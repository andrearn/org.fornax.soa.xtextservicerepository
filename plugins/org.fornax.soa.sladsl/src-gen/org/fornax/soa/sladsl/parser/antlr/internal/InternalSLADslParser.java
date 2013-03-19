package org.fornax.soa.sladsl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.fornax.soa.sladsl.services.SLADslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalSLADslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'service-level-agreement'", "'{'", "'effective-date'", "'effective-until'", "'scope'", "'preample'", "'description'", "'restrictions'", "'applies-to'", "'}'", "'service-quality-requirements'", "'data-security-and-protection'", "'general-security-terms'", "'security-requirements'", "'additional-services'", "'cancellation'", "'extraordinary-cancellation'", "'subscriptions'", "'tags'", "'costs'", "'amount'", "'billed-per-unit'", "'effort-accounting'", "'penalty'", "'availability'", "'mean-time-between-failure'", "'mean-time-to-repair'", "'regular-down-times'", "'throughput'", "'score-to-be-kept'", "'latency'", "'STRING'", "'percentile'", "'max-downtime'", "'duration'", "'capacity'", "'num-of-requests'", "'per'", "'message-size'", "'message-exchange-reliability'", "'in-order-delivery'", "'accuracy'", "'max-error-rate'", "'logging'", "'message-log-level'", "'additional-logging-requirements'", "'.'", "'%'", "'authentication-procedure'", "'optional'", "'auth-tokens'", "'hash-algorithms'", "'use-nonce'", "'issuer'", "'Base64-encoded'", "'signing-policy'", "'supported-algorithms'", "'requires-algorithm'", "'signed-message-parts'", "','", "'expression'", "'encryption-policy'", "'encrypted-message-parts'", "'priority'", "'escalation'", "'cause'", "'escalate-to'", "'procedure'", "'customer-party'", "'provider-party'", "'third-party'", "'participation-role'", "'representative'", "'first-name'", "'last-name'", "'org-unit'", "'email'", "'phone'", "'responsibility'", "'report'", "'report-to'", "'contents'", "'-'", "'version'", "'minVersion'", "'maxVersion'", "'>='", "'<'", "'majorVersion'", "'fixedVersion'", "'.*'", "'@'", "'location'", "'reference'", "'MD5'", "'SHA1'", "'SHA256'", "'RSA'", "'PlainText'", "'header'", "'body'", "'attachments'", "'all'", "'NONE'", "'RSA_1_5'", "'AES128'", "'AES192'", "'AES256'", "'Basic128'", "'Basic192'", "'Basic256'", "'DES'", "'3DES'", "'UsernamePassword'", "'SAML'", "'SAML2'", "'Kerberos'", "'SPNEGO'", "'RELToken'", "'X509Certificate'", "'OAuth'", "'OAuth2'", "'none'", "'exactly-once'", "'at-most-once'", "'at-least-once'", "'best-effort'", "'pending'", "'accepted'", "'denied'", "'specific'"
    };
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__19=19;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__90=90;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int T__137=137;
    public static final int T__136=136;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__141=141;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__140=140;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int RULE_STRING=4;
    public static final int T__127=127;
    public static final int T__71=71;
    public static final int T__129=129;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__130=130;
    public static final int T__74=74;
    public static final int T__131=131;
    public static final int T__73=73;
    public static final int T__132=132;
    public static final int T__133=133;
    public static final int T__79=79;
    public static final int T__134=134;
    public static final int T__78=78;
    public static final int T__135=135;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int T__120=120;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__103=103;
    public static final int T__59=59;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int RULE_INT=6;
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalSLADslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSLADslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSLADslParser.tokenNames; }
    public String getGrammarFileName() { return "../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private SLADslGrammarAccess grammarAccess;
     	
        public InternalSLADslParser(TokenStream input, SLADslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "SlaModel";	
       	}
       	
       	@Override
       	protected SLADslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleSlaModel"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:74:1: entryRuleSlaModel returns [EObject current=null] : iv_ruleSlaModel= ruleSlaModel EOF ;
    public final EObject entryRuleSlaModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSlaModel = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:75:2: (iv_ruleSlaModel= ruleSlaModel EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:76:2: iv_ruleSlaModel= ruleSlaModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSlaModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSlaModel_in_entryRuleSlaModel81);
            iv_ruleSlaModel=ruleSlaModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSlaModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSlaModel91); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSlaModel"


    // $ANTLR start "ruleSlaModel"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:83:1: ruleSlaModel returns [EObject current=null] : ( (lv_agreements_0_0= ruleSLA ) )* ;
    public final EObject ruleSlaModel() throws RecognitionException {
        EObject current = null;

        EObject lv_agreements_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:86:28: ( ( (lv_agreements_0_0= ruleSLA ) )* )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:87:1: ( (lv_agreements_0_0= ruleSLA ) )*
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:87:1: ( (lv_agreements_0_0= ruleSLA ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:88:1: (lv_agreements_0_0= ruleSLA )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:88:1: (lv_agreements_0_0= ruleSLA )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:89:3: lv_agreements_0_0= ruleSLA
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSlaModelAccess().getAgreementsSLAParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleSLA_in_ruleSlaModel136);
            	    lv_agreements_0_0=ruleSLA();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSlaModelRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"agreements",
            	              		lv_agreements_0_0, 
            	              		"SLA");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSlaModel"


    // $ANTLR start "entryRuleSLA"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:113:1: entryRuleSLA returns [EObject current=null] : iv_ruleSLA= ruleSLA EOF ;
    public final EObject entryRuleSLA() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSLA = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:114:2: (iv_ruleSLA= ruleSLA EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:115:2: iv_ruleSLA= ruleSLA EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSLARule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSLA_in_entryRuleSLA172);
            iv_ruleSLA=ruleSLA();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSLA; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSLA182); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSLA"


    // $ANTLR start "ruleSLA"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:122:1: ruleSLA returns [EObject current=null] : (otherlv_0= 'service-level-agreement' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_version_2_0= ruleVersion ) )? otherlv_3= '{' otherlv_4= 'effective-date' ( (lv_effectiveDate_5_0= RULE_STRING ) ) (otherlv_6= 'effective-until' ( (lv_effectiveUntil_7_0= RULE_STRING ) ) )? ( (lv_parties_8_0= ruleParty ) )* (otherlv_9= 'scope' ( (lv_scope_10_0= RULE_STRING ) ) )? (otherlv_11= 'preample' ( (lv_preample_12_0= RULE_STRING ) ) )? (otherlv_13= 'description' ( (lv_description_14_0= RULE_STRING ) ) )? (otherlv_15= 'restrictions' ( (lv_restrictions_16_0= RULE_STRING ) ) )? ( (lv_priorities_17_0= rulePriorityDeclaration ) )* (otherlv_18= 'applies-to' otherlv_19= '{' ( (lv_appliesTo_20_0= ruleAssetRef ) )* otherlv_21= '}' )? ( (lv_costs_22_0= ruleCost ) )? (otherlv_23= 'service-quality-requirements' otherlv_24= '{' ( (lv_serviceQualityProperties_25_0= ruleServiceQualityProperty ) )* otherlv_26= '}' ) (otherlv_27= 'data-security-and-protection' otherlv_28= '{' (otherlv_29= 'general-security-terms' ( (lv_dataSecProtClause_30_0= RULE_STRING ) ) )? (otherlv_31= 'security-requirements' otherlv_32= '{' ( (lv_securityRequirements_33_0= ruleSecurityRequirement ) )* otherlv_34= '}' ) otherlv_35= '}' )? (otherlv_36= 'additional-services' ( (lv_additionalServices_37_0= RULE_STRING ) ) )? ( (lv_escalationProcedure_38_0= ruleEscalation ) )? (otherlv_39= 'cancellation' ( (lv_cancellation_40_0= RULE_STRING ) ) )? (otherlv_41= 'extraordinary-cancellation' ( (lv_extraordinaryCancellation_42_0= RULE_STRING ) ) )? ( (lv_reports_43_0= ruleReport ) )* (otherlv_44= 'subscriptions' otherlv_45= '{' ( ( ruleQualifiedName ) )* otherlv_47= '}' )? (otherlv_48= 'tags' ( (otherlv_49= RULE_ID ) )+ )* otherlv_50= '}' ) ;
    public final EObject ruleSLA() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_effectiveDate_5_0=null;
        Token otherlv_6=null;
        Token lv_effectiveUntil_7_0=null;
        Token otherlv_9=null;
        Token lv_scope_10_0=null;
        Token otherlv_11=null;
        Token lv_preample_12_0=null;
        Token otherlv_13=null;
        Token lv_description_14_0=null;
        Token otherlv_15=null;
        Token lv_restrictions_16_0=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token lv_dataSecProtClause_30_0=null;
        Token otherlv_31=null;
        Token otherlv_32=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        Token otherlv_36=null;
        Token lv_additionalServices_37_0=null;
        Token otherlv_39=null;
        Token lv_cancellation_40_0=null;
        Token otherlv_41=null;
        Token lv_extraordinaryCancellation_42_0=null;
        Token otherlv_44=null;
        Token otherlv_45=null;
        Token otherlv_47=null;
        Token otherlv_48=null;
        Token otherlv_49=null;
        Token otherlv_50=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_version_2_0 = null;

        EObject lv_parties_8_0 = null;

        EObject lv_priorities_17_0 = null;

        EObject lv_appliesTo_20_0 = null;

        EObject lv_costs_22_0 = null;

        EObject lv_serviceQualityProperties_25_0 = null;

        EObject lv_securityRequirements_33_0 = null;

        EObject lv_escalationProcedure_38_0 = null;

        EObject lv_reports_43_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:125:28: ( (otherlv_0= 'service-level-agreement' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_version_2_0= ruleVersion ) )? otherlv_3= '{' otherlv_4= 'effective-date' ( (lv_effectiveDate_5_0= RULE_STRING ) ) (otherlv_6= 'effective-until' ( (lv_effectiveUntil_7_0= RULE_STRING ) ) )? ( (lv_parties_8_0= ruleParty ) )* (otherlv_9= 'scope' ( (lv_scope_10_0= RULE_STRING ) ) )? (otherlv_11= 'preample' ( (lv_preample_12_0= RULE_STRING ) ) )? (otherlv_13= 'description' ( (lv_description_14_0= RULE_STRING ) ) )? (otherlv_15= 'restrictions' ( (lv_restrictions_16_0= RULE_STRING ) ) )? ( (lv_priorities_17_0= rulePriorityDeclaration ) )* (otherlv_18= 'applies-to' otherlv_19= '{' ( (lv_appliesTo_20_0= ruleAssetRef ) )* otherlv_21= '}' )? ( (lv_costs_22_0= ruleCost ) )? (otherlv_23= 'service-quality-requirements' otherlv_24= '{' ( (lv_serviceQualityProperties_25_0= ruleServiceQualityProperty ) )* otherlv_26= '}' ) (otherlv_27= 'data-security-and-protection' otherlv_28= '{' (otherlv_29= 'general-security-terms' ( (lv_dataSecProtClause_30_0= RULE_STRING ) ) )? (otherlv_31= 'security-requirements' otherlv_32= '{' ( (lv_securityRequirements_33_0= ruleSecurityRequirement ) )* otherlv_34= '}' ) otherlv_35= '}' )? (otherlv_36= 'additional-services' ( (lv_additionalServices_37_0= RULE_STRING ) ) )? ( (lv_escalationProcedure_38_0= ruleEscalation ) )? (otherlv_39= 'cancellation' ( (lv_cancellation_40_0= RULE_STRING ) ) )? (otherlv_41= 'extraordinary-cancellation' ( (lv_extraordinaryCancellation_42_0= RULE_STRING ) ) )? ( (lv_reports_43_0= ruleReport ) )* (otherlv_44= 'subscriptions' otherlv_45= '{' ( ( ruleQualifiedName ) )* otherlv_47= '}' )? (otherlv_48= 'tags' ( (otherlv_49= RULE_ID ) )+ )* otherlv_50= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:126:1: (otherlv_0= 'service-level-agreement' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_version_2_0= ruleVersion ) )? otherlv_3= '{' otherlv_4= 'effective-date' ( (lv_effectiveDate_5_0= RULE_STRING ) ) (otherlv_6= 'effective-until' ( (lv_effectiveUntil_7_0= RULE_STRING ) ) )? ( (lv_parties_8_0= ruleParty ) )* (otherlv_9= 'scope' ( (lv_scope_10_0= RULE_STRING ) ) )? (otherlv_11= 'preample' ( (lv_preample_12_0= RULE_STRING ) ) )? (otherlv_13= 'description' ( (lv_description_14_0= RULE_STRING ) ) )? (otherlv_15= 'restrictions' ( (lv_restrictions_16_0= RULE_STRING ) ) )? ( (lv_priorities_17_0= rulePriorityDeclaration ) )* (otherlv_18= 'applies-to' otherlv_19= '{' ( (lv_appliesTo_20_0= ruleAssetRef ) )* otherlv_21= '}' )? ( (lv_costs_22_0= ruleCost ) )? (otherlv_23= 'service-quality-requirements' otherlv_24= '{' ( (lv_serviceQualityProperties_25_0= ruleServiceQualityProperty ) )* otherlv_26= '}' ) (otherlv_27= 'data-security-and-protection' otherlv_28= '{' (otherlv_29= 'general-security-terms' ( (lv_dataSecProtClause_30_0= RULE_STRING ) ) )? (otherlv_31= 'security-requirements' otherlv_32= '{' ( (lv_securityRequirements_33_0= ruleSecurityRequirement ) )* otherlv_34= '}' ) otherlv_35= '}' )? (otherlv_36= 'additional-services' ( (lv_additionalServices_37_0= RULE_STRING ) ) )? ( (lv_escalationProcedure_38_0= ruleEscalation ) )? (otherlv_39= 'cancellation' ( (lv_cancellation_40_0= RULE_STRING ) ) )? (otherlv_41= 'extraordinary-cancellation' ( (lv_extraordinaryCancellation_42_0= RULE_STRING ) ) )? ( (lv_reports_43_0= ruleReport ) )* (otherlv_44= 'subscriptions' otherlv_45= '{' ( ( ruleQualifiedName ) )* otherlv_47= '}' )? (otherlv_48= 'tags' ( (otherlv_49= RULE_ID ) )+ )* otherlv_50= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:126:1: (otherlv_0= 'service-level-agreement' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_version_2_0= ruleVersion ) )? otherlv_3= '{' otherlv_4= 'effective-date' ( (lv_effectiveDate_5_0= RULE_STRING ) ) (otherlv_6= 'effective-until' ( (lv_effectiveUntil_7_0= RULE_STRING ) ) )? ( (lv_parties_8_0= ruleParty ) )* (otherlv_9= 'scope' ( (lv_scope_10_0= RULE_STRING ) ) )? (otherlv_11= 'preample' ( (lv_preample_12_0= RULE_STRING ) ) )? (otherlv_13= 'description' ( (lv_description_14_0= RULE_STRING ) ) )? (otherlv_15= 'restrictions' ( (lv_restrictions_16_0= RULE_STRING ) ) )? ( (lv_priorities_17_0= rulePriorityDeclaration ) )* (otherlv_18= 'applies-to' otherlv_19= '{' ( (lv_appliesTo_20_0= ruleAssetRef ) )* otherlv_21= '}' )? ( (lv_costs_22_0= ruleCost ) )? (otherlv_23= 'service-quality-requirements' otherlv_24= '{' ( (lv_serviceQualityProperties_25_0= ruleServiceQualityProperty ) )* otherlv_26= '}' ) (otherlv_27= 'data-security-and-protection' otherlv_28= '{' (otherlv_29= 'general-security-terms' ( (lv_dataSecProtClause_30_0= RULE_STRING ) ) )? (otherlv_31= 'security-requirements' otherlv_32= '{' ( (lv_securityRequirements_33_0= ruleSecurityRequirement ) )* otherlv_34= '}' ) otherlv_35= '}' )? (otherlv_36= 'additional-services' ( (lv_additionalServices_37_0= RULE_STRING ) ) )? ( (lv_escalationProcedure_38_0= ruleEscalation ) )? (otherlv_39= 'cancellation' ( (lv_cancellation_40_0= RULE_STRING ) ) )? (otherlv_41= 'extraordinary-cancellation' ( (lv_extraordinaryCancellation_42_0= RULE_STRING ) ) )? ( (lv_reports_43_0= ruleReport ) )* (otherlv_44= 'subscriptions' otherlv_45= '{' ( ( ruleQualifiedName ) )* otherlv_47= '}' )? (otherlv_48= 'tags' ( (otherlv_49= RULE_ID ) )+ )* otherlv_50= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:126:3: otherlv_0= 'service-level-agreement' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_version_2_0= ruleVersion ) )? otherlv_3= '{' otherlv_4= 'effective-date' ( (lv_effectiveDate_5_0= RULE_STRING ) ) (otherlv_6= 'effective-until' ( (lv_effectiveUntil_7_0= RULE_STRING ) ) )? ( (lv_parties_8_0= ruleParty ) )* (otherlv_9= 'scope' ( (lv_scope_10_0= RULE_STRING ) ) )? (otherlv_11= 'preample' ( (lv_preample_12_0= RULE_STRING ) ) )? (otherlv_13= 'description' ( (lv_description_14_0= RULE_STRING ) ) )? (otherlv_15= 'restrictions' ( (lv_restrictions_16_0= RULE_STRING ) ) )? ( (lv_priorities_17_0= rulePriorityDeclaration ) )* (otherlv_18= 'applies-to' otherlv_19= '{' ( (lv_appliesTo_20_0= ruleAssetRef ) )* otherlv_21= '}' )? ( (lv_costs_22_0= ruleCost ) )? (otherlv_23= 'service-quality-requirements' otherlv_24= '{' ( (lv_serviceQualityProperties_25_0= ruleServiceQualityProperty ) )* otherlv_26= '}' ) (otherlv_27= 'data-security-and-protection' otherlv_28= '{' (otherlv_29= 'general-security-terms' ( (lv_dataSecProtClause_30_0= RULE_STRING ) ) )? (otherlv_31= 'security-requirements' otherlv_32= '{' ( (lv_securityRequirements_33_0= ruleSecurityRequirement ) )* otherlv_34= '}' ) otherlv_35= '}' )? (otherlv_36= 'additional-services' ( (lv_additionalServices_37_0= RULE_STRING ) ) )? ( (lv_escalationProcedure_38_0= ruleEscalation ) )? (otherlv_39= 'cancellation' ( (lv_cancellation_40_0= RULE_STRING ) ) )? (otherlv_41= 'extraordinary-cancellation' ( (lv_extraordinaryCancellation_42_0= RULE_STRING ) ) )? ( (lv_reports_43_0= ruleReport ) )* (otherlv_44= 'subscriptions' otherlv_45= '{' ( ( ruleQualifiedName ) )* otherlv_47= '}' )? (otherlv_48= 'tags' ( (otherlv_49= RULE_ID ) )+ )* otherlv_50= '}'
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleSLA219); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSLAAccess().getServiceLevelAgreementKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:130:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:131:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:131:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:132:3: lv_name_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSLAAccess().getNameQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSLA240);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSLARule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"QualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:148:2: ( (lv_version_2_0= ruleVersion ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==94) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:149:1: (lv_version_2_0= ruleVersion )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:149:1: (lv_version_2_0= ruleVersion )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:150:3: lv_version_2_0= ruleVersion
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSLAAccess().getVersionVersionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleVersion_in_ruleSLA261);
                    lv_version_2_0=ruleVersion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSLARule());
                      	        }
                             		set(
                             			current, 
                             			"version",
                              		lv_version_2_0, 
                              		"Version");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSLA274); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getSLAAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSLA286); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getSLAAccess().getEffectiveDateKeyword_4());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:174:1: ( (lv_effectiveDate_5_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:175:1: (lv_effectiveDate_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:175:1: (lv_effectiveDate_5_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:176:3: lv_effectiveDate_5_0= RULE_STRING
            {
            lv_effectiveDate_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA303); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_effectiveDate_5_0, grammarAccess.getSLAAccess().getEffectiveDateSTRINGTerminalRuleCall_5_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getSLARule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"effectiveDate",
                      		lv_effectiveDate_5_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:192:2: (otherlv_6= 'effective-until' ( (lv_effectiveUntil_7_0= RULE_STRING ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:192:4: otherlv_6= 'effective-until' ( (lv_effectiveUntil_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSLA321); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getSLAAccess().getEffectiveUntilKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:196:1: ( (lv_effectiveUntil_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:197:1: (lv_effectiveUntil_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:197:1: (lv_effectiveUntil_7_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:198:3: lv_effectiveUntil_7_0= RULE_STRING
                    {
                    lv_effectiveUntil_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA338); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_effectiveUntil_7_0, grammarAccess.getSLAAccess().getEffectiveUntilSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"effectiveUntil",
                              		lv_effectiveUntil_7_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:214:4: ( (lv_parties_8_0= ruleParty ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=79 && LA4_0<=81)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:215:1: (lv_parties_8_0= ruleParty )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:215:1: (lv_parties_8_0= ruleParty )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:216:3: lv_parties_8_0= ruleParty
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSLAAccess().getPartiesPartyParserRuleCall_7_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleParty_in_ruleSLA366);
            	    lv_parties_8_0=ruleParty();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSLARule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"parties",
            	              		lv_parties_8_0, 
            	              		"Party");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:232:3: (otherlv_9= 'scope' ( (lv_scope_10_0= RULE_STRING ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:232:5: otherlv_9= 'scope' ( (lv_scope_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSLA380); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getSLAAccess().getScopeKeyword_8_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:236:1: ( (lv_scope_10_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:237:1: (lv_scope_10_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:237:1: (lv_scope_10_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:238:3: lv_scope_10_0= RULE_STRING
                    {
                    lv_scope_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA397); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_scope_10_0, grammarAccess.getSLAAccess().getScopeSTRINGTerminalRuleCall_8_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"scope",
                              		lv_scope_10_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:254:4: (otherlv_11= 'preample' ( (lv_preample_12_0= RULE_STRING ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:254:6: otherlv_11= 'preample' ( (lv_preample_12_0= RULE_STRING ) )
                    {
                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSLA417); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getSLAAccess().getPreampleKeyword_9_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:258:1: ( (lv_preample_12_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:259:1: (lv_preample_12_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:259:1: (lv_preample_12_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:260:3: lv_preample_12_0= RULE_STRING
                    {
                    lv_preample_12_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA434); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_preample_12_0, grammarAccess.getSLAAccess().getPreampleSTRINGTerminalRuleCall_9_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"preample",
                              		lv_preample_12_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:276:4: (otherlv_13= 'description' ( (lv_description_14_0= RULE_STRING ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:276:6: otherlv_13= 'description' ( (lv_description_14_0= RULE_STRING ) )
                    {
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSLA454); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getSLAAccess().getDescriptionKeyword_10_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:280:1: ( (lv_description_14_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:281:1: (lv_description_14_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:281:1: (lv_description_14_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:282:3: lv_description_14_0= RULE_STRING
                    {
                    lv_description_14_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA471); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_description_14_0, grammarAccess.getSLAAccess().getDescriptionSTRINGTerminalRuleCall_10_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"description",
                              		lv_description_14_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:298:4: (otherlv_15= 'restrictions' ( (lv_restrictions_16_0= RULE_STRING ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:298:6: otherlv_15= 'restrictions' ( (lv_restrictions_16_0= RULE_STRING ) )
                    {
                    otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSLA491); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getSLAAccess().getRestrictionsKeyword_11_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:302:1: ( (lv_restrictions_16_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:303:1: (lv_restrictions_16_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:303:1: (lv_restrictions_16_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:304:3: lv_restrictions_16_0= RULE_STRING
                    {
                    lv_restrictions_16_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA508); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_restrictions_16_0, grammarAccess.getSLAAccess().getRestrictionsSTRINGTerminalRuleCall_11_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"restrictions",
                              		lv_restrictions_16_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:320:4: ( (lv_priorities_17_0= rulePriorityDeclaration ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==74) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:321:1: (lv_priorities_17_0= rulePriorityDeclaration )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:321:1: (lv_priorities_17_0= rulePriorityDeclaration )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:322:3: lv_priorities_17_0= rulePriorityDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSLAAccess().getPrioritiesPriorityDeclarationParserRuleCall_12_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_rulePriorityDeclaration_in_ruleSLA536);
            	    lv_priorities_17_0=rulePriorityDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSLARule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"priorities",
            	              		lv_priorities_17_0, 
            	              		"PriorityDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:338:3: (otherlv_18= 'applies-to' otherlv_19= '{' ( (lv_appliesTo_20_0= ruleAssetRef ) )* otherlv_21= '}' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:338:5: otherlv_18= 'applies-to' otherlv_19= '{' ( (lv_appliesTo_20_0= ruleAssetRef ) )* otherlv_21= '}'
                    {
                    otherlv_18=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSLA550); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getSLAAccess().getAppliesToKeyword_13_0());
                          
                    }
                    otherlv_19=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSLA562); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getSLAAccess().getLeftCurlyBracketKeyword_13_1());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:346:1: ( (lv_appliesTo_20_0= ruleAssetRef ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_ID) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:347:1: (lv_appliesTo_20_0= ruleAssetRef )
                    	    {
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:347:1: (lv_appliesTo_20_0= ruleAssetRef )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:348:3: lv_appliesTo_20_0= ruleAssetRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSLAAccess().getAppliesToAssetRefParserRuleCall_13_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssetRef_in_ruleSLA583);
                    	    lv_appliesTo_20_0=ruleAssetRef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSLARule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"appliesTo",
                    	              		lv_appliesTo_20_0, 
                    	              		"AssetRef");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    otherlv_21=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSLA596); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_21, grammarAccess.getSLAAccess().getRightCurlyBracketKeyword_13_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:368:3: ( (lv_costs_22_0= ruleCost ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==30) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:369:1: (lv_costs_22_0= ruleCost )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:369:1: (lv_costs_22_0= ruleCost )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:370:3: lv_costs_22_0= ruleCost
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSLAAccess().getCostsCostParserRuleCall_14_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCost_in_ruleSLA619);
                    lv_costs_22_0=ruleCost();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSLARule());
                      	        }
                             		set(
                             			current, 
                             			"costs",
                              		lv_costs_22_0, 
                              		"Cost");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:386:3: (otherlv_23= 'service-quality-requirements' otherlv_24= '{' ( (lv_serviceQualityProperties_25_0= ruleServiceQualityProperty ) )* otherlv_26= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:386:5: otherlv_23= 'service-quality-requirements' otherlv_24= '{' ( (lv_serviceQualityProperties_25_0= ruleServiceQualityProperty ) )* otherlv_26= '}'
            {
            otherlv_23=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleSLA633); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_23, grammarAccess.getSLAAccess().getServiceQualityRequirementsKeyword_15_0());
                  
            }
            otherlv_24=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSLA645); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_24, grammarAccess.getSLAAccess().getLeftCurlyBracketKeyword_15_1());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:394:1: ( (lv_serviceQualityProperties_25_0= ruleServiceQualityProperty ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==35||LA13_0==39||LA13_0==41||LA13_0==44||LA13_0==46||LA13_0==50||LA13_0==52||LA13_0==54) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:395:1: (lv_serviceQualityProperties_25_0= ruleServiceQualityProperty )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:395:1: (lv_serviceQualityProperties_25_0= ruleServiceQualityProperty )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:396:3: lv_serviceQualityProperties_25_0= ruleServiceQualityProperty
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSLAAccess().getServiceQualityPropertiesServiceQualityPropertyParserRuleCall_15_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceQualityProperty_in_ruleSLA666);
            	    lv_serviceQualityProperties_25_0=ruleServiceQualityProperty();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSLARule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"serviceQualityProperties",
            	              		lv_serviceQualityProperties_25_0, 
            	              		"ServiceQualityProperty");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_26=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSLA679); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_26, grammarAccess.getSLAAccess().getRightCurlyBracketKeyword_15_3());
                  
            }

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:416:2: (otherlv_27= 'data-security-and-protection' otherlv_28= '{' (otherlv_29= 'general-security-terms' ( (lv_dataSecProtClause_30_0= RULE_STRING ) ) )? (otherlv_31= 'security-requirements' otherlv_32= '{' ( (lv_securityRequirements_33_0= ruleSecurityRequirement ) )* otherlv_34= '}' ) otherlv_35= '}' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==22) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:416:4: otherlv_27= 'data-security-and-protection' otherlv_28= '{' (otherlv_29= 'general-security-terms' ( (lv_dataSecProtClause_30_0= RULE_STRING ) ) )? (otherlv_31= 'security-requirements' otherlv_32= '{' ( (lv_securityRequirements_33_0= ruleSecurityRequirement ) )* otherlv_34= '}' ) otherlv_35= '}'
                    {
                    otherlv_27=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleSLA693); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_27, grammarAccess.getSLAAccess().getDataSecurityAndProtectionKeyword_16_0());
                          
                    }
                    otherlv_28=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSLA705); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_28, grammarAccess.getSLAAccess().getLeftCurlyBracketKeyword_16_1());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:424:1: (otherlv_29= 'general-security-terms' ( (lv_dataSecProtClause_30_0= RULE_STRING ) ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==23) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:424:3: otherlv_29= 'general-security-terms' ( (lv_dataSecProtClause_30_0= RULE_STRING ) )
                            {
                            otherlv_29=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleSLA718); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_29, grammarAccess.getSLAAccess().getGeneralSecurityTermsKeyword_16_2_0());
                                  
                            }
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:428:1: ( (lv_dataSecProtClause_30_0= RULE_STRING ) )
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:429:1: (lv_dataSecProtClause_30_0= RULE_STRING )
                            {
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:429:1: (lv_dataSecProtClause_30_0= RULE_STRING )
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:430:3: lv_dataSecProtClause_30_0= RULE_STRING
                            {
                            lv_dataSecProtClause_30_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA735); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_dataSecProtClause_30_0, grammarAccess.getSLAAccess().getDataSecProtClauseSTRINGTerminalRuleCall_16_2_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSLARule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"dataSecProtClause",
                                      		lv_dataSecProtClause_30_0, 
                                      		"STRING");
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:446:4: (otherlv_31= 'security-requirements' otherlv_32= '{' ( (lv_securityRequirements_33_0= ruleSecurityRequirement ) )* otherlv_34= '}' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:446:6: otherlv_31= 'security-requirements' otherlv_32= '{' ( (lv_securityRequirements_33_0= ruleSecurityRequirement ) )* otherlv_34= '}'
                    {
                    otherlv_31=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleSLA755); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_31, grammarAccess.getSLAAccess().getSecurityRequirementsKeyword_16_3_0());
                          
                    }
                    otherlv_32=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSLA767); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_32, grammarAccess.getSLAAccess().getLeftCurlyBracketKeyword_16_3_1());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:454:1: ( (lv_securityRequirements_33_0= ruleSecurityRequirement ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==59||LA15_0==66||LA15_0==72) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:455:1: (lv_securityRequirements_33_0= ruleSecurityRequirement )
                    	    {
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:455:1: (lv_securityRequirements_33_0= ruleSecurityRequirement )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:456:3: lv_securityRequirements_33_0= ruleSecurityRequirement
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSLAAccess().getSecurityRequirementsSecurityRequirementParserRuleCall_16_3_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleSecurityRequirement_in_ruleSLA788);
                    	    lv_securityRequirements_33_0=ruleSecurityRequirement();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSLARule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"securityRequirements",
                    	              		lv_securityRequirements_33_0, 
                    	              		"SecurityRequirement");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_34=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSLA801); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_34, grammarAccess.getSLAAccess().getRightCurlyBracketKeyword_16_3_3());
                          
                    }

                    }

                    otherlv_35=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSLA814); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_35, grammarAccess.getSLAAccess().getRightCurlyBracketKeyword_16_4());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:480:3: (otherlv_36= 'additional-services' ( (lv_additionalServices_37_0= RULE_STRING ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==25) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:480:5: otherlv_36= 'additional-services' ( (lv_additionalServices_37_0= RULE_STRING ) )
                    {
                    otherlv_36=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleSLA829); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_36, grammarAccess.getSLAAccess().getAdditionalServicesKeyword_17_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:484:1: ( (lv_additionalServices_37_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:485:1: (lv_additionalServices_37_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:485:1: (lv_additionalServices_37_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:486:3: lv_additionalServices_37_0= RULE_STRING
                    {
                    lv_additionalServices_37_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA846); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_additionalServices_37_0, grammarAccess.getSLAAccess().getAdditionalServicesSTRINGTerminalRuleCall_17_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"additionalServices",
                              		lv_additionalServices_37_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:502:4: ( (lv_escalationProcedure_38_0= ruleEscalation ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==75) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:503:1: (lv_escalationProcedure_38_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:503:1: (lv_escalationProcedure_38_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:504:3: lv_escalationProcedure_38_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSLAAccess().getEscalationProcedureEscalationParserRuleCall_18_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleSLA874);
                    lv_escalationProcedure_38_0=ruleEscalation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSLARule());
                      	        }
                             		set(
                             			current, 
                             			"escalationProcedure",
                              		lv_escalationProcedure_38_0, 
                              		"Escalation");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:520:3: (otherlv_39= 'cancellation' ( (lv_cancellation_40_0= RULE_STRING ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==26) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:520:5: otherlv_39= 'cancellation' ( (lv_cancellation_40_0= RULE_STRING ) )
                    {
                    otherlv_39=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleSLA888); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_39, grammarAccess.getSLAAccess().getCancellationKeyword_19_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:524:1: ( (lv_cancellation_40_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:525:1: (lv_cancellation_40_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:525:1: (lv_cancellation_40_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:526:3: lv_cancellation_40_0= RULE_STRING
                    {
                    lv_cancellation_40_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA905); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_cancellation_40_0, grammarAccess.getSLAAccess().getCancellationSTRINGTerminalRuleCall_19_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"cancellation",
                              		lv_cancellation_40_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:542:4: (otherlv_41= 'extraordinary-cancellation' ( (lv_extraordinaryCancellation_42_0= RULE_STRING ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:542:6: otherlv_41= 'extraordinary-cancellation' ( (lv_extraordinaryCancellation_42_0= RULE_STRING ) )
                    {
                    otherlv_41=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleSLA925); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_41, grammarAccess.getSLAAccess().getExtraordinaryCancellationKeyword_20_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:546:1: ( (lv_extraordinaryCancellation_42_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:547:1: (lv_extraordinaryCancellation_42_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:547:1: (lv_extraordinaryCancellation_42_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:548:3: lv_extraordinaryCancellation_42_0= RULE_STRING
                    {
                    lv_extraordinaryCancellation_42_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA942); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_extraordinaryCancellation_42_0, grammarAccess.getSLAAccess().getExtraordinaryCancellationSTRINGTerminalRuleCall_20_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"extraordinaryCancellation",
                              		lv_extraordinaryCancellation_42_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:564:4: ( (lv_reports_43_0= ruleReport ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==90) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:565:1: (lv_reports_43_0= ruleReport )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:565:1: (lv_reports_43_0= ruleReport )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:566:3: lv_reports_43_0= ruleReport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSLAAccess().getReportsReportParserRuleCall_21_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleReport_in_ruleSLA970);
            	    lv_reports_43_0=ruleReport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSLARule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"reports",
            	              		lv_reports_43_0, 
            	              		"Report");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:582:3: (otherlv_44= 'subscriptions' otherlv_45= '{' ( ( ruleQualifiedName ) )* otherlv_47= '}' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==28) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:582:5: otherlv_44= 'subscriptions' otherlv_45= '{' ( ( ruleQualifiedName ) )* otherlv_47= '}'
                    {
                    otherlv_44=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleSLA984); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_44, grammarAccess.getSLAAccess().getSubscriptionsKeyword_22_0());
                          
                    }
                    otherlv_45=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSLA996); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_45, grammarAccess.getSLAAccess().getLeftCurlyBracketKeyword_22_1());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:590:1: ( ( ruleQualifiedName ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==RULE_ID) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:591:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:591:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:592:3: ruleQualifiedName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getSLARule());
                    	      	        }
                    	              
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSLAAccess().getSubscriptionsUserCrossReference_22_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSLA1023);
                    	    ruleQualifiedName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    otherlv_47=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSLA1036); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_47, grammarAccess.getSLAAccess().getRightCurlyBracketKeyword_22_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:612:3: (otherlv_48= 'tags' ( (otherlv_49= RULE_ID ) )+ )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==29) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:612:5: otherlv_48= 'tags' ( (otherlv_49= RULE_ID ) )+
            	    {
            	    otherlv_48=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleSLA1051); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_48, grammarAccess.getSLAAccess().getTagsKeyword_23_0());
            	          
            	    }
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:616:1: ( (otherlv_49= RULE_ID ) )+
            	    int cnt24=0;
            	    loop24:
            	    do {
            	        int alt24=2;
            	        int LA24_0 = input.LA(1);

            	        if ( (LA24_0==RULE_ID) ) {
            	            alt24=1;
            	        }


            	        switch (alt24) {
            	    	case 1 :
            	    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:617:1: (otherlv_49= RULE_ID )
            	    	    {
            	    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:617:1: (otherlv_49= RULE_ID )
            	    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:618:3: otherlv_49= RULE_ID
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      		  /* */ 
            	    	      		
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      			if (current==null) {
            	    	      	            current = createModelElement(grammarAccess.getSLARule());
            	    	      	        }
            	    	              
            	    	    }
            	    	    otherlv_49=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSLA1075); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      		newLeafNode(otherlv_49, grammarAccess.getSLAAccess().getTagsTagCrossReference_23_1_0()); 
            	    	      	
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt24 >= 1 ) break loop24;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(24, input);
            	                throw eee;
            	        }
            	        cnt24++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            otherlv_50=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSLA1090); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_50, grammarAccess.getSLAAccess().getRightCurlyBracketKeyword_24());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSLA"


    // $ANTLR start "entryRuleCost"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:644:1: entryRuleCost returns [EObject current=null] : iv_ruleCost= ruleCost EOF ;
    public final EObject entryRuleCost() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCost = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:645:2: (iv_ruleCost= ruleCost EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:646:2: iv_ruleCost= ruleCost EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCostRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCost_in_entryRuleCost1126);
            iv_ruleCost=ruleCost();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCost; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCost1136); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCost"


    // $ANTLR start "ruleCost"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:653:1: ruleCost returns [EObject current=null] : (otherlv_0= 'costs' otherlv_1= '{' otherlv_2= 'amount' ( (lv_costsAmount_3_0= RULE_STRING ) ) otherlv_4= 'billed-per-unit' ( (lv_billedUnit_5_0= RULE_STRING ) ) (otherlv_6= 'effort-accounting' ( (lv_effortAccounting_7_0= RULE_STRING ) ) )? ( (lv_escalation_8_0= ruleEscalation ) )? (otherlv_9= 'penalty' ( (lv_penalty_10_0= RULE_STRING ) ) )? otherlv_11= '}' ) ;
    public final EObject ruleCost() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_costsAmount_3_0=null;
        Token otherlv_4=null;
        Token lv_billedUnit_5_0=null;
        Token otherlv_6=null;
        Token lv_effortAccounting_7_0=null;
        Token otherlv_9=null;
        Token lv_penalty_10_0=null;
        Token otherlv_11=null;
        EObject lv_escalation_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:656:28: ( (otherlv_0= 'costs' otherlv_1= '{' otherlv_2= 'amount' ( (lv_costsAmount_3_0= RULE_STRING ) ) otherlv_4= 'billed-per-unit' ( (lv_billedUnit_5_0= RULE_STRING ) ) (otherlv_6= 'effort-accounting' ( (lv_effortAccounting_7_0= RULE_STRING ) ) )? ( (lv_escalation_8_0= ruleEscalation ) )? (otherlv_9= 'penalty' ( (lv_penalty_10_0= RULE_STRING ) ) )? otherlv_11= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:657:1: (otherlv_0= 'costs' otherlv_1= '{' otherlv_2= 'amount' ( (lv_costsAmount_3_0= RULE_STRING ) ) otherlv_4= 'billed-per-unit' ( (lv_billedUnit_5_0= RULE_STRING ) ) (otherlv_6= 'effort-accounting' ( (lv_effortAccounting_7_0= RULE_STRING ) ) )? ( (lv_escalation_8_0= ruleEscalation ) )? (otherlv_9= 'penalty' ( (lv_penalty_10_0= RULE_STRING ) ) )? otherlv_11= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:657:1: (otherlv_0= 'costs' otherlv_1= '{' otherlv_2= 'amount' ( (lv_costsAmount_3_0= RULE_STRING ) ) otherlv_4= 'billed-per-unit' ( (lv_billedUnit_5_0= RULE_STRING ) ) (otherlv_6= 'effort-accounting' ( (lv_effortAccounting_7_0= RULE_STRING ) ) )? ( (lv_escalation_8_0= ruleEscalation ) )? (otherlv_9= 'penalty' ( (lv_penalty_10_0= RULE_STRING ) ) )? otherlv_11= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:657:3: otherlv_0= 'costs' otherlv_1= '{' otherlv_2= 'amount' ( (lv_costsAmount_3_0= RULE_STRING ) ) otherlv_4= 'billed-per-unit' ( (lv_billedUnit_5_0= RULE_STRING ) ) (otherlv_6= 'effort-accounting' ( (lv_effortAccounting_7_0= RULE_STRING ) ) )? ( (lv_escalation_8_0= ruleEscalation ) )? (otherlv_9= 'penalty' ( (lv_penalty_10_0= RULE_STRING ) ) )? otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleCost1173); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getCostAccess().getCostsKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleCost1185); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCostAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleCost1197); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getCostAccess().getAmountKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:669:1: ( (lv_costsAmount_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:670:1: (lv_costsAmount_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:670:1: (lv_costsAmount_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:671:3: lv_costsAmount_3_0= RULE_STRING
            {
            lv_costsAmount_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCost1214); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_costsAmount_3_0, grammarAccess.getCostAccess().getCostsAmountSTRINGTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getCostRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"costsAmount",
                      		lv_costsAmount_3_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleCost1231); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getCostAccess().getBilledPerUnitKeyword_4());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:691:1: ( (lv_billedUnit_5_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:692:1: (lv_billedUnit_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:692:1: (lv_billedUnit_5_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:693:3: lv_billedUnit_5_0= RULE_STRING
            {
            lv_billedUnit_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCost1248); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_billedUnit_5_0, grammarAccess.getCostAccess().getBilledUnitSTRINGTerminalRuleCall_5_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getCostRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"billedUnit",
                      		lv_billedUnit_5_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:709:2: (otherlv_6= 'effort-accounting' ( (lv_effortAccounting_7_0= RULE_STRING ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==33) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:709:4: otherlv_6= 'effort-accounting' ( (lv_effortAccounting_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleCost1266); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getCostAccess().getEffortAccountingKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:713:1: ( (lv_effortAccounting_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:714:1: (lv_effortAccounting_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:714:1: (lv_effortAccounting_7_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:715:3: lv_effortAccounting_7_0= RULE_STRING
                    {
                    lv_effortAccounting_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCost1283); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_effortAccounting_7_0, grammarAccess.getCostAccess().getEffortAccountingSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getCostRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"effortAccounting",
                              		lv_effortAccounting_7_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:731:4: ( (lv_escalation_8_0= ruleEscalation ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==75) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:732:1: (lv_escalation_8_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:732:1: (lv_escalation_8_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:733:3: lv_escalation_8_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCostAccess().getEscalationEscalationParserRuleCall_7_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleCost1311);
                    lv_escalation_8_0=ruleEscalation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCostRule());
                      	        }
                             		set(
                             			current, 
                             			"escalation",
                              		lv_escalation_8_0, 
                              		"Escalation");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:749:3: (otherlv_9= 'penalty' ( (lv_penalty_10_0= RULE_STRING ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==34) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:749:5: otherlv_9= 'penalty' ( (lv_penalty_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleCost1325); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getCostAccess().getPenaltyKeyword_8_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:753:1: ( (lv_penalty_10_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:754:1: (lv_penalty_10_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:754:1: (lv_penalty_10_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:755:3: lv_penalty_10_0= RULE_STRING
                    {
                    lv_penalty_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCost1342); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_penalty_10_0, grammarAccess.getCostAccess().getPenaltySTRINGTerminalRuleCall_8_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getCostRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"penalty",
                              		lv_penalty_10_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleCost1361); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getCostAccess().getRightCurlyBracketKeyword_9());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCost"


    // $ANTLR start "entryRuleServiceQualityProperty"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:783:1: entryRuleServiceQualityProperty returns [EObject current=null] : iv_ruleServiceQualityProperty= ruleServiceQualityProperty EOF ;
    public final EObject entryRuleServiceQualityProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceQualityProperty = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:784:2: (iv_ruleServiceQualityProperty= ruleServiceQualityProperty EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:785:2: iv_ruleServiceQualityProperty= ruleServiceQualityProperty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getServiceQualityPropertyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceQualityProperty_in_entryRuleServiceQualityProperty1397);
            iv_ruleServiceQualityProperty=ruleServiceQualityProperty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleServiceQualityProperty; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleServiceQualityProperty1407); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceQualityProperty"


    // $ANTLR start "ruleServiceQualityProperty"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:792:1: ruleServiceQualityProperty returns [EObject current=null] : (this_Availability_0= ruleAvailability | this_Throughput_1= ruleThroughput | this_Latency_2= ruleLatency | this_MaxDownTime_3= ruleMaxDownTime | this_CapacityRequirement_4= ruleCapacityRequirement | this_AccuracyRequirement_5= ruleAccuracyRequirement | this_ReliablityRequirement_6= ruleReliablityRequirement | this_LogRequirement_7= ruleLogRequirement ) ;
    public final EObject ruleServiceQualityProperty() throws RecognitionException {
        EObject current = null;

        EObject this_Availability_0 = null;

        EObject this_Throughput_1 = null;

        EObject this_Latency_2 = null;

        EObject this_MaxDownTime_3 = null;

        EObject this_CapacityRequirement_4 = null;

        EObject this_AccuracyRequirement_5 = null;

        EObject this_ReliablityRequirement_6 = null;

        EObject this_LogRequirement_7 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:795:28: ( (this_Availability_0= ruleAvailability | this_Throughput_1= ruleThroughput | this_Latency_2= ruleLatency | this_MaxDownTime_3= ruleMaxDownTime | this_CapacityRequirement_4= ruleCapacityRequirement | this_AccuracyRequirement_5= ruleAccuracyRequirement | this_ReliablityRequirement_6= ruleReliablityRequirement | this_LogRequirement_7= ruleLogRequirement ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:796:1: (this_Availability_0= ruleAvailability | this_Throughput_1= ruleThroughput | this_Latency_2= ruleLatency | this_MaxDownTime_3= ruleMaxDownTime | this_CapacityRequirement_4= ruleCapacityRequirement | this_AccuracyRequirement_5= ruleAccuracyRequirement | this_ReliablityRequirement_6= ruleReliablityRequirement | this_LogRequirement_7= ruleLogRequirement )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:796:1: (this_Availability_0= ruleAvailability | this_Throughput_1= ruleThroughput | this_Latency_2= ruleLatency | this_MaxDownTime_3= ruleMaxDownTime | this_CapacityRequirement_4= ruleCapacityRequirement | this_AccuracyRequirement_5= ruleAccuracyRequirement | this_ReliablityRequirement_6= ruleReliablityRequirement | this_LogRequirement_7= ruleLogRequirement )
            int alt29=8;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt29=1;
                }
                break;
            case 39:
                {
                alt29=2;
                }
                break;
            case 41:
                {
                alt29=3;
                }
                break;
            case 44:
                {
                alt29=4;
                }
                break;
            case 46:
                {
                alt29=5;
                }
                break;
            case 52:
                {
                alt29=6;
                }
                break;
            case 50:
                {
                alt29=7;
                }
                break;
            case 54:
                {
                alt29=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:797:2: this_Availability_0= ruleAvailability
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getAvailabilityParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAvailability_in_ruleServiceQualityProperty1457);
                    this_Availability_0=ruleAvailability();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Availability_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:810:2: this_Throughput_1= ruleThroughput
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getThroughputParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleThroughput_in_ruleServiceQualityProperty1487);
                    this_Throughput_1=ruleThroughput();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Throughput_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:823:2: this_Latency_2= ruleLatency
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getLatencyParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLatency_in_ruleServiceQualityProperty1517);
                    this_Latency_2=ruleLatency();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Latency_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:836:2: this_MaxDownTime_3= ruleMaxDownTime
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getMaxDownTimeParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMaxDownTime_in_ruleServiceQualityProperty1547);
                    this_MaxDownTime_3=ruleMaxDownTime();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MaxDownTime_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:849:2: this_CapacityRequirement_4= ruleCapacityRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getCapacityRequirementParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCapacityRequirement_in_ruleServiceQualityProperty1577);
                    this_CapacityRequirement_4=ruleCapacityRequirement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CapacityRequirement_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:862:2: this_AccuracyRequirement_5= ruleAccuracyRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getAccuracyRequirementParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAccuracyRequirement_in_ruleServiceQualityProperty1607);
                    this_AccuracyRequirement_5=ruleAccuracyRequirement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AccuracyRequirement_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:875:2: this_ReliablityRequirement_6= ruleReliablityRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getReliablityRequirementParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleReliablityRequirement_in_ruleServiceQualityProperty1637);
                    this_ReliablityRequirement_6=ruleReliablityRequirement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ReliablityRequirement_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:888:2: this_LogRequirement_7= ruleLogRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getLogRequirementParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLogRequirement_in_ruleServiceQualityProperty1667);
                    this_LogRequirement_7=ruleLogRequirement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LogRequirement_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceQualityProperty"


    // $ANTLR start "entryRuleAvailability"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:907:1: entryRuleAvailability returns [EObject current=null] : iv_ruleAvailability= ruleAvailability EOF ;
    public final EObject entryRuleAvailability() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAvailability = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:908:2: (iv_ruleAvailability= ruleAvailability EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:909:2: iv_ruleAvailability= ruleAvailability EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAvailabilityRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAvailability_in_entryRuleAvailability1702);
            iv_ruleAvailability=ruleAvailability();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAvailability; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAvailability1712); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAvailability"


    // $ANTLR start "ruleAvailability"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:916:1: ruleAvailability returns [EObject current=null] : (otherlv_0= 'availability' otherlv_1= '{' otherlv_2= 'availability' ( (lv_availability_3_0= RULE_STRING ) ) (otherlv_4= 'mean-time-between-failure' ( (lv_mtbf_5_0= RULE_STRING ) ) )? (otherlv_6= 'mean-time-to-repair' ( (lv_mttr_7_0= RULE_STRING ) ) ( (lv_mttrPercentile_8_0= rulePercentile ) )? )? (otherlv_9= 'regular-down-times' ( (lv_regularDownTimes_10_0= RULE_STRING ) ) )? otherlv_11= '}' ) ;
    public final EObject ruleAvailability() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_availability_3_0=null;
        Token otherlv_4=null;
        Token lv_mtbf_5_0=null;
        Token otherlv_6=null;
        Token lv_mttr_7_0=null;
        Token otherlv_9=null;
        Token lv_regularDownTimes_10_0=null;
        Token otherlv_11=null;
        EObject lv_mttrPercentile_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:919:28: ( (otherlv_0= 'availability' otherlv_1= '{' otherlv_2= 'availability' ( (lv_availability_3_0= RULE_STRING ) ) (otherlv_4= 'mean-time-between-failure' ( (lv_mtbf_5_0= RULE_STRING ) ) )? (otherlv_6= 'mean-time-to-repair' ( (lv_mttr_7_0= RULE_STRING ) ) ( (lv_mttrPercentile_8_0= rulePercentile ) )? )? (otherlv_9= 'regular-down-times' ( (lv_regularDownTimes_10_0= RULE_STRING ) ) )? otherlv_11= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:920:1: (otherlv_0= 'availability' otherlv_1= '{' otherlv_2= 'availability' ( (lv_availability_3_0= RULE_STRING ) ) (otherlv_4= 'mean-time-between-failure' ( (lv_mtbf_5_0= RULE_STRING ) ) )? (otherlv_6= 'mean-time-to-repair' ( (lv_mttr_7_0= RULE_STRING ) ) ( (lv_mttrPercentile_8_0= rulePercentile ) )? )? (otherlv_9= 'regular-down-times' ( (lv_regularDownTimes_10_0= RULE_STRING ) ) )? otherlv_11= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:920:1: (otherlv_0= 'availability' otherlv_1= '{' otherlv_2= 'availability' ( (lv_availability_3_0= RULE_STRING ) ) (otherlv_4= 'mean-time-between-failure' ( (lv_mtbf_5_0= RULE_STRING ) ) )? (otherlv_6= 'mean-time-to-repair' ( (lv_mttr_7_0= RULE_STRING ) ) ( (lv_mttrPercentile_8_0= rulePercentile ) )? )? (otherlv_9= 'regular-down-times' ( (lv_regularDownTimes_10_0= RULE_STRING ) ) )? otherlv_11= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:920:3: otherlv_0= 'availability' otherlv_1= '{' otherlv_2= 'availability' ( (lv_availability_3_0= RULE_STRING ) ) (otherlv_4= 'mean-time-between-failure' ( (lv_mtbf_5_0= RULE_STRING ) ) )? (otherlv_6= 'mean-time-to-repair' ( (lv_mttr_7_0= RULE_STRING ) ) ( (lv_mttrPercentile_8_0= rulePercentile ) )? )? (otherlv_9= 'regular-down-times' ( (lv_regularDownTimes_10_0= RULE_STRING ) ) )? otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleAvailability1749); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAvailabilityAccess().getAvailabilityKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAvailability1761); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAvailabilityAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleAvailability1773); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAvailabilityAccess().getAvailabilityKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:932:1: ( (lv_availability_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:933:1: (lv_availability_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:933:1: (lv_availability_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:934:3: lv_availability_3_0= RULE_STRING
            {
            lv_availability_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAvailability1790); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_availability_3_0, grammarAccess.getAvailabilityAccess().getAvailabilitySTRINGTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAvailabilityRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"availability",
                      		lv_availability_3_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:950:2: (otherlv_4= 'mean-time-between-failure' ( (lv_mtbf_5_0= RULE_STRING ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==36) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:950:4: otherlv_4= 'mean-time-between-failure' ( (lv_mtbf_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleAvailability1808); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getAvailabilityAccess().getMeanTimeBetweenFailureKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:954:1: ( (lv_mtbf_5_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:955:1: (lv_mtbf_5_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:955:1: (lv_mtbf_5_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:956:3: lv_mtbf_5_0= RULE_STRING
                    {
                    lv_mtbf_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAvailability1825); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_mtbf_5_0, grammarAccess.getAvailabilityAccess().getMtbfSTRINGTerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAvailabilityRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"mtbf",
                              		lv_mtbf_5_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:972:4: (otherlv_6= 'mean-time-to-repair' ( (lv_mttr_7_0= RULE_STRING ) ) ( (lv_mttrPercentile_8_0= rulePercentile ) )? )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==37) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:972:6: otherlv_6= 'mean-time-to-repair' ( (lv_mttr_7_0= RULE_STRING ) ) ( (lv_mttrPercentile_8_0= rulePercentile ) )?
                    {
                    otherlv_6=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleAvailability1845); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getAvailabilityAccess().getMeanTimeToRepairKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:976:1: ( (lv_mttr_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:977:1: (lv_mttr_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:977:1: (lv_mttr_7_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:978:3: lv_mttr_7_0= RULE_STRING
                    {
                    lv_mttr_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAvailability1862); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_mttr_7_0, grammarAccess.getAvailabilityAccess().getMttrSTRINGTerminalRuleCall_5_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAvailabilityRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"mttr",
                              		lv_mttr_7_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:994:2: ( (lv_mttrPercentile_8_0= rulePercentile ) )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==RULE_INT) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:995:1: (lv_mttrPercentile_8_0= rulePercentile )
                            {
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:995:1: (lv_mttrPercentile_8_0= rulePercentile )
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:996:3: lv_mttrPercentile_8_0= rulePercentile
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAvailabilityAccess().getMttrPercentilePercentileParserRuleCall_5_2_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_rulePercentile_in_ruleAvailability1888);
                            lv_mttrPercentile_8_0=rulePercentile();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getAvailabilityRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"mttrPercentile",
                                      		lv_mttrPercentile_8_0, 
                                      		"Percentile");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1012:5: (otherlv_9= 'regular-down-times' ( (lv_regularDownTimes_10_0= RULE_STRING ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==38) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1012:7: otherlv_9= 'regular-down-times' ( (lv_regularDownTimes_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleAvailability1904); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getAvailabilityAccess().getRegularDownTimesKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1016:1: ( (lv_regularDownTimes_10_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1017:1: (lv_regularDownTimes_10_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1017:1: (lv_regularDownTimes_10_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1018:3: lv_regularDownTimes_10_0= RULE_STRING
                    {
                    lv_regularDownTimes_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAvailability1921); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_regularDownTimes_10_0, grammarAccess.getAvailabilityAccess().getRegularDownTimesSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAvailabilityRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"regularDownTimes",
                              		lv_regularDownTimes_10_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAvailability1940); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getAvailabilityAccess().getRightCurlyBracketKeyword_7());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAvailability"


    // $ANTLR start "entryRuleThroughput"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1046:1: entryRuleThroughput returns [EObject current=null] : iv_ruleThroughput= ruleThroughput EOF ;
    public final EObject entryRuleThroughput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThroughput = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1047:2: (iv_ruleThroughput= ruleThroughput EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1048:2: iv_ruleThroughput= ruleThroughput EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getThroughputRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleThroughput_in_entryRuleThroughput1976);
            iv_ruleThroughput=ruleThroughput();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleThroughput; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleThroughput1986); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleThroughput"


    // $ANTLR start "ruleThroughput"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1055:1: ruleThroughput returns [EObject current=null] : (otherlv_0= 'throughput' otherlv_1= '{' otherlv_2= 'throughput' ( (lv_definition_3_0= RULE_STRING ) ) otherlv_4= 'score-to-be-kept' ( (lv_score_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' ) ;
    public final EObject ruleThroughput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_definition_3_0=null;
        Token otherlv_4=null;
        Token lv_score_5_0=null;
        Token otherlv_7=null;
        Token lv_penalty_8_0=null;
        Token otherlv_9=null;
        EObject lv_escalation_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1058:28: ( (otherlv_0= 'throughput' otherlv_1= '{' otherlv_2= 'throughput' ( (lv_definition_3_0= RULE_STRING ) ) otherlv_4= 'score-to-be-kept' ( (lv_score_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1059:1: (otherlv_0= 'throughput' otherlv_1= '{' otherlv_2= 'throughput' ( (lv_definition_3_0= RULE_STRING ) ) otherlv_4= 'score-to-be-kept' ( (lv_score_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1059:1: (otherlv_0= 'throughput' otherlv_1= '{' otherlv_2= 'throughput' ( (lv_definition_3_0= RULE_STRING ) ) otherlv_4= 'score-to-be-kept' ( (lv_score_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1059:3: otherlv_0= 'throughput' otherlv_1= '{' otherlv_2= 'throughput' ( (lv_definition_3_0= RULE_STRING ) ) otherlv_4= 'score-to-be-kept' ( (lv_score_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleThroughput2023); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getThroughputAccess().getThroughputKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleThroughput2035); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getThroughputAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleThroughput2047); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getThroughputAccess().getThroughputKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1071:1: ( (lv_definition_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1072:1: (lv_definition_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1072:1: (lv_definition_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1073:3: lv_definition_3_0= RULE_STRING
            {
            lv_definition_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleThroughput2064); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_definition_3_0, grammarAccess.getThroughputAccess().getDefinitionSTRINGTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getThroughputRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"definition",
                      		lv_definition_3_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleThroughput2081); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getThroughputAccess().getScoreToBeKeptKeyword_4());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1093:1: ( (lv_score_5_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1094:1: (lv_score_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1094:1: (lv_score_5_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1095:3: lv_score_5_0= RULE_STRING
            {
            lv_score_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleThroughput2098); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_score_5_0, grammarAccess.getThroughputAccess().getScoreSTRINGTerminalRuleCall_5_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getThroughputRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"score",
                      		lv_score_5_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1111:2: ( (lv_escalation_6_0= ruleEscalation ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==75) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1112:1: (lv_escalation_6_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1112:1: (lv_escalation_6_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1113:3: lv_escalation_6_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getThroughputAccess().getEscalationEscalationParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleThroughput2124);
                    lv_escalation_6_0=ruleEscalation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getThroughputRule());
                      	        }
                             		set(
                             			current, 
                             			"escalation",
                              		lv_escalation_6_0, 
                              		"Escalation");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1129:3: (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==34) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1129:5: otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleThroughput2138); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getThroughputAccess().getPenaltyKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1133:1: ( (lv_penalty_8_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1134:1: (lv_penalty_8_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1134:1: (lv_penalty_8_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1135:3: lv_penalty_8_0= RULE_STRING
                    {
                    lv_penalty_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleThroughput2155); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_penalty_8_0, grammarAccess.getThroughputAccess().getPenaltySTRINGTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getThroughputRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"penalty",
                              		lv_penalty_8_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleThroughput2174); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getThroughputAccess().getRightCurlyBracketKeyword_8());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleThroughput"


    // $ANTLR start "entryRuleLatency"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1163:1: entryRuleLatency returns [EObject current=null] : iv_ruleLatency= ruleLatency EOF ;
    public final EObject entryRuleLatency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLatency = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1164:2: (iv_ruleLatency= ruleLatency EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1165:2: iv_ruleLatency= ruleLatency EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLatencyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLatency_in_entryRuleLatency2210);
            iv_ruleLatency=ruleLatency();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLatency; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLatency2220); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLatency"


    // $ANTLR start "ruleLatency"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1172:1: ruleLatency returns [EObject current=null] : (otherlv_0= 'latency' otherlv_1= '{' otherlv_2= 'latency' ( (lv_latency_3_0= 'STRING' ) ) otherlv_4= 'percentile' ( (lv_percentile_5_0= rulePercentile ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' ) ;
    public final EObject ruleLatency() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_latency_3_0=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token lv_penalty_8_0=null;
        Token otherlv_9=null;
        EObject lv_percentile_5_0 = null;

        EObject lv_escalation_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1175:28: ( (otherlv_0= 'latency' otherlv_1= '{' otherlv_2= 'latency' ( (lv_latency_3_0= 'STRING' ) ) otherlv_4= 'percentile' ( (lv_percentile_5_0= rulePercentile ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1176:1: (otherlv_0= 'latency' otherlv_1= '{' otherlv_2= 'latency' ( (lv_latency_3_0= 'STRING' ) ) otherlv_4= 'percentile' ( (lv_percentile_5_0= rulePercentile ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1176:1: (otherlv_0= 'latency' otherlv_1= '{' otherlv_2= 'latency' ( (lv_latency_3_0= 'STRING' ) ) otherlv_4= 'percentile' ( (lv_percentile_5_0= rulePercentile ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1176:3: otherlv_0= 'latency' otherlv_1= '{' otherlv_2= 'latency' ( (lv_latency_3_0= 'STRING' ) ) otherlv_4= 'percentile' ( (lv_percentile_5_0= rulePercentile ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleLatency2257); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLatencyAccess().getLatencyKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleLatency2269); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLatencyAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleLatency2281); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getLatencyAccess().getLatencyKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1188:1: ( (lv_latency_3_0= 'STRING' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1189:1: (lv_latency_3_0= 'STRING' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1189:1: (lv_latency_3_0= 'STRING' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1190:3: lv_latency_3_0= 'STRING'
            {
            lv_latency_3_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleLatency2299); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_latency_3_0, grammarAccess.getLatencyAccess().getLatencySTRINGKeyword_3_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getLatencyRule());
              	        }
                     		setWithLastConsumed(current, "latency", lv_latency_3_0, "STRING");
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleLatency2324); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLatencyAccess().getPercentileKeyword_4());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1207:1: ( (lv_percentile_5_0= rulePercentile ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1208:1: (lv_percentile_5_0= rulePercentile )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1208:1: (lv_percentile_5_0= rulePercentile )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1209:3: lv_percentile_5_0= rulePercentile
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLatencyAccess().getPercentilePercentileParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePercentile_in_ruleLatency2345);
            lv_percentile_5_0=rulePercentile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLatencyRule());
              	        }
                     		set(
                     			current, 
                     			"percentile",
                      		lv_percentile_5_0, 
                      		"Percentile");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1225:2: ( (lv_escalation_6_0= ruleEscalation ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==75) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1226:1: (lv_escalation_6_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1226:1: (lv_escalation_6_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1227:3: lv_escalation_6_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLatencyAccess().getEscalationEscalationParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleLatency2366);
                    lv_escalation_6_0=ruleEscalation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLatencyRule());
                      	        }
                             		set(
                             			current, 
                             			"escalation",
                              		lv_escalation_6_0, 
                              		"Escalation");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1243:3: (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==34) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1243:5: otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleLatency2380); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getLatencyAccess().getPenaltyKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1247:1: ( (lv_penalty_8_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1248:1: (lv_penalty_8_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1248:1: (lv_penalty_8_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1249:3: lv_penalty_8_0= RULE_STRING
                    {
                    lv_penalty_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleLatency2397); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_penalty_8_0, grammarAccess.getLatencyAccess().getPenaltySTRINGTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getLatencyRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"penalty",
                              		lv_penalty_8_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleLatency2416); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getLatencyAccess().getRightCurlyBracketKeyword_8());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLatency"


    // $ANTLR start "entryRuleMaxDownTime"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1277:1: entryRuleMaxDownTime returns [EObject current=null] : iv_ruleMaxDownTime= ruleMaxDownTime EOF ;
    public final EObject entryRuleMaxDownTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxDownTime = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1278:2: (iv_ruleMaxDownTime= ruleMaxDownTime EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1279:2: iv_ruleMaxDownTime= ruleMaxDownTime EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMaxDownTimeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMaxDownTime_in_entryRuleMaxDownTime2452);
            iv_ruleMaxDownTime=ruleMaxDownTime();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMaxDownTime; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxDownTime2462); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMaxDownTime"


    // $ANTLR start "ruleMaxDownTime"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1286:1: ruleMaxDownTime returns [EObject current=null] : (otherlv_0= 'max-downtime' otherlv_1= '{' otherlv_2= 'duration' ( (lv_definition_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleMaxDownTime() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_definition_3_0=null;
        Token otherlv_5=null;
        Token lv_penalty_6_0=null;
        Token otherlv_7=null;
        EObject lv_escalation_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1289:28: ( (otherlv_0= 'max-downtime' otherlv_1= '{' otherlv_2= 'duration' ( (lv_definition_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1290:1: (otherlv_0= 'max-downtime' otherlv_1= '{' otherlv_2= 'duration' ( (lv_definition_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1290:1: (otherlv_0= 'max-downtime' otherlv_1= '{' otherlv_2= 'duration' ( (lv_definition_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1290:3: otherlv_0= 'max-downtime' otherlv_1= '{' otherlv_2= 'duration' ( (lv_definition_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleMaxDownTime2499); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMaxDownTimeAccess().getMaxDowntimeKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleMaxDownTime2511); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMaxDownTimeAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleMaxDownTime2523); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMaxDownTimeAccess().getDurationKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1302:1: ( (lv_definition_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1303:1: (lv_definition_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1303:1: (lv_definition_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1304:3: lv_definition_3_0= RULE_STRING
            {
            lv_definition_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMaxDownTime2540); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_definition_3_0, grammarAccess.getMaxDownTimeAccess().getDefinitionSTRINGTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMaxDownTimeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"definition",
                      		lv_definition_3_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1320:2: ( (lv_escalation_4_0= ruleEscalation ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==75) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1321:1: (lv_escalation_4_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1321:1: (lv_escalation_4_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1322:3: lv_escalation_4_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMaxDownTimeAccess().getEscalationEscalationParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleMaxDownTime2566);
                    lv_escalation_4_0=ruleEscalation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMaxDownTimeRule());
                      	        }
                             		set(
                             			current, 
                             			"escalation",
                              		lv_escalation_4_0, 
                              		"Escalation");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1338:3: (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==34) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1338:5: otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleMaxDownTime2580); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getMaxDownTimeAccess().getPenaltyKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1342:1: ( (lv_penalty_6_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1343:1: (lv_penalty_6_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1343:1: (lv_penalty_6_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1344:3: lv_penalty_6_0= RULE_STRING
                    {
                    lv_penalty_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMaxDownTime2597); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_penalty_6_0, grammarAccess.getMaxDownTimeAccess().getPenaltySTRINGTerminalRuleCall_5_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMaxDownTimeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"penalty",
                              		lv_penalty_6_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMaxDownTime2616); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getMaxDownTimeAccess().getRightCurlyBracketKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMaxDownTime"


    // $ANTLR start "entryRuleCapacityRequirement"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1372:1: entryRuleCapacityRequirement returns [EObject current=null] : iv_ruleCapacityRequirement= ruleCapacityRequirement EOF ;
    public final EObject entryRuleCapacityRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCapacityRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1373:2: (iv_ruleCapacityRequirement= ruleCapacityRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1374:2: iv_ruleCapacityRequirement= ruleCapacityRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCapacityRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCapacityRequirement_in_entryRuleCapacityRequirement2652);
            iv_ruleCapacityRequirement=ruleCapacityRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCapacityRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCapacityRequirement2662); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCapacityRequirement"


    // $ANTLR start "ruleCapacityRequirement"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1381:1: ruleCapacityRequirement returns [EObject current=null] : (otherlv_0= 'capacity' otherlv_1= '{' () (otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) ) )? (otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) ) )? ( (lv_escalation_9_0= ruleEscalation ) )? (otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) ) )? otherlv_12= '}' ) ;
    public final EObject ruleCapacityRequirement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_requestNum_4_0=null;
        Token otherlv_5=null;
        Token lv_timeUnit_6_0=null;
        Token otherlv_7=null;
        Token lv_messageSize_8_0=null;
        Token otherlv_10=null;
        Token lv_penalty_11_0=null;
        Token otherlv_12=null;
        EObject lv_escalation_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1384:28: ( (otherlv_0= 'capacity' otherlv_1= '{' () (otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) ) )? (otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) ) )? ( (lv_escalation_9_0= ruleEscalation ) )? (otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) ) )? otherlv_12= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1385:1: (otherlv_0= 'capacity' otherlv_1= '{' () (otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) ) )? (otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) ) )? ( (lv_escalation_9_0= ruleEscalation ) )? (otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) ) )? otherlv_12= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1385:1: (otherlv_0= 'capacity' otherlv_1= '{' () (otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) ) )? (otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) ) )? ( (lv_escalation_9_0= ruleEscalation ) )? (otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) ) )? otherlv_12= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1385:3: otherlv_0= 'capacity' otherlv_1= '{' () (otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) ) )? (otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) ) )? ( (lv_escalation_9_0= ruleEscalation ) )? (otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleCapacityRequirement2699); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getCapacityRequirementAccess().getCapacityKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleCapacityRequirement2711); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCapacityRequirementAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1393:1: ()
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1394:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getCapacityRequirementAccess().getCapacityRequirementAction_2(),
                          current);
                  
            }

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1402:2: (otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==47) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1402:4: otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleCapacityRequirement2736); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getCapacityRequirementAccess().getNumOfRequestsKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1406:1: ( (lv_requestNum_4_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1407:1: (lv_requestNum_4_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1407:1: (lv_requestNum_4_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1408:3: lv_requestNum_4_0= RULE_STRING
                    {
                    lv_requestNum_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCapacityRequirement2753); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_requestNum_4_0, grammarAccess.getCapacityRequirementAccess().getRequestNumSTRINGTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getCapacityRequirementRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"requestNum",
                              		lv_requestNum_4_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleCapacityRequirement2770); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getCapacityRequirementAccess().getPerKeyword_3_2());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1428:1: ( (lv_timeUnit_6_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1429:1: (lv_timeUnit_6_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1429:1: (lv_timeUnit_6_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1430:3: lv_timeUnit_6_0= RULE_STRING
                    {
                    lv_timeUnit_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCapacityRequirement2787); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_timeUnit_6_0, grammarAccess.getCapacityRequirementAccess().getTimeUnitSTRINGTerminalRuleCall_3_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getCapacityRequirementRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"timeUnit",
                              		lv_timeUnit_6_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1446:4: (otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==49) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1446:6: otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleCapacityRequirement2807); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getCapacityRequirementAccess().getMessageSizeKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1450:1: ( (lv_messageSize_8_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1451:1: (lv_messageSize_8_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1451:1: (lv_messageSize_8_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1452:3: lv_messageSize_8_0= RULE_STRING
                    {
                    lv_messageSize_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCapacityRequirement2824); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_messageSize_8_0, grammarAccess.getCapacityRequirementAccess().getMessageSizeSTRINGTerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getCapacityRequirementRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"messageSize",
                              		lv_messageSize_8_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1468:4: ( (lv_escalation_9_0= ruleEscalation ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==75) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1469:1: (lv_escalation_9_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1469:1: (lv_escalation_9_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1470:3: lv_escalation_9_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCapacityRequirementAccess().getEscalationEscalationParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleCapacityRequirement2852);
                    lv_escalation_9_0=ruleEscalation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCapacityRequirementRule());
                      	        }
                             		set(
                             			current, 
                             			"escalation",
                              		lv_escalation_9_0, 
                              		"Escalation");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1486:3: (otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==34) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1486:5: otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) )
                    {
                    otherlv_10=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleCapacityRequirement2866); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getCapacityRequirementAccess().getPenaltyKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1490:1: ( (lv_penalty_11_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1491:1: (lv_penalty_11_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1491:1: (lv_penalty_11_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1492:3: lv_penalty_11_0= RULE_STRING
                    {
                    lv_penalty_11_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCapacityRequirement2883); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_penalty_11_0, grammarAccess.getCapacityRequirementAccess().getPenaltySTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getCapacityRequirementRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"penalty",
                              		lv_penalty_11_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleCapacityRequirement2902); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getCapacityRequirementAccess().getRightCurlyBracketKeyword_7());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCapacityRequirement"


    // $ANTLR start "entryRuleReliablityRequirement"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1520:1: entryRuleReliablityRequirement returns [EObject current=null] : iv_ruleReliablityRequirement= ruleReliablityRequirement EOF ;
    public final EObject entryRuleReliablityRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReliablityRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1521:2: (iv_ruleReliablityRequirement= ruleReliablityRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1522:2: iv_ruleReliablityRequirement= ruleReliablityRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReliablityRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReliablityRequirement_in_entryRuleReliablityRequirement2938);
            iv_ruleReliablityRequirement=ruleReliablityRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReliablityRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReliablityRequirement2948); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReliablityRequirement"


    // $ANTLR start "ruleReliablityRequirement"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1529:1: ruleReliablityRequirement returns [EObject current=null] : (otherlv_0= 'message-exchange-reliability' otherlv_1= '{' ( (lv_reliability_2_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_3_0= 'in-order-delivery' ) )? otherlv_4= '}' ) ;
    public final EObject ruleReliablityRequirement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_inOrderDelivery_3_0=null;
        Token otherlv_4=null;
        Enumerator lv_reliability_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1532:28: ( (otherlv_0= 'message-exchange-reliability' otherlv_1= '{' ( (lv_reliability_2_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_3_0= 'in-order-delivery' ) )? otherlv_4= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1533:1: (otherlv_0= 'message-exchange-reliability' otherlv_1= '{' ( (lv_reliability_2_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_3_0= 'in-order-delivery' ) )? otherlv_4= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1533:1: (otherlv_0= 'message-exchange-reliability' otherlv_1= '{' ( (lv_reliability_2_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_3_0= 'in-order-delivery' ) )? otherlv_4= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1533:3: otherlv_0= 'message-exchange-reliability' otherlv_1= '{' ( (lv_reliability_2_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_3_0= 'in-order-delivery' ) )? otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleReliablityRequirement2985); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getReliablityRequirementAccess().getMessageExchangeReliabilityKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleReliablityRequirement2997); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getReliablityRequirementAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1541:1: ( (lv_reliability_2_0= ruleReliablilityKind ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1542:1: (lv_reliability_2_0= ruleReliablilityKind )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1542:1: (lv_reliability_2_0= ruleReliablilityKind )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1543:3: lv_reliability_2_0= ruleReliablilityKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReliablityRequirementAccess().getReliabilityReliablilityKindEnumRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleReliablilityKind_in_ruleReliablityRequirement3018);
            lv_reliability_2_0=ruleReliablilityKind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getReliablityRequirementRule());
              	        }
                     		set(
                     			current, 
                     			"reliability",
                      		lv_reliability_2_0, 
                      		"ReliablilityKind");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1559:2: ( (lv_inOrderDelivery_3_0= 'in-order-delivery' ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==51) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1560:1: (lv_inOrderDelivery_3_0= 'in-order-delivery' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1560:1: (lv_inOrderDelivery_3_0= 'in-order-delivery' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1561:3: lv_inOrderDelivery_3_0= 'in-order-delivery'
                    {
                    lv_inOrderDelivery_3_0=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleReliablityRequirement3036); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_inOrderDelivery_3_0, grammarAccess.getReliablityRequirementAccess().getInOrderDeliveryInOrderDeliveryKeyword_3_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getReliablityRequirementRule());
                      	        }
                             		setWithLastConsumed(current, "inOrderDelivery", true, "in-order-delivery");
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleReliablityRequirement3062); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getReliablityRequirementAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReliablityRequirement"


    // $ANTLR start "entryRuleAccuracyRequirement"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1586:1: entryRuleAccuracyRequirement returns [EObject current=null] : iv_ruleAccuracyRequirement= ruleAccuracyRequirement EOF ;
    public final EObject entryRuleAccuracyRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccuracyRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1587:2: (iv_ruleAccuracyRequirement= ruleAccuracyRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1588:2: iv_ruleAccuracyRequirement= ruleAccuracyRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAccuracyRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAccuracyRequirement_in_entryRuleAccuracyRequirement3098);
            iv_ruleAccuracyRequirement=ruleAccuracyRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAccuracyRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAccuracyRequirement3108); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAccuracyRequirement"


    // $ANTLR start "ruleAccuracyRequirement"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1595:1: ruleAccuracyRequirement returns [EObject current=null] : (otherlv_0= 'accuracy' otherlv_1= '{' otherlv_2= 'max-error-rate' ( (lv_maxErrorRate_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleAccuracyRequirement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_maxErrorRate_3_0=null;
        Token otherlv_5=null;
        Token lv_penalty_6_0=null;
        Token otherlv_7=null;
        EObject lv_escalation_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1598:28: ( (otherlv_0= 'accuracy' otherlv_1= '{' otherlv_2= 'max-error-rate' ( (lv_maxErrorRate_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1599:1: (otherlv_0= 'accuracy' otherlv_1= '{' otherlv_2= 'max-error-rate' ( (lv_maxErrorRate_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1599:1: (otherlv_0= 'accuracy' otherlv_1= '{' otherlv_2= 'max-error-rate' ( (lv_maxErrorRate_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1599:3: otherlv_0= 'accuracy' otherlv_1= '{' otherlv_2= 'max-error-rate' ( (lv_maxErrorRate_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleAccuracyRequirement3145); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAccuracyRequirementAccess().getAccuracyKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAccuracyRequirement3157); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAccuracyRequirementAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleAccuracyRequirement3169); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAccuracyRequirementAccess().getMaxErrorRateKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1611:1: ( (lv_maxErrorRate_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1612:1: (lv_maxErrorRate_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1612:1: (lv_maxErrorRate_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1613:3: lv_maxErrorRate_3_0= RULE_STRING
            {
            lv_maxErrorRate_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAccuracyRequirement3186); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_maxErrorRate_3_0, grammarAccess.getAccuracyRequirementAccess().getMaxErrorRateSTRINGTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAccuracyRequirementRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"maxErrorRate",
                      		lv_maxErrorRate_3_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1629:2: ( (lv_escalation_4_0= ruleEscalation ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==75) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1630:1: (lv_escalation_4_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1630:1: (lv_escalation_4_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1631:3: lv_escalation_4_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAccuracyRequirementAccess().getEscalationEscalationParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleAccuracyRequirement3212);
                    lv_escalation_4_0=ruleEscalation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAccuracyRequirementRule());
                      	        }
                             		set(
                             			current, 
                             			"escalation",
                              		lv_escalation_4_0, 
                              		"Escalation");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1647:3: (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==34) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1647:5: otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAccuracyRequirement3226); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getAccuracyRequirementAccess().getPenaltyKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1651:1: ( (lv_penalty_6_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1652:1: (lv_penalty_6_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1652:1: (lv_penalty_6_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1653:3: lv_penalty_6_0= RULE_STRING
                    {
                    lv_penalty_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAccuracyRequirement3243); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_penalty_6_0, grammarAccess.getAccuracyRequirementAccess().getPenaltySTRINGTerminalRuleCall_5_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAccuracyRequirementRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"penalty",
                              		lv_penalty_6_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAccuracyRequirement3262); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getAccuracyRequirementAccess().getRightCurlyBracketKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAccuracyRequirement"


    // $ANTLR start "entryRuleLogRequirement"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1681:1: entryRuleLogRequirement returns [EObject current=null] : iv_ruleLogRequirement= ruleLogRequirement EOF ;
    public final EObject entryRuleLogRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1682:2: (iv_ruleLogRequirement= ruleLogRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1683:2: iv_ruleLogRequirement= ruleLogRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLogRequirement_in_entryRuleLogRequirement3298);
            iv_ruleLogRequirement=ruleLogRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLogRequirement3308); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogRequirement"


    // $ANTLR start "ruleLogRequirement"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1690:1: ruleLogRequirement returns [EObject current=null] : (otherlv_0= 'logging' otherlv_1= '{' otherlv_2= 'message-log-level' ( (lv_logLevel_3_0= ruleLogRequirementKind ) ) otherlv_4= 'additional-logging-requirements' ( (lv_additionalLoggingRequirement_5_0= RULE_STRING ) ) ) ;
    public final EObject ruleLogRequirement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_additionalLoggingRequirement_5_0=null;
        Enumerator lv_logLevel_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1693:28: ( (otherlv_0= 'logging' otherlv_1= '{' otherlv_2= 'message-log-level' ( (lv_logLevel_3_0= ruleLogRequirementKind ) ) otherlv_4= 'additional-logging-requirements' ( (lv_additionalLoggingRequirement_5_0= RULE_STRING ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1694:1: (otherlv_0= 'logging' otherlv_1= '{' otherlv_2= 'message-log-level' ( (lv_logLevel_3_0= ruleLogRequirementKind ) ) otherlv_4= 'additional-logging-requirements' ( (lv_additionalLoggingRequirement_5_0= RULE_STRING ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1694:1: (otherlv_0= 'logging' otherlv_1= '{' otherlv_2= 'message-log-level' ( (lv_logLevel_3_0= ruleLogRequirementKind ) ) otherlv_4= 'additional-logging-requirements' ( (lv_additionalLoggingRequirement_5_0= RULE_STRING ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1694:3: otherlv_0= 'logging' otherlv_1= '{' otherlv_2= 'message-log-level' ( (lv_logLevel_3_0= ruleLogRequirementKind ) ) otherlv_4= 'additional-logging-requirements' ( (lv_additionalLoggingRequirement_5_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleLogRequirement3345); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLogRequirementAccess().getLoggingKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleLogRequirement3357); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLogRequirementAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleLogRequirement3369); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getLogRequirementAccess().getMessageLogLevelKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1706:1: ( (lv_logLevel_3_0= ruleLogRequirementKind ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1707:1: (lv_logLevel_3_0= ruleLogRequirementKind )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1707:1: (lv_logLevel_3_0= ruleLogRequirementKind )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1708:3: lv_logLevel_3_0= ruleLogRequirementKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogRequirementAccess().getLogLevelLogRequirementKindEnumRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLogRequirementKind_in_ruleLogRequirement3390);
            lv_logLevel_3_0=ruleLogRequirementKind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLogRequirementRule());
              	        }
                     		set(
                     			current, 
                     			"logLevel",
                      		lv_logLevel_3_0, 
                      		"LogRequirementKind");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleLogRequirement3402); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLogRequirementAccess().getAdditionalLoggingRequirementsKeyword_4());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1728:1: ( (lv_additionalLoggingRequirement_5_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1729:1: (lv_additionalLoggingRequirement_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1729:1: (lv_additionalLoggingRequirement_5_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1730:3: lv_additionalLoggingRequirement_5_0= RULE_STRING
            {
            lv_additionalLoggingRequirement_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleLogRequirement3419); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_additionalLoggingRequirement_5_0, grammarAccess.getLogRequirementAccess().getAdditionalLoggingRequirementSTRINGTerminalRuleCall_5_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getLogRequirementRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"additionalLoggingRequirement",
                      		lv_additionalLoggingRequirement_5_0, 
                      		"STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogRequirement"


    // $ANTLR start "entryRulePercentile"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1754:1: entryRulePercentile returns [EObject current=null] : iv_rulePercentile= rulePercentile EOF ;
    public final EObject entryRulePercentile() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePercentile = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1755:2: (iv_rulePercentile= rulePercentile EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1756:2: iv_rulePercentile= rulePercentile EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPercentileRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePercentile_in_entryRulePercentile3460);
            iv_rulePercentile=rulePercentile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePercentile; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePercentile3470); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePercentile"


    // $ANTLR start "rulePercentile"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1763:1: rulePercentile returns [EObject current=null] : ( ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%' ) ;
    public final EObject rulePercentile() throws RecognitionException {
        EObject current = null;

        Token lv_percentile_0_0=null;
        Token otherlv_1=null;
        Token this_INT_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1766:28: ( ( ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1767:1: ( ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1767:1: ( ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1767:2: ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%'
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1767:2: ( (lv_percentile_0_0= RULE_INT ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1768:1: (lv_percentile_0_0= RULE_INT )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1768:1: (lv_percentile_0_0= RULE_INT )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1769:3: lv_percentile_0_0= RULE_INT
            {
            lv_percentile_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rulePercentile3512); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_percentile_0_0, grammarAccess.getPercentileAccess().getPercentileINTTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPercentileRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"percentile",
                      		lv_percentile_0_0, 
                      		"INT");
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1785:2: (otherlv_1= '.' this_INT_2= RULE_INT )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==57) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1785:4: otherlv_1= '.' this_INT_2= RULE_INT
            	    {
            	    otherlv_1=(Token)match(input,57,FollowSets000.FOLLOW_57_in_rulePercentile3530); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPercentileAccess().getFullStopKeyword_1_0());
            	          
            	    }
            	    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rulePercentile3541); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_INT_2, grammarAccess.getPercentileAccess().getINTTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            otherlv_3=(Token)match(input,58,FollowSets000.FOLLOW_58_in_rulePercentile3554); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getPercentileAccess().getPercentSignKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePercentile"


    // $ANTLR start "entryRuleSecurityRequirement"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1805:1: entryRuleSecurityRequirement returns [EObject current=null] : iv_ruleSecurityRequirement= ruleSecurityRequirement EOF ;
    public final EObject entryRuleSecurityRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecurityRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1806:2: (iv_ruleSecurityRequirement= ruleSecurityRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1807:2: iv_ruleSecurityRequirement= ruleSecurityRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSecurityRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSecurityRequirement_in_entryRuleSecurityRequirement3590);
            iv_ruleSecurityRequirement=ruleSecurityRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSecurityRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecurityRequirement3600); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSecurityRequirement"


    // $ANTLR start "ruleSecurityRequirement"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1814:1: ruleSecurityRequirement returns [EObject current=null] : (this_AuthenticationRequirement_0= ruleAuthenticationRequirement | this_SigningRequirement_1= ruleSigningRequirement | this_EncryptionRequirement_2= ruleEncryptionRequirement ) ;
    public final EObject ruleSecurityRequirement() throws RecognitionException {
        EObject current = null;

        EObject this_AuthenticationRequirement_0 = null;

        EObject this_SigningRequirement_1 = null;

        EObject this_EncryptionRequirement_2 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1817:28: ( (this_AuthenticationRequirement_0= ruleAuthenticationRequirement | this_SigningRequirement_1= ruleSigningRequirement | this_EncryptionRequirement_2= ruleEncryptionRequirement ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1818:1: (this_AuthenticationRequirement_0= ruleAuthenticationRequirement | this_SigningRequirement_1= ruleSigningRequirement | this_EncryptionRequirement_2= ruleEncryptionRequirement )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1818:1: (this_AuthenticationRequirement_0= ruleAuthenticationRequirement | this_SigningRequirement_1= ruleSigningRequirement | this_EncryptionRequirement_2= ruleEncryptionRequirement )
            int alt48=3;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt48=1;
                }
                break;
            case 66:
                {
                alt48=2;
                }
                break;
            case 72:
                {
                alt48=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1819:2: this_AuthenticationRequirement_0= ruleAuthenticationRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityRequirementAccess().getAuthenticationRequirementParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAuthenticationRequirement_in_ruleSecurityRequirement3650);
                    this_AuthenticationRequirement_0=ruleAuthenticationRequirement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AuthenticationRequirement_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1832:2: this_SigningRequirement_1= ruleSigningRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityRequirementAccess().getSigningRequirementParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSigningRequirement_in_ruleSecurityRequirement3680);
                    this_SigningRequirement_1=ruleSigningRequirement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SigningRequirement_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1845:2: this_EncryptionRequirement_2= ruleEncryptionRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityRequirementAccess().getEncryptionRequirementParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEncryptionRequirement_in_ruleSecurityRequirement3710);
                    this_EncryptionRequirement_2=ruleEncryptionRequirement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_EncryptionRequirement_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSecurityRequirement"


    // $ANTLR start "entryRuleAuthenticationRequirement"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1864:1: entryRuleAuthenticationRequirement returns [EObject current=null] : iv_ruleAuthenticationRequirement= ruleAuthenticationRequirement EOF ;
    public final EObject entryRuleAuthenticationRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthenticationRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1865:2: (iv_ruleAuthenticationRequirement= ruleAuthenticationRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1866:2: iv_ruleAuthenticationRequirement= ruleAuthenticationRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAuthenticationRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthenticationRequirement_in_entryRuleAuthenticationRequirement3745);
            iv_ruleAuthenticationRequirement=ruleAuthenticationRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAuthenticationRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAuthenticationRequirement3755); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAuthenticationRequirement"


    // $ANTLR start "ruleAuthenticationRequirement"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1873:1: ruleAuthenticationRequirement returns [EObject current=null] : ( () otherlv_1= 'authentication-procedure' ( (lv_optional_2_0= 'optional' ) )? otherlv_3= '{' otherlv_4= 'auth-tokens' otherlv_5= '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ otherlv_7= '}' otherlv_8= 'hash-algorithms' otherlv_9= '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* otherlv_11= '}' ( (lv_useNonce_12_0= 'use-nonce' ) )? (otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) ) )? otherlv_15= '}' ) ;
    public final EObject ruleAuthenticationRequirement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_optional_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token lv_useNonce_12_0=null;
        Token otherlv_13=null;
        Token lv_issuer_14_0=null;
        Token otherlv_15=null;
        EObject lv_authTokens_6_0 = null;

        EObject lv_hashAlgorithms_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1876:28: ( ( () otherlv_1= 'authentication-procedure' ( (lv_optional_2_0= 'optional' ) )? otherlv_3= '{' otherlv_4= 'auth-tokens' otherlv_5= '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ otherlv_7= '}' otherlv_8= 'hash-algorithms' otherlv_9= '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* otherlv_11= '}' ( (lv_useNonce_12_0= 'use-nonce' ) )? (otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) ) )? otherlv_15= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1877:1: ( () otherlv_1= 'authentication-procedure' ( (lv_optional_2_0= 'optional' ) )? otherlv_3= '{' otherlv_4= 'auth-tokens' otherlv_5= '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ otherlv_7= '}' otherlv_8= 'hash-algorithms' otherlv_9= '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* otherlv_11= '}' ( (lv_useNonce_12_0= 'use-nonce' ) )? (otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) ) )? otherlv_15= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1877:1: ( () otherlv_1= 'authentication-procedure' ( (lv_optional_2_0= 'optional' ) )? otherlv_3= '{' otherlv_4= 'auth-tokens' otherlv_5= '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ otherlv_7= '}' otherlv_8= 'hash-algorithms' otherlv_9= '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* otherlv_11= '}' ( (lv_useNonce_12_0= 'use-nonce' ) )? (otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) ) )? otherlv_15= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1877:2: () otherlv_1= 'authentication-procedure' ( (lv_optional_2_0= 'optional' ) )? otherlv_3= '{' otherlv_4= 'auth-tokens' otherlv_5= '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ otherlv_7= '}' otherlv_8= 'hash-algorithms' otherlv_9= '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* otherlv_11= '}' ( (lv_useNonce_12_0= 'use-nonce' ) )? (otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) ) )? otherlv_15= '}'
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1877:2: ()
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1878:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAuthenticationRequirementAccess().getAuthenticationRequirementAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleAuthenticationRequirement3804); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAuthenticationRequirementAccess().getAuthenticationProcedureKeyword_1());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1890:1: ( (lv_optional_2_0= 'optional' ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==60) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1891:1: (lv_optional_2_0= 'optional' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1891:1: (lv_optional_2_0= 'optional' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1892:3: lv_optional_2_0= 'optional'
                    {
                    lv_optional_2_0=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleAuthenticationRequirement3822); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_optional_2_0, grammarAccess.getAuthenticationRequirementAccess().getOptionalOptionalKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAuthenticationRequirementRule());
                      	        }
                             		setWithLastConsumed(current, "optional", true, "optional");
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAuthenticationRequirement3848); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAuthenticationRequirementAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleAuthenticationRequirement3860); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getAuthenticationRequirementAccess().getAuthTokensKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAuthenticationRequirement3872); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getAuthenticationRequirementAccess().getLeftCurlyBracketKeyword_5());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1917:1: ( (lv_authTokens_6_0= ruleAuthToken ) )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==60||(LA50_0>=124 && LA50_0<=132)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1918:1: (lv_authTokens_6_0= ruleAuthToken )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1918:1: (lv_authTokens_6_0= ruleAuthToken )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1919:3: lv_authTokens_6_0= ruleAuthToken
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAuthenticationRequirementAccess().getAuthTokensAuthTokenParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAuthToken_in_ruleAuthenticationRequirement3893);
            	    lv_authTokens_6_0=ruleAuthToken();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAuthenticationRequirementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"authTokens",
            	              		lv_authTokens_6_0, 
            	              		"AuthToken");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt50 >= 1 ) break loop50;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(50, input);
                        throw eee;
                }
                cnt50++;
            } while (true);

            otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAuthenticationRequirement3906); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getAuthenticationRequirementAccess().getRightCurlyBracketKeyword_7());
                  
            }
            otherlv_8=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleAuthenticationRequirement3918); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getAuthenticationRequirementAccess().getHashAlgorithmsKeyword_8());
                  
            }
            otherlv_9=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAuthenticationRequirement3930); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getAuthenticationRequirementAccess().getLeftCurlyBracketKeyword_9());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1947:1: ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==60||LA51_0==65||(LA51_0>=105 && LA51_0<=109)) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1948:1: (lv_hashAlgorithms_10_0= ruleHashAlgorithm )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1948:1: (lv_hashAlgorithms_10_0= ruleHashAlgorithm )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1949:3: lv_hashAlgorithms_10_0= ruleHashAlgorithm
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAuthenticationRequirementAccess().getHashAlgorithmsHashAlgorithmParserRuleCall_10_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleHashAlgorithm_in_ruleAuthenticationRequirement3951);
            	    lv_hashAlgorithms_10_0=ruleHashAlgorithm();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAuthenticationRequirementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"hashAlgorithms",
            	              		lv_hashAlgorithms_10_0, 
            	              		"HashAlgorithm");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

            otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAuthenticationRequirement3964); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getAuthenticationRequirementAccess().getRightCurlyBracketKeyword_11());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1969:1: ( (lv_useNonce_12_0= 'use-nonce' ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==63) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1970:1: (lv_useNonce_12_0= 'use-nonce' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1970:1: (lv_useNonce_12_0= 'use-nonce' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1971:3: lv_useNonce_12_0= 'use-nonce'
                    {
                    lv_useNonce_12_0=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleAuthenticationRequirement3982); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_useNonce_12_0, grammarAccess.getAuthenticationRequirementAccess().getUseNonceUseNonceKeyword_12_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAuthenticationRequirementRule());
                      	        }
                             		setWithLastConsumed(current, "useNonce", true, "use-nonce");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1984:3: (otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==64) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1984:5: otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) )
                    {
                    otherlv_13=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleAuthenticationRequirement4009); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getAuthenticationRequirementAccess().getIssuerKeyword_13_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1988:1: ( (lv_issuer_14_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1989:1: (lv_issuer_14_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1989:1: (lv_issuer_14_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1990:3: lv_issuer_14_0= RULE_STRING
                    {
                    lv_issuer_14_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAuthenticationRequirement4026); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_issuer_14_0, grammarAccess.getAuthenticationRequirementAccess().getIssuerSTRINGTerminalRuleCall_13_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAuthenticationRequirementRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"issuer",
                              		lv_issuer_14_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAuthenticationRequirement4045); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getAuthenticationRequirementAccess().getRightCurlyBracketKeyword_14());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAuthenticationRequirement"


    // $ANTLR start "entryRuleAuthToken"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2018:1: entryRuleAuthToken returns [EObject current=null] : iv_ruleAuthToken= ruleAuthToken EOF ;
    public final EObject entryRuleAuthToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthToken = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2019:2: (iv_ruleAuthToken= ruleAuthToken EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2020:2: iv_ruleAuthToken= ruleAuthToken EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAuthTokenRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthToken_in_entryRuleAuthToken4081);
            iv_ruleAuthToken=ruleAuthToken();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAuthToken; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAuthToken4091); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAuthToken"


    // $ANTLR start "ruleAuthToken"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2027:1: ruleAuthToken returns [EObject current=null] : ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) ) ;
    public final EObject ruleAuthToken() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Enumerator lv_kind_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2030:28: ( ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2031:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2031:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2031:2: ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2031:2: ( (lv_optional_0_0= 'optional' ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==60) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2032:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2032:1: (lv_optional_0_0= 'optional' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2033:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleAuthToken4134); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_optional_0_0, grammarAccess.getAuthTokenAccess().getOptionalOptionalKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAuthTokenRule());
                      	        }
                             		setWithLastConsumed(current, "optional", true, "optional");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2046:3: ( (lv_kind_1_0= ruleAuthTokenKind ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2047:1: (lv_kind_1_0= ruleAuthTokenKind )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2047:1: (lv_kind_1_0= ruleAuthTokenKind )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2048:3: lv_kind_1_0= ruleAuthTokenKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAuthTokenAccess().getKindAuthTokenKindEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthTokenKind_in_ruleAuthToken4169);
            lv_kind_1_0=ruleAuthTokenKind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAuthTokenRule());
              	        }
                     		set(
                     			current, 
                     			"kind",
                      		lv_kind_1_0, 
                      		"AuthTokenKind");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAuthToken"


    // $ANTLR start "entryRuleHashAlgorithm"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2072:1: entryRuleHashAlgorithm returns [EObject current=null] : iv_ruleHashAlgorithm= ruleHashAlgorithm EOF ;
    public final EObject entryRuleHashAlgorithm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHashAlgorithm = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2073:2: (iv_ruleHashAlgorithm= ruleHashAlgorithm EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2074:2: iv_ruleHashAlgorithm= ruleHashAlgorithm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHashAlgorithmRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleHashAlgorithm_in_entryRuleHashAlgorithm4205);
            iv_ruleHashAlgorithm=ruleHashAlgorithm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHashAlgorithm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHashAlgorithm4215); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHashAlgorithm"


    // $ANTLR start "ruleHashAlgorithm"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2081:1: ruleHashAlgorithm returns [EObject current=null] : ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) ) ;
    public final EObject ruleHashAlgorithm() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Token lv_useBase64_1_0=null;
        Enumerator lv_kind_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2084:28: ( ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2085:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2085:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2085:2: ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2085:2: ( (lv_optional_0_0= 'optional' ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==60) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2086:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2086:1: (lv_optional_0_0= 'optional' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2087:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleHashAlgorithm4258); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_optional_0_0, grammarAccess.getHashAlgorithmAccess().getOptionalOptionalKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getHashAlgorithmRule());
                      	        }
                             		setWithLastConsumed(current, "optional", true, "optional");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2100:3: ( (lv_useBase64_1_0= 'Base64-encoded' ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==65) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2101:1: (lv_useBase64_1_0= 'Base64-encoded' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2101:1: (lv_useBase64_1_0= 'Base64-encoded' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2102:3: lv_useBase64_1_0= 'Base64-encoded'
                    {
                    lv_useBase64_1_0=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleHashAlgorithm4290); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_useBase64_1_0, grammarAccess.getHashAlgorithmAccess().getUseBase64Base64EncodedKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getHashAlgorithmRule());
                      	        }
                             		setWithLastConsumed(current, "useBase64", true, "Base64-encoded");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2115:3: ( (lv_kind_2_0= ruleHashAlgKind ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2116:1: (lv_kind_2_0= ruleHashAlgKind )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2116:1: (lv_kind_2_0= ruleHashAlgKind )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2117:3: lv_kind_2_0= ruleHashAlgKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getHashAlgorithmAccess().getKindHashAlgKindEnumRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleHashAlgKind_in_ruleHashAlgorithm4325);
            lv_kind_2_0=ruleHashAlgKind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getHashAlgorithmRule());
              	        }
                     		set(
                     			current, 
                     			"kind",
                      		lv_kind_2_0, 
                      		"HashAlgKind");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHashAlgorithm"


    // $ANTLR start "entryRuleSigningRequirement"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2141:1: entryRuleSigningRequirement returns [EObject current=null] : iv_ruleSigningRequirement= ruleSigningRequirement EOF ;
    public final EObject entryRuleSigningRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSigningRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2142:2: (iv_ruleSigningRequirement= ruleSigningRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2143:2: iv_ruleSigningRequirement= ruleSigningRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSigningRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSigningRequirement_in_entryRuleSigningRequirement4361);
            iv_ruleSigningRequirement=ruleSigningRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSigningRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSigningRequirement4371); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSigningRequirement"


    // $ANTLR start "ruleSigningRequirement"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2150:1: ruleSigningRequirement returns [EObject current=null] : ( () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' ) ;
    public final EObject ruleSigningRequirement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Enumerator lv_supportedSigningAlgorithms_4_0 = null;

        Enumerator lv_requiredSigningAlgorithm_6_0 = null;

        EObject lv_signedParts_8_0 = null;

        EObject lv_signedParts_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2153:28: ( ( () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2154:1: ( () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2154:1: ( () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2154:2: () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}'
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2154:2: ()
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2155:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getSigningRequirementAccess().getSigningRequirementAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleSigningRequirement4420); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSigningRequirementAccess().getSigningPolicyKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSigningRequirement4432); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getSigningRequirementAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2171:1: (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==67) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2171:3: otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+
                    {
                    otherlv_3=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleSigningRequirement4445); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getSigningRequirementAccess().getSupportedAlgorithmsKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2175:1: ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+
                    int cnt57=0;
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( ((LA57_0>=105 && LA57_0<=107)||(LA57_0>=114 && LA57_0<=118)) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2176:1: (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm )
                    	    {
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2176:1: (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2177:3: lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSigningRequirementAccess().getSupportedSigningAlgorithmsSigningAlgothmEnumRuleCall_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleSigningAlgothm_in_ruleSigningRequirement4466);
                    	    lv_supportedSigningAlgorithms_4_0=ruleSigningAlgothm();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSigningRequirementRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"supportedSigningAlgorithms",
                    	              		lv_supportedSigningAlgorithms_4_0, 
                    	              		"SigningAlgothm");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt57 >= 1 ) break loop57;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(57, input);
                                throw eee;
                        }
                        cnt57++;
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2193:5: (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==68) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2193:7: otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) )
                    {
                    otherlv_5=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleSigningRequirement4482); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSigningRequirementAccess().getRequiresAlgorithmKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2197:1: ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2198:1: (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2198:1: (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2199:3: lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSigningRequirementAccess().getRequiredSigningAlgorithmSigningAlgothmEnumRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSigningAlgothm_in_ruleSigningRequirement4503);
                    lv_requiredSigningAlgorithm_6_0=ruleSigningAlgothm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSigningRequirementRule());
                      	        }
                             		set(
                             			current, 
                             			"requiredSigningAlgorithm",
                              		lv_requiredSigningAlgorithm_6_0, 
                              		"SigningAlgothm");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2215:4: (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==69) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2215:6: otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )*
                    {
                    otherlv_7=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleSigningRequirement4518); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getSigningRequirementAccess().getSignedMessagePartsKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2219:1: ( (lv_signedParts_8_0= ruleMessagePartRef ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2220:1: (lv_signedParts_8_0= ruleMessagePartRef )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2220:1: (lv_signedParts_8_0= ruleMessagePartRef )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2221:3: lv_signedParts_8_0= ruleMessagePartRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSigningRequirementAccess().getSignedPartsMessagePartRefParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_ruleSigningRequirement4539);
                    lv_signedParts_8_0=ruleMessagePartRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSigningRequirementRule());
                      	        }
                             		add(
                             			current, 
                             			"signedParts",
                              		lv_signedParts_8_0, 
                              		"MessagePartRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2237:2: (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==70) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2237:4: otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) )
                    	    {
                    	    otherlv_9=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleSigningRequirement4552); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getSigningRequirementAccess().getCommaKeyword_5_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2241:1: ( (lv_signedParts_10_0= ruleMessagePartRef ) )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2242:1: (lv_signedParts_10_0= ruleMessagePartRef )
                    	    {
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2242:1: (lv_signedParts_10_0= ruleMessagePartRef )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2243:3: lv_signedParts_10_0= ruleMessagePartRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSigningRequirementAccess().getSignedPartsMessagePartRefParserRuleCall_5_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_ruleSigningRequirement4573);
                    	    lv_signedParts_10_0=ruleMessagePartRef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSigningRequirementRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"signedParts",
                    	              		lv_signedParts_10_0, 
                    	              		"MessagePartRef");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop60;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSigningRequirement4589); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getSigningRequirementAccess().getRightCurlyBracketKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSigningRequirement"


    // $ANTLR start "entryRuleMessagePartRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2271:1: entryRuleMessagePartRef returns [EObject current=null] : iv_ruleMessagePartRef= ruleMessagePartRef EOF ;
    public final EObject entryRuleMessagePartRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessagePartRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2272:2: (iv_ruleMessagePartRef= ruleMessagePartRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2273:2: iv_ruleMessagePartRef= ruleMessagePartRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMessagePartRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_entryRuleMessagePartRef4625);
            iv_ruleMessagePartRef=ruleMessagePartRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMessagePartRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMessagePartRef4635); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessagePartRef"


    // $ANTLR start "ruleMessagePartRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2280:1: ruleMessagePartRef returns [EObject current=null] : ( ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleMessagePartRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_partRefExpression_2_0=null;
        Enumerator lv_messagePartRef_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2283:28: ( ( ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )? ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2284:1: ( ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )? )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2284:1: ( ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )? )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2284:2: ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )?
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2284:2: ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2285:1: (lv_messagePartRef_0_0= ruleMessagePartRefKind )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2285:1: (lv_messagePartRef_0_0= ruleMessagePartRefKind )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2286:3: lv_messagePartRef_0_0= ruleMessagePartRefKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMessagePartRefAccess().getMessagePartRefMessagePartRefKindEnumRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleMessagePartRefKind_in_ruleMessagePartRef4681);
            lv_messagePartRef_0_0=ruleMessagePartRefKind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMessagePartRefRule());
              	        }
                     		set(
                     			current, 
                     			"messagePartRef",
                      		lv_messagePartRef_0_0, 
                      		"MessagePartRefKind");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2302:2: (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==71) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2302:4: otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleMessagePartRef4694); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMessagePartRefAccess().getExpressionKeyword_1_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2306:1: ( (lv_partRefExpression_2_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2307:1: (lv_partRefExpression_2_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2307:1: (lv_partRefExpression_2_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2308:3: lv_partRefExpression_2_0= RULE_STRING
                    {
                    lv_partRefExpression_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMessagePartRef4711); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_partRefExpression_2_0, grammarAccess.getMessagePartRefAccess().getPartRefExpressionSTRINGTerminalRuleCall_1_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMessagePartRefRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"partRefExpression",
                              		lv_partRefExpression_2_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessagePartRef"


    // $ANTLR start "entryRuleEncryptionRequirement"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2332:1: entryRuleEncryptionRequirement returns [EObject current=null] : iv_ruleEncryptionRequirement= ruleEncryptionRequirement EOF ;
    public final EObject entryRuleEncryptionRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEncryptionRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2333:2: (iv_ruleEncryptionRequirement= ruleEncryptionRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2334:2: iv_ruleEncryptionRequirement= ruleEncryptionRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEncryptionRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEncryptionRequirement_in_entryRuleEncryptionRequirement4754);
            iv_ruleEncryptionRequirement=ruleEncryptionRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEncryptionRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEncryptionRequirement4764); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEncryptionRequirement"


    // $ANTLR start "ruleEncryptionRequirement"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2341:1: ruleEncryptionRequirement returns [EObject current=null] : ( () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' ) ;
    public final EObject ruleEncryptionRequirement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Enumerator lv_supportedCipherAlgorithms_4_0 = null;

        Enumerator lv_requiredCipherAlgorithm_6_0 = null;

        EObject lv_encryptedParts_8_0 = null;

        EObject lv_encryptedParts_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2344:28: ( ( () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2345:1: ( () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2345:1: ( () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2345:2: () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}'
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2345:2: ()
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2346:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEncryptionRequirementAccess().getEncryptionRequirementAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleEncryptionRequirement4813); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEncryptionRequirementAccess().getEncryptionPolicyKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEncryptionRequirement4825); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getEncryptionRequirementAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2362:1: (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==67) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2362:3: otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+
                    {
                    otherlv_3=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleEncryptionRequirement4838); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getEncryptionRequirementAccess().getSupportedAlgorithmsKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2366:1: ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+
                    int cnt63=0;
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==114||LA63_0==116||(LA63_0>=118 && LA63_0<=123)) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2367:1: (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind )
                    	    {
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2367:1: (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2368:3: lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getEncryptionRequirementAccess().getSupportedCipherAlgorithmsCipherAlgorithmKindEnumRuleCall_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCipherAlgorithmKind_in_ruleEncryptionRequirement4859);
                    	    lv_supportedCipherAlgorithms_4_0=ruleCipherAlgorithmKind();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getEncryptionRequirementRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"supportedCipherAlgorithms",
                    	              		lv_supportedCipherAlgorithms_4_0, 
                    	              		"CipherAlgorithmKind");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt63 >= 1 ) break loop63;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(63, input);
                                throw eee;
                        }
                        cnt63++;
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2384:5: (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==68) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2384:7: otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) )
                    {
                    otherlv_5=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleEncryptionRequirement4875); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getEncryptionRequirementAccess().getRequiresAlgorithmKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2388:1: ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2389:1: (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2389:1: (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2390:3: lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEncryptionRequirementAccess().getRequiredCipherAlgorithmCipherAlgorithmKindEnumRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCipherAlgorithmKind_in_ruleEncryptionRequirement4896);
                    lv_requiredCipherAlgorithm_6_0=ruleCipherAlgorithmKind();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEncryptionRequirementRule());
                      	        }
                             		set(
                             			current, 
                             			"requiredCipherAlgorithm",
                              		lv_requiredCipherAlgorithm_6_0, 
                              		"CipherAlgorithmKind");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2406:4: (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==73) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2406:6: otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )*
                    {
                    otherlv_7=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleEncryptionRequirement4911); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getEncryptionRequirementAccess().getEncryptedMessagePartsKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2410:1: ( (lv_encryptedParts_8_0= ruleMessagePartRef ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2411:1: (lv_encryptedParts_8_0= ruleMessagePartRef )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2411:1: (lv_encryptedParts_8_0= ruleMessagePartRef )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2412:3: lv_encryptedParts_8_0= ruleMessagePartRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEncryptionRequirementAccess().getEncryptedPartsMessagePartRefParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_ruleEncryptionRequirement4932);
                    lv_encryptedParts_8_0=ruleMessagePartRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEncryptionRequirementRule());
                      	        }
                             		add(
                             			current, 
                             			"encryptedParts",
                              		lv_encryptedParts_8_0, 
                              		"MessagePartRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2428:2: (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==70) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2428:4: otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) )
                    	    {
                    	    otherlv_9=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleEncryptionRequirement4945); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getEncryptionRequirementAccess().getCommaKeyword_5_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2432:1: ( (lv_encryptedParts_10_0= ruleMessagePartRef ) )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2433:1: (lv_encryptedParts_10_0= ruleMessagePartRef )
                    	    {
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2433:1: (lv_encryptedParts_10_0= ruleMessagePartRef )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2434:3: lv_encryptedParts_10_0= ruleMessagePartRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getEncryptionRequirementAccess().getEncryptedPartsMessagePartRefParserRuleCall_5_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_ruleEncryptionRequirement4966);
                    	    lv_encryptedParts_10_0=ruleMessagePartRef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getEncryptionRequirementRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"encryptedParts",
                    	              		lv_encryptedParts_10_0, 
                    	              		"MessagePartRef");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop66;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleEncryptionRequirement4982); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getEncryptionRequirementAccess().getRightCurlyBracketKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEncryptionRequirement"


    // $ANTLR start "entryRulePriorityDeclaration"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2462:1: entryRulePriorityDeclaration returns [EObject current=null] : iv_rulePriorityDeclaration= rulePriorityDeclaration EOF ;
    public final EObject entryRulePriorityDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePriorityDeclaration = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2463:2: (iv_rulePriorityDeclaration= rulePriorityDeclaration EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2464:2: iv_rulePriorityDeclaration= rulePriorityDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPriorityDeclarationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePriorityDeclaration_in_entryRulePriorityDeclaration5018);
            iv_rulePriorityDeclaration=rulePriorityDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePriorityDeclaration; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePriorityDeclaration5028); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePriorityDeclaration"


    // $ANTLR start "rulePriorityDeclaration"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2471:1: rulePriorityDeclaration returns [EObject current=null] : (otherlv_0= 'priority' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) ) ;
    public final EObject rulePriorityDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_description_3_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2474:28: ( (otherlv_0= 'priority' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2475:1: (otherlv_0= 'priority' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2475:1: (otherlv_0= 'priority' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2475:3: otherlv_0= 'priority' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,74,FollowSets000.FOLLOW_74_in_rulePriorityDeclaration5065); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPriorityDeclarationAccess().getPriorityKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2479:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2480:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2480:1: (lv_name_1_0= RULE_ID )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2481:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePriorityDeclaration5082); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getPriorityDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPriorityDeclarationRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_rulePriorityDeclaration5099); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getPriorityDeclarationAccess().getDescriptionKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2501:1: ( (lv_description_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2502:1: (lv_description_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2502:1: (lv_description_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2503:3: lv_description_3_0= RULE_STRING
            {
            lv_description_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rulePriorityDeclaration5116); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_description_3_0, grammarAccess.getPriorityDeclarationAccess().getDescriptionSTRINGTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getPriorityDeclarationRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"description",
                      		lv_description_3_0, 
                      		"STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePriorityDeclaration"


    // $ANTLR start "entryRuleEscalation"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2527:1: entryRuleEscalation returns [EObject current=null] : iv_ruleEscalation= ruleEscalation EOF ;
    public final EObject entryRuleEscalation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEscalation = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2528:2: (iv_ruleEscalation= ruleEscalation EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2529:2: iv_ruleEscalation= ruleEscalation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEscalationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_entryRuleEscalation5157);
            iv_ruleEscalation=ruleEscalation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEscalation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEscalation5167); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEscalation"


    // $ANTLR start "ruleEscalation"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2536:1: ruleEscalation returns [EObject current=null] : (otherlv_0= 'escalation' otherlv_1= '{' (otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) ) )? otherlv_4= 'escalate-to' otherlv_5= '{' ( ( ruleQualifiedName ) )+ otherlv_7= '}' (otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) ;
    public final EObject ruleEscalation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_cause_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_procedure_9_0=null;
        Token otherlv_10=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2539:28: ( (otherlv_0= 'escalation' otherlv_1= '{' (otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) ) )? otherlv_4= 'escalate-to' otherlv_5= '{' ( ( ruleQualifiedName ) )+ otherlv_7= '}' (otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2540:1: (otherlv_0= 'escalation' otherlv_1= '{' (otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) ) )? otherlv_4= 'escalate-to' otherlv_5= '{' ( ( ruleQualifiedName ) )+ otherlv_7= '}' (otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2540:1: (otherlv_0= 'escalation' otherlv_1= '{' (otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) ) )? otherlv_4= 'escalate-to' otherlv_5= '{' ( ( ruleQualifiedName ) )+ otherlv_7= '}' (otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2540:3: otherlv_0= 'escalation' otherlv_1= '{' (otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) ) )? otherlv_4= 'escalate-to' otherlv_5= '{' ( ( ruleQualifiedName ) )+ otherlv_7= '}' (otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) ) )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleEscalation5204); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEscalationAccess().getEscalationKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEscalation5216); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEscalationAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2548:1: (otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==76) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2548:3: otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleEscalation5229); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getEscalationAccess().getCauseKeyword_2_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2552:1: ( (lv_cause_3_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2553:1: (lv_cause_3_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2553:1: (lv_cause_3_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2554:3: lv_cause_3_0= RULE_STRING
                    {
                    lv_cause_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEscalation5246); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_cause_3_0, grammarAccess.getEscalationAccess().getCauseSTRINGTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEscalationRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"cause",
                              		lv_cause_3_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleEscalation5265); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEscalationAccess().getEscalateToKeyword_3());
                  
            }
            otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEscalation5277); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getEscalationAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2578:1: ( ( ruleQualifiedName ) )+
            int cnt69=0;
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==RULE_ID) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2579:1: ( ruleQualifiedName )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2579:1: ( ruleQualifiedName )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2580:3: ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getEscalationRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEscalationAccess().getEscalationTargetsUserCrossReference_5_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleEscalation5304);
            	    ruleQualifiedName();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt69 >= 1 ) break loop69;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(69, input);
                        throw eee;
                }
                cnt69++;
            } while (true);

            otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleEscalation5317); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getEscalationAccess().getRightCurlyBracketKeyword_6());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2600:1: (otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==78) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2600:3: otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleEscalation5330); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getEscalationAccess().getProcedureKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2604:1: ( (lv_procedure_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2605:1: (lv_procedure_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2605:1: (lv_procedure_9_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2606:3: lv_procedure_9_0= RULE_STRING
                    {
                    lv_procedure_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEscalation5347); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_procedure_9_0, grammarAccess.getEscalationAccess().getProcedureSTRINGTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getEscalationRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"procedure",
                              		lv_procedure_9_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleEscalation5366); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getEscalationAccess().getRightCurlyBracketKeyword_8());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEscalation"


    // $ANTLR start "entryRuleParty"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2634:1: entryRuleParty returns [EObject current=null] : iv_ruleParty= ruleParty EOF ;
    public final EObject entryRuleParty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParty = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2635:2: (iv_ruleParty= ruleParty EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2636:2: iv_ruleParty= ruleParty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParty_in_entryRuleParty5402);
            iv_ruleParty=ruleParty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParty; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParty5412); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParty"


    // $ANTLR start "ruleParty"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2643:1: ruleParty returns [EObject current=null] : (this_CustomerParty_0= ruleCustomerParty | this_ProviderParty_1= ruleProviderParty | this_ThirdParty_2= ruleThirdParty ) ;
    public final EObject ruleParty() throws RecognitionException {
        EObject current = null;

        EObject this_CustomerParty_0 = null;

        EObject this_ProviderParty_1 = null;

        EObject this_ThirdParty_2 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2646:28: ( (this_CustomerParty_0= ruleCustomerParty | this_ProviderParty_1= ruleProviderParty | this_ThirdParty_2= ruleThirdParty ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2647:1: (this_CustomerParty_0= ruleCustomerParty | this_ProviderParty_1= ruleProviderParty | this_ThirdParty_2= ruleThirdParty )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2647:1: (this_CustomerParty_0= ruleCustomerParty | this_ProviderParty_1= ruleProviderParty | this_ThirdParty_2= ruleThirdParty )
            int alt71=3;
            switch ( input.LA(1) ) {
            case 79:
                {
                alt71=1;
                }
                break;
            case 80:
                {
                alt71=2;
                }
                break;
            case 81:
                {
                alt71=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2648:2: this_CustomerParty_0= ruleCustomerParty
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartyAccess().getCustomerPartyParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCustomerParty_in_ruleParty5462);
                    this_CustomerParty_0=ruleCustomerParty();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CustomerParty_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2661:2: this_ProviderParty_1= ruleProviderParty
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartyAccess().getProviderPartyParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProviderParty_in_ruleParty5492);
                    this_ProviderParty_1=ruleProviderParty();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ProviderParty_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2674:2: this_ThirdParty_2= ruleThirdParty
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartyAccess().getThirdPartyParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleThirdParty_in_ruleParty5522);
                    this_ThirdParty_2=ruleThirdParty();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ThirdParty_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParty"


    // $ANTLR start "entryRuleCustomerParty"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2693:1: entryRuleCustomerParty returns [EObject current=null] : iv_ruleCustomerParty= ruleCustomerParty EOF ;
    public final EObject entryRuleCustomerParty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomerParty = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2694:2: (iv_ruleCustomerParty= ruleCustomerParty EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2695:2: iv_ruleCustomerParty= ruleCustomerParty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCustomerPartyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCustomerParty_in_entryRuleCustomerParty5557);
            iv_ruleCustomerParty=ruleCustomerParty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCustomerParty; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCustomerParty5567); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCustomerParty"


    // $ANTLR start "ruleCustomerParty"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2702:1: ruleCustomerParty returns [EObject current=null] : (otherlv_0= 'customer-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepresentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' ) ;
    public final EObject ruleCustomerParty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_representatives_3_0 = null;

        EObject lv_responsibilities_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2705:28: ( (otherlv_0= 'customer-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepresentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2706:1: (otherlv_0= 'customer-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepresentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2706:1: (otherlv_0= 'customer-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepresentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2706:3: otherlv_0= 'customer-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepresentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleCustomerParty5604); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getCustomerPartyAccess().getCustomerPartyKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2710:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2711:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2711:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2712:3: lv_name_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCustomerPartyAccess().getNameQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleCustomerParty5625);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCustomerPartyRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"QualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleCustomerParty5637); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getCustomerPartyAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2732:1: ( (lv_representatives_3_0= ruleRepresentative ) )+
            int cnt72=0;
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==RULE_ID||LA72_0==83) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2733:1: (lv_representatives_3_0= ruleRepresentative )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2733:1: (lv_representatives_3_0= ruleRepresentative )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2734:3: lv_representatives_3_0= ruleRepresentative
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCustomerPartyAccess().getRepresentativesRepresentativeParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleRepresentative_in_ruleCustomerParty5658);
            	    lv_representatives_3_0=ruleRepresentative();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getCustomerPartyRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"representatives",
            	              		lv_representatives_3_0, 
            	              		"Representative");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt72 >= 1 ) break loop72;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(72, input);
                        throw eee;
                }
                cnt72++;
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2750:3: ( (lv_responsibilities_4_0= ruleResponsibility ) )+
            int cnt73=0;
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==89) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2751:1: (lv_responsibilities_4_0= ruleResponsibility )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2751:1: (lv_responsibilities_4_0= ruleResponsibility )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2752:3: lv_responsibilities_4_0= ruleResponsibility
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCustomerPartyAccess().getResponsibilitiesResponsibilityParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleResponsibility_in_ruleCustomerParty5680);
            	    lv_responsibilities_4_0=ruleResponsibility();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getCustomerPartyRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"responsibilities",
            	              		lv_responsibilities_4_0, 
            	              		"Responsibility");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt73 >= 1 ) break loop73;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(73, input);
                        throw eee;
                }
                cnt73++;
            } while (true);

            otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleCustomerParty5693); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getCustomerPartyAccess().getRightCurlyBracketKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCustomerParty"


    // $ANTLR start "entryRuleProviderParty"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2780:1: entryRuleProviderParty returns [EObject current=null] : iv_ruleProviderParty= ruleProviderParty EOF ;
    public final EObject entryRuleProviderParty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProviderParty = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2781:2: (iv_ruleProviderParty= ruleProviderParty EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2782:2: iv_ruleProviderParty= ruleProviderParty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProviderPartyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleProviderParty_in_entryRuleProviderParty5729);
            iv_ruleProviderParty=ruleProviderParty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProviderParty; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProviderParty5739); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProviderParty"


    // $ANTLR start "ruleProviderParty"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2789:1: ruleProviderParty returns [EObject current=null] : (otherlv_0= 'provider-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepresentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' ) ;
    public final EObject ruleProviderParty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_representatives_3_0 = null;

        EObject lv_responsibilities_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2792:28: ( (otherlv_0= 'provider-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepresentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2793:1: (otherlv_0= 'provider-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepresentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2793:1: (otherlv_0= 'provider-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepresentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2793:3: otherlv_0= 'provider-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepresentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleProviderParty5776); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getProviderPartyAccess().getProviderPartyKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2797:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2798:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2798:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2799:3: lv_name_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProviderPartyAccess().getNameQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleProviderParty5797);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getProviderPartyRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"QualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleProviderParty5809); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getProviderPartyAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2819:1: ( (lv_representatives_3_0= ruleRepresentative ) )+
            int cnt74=0;
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==RULE_ID||LA74_0==83) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2820:1: (lv_representatives_3_0= ruleRepresentative )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2820:1: (lv_representatives_3_0= ruleRepresentative )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2821:3: lv_representatives_3_0= ruleRepresentative
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProviderPartyAccess().getRepresentativesRepresentativeParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleRepresentative_in_ruleProviderParty5830);
            	    lv_representatives_3_0=ruleRepresentative();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProviderPartyRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"representatives",
            	              		lv_representatives_3_0, 
            	              		"Representative");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt74 >= 1 ) break loop74;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(74, input);
                        throw eee;
                }
                cnt74++;
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2837:3: ( (lv_responsibilities_4_0= ruleResponsibility ) )+
            int cnt75=0;
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==89) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2838:1: (lv_responsibilities_4_0= ruleResponsibility )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2838:1: (lv_responsibilities_4_0= ruleResponsibility )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2839:3: lv_responsibilities_4_0= ruleResponsibility
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProviderPartyAccess().getResponsibilitiesResponsibilityParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleResponsibility_in_ruleProviderParty5852);
            	    lv_responsibilities_4_0=ruleResponsibility();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getProviderPartyRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"responsibilities",
            	              		lv_responsibilities_4_0, 
            	              		"Responsibility");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt75 >= 1 ) break loop75;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(75, input);
                        throw eee;
                }
                cnt75++;
            } while (true);

            otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleProviderParty5865); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getProviderPartyAccess().getRightCurlyBracketKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProviderParty"


    // $ANTLR start "entryRuleThirdParty"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2867:1: entryRuleThirdParty returns [EObject current=null] : iv_ruleThirdParty= ruleThirdParty EOF ;
    public final EObject entryRuleThirdParty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThirdParty = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2868:2: (iv_ruleThirdParty= ruleThirdParty EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2869:2: iv_ruleThirdParty= ruleThirdParty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getThirdPartyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleThirdParty_in_entryRuleThirdParty5901);
            iv_ruleThirdParty=ruleThirdParty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleThirdParty; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleThirdParty5911); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleThirdParty"


    // $ANTLR start "ruleThirdParty"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2876:1: ruleThirdParty returns [EObject current=null] : (otherlv_0= 'third-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' otherlv_3= 'participation-role' ( (lv_role_4_0= RULE_STRING ) ) ( (lv_representatives_5_0= ruleRepresentative ) )+ ( (lv_responsibilities_6_0= ruleResponsibility ) )+ otherlv_7= '}' ) ;
    public final EObject ruleThirdParty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_role_4_0=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_representatives_5_0 = null;

        EObject lv_responsibilities_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2879:28: ( (otherlv_0= 'third-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' otherlv_3= 'participation-role' ( (lv_role_4_0= RULE_STRING ) ) ( (lv_representatives_5_0= ruleRepresentative ) )+ ( (lv_responsibilities_6_0= ruleResponsibility ) )+ otherlv_7= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2880:1: (otherlv_0= 'third-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' otherlv_3= 'participation-role' ( (lv_role_4_0= RULE_STRING ) ) ( (lv_representatives_5_0= ruleRepresentative ) )+ ( (lv_responsibilities_6_0= ruleResponsibility ) )+ otherlv_7= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2880:1: (otherlv_0= 'third-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' otherlv_3= 'participation-role' ( (lv_role_4_0= RULE_STRING ) ) ( (lv_representatives_5_0= ruleRepresentative ) )+ ( (lv_responsibilities_6_0= ruleResponsibility ) )+ otherlv_7= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2880:3: otherlv_0= 'third-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' otherlv_3= 'participation-role' ( (lv_role_4_0= RULE_STRING ) ) ( (lv_representatives_5_0= ruleRepresentative ) )+ ( (lv_responsibilities_6_0= ruleResponsibility ) )+ otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleThirdParty5948); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getThirdPartyAccess().getThirdPartyKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2884:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2885:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2885:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2886:3: lv_name_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getThirdPartyAccess().getNameQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleThirdParty5969);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getThirdPartyRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"QualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleThirdParty5981); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getThirdPartyAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleThirdParty5993); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getThirdPartyAccess().getParticipationRoleKeyword_3());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2910:1: ( (lv_role_4_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2911:1: (lv_role_4_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2911:1: (lv_role_4_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2912:3: lv_role_4_0= RULE_STRING
            {
            lv_role_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleThirdParty6010); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_role_4_0, grammarAccess.getThirdPartyAccess().getRoleSTRINGTerminalRuleCall_4_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getThirdPartyRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"role",
                      		lv_role_4_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2928:2: ( (lv_representatives_5_0= ruleRepresentative ) )+
            int cnt76=0;
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==RULE_ID||LA76_0==83) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2929:1: (lv_representatives_5_0= ruleRepresentative )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2929:1: (lv_representatives_5_0= ruleRepresentative )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2930:3: lv_representatives_5_0= ruleRepresentative
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getThirdPartyAccess().getRepresentativesRepresentativeParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleRepresentative_in_ruleThirdParty6036);
            	    lv_representatives_5_0=ruleRepresentative();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getThirdPartyRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"representatives",
            	              		lv_representatives_5_0, 
            	              		"Representative");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt76 >= 1 ) break loop76;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(76, input);
                        throw eee;
                }
                cnt76++;
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2946:3: ( (lv_responsibilities_6_0= ruleResponsibility ) )+
            int cnt77=0;
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==89) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2947:1: (lv_responsibilities_6_0= ruleResponsibility )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2947:1: (lv_responsibilities_6_0= ruleResponsibility )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2948:3: lv_responsibilities_6_0= ruleResponsibility
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getThirdPartyAccess().getResponsibilitiesResponsibilityParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleResponsibility_in_ruleThirdParty6058);
            	    lv_responsibilities_6_0=ruleResponsibility();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getThirdPartyRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"responsibilities",
            	              		lv_responsibilities_6_0, 
            	              		"Responsibility");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt77 >= 1 ) break loop77;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(77, input);
                        throw eee;
                }
                cnt77++;
            } while (true);

            otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleThirdParty6071); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getThirdPartyAccess().getRightCurlyBracketKeyword_7());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleThirdParty"


    // $ANTLR start "entryRuleRepresentative"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2976:1: entryRuleRepresentative returns [EObject current=null] : iv_ruleRepresentative= ruleRepresentative EOF ;
    public final EObject entryRuleRepresentative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRepresentative = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2977:2: (iv_ruleRepresentative= ruleRepresentative EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2978:2: iv_ruleRepresentative= ruleRepresentative EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRepresentativeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRepresentative_in_entryRuleRepresentative6107);
            iv_ruleRepresentative=ruleRepresentative();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRepresentative; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRepresentative6117); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRepresentative"


    // $ANTLR start "ruleRepresentative"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2985:1: ruleRepresentative returns [EObject current=null] : (this_UserRef_0= ruleUserRef | this_InlineRepresentative_1= ruleInlineRepresentative ) ;
    public final EObject ruleRepresentative() throws RecognitionException {
        EObject current = null;

        EObject this_UserRef_0 = null;

        EObject this_InlineRepresentative_1 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2988:28: ( (this_UserRef_0= ruleUserRef | this_InlineRepresentative_1= ruleInlineRepresentative ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2989:1: (this_UserRef_0= ruleUserRef | this_InlineRepresentative_1= ruleInlineRepresentative )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2989:1: (this_UserRef_0= ruleUserRef | this_InlineRepresentative_1= ruleInlineRepresentative )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_ID) ) {
                alt78=1;
            }
            else if ( (LA78_0==83) ) {
                alt78=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2990:2: this_UserRef_0= ruleUserRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getRepresentativeAccess().getUserRefParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUserRef_in_ruleRepresentative6167);
                    this_UserRef_0=ruleUserRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_UserRef_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3003:2: this_InlineRepresentative_1= ruleInlineRepresentative
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getRepresentativeAccess().getInlineRepresentativeParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInlineRepresentative_in_ruleRepresentative6197);
                    this_InlineRepresentative_1=ruleInlineRepresentative();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_InlineRepresentative_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRepresentative"


    // $ANTLR start "entryRuleUserRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3022:1: entryRuleUserRef returns [EObject current=null] : iv_ruleUserRef= ruleUserRef EOF ;
    public final EObject entryRuleUserRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUserRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3023:2: (iv_ruleUserRef= ruleUserRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3024:2: iv_ruleUserRef= ruleUserRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUserRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUserRef_in_entryRuleUserRef6232);
            iv_ruleUserRef=ruleUserRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUserRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUserRef6242); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUserRef"


    // $ANTLR start "ruleUserRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3031:1: ruleUserRef returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleUserRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3034:28: ( ( ( ruleQualifiedName ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3035:1: ( ( ruleQualifiedName ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3035:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3036:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3036:1: ( ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3037:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getUserRefRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUserRefAccess().getRepresentativeUserCrossReference_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleUserRef6293);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUserRef"


    // $ANTLR start "entryRuleInlineRepresentative"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3061:1: entryRuleInlineRepresentative returns [EObject current=null] : iv_ruleInlineRepresentative= ruleInlineRepresentative EOF ;
    public final EObject entryRuleInlineRepresentative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInlineRepresentative = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3062:2: (iv_ruleInlineRepresentative= ruleInlineRepresentative EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3063:2: iv_ruleInlineRepresentative= ruleInlineRepresentative EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInlineRepresentativeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInlineRepresentative_in_entryRuleInlineRepresentative6328);
            iv_ruleInlineRepresentative=ruleInlineRepresentative();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInlineRepresentative; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInlineRepresentative6338); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInlineRepresentative"


    // $ANTLR start "ruleInlineRepresentative"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3070:1: ruleInlineRepresentative returns [EObject current=null] : ( () otherlv_1= 'representative' otherlv_2= '{' (otherlv_3= 'first-name' ( (lv_firstname_4_0= RULE_STRING ) ) )? (otherlv_5= 'last-name' ( (lv_lastname_6_0= RULE_STRING ) ) )? (otherlv_7= 'org-unit' ( (lv_orgUnit_8_0= RULE_STRING ) ) )? (otherlv_9= 'email' ( (lv_email_10_0= RULE_STRING ) ) )? (otherlv_11= 'phone' ( (lv_phone_12_0= RULE_STRING ) ) )? otherlv_13= '}' ) ;
    public final EObject ruleInlineRepresentative() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_firstname_4_0=null;
        Token otherlv_5=null;
        Token lv_lastname_6_0=null;
        Token otherlv_7=null;
        Token lv_orgUnit_8_0=null;
        Token otherlv_9=null;
        Token lv_email_10_0=null;
        Token otherlv_11=null;
        Token lv_phone_12_0=null;
        Token otherlv_13=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3073:28: ( ( () otherlv_1= 'representative' otherlv_2= '{' (otherlv_3= 'first-name' ( (lv_firstname_4_0= RULE_STRING ) ) )? (otherlv_5= 'last-name' ( (lv_lastname_6_0= RULE_STRING ) ) )? (otherlv_7= 'org-unit' ( (lv_orgUnit_8_0= RULE_STRING ) ) )? (otherlv_9= 'email' ( (lv_email_10_0= RULE_STRING ) ) )? (otherlv_11= 'phone' ( (lv_phone_12_0= RULE_STRING ) ) )? otherlv_13= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3074:1: ( () otherlv_1= 'representative' otherlv_2= '{' (otherlv_3= 'first-name' ( (lv_firstname_4_0= RULE_STRING ) ) )? (otherlv_5= 'last-name' ( (lv_lastname_6_0= RULE_STRING ) ) )? (otherlv_7= 'org-unit' ( (lv_orgUnit_8_0= RULE_STRING ) ) )? (otherlv_9= 'email' ( (lv_email_10_0= RULE_STRING ) ) )? (otherlv_11= 'phone' ( (lv_phone_12_0= RULE_STRING ) ) )? otherlv_13= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3074:1: ( () otherlv_1= 'representative' otherlv_2= '{' (otherlv_3= 'first-name' ( (lv_firstname_4_0= RULE_STRING ) ) )? (otherlv_5= 'last-name' ( (lv_lastname_6_0= RULE_STRING ) ) )? (otherlv_7= 'org-unit' ( (lv_orgUnit_8_0= RULE_STRING ) ) )? (otherlv_9= 'email' ( (lv_email_10_0= RULE_STRING ) ) )? (otherlv_11= 'phone' ( (lv_phone_12_0= RULE_STRING ) ) )? otherlv_13= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3074:2: () otherlv_1= 'representative' otherlv_2= '{' (otherlv_3= 'first-name' ( (lv_firstname_4_0= RULE_STRING ) ) )? (otherlv_5= 'last-name' ( (lv_lastname_6_0= RULE_STRING ) ) )? (otherlv_7= 'org-unit' ( (lv_orgUnit_8_0= RULE_STRING ) ) )? (otherlv_9= 'email' ( (lv_email_10_0= RULE_STRING ) ) )? (otherlv_11= 'phone' ( (lv_phone_12_0= RULE_STRING ) ) )? otherlv_13= '}'
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3074:2: ()
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3075:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getInlineRepresentativeAccess().getInlineRepresentativeAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleInlineRepresentative6387); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getInlineRepresentativeAccess().getRepresentativeKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleInlineRepresentative6399); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getInlineRepresentativeAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3091:1: (otherlv_3= 'first-name' ( (lv_firstname_4_0= RULE_STRING ) ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==84) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3091:3: otherlv_3= 'first-name' ( (lv_firstname_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,84,FollowSets000.FOLLOW_84_in_ruleInlineRepresentative6412); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getInlineRepresentativeAccess().getFirstNameKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3095:1: ( (lv_firstname_4_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3096:1: (lv_firstname_4_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3096:1: (lv_firstname_4_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3097:3: lv_firstname_4_0= RULE_STRING
                    {
                    lv_firstname_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleInlineRepresentative6429); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_firstname_4_0, grammarAccess.getInlineRepresentativeAccess().getFirstnameSTRINGTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getInlineRepresentativeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"firstname",
                              		lv_firstname_4_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3113:4: (otherlv_5= 'last-name' ( (lv_lastname_6_0= RULE_STRING ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==85) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3113:6: otherlv_5= 'last-name' ( (lv_lastname_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,85,FollowSets000.FOLLOW_85_in_ruleInlineRepresentative6449); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getInlineRepresentativeAccess().getLastNameKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3117:1: ( (lv_lastname_6_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3118:1: (lv_lastname_6_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3118:1: (lv_lastname_6_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3119:3: lv_lastname_6_0= RULE_STRING
                    {
                    lv_lastname_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleInlineRepresentative6466); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_lastname_6_0, grammarAccess.getInlineRepresentativeAccess().getLastnameSTRINGTerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getInlineRepresentativeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"lastname",
                              		lv_lastname_6_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3135:4: (otherlv_7= 'org-unit' ( (lv_orgUnit_8_0= RULE_STRING ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==86) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3135:6: otherlv_7= 'org-unit' ( (lv_orgUnit_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,86,FollowSets000.FOLLOW_86_in_ruleInlineRepresentative6486); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getInlineRepresentativeAccess().getOrgUnitKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3139:1: ( (lv_orgUnit_8_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3140:1: (lv_orgUnit_8_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3140:1: (lv_orgUnit_8_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3141:3: lv_orgUnit_8_0= RULE_STRING
                    {
                    lv_orgUnit_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleInlineRepresentative6503); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_orgUnit_8_0, grammarAccess.getInlineRepresentativeAccess().getOrgUnitSTRINGTerminalRuleCall_5_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getInlineRepresentativeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"orgUnit",
                              		lv_orgUnit_8_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3157:4: (otherlv_9= 'email' ( (lv_email_10_0= RULE_STRING ) ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==87) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3157:6: otherlv_9= 'email' ( (lv_email_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,87,FollowSets000.FOLLOW_87_in_ruleInlineRepresentative6523); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getInlineRepresentativeAccess().getEmailKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3161:1: ( (lv_email_10_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3162:1: (lv_email_10_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3162:1: (lv_email_10_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3163:3: lv_email_10_0= RULE_STRING
                    {
                    lv_email_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleInlineRepresentative6540); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_email_10_0, grammarAccess.getInlineRepresentativeAccess().getEmailSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getInlineRepresentativeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"email",
                              		lv_email_10_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3179:4: (otherlv_11= 'phone' ( (lv_phone_12_0= RULE_STRING ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==88) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3179:6: otherlv_11= 'phone' ( (lv_phone_12_0= RULE_STRING ) )
                    {
                    otherlv_11=(Token)match(input,88,FollowSets000.FOLLOW_88_in_ruleInlineRepresentative6560); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getInlineRepresentativeAccess().getPhoneKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3183:1: ( (lv_phone_12_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3184:1: (lv_phone_12_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3184:1: (lv_phone_12_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3185:3: lv_phone_12_0= RULE_STRING
                    {
                    lv_phone_12_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleInlineRepresentative6577); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_phone_12_0, grammarAccess.getInlineRepresentativeAccess().getPhoneSTRINGTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getInlineRepresentativeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"phone",
                              		lv_phone_12_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleInlineRepresentative6596); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getInlineRepresentativeAccess().getRightCurlyBracketKeyword_8());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInlineRepresentative"


    // $ANTLR start "entryRuleResponsibility"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3213:1: entryRuleResponsibility returns [EObject current=null] : iv_ruleResponsibility= ruleResponsibility EOF ;
    public final EObject entryRuleResponsibility() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResponsibility = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3214:2: (iv_ruleResponsibility= ruleResponsibility EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3215:2: iv_ruleResponsibility= ruleResponsibility EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResponsibilityRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleResponsibility_in_entryRuleResponsibility6632);
            iv_ruleResponsibility=ruleResponsibility();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResponsibility; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleResponsibility6642); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResponsibility"


    // $ANTLR start "ruleResponsibility"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3222:1: ruleResponsibility returns [EObject current=null] : (otherlv_0= 'responsibility' ( (lv_description_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleResponsibility() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_description_1_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3225:28: ( (otherlv_0= 'responsibility' ( (lv_description_1_0= RULE_STRING ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3226:1: (otherlv_0= 'responsibility' ( (lv_description_1_0= RULE_STRING ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3226:1: (otherlv_0= 'responsibility' ( (lv_description_1_0= RULE_STRING ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3226:3: otherlv_0= 'responsibility' ( (lv_description_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,89,FollowSets000.FOLLOW_89_in_ruleResponsibility6679); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getResponsibilityAccess().getResponsibilityKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3230:1: ( (lv_description_1_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3231:1: (lv_description_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3231:1: (lv_description_1_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3232:3: lv_description_1_0= RULE_STRING
            {
            lv_description_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleResponsibility6696); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_description_1_0, grammarAccess.getResponsibilityAccess().getDescriptionSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getResponsibilityRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"description",
                      		lv_description_1_0, 
                      		"STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResponsibility"


    // $ANTLR start "entryRuleReport"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3256:1: entryRuleReport returns [EObject current=null] : iv_ruleReport= ruleReport EOF ;
    public final EObject entryRuleReport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReport = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3257:2: (iv_ruleReport= ruleReport EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3258:2: iv_ruleReport= ruleReport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReportRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReport_in_entryRuleReport6737);
            iv_ruleReport=ruleReport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReport; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReport6747); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReport"


    // $ANTLR start "ruleReport"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3265:1: ruleReport returns [EObject current=null] : (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' ( ( ruleQualifiedName ) ) otherlv_5= 'contents' ( (lv_content_6_0= RULE_STRING ) ) otherlv_7= '}' ) ;
    public final EObject ruleReport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_content_6_0=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3268:28: ( (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' ( ( ruleQualifiedName ) ) otherlv_5= 'contents' ( (lv_content_6_0= RULE_STRING ) ) otherlv_7= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3269:1: (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' ( ( ruleQualifiedName ) ) otherlv_5= 'contents' ( (lv_content_6_0= RULE_STRING ) ) otherlv_7= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3269:1: (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' ( ( ruleQualifiedName ) ) otherlv_5= 'contents' ( (lv_content_6_0= RULE_STRING ) ) otherlv_7= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3269:3: otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' ( ( ruleQualifiedName ) ) otherlv_5= 'contents' ( (lv_content_6_0= RULE_STRING ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,90,FollowSets000.FOLLOW_90_in_ruleReport6784); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getReportAccess().getReportKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3273:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3274:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3274:1: (lv_name_1_0= RULE_ID )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3275:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReport6801); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getReportAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getReportRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleReport6818); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getReportAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,91,FollowSets000.FOLLOW_91_in_ruleReport6830); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getReportAccess().getReportToKeyword_3());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3299:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3300:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3300:1: ( ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3301:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getReportRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReportAccess().getReportToUserCrossReference_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleReport6857);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,92,FollowSets000.FOLLOW_92_in_ruleReport6869); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getReportAccess().getContentsKeyword_5());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3321:1: ( (lv_content_6_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3322:1: (lv_content_6_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3322:1: (lv_content_6_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3323:3: lv_content_6_0= RULE_STRING
            {
            lv_content_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReport6886); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_content_6_0, grammarAccess.getReportAccess().getContentSTRINGTerminalRuleCall_6_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getReportRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"content",
                      		lv_content_6_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleReport6903); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getReportAccess().getRightCurlyBracketKeyword_7());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReport"


    // $ANTLR start "entryRuleVersionId"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3353:1: entryRuleVersionId returns [String current=null] : iv_ruleVersionId= ruleVersionId EOF ;
    public final String entryRuleVersionId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionId = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3354:2: (iv_ruleVersionId= ruleVersionId EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3355:2: iv_ruleVersionId= ruleVersionId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionIdRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_entryRuleVersionId6942);
            iv_ruleVersionId=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionId.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionId6953); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVersionId"


    // $ANTLR start "ruleVersionId"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3362:1: ruleVersionId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleVersionId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_ID_5=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3365:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3366:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3366:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3366:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )*
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId6993); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3373:1: (kw= '.' this_INT_2= RULE_INT )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==57) ) {
                    int LA84_1 = input.LA(2);

                    if ( (LA84_1==RULE_INT) ) {
                        alt84=1;
                    }


                }


                switch (alt84) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3374:2: kw= '.' this_INT_2= RULE_INT
            	    {
            	    kw=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleVersionId7012); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId7027); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_INT_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_INT_2, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop84;
                }
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3386:3: ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==57||LA86_0==93) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3386:4: (kw= '.' | kw= '-' ) this_ID_5= RULE_ID
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3386:4: (kw= '.' | kw= '-' )
            	    int alt85=2;
            	    int LA85_0 = input.LA(1);

            	    if ( (LA85_0==57) ) {
            	        alt85=1;
            	    }
            	    else if ( (LA85_0==93) ) {
            	        alt85=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 85, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt85) {
            	        case 1 :
            	            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3387:2: kw= '.'
            	            {
            	            kw=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleVersionId7049); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_2_0_0()); 
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3394:2: kw= '-'
            	            {
            	            kw=(Token)match(input,93,FollowSets000.FOLLOW_93_in_ruleVersionId7068); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getVersionIdAccess().getHyphenMinusKeyword_2_0_1()); 
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    this_ID_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVersionId7084); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_5);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_5, grammarAccess.getVersionIdAccess().getIDTerminalRuleCall_2_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop86;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVersionId"


    // $ANTLR start "entryRuleVersion"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3416:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3417:2: (iv_ruleVersion= ruleVersion EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3418:2: iv_ruleVersion= ruleVersion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersion_in_entryRuleVersion7133);
            iv_ruleVersion=ruleVersion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersion7143); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVersion"


    // $ANTLR start "ruleVersion"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3425:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleVersion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_version_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3428:28: ( (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3429:1: (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3429:1: (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3429:3: otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,94,FollowSets000.FOLLOW_94_in_ruleVersion7180); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3433:1: ( (lv_version_1_0= ruleVersionId ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3434:1: (lv_version_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3434:1: (lv_version_1_0= ruleVersionId )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3435:3: lv_version_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionAccess().getVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleVersion7201);
            lv_version_1_0=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVersionRule());
              	        }
                     		set(
                     			current, 
                     			"version",
                      		lv_version_1_0, 
                      		"VersionId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVersion"


    // $ANTLR start "entryRuleVersionRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3459:1: entryRuleVersionRef returns [EObject current=null] : iv_ruleVersionRef= ruleVersionRef EOF ;
    public final EObject entryRuleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3460:2: (iv_ruleVersionRef= ruleVersionRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3461:2: iv_ruleVersionRef= ruleVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_entryRuleVersionRef7237);
            iv_ruleVersionRef=ruleVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionRef7247); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVersionRef"


    // $ANTLR start "ruleVersionRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3468:1: ruleVersionRef returns [EObject current=null] : (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) ;
    public final EObject ruleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject this_MinVersionRef_0 = null;

        EObject this_MaxVersionRef_1 = null;

        EObject this_LowerBoundRangeVersionRef_2 = null;

        EObject this_MajorVersionRef_3 = null;

        EObject this_FixedVersionRef_4 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3471:28: ( (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3472:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3472:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            int alt87=5;
            switch ( input.LA(1) ) {
            case 95:
                {
                int LA87_1 = input.LA(2);

                if ( (LA87_1==RULE_INT) ) {
                    alt87=1;
                }
                else if ( (LA87_1==97) ) {
                    alt87=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 1, input);

                    throw nvae;
                }
                }
                break;
            case 96:
                {
                alt87=2;
                }
                break;
            case 99:
                {
                alt87=4;
                }
                break;
            case 100:
                {
                alt87=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }

            switch (alt87) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3473:2: this_MinVersionRef_0= ruleMinVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMinVersionRefParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_ruleVersionRef7297);
                    this_MinVersionRef_0=ruleMinVersionRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MinVersionRef_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3486:2: this_MaxVersionRef_1= ruleMaxVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMaxVersionRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_ruleVersionRef7327);
                    this_MaxVersionRef_1=ruleMaxVersionRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MaxVersionRef_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3499:2: this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getLowerBoundRangeVersionRefParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef7357);
                    this_LowerBoundRangeVersionRef_2=ruleLowerBoundRangeVersionRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LowerBoundRangeVersionRef_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3512:2: this_MajorVersionRef_3= ruleMajorVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMajorVersionRefParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_ruleVersionRef7387);
                    this_MajorVersionRef_3=ruleMajorVersionRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MajorVersionRef_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3525:2: this_FixedVersionRef_4= ruleFixedVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getFixedVersionRefParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_ruleVersionRef7417);
                    this_FixedVersionRef_4=ruleFixedVersionRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FixedVersionRef_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVersionRef"


    // $ANTLR start "entryRuleMinVersionRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3544:1: entryRuleMinVersionRef returns [EObject current=null] : iv_ruleMinVersionRef= ruleMinVersionRef EOF ;
    public final EObject entryRuleMinVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinVersionRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3545:2: (iv_ruleMinVersionRef= ruleMinVersionRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3546:2: iv_ruleMinVersionRef= ruleMinVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMinVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef7452);
            iv_ruleMinVersionRef=ruleMinVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMinVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMinVersionRef7462); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMinVersionRef"


    // $ANTLR start "ruleMinVersionRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3553:1: ruleMinVersionRef returns [EObject current=null] : (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMinVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_minVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3556:28: ( (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3557:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3557:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3557:3: otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,95,FollowSets000.FOLLOW_95_in_ruleMinVersionRef7499); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMinVersionRefAccess().getMinVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3561:1: ( (lv_minVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3562:1: (lv_minVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3562:1: (lv_minVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3563:3: lv_minVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMinVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMinVersionRef7520);
            lv_minVersion_1_0=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMinVersionRefRule());
              	        }
                     		set(
                     			current, 
                     			"minVersion",
                      		lv_minVersion_1_0, 
                      		"VersionId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMinVersionRef"


    // $ANTLR start "entryRuleMaxVersionRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3587:1: entryRuleMaxVersionRef returns [EObject current=null] : iv_ruleMaxVersionRef= ruleMaxVersionRef EOF ;
    public final EObject entryRuleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxVersionRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3588:2: (iv_ruleMaxVersionRef= ruleMaxVersionRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3589:2: iv_ruleMaxVersionRef= ruleMaxVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMaxVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef7556);
            iv_ruleMaxVersionRef=ruleMaxVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMaxVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxVersionRef7566); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMaxVersionRef"


    // $ANTLR start "ruleMaxVersionRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3596:1: ruleMaxVersionRef returns [EObject current=null] : (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_maxVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3599:28: ( (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3600:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3600:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3600:3: otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,96,FollowSets000.FOLLOW_96_in_ruleMaxVersionRef7603); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMaxVersionRefAccess().getMaxVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3604:1: ( (lv_maxVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3605:1: (lv_maxVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3605:1: (lv_maxVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3606:3: lv_maxVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMaxVersionRefAccess().getMaxVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMaxVersionRef7624);
            lv_maxVersion_1_0=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMaxVersionRefRule());
              	        }
                     		set(
                     			current, 
                     			"maxVersion",
                      		lv_maxVersion_1_0, 
                      		"VersionId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMaxVersionRef"


    // $ANTLR start "entryRuleLowerBoundRangeVersionRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3630:1: entryRuleLowerBoundRangeVersionRef returns [EObject current=null] : iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF ;
    public final EObject entryRuleLowerBoundRangeVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerBoundRangeVersionRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3631:2: (iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3632:2: iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef7660);
            iv_ruleLowerBoundRangeVersionRef=ruleLowerBoundRangeVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLowerBoundRangeVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef7670); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLowerBoundRangeVersionRef"


    // $ANTLR start "ruleLowerBoundRangeVersionRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3639:1: ruleLowerBoundRangeVersionRef returns [EObject current=null] : ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) ;
    public final EObject ruleLowerBoundRangeVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_minVersion_2_0 = null;

        AntlrDatatypeRuleToken lv_maxVersion_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3642:28: ( ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3643:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3643:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3643:2: (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3643:2: (otherlv_0= 'minVersion' otherlv_1= '>=' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3643:4: otherlv_0= 'minVersion' otherlv_1= '>='
            {
            otherlv_0=(Token)match(input,95,FollowSets000.FOLLOW_95_in_ruleLowerBoundRangeVersionRef7708); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionKeyword_0_0());
                  
            }
            otherlv_1=(Token)match(input,97,FollowSets000.FOLLOW_97_in_ruleLowerBoundRangeVersionRef7720); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLowerBoundRangeVersionRefAccess().getGreaterThanSignEqualsSignKeyword_0_1());
                  
            }

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3651:2: ( (lv_minVersion_2_0= ruleVersionId ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3652:1: (lv_minVersion_2_0= ruleVersionId )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3652:1: (lv_minVersion_2_0= ruleVersionId )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3653:3: lv_minVersion_2_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef7742);
            lv_minVersion_2_0=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLowerBoundRangeVersionRefRule());
              	        }
                     		set(
                     			current, 
                     			"minVersion",
                      		lv_minVersion_2_0, 
                      		"VersionId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleLowerBoundRangeVersionRef7754); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLowerBoundRangeVersionRefAccess().getCommaKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3673:1: (otherlv_4= 'maxVersion' otherlv_5= '<' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3673:3: otherlv_4= 'maxVersion' otherlv_5= '<'
            {
            otherlv_4=(Token)match(input,96,FollowSets000.FOLLOW_96_in_ruleLowerBoundRangeVersionRef7767); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionKeyword_3_0());
                  
            }
            otherlv_5=(Token)match(input,98,FollowSets000.FOLLOW_98_in_ruleLowerBoundRangeVersionRef7779); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLowerBoundRangeVersionRefAccess().getLessThanSignKeyword_3_1());
                  
            }

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3681:2: ( (lv_maxVersion_6_0= ruleVersionId ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3682:1: (lv_maxVersion_6_0= ruleVersionId )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3682:1: (lv_maxVersion_6_0= ruleVersionId )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3683:3: lv_maxVersion_6_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionVersionIdParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef7801);
            lv_maxVersion_6_0=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLowerBoundRangeVersionRefRule());
              	        }
                     		set(
                     			current, 
                     			"maxVersion",
                      		lv_maxVersion_6_0, 
                      		"VersionId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLowerBoundRangeVersionRef"


    // $ANTLR start "entryRuleMajorVersionRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3707:1: entryRuleMajorVersionRef returns [EObject current=null] : iv_ruleMajorVersionRef= ruleMajorVersionRef EOF ;
    public final EObject entryRuleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMajorVersionRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3708:2: (iv_ruleMajorVersionRef= ruleMajorVersionRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3709:2: iv_ruleMajorVersionRef= ruleMajorVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMajorVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef7837);
            iv_ruleMajorVersionRef=ruleMajorVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMajorVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMajorVersionRef7847); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMajorVersionRef"


    // $ANTLR start "ruleMajorVersionRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3716:1: ruleMajorVersionRef returns [EObject current=null] : (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) ;
    public final EObject ruleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_majorVersion_1_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3719:28: ( (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3720:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3720:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3720:3: otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,99,FollowSets000.FOLLOW_99_in_ruleMajorVersionRef7884); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMajorVersionRefAccess().getMajorVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3724:1: ( (lv_majorVersion_1_0= RULE_INT ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3725:1: (lv_majorVersion_1_0= RULE_INT )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3725:1: (lv_majorVersion_1_0= RULE_INT )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3726:3: lv_majorVersion_1_0= RULE_INT
            {
            lv_majorVersion_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMajorVersionRef7901); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_majorVersion_1_0, grammarAccess.getMajorVersionRefAccess().getMajorVersionINTTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMajorVersionRefRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"majorVersion",
                      		lv_majorVersion_1_0, 
                      		"INT");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMajorVersionRef"


    // $ANTLR start "entryRuleFixedVersionRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3750:1: entryRuleFixedVersionRef returns [EObject current=null] : iv_ruleFixedVersionRef= ruleFixedVersionRef EOF ;
    public final EObject entryRuleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedVersionRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3751:2: (iv_ruleFixedVersionRef= ruleFixedVersionRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3752:2: iv_ruleFixedVersionRef= ruleFixedVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFixedVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef7942);
            iv_ruleFixedVersionRef=ruleFixedVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFixedVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFixedVersionRef7952); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFixedVersionRef"


    // $ANTLR start "ruleFixedVersionRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3759:1: ruleFixedVersionRef returns [EObject current=null] : (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_fixedVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3762:28: ( (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3763:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3763:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3763:3: otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,100,FollowSets000.FOLLOW_100_in_ruleFixedVersionRef7989); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFixedVersionRefAccess().getFixedVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3767:1: ( (lv_fixedVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3768:1: (lv_fixedVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3768:1: (lv_fixedVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3769:3: lv_fixedVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFixedVersionRefAccess().getFixedVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleFixedVersionRef8010);
            lv_fixedVersion_1_0=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFixedVersionRefRule());
              	        }
                     		set(
                     			current, 
                     			"fixedVersion",
                      		lv_fixedVersion_1_0, 
                      		"VersionId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFixedVersionRef"


    // $ANTLR start "entryRuleQualifiedNameWithWildCard"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3793:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3794:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3795:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard8047);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard8058); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildCard"


    // $ANTLR start "ruleQualifiedNameWithWildCard"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3802:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3805:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3806:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3806:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3807:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard8105);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3817:1: (kw= '.*' )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==101) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3818:2: kw= '.*'
                    {
                    kw=(Token)match(input,101,FollowSets000.FOLLOW_101_in_ruleQualifiedNameWithWildCard8124); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameWithWildCard"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3831:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3832:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3833:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8167);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName8178); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3840:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( (kw= '.' | kw= '@' ) this_ID_3= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_3=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3843:28: ( (this_ID_0= RULE_ID ( (kw= '.' | kw= '@' ) this_ID_3= RULE_ID )* ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3844:1: (this_ID_0= RULE_ID ( (kw= '.' | kw= '@' ) this_ID_3= RULE_ID )* )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3844:1: (this_ID_0= RULE_ID ( (kw= '.' | kw= '@' ) this_ID_3= RULE_ID )* )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3844:6: this_ID_0= RULE_ID ( (kw= '.' | kw= '@' ) this_ID_3= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName8218); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3851:1: ( (kw= '.' | kw= '@' ) this_ID_3= RULE_ID )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==57||LA90_0==102) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3851:2: (kw= '.' | kw= '@' ) this_ID_3= RULE_ID
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3851:2: (kw= '.' | kw= '@' )
            	    int alt89=2;
            	    int LA89_0 = input.LA(1);

            	    if ( (LA89_0==57) ) {
            	        alt89=1;
            	    }
            	    else if ( (LA89_0==102) ) {
            	        alt89=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 89, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt89) {
            	        case 1 :
            	            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3852:2: kw= '.'
            	            {
            	            kw=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleQualifiedName8238); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0_0()); 
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3859:2: kw= '@'
            	            {
            	            kw=(Token)match(input,102,FollowSets000.FOLLOW_102_in_ruleQualifiedName8257); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getCommercialAtKeyword_1_0_1()); 
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    this_ID_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName8273); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_3);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_3, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop90;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleInfoItem"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3885:1: entryRuleInfoItem returns [EObject current=null] : iv_ruleInfoItem= ruleInfoItem EOF ;
    public final EObject entryRuleInfoItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfoItem = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3886:2: (iv_ruleInfoItem= ruleInfoItem EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3887:2: iv_ruleInfoItem= ruleInfoItem EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfoItemRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfoItem_in_entryRuleInfoItem8326);
            iv_ruleInfoItem=ruleInfoItem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfoItem; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfoItem8336); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfoItem"


    // $ANTLR start "ruleInfoItem"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3894:1: ruleInfoItem returns [EObject current=null] : (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleInfoItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_documentLocation_1_0=null;
        Token otherlv_2=null;
        Token lv_reference_3_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3897:28: ( (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3898:1: (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3898:1: (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3898:3: otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,103,FollowSets000.FOLLOW_103_in_ruleInfoItem8373); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInfoItemAccess().getLocationKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3902:1: ( (lv_documentLocation_1_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3903:1: (lv_documentLocation_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3903:1: (lv_documentLocation_1_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3904:3: lv_documentLocation_1_0= RULE_STRING
            {
            lv_documentLocation_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleInfoItem8390); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_documentLocation_1_0, grammarAccess.getInfoItemAccess().getDocumentLocationSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getInfoItemRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"documentLocation",
                      		lv_documentLocation_1_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3920:2: (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==104) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3920:4: otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,104,FollowSets000.FOLLOW_104_in_ruleInfoItem8408); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getInfoItemAccess().getReferenceKeyword_2_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3924:1: ( (lv_reference_3_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3925:1: (lv_reference_3_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3925:1: (lv_reference_3_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3926:3: lv_reference_3_0= RULE_STRING
                    {
                    lv_reference_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleInfoItem8425); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_reference_3_0, grammarAccess.getInfoItemAccess().getReferenceSTRINGTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getInfoItemRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"reference",
                              		lv_reference_3_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfoItem"


    // $ANTLR start "entryRuleRoleRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3952:1: entryRuleRoleRef returns [EObject current=null] : iv_ruleRoleRef= ruleRoleRef EOF ;
    public final EObject entryRuleRoleRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoleRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3953:2: (iv_ruleRoleRef= ruleRoleRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3954:2: iv_ruleRoleRef= ruleRoleRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRoleRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRoleRef_in_entryRuleRoleRef8470);
            iv_ruleRoleRef=ruleRoleRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRoleRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoleRef8480); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRoleRef"


    // $ANTLR start "ruleRoleRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3961:1: ruleRoleRef returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleRoleRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3964:28: ( ( ( ruleQualifiedName ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3965:1: ( ( ruleQualifiedName ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3965:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3966:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3966:1: ( ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3967:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getRoleRefRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRoleRefAccess().getRoleRoleCrossReference_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleRoleRef8531);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRoleRef"


    // $ANTLR start "entryRulePrivilegeRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3993:1: entryRulePrivilegeRef returns [EObject current=null] : iv_rulePrivilegeRef= rulePrivilegeRef EOF ;
    public final EObject entryRulePrivilegeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrivilegeRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3994:2: (iv_rulePrivilegeRef= rulePrivilegeRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3995:2: iv_rulePrivilegeRef= rulePrivilegeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrivilegeRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrivilegeRef_in_entryRulePrivilegeRef8568);
            iv_rulePrivilegeRef=rulePrivilegeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrivilegeRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrivilegeRef8578); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrivilegeRef"


    // $ANTLR start "rulePrivilegeRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4002:1: rulePrivilegeRef returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject rulePrivilegeRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4005:28: ( ( ( ruleQualifiedName ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4006:1: ( ( ruleQualifiedName ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4006:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4007:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4007:1: ( ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4008:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPrivilegeRefRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrivilegeRefAccess().getPrivilegePrivilegeCrossReference_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rulePrivilegeRef8629);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrivilegeRef"


    // $ANTLR start "entryRuleAssetRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4034:1: entryRuleAssetRef returns [EObject current=null] : iv_ruleAssetRef= ruleAssetRef EOF ;
    public final EObject entryRuleAssetRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssetRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4035:2: (iv_ruleAssetRef= ruleAssetRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4036:2: iv_ruleAssetRef= ruleAssetRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssetRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAssetRef_in_entryRuleAssetRef8666);
            iv_ruleAssetRef=ruleAssetRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssetRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssetRef8676); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssetRef"


    // $ANTLR start "ruleAssetRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4043:1: ruleAssetRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )? ) ;
    public final EObject ruleAssetRef() throws RecognitionException {
        EObject current = null;

        EObject lv_versionRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4046:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )? ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4047:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )? )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4047:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )? )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4047:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )?
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4047:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4048:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4048:1: ( ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4049:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAssetRefRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssetRefAccess().getAssetEObjectCrossReference_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleAssetRef8728);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4065:2: ( (lv_versionRef_1_0= ruleVersionRef ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( ((LA92_0>=95 && LA92_0<=96)||(LA92_0>=99 && LA92_0<=100)) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4066:1: (lv_versionRef_1_0= ruleVersionRef )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4066:1: (lv_versionRef_1_0= ruleVersionRef )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4067:3: lv_versionRef_1_0= ruleVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssetRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleAssetRef8749);
                    lv_versionRef_1_0=ruleVersionRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAssetRefRule());
                      	        }
                             		set(
                             			current, 
                             			"versionRef",
                              		lv_versionRef_1_0, 
                              		"VersionRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssetRef"


    // $ANTLR start "ruleHashAlgKind"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4091:1: ruleHashAlgKind returns [Enumerator current=null] : ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'RSA' ) | (enumLiteral_4= 'PlainText' ) ) ;
    public final Enumerator ruleHashAlgKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4093:28: ( ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'RSA' ) | (enumLiteral_4= 'PlainText' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4094:1: ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'RSA' ) | (enumLiteral_4= 'PlainText' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4094:1: ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'RSA' ) | (enumLiteral_4= 'PlainText' ) )
            int alt93=5;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt93=1;
                }
                break;
            case 106:
                {
                alt93=2;
                }
                break;
            case 107:
                {
                alt93=3;
                }
                break;
            case 108:
                {
                alt93=4;
                }
                break;
            case 109:
                {
                alt93=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4094:2: (enumLiteral_0= 'MD5' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4094:2: (enumLiteral_0= 'MD5' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4094:4: enumLiteral_0= 'MD5'
                    {
                    enumLiteral_0=(Token)match(input,105,FollowSets000.FOLLOW_105_in_ruleHashAlgKind8800); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getMD5EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getHashAlgKindAccess().getMD5EnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4100:6: (enumLiteral_1= 'SHA1' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4100:6: (enumLiteral_1= 'SHA1' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4100:8: enumLiteral_1= 'SHA1'
                    {
                    enumLiteral_1=(Token)match(input,106,FollowSets000.FOLLOW_106_in_ruleHashAlgKind8817); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getSHA1EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getHashAlgKindAccess().getSHA1EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4106:6: (enumLiteral_2= 'SHA256' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4106:6: (enumLiteral_2= 'SHA256' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4106:8: enumLiteral_2= 'SHA256'
                    {
                    enumLiteral_2=(Token)match(input,107,FollowSets000.FOLLOW_107_in_ruleHashAlgKind8834); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getSHA256EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getHashAlgKindAccess().getSHA256EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4112:6: (enumLiteral_3= 'RSA' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4112:6: (enumLiteral_3= 'RSA' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4112:8: enumLiteral_3= 'RSA'
                    {
                    enumLiteral_3=(Token)match(input,108,FollowSets000.FOLLOW_108_in_ruleHashAlgKind8851); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getRSAEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getHashAlgKindAccess().getRSAEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4118:6: (enumLiteral_4= 'PlainText' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4118:6: (enumLiteral_4= 'PlainText' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4118:8: enumLiteral_4= 'PlainText'
                    {
                    enumLiteral_4=(Token)match(input,109,FollowSets000.FOLLOW_109_in_ruleHashAlgKind8868); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getPlainTextEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getHashAlgKindAccess().getPlainTextEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHashAlgKind"


    // $ANTLR start "ruleMessagePartRefKind"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4128:1: ruleMessagePartRefKind returns [Enumerator current=null] : ( (enumLiteral_0= 'header' ) | (enumLiteral_1= 'body' ) | (enumLiteral_2= 'attachments' ) | (enumLiteral_3= 'all' ) | (enumLiteral_4= 'expression' ) ) ;
    public final Enumerator ruleMessagePartRefKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4130:28: ( ( (enumLiteral_0= 'header' ) | (enumLiteral_1= 'body' ) | (enumLiteral_2= 'attachments' ) | (enumLiteral_3= 'all' ) | (enumLiteral_4= 'expression' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4131:1: ( (enumLiteral_0= 'header' ) | (enumLiteral_1= 'body' ) | (enumLiteral_2= 'attachments' ) | (enumLiteral_3= 'all' ) | (enumLiteral_4= 'expression' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4131:1: ( (enumLiteral_0= 'header' ) | (enumLiteral_1= 'body' ) | (enumLiteral_2= 'attachments' ) | (enumLiteral_3= 'all' ) | (enumLiteral_4= 'expression' ) )
            int alt94=5;
            switch ( input.LA(1) ) {
            case 110:
                {
                alt94=1;
                }
                break;
            case 111:
                {
                alt94=2;
                }
                break;
            case 112:
                {
                alt94=3;
                }
                break;
            case 113:
                {
                alt94=4;
                }
                break;
            case 71:
                {
                alt94=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }

            switch (alt94) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4131:2: (enumLiteral_0= 'header' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4131:2: (enumLiteral_0= 'header' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4131:4: enumLiteral_0= 'header'
                    {
                    enumLiteral_0=(Token)match(input,110,FollowSets000.FOLLOW_110_in_ruleMessagePartRefKind8913); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getHeaderEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getMessagePartRefKindAccess().getHeaderEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4137:6: (enumLiteral_1= 'body' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4137:6: (enumLiteral_1= 'body' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4137:8: enumLiteral_1= 'body'
                    {
                    enumLiteral_1=(Token)match(input,111,FollowSets000.FOLLOW_111_in_ruleMessagePartRefKind8930); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getBodyEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getMessagePartRefKindAccess().getBodyEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4143:6: (enumLiteral_2= 'attachments' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4143:6: (enumLiteral_2= 'attachments' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4143:8: enumLiteral_2= 'attachments'
                    {
                    enumLiteral_2=(Token)match(input,112,FollowSets000.FOLLOW_112_in_ruleMessagePartRefKind8947); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getAttachmentsEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getMessagePartRefKindAccess().getAttachmentsEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4149:6: (enumLiteral_3= 'all' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4149:6: (enumLiteral_3= 'all' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4149:8: enumLiteral_3= 'all'
                    {
                    enumLiteral_3=(Token)match(input,113,FollowSets000.FOLLOW_113_in_ruleMessagePartRefKind8964); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getAllEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getMessagePartRefKindAccess().getAllEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4155:6: (enumLiteral_4= 'expression' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4155:6: (enumLiteral_4= 'expression' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4155:8: enumLiteral_4= 'expression'
                    {
                    enumLiteral_4=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleMessagePartRefKind8981); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getExpressionEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getMessagePartRefKindAccess().getExpressionEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessagePartRefKind"


    // $ANTLR start "ruleSigningAlgothm"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4165:1: ruleSigningAlgothm returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'MD5' ) | (enumLiteral_4= 'RSA_1_5' ) | (enumLiteral_5= 'AES128' ) | (enumLiteral_6= 'AES192' ) | (enumLiteral_7= 'AES256' ) ) ;
    public final Enumerator ruleSigningAlgothm() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4167:28: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'MD5' ) | (enumLiteral_4= 'RSA_1_5' ) | (enumLiteral_5= 'AES128' ) | (enumLiteral_6= 'AES192' ) | (enumLiteral_7= 'AES256' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4168:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'MD5' ) | (enumLiteral_4= 'RSA_1_5' ) | (enumLiteral_5= 'AES128' ) | (enumLiteral_6= 'AES192' ) | (enumLiteral_7= 'AES256' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4168:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'MD5' ) | (enumLiteral_4= 'RSA_1_5' ) | (enumLiteral_5= 'AES128' ) | (enumLiteral_6= 'AES192' ) | (enumLiteral_7= 'AES256' ) )
            int alt95=8;
            switch ( input.LA(1) ) {
            case 114:
                {
                alt95=1;
                }
                break;
            case 106:
                {
                alt95=2;
                }
                break;
            case 107:
                {
                alt95=3;
                }
                break;
            case 105:
                {
                alt95=4;
                }
                break;
            case 115:
                {
                alt95=5;
                }
                break;
            case 116:
                {
                alt95=6;
                }
                break;
            case 117:
                {
                alt95=7;
                }
                break;
            case 118:
                {
                alt95=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }

            switch (alt95) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4168:2: (enumLiteral_0= 'NONE' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4168:2: (enumLiteral_0= 'NONE' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4168:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,114,FollowSets000.FOLLOW_114_in_ruleSigningAlgothm9026); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getSigningAlgothmAccess().getNONEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4174:6: (enumLiteral_1= 'SHA1' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4174:6: (enumLiteral_1= 'SHA1' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4174:8: enumLiteral_1= 'SHA1'
                    {
                    enumLiteral_1=(Token)match(input,106,FollowSets000.FOLLOW_106_in_ruleSigningAlgothm9043); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getSHA1EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getSigningAlgothmAccess().getSHA1EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4180:6: (enumLiteral_2= 'SHA256' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4180:6: (enumLiteral_2= 'SHA256' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4180:8: enumLiteral_2= 'SHA256'
                    {
                    enumLiteral_2=(Token)match(input,107,FollowSets000.FOLLOW_107_in_ruleSigningAlgothm9060); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getSHA256EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getSigningAlgothmAccess().getSHA256EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4186:6: (enumLiteral_3= 'MD5' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4186:6: (enumLiteral_3= 'MD5' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4186:8: enumLiteral_3= 'MD5'
                    {
                    enumLiteral_3=(Token)match(input,105,FollowSets000.FOLLOW_105_in_ruleSigningAlgothm9077); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getMD5EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getSigningAlgothmAccess().getMD5EnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4192:6: (enumLiteral_4= 'RSA_1_5' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4192:6: (enumLiteral_4= 'RSA_1_5' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4192:8: enumLiteral_4= 'RSA_1_5'
                    {
                    enumLiteral_4=(Token)match(input,115,FollowSets000.FOLLOW_115_in_ruleSigningAlgothm9094); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getRSA_1_5EnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getSigningAlgothmAccess().getRSA_1_5EnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4198:6: (enumLiteral_5= 'AES128' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4198:6: (enumLiteral_5= 'AES128' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4198:8: enumLiteral_5= 'AES128'
                    {
                    enumLiteral_5=(Token)match(input,116,FollowSets000.FOLLOW_116_in_ruleSigningAlgothm9111); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getAES128EnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getSigningAlgothmAccess().getAES128EnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4204:6: (enumLiteral_6= 'AES192' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4204:6: (enumLiteral_6= 'AES192' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4204:8: enumLiteral_6= 'AES192'
                    {
                    enumLiteral_6=(Token)match(input,117,FollowSets000.FOLLOW_117_in_ruleSigningAlgothm9128); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getAES192EnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getSigningAlgothmAccess().getAES192EnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4210:6: (enumLiteral_7= 'AES256' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4210:6: (enumLiteral_7= 'AES256' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4210:8: enumLiteral_7= 'AES256'
                    {
                    enumLiteral_7=(Token)match(input,118,FollowSets000.FOLLOW_118_in_ruleSigningAlgothm9145); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getAES256EnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_7, grammarAccess.getSigningAlgothmAccess().getAES256EnumLiteralDeclaration_7()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSigningAlgothm"


    // $ANTLR start "ruleCipherAlgorithmKind"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4220:1: ruleCipherAlgorithmKind returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'Basic128' ) | (enumLiteral_2= 'Basic192' ) | (enumLiteral_3= 'Basic256' ) | (enumLiteral_4= 'DES' ) | (enumLiteral_5= '3DES' ) | (enumLiteral_6= 'AES128' ) | (enumLiteral_7= 'AES256' ) ) ;
    public final Enumerator ruleCipherAlgorithmKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4222:28: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'Basic128' ) | (enumLiteral_2= 'Basic192' ) | (enumLiteral_3= 'Basic256' ) | (enumLiteral_4= 'DES' ) | (enumLiteral_5= '3DES' ) | (enumLiteral_6= 'AES128' ) | (enumLiteral_7= 'AES256' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4223:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'Basic128' ) | (enumLiteral_2= 'Basic192' ) | (enumLiteral_3= 'Basic256' ) | (enumLiteral_4= 'DES' ) | (enumLiteral_5= '3DES' ) | (enumLiteral_6= 'AES128' ) | (enumLiteral_7= 'AES256' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4223:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'Basic128' ) | (enumLiteral_2= 'Basic192' ) | (enumLiteral_3= 'Basic256' ) | (enumLiteral_4= 'DES' ) | (enumLiteral_5= '3DES' ) | (enumLiteral_6= 'AES128' ) | (enumLiteral_7= 'AES256' ) )
            int alt96=8;
            switch ( input.LA(1) ) {
            case 114:
                {
                alt96=1;
                }
                break;
            case 119:
                {
                alt96=2;
                }
                break;
            case 120:
                {
                alt96=3;
                }
                break;
            case 121:
                {
                alt96=4;
                }
                break;
            case 122:
                {
                alt96=5;
                }
                break;
            case 123:
                {
                alt96=6;
                }
                break;
            case 116:
                {
                alt96=7;
                }
                break;
            case 118:
                {
                alt96=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }

            switch (alt96) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4223:2: (enumLiteral_0= 'NONE' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4223:2: (enumLiteral_0= 'NONE' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4223:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,114,FollowSets000.FOLLOW_114_in_ruleCipherAlgorithmKind9190); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getCipherAlgorithmKindAccess().getNONEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4229:6: (enumLiteral_1= 'Basic128' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4229:6: (enumLiteral_1= 'Basic128' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4229:8: enumLiteral_1= 'Basic128'
                    {
                    enumLiteral_1=(Token)match(input,119,FollowSets000.FOLLOW_119_in_ruleCipherAlgorithmKind9207); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getBasic128EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getCipherAlgorithmKindAccess().getBasic128EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4235:6: (enumLiteral_2= 'Basic192' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4235:6: (enumLiteral_2= 'Basic192' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4235:8: enumLiteral_2= 'Basic192'
                    {
                    enumLiteral_2=(Token)match(input,120,FollowSets000.FOLLOW_120_in_ruleCipherAlgorithmKind9224); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getBasic192EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getCipherAlgorithmKindAccess().getBasic192EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4241:6: (enumLiteral_3= 'Basic256' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4241:6: (enumLiteral_3= 'Basic256' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4241:8: enumLiteral_3= 'Basic256'
                    {
                    enumLiteral_3=(Token)match(input,121,FollowSets000.FOLLOW_121_in_ruleCipherAlgorithmKind9241); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getBasic256EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getCipherAlgorithmKindAccess().getBasic256EnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4247:6: (enumLiteral_4= 'DES' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4247:6: (enumLiteral_4= 'DES' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4247:8: enumLiteral_4= 'DES'
                    {
                    enumLiteral_4=(Token)match(input,122,FollowSets000.FOLLOW_122_in_ruleCipherAlgorithmKind9258); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getDESEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getCipherAlgorithmKindAccess().getDESEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4253:6: (enumLiteral_5= '3DES' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4253:6: (enumLiteral_5= '3DES' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4253:8: enumLiteral_5= '3DES'
                    {
                    enumLiteral_5=(Token)match(input,123,FollowSets000.FOLLOW_123_in_ruleCipherAlgorithmKind9275); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getTRIPLE_DESEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getCipherAlgorithmKindAccess().getTRIPLE_DESEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4259:6: (enumLiteral_6= 'AES128' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4259:6: (enumLiteral_6= 'AES128' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4259:8: enumLiteral_6= 'AES128'
                    {
                    enumLiteral_6=(Token)match(input,116,FollowSets000.FOLLOW_116_in_ruleCipherAlgorithmKind9292); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getAES128EnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getCipherAlgorithmKindAccess().getAES128EnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4265:6: (enumLiteral_7= 'AES256' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4265:6: (enumLiteral_7= 'AES256' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4265:8: enumLiteral_7= 'AES256'
                    {
                    enumLiteral_7=(Token)match(input,118,FollowSets000.FOLLOW_118_in_ruleCipherAlgorithmKind9309); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getAES256EnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_7, grammarAccess.getCipherAlgorithmKindAccess().getAES256EnumLiteralDeclaration_7()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCipherAlgorithmKind"


    // $ANTLR start "ruleAuthTokenKind"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4275:1: ruleAuthTokenKind returns [Enumerator current=null] : ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'SPNEGO' ) | (enumLiteral_5= 'RELToken' ) | (enumLiteral_6= 'X509Certificate' ) | (enumLiteral_7= 'OAuth' ) | (enumLiteral_8= 'OAuth2' ) ) ;
    public final Enumerator ruleAuthTokenKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4277:28: ( ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'SPNEGO' ) | (enumLiteral_5= 'RELToken' ) | (enumLiteral_6= 'X509Certificate' ) | (enumLiteral_7= 'OAuth' ) | (enumLiteral_8= 'OAuth2' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4278:1: ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'SPNEGO' ) | (enumLiteral_5= 'RELToken' ) | (enumLiteral_6= 'X509Certificate' ) | (enumLiteral_7= 'OAuth' ) | (enumLiteral_8= 'OAuth2' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4278:1: ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'SPNEGO' ) | (enumLiteral_5= 'RELToken' ) | (enumLiteral_6= 'X509Certificate' ) | (enumLiteral_7= 'OAuth' ) | (enumLiteral_8= 'OAuth2' ) )
            int alt97=9;
            switch ( input.LA(1) ) {
            case 124:
                {
                alt97=1;
                }
                break;
            case 125:
                {
                alt97=2;
                }
                break;
            case 126:
                {
                alt97=3;
                }
                break;
            case 127:
                {
                alt97=4;
                }
                break;
            case 128:
                {
                alt97=5;
                }
                break;
            case 129:
                {
                alt97=6;
                }
                break;
            case 130:
                {
                alt97=7;
                }
                break;
            case 131:
                {
                alt97=8;
                }
                break;
            case 132:
                {
                alt97=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }

            switch (alt97) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4278:2: (enumLiteral_0= 'UsernamePassword' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4278:2: (enumLiteral_0= 'UsernamePassword' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4278:4: enumLiteral_0= 'UsernamePassword'
                    {
                    enumLiteral_0=(Token)match(input,124,FollowSets000.FOLLOW_124_in_ruleAuthTokenKind9354); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getUsernamePasswordEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAuthTokenKindAccess().getUsernamePasswordEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4284:6: (enumLiteral_1= 'SAML' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4284:6: (enumLiteral_1= 'SAML' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4284:8: enumLiteral_1= 'SAML'
                    {
                    enumLiteral_1=(Token)match(input,125,FollowSets000.FOLLOW_125_in_ruleAuthTokenKind9371); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSAMLEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getAuthTokenKindAccess().getSAMLEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4290:6: (enumLiteral_2= 'SAML2' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4290:6: (enumLiteral_2= 'SAML2' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4290:8: enumLiteral_2= 'SAML2'
                    {
                    enumLiteral_2=(Token)match(input,126,FollowSets000.FOLLOW_126_in_ruleAuthTokenKind9388); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSAML2EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getAuthTokenKindAccess().getSAML2EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4296:6: (enumLiteral_3= 'Kerberos' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4296:6: (enumLiteral_3= 'Kerberos' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4296:8: enumLiteral_3= 'Kerberos'
                    {
                    enumLiteral_3=(Token)match(input,127,FollowSets000.FOLLOW_127_in_ruleAuthTokenKind9405); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getKerberosEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getAuthTokenKindAccess().getKerberosEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4302:6: (enumLiteral_4= 'SPNEGO' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4302:6: (enumLiteral_4= 'SPNEGO' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4302:8: enumLiteral_4= 'SPNEGO'
                    {
                    enumLiteral_4=(Token)match(input,128,FollowSets000.FOLLOW_128_in_ruleAuthTokenKind9422); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSPNEGOEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getAuthTokenKindAccess().getSPNEGOEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4308:6: (enumLiteral_5= 'RELToken' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4308:6: (enumLiteral_5= 'RELToken' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4308:8: enumLiteral_5= 'RELToken'
                    {
                    enumLiteral_5=(Token)match(input,129,FollowSets000.FOLLOW_129_in_ruleAuthTokenKind9439); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getRELTokenEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getAuthTokenKindAccess().getRELTokenEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4314:6: (enumLiteral_6= 'X509Certificate' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4314:6: (enumLiteral_6= 'X509Certificate' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4314:8: enumLiteral_6= 'X509Certificate'
                    {
                    enumLiteral_6=(Token)match(input,130,FollowSets000.FOLLOW_130_in_ruleAuthTokenKind9456); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getX509CertificateEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getAuthTokenKindAccess().getX509CertificateEnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4320:6: (enumLiteral_7= 'OAuth' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4320:6: (enumLiteral_7= 'OAuth' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4320:8: enumLiteral_7= 'OAuth'
                    {
                    enumLiteral_7=(Token)match(input,131,FollowSets000.FOLLOW_131_in_ruleAuthTokenKind9473); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getOAuthEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_7, grammarAccess.getAuthTokenKindAccess().getOAuthEnumLiteralDeclaration_7()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4326:6: (enumLiteral_8= 'OAuth2' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4326:6: (enumLiteral_8= 'OAuth2' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4326:8: enumLiteral_8= 'OAuth2'
                    {
                    enumLiteral_8=(Token)match(input,132,FollowSets000.FOLLOW_132_in_ruleAuthTokenKind9490); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getOAuth2EnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_8, grammarAccess.getAuthTokenKindAccess().getOAuth2EnumLiteralDeclaration_8()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAuthTokenKind"


    // $ANTLR start "ruleLogRequirementKind"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4336:1: ruleLogRequirementKind returns [Enumerator current=null] : ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'header' ) | (enumLiteral_2= 'all' ) ) ;
    public final Enumerator ruleLogRequirementKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4338:28: ( ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'header' ) | (enumLiteral_2= 'all' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4339:1: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'header' ) | (enumLiteral_2= 'all' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4339:1: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'header' ) | (enumLiteral_2= 'all' ) )
            int alt98=3;
            switch ( input.LA(1) ) {
            case 133:
                {
                alt98=1;
                }
                break;
            case 110:
                {
                alt98=2;
                }
                break;
            case 113:
                {
                alt98=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }

            switch (alt98) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4339:2: (enumLiteral_0= 'none' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4339:2: (enumLiteral_0= 'none' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4339:4: enumLiteral_0= 'none'
                    {
                    enumLiteral_0=(Token)match(input,133,FollowSets000.FOLLOW_133_in_ruleLogRequirementKind9535); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getLogRequirementKindAccess().getNoneEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getLogRequirementKindAccess().getNoneEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4345:6: (enumLiteral_1= 'header' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4345:6: (enumLiteral_1= 'header' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4345:8: enumLiteral_1= 'header'
                    {
                    enumLiteral_1=(Token)match(input,110,FollowSets000.FOLLOW_110_in_ruleLogRequirementKind9552); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getLogRequirementKindAccess().getHeaderEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getLogRequirementKindAccess().getHeaderEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4351:6: (enumLiteral_2= 'all' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4351:6: (enumLiteral_2= 'all' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4351:8: enumLiteral_2= 'all'
                    {
                    enumLiteral_2=(Token)match(input,113,FollowSets000.FOLLOW_113_in_ruleLogRequirementKind9569); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getLogRequirementKindAccess().getAllEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getLogRequirementKindAccess().getAllEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogRequirementKind"


    // $ANTLR start "ruleReliablilityKind"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4361:1: ruleReliablilityKind returns [Enumerator current=null] : ( (enumLiteral_0= 'exactly-once' ) | (enumLiteral_1= 'at-most-once' ) | (enumLiteral_2= 'at-least-once' ) | (enumLiteral_3= 'best-effort' ) ) ;
    public final Enumerator ruleReliablilityKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4363:28: ( ( (enumLiteral_0= 'exactly-once' ) | (enumLiteral_1= 'at-most-once' ) | (enumLiteral_2= 'at-least-once' ) | (enumLiteral_3= 'best-effort' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4364:1: ( (enumLiteral_0= 'exactly-once' ) | (enumLiteral_1= 'at-most-once' ) | (enumLiteral_2= 'at-least-once' ) | (enumLiteral_3= 'best-effort' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4364:1: ( (enumLiteral_0= 'exactly-once' ) | (enumLiteral_1= 'at-most-once' ) | (enumLiteral_2= 'at-least-once' ) | (enumLiteral_3= 'best-effort' ) )
            int alt99=4;
            switch ( input.LA(1) ) {
            case 134:
                {
                alt99=1;
                }
                break;
            case 135:
                {
                alt99=2;
                }
                break;
            case 136:
                {
                alt99=3;
                }
                break;
            case 137:
                {
                alt99=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;
            }

            switch (alt99) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4364:2: (enumLiteral_0= 'exactly-once' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4364:2: (enumLiteral_0= 'exactly-once' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4364:4: enumLiteral_0= 'exactly-once'
                    {
                    enumLiteral_0=(Token)match(input,134,FollowSets000.FOLLOW_134_in_ruleReliablilityKind9614); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReliablilityKindAccess().getEXACTLY_ONCEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getReliablilityKindAccess().getEXACTLY_ONCEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4370:6: (enumLiteral_1= 'at-most-once' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4370:6: (enumLiteral_1= 'at-most-once' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4370:8: enumLiteral_1= 'at-most-once'
                    {
                    enumLiteral_1=(Token)match(input,135,FollowSets000.FOLLOW_135_in_ruleReliablilityKind9631); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReliablilityKindAccess().getAT_MOST_ONCEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getReliablilityKindAccess().getAT_MOST_ONCEEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4376:6: (enumLiteral_2= 'at-least-once' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4376:6: (enumLiteral_2= 'at-least-once' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4376:8: enumLiteral_2= 'at-least-once'
                    {
                    enumLiteral_2=(Token)match(input,136,FollowSets000.FOLLOW_136_in_ruleReliablilityKind9648); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReliablilityKindAccess().getAT_LEAST_ONCEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getReliablilityKindAccess().getAT_LEAST_ONCEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4382:6: (enumLiteral_3= 'best-effort' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4382:6: (enumLiteral_3= 'best-effort' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4382:8: enumLiteral_3= 'best-effort'
                    {
                    enumLiteral_3=(Token)match(input,137,FollowSets000.FOLLOW_137_in_ruleReliablilityKind9665); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReliablilityKindAccess().getBEST_EFFORTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getReliablilityKindAccess().getBEST_EFFORTEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReliablilityKind"


    // $ANTLR start "ruleGovernanceDecisionResult"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4392:1: ruleGovernanceDecisionResult returns [Enumerator current=null] : ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) ) ;
    public final Enumerator ruleGovernanceDecisionResult() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4394:28: ( ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4395:1: ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4395:1: ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) )
            int alt100=4;
            switch ( input.LA(1) ) {
            case 138:
                {
                alt100=1;
                }
                break;
            case 139:
                {
                alt100=2;
                }
                break;
            case 140:
                {
                alt100=3;
                }
                break;
            case 141:
                {
                alt100=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }

            switch (alt100) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4395:2: (enumLiteral_0= 'pending' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4395:2: (enumLiteral_0= 'pending' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4395:4: enumLiteral_0= 'pending'
                    {
                    enumLiteral_0=(Token)match(input,138,FollowSets000.FOLLOW_138_in_ruleGovernanceDecisionResult9710); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getPendingEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getGovernanceDecisionResultAccess().getPendingEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4401:6: (enumLiteral_1= 'accepted' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4401:6: (enumLiteral_1= 'accepted' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4401:8: enumLiteral_1= 'accepted'
                    {
                    enumLiteral_1=(Token)match(input,139,FollowSets000.FOLLOW_139_in_ruleGovernanceDecisionResult9727); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getAcceptedEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getGovernanceDecisionResultAccess().getAcceptedEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4407:6: (enumLiteral_2= 'denied' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4407:6: (enumLiteral_2= 'denied' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4407:8: enumLiteral_2= 'denied'
                    {
                    enumLiteral_2=(Token)match(input,140,FollowSets000.FOLLOW_140_in_ruleGovernanceDecisionResult9744); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getDeniedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getGovernanceDecisionResultAccess().getDeniedEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4413:6: (enumLiteral_3= 'specific' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4413:6: (enumLiteral_3= 'specific' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4413:8: enumLiteral_3= 'specific'
                    {
                    enumLiteral_3=(Token)match(input,141,FollowSets000.FOLLOW_141_in_ruleGovernanceDecisionResult9761); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getSpecificEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getGovernanceDecisionResultAccess().getSpecificEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGovernanceDecisionResult"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleSlaModel_in_entryRuleSlaModel81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSlaModel91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSLA_in_ruleSlaModel136 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_ruleSLA_in_entryRuleSLA172 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSLA182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSLA219 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSLA240 = new BitSet(new long[]{0x0000000000001000L,0x0000000040000000L});
        public static final BitSet FOLLOW_ruleVersion_in_ruleSLA261 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSLA274 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleSLA286 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA303 = new BitSet(new long[]{0x00000000402FC000L,0x0000000000038400L});
        public static final BitSet FOLLOW_14_in_ruleSLA321 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA338 = new BitSet(new long[]{0x00000000402F8000L,0x0000000000038400L});
        public static final BitSet FOLLOW_ruleParty_in_ruleSLA366 = new BitSet(new long[]{0x00000000402F8000L,0x0000000000038400L});
        public static final BitSet FOLLOW_15_in_ruleSLA380 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA397 = new BitSet(new long[]{0x00000000402F0000L,0x0000000000000400L});
        public static final BitSet FOLLOW_16_in_ruleSLA417 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA434 = new BitSet(new long[]{0x00000000402E0000L,0x0000000000000400L});
        public static final BitSet FOLLOW_17_in_ruleSLA454 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA471 = new BitSet(new long[]{0x00000000402C0000L,0x0000000000000400L});
        public static final BitSet FOLLOW_18_in_ruleSLA491 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA508 = new BitSet(new long[]{0x0000000040280000L,0x0000000000000400L});
        public static final BitSet FOLLOW_rulePriorityDeclaration_in_ruleSLA536 = new BitSet(new long[]{0x0000000040280000L,0x0000000000000400L});
        public static final BitSet FOLLOW_19_in_ruleSLA550 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSLA562 = new BitSet(new long[]{0x0000000000100020L});
        public static final BitSet FOLLOW_ruleAssetRef_in_ruleSLA583 = new BitSet(new long[]{0x0000000000100020L});
        public static final BitSet FOLLOW_20_in_ruleSLA596 = new BitSet(new long[]{0x0000000040200000L});
        public static final BitSet FOLLOW_ruleCost_in_ruleSLA619 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleSLA633 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSLA645 = new BitSet(new long[]{0x0054528800100000L});
        public static final BitSet FOLLOW_ruleServiceQualityProperty_in_ruleSLA666 = new BitSet(new long[]{0x0054528800100000L});
        public static final BitSet FOLLOW_20_in_ruleSLA679 = new BitSet(new long[]{0x000000003E500000L,0x0000000004000800L});
        public static final BitSet FOLLOW_22_in_ruleSLA693 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSLA705 = new BitSet(new long[]{0x0000000001800000L});
        public static final BitSet FOLLOW_23_in_ruleSLA718 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA735 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleSLA755 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSLA767 = new BitSet(new long[]{0x0800000000100000L,0x0000000000000104L});
        public static final BitSet FOLLOW_ruleSecurityRequirement_in_ruleSLA788 = new BitSet(new long[]{0x0800000000100000L,0x0000000000000104L});
        public static final BitSet FOLLOW_20_in_ruleSLA801 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleSLA814 = new BitSet(new long[]{0x000000003E100000L,0x0000000004000800L});
        public static final BitSet FOLLOW_25_in_ruleSLA829 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA846 = new BitSet(new long[]{0x000000003C100000L,0x0000000004000800L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleSLA874 = new BitSet(new long[]{0x000000003C100000L,0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleSLA888 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA905 = new BitSet(new long[]{0x0000000038100000L,0x0000000004000000L});
        public static final BitSet FOLLOW_27_in_ruleSLA925 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA942 = new BitSet(new long[]{0x0000000030100000L,0x0000000004000000L});
        public static final BitSet FOLLOW_ruleReport_in_ruleSLA970 = new BitSet(new long[]{0x0000000030100000L,0x0000000004000000L});
        public static final BitSet FOLLOW_28_in_ruleSLA984 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSLA996 = new BitSet(new long[]{0x0000000000100020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSLA1023 = new BitSet(new long[]{0x0000000000100020L});
        public static final BitSet FOLLOW_20_in_ruleSLA1036 = new BitSet(new long[]{0x0000000020100000L});
        public static final BitSet FOLLOW_29_in_ruleSLA1051 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSLA1075 = new BitSet(new long[]{0x0000000020100020L});
        public static final BitSet FOLLOW_20_in_ruleSLA1090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCost_in_entryRuleCost1126 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCost1136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleCost1173 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleCost1185 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleCost1197 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCost1214 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleCost1231 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCost1248 = new BitSet(new long[]{0x0000000600100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_33_in_ruleCost1266 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCost1283 = new BitSet(new long[]{0x0000000400100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleCost1311 = new BitSet(new long[]{0x0000000400100000L});
        public static final BitSet FOLLOW_34_in_ruleCost1325 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCost1342 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleCost1361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceQualityProperty_in_entryRuleServiceQualityProperty1397 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleServiceQualityProperty1407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAvailability_in_ruleServiceQualityProperty1457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThroughput_in_ruleServiceQualityProperty1487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLatency_in_ruleServiceQualityProperty1517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxDownTime_in_ruleServiceQualityProperty1547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCapacityRequirement_in_ruleServiceQualityProperty1577 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAccuracyRequirement_in_ruleServiceQualityProperty1607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReliablityRequirement_in_ruleServiceQualityProperty1637 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLogRequirement_in_ruleServiceQualityProperty1667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAvailability_in_entryRuleAvailability1702 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAvailability1712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleAvailability1749 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAvailability1761 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_35_in_ruleAvailability1773 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAvailability1790 = new BitSet(new long[]{0x0000007000100000L});
        public static final BitSet FOLLOW_36_in_ruleAvailability1808 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAvailability1825 = new BitSet(new long[]{0x0000006000100000L});
        public static final BitSet FOLLOW_37_in_ruleAvailability1845 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAvailability1862 = new BitSet(new long[]{0x0000004000100040L});
        public static final BitSet FOLLOW_rulePercentile_in_ruleAvailability1888 = new BitSet(new long[]{0x0000004000100000L});
        public static final BitSet FOLLOW_38_in_ruleAvailability1904 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAvailability1921 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleAvailability1940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThroughput_in_entryRuleThroughput1976 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleThroughput1986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleThroughput2023 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleThroughput2035 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_39_in_ruleThroughput2047 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleThroughput2064 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_40_in_ruleThroughput2081 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleThroughput2098 = new BitSet(new long[]{0x0000000400100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleThroughput2124 = new BitSet(new long[]{0x0000000400100000L});
        public static final BitSet FOLLOW_34_in_ruleThroughput2138 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleThroughput2155 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleThroughput2174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLatency_in_entryRuleLatency2210 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLatency2220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleLatency2257 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleLatency2269 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_41_in_ruleLatency2281 = new BitSet(new long[]{0x0000040000000000L});
        public static final BitSet FOLLOW_42_in_ruleLatency2299 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_43_in_ruleLatency2324 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rulePercentile_in_ruleLatency2345 = new BitSet(new long[]{0x0000000400100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleLatency2366 = new BitSet(new long[]{0x0000000400100000L});
        public static final BitSet FOLLOW_34_in_ruleLatency2380 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleLatency2397 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleLatency2416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxDownTime_in_entryRuleMaxDownTime2452 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxDownTime2462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleMaxDownTime2499 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleMaxDownTime2511 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleMaxDownTime2523 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleMaxDownTime2540 = new BitSet(new long[]{0x0000000400100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleMaxDownTime2566 = new BitSet(new long[]{0x0000000400100000L});
        public static final BitSet FOLLOW_34_in_ruleMaxDownTime2580 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleMaxDownTime2597 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleMaxDownTime2616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCapacityRequirement_in_entryRuleCapacityRequirement2652 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCapacityRequirement2662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleCapacityRequirement2699 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleCapacityRequirement2711 = new BitSet(new long[]{0x0002800400100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_47_in_ruleCapacityRequirement2736 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCapacityRequirement2753 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleCapacityRequirement2770 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCapacityRequirement2787 = new BitSet(new long[]{0x0002000400100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_49_in_ruleCapacityRequirement2807 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCapacityRequirement2824 = new BitSet(new long[]{0x0000000400100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleCapacityRequirement2852 = new BitSet(new long[]{0x0000000400100000L});
        public static final BitSet FOLLOW_34_in_ruleCapacityRequirement2866 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCapacityRequirement2883 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleCapacityRequirement2902 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReliablityRequirement_in_entryRuleReliablityRequirement2938 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReliablityRequirement2948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleReliablityRequirement2985 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleReliablityRequirement2997 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000003C0L});
        public static final BitSet FOLLOW_ruleReliablilityKind_in_ruleReliablityRequirement3018 = new BitSet(new long[]{0x0008000000100000L});
        public static final BitSet FOLLOW_51_in_ruleReliablityRequirement3036 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleReliablityRequirement3062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAccuracyRequirement_in_entryRuleAccuracyRequirement3098 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAccuracyRequirement3108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleAccuracyRequirement3145 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAccuracyRequirement3157 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_ruleAccuracyRequirement3169 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAccuracyRequirement3186 = new BitSet(new long[]{0x0000000400100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleAccuracyRequirement3212 = new BitSet(new long[]{0x0000000400100000L});
        public static final BitSet FOLLOW_34_in_ruleAccuracyRequirement3226 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAccuracyRequirement3243 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleAccuracyRequirement3262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLogRequirement_in_entryRuleLogRequirement3298 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLogRequirement3308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleLogRequirement3345 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleLogRequirement3357 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleLogRequirement3369 = new BitSet(new long[]{0x0000000000000000L,0x0002400000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_ruleLogRequirementKind_in_ruleLogRequirement3390 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleLogRequirement3402 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleLogRequirement3419 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePercentile_in_entryRulePercentile3460 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePercentile3470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rulePercentile3512 = new BitSet(new long[]{0x0600000000000000L});
        public static final BitSet FOLLOW_57_in_rulePercentile3530 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_rulePercentile3541 = new BitSet(new long[]{0x0600000000000000L});
        public static final BitSet FOLLOW_58_in_rulePercentile3554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecurityRequirement_in_entryRuleSecurityRequirement3590 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecurityRequirement3600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthenticationRequirement_in_ruleSecurityRequirement3650 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSigningRequirement_in_ruleSecurityRequirement3680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEncryptionRequirement_in_ruleSecurityRequirement3710 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthenticationRequirement_in_entryRuleAuthenticationRequirement3745 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAuthenticationRequirement3755 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_ruleAuthenticationRequirement3804 = new BitSet(new long[]{0x1000000000001000L});
        public static final BitSet FOLLOW_60_in_ruleAuthenticationRequirement3822 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAuthenticationRequirement3848 = new BitSet(new long[]{0x2000000000000000L});
        public static final BitSet FOLLOW_61_in_ruleAuthenticationRequirement3860 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAuthenticationRequirement3872 = new BitSet(new long[]{0x1000000000000000L,0xF000000000000000L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleAuthToken_in_ruleAuthenticationRequirement3893 = new BitSet(new long[]{0x1000000000100000L,0xF000000000000000L,0x000000000000001FL});
        public static final BitSet FOLLOW_20_in_ruleAuthenticationRequirement3906 = new BitSet(new long[]{0x4000000000000000L});
        public static final BitSet FOLLOW_62_in_ruleAuthenticationRequirement3918 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAuthenticationRequirement3930 = new BitSet(new long[]{0x1000000000100000L,0x00003E0000000002L});
        public static final BitSet FOLLOW_ruleHashAlgorithm_in_ruleAuthenticationRequirement3951 = new BitSet(new long[]{0x1000000000100000L,0x00003E0000000002L});
        public static final BitSet FOLLOW_20_in_ruleAuthenticationRequirement3964 = new BitSet(new long[]{0x8000000000100000L,0x0000000000000001L});
        public static final BitSet FOLLOW_63_in_ruleAuthenticationRequirement3982 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000001L});
        public static final BitSet FOLLOW_64_in_ruleAuthenticationRequirement4009 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAuthenticationRequirement4026 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleAuthenticationRequirement4045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthToken_in_entryRuleAuthToken4081 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAuthToken4091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleAuthToken4134 = new BitSet(new long[]{0x1000000000000000L,0xF000000000000000L,0x000000000000001FL});
        public static final BitSet FOLLOW_ruleAuthTokenKind_in_ruleAuthToken4169 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHashAlgorithm_in_entryRuleHashAlgorithm4205 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHashAlgorithm4215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleHashAlgorithm4258 = new BitSet(new long[]{0x1000000000000000L,0x00003E0000000002L});
        public static final BitSet FOLLOW_65_in_ruleHashAlgorithm4290 = new BitSet(new long[]{0x1000000000000000L,0x00003E0000000002L});
        public static final BitSet FOLLOW_ruleHashAlgKind_in_ruleHashAlgorithm4325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSigningRequirement_in_entryRuleSigningRequirement4361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSigningRequirement4371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleSigningRequirement4420 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSigningRequirement4432 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000038L});
        public static final BitSet FOLLOW_67_in_ruleSigningRequirement4445 = new BitSet(new long[]{0x0000000000000000L,0x007C0E0000000000L});
        public static final BitSet FOLLOW_ruleSigningAlgothm_in_ruleSigningRequirement4466 = new BitSet(new long[]{0x0000000000100000L,0x007C0E0000000030L});
        public static final BitSet FOLLOW_68_in_ruleSigningRequirement4482 = new BitSet(new long[]{0x0000000000000000L,0x007C0E0000000000L});
        public static final BitSet FOLLOW_ruleSigningAlgothm_in_ruleSigningRequirement4503 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000020L});
        public static final BitSet FOLLOW_69_in_ruleSigningRequirement4518 = new BitSet(new long[]{0x0000000000000000L,0x0003C00000000080L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_ruleSigningRequirement4539 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000040L});
        public static final BitSet FOLLOW_70_in_ruleSigningRequirement4552 = new BitSet(new long[]{0x0000000000000000L,0x0003C00000000080L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_ruleSigningRequirement4573 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000040L});
        public static final BitSet FOLLOW_20_in_ruleSigningRequirement4589 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_entryRuleMessagePartRef4625 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMessagePartRef4635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMessagePartRefKind_in_ruleMessagePartRef4681 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_ruleMessagePartRef4694 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleMessagePartRef4711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEncryptionRequirement_in_entryRuleEncryptionRequirement4754 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEncryptionRequirement4764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_72_in_ruleEncryptionRequirement4813 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEncryptionRequirement4825 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000218L});
        public static final BitSet FOLLOW_67_in_ruleEncryptionRequirement4838 = new BitSet(new long[]{0x0000000000000000L,0x0FD4000000000000L});
        public static final BitSet FOLLOW_ruleCipherAlgorithmKind_in_ruleEncryptionRequirement4859 = new BitSet(new long[]{0x0000000000100000L,0x0FD4000000000210L});
        public static final BitSet FOLLOW_68_in_ruleEncryptionRequirement4875 = new BitSet(new long[]{0x0000000000000000L,0x0FD4000000000000L});
        public static final BitSet FOLLOW_ruleCipherAlgorithmKind_in_ruleEncryptionRequirement4896 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000200L});
        public static final BitSet FOLLOW_73_in_ruleEncryptionRequirement4911 = new BitSet(new long[]{0x0000000000000000L,0x0003C00000000080L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_ruleEncryptionRequirement4932 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000040L});
        public static final BitSet FOLLOW_70_in_ruleEncryptionRequirement4945 = new BitSet(new long[]{0x0000000000000000L,0x0003C00000000080L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_ruleEncryptionRequirement4966 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000040L});
        public static final BitSet FOLLOW_20_in_ruleEncryptionRequirement4982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePriorityDeclaration_in_entryRulePriorityDeclaration5018 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePriorityDeclaration5028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_74_in_rulePriorityDeclaration5065 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePriorityDeclaration5082 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_rulePriorityDeclaration5099 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_rulePriorityDeclaration5116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEscalation_in_entryRuleEscalation5157 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEscalation5167 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleEscalation5204 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEscalation5216 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003000L});
        public static final BitSet FOLLOW_76_in_ruleEscalation5229 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEscalation5246 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
        public static final BitSet FOLLOW_77_in_ruleEscalation5265 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEscalation5277 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleEscalation5304 = new BitSet(new long[]{0x0000000000100020L});
        public static final BitSet FOLLOW_20_in_ruleEscalation5317 = new BitSet(new long[]{0x0000000000100000L,0x0000000000004000L});
        public static final BitSet FOLLOW_78_in_ruleEscalation5330 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEscalation5347 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleEscalation5366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParty_in_entryRuleParty5402 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParty5412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCustomerParty_in_ruleParty5462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProviderParty_in_ruleParty5492 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdParty_in_ruleParty5522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCustomerParty_in_entryRuleCustomerParty5557 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCustomerParty5567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_79_in_ruleCustomerParty5604 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCustomerParty5625 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleCustomerParty5637 = new BitSet(new long[]{0x0000000000000020L,0x0000000000080000L});
        public static final BitSet FOLLOW_ruleRepresentative_in_ruleCustomerParty5658 = new BitSet(new long[]{0x0000000000000020L,0x0000000002080000L});
        public static final BitSet FOLLOW_ruleResponsibility_in_ruleCustomerParty5680 = new BitSet(new long[]{0x0000000000100000L,0x0000000002000000L});
        public static final BitSet FOLLOW_20_in_ruleCustomerParty5693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProviderParty_in_entryRuleProviderParty5729 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProviderParty5739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_80_in_ruleProviderParty5776 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleProviderParty5797 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleProviderParty5809 = new BitSet(new long[]{0x0000000000000020L,0x0000000000080000L});
        public static final BitSet FOLLOW_ruleRepresentative_in_ruleProviderParty5830 = new BitSet(new long[]{0x0000000000000020L,0x0000000002080000L});
        public static final BitSet FOLLOW_ruleResponsibility_in_ruleProviderParty5852 = new BitSet(new long[]{0x0000000000100000L,0x0000000002000000L});
        public static final BitSet FOLLOW_20_in_ruleProviderParty5865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdParty_in_entryRuleThirdParty5901 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleThirdParty5911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_81_in_ruleThirdParty5948 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleThirdParty5969 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleThirdParty5981 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
        public static final BitSet FOLLOW_82_in_ruleThirdParty5993 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleThirdParty6010 = new BitSet(new long[]{0x0000000000000020L,0x0000000000080000L});
        public static final BitSet FOLLOW_ruleRepresentative_in_ruleThirdParty6036 = new BitSet(new long[]{0x0000000000000020L,0x0000000002080000L});
        public static final BitSet FOLLOW_ruleResponsibility_in_ruleThirdParty6058 = new BitSet(new long[]{0x0000000000100000L,0x0000000002000000L});
        public static final BitSet FOLLOW_20_in_ruleThirdParty6071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRepresentative_in_entryRuleRepresentative6107 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRepresentative6117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUserRef_in_ruleRepresentative6167 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInlineRepresentative_in_ruleRepresentative6197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUserRef_in_entryRuleUserRef6232 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUserRef6242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleUserRef6293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInlineRepresentative_in_entryRuleInlineRepresentative6328 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInlineRepresentative6338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_83_in_ruleInlineRepresentative6387 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleInlineRepresentative6399 = new BitSet(new long[]{0x0000000000100000L,0x0000000001F00000L});
        public static final BitSet FOLLOW_84_in_ruleInlineRepresentative6412 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleInlineRepresentative6429 = new BitSet(new long[]{0x0000000000100000L,0x0000000001E00000L});
        public static final BitSet FOLLOW_85_in_ruleInlineRepresentative6449 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleInlineRepresentative6466 = new BitSet(new long[]{0x0000000000100000L,0x0000000001C00000L});
        public static final BitSet FOLLOW_86_in_ruleInlineRepresentative6486 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleInlineRepresentative6503 = new BitSet(new long[]{0x0000000000100000L,0x0000000001800000L});
        public static final BitSet FOLLOW_87_in_ruleInlineRepresentative6523 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleInlineRepresentative6540 = new BitSet(new long[]{0x0000000000100000L,0x0000000001000000L});
        public static final BitSet FOLLOW_88_in_ruleInlineRepresentative6560 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleInlineRepresentative6577 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleInlineRepresentative6596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleResponsibility_in_entryRuleResponsibility6632 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleResponsibility6642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_89_in_ruleResponsibility6679 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleResponsibility6696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReport_in_entryRuleReport6737 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReport6747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_90_in_ruleReport6784 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReport6801 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleReport6818 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
        public static final BitSet FOLLOW_91_in_ruleReport6830 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleReport6857 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
        public static final BitSet FOLLOW_92_in_ruleReport6869 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReport6886 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleReport6903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVersionId_in_entryRuleVersionId6942 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionId6953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId6993 = new BitSet(new long[]{0x0200000000000002L,0x0000000020000000L});
        public static final BitSet FOLLOW_57_in_ruleVersionId7012 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId7027 = new BitSet(new long[]{0x0200000000000002L,0x0000000020000000L});
        public static final BitSet FOLLOW_57_in_ruleVersionId7049 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_93_in_ruleVersionId7068 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVersionId7084 = new BitSet(new long[]{0x0200000000000002L,0x0000000020000000L});
        public static final BitSet FOLLOW_ruleVersion_in_entryRuleVersion7133 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersion7143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_94_in_ruleVersion7180 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleVersion7201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVersionRef_in_entryRuleVersionRef7237 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionRef7247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_ruleVersionRef7297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_ruleVersionRef7327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef7357 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_ruleVersionRef7387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_ruleVersionRef7417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef7452 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMinVersionRef7462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_95_in_ruleMinVersionRef7499 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMinVersionRef7520 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef7556 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxVersionRef7566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_96_in_ruleMaxVersionRef7603 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMaxVersionRef7624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef7660 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef7670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_95_in_ruleLowerBoundRangeVersionRef7708 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
        public static final BitSet FOLLOW_97_in_ruleLowerBoundRangeVersionRef7720 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef7742 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_70_in_ruleLowerBoundRangeVersionRef7754 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
        public static final BitSet FOLLOW_96_in_ruleLowerBoundRangeVersionRef7767 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
        public static final BitSet FOLLOW_98_in_ruleLowerBoundRangeVersionRef7779 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef7801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef7837 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMajorVersionRef7847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_99_in_ruleMajorVersionRef7884 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMajorVersionRef7901 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef7942 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFixedVersionRef7952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_100_in_ruleFixedVersionRef7989 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleFixedVersionRef8010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard8047 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard8058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard8105 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
        public static final BitSet FOLLOW_101_in_ruleQualifiedNameWithWildCard8124 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8167 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName8178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName8218 = new BitSet(new long[]{0x0200000000000002L,0x0000004000000000L});
        public static final BitSet FOLLOW_57_in_ruleQualifiedName8238 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_102_in_ruleQualifiedName8257 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName8273 = new BitSet(new long[]{0x0200000000000002L,0x0000004000000000L});
        public static final BitSet FOLLOW_ruleInfoItem_in_entryRuleInfoItem8326 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfoItem8336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_103_in_ruleInfoItem8373 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleInfoItem8390 = new BitSet(new long[]{0x0000000000000002L,0x0000010000000000L});
        public static final BitSet FOLLOW_104_in_ruleInfoItem8408 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleInfoItem8425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRoleRef_in_entryRuleRoleRef8470 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoleRef8480 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRoleRef8531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrivilegeRef_in_entryRulePrivilegeRef8568 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrivilegeRef8578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rulePrivilegeRef8629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssetRef_in_entryRuleAssetRef8666 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssetRef8676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssetRef8728 = new BitSet(new long[]{0x0000000000000002L,0x0000001980000000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleAssetRef8749 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_105_in_ruleHashAlgKind8800 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_106_in_ruleHashAlgKind8817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_107_in_ruleHashAlgKind8834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_108_in_ruleHashAlgKind8851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_109_in_ruleHashAlgKind8868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_110_in_ruleMessagePartRefKind8913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_111_in_ruleMessagePartRefKind8930 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_112_in_ruleMessagePartRefKind8947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_113_in_ruleMessagePartRefKind8964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_71_in_ruleMessagePartRefKind8981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_114_in_ruleSigningAlgothm9026 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_106_in_ruleSigningAlgothm9043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_107_in_ruleSigningAlgothm9060 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_105_in_ruleSigningAlgothm9077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_115_in_ruleSigningAlgothm9094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_116_in_ruleSigningAlgothm9111 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_117_in_ruleSigningAlgothm9128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_118_in_ruleSigningAlgothm9145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_114_in_ruleCipherAlgorithmKind9190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_119_in_ruleCipherAlgorithmKind9207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_120_in_ruleCipherAlgorithmKind9224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_121_in_ruleCipherAlgorithmKind9241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_122_in_ruleCipherAlgorithmKind9258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_123_in_ruleCipherAlgorithmKind9275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_116_in_ruleCipherAlgorithmKind9292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_118_in_ruleCipherAlgorithmKind9309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_124_in_ruleAuthTokenKind9354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_125_in_ruleAuthTokenKind9371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_126_in_ruleAuthTokenKind9388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_127_in_ruleAuthTokenKind9405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_128_in_ruleAuthTokenKind9422 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_129_in_ruleAuthTokenKind9439 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_130_in_ruleAuthTokenKind9456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_131_in_ruleAuthTokenKind9473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_132_in_ruleAuthTokenKind9490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_133_in_ruleLogRequirementKind9535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_110_in_ruleLogRequirementKind9552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_113_in_ruleLogRequirementKind9569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_134_in_ruleReliablilityKind9614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_135_in_ruleReliablilityKind9631 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_136_in_ruleReliablilityKind9648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_137_in_ruleReliablilityKind9665 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_138_in_ruleGovernanceDecisionResult9710 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_139_in_ruleGovernanceDecisionResult9727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_140_in_ruleGovernanceDecisionResult9744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_141_in_ruleGovernanceDecisionResult9761 = new BitSet(new long[]{0x0000000000000002L});
    }


}