#include "AndroidKp.h"
#include "kp.h"
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
	char *uuid = generateUuid("KP");

	if(sslog_ss_init_session_with_parameters(hostname_, ip_, (int)port) != 0)
		return -1;

	register_ontology();

	if (ss_join(sslog_get_ss_info(), uuid) == -1) {
		__android_log_print(ANDROID_LOG_ERROR, "connectionSmartSpace():", "Connection error");
		return -1;
	}

	if((*env)->GetJavaVM(env, &JVM) != 0)
		__android_log_print(ANDROID_LOG_ERROR, "class KP", "Get java VM failed");

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
				if(activatePerson(profile) != 0)
					return -1;
				else
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
 * @brief Counts person position in timeslot
 *
 */
JNIEXPORT jint JNICALL Java_petrsu_smartroom_android_srclient_KP_personTimeslotIndex
  (JNIEnv *env, jobject obj) {

	int index = 0;

	individual_t *timeslot = firstTimeslot;

	prop_val_t *person = sslog_ss_get_property(personProfile, PROPERTY_PERSONINFORMATION);
	individual_t *personInfo = (individual_t *) person->prop_value;


	while(timeslot != NULL) {

		prop_val_t *timeslotData = sslog_ss_get_property(timeslot, PROPERTY_PERSONLINK);

		// If person is not active
		if(timeslotData == NULL) {
			index += 1;
			prop_val_t *nextTimeslot = sslog_ss_get_property(timeslot, PROPERTY_NEXTTIMESLOT);

			if(nextTimeslot != NULL)
				timeslot = (individual_t *) nextTimeslot->prop_value;

			else
				return -1;

			continue;
		}

		individual_t *personTimeslot = (individual_t *) timeslotData->prop_value;

		if(strcmp(personInfo->uuid, personTimeslot->uuid) == 0) {
			return index;

		} else
			index += 1;

		prop_val_t *nextTimeslot = sslog_ss_get_property(timeslot, PROPERTY_NEXTTIMESLOT);

		if(nextTimeslot == NULL)
			break;

		timeslot = (individual_t *) nextTimeslot->prop_value;
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


/**
 * @fn activatePerson(individual_t *profile)
 *
 * @brief Send `newParticipantCome` notification
 *
 * If searchPerson() function ended successful then this function
 * sends notification to AgendaNotification class
 *
 * @param profile - pointer to profile individual
 *
 * @return Returns 0 in success and -1 if failed
 */
int activatePerson(individual_t *profile) {

	char *online_status = "online";
	char *offline_status = "offline";

	prop_val_t *person_prop = sslog_ss_get_property(profile, PROPERTY_PERSONINFORMATION);

	individual_t *person;

	if(person_prop == NULL)
		return -1;

	person = (individual_t *)person_prop->prop_value;

	sslog_ss_populate_individual(person);

	if(person == NULL)
		return -1;

	// if property does not exists
	if(sslog_ss_get_property(person, PROPERTY_STATUS) == NULL) {

		if(sslog_ss_add_property(person, PROPERTY_STATUS, (void *)online_status) != 0) {
			__android_log_print(ANDROID_LOG_ERROR, "class KP", "%s", get_error_text());
			return -1;
		}

	} else {
		sslog_ss_update_property(person, PROPERTY_STATUS->name, (void *)offline_status,
				(void *)online_status);
	}

	individual_t *agendaGui = sslog_new_individual(CLASS_AGENDANOTIFICATION);

	sslog_set_individual_uuid(agendaGui,
			generateUuid("http://www.cs.karelia.ru/smartroom#Notification"));

	if(sslog_ss_add_property(agendaGui, PROPERTY_NEWPARTICIPANTCOME, profile) != 0 ) {
		__android_log_print(ANDROID_LOG_ERROR, "class KP", "%s", get_error_text());
		return -1;
	}

	if(sslog_ss_insert_individual(agendaGui) != 0) {
		__android_log_print(ANDROID_LOG_ERROR, "class KP", "insert failed");
		return -1;
	}

	return 0;
}


/**
 * @fn Java_petrsu_smartroom_android_srclient_KP_loadTimeslotList(JNIEnv *env, jclass clazz, jobject obj)
 *
 * @brief Gets TimeSlot individuals from Smart Space
 *
 * Gets the list of TimeSlot class individuals from Smart Space
 * processes it and fills Agenda.
 *
 * @param env - pointer to JNI environment
 * @param clazz - class keeping loadTimeSlot() function
 * @param obj - Agenda class object
 *
 * @return Returns 0 in success and -1 if failed
 */
JNIEXPORT jint JNICALL Java_petrsu_smartroom_android_srclient_KP_loadTimeslotList
  (JNIEnv *env, jclass clazz, jobject obj) {

	// TODO:
	// when there will be more than one section, it's enough only to
	// initialize chosen `section`
	int counter = 0, attempts = 3;

	if(obj != NULL)
		agendaClassObject = (jobject *)(*env)->NewGlobalRef(env, obj);
	else
		return -1;

	prop_val_t *propTimeslot = sslog_ss_get_property(section, PROPERTY_FIRSTTIMESLOT);

	for(; counter < attempts; counter++) {
		if(propTimeslot == NULL)
			propTimeslot = sslog_ss_get_property(section, PROPERTY_FIRSTTIMESLOT);
		else
			break;
	}

	while(propTimeslot != NULL) {
		individual_t *pTimeslot = (individual_t *) propTimeslot->prop_value;

		addTimeslotToJavaList(env, pTimeslot, obj);

		propTimeslot = sslog_ss_get_property(pTimeslot, PROPERTY_NEXTTIMESLOT);
	}

	return 0;
}


/**
 * @fn addTimeslotToJavaList(JNIEnv *env, individual_t *timeslot, jobject obj)
 *
 * @brief Fills Agenda by timeslot's properties values
 *
 * Extracts timeslot's properties and stores them into
 * Agenda timeslot list.
 *
 * @param env - pointer to JNI environment
 * @param timeslot - timeslot individual
 * @param obj - Agenda class object
 *
 * @return Returns 0 in success and -1 if failed
 */
void addTimeslotToJavaList(JNIEnv *env, individual_t *timeslot, jobject obj) {

	jmethodID methodId = (*env)->GetMethodID(env, classAgenda, "addTimeslotItemToList",
			"(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V");

	int counter = 0, attempts = 3;
	prop_val_t *p_val_name = sslog_ss_get_property (timeslot, PROPERTY_SPEAKERNAME);
	prop_val_t *p_val_pres_title = sslog_ss_get_property (timeslot, PROPERTY_PRESENTATIONTITLE);

	for(; counter < attempts; counter++) {

		if(p_val_name == NULL)
			p_val_name = sslog_ss_get_property (timeslot, PROPERTY_SPEAKERNAME);

		if(p_val_pres_title == NULL)
			p_val_pres_title = sslog_ss_get_property (timeslot, PROPERTY_PRESENTATIONTITLE);

		if((p_val_name != NULL)	&& (p_val_pres_title != NULL))
			break;
	}


	/* Gets person link property */
	char *imgLink = (char *) malloc (sizeof(char) * 200);

	strcpy(imgLink, "absentImage");

	prop_val_t *p_val_person_link = sslog_ss_get_property (timeslot, PROPERTY_PERSONLINK);
	if(p_val_person_link != NULL) {

		char *status = "";
		individual_t *person = (individual_t *)p_val_person_link->prop_value;

		prop_val_t *p_val_status = sslog_ss_get_property (person, PROPERTY_STATUS);
		if(p_val_status != NULL)
			status = (char *) p_val_status->prop_value;

		prop_val_t *p_val_img = sslog_ss_get_property (person, PROPERTY_IMG);

		if(p_val_img != NULL) {
			strcpy(imgLink, (char *)p_val_img->prop_value);
		} else if(strcmp(status, "online"))
			strcpy(imgLink, "noImage");
	}

	/* Calling Agenda's addTimeslotItemToList Java method */
	if(obj != NULL)
		(*env)->CallVoidMethod(env, obj, methodId,
				(*env)->NewStringUTF(env, (char *)(p_val_name->prop_value)),
				(*env)->NewStringUTF(env, (char *)(p_val_pres_title->prop_value)),
				(*env)->NewStringUTF(env, imgLink));

	free(imgLink);
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


/**********************************
 *
 *  Gets list of available services
 *
 **********************************/
JNIEXPORT jint JNICALL Java_petrsu_smartroom_android_srclient_KP_getServicesInfo
  (JNIEnv *env, jclass clazz, jobject menu) {

	jclass class = getJClassObject(env, "ServicesMenu");
	jfieldID agendaStateField = getFieldID(env, class, "agendaServiceState", "I");
	jfieldID presentationStateField = getFieldID(env, class, "presentationServiceState", "I");

	individual_t *agenda = (individual_t *)
			sslog_ss_get_individual_by_class_all(CLASS_AGENDA);

	if(agenda == NULL) {
		__android_log_print(ANDROID_LOG_ERROR, "class KP", "Agenda service not found");
		(*env)->SetIntField(env, menu, agendaStateField, 0);
	} else
		(*env)->SetIntField(env, menu, agendaStateField, 1);


	individual_t *presentation = (individual_t *)
			sslog_ss_get_individual_by_class_all(CLASS_PRESENTATIONSERVICE);

	if(presentation == NULL) {
		__android_log_print(ANDROID_LOG_ERROR, "class KP", "Projector service not found");
		(*env)->SetIntField(env, menu, presentationStateField, 0);
	} else
		(*env)->SetIntField(env, menu, presentationStateField, 1);

	return 0;

}/* Gets list of available services */


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

/**
 * @brief Handles agenda changes
 */
void agendaNotificationHandler(subscription_t *sbcr) {

	/* Gets jni environment pointer (env) */
	JNIEnv *env = NULL;
	bool attached = JNI_FALSE;

	switch((*JVM)->GetEnv(JVM, (void **)&env, JNI_VERSION_1_6)) {

		case JNI_OK:
			break;

		case JNI_EDETACHED:
			(*JVM)->AttachCurrentThread(JVM, &env, NULL);
			attached = JNI_TRUE;
			break;

		case JNI_EVERSION:
			__android_log_print(ANDROID_LOG_ERROR, "agendaHandler:",
					"invalid jni version");
			break;
	}

	jmethodID updateAgenda = (*env)->GetMethodID(env, classAgenda, "updateAgenda", "()V");
	jmethodID setCurTimeslot = (*env)->GetMethodID(env, classAgenda, "setCurrentTimeslot", "(I)V");

	jfieldID agendaCreated = (*env)->GetStaticFieldID(env, classAgenda,
			"agendaCreated", "I");
	int agendaIsCreated = (*env)->GetStaticIntField(env, classAgenda, agendaCreated);

	subscription_changes_data_t *changes = sslog_sbcr_get_changes_last(sbcr);
	list_t *list = sslog_sbcr_ch_get_individual_all(changes);

	if(agendaIsCreated != 1) {
		if(attached)
			(*JVM)->DetachCurrentThread(JVM);

		return;
	}

	if(list != NULL) {
		list_head_t *list_walker = NULL;

		list_for_each(list_walker, &list->links) {
			list_t *node = list_entry(list_walker, list_t, links);
			char *uuid = (char *) node->data;

			individual_t *individual = (individual_t *)
					sslog_repo_get_individual_by_uuid(uuid);

			prop_val_t *p_val_update = sslog_ss_get_property (individual,
						PROPERTY_UPDATEAGENDA);
			if(p_val_update != NULL) {
				if(agendaIsCreated == 1)
					(*env)->CallVoidMethod(env, agendaClassObject, updateAgenda);
			}

			prop_val_t *p_val_timeslot = sslog_ss_get_property (individual,
									PROPERTY_CURRENTTIMESLOT);
			if(p_val_timeslot != NULL) {

				calculateTimeslotIndex(p_val_timeslot);

				if(agendaIsCreated == 1)
					(*env)->CallVoidMethod(env, agendaClassObject, updateAgenda);
				else
					break;
			}
		}
	}

	list_free_with_nodes(list, NULL);

	if(attached)
		(*JVM)->DetachCurrentThread(JVM);
}


JNIEXPORT jint JNICALL Java_petrsu_smartroom_android_srclient_KP_getCurrentTimeslotIndex
  (JNIEnv *env, jclass clazz) {
	return calculateTimeslotIndex(NULL);
}

/**
 * @brief Calculates an index number of current timeslot
 */
int calculateTimeslotIndex(prop_val_t *propTimeslot) {

	individual_t *curTimeslot;
	individual_t *timeslot = firstTimeslot;
	currentTimeslotIndex = 1;

	if(propTimeslot != NULL)
		curTimeslot = (individual_t *) propTimeslot->prop_value;

	else {
		propTimeslot = sslog_ss_get_property (section,
				PROPERTY_CURRENTTIMESLOT);

		if(propTimeslot != NULL)
			curTimeslot = (individual_t *) propTimeslot->prop_value;
		else
			return -1;
	}

	// Get index of current timeslot
	while(strcmp(curTimeslot->uuid, timeslot->uuid) != 0) {
		prop_val_t *val = sslog_ss_get_property(timeslot, PROPERTY_NEXTTIMESLOT);

		if(val != NULL) {
			timeslot = (individual_t *) val->prop_value;
			++currentTimeslotIndex;
		} else return -1;
	}

	return currentTimeslotIndex;
}

/**
 * @brief Function checks the fact that current
 * participant is a speaker.
 *
 * @return True if participant is a speaker and
 * false otherwise
 */
JNIEXPORT jboolean JNICALL Java_petrsu_smartroom_android_srclient_KP_checkSpeakerState
  (JNIEnv *env, jclass clazz) {

	individual_t *timeslot;
	prop_val_t *curValue = sslog_ss_get_property(section, PROPERTY_CURRENTTIMESLOT);

	if(curValue == NULL)
		return JNI_FALSE;

	timeslot = (individual_t *) curValue->prop_value;

	prop_val_t *personValue = sslog_ss_get_property(timeslot, PROPERTY_PERSONLINK);

	if(personValue == NULL)
		return JNI_FALSE;

	individual_t *curPerson = (individual_t *) personValue->prop_value;

	prop_val_t *person = sslog_ss_get_property(personProfile, PROPERTY_PERSONINFORMATION);

	if(person == NULL)
			return JNI_FALSE;

	individual_t *personInfo = (individual_t *) person->prop_value;

	if(strcmp(personInfo->uuid, curPerson->uuid) == 0)
		return JNI_TRUE;
	else
		return JNI_FALSE;
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

JNIEXPORT jstring JNICALL Java_petrsu_smartroom_android_srclient_KP_getMicServiceIP
  (JNIEnv *env, jclass clazz) {

	list_t *list = sslog_ss_get_individual_by_class_all(CLASS_MICROPHONESERVICE);
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

	prop_val_t *ip_value = sslog_ss_get_property(individual, PROPERTY_IP);

	if(ip_value == NULL)
		return NULL;

	return (*env)->NewStringUTF(env, (char *)ip_value->prop_value);
}

JNIEXPORT jstring JNICALL Java_petrsu_smartroom_android_srclient_KP_getMicServicePort
  (JNIEnv *env, jclass clazz) {

	list_t *list = sslog_ss_get_individual_by_class_all(CLASS_MICROPHONESERVICE);
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

	prop_val_t *port_value = sslog_ss_get_property(individual, PROPERTY_PORT);

	if(port_value == NULL)
		return NULL;

	return (*env)->NewStringUTF(env, (char *)port_value->prop_value);
}

/**
 * @brief Returns current speaker name
 */
JNIEXPORT jstring JNICALL Java_petrsu_smartroom_android_srclient_KP_getSpeakerName
  (JNIEnv *env, jclass clazz) {

	list_t *sectionList = sslog_ss_get_individual_by_class_all(CLASS_SECTION);
	individual_t *section1 = NULL;

	if(sectionList != NULL) {
		list_head_t* pos = NULL;
		list_for_each(pos, &sectionList->links) {
			list_t* node = list_entry(pos, list_t, links);
			section1 = (individual_t *)(node->data);
			sslog_ss_populate_individual(section);
			break;
		}
	}

	prop_val_t *curTimeslotProp = sslog_ss_get_property(section1, PROPERTY_CURRENTTIMESLOT);

	if(curTimeslotProp == NULL)
		return "";

	individual_t *curTimeslot = (individual_t *)curTimeslotProp->prop_value;

	prop_val_t *personLinkProp = sslog_ss_get_property(curTimeslot, PROPERTY_PERSONLINK);

	if(personLinkProp == NULL)
		return "";

	individual_t *person = (individual_t *)personLinkProp->prop_value;
	prop_val_t *personName = sslog_ss_get_property(person, PROPERTY_NAME);

	if(personName != NULL)
		return (*env)->NewStringUTF(env, (char *)personName->prop_value);

	else
		return "";
}


JNIEXPORT jboolean JNICALL Java_petrsu_smartroom_android_srclient_KP_checkConnection
  (JNIEnv *env, jobject obj) {

	list_t *agendaList = sslog_ss_get_individual_by_class_all(CLASS_AGENDA);
	list_t *presentationList = sslog_ss_get_individual_by_class_all(CLASS_PRESENTATIONSERVICE);

	if(agendaList != NULL || presentationList != NULL)
		return JNI_TRUE;
	else
		return JNI_FALSE;
}


JNIEXPORT jstring JNICALL Java_petrsu_smartroom_android_srclient_KP_getPresentationLink
  (JNIEnv *env, jclass clazz, jint index) {

	individual_t *person = NULL;
	individual_t *presentation = NULL;
	individual_t *pTimeslot = NULL;

	pTimeslot = getTimeslot(index);

	if(pTimeslot == NULL)
		return NULL;

	prop_val_t *propPerson = sslog_ss_get_property(pTimeslot, PROPERTY_PERSONLINK);
	if(propPerson != NULL)
		person = (individual_t *) propPerson->prop_value;
	else
		return NULL;

	prop_val_t *propPresents = sslog_ss_get_property(person, PROPERTY_PRESENTS);
	if(propPresents != NULL)
		presentation = (individual_t *) propPresents->prop_value;
	else
		return NULL;

	if(presentation != NULL) {
		prop_val_t *link = sslog_ss_get_property(presentation, PROPERTY_URL);

		if(link != NULL)
			return (*env)->NewStringUTF(env, (char *)link->prop_value);
	}

	return NULL;
}

/**
 * @brief Get timeslot's individual by index
 */
individual_t* getTimeslot(int index) {

	prop_val_t *propTimeslot = sslog_ss_get_property(section, PROPERTY_FIRSTTIMESLOT);
	individual_t *pTimeslot = NULL;
	int i = 0;

	if(propTimeslot == NULL)
		propTimeslot = sslog_ss_get_property(section, PROPERTY_FIRSTTIMESLOT);

	for(; (i <= index) && (propTimeslot != NULL); i++) {
		pTimeslot = (individual_t *) propTimeslot->prop_value;

		if(pTimeslot != NULL)
			propTimeslot = sslog_ss_get_property(pTimeslot, PROPERTY_NEXTTIMESLOT);
	}

	return pTimeslot;
}

/**
 * @brief Loads chosen profile from agenda service
 */
JNIEXPORT jstring JNICALL Java_petrsu_smartroom_android_srclient_KP_loadProfile
  (JNIEnv *env, jclass clazz, jobject obj, jint index) {

	jclass *classProfile = getJClassObject(env, "Profile");
	individual_t *timeslot = getTimeslot(index);
	individual_t *person = NULL;

	if(obj == NULL || timeslot == NULL)
		return "";

	jmethodID setNameId = (*env)->GetMethodID(env, classProfile,
			"setName", "(Ljava/lang/String;)V");
	jmethodID setPhoneId = (*env)->GetMethodID(env, classProfile,
			"setPhone", "(Ljava/lang/String;)V");
	jmethodID setImageId = (*env)->GetMethodID(env, classProfile,
			"setImage", "(Ljava/lang/String;)V");

	prop_val_t *propPerson = sslog_ss_get_property(timeslot, PROPERTY_PERSONLINK);
	if(propPerson != NULL)
		person = (individual_t *) propPerson->prop_value;
	else
		return NULL;

	prop_val_t *propName = sslog_ss_get_property(person, PROPERTY_NAME);
	if(propName != NULL)
		(*env)->CallVoidMethod(env, obj, setNameId,
				(*env)->NewStringUTF(env, (char *)propName->prop_value));

	prop_val_t *propPhone = sslog_ss_get_property(person, PROPERTY_PHONE);
	if(propPhone != NULL)
		(*env)->CallVoidMethod(env, obj, setPhoneId,
				(*env)->NewStringUTF(env, (char *)propPhone->prop_value));

	prop_val_t *propImage = sslog_ss_get_property(person, PROPERTY_IMG);
	if(propImage != NULL)
		(*env)->CallVoidMethod(env, obj, setImageId,
				(*env)->NewStringUTF(env, (char *)propImage->prop_value));

	return (*env)->NewStringUTF(env, (char *)person->uuid);
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
* @fn Java_petrsu_smartroom_android_srclient_KP_getThemes(JNIEnv *env, jobject obj)
*
* @brief Gets themes data from SS.
*
* @param env - pointer to JNI environment
* @param obj - Blog class object
*
* @return themes list
*/
JNIEXPORT jobjectArray JNICALL Java_petrsu_smartroom_android_blogclient_KP_getThemes(JNIEnv *env, jobject *obj)
{
	/*list_t *themelist = sslog_ss_get_individual_by_class_all(CLASS_THEME);
	individual_t *individual;
	const jint maxTheme = 255;
    jclass stringObject = (*env)->FindClass(env, "java/lang/String");
    jobjectArray ThemeArray = (*env)->NewObjectArray(env, maxTheme,
			stringObject, (*env)->NewStringUTF(env, NULL));


	if(themelist != NULL) {
		list_head_t* pos = NULL;
		int index = 0;
		list_for_each(pos, &themelist->links) {
			list_t* node = list_entry(pos, list_t, links);
			individual = (individual_t*)(node->data);
			prop_val_t *id_value = sslog_ss_get_property(individual, PROPERTY_ID);
			prop_val_t *status_value = sslog_ss_get_property(individual, PROPERTY_STATUS);

			if(index >= maxTheme)
				break;

			if ((id_value == NULL) || (status_value == NULL))
					return NULL;

			char *res = (char *) malloc (sizeof(char) * 255);
			strcat(res, (char *) id_value->prop_value); strcat(res, " ");
			strcat(res, (char *) status_value->prop_value);



			(*env)->SetObjectArrayElement(env, ThemeArray, index,
					(*env)->NewStringUTF(env, res));

			++index;
		}
	} else
		return NULL;


	return ThemeArray;*/
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
	/*list_t *list = sslog_ss_get_individual_by_class_all(CLASS_BLOG);
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

	if(ip_value == NULL)
		return NULL;

	return (*env)->NewStringUTF(env, (char *)login_value->prop_value);*/
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
	/*list_t *list = sslog_ss_get_individual_by_class_all(CLASS_BLOG);
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

	if(ip_value == NULL)
		return NULL;

	return (*env)->NewStringUTF(env, (char *)password_value->prop_value);*/


}

