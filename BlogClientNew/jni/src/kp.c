#include "AndroidKp.h"
#include "kp.h"
#include "SmartRoomOntology.h"
#include <android/log.h>


/**
 * @fn  JNIEXPORT jint JNICALL Java_petrsu_smartroom_android_srclient_KP_connectSmartSpace(JNIEnv *env, jobject obj, jstring hostname, jstring ip, jint port)
 *
 * @brief Function connect client to Smart Space
 *
 * @param env - pointer to JNI environment
 * @param obj - Java object
 * @param hostname - name of Smart Space
 * @param ip - ip address
 * @param port - SIB port
 *
 * @return Returns 0 in success and -1 if failed
 */
JNIEXPORT jint JNICALL Java_petrsu_smartroom_android_blogclient_KP_connectSmartSpace
  (JNIEnv *env, jobject obj, jstring hostname, jstring ip, jint port) {

	const char *hostname_ = (*env) -> GetStringUTFChars(env, hostname, NULL);
		const char *ip_ = (*env) -> GetStringUTFChars(env, ip, NULL);

		if(sslog_ss_init_session_with_parameters(hostname_, ip_, (int)port) != 0)
			return -1;

		register_ontology();

		if (ss_join(sslog_get_ss_info(), generateUuid("BlogClientKP")) == -1) {
			__android_log_print(ANDROID_LOG_ERROR, "connectionSmartSpace():", "Connection error**********");
			//__android_log_print(ANDROID_LOG_ERROR, "connectionSmartSpace():", get_error_text());
			return -1;
		}

	return 0;
}


/**
 * @fn  Java_petrsu_smartroom_android_srclient_KP_disconnectSmartSpace(JNIEnv *env, jobject obj)
 *
 * @brief Function disconnect client from Smart Space
 *
 * @param env - pointer to JNI environment
 * @param obj - Java object
 */
JNIEXPORT void JNICALL Java_petrsu_smartroom_android_blogclient_KP_disconnectSmartSpace
  (JNIEnv *env, jobject obj) {

	sslog_sbcr_stop_all();
	//logout();
	sslog_sbcr_unsubscribe_all(true);
	sslog_ss_leave_session(sslog_get_ss_info());
	sslog_repo_clean_all();
}


/**
 * @brief Logging out user from Smart Space
 */
void logout() {
	prop_val_t *person_prop = sslog_ss_get_property(personProfile, PROPERTY_PERSONINFORMATION);
	individual_t *person;

	char *online_status = "online";
	char *offline_status = "offline";

	if(person_prop == NULL)
		return;

	person = (individual_t *)person_prop->prop_value;

	if(person == NULL)
		return;

	sslog_ss_update_property(person, PROPERTY_STATUS->name, (void *)online_status,
			(void *)offline_status);

	/*individual_t *agendaGui = sslog_new_individual(CLASS_AGENDAGUINOTIFICATION);

	sslog_set_individual_uuid(agendaGui,
			generateUuid("http://www.cs.karelia.ru/smartroom#Notification"));

	if(sslog_ss_add_property(agendaGui, PROPERTY_UPDATEAGENDA, firstTimeslot) != 0 )
		return;

	if(sslog_ss_insert_individual(agendaGui) != 0)
		return;*/
}


/**
 * @fn  Java_petrsu_smartroom_android_srclient_KP_userRegistration(JNIEnv *env, jobject obj, jstring userName, jstring password)
 *
 * @brief Register client in Smart Space
 *
 * Function takes `userName` and `password` and compares them
 * with corresponding individual's properties
 *
 * @param env - pointer to JNI environment
 * @param obj - Java object
 * @param userName - registered user name
 * @param password - user password
 *
 * @return Returns 0 in success, 1 if username exists and -1 if failed
 */
