// Copyright (c) 2010-2017 André Arnold and others.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html


/**
 * @fileoverview
 * Registers a language handler for Environment DSL.
 *
 * @author André Arnold
 */

PR['registerLangHandler'](
    PR['createSimpleLexer'](
        [
          // Whitespace
         [PR['PR_PLAIN'],       /^[\t\n\r \xA0]+/, null, '\t\n\r \xA0'],
         [PR['PR_PUNCTUATION'], /^[!#%&()*+,\-:;<=>?@\[\\\]^{|}~]+/, null,
          '!#%&()*+,-:;<=>?@[\\]^{|}~'],

//         , null]
        ],
        [
         // A double or single quoted, possibly multi-line, string.
         [PR['PR_STRING'],        /^(?:"(?:[^\"\\]|\\.)*"|'(?!\'\')(?:[^\'\\]|\\.)*')/],
         // A symbol literal is a single quote followed by an identifier with no
         // single quote following
         // A character literal has single quotes on either side
         [PR['PR_STRING'],      /^'(?:[^\r\n\\']|\\(?:'|[^\r\n']+))'/],
         [PR['PR_LITERAL'],     /^'[a-zA-Z_$][\w$]*(?!['$\w])/],
         [PR['PR_KEYWORD'],     /^(?:AMQP|AppServer|Broker|COS-Naming|Corba-IOR|Development-Environment|EJB|ESB|FTP|File|HTTP|IIOP|IMAP|Infrastructure-Library|InfrastructureManager|InitialContextFactory|JCA-connection-spec|JMS|Local-Environment|Native|Other-Environment|POP3|Production-Environment|REST|RFC|RMI|RMI-Registry|Registry|SMTP|SOAP\/HTTP|SOAP\/JMS|Staging-Environment|TCP|Test-Environment|Tuxedo|UDDI|URL|accepted|accountingArea|adminUrl|admins|appserver|baseUrl|broker|client|client-ID|cluster|clustered|config-script|configuration|connection-factory-JNDI-name|connection-factory-class|connector|connectors|container|containers|context-root|data-source|dataDir|database|database-type|database-version|default|denied|deployDir|deployUser|dir|email|endpoint-visibility|environment|esb|executable|external|firstname|fixedVersion|frozen|full-qualified-name|gateway|host|identifier|identity-access-manager|image|implementation|import|infrastructure-manager|ip-address|jdbcUrl|jndi|jndi-name|jndi-url|kind|lastname|location|majorVersion|management-servers|map-port|maxVersion|minVersion|of type|owner|pending|phone|port|private|processserver|protocol-versions|public|reference|registries|registry|requires-auth|sap|schema|secure-port|secure-url|secured-port|security-protocol|server|server-type|server-version|specific|system-id|tags|to|type|url|use-IAM|user|version|versions|virtual-machine|virtual-machines|webserver)\b/],
         [PR['PR_LITERAL'],     /^(?:true|false)\b/],
         [PR['PR_LITERAL'],     /^(?:(?:0(?:[0-7]+|X[0-9A-F]+))L?|(?:(?:0|[1-9][0-9]*)(?:(?:\.[0-9]+)?(?:E[+\-]?[0-9]+)?F?|L?))|\\.[0-9]+(?:E[+\-]?[0-9]+)?F?)/i],
         // Treat upper camel case identifiers as types.
         [PR['PR_TYPE'],        /^[$_]*[A-Z][_$A-Z0-9]*[a-z][\w$]*/],
         [PR['PR_PLAIN'],       /^[$a-zA-Z_][\w$]*/],
         [PR['PR_COMMENT'],     /^\/(?:\/.*|\*(?:\/|\**[^*/])*(?:\*+\/?)?)/],
         [PR['PR_PUNCTUATION'], /^(?:\.+|\/)/],
         [PR['PR_STRING'],      /^((\'\'\'|\u00BB)([\s\S]*?)(\'\'\'|\u00AB))/]

        ]),
    ['EnvironmentDSL']);
