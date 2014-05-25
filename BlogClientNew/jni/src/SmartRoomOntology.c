#include "SmartRoomOntology.h"



#if INCLUDE_CLASS_TIMESLOT
class_t *CLASS_TIMESLOT;
#endif
#if INCLUDE_CLASS_PROFILE
class_t *CLASS_PROFILE;
#endif
#if INCLUDE_CLASS_CONFERENCESERVICE
class_t *CLASS_CONFERENCESERVICE;
#endif
#if INCLUDE_CLASS_CONTENTSERVICE
class_t *CLASS_CONTENTSERVICE;
#endif
#if INCLUDE_CLASS_NOTHING
class_t *CLASS_NOTHING;
#endif
#if INCLUDE_CLASS_PRESENTATION
class_t *CLASS_PRESENTATION;
#endif
#if INCLUDE_CLASS_SMARTROOM
class_t *CLASS_SMARTROOM;
#endif
#if INCLUDE_CLASS_BLOG
class_t *CLASS_BLOG;
#endif
#if INCLUDE_CLASS_PERSON
class_t *CLASS_PERSON;
#endif
#if INCLUDE_CLASS_ACTIVITY
class_t *CLASS_ACTIVITY;
#endif
#if INCLUDE_CLASS_AGENDANOTIFICATION
class_t *CLASS_AGENDANOTIFICATION;
#endif
#if INCLUDE_CLASS_PRESENTATIONNOTIFICATION
class_t *CLASS_PRESENTATIONNOTIFICATION;
#endif
#if INCLUDE_CLASS_THING
class_t *CLASS_THING;
#endif
#if INCLUDE_CLASS_CONTEXT
class_t *CLASS_CONTEXT;
#endif
#if INCLUDE_CLASS_CLIENTNOTIFICATION
class_t *CLASS_CLIENTNOTIFICATION;
#endif
#if INCLUDE_CLASS_PRESENTATIONSERVICE
class_t *CLASS_PRESENTATIONSERVICE;
#endif
#if INCLUDE_CLASS_ONLINEACCOUNT
class_t *CLASS_ONLINEACCOUNT;
#endif
#if INCLUDE_CLASS_SECTION
class_t *CLASS_SECTION;
#endif
#if INCLUDE_CLASS_CONFERENCENOTIFICATION
class_t *CLASS_CONFERENCENOTIFICATION;
#endif
#if INCLUDE_CLASS_SERVICE
class_t *CLASS_SERVICE;
#endif
#if INCLUDE_CLASS_THEME
class_t *CLASS_THEME;
#endif


#if INCLUDE_PROPERTY_MBOX
property_t *PROPERTY_MBOX;
#endif
#if INCLUDE_PROPERTY_PRESENTATIONURL
property_t *PROPERTY_PRESENTATIONURL;
#endif
#if INCLUDE_PROPERTY_CONTENTURL
property_t *PROPERTY_CONTENTURL;
#endif
#if INCLUDE_PROPERTY_ORGANIZATION
property_t *PROPERTY_ORGANIZATION;
#endif
#if INCLUDE_PROPERTY_SECTIONSTARTTIME
property_t *PROPERTY_SECTIONSTARTTIME;
#endif
#if INCLUDE_PROPERTY_ENDPRESENTATION
property_t *PROPERTY_ENDPRESENTATION;
#endif
#if INCLUDE_PROPERTY_CURRENTSLIDENUM
property_t *PROPERTY_CURRENTSLIDENUM;
#endif
#if INCLUDE_PROPERTY_HOLDSACTIVITY
property_t *PROPERTY_HOLDSACTIVITY;
#endif
#if INCLUDE_PROPERTY_ACTIVITYTITLE
property_t *PROPERTY_ACTIVITYTITLE;
#endif
#if INCLUDE_PROPERTY_USERNAME
property_t *PROPERTY_USERNAME;
#endif
#if INCLUDE_PROPERTY_TIMESLOTACTUALDURATION
property_t *PROPERTY_TIMESLOTACTUALDURATION;
#endif
#if INCLUDE_PROPERTY_TOPIC_INTEREST
property_t *PROPERTY_TOPIC_INTEREST;
#endif
#if INCLUDE_PROPERTY_PASSWORD
property_t *PROPERTY_PASSWORD;
#endif
#if INCLUDE_PROPERTY_TIMESLOTTITLE
property_t *PROPERTY_TIMESLOTTITLE;
#endif
#if INCLUDE_PROPERTY_PHONE
property_t *PROPERTY_PHONE;
#endif
#if INCLUDE_PROPERTY_STARTCONFERENCE
property_t *PROPERTY_STARTCONFERENCE;
#endif
#if INCLUDE_PROPERTY_CURRENTSLIDECOUNT
property_t *PROPERTY_CURRENTSLIDECOUNT;
#endif
#if INCLUDE_PROPERTY_HASSERVICE
property_t *PROPERTY_HASSERVICE;
#endif
#if INCLUDE_PROPERTY_SECTIONTITLE
property_t *PROPERTY_SECTIONTITLE;
#endif
#if INCLUDE_PROPERTY_SRPASSWORD
property_t *PROPERTY_SRPASSWORD;
#endif
#if INCLUDE_PROPERTY_PERSONINFORMATION
property_t *PROPERTY_PERSONINFORMATION;
#endif
#if INCLUDE_PROPERTY_CURRENTSLIDEIMG
property_t *PROPERTY_CURRENTSLIDEIMG;
#endif
#if INCLUDE_PROPERTY_NEXTTIMESLOT
property_t *PROPERTY_NEXTTIMESLOT;
#endif
#if INCLUDE_PROPERTY_TIMESLOTSPEAKERNAME
property_t *PROPERTY_TIMESLOTSPEAKERNAME;
#endif
#if INCLUDE_PROPERTY_SRLOGIN
property_t *PROPERTY_SRLOGIN;
#endif
#if INCLUDE_PROPERTY_PRESENTATIONTITLE
property_t *PROPERTY_PRESENTATIONTITLE;
#endif
#if INCLUDE_PROPERTY_THEMEID
property_t *PROPERTY_THEMEID;
#endif
#if INCLUDE_PROPERTY_HASSECTION
property_t *PROPERTY_HASSECTION;
#endif
#if INCLUDE_PROPERTY_FIRSTTIMESLOT
property_t *PROPERTY_FIRSTTIMESLOT;
#endif
#if INCLUDE_PROPERTY_SERVICENAME
property_t *PROPERTY_SERVICENAME;
#endif
#if INCLUDE_PROPERTY_NAME
property_t *PROPERTY_NAME;
#endif
#if INCLUDE_PROPERTY_PRESENTATIONTAGS
property_t *PROPERTY_PRESENTATIONTAGS;
#endif
#if INCLUDE_PROPERTY_STARTPRESENTATION
property_t *PROPERTY_STARTPRESENTATION;
#endif
#if INCLUDE_PROPERTY_CURRENTTIMESLOT
property_t *PROPERTY_CURRENTTIMESLOT;
#endif
#if INCLUDE_PROPERTY_SHOWSLIDE
property_t *PROPERTY_SHOWSLIDE;
#endif
#if INCLUDE_PROPERTY_UPDATEPRESENTATION
property_t *PROPERTY_UPDATEPRESENTATION;
#endif
#if INCLUDE_PROPERTY_ENDCONFERENCE
property_t *PROPERTY_ENDCONFERENCE;
#endif
#if INCLUDE_PROPERTY_SERVICEDESCRIPTION
property_t *PROPERTY_SERVICEDESCRIPTION;
#endif
#if INCLUDE_PROPERTY_TIMESLOTPERSON
property_t *PROPERTY_TIMESLOTPERSON;
#endif
#if INCLUDE_PROPERTY_THEMESTATUS
property_t *PROPERTY_THEMESTATUS;
#endif
#if INCLUDE_PROPERTY_STATUS
property_t *PROPERTY_STATUS;
#endif
#if INCLUDE_PROPERTY_TIMESLOTPRESENTATION
property_t *PROPERTY_TIMESLOTPRESENTATION;
#endif
#if INCLUDE_PROPERTY_WLANMAC
property_t *PROPERTY_WLANMAC;
#endif
#if INCLUDE_PROPERTY_ACCOUNT
property_t *PROPERTY_ACCOUNT;
#endif
#if INCLUDE_PROPERTY_TIMESLOTDURATION
property_t *PROPERTY_TIMESLOTDURATION;
#endif
#if INCLUDE_PROPERTY_SECTIONDATE
property_t *PROPERTY_SECTIONDATE;
#endif
#if INCLUDE_PROPERTY_AGE
property_t *PROPERTY_AGE;
#endif
#if INCLUDE_PROPERTY_UPDATEAGENDA
property_t *PROPERTY_UPDATEAGENDA;
#endif
#if INCLUDE_PROPERTY_IMG
property_t *PROPERTY_IMG;
#endif
#if INCLUDE_PROPERTY_LANGUAGE
property_t *PROPERTY_LANGUAGE;
#endif
#if INCLUDE_PROPERTY_HASPRESENTATION
property_t *PROPERTY_HASPRESENTATION;
#endif
#if INCLUDE_PROPERTY_CURRENTPRESENTATION
property_t *PROPERTY_CURRENTPRESENTATION;
#endif
#if INCLUDE_PROPERTY_HASCONTEXT
property_t *PROPERTY_HASCONTEXT;
#endif
#if INCLUDE_PROPERTY_STARTCONFERENCEFROM
property_t *PROPERTY_STARTCONFERENCEFROM;
#endif
#if INCLUDE_PROPERTY_SERVICESTATUS
property_t *PROPERTY_SERVICESTATUS;
#endif
#if INCLUDE_PROPERTY_CURRENTSECTION
property_t *PROPERTY_CURRENTSECTION;
#endif



/**
 * @brief Register ontology.
 *
 * It creates all structures, such as classes and properties. Use it firs in your propgramm.
 */
void register_ontology()
{    
    list_t *tmp_node = NULL;    

#if INCLUDE_PROPERTY_MBOX

PROPERTY_MBOX =  (property_t *) malloc(sizeof(property_t));
PROPERTY_MBOX->name = strdup("http://xmlns.com/foaf/0.1/mbox");
PROPERTY_MBOX->about = strdup("mbox");
//PROPERTY_MBOX->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_MBOX->domain = strdup("http://xmlns.com/foaf/0.1/Person"); 
PROPERTY_MBOX->maxcardinality = -1;
PROPERTY_MBOX->mincardinality = -1;
PROPERTY_MBOX->subpropertyof = NULL;
PROPERTY_MBOX->oneof = list_get_new_list();  
PROPERTY_MBOX->rtti = RTTI_PROPERTY;
PROPERTY_MBOX->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_MBOX);

#endif
#if INCLUDE_PROPERTY_PRESENTATIONURL

PROPERTY_PRESENTATIONURL =  (property_t *) malloc(sizeof(property_t));
PROPERTY_PRESENTATIONURL->name = strdup("http://www.cs.karelia.ru/smartroom#presentationUrl");
PROPERTY_PRESENTATIONURL->about = strdup("presentationUrl");
//PROPERTY_PRESENTATIONURL->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_PRESENTATIONURL->domain = strdup("http://www.cs.karelia.ru/smartroom#Presentation");
PROPERTY_PRESENTATIONURL->maxcardinality = -1;
PROPERTY_PRESENTATIONURL->mincardinality = -1;
PROPERTY_PRESENTATIONURL->subpropertyof = NULL;
PROPERTY_PRESENTATIONURL->oneof = list_get_new_list();
PROPERTY_PRESENTATIONURL->rtti = RTTI_PROPERTY;
PROPERTY_PRESENTATIONURL->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_PRESENTATIONURL);

#endif
#if INCLUDE_PROPERTY_CONTENTURL

PROPERTY_CONTENTURL =  (property_t *) malloc(sizeof(property_t));
PROPERTY_CONTENTURL->name = strdup("http://www.cs.karelia.ru/smartroom#contentUrl");
PROPERTY_CONTENTURL->about = strdup("contentUrl");
//PROPERTY_CONTENTURL->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_CONTENTURL->domain = strdup("http://www.cs.karelia.ru/smartroom#ContentService");
PROPERTY_CONTENTURL->maxcardinality = -1;
PROPERTY_CONTENTURL->mincardinality = -1;
PROPERTY_CONTENTURL->subpropertyof = NULL;
PROPERTY_CONTENTURL->oneof = list_get_new_list();
PROPERTY_CONTENTURL->rtti = RTTI_PROPERTY;
PROPERTY_CONTENTURL->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_CONTENTURL);

#endif
#if INCLUDE_PROPERTY_ORGANIZATION

PROPERTY_ORGANIZATION =  (property_t *) malloc(sizeof(property_t));
PROPERTY_ORGANIZATION->name = strdup("http://www.cs.karelia.ru/smartroom#organization");
PROPERTY_ORGANIZATION->about = strdup("organization");
//PROPERTY_ORGANIZATION->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_ORGANIZATION->domain = strdup("http://xmlns.com/foaf/0.1/Person"); 
PROPERTY_ORGANIZATION->maxcardinality = -1;
PROPERTY_ORGANIZATION->mincardinality = -1;
PROPERTY_ORGANIZATION->subpropertyof = NULL;
PROPERTY_ORGANIZATION->oneof = list_get_new_list();  
PROPERTY_ORGANIZATION->rtti = RTTI_PROPERTY;
PROPERTY_ORGANIZATION->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_ORGANIZATION);

#endif
#if INCLUDE_PROPERTY_SECTIONSTARTTIME