JNIEXPORT jint JNICALL Java_petrsu_smartroom_android_blogclient_KP_userRegistration
  (JNIEnv *env, jobject obj, jstring userName, jstring password) {

	list_t* profileList = sslog_ss_get_individual_by_class_all(CLASS_PROFILE);
	individual_t *profile = NULL;
	int personFounded = -1;
	const char *chairman = "chairman";

	if(profileList != NULL) {

		list_head_t* pos = NULL;
		list_for_each(pos, &profileList->links) {
			list_t* node = list_entry(pos, list_t, links);
			profile = (individual_t*)(node->data);
			sslog_ss_populate_individual(profile);

			if(profile != NULL)
				personFounded = searchPerson(profile,
						(*env)->GetStringUTFChars(env, userName, NULL),
						(*env)->GetStringUTFChars(env, password, NULL));
			else
				return -1;

			if(personFounded == 0)
					return 0;
		}
	}

	if((strcmp(chairman, (*env)->GetStringUTFChars(env, userName, NULL)) == 0) &&
			(strcmp(chairman, (*env)->GetStringUTFChars(env, password, NULL))) == 0) {

		individual_t *person = createPerson("chairman", "", "");

		if(person != NULL) {
			if(createProfile(person) == NULL)
				return -1;
		} else
			return -1;

		return 0;
	}

	return -1;
}


/**
 * @brief Creates new profile in Smart Space
 * @param userName
 * @param password
 * @return 0 in success and -1 otherwise
 */
JNIEXPORT jint JNICALL Java_petrsu_smartroom_android_blogclient_KP_registerGuest
  (JNIEnv *env, jclass clazz, jstring name, jstring phone, jstring email) {

	const char *p_name = (*env)->GetStringUTFChars(env, name, NULL);
	const char *p_phone = (*env)->GetStringUTFChars(env, phone, NULL);
	const char *p_email = (*env)->GetStringUTFChars(env, email, NULL);

	if(personExists(p_name))
		return 1;

	individual_t *person = createPerson(p_name, p_phone, p_email);

	if(person != NULL) {
		if(createProfile(person) == NULL)
			return -1;
	} else
		return -1;

	return 0;
}

individual_t* createProfile(individual_t *person) {

	individual_t *profile = sslog_new_individual(CLASS_PROFILE);
	char *username = "";
	char *password = "";

	sslog_set_individual_uuid(profile, generateUuid("http://www.cs.karelia.ru/smartroom#Profile"));

	if(sslog_ss_add_property(profile, PROPERTY_USERNAME, (void *)username) == -1)
		return NULL;

	if(sslog_ss_add_property(profile, PROPERTY_PASSWORD, (void *)password) == -1)
		return NULL;

	if(sslog_ss_add_property(profile, PROPERTY_PERSONINFORMATION, person) == -1)
			return NULL;

	if(sslog_ss_insert_individual(profile) == -1)
		return NULL;

	personProfile = profile;

	return profile;
}

/**
 * @brief Creates empty individual for person data
 * @return pointer to individual, NULL otherwise
 */
individual_t* createPerson(const char *name, const char *phone, const char *email) {

	individual_t *person = sslog_new_individual(CLASS_PERSON);

	if(person == NULL)
		return NULL;

	sslog_set_individual_uuid(person, generateUuid("http://xmlns.com/foaf/0.1/#Person"));

	if(sslog_ss_add_property(person, PROPERTY_NAME, (void *)name) == -1)
		return NULL;

	if(sslog_ss_add_property(person, PROPERTY_PHONE, (void *)phone) == -1)
		return NULL;

	if(sslog_ss_add_property(person, PROPERTY_MBOX, (void *)email) == -1)
		return NULL;

	return person;
}

/**
 * @brief Checks an existence of username in Smart Space
 *
 * @param username
 * @return 0 if exists and -1 otherwise
 */
