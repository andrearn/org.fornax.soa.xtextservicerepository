---
layout: documentation
title: DSL Reference
part: Reference
---
# {{page.title}} {#DSLReference}


## General syntax rules 

### Qualified names 

Asset names can be fully qualified. A <code>QualifiedName</code> is defined as:

Definition:        
```xtext
    ID(.ID)*
```

Example:
```BaseDSL
    my.qualified.Name
```


### Keyword escape {#keywordEscapeRule}

If a name is already a keyword it can be escaped with the character `^` as usual in Xtext
based languages.


### Version declarations 

Versioned assets declare their version with the following statement:

Definition:        
```xtext
    version INT('.'INT)*
```

Example:
```BaseDSL
    version 1.3.1
```

The first number is the major version number. Two elements with the same name and major version number are considered compatible.


### Lifecycle state declarations 

Elements under the SOA governance lifecycle declare their current state with the following statement:

Definition:        
```ServiceDSL
    lifecycle-state lifecycleStateNameFromProfile
```

Example:
```ServiceDSL
    lifecycle-state productive
```

Possible lifecycle states are defined with Lifecycles in the profil DSL.


### Governance approval declarations 

Assets under SOA governance declare their current approval state with the following section:

Definition:    
```ServiceDSL
    governance-approval {
        yes | no | tolerated | temporarily-tolerated
        (decision-date DATE|STRING)?
        (decision-by STRING)? 
    }
```

Example:
```ServiceDSL
    governance-approval {
        yes
        decision-date 2017-03-01
        decision-by "Max Miller" 
    }
```

In the example the asset has been approved on March 1st, 2017 by Max Miller.
    

## Business DSL 

### Introduction 

The Business DSL defines and business capabilties and business functions as well as organizational structures that implements the business function. Business capabilities can be mapped to services, service operations or features of a solution. E.g. a service may declare that it realizes a certain capability. Capabilities can be grouped into *capability-group*s and organized into *domain*s. It is also possible to define variants of a capability.

Example:
```BusinessDSL
domain company.shop {
    
    capability-group Invoicing {
        description "Creating and managing invoices"
        
            
        capability BillRun {
            version 1.0
            short-description "Start the monthly billrun"
            automation-level automated
            business-value "critical"
        }
        
        capability InvoiceCreation {
            version 1.0
            short-description "Create an invoice document for the customer "
            automation-level automated
            business-value "medium"
            inputs {
                input "order"
                input "customer"
                input "customer address"
            }
            outcomes {
                outcome "Invoice document created and archived"
                outcome "Invoice document sent by email and postal mail to the customer"
            }
        }
    }    
}
```

The example defines a capability group `Invoicing` in the domain `company.shop`. The capability group contains the fully automated capabilities `Billrun` and `InvoiceCreation`. The latter one defines required inputs and expected results.
 
Business capability models can be created by creating a new _Business DSL file_. A wizard is available for that.


## Service DSL 


### Language overview

#### Service DSL file structure 

A Service DSL file defines namespace, business objects, services and exception. It has the following basic structure:

```ServiceDSL
org-namespace <QualifiedName> shortname "<String>" {
                    
    domain-namespace <QualifiedName> shortname "<String>" {
        (
        metadata {
            <business-domain>?
            <owner>?
        }
        )?
        
        /* business objects and enums */
        businessObject AbstractProduct {
            metadata {
                version <someversion.number>
                lifecycle-state <a governance lifecycle state>
                governance-approval {
                    ...
                }
            }
            <... attributes and weak-references ...>
        }
        
        
        /* services ... */                
        public service CustomerEntityService {
            metadata {
                version <someversion.number>
                lifecycle-state <a governance lifecycle state>
                governance-approval {
                    ...
                }
                category entity
                statefulness < idempotent | stateless | stateful >;
                persistence <read | write | read/write>
            }
            
            // operations go here:
            <message exchange pattern: sync | async ..> <operationName> (<(optional)? parameters> ) 
                returns <(optional)? return parameters>
                throws <exceptions, ...>
            {
                requires <other version constrained service dependency>
            }
        }
        
        // RESTful resources
        public resource CustomerResource {
            metadata {
                version <someversion.number>
                lifecycle-state <a governance lifecycle state>
                governance-approval {
                    ...
                }
                category entity
                statefulness < idempotent | stateless | stateful >;
                persistence <read | write | read/write>
            }
            base-URI "/customer"
			
            GET "/{customerId}" 
                <operationName> (customerId : long)
                <operationName> (<(optional)? parameters> ) 
                returns <(optional)? return parameters>
                throws <exceptions, ...>
                {
                    requires <other version constrained service dependency>
                }
                returns {
                    response-code <HTTP status code> {
                        <(optional)? return parameters>
                        content-type <content type name>
                    }
                }
                throws {
                    response-code <HTTP status code> {
                        <exception type with version>
                        content-type "application/json"
                    }
                }
            {		
            }
        }
        
        // exceptions ... 
        exception <ExceptionName> {
            metadata {
                version <someversion.number>
                lifecycle-state <a governance lifecycle state>
                governance-approval {
                    ...
                }
            }
            <exception-attributes like in business objects>
        }
    }
}
```


#### Namespaces

##### Organization Namespace 

Organization Namespaces are toplevel namespaces like `com.example`. They reflect a company, organization or top level unit of a company. Organization Namespaces are used as host part in namespace URIs in reversed order, e.g. _http://example.com/_ Organization Namespace should declare a short name which might be used as namespace prefix or part of a file name.    

##### Domain Namespace 

A Domain Namespace contains a canonical datamodel as well as related public services for a certain logical subdomain. Usually a service DSL file declares a single Domain Namespace and no Domain Namespaces are nested in that file within the declared Domain Namespace. Instead subnamespaces will be declared in separate file having their namespace name prefixed with with the names of all their parnet Domain Namespaces. Hence parent-child relationships of Domain Namespaces are built by apply this naming convention. Dots are used as separators.

Example:

Be `product` the top level of all subnamespace related to customers. Then `customer.contract` would declare the subnamespace `contract` as subnamespace of `customer`. If `org.example` would be the top level Organization Namespace containing these Domain Namespaces, the full qualified name would be: 

`org.example.customer.contract`. The resulting namespace URI would look like: _http://example.org/customer/contract_

The resp. declarations with Service DSL would look like:

```ServiceDSL
org-namespace com.example shortname "ex" {
                    
    domain-namespace customer shortname "cust" {
        metadata {
        }
                        
    }
}
```

And it's subdomain:
```ServiceDSL
org-namespace com.example shortname "ex" {
                    
    domain-namespace customer.contract shortname "ct" {
        metadata {
        }
                    
    }
}
```

##### Internal Namespace 

An internal namespace contains private services and the non canonical datamodel, i.e. internal parts of the infrastructure the may change frequently. Datatypes declared in an internal namespace are being considered noncanonical. Services defined in an internal namespace should be marked `private`. An internal namespace is declared like this:

Example:
```ServiceDSL
org-namespace com.example shortname "ex" {
                    
    internal-namespace customer.contract.internal.backend shortname "ctback" {
        metadata {
        }
                        
    }
}
```



#### BusinessObjects 

BusinessObject are user defined complex datatypes capturing business data. BusinessObject are versioned and have a lifecycle state. The actual data are represented by one or more properties, that have a name and a datatype.
                
Example:

```ServiceDSL
businessObject AbstractProduct {
    metadata {
        version 1.0
        lifecycle-state test
        governance-approval {
            yes
            decision-date 2017-04-20
            decision-by "Anna Jacobson"
        }
    }
    business-key productId : string
    name : string
    price : AbstractPrice majorVersion 1
    category : string
    optional vendor : string
}
```

##### Business object meta data 

 
| Keyword                    | Valid values                              | Example                      | Description                                              |
| :------------------------- | :--------------------------------------   | :--------------------------- | -------------------------------------------------------- |
| `version`                  | `INT('.'INT)*`{:.language-xtext}          | `version 1.2.1`{:.language-ServiceDSL}                                            | The business object version.                                                                                                                      |
| `replaces`                 | Reference to old business object          | `replaces OldBusinessObject`{:.language-ServiceDSL}<br/>&nbsp;&nbsp;&nbsp;&nbsp;` majorVersion 1`{:.language-ServiceDSL}               | Used to rename business objects or move them to another namespace. The reference to the previous business object is given here.                   |
| `lifecycle-state`          | Reference to a lifecycle state by name    | `lifecycle-state defined`{:.language-ServiceDSL}                                 | The lifecycle state of the business object with regard to SOA governance.                                                                         |
| `governance-approval`      | see definition of governance approval     | `governance-approval {`{:.language-ServiceDSL}<br/>&nbsp;&nbsp;&nbsp;&nbsp;`    yes`{:.language-ServiceDSL}<br/>&nbsp;&nbsp;&nbsp;&nbsp;`    decision-on 2017-02-01`{:.language-ServiceDSL}<br/>&nbsp;&nbsp;&nbsp;&nbsp;`    decision-by "John Miller"`{:.language-ServiceDSL}<br/>`}`{:.language-ServiceDSL}  | The state of the governance decision on the business object. |
| `retirement-on`            | DATE literal STRING literal with a date   | `retirement-on 2018-08-31`{:.language-ServiceDSL}                              | The (planned) date of retirement of the business object.                                                                                          |
| `provided-definition-URL`  | STRING with technical contract URL          | `provided-definition-URL`{:.language-ServiceDSL}<br/>&nbsp;&nbsp;&nbsp;&nbsp;`"http://somehost:8080/some.xsd"`{:.language-ServiceDSL} | Only for business objects defined in internal namespaces. The location where the already existing definition of the business object can be found. |