PROPERTY_SECTIONSTARTTIME =  (property_t *) malloc(sizeof(property_t));
PROPERTY_SECTIONSTARTTIME->name = strdup("http://www.cs.karelia.ru/smartroom#sectionStartTime");
PROPERTY_SECTIONSTARTTIME->about = strdup("sectionStartTime");
//PROPERTY_SECTIONSTARTTIME->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_SECTIONSTARTTIME->domain = strdup("http://www.cs.karelia.ru/smartroom#Section");
PROPERTY_SECTIONSTARTTIME->maxcardinality = -1;
PROPERTY_SECTIONSTARTTIME->mincardinality = -1;
PROPERTY_SECTIONSTARTTIME->subpropertyof = NULL;
PROPERTY_SECTIONSTARTTIME->oneof = list_get_new_list();
PROPERTY_SECTIONSTARTTIME->rtti = RTTI_PROPERTY;
PROPERTY_SECTIONSTARTTIME->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_SECTIONSTARTTIME);

#endif
#if INCLUDE_PROPERTY_ENDPRESENTATION

PROPERTY_ENDPRESENTATION =  (property_t *) malloc(sizeof(property_t));
PROPERTY_ENDPRESENTATION->name = strdup("http://www.cs.karelia.ru/smartroom#endPresentation");
PROPERTY_ENDPRESENTATION->about = strdup("endPresentation");
//PROPERTY_ENDPRESENTATION->range = "http://www.cs.karelia.ru/smartroom#Presentation"; //getRange
PROPERTY_ENDPRESENTATION->domain = strdup("-74525e9f:14633798e1a:-7ff7");
PROPERTY_ENDPRESENTATION->maxcardinality = -1;
PROPERTY_ENDPRESENTATION->mincardinality = -1;
PROPERTY_ENDPRESENTATION->subpropertyof = NULL;
PROPERTY_ENDPRESENTATION->oneof = list_get_new_list();  
PROPERTY_ENDPRESENTATION->rtti = RTTI_PROPERTY;
PROPERTY_ENDPRESENTATION->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_ENDPRESENTATION);

#endif
#if INCLUDE_PROPERTY_CURRENTSLIDENUM

PROPERTY_CURRENTSLIDENUM =  (property_t *) malloc(sizeof(property_t));
PROPERTY_CURRENTSLIDENUM->name = strdup("http://www.cs.karelia.ru/smartroom#currentSlideNum");
PROPERTY_CURRENTSLIDENUM->about = strdup("currentSlideNum");
//PROPERTY_CURRENTSLIDENUM->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_CURRENTSLIDENUM->domain = strdup("http://www.cs.karelia.ru/smartroom#PresentationService");
PROPERTY_CURRENTSLIDENUM->maxcardinality = -1;
PROPERTY_CURRENTSLIDENUM->mincardinality = -1;
PROPERTY_CURRENTSLIDENUM->subpropertyof = NULL;
PROPERTY_CURRENTSLIDENUM->oneof = list_get_new_list();  
PROPERTY_CURRENTSLIDENUM->rtti = RTTI_PROPERTY;
PROPERTY_CURRENTSLIDENUM->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_CURRENTSLIDENUM);

#endif
#if INCLUDE_PROPERTY_HOLDSACTIVITY

PROPERTY_HOLDSACTIVITY =  (property_t *) malloc(sizeof(property_t));
PROPERTY_HOLDSACTIVITY->name = strdup("http://www.cs.karelia.ru/smartroom#holdsActivity");
PROPERTY_HOLDSACTIVITY->about = strdup("holdsActivity");
//PROPERTY_HOLDSACTIVITY->range = "http://www.cs.karelia.ru/smartroom#Activity"; //getRange
PROPERTY_HOLDSACTIVITY->domain = strdup("http://www.cs.karelia.ru/smartroom#ConferenceService");
PROPERTY_HOLDSACTIVITY->maxcardinality = -1;
PROPERTY_HOLDSACTIVITY->mincardinality = -1;
PROPERTY_HOLDSACTIVITY->subpropertyof = NULL;
PROPERTY_HOLDSACTIVITY->oneof = list_get_new_list();
PROPERTY_HOLDSACTIVITY->rtti = RTTI_PROPERTY;
PROPERTY_HOLDSACTIVITY->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_HOLDSACTIVITY);

#endif
#if INCLUDE_PROPERTY_ACTIVITYTITLE

PROPERTY_ACTIVITYTITLE =  (property_t *) malloc(sizeof(property_t));
PROPERTY_ACTIVITYTITLE->name = strdup("http://www.cs.karelia.ru/smartroom#activityTitle");
PROPERTY_ACTIVITYTITLE->about = strdup("activityTitle");
//PROPERTY_ACTIVITYTITLE->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_ACTIVITYTITLE->domain = strdup("http://www.cs.karelia.ru/smartroom#Activity");
PROPERTY_ACTIVITYTITLE->maxcardinality = -1;
PROPERTY_ACTIVITYTITLE->mincardinality = -1;
PROPERTY_ACTIVITYTITLE->subpropertyof = NULL;
PROPERTY_ACTIVITYTITLE->oneof = list_get_new_list();
PROPERTY_ACTIVITYTITLE->rtti = RTTI_PROPERTY;
PROPERTY_ACTIVITYTITLE->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_ACTIVITYTITLE);

#endif
#if INCLUDE_PROPERTY_USERNAME

PROPERTY_USERNAME =  (property_t *) malloc(sizeof(property_t));
PROPERTY_USERNAME->name = strdup("http://www.cs.karelia.ru/smartroom#username");
PROPERTY_USERNAME->about = strdup("username");
//PROPERTY_USERNAME->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_USERNAME->domain = strdup("http://www.cs.karelia.ru/smartroom#Profile"); 
PROPERTY_USERNAME->maxcardinality = -1;
PROPERTY_USERNAME->mincardinality = -1;
PROPERTY_USERNAME->subpropertyof = NULL;
PROPERTY_USERNAME->oneof = list_get_new_list();  
PROPERTY_USERNAME->rtti = RTTI_PROPERTY;
PROPERTY_USERNAME->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_USERNAME);

#endif
#if INCLUDE_PROPERTY_TIMESLOTACTUALDURATION

PROPERTY_TIMESLOTACTUALDURATION =  (property_t *) malloc(sizeof(property_t));
PROPERTY_TIMESLOTACTUALDURATION->name = strdup("http://www.cs.karelia.ru/smartroom#timeslotActualDuration");
PROPERTY_TIMESLOTACTUALDURATION->about = strdup("timeslotActualDuration");
//PROPERTY_TIMESLOTACTUALDURATION->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_TIMESLOTACTUALDURATION->domain = strdup("http://www.cs.karelia.ru/smartroom#Timeslot");
PROPERTY_TIMESLOTACTUALDURATION->maxcardinality = -1;
PROPERTY_TIMESLOTACTUALDURATION->mincardinality = -1;
PROPERTY_TIMESLOTACTUALDURATION->subpropertyof = NULL;
PROPERTY_TIMESLOTACTUALDURATION->oneof = list_get_new_list();
PROPERTY_TIMESLOTACTUALDURATION->rtti = RTTI_PROPERTY;
PROPERTY_TIMESLOTACTUALDURATION->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_TIMESLOTACTUALDURATION);

#endif
#if INCLUDE_PROPERTY_TOPIC_INTEREST

PROPERTY_TOPIC_INTEREST =  (property_t *) malloc(sizeof(property_t));
PROPERTY_TOPIC_INTEREST->name = strdup("http://xmlns.com/foaf/0.1/topic_interest");
PROPERTY_TOPIC_INTEREST->about = strdup("topic_interest");
//PROPERTY_TOPIC_INTEREST->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_TOPIC_INTEREST->domain = strdup("http://xmlns.com/foaf/0.1/Person"); 
PROPERTY_TOPIC_INTEREST->maxcardinality = -1;
PROPERTY_TOPIC_INTEREST->mincardinality = -1;
PROPERTY_TOPIC_INTEREST->subpropertyof = NULL;
PROPERTY_TOPIC_INTEREST->oneof = list_get_new_list();  
PROPERTY_TOPIC_INTEREST->rtti = RTTI_PROPERTY;
PROPERTY_TOPIC_INTEREST->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_TOPIC_INTEREST);

#endif
#if INCLUDE_PROPERTY_PASSWORD

PROPERTY_PASSWORD =  (property_t *) malloc(sizeof(property_t));
PROPERTY_PASSWORD->name = strdup("http://www.cs.karelia.ru/smartroom#password");
PROPERTY_PASSWORD->about = strdup("password");
//PROPERTY_PASSWORD->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_PASSWORD->domain = strdup("http://www.cs.karelia.ru/smartroom#Profile"); 
PROPERTY_PASSWORD->maxcardinality = -1;
PROPERTY_PASSWORD->mincardinality = -1;
PROPERTY_PASSWORD->subpropertyof = NULL;
PROPERTY_PASSWORD->oneof = list_get_new_list();  
PROPERTY_PASSWORD->rtti = RTTI_PROPERTY;
PROPERTY_PASSWORD->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_PASSWORD);

#endif
#if INCLUDE_PROPERTY_TIMESLOTTITLE

PROPERTY_TIMESLOTTITLE =  (property_t *) malloc(sizeof(property_t));
PROPERTY_TIMESLOTTITLE->name = strdup("http://www.cs.karelia.ru/smartroom#timeslotTitle");
PROPERTY_TIMESLOTTITLE->about = strdup("timeslotTitle");
//PROPERTY_TIMESLOTTITLE->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_TIMESLOTTITLE->domain = strdup("http://www.cs.karelia.ru/smartroom#Timeslot");
PROPERTY_TIMESLOTTITLE->maxcardinality = -1;
PROPERTY_TIMESLOTTITLE->mincardinality = -1;
PROPERTY_TIMESLOTTITLE->subpropertyof = NULL;
PROPERTY_TIMESLOTTITLE->oneof = list_get_new_list();
PROPERTY_TIMESLOTTITLE->rtti = RTTI_PROPERTY;
PROPERTY_TIMESLOTTITLE->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_TIMESLOTTITLE);

#endif
#if INCLUDE_PROPERTY_PHONE

PROPERTY_PHONE =  (property_t *) malloc(sizeof(property_t));
PROPERTY_PHONE->name = strdup("http://xmlns.com/foaf/0.1/phone");
PROPERTY_PHONE->about = strdup("phone");
//PROPERTY_PHONE->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_PHONE->domain = strdup("http://xmlns.com/foaf/0.1/Person"); 
PROPERTY_PHONE->maxcardinality = -1;
PROPERTY_PHONE->mincardinality = -1;
PROPERTY_PHONE->subpropertyof = NULL;
PROPERTY_PHONE->oneof = list_get_new_list();  
PROPERTY_PHONE->rtti = RTTI_PROPERTY;
PROPERTY_PHONE->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_PHONE);

#endif
#if INCLUDE_PROPERTY_STARTCONFERENCE

PROPERTY_STARTCONFERENCE =  (property_t *) malloc(sizeof(property_t));
PROPERTY_STARTCONFERENCE->name = strdup("http://www.cs.karelia.ru/smartroom#startConference");
PROPERTY_STARTCONFERENCE->about = strdup("startConference");
//PROPERTY_STARTCONFERENCE->range = "http://www.cs.karelia.ru/smartroom#Section"; //getRange
PROPERTY_STARTCONFERENCE->domain = strdup("-74525e9f:14633798e1a:-7ffd");
PROPERTY_STARTCONFERENCE->maxcardinality = -1;
PROPERTY_STARTCONFERENCE->mincardinality = -1;
PROPERTY_STARTCONFERENCE->subpropertyof = NULL;
PROPERTY_STARTCONFERENCE->oneof = list_get_new_list();  
PROPERTY_STARTCONFERENCE->rtti = RTTI_PROPERTY;
PROPERTY_STARTCONFERENCE->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_STARTCONFERENCE);

#endif
#if INCLUDE_PROPERTY_CURRENTSLIDECOUNT

PROPERTY_CURRENTSLIDECOUNT =  (property_t *) malloc(sizeof(property_t));
PROPERTY_CURRENTSLIDECOUNT->name = strdup("http://www.cs.karelia.ru/smartroom#currentSlideCount");
PROPERTY_CURRENTSLIDECOUNT->about = strdup("currentSlideCount");
//PROPERTY_CURRENTSLIDECOUNT->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_CURRENTSLIDECOUNT->domain = strdup("http://www.cs.karelia.ru/smartroom#PresentationService");
PROPERTY_CURRENTSLIDECOUNT->maxcardinality = -1;
PROPERTY_CURRENTSLIDECOUNT->mincardinality = -1;
PROPERTY_CURRENTSLIDECOUNT->subpropertyof = NULL;
PROPERTY_CURRENTSLIDECOUNT->oneof = list_get_new_list();  
PROPERTY_CURRENTSLIDECOUNT->rtti = RTTI_PROPERTY;
PROPERTY_CURRENTSLIDECOUNT->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_CURRENTSLIDECOUNT);

#endif
#if INCLUDE_PROPERTY_HASSERVICE

PROPERTY_HASSERVICE =  (property_t *) malloc(sizeof(property_t));
PROPERTY_HASSERVICE->name = strdup("http://www.cs.karelia.ru/smartroom#hasService");
PROPERTY_HASSERVICE->about = strdup("hasService");
//PROPERTY_HASSERVICE->range = "http://www.cs.karelia.ru/smartroom#Service"; //getRange
PROPERTY_HASSERVICE->domain = strdup("http://www.cs.karelia.ru/smartroom#SmartRoom"); 
PROPERTY_HASSERVICE->maxcardinality = -1;
PROPERTY_HASSERVICE->mincardinality = -1;
PROPERTY_HASSERVICE->subpropertyof = NULL;
PROPERTY_HASSERVICE->oneof = list_get_new_list();  
PROPERTY_HASSERVICE->rtti = RTTI_PROPERTY;
PROPERTY_HASSERVICE->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_HASSERVICE);

#endif
#if INCLUDE_PROPERTY_SECTIONTITLE