bool personExists(const char *name) {
	list_t* personList = sslog_ss_get_individual_by_class_all(CLASS_PERSON);

	if(personList != NULL) {
		list_head_t* pos = NULL;
		list_for_each(pos, &personList->links) {
			list_t* node = list_entry(pos, list_t, links);
			individual_t* person = (individual_t*)(node->data);

			prop_val_t *p_name = sslog_ss_get_property(person, PROPERTY_NAME);

			if(p_name != NULL)
				if(strcmp(name, (char *)p_name->prop_value) == 0)
					return JNI_TRUE;
		}
	}

	return JNI_FALSE;
}


/**
 * @fn  searchPerson(individual_t *person, char *userName, char *password)
 *
 * @brief Searches person in Smart Space
 *
 * @param person - pointer to person individual
 * @param userName - registered user name
 * @param password - user password
 *
 * @return Returns 0 in success and -1 if failed
 */
int searchPerson(individual_t *profile, const char *userName, const char *password) {

	prop_val_t *p_val_username = sslog_ss_get_property (profile, PROPERTY_USERNAME);

	if(p_val_username == NULL)
		return -1;

	prop_val_t *p_val_password = sslog_ss_get_property (profile, PROPERTY_PASSWORD);

	if(p_val_password == NULL)
		return -1;

	if((strcmp(userName, (char *)p_val_username->prop_value) == 0) &&
			(strcmp(password, (char *)p_val_password->prop_value) == 0)) {
		personProfile = profile;

		return 0;
	}

	return -1;
}


/***********************
 *
 * Generates unique uuid
 *
 ***********************/
char* generateUuid(char *uuid) {

	int rand_val = 0, rand_length = 1, i = 0, postfix_length = 6;
	char *result = (char*) malloc (sizeof(char) * strlen(uuid) + postfix_length + 2);

	for(; i < postfix_length; rand_length *= 10, i++);

	do {
		srand(time(NULL));
		rand_val = rand() % rand_length;
		sprintf(result, "%s-%d", uuid, rand_val);
	} while(sslog_ss_exists_uuid(result) == 1);

	return result;
}


/*************************************************
 *
 * Returns jclass object of Java class `className`
 *
 *************************************************/
jclass getJClassObject(JNIEnv *env, char *className) {

	char *classPath = (char *) malloc (sizeof(char) *
			strlen("petrsu/smartroom/android/srclient/") + strlen(className));

	strcpy(classPath, "petrsu/smartroom/android/srclient/");
	strcat(classPath, className);

	jclass class = (*env)->FindClass(env, classPath);

	if(class == NULL) {
		char *error = (char *) malloc (sizeof(char) * 30);
		strcpy(error, "Can't find ");
		strcat(error, className);
		strcat(error, " class");

		return NULL;
	}

	free(classPath);

	return class;
}/* Returns jclass object of Java class `className` */


/**************************************
 *
 * Returns ID of Java field `fieldName`
 *
 **************************************/
jfieldID getFieldID(JNIEnv *env, jclass class, char *fieldName, char *signature) {

	jfieldID fieldID = (*env)->GetFieldID(env, class, fieldName, signature);
	char *err_msg = (char *) malloc (sizeof(char) * ERROR_MSG_LENGTH);

	strcpy(err_msg, "Can't get ");
	strcat(err_msg, fieldName);
	strcat(err_msg, " ID");

	if(fieldID == NULL)
		return NULL;

	free(err_msg);

	return fieldID;
}


/********************************************************
 *
 * Loads presentation with `uuid` or current presentation
 *
 ********************************************************/
