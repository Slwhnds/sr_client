#ifndef _KP_H_
#define _KP_H_

#include "SmartRoomOntology.h"
#include <stdlib.h>
#include <errno.h>
#include <jni.h>
#include <string.h>
#include <stdio.h>

jobject *blogServiceClassObject;
jclass *classBlogService;
individual_t *section;

char* generateUuid(char*);
int addTimeslotToJavaList(JNIEnv *, individual_t *, jobject);

#endif
