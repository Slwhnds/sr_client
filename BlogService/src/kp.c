#include "BlogService.h"
#include "kp.h"

JNIEXPORT jint JNICALL Java_BlogService_connectSmartSpace
  (JNIEnv *env, jclass clazz, jstring hostname, jstring ip, jint port) {

	const char *hostname_ = (*env) -> GetStringUTFChars(env, hostname, NULL);
	const char *ip_ = (*env) -> GetStringUTFChars(env, ip, NULL);

	if(sslog_ss_init_session_with_parameters(hostname_, ip_, (int)port) != 0)
		return -1;

	register_ontology();

	if (ss_join(sslog_get_ss_info(), "BlogService") == -1)
		return -1;

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
JNIEXPORT jint JNICALL Java_BlogService_loadTimeslotList
  (JNIEnv *env, jclass clazz, jobject obj) {

	// TODO:
	// when there will be more than one section, it's enough only to
	// initialize chosen `section`
	int counter = 0, attempts = 1000;
	//printf("100\n");

	if(obj != NULL)
		blogServiceClassObject = (jobject *)(*env)->NewGlobalRef(env, obj);
	else
		return -1;

	/* Get section */
		list_t *sectionList = sslog_ss_get_individual_by_class_all(CLASS_SECTION);

		if(sectionList != NULL) {
			printf("sectionList != NULL\n");
			list_head_t* pos = NULL;
			list_for_each(pos, &sectionList->links) {
				list_t* node = list_entry(pos, list_t, links);
				section = (individual_t *)(node->data);
				sslog_ss_populate_individual(section);
				break;
			}
		}/* Get section */


	prop_val_t *propTimeslot = sslog_ss_get_property(section, PROPERTY_FIRSTTIMESLOT);

	for(; counter < attempts; counter++) {
		if(propTimeslot == NULL)
			propTimeslot = sslog_ss_get_property(section, PROPERTY_FIRSTTIMESLOT);
		else
			break;
	}

	while(propTimeslot != NULL) {
		printf("propTimeslot != NULL\n");

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

	printf("addTimeslotToJavaList\n");

	jmethodID methodId = (*env)->GetMethodID(env, classBlogService, "addTimeslotItemToList",
			"(Ljava/lang/String;Ljava/lang/String;)V");

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

	/* Calling Agenda's addTimeslotItemToList Java method */
	if(obj != NULL)
		(*env)->CallVoidMethod(env, obj, methodId,
				(*env)->NewStringUTF(env, (char *)(p_val_name->prop_value)),
				(*env)->NewStringUTF(env, (char *)(p_val_pres_title->prop_value)));
}


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

JNIEXPORT jint JNICALL Java_BlogService_publishStartData
  (JNIEnv *env, jclass clazz, jstring login, jstring pass) {
    
    const char *login_ = (*env) -> GetStringUTFChars(env, login, NULL);
    const char *pass_ = (*env) -> GetStringUTFChars(env, pass, NULL);
    
   /* individual_t *individual = sslog_new_individual(CLASS_BLOG);
    if(individual == NULL)
	return -1;

    sslog_set_individual_uuid(individual, 
			      "http://www.cs.karelia.ru/smartroom#blog");
    
    sslog_ss_remove_property_all(individual, PROPERTY_SRLOGIN);
    sslog_ss_remove_property_all(individual, PROPERTY_SRPASSWORD);
    
    if(sslog_ss_add_property(individual, PROPERTY_SRLOGIN, (void *)login_) != 0 )
	return -1;
    
    if(sslog_ss_add_property(individual, PROPERTY_SRPASSWORD, (void *)pass_) != 0 )
	return -1;

    if(sslog_ss_insert_individual(individual) != 0)
	return -1;*/

    return 0;
}

JNIEXPORT jint JNICALL Java_BlogService_publishData
  (JNIEnv *env, jclass clazz, jstring status, jstring id) {

    const char *status_ = (*env) -> GetStringUTFChars(env, status, NULL);
    const char *id_ = (*env) -> GetStringUTFChars(env, id, NULL);

    /*individual_t *individual = sslog_new_individual(CLASS_THEME);
    if(individual == NULL)
	return -1;

    sslog_set_individual_uuid(individual,
    		generateUuid("newTheme"));

    sslog_ss_remove_property_all(individual, PROPERTY_STATUS);
    sslog_ss_remove_property_all(individual, PROPERTY_ID);

    if(sslog_ss_add_property(individual, PROPERTY_STATUS, (void *)status_) != 0 )
	return -1;

    if(sslog_ss_add_property(individual, PROPERTY_ID, (void *)id_) != 0 )
	return -1;

    if(sslog_ss_insert_individual(individual) != 0)
	return -1;*/

    return 0;
}

JNIEXPORT void JNICALL Java_BlogService_deletePublishedData
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
	return;
    
    sslog_ss_remove_property_all(individual, PROPERTY_IP);
    sslog_ss_remove_property_all(individual, PROPERTY_PORT);
}