PROPERTY_SECTIONTITLE =  (property_t *) malloc(sizeof(property_t));
PROPERTY_SECTIONTITLE->name = strdup("http://www.cs.karelia.ru/smartroom#sectionTitle");
PROPERTY_SECTIONTITLE->about = strdup("sectionTitle");
//PROPERTY_SECTIONTITLE->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_SECTIONTITLE->domain = strdup("http://www.cs.karelia.ru/smartroom#Section");
PROPERTY_SECTIONTITLE->maxcardinality = -1;
PROPERTY_SECTIONTITLE->mincardinality = -1;
PROPERTY_SECTIONTITLE->subpropertyof = NULL;
PROPERTY_SECTIONTITLE->oneof = list_get_new_list();
PROPERTY_SECTIONTITLE->rtti = RTTI_PROPERTY;
PROPERTY_SECTIONTITLE->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_SECTIONTITLE);

#endif
#if INCLUDE_PROPERTY_SRPASSWORD

PROPERTY_SRPASSWORD =  (property_t *) malloc(sizeof(property_t));
PROPERTY_SRPASSWORD->name = strdup("http://www.cs.karelia.ru/smartroom#srPassword");
PROPERTY_SRPASSWORD->about = strdup("srPassword");
//PROPERTY_SRPASSWORD->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_SRPASSWORD->domain = strdup("http://www.cs.karelia.ru/smartroom#Blog");
PROPERTY_SRPASSWORD->maxcardinality = -1;
PROPERTY_SRPASSWORD->mincardinality = -1;
PROPERTY_SRPASSWORD->subpropertyof = NULL;
PROPERTY_SRPASSWORD->oneof = list_get_new_list();
PROPERTY_SRPASSWORD->rtti = RTTI_PROPERTY;
PROPERTY_SRPASSWORD->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_SRPASSWORD);

#endif
#if INCLUDE_PROPERTY_PERSONINFORMATION

PROPERTY_PERSONINFORMATION =  (property_t *) malloc(sizeof(property_t));
PROPERTY_PERSONINFORMATION->name = strdup("http://www.cs.karelia.ru/smartroom#personInformation");
PROPERTY_PERSONINFORMATION->about = strdup("personInformation");
//PROPERTY_PERSONINFORMATION->range = "http://xmlns.com/foaf/0.1/Person"; //getRange
PROPERTY_PERSONINFORMATION->domain = strdup("http://www.cs.karelia.ru/smartroom#Profile"); 
PROPERTY_PERSONINFORMATION->maxcardinality = -1;
PROPERTY_PERSONINFORMATION->mincardinality = -1;
PROPERTY_PERSONINFORMATION->subpropertyof = NULL;
PROPERTY_PERSONINFORMATION->oneof = list_get_new_list();  
PROPERTY_PERSONINFORMATION->rtti = RTTI_PROPERTY;
PROPERTY_PERSONINFORMATION->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_PERSONINFORMATION);

#endif
#if INCLUDE_PROPERTY_CURRENTSLIDEIMG

PROPERTY_CURRENTSLIDEIMG =  (property_t *) malloc(sizeof(property_t));
PROPERTY_CURRENTSLIDEIMG->name = strdup("http://www.cs.karelia.ru/smartroom#currentSlideImg");
PROPERTY_CURRENTSLIDEIMG->about = strdup("currentSlideImg");
//PROPERTY_CURRENTSLIDEIMG->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_CURRENTSLIDEIMG->domain = strdup("http://www.cs.karelia.ru/smartroom#PresentationService");
PROPERTY_CURRENTSLIDEIMG->maxcardinality = -1;
PROPERTY_CURRENTSLIDEIMG->mincardinality = -1;
PROPERTY_CURRENTSLIDEIMG->subpropertyof = NULL;
PROPERTY_CURRENTSLIDEIMG->oneof = list_get_new_list();  
PROPERTY_CURRENTSLIDEIMG->rtti = RTTI_PROPERTY;
PROPERTY_CURRENTSLIDEIMG->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_CURRENTSLIDEIMG);

#endif
#if INCLUDE_PROPERTY_NEXTTIMESLOT

PROPERTY_NEXTTIMESLOT =  (property_t *) malloc(sizeof(property_t));
PROPERTY_NEXTTIMESLOT->name = strdup("http://www.cs.karelia.ru/smartroom#nextTimeslot");
PROPERTY_NEXTTIMESLOT->about = strdup("nextTimeslot");
//PROPERTY_NEXTTIMESLOT->range = "http://www.cs.karelia.ru/smartroom#Timeslot"; //getRange
PROPERTY_NEXTTIMESLOT->domain = strdup("http://www.cs.karelia.ru/smartroom#Timeslot");
PROPERTY_NEXTTIMESLOT->maxcardinality = -1;
PROPERTY_NEXTTIMESLOT->mincardinality = -1;
PROPERTY_NEXTTIMESLOT->subpropertyof = NULL;
PROPERTY_NEXTTIMESLOT->oneof = list_get_new_list();
PROPERTY_NEXTTIMESLOT->rtti = RTTI_PROPERTY;
PROPERTY_NEXTTIMESLOT->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_NEXTTIMESLOT);

#endif
#if INCLUDE_PROPERTY_TIMESLOTSPEAKERNAME

PROPERTY_TIMESLOTSPEAKERNAME =  (property_t *) malloc(sizeof(property_t));
PROPERTY_TIMESLOTSPEAKERNAME->name = strdup("http://www.cs.karelia.ru/smartroom#timeslotSpeakerName");
PROPERTY_TIMESLOTSPEAKERNAME->about = strdup("timeslotSpeakerName");
//PROPERTY_TIMESLOTSPEAKERNAME->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_TIMESLOTSPEAKERNAME->domain = strdup("http://www.cs.karelia.ru/smartroom#Timeslot");
PROPERTY_TIMESLOTSPEAKERNAME->maxcardinality = -1;
PROPERTY_TIMESLOTSPEAKERNAME->mincardinality = -1;
PROPERTY_TIMESLOTSPEAKERNAME->subpropertyof = NULL;
PROPERTY_TIMESLOTSPEAKERNAME->oneof = list_get_new_list();
PROPERTY_TIMESLOTSPEAKERNAME->rtti = RTTI_PROPERTY;
PROPERTY_TIMESLOTSPEAKERNAME->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_TIMESLOTSPEAKERNAME);

#endif
#if INCLUDE_PROPERTY_SRLOGIN

PROPERTY_SRLOGIN =  (property_t *) malloc(sizeof(property_t));
PROPERTY_SRLOGIN->name = strdup("http://www.cs.karelia.ru/smartroom#srLogin");
PROPERTY_SRLOGIN->about = strdup("srLogin");
//PROPERTY_SRLOGIN->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_SRLOGIN->domain = strdup("http://www.cs.karelia.ru/smartroom#Blog");
PROPERTY_SRLOGIN->maxcardinality = -1;
PROPERTY_SRLOGIN->mincardinality = -1;
PROPERTY_SRLOGIN->subpropertyof = NULL;
PROPERTY_SRLOGIN->oneof = list_get_new_list();
PROPERTY_SRLOGIN->rtti = RTTI_PROPERTY;
PROPERTY_SRLOGIN->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_SRLOGIN);

#endif
#if INCLUDE_PROPERTY_PRESENTATIONTITLE

PROPERTY_PRESENTATIONTITLE =  (property_t *) malloc(sizeof(property_t));
PROPERTY_PRESENTATIONTITLE->name = strdup("http://www.cs.karelia.ru/smartroom#presentationTitle");
PROPERTY_PRESENTATIONTITLE->about = strdup("presentationTitle");
//PROPERTY_PRESENTATIONTITLE->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_PRESENTATIONTITLE->domain = strdup("http://www.cs.karelia.ru/smartroom#Presentation");
PROPERTY_PRESENTATIONTITLE->maxcardinality = -1;
PROPERTY_PRESENTATIONTITLE->mincardinality = -1;
PROPERTY_PRESENTATIONTITLE->subpropertyof = NULL;
PROPERTY_PRESENTATIONTITLE->oneof = list_get_new_list();  
PROPERTY_PRESENTATIONTITLE->rtti = RTTI_PROPERTY;
PROPERTY_PRESENTATIONTITLE->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_PRESENTATIONTITLE);

#endif
#if INCLUDE_PROPERTY_THEMEID

PROPERTY_THEMEID =  (property_t *) malloc(sizeof(property_t));
PROPERTY_THEMEID->name = strdup("http://www.cs.karelia.ru/smartroom#themeId");
PROPERTY_THEMEID->about = strdup("themeId");
//PROPERTY_THEMEID->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_THEMEID->domain = strdup("http://www.cs.karelia.ru/smartroom#Theme");
PROPERTY_THEMEID->maxcardinality = -1;
PROPERTY_THEMEID->mincardinality = -1;
PROPERTY_THEMEID->subpropertyof = NULL;
PROPERTY_THEMEID->oneof = list_get_new_list();
PROPERTY_THEMEID->rtti = RTTI_PROPERTY;
PROPERTY_THEMEID->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_THEMEID);

#endif
#if INCLUDE_PROPERTY_HASSECTION

PROPERTY_HASSECTION =  (property_t *) malloc(sizeof(property_t));
PROPERTY_HASSECTION->name = strdup("http://www.cs.karelia.ru/smartroom#hasSection");
PROPERTY_HASSECTION->about = strdup("hasSection");
//PROPERTY_HASSECTION->range = "http://www.cs.karelia.ru/smartroom#Section"; //getRange
PROPERTY_HASSECTION->domain = strdup("http://www.cs.karelia.ru/smartroom#Activity");
PROPERTY_HASSECTION->maxcardinality = -1;
PROPERTY_HASSECTION->mincardinality = -1;
PROPERTY_HASSECTION->subpropertyof = NULL;
PROPERTY_HASSECTION->oneof = list_get_new_list();  
PROPERTY_HASSECTION->rtti = RTTI_PROPERTY;
PROPERTY_HASSECTION->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_HASSECTION);

#endif
#if INCLUDE_PROPERTY_FIRSTTIMESLOT

PROPERTY_FIRSTTIMESLOT =  (property_t *) malloc(sizeof(property_t));
PROPERTY_FIRSTTIMESLOT->name = strdup("http://www.cs.karelia.ru/smartroom#firstTimeslot");
PROPERTY_FIRSTTIMESLOT->about = strdup("firstTimeslot");
//PROPERTY_FIRSTTIMESLOT->range = "http://www.cs.karelia.ru/smartroom#Timeslot"; //getRange
PROPERTY_FIRSTTIMESLOT->domain = strdup("http://www.cs.karelia.ru/smartroom#Section");
PROPERTY_FIRSTTIMESLOT->maxcardinality = -1;
PROPERTY_FIRSTTIMESLOT->mincardinality = -1;
PROPERTY_FIRSTTIMESLOT->subpropertyof = NULL;
PROPERTY_FIRSTTIMESLOT->oneof = list_get_new_list();
PROPERTY_FIRSTTIMESLOT->rtti = RTTI_PROPERTY;
PROPERTY_FIRSTTIMESLOT->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_FIRSTTIMESLOT);

#endif
#if INCLUDE_PROPERTY_SERVICENAME

PROPERTY_SERVICENAME =  (property_t *) malloc(sizeof(property_t));
PROPERTY_SERVICENAME->name = strdup("http://www.cs.karelia.ru/smartroom#serviceName");
PROPERTY_SERVICENAME->about = strdup("serviceName");
//PROPERTY_SERVICENAME->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_SERVICENAME->domain = strdup("http://www.cs.karelia.ru/smartroom#Service"); 
PROPERTY_SERVICENAME->maxcardinality = -1;
PROPERTY_SERVICENAME->mincardinality = -1;
PROPERTY_SERVICENAME->subpropertyof = NULL;
PROPERTY_SERVICENAME->oneof = list_get_new_list();  
PROPERTY_SERVICENAME->rtti = RTTI_PROPERTY;
PROPERTY_SERVICENAME->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_SERVICENAME);

#endif
#if INCLUDE_PROPERTY_NAME

PROPERTY_NAME =  (property_t *) malloc(sizeof(property_t));
PROPERTY_NAME->name = strdup("http://xmlns.com/foaf/0.1/name");
PROPERTY_NAME->about = strdup("name");
//PROPERTY_NAME->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_NAME->domain = strdup("http://xmlns.com/foaf/0.1/Person"); 
PROPERTY_NAME->maxcardinality = -1;
PROPERTY_NAME->mincardinality = -1;
PROPERTY_NAME->subpropertyof = NULL;
PROPERTY_NAME->oneof = list_get_new_list();  
PROPERTY_NAME->rtti = RTTI_PROPERTY;
PROPERTY_NAME->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_NAME);

#endif
#if INCLUDE_PROPERTY_PRESENTATIONTAGS

PROPERTY_PRESENTATIONTAGS =  (property_t *) malloc(sizeof(property_t));
PROPERTY_PRESENTATIONTAGS->name = strdup("http://www.cs.karelia.ru/smartroom#presentationTags");
PROPERTY_PRESENTATIONTAGS->about = strdup("presentationTags");
//PROPERTY_PRESENTATIONTAGS->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_PRESENTATIONTAGS->domain = strdup("http://www.cs.karelia.ru/smartroom#Presentation");
PROPERTY_PRESENTATIONTAGS->maxcardinality = -1;
PROPERTY_PRESENTATIONTAGS->mincardinality = -1;
PROPERTY_PRESENTATIONTAGS->subpropertyof = NULL;
PROPERTY_PRESENTATIONTAGS->oneof = list_get_new_list();
PROPERTY_PRESENTATIONTAGS->rtti = RTTI_PROPERTY;
PROPERTY_PRESENTATIONTAGS->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_PRESENTATIONTAGS);

#endif
#if INCLUDE_PROPERTY_STARTPRESENTATION

PROPERTY_STARTPRESENTATION =  (property_t *) malloc(sizeof(property_t));
PROPERTY_STARTPRESENTATION->name = strdup("http://www.cs.karelia.ru/smartroom#startPresentation");
PROPERTY_STARTPRESENTATION->about = strdup("startPresentation");
//PROPERTY_STARTPRESENTATION->range = "http://www.cs.karelia.ru/smartroom#Presentation"; //getRange
PROPERTY_STARTPRESENTATION->domain = strdup("-74525e9f:14633798e1a:-7ffa");
PROPERTY_STARTPRESENTATION->maxcardinality = -1;
PROPERTY_STARTPRESENTATION->mincardinality = -1;
PROPERTY_STARTPRESENTATION->subpropertyof = NULL;
PROPERTY_STARTPRESENTATION->oneof = list_get_new_list();  
PROPERTY_STARTPRESENTATION->rtti = RTTI_PROPERTY;
PROPERTY_STARTPRESENTATION->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_STARTPRESENTATION);

#endif
#if INCLUDE_PROPERTY_CURRENTTIMESLOT

PROPERTY_CURRENTTIMESLOT =  (property_t *) malloc(sizeof(property_t));
PROPERTY_CURRENTTIMESLOT->name = strdup("http://www.cs.karelia.ru/smartroom#currentTimeslot");
PROPERTY_CURRENTTIMESLOT->about = strdup("currentTimeslot");
//PROPERTY_CURRENTTIMESLOT->range = "http://www.cs.karelia.ru/smartroom#Timeslot"; //getRange
PROPERTY_CURRENTTIMESLOT->domain = strdup("http://www.cs.karelia.ru/smartroom#Section");
PROPERTY_CURRENTTIMESLOT->maxcardinality = -1;
PROPERTY_CURRENTTIMESLOT->mincardinality = -1;
PROPERTY_CURRENTTIMESLOT->subpropertyof = NULL;
PROPERTY_CURRENTTIMESLOT->oneof = list_get_new_list();
PROPERTY_CURRENTTIMESLOT->rtti = RTTI_PROPERTY;
PROPERTY_CURRENTTIMESLOT->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_CURRENTTIMESLOT);

#endif
#if INCLUDE_PROPERTY_SHOWSLIDE

PROPERTY_SHOWSLIDE =  (property_t *) malloc(sizeof(property_t));
PROPERTY_SHOWSLIDE->name = strdup("http://www.cs.karelia.ru/smartroom#showSlide");
PROPERTY_SHOWSLIDE->about = strdup("showSlide");
//PROPERTY_SHOWSLIDE->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_SHOWSLIDE->domain = strdup("http://www.cs.karelia.ru/smartroom#PresentationNotification");
PROPERTY_SHOWSLIDE->maxcardinality = -1;
PROPERTY_SHOWSLIDE->mincardinality = -1;
PROPERTY_SHOWSLIDE->subpropertyof = NULL;
PROPERTY_SHOWSLIDE->oneof = list_get_new_list();  
PROPERTY_SHOWSLIDE->rtti = RTTI_PROPERTY;
PROPERTY_SHOWSLIDE->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_SHOWSLIDE);

#endif
#if INCLUDE_PROPERTY_UPDATEPRESENTATION

PROPERTY_UPDATEPRESENTATION =  (property_t *) malloc(sizeof(property_t));
PROPERTY_UPDATEPRESENTATION->name = strdup("http://www.cs.karelia.ru/smartroom#updatePresentation");
PROPERTY_UPDATEPRESENTATION->about = strdup("updatePresentation");
//PROPERTY_UPDATEPRESENTATION->range = "http://www.cs.karelia.ru/smartroom#Presentation"; //getRange
PROPERTY_UPDATEPRESENTATION->domain = strdup("http://www.cs.karelia.ru/smartroom#PresentationNotification");
PROPERTY_UPDATEPRESENTATION->maxcardinality = -1;
PROPERTY_UPDATEPRESENTATION->mincardinality = -1;
PROPERTY_UPDATEPRESENTATION->subpropertyof = NULL;
PROPERTY_UPDATEPRESENTATION->oneof = list_get_new_list();  
PROPERTY_UPDATEPRESENTATION->rtti = RTTI_PROPERTY;
PROPERTY_UPDATEPRESENTATION->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_UPDATEPRESENTATION);

#endif
#if INCLUDE_PROPERTY_ENDCONFERENCE

PROPERTY_ENDCONFERENCE =  (property_t *) malloc(sizeof(property_t));
PROPERTY_ENDCONFERENCE->name = strdup("http://www.cs.karelia.ru/smartroom#endConference");
PROPERTY_ENDCONFERENCE->about = strdup("endConference");
//PROPERTY_ENDCONFERENCE->range = "http://www.cs.karelia.ru/smartroom#Section"; //getRange
PROPERTY_ENDCONFERENCE->domain = strdup("http://www.cs.karelia.ru/smartroom#ConferenceNotification");
PROPERTY_ENDCONFERENCE->maxcardinality = -1;
PROPERTY_ENDCONFERENCE->mincardinality = -1;
PROPERTY_ENDCONFERENCE->subpropertyof = NULL;
PROPERTY_ENDCONFERENCE->oneof = list_get_new_list();  
PROPERTY_ENDCONFERENCE->rtti = RTTI_PROPERTY;
PROPERTY_ENDCONFERENCE->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_ENDCONFERENCE);

#endif
#if INCLUDE_PROPERTY_SERVICEDESCRIPTION

PROPERTY_SERVICEDESCRIPTION =  (property_t *) malloc(sizeof(property_t));
PROPERTY_SERVICEDESCRIPTION->name = strdup("http://www.cs.karelia.ru/smartroom#serviceDescription");
PROPERTY_SERVICEDESCRIPTION->about = strdup("serviceDescription");
//PROPERTY_SERVICEDESCRIPTION->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_SERVICEDESCRIPTION->domain = strdup("http://www.cs.karelia.ru/smartroom#Service");
PROPERTY_SERVICEDESCRIPTION->maxcardinality = -1;
PROPERTY_SERVICEDESCRIPTION->mincardinality = -1;
PROPERTY_SERVICEDESCRIPTION->subpropertyof = NULL;
PROPERTY_SERVICEDESCRIPTION->oneof = list_get_new_list();
PROPERTY_SERVICEDESCRIPTION->rtti = RTTI_PROPERTY;
PROPERTY_SERVICEDESCRIPTION->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_SERVICEDESCRIPTION);

#endif
#if INCLUDE_PROPERTY_TIMESLOTPERSON

PROPERTY_TIMESLOTPERSON =  (property_t *) malloc(sizeof(property_t));
PROPERTY_TIMESLOTPERSON->name = strdup("http://www.cs.karelia.ru/smartroom#timeslotPerson");
PROPERTY_TIMESLOTPERSON->about = strdup("timeslotPerson");
//PROPERTY_TIMESLOTPERSON->range = "http://xmlns.com/foaf/0.1/Person"; //getRange
PROPERTY_TIMESLOTPERSON->domain = strdup("http://www.cs.karelia.ru/smartroom#Timeslot");
PROPERTY_TIMESLOTPERSON->maxcardinality = -1;
PROPERTY_TIMESLOTPERSON->mincardinality = -1;
PROPERTY_TIMESLOTPERSON->subpropertyof = NULL;
PROPERTY_TIMESLOTPERSON->oneof = list_get_new_list();
PROPERTY_TIMESLOTPERSON->rtti = RTTI_PROPERTY;
PROPERTY_TIMESLOTPERSON->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_TIMESLOTPERSON);

#endif
#if INCLUDE_PROPERTY_THEMESTATUS

PROPERTY_THEMESTATUS =  (property_t *) malloc(sizeof(property_t));
PROPERTY_THEMESTATUS->name = strdup("http://www.cs.karelia.ru/smartroom#themeStatus");
PROPERTY_THEMESTATUS->about = strdup("themeStatus");
//PROPERTY_THEMESTATUS->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_THEMESTATUS->domain = strdup("http://www.cs.karelia.ru/smartroom#Theme");
PROPERTY_THEMESTATUS->maxcardinality = -1;
PROPERTY_THEMESTATUS->mincardinality = -1;
PROPERTY_THEMESTATUS->subpropertyof = NULL;
PROPERTY_THEMESTATUS->oneof = list_get_new_list();
PROPERTY_THEMESTATUS->rtti = RTTI_PROPERTY;
PROPERTY_THEMESTATUS->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_THEMESTATUS);

#endif
#if INCLUDE_PROPERTY_STATUS

PROPERTY_STATUS =  (property_t *) malloc(sizeof(property_t));
PROPERTY_STATUS->name = strdup("http://xmlns.com/foaf/0.1/status");
PROPERTY_STATUS->about = strdup("status");
//PROPERTY_STATUS->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_STATUS->domain = strdup("http://xmlns.com/foaf/0.1/Person"); 
PROPERTY_STATUS->maxcardinality = -1;
PROPERTY_STATUS->mincardinality = -1;
PROPERTY_STATUS->subpropertyof = NULL;
PROPERTY_STATUS->oneof = list_get_new_list();  
PROPERTY_STATUS->rtti = RTTI_PROPERTY;
PROPERTY_STATUS->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_STATUS);

#endif
#if INCLUDE_PROPERTY_TIMESLOTPRESENTATION

PROPERTY_TIMESLOTPRESENTATION =  (property_t *) malloc(sizeof(property_t));
PROPERTY_TIMESLOTPRESENTATION->name = strdup("http://www.cs.karelia.ru/smartroom#timeslotPresentation");
PROPERTY_TIMESLOTPRESENTATION->about = strdup("timeslotPresentation");
//PROPERTY_TIMESLOTPRESENTATION->range = "http://www.cs.karelia.ru/smartroom#Presentation"; //getRange
PROPERTY_TIMESLOTPRESENTATION->domain = strdup("http://www.cs.karelia.ru/smartroom#Timeslot");
PROPERTY_TIMESLOTPRESENTATION->maxcardinality = -1;
PROPERTY_TIMESLOTPRESENTATION->mincardinality = -1;
PROPERTY_TIMESLOTPRESENTATION->subpropertyof = NULL;
PROPERTY_TIMESLOTPRESENTATION->oneof = list_get_new_list();
PROPERTY_TIMESLOTPRESENTATION->rtti = RTTI_PROPERTY;
PROPERTY_TIMESLOTPRESENTATION->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_TIMESLOTPRESENTATION);

#endif
#if INCLUDE_PROPERTY_WLANMAC

PROPERTY_WLANMAC =  (property_t *) malloc(sizeof(property_t));
PROPERTY_WLANMAC->name = strdup("http://www.cs.karelia.ru/smartroom#wlanmac");
PROPERTY_WLANMAC->about = strdup("wlanmac");
//PROPERTY_WLANMAC->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_WLANMAC->domain = strdup("http://xmlns.com/foaf/0.1/Person");
PROPERTY_WLANMAC->maxcardinality = -1;
PROPERTY_WLANMAC->mincardinality = -1;
PROPERTY_WLANMAC->subpropertyof = NULL;
PROPERTY_WLANMAC->oneof = list_get_new_list();
PROPERTY_WLANMAC->rtti = RTTI_PROPERTY;
PROPERTY_WLANMAC->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_WLANMAC);

#endif
#if INCLUDE_PROPERTY_ACCOUNT

PROPERTY_ACCOUNT =  (property_t *) malloc(sizeof(property_t));
PROPERTY_ACCOUNT->name = strdup("http://xmlns.com/foaf/0.1/account");
PROPERTY_ACCOUNT->about = strdup("account");
//PROPERTY_ACCOUNT->range = "http://xmlns.com/foaf/0.1/OnlineAccount"; //getRange
PROPERTY_ACCOUNT->domain = strdup("http://xmlns.com/foaf/0.1/Person"); 
PROPERTY_ACCOUNT->maxcardinality = -1;
PROPERTY_ACCOUNT->mincardinality = -1;
PROPERTY_ACCOUNT->subpropertyof = NULL;
PROPERTY_ACCOUNT->oneof = list_get_new_list();  
PROPERTY_ACCOUNT->rtti = RTTI_PROPERTY;
PROPERTY_ACCOUNT->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_ACCOUNT);

#endif
#if INCLUDE_PROPERTY_TIMESLOTDURATION

PROPERTY_TIMESLOTDURATION =  (property_t *) malloc(sizeof(property_t));
PROPERTY_TIMESLOTDURATION->name = strdup("http://www.cs.karelia.ru/smartroom#timeslotDuration");
PROPERTY_TIMESLOTDURATION->about = strdup("timeslotDuration");
//PROPERTY_TIMESLOTDURATION->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_TIMESLOTDURATION->domain = strdup("http://www.cs.karelia.ru/smartroom#Timeslot");
PROPERTY_TIMESLOTDURATION->maxcardinality = -1;
PROPERTY_TIMESLOTDURATION->mincardinality = -1;
PROPERTY_TIMESLOTDURATION->subpropertyof = NULL;
PROPERTY_TIMESLOTDURATION->oneof = list_get_new_list();
PROPERTY_TIMESLOTDURATION->rtti = RTTI_PROPERTY;
PROPERTY_TIMESLOTDURATION->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_TIMESLOTDURATION);

#endif
#if INCLUDE_PROPERTY_SECTIONDATE

PROPERTY_SECTIONDATE =  (property_t *) malloc(sizeof(property_t));
PROPERTY_SECTIONDATE->name = strdup("http://www.cs.karelia.ru/smartroom#sectionDate");
PROPERTY_SECTIONDATE->about = strdup("sectionDate");
//PROPERTY_SECTIONDATE->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_SECTIONDATE->domain = strdup("http://www.cs.karelia.ru/smartroom#Section");
PROPERTY_SECTIONDATE->maxcardinality = -1;
PROPERTY_SECTIONDATE->mincardinality = -1;
PROPERTY_SECTIONDATE->subpropertyof = NULL;
PROPERTY_SECTIONDATE->oneof = list_get_new_list();
PROPERTY_SECTIONDATE->rtti = RTTI_PROPERTY;
PROPERTY_SECTIONDATE->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_SECTIONDATE);

#endif
#if INCLUDE_PROPERTY_AGE