##### Properties 

Properties are use by business and query objects. A property is defined as:

```xtext
Property:
    (deprecated?='@deprecated')? 
    (
        (((optional?='optional')? (weak?='weak')?) | (isBusinessKey?='business-key')? | (isProvidedKey?='provided-key')?) 
        (readonly?='read-only')?
    )
    ((historizingKey?='historizing-key') | (historized?='historized') | (versionIndependantKey?='version-independant-key'))? 
    name=ID ':' type=TypeRef ;
```
    
Properties have a name and a type reference. Further cardinalities
and some qualifiers can be defined. If a property is optional, the keyword `optional`{:lang-ServiceDSL}
is being. If a property has multiple cardinality brackets are used in the type reference after the type
name, e.g. 

contract : `Contract [] majorVersion 1`{:.language-ServiceDSL}

If the collection type is a set instead of a list it can be expressed like this:

contract : `Contract [] as set] majorVersion 1`{:.language-ServiceDSL}


Property qualifier keywords:

| Keyword                   | Description                                                               |
| :------------------------- | ------------------------------------------------------------------------- |
| `optional`                | The property is optional. It may be null.|
| `weak`                    | Though the property is mandatory from a business point of view, it is not always set for technical reasons, such as query performance.|
| `business-key`            | The property is a business-key. All business keys together identify an object. Business keys must be always defined. However it is not necessary that a business object has a business key.|
| `provided-key`            | The property is a key generated or provided from somewhere else, as e.g. a    backend system. In contrast to a business key a provided key may not always be set.|
| `historized`              | The property is a historized relationship. Hence a set key attributes, the historizing keys are required on the referenced type to resolve the reference. All historized versions of a BO share the same version independant key |
| `historing-key`           | The property is a key used to resolve historized references to this BO. |
| `version-independant-key` | The property is a key shared by all versions of a historized BO. |
                        

###### Common features of Properties:


Property name and type:

Each property has a name and a type. The name and the type are separated by <code>:</code>. Types may be BusinessObjects, Enumerations or DataTypes, i.e. primitive types defined in the SOAProfile. As BusinessObjects and Enumerations are versioned, the type reference of the attribute must declare a version constraint.

Example:
```ServiceDSL
firstname : string
contract : Contract majorVersion 1
```


Cardinality:

Properties may be marked optional by using the keyword <code>optional</code> in front of the property name.

firstname may be left empty / null:
```ServiceDSL
optional firstname : string
```                                

Properties may also have a collection type:
```ServiceDSL
contracts : Contract [] majorVersion 1
```
The BusinessObject has a collection of at least one Contract in major version 1.



Property qualifier keywords:

| Keyword                   | Description |
|:------------------------- | ----------- |
| `optional`                | The property is optional. It may be null. |
| `weak`                    | Though the property is mandatory from a business point of view, it is not always set for technical reasons, such as query performance. |
| `business-key`            | The property is a business-key. All business keys together identify an object. Business keys must be always defined. However it is not necessary that a business object has a business key.|
| `provided-key`            | The property is a key generated or provided from somewhere else, as e.g. a backend system. In contrast to a business key a provided key may not always be set. |
| `historized`              | The property is a historized relationship. Hence a set key attributes, the historizing keys are required on the referenced type to resolve the reference. All historized versions of a BO share the same version independant key |
| `historing-key`           | The property is a key used to resolve historized references to this BO. |
| `version-independant-key` | The property is a key shared by all versions of a historized BO. |
                        