JNIEXPORT jint JNICALL Java_petrsu_smartroom_android_srclient_KP_loadPresentation
  (JNIEnv *env, jobject obj, jobject presentationClassObj) {

	prop_val_t *p_val_slideNum = NULL;
	prop_val_t *p_val_slideCount = NULL;
	prop_val_t *p_val_slideImg = NULL;
	individual_t *presentationService = NULL;

	if(presentationClassObj == NULL)
		return -1;

	presentationClassObject = (jobject *)(*env)->NewGlobalRef(env, presentationClassObj);

	__android_log_print(ANDROID_LOG_ERROR, "loadPresentation()", "start");

	jmethodID setSlideNumId = (*env)->GetMethodID(env, classProjector,
			"setSlideNumber", "(Ljava/lang/String;)V");
	jmethodID setSlideCountId = (*env)->GetMethodID(env, classProjector,
			"setSlideCount", "(Ljava/lang/String;)V");
	jmethodID setSlideImageId = (*env)->GetMethodID(env, classProjector,
			"setSlideImage", "(Ljava/lang/String;)V");

	list_t* presentationServiceList = sslog_ss_get_individual_by_class_all(
				CLASS_PRESENTATIONSERVICE);

	if(presentationServiceList != NULL) {
		list_head_t* pos = NULL;
		list_for_each(pos, &presentationServiceList->links) {
			list_t* node = list_entry(pos, list_t, links);
			presentationService = (individual_t*)(node->data);
			sslog_ss_populate_individual(presentationService);
			break;
		}

		// Set current slide img value
		p_val_slideImg = sslog_ss_get_property (presentationService,
				PROPERTY_CURRENTSLIDEIMG);
		if(p_val_slideImg != NULL)
			(*env)->CallVoidMethod(env, presentationClassObject, setSlideImageId,
					(*env)->NewStringUTF(env, (char *)p_val_slideImg->prop_value));

		// Set current slide number value
		p_val_slideNum = sslog_ss_get_property (presentationService,
				PROPERTY_CURRENTSLIDENUM);
		if(p_val_slideNum != NULL)
			(*env)->CallVoidMethod(env, presentationClassObject, setSlideNumId,
					(*env)->NewStringUTF(env, (char *)p_val_slideNum->prop_value));

		// Set current slide count value
		p_val_slideCount = sslog_ss_get_property (presentationService,
				PROPERTY_CURRENTSLIDECOUNT);
		if(p_val_slideCount != NULL)
			(*env)->CallVoidMethod(env, presentationClassObject, setSlideCountId,
					(*env)->NewStringUTF(env, (char *)p_val_slideCount->prop_value));
	}

	__android_log_print(ANDROID_LOG_ERROR, "loadPresentation()", "DONE");

	return 0;
}



/**
 * @brief Handles changes happened with `CLASS_PRESENTATIONNOTIFICATION`
 *
 * @param sbcr
 */
