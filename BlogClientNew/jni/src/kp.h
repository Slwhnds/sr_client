#ifndef _KP_H_
#define _KP_H_

#include "SmartRoomOntology.h"
#include <stdlib.h>
#include <errno.h>
#include <jni.h>
#include <string.h>

#define MAX_CLASS_NAME_LENGTH 20
#define ERROR_MSG_LENGTH 40


JavaVM* JVM;
individual_t *personProfile;
individual_t *currentSection;
jclass *classAgenda;
jclass *classProjector;
jclass *classKP;
jobject *agendaClassObject;
jobject *presentationClassObject;
int currentTimeslotIndex;
subscription_t *conferenceSubscriptionContainer;
subscription_t *presentationSubscriptionContainer;

void addTimeslotToJavaList(JNIEnv *, individual_t *, jobject);
prop_val_t* initNullProperty();
char* generateUuid(char*);
jclass getJClassObject(JNIEnv *, char *);
jfieldID getFieldID(JNIEnv *, jclass, char *, char *);
int searchPerson(individual_t *, const char *, const char *);
int activatePerson(individual_t *);
void subscriptionHandler(subscription_t *);
void projectorNotificationHandler(subscription_t *);
void agendaNotificationHandler(subscription_t *);
void conferenceNotificationHandler(subscription_t *);
individual_t* createProfile(individual_t *);
individual_t* createPerson(const char *, const char *, const char*);
void logout();
int calculateTimeslotIndex(prop_val_t *);
bool personExists(const char *);
individual_t* getTimeslot(int);
int subscribeConferenceService();
int subscribePresentationService();
individual_t* getCurrentSection();
individual_t* getFirstTimeslot();
individual_t* getContentService();

int addThemeToJavaList(JNIEnv *, individual_t *, jobject);
jclass *classBlogListActivity;

#endif