Common features of Properties:


Property name and type:

Each property has a name and a type. The name and the type are separated by `:`. Types may be BusinessObjects, Enumerations or DataTypes, i.e. primitive types defined in the SOAProfile. As BusinessObjects and Enumerations are versioned, the type reference of the attribute must declare a version constraint.


#### Enumerations

##### Enumeration meta data

| Keyword                | Valid values                             | Example                                          | Description |
| :--------------------- | :-------------------------------------   | :--------------------------------------------- | ----------- |
| `version`              | `INT('.'INT)*`                             | `version 1.2.1`{:.language-ServiceDSL}         | The enumeration version. |
| `replaces`             | Reference to old enumeration             | `replaces OldEnumeration`<br/>&nbsp;&nbsp;&nbsp;&nbsp;`majorVersion 1`{:.language-ServiceDSL} | Used to rename enumerations or move them to another namespace. The reference to the previous enumeration is given here. |
| `lifecycle-state`      | Reference to a lifecycle state by name | `lifecycle-state defined`{:.language-ServiceDSL}               | The lifecycle state of the enumeration with regard to SOA governance. |
| `governance-approval`  | see definition of governance approval    | `governance-approval {`{:.language-ServiceDSL}<br/>&nbsp;&nbsp;&nbsp;&nbsp;`    yes`{:.language-ServiceDSL}<br/>&nbsp;&nbsp;&nbsp;&nbsp;`    decision-on 2017-02-01`{:.language-ServiceDSL}<br/>&nbsp;&nbsp;&nbsp;&nbsp;`    decision-by "John Miller"`{:.language-ServiceDSL}`}`{:.language-ServiceDSL} | The state of the governance decision on the enumeration. |
| `retirement-on`          | DATE or STRING literal with a date       | `retirement-on 2017-08-31`{:.language-ServiceDSL}               | The (planned) date of retirement of the enumeration.    |
| `provided-contract`     | STRING with technical contract URL       | `provided-definition-URL`<br/>&nbsp;&nbsp;&nbsp;&nbsp;`"http://somehost:8080/some.xsd"`{:.language-ServiceDSL} | Only for enumerations defined in internal namespaces. The location where the already existing definition of the business object can be found. |


#### Services

##### General service properties


###### Public services:

Public services comprice the official API and should be generally used. Public services may depend, i.e. <code>require</code> a private service. Hence, such a public service would wrap the e[require]d private service.

Public services may only use the canonical datamodel to be reusable.


###### Domain services:

Domain services are some more restricted in their usage. They can only be called from services defined in the same namespace or one of it's subnamespaces. Domain services may only use the canonical datamodel to be reusable.


###### Private services:

Private service are internal API that should be wrapped by public or domain services. Private services can only be called from the wrapping public and domain service. While they can be called from other private services as well, this is regarded bad design and should be refactored to call their wrapping public services. 

Every service has a name, version, lifecycle state and governance approval state.                    


##### Defining services

A service is defined in a domain namespace or internal namespace like this:

```ServiceDSL
/*
    The CustomerEntityService loads, stores and find Customer instances
*/
public service CustomerEntityService {
    metadata {
        version 1.0
        lifecycle-state proposed
        governance-approval {
            yes
            approval-date 2017-04-20
            approved-by "Anna Jacobson"
        }
        category ^entity
        statefulness stateful
        persistence read/write
    }
    
    // operations go here:
    sync getCustomerByName (optional firstName : string, lastname : string) 
        returns optional customers : Customer [] majorVersion 1
        throws CustomerNotFoundException 
    {
        requires SomeBackendService majorVersion 1
    }
}
```

##### Service meta data