void presentationNotificationHandler(subscription_t *sbcr) {

	/* Gets jni environment pointer (env) */
	JNIEnv *env;
	bool attached = false;

	switch((*JVM)->GetEnv(JVM, (void **)&env, JNI_VERSION_1_6)) {

		case JNI_OK:
			break;

		case JNI_EDETACHED:
			(*JVM)->AttachCurrentThread(JVM, &env, NULL);
			attached = true;
			break;

		case JNI_EVERSION:
			__android_log_print(ANDROID_LOG_ERROR, "presentationHandler:",
					"invalid jni version");
			break;
	}

	jmethodID setSlideNumId = (*env)->GetMethodID(env, classProjector,
			"setSlideNumber", "(Ljava/lang/String;)V");
	jmethodID setSlideCountId = (*env)->GetMethodID(env, classProjector,
			"setSlideCount", "(Ljava/lang/String;)V");
	jmethodID setSlideImageId = (*env)->GetMethodID(env, classProjector,
			"setSlideImage", "(Ljava/lang/String;)V");
	jmethodID updateProjector = (*env)->GetMethodID(env, classProjector, "updateProjector", "()I");

	jfieldID presentationCreated = (*env)->GetStaticFieldID(env, classProjector,
			"presentationCreated", "I");

	int presentationIsCreated = (*env)->GetStaticIntField(env,
			classProjector, presentationCreated);

	subscription_changes_data_t *changes = sslog_sbcr_get_changes_last(sbcr);
		list_t *list = sslog_sbcr_ch_get_individual_all(changes);

	if(presentationIsCreated != 1) {
		if(attached)
			(*JVM)->DetachCurrentThread(JVM);

		return;
	}

	// Handling last changes of subscribed data
	if(list != NULL) {
		list_head_t *list_walker = NULL;

		list_for_each(list_walker, &list->links) {
			list_t *node = list_entry(list_walker, list_t, links);
			char *uuid = (char *) node->data;

			individual_t *individual = (individual_t *)
					sslog_repo_get_individual_by_uuid(uuid);

			// Current slide number property
			prop_val_t *p_val_slidenum = sslog_ss_get_property (individual,
						PROPERTY_CURRENTSLIDENUM);
			if(p_val_slidenum != NULL) {
				(*env)->CallVoidMethod(env, presentationClassObject, setSlideNumId,
						(*env)->NewStringUTF(env, (char *)p_val_slidenum->prop_value));
			}

			// Current slide count property
			prop_val_t *p_val_slidecount = sslog_ss_get_property (individual,
						PROPERTY_CURRENTSLIDECOUNT);
			if(p_val_slidecount != NULL) {
				(*env)->CallVoidMethod(env, presentationClassObject, setSlideCountId,
						(*env)->NewStringUTF(env, (char *)p_val_slidecount->prop_value));
			}

			// Current slide image property
			prop_val_t *p_val_slideimg = sslog_ss_get_property (individual,
						PROPERTY_CURRENTSLIDEIMG);
			if(p_val_slideimg != NULL) {
				(*env)->CallVoidMethod(env, presentationClassObject, setSlideImageId,
						(*env)->NewStringUTF(env, (char *)p_val_slideimg->prop_value));
			}
		}
	}

	(*env)->CallIntMethod(env, presentationClassObject, updateProjector);

	list_free_with_nodes(list, NULL);

	if(attached)
		(*JVM)->DetachCurrentThread(JVM);
}

/**
 * @brief Saves all profile changes to Smart Space
 */
JNIEXPORT jint JNICALL Java_petrsu_smartroom_android_srclient_KP_saveProfileChanges
  (JNIEnv *env, jclass clazz, jstring name, jstring phone) {

	prop_val_t *person_prop = sslog_ss_get_property(personProfile, PROPERTY_PERSONINFORMATION);
	individual_t *person;

	const char *new_name = (*env)->GetStringUTFChars(env, name, NULL);
	const char *new_phone = (*env)->GetStringUTFChars(env, phone, NULL);

	if(person_prop == NULL)
		return -1;

	person = (individual_t *)person_prop->prop_value;
	if(person == NULL)
		return -1;

	prop_val_t *person_name = sslog_ss_get_property(person, PROPERTY_NAME);
	char *p_name;
	if(person_name != NULL)
		p_name = (char *)person_name->prop_value;

	prop_val_t *person_phone = sslog_ss_get_property(person, PROPERTY_PHONE);
	char *p_phone;
	if(person_phone != NULL)
		p_phone = (char *)person_phone->prop_value;

	sslog_ss_update_property(person, PROPERTY_PHONE->name, (void *)p_phone,
					(void *)new_phone);

	sslog_ss_update_property(person, PROPERTY_NAME->name, (void *)p_name,
				(void *)new_name);

	return 0;
}


/**
 * @brief Returns person's uuid
 */
JNIEXPORT jstring JNICALL Java_petrsu_smartroom_android_srclient_KP_getPersonUuid
  (JNIEnv *env, jclass clazz) {

	prop_val_t *person_prop = sslog_ss_get_property(personProfile, PROPERTY_PERSONINFORMATION);
	individual_t *person;

	if(person_prop == NULL)
		return "";

	person = (individual_t *)person_prop->prop_value;

	if(person == NULL)
		return "";

	return (*env)->NewStringUTF(env, (char *)person->uuid);
}