PROPERTY_AGE =  (property_t *) malloc(sizeof(property_t));
PROPERTY_AGE->name = strdup("http://xmlns.com/foaf/0.1/age");
PROPERTY_AGE->about = strdup("age");
//PROPERTY_AGE->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_AGE->domain = strdup("http://xmlns.com/foaf/0.1/Person"); 
PROPERTY_AGE->maxcardinality = -1;
PROPERTY_AGE->mincardinality = -1;
PROPERTY_AGE->subpropertyof = NULL;
PROPERTY_AGE->oneof = list_get_new_list();  
PROPERTY_AGE->rtti = RTTI_PROPERTY;
PROPERTY_AGE->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_AGE);

#endif
#if INCLUDE_PROPERTY_UPDATEAGENDA

PROPERTY_UPDATEAGENDA =  (property_t *) malloc(sizeof(property_t));
PROPERTY_UPDATEAGENDA->name = strdup("http://www.cs.karelia.ru/smartroom#updateAgenda");
PROPERTY_UPDATEAGENDA->about = strdup("updateAgenda");
//PROPERTY_UPDATEAGENDA->range = "http://www.cs.karelia.ru/smartroom#Section"; //getRange
PROPERTY_UPDATEAGENDA->domain = strdup(""); 
PROPERTY_UPDATEAGENDA->maxcardinality = -1;
PROPERTY_UPDATEAGENDA->mincardinality = -1;
PROPERTY_UPDATEAGENDA->subpropertyof = NULL;
PROPERTY_UPDATEAGENDA->oneof = list_get_new_list();  
PROPERTY_UPDATEAGENDA->rtti = RTTI_PROPERTY;
PROPERTY_UPDATEAGENDA->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_UPDATEAGENDA);

#endif
#if INCLUDE_PROPERTY_IMG

PROPERTY_IMG =  (property_t *) malloc(sizeof(property_t));
PROPERTY_IMG->name = strdup("http://xmlns.com/foaf/0.1/img");
PROPERTY_IMG->about = strdup("img");
//PROPERTY_IMG->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_IMG->domain = strdup("http://xmlns.com/foaf/0.1/Person"); 
PROPERTY_IMG->maxcardinality = -1;
PROPERTY_IMG->mincardinality = -1;
PROPERTY_IMG->subpropertyof = NULL;
PROPERTY_IMG->oneof = list_get_new_list();  
PROPERTY_IMG->rtti = RTTI_PROPERTY;
PROPERTY_IMG->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_IMG);

#endif
#if INCLUDE_PROPERTY_LANGUAGE

PROPERTY_LANGUAGE =  (property_t *) malloc(sizeof(property_t));
PROPERTY_LANGUAGE->name = strdup("http://www.cs.karelia.ru/smartroom#language");
PROPERTY_LANGUAGE->about = strdup("language");
//PROPERTY_LANGUAGE->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_LANGUAGE->domain = strdup("http://xmlns.com/foaf/0.1/Person"); 
PROPERTY_LANGUAGE->maxcardinality = -1;
PROPERTY_LANGUAGE->mincardinality = -1;
PROPERTY_LANGUAGE->subpropertyof = NULL;
PROPERTY_LANGUAGE->oneof = list_get_new_list();  
PROPERTY_LANGUAGE->rtti = RTTI_PROPERTY;
PROPERTY_LANGUAGE->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_LANGUAGE);

#endif
#if INCLUDE_PROPERTY_HASPRESENTATION

PROPERTY_HASPRESENTATION =  (property_t *) malloc(sizeof(property_t));
PROPERTY_HASPRESENTATION->name = strdup("http://www.cs.karelia.ru/smartroom#hasPresentation");
PROPERTY_HASPRESENTATION->about = strdup("hasPresentation");
//PROPERTY_HASPRESENTATION->range = "http://www.cs.karelia.ru/smartroom#Presentation"; //getRange
PROPERTY_HASPRESENTATION->domain = strdup("http://xmlns.com/foaf/0.1/Person");
PROPERTY_HASPRESENTATION->maxcardinality = -1;
PROPERTY_HASPRESENTATION->mincardinality = -1;
PROPERTY_HASPRESENTATION->subpropertyof = NULL;
PROPERTY_HASPRESENTATION->oneof = list_get_new_list();
PROPERTY_HASPRESENTATION->rtti = RTTI_PROPERTY;
PROPERTY_HASPRESENTATION->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_HASPRESENTATION);

#endif
#if INCLUDE_PROPERTY_CURRENTPRESENTATION

PROPERTY_CURRENTPRESENTATION =  (property_t *) malloc(sizeof(property_t));
PROPERTY_CURRENTPRESENTATION->name = strdup("http://www.cs.karelia.ru/smartroom#currentPresentation");
PROPERTY_CURRENTPRESENTATION->about = strdup("currentPresentation");
//PROPERTY_CURRENTPRESENTATION->range = "http://www.cs.karelia.ru/smartroom#Presentation"; //getRange
PROPERTY_CURRENTPRESENTATION->domain = strdup("http://www.cs.karelia.ru/smartroom#PresentationService");
PROPERTY_CURRENTPRESENTATION->maxcardinality = -1;
PROPERTY_CURRENTPRESENTATION->mincardinality = -1;
PROPERTY_CURRENTPRESENTATION->subpropertyof = NULL;
PROPERTY_CURRENTPRESENTATION->oneof = list_get_new_list();  
PROPERTY_CURRENTPRESENTATION->rtti = RTTI_PROPERTY;
PROPERTY_CURRENTPRESENTATION->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_CURRENTPRESENTATION);

#endif
#if INCLUDE_PROPERTY_HASCONTEXT

PROPERTY_HASCONTEXT =  (property_t *) malloc(sizeof(property_t));
PROPERTY_HASCONTEXT->name = strdup("http://www.cs.karelia.ru/smartroom#hasContext");
PROPERTY_HASCONTEXT->about = strdup("hasContext");
//PROPERTY_HASCONTEXT->range = "http://www.cs.karelia.ru/smartroom#Context"; //getRange
PROPERTY_HASCONTEXT->domain = strdup("http://www.cs.karelia.ru/smartroom#Profile"); 
PROPERTY_HASCONTEXT->maxcardinality = -1;
PROPERTY_HASCONTEXT->mincardinality = -1;
PROPERTY_HASCONTEXT->subpropertyof = NULL;
PROPERTY_HASCONTEXT->oneof = list_get_new_list();  
PROPERTY_HASCONTEXT->rtti = RTTI_PROPERTY;
PROPERTY_HASCONTEXT->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_HASCONTEXT);

#endif
#if INCLUDE_PROPERTY_STARTCONFERENCEFROM

PROPERTY_STARTCONFERENCEFROM =  (property_t *) malloc(sizeof(property_t));
PROPERTY_STARTCONFERENCEFROM->name = strdup("http://www.cs.karelia.ru/smartroom#startConferenceFrom");
PROPERTY_STARTCONFERENCEFROM->about = strdup("startConferenceFrom");
//PROPERTY_STARTCONFERENCEFROM->range = "http://www.cs.karelia.ru/smartroom#Timeslot"; //getRange
PROPERTY_STARTCONFERENCEFROM->domain = strdup("http://www.cs.karelia.ru/smartroom#ConferenceNotification");
PROPERTY_STARTCONFERENCEFROM->maxcardinality = -1;
PROPERTY_STARTCONFERENCEFROM->mincardinality = -1;
PROPERTY_STARTCONFERENCEFROM->subpropertyof = NULL;
PROPERTY_STARTCONFERENCEFROM->oneof = list_get_new_list();  
PROPERTY_STARTCONFERENCEFROM->rtti = RTTI_PROPERTY;
PROPERTY_STARTCONFERENCEFROM->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_STARTCONFERENCEFROM);

#endif
#if INCLUDE_PROPERTY_SERVICESTATUS

PROPERTY_SERVICESTATUS =  (property_t *) malloc(sizeof(property_t));
PROPERTY_SERVICESTATUS->name = strdup("http://www.cs.karelia.ru/smartroom#serviceStatus");
PROPERTY_SERVICESTATUS->about = strdup("serviceStatus");
//PROPERTY_SERVICESTATUS->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_SERVICESTATUS->domain = strdup("http://www.cs.karelia.ru/smartroom#Service");
PROPERTY_SERVICESTATUS->maxcardinality = -1;
PROPERTY_SERVICESTATUS->mincardinality = -1;
PROPERTY_SERVICESTATUS->subpropertyof = NULL;
PROPERTY_SERVICESTATUS->oneof = list_get_new_list();
PROPERTY_SERVICESTATUS->rtti = RTTI_PROPERTY;
PROPERTY_SERVICESTATUS->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_SERVICESTATUS);

#endif
#if INCLUDE_PROPERTY_CURRENTSECTION

PROPERTY_CURRENTSECTION =  (property_t *) malloc(sizeof(property_t));
PROPERTY_CURRENTSECTION->name = strdup("http://www.cs.karelia.ru/smartroom#currentSection");
PROPERTY_CURRENTSECTION->about = strdup("currentSection");
//PROPERTY_CURRENTSECTION->range = "http://www.cs.karelia.ru/smartroom#Section"; //getRange
PROPERTY_CURRENTSECTION->domain = strdup("http://www.cs.karelia.ru/smartroom#ConferenceService");
PROPERTY_CURRENTSECTION->maxcardinality = -1;
PROPERTY_CURRENTSECTION->mincardinality = -1;
PROPERTY_CURRENTSECTION->subpropertyof = NULL;
PROPERTY_CURRENTSECTION->oneof = list_get_new_list();
PROPERTY_CURRENTSECTION->rtti = RTTI_PROPERTY;
PROPERTY_CURRENTSECTION->type = OBJECTPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_CURRENTSECTION);

#endif




#if INCLUDE_CLASS_TIMESLOT

CLASS_TIMESLOT = (class_t *) malloc(sizeof(class_t));
CLASS_TIMESLOT->rtti = RTTI_CLASS;
CLASS_TIMESLOT->classtype =  strdup("http://www.cs.karelia.ru/smartroom#Timeslot");
CLASS_TIMESLOT->properties = list_get_new_list();
CLASS_TIMESLOT->instances = NULL;
CLASS_TIMESLOT->superclasses = list_get_new_list();
CLASS_TIMESLOT->oneof = list_get_new_list();

sslog_repo_add_entity((void *) CLASS_TIMESLOT);

#if INCLUDE_PROPERTY_TIMESLOTPERSON
tmp_node = list_get_new_node(PROPERTY_TIMESLOTPERSON);
list_add_node(tmp_node, CLASS_TIMESLOT->properties);
#endif
#if INCLUDE_PROPERTY_TIMESLOTTITLE
tmp_node = list_get_new_node(PROPERTY_TIMESLOTTITLE);
list_add_node(tmp_node, CLASS_TIMESLOT->properties);
#endif
#if INCLUDE_PROPERTY_TIMESLOTPRESENTATION
tmp_node = list_get_new_node(PROPERTY_TIMESLOTPRESENTATION);
list_add_node(tmp_node, CLASS_TIMESLOT->properties);
#endif
#if INCLUDE_PROPERTY_TIMESLOTDURATION
tmp_node = list_get_new_node(PROPERTY_TIMESLOTDURATION);
list_add_node(tmp_node, CLASS_TIMESLOT->properties);
#endif
#if INCLUDE_PROPERTY_TIMESLOTACTUALDURATION
tmp_node = list_get_new_node(PROPERTY_TIMESLOTACTUALDURATION);
list_add_node(tmp_node, CLASS_TIMESLOT->properties);
#endif
#if INCLUDE_PROPERTY_NEXTTIMESLOT
tmp_node = list_get_new_node(PROPERTY_NEXTTIMESLOT);
list_add_node(tmp_node, CLASS_TIMESLOT->properties);
#endif
#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_TIMESLOT->properties);
#endif
#if INCLUDE_PROPERTY_TIMESLOTSPEAKERNAME
tmp_node = list_get_new_node(PROPERTY_TIMESLOTSPEAKERNAME);
list_add_node(tmp_node, CLASS_TIMESLOT->properties);
#endif

#endif
#if INCLUDE_CLASS_PROFILE

CLASS_PROFILE = (class_t *) malloc(sizeof(class_t));
CLASS_PROFILE->rtti = RTTI_CLASS;
CLASS_PROFILE->classtype =  strdup("http://www.cs.karelia.ru/smartroom#Profile");
CLASS_PROFILE->properties = list_get_new_list();  
CLASS_PROFILE->instances = NULL;
CLASS_PROFILE->superclasses = list_get_new_list();  
CLASS_PROFILE->oneof = list_get_new_list();  

sslog_repo_add_entity((void *) CLASS_PROFILE);

#if INCLUDE_PROPERTY_USERNAME
tmp_node = list_get_new_node(PROPERTY_USERNAME);
list_add_node(tmp_node, CLASS_PROFILE->properties);
#endif
#if INCLUDE_PROPERTY_HASCONTEXT
tmp_node = list_get_new_node(PROPERTY_HASCONTEXT);
list_add_node(tmp_node, CLASS_PROFILE->properties);
#endif
#if INCLUDE_PROPERTY_PERSONINFORMATION
tmp_node = list_get_new_node(PROPERTY_PERSONINFORMATION);
list_add_node(tmp_node, CLASS_PROFILE->properties);
#endif
#if INCLUDE_PROPERTY_PASSWORD
tmp_node = list_get_new_node(PROPERTY_PASSWORD);
list_add_node(tmp_node, CLASS_PROFILE->properties);
#endif
#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_PROFILE->properties);
#endif

#endif
#if INCLUDE_CLASS_CONFERENCESERVICE

CLASS_CONFERENCESERVICE = (class_t *) malloc(sizeof(class_t));
CLASS_CONFERENCESERVICE->rtti = RTTI_CLASS;
CLASS_CONFERENCESERVICE->classtype =  strdup("http://www.cs.karelia.ru/smartroom#ConferenceService");
CLASS_CONFERENCESERVICE->properties = list_get_new_list();
CLASS_CONFERENCESERVICE->instances = NULL;
CLASS_CONFERENCESERVICE->superclasses = list_get_new_list();
CLASS_CONFERENCESERVICE->oneof = list_get_new_list();

