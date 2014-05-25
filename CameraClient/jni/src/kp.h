#ifndef _KP_H_
#define _KP_H_

#include "SmartRoomOntology.h"
#include <stdlib.h>
#include <errno.h>
#include <jni.h>
#include <string.h>
#include <stdio.h>

jclass *classCameraListActivity;

char* generateUuid(char*);
int addCameraToJavaList(JNIEnv *, individual_t *, jobject);

#endif
