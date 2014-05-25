#include "SmartRoomOntology.h"
#include "stdio.h"



#if INCLUDE_CLASS_CAMERA
class_t *CLASS_CAMERA;
#endif
#if INCLUDE_CLASS_NOTHING
class_t *CLASS_NOTHING;
#endif
#if INCLUDE_CLASS_THING
class_t *CLASS_THING;
#endif


#if INCLUDE_PROPERTY_CAMERALOGIN
property_t *PROPERTY_CAMERALOGIN;
#endif
#if INCLUDE_PROPERTY_CAMERANAME
property_t *PROPERTY_CAMERANAME;
#endif
#if INCLUDE_PROPERTY_SERVERURI
property_t *PROPERTY_SERVERURI;
#endif
#if INCLUDE_PROPERTY_CAMERAPASS
property_t *PROPERTY_CAMERAPASS;
#endif
#if INCLUDE_PROPERTY_CAMERAIP
property_t *PROPERTY_CAMERAIP;
#endif
#if INCLUDE_PROPERTY_CAMERAPORT
property_t *PROPERTY_CAMERAPORT;
#endif
#if INCLUDE_PROPERTY_CAMERAAPI
property_t *PROPERTY_CAMERAAPI;
#endif



/**
 * @brief Register ontology.
 *
 * It creates all structures, such as classes and properties. Use it firs in your propgramm.
 */
void register_ontology()
{    
    list_t *tmp_node = NULL;    

#if INCLUDE_PROPERTY_CAMERALOGIN

PROPERTY_CAMERALOGIN =  (property_t *) malloc(sizeof(property_t));
PROPERTY_CAMERALOGIN->name = strdup("http://www.cs.karelia.ru/smartroom#cameraLogin");
PROPERTY_CAMERALOGIN->about = strdup("cameraLogin");
//PROPERTY_CAMERALOGIN->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_CAMERALOGIN->domain = strdup("http://www.cs.karelia.ru/smartroom#Camera");
PROPERTY_CAMERALOGIN->maxcardinality = -1;
PROPERTY_CAMERALOGIN->mincardinality = -1;
PROPERTY_CAMERALOGIN->subpropertyof = NULL;
PROPERTY_CAMERALOGIN->oneof = list_get_new_list();
PROPERTY_CAMERALOGIN->rtti = RTTI_PROPERTY;
PROPERTY_CAMERALOGIN->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_CAMERALOGIN);

#endif
#if INCLUDE_PROPERTY_CAMERANAME

PROPERTY_CAMERANAME =  (property_t *) malloc(sizeof(property_t));
PROPERTY_CAMERANAME->name = strdup("http://www.cs.karelia.ru/smartroom#cameraName");
PROPERTY_CAMERANAME->about = strdup("cameraName");
//PROPERTY_CAMERANAME->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_CAMERANAME->domain = strdup("http://www.cs.karelia.ru/smartroom#Camera");
PROPERTY_CAMERANAME->maxcardinality = -1;
PROPERTY_CAMERANAME->mincardinality = -1;
PROPERTY_CAMERANAME->subpropertyof = NULL;
PROPERTY_CAMERANAME->oneof = list_get_new_list();
PROPERTY_CAMERANAME->rtti = RTTI_PROPERTY;
PROPERTY_CAMERANAME->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_CAMERANAME);

#endif
#if INCLUDE_PROPERTY_SERVERURI

PROPERTY_SERVERURI =  (property_t *) malloc(sizeof(property_t));
PROPERTY_SERVERURI->name = strdup("http://www.cs.karelia.ru/smartroom#serverURI");
PROPERTY_SERVERURI->about = strdup("serverURI");
//PROPERTY_SERVERURI->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_SERVERURI->domain = strdup("http://www.cs.karelia.ru/smartroom#Camera");
PROPERTY_SERVERURI->maxcardinality = -1;
PROPERTY_SERVERURI->mincardinality = -1;
PROPERTY_SERVERURI->subpropertyof = NULL;
PROPERTY_SERVERURI->oneof = list_get_new_list();
PROPERTY_SERVERURI->rtti = RTTI_PROPERTY;
PROPERTY_SERVERURI->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_SERVERURI);

