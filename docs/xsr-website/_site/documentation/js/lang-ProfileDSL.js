// Copyright (c) 2010-2017 André Arnold and others.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html


/**
 * @fileoverview
 * Registers a language handler for Profile DSL.
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
         [PR['PR_KEYWORD'],     /^(?:accepted|allow-enums|allow-inheritance|allow-polymorphism|as|attr|base-category|basic-types|budgeting|by|class|contact-info|datatype|decision-by|decision-date|decision-result|default|default-publish-header|default-request-header|default-response-header|denied|design-rule|design-rules|effective-date|end|enum|extendible-XML-attribute-clause|extendible-XML-attributes|extendible-XML-clause|extendible-parameters|extendible-properties|extendible-sub-types|extends|extensible-XML-attribute-clause|extensible-XML-attributes|extensible-XML-clause|extensible-parameters|extensible-properties|extensible-sub-types|false|fixedVersion|for|freezes-asset|frozen|governance-decision|import|initial|internal-namespace-rule|internal-qualifier|justification-doc|lifecycle|lifecycle-state|location|majorVersion|maxVersion|message-headers|messaging|meta-data|metadata|minVersion|must-contain-internal-qualifier|name-based|namespace-based|namespace-rule|namespace-rules|namespace|no-qualifier|no-trailing-slash-in-namespace-uri|operations|optional|org-namespace|other|owner|parent|pending|profile|publish|qualifier-before-last-name|qualifies-build-for|qualifies-build-for-environment|qualifies-for|qualifies-for-environment|qualifying-name|reference|replaces|request|requires-approval|response|responsible|scope|service-categories|service-rule|services|set|shorten|shortname|soa-profile|specific|specific-result|state|strict-checks|subject|subscriptions|to|type-rule|types|use-when-defined|version-evolution|version-evolution-policy|versioning-strategy|version)\b/],
         [PR['PR_LITERAL'],     /^(?:Development-Environment|Local-Environment|Other-Environment|Production-Environment|Staging-Environment|Test-Environment|URI|true|false|activity|entity|process|rule|utility)\b/],
         [PR['PR_LITERAL'],     /^(?:(?:0(?:[0-7]+|X[0-9A-F]+))L?|(?:(?:0|[1-9][0-9]*)(?:(?:\.[0-9]+)?(?:E[+\-]?[0-9]+)?F?|L?))|\\.[0-9]+(?:E[+\-]?[0-9]+)?F?)/i],
         // Treat upper camel case identifiers as types.
         [PR['PR_TYPE'],        /^[$_]*[A-Z][_$A-Z0-9]*[a-z][\w$]*/],
         [PR['PR_PLAIN'],       /^[$a-zA-Z_][\w$]*/],
         [PR['PR_COMMENT'],     /^\/(?:\/.*|\*(?:\/|\**[^*/])*(?:\*+\/?)?)/],
         [PR['PR_PUNCTUATION'], /^(?:\.+|\/)/],
         [PR['PR_STRING'],      /^((\'\'\'|\u00BB)([\s\S]*?)(\'\'\'|\u00AB))/]

        ]),
    ['ProfileDSL']);
