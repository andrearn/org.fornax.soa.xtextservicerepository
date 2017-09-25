// Copyright (c) 2010-2017 André Arnold and others.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html


/**
 * @fileoverview
 * Registers a language handler for SLA DSL.
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
         [PR['PR_KEYWORD'],     /^(?:Base64-encoded|STRING|accepted|accuracy|accuracy-assertion|additional-logging-requirements|additional-services|all|amount|applies-to|at-least-once|at-most-once|attachments|auth-tokens|authentication-procedure|availability-assertion|availability|best-effort|billed-per-unit|body|cancellation|capacity-assertion|capacity|cause|contents|costs|customer-party|data-security-and-protection|denied|description|duration|effective-date|effective-until|effort-accounting|email|encrypted-message-parts|encryption-policy|escalate-to|escalation|exactly-once|expression|extraordinary-cancellation|first-name|fixedVersion|frozen|general-security-terms|hash-algorithms|header|in-order-delivery|issuer|last-name|latency-assertion|latency|location|logging|majorVersion|max-downtime|max-downtime-assertion|max-error-rate|maxVersion|mean-time-between-failure|mean-time-to-repair|message-exchange-reliability|message-log-level|message-size|minVersion|none|num-of-requests|optional|org-unit|participation-role|penalty|pending|per|percentile|phone|preample|priority|procedure|provider-party|reference|regular-down-times|report-to|report|representative|requires-algorithm|responsibility|restrictions|scope|score-to-be-kept|security-guaranties|security-requirements|service-level-agreement|service-level-assertions|service-quality-assertions|service-quality-requirements|signed-message-parts|signing-policy|specific|subscriptions|supported-algorithms|tags|third-party|throughput-assertion|throughput|use-nonce|version)\b/],
         [PR['PR_LITERAL'],     /^(?:true|false)\b/],
         [PR['PR_LITERAL'],     /^(?:(?:0(?:[0-7]+|X[0-9A-F]+))L?|(?:(?:0|[1-9][0-9]*)(?:(?:\.[0-9]+)?(?:E[+\-]?[0-9]+)?F?|L?))|\\.[0-9]+(?:E[+\-]?[0-9]+)?F?)/i],
         // Treat upper camel case identifiers as types.
         [PR['PR_TYPE'],        /^[$_]*[A-Z][_$A-Z0-9]*[a-z][\w$]*/],
         [PR['PR_PLAIN'],       /^[$a-zA-Z_][\w$]*/],
         [PR['PR_COMMENT'],     /^\/(?:\/.*|\*(?:\/|\**[^*/])*(?:\*+\/?)?)/],
         [PR['PR_PUNCTUATION'], /^(?:\.+|\/)/],
         [PR['PR_STRING'],      /^((\'\'\'|\u00BB)([\s\S]*?)(\'\'\'|\u00AB))/]

        ]),
    ['SLADSL']);
