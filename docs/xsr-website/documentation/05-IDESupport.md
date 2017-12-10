---
layout: documentation
title: Supporting IDE features
part: Concepts
---
# {{page.title}} {#IDESupport}

## Searching assets

XKonneX Repository supports two ways to find assets like services.

### Standard Xtext based search

The first option is to use "Open Model Element" from the "Navigate" menu. This is the standard Xtext search facility which opens a pop-up dialog where can enter a name or name pattern of the model element you look for and additionally it's type e.g. Service. Another option is to use the "Service Repository Search" from the search dialog.

### XKonneX Repository Search dialog

Here you use different kinds of queries:

* Search for assets by name, type. Wildcards can be used as well. The search result can be further constrained by version and state ranges, scoping to canonical and/or non canonical model or tags.
* Unapproved assets - Find all Services, BusinessObjects etc. which need governance approval.


### Quick type hierarchy

When you select a business object yoe can view it's type hierarchy in a pop-up dialog by selecting "Quick type hierarchy" from the context menu.


## Asset tagging

Many assets have a <code>tags</code> property where you can name tags you previously defined in a Semantics DSL file. Use the Service Repository Search to find assets with a tag (or several tags).

## Graphical model views

For some models a diagram can be displayed. These diagrams are created dynamically using a script that maps a selected model element and it's related elements to a diagram. So you can have look at how the object of a service data model relate to one another or how a solution is structured. Starting with an initial diagram you can discover further parts of the model when you click at the "+" sign on a model elements border.
To view any of the supported diagrams you need to have the Generic Graph Views feature installed and the "Xtext generic graph view" opened. You can find it in the Xtext view category.

### Business object diagram

To view a business object diagram you need to select a `domain-namespace`{:language-ServiceDSL} or `internal-namespace`{:language-ServiceDSL} by clicking on it's name in the DSL file. Then you select the "BusinessObject diagram" from the Generic Graph View pane. The diagram shows first all business and query objects, enums and exception types defined in the namespace.

### Service diagram

To view a service diagram you need to select a `domain-namespace`{:language-ServiceDSL} or `internal-namespace`{:language-ServiceDSL}. Then you select the "Service diagram" from the Generic Graph View pane. The diagram shows first all services defined in the namespace. When you click on the "+" sign of a service node more elements like business object and services required by the service will be opened.


### Solution diagram

To view a solution diagram you need to select a solution by clicking on it's name. The diagram will show at first all modules features and required services defined at the top level of the solution.