#endif
#if INCLUDE_PROPERTY_CAMERAPASS

PROPERTY_CAMERAPASS =  (property_t *) malloc(sizeof(property_t));
PROPERTY_CAMERAPASS->name = strdup("http://www.cs.karelia.ru/smartroom#cameraPass");
PROPERTY_CAMERAPASS->about = strdup("cameraPass");
//PROPERTY_CAMERAPASS->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_CAMERAPASS->domain = strdup("http://www.cs.karelia.ru/smartroom#Camera");
PROPERTY_CAMERAPASS->maxcardinality = -1;
PROPERTY_CAMERAPASS->mincardinality = -1;
PROPERTY_CAMERAPASS->subpropertyof = NULL;
PROPERTY_CAMERAPASS->oneof = list_get_new_list();
PROPERTY_CAMERAPASS->rtti = RTTI_PROPERTY;
PROPERTY_CAMERAPASS->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_CAMERAPASS);

#endif
#if INCLUDE_PROPERTY_CAMERAIP

PROPERTY_CAMERAIP =  (property_t *) malloc(sizeof(property_t));
PROPERTY_CAMERAIP->name = strdup("http://www.cs.karelia.ru/smartroom#cameraIP");
PROPERTY_CAMERAIP->about = strdup("cameraIP");
//PROPERTY_CAMERAIP->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_CAMERAIP->domain = strdup("http://www.cs.karelia.ru/smartroom#Camera");
PROPERTY_CAMERAIP->maxcardinality = -1;
PROPERTY_CAMERAIP->mincardinality = -1;
PROPERTY_CAMERAIP->subpropertyof = NULL;
PROPERTY_CAMERAIP->oneof = list_get_new_list();
PROPERTY_CAMERAIP->rtti = RTTI_PROPERTY;
PROPERTY_CAMERAIP->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_CAMERAIP);

#endif
#if INCLUDE_PROPERTY_CAMERAPORT

PROPERTY_CAMERAPORT =  (property_t *) malloc(sizeof(property_t));
PROPERTY_CAMERAPORT->name = strdup("http://www.cs.karelia.ru/smartroom#cameraPort");
PROPERTY_CAMERAPORT->about = strdup("cameraPort");
//PROPERTY_CAMERAPORT->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_CAMERAPORT->domain = strdup("http://www.cs.karelia.ru/smartroom#Camera");
PROPERTY_CAMERAPORT->maxcardinality = -1;
PROPERTY_CAMERAPORT->mincardinality = -1;
PROPERTY_CAMERAPORT->subpropertyof = NULL;
PROPERTY_CAMERAPORT->oneof = list_get_new_list();
PROPERTY_CAMERAPORT->rtti = RTTI_PROPERTY;
PROPERTY_CAMERAPORT->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_CAMERAPORT);

#endif
#if INCLUDE_PROPERTY_CAMERAAPI

PROPERTY_CAMERAAPI =  (property_t *) malloc(sizeof(property_t));
PROPERTY_CAMERAAPI->name = strdup("http://www.cs.karelia.ru/smartroom#cameraAPI");
PROPERTY_CAMERAAPI->about = strdup("cameraAPI");
//PROPERTY_CAMERAAPI->range = "http://www.w3.org/2001/XMLSchema#string"; //getRange
PROPERTY_CAMERAAPI->domain = strdup("http://www.cs.karelia.ru/smartroom#Camera");
PROPERTY_CAMERAAPI->maxcardinality = -1;
PROPERTY_CAMERAAPI->mincardinality = -1;
PROPERTY_CAMERAAPI->subpropertyof = NULL;
PROPERTY_CAMERAAPI->oneof = list_get_new_list();
PROPERTY_CAMERAAPI->rtti = RTTI_PROPERTY;
PROPERTY_CAMERAAPI->type = DATATYPEPROPERTY;