| Keyword               | Valid values                              | Example                                        | Description                   |
| :--------------------- | :---------------------------------------- | :------------------------------------------- | ------------------------------ |
| `version`             | `INT('.'INT)*`                            | `version 1.0.1`{:.language-ServiceDSL}        | The service version.|
| `lifecycle-state`     | Reference to a lifecycle state by name    | `lifecycle-state defined`{:.language-ServiceDSL}  | The lifecycle state of the service with regard to SOA governance. |
| `governance-approval` | see definition of governance approval     | `governance-approval {`{:.language-ServiceDSL}<br/>&nbsp;&nbsp;&nbsp;&nbsp;`    yes`{:.language-ServiceDSL}<br/>&nbsp;&nbsp;&nbsp;&nbsp;`    decision-on 2017-02-01`{:.language-ServiceDSL}<br/>&nbsp;&nbsp;&nbsp;&nbsp;`    decision-by "John Miller"`{:.language-ServiceDSL}<br/>`}`{:.language-ServiceDSL} | The state of the governance decision on the service. |
| `category`            | Reference to a service category by name as defined in the  ArchitecureProfile | `category activity`{:.language-ServiceDSL} | The service category. |
| `statefulness`        | `idempotend | stateless | stateful`       | `statefulness stateless`{:.language-ServiceDSL}                     | Whether the service can be repeatedly called with the same result (idempotend), is stateless or stateful. |
| `persistence`         | `read | write | read/write | none`        | `persistence read/write`{:.language-ServiceDSL}                      | Whether data treaded by the service are persistent and read and/or written to a persistent store. |
| `realizes-capabilty`  | `(QualifiedCapabilityName`<br/>&nbsp;&nbsp;&nbsp;&nbsp;`VersionConstraint)+` | `realizes-capabilty`{:.language-ServiceDSL}<br/>&nbsp;&nbsp;&nbsp;&nbsp;`    InvoiceCustomer fixedVersion 1`{:.language-ServiceDSL}<br/>&nbsp;&nbsp;&nbsp;&nbsp;`    InvoiceMail fixedVersion 2`{:.language-ServiceDSL}    | Reference to one or more business capabilities that are fully realized by the service. |
| `supports-capabilty`  | `(QualifiedCapabilityName`<br/>&nbsp;&nbsp;&nbsp;&nbsp;`VersionConstraint)+` | `supports-capability`{:.language-ServiceDSL}<br/>&nbsp;&nbsp;&nbsp;&nbsp;`    InvoiceCustomer fixedVersion 1`{:.language-ServiceDSL}<br/>&nbsp;&nbsp;&nbsp;&nbsp;`    InvoiceMail fixedVersion 2`{:.language-ServiceDSL}    | Reference to one or more business capabilities that are supported, but not fully realized by the service. |
| `provided-contract`   | `STRING`                                  | `provided-Contract-URL`<br/>&nbsp;&nbsp;&nbsp;&nbsp;`"http://somehost:someport/some.wsdl"`{:.language-ServiceDSL} | Only for private services defined in internal namespaces. The location where the already existing contract of the service can be found. |
| `sourceURL`           | `STRING` with the location URL of the source code repository | `sourceURL "svn://somehost/somelocation"`{:.language-ServiceDSL} | Where the sources can be found. |
| `docURL`              | `STRING` with the URL of the document     | `docURL "svn://somehost/somelocation"`{:.language-ServiceDSL}     | Where the documentation or specification can be found. |
| `release-on`          | `DATE` or `STRING` with the release date  | `release-on 2017-08-28`{:.language-ServiceDSL}                  | The (planned) release date of the service. |
| `retirement-on`       | `DATE` or `STRING` the date of retirement | `retirement-on 2018-08-31`{:.language-ServiceDSL} | The (planned) date of retirement of the service. |
| `replaces`            | Reference to old service                     | `replaces OldServiceName`<br/>&nbsp;&nbsp;&nbsp;&nbsp;`majorVersion 1`{:.language-ServiceDSL}   | Used to rename services or move them to another namespace. The reference to the previous service is given here. |
| `messageHeader`       | Reference to a MessageHeader definition   | `messageHeader MyHeader`<br/>&nbsp;&nbsp;&nbsp;&nbsp;`majorVersion 1`{:.language-ServiceDSL}     | An alternative message header to be sent with each message. Usually a default message header has been defined in the profile which is being used when this attribute has not been defined, hence it is an override. |

#### Operations

###### Operation parameters 

#### Exceptions


## Module DSL

### Defining modules

Modules aggregate services into a deployable unit. Modules have a version and are subject to a lifecycle. The services provided by should be referenced with a fixed version in order be to know what exactly the module provides. Hence, a version of a module contains a fixed set of services with exactly defined versions.

The following example shows, how modules are defined:
 

```ModuleDSL
module com.company.shop.invoicing {
    version 1.4.3
    lifecycle-state test
    assembly-type SCA_EAR
    provides {
        InvoiceProcessService fixedVersion 1.4
        InvoiceActivityService fixedVersion 1.2
        InvoiceNotificationUtilityService fixedVersion 1.1.1
    }
    source-location "git://git.company.com/shop/invoicing"
    release-tag "Release_1.4.3_RC2"
    release-on 2017-08-28
}
```

