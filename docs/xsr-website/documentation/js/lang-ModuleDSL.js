// Copyright (c) 2010-2017 André Arnold and others.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html


/**
 * @fileoverview
 * Registers a language handler for Module DSL.
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
         [PR['PR_KEYWORD'],     /^(?:accepted|accepting-other-endpoints|additional-information|alternative-endpoint-protocols|artifactId|assembly-type|assembly-type-details|budgeting|channel|client|contact-info|decision-by|decision-date|decision-result|denied|deployment-module-name|effective-date|endpoint-protocol|endpoint-qualifier|excluding|external|fixedVersion|from-any-module-of|frozen|governance-decision|groupId|import|include-domain-sub-namespaces|include-sub-namespaces|including|justification-doc|lifecycle-state|location|majorVersion|maxVersion|minVersion|module|namespace|operations|owner|parameters|pending|provides|public|qualifier|reference|release-on|release-tag|resource|responsible|service|source-location|specific|specific-result|subject|subscriptions|tags|uses|version)\b/],
         [PR['PR_LITERAL'],     /^(?:true|false|DLL|EAR|JAR|OSGi|OTHER|SCA-Composite|SCA-EAR|WAR|WebMethods|ZIP)\b/],
         [PR['PR_LITERAL'],     /^(?:(?:0(?:[0-7]+|X[0-9A-F]+))L?|(?:(?:0|[1-9][0-9]*)(?:(?:\.[0-9]+)?(?:E[+\-]?[0-9]+)?F?|L?))|\\.[0-9]+(?:E[+\-]?[0-9]+)?F?)/i],
         // Treat upper camel case identifiers as types.
         [PR['PR_TYPE'],        /^[$_]*[A-Z][_$A-Z0-9]*[a-z][\w$]*/],
         [PR['PR_PLAIN'],       /^[$a-zA-Z_][\w$]*/],
         [PR['PR_COMMENT'],     /^\/(?:\/.*|\*(?:\/|\**[^*/])*(?:\*+\/?)?)/],
         [PR['PR_PUNCTUATION'], /^(?:\.+|\/)/],
         [PR['PR_STRING'],      /^((\'\'\'|\u00BB)([\s\S]*?)(\'\'\'|\u00AB))/]

        ]),
    ['ModuleDSL']);