sslog_repo_add_entity((void *) CLASS_CONFERENCESERVICE);

#if INCLUDE_PROPERTY_HOLDSACTIVITY
tmp_node = list_get_new_node(PROPERTY_HOLDSACTIVITY);
list_add_node(tmp_node, CLASS_CONFERENCESERVICE->properties);
#endif
#if INCLUDE_PROPERTY_SERVICESTATUS
tmp_node = list_get_new_node(PROPERTY_SERVICESTATUS);
list_add_node(tmp_node, CLASS_CONFERENCESERVICE->properties);
#endif
#if INCLUDE_PROPERTY_SERVICEDESCRIPTION
tmp_node = list_get_new_node(PROPERTY_SERVICEDESCRIPTION);
list_add_node(tmp_node, CLASS_CONFERENCESERVICE->properties);
#endif
#if INCLUDE_PROPERTY_SERVICENAME
tmp_node = list_get_new_node(PROPERTY_SERVICENAME);
list_add_node(tmp_node, CLASS_CONFERENCESERVICE->properties);
#endif
#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_CONFERENCESERVICE->properties);
#endif
#if INCLUDE_PROPERTY_CURRENTSECTION
tmp_node = list_get_new_node(PROPERTY_CURRENTSECTION);
list_add_node(tmp_node, CLASS_CONFERENCESERVICE->properties);
#endif

#endif
#if INCLUDE_CLASS_CONTENTSERVICE

CLASS_CONTENTSERVICE = (class_t *) malloc(sizeof(class_t));
CLASS_CONTENTSERVICE->rtti = RTTI_CLASS;
CLASS_CONTENTSERVICE->classtype =  strdup("http://www.cs.karelia.ru/smartroom#ContentService");
CLASS_CONTENTSERVICE->properties = list_get_new_list();
CLASS_CONTENTSERVICE->instances = NULL;
CLASS_CONTENTSERVICE->superclasses = list_get_new_list();
CLASS_CONTENTSERVICE->oneof = list_get_new_list();

sslog_repo_add_entity((void *) CLASS_CONTENTSERVICE);

#if INCLUDE_PROPERTY_SERVICESTATUS
tmp_node = list_get_new_node(PROPERTY_SERVICESTATUS);
list_add_node(tmp_node, CLASS_CONTENTSERVICE->properties);
#endif
#if INCLUDE_PROPERTY_SERVICEDESCRIPTION
tmp_node = list_get_new_node(PROPERTY_SERVICEDESCRIPTION);
list_add_node(tmp_node, CLASS_CONTENTSERVICE->properties);
#endif
#if INCLUDE_PROPERTY_SERVICENAME
tmp_node = list_get_new_node(PROPERTY_SERVICENAME);
list_add_node(tmp_node, CLASS_CONTENTSERVICE->properties);
#endif
#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_CONTENTSERVICE->properties);
#endif
#if INCLUDE_PROPERTY_CONTENTURL
tmp_node = list_get_new_node(PROPERTY_CONTENTURL);
list_add_node(tmp_node, CLASS_CONTENTSERVICE->properties);
#endif

#endif
#if INCLUDE_CLASS_NOTHING

CLASS_NOTHING = (class_t *) malloc(sizeof(class_t));
CLASS_NOTHING->rtti = RTTI_CLASS;
CLASS_NOTHING->classtype =  strdup("http://www.w3.org/2002/07/owl#Nothing");
CLASS_NOTHING->properties = list_get_new_list();  
CLASS_NOTHING->instances = NULL;
CLASS_NOTHING->superclasses = list_get_new_list();  
CLASS_NOTHING->oneof = list_get_new_list();  

sslog_repo_add_entity((void *) CLASS_NOTHING);

#if INCLUDE_PROPERTY_CURRENTSLIDECOUNT
tmp_node = list_get_new_node(PROPERTY_CURRENTSLIDECOUNT);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_IMG
tmp_node = list_get_new_node(PROPERTY_IMG);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_SECTIONDATE
tmp_node = list_get_new_node(PROPERTY_SECTIONDATE);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_HOLDSACTIVITY
tmp_node = list_get_new_node(PROPERTY_HOLDSACTIVITY);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_SECTIONSTARTTIME
tmp_node = list_get_new_node(PROPERTY_SECTIONSTARTTIME);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_MBOX
tmp_node = list_get_new_node(PROPERTY_MBOX);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_USERNAME
tmp_node = list_get_new_node(PROPERTY_USERNAME);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_SRLOGIN
tmp_node = list_get_new_node(PROPERTY_SRLOGIN);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_FIRSTTIMESLOT
tmp_node = list_get_new_node(PROPERTY_FIRSTTIMESLOT);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_NAME
tmp_node = list_get_new_node(PROPERTY_NAME);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_HASCONTEXT
tmp_node = list_get_new_node(PROPERTY_HASCONTEXT);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_STARTCONFERENCEFROM
tmp_node = list_get_new_node(PROPERTY_STARTCONFERENCEFROM);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_TIMESLOTPERSON
tmp_node = list_get_new_node(PROPERTY_TIMESLOTPERSON);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_CURRENTSLIDEIMG
tmp_node = list_get_new_node(PROPERTY_CURRENTSLIDEIMG);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_LANGUAGE
tmp_node = list_get_new_node(PROPERTY_LANGUAGE);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_WLANMAC
tmp_node = list_get_new_node(PROPERTY_WLANMAC);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_STARTPRESENTATION
tmp_node = list_get_new_node(PROPERTY_STARTPRESENTATION);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_PRESENTATIONTAGS
tmp_node = list_get_new_node(PROPERTY_PRESENTATIONTAGS);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_SERVICESTATUS
tmp_node = list_get_new_node(PROPERTY_SERVICESTATUS);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_HASPRESENTATION
tmp_node = list_get_new_node(PROPERTY_HASPRESENTATION);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_ENDPRESENTATION
tmp_node = list_get_new_node(PROPERTY_ENDPRESENTATION);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_PERSONINFORMATION
tmp_node = list_get_new_node(PROPERTY_PERSONINFORMATION);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_PRESENTATIONTITLE
tmp_node = list_get_new_node(PROPERTY_PRESENTATIONTITLE);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_AGE
tmp_node = list_get_new_node(PROPERTY_AGE);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_ACTIVITYTITLE
tmp_node = list_get_new_node(PROPERTY_ACTIVITYTITLE);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_SERVICEDESCRIPTION
tmp_node = list_get_new_node(PROPERTY_SERVICEDESCRIPTION);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_PASSWORD
tmp_node = list_get_new_node(PROPERTY_PASSWORD);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_TIMESLOTTITLE
tmp_node = list_get_new_node(PROPERTY_TIMESLOTTITLE);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_TIMESLOTPRESENTATION
tmp_node = list_get_new_node(PROPERTY_TIMESLOTPRESENTATION);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_PHONE
tmp_node = list_get_new_node(PROPERTY_PHONE);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_TIMESLOTDURATION
tmp_node = list_get_new_node(PROPERTY_TIMESLOTDURATION);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_TIMESLOTACTUALDURATION
tmp_node = list_get_new_node(PROPERTY_TIMESLOTACTUALDURATION);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_CURRENTTIMESLOT
tmp_node = list_get_new_node(PROPERTY_CURRENTTIMESLOT);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_TOPIC_INTEREST
tmp_node = list_get_new_node(PROPERTY_TOPIC_INTEREST);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_SERVICENAME
tmp_node = list_get_new_node(PROPERTY_SERVICENAME);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_CURRENTPRESENTATION
tmp_node = list_get_new_node(PROPERTY_CURRENTPRESENTATION);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_NEXTTIMESLOT
tmp_node = list_get_new_node(PROPERTY_NEXTTIMESLOT);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_ENDCONFERENCE
tmp_node = list_get_new_node(PROPERTY_ENDCONFERENCE);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_SECTIONTITLE
tmp_node = list_get_new_node(PROPERTY_SECTIONTITLE);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_THEMESTATUS
tmp_node = list_get_new_node(PROPERTY_THEMESTATUS);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_HASSERVICE
tmp_node = list_get_new_node(PROPERTY_HASSERVICE);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_STARTCONFERENCE
tmp_node = list_get_new_node(PROPERTY_STARTCONFERENCE);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_CONTENTURL
tmp_node = list_get_new_node(PROPERTY_CONTENTURL);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_CURRENTSECTION
tmp_node = list_get_new_node(PROPERTY_CURRENTSECTION);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_TIMESLOTSPEAKERNAME
tmp_node = list_get_new_node(PROPERTY_TIMESLOTSPEAKERNAME);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_PRESENTATIONURL
tmp_node = list_get_new_node(PROPERTY_PRESENTATIONURL);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_SRPASSWORD
tmp_node = list_get_new_node(PROPERTY_SRPASSWORD);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_CURRENTSLIDENUM
tmp_node = list_get_new_node(PROPERTY_CURRENTSLIDENUM);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_ORGANIZATION
tmp_node = list_get_new_node(PROPERTY_ORGANIZATION);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_SHOWSLIDE
tmp_node = list_get_new_node(PROPERTY_SHOWSLIDE);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_HASSECTION
tmp_node = list_get_new_node(PROPERTY_HASSECTION);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_STATUS
tmp_node = list_get_new_node(PROPERTY_STATUS);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_ACCOUNT
tmp_node = list_get_new_node(PROPERTY_ACCOUNT);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_UPDATEPRESENTATION
tmp_node = list_get_new_node(PROPERTY_UPDATEPRESENTATION);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_THEMEID
tmp_node = list_get_new_node(PROPERTY_THEMEID);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif

#endif
#if INCLUDE_CLASS_PRESENTATION

CLASS_PRESENTATION = (class_t *) malloc(sizeof(class_t));
CLASS_PRESENTATION->rtti = RTTI_CLASS;
CLASS_PRESENTATION->classtype =  strdup("http://www.cs.karelia.ru/smartroom#Presentation");
CLASS_PRESENTATION->properties = list_get_new_list();  
CLASS_PRESENTATION->instances = NULL;
CLASS_PRESENTATION->superclasses = list_get_new_list();  
CLASS_PRESENTATION->oneof = list_get_new_list();  

sslog_repo_add_entity((void *) CLASS_PRESENTATION);

#if INCLUDE_PROPERTY_PRESENTATIONTAGS
tmp_node = list_get_new_node(PROPERTY_PRESENTATIONTAGS);
list_add_node(tmp_node, CLASS_PRESENTATION->properties);
#endif
#if INCLUDE_PROPERTY_PRESENTATIONTITLE
tmp_node = list_get_new_node(PROPERTY_PRESENTATIONTITLE);
list_add_node(tmp_node, CLASS_PRESENTATION->properties);
#endif
#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_PRESENTATION->properties);
#endif
#if INCLUDE_PROPERTY_PRESENTATIONURL
tmp_node = list_get_new_node(PROPERTY_PRESENTATIONURL);
list_add_node(tmp_node, CLASS_PRESENTATION->properties);
#endif

#endif
#if INCLUDE_CLASS_SMARTROOM

CLASS_SMARTROOM = (class_t *) malloc(sizeof(class_t));
CLASS_SMARTROOM->rtti = RTTI_CLASS;
CLASS_SMARTROOM->classtype =  strdup("http://www.cs.karelia.ru/smartroom#SmartRoom");
CLASS_SMARTROOM->properties = list_get_new_list();  
CLASS_SMARTROOM->instances = NULL;
CLASS_SMARTROOM->superclasses = list_get_new_list();  
CLASS_SMARTROOM->oneof = list_get_new_list();  

sslog_repo_add_entity((void *) CLASS_SMARTROOM);

#if INCLUDE_PROPERTY_HASSERVICE
tmp_node = list_get_new_node(PROPERTY_HASSERVICE);
list_add_node(tmp_node, CLASS_SMARTROOM->properties);
#endif
#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_SMARTROOM->properties);
#endif

#endif
#if INCLUDE_CLASS_BLOG

CLASS_BLOG = (class_t *) malloc(sizeof(class_t));
CLASS_BLOG->rtti = RTTI_CLASS;
CLASS_BLOG->classtype =  strdup("http://www.cs.karelia.ru/smartroom#Blog");
CLASS_BLOG->properties = list_get_new_list();
CLASS_BLOG->instances = NULL;
CLASS_BLOG->superclasses = list_get_new_list();
CLASS_BLOG->oneof = list_get_new_list();

sslog_repo_add_entity((void *) CLASS_BLOG);

#if INCLUDE_PROPERTY_SRLOGIN
tmp_node = list_get_new_node(PROPERTY_SRLOGIN);
list_add_node(tmp_node, CLASS_BLOG->properties);
#endif
#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_BLOG->properties);
#endif
#if INCLUDE_PROPERTY_SRPASSWORD
tmp_node = list_get_new_node(PROPERTY_SRPASSWORD);
list_add_node(tmp_node, CLASS_BLOG->properties);
#endif

#endif
#if INCLUDE_CLASS_PERSON

CLASS_PERSON = (class_t *) malloc(sizeof(class_t));
CLASS_PERSON->rtti = RTTI_CLASS;
CLASS_PERSON->classtype =  strdup("http://xmlns.com/foaf/0.1/Person");
CLASS_PERSON->properties = list_get_new_list();  
CLASS_PERSON->instances = NULL;
CLASS_PERSON->superclasses = list_get_new_list();  
CLASS_PERSON->oneof = list_get_new_list();  

sslog_repo_add_entity((void *) CLASS_PERSON);

