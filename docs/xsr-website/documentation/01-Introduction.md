---
layout: documentation
title: Introduction
part: Introduction
---
# {{page.title}} {#Introduction}

XKonneX Repository captures central assets of a software architecture using domain specific languages based on the concepts of domain driven design as well as service based architectures such as micro services and SOA. Use it to define the ubiquitous language of your domain and the service contracts of the services to access these domains.

A micro service as well as a service oriented architecture is build from functionality provided by services. Hence, which services exist in a SOA is the most interesting question for an analyst, software architect or developer. Service repositories are the most important tool to answer questions like:

[//]: <> TODO Idea: Show different stakeholders graphically with their questions
   * Which services are available?
   * Which features are already available or under development?
   * What is the contract of a service?
   * How can I access the service
   * In what state is the service?
   * Can I use it for production?
   * What dependencies does it have?
   * What are the central domain objects
    …

Usually, a service repository will import WSDLs, XSDs and other documents to describe the available services. However, WSDL is a rather technical webservice related description of a service. It does not define the complete formal service contract independent of the technology being used. E.g. the version of a service and it’s dependencies are not defined or considered meaningful to a certain technology stack.

Another issue is, that often SOA Governance will define additional rules that apply to service contract. The Governance board has to review every service contract, whether it meets the compliance rules, it has defined. This is going to reduce the agility in service development.

XKonneX Repository addresses these issues in several ways:

   1. Use DSLs to describe formal service contracts with all required details
   2. Use model validators to verify formal constraints without the need to involve the SOA governance board
   3. Use code generation to apply technical rules implicitly, e.g. all webservices use document/literal-wrapped SOAP style and schema centralization
