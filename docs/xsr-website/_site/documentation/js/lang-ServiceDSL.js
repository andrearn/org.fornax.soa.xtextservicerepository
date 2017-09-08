// Copyright (c) 2010-2017 André Arnold and others.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html


/**
 * @fileoverview
 * Registers a language handler for Service DSL.
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
         [PR['PR_KEYWORD'],     /^(?:abstract|accepted|accepts-content-type|additional-information|aggregate|architecture-profile|as|as-attachment-ref|async|base-URI|budgeting|business-key|businessObject|calling|channel|command|compensated-by|considers|contact-info|content-type|decision-by|decision-date|decision-result|default|deferred|denied|domain|domain-namespace|effective-date|entity|enum|event|exception|extends|fire+forget|fixedVersion|flat-only|frozen|governance-approval|governance-decision|handle-response-with|historized|historizing-key|idempotent|import|internal-namespace|justification-doc|lifecycle-state|links|links-to|links-to-url|location|majorVersion|mandatory|maxVersion|message-headers|metadata|minVersion|no|none|oneway|optional|org-namespace|owner|parameter|pattern|pending|persistence|private|provided-contract|provided-key|public|publish-message-header|publishers|queryObject|read|read-only|read\/write|realizes-capability|reference|release-on|replaces|request-message-header|requires|requires-channel|requires-new|resource|response-code|response-message-header|responsible|retirement-on|returns|service|service-category|set|short-description|shortname|specific|specific-result|stateful|statefulness|stateless|subject|subscribers|subscriptions|supports-capability|sync|sync+async|tags|temporarily-tolerated|throws|tolerated|topic|transaction-spec|transactional|transient-state|transmits-commands|transmits-events|updating|valueObject|version|version-independant-key|weak|write|yes)\b/],
         [PR['PR_LITERAL'],     /^(?:true|false)\b/],
         [PR['PR_LITERAL'],     /^(?:(?:0(?:[0-7]+|X[0-9A-F]+))L?|(?:(?:0|[1-9][0-9]*)(?:(?:\.[0-9]+)?(?:E[+\-]?[0-9]+)?F?|L?))|\\.[0-9]+(?:E[+\-]?[0-9]+)?F?)/i],
         // Treat upper camel case identifiers as types.
         [PR['PR_TYPE'],        /^[$_]*[A-Z][_$A-Z0-9]*[a-z][\w$]*/],
         [PR['PR_PLAIN'],       /^[$a-zA-Z_][\w$]*/],
         [PR['PR_COMMENT'],     /^\/(?:\/.*|\*(?:\/|\**[^*/])*(?:\*+\/?)?)/],
         [PR['PR_PUNCTUATION'], /^(?:\.+|\/)/],
         [PR['PR_STRING'],      /^((\'\'\'|\u00BB)([\s\S]*?)(\'\'\'|\u00AB))/]

        ]),
    ['ServiceDSL']);