#if INCLUDE_PROPERTY_IMG
tmp_node = list_get_new_node(PROPERTY_IMG);
list_add_node(tmp_node, CLASS_PERSON->properties);
#endif
#if INCLUDE_PROPERTY_MBOX
tmp_node = list_get_new_node(PROPERTY_MBOX);
list_add_node(tmp_node, CLASS_PERSON->properties);
#endif
#if INCLUDE_PROPERTY_NAME
tmp_node = list_get_new_node(PROPERTY_NAME);
list_add_node(tmp_node, CLASS_PERSON->properties);
#endif
#if INCLUDE_PROPERTY_LANGUAGE
tmp_node = list_get_new_node(PROPERTY_LANGUAGE);
list_add_node(tmp_node, CLASS_PERSON->properties);
#endif
#if INCLUDE_PROPERTY_WLANMAC
tmp_node = list_get_new_node(PROPERTY_WLANMAC);
list_add_node(tmp_node, CLASS_PERSON->properties);
#endif
#if INCLUDE_PROPERTY_HASPRESENTATION
tmp_node = list_get_new_node(PROPERTY_HASPRESENTATION);
list_add_node(tmp_node, CLASS_PERSON->properties);
#endif
#if INCLUDE_PROPERTY_AGE
tmp_node = list_get_new_node(PROPERTY_AGE);
list_add_node(tmp_node, CLASS_PERSON->properties);
#endif
#if INCLUDE_PROPERTY_PHONE
tmp_node = list_get_new_node(PROPERTY_PHONE);
list_add_node(tmp_node, CLASS_PERSON->properties);
#endif
#if INCLUDE_PROPERTY_TOPIC_INTEREST
tmp_node = list_get_new_node(PROPERTY_TOPIC_INTEREST);
list_add_node(tmp_node, CLASS_PERSON->properties);
#endif
#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_PERSON->properties);
#endif
#if INCLUDE_PROPERTY_ORGANIZATION
tmp_node = list_get_new_node(PROPERTY_ORGANIZATION);
list_add_node(tmp_node, CLASS_PERSON->properties);
#endif
#if INCLUDE_PROPERTY_STATUS
tmp_node = list_get_new_node(PROPERTY_STATUS);
list_add_node(tmp_node, CLASS_PERSON->properties);
#endif
#if INCLUDE_PROPERTY_ACCOUNT
tmp_node = list_get_new_node(PROPERTY_ACCOUNT);
list_add_node(tmp_node, CLASS_PERSON->properties);
#endif

#endif
#if INCLUDE_CLASS_ACTIVITY

CLASS_ACTIVITY = (class_t *) malloc(sizeof(class_t));
CLASS_ACTIVITY->rtti = RTTI_CLASS;
CLASS_ACTIVITY->classtype =  strdup("http://www.cs.karelia.ru/smartroom#Activity");
CLASS_ACTIVITY->properties = list_get_new_list();
CLASS_ACTIVITY->instances = NULL;
CLASS_ACTIVITY->superclasses = list_get_new_list();
CLASS_ACTIVITY->oneof = list_get_new_list();

sslog_repo_add_entity((void *) CLASS_ACTIVITY);

#if INCLUDE_PROPERTY_ACTIVITYTITLE
tmp_node = list_get_new_node(PROPERTY_ACTIVITYTITLE);
list_add_node(tmp_node, CLASS_ACTIVITY->properties);
#endif
#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_ACTIVITY->properties);
#endif
#if INCLUDE_PROPERTY_HASSECTION
tmp_node = list_get_new_node(PROPERTY_HASSECTION);
list_add_node(tmp_node, CLASS_ACTIVITY->properties);
#endif

#endif
#if INCLUDE_CLASS_AGENDANOTIFICATION

CLASS_AGENDANOTIFICATION = (class_t *) malloc(sizeof(class_t));
CLASS_AGENDANOTIFICATION->rtti = RTTI_CLASS;
CLASS_AGENDANOTIFICATION->classtype =  strdup("http://www.cs.karelia.ru/smartroom#AgendaNotification");
CLASS_AGENDANOTIFICATION->properties = list_get_new_list();
CLASS_AGENDANOTIFICATION->instances = NULL;
CLASS_AGENDANOTIFICATION->superclasses = list_get_new_list();
CLASS_AGENDANOTIFICATION->oneof = list_get_new_list();

sslog_repo_add_entity((void *) CLASS_AGENDANOTIFICATION);

#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_AGENDANOTIFICATION->properties);
#endif
#if INCLUDE_PROPERTY_STARTCONFERENCE
tmp_node = list_get_new_node(PROPERTY_STARTCONFERENCE);
list_add_node(tmp_node, CLASS_AGENDANOTIFICATION->properties);
#endif

#endif
#if INCLUDE_CLASS_PRESENTATIONNOTIFICATION

CLASS_PRESENTATIONNOTIFICATION = (class_t *) malloc(sizeof(class_t));
CLASS_PRESENTATIONNOTIFICATION->rtti = RTTI_CLASS;
CLASS_PRESENTATIONNOTIFICATION->classtype =  strdup("http://www.cs.karelia.ru/smartroom#PresentationNotification");
CLASS_PRESENTATIONNOTIFICATION->properties = list_get_new_list();
CLASS_PRESENTATIONNOTIFICATION->instances = NULL;
CLASS_PRESENTATIONNOTIFICATION->superclasses = list_get_new_list();
CLASS_PRESENTATIONNOTIFICATION->oneof = list_get_new_list();

sslog_repo_add_entity((void *) CLASS_PRESENTATIONNOTIFICATION);

#if INCLUDE_PROPERTY_STARTPRESENTATION
tmp_node = list_get_new_node(PROPERTY_STARTPRESENTATION);
list_add_node(tmp_node, CLASS_PRESENTATIONNOTIFICATION->properties);
#endif
#if INCLUDE_PROPERTY_ENDPRESENTATION
tmp_node = list_get_new_node(PROPERTY_ENDPRESENTATION);
list_add_node(tmp_node, CLASS_PRESENTATIONNOTIFICATION->properties);
#endif
#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_PRESENTATIONNOTIFICATION->properties);
#endif
#if INCLUDE_PROPERTY_SHOWSLIDE
tmp_node = list_get_new_node(PROPERTY_SHOWSLIDE);
list_add_node(tmp_node, CLASS_PRESENTATIONNOTIFICATION->properties);
#endif
#if INCLUDE_PROPERTY_UPDATEPRESENTATION
tmp_node = list_get_new_node(PROPERTY_UPDATEPRESENTATION);
list_add_node(tmp_node, CLASS_PRESENTATIONNOTIFICATION->properties);
#endif

#endif
#if INCLUDE_CLASS_THING

CLASS_THING = (class_t *) malloc(sizeof(class_t));
CLASS_THING->rtti = RTTI_CLASS;
CLASS_THING->classtype =  strdup("http://www.w3.org/2002/07/owl#Thing");
CLASS_THING->properties = list_get_new_list();
CLASS_THING->instances = NULL;
CLASS_THING->superclasses = list_get_new_list();
CLASS_THING->oneof = list_get_new_list();

sslog_repo_add_entity((void *) CLASS_THING);

#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_THING->properties);
#endif

#endif
#if INCLUDE_CLASS_CONTEXT

CLASS_CONTEXT = (class_t *) malloc(sizeof(class_t));
CLASS_CONTEXT->rtti = RTTI_CLASS;
CLASS_CONTEXT->classtype =  strdup("http://www.cs.karelia.ru/smartroom#Context");
CLASS_CONTEXT->properties = list_get_new_list();
CLASS_CONTEXT->instances = NULL;
CLASS_CONTEXT->superclasses = list_get_new_list();
CLASS_CONTEXT->oneof = list_get_new_list();

sslog_repo_add_entity((void *) CLASS_CONTEXT);

#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_CONTEXT->properties);
#endif

#endif
#if INCLUDE_CLASS_CLIENTNOTIFICATION

CLASS_CLIENTNOTIFICATION = (class_t *) malloc(sizeof(class_t));
CLASS_CLIENTNOTIFICATION->rtti = RTTI_CLASS;
CLASS_CLIENTNOTIFICATION->classtype =  strdup("http://www.cs.karelia.ru/smartroom#ClientNotification");
CLASS_CLIENTNOTIFICATION->properties = list_get_new_list();
CLASS_CLIENTNOTIFICATION->instances = NULL;
CLASS_CLIENTNOTIFICATION->superclasses = list_get_new_list();
CLASS_CLIENTNOTIFICATION->oneof = list_get_new_list();

sslog_repo_add_entity((void *) CLASS_CLIENTNOTIFICATION);

#if INCLUDE_PROPERTY_STARTPRESENTATION
tmp_node = list_get_new_node(PROPERTY_STARTPRESENTATION);
list_add_node(tmp_node, CLASS_CLIENTNOTIFICATION->properties);
#endif
#if INCLUDE_PROPERTY_ENDPRESENTATION
tmp_node = list_get_new_node(PROPERTY_ENDPRESENTATION);
list_add_node(tmp_node, CLASS_CLIENTNOTIFICATION->properties);
#endif
#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_CLIENTNOTIFICATION->properties);
#endif

#endif
#if INCLUDE_CLASS_PRESENTATIONSERVICE

CLASS_PRESENTATIONSERVICE = (class_t *) malloc(sizeof(class_t));
CLASS_PRESENTATIONSERVICE->rtti = RTTI_CLASS;
CLASS_PRESENTATIONSERVICE->classtype =  strdup("http://www.cs.karelia.ru/smartroom#PresentationService");
CLASS_PRESENTATIONSERVICE->properties = list_get_new_list();
CLASS_PRESENTATIONSERVICE->instances = NULL;
CLASS_PRESENTATIONSERVICE->superclasses = list_get_new_list();
CLASS_PRESENTATIONSERVICE->oneof = list_get_new_list();

sslog_repo_add_entity((void *) CLASS_PRESENTATIONSERVICE);

#if INCLUDE_PROPERTY_CURRENTSLIDECOUNT
tmp_node = list_get_new_node(PROPERTY_CURRENTSLIDECOUNT);
list_add_node(tmp_node, CLASS_PRESENTATIONSERVICE->properties);
#endif
#if INCLUDE_PROPERTY_CURRENTSLIDEIMG
tmp_node = list_get_new_node(PROPERTY_CURRENTSLIDEIMG);
list_add_node(tmp_node, CLASS_PRESENTATIONSERVICE->properties);
#endif
#if INCLUDE_PROPERTY_SERVICESTATUS
tmp_node = list_get_new_node(PROPERTY_SERVICESTATUS);
list_add_node(tmp_node, CLASS_PRESENTATIONSERVICE->properties);
#endif
#if INCLUDE_PROPERTY_SERVICEDESCRIPTION
tmp_node = list_get_new_node(PROPERTY_SERVICEDESCRIPTION);
list_add_node(tmp_node, CLASS_PRESENTATIONSERVICE->properties);
#endif
#if INCLUDE_PROPERTY_SERVICENAME
tmp_node = list_get_new_node(PROPERTY_SERVICENAME);
list_add_node(tmp_node, CLASS_PRESENTATIONSERVICE->properties);
#endif
#if INCLUDE_PROPERTY_CURRENTPRESENTATION
tmp_node = list_get_new_node(PROPERTY_CURRENTPRESENTATION);
list_add_node(tmp_node, CLASS_PRESENTATIONSERVICE->properties);
#endif
#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_PRESENTATIONSERVICE->properties);
#endif
#if INCLUDE_PROPERTY_CURRENTSLIDENUM
tmp_node = list_get_new_node(PROPERTY_CURRENTSLIDENUM);
list_add_node(tmp_node, CLASS_PRESENTATIONSERVICE->properties);
#endif

#endif
#if INCLUDE_CLASS_ONLINEACCOUNT

CLASS_ONLINEACCOUNT = (class_t *) malloc(sizeof(class_t));
CLASS_ONLINEACCOUNT->rtti = RTTI_CLASS;
CLASS_ONLINEACCOUNT->classtype =  strdup("http://xmlns.com/foaf/0.1/OnlineAccount");
CLASS_ONLINEACCOUNT->properties = list_get_new_list();
CLASS_ONLINEACCOUNT->instances = NULL;
CLASS_ONLINEACCOUNT->superclasses = list_get_new_list();
CLASS_ONLINEACCOUNT->oneof = list_get_new_list();

sslog_repo_add_entity((void *) CLASS_ONLINEACCOUNT);

#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_ONLINEACCOUNT->properties);
#endif

#endif
#if INCLUDE_CLASS_SECTION

CLASS_SECTION = (class_t *) malloc(sizeof(class_t));
CLASS_SECTION->rtti = RTTI_CLASS;
CLASS_SECTION->classtype =  strdup("http://www.cs.karelia.ru/smartroom#Section");
CLASS_SECTION->properties = list_get_new_list();
CLASS_SECTION->instances = NULL;
CLASS_SECTION->superclasses = list_get_new_list();
CLASS_SECTION->oneof = list_get_new_list();

sslog_repo_add_entity((void *) CLASS_SECTION);

#if INCLUDE_PROPERTY_SECTIONDATE
tmp_node = list_get_new_node(PROPERTY_SECTIONDATE);
list_add_node(tmp_node, CLASS_SECTION->properties);
#endif
#if INCLUDE_PROPERTY_SECTIONSTARTTIME
tmp_node = list_get_new_node(PROPERTY_SECTIONSTARTTIME);
list_add_node(tmp_node, CLASS_SECTION->properties);
#endif
#if INCLUDE_PROPERTY_FIRSTTIMESLOT
tmp_node = list_get_new_node(PROPERTY_FIRSTTIMESLOT);
list_add_node(tmp_node, CLASS_SECTION->properties);
#endif
#if INCLUDE_PROPERTY_CURRENTTIMESLOT
tmp_node = list_get_new_node(PROPERTY_CURRENTTIMESLOT);
list_add_node(tmp_node, CLASS_SECTION->properties);
#endif
#if INCLUDE_PROPERTY_SECTIONTITLE
tmp_node = list_get_new_node(PROPERTY_SECTIONTITLE);
list_add_node(tmp_node, CLASS_SECTION->properties);
#endif
#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_SECTION->properties);
#endif

#endif
#if INCLUDE_CLASS_CONFERENCENOTIFICATION

