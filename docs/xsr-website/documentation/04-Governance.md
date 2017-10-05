---
layout: documentation
title: Archietcture and API governance
part: Concepts
---
# {{page.title}} {#Governance}

## Introduction 

### Purpose 

SOA governance defines the basic rules to follow in building up a service oriented architecture by defining processes design rules and by granting authority to execute governance task to certain roles. The service repository is one of the main tools to communicate the architecture and design of a SOA landscape as well as executing change management, control an service portfolio planning.

Many assets in the repository define a version, lifecycle state and governance approval state. Who can change these properties is defined by the SOA governance processes and rules.


## Versioning 

### Setting the version of an asset 

Each versioned asset has a `version`{:language-ServiceDSL} property.

### When to create a new version 

A new version has a least to be created, when an asset is to be changed, but the most recent version has already been approved by SOA governance or is already in production. Create a new minor version when the changes are backward compatible. If however, the changes are incompatible, a new major version must be created.

#### Versioned relationships between assets

Relationships between versioned assets are constrained by a version constraint, defining which versions of the referred asset are acceptable. This is expressed by a version constraint rule on the relationship like this:

```BaseDSL 
	someAttribute : SomeOtherType majorVersion 2
```

The example declares that the BO attribute `someAttribute`{:language-BaseDSL} references an instance of the latest minor version in major version `2` available for `VersionedType`{:language-BaseDSL} `SomeOtherType`{:language-BaseDSL}.


## Lifecycle management

Assets usually follow a certain lifecycle. They start as a proposal, become productive and eventually may become deprecated before their final removal.

In XKonneX Repository a lifecycle state may be bound to a minimal type of environment like *TEST* or *PRODUCTION*. The binding to environments an the effect wrt. the changeability of the asset can be define in the *architecture profile*, i.e. a *.profdsl*-File. 

### Definition of a lifycycle
The asset lifecycle is defined as a state transition model in the _architecture profile_. 

Example:

```ProfileDSL
/**
  * A SOA architecture profile defines some basic rules for the whole company
  */
profile SampleArchitectureProfile {
    
    ...
    
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
    
    ...
    
}
```

#### Declaring the lifecycle state of an asset
The current lifecycle state of an asset can be defined with a piece of DSL like this:

```ServiceDSL
    metadata {
        ...
        lifecycle-state test
    	...
    }
```
The asset above is currently under test.


## Asset approvals and governance decision documentation 

Asset approvals are done in the model with a piece of DSL like this one:

```ServiceDSL
    metadata {
        ...
        governance-approval {
            yes
            decision-date 2017-03-01
            decision-by "Max Miller" 
        }
    	...
    }
```

It states, whether the asset has been approved and when the decision has been made by whom. In this case `Max Miller` decided to approve the asset on `2017-03-11`.