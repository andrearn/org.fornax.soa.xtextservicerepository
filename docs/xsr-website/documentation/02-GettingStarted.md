---
layout: documentation
title: Getting started XKonneX Repository
part: Getting started
---
# {{page.title}} {#GettingStarted}

To get started, you should first have a look at XKonneX Repository Example projects. There you will find a simple and a more advanced example. Both examples consist of an XKonneX Repository project containing the domain model and generator project, that shows how to generate code from the model.

## Examples
### Simple example

The simple example has minimal domain model leaving out all advanced concepts around services and architecture governance.

### REST service example

The REST service example demonstrates the modeling of a REST service API

### Advanced example

The advanced example provides an example for more detailed modeling regarding governance properties, system environment definitions and overrides for conventions applied when nothing else is specified.

## Installation

### Requirements and installatiopn sources
XKonneX Repository requires Eclipse Luna with Java 1.8 and Xtext 2.13 or later. 

Please add the following updatesites to your Eclipse installation:
	* <http://dl.bintray.com/andrearn/XtextServiceRepository-updatesite> (XKonneX Repo)
	* <http://rtsys.informatik.uni-kiel.de/~kieler/updatesite/release_0.8/> (KIELER layout framework)
	
You may also add the following update site for Xtext:
	* <http://download.itemis.de/updates>
	
The easiest way add all updatesites is to download and import the Updatesite-bookmark-file available [here](https://github.com/andrearn/org.fornax.soa.xtextservicerepository/blob/master/bookmarks.xml). To import the file select "Help" > "Install New Software ..." from the menu and click on "Available Software Sites" to see the update sites available to your Eclipse installation. By clicking on "Import" you can select and import the downloaded bookmark file.

### Installing the features
Select the XKonneX Repo update site list and select all XKonneX Repo SDKs. Then proceed with "Next" and follow the installation steps. 
 
## Creating a model
### Create a XKonneX repository project

First, let's create a new XKonneX repository project:

### Model services
To model service start by creating a new Service DSL file. Let's call it _shop.svcdsl_

#### Define the namespace of the services.

### Bundle services in a module

### Model your runtime environment

### Connect the module to your environment

## Generating code