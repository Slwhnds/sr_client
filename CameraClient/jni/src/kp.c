#include "CameraClient.h"
#include "kp.h"

JNIEXPORT jint JNICALL Java_petrsu_smartroom_android_cameraclient_KP_connectSmartSpace
  (JNIEnv *env, jclass clazz, jstring hostname, jstring ip, jint port) {

	const char *hostname_ = (*env) -> GetStringUTFChars(env, hostname, NULL);
	const char *ip_ = (*env) -> GetStringUTFChars(env, ip, NULL);

	if(sslog_ss_init_session_with_parameters(hostname_, ip_, (int)port) != 0)
		return -1;

	register_ontology();

	if (ss_join(sslog_get_ss_info(), generateUuid("CameraClient")) == -1)
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

/*JNIEXPORT jobjectArray JNICALL Java_petrsu_smartroom_android_cameraclient_KP_getCameraData
  (JNIEnv *env, jclass clazz) {
	list_t *cameralist = sslog_ss_get_individual_by_class_all(CLASS_CAMERA);
		individual_t *individual;
		const jint maxCameras = 10;
	    jclass stringObject = (*env)->FindClass(env, "java/lang/String");
	    jobjectArray CamerasArray = (*env)->NewObjectArray(env, maxCameras,
				stringObject, (*env)->NewStringUTF(env, NULL));

		//__android_log_print("native code", "1*********");

		if(cameralist != NULL) {
			//__android_log_print("native code", "2*********");
			list_head_t* pos = NULL;
			int index = 0;
			list_for_each(pos, &cameralist->links) {
				list_t* node = list_entry(pos, list_t, links);
				individual = (individual_t*)(node->data);
				sslog_ss_populate_individual(individual);

				//__android_log_print("native code", "3*********");
				prop_val_t *name_value = sslog_ss_get_property(individual, PROPERTY_CAMERANAME);
				prop_val_t *ip_value = sslog_ss_get_property(individual, PROPERTY_CAMERAIP);
				prop_val_t *port_value = sslog_ss_get_property(individual, PROPERTY_CAMERAPORT);
				prop_val_t *login_value = sslog_ss_get_property(individual, PROPERTY_CAMERALOGIN);
				prop_val_t *password_value = sslog_ss_get_property(individual, PROPERTY_CAMERAPASS);
				prop_val_t *api_value = sslog_ss_get_property(individual, PROPERTY_CAMERAAPI);
				prop_val_t *uri_value = sslog_ss_get_property(individual, PROPERTY_SERVERURI);

				//__android_log_print("native code", "4*********");
				if(index >= maxCameras)
					break;

				if ((name_value == NULL) ||
					(ip_value == NULL) ||
					(port_value == NULL) ||
					(login_value == NULL) ||
					(password_value == NULL) ||
					(api_value == NULL) ||
					(uri_value == NULL))
						return NULL;

				/*char *name_value_ = (*env) -> GetStringUTFChars(env, name_value->prop_value, NULL);
				char *ip_value_ = (*env) -> GetStringUTFChars(env, ip_value->prop_value, NULL);
				char *port_value_ = (*env) -> GetStringUTFChars(env, port_value->prop_value, NULL);
				char *login_value_ = (*env) -> GetStringUTFChars(env, login_value->prop_value, NULL);
				char *password_value_ = (*env) -> GetStringUTFChars(env, password_value->prop_value, NULL);
				char *api_value_ = (*env) -> GetStringUTFChars(env, api_value->prop_value, NULL);
				char *uri_value_= (*env) -> GetStringUTFChars(env, uri_value->prop_value, NULL);*/

				//__android_log_print("native code", "5*********");
				/*char *name_value_ = (char*) name_value->prop_value;
				char *ip_value_ = (char*) ip_value->prop_value;
				char *port_value_ = (char*) port_value->prop_value;
				char *login_value_ = (char*) login_value->prop_value;
				char *password_value_ = (char*) password_value->prop_value;
				char *api_value_ = (char*) api_value->prop_value;
				char *uri_value_= (char*) uri_value->prop_value;

			char res[sizeof(char) * (
					strlen(name_value_) + strlen(ip_value_) +
					strlen(port_value_) + strlen(uri_value_) +
					strlen(api_value_) + strlen(login_value_) +
					strlen(password_value_) + strlen(" ") * 6 + strlen('\0')
			)];
			/*strncat(res, name_value_, strlen(name_value_)); strncat(res, " ", strlen(" "));
			strncat(res, ip_value_, strlen(ip_value_)); strncat(res, " ", strlen(" "));
			strncat(res, port_value_, strlen(port_value_)); strncat(res, " ", strlen(" "));
			strncat(res, uri_value_, strlen(uri_value_)); strncat(res, " ", strlen(" "));
			strncat(res, api_value_, strlen(api_value_)); strncat(res, " ", strlen(" "));
			strncat(res, login_value_, strlen(login_value_)); strncat(res, " ", strlen(" "));
			strncat(res, password_value_, strlen(password_value_)); strncat(res, " ", strlen(" "));
			strncat(res, '\0', strlen('\0'));*/
			//(*env)->NewStringUTF(env, " ");

				/*(*env)->SetObjectArrayElement(env, CamerasArray, index,
						(*env)->NewStringUTF(env, res));

				++index;
			}
		} else
			return NULL;

		return CamerasArray;
		//return NULL;
}*/

JNIEXPORT jint JNICALL Java_petrsu_smartroom_android_cameraclient_KP_getCameraData
  (JNIEnv *env, jclass clazz, jobject obj) {

	if(obj != NULL)
		classCameraListActivity = (*env)->GetObjectClass(env, obj);
	else
		return -1;

	list_t *cameralist = sslog_ss_get_individual_by_class_all(CLASS_CAMERA);
		individual_t *individual;

		if(cameralist != NULL) {
			list_head_t* pos = NULL;
			list_for_each(pos, &cameralist->links) {
				list_t* node = list_entry(pos, list_t, links);
				individual = (individual_t*)(node->data);
				sslog_ss_populate_individual(individual);
				if (addCameraToJavaList(env, individual, obj) != 0 )
								return -1;
			}
		}

		return 0;
}

int addCameraToJavaList(JNIEnv *env, individual_t *camera, jobject obj) {

	//printf("addTimeslotToJavaList\n");

	jmethodID methodId = (*env)->GetMethodID(env, classCameraListActivity, "addCameraItemToList",
			"(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V");

	prop_val_t *name_value = sslog_ss_get_property(camera, PROPERTY_CAMERANAME);
	prop_val_t *ip_value = sslog_ss_get_property(camera, PROPERTY_CAMERAIP);
	prop_val_t *port_value = sslog_ss_get_property(camera, PROPERTY_CAMERAPORT);
	prop_val_t *login_value = sslog_ss_get_property(camera, PROPERTY_CAMERALOGIN);
	prop_val_t *password_value = sslog_ss_get_property(camera, PROPERTY_CAMERAPASS);
	prop_val_t *api_value = sslog_ss_get_property(camera, PROPERTY_CAMERAAPI);
	prop_val_t *uri_value = sslog_ss_get_property(camera, PROPERTY_SERVERURI);

	if((name_value == NULL)	|| (ip_value == NULL) || (port_value == NULL) || (login_value == NULL)
			|| (password_value == NULL) || (api_value == NULL) || (uri_value == NULL))
		return -1;

	char *name_value_ = (char*) name_value->prop_value;
	char *ip_value_ = (char*) ip_value->prop_value;
	char *port_value_ = (char*) port_value->prop_value;
	char *login_value_ = (char*) login_value->prop_value;
	char *password_value_ = (char*) password_value->prop_value;
	char *api_value_ = (char*) api_value->prop_value;
	char *uri_value_= (char*) uri_value->prop_value;

	if(obj != NULL) {
		(*env)->CallVoidMethod(env, obj, methodId,
				(*env)->NewStringUTF(env, name_value_),
				(*env)->NewStringUTF(env, ip_value_),
				(*env)->NewStringUTF(env, port_value_),
				(*env)->NewStringUTF(env, uri_value_),
				(*env)->NewStringUTF(env, api_value_),
				(*env)->NewStringUTF(env, login_value_),
				(*env)->NewStringUTF(env, password_value_));
		return 0;
	}
	else
		return -1;
}