sslog_repo_add_entity((void *) PROPERTY_CAMERAAPI);

#endif




#if INCLUDE_CLASS_CAMERA

CLASS_CAMERA = (class_t *) malloc(sizeof(class_t));
CLASS_CAMERA->rtti = RTTI_CLASS;
CLASS_CAMERA->classtype =  strdup("http://www.cs.karelia.ru/smartroom#Camera");
CLASS_CAMERA->properties = list_get_new_list();
CLASS_CAMERA->instances = NULL;
CLASS_CAMERA->superclasses = list_get_new_list();
CLASS_CAMERA->oneof = list_get_new_list();

sslog_repo_add_entity((void *) CLASS_CAMERA);

#if INCLUDE_PROPERTY_SERVERURI
tmp_node = list_get_new_node(PROPERTY_SERVERURI);
list_add_node(tmp_node, CLASS_CAMERA->properties);
#endif
#if INCLUDE_PROPERTY_CAMERAPASS
tmp_node = list_get_new_node(PROPERTY_CAMERAPASS);
list_add_node(tmp_node, CLASS_CAMERA->properties);
#endif
#if INCLUDE_PROPERTY_CAMERALOGIN
tmp_node = list_get_new_node(PROPERTY_CAMERALOGIN);
list_add_node(tmp_node, CLASS_CAMERA->properties);
#endif
#if INCLUDE_PROPERTY_CAMERAIP
tmp_node = list_get_new_node(PROPERTY_CAMERAIP);
list_add_node(tmp_node, CLASS_CAMERA->properties);
#endif
#if INCLUDE_PROPERTY_CAMERAPORT
tmp_node = list_get_new_node(PROPERTY_CAMERAPORT);
list_add_node(tmp_node, CLASS_CAMERA->properties);
#endif
#if INCLUDE_PROPERTY_CAMERAAPI
tmp_node = list_get_new_node(PROPERTY_CAMERAAPI);
list_add_node(tmp_node, CLASS_CAMERA->properties);
#endif
#if INCLUDE_PROPERTY_CAMERANAME
tmp_node = list_get_new_node(PROPERTY_CAMERANAME);
list_add_node(tmp_node, CLASS_CAMERA->properties);
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

#if INCLUDE_PROPERTY_SERVERURI
tmp_node = list_get_new_node(PROPERTY_SERVERURI);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_CAMERAPASS
tmp_node = list_get_new_node(PROPERTY_CAMERAPASS);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_CAMERALOGIN
tmp_node = list_get_new_node(PROPERTY_CAMERALOGIN);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_CAMERAIP
tmp_node = list_get_new_node(PROPERTY_CAMERAIP);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_CAMERAPORT
tmp_node = list_get_new_node(PROPERTY_CAMERAPORT);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_CAMERAAPI
tmp_node = list_get_new_node(PROPERTY_CAMERAAPI);
list_add_node(tmp_node, CLASS_NOTHING->properties);
#endif
#if INCLUDE_PROPERTY_CAMERANAME
tmp_node = list_get_new_node(PROPERTY_CAMERANAME);
list_add_node(tmp_node, CLASS_NOTHING->properties);
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


#endif


#if INCLUDE_CLASS_CAMERA
#if INCLUDE_CLASS_THING
tmp_node = list_get_new_node(CLASS_THING);
list_add_node(tmp_node, CLASS_CAMERA->superclasses);
#endif
#endif
#if INCLUDE_CLASS_NOTHING
#if INCLUDE_CLASS_CAMERA
tmp_node = list_get_new_node(CLASS_CAMERA);
list_add_node(tmp_node, CLASS_NOTHING->superclasses);
#endif
#endif



}