CLASS_CONFERENCENOTIFICATION = (class_t *) malloc(sizeof(class_t));
CLASS_CONFERENCENOTIFICATION->rtti = RTTI_CLASS;
CLASS_CONFERENCENOTIFICATION->classtype =  strdup("http://www.cs.karelia.ru/smartroom#ConferenceNotification");
CLASS_CONFERENCENOTIFICATION->properties = list_get_new_list();
CLASS_CONFERENCENOTIFICATION->instances = NULL;
CLASS_CONFERENCENOTIFICATION->superclasses = list_get_new_list();
CLASS_CONFERENCENOTIFICATION->oneof = list_get_new_list();

sslog_repo_add_entity((void *) CLASS_CONFERENCENOTIFICATION);

#if INCLUDE_PROPERTY_STARTCONFERENCEFROM
tmp_node = list_get_new_node(PROPERTY_STARTCONFERENCEFROM);
list_add_node(tmp_node, CLASS_CONFERENCENOTIFICATION->properties);
#endif
#if INCLUDE_PROPERTY_ENDPRESENTATION
tmp_node = list_get_new_node(PROPERTY_ENDPRESENTATION);
list_add_node(tmp_node, CLASS_CONFERENCENOTIFICATION->properties);
#endif
#if INCLUDE_PROPERTY_ENDCONFERENCE
tmp_node = list_get_new_node(PROPERTY_ENDCONFERENCE);
list_add_node(tmp_node, CLASS_CONFERENCENOTIFICATION->properties);
#endif
#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_CONFERENCENOTIFICATION->properties);
#endif
#if INCLUDE_PROPERTY_STARTCONFERENCE
tmp_node = list_get_new_node(PROPERTY_STARTCONFERENCE);
list_add_node(tmp_node, CLASS_CONFERENCENOTIFICATION->properties);
#endif

#endif
#if INCLUDE_CLASS_SERVICE

CLASS_SERVICE = (class_t *) malloc(sizeof(class_t));
CLASS_SERVICE->rtti = RTTI_CLASS;
CLASS_SERVICE->classtype =  strdup("http://www.cs.karelia.ru/smartroom#Service");
CLASS_SERVICE->properties = list_get_new_list();
CLASS_SERVICE->instances = NULL;
CLASS_SERVICE->superclasses = list_get_new_list();
CLASS_SERVICE->oneof = list_get_new_list();

sslog_repo_add_entity((void *) CLASS_SERVICE);

#if INCLUDE_PROPERTY_SERVICESTATUS
tmp_node = list_get_new_node(PROPERTY_SERVICESTATUS);
list_add_node(tmp_node, CLASS_SERVICE->properties);
#endif
#if INCLUDE_PROPERTY_SERVICEDESCRIPTION
tmp_node = list_get_new_node(PROPERTY_SERVICEDESCRIPTION);
list_add_node(tmp_node, CLASS_SERVICE->properties);
#endif
#if INCLUDE_PROPERTY_SERVICENAME
tmp_node = list_get_new_node(PROPERTY_SERVICENAME);
list_add_node(tmp_node, CLASS_SERVICE->properties);
#endif
#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_SERVICE->properties);
#endif

#endif
#if INCLUDE_CLASS_THEME

CLASS_THEME = (class_t *) malloc(sizeof(class_t));
CLASS_THEME->rtti = RTTI_CLASS;
CLASS_THEME->classtype =  strdup("http://www.cs.karelia.ru/smartroom#Theme");
CLASS_THEME->properties = list_get_new_list();
CLASS_THEME->instances = NULL;
CLASS_THEME->superclasses = list_get_new_list();
CLASS_THEME->oneof = list_get_new_list();

sslog_repo_add_entity((void *) CLASS_THEME);

#if INCLUDE_PROPERTY_THEMESTATUS
tmp_node = list_get_new_node(PROPERTY_THEMESTATUS);
list_add_node(tmp_node, CLASS_THEME->properties);
#endif
#if INCLUDE_PROPERTY_UPDATEAGENDA
tmp_node = list_get_new_node(PROPERTY_UPDATEAGENDA);
list_add_node(tmp_node, CLASS_THEME->properties);
#endif
#if INCLUDE_PROPERTY_THEMEID
tmp_node = list_get_new_node(PROPERTY_THEMEID);
list_add_node(tmp_node, CLASS_THEME->properties);
#endif

#endif


#if INCLUDE_CLASS_TIMESLOT
#if INCLUDE_CLASS_THING
tmp_node = list_get_new_node(CLASS_THING);
list_add_node(tmp_node, CLASS_TIMESLOT->superclasses);
#endif
#endif
#if INCLUDE_CLASS_PROFILE
#if INCLUDE_CLASS_THING
tmp_node = list_get_new_node(CLASS_THING);
list_add_node(tmp_node, CLASS_PROFILE->superclasses);
#endif
#endif
#if INCLUDE_CLASS_CONFERENCESERVICE
#if INCLUDE_CLASS_SERVICE
tmp_node = list_get_new_node(CLASS_SERVICE);
list_add_node(tmp_node, CLASS_CONFERENCESERVICE->superclasses);
#endif
#endif
#if INCLUDE_CLASS_CONTENTSERVICE
#if INCLUDE_CLASS_SERVICE
tmp_node = list_get_new_node(CLASS_SERVICE);
list_add_node(tmp_node, CLASS_CONTENTSERVICE->superclasses);
#endif
#endif
#if INCLUDE_CLASS_NOTHING
#if INCLUDE_CLASS_PROFILE
tmp_node = list_get_new_node(CLASS_PROFILE);
list_add_node(tmp_node, CLASS_NOTHING->superclasses);
#endif
#endif
#if INCLUDE_CLASS_NOTHING
#if INCLUDE_CLASS_TIMESLOT
tmp_node = list_get_new_node(CLASS_TIMESLOT);
list_add_node(tmp_node, CLASS_NOTHING->superclasses);
#endif
#endif
#if INCLUDE_CLASS_NOTHING
#if INCLUDE_CLASS_CONFERENCESERVICE
tmp_node = list_get_new_node(CLASS_CONFERENCESERVICE);
list_add_node(tmp_node, CLASS_NOTHING->superclasses);
#endif
#endif
#if INCLUDE_CLASS_NOTHING
#if INCLUDE_CLASS_CONTENTSERVICE
tmp_node = list_get_new_node(CLASS_CONTENTSERVICE);
list_add_node(tmp_node, CLASS_NOTHING->superclasses);
#endif
#endif
#if INCLUDE_CLASS_NOTHING
#if INCLUDE_CLASS_PRESENTATION
tmp_node = list_get_new_node(CLASS_PRESENTATION);
list_add_node(tmp_node, CLASS_NOTHING->superclasses);
#endif
#endif
#if INCLUDE_CLASS_NOTHING
#if INCLUDE_CLASS_SMARTROOM
tmp_node = list_get_new_node(CLASS_SMARTROOM);
list_add_node(tmp_node, CLASS_NOTHING->superclasses);
#endif
#endif
#if INCLUDE_CLASS_NOTHING
#if INCLUDE_CLASS_ACTIVITY
tmp_node = list_get_new_node(CLASS_ACTIVITY);
list_add_node(tmp_node, CLASS_NOTHING->superclasses);
#endif
#endif
#if INCLUDE_CLASS_NOTHING
#if INCLUDE_CLASS_PERSON
tmp_node = list_get_new_node(CLASS_PERSON);
list_add_node(tmp_node, CLASS_NOTHING->superclasses);
#endif
#endif
#if INCLUDE_CLASS_NOTHING
#if INCLUDE_CLASS_BLOG
tmp_node = list_get_new_node(CLASS_BLOG);
list_add_node(tmp_node, CLASS_NOTHING->superclasses);
#endif
#endif
#if INCLUDE_CLASS_NOTHING
#if INCLUDE_CLASS_AGENDANOTIFICATION
tmp_node = list_get_new_node(CLASS_AGENDANOTIFICATION);
list_add_node(tmp_node, CLASS_NOTHING->superclasses);
#endif
#endif
#if INCLUDE_CLASS_NOTHING
#if INCLUDE_CLASS_PRESENTATIONNOTIFICATION
tmp_node = list_get_new_node(CLASS_PRESENTATIONNOTIFICATION);
list_add_node(tmp_node, CLASS_NOTHING->superclasses);
#endif
#endif
#if INCLUDE_CLASS_NOTHING
#if INCLUDE_CLASS_CONTEXT
tmp_node = list_get_new_node(CLASS_CONTEXT);
list_add_node(tmp_node, CLASS_NOTHING->superclasses);
#endif
#endif
#if INCLUDE_CLASS_NOTHING
#if INCLUDE_CLASS_PRESENTATIONSERVICE
tmp_node = list_get_new_node(CLASS_PRESENTATIONSERVICE);
list_add_node(tmp_node, CLASS_NOTHING->superclasses);
#endif
#endif
#if INCLUDE_CLASS_NOTHING
#if INCLUDE_CLASS_CLIENTNOTIFICATION
tmp_node = list_get_new_node(CLASS_CLIENTNOTIFICATION);
list_add_node(tmp_node, CLASS_NOTHING->superclasses);
#endif
#endif
#if INCLUDE_CLASS_NOTHING
#if INCLUDE_CLASS_ONLINEACCOUNT
tmp_node = list_get_new_node(CLASS_ONLINEACCOUNT);
list_add_node(tmp_node, CLASS_NOTHING->superclasses);
#endif
#endif
#if INCLUDE_CLASS_NOTHING
#if INCLUDE_CLASS_SECTION
tmp_node = list_get_new_node(CLASS_SECTION);
list_add_node(tmp_node, CLASS_NOTHING->superclasses);
#endif
#endif
#if INCLUDE_CLASS_NOTHING
#if INCLUDE_CLASS_CONFERENCENOTIFICATION
tmp_node = list_get_new_node(CLASS_CONFERENCENOTIFICATION);
list_add_node(tmp_node, CLASS_NOTHING->superclasses);
#endif
#endif
#if INCLUDE_CLASS_NOTHING
#if INCLUDE_CLASS_THEME
tmp_node = list_get_new_node(CLASS_THEME);
list_add_node(tmp_node, CLASS_NOTHING->superclasses);
#endif
#endif
#if INCLUDE_CLASS_PRESENTATION
#if INCLUDE_CLASS_THING
tmp_node = list_get_new_node(CLASS_THING);
list_add_node(tmp_node, CLASS_PRESENTATION->superclasses);
#endif
#endif
#if INCLUDE_CLASS_SMARTROOM
#if INCLUDE_CLASS_THING
tmp_node = list_get_new_node(CLASS_THING);
list_add_node(tmp_node, CLASS_SMARTROOM->superclasses);
#endif
#endif
#if INCLUDE_CLASS_BLOG
#if INCLUDE_CLASS_THING
tmp_node = list_get_new_node(CLASS_THING);
list_add_node(tmp_node, CLASS_BLOG->superclasses);
#endif
#endif
#if INCLUDE_CLASS_PERSON
#if INCLUDE_CLASS_THING
tmp_node = list_get_new_node(CLASS_THING);
list_add_node(tmp_node, CLASS_PERSON->superclasses);
#endif
#endif
#if INCLUDE_CLASS_ACTIVITY
#if INCLUDE_CLASS_THING
tmp_node = list_get_new_node(CLASS_THING);
list_add_node(tmp_node, CLASS_ACTIVITY->superclasses);
#endif
#endif
#if INCLUDE_CLASS_AGENDANOTIFICATION
#if INCLUDE_CLASS_THING
tmp_node = list_get_new_node(CLASS_THING);
list_add_node(tmp_node, CLASS_AGENDANOTIFICATION->superclasses);
#endif
#endif
#if INCLUDE_CLASS_PRESENTATIONNOTIFICATION
#if INCLUDE_CLASS_THING
tmp_node = list_get_new_node(CLASS_THING);
list_add_node(tmp_node, CLASS_PRESENTATIONNOTIFICATION->superclasses);
#endif
#endif
#if INCLUDE_CLASS_CONTEXT
#if INCLUDE_CLASS_THING
tmp_node = list_get_new_node(CLASS_THING);
list_add_node(tmp_node, CLASS_CONTEXT->superclasses);
#endif
#endif
#if INCLUDE_CLASS_CLIENTNOTIFICATION
#if INCLUDE_CLASS_THING
tmp_node = list_get_new_node(CLASS_THING);
list_add_node(tmp_node, CLASS_CLIENTNOTIFICATION->superclasses);
#endif
#endif
#if INCLUDE_CLASS_PRESENTATIONSERVICE
#if INCLUDE_CLASS_SERVICE
tmp_node = list_get_new_node(CLASS_SERVICE);
list_add_node(tmp_node, CLASS_PRESENTATIONSERVICE->superclasses);
#endif
#endif
#if INCLUDE_CLASS_ONLINEACCOUNT
#if INCLUDE_CLASS_THING
tmp_node = list_get_new_node(CLASS_THING);
list_add_node(tmp_node, CLASS_ONLINEACCOUNT->superclasses);
#endif
#endif
#if INCLUDE_CLASS_SECTION
#if INCLUDE_CLASS_THING
tmp_node = list_get_new_node(CLASS_THING);
list_add_node(tmp_node, CLASS_SECTION->superclasses);
#endif
#endif
#if INCLUDE_CLASS_CONFERENCENOTIFICATION
#if INCLUDE_CLASS_THING
tmp_node = list_get_new_node(CLASS_THING);
list_add_node(tmp_node, CLASS_CONFERENCENOTIFICATION->superclasses);
#endif
#endif
#if INCLUDE_CLASS_SERVICE
#if INCLUDE_CLASS_THING
tmp_node = list_get_new_node(CLASS_THING);
list_add_node(tmp_node, CLASS_SERVICE->superclasses);
#endif
#endif
#if INCLUDE_CLASS_THEME
#if INCLUDE_CLASS_THING
tmp_node = list_get_new_node(CLASS_THING);
list_add_node(tmp_node, CLASS_THEME->superclasses);
#endif
#endif



}

