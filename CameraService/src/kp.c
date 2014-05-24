#include "CameraService.h"
#include "kp.h"

JNIEXPORT jint JNICALL Java_CameraService_connectSmartSpace
  (JNIEnv *env, jclass clazz, jstring hostname, jstring ip, jint port) {

	const char *hostname_ = (*env) -> GetStringUTFChars(env, hostname, NULL);
	const char *ip_ = (*env) -> GetStringUTFChars(env, ip, NULL);

	if(sslog_ss_init_session_with_parameters(hostname_, ip_, (int)port) != 0)
		return -1;

	register_ontology();

	if (ss_join(sslog_get_ss_info(), "CameraService") == -1)
		return -1;

	return 0;
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

JNIEXPORT jint JNICALL Java_CameraService_publishData
  (JNIEnv *env, jclass clazz, jobjectArray cameras) {
    
	if (cameras == NULL)
		return -1;

	int i;
	jsize len;
	jobject myobj;
	char *str;
	individual_t *individual;

	//printf("This is what C gets from Java\n");
	len = (*env)->GetArrayLength(env, cameras);
	//printf("The length of the array is : %d%\n", len);

	//printf("Elements in the array:\n");
	for(i = 0; i < len; i++) {

		myobj = (*env)->GetObjectArrayElement(env, cameras, i);
		if (myobj == NULL)
			return -1;
		str = (*env)->GetStringUTFChars(env, myobj, 0);

		individual = sslog_new_individual(CLASS_CAMERA);
		if(individual == NULL)
			return -1;

		sslog_set_individual_uuid(individual,
				generateUuid(str));

		sslog_ss_remove_property_all(individual, PROPERTY_CAMERAIP);
		sslog_ss_remove_property_all(individual, PROPERTY_CAMERAPORT);
		sslog_ss_remove_property_all(individual, PROPERTY_SERVERURI);
		sslog_ss_remove_property_all(individual, PROPERTY_CAMERAAPI);
		sslog_ss_remove_property_all(individual, PROPERTY_CAMERANAME);
		sslog_ss_remove_property_all(individual, PROPERTY_CAMERALOGIN);
		sslog_ss_remove_property_all(individual, PROPERTY_CAMERAPASS);

		char *token, *last;


		//name
		token = strtok_r(str, " ", &last);
		if (token == NULL)
			return -1;
		if(sslog_ss_add_property(individual, PROPERTY_CAMERANAME, (void *)token) != 0 )
			return -1;
		//printf ("%s\n", token);

		//ip
		token = strtok_r(NULL, " ", &last);
		if (token == NULL)
			return -1;
		if(sslog_ss_add_property(individual, PROPERTY_CAMERAIP, (void *)token) != 0 )
			return -1;
		//printf ("%s\n", token);

		//port
		token = strtok_r(NULL, " ", &last);
		if (token == NULL)
			return -1;
		if(sslog_ss_add_property(individual, PROPERTY_CAMERAPORT, (void *)token) != 0 )
			return -1;
		//printf ("%s\n", token);

		//uri
		token = strtok_r(NULL, " ", &last);
		if (token == NULL)
			return -1;
		if(sslog_ss_add_property(individual, PROPERTY_SERVERURI, (void *)token) != 0 )
			return -1;
		//printf ("%s\n", token);

		//api
		token = strtok_r(NULL, " ", &last);
		if (token == NULL)
			return -1;
		if(sslog_ss_add_property(individual, PROPERTY_CAMERAAPI, (void *)token) != 0 )
			return -1;
		//printf ("%s\n", token);

		//login
		token = strtok_r(NULL, " ", &last);
		if (token == NULL)
			return -1;
		if(sslog_ss_add_property(individual, PROPERTY_CAMERALOGIN, (void *)token) != 0 )
			return -1;
		//printf ("%s\n", token);

		//password
		token = strtok_r(NULL, " ", &last);
		if (token == NULL)
			return -1;
		if(sslog_ss_add_property(individual, PROPERTY_CAMERAPASS, (void *)token) != 0 )
			return -1;
		//printf ("%s\n", token);

		if(sslog_ss_insert_individual(individual) != 0)
			return -1;
	}

    return 0;
}

JNIEXPORT void JNICALL Java_CameraService_deletePublishedData
  (JNIEnv *env, jclass clazz) {
	list_t *list = sslog_ss_get_individual_by_class_all(CLASS_CAMERA);
	individual_t *individual;

	if(list != NULL) {
		list_head_t* pos = NULL;
		list_for_each(pos, &list->links) {
			list_t* node = list_entry(pos, list_t, links);
			individual = (individual_t*)(node->data);
			sslog_ss_populate_individual(individual);
			sslog_ss_remove_property_all(individual, PROPERTY_CAMERAIP);
			sslog_ss_remove_property_all(individual, PROPERTY_CAMERAPORT);
			sslog_ss_remove_property_all(individual, PROPERTY_SERVERURI);
			sslog_ss_remove_property_all(individual, PROPERTY_CAMERAAPI);
			sslog_ss_remove_property_all(individual, PROPERTY_CAMERANAME);
			sslog_ss_remove_property_all(individual, PROPERTY_CAMERALOGIN);
			sslog_ss_remove_property_all(individual, PROPERTY_CAMERAPASS);
			sslog_ss_remove_individual(individual);
		}

	}
	return;
}
