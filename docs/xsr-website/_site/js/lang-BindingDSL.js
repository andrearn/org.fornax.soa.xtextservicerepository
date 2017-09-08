// Copyright (c) 2010-2017 André Arnold and others.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html


/**
 * @fileoverview
 * Registers a language handler for Binding DSL.
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
         [PR['PR_KEYWORD'],     /^(?:Base64-encoded|HTTP|JMS|SMTP|SOAP|SOAP-v1.1|SOAP-v1.2|STRING|accepted|accuracy-assertion|all|as|assertions|at-least-once|at-most-once|attachments|auth-tokens|authn-policy|availability|availability-assertion|best-effort|billed-per-unit|bind-channel|bind-module|bind-operation|bind-resource|bind-service|body|capacity-assertion|costs|costs-assertion|decision-by|decision-date|decision-result|default-assertions|default-policies|default-protocols|default-resource-assertions|default-resource-policies|default-resource-protocols|denied|document\/literal-wrapped|effective-date|encrypted-message-parts|encryption-policy|endpoint-qualifier|environment|exactly-once|executable|expression|fixedVersion|governance-decision|hash-algorithms|header|http-context-root|import|in-order-delivery|issuer|justification-doc|latency|location|logging-policy|majorVersion|max-error-rate|maxVersion|mean-time-between-failure|mean-time-to-repair|message-exchange-reliability|message-size|minVersion|none|num-of-requests|on-connector|optional|pending|per|percentile|policies|predefined-assertion|protocol-version|protocols|provided-WSDL-Url|provided-contract|'provider-policies|provider-protocols|reference|references-module|regular-down-times|reliability-assertion|requires-algorithm|rpc\/encoded|rpc\/literal|server|signed-message-parts|signing-policy|specific|specific-result|style|subject|supported-algorithms|to|transport|use-nonce)\b/],
         [PR['PR_LITERAL'],     /^(?:true|false)\b/],
         [PR['PR_LITERAL'],     /^(?:(?:0(?:[0-7]+|X[0-9A-F]+))L?|(?:(?:0|[1-9][0-9]*)(?:(?:\.[0-9]+)?(?:E[+\-]?[0-9]+)?F?|L?))|\\.[0-9]+(?:E[+\-]?[0-9]+)?F?)/i],
         // Treat upper camel case identifiers as types.
         [PR['PR_TYPE'],        /^[$_]*[A-Z][_$A-Z0-9]*[a-z][\w$]*/],
         [PR['PR_PLAIN'],       /^[$a-zA-Z_][\w$]*/],
         [PR['PR_COMMENT'],     /^\/(?:\/.*|\*(?:\/|\**[^*/])*(?:\*+\/?)?)/],
         [PR['PR_PUNCTUATION'], /^(?:\.+|\/)/],
         [PR['PR_STRING'],      /^((\'\'\'|\u00BB)([\s\S]*?)(\'\'\'|\u00AB))/]

        ]),
    ['BindingDSL']);