/**
* @fn Java_petrsu_smartroom_android_srclient_KP_getLog()
*
* @brief Извлекает из SS общий логин на внешнем блог-сервисе.
*
* @param env - pointer to JNI environment
* @param obj - Blog class object
*
* @return общий логин
*/
JNIEXPORT jstring JNICALL Java_petrsu_smartroom_android_blogclient_KP_getLog(JNIEnv *env, jobject *obj)
{
	list_t *list = sslog_ss_get_individual_by_class_all(CLASS_BLOG);
	individual_t *individual;

	if(list != NULL) {
		list_head_t* pos = NULL;
		list_for_each(pos, &list->links) {
			list_t* node = list_entry(pos, list_t, links);
			individual = (individual_t*)(node->data);
			sslog_ss_populate_individual(individual);
		}
	} else
		return NULL;

	prop_val_t *login_value = sslog_ss_get_property(individual, PROPERTY_SRLOGIN);

	if(login_value == NULL)
		return NULL;

	return (*env)->NewStringUTF(env, (char *)login_value->prop_value);
}

/**
* @fn Java_petrsu_smartroom_android_srclient_KP_getPass()
*
* @brief Извлекает из SS общий пароль на внешнем блог-сервисе.
*
* @param env - pointer to JNI environment
* @param obj - Blog class object
*
* @return общий пароль
*/
JNIEXPORT jstring JNICALL Java_petrsu_smartroom_android_blogclient_KP_getPass(JNIEnv *env, jobject *obj)
{
	list_t *list = sslog_ss_get_individual_by_class_all(CLASS_BLOG);
	individual_t *individual;

	if(list != NULL) {
		list_head_t* pos = NULL;
		list_for_each(pos, &list->links) {
			list_t* node = list_entry(pos, list_t, links);
			individual = (individual_t*)(node->data);
			sslog_ss_populate_individual(individual);
		}
	} else
		return NULL;

	prop_val_t *password_value = sslog_ss_get_property(individual, PROPERTY_SRPASSWORD);

	if(password_value == NULL)
		return NULL;

	return (*env)->NewStringUTF(env, (char *)password_value->prop_value);


}

JNIEXPORT jint JNICALL Java_petrsu_smartroom_android_blogclient_KP_getThemes
  (JNIEnv *env, jclass clazz, jobject obj) {

	if(obj != NULL)
		classBlogListActivity = (*env)->GetObjectClass(env, obj);
	else
		return -1;

	list_t *themelist = sslog_ss_get_individual_by_class_all(CLASS_THEME);
		individual_t *individual;

		if(themelist != NULL) {
			list_head_t* pos = NULL;
			list_for_each(pos, &themelist->links) {
				list_t* node = list_entry(pos, list_t, links);
				individual = (individual_t*)(node->data);
				sslog_ss_populate_individual(individual);
				if (addThemeToJavaList(env, individual, obj) != 0 )
								return -1;
			}
		}

		return 0;
}

int addThemeToJavaList(JNIEnv *env, individual_t *theme, jobject obj) {

	//printf("addTimeslotToJavaList\n");

	jmethodID methodId = (*env)->GetMethodID(env, classBlogListActivity, "addThemeItemToList",
			"(Ljava/lang/String;Ljava/lang/String;)V");

	prop_val_t *id_value = sslog_ss_get_property(theme, PROPERTY_THEMEID);
	prop_val_t *status_value = sslog_ss_get_property(theme, PROPERTY_THEMESTATUS);

	if((id_value == NULL) || (status_value == NULL))
		return -1;

	char *id_value_ = (char*) id_value->prop_value;
	char *status_value_ = (char*) status_value->prop_value;

	if(obj != NULL) {
		(*env)->CallVoidMethod(env, obj, methodId,
				(*env)->NewStringUTF(env, id_value_),
				(*env)->NewStringUTF(env, status_value_));
		return 0;
	}
	else
		return -1;
}

