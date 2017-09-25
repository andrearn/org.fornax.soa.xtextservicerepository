---
layout: documentation
title: Service governance
part: Concepts
---
# {{page.title}} {#Governance}]

## Introduction 

### Purpose 

SOA governance defines the basic rules to follow in building up a service oriented architecture by defining processes design rules and by granting authority to execute governance task to certain roles. The service repository is one of the main tools to communicate the architecture and design of a SOA landscape as well as executing change management, control an service portfolio planning.

Many assets in the repository define a version, lifecycle state and governance approval state. Who can change these properties is defined by the SOA governance processes and rules.


## Governance concepts 


### Asset versioning 

#### Setting the version of an asset 

Each versioned asset has a `version`{:language-ServiceDSL} property.

#### When to create a new version 

A new version has a least to be created, when an asset is to be changed, but the most recent version has already been approved by SOA governance or is already in production. Create a new minor version when the changes are backward compatible. If however, the changes are incompatible, a new major version must be created.

#### Versioned relationships between assets

Relationships between versioned assets are constrained by a version constraint, defining which versions of the referred asset are acceptable. This is expressed by a version constraint rule on the relationship like this:
]]
```BaseDSL 
	someAttribute : SomeOtherType majorVersion 2
```

The example declares that the BO attribute `someAttribute`{:language-BaseDSL} references an instance of the latest minor version in major version `2` available for `VersionedType`{:language-BaseDSL} `SomeOtherType`{:language-BaseDSL}.
]

### Asset lifecycle management


### Asset approvals 