The example defines a module with the `QualifiedName` `com.company.shop.invoicing` in version `1.4.3` that provides three services. The module is available for acceptance test and has been packaged as an EAR containing a SCA composite. The `source-location` and `revision` tag referring to the source commited to the version control system are optional parameters. The version and lifecycle-state declaration comply to the common syntax rules for versions and lifecycle status declarations being follow the general syntax rules for these used throughout the service repository.

Modules are declared in _Module DSL files_. A wizard is available to create new _Module DSL files_.


## Environment DSL {#langEnvironmentDsl}

### Defining environments {#langDefEnv}

The environment defines which servers are available and where they are hosted. Environments have a unique name and a type such as e[development], `test` or `production`. To create a new environment create a new _Environment DSL file_. A new file wizard is available for that. Then define an environment as in this example:
            

```EnvironmentDSL
environment CoreDevelopment of type Development-Environment {
    host as4000 {
        full-qualified-name "as4000.company.com"
    }
    host as4200 {
        full-qualified-name "as4000.company.com"
    }
    host as4350 {
        full-qualified-name "as4350.company.com"
    }
    appserver as4350Tomcat {
        identifier "tomcat.as4350.core.dev"
        host as4350
        baseUrl "http://as4350.company.com:8080"
        connectors {
            HTTP {
                port 8080
                secured-port 8443
            }
            SOAP/HTTP {
                port 8080
                secured-port 8443
                context-root "ws"
            }
        }
    }
    
    esb DevESB {
        identifier "esb.as4200.core.dev"
        host localhost
        adminUrl "https://as4200.company.com:9443/ibm/console"
        server-type "websphere"
        server-version "7.5"
        connectors {
            SOAP/HTTP {
                port 9080
                secured-port 9443
                security-protocol SSLv3
                implementation "IBM"
            }
        }
    }
    
    registry reg {
        identifier "simplereg.as4000.core"
        host as4000 
        
        baseUrl "http://registry.company.com"
        
        server-type "Apache"
        server-version "2.2"
        kind HTTP
    }
}
```

In this example three hosts `as4000` `as4200` and `as4350` have set up in the development environment named `CoreDevelopment`. On host `as4000` an Apache has been installed having the identifier `simplereg.as4000.core` in the Definitive Software Library within the Configuration Database. On host `as4350` the Tomcat instance `as4350Tomcat` offers HTTP on port 8080 and HTTPS on port 8443 as outlined in the `connectors` section. The tomcat also offers a SOAP interface on the same ports, offering SOAP services under the context root `ws`. Finally an ESB is running on host `as4200`, that also offers SOAP on port 9080. The connectors are implicitely referenced from the binding when having the same type as the `BindingProtocol` defined for a service or module in the binding of them to this environment.



## Binding DSL {#langBindingDsl}

### Defining bindings {#langDefBind}

The binding creates the link between services / modules and a target environment where they get deployed. Hence they are bound to that environment. Consequently a binding would be defined for each environment where the services / modules are deployed. 
The following example shows how a binding can be defined for a module to a target environment.

Example:

```BindingDSL
import CoreDevelopment

bind-module com.company.shop.invoicing fixedVersion 1.4.3 
    as com.company.shop.invoicing.dev to server CoreDevelopment.DevESB {
    default-protocols {
        SOAP {
            style document/literal-wrapped
        }
    }
}
```

The module `com.company.shop.invoicing` in version `1.4.3` is  bound to the development environment named `CoreDevelopment`. The binding has the name `com.company.shop.invoicing.dev` to be easily referrable from code generators. The binding definition ist pretty simple by stating, that the module will be deployed to the ESB `DevESB` in the target environment. All services provided by the module will be offered as SOAP services using the _document / literal-wrapped_ style. Note that the `BindingProtocol` `SOAP`{:.language-BindingDSL} links to the `SOAPHTTP`{:.language-EnvironmentDSL} connector of the ESB

Bindings are declared in _Binding DSL files_. A wizard is available to create new _Binding DSL files_.
        

## Solution DSL {#langSolutionDsl}

The solution DSL is used to model service based solutions, i.e. applications. With solutions you can model service consumers that are not services themselves. This provides a means to find out which solutions / apps are the consumers of a service and whether it is being used by any potential consumer at all.

Example:
```SolutionDSL
import SampleArchitectureProfile.ExSOALifecycle.*
import org.example.sales.*

/**
 * A CRM application
 */
solution CustomerManagementApp {
    version 1.0
    lifecycle-state productive
    
    additional-information {
        location 
            "file://W:\\CustomerManagement\\Requirements\\CustomerManagementApp-Requirements.doc"
        location 
            "file://W:\\CustomerManagement\\Design\\CustomerManagementApp-Design.doc"
    }
    requires CustomerManagerBAS majorVersion 1
    
    feature SomeFeature {
        requires CustomerLookupBES majorVersion 1
    }
}
```

## Profile DSL {#langProfileDsl}

The profile DSL models the general architectural constraints, asset lifecycle and basic data types. A profile model must always be created, to declare the basic types at least.

Example:

```ProfileDSL
/*
 * Define simple data types
 */

datatype int
datatype string
datatype date
datatype datetime
datatype boolean
datatype char
datatype long
datatype float
datatype double
datatype decimal
datatype base64Binary
datatype anyType 
/**
  * A SOA architecture profile defines some basic rules for the whole company
  */
profile SampleArchitectureProfile {
    scope "Example Org"
    
    /** Example Org default asset lifecycle */
    lifecycle ExSOALifecycle {
            
        /**
         * The asset is proposal that is only discussed
         */
        initial state proposed {
            /*
             * One can play with the proposal only in a 
             * local environment (the local PC)
             */
            qualifies-for Local-Environment
            -> development 
        }
        
        /**
         * The asset is under development
         */
        state development {
            /*
             * It becomes accesible in the development environment as well
             */
            qualifies-for Local-Environment, Development-Environment
            -> test
            -> proposed
        }
        
        /*
         * The asset is under test
         */
        state test {
            //must have been approved by SOA governance
            requires-approval
            qualifies-for 
            	Local-Environment, Development-Environment, Test-Environment
            -> productive
            -> proposed
        }
       
        /* 
         * The is under productive use
         */
        state productive {
            //must have been approved by SOA governance
            requires-approval
            /* changes are not allowed on this version of the asset, 
             * new version need to be created to incorporate changes */
            freezes-asset
            qualifies-for Local-Environment, Development-Environment,
            	Test-Environment, Staging-Environment, Production-Environment
            -> deprecated
            -> proposed
        }
        
        /*
         * The asset is deprecated and will be retired soon.
         */
        state deprecated {
            //must have been approved by SOA governance
            requires-approval
            /* changes are not allowed on this version of the asset, a 
             * new version need to be created to incorporate changes */
            freezes-asset
            qualifies-for Local-Environment, Development-Environment,
                Test-Environment, Staging-Environment, Production-Environment
            -> productive
            -> proposed
        }
    }
    
    /**
     * Categorize services based on a standard category
     */
    service-categories {
        /**
         * This is a <b>Business Activity Service</b> (BAS) <br/><br/>
         * 
         * A Service, that can execute an activity or function of the business logic.
         */
        ^activity base-category activity
        
        /* Categorizes a <b>Business Entity Service</b> (BES) <br/><br/>
         * 
         * The service accesses persistent data
         */
        ^entity base-category entity
       
        /** 
         * Categorizes a <b>Business Process Service</b> (BPS) <br/><br/>
         * 
         * The service represents a business process
         */
        ^process base-category process
        
        /**
         * Categorizes a <b>Business Rule Service</b> (BRS) <br/><br/>
         * 
         * The service represents a business rule
         */
        ^rule base-category rule
        
        /**
         * Categorizes a <b>Utility Service</b> (US)
         * 
         * A service that can be used for helper functions
         */
        ^utility base-category utility
    }
    
    
    /**
     * Define general design rules and naming conventions
     */
    design-rules {
        
            
        /* Rules for data types */
        types {
            /*
             * Define how the evolution of backward compatible version is supported
             */
            version-evolution {
                /* XSDs will need a placeholder element for response 
                 * messages. By default a list of "any"-elements */
                extendible-properties
                /* 
                 * And placeholders for XSD attributes is defined will 
                 * be used as well */
                extendible-XML-attributes    
            }
        }
    }
    
    
    /**
     * Use a new namespace for every major version of 
     * BOs, Enums, Services oder Exception 
     * e.g. an XSD-namespace 
     */
    versioning-strategy namespace-based 
    
}
```
