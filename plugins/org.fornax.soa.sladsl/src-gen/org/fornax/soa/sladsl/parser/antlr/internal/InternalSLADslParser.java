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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'service-level-agreement'", "'{'", "'effective-date'", "'effective-until'", "'preample'", "'description'", "'scope'", "'applies-to'", "'}'", "'service-quality-requirements'", "'data-security-and-protection'", "'general-security-terms'", "'security-requirements'", "'restrictions'", "'additional-services'", "'cancellation'", "'extraordinary-cancellation'", "'effort-accounting'", "'contact-info'", "'owner'", "'responsible'", "'budgeting'", "'subscriptions'", "'tags'", "'costs'", "'amount'", "'billed-per-unit'", "'penalty'", "'availability'", "'mean-time-between-failure'", "'mean-time-to-repair'", "'regular-down-times'", "'throughput'", "'score-to-be-kept'", "'latency'", "'STRING'", "'percentile'", "'max-downtime'", "'duration'", "'capacity'", "'num-of-requests'", "'per'", "'message-size'", "'message-exchange-reliability'", "'in-order-delivery'", "'accuracy'", "'max-error-rate'", "'logging'", "'message-log-level'", "'additional-logging-requirements'", "'.'", "'%'", "'authentication-procedure'", "'optional'", "'auth-tokens'", "'hash-algorithms'", "'use-nonce'", "'issuer'", "'Base64-encoded'", "'signing-policy'", "'supported-algorithms'", "'requires-algorithm'", "'signed-message-parts'", "','", "'expression'", "'encryption-policy'", "'encrypted-message-parts'", "'priority'", "'escalation'", "'cause'", "'escalate-to'", "'procedure'", "'customer-party'", "'provider-party'", "'third-party'", "'participation-role'", "'representative'", "'name'", "'phone'", "'email'", "'responsibility'", "'report'", "'report-to'", "'contents'", "'reporting-responsibility'", "'-'", "'version'", "'minVersion'", "'maxVersion'", "'>='", "'<'", "'majorVersion'", "'fixedVersion'", "'.*'", "'location'", "'reference'", "'MD5'", "'SHA1'", "'SHA256'", "'RSA'", "'PlainText'", "'header'", "'body'", "'attachments'", "'all'", "'NONE'", "'RSA_1_5'", "'AES128'", "'AES192'", "'AES256'", "'Basic128'", "'Basic192'", "'Basic256'", "'DES'", "'3DES'", "'UsernamePassword'", "'SAML'", "'SAML2'", "'Kerberos'", "'SPNEGO'", "'RELToken'", "'X509Certificate'", "'OAuth'", "'OAuth2'", "'none'", "'exactly-once'", "'at-most-once'", "'at-least-once'", "'best-effort'", "'pending'", "'accepted'", "'denied'", "'specific'"
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
    public static final int T__142=142;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__140=140;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__143=143;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:122:1: ruleSLA returns [EObject current=null] : (otherlv_0= 'service-level-agreement' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_version_2_0= ruleVersion ) )? otherlv_3= '{' otherlv_4= 'effective-date' ( (lv_effectiveDate_5_0= RULE_STRING ) ) (otherlv_6= 'effective-until' ( (lv_effectiveUntil_7_0= RULE_STRING ) ) )? (otherlv_8= 'preample' ( (lv_preample_9_0= RULE_STRING ) ) )? (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) )? (otherlv_12= 'scope' ( (lv_scope_13_0= RULE_STRING ) ) )? (otherlv_14= 'applies-to' otherlv_15= '{' ( (lv_appliesTo_16_0= ruleAssetRef ) )* otherlv_17= '}' )? ( (lv_costs_18_0= ruleCost ) )? (otherlv_19= 'service-quality-requirements' otherlv_20= '{' ( (lv_serviceQualityProperties_21_0= ruleServiceQualityProperty ) )* otherlv_22= '}' ) (otherlv_23= 'data-security-and-protection' otherlv_24= '{' (otherlv_25= 'general-security-terms' ( (lv_dataSecProtClause_26_0= RULE_STRING ) ) )? (otherlv_27= 'security-requirements' otherlv_28= '{' ( (lv_securityRequirements_29_0= ruleSecurityRequirement ) )* otherlv_30= '}' ) otherlv_31= '}' )? (otherlv_32= 'restrictions' ( (lv_restrictions_33_0= RULE_STRING ) ) )? ( (lv_priorities_34_0= rulePriorityDeclaration ) )* ( (lv_escalationProcedure_35_0= ruleEscalation ) )? (otherlv_36= 'additional-services' ( (lv_additionalServices_37_0= RULE_STRING ) ) )? ( (lv_parties_38_0= ruleParty ) )* (otherlv_39= 'cancellation' ( (lv_cancellation_40_0= RULE_STRING ) ) )? (otherlv_41= 'extraordinary-cancellation' ( (lv_extraordinaryCancellation_42_0= RULE_STRING ) ) )? (otherlv_43= 'effort-accounting' ( (lv_effortAccounting_44_0= RULE_STRING ) ) )? ( (lv_reports_45_0= ruleReport ) )* (otherlv_46= 'contact-info' otherlv_47= '{' (otherlv_48= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_50= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_52= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_54= 'subscriptions' otherlv_55= '{' ( ( ruleQualifiedName ) )* otherlv_57= '}' )? )? (otherlv_58= 'tags' ( (otherlv_59= RULE_ID ) )+ )* otherlv_60= '}' ) ;
    public final EObject ruleSLA() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_effectiveDate_5_0=null;
        Token otherlv_6=null;
        Token lv_effectiveUntil_7_0=null;
        Token otherlv_8=null;
        Token lv_preample_9_0=null;
        Token otherlv_10=null;
        Token lv_description_11_0=null;
        Token otherlv_12=null;
        Token lv_scope_13_0=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token lv_dataSecProtClause_26_0=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token otherlv_32=null;
        Token lv_restrictions_33_0=null;
        Token otherlv_36=null;
        Token lv_additionalServices_37_0=null;
        Token otherlv_39=null;
        Token lv_cancellation_40_0=null;
        Token otherlv_41=null;
        Token lv_extraordinaryCancellation_42_0=null;
        Token otherlv_43=null;
        Token lv_effortAccounting_44_0=null;
        Token otherlv_46=null;
        Token otherlv_47=null;
        Token otherlv_48=null;
        Token otherlv_50=null;
        Token otherlv_52=null;
        Token otherlv_54=null;
        Token otherlv_55=null;
        Token otherlv_57=null;
        Token otherlv_58=null;
        Token otherlv_59=null;
        Token otherlv_60=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_version_2_0 = null;

        EObject lv_appliesTo_16_0 = null;

        EObject lv_costs_18_0 = null;

        EObject lv_serviceQualityProperties_21_0 = null;

        EObject lv_securityRequirements_29_0 = null;

        EObject lv_priorities_34_0 = null;

        EObject lv_escalationProcedure_35_0 = null;

        EObject lv_parties_38_0 = null;

        EObject lv_reports_45_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:125:28: ( (otherlv_0= 'service-level-agreement' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_version_2_0= ruleVersion ) )? otherlv_3= '{' otherlv_4= 'effective-date' ( (lv_effectiveDate_5_0= RULE_STRING ) ) (otherlv_6= 'effective-until' ( (lv_effectiveUntil_7_0= RULE_STRING ) ) )? (otherlv_8= 'preample' ( (lv_preample_9_0= RULE_STRING ) ) )? (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) )? (otherlv_12= 'scope' ( (lv_scope_13_0= RULE_STRING ) ) )? (otherlv_14= 'applies-to' otherlv_15= '{' ( (lv_appliesTo_16_0= ruleAssetRef ) )* otherlv_17= '}' )? ( (lv_costs_18_0= ruleCost ) )? (otherlv_19= 'service-quality-requirements' otherlv_20= '{' ( (lv_serviceQualityProperties_21_0= ruleServiceQualityProperty ) )* otherlv_22= '}' ) (otherlv_23= 'data-security-and-protection' otherlv_24= '{' (otherlv_25= 'general-security-terms' ( (lv_dataSecProtClause_26_0= RULE_STRING ) ) )? (otherlv_27= 'security-requirements' otherlv_28= '{' ( (lv_securityRequirements_29_0= ruleSecurityRequirement ) )* otherlv_30= '}' ) otherlv_31= '}' )? (otherlv_32= 'restrictions' ( (lv_restrictions_33_0= RULE_STRING ) ) )? ( (lv_priorities_34_0= rulePriorityDeclaration ) )* ( (lv_escalationProcedure_35_0= ruleEscalation ) )? (otherlv_36= 'additional-services' ( (lv_additionalServices_37_0= RULE_STRING ) ) )? ( (lv_parties_38_0= ruleParty ) )* (otherlv_39= 'cancellation' ( (lv_cancellation_40_0= RULE_STRING ) ) )? (otherlv_41= 'extraordinary-cancellation' ( (lv_extraordinaryCancellation_42_0= RULE_STRING ) ) )? (otherlv_43= 'effort-accounting' ( (lv_effortAccounting_44_0= RULE_STRING ) ) )? ( (lv_reports_45_0= ruleReport ) )* (otherlv_46= 'contact-info' otherlv_47= '{' (otherlv_48= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_50= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_52= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_54= 'subscriptions' otherlv_55= '{' ( ( ruleQualifiedName ) )* otherlv_57= '}' )? )? (otherlv_58= 'tags' ( (otherlv_59= RULE_ID ) )+ )* otherlv_60= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:126:1: (otherlv_0= 'service-level-agreement' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_version_2_0= ruleVersion ) )? otherlv_3= '{' otherlv_4= 'effective-date' ( (lv_effectiveDate_5_0= RULE_STRING ) ) (otherlv_6= 'effective-until' ( (lv_effectiveUntil_7_0= RULE_STRING ) ) )? (otherlv_8= 'preample' ( (lv_preample_9_0= RULE_STRING ) ) )? (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) )? (otherlv_12= 'scope' ( (lv_scope_13_0= RULE_STRING ) ) )? (otherlv_14= 'applies-to' otherlv_15= '{' ( (lv_appliesTo_16_0= ruleAssetRef ) )* otherlv_17= '}' )? ( (lv_costs_18_0= ruleCost ) )? (otherlv_19= 'service-quality-requirements' otherlv_20= '{' ( (lv_serviceQualityProperties_21_0= ruleServiceQualityProperty ) )* otherlv_22= '}' ) (otherlv_23= 'data-security-and-protection' otherlv_24= '{' (otherlv_25= 'general-security-terms' ( (lv_dataSecProtClause_26_0= RULE_STRING ) ) )? (otherlv_27= 'security-requirements' otherlv_28= '{' ( (lv_securityRequirements_29_0= ruleSecurityRequirement ) )* otherlv_30= '}' ) otherlv_31= '}' )? (otherlv_32= 'restrictions' ( (lv_restrictions_33_0= RULE_STRING ) ) )? ( (lv_priorities_34_0= rulePriorityDeclaration ) )* ( (lv_escalationProcedure_35_0= ruleEscalation ) )? (otherlv_36= 'additional-services' ( (lv_additionalServices_37_0= RULE_STRING ) ) )? ( (lv_parties_38_0= ruleParty ) )* (otherlv_39= 'cancellation' ( (lv_cancellation_40_0= RULE_STRING ) ) )? (otherlv_41= 'extraordinary-cancellation' ( (lv_extraordinaryCancellation_42_0= RULE_STRING ) ) )? (otherlv_43= 'effort-accounting' ( (lv_effortAccounting_44_0= RULE_STRING ) ) )? ( (lv_reports_45_0= ruleReport ) )* (otherlv_46= 'contact-info' otherlv_47= '{' (otherlv_48= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_50= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_52= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_54= 'subscriptions' otherlv_55= '{' ( ( ruleQualifiedName ) )* otherlv_57= '}' )? )? (otherlv_58= 'tags' ( (otherlv_59= RULE_ID ) )+ )* otherlv_60= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:126:1: (otherlv_0= 'service-level-agreement' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_version_2_0= ruleVersion ) )? otherlv_3= '{' otherlv_4= 'effective-date' ( (lv_effectiveDate_5_0= RULE_STRING ) ) (otherlv_6= 'effective-until' ( (lv_effectiveUntil_7_0= RULE_STRING ) ) )? (otherlv_8= 'preample' ( (lv_preample_9_0= RULE_STRING ) ) )? (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) )? (otherlv_12= 'scope' ( (lv_scope_13_0= RULE_STRING ) ) )? (otherlv_14= 'applies-to' otherlv_15= '{' ( (lv_appliesTo_16_0= ruleAssetRef ) )* otherlv_17= '}' )? ( (lv_costs_18_0= ruleCost ) )? (otherlv_19= 'service-quality-requirements' otherlv_20= '{' ( (lv_serviceQualityProperties_21_0= ruleServiceQualityProperty ) )* otherlv_22= '}' ) (otherlv_23= 'data-security-and-protection' otherlv_24= '{' (otherlv_25= 'general-security-terms' ( (lv_dataSecProtClause_26_0= RULE_STRING ) ) )? (otherlv_27= 'security-requirements' otherlv_28= '{' ( (lv_securityRequirements_29_0= ruleSecurityRequirement ) )* otherlv_30= '}' ) otherlv_31= '}' )? (otherlv_32= 'restrictions' ( (lv_restrictions_33_0= RULE_STRING ) ) )? ( (lv_priorities_34_0= rulePriorityDeclaration ) )* ( (lv_escalationProcedure_35_0= ruleEscalation ) )? (otherlv_36= 'additional-services' ( (lv_additionalServices_37_0= RULE_STRING ) ) )? ( (lv_parties_38_0= ruleParty ) )* (otherlv_39= 'cancellation' ( (lv_cancellation_40_0= RULE_STRING ) ) )? (otherlv_41= 'extraordinary-cancellation' ( (lv_extraordinaryCancellation_42_0= RULE_STRING ) ) )? (otherlv_43= 'effort-accounting' ( (lv_effortAccounting_44_0= RULE_STRING ) ) )? ( (lv_reports_45_0= ruleReport ) )* (otherlv_46= 'contact-info' otherlv_47= '{' (otherlv_48= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_50= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_52= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_54= 'subscriptions' otherlv_55= '{' ( ( ruleQualifiedName ) )* otherlv_57= '}' )? )? (otherlv_58= 'tags' ( (otherlv_59= RULE_ID ) )+ )* otherlv_60= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:126:3: otherlv_0= 'service-level-agreement' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_version_2_0= ruleVersion ) )? otherlv_3= '{' otherlv_4= 'effective-date' ( (lv_effectiveDate_5_0= RULE_STRING ) ) (otherlv_6= 'effective-until' ( (lv_effectiveUntil_7_0= RULE_STRING ) ) )? (otherlv_8= 'preample' ( (lv_preample_9_0= RULE_STRING ) ) )? (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) )? (otherlv_12= 'scope' ( (lv_scope_13_0= RULE_STRING ) ) )? (otherlv_14= 'applies-to' otherlv_15= '{' ( (lv_appliesTo_16_0= ruleAssetRef ) )* otherlv_17= '}' )? ( (lv_costs_18_0= ruleCost ) )? (otherlv_19= 'service-quality-requirements' otherlv_20= '{' ( (lv_serviceQualityProperties_21_0= ruleServiceQualityProperty ) )* otherlv_22= '}' ) (otherlv_23= 'data-security-and-protection' otherlv_24= '{' (otherlv_25= 'general-security-terms' ( (lv_dataSecProtClause_26_0= RULE_STRING ) ) )? (otherlv_27= 'security-requirements' otherlv_28= '{' ( (lv_securityRequirements_29_0= ruleSecurityRequirement ) )* otherlv_30= '}' ) otherlv_31= '}' )? (otherlv_32= 'restrictions' ( (lv_restrictions_33_0= RULE_STRING ) ) )? ( (lv_priorities_34_0= rulePriorityDeclaration ) )* ( (lv_escalationProcedure_35_0= ruleEscalation ) )? (otherlv_36= 'additional-services' ( (lv_additionalServices_37_0= RULE_STRING ) ) )? ( (lv_parties_38_0= ruleParty ) )* (otherlv_39= 'cancellation' ( (lv_cancellation_40_0= RULE_STRING ) ) )? (otherlv_41= 'extraordinary-cancellation' ( (lv_extraordinaryCancellation_42_0= RULE_STRING ) ) )? (otherlv_43= 'effort-accounting' ( (lv_effortAccounting_44_0= RULE_STRING ) ) )? ( (lv_reports_45_0= ruleReport ) )* (otherlv_46= 'contact-info' otherlv_47= '{' (otherlv_48= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_50= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_52= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_54= 'subscriptions' otherlv_55= '{' ( ( ruleQualifiedName ) )* otherlv_57= '}' )? )? (otherlv_58= 'tags' ( (otherlv_59= RULE_ID ) )+ )* otherlv_60= '}'
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

            if ( (LA2_0==97) ) {
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:214:4: (otherlv_8= 'preample' ( (lv_preample_9_0= RULE_STRING ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:214:6: otherlv_8= 'preample' ( (lv_preample_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSLA358); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getSLAAccess().getPreampleKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:218:1: ( (lv_preample_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:219:1: (lv_preample_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:219:1: (lv_preample_9_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:220:3: lv_preample_9_0= RULE_STRING
                    {
                    lv_preample_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA375); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_preample_9_0, grammarAccess.getSLAAccess().getPreampleSTRINGTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"preample",
                              		lv_preample_9_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:236:4: (otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:236:6: otherlv_10= 'description' ( (lv_description_11_0= RULE_STRING ) )
                    {
                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSLA395); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getSLAAccess().getDescriptionKeyword_8_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:240:1: ( (lv_description_11_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:241:1: (lv_description_11_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:241:1: (lv_description_11_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:242:3: lv_description_11_0= RULE_STRING
                    {
                    lv_description_11_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA412); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_description_11_0, grammarAccess.getSLAAccess().getDescriptionSTRINGTerminalRuleCall_8_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"description",
                              		lv_description_11_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:258:4: (otherlv_12= 'scope' ( (lv_scope_13_0= RULE_STRING ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:258:6: otherlv_12= 'scope' ( (lv_scope_13_0= RULE_STRING ) )
                    {
                    otherlv_12=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSLA432); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getSLAAccess().getScopeKeyword_9_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:262:1: ( (lv_scope_13_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:263:1: (lv_scope_13_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:263:1: (lv_scope_13_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:264:3: lv_scope_13_0= RULE_STRING
                    {
                    lv_scope_13_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA449); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_scope_13_0, grammarAccess.getSLAAccess().getScopeSTRINGTerminalRuleCall_9_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"scope",
                              		lv_scope_13_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:280:4: (otherlv_14= 'applies-to' otherlv_15= '{' ( (lv_appliesTo_16_0= ruleAssetRef ) )* otherlv_17= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:280:6: otherlv_14= 'applies-to' otherlv_15= '{' ( (lv_appliesTo_16_0= ruleAssetRef ) )* otherlv_17= '}'
                    {
                    otherlv_14=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSLA469); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getSLAAccess().getAppliesToKeyword_10_0());
                          
                    }
                    otherlv_15=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSLA481); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getSLAAccess().getLeftCurlyBracketKeyword_10_1());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:288:1: ( (lv_appliesTo_16_0= ruleAssetRef ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_ID) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:289:1: (lv_appliesTo_16_0= ruleAssetRef )
                    	    {
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:289:1: (lv_appliesTo_16_0= ruleAssetRef )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:290:3: lv_appliesTo_16_0= ruleAssetRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSLAAccess().getAppliesToAssetRefParserRuleCall_10_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssetRef_in_ruleSLA502);
                    	    lv_appliesTo_16_0=ruleAssetRef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSLARule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"appliesTo",
                    	              		lv_appliesTo_16_0, 
                    	              		"AssetRef");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSLA515); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getSLAAccess().getRightCurlyBracketKeyword_10_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:310:3: ( (lv_costs_18_0= ruleCost ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==35) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:311:1: (lv_costs_18_0= ruleCost )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:311:1: (lv_costs_18_0= ruleCost )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:312:3: lv_costs_18_0= ruleCost
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSLAAccess().getCostsCostParserRuleCall_11_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCost_in_ruleSLA538);
                    lv_costs_18_0=ruleCost();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSLARule());
                      	        }
                             		set(
                             			current, 
                             			"costs",
                              		lv_costs_18_0, 
                              		"Cost");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:328:3: (otherlv_19= 'service-quality-requirements' otherlv_20= '{' ( (lv_serviceQualityProperties_21_0= ruleServiceQualityProperty ) )* otherlv_22= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:328:5: otherlv_19= 'service-quality-requirements' otherlv_20= '{' ( (lv_serviceQualityProperties_21_0= ruleServiceQualityProperty ) )* otherlv_22= '}'
            {
            otherlv_19=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSLA552); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_19, grammarAccess.getSLAAccess().getServiceQualityRequirementsKeyword_12_0());
                  
            }
            otherlv_20=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSLA564); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_20, grammarAccess.getSLAAccess().getLeftCurlyBracketKeyword_12_1());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:336:1: ( (lv_serviceQualityProperties_21_0= ruleServiceQualityProperty ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==39||LA10_0==43||LA10_0==45||LA10_0==48||LA10_0==50||LA10_0==54||LA10_0==56||LA10_0==58) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:337:1: (lv_serviceQualityProperties_21_0= ruleServiceQualityProperty )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:337:1: (lv_serviceQualityProperties_21_0= ruleServiceQualityProperty )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:338:3: lv_serviceQualityProperties_21_0= ruleServiceQualityProperty
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSLAAccess().getServiceQualityPropertiesServiceQualityPropertyParserRuleCall_12_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceQualityProperty_in_ruleSLA585);
            	    lv_serviceQualityProperties_21_0=ruleServiceQualityProperty();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSLARule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"serviceQualityProperties",
            	              		lv_serviceQualityProperties_21_0, 
            	              		"ServiceQualityProperty");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_22=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSLA598); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_22, grammarAccess.getSLAAccess().getRightCurlyBracketKeyword_12_3());
                  
            }

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:358:2: (otherlv_23= 'data-security-and-protection' otherlv_24= '{' (otherlv_25= 'general-security-terms' ( (lv_dataSecProtClause_26_0= RULE_STRING ) ) )? (otherlv_27= 'security-requirements' otherlv_28= '{' ( (lv_securityRequirements_29_0= ruleSecurityRequirement ) )* otherlv_30= '}' ) otherlv_31= '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==21) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:358:4: otherlv_23= 'data-security-and-protection' otherlv_24= '{' (otherlv_25= 'general-security-terms' ( (lv_dataSecProtClause_26_0= RULE_STRING ) ) )? (otherlv_27= 'security-requirements' otherlv_28= '{' ( (lv_securityRequirements_29_0= ruleSecurityRequirement ) )* otherlv_30= '}' ) otherlv_31= '}'
                    {
                    otherlv_23=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleSLA612); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_23, grammarAccess.getSLAAccess().getDataSecurityAndProtectionKeyword_13_0());
                          
                    }
                    otherlv_24=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSLA624); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_24, grammarAccess.getSLAAccess().getLeftCurlyBracketKeyword_13_1());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:366:1: (otherlv_25= 'general-security-terms' ( (lv_dataSecProtClause_26_0= RULE_STRING ) ) )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==22) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:366:3: otherlv_25= 'general-security-terms' ( (lv_dataSecProtClause_26_0= RULE_STRING ) )
                            {
                            otherlv_25=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleSLA637); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_25, grammarAccess.getSLAAccess().getGeneralSecurityTermsKeyword_13_2_0());
                                  
                            }
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:370:1: ( (lv_dataSecProtClause_26_0= RULE_STRING ) )
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:371:1: (lv_dataSecProtClause_26_0= RULE_STRING )
                            {
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:371:1: (lv_dataSecProtClause_26_0= RULE_STRING )
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:372:3: lv_dataSecProtClause_26_0= RULE_STRING
                            {
                            lv_dataSecProtClause_26_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA654); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_dataSecProtClause_26_0, grammarAccess.getSLAAccess().getDataSecProtClauseSTRINGTerminalRuleCall_13_2_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSLARule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"dataSecProtClause",
                                      		lv_dataSecProtClause_26_0, 
                                      		"STRING");
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:388:4: (otherlv_27= 'security-requirements' otherlv_28= '{' ( (lv_securityRequirements_29_0= ruleSecurityRequirement ) )* otherlv_30= '}' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:388:6: otherlv_27= 'security-requirements' otherlv_28= '{' ( (lv_securityRequirements_29_0= ruleSecurityRequirement ) )* otherlv_30= '}'
                    {
                    otherlv_27=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleSLA674); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_27, grammarAccess.getSLAAccess().getSecurityRequirementsKeyword_13_3_0());
                          
                    }
                    otherlv_28=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSLA686); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_28, grammarAccess.getSLAAccess().getLeftCurlyBracketKeyword_13_3_1());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:396:1: ( (lv_securityRequirements_29_0= ruleSecurityRequirement ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==63||LA12_0==70||LA12_0==76) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:397:1: (lv_securityRequirements_29_0= ruleSecurityRequirement )
                    	    {
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:397:1: (lv_securityRequirements_29_0= ruleSecurityRequirement )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:398:3: lv_securityRequirements_29_0= ruleSecurityRequirement
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSLAAccess().getSecurityRequirementsSecurityRequirementParserRuleCall_13_3_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleSecurityRequirement_in_ruleSLA707);
                    	    lv_securityRequirements_29_0=ruleSecurityRequirement();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSLARule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"securityRequirements",
                    	              		lv_securityRequirements_29_0, 
                    	              		"SecurityRequirement");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_30=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSLA720); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_30, grammarAccess.getSLAAccess().getRightCurlyBracketKeyword_13_3_3());
                          
                    }

                    }

                    otherlv_31=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSLA733); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_31, grammarAccess.getSLAAccess().getRightCurlyBracketKeyword_13_4());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:422:3: (otherlv_32= 'restrictions' ( (lv_restrictions_33_0= RULE_STRING ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==24) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:422:5: otherlv_32= 'restrictions' ( (lv_restrictions_33_0= RULE_STRING ) )
                    {
                    otherlv_32=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleSLA748); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_32, grammarAccess.getSLAAccess().getRestrictionsKeyword_14_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:426:1: ( (lv_restrictions_33_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:427:1: (lv_restrictions_33_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:427:1: (lv_restrictions_33_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:428:3: lv_restrictions_33_0= RULE_STRING
                    {
                    lv_restrictions_33_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA765); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_restrictions_33_0, grammarAccess.getSLAAccess().getRestrictionsSTRINGTerminalRuleCall_14_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"restrictions",
                              		lv_restrictions_33_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:444:4: ( (lv_priorities_34_0= rulePriorityDeclaration ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==78) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:445:1: (lv_priorities_34_0= rulePriorityDeclaration )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:445:1: (lv_priorities_34_0= rulePriorityDeclaration )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:446:3: lv_priorities_34_0= rulePriorityDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSLAAccess().getPrioritiesPriorityDeclarationParserRuleCall_15_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_rulePriorityDeclaration_in_ruleSLA793);
            	    lv_priorities_34_0=rulePriorityDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSLARule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"priorities",
            	              		lv_priorities_34_0, 
            	              		"PriorityDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:462:3: ( (lv_escalationProcedure_35_0= ruleEscalation ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==79) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:463:1: (lv_escalationProcedure_35_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:463:1: (lv_escalationProcedure_35_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:464:3: lv_escalationProcedure_35_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSLAAccess().getEscalationProcedureEscalationParserRuleCall_16_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleSLA815);
                    lv_escalationProcedure_35_0=ruleEscalation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSLARule());
                      	        }
                             		set(
                             			current, 
                             			"escalationProcedure",
                              		lv_escalationProcedure_35_0, 
                              		"Escalation");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:502:4: ( (lv_parties_38_0= ruleParty ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=83 && LA18_0<=85)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:503:1: (lv_parties_38_0= ruleParty )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:503:1: (lv_parties_38_0= ruleParty )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:504:3: lv_parties_38_0= ruleParty
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSLAAccess().getPartiesPartyParserRuleCall_18_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleParty_in_ruleSLA874);
            	    lv_parties_38_0=ruleParty();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSLARule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"parties",
            	              		lv_parties_38_0, 
            	              		"Party");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:564:4: (otherlv_43= 'effort-accounting' ( (lv_effortAccounting_44_0= RULE_STRING ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==28) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:564:6: otherlv_43= 'effort-accounting' ( (lv_effortAccounting_44_0= RULE_STRING ) )
                    {
                    otherlv_43=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleSLA962); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_43, grammarAccess.getSLAAccess().getEffortAccountingKeyword_21_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:568:1: ( (lv_effortAccounting_44_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:569:1: (lv_effortAccounting_44_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:569:1: (lv_effortAccounting_44_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:570:3: lv_effortAccounting_44_0= RULE_STRING
                    {
                    lv_effortAccounting_44_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA979); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_effortAccounting_44_0, grammarAccess.getSLAAccess().getEffortAccountingSTRINGTerminalRuleCall_21_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"effortAccounting",
                              		lv_effortAccounting_44_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:586:4: ( (lv_reports_45_0= ruleReport ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==92) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:587:1: (lv_reports_45_0= ruleReport )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:587:1: (lv_reports_45_0= ruleReport )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:588:3: lv_reports_45_0= ruleReport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSLAAccess().getReportsReportParserRuleCall_22_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleReport_in_ruleSLA1007);
            	    lv_reports_45_0=ruleReport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSLARule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"reports",
            	              		lv_reports_45_0, 
            	              		"Report");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:604:3: (otherlv_46= 'contact-info' otherlv_47= '{' (otherlv_48= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_50= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_52= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_54= 'subscriptions' otherlv_55= '{' ( ( ruleQualifiedName ) )* otherlv_57= '}' )? )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==29) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:604:5: otherlv_46= 'contact-info' otherlv_47= '{' (otherlv_48= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_50= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_52= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_54= 'subscriptions' otherlv_55= '{' ( ( ruleQualifiedName ) )* otherlv_57= '}' )?
                    {
                    otherlv_46=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleSLA1021); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_46, grammarAccess.getSLAAccess().getContactInfoKeyword_23_0());
                          
                    }
                    otherlv_47=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSLA1033); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_47, grammarAccess.getSLAAccess().getLeftCurlyBracketKeyword_23_1());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:612:1: (otherlv_48= 'owner' ( ( ruleQualifiedName ) ) )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==30) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:612:3: otherlv_48= 'owner' ( ( ruleQualifiedName ) )
                            {
                            otherlv_48=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleSLA1046); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_48, grammarAccess.getSLAAccess().getOwnerKeyword_23_2_0());
                                  
                            }
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:616:1: ( ( ruleQualifiedName ) )
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:617:1: ( ruleQualifiedName )
                            {
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:617:1: ( ruleQualifiedName )
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:618:3: ruleQualifiedName
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
                               
                              	        newCompositeNode(grammarAccess.getSLAAccess().getOwnerUserCrossReference_23_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSLA1073);
                            ruleQualifiedName();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:634:4: (otherlv_50= 'responsible' ( ( ruleQualifiedName ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==31) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:634:6: otherlv_50= 'responsible' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_50=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleSLA1088); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_50, grammarAccess.getSLAAccess().getResponsibleKeyword_23_3_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:638:1: ( ( ruleQualifiedName ) )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:639:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:639:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:640:3: ruleQualifiedName
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
                    	       
                    	      	        newCompositeNode(grammarAccess.getSLAAccess().getResponsibleUserCrossReference_23_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSLA1115);
                    	    ruleQualifiedName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:656:4: (otherlv_52= 'budgeting' ( ( ruleQualifiedName ) ) )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==32) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:656:6: otherlv_52= 'budgeting' ( ( ruleQualifiedName ) )
                            {
                            otherlv_52=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleSLA1130); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_52, grammarAccess.getSLAAccess().getBudgetingKeyword_23_4_0());
                                  
                            }
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:660:1: ( ( ruleQualifiedName ) )
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:661:1: ( ruleQualifiedName )
                            {
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:661:1: ( ruleQualifiedName )
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:662:3: ruleQualifiedName
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
                               
                              	        newCompositeNode(grammarAccess.getSLAAccess().getBudgetingUserCrossReference_23_4_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSLA1157);
                            ruleQualifiedName();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:678:4: (otherlv_54= 'subscriptions' otherlv_55= '{' ( ( ruleQualifiedName ) )* otherlv_57= '}' )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==33) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:678:6: otherlv_54= 'subscriptions' otherlv_55= '{' ( ( ruleQualifiedName ) )* otherlv_57= '}'
                            {
                            otherlv_54=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleSLA1172); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_54, grammarAccess.getSLAAccess().getSubscriptionsKeyword_23_5_0());
                                  
                            }
                            otherlv_55=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSLA1184); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_55, grammarAccess.getSLAAccess().getLeftCurlyBracketKeyword_23_5_1());
                                  
                            }
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:686:1: ( ( ruleQualifiedName ) )*
                            loop26:
                            do {
                                int alt26=2;
                                int LA26_0 = input.LA(1);

                                if ( (LA26_0==RULE_ID) ) {
                                    alt26=1;
                                }


                                switch (alt26) {
                            	case 1 :
                            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:687:1: ( ruleQualifiedName )
                            	    {
                            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:687:1: ( ruleQualifiedName )
                            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:688:3: ruleQualifiedName
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
                            	       
                            	      	        newCompositeNode(grammarAccess.getSLAAccess().getSubscriptionsUserCrossReference_23_5_2_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSLA1211);
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
                            	    break loop26;
                                }
                            } while (true);

                            otherlv_57=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSLA1224); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_57, grammarAccess.getSLAAccess().getRightCurlyBracketKeyword_23_5_3());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:708:5: (otherlv_58= 'tags' ( (otherlv_59= RULE_ID ) )+ )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==34) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:708:7: otherlv_58= 'tags' ( (otherlv_59= RULE_ID ) )+
            	    {
            	    otherlv_58=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleSLA1241); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_58, grammarAccess.getSLAAccess().getTagsKeyword_24_0());
            	          
            	    }
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:712:1: ( (otherlv_59= RULE_ID ) )+
            	    int cnt29=0;
            	    loop29:
            	    do {
            	        int alt29=2;
            	        int LA29_0 = input.LA(1);

            	        if ( (LA29_0==RULE_ID) ) {
            	            alt29=1;
            	        }


            	        switch (alt29) {
            	    	case 1 :
            	    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:713:1: (otherlv_59= RULE_ID )
            	    	    {
            	    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:713:1: (otherlv_59= RULE_ID )
            	    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:714:3: otherlv_59= RULE_ID
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      		  /* */ 
            	    	      		
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      			if (current==null) {
            	    	      	            current = createModelElement(grammarAccess.getSLARule());
            	    	      	        }
            	    	              
            	    	    }
            	    	    otherlv_59=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSLA1265); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      		newLeafNode(otherlv_59, grammarAccess.getSLAAccess().getTagsTagCrossReference_24_1_0()); 
            	    	      	
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt29 >= 1 ) break loop29;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(29, input);
            	                throw eee;
            	        }
            	        cnt29++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            otherlv_60=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSLA1280); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_60, grammarAccess.getSLAAccess().getRightCurlyBracketKeyword_25());
                  
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:740:1: entryRuleCost returns [EObject current=null] : iv_ruleCost= ruleCost EOF ;
    public final EObject entryRuleCost() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCost = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:741:2: (iv_ruleCost= ruleCost EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:742:2: iv_ruleCost= ruleCost EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCostRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCost_in_entryRuleCost1316);
            iv_ruleCost=ruleCost();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCost; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCost1326); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:749:1: ruleCost returns [EObject current=null] : (otherlv_0= 'costs' otherlv_1= '{' otherlv_2= 'amount' ( (lv_costsAmount_3_0= RULE_STRING ) ) otherlv_4= 'billed-per-unit' ( (lv_billedUnit_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' ) ;
    public final EObject ruleCost() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_costsAmount_3_0=null;
        Token otherlv_4=null;
        Token lv_billedUnit_5_0=null;
        Token otherlv_7=null;
        Token lv_penalty_8_0=null;
        Token otherlv_9=null;
        EObject lv_escalation_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:752:28: ( (otherlv_0= 'costs' otherlv_1= '{' otherlv_2= 'amount' ( (lv_costsAmount_3_0= RULE_STRING ) ) otherlv_4= 'billed-per-unit' ( (lv_billedUnit_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:753:1: (otherlv_0= 'costs' otherlv_1= '{' otherlv_2= 'amount' ( (lv_costsAmount_3_0= RULE_STRING ) ) otherlv_4= 'billed-per-unit' ( (lv_billedUnit_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:753:1: (otherlv_0= 'costs' otherlv_1= '{' otherlv_2= 'amount' ( (lv_costsAmount_3_0= RULE_STRING ) ) otherlv_4= 'billed-per-unit' ( (lv_billedUnit_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:753:3: otherlv_0= 'costs' otherlv_1= '{' otherlv_2= 'amount' ( (lv_costsAmount_3_0= RULE_STRING ) ) otherlv_4= 'billed-per-unit' ( (lv_billedUnit_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleCost1363); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getCostAccess().getCostsKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleCost1375); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCostAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleCost1387); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getCostAccess().getAmountKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:765:1: ( (lv_costsAmount_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:766:1: (lv_costsAmount_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:766:1: (lv_costsAmount_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:767:3: lv_costsAmount_3_0= RULE_STRING
            {
            lv_costsAmount_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCost1404); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleCost1421); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getCostAccess().getBilledPerUnitKeyword_4());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:787:1: ( (lv_billedUnit_5_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:788:1: (lv_billedUnit_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:788:1: (lv_billedUnit_5_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:789:3: lv_billedUnit_5_0= RULE_STRING
            {
            lv_billedUnit_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCost1438); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:805:2: ( (lv_escalation_6_0= ruleEscalation ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==79) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:806:1: (lv_escalation_6_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:806:1: (lv_escalation_6_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:807:3: lv_escalation_6_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCostAccess().getEscalationEscalationParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleCost1464);
                    lv_escalation_6_0=ruleEscalation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCostRule());
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:823:3: (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==38) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:823:5: otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleCost1478); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getCostAccess().getPenaltyKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:827:1: ( (lv_penalty_8_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:828:1: (lv_penalty_8_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:828:1: (lv_penalty_8_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:829:3: lv_penalty_8_0= RULE_STRING
                    {
                    lv_penalty_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCost1495); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_penalty_8_0, grammarAccess.getCostAccess().getPenaltySTRINGTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getCostRule());
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

            otherlv_9=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleCost1514); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getCostAccess().getRightCurlyBracketKeyword_8());
                  
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:857:1: entryRuleServiceQualityProperty returns [EObject current=null] : iv_ruleServiceQualityProperty= ruleServiceQualityProperty EOF ;
    public final EObject entryRuleServiceQualityProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceQualityProperty = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:858:2: (iv_ruleServiceQualityProperty= ruleServiceQualityProperty EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:859:2: iv_ruleServiceQualityProperty= ruleServiceQualityProperty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getServiceQualityPropertyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceQualityProperty_in_entryRuleServiceQualityProperty1550);
            iv_ruleServiceQualityProperty=ruleServiceQualityProperty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleServiceQualityProperty; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleServiceQualityProperty1560); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:866:1: ruleServiceQualityProperty returns [EObject current=null] : (this_Availability_0= ruleAvailability | this_Throughput_1= ruleThroughput | this_Latency_2= ruleLatency | this_MaxDownTime_3= ruleMaxDownTime | this_CapacityRequirement_4= ruleCapacityRequirement | this_AccuracyRequirement_5= ruleAccuracyRequirement | this_ReliablityRequirement_6= ruleReliablityRequirement | this_LogRequirement_7= ruleLogRequirement ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:869:28: ( (this_Availability_0= ruleAvailability | this_Throughput_1= ruleThroughput | this_Latency_2= ruleLatency | this_MaxDownTime_3= ruleMaxDownTime | this_CapacityRequirement_4= ruleCapacityRequirement | this_AccuracyRequirement_5= ruleAccuracyRequirement | this_ReliablityRequirement_6= ruleReliablityRequirement | this_LogRequirement_7= ruleLogRequirement ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:870:1: (this_Availability_0= ruleAvailability | this_Throughput_1= ruleThroughput | this_Latency_2= ruleLatency | this_MaxDownTime_3= ruleMaxDownTime | this_CapacityRequirement_4= ruleCapacityRequirement | this_AccuracyRequirement_5= ruleAccuracyRequirement | this_ReliablityRequirement_6= ruleReliablityRequirement | this_LogRequirement_7= ruleLogRequirement )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:870:1: (this_Availability_0= ruleAvailability | this_Throughput_1= ruleThroughput | this_Latency_2= ruleLatency | this_MaxDownTime_3= ruleMaxDownTime | this_CapacityRequirement_4= ruleCapacityRequirement | this_AccuracyRequirement_5= ruleAccuracyRequirement | this_ReliablityRequirement_6= ruleReliablityRequirement | this_LogRequirement_7= ruleLogRequirement )
            int alt33=8;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt33=1;
                }
                break;
            case 43:
                {
                alt33=2;
                }
                break;
            case 45:
                {
                alt33=3;
                }
                break;
            case 48:
                {
                alt33=4;
                }
                break;
            case 50:
                {
                alt33=5;
                }
                break;
            case 56:
                {
                alt33=6;
                }
                break;
            case 54:
                {
                alt33=7;
                }
                break;
            case 58:
                {
                alt33=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:871:2: this_Availability_0= ruleAvailability
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getAvailabilityParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAvailability_in_ruleServiceQualityProperty1610);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:884:2: this_Throughput_1= ruleThroughput
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getThroughputParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleThroughput_in_ruleServiceQualityProperty1640);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:897:2: this_Latency_2= ruleLatency
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getLatencyParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLatency_in_ruleServiceQualityProperty1670);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:910:2: this_MaxDownTime_3= ruleMaxDownTime
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getMaxDownTimeParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMaxDownTime_in_ruleServiceQualityProperty1700);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:923:2: this_CapacityRequirement_4= ruleCapacityRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getCapacityRequirementParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCapacityRequirement_in_ruleServiceQualityProperty1730);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:936:2: this_AccuracyRequirement_5= ruleAccuracyRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getAccuracyRequirementParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAccuracyRequirement_in_ruleServiceQualityProperty1760);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:949:2: this_ReliablityRequirement_6= ruleReliablityRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getReliablityRequirementParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleReliablityRequirement_in_ruleServiceQualityProperty1790);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:962:2: this_LogRequirement_7= ruleLogRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getLogRequirementParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLogRequirement_in_ruleServiceQualityProperty1820);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:981:1: entryRuleAvailability returns [EObject current=null] : iv_ruleAvailability= ruleAvailability EOF ;
    public final EObject entryRuleAvailability() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAvailability = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:982:2: (iv_ruleAvailability= ruleAvailability EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:983:2: iv_ruleAvailability= ruleAvailability EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAvailabilityRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAvailability_in_entryRuleAvailability1855);
            iv_ruleAvailability=ruleAvailability();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAvailability; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAvailability1865); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:990:1: ruleAvailability returns [EObject current=null] : (otherlv_0= 'availability' otherlv_1= '{' otherlv_2= 'availability' ( (lv_availability_3_0= RULE_STRING ) ) (otherlv_4= 'mean-time-between-failure' ( (lv_mtbf_5_0= RULE_STRING ) ) )? (otherlv_6= 'mean-time-to-repair' ( (lv_mttr_7_0= RULE_STRING ) ) ( (lv_mttrPercentile_8_0= rulePercentile ) )? )? (otherlv_9= 'regular-down-times' ( (lv_regularDownTimes_10_0= RULE_STRING ) ) )? otherlv_11= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:993:28: ( (otherlv_0= 'availability' otherlv_1= '{' otherlv_2= 'availability' ( (lv_availability_3_0= RULE_STRING ) ) (otherlv_4= 'mean-time-between-failure' ( (lv_mtbf_5_0= RULE_STRING ) ) )? (otherlv_6= 'mean-time-to-repair' ( (lv_mttr_7_0= RULE_STRING ) ) ( (lv_mttrPercentile_8_0= rulePercentile ) )? )? (otherlv_9= 'regular-down-times' ( (lv_regularDownTimes_10_0= RULE_STRING ) ) )? otherlv_11= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:994:1: (otherlv_0= 'availability' otherlv_1= '{' otherlv_2= 'availability' ( (lv_availability_3_0= RULE_STRING ) ) (otherlv_4= 'mean-time-between-failure' ( (lv_mtbf_5_0= RULE_STRING ) ) )? (otherlv_6= 'mean-time-to-repair' ( (lv_mttr_7_0= RULE_STRING ) ) ( (lv_mttrPercentile_8_0= rulePercentile ) )? )? (otherlv_9= 'regular-down-times' ( (lv_regularDownTimes_10_0= RULE_STRING ) ) )? otherlv_11= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:994:1: (otherlv_0= 'availability' otherlv_1= '{' otherlv_2= 'availability' ( (lv_availability_3_0= RULE_STRING ) ) (otherlv_4= 'mean-time-between-failure' ( (lv_mtbf_5_0= RULE_STRING ) ) )? (otherlv_6= 'mean-time-to-repair' ( (lv_mttr_7_0= RULE_STRING ) ) ( (lv_mttrPercentile_8_0= rulePercentile ) )? )? (otherlv_9= 'regular-down-times' ( (lv_regularDownTimes_10_0= RULE_STRING ) ) )? otherlv_11= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:994:3: otherlv_0= 'availability' otherlv_1= '{' otherlv_2= 'availability' ( (lv_availability_3_0= RULE_STRING ) ) (otherlv_4= 'mean-time-between-failure' ( (lv_mtbf_5_0= RULE_STRING ) ) )? (otherlv_6= 'mean-time-to-repair' ( (lv_mttr_7_0= RULE_STRING ) ) ( (lv_mttrPercentile_8_0= rulePercentile ) )? )? (otherlv_9= 'regular-down-times' ( (lv_regularDownTimes_10_0= RULE_STRING ) ) )? otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleAvailability1902); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAvailabilityAccess().getAvailabilityKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAvailability1914); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAvailabilityAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleAvailability1926); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAvailabilityAccess().getAvailabilityKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1006:1: ( (lv_availability_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1007:1: (lv_availability_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1007:1: (lv_availability_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1008:3: lv_availability_3_0= RULE_STRING
            {
            lv_availability_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAvailability1943); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1024:2: (otherlv_4= 'mean-time-between-failure' ( (lv_mtbf_5_0= RULE_STRING ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==40) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1024:4: otherlv_4= 'mean-time-between-failure' ( (lv_mtbf_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleAvailability1961); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getAvailabilityAccess().getMeanTimeBetweenFailureKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1028:1: ( (lv_mtbf_5_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1029:1: (lv_mtbf_5_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1029:1: (lv_mtbf_5_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1030:3: lv_mtbf_5_0= RULE_STRING
                    {
                    lv_mtbf_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAvailability1978); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1046:4: (otherlv_6= 'mean-time-to-repair' ( (lv_mttr_7_0= RULE_STRING ) ) ( (lv_mttrPercentile_8_0= rulePercentile ) )? )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==41) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1046:6: otherlv_6= 'mean-time-to-repair' ( (lv_mttr_7_0= RULE_STRING ) ) ( (lv_mttrPercentile_8_0= rulePercentile ) )?
                    {
                    otherlv_6=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleAvailability1998); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getAvailabilityAccess().getMeanTimeToRepairKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1050:1: ( (lv_mttr_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1051:1: (lv_mttr_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1051:1: (lv_mttr_7_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1052:3: lv_mttr_7_0= RULE_STRING
                    {
                    lv_mttr_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAvailability2015); if (state.failed) return current;
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

                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1068:2: ( (lv_mttrPercentile_8_0= rulePercentile ) )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==RULE_INT) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1069:1: (lv_mttrPercentile_8_0= rulePercentile )
                            {
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1069:1: (lv_mttrPercentile_8_0= rulePercentile )
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1070:3: lv_mttrPercentile_8_0= rulePercentile
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAvailabilityAccess().getMttrPercentilePercentileParserRuleCall_5_2_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_rulePercentile_in_ruleAvailability2041);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1086:5: (otherlv_9= 'regular-down-times' ( (lv_regularDownTimes_10_0= RULE_STRING ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==42) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1086:7: otherlv_9= 'regular-down-times' ( (lv_regularDownTimes_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleAvailability2057); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getAvailabilityAccess().getRegularDownTimesKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1090:1: ( (lv_regularDownTimes_10_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1091:1: (lv_regularDownTimes_10_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1091:1: (lv_regularDownTimes_10_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1092:3: lv_regularDownTimes_10_0= RULE_STRING
                    {
                    lv_regularDownTimes_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAvailability2074); if (state.failed) return current;
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

            otherlv_11=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAvailability2093); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1120:1: entryRuleThroughput returns [EObject current=null] : iv_ruleThroughput= ruleThroughput EOF ;
    public final EObject entryRuleThroughput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThroughput = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1121:2: (iv_ruleThroughput= ruleThroughput EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1122:2: iv_ruleThroughput= ruleThroughput EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getThroughputRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleThroughput_in_entryRuleThroughput2129);
            iv_ruleThroughput=ruleThroughput();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleThroughput; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleThroughput2139); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1129:1: ruleThroughput returns [EObject current=null] : (otherlv_0= 'throughput' otherlv_1= '{' otherlv_2= 'throughput' ( (lv_definition_3_0= RULE_STRING ) ) otherlv_4= 'score-to-be-kept' ( (lv_score_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1132:28: ( (otherlv_0= 'throughput' otherlv_1= '{' otherlv_2= 'throughput' ( (lv_definition_3_0= RULE_STRING ) ) otherlv_4= 'score-to-be-kept' ( (lv_score_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1133:1: (otherlv_0= 'throughput' otherlv_1= '{' otherlv_2= 'throughput' ( (lv_definition_3_0= RULE_STRING ) ) otherlv_4= 'score-to-be-kept' ( (lv_score_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1133:1: (otherlv_0= 'throughput' otherlv_1= '{' otherlv_2= 'throughput' ( (lv_definition_3_0= RULE_STRING ) ) otherlv_4= 'score-to-be-kept' ( (lv_score_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1133:3: otherlv_0= 'throughput' otherlv_1= '{' otherlv_2= 'throughput' ( (lv_definition_3_0= RULE_STRING ) ) otherlv_4= 'score-to-be-kept' ( (lv_score_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleThroughput2176); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getThroughputAccess().getThroughputKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleThroughput2188); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getThroughputAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleThroughput2200); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getThroughputAccess().getThroughputKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1145:1: ( (lv_definition_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1146:1: (lv_definition_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1146:1: (lv_definition_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1147:3: lv_definition_3_0= RULE_STRING
            {
            lv_definition_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleThroughput2217); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleThroughput2234); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getThroughputAccess().getScoreToBeKeptKeyword_4());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1167:1: ( (lv_score_5_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1168:1: (lv_score_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1168:1: (lv_score_5_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1169:3: lv_score_5_0= RULE_STRING
            {
            lv_score_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleThroughput2251); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1185:2: ( (lv_escalation_6_0= ruleEscalation ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==79) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1186:1: (lv_escalation_6_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1186:1: (lv_escalation_6_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1187:3: lv_escalation_6_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getThroughputAccess().getEscalationEscalationParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleThroughput2277);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1203:3: (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==38) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1203:5: otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleThroughput2291); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getThroughputAccess().getPenaltyKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1207:1: ( (lv_penalty_8_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1208:1: (lv_penalty_8_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1208:1: (lv_penalty_8_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1209:3: lv_penalty_8_0= RULE_STRING
                    {
                    lv_penalty_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleThroughput2308); if (state.failed) return current;
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

            otherlv_9=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleThroughput2327); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1237:1: entryRuleLatency returns [EObject current=null] : iv_ruleLatency= ruleLatency EOF ;
    public final EObject entryRuleLatency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLatency = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1238:2: (iv_ruleLatency= ruleLatency EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1239:2: iv_ruleLatency= ruleLatency EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLatencyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLatency_in_entryRuleLatency2363);
            iv_ruleLatency=ruleLatency();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLatency; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLatency2373); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1246:1: ruleLatency returns [EObject current=null] : (otherlv_0= 'latency' otherlv_1= '{' otherlv_2= 'latency' ( (lv_latency_3_0= 'STRING' ) ) otherlv_4= 'percentile' ( (lv_percentile_5_0= rulePercentile ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1249:28: ( (otherlv_0= 'latency' otherlv_1= '{' otherlv_2= 'latency' ( (lv_latency_3_0= 'STRING' ) ) otherlv_4= 'percentile' ( (lv_percentile_5_0= rulePercentile ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1250:1: (otherlv_0= 'latency' otherlv_1= '{' otherlv_2= 'latency' ( (lv_latency_3_0= 'STRING' ) ) otherlv_4= 'percentile' ( (lv_percentile_5_0= rulePercentile ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1250:1: (otherlv_0= 'latency' otherlv_1= '{' otherlv_2= 'latency' ( (lv_latency_3_0= 'STRING' ) ) otherlv_4= 'percentile' ( (lv_percentile_5_0= rulePercentile ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1250:3: otherlv_0= 'latency' otherlv_1= '{' otherlv_2= 'latency' ( (lv_latency_3_0= 'STRING' ) ) otherlv_4= 'percentile' ( (lv_percentile_5_0= rulePercentile ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleLatency2410); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLatencyAccess().getLatencyKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleLatency2422); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLatencyAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleLatency2434); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getLatencyAccess().getLatencyKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1262:1: ( (lv_latency_3_0= 'STRING' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1263:1: (lv_latency_3_0= 'STRING' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1263:1: (lv_latency_3_0= 'STRING' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1264:3: lv_latency_3_0= 'STRING'
            {
            lv_latency_3_0=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleLatency2452); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleLatency2477); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLatencyAccess().getPercentileKeyword_4());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1281:1: ( (lv_percentile_5_0= rulePercentile ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1282:1: (lv_percentile_5_0= rulePercentile )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1282:1: (lv_percentile_5_0= rulePercentile )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1283:3: lv_percentile_5_0= rulePercentile
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLatencyAccess().getPercentilePercentileParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePercentile_in_ruleLatency2498);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1299:2: ( (lv_escalation_6_0= ruleEscalation ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==79) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1300:1: (lv_escalation_6_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1300:1: (lv_escalation_6_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1301:3: lv_escalation_6_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLatencyAccess().getEscalationEscalationParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleLatency2519);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1317:3: (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==38) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1317:5: otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleLatency2533); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getLatencyAccess().getPenaltyKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1321:1: ( (lv_penalty_8_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1322:1: (lv_penalty_8_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1322:1: (lv_penalty_8_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1323:3: lv_penalty_8_0= RULE_STRING
                    {
                    lv_penalty_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleLatency2550); if (state.failed) return current;
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

            otherlv_9=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleLatency2569); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1351:1: entryRuleMaxDownTime returns [EObject current=null] : iv_ruleMaxDownTime= ruleMaxDownTime EOF ;
    public final EObject entryRuleMaxDownTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxDownTime = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1352:2: (iv_ruleMaxDownTime= ruleMaxDownTime EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1353:2: iv_ruleMaxDownTime= ruleMaxDownTime EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMaxDownTimeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMaxDownTime_in_entryRuleMaxDownTime2605);
            iv_ruleMaxDownTime=ruleMaxDownTime();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMaxDownTime; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxDownTime2615); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1360:1: ruleMaxDownTime returns [EObject current=null] : (otherlv_0= 'max-downtime' otherlv_1= '{' otherlv_2= 'duration' ( (lv_definition_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1363:28: ( (otherlv_0= 'max-downtime' otherlv_1= '{' otherlv_2= 'duration' ( (lv_definition_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1364:1: (otherlv_0= 'max-downtime' otherlv_1= '{' otherlv_2= 'duration' ( (lv_definition_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1364:1: (otherlv_0= 'max-downtime' otherlv_1= '{' otherlv_2= 'duration' ( (lv_definition_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1364:3: otherlv_0= 'max-downtime' otherlv_1= '{' otherlv_2= 'duration' ( (lv_definition_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleMaxDownTime2652); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMaxDownTimeAccess().getMaxDowntimeKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleMaxDownTime2664); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMaxDownTimeAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleMaxDownTime2676); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMaxDownTimeAccess().getDurationKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1376:1: ( (lv_definition_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1377:1: (lv_definition_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1377:1: (lv_definition_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1378:3: lv_definition_3_0= RULE_STRING
            {
            lv_definition_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMaxDownTime2693); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1394:2: ( (lv_escalation_4_0= ruleEscalation ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==79) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1395:1: (lv_escalation_4_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1395:1: (lv_escalation_4_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1396:3: lv_escalation_4_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMaxDownTimeAccess().getEscalationEscalationParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleMaxDownTime2719);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1412:3: (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==38) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1412:5: otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleMaxDownTime2733); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getMaxDownTimeAccess().getPenaltyKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1416:1: ( (lv_penalty_6_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1417:1: (lv_penalty_6_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1417:1: (lv_penalty_6_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1418:3: lv_penalty_6_0= RULE_STRING
                    {
                    lv_penalty_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMaxDownTime2750); if (state.failed) return current;
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

            otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleMaxDownTime2769); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1446:1: entryRuleCapacityRequirement returns [EObject current=null] : iv_ruleCapacityRequirement= ruleCapacityRequirement EOF ;
    public final EObject entryRuleCapacityRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCapacityRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1447:2: (iv_ruleCapacityRequirement= ruleCapacityRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1448:2: iv_ruleCapacityRequirement= ruleCapacityRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCapacityRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCapacityRequirement_in_entryRuleCapacityRequirement2805);
            iv_ruleCapacityRequirement=ruleCapacityRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCapacityRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCapacityRequirement2815); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1455:1: ruleCapacityRequirement returns [EObject current=null] : (otherlv_0= 'capacity' otherlv_1= '{' () (otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) ) )? (otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) ) )? ( (lv_escalation_9_0= ruleEscalation ) )? (otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) ) )? otherlv_12= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1458:28: ( (otherlv_0= 'capacity' otherlv_1= '{' () (otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) ) )? (otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) ) )? ( (lv_escalation_9_0= ruleEscalation ) )? (otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) ) )? otherlv_12= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1459:1: (otherlv_0= 'capacity' otherlv_1= '{' () (otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) ) )? (otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) ) )? ( (lv_escalation_9_0= ruleEscalation ) )? (otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) ) )? otherlv_12= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1459:1: (otherlv_0= 'capacity' otherlv_1= '{' () (otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) ) )? (otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) ) )? ( (lv_escalation_9_0= ruleEscalation ) )? (otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) ) )? otherlv_12= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1459:3: otherlv_0= 'capacity' otherlv_1= '{' () (otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) ) )? (otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) ) )? ( (lv_escalation_9_0= ruleEscalation ) )? (otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleCapacityRequirement2852); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getCapacityRequirementAccess().getCapacityKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleCapacityRequirement2864); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCapacityRequirementAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1467:1: ()
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1468:2: 
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1476:2: (otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==51) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1476:4: otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleCapacityRequirement2889); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getCapacityRequirementAccess().getNumOfRequestsKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1480:1: ( (lv_requestNum_4_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1481:1: (lv_requestNum_4_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1481:1: (lv_requestNum_4_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1482:3: lv_requestNum_4_0= RULE_STRING
                    {
                    lv_requestNum_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCapacityRequirement2906); if (state.failed) return current;
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

                    otherlv_5=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleCapacityRequirement2923); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getCapacityRequirementAccess().getPerKeyword_3_2());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1502:1: ( (lv_timeUnit_6_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1503:1: (lv_timeUnit_6_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1503:1: (lv_timeUnit_6_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1504:3: lv_timeUnit_6_0= RULE_STRING
                    {
                    lv_timeUnit_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCapacityRequirement2940); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1520:4: (otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==53) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1520:6: otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleCapacityRequirement2960); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getCapacityRequirementAccess().getMessageSizeKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1524:1: ( (lv_messageSize_8_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1525:1: (lv_messageSize_8_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1525:1: (lv_messageSize_8_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1526:3: lv_messageSize_8_0= RULE_STRING
                    {
                    lv_messageSize_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCapacityRequirement2977); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1542:4: ( (lv_escalation_9_0= ruleEscalation ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==79) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1543:1: (lv_escalation_9_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1543:1: (lv_escalation_9_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1544:3: lv_escalation_9_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCapacityRequirementAccess().getEscalationEscalationParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleCapacityRequirement3005);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1560:3: (otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==38) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1560:5: otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) )
                    {
                    otherlv_10=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleCapacityRequirement3019); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getCapacityRequirementAccess().getPenaltyKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1564:1: ( (lv_penalty_11_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1565:1: (lv_penalty_11_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1565:1: (lv_penalty_11_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1566:3: lv_penalty_11_0= RULE_STRING
                    {
                    lv_penalty_11_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCapacityRequirement3036); if (state.failed) return current;
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

            otherlv_12=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleCapacityRequirement3055); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1594:1: entryRuleReliablityRequirement returns [EObject current=null] : iv_ruleReliablityRequirement= ruleReliablityRequirement EOF ;
    public final EObject entryRuleReliablityRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReliablityRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1595:2: (iv_ruleReliablityRequirement= ruleReliablityRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1596:2: iv_ruleReliablityRequirement= ruleReliablityRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReliablityRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReliablityRequirement_in_entryRuleReliablityRequirement3091);
            iv_ruleReliablityRequirement=ruleReliablityRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReliablityRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReliablityRequirement3101); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1603:1: ruleReliablityRequirement returns [EObject current=null] : (otherlv_0= 'message-exchange-reliability' otherlv_1= '{' ( (lv_reliability_2_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_3_0= 'in-order-delivery' ) )? otherlv_4= '}' ) ;
    public final EObject ruleReliablityRequirement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_inOrderDelivery_3_0=null;
        Token otherlv_4=null;
        Enumerator lv_reliability_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1606:28: ( (otherlv_0= 'message-exchange-reliability' otherlv_1= '{' ( (lv_reliability_2_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_3_0= 'in-order-delivery' ) )? otherlv_4= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1607:1: (otherlv_0= 'message-exchange-reliability' otherlv_1= '{' ( (lv_reliability_2_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_3_0= 'in-order-delivery' ) )? otherlv_4= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1607:1: (otherlv_0= 'message-exchange-reliability' otherlv_1= '{' ( (lv_reliability_2_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_3_0= 'in-order-delivery' ) )? otherlv_4= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1607:3: otherlv_0= 'message-exchange-reliability' otherlv_1= '{' ( (lv_reliability_2_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_3_0= 'in-order-delivery' ) )? otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleReliablityRequirement3138); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getReliablityRequirementAccess().getMessageExchangeReliabilityKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleReliablityRequirement3150); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getReliablityRequirementAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1615:1: ( (lv_reliability_2_0= ruleReliablilityKind ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1616:1: (lv_reliability_2_0= ruleReliablilityKind )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1616:1: (lv_reliability_2_0= ruleReliablilityKind )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1617:3: lv_reliability_2_0= ruleReliablilityKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReliablityRequirementAccess().getReliabilityReliablilityKindEnumRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleReliablilityKind_in_ruleReliablityRequirement3171);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1633:2: ( (lv_inOrderDelivery_3_0= 'in-order-delivery' ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==55) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1634:1: (lv_inOrderDelivery_3_0= 'in-order-delivery' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1634:1: (lv_inOrderDelivery_3_0= 'in-order-delivery' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1635:3: lv_inOrderDelivery_3_0= 'in-order-delivery'
                    {
                    lv_inOrderDelivery_3_0=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleReliablityRequirement3189); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleReliablityRequirement3215); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1660:1: entryRuleAccuracyRequirement returns [EObject current=null] : iv_ruleAccuracyRequirement= ruleAccuracyRequirement EOF ;
    public final EObject entryRuleAccuracyRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccuracyRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1661:2: (iv_ruleAccuracyRequirement= ruleAccuracyRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1662:2: iv_ruleAccuracyRequirement= ruleAccuracyRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAccuracyRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAccuracyRequirement_in_entryRuleAccuracyRequirement3251);
            iv_ruleAccuracyRequirement=ruleAccuracyRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAccuracyRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAccuracyRequirement3261); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1669:1: ruleAccuracyRequirement returns [EObject current=null] : (otherlv_0= 'accuracy' otherlv_1= '{' otherlv_2= 'max-error-rate' ( (lv_maxErrorRate_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1672:28: ( (otherlv_0= 'accuracy' otherlv_1= '{' otherlv_2= 'max-error-rate' ( (lv_maxErrorRate_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1673:1: (otherlv_0= 'accuracy' otherlv_1= '{' otherlv_2= 'max-error-rate' ( (lv_maxErrorRate_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1673:1: (otherlv_0= 'accuracy' otherlv_1= '{' otherlv_2= 'max-error-rate' ( (lv_maxErrorRate_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1673:3: otherlv_0= 'accuracy' otherlv_1= '{' otherlv_2= 'max-error-rate' ( (lv_maxErrorRate_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleAccuracyRequirement3298); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAccuracyRequirementAccess().getAccuracyKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAccuracyRequirement3310); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAccuracyRequirementAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleAccuracyRequirement3322); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAccuracyRequirementAccess().getMaxErrorRateKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1685:1: ( (lv_maxErrorRate_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1686:1: (lv_maxErrorRate_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1686:1: (lv_maxErrorRate_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1687:3: lv_maxErrorRate_3_0= RULE_STRING
            {
            lv_maxErrorRate_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAccuracyRequirement3339); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1703:2: ( (lv_escalation_4_0= ruleEscalation ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==79) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1704:1: (lv_escalation_4_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1704:1: (lv_escalation_4_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1705:3: lv_escalation_4_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAccuracyRequirementAccess().getEscalationEscalationParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleAccuracyRequirement3365);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1721:3: (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==38) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1721:5: otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleAccuracyRequirement3379); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getAccuracyRequirementAccess().getPenaltyKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1725:1: ( (lv_penalty_6_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1726:1: (lv_penalty_6_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1726:1: (lv_penalty_6_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1727:3: lv_penalty_6_0= RULE_STRING
                    {
                    lv_penalty_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAccuracyRequirement3396); if (state.failed) return current;
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

            otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAccuracyRequirement3415); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1755:1: entryRuleLogRequirement returns [EObject current=null] : iv_ruleLogRequirement= ruleLogRequirement EOF ;
    public final EObject entryRuleLogRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1756:2: (iv_ruleLogRequirement= ruleLogRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1757:2: iv_ruleLogRequirement= ruleLogRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLogRequirement_in_entryRuleLogRequirement3451);
            iv_ruleLogRequirement=ruleLogRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLogRequirement3461); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1764:1: ruleLogRequirement returns [EObject current=null] : (otherlv_0= 'logging' otherlv_1= '{' otherlv_2= 'message-log-level' ( (lv_logLevel_3_0= ruleLogRequirementKind ) ) otherlv_4= 'additional-logging-requirements' ( (lv_additionalLoggingRequirement_5_0= RULE_STRING ) ) ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1767:28: ( (otherlv_0= 'logging' otherlv_1= '{' otherlv_2= 'message-log-level' ( (lv_logLevel_3_0= ruleLogRequirementKind ) ) otherlv_4= 'additional-logging-requirements' ( (lv_additionalLoggingRequirement_5_0= RULE_STRING ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1768:1: (otherlv_0= 'logging' otherlv_1= '{' otherlv_2= 'message-log-level' ( (lv_logLevel_3_0= ruleLogRequirementKind ) ) otherlv_4= 'additional-logging-requirements' ( (lv_additionalLoggingRequirement_5_0= RULE_STRING ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1768:1: (otherlv_0= 'logging' otherlv_1= '{' otherlv_2= 'message-log-level' ( (lv_logLevel_3_0= ruleLogRequirementKind ) ) otherlv_4= 'additional-logging-requirements' ( (lv_additionalLoggingRequirement_5_0= RULE_STRING ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1768:3: otherlv_0= 'logging' otherlv_1= '{' otherlv_2= 'message-log-level' ( (lv_logLevel_3_0= ruleLogRequirementKind ) ) otherlv_4= 'additional-logging-requirements' ( (lv_additionalLoggingRequirement_5_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleLogRequirement3498); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLogRequirementAccess().getLoggingKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleLogRequirement3510); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLogRequirementAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleLogRequirement3522); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getLogRequirementAccess().getMessageLogLevelKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1780:1: ( (lv_logLevel_3_0= ruleLogRequirementKind ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1781:1: (lv_logLevel_3_0= ruleLogRequirementKind )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1781:1: (lv_logLevel_3_0= ruleLogRequirementKind )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1782:3: lv_logLevel_3_0= ruleLogRequirementKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogRequirementAccess().getLogLevelLogRequirementKindEnumRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLogRequirementKind_in_ruleLogRequirement3543);
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

            otherlv_4=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleLogRequirement3555); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLogRequirementAccess().getAdditionalLoggingRequirementsKeyword_4());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1802:1: ( (lv_additionalLoggingRequirement_5_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1803:1: (lv_additionalLoggingRequirement_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1803:1: (lv_additionalLoggingRequirement_5_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1804:3: lv_additionalLoggingRequirement_5_0= RULE_STRING
            {
            lv_additionalLoggingRequirement_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleLogRequirement3572); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1828:1: entryRulePercentile returns [EObject current=null] : iv_rulePercentile= rulePercentile EOF ;
    public final EObject entryRulePercentile() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePercentile = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1829:2: (iv_rulePercentile= rulePercentile EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1830:2: iv_rulePercentile= rulePercentile EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPercentileRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePercentile_in_entryRulePercentile3613);
            iv_rulePercentile=rulePercentile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePercentile; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePercentile3623); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1837:1: rulePercentile returns [EObject current=null] : ( ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%' ) ;
    public final EObject rulePercentile() throws RecognitionException {
        EObject current = null;

        Token lv_percentile_0_0=null;
        Token otherlv_1=null;
        Token this_INT_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1840:28: ( ( ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1841:1: ( ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1841:1: ( ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1841:2: ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%'
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1841:2: ( (lv_percentile_0_0= RULE_INT ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1842:1: (lv_percentile_0_0= RULE_INT )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1842:1: (lv_percentile_0_0= RULE_INT )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1843:3: lv_percentile_0_0= RULE_INT
            {
            lv_percentile_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rulePercentile3665); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1859:2: (otherlv_1= '.' this_INT_2= RULE_INT )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==61) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1859:4: otherlv_1= '.' this_INT_2= RULE_INT
            	    {
            	    otherlv_1=(Token)match(input,61,FollowSets000.FOLLOW_61_in_rulePercentile3683); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPercentileAccess().getFullStopKeyword_1_0());
            	          
            	    }
            	    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rulePercentile3694); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_INT_2, grammarAccess.getPercentileAccess().getINTTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

            otherlv_3=(Token)match(input,62,FollowSets000.FOLLOW_62_in_rulePercentile3707); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1879:1: entryRuleSecurityRequirement returns [EObject current=null] : iv_ruleSecurityRequirement= ruleSecurityRequirement EOF ;
    public final EObject entryRuleSecurityRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecurityRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1880:2: (iv_ruleSecurityRequirement= ruleSecurityRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1881:2: iv_ruleSecurityRequirement= ruleSecurityRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSecurityRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSecurityRequirement_in_entryRuleSecurityRequirement3743);
            iv_ruleSecurityRequirement=ruleSecurityRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSecurityRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecurityRequirement3753); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1888:1: ruleSecurityRequirement returns [EObject current=null] : (this_AuthenticationRequirement_0= ruleAuthenticationRequirement | this_SigningRequirement_1= ruleSigningRequirement | this_EncryptionRequirement_2= ruleEncryptionRequirement ) ;
    public final EObject ruleSecurityRequirement() throws RecognitionException {
        EObject current = null;

        EObject this_AuthenticationRequirement_0 = null;

        EObject this_SigningRequirement_1 = null;

        EObject this_EncryptionRequirement_2 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1891:28: ( (this_AuthenticationRequirement_0= ruleAuthenticationRequirement | this_SigningRequirement_1= ruleSigningRequirement | this_EncryptionRequirement_2= ruleEncryptionRequirement ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1892:1: (this_AuthenticationRequirement_0= ruleAuthenticationRequirement | this_SigningRequirement_1= ruleSigningRequirement | this_EncryptionRequirement_2= ruleEncryptionRequirement )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1892:1: (this_AuthenticationRequirement_0= ruleAuthenticationRequirement | this_SigningRequirement_1= ruleSigningRequirement | this_EncryptionRequirement_2= ruleEncryptionRequirement )
            int alt52=3;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt52=1;
                }
                break;
            case 70:
                {
                alt52=2;
                }
                break;
            case 76:
                {
                alt52=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1893:2: this_AuthenticationRequirement_0= ruleAuthenticationRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityRequirementAccess().getAuthenticationRequirementParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAuthenticationRequirement_in_ruleSecurityRequirement3803);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1906:2: this_SigningRequirement_1= ruleSigningRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityRequirementAccess().getSigningRequirementParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSigningRequirement_in_ruleSecurityRequirement3833);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1919:2: this_EncryptionRequirement_2= ruleEncryptionRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityRequirementAccess().getEncryptionRequirementParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEncryptionRequirement_in_ruleSecurityRequirement3863);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1938:1: entryRuleAuthenticationRequirement returns [EObject current=null] : iv_ruleAuthenticationRequirement= ruleAuthenticationRequirement EOF ;
    public final EObject entryRuleAuthenticationRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthenticationRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1939:2: (iv_ruleAuthenticationRequirement= ruleAuthenticationRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1940:2: iv_ruleAuthenticationRequirement= ruleAuthenticationRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAuthenticationRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthenticationRequirement_in_entryRuleAuthenticationRequirement3898);
            iv_ruleAuthenticationRequirement=ruleAuthenticationRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAuthenticationRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAuthenticationRequirement3908); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1947:1: ruleAuthenticationRequirement returns [EObject current=null] : ( () otherlv_1= 'authentication-procedure' ( (lv_optional_2_0= 'optional' ) )? otherlv_3= '{' otherlv_4= 'auth-tokens' otherlv_5= '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ otherlv_7= '}' otherlv_8= 'hash-algorithms' otherlv_9= '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* otherlv_11= '}' ( (lv_useNonce_12_0= 'use-nonce' ) )? (otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) ) )? otherlv_15= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1950:28: ( ( () otherlv_1= 'authentication-procedure' ( (lv_optional_2_0= 'optional' ) )? otherlv_3= '{' otherlv_4= 'auth-tokens' otherlv_5= '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ otherlv_7= '}' otherlv_8= 'hash-algorithms' otherlv_9= '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* otherlv_11= '}' ( (lv_useNonce_12_0= 'use-nonce' ) )? (otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) ) )? otherlv_15= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1951:1: ( () otherlv_1= 'authentication-procedure' ( (lv_optional_2_0= 'optional' ) )? otherlv_3= '{' otherlv_4= 'auth-tokens' otherlv_5= '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ otherlv_7= '}' otherlv_8= 'hash-algorithms' otherlv_9= '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* otherlv_11= '}' ( (lv_useNonce_12_0= 'use-nonce' ) )? (otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) ) )? otherlv_15= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1951:1: ( () otherlv_1= 'authentication-procedure' ( (lv_optional_2_0= 'optional' ) )? otherlv_3= '{' otherlv_4= 'auth-tokens' otherlv_5= '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ otherlv_7= '}' otherlv_8= 'hash-algorithms' otherlv_9= '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* otherlv_11= '}' ( (lv_useNonce_12_0= 'use-nonce' ) )? (otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) ) )? otherlv_15= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1951:2: () otherlv_1= 'authentication-procedure' ( (lv_optional_2_0= 'optional' ) )? otherlv_3= '{' otherlv_4= 'auth-tokens' otherlv_5= '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ otherlv_7= '}' otherlv_8= 'hash-algorithms' otherlv_9= '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* otherlv_11= '}' ( (lv_useNonce_12_0= 'use-nonce' ) )? (otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) ) )? otherlv_15= '}'
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1951:2: ()
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1952:2: 
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

            otherlv_1=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleAuthenticationRequirement3957); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAuthenticationRequirementAccess().getAuthenticationProcedureKeyword_1());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1964:1: ( (lv_optional_2_0= 'optional' ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==64) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1965:1: (lv_optional_2_0= 'optional' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1965:1: (lv_optional_2_0= 'optional' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1966:3: lv_optional_2_0= 'optional'
                    {
                    lv_optional_2_0=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleAuthenticationRequirement3975); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAuthenticationRequirement4001); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAuthenticationRequirementAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleAuthenticationRequirement4013); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getAuthenticationRequirementAccess().getAuthTokensKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAuthenticationRequirement4025); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getAuthenticationRequirementAccess().getLeftCurlyBracketKeyword_5());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1991:1: ( (lv_authTokens_6_0= ruleAuthToken ) )+
            int cnt54=0;
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==64||(LA54_0>=126 && LA54_0<=134)) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1992:1: (lv_authTokens_6_0= ruleAuthToken )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1992:1: (lv_authTokens_6_0= ruleAuthToken )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1993:3: lv_authTokens_6_0= ruleAuthToken
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAuthenticationRequirementAccess().getAuthTokensAuthTokenParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAuthToken_in_ruleAuthenticationRequirement4046);
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
            	    if ( cnt54 >= 1 ) break loop54;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(54, input);
                        throw eee;
                }
                cnt54++;
            } while (true);

            otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAuthenticationRequirement4059); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getAuthenticationRequirementAccess().getRightCurlyBracketKeyword_7());
                  
            }
            otherlv_8=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleAuthenticationRequirement4071); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getAuthenticationRequirementAccess().getHashAlgorithmsKeyword_8());
                  
            }
            otherlv_9=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAuthenticationRequirement4083); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getAuthenticationRequirementAccess().getLeftCurlyBracketKeyword_9());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2021:1: ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==64||LA55_0==69||(LA55_0>=107 && LA55_0<=111)) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2022:1: (lv_hashAlgorithms_10_0= ruleHashAlgorithm )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2022:1: (lv_hashAlgorithms_10_0= ruleHashAlgorithm )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2023:3: lv_hashAlgorithms_10_0= ruleHashAlgorithm
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAuthenticationRequirementAccess().getHashAlgorithmsHashAlgorithmParserRuleCall_10_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleHashAlgorithm_in_ruleAuthenticationRequirement4104);
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
            	    break loop55;
                }
            } while (true);

            otherlv_11=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAuthenticationRequirement4117); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getAuthenticationRequirementAccess().getRightCurlyBracketKeyword_11());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2043:1: ( (lv_useNonce_12_0= 'use-nonce' ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==67) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2044:1: (lv_useNonce_12_0= 'use-nonce' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2044:1: (lv_useNonce_12_0= 'use-nonce' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2045:3: lv_useNonce_12_0= 'use-nonce'
                    {
                    lv_useNonce_12_0=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleAuthenticationRequirement4135); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2058:3: (otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==68) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2058:5: otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) )
                    {
                    otherlv_13=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleAuthenticationRequirement4162); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getAuthenticationRequirementAccess().getIssuerKeyword_13_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2062:1: ( (lv_issuer_14_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2063:1: (lv_issuer_14_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2063:1: (lv_issuer_14_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2064:3: lv_issuer_14_0= RULE_STRING
                    {
                    lv_issuer_14_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAuthenticationRequirement4179); if (state.failed) return current;
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

            otherlv_15=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAuthenticationRequirement4198); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2092:1: entryRuleAuthToken returns [EObject current=null] : iv_ruleAuthToken= ruleAuthToken EOF ;
    public final EObject entryRuleAuthToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthToken = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2093:2: (iv_ruleAuthToken= ruleAuthToken EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2094:2: iv_ruleAuthToken= ruleAuthToken EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAuthTokenRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthToken_in_entryRuleAuthToken4234);
            iv_ruleAuthToken=ruleAuthToken();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAuthToken; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAuthToken4244); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2101:1: ruleAuthToken returns [EObject current=null] : ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) ) ;
    public final EObject ruleAuthToken() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Enumerator lv_kind_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2104:28: ( ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2105:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2105:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2105:2: ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2105:2: ( (lv_optional_0_0= 'optional' ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==64) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2106:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2106:1: (lv_optional_0_0= 'optional' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2107:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleAuthToken4287); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2120:3: ( (lv_kind_1_0= ruleAuthTokenKind ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2121:1: (lv_kind_1_0= ruleAuthTokenKind )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2121:1: (lv_kind_1_0= ruleAuthTokenKind )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2122:3: lv_kind_1_0= ruleAuthTokenKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAuthTokenAccess().getKindAuthTokenKindEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthTokenKind_in_ruleAuthToken4322);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2146:1: entryRuleHashAlgorithm returns [EObject current=null] : iv_ruleHashAlgorithm= ruleHashAlgorithm EOF ;
    public final EObject entryRuleHashAlgorithm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHashAlgorithm = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2147:2: (iv_ruleHashAlgorithm= ruleHashAlgorithm EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2148:2: iv_ruleHashAlgorithm= ruleHashAlgorithm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHashAlgorithmRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleHashAlgorithm_in_entryRuleHashAlgorithm4358);
            iv_ruleHashAlgorithm=ruleHashAlgorithm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHashAlgorithm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHashAlgorithm4368); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2155:1: ruleHashAlgorithm returns [EObject current=null] : ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) ) ;
    public final EObject ruleHashAlgorithm() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Token lv_useBase64_1_0=null;
        Enumerator lv_kind_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2158:28: ( ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2159:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2159:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2159:2: ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2159:2: ( (lv_optional_0_0= 'optional' ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==64) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2160:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2160:1: (lv_optional_0_0= 'optional' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2161:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleHashAlgorithm4411); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2174:3: ( (lv_useBase64_1_0= 'Base64-encoded' ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==69) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2175:1: (lv_useBase64_1_0= 'Base64-encoded' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2175:1: (lv_useBase64_1_0= 'Base64-encoded' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2176:3: lv_useBase64_1_0= 'Base64-encoded'
                    {
                    lv_useBase64_1_0=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleHashAlgorithm4443); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2189:3: ( (lv_kind_2_0= ruleHashAlgKind ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2190:1: (lv_kind_2_0= ruleHashAlgKind )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2190:1: (lv_kind_2_0= ruleHashAlgKind )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2191:3: lv_kind_2_0= ruleHashAlgKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getHashAlgorithmAccess().getKindHashAlgKindEnumRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleHashAlgKind_in_ruleHashAlgorithm4478);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2215:1: entryRuleSigningRequirement returns [EObject current=null] : iv_ruleSigningRequirement= ruleSigningRequirement EOF ;
    public final EObject entryRuleSigningRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSigningRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2216:2: (iv_ruleSigningRequirement= ruleSigningRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2217:2: iv_ruleSigningRequirement= ruleSigningRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSigningRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSigningRequirement_in_entryRuleSigningRequirement4514);
            iv_ruleSigningRequirement=ruleSigningRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSigningRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSigningRequirement4524); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2224:1: ruleSigningRequirement returns [EObject current=null] : ( () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2227:28: ( ( () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2228:1: ( () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2228:1: ( () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2228:2: () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}'
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2228:2: ()
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2229:2: 
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

            otherlv_1=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleSigningRequirement4573); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSigningRequirementAccess().getSigningPolicyKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSigningRequirement4585); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getSigningRequirementAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2245:1: (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==71) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2245:3: otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+
                    {
                    otherlv_3=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleSigningRequirement4598); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getSigningRequirementAccess().getSupportedAlgorithmsKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2249:1: ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+
                    int cnt61=0;
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( ((LA61_0>=107 && LA61_0<=109)||(LA61_0>=116 && LA61_0<=120)) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2250:1: (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm )
                    	    {
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2250:1: (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2251:3: lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSigningRequirementAccess().getSupportedSigningAlgorithmsSigningAlgothmEnumRuleCall_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleSigningAlgothm_in_ruleSigningRequirement4619);
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
                    	    if ( cnt61 >= 1 ) break loop61;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(61, input);
                                throw eee;
                        }
                        cnt61++;
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2267:5: (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==72) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2267:7: otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) )
                    {
                    otherlv_5=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleSigningRequirement4635); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSigningRequirementAccess().getRequiresAlgorithmKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2271:1: ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2272:1: (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2272:1: (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2273:3: lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSigningRequirementAccess().getRequiredSigningAlgorithmSigningAlgothmEnumRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSigningAlgothm_in_ruleSigningRequirement4656);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2289:4: (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==73) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2289:6: otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )*
                    {
                    otherlv_7=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleSigningRequirement4671); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getSigningRequirementAccess().getSignedMessagePartsKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2293:1: ( (lv_signedParts_8_0= ruleMessagePartRef ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2294:1: (lv_signedParts_8_0= ruleMessagePartRef )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2294:1: (lv_signedParts_8_0= ruleMessagePartRef )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2295:3: lv_signedParts_8_0= ruleMessagePartRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSigningRequirementAccess().getSignedPartsMessagePartRefParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_ruleSigningRequirement4692);
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

                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2311:2: (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==74) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2311:4: otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) )
                    	    {
                    	    otherlv_9=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleSigningRequirement4705); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getSigningRequirementAccess().getCommaKeyword_5_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2315:1: ( (lv_signedParts_10_0= ruleMessagePartRef ) )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2316:1: (lv_signedParts_10_0= ruleMessagePartRef )
                    	    {
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2316:1: (lv_signedParts_10_0= ruleMessagePartRef )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2317:3: lv_signedParts_10_0= ruleMessagePartRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSigningRequirementAccess().getSignedPartsMessagePartRefParserRuleCall_5_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_ruleSigningRequirement4726);
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
                    	    break loop64;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSigningRequirement4742); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2345:1: entryRuleMessagePartRef returns [EObject current=null] : iv_ruleMessagePartRef= ruleMessagePartRef EOF ;
    public final EObject entryRuleMessagePartRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessagePartRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2346:2: (iv_ruleMessagePartRef= ruleMessagePartRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2347:2: iv_ruleMessagePartRef= ruleMessagePartRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMessagePartRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_entryRuleMessagePartRef4778);
            iv_ruleMessagePartRef=ruleMessagePartRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMessagePartRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMessagePartRef4788); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2354:1: ruleMessagePartRef returns [EObject current=null] : ( ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleMessagePartRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_partRefExpression_2_0=null;
        Enumerator lv_messagePartRef_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2357:28: ( ( ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )? ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2358:1: ( ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )? )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2358:1: ( ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )? )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2358:2: ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )?
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2358:2: ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2359:1: (lv_messagePartRef_0_0= ruleMessagePartRefKind )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2359:1: (lv_messagePartRef_0_0= ruleMessagePartRefKind )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2360:3: lv_messagePartRef_0_0= ruleMessagePartRefKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMessagePartRefAccess().getMessagePartRefMessagePartRefKindEnumRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleMessagePartRefKind_in_ruleMessagePartRef4834);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2376:2: (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==75) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2376:4: otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleMessagePartRef4847); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMessagePartRefAccess().getExpressionKeyword_1_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2380:1: ( (lv_partRefExpression_2_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2381:1: (lv_partRefExpression_2_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2381:1: (lv_partRefExpression_2_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2382:3: lv_partRefExpression_2_0= RULE_STRING
                    {
                    lv_partRefExpression_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMessagePartRef4864); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2406:1: entryRuleEncryptionRequirement returns [EObject current=null] : iv_ruleEncryptionRequirement= ruleEncryptionRequirement EOF ;
    public final EObject entryRuleEncryptionRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEncryptionRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2407:2: (iv_ruleEncryptionRequirement= ruleEncryptionRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2408:2: iv_ruleEncryptionRequirement= ruleEncryptionRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEncryptionRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEncryptionRequirement_in_entryRuleEncryptionRequirement4907);
            iv_ruleEncryptionRequirement=ruleEncryptionRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEncryptionRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEncryptionRequirement4917); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2415:1: ruleEncryptionRequirement returns [EObject current=null] : ( () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2418:28: ( ( () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2419:1: ( () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2419:1: ( () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2419:2: () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}'
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2419:2: ()
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2420:2: 
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

            otherlv_1=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleEncryptionRequirement4966); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEncryptionRequirementAccess().getEncryptionPolicyKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEncryptionRequirement4978); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getEncryptionRequirementAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2436:1: (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==71) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2436:3: otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+
                    {
                    otherlv_3=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleEncryptionRequirement4991); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getEncryptionRequirementAccess().getSupportedAlgorithmsKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2440:1: ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+
                    int cnt67=0;
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==116||LA67_0==118||(LA67_0>=120 && LA67_0<=125)) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2441:1: (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind )
                    	    {
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2441:1: (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2442:3: lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getEncryptionRequirementAccess().getSupportedCipherAlgorithmsCipherAlgorithmKindEnumRuleCall_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCipherAlgorithmKind_in_ruleEncryptionRequirement5012);
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
                    	    if ( cnt67 >= 1 ) break loop67;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(67, input);
                                throw eee;
                        }
                        cnt67++;
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2458:5: (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==72) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2458:7: otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) )
                    {
                    otherlv_5=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleEncryptionRequirement5028); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getEncryptionRequirementAccess().getRequiresAlgorithmKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2462:1: ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2463:1: (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2463:1: (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2464:3: lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEncryptionRequirementAccess().getRequiredCipherAlgorithmCipherAlgorithmKindEnumRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCipherAlgorithmKind_in_ruleEncryptionRequirement5049);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2480:4: (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==77) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2480:6: otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )*
                    {
                    otherlv_7=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleEncryptionRequirement5064); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getEncryptionRequirementAccess().getEncryptedMessagePartsKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2484:1: ( (lv_encryptedParts_8_0= ruleMessagePartRef ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2485:1: (lv_encryptedParts_8_0= ruleMessagePartRef )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2485:1: (lv_encryptedParts_8_0= ruleMessagePartRef )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2486:3: lv_encryptedParts_8_0= ruleMessagePartRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEncryptionRequirementAccess().getEncryptedPartsMessagePartRefParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_ruleEncryptionRequirement5085);
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

                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2502:2: (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==74) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2502:4: otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) )
                    	    {
                    	    otherlv_9=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleEncryptionRequirement5098); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getEncryptionRequirementAccess().getCommaKeyword_5_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2506:1: ( (lv_encryptedParts_10_0= ruleMessagePartRef ) )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2507:1: (lv_encryptedParts_10_0= ruleMessagePartRef )
                    	    {
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2507:1: (lv_encryptedParts_10_0= ruleMessagePartRef )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2508:3: lv_encryptedParts_10_0= ruleMessagePartRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getEncryptionRequirementAccess().getEncryptedPartsMessagePartRefParserRuleCall_5_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_ruleEncryptionRequirement5119);
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
                    	    break loop70;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleEncryptionRequirement5135); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2536:1: entryRulePriorityDeclaration returns [EObject current=null] : iv_rulePriorityDeclaration= rulePriorityDeclaration EOF ;
    public final EObject entryRulePriorityDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePriorityDeclaration = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2537:2: (iv_rulePriorityDeclaration= rulePriorityDeclaration EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2538:2: iv_rulePriorityDeclaration= rulePriorityDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPriorityDeclarationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePriorityDeclaration_in_entryRulePriorityDeclaration5171);
            iv_rulePriorityDeclaration=rulePriorityDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePriorityDeclaration; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePriorityDeclaration5181); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2545:1: rulePriorityDeclaration returns [EObject current=null] : (otherlv_0= 'priority' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) ) ;
    public final EObject rulePriorityDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_description_3_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2548:28: ( (otherlv_0= 'priority' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2549:1: (otherlv_0= 'priority' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2549:1: (otherlv_0= 'priority' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2549:3: otherlv_0= 'priority' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,78,FollowSets000.FOLLOW_78_in_rulePriorityDeclaration5218); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPriorityDeclarationAccess().getPriorityKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2553:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2554:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2554:1: (lv_name_1_0= RULE_ID )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2555:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePriorityDeclaration5235); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_rulePriorityDeclaration5252); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getPriorityDeclarationAccess().getDescriptionKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2575:1: ( (lv_description_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2576:1: (lv_description_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2576:1: (lv_description_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2577:3: lv_description_3_0= RULE_STRING
            {
            lv_description_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rulePriorityDeclaration5269); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2601:1: entryRuleEscalation returns [EObject current=null] : iv_ruleEscalation= ruleEscalation EOF ;
    public final EObject entryRuleEscalation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEscalation = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2602:2: (iv_ruleEscalation= ruleEscalation EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2603:2: iv_ruleEscalation= ruleEscalation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEscalationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_entryRuleEscalation5310);
            iv_ruleEscalation=ruleEscalation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEscalation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEscalation5320); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2610:1: ruleEscalation returns [EObject current=null] : (otherlv_0= 'escalation' otherlv_1= '{' (otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) ) )? otherlv_4= 'escalate-to' otherlv_5= '{' ( ( ruleQualifiedName ) )+ otherlv_7= '}' (otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2613:28: ( (otherlv_0= 'escalation' otherlv_1= '{' (otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) ) )? otherlv_4= 'escalate-to' otherlv_5= '{' ( ( ruleQualifiedName ) )+ otherlv_7= '}' (otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2614:1: (otherlv_0= 'escalation' otherlv_1= '{' (otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) ) )? otherlv_4= 'escalate-to' otherlv_5= '{' ( ( ruleQualifiedName ) )+ otherlv_7= '}' (otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2614:1: (otherlv_0= 'escalation' otherlv_1= '{' (otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) ) )? otherlv_4= 'escalate-to' otherlv_5= '{' ( ( ruleQualifiedName ) )+ otherlv_7= '}' (otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2614:3: otherlv_0= 'escalation' otherlv_1= '{' (otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) ) )? otherlv_4= 'escalate-to' otherlv_5= '{' ( ( ruleQualifiedName ) )+ otherlv_7= '}' (otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) ) )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleEscalation5357); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEscalationAccess().getEscalationKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEscalation5369); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEscalationAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2622:1: (otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==80) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2622:3: otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleEscalation5382); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getEscalationAccess().getCauseKeyword_2_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2626:1: ( (lv_cause_3_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2627:1: (lv_cause_3_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2627:1: (lv_cause_3_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2628:3: lv_cause_3_0= RULE_STRING
                    {
                    lv_cause_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEscalation5399); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleEscalation5418); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEscalationAccess().getEscalateToKeyword_3());
                  
            }
            otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEscalation5430); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getEscalationAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2652:1: ( ( ruleQualifiedName ) )+
            int cnt73=0;
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==RULE_ID) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2653:1: ( ruleQualifiedName )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2653:1: ( ruleQualifiedName )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2654:3: ruleQualifiedName
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
            	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleEscalation5457);
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
            	    if ( cnt73 >= 1 ) break loop73;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(73, input);
                        throw eee;
                }
                cnt73++;
            } while (true);

            otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleEscalation5470); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getEscalationAccess().getRightCurlyBracketKeyword_6());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2674:1: (otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==82) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2674:3: otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleEscalation5483); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getEscalationAccess().getProcedureKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2678:1: ( (lv_procedure_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2679:1: (lv_procedure_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2679:1: (lv_procedure_9_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2680:3: lv_procedure_9_0= RULE_STRING
                    {
                    lv_procedure_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEscalation5500); if (state.failed) return current;
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

            otherlv_10=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleEscalation5519); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2708:1: entryRuleParty returns [EObject current=null] : iv_ruleParty= ruleParty EOF ;
    public final EObject entryRuleParty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParty = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2709:2: (iv_ruleParty= ruleParty EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2710:2: iv_ruleParty= ruleParty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParty_in_entryRuleParty5555);
            iv_ruleParty=ruleParty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParty; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParty5565); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2717:1: ruleParty returns [EObject current=null] : (this_CustomerParty_0= ruleCustomerParty | this_ProviderParty_1= ruleProviderParty | this_ThirdParty_2= ruleThirdParty ) ;
    public final EObject ruleParty() throws RecognitionException {
        EObject current = null;

        EObject this_CustomerParty_0 = null;

        EObject this_ProviderParty_1 = null;

        EObject this_ThirdParty_2 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2720:28: ( (this_CustomerParty_0= ruleCustomerParty | this_ProviderParty_1= ruleProviderParty | this_ThirdParty_2= ruleThirdParty ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2721:1: (this_CustomerParty_0= ruleCustomerParty | this_ProviderParty_1= ruleProviderParty | this_ThirdParty_2= ruleThirdParty )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2721:1: (this_CustomerParty_0= ruleCustomerParty | this_ProviderParty_1= ruleProviderParty | this_ThirdParty_2= ruleThirdParty )
            int alt75=3;
            switch ( input.LA(1) ) {
            case 83:
                {
                alt75=1;
                }
                break;
            case 84:
                {
                alt75=2;
                }
                break;
            case 85:
                {
                alt75=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }

            switch (alt75) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2722:2: this_CustomerParty_0= ruleCustomerParty
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartyAccess().getCustomerPartyParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCustomerParty_in_ruleParty5615);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2735:2: this_ProviderParty_1= ruleProviderParty
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartyAccess().getProviderPartyParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProviderParty_in_ruleParty5645);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2748:2: this_ThirdParty_2= ruleThirdParty
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartyAccess().getThirdPartyParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleThirdParty_in_ruleParty5675);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2767:1: entryRuleCustomerParty returns [EObject current=null] : iv_ruleCustomerParty= ruleCustomerParty EOF ;
    public final EObject entryRuleCustomerParty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomerParty = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2768:2: (iv_ruleCustomerParty= ruleCustomerParty EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2769:2: iv_ruleCustomerParty= ruleCustomerParty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCustomerPartyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCustomerParty_in_entryRuleCustomerParty5710);
            iv_ruleCustomerParty=ruleCustomerParty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCustomerParty; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCustomerParty5720); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2776:1: ruleCustomerParty returns [EObject current=null] : (otherlv_0= 'customer-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepesentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2779:28: ( (otherlv_0= 'customer-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepesentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2780:1: (otherlv_0= 'customer-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepesentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2780:1: (otherlv_0= 'customer-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepesentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2780:3: otherlv_0= 'customer-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepesentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleCustomerParty5757); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getCustomerPartyAccess().getCustomerPartyKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2784:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2785:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2785:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2786:3: lv_name_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCustomerPartyAccess().getNameQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleCustomerParty5778);
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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleCustomerParty5790); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getCustomerPartyAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2806:1: ( (lv_representatives_3_0= ruleRepesentative ) )+
            int cnt76=0;
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==87) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2807:1: (lv_representatives_3_0= ruleRepesentative )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2807:1: (lv_representatives_3_0= ruleRepesentative )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2808:3: lv_representatives_3_0= ruleRepesentative
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCustomerPartyAccess().getRepresentativesRepesentativeParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleRepesentative_in_ruleCustomerParty5811);
            	    lv_representatives_3_0=ruleRepesentative();

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
            	              		"Repesentative");
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2824:3: ( (lv_responsibilities_4_0= ruleResponsibility ) )+
            int cnt77=0;
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==91||LA77_0==95) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2825:1: (lv_responsibilities_4_0= ruleResponsibility )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2825:1: (lv_responsibilities_4_0= ruleResponsibility )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2826:3: lv_responsibilities_4_0= ruleResponsibility
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCustomerPartyAccess().getResponsibilitiesResponsibilityParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleResponsibility_in_ruleCustomerParty5833);
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
            	    if ( cnt77 >= 1 ) break loop77;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(77, input);
                        throw eee;
                }
                cnt77++;
            } while (true);

            otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleCustomerParty5846); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2854:1: entryRuleProviderParty returns [EObject current=null] : iv_ruleProviderParty= ruleProviderParty EOF ;
    public final EObject entryRuleProviderParty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProviderParty = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2855:2: (iv_ruleProviderParty= ruleProviderParty EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2856:2: iv_ruleProviderParty= ruleProviderParty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProviderPartyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleProviderParty_in_entryRuleProviderParty5882);
            iv_ruleProviderParty=ruleProviderParty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProviderParty; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProviderParty5892); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2863:1: ruleProviderParty returns [EObject current=null] : (otherlv_0= 'provider-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepesentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2866:28: ( (otherlv_0= 'provider-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepesentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2867:1: (otherlv_0= 'provider-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepesentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2867:1: (otherlv_0= 'provider-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepesentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2867:3: otherlv_0= 'provider-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepesentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,84,FollowSets000.FOLLOW_84_in_ruleProviderParty5929); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getProviderPartyAccess().getProviderPartyKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2871:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2872:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2872:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2873:3: lv_name_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProviderPartyAccess().getNameQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleProviderParty5950);
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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleProviderParty5962); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getProviderPartyAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2893:1: ( (lv_representatives_3_0= ruleRepesentative ) )+
            int cnt78=0;
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==87) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2894:1: (lv_representatives_3_0= ruleRepesentative )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2894:1: (lv_representatives_3_0= ruleRepesentative )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2895:3: lv_representatives_3_0= ruleRepesentative
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProviderPartyAccess().getRepresentativesRepesentativeParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleRepesentative_in_ruleProviderParty5983);
            	    lv_representatives_3_0=ruleRepesentative();

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
            	              		"Repesentative");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt78 >= 1 ) break loop78;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(78, input);
                        throw eee;
                }
                cnt78++;
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2911:3: ( (lv_responsibilities_4_0= ruleResponsibility ) )+
            int cnt79=0;
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==91||LA79_0==95) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2912:1: (lv_responsibilities_4_0= ruleResponsibility )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2912:1: (lv_responsibilities_4_0= ruleResponsibility )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2913:3: lv_responsibilities_4_0= ruleResponsibility
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProviderPartyAccess().getResponsibilitiesResponsibilityParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleResponsibility_in_ruleProviderParty6005);
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
            	    if ( cnt79 >= 1 ) break loop79;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(79, input);
                        throw eee;
                }
                cnt79++;
            } while (true);

            otherlv_5=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleProviderParty6018); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2941:1: entryRuleThirdParty returns [EObject current=null] : iv_ruleThirdParty= ruleThirdParty EOF ;
    public final EObject entryRuleThirdParty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThirdParty = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2942:2: (iv_ruleThirdParty= ruleThirdParty EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2943:2: iv_ruleThirdParty= ruleThirdParty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getThirdPartyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleThirdParty_in_entryRuleThirdParty6054);
            iv_ruleThirdParty=ruleThirdParty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleThirdParty; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleThirdParty6064); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2950:1: ruleThirdParty returns [EObject current=null] : (otherlv_0= 'third-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' otherlv_3= 'participation-role' ( (lv_role_4_0= RULE_STRING ) ) ( (lv_representatives_5_0= ruleRepesentative ) )+ ( (lv_responsibilities_6_0= ruleResponsibility ) )+ otherlv_7= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2953:28: ( (otherlv_0= 'third-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' otherlv_3= 'participation-role' ( (lv_role_4_0= RULE_STRING ) ) ( (lv_representatives_5_0= ruleRepesentative ) )+ ( (lv_responsibilities_6_0= ruleResponsibility ) )+ otherlv_7= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2954:1: (otherlv_0= 'third-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' otherlv_3= 'participation-role' ( (lv_role_4_0= RULE_STRING ) ) ( (lv_representatives_5_0= ruleRepesentative ) )+ ( (lv_responsibilities_6_0= ruleResponsibility ) )+ otherlv_7= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2954:1: (otherlv_0= 'third-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' otherlv_3= 'participation-role' ( (lv_role_4_0= RULE_STRING ) ) ( (lv_representatives_5_0= ruleRepesentative ) )+ ( (lv_responsibilities_6_0= ruleResponsibility ) )+ otherlv_7= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2954:3: otherlv_0= 'third-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' otherlv_3= 'participation-role' ( (lv_role_4_0= RULE_STRING ) ) ( (lv_representatives_5_0= ruleRepesentative ) )+ ( (lv_responsibilities_6_0= ruleResponsibility ) )+ otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,85,FollowSets000.FOLLOW_85_in_ruleThirdParty6101); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getThirdPartyAccess().getThirdPartyKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2958:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2959:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2959:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2960:3: lv_name_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getThirdPartyAccess().getNameQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleThirdParty6122);
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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleThirdParty6134); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getThirdPartyAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,86,FollowSets000.FOLLOW_86_in_ruleThirdParty6146); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getThirdPartyAccess().getParticipationRoleKeyword_3());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2984:1: ( (lv_role_4_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2985:1: (lv_role_4_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2985:1: (lv_role_4_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2986:3: lv_role_4_0= RULE_STRING
            {
            lv_role_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleThirdParty6163); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3002:2: ( (lv_representatives_5_0= ruleRepesentative ) )+
            int cnt80=0;
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==87) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3003:1: (lv_representatives_5_0= ruleRepesentative )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3003:1: (lv_representatives_5_0= ruleRepesentative )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3004:3: lv_representatives_5_0= ruleRepesentative
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getThirdPartyAccess().getRepresentativesRepesentativeParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleRepesentative_in_ruleThirdParty6189);
            	    lv_representatives_5_0=ruleRepesentative();

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
            	              		"Repesentative");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt80 >= 1 ) break loop80;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(80, input);
                        throw eee;
                }
                cnt80++;
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3020:3: ( (lv_responsibilities_6_0= ruleResponsibility ) )+
            int cnt81=0;
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==91||LA81_0==95) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3021:1: (lv_responsibilities_6_0= ruleResponsibility )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3021:1: (lv_responsibilities_6_0= ruleResponsibility )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3022:3: lv_responsibilities_6_0= ruleResponsibility
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getThirdPartyAccess().getResponsibilitiesResponsibilityParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleResponsibility_in_ruleThirdParty6211);
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
            	    if ( cnt81 >= 1 ) break loop81;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(81, input);
                        throw eee;
                }
                cnt81++;
            } while (true);

            otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleThirdParty6224); if (state.failed) return current;
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


    // $ANTLR start "entryRuleRepesentative"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3050:1: entryRuleRepesentative returns [EObject current=null] : iv_ruleRepesentative= ruleRepesentative EOF ;
    public final EObject entryRuleRepesentative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRepesentative = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3051:2: (iv_ruleRepesentative= ruleRepesentative EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3052:2: iv_ruleRepesentative= ruleRepesentative EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRepesentativeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRepesentative_in_entryRuleRepesentative6260);
            iv_ruleRepesentative=ruleRepesentative();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRepesentative; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRepesentative6270); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRepesentative"


    // $ANTLR start "ruleRepesentative"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3059:1: ruleRepesentative returns [EObject current=null] : (otherlv_0= 'representative' otherlv_1= '{' otherlv_2= 'name' ( (lv_fullname_3_0= RULE_STRING ) ) (otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) ) )? (otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) ;
    public final EObject ruleRepesentative() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_fullname_3_0=null;
        Token otherlv_4=null;
        Token lv_phone_5_0=null;
        Token otherlv_6=null;
        Token lv_email_7_0=null;
        Token otherlv_8=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3062:28: ( (otherlv_0= 'representative' otherlv_1= '{' otherlv_2= 'name' ( (lv_fullname_3_0= RULE_STRING ) ) (otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) ) )? (otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3063:1: (otherlv_0= 'representative' otherlv_1= '{' otherlv_2= 'name' ( (lv_fullname_3_0= RULE_STRING ) ) (otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) ) )? (otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3063:1: (otherlv_0= 'representative' otherlv_1= '{' otherlv_2= 'name' ( (lv_fullname_3_0= RULE_STRING ) ) (otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) ) )? (otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3063:3: otherlv_0= 'representative' otherlv_1= '{' otherlv_2= 'name' ( (lv_fullname_3_0= RULE_STRING ) ) (otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) ) )? (otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) ) )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,87,FollowSets000.FOLLOW_87_in_ruleRepesentative6307); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRepesentativeAccess().getRepresentativeKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleRepesentative6319); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRepesentativeAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,88,FollowSets000.FOLLOW_88_in_ruleRepesentative6331); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRepesentativeAccess().getNameKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3075:1: ( (lv_fullname_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3076:1: (lv_fullname_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3076:1: (lv_fullname_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3077:3: lv_fullname_3_0= RULE_STRING
            {
            lv_fullname_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleRepesentative6348); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_fullname_3_0, grammarAccess.getRepesentativeAccess().getFullnameSTRINGTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRepesentativeRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"fullname",
                      		lv_fullname_3_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3093:2: (otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==89) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3093:4: otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,89,FollowSets000.FOLLOW_89_in_ruleRepesentative6366); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getRepesentativeAccess().getPhoneKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3097:1: ( (lv_phone_5_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3098:1: (lv_phone_5_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3098:1: (lv_phone_5_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3099:3: lv_phone_5_0= RULE_STRING
                    {
                    lv_phone_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleRepesentative6383); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_phone_5_0, grammarAccess.getRepesentativeAccess().getPhoneSTRINGTerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getRepesentativeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"phone",
                              		lv_phone_5_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3115:4: (otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==90) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3115:6: otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,90,FollowSets000.FOLLOW_90_in_ruleRepesentative6403); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getRepesentativeAccess().getEmailKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3119:1: ( (lv_email_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3120:1: (lv_email_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3120:1: (lv_email_7_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3121:3: lv_email_7_0= RULE_STRING
                    {
                    lv_email_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleRepesentative6420); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_email_7_0, grammarAccess.getRepesentativeAccess().getEmailSTRINGTerminalRuleCall_5_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getRepesentativeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"email",
                              		lv_email_7_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleRepesentative6439); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getRepesentativeAccess().getRightCurlyBracketKeyword_6());
                  
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
    // $ANTLR end "ruleRepesentative"


    // $ANTLR start "entryRuleResponsibility"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3149:1: entryRuleResponsibility returns [EObject current=null] : iv_ruleResponsibility= ruleResponsibility EOF ;
    public final EObject entryRuleResponsibility() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResponsibility = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3150:2: (iv_ruleResponsibility= ruleResponsibility EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3151:2: iv_ruleResponsibility= ruleResponsibility EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResponsibilityRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleResponsibility_in_entryRuleResponsibility6475);
            iv_ruleResponsibility=ruleResponsibility();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResponsibility; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleResponsibility6485); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3158:1: ruleResponsibility returns [EObject current=null] : (this_SimpleResponsibility_0= ruleSimpleResponsibility | this_ReportingResponsibility_1= ruleReportingResponsibility ) ;
    public final EObject ruleResponsibility() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleResponsibility_0 = null;

        EObject this_ReportingResponsibility_1 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3161:28: ( (this_SimpleResponsibility_0= ruleSimpleResponsibility | this_ReportingResponsibility_1= ruleReportingResponsibility ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3162:1: (this_SimpleResponsibility_0= ruleSimpleResponsibility | this_ReportingResponsibility_1= ruleReportingResponsibility )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3162:1: (this_SimpleResponsibility_0= ruleSimpleResponsibility | this_ReportingResponsibility_1= ruleReportingResponsibility )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==91) ) {
                alt84=1;
            }
            else if ( (LA84_0==95) ) {
                alt84=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }
            switch (alt84) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3163:2: this_SimpleResponsibility_0= ruleSimpleResponsibility
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getResponsibilityAccess().getSimpleResponsibilityParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleResponsibility_in_ruleResponsibility6535);
                    this_SimpleResponsibility_0=ruleSimpleResponsibility();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SimpleResponsibility_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3176:2: this_ReportingResponsibility_1= ruleReportingResponsibility
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getResponsibilityAccess().getReportingResponsibilityParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleReportingResponsibility_in_ruleResponsibility6565);
                    this_ReportingResponsibility_1=ruleReportingResponsibility();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ReportingResponsibility_1; 
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
    // $ANTLR end "ruleResponsibility"


    // $ANTLR start "entryRuleSimpleResponsibility"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3195:1: entryRuleSimpleResponsibility returns [EObject current=null] : iv_ruleSimpleResponsibility= ruleSimpleResponsibility EOF ;
    public final EObject entryRuleSimpleResponsibility() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleResponsibility = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3196:2: (iv_ruleSimpleResponsibility= ruleSimpleResponsibility EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3197:2: iv_ruleSimpleResponsibility= ruleSimpleResponsibility EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleResponsibilityRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleResponsibility_in_entryRuleSimpleResponsibility6600);
            iv_ruleSimpleResponsibility=ruleSimpleResponsibility();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleResponsibility; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleResponsibility6610); if (state.failed) return current;

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
    // $ANTLR end "entryRuleSimpleResponsibility"


    // $ANTLR start "ruleSimpleResponsibility"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3204:1: ruleSimpleResponsibility returns [EObject current=null] : (otherlv_0= 'responsibility' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_description_3_0= RULE_STRING ) ) ( (lv_escalations_4_0= ruleEscalation ) )+ ( (lv_penalty_5_0= RULE_STRING ) ) otherlv_6= '}' ) ;
    public final EObject ruleSimpleResponsibility() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_description_3_0=null;
        Token lv_penalty_5_0=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_escalations_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3207:28: ( (otherlv_0= 'responsibility' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_description_3_0= RULE_STRING ) ) ( (lv_escalations_4_0= ruleEscalation ) )+ ( (lv_penalty_5_0= RULE_STRING ) ) otherlv_6= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3208:1: (otherlv_0= 'responsibility' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_description_3_0= RULE_STRING ) ) ( (lv_escalations_4_0= ruleEscalation ) )+ ( (lv_penalty_5_0= RULE_STRING ) ) otherlv_6= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3208:1: (otherlv_0= 'responsibility' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_description_3_0= RULE_STRING ) ) ( (lv_escalations_4_0= ruleEscalation ) )+ ( (lv_penalty_5_0= RULE_STRING ) ) otherlv_6= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3208:3: otherlv_0= 'responsibility' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_description_3_0= RULE_STRING ) ) ( (lv_escalations_4_0= ruleEscalation ) )+ ( (lv_penalty_5_0= RULE_STRING ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,91,FollowSets000.FOLLOW_91_in_ruleSimpleResponsibility6647); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSimpleResponsibilityAccess().getResponsibilityKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3212:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3213:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3213:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3214:3: lv_name_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSimpleResponsibilityAccess().getNameQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSimpleResponsibility6668);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSimpleResponsibilityRule());
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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSimpleResponsibility6680); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getSimpleResponsibilityAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3234:1: ( (lv_description_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3235:1: (lv_description_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3235:1: (lv_description_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3236:3: lv_description_3_0= RULE_STRING
            {
            lv_description_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSimpleResponsibility6697); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_description_3_0, grammarAccess.getSimpleResponsibilityAccess().getDescriptionSTRINGTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getSimpleResponsibilityRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"description",
                      		lv_description_3_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3252:2: ( (lv_escalations_4_0= ruleEscalation ) )+
            int cnt85=0;
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==79) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3253:1: (lv_escalations_4_0= ruleEscalation )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3253:1: (lv_escalations_4_0= ruleEscalation )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3254:3: lv_escalations_4_0= ruleEscalation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSimpleResponsibilityAccess().getEscalationsEscalationParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleSimpleResponsibility6723);
            	    lv_escalations_4_0=ruleEscalation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSimpleResponsibilityRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"escalations",
            	              		lv_escalations_4_0, 
            	              		"Escalation");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt85 >= 1 ) break loop85;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(85, input);
                        throw eee;
                }
                cnt85++;
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3270:3: ( (lv_penalty_5_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3271:1: (lv_penalty_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3271:1: (lv_penalty_5_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3272:3: lv_penalty_5_0= RULE_STRING
            {
            lv_penalty_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSimpleResponsibility6741); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_penalty_5_0, grammarAccess.getSimpleResponsibilityAccess().getPenaltySTRINGTerminalRuleCall_5_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getSimpleResponsibilityRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"penalty",
                      		lv_penalty_5_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSimpleResponsibility6758); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getSimpleResponsibilityAccess().getRightCurlyBracketKeyword_6());
                  
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
    // $ANTLR end "ruleSimpleResponsibility"


    // $ANTLR start "entryRuleReport"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3300:1: entryRuleReport returns [EObject current=null] : iv_ruleReport= ruleReport EOF ;
    public final EObject entryRuleReport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReport = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3301:2: (iv_ruleReport= ruleReport EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3302:2: iv_ruleReport= ruleReport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReportRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReport_in_entryRuleReport6794);
            iv_ruleReport=ruleReport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReport; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReport6804); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3309:1: ruleReport returns [EObject current=null] : (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' ( (lv_reportTo_4_0= RULE_STRING ) ) otherlv_5= 'contents' ( (lv_content_6_0= RULE_STRING ) ) otherlv_7= '}' ) ;
    public final EObject ruleReport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_reportTo_4_0=null;
        Token otherlv_5=null;
        Token lv_content_6_0=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3312:28: ( (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' ( (lv_reportTo_4_0= RULE_STRING ) ) otherlv_5= 'contents' ( (lv_content_6_0= RULE_STRING ) ) otherlv_7= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3313:1: (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' ( (lv_reportTo_4_0= RULE_STRING ) ) otherlv_5= 'contents' ( (lv_content_6_0= RULE_STRING ) ) otherlv_7= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3313:1: (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' ( (lv_reportTo_4_0= RULE_STRING ) ) otherlv_5= 'contents' ( (lv_content_6_0= RULE_STRING ) ) otherlv_7= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3313:3: otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' ( (lv_reportTo_4_0= RULE_STRING ) ) otherlv_5= 'contents' ( (lv_content_6_0= RULE_STRING ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,92,FollowSets000.FOLLOW_92_in_ruleReport6841); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getReportAccess().getReportKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3317:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3318:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3318:1: (lv_name_1_0= RULE_ID )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3319:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReport6858); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleReport6875); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getReportAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,93,FollowSets000.FOLLOW_93_in_ruleReport6887); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getReportAccess().getReportToKeyword_3());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3343:1: ( (lv_reportTo_4_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3344:1: (lv_reportTo_4_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3344:1: (lv_reportTo_4_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3345:3: lv_reportTo_4_0= RULE_STRING
            {
            lv_reportTo_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReport6904); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_reportTo_4_0, grammarAccess.getReportAccess().getReportToSTRINGTerminalRuleCall_4_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getReportRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"reportTo",
                      		lv_reportTo_4_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,94,FollowSets000.FOLLOW_94_in_ruleReport6921); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getReportAccess().getContentsKeyword_5());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3365:1: ( (lv_content_6_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3366:1: (lv_content_6_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3366:1: (lv_content_6_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3367:3: lv_content_6_0= RULE_STRING
            {
            lv_content_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReport6938); if (state.failed) return current;
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

            otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleReport6955); if (state.failed) return current;
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


    // $ANTLR start "entryRuleReportingResponsibility"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3395:1: entryRuleReportingResponsibility returns [EObject current=null] : iv_ruleReportingResponsibility= ruleReportingResponsibility EOF ;
    public final EObject entryRuleReportingResponsibility() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReportingResponsibility = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3396:2: (iv_ruleReportingResponsibility= ruleReportingResponsibility EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3397:2: iv_ruleReportingResponsibility= ruleReportingResponsibility EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReportingResponsibilityRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReportingResponsibility_in_entryRuleReportingResponsibility6991);
            iv_ruleReportingResponsibility=ruleReportingResponsibility();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReportingResponsibility; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReportingResponsibility7001); if (state.failed) return current;

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
    // $ANTLR end "entryRuleReportingResponsibility"


    // $ANTLR start "ruleReportingResponsibility"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3404:1: ruleReportingResponsibility returns [EObject current=null] : (otherlv_0= 'reporting-responsibility' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' otherlv_4= 'contents' ( (lv_content_5_0= RULE_STRING ) ) ( (lv_escalations_6_0= ruleEscalation ) )+ ( (lv_penalty_7_0= RULE_STRING ) ) otherlv_8= '}' ) ;
    public final EObject ruleReportingResponsibility() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_content_5_0=null;
        Token lv_penalty_7_0=null;
        Token otherlv_8=null;
        EObject lv_escalations_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3407:28: ( (otherlv_0= 'reporting-responsibility' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' otherlv_4= 'contents' ( (lv_content_5_0= RULE_STRING ) ) ( (lv_escalations_6_0= ruleEscalation ) )+ ( (lv_penalty_7_0= RULE_STRING ) ) otherlv_8= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3408:1: (otherlv_0= 'reporting-responsibility' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' otherlv_4= 'contents' ( (lv_content_5_0= RULE_STRING ) ) ( (lv_escalations_6_0= ruleEscalation ) )+ ( (lv_penalty_7_0= RULE_STRING ) ) otherlv_8= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3408:1: (otherlv_0= 'reporting-responsibility' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' otherlv_4= 'contents' ( (lv_content_5_0= RULE_STRING ) ) ( (lv_escalations_6_0= ruleEscalation ) )+ ( (lv_penalty_7_0= RULE_STRING ) ) otherlv_8= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3408:3: otherlv_0= 'reporting-responsibility' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' otherlv_4= 'contents' ( (lv_content_5_0= RULE_STRING ) ) ( (lv_escalations_6_0= ruleEscalation ) )+ ( (lv_penalty_7_0= RULE_STRING ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,95,FollowSets000.FOLLOW_95_in_ruleReportingResponsibility7038); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getReportingResponsibilityAccess().getReportingResponsibilityKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3412:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3413:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3413:1: (lv_name_1_0= RULE_ID )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3414:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReportingResponsibility7055); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getReportingResponsibilityAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getReportingResponsibilityRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleReportingResponsibility7072); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getReportingResponsibilityAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,93,FollowSets000.FOLLOW_93_in_ruleReportingResponsibility7084); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getReportingResponsibilityAccess().getReportToKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,94,FollowSets000.FOLLOW_94_in_ruleReportingResponsibility7096); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getReportingResponsibilityAccess().getContentsKeyword_4());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3442:1: ( (lv_content_5_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3443:1: (lv_content_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3443:1: (lv_content_5_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3444:3: lv_content_5_0= RULE_STRING
            {
            lv_content_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReportingResponsibility7113); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_content_5_0, grammarAccess.getReportingResponsibilityAccess().getContentSTRINGTerminalRuleCall_5_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getReportingResponsibilityRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"content",
                      		lv_content_5_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3460:2: ( (lv_escalations_6_0= ruleEscalation ) )+
            int cnt86=0;
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==79) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3461:1: (lv_escalations_6_0= ruleEscalation )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3461:1: (lv_escalations_6_0= ruleEscalation )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3462:3: lv_escalations_6_0= ruleEscalation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getReportingResponsibilityAccess().getEscalationsEscalationParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleReportingResponsibility7139);
            	    lv_escalations_6_0=ruleEscalation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getReportingResponsibilityRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"escalations",
            	              		lv_escalations_6_0, 
            	              		"Escalation");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt86 >= 1 ) break loop86;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(86, input);
                        throw eee;
                }
                cnt86++;
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3478:3: ( (lv_penalty_7_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3479:1: (lv_penalty_7_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3479:1: (lv_penalty_7_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3480:3: lv_penalty_7_0= RULE_STRING
            {
            lv_penalty_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReportingResponsibility7157); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_penalty_7_0, grammarAccess.getReportingResponsibilityAccess().getPenaltySTRINGTerminalRuleCall_7_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getReportingResponsibilityRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"penalty",
                      		lv_penalty_7_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleReportingResponsibility7174); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getReportingResponsibilityAccess().getRightCurlyBracketKeyword_8());
                  
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
    // $ANTLR end "ruleReportingResponsibility"


    // $ANTLR start "entryRuleVersionId"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3510:1: entryRuleVersionId returns [String current=null] : iv_ruleVersionId= ruleVersionId EOF ;
    public final String entryRuleVersionId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionId = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3511:2: (iv_ruleVersionId= ruleVersionId EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3512:2: iv_ruleVersionId= ruleVersionId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionIdRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_entryRuleVersionId7213);
            iv_ruleVersionId=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionId.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionId7224); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3519:1: ruleVersionId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleVersionId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_ID_5=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3522:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3523:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3523:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3523:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )*
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId7264); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3530:1: (kw= '.' this_INT_2= RULE_INT )*
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==61) ) {
                    int LA87_1 = input.LA(2);

                    if ( (LA87_1==RULE_INT) ) {
                        alt87=1;
                    }


                }


                switch (alt87) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3531:2: kw= '.' this_INT_2= RULE_INT
            	    {
            	    kw=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleVersionId7283); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId7298); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_INT_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_INT_2, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop87;
                }
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3543:3: ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==61||LA89_0==96) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3543:4: (kw= '.' | kw= '-' ) this_ID_5= RULE_ID
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3543:4: (kw= '.' | kw= '-' )
            	    int alt88=2;
            	    int LA88_0 = input.LA(1);

            	    if ( (LA88_0==61) ) {
            	        alt88=1;
            	    }
            	    else if ( (LA88_0==96) ) {
            	        alt88=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 88, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt88) {
            	        case 1 :
            	            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3544:2: kw= '.'
            	            {
            	            kw=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleVersionId7320); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_2_0_0()); 
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3551:2: kw= '-'
            	            {
            	            kw=(Token)match(input,96,FollowSets000.FOLLOW_96_in_ruleVersionId7339); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getVersionIdAccess().getHyphenMinusKeyword_2_0_1()); 
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    this_ID_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVersionId7355); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_5);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_5, grammarAccess.getVersionIdAccess().getIDTerminalRuleCall_2_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop89;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3573:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3574:2: (iv_ruleVersion= ruleVersion EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3575:2: iv_ruleVersion= ruleVersion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersion_in_entryRuleVersion7404);
            iv_ruleVersion=ruleVersion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersion7414); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3582:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleVersion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_version_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3585:28: ( (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3586:1: (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3586:1: (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3586:3: otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,97,FollowSets000.FOLLOW_97_in_ruleVersion7451); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3590:1: ( (lv_version_1_0= ruleVersionId ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3591:1: (lv_version_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3591:1: (lv_version_1_0= ruleVersionId )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3592:3: lv_version_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionAccess().getVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleVersion7472);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3616:1: entryRuleVersionRef returns [EObject current=null] : iv_ruleVersionRef= ruleVersionRef EOF ;
    public final EObject entryRuleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3617:2: (iv_ruleVersionRef= ruleVersionRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3618:2: iv_ruleVersionRef= ruleVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_entryRuleVersionRef7508);
            iv_ruleVersionRef=ruleVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionRef7518); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3625:1: ruleVersionRef returns [EObject current=null] : (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) ;
    public final EObject ruleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject this_MinVersionRef_0 = null;

        EObject this_MaxVersionRef_1 = null;

        EObject this_LowerBoundRangeVersionRef_2 = null;

        EObject this_MajorVersionRef_3 = null;

        EObject this_FixedVersionRef_4 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3628:28: ( (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3629:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3629:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            int alt90=5;
            switch ( input.LA(1) ) {
            case 98:
                {
                int LA90_1 = input.LA(2);

                if ( (LA90_1==RULE_INT) ) {
                    alt90=1;
                }
                else if ( (LA90_1==100) ) {
                    alt90=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 90, 1, input);

                    throw nvae;
                }
                }
                break;
            case 99:
                {
                alt90=2;
                }
                break;
            case 102:
                {
                alt90=4;
                }
                break;
            case 103:
                {
                alt90=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }

            switch (alt90) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3630:2: this_MinVersionRef_0= ruleMinVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMinVersionRefParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_ruleVersionRef7568);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3643:2: this_MaxVersionRef_1= ruleMaxVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMaxVersionRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_ruleVersionRef7598);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3656:2: this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getLowerBoundRangeVersionRefParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef7628);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3669:2: this_MajorVersionRef_3= ruleMajorVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMajorVersionRefParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_ruleVersionRef7658);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3682:2: this_FixedVersionRef_4= ruleFixedVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getFixedVersionRefParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_ruleVersionRef7688);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3701:1: entryRuleMinVersionRef returns [EObject current=null] : iv_ruleMinVersionRef= ruleMinVersionRef EOF ;
    public final EObject entryRuleMinVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinVersionRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3702:2: (iv_ruleMinVersionRef= ruleMinVersionRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3703:2: iv_ruleMinVersionRef= ruleMinVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMinVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef7723);
            iv_ruleMinVersionRef=ruleMinVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMinVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMinVersionRef7733); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3710:1: ruleMinVersionRef returns [EObject current=null] : (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMinVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_minVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3713:28: ( (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3714:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3714:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3714:3: otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,98,FollowSets000.FOLLOW_98_in_ruleMinVersionRef7770); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMinVersionRefAccess().getMinVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3718:1: ( (lv_minVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3719:1: (lv_minVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3719:1: (lv_minVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3720:3: lv_minVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMinVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMinVersionRef7791);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3744:1: entryRuleMaxVersionRef returns [EObject current=null] : iv_ruleMaxVersionRef= ruleMaxVersionRef EOF ;
    public final EObject entryRuleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxVersionRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3745:2: (iv_ruleMaxVersionRef= ruleMaxVersionRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3746:2: iv_ruleMaxVersionRef= ruleMaxVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMaxVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef7827);
            iv_ruleMaxVersionRef=ruleMaxVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMaxVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxVersionRef7837); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3753:1: ruleMaxVersionRef returns [EObject current=null] : (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_maxVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3756:28: ( (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3757:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3757:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3757:3: otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,99,FollowSets000.FOLLOW_99_in_ruleMaxVersionRef7874); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMaxVersionRefAccess().getMaxVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3761:1: ( (lv_maxVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3762:1: (lv_maxVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3762:1: (lv_maxVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3763:3: lv_maxVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMaxVersionRefAccess().getMaxVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMaxVersionRef7895);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3787:1: entryRuleLowerBoundRangeVersionRef returns [EObject current=null] : iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF ;
    public final EObject entryRuleLowerBoundRangeVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerBoundRangeVersionRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3788:2: (iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3789:2: iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef7931);
            iv_ruleLowerBoundRangeVersionRef=ruleLowerBoundRangeVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLowerBoundRangeVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef7941); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3796:1: ruleLowerBoundRangeVersionRef returns [EObject current=null] : ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3799:28: ( ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3800:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3800:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3800:2: (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3800:2: (otherlv_0= 'minVersion' otherlv_1= '>=' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3800:4: otherlv_0= 'minVersion' otherlv_1= '>='
            {
            otherlv_0=(Token)match(input,98,FollowSets000.FOLLOW_98_in_ruleLowerBoundRangeVersionRef7979); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionKeyword_0_0());
                  
            }
            otherlv_1=(Token)match(input,100,FollowSets000.FOLLOW_100_in_ruleLowerBoundRangeVersionRef7991); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLowerBoundRangeVersionRefAccess().getGreaterThanSignEqualsSignKeyword_0_1());
                  
            }

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3808:2: ( (lv_minVersion_2_0= ruleVersionId ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3809:1: (lv_minVersion_2_0= ruleVersionId )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3809:1: (lv_minVersion_2_0= ruleVersionId )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3810:3: lv_minVersion_2_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef8013);
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

            otherlv_3=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleLowerBoundRangeVersionRef8025); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLowerBoundRangeVersionRefAccess().getCommaKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3830:1: (otherlv_4= 'maxVersion' otherlv_5= '<' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3830:3: otherlv_4= 'maxVersion' otherlv_5= '<'
            {
            otherlv_4=(Token)match(input,99,FollowSets000.FOLLOW_99_in_ruleLowerBoundRangeVersionRef8038); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionKeyword_3_0());
                  
            }
            otherlv_5=(Token)match(input,101,FollowSets000.FOLLOW_101_in_ruleLowerBoundRangeVersionRef8050); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLowerBoundRangeVersionRefAccess().getLessThanSignKeyword_3_1());
                  
            }

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3838:2: ( (lv_maxVersion_6_0= ruleVersionId ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3839:1: (lv_maxVersion_6_0= ruleVersionId )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3839:1: (lv_maxVersion_6_0= ruleVersionId )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3840:3: lv_maxVersion_6_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionVersionIdParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef8072);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3864:1: entryRuleMajorVersionRef returns [EObject current=null] : iv_ruleMajorVersionRef= ruleMajorVersionRef EOF ;
    public final EObject entryRuleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMajorVersionRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3865:2: (iv_ruleMajorVersionRef= ruleMajorVersionRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3866:2: iv_ruleMajorVersionRef= ruleMajorVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMajorVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef8108);
            iv_ruleMajorVersionRef=ruleMajorVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMajorVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMajorVersionRef8118); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3873:1: ruleMajorVersionRef returns [EObject current=null] : (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) ;
    public final EObject ruleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_majorVersion_1_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3876:28: ( (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3877:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3877:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3877:3: otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,102,FollowSets000.FOLLOW_102_in_ruleMajorVersionRef8155); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMajorVersionRefAccess().getMajorVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3881:1: ( (lv_majorVersion_1_0= RULE_INT ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3882:1: (lv_majorVersion_1_0= RULE_INT )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3882:1: (lv_majorVersion_1_0= RULE_INT )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3883:3: lv_majorVersion_1_0= RULE_INT
            {
            lv_majorVersion_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMajorVersionRef8172); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3907:1: entryRuleFixedVersionRef returns [EObject current=null] : iv_ruleFixedVersionRef= ruleFixedVersionRef EOF ;
    public final EObject entryRuleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedVersionRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3908:2: (iv_ruleFixedVersionRef= ruleFixedVersionRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3909:2: iv_ruleFixedVersionRef= ruleFixedVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFixedVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef8213);
            iv_ruleFixedVersionRef=ruleFixedVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFixedVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFixedVersionRef8223); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3916:1: ruleFixedVersionRef returns [EObject current=null] : (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_fixedVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3919:28: ( (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3920:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3920:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3920:3: otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,103,FollowSets000.FOLLOW_103_in_ruleFixedVersionRef8260); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFixedVersionRefAccess().getFixedVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3924:1: ( (lv_fixedVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3925:1: (lv_fixedVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3925:1: (lv_fixedVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3926:3: lv_fixedVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFixedVersionRefAccess().getFixedVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleFixedVersionRef8281);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3950:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3951:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3952:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard8318);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard8329); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3959:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3962:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3963:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3963:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3964:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard8376);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3974:1: (kw= '.*' )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==104) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3975:2: kw= '.*'
                    {
                    kw=(Token)match(input,104,FollowSets000.FOLLOW_104_in_ruleQualifiedNameWithWildCard8395); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3988:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3989:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3990:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8438);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName8449); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3997:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4000:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4001:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4001:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4001:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName8489); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4008:1: (kw= '.' this_ID_2= RULE_ID )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==61) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4009:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleQualifiedName8508); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName8523); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop92;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4035:1: entryRuleInfoItem returns [EObject current=null] : iv_ruleInfoItem= ruleInfoItem EOF ;
    public final EObject entryRuleInfoItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfoItem = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4036:2: (iv_ruleInfoItem= ruleInfoItem EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4037:2: iv_ruleInfoItem= ruleInfoItem EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfoItemRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfoItem_in_entryRuleInfoItem8576);
            iv_ruleInfoItem=ruleInfoItem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfoItem; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfoItem8586); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4044:1: ruleInfoItem returns [EObject current=null] : (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleInfoItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_documentLocation_1_0=null;
        Token otherlv_2=null;
        Token lv_reference_3_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4047:28: ( (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4048:1: (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4048:1: (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4048:3: otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,105,FollowSets000.FOLLOW_105_in_ruleInfoItem8623); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInfoItemAccess().getLocationKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4052:1: ( (lv_documentLocation_1_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4053:1: (lv_documentLocation_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4053:1: (lv_documentLocation_1_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4054:3: lv_documentLocation_1_0= RULE_STRING
            {
            lv_documentLocation_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleInfoItem8640); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4070:2: (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==106) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4070:4: otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,106,FollowSets000.FOLLOW_106_in_ruleInfoItem8658); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getInfoItemAccess().getReferenceKeyword_2_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4074:1: ( (lv_reference_3_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4075:1: (lv_reference_3_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4075:1: (lv_reference_3_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4076:3: lv_reference_3_0= RULE_STRING
                    {
                    lv_reference_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleInfoItem8675); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4102:1: entryRuleRoleRef returns [EObject current=null] : iv_ruleRoleRef= ruleRoleRef EOF ;
    public final EObject entryRuleRoleRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoleRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4103:2: (iv_ruleRoleRef= ruleRoleRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4104:2: iv_ruleRoleRef= ruleRoleRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRoleRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRoleRef_in_entryRuleRoleRef8720);
            iv_ruleRoleRef=ruleRoleRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRoleRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoleRef8730); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4111:1: ruleRoleRef returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleRoleRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4114:28: ( ( ( ruleQualifiedName ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4115:1: ( ( ruleQualifiedName ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4115:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4116:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4116:1: ( ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4117:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleRoleRef8781);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4143:1: entryRulePrivilegeRef returns [EObject current=null] : iv_rulePrivilegeRef= rulePrivilegeRef EOF ;
    public final EObject entryRulePrivilegeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrivilegeRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4144:2: (iv_rulePrivilegeRef= rulePrivilegeRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4145:2: iv_rulePrivilegeRef= rulePrivilegeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrivilegeRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrivilegeRef_in_entryRulePrivilegeRef8818);
            iv_rulePrivilegeRef=rulePrivilegeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrivilegeRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrivilegeRef8828); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4152:1: rulePrivilegeRef returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject rulePrivilegeRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4155:28: ( ( ( ruleQualifiedName ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4156:1: ( ( ruleQualifiedName ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4156:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4157:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4157:1: ( ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4158:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rulePrivilegeRef8879);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4184:1: entryRuleAssetRef returns [EObject current=null] : iv_ruleAssetRef= ruleAssetRef EOF ;
    public final EObject entryRuleAssetRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssetRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4185:2: (iv_ruleAssetRef= ruleAssetRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4186:2: iv_ruleAssetRef= ruleAssetRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssetRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAssetRef_in_entryRuleAssetRef8916);
            iv_ruleAssetRef=ruleAssetRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssetRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssetRef8926); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4193:1: ruleAssetRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )? ) ;
    public final EObject ruleAssetRef() throws RecognitionException {
        EObject current = null;

        EObject lv_versionRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4196:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )? ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4197:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )? )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4197:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )? )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4197:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )?
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4197:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4198:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4198:1: ( ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4199:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleAssetRef8978);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4215:2: ( (lv_versionRef_1_0= ruleVersionRef ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( ((LA94_0>=98 && LA94_0<=99)||(LA94_0>=102 && LA94_0<=103)) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4216:1: (lv_versionRef_1_0= ruleVersionRef )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4216:1: (lv_versionRef_1_0= ruleVersionRef )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4217:3: lv_versionRef_1_0= ruleVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssetRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleAssetRef8999);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4241:1: ruleHashAlgKind returns [Enumerator current=null] : ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'RSA' ) | (enumLiteral_4= 'PlainText' ) ) ;
    public final Enumerator ruleHashAlgKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4243:28: ( ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'RSA' ) | (enumLiteral_4= 'PlainText' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4244:1: ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'RSA' ) | (enumLiteral_4= 'PlainText' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4244:1: ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'RSA' ) | (enumLiteral_4= 'PlainText' ) )
            int alt95=5;
            switch ( input.LA(1) ) {
            case 107:
                {
                alt95=1;
                }
                break;
            case 108:
                {
                alt95=2;
                }
                break;
            case 109:
                {
                alt95=3;
                }
                break;
            case 110:
                {
                alt95=4;
                }
                break;
            case 111:
                {
                alt95=5;
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4244:2: (enumLiteral_0= 'MD5' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4244:2: (enumLiteral_0= 'MD5' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4244:4: enumLiteral_0= 'MD5'
                    {
                    enumLiteral_0=(Token)match(input,107,FollowSets000.FOLLOW_107_in_ruleHashAlgKind9050); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getMD5EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getHashAlgKindAccess().getMD5EnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4250:6: (enumLiteral_1= 'SHA1' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4250:6: (enumLiteral_1= 'SHA1' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4250:8: enumLiteral_1= 'SHA1'
                    {
                    enumLiteral_1=(Token)match(input,108,FollowSets000.FOLLOW_108_in_ruleHashAlgKind9067); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getSHA1EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getHashAlgKindAccess().getSHA1EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4256:6: (enumLiteral_2= 'SHA256' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4256:6: (enumLiteral_2= 'SHA256' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4256:8: enumLiteral_2= 'SHA256'
                    {
                    enumLiteral_2=(Token)match(input,109,FollowSets000.FOLLOW_109_in_ruleHashAlgKind9084); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getSHA256EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getHashAlgKindAccess().getSHA256EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4262:6: (enumLiteral_3= 'RSA' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4262:6: (enumLiteral_3= 'RSA' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4262:8: enumLiteral_3= 'RSA'
                    {
                    enumLiteral_3=(Token)match(input,110,FollowSets000.FOLLOW_110_in_ruleHashAlgKind9101); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getRSAEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getHashAlgKindAccess().getRSAEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4268:6: (enumLiteral_4= 'PlainText' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4268:6: (enumLiteral_4= 'PlainText' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4268:8: enumLiteral_4= 'PlainText'
                    {
                    enumLiteral_4=(Token)match(input,111,FollowSets000.FOLLOW_111_in_ruleHashAlgKind9118); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4278:1: ruleMessagePartRefKind returns [Enumerator current=null] : ( (enumLiteral_0= 'header' ) | (enumLiteral_1= 'body' ) | (enumLiteral_2= 'attachments' ) | (enumLiteral_3= 'all' ) | (enumLiteral_4= 'expression' ) ) ;
    public final Enumerator ruleMessagePartRefKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4280:28: ( ( (enumLiteral_0= 'header' ) | (enumLiteral_1= 'body' ) | (enumLiteral_2= 'attachments' ) | (enumLiteral_3= 'all' ) | (enumLiteral_4= 'expression' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4281:1: ( (enumLiteral_0= 'header' ) | (enumLiteral_1= 'body' ) | (enumLiteral_2= 'attachments' ) | (enumLiteral_3= 'all' ) | (enumLiteral_4= 'expression' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4281:1: ( (enumLiteral_0= 'header' ) | (enumLiteral_1= 'body' ) | (enumLiteral_2= 'attachments' ) | (enumLiteral_3= 'all' ) | (enumLiteral_4= 'expression' ) )
            int alt96=5;
            switch ( input.LA(1) ) {
            case 112:
                {
                alt96=1;
                }
                break;
            case 113:
                {
                alt96=2;
                }
                break;
            case 114:
                {
                alt96=3;
                }
                break;
            case 115:
                {
                alt96=4;
                }
                break;
            case 75:
                {
                alt96=5;
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4281:2: (enumLiteral_0= 'header' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4281:2: (enumLiteral_0= 'header' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4281:4: enumLiteral_0= 'header'
                    {
                    enumLiteral_0=(Token)match(input,112,FollowSets000.FOLLOW_112_in_ruleMessagePartRefKind9163); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getHeaderEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getMessagePartRefKindAccess().getHeaderEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4287:6: (enumLiteral_1= 'body' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4287:6: (enumLiteral_1= 'body' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4287:8: enumLiteral_1= 'body'
                    {
                    enumLiteral_1=(Token)match(input,113,FollowSets000.FOLLOW_113_in_ruleMessagePartRefKind9180); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getBodyEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getMessagePartRefKindAccess().getBodyEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4293:6: (enumLiteral_2= 'attachments' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4293:6: (enumLiteral_2= 'attachments' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4293:8: enumLiteral_2= 'attachments'
                    {
                    enumLiteral_2=(Token)match(input,114,FollowSets000.FOLLOW_114_in_ruleMessagePartRefKind9197); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getAttachmentsEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getMessagePartRefKindAccess().getAttachmentsEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4299:6: (enumLiteral_3= 'all' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4299:6: (enumLiteral_3= 'all' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4299:8: enumLiteral_3= 'all'
                    {
                    enumLiteral_3=(Token)match(input,115,FollowSets000.FOLLOW_115_in_ruleMessagePartRefKind9214); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getAllEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getMessagePartRefKindAccess().getAllEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4305:6: (enumLiteral_4= 'expression' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4305:6: (enumLiteral_4= 'expression' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4305:8: enumLiteral_4= 'expression'
                    {
                    enumLiteral_4=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleMessagePartRefKind9231); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4315:1: ruleSigningAlgothm returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'MD5' ) | (enumLiteral_4= 'RSA_1_5' ) | (enumLiteral_5= 'AES128' ) | (enumLiteral_6= 'AES192' ) | (enumLiteral_7= 'AES256' ) ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4317:28: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'MD5' ) | (enumLiteral_4= 'RSA_1_5' ) | (enumLiteral_5= 'AES128' ) | (enumLiteral_6= 'AES192' ) | (enumLiteral_7= 'AES256' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4318:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'MD5' ) | (enumLiteral_4= 'RSA_1_5' ) | (enumLiteral_5= 'AES128' ) | (enumLiteral_6= 'AES192' ) | (enumLiteral_7= 'AES256' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4318:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'MD5' ) | (enumLiteral_4= 'RSA_1_5' ) | (enumLiteral_5= 'AES128' ) | (enumLiteral_6= 'AES192' ) | (enumLiteral_7= 'AES256' ) )
            int alt97=8;
            switch ( input.LA(1) ) {
            case 116:
                {
                alt97=1;
                }
                break;
            case 108:
                {
                alt97=2;
                }
                break;
            case 109:
                {
                alt97=3;
                }
                break;
            case 107:
                {
                alt97=4;
                }
                break;
            case 117:
                {
                alt97=5;
                }
                break;
            case 118:
                {
                alt97=6;
                }
                break;
            case 119:
                {
                alt97=7;
                }
                break;
            case 120:
                {
                alt97=8;
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4318:2: (enumLiteral_0= 'NONE' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4318:2: (enumLiteral_0= 'NONE' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4318:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,116,FollowSets000.FOLLOW_116_in_ruleSigningAlgothm9276); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getSigningAlgothmAccess().getNONEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4324:6: (enumLiteral_1= 'SHA1' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4324:6: (enumLiteral_1= 'SHA1' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4324:8: enumLiteral_1= 'SHA1'
                    {
                    enumLiteral_1=(Token)match(input,108,FollowSets000.FOLLOW_108_in_ruleSigningAlgothm9293); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getSHA1EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getSigningAlgothmAccess().getSHA1EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4330:6: (enumLiteral_2= 'SHA256' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4330:6: (enumLiteral_2= 'SHA256' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4330:8: enumLiteral_2= 'SHA256'
                    {
                    enumLiteral_2=(Token)match(input,109,FollowSets000.FOLLOW_109_in_ruleSigningAlgothm9310); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getSHA256EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getSigningAlgothmAccess().getSHA256EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4336:6: (enumLiteral_3= 'MD5' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4336:6: (enumLiteral_3= 'MD5' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4336:8: enumLiteral_3= 'MD5'
                    {
                    enumLiteral_3=(Token)match(input,107,FollowSets000.FOLLOW_107_in_ruleSigningAlgothm9327); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getMD5EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getSigningAlgothmAccess().getMD5EnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4342:6: (enumLiteral_4= 'RSA_1_5' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4342:6: (enumLiteral_4= 'RSA_1_5' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4342:8: enumLiteral_4= 'RSA_1_5'
                    {
                    enumLiteral_4=(Token)match(input,117,FollowSets000.FOLLOW_117_in_ruleSigningAlgothm9344); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getRSA_1_5EnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getSigningAlgothmAccess().getRSA_1_5EnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4348:6: (enumLiteral_5= 'AES128' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4348:6: (enumLiteral_5= 'AES128' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4348:8: enumLiteral_5= 'AES128'
                    {
                    enumLiteral_5=(Token)match(input,118,FollowSets000.FOLLOW_118_in_ruleSigningAlgothm9361); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getAES128EnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getSigningAlgothmAccess().getAES128EnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4354:6: (enumLiteral_6= 'AES192' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4354:6: (enumLiteral_6= 'AES192' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4354:8: enumLiteral_6= 'AES192'
                    {
                    enumLiteral_6=(Token)match(input,119,FollowSets000.FOLLOW_119_in_ruleSigningAlgothm9378); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getAES192EnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getSigningAlgothmAccess().getAES192EnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4360:6: (enumLiteral_7= 'AES256' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4360:6: (enumLiteral_7= 'AES256' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4360:8: enumLiteral_7= 'AES256'
                    {
                    enumLiteral_7=(Token)match(input,120,FollowSets000.FOLLOW_120_in_ruleSigningAlgothm9395); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4370:1: ruleCipherAlgorithmKind returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'Basic128' ) | (enumLiteral_2= 'Basic192' ) | (enumLiteral_3= 'Basic256' ) | (enumLiteral_4= 'DES' ) | (enumLiteral_5= '3DES' ) | (enumLiteral_6= 'AES128' ) | (enumLiteral_7= 'AES256' ) ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4372:28: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'Basic128' ) | (enumLiteral_2= 'Basic192' ) | (enumLiteral_3= 'Basic256' ) | (enumLiteral_4= 'DES' ) | (enumLiteral_5= '3DES' ) | (enumLiteral_6= 'AES128' ) | (enumLiteral_7= 'AES256' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4373:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'Basic128' ) | (enumLiteral_2= 'Basic192' ) | (enumLiteral_3= 'Basic256' ) | (enumLiteral_4= 'DES' ) | (enumLiteral_5= '3DES' ) | (enumLiteral_6= 'AES128' ) | (enumLiteral_7= 'AES256' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4373:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'Basic128' ) | (enumLiteral_2= 'Basic192' ) | (enumLiteral_3= 'Basic256' ) | (enumLiteral_4= 'DES' ) | (enumLiteral_5= '3DES' ) | (enumLiteral_6= 'AES128' ) | (enumLiteral_7= 'AES256' ) )
            int alt98=8;
            switch ( input.LA(1) ) {
            case 116:
                {
                alt98=1;
                }
                break;
            case 121:
                {
                alt98=2;
                }
                break;
            case 122:
                {
                alt98=3;
                }
                break;
            case 123:
                {
                alt98=4;
                }
                break;
            case 124:
                {
                alt98=5;
                }
                break;
            case 125:
                {
                alt98=6;
                }
                break;
            case 118:
                {
                alt98=7;
                }
                break;
            case 120:
                {
                alt98=8;
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4373:2: (enumLiteral_0= 'NONE' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4373:2: (enumLiteral_0= 'NONE' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4373:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,116,FollowSets000.FOLLOW_116_in_ruleCipherAlgorithmKind9440); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getCipherAlgorithmKindAccess().getNONEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4379:6: (enumLiteral_1= 'Basic128' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4379:6: (enumLiteral_1= 'Basic128' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4379:8: enumLiteral_1= 'Basic128'
                    {
                    enumLiteral_1=(Token)match(input,121,FollowSets000.FOLLOW_121_in_ruleCipherAlgorithmKind9457); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getBasic128EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getCipherAlgorithmKindAccess().getBasic128EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4385:6: (enumLiteral_2= 'Basic192' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4385:6: (enumLiteral_2= 'Basic192' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4385:8: enumLiteral_2= 'Basic192'
                    {
                    enumLiteral_2=(Token)match(input,122,FollowSets000.FOLLOW_122_in_ruleCipherAlgorithmKind9474); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getBasic192EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getCipherAlgorithmKindAccess().getBasic192EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4391:6: (enumLiteral_3= 'Basic256' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4391:6: (enumLiteral_3= 'Basic256' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4391:8: enumLiteral_3= 'Basic256'
                    {
                    enumLiteral_3=(Token)match(input,123,FollowSets000.FOLLOW_123_in_ruleCipherAlgorithmKind9491); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getBasic256EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getCipherAlgorithmKindAccess().getBasic256EnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4397:6: (enumLiteral_4= 'DES' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4397:6: (enumLiteral_4= 'DES' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4397:8: enumLiteral_4= 'DES'
                    {
                    enumLiteral_4=(Token)match(input,124,FollowSets000.FOLLOW_124_in_ruleCipherAlgorithmKind9508); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getDESEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getCipherAlgorithmKindAccess().getDESEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4403:6: (enumLiteral_5= '3DES' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4403:6: (enumLiteral_5= '3DES' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4403:8: enumLiteral_5= '3DES'
                    {
                    enumLiteral_5=(Token)match(input,125,FollowSets000.FOLLOW_125_in_ruleCipherAlgorithmKind9525); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getTRIPLE_DESEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getCipherAlgorithmKindAccess().getTRIPLE_DESEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4409:6: (enumLiteral_6= 'AES128' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4409:6: (enumLiteral_6= 'AES128' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4409:8: enumLiteral_6= 'AES128'
                    {
                    enumLiteral_6=(Token)match(input,118,FollowSets000.FOLLOW_118_in_ruleCipherAlgorithmKind9542); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getAES128EnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getCipherAlgorithmKindAccess().getAES128EnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4415:6: (enumLiteral_7= 'AES256' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4415:6: (enumLiteral_7= 'AES256' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4415:8: enumLiteral_7= 'AES256'
                    {
                    enumLiteral_7=(Token)match(input,120,FollowSets000.FOLLOW_120_in_ruleCipherAlgorithmKind9559); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4425:1: ruleAuthTokenKind returns [Enumerator current=null] : ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'SPNEGO' ) | (enumLiteral_5= 'RELToken' ) | (enumLiteral_6= 'X509Certificate' ) | (enumLiteral_7= 'OAuth' ) | (enumLiteral_8= 'OAuth2' ) ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4427:28: ( ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'SPNEGO' ) | (enumLiteral_5= 'RELToken' ) | (enumLiteral_6= 'X509Certificate' ) | (enumLiteral_7= 'OAuth' ) | (enumLiteral_8= 'OAuth2' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4428:1: ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'SPNEGO' ) | (enumLiteral_5= 'RELToken' ) | (enumLiteral_6= 'X509Certificate' ) | (enumLiteral_7= 'OAuth' ) | (enumLiteral_8= 'OAuth2' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4428:1: ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'SPNEGO' ) | (enumLiteral_5= 'RELToken' ) | (enumLiteral_6= 'X509Certificate' ) | (enumLiteral_7= 'OAuth' ) | (enumLiteral_8= 'OAuth2' ) )
            int alt99=9;
            switch ( input.LA(1) ) {
            case 126:
                {
                alt99=1;
                }
                break;
            case 127:
                {
                alt99=2;
                }
                break;
            case 128:
                {
                alt99=3;
                }
                break;
            case 129:
                {
                alt99=4;
                }
                break;
            case 130:
                {
                alt99=5;
                }
                break;
            case 131:
                {
                alt99=6;
                }
                break;
            case 132:
                {
                alt99=7;
                }
                break;
            case 133:
                {
                alt99=8;
                }
                break;
            case 134:
                {
                alt99=9;
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4428:2: (enumLiteral_0= 'UsernamePassword' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4428:2: (enumLiteral_0= 'UsernamePassword' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4428:4: enumLiteral_0= 'UsernamePassword'
                    {
                    enumLiteral_0=(Token)match(input,126,FollowSets000.FOLLOW_126_in_ruleAuthTokenKind9604); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getUsernamePasswordEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAuthTokenKindAccess().getUsernamePasswordEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4434:6: (enumLiteral_1= 'SAML' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4434:6: (enumLiteral_1= 'SAML' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4434:8: enumLiteral_1= 'SAML'
                    {
                    enumLiteral_1=(Token)match(input,127,FollowSets000.FOLLOW_127_in_ruleAuthTokenKind9621); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSAMLEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getAuthTokenKindAccess().getSAMLEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4440:6: (enumLiteral_2= 'SAML2' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4440:6: (enumLiteral_2= 'SAML2' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4440:8: enumLiteral_2= 'SAML2'
                    {
                    enumLiteral_2=(Token)match(input,128,FollowSets000.FOLLOW_128_in_ruleAuthTokenKind9638); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSAML2EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getAuthTokenKindAccess().getSAML2EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4446:6: (enumLiteral_3= 'Kerberos' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4446:6: (enumLiteral_3= 'Kerberos' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4446:8: enumLiteral_3= 'Kerberos'
                    {
                    enumLiteral_3=(Token)match(input,129,FollowSets000.FOLLOW_129_in_ruleAuthTokenKind9655); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getKerberosEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getAuthTokenKindAccess().getKerberosEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4452:6: (enumLiteral_4= 'SPNEGO' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4452:6: (enumLiteral_4= 'SPNEGO' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4452:8: enumLiteral_4= 'SPNEGO'
                    {
                    enumLiteral_4=(Token)match(input,130,FollowSets000.FOLLOW_130_in_ruleAuthTokenKind9672); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSPNEGOEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getAuthTokenKindAccess().getSPNEGOEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4458:6: (enumLiteral_5= 'RELToken' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4458:6: (enumLiteral_5= 'RELToken' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4458:8: enumLiteral_5= 'RELToken'
                    {
                    enumLiteral_5=(Token)match(input,131,FollowSets000.FOLLOW_131_in_ruleAuthTokenKind9689); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getRELTokenEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getAuthTokenKindAccess().getRELTokenEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4464:6: (enumLiteral_6= 'X509Certificate' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4464:6: (enumLiteral_6= 'X509Certificate' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4464:8: enumLiteral_6= 'X509Certificate'
                    {
                    enumLiteral_6=(Token)match(input,132,FollowSets000.FOLLOW_132_in_ruleAuthTokenKind9706); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getX509CertificateEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getAuthTokenKindAccess().getX509CertificateEnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4470:6: (enumLiteral_7= 'OAuth' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4470:6: (enumLiteral_7= 'OAuth' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4470:8: enumLiteral_7= 'OAuth'
                    {
                    enumLiteral_7=(Token)match(input,133,FollowSets000.FOLLOW_133_in_ruleAuthTokenKind9723); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getOAuthEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_7, grammarAccess.getAuthTokenKindAccess().getOAuthEnumLiteralDeclaration_7()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4476:6: (enumLiteral_8= 'OAuth2' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4476:6: (enumLiteral_8= 'OAuth2' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4476:8: enumLiteral_8= 'OAuth2'
                    {
                    enumLiteral_8=(Token)match(input,134,FollowSets000.FOLLOW_134_in_ruleAuthTokenKind9740); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4486:1: ruleLogRequirementKind returns [Enumerator current=null] : ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'header' ) | (enumLiteral_2= 'all' ) ) ;
    public final Enumerator ruleLogRequirementKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4488:28: ( ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'header' ) | (enumLiteral_2= 'all' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4489:1: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'header' ) | (enumLiteral_2= 'all' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4489:1: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'header' ) | (enumLiteral_2= 'all' ) )
            int alt100=3;
            switch ( input.LA(1) ) {
            case 135:
                {
                alt100=1;
                }
                break;
            case 112:
                {
                alt100=2;
                }
                break;
            case 115:
                {
                alt100=3;
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4489:2: (enumLiteral_0= 'none' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4489:2: (enumLiteral_0= 'none' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4489:4: enumLiteral_0= 'none'
                    {
                    enumLiteral_0=(Token)match(input,135,FollowSets000.FOLLOW_135_in_ruleLogRequirementKind9785); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getLogRequirementKindAccess().getNoneEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getLogRequirementKindAccess().getNoneEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4495:6: (enumLiteral_1= 'header' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4495:6: (enumLiteral_1= 'header' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4495:8: enumLiteral_1= 'header'
                    {
                    enumLiteral_1=(Token)match(input,112,FollowSets000.FOLLOW_112_in_ruleLogRequirementKind9802); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getLogRequirementKindAccess().getHeaderEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getLogRequirementKindAccess().getHeaderEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4501:6: (enumLiteral_2= 'all' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4501:6: (enumLiteral_2= 'all' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4501:8: enumLiteral_2= 'all'
                    {
                    enumLiteral_2=(Token)match(input,115,FollowSets000.FOLLOW_115_in_ruleLogRequirementKind9819); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4511:1: ruleReliablilityKind returns [Enumerator current=null] : ( (enumLiteral_0= 'exactly-once' ) | (enumLiteral_1= 'at-most-once' ) | (enumLiteral_2= 'at-least-once' ) | (enumLiteral_3= 'best-effort' ) ) ;
    public final Enumerator ruleReliablilityKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4513:28: ( ( (enumLiteral_0= 'exactly-once' ) | (enumLiteral_1= 'at-most-once' ) | (enumLiteral_2= 'at-least-once' ) | (enumLiteral_3= 'best-effort' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4514:1: ( (enumLiteral_0= 'exactly-once' ) | (enumLiteral_1= 'at-most-once' ) | (enumLiteral_2= 'at-least-once' ) | (enumLiteral_3= 'best-effort' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4514:1: ( (enumLiteral_0= 'exactly-once' ) | (enumLiteral_1= 'at-most-once' ) | (enumLiteral_2= 'at-least-once' ) | (enumLiteral_3= 'best-effort' ) )
            int alt101=4;
            switch ( input.LA(1) ) {
            case 136:
                {
                alt101=1;
                }
                break;
            case 137:
                {
                alt101=2;
                }
                break;
            case 138:
                {
                alt101=3;
                }
                break;
            case 139:
                {
                alt101=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }

            switch (alt101) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4514:2: (enumLiteral_0= 'exactly-once' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4514:2: (enumLiteral_0= 'exactly-once' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4514:4: enumLiteral_0= 'exactly-once'
                    {
                    enumLiteral_0=(Token)match(input,136,FollowSets000.FOLLOW_136_in_ruleReliablilityKind9864); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReliablilityKindAccess().getEXACTLY_ONCEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getReliablilityKindAccess().getEXACTLY_ONCEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4520:6: (enumLiteral_1= 'at-most-once' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4520:6: (enumLiteral_1= 'at-most-once' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4520:8: enumLiteral_1= 'at-most-once'
                    {
                    enumLiteral_1=(Token)match(input,137,FollowSets000.FOLLOW_137_in_ruleReliablilityKind9881); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReliablilityKindAccess().getAT_MOST_ONCEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getReliablilityKindAccess().getAT_MOST_ONCEEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4526:6: (enumLiteral_2= 'at-least-once' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4526:6: (enumLiteral_2= 'at-least-once' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4526:8: enumLiteral_2= 'at-least-once'
                    {
                    enumLiteral_2=(Token)match(input,138,FollowSets000.FOLLOW_138_in_ruleReliablilityKind9898); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReliablilityKindAccess().getAT_LEAST_ONCEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getReliablilityKindAccess().getAT_LEAST_ONCEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4532:6: (enumLiteral_3= 'best-effort' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4532:6: (enumLiteral_3= 'best-effort' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4532:8: enumLiteral_3= 'best-effort'
                    {
                    enumLiteral_3=(Token)match(input,139,FollowSets000.FOLLOW_139_in_ruleReliablilityKind9915); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4542:1: ruleGovernanceDecisionResult returns [Enumerator current=null] : ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) ) ;
    public final Enumerator ruleGovernanceDecisionResult() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4544:28: ( ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4545:1: ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4545:1: ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) )
            int alt102=4;
            switch ( input.LA(1) ) {
            case 140:
                {
                alt102=1;
                }
                break;
            case 141:
                {
                alt102=2;
                }
                break;
            case 142:
                {
                alt102=3;
                }
                break;
            case 143:
                {
                alt102=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }

            switch (alt102) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4545:2: (enumLiteral_0= 'pending' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4545:2: (enumLiteral_0= 'pending' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4545:4: enumLiteral_0= 'pending'
                    {
                    enumLiteral_0=(Token)match(input,140,FollowSets000.FOLLOW_140_in_ruleGovernanceDecisionResult9960); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getPendingEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getGovernanceDecisionResultAccess().getPendingEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4551:6: (enumLiteral_1= 'accepted' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4551:6: (enumLiteral_1= 'accepted' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4551:8: enumLiteral_1= 'accepted'
                    {
                    enumLiteral_1=(Token)match(input,141,FollowSets000.FOLLOW_141_in_ruleGovernanceDecisionResult9977); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getAcceptedEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getGovernanceDecisionResultAccess().getAcceptedEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4557:6: (enumLiteral_2= 'denied' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4557:6: (enumLiteral_2= 'denied' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4557:8: enumLiteral_2= 'denied'
                    {
                    enumLiteral_2=(Token)match(input,142,FollowSets000.FOLLOW_142_in_ruleGovernanceDecisionResult9994); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getDeniedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getGovernanceDecisionResultAccess().getDeniedEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4563:6: (enumLiteral_3= 'specific' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4563:6: (enumLiteral_3= 'specific' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4563:8: enumLiteral_3= 'specific'
                    {
                    enumLiteral_3=(Token)match(input,143,FollowSets000.FOLLOW_143_in_ruleGovernanceDecisionResult10011); if (state.failed) return current;
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
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSLA240 = new BitSet(new long[]{0x0000000000001000L,0x0000000200000000L});
        public static final BitSet FOLLOW_ruleVersion_in_ruleSLA261 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSLA274 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleSLA286 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA303 = new BitSet(new long[]{0x000000080017C000L});
        public static final BitSet FOLLOW_14_in_ruleSLA321 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA338 = new BitSet(new long[]{0x0000000800178000L});
        public static final BitSet FOLLOW_15_in_ruleSLA358 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA375 = new BitSet(new long[]{0x0000000800170000L});
        public static final BitSet FOLLOW_16_in_ruleSLA395 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA412 = new BitSet(new long[]{0x0000000800160000L});
        public static final BitSet FOLLOW_17_in_ruleSLA432 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA449 = new BitSet(new long[]{0x0000000800140000L});
        public static final BitSet FOLLOW_18_in_ruleSLA469 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSLA481 = new BitSet(new long[]{0x0000000000080020L});
        public static final BitSet FOLLOW_ruleAssetRef_in_ruleSLA502 = new BitSet(new long[]{0x0000000000080020L});
        public static final BitSet FOLLOW_19_in_ruleSLA515 = new BitSet(new long[]{0x0000000800100000L});
        public static final BitSet FOLLOW_ruleCost_in_ruleSLA538 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleSLA552 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSLA564 = new BitSet(new long[]{0x0545288000080000L});
        public static final BitSet FOLLOW_ruleServiceQualityProperty_in_ruleSLA585 = new BitSet(new long[]{0x0545288000080000L});
        public static final BitSet FOLLOW_19_in_ruleSLA598 = new BitSet(new long[]{0x000000043F280000L,0x000000001038C000L});
        public static final BitSet FOLLOW_21_in_ruleSLA612 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSLA624 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_22_in_ruleSLA637 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA654 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleSLA674 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSLA686 = new BitSet(new long[]{0x8000000000080000L,0x0000000000001040L});
        public static final BitSet FOLLOW_ruleSecurityRequirement_in_ruleSLA707 = new BitSet(new long[]{0x8000000000080000L,0x0000000000001040L});
        public static final BitSet FOLLOW_19_in_ruleSLA720 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleSLA733 = new BitSet(new long[]{0x000000043F080000L,0x000000001038C000L});
        public static final BitSet FOLLOW_24_in_ruleSLA748 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA765 = new BitSet(new long[]{0x000000043E080000L,0x000000001038C000L});
        public static final BitSet FOLLOW_rulePriorityDeclaration_in_ruleSLA793 = new BitSet(new long[]{0x000000043E080000L,0x000000001038C000L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleSLA815 = new BitSet(new long[]{0x000000043E080000L,0x0000000010380000L});
        public static final BitSet FOLLOW_25_in_ruleSLA829 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA846 = new BitSet(new long[]{0x000000043C080000L,0x0000000010380000L});
        public static final BitSet FOLLOW_ruleParty_in_ruleSLA874 = new BitSet(new long[]{0x000000043C080000L,0x0000000010380000L});
        public static final BitSet FOLLOW_26_in_ruleSLA888 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA905 = new BitSet(new long[]{0x0000000438080000L,0x0000000010000000L});
        public static final BitSet FOLLOW_27_in_ruleSLA925 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA942 = new BitSet(new long[]{0x0000000430080000L,0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleSLA962 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA979 = new BitSet(new long[]{0x0000000420080000L,0x0000000010000000L});
        public static final BitSet FOLLOW_ruleReport_in_ruleSLA1007 = new BitSet(new long[]{0x0000000420080000L,0x0000000010000000L});
        public static final BitSet FOLLOW_29_in_ruleSLA1021 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSLA1033 = new BitSet(new long[]{0x00000007C0080000L});
        public static final BitSet FOLLOW_30_in_ruleSLA1046 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSLA1073 = new BitSet(new long[]{0x0000000780080000L});
        public static final BitSet FOLLOW_31_in_ruleSLA1088 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSLA1115 = new BitSet(new long[]{0x0000000780080000L});
        public static final BitSet FOLLOW_32_in_ruleSLA1130 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSLA1157 = new BitSet(new long[]{0x0000000600080000L});
        public static final BitSet FOLLOW_33_in_ruleSLA1172 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSLA1184 = new BitSet(new long[]{0x0000000000080020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSLA1211 = new BitSet(new long[]{0x0000000000080020L});
        public static final BitSet FOLLOW_19_in_ruleSLA1224 = new BitSet(new long[]{0x0000000400080000L});
        public static final BitSet FOLLOW_34_in_ruleSLA1241 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSLA1265 = new BitSet(new long[]{0x0000000400080020L});
        public static final BitSet FOLLOW_19_in_ruleSLA1280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCost_in_entryRuleCost1316 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCost1326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleCost1363 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleCost1375 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleCost1387 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCost1404 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_37_in_ruleCost1421 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCost1438 = new BitSet(new long[]{0x0000004000080000L,0x0000000000008000L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleCost1464 = new BitSet(new long[]{0x0000004000080000L});
        public static final BitSet FOLLOW_38_in_ruleCost1478 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCost1495 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleCost1514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceQualityProperty_in_entryRuleServiceQualityProperty1550 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleServiceQualityProperty1560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAvailability_in_ruleServiceQualityProperty1610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThroughput_in_ruleServiceQualityProperty1640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLatency_in_ruleServiceQualityProperty1670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxDownTime_in_ruleServiceQualityProperty1700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCapacityRequirement_in_ruleServiceQualityProperty1730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAccuracyRequirement_in_ruleServiceQualityProperty1760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReliablityRequirement_in_ruleServiceQualityProperty1790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLogRequirement_in_ruleServiceQualityProperty1820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAvailability_in_entryRuleAvailability1855 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAvailability1865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleAvailability1902 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAvailability1914 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_39_in_ruleAvailability1926 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAvailability1943 = new BitSet(new long[]{0x0000070000080000L});
        public static final BitSet FOLLOW_40_in_ruleAvailability1961 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAvailability1978 = new BitSet(new long[]{0x0000060000080000L});
        public static final BitSet FOLLOW_41_in_ruleAvailability1998 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAvailability2015 = new BitSet(new long[]{0x0000040000080040L});
        public static final BitSet FOLLOW_rulePercentile_in_ruleAvailability2041 = new BitSet(new long[]{0x0000040000080000L});
        public static final BitSet FOLLOW_42_in_ruleAvailability2057 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAvailability2074 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleAvailability2093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThroughput_in_entryRuleThroughput2129 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleThroughput2139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleThroughput2176 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleThroughput2188 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_43_in_ruleThroughput2200 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleThroughput2217 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_ruleThroughput2234 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleThroughput2251 = new BitSet(new long[]{0x0000004000080000L,0x0000000000008000L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleThroughput2277 = new BitSet(new long[]{0x0000004000080000L});
        public static final BitSet FOLLOW_38_in_ruleThroughput2291 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleThroughput2308 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleThroughput2327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLatency_in_entryRuleLatency2363 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLatency2373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleLatency2410 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleLatency2422 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleLatency2434 = new BitSet(new long[]{0x0000400000000000L});
        public static final BitSet FOLLOW_46_in_ruleLatency2452 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleLatency2477 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rulePercentile_in_ruleLatency2498 = new BitSet(new long[]{0x0000004000080000L,0x0000000000008000L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleLatency2519 = new BitSet(new long[]{0x0000004000080000L});
        public static final BitSet FOLLOW_38_in_ruleLatency2533 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleLatency2550 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleLatency2569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxDownTime_in_entryRuleMaxDownTime2605 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxDownTime2615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleMaxDownTime2652 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleMaxDownTime2664 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleMaxDownTime2676 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleMaxDownTime2693 = new BitSet(new long[]{0x0000004000080000L,0x0000000000008000L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleMaxDownTime2719 = new BitSet(new long[]{0x0000004000080000L});
        public static final BitSet FOLLOW_38_in_ruleMaxDownTime2733 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleMaxDownTime2750 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleMaxDownTime2769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCapacityRequirement_in_entryRuleCapacityRequirement2805 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCapacityRequirement2815 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleCapacityRequirement2852 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleCapacityRequirement2864 = new BitSet(new long[]{0x0028004000080000L,0x0000000000008000L});
        public static final BitSet FOLLOW_51_in_ruleCapacityRequirement2889 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCapacityRequirement2906 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_52_in_ruleCapacityRequirement2923 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCapacityRequirement2940 = new BitSet(new long[]{0x0020004000080000L,0x0000000000008000L});
        public static final BitSet FOLLOW_53_in_ruleCapacityRequirement2960 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCapacityRequirement2977 = new BitSet(new long[]{0x0000004000080000L,0x0000000000008000L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleCapacityRequirement3005 = new BitSet(new long[]{0x0000004000080000L});
        public static final BitSet FOLLOW_38_in_ruleCapacityRequirement3019 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCapacityRequirement3036 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleCapacityRequirement3055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReliablityRequirement_in_entryRuleReliablityRequirement3091 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReliablityRequirement3101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleReliablityRequirement3138 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleReliablityRequirement3150 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000F00L});
        public static final BitSet FOLLOW_ruleReliablilityKind_in_ruleReliablityRequirement3171 = new BitSet(new long[]{0x0080000000080000L});
        public static final BitSet FOLLOW_55_in_ruleReliablityRequirement3189 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleReliablityRequirement3215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAccuracyRequirement_in_entryRuleAccuracyRequirement3251 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAccuracyRequirement3261 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleAccuracyRequirement3298 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAccuracyRequirement3310 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_57_in_ruleAccuracyRequirement3322 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAccuracyRequirement3339 = new BitSet(new long[]{0x0000004000080000L,0x0000000000008000L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleAccuracyRequirement3365 = new BitSet(new long[]{0x0000004000080000L});
        public static final BitSet FOLLOW_38_in_ruleAccuracyRequirement3379 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAccuracyRequirement3396 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleAccuracyRequirement3415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLogRequirement_in_entryRuleLogRequirement3451 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLogRequirement3461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleLogRequirement3498 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleLogRequirement3510 = new BitSet(new long[]{0x0800000000000000L});
        public static final BitSet FOLLOW_59_in_ruleLogRequirement3522 = new BitSet(new long[]{0x0000000000000000L,0x0009000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_ruleLogRequirementKind_in_ruleLogRequirement3543 = new BitSet(new long[]{0x1000000000000000L});
        public static final BitSet FOLLOW_60_in_ruleLogRequirement3555 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleLogRequirement3572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePercentile_in_entryRulePercentile3613 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePercentile3623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rulePercentile3665 = new BitSet(new long[]{0x6000000000000000L});
        public static final BitSet FOLLOW_61_in_rulePercentile3683 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_rulePercentile3694 = new BitSet(new long[]{0x6000000000000000L});
        public static final BitSet FOLLOW_62_in_rulePercentile3707 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecurityRequirement_in_entryRuleSecurityRequirement3743 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecurityRequirement3753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthenticationRequirement_in_ruleSecurityRequirement3803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSigningRequirement_in_ruleSecurityRequirement3833 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEncryptionRequirement_in_ruleSecurityRequirement3863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthenticationRequirement_in_entryRuleAuthenticationRequirement3898 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAuthenticationRequirement3908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleAuthenticationRequirement3957 = new BitSet(new long[]{0x0000000000001000L,0x0000000000000001L});
        public static final BitSet FOLLOW_64_in_ruleAuthenticationRequirement3975 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAuthenticationRequirement4001 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleAuthenticationRequirement4013 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAuthenticationRequirement4025 = new BitSet(new long[]{0x0000000000000000L,0xC000000000000001L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleAuthToken_in_ruleAuthenticationRequirement4046 = new BitSet(new long[]{0x0000000000080000L,0xC000000000000001L,0x000000000000007FL});
        public static final BitSet FOLLOW_19_in_ruleAuthenticationRequirement4059 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_66_in_ruleAuthenticationRequirement4071 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAuthenticationRequirement4083 = new BitSet(new long[]{0x0000000000080000L,0x0000F80000000021L});
        public static final BitSet FOLLOW_ruleHashAlgorithm_in_ruleAuthenticationRequirement4104 = new BitSet(new long[]{0x0000000000080000L,0x0000F80000000021L});
        public static final BitSet FOLLOW_19_in_ruleAuthenticationRequirement4117 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000018L});
        public static final BitSet FOLLOW_67_in_ruleAuthenticationRequirement4135 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000010L});
        public static final BitSet FOLLOW_68_in_ruleAuthenticationRequirement4162 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAuthenticationRequirement4179 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleAuthenticationRequirement4198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthToken_in_entryRuleAuthToken4234 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAuthToken4244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_ruleAuthToken4287 = new BitSet(new long[]{0x0000000000000000L,0xC000000000000001L,0x000000000000007FL});
        public static final BitSet FOLLOW_ruleAuthTokenKind_in_ruleAuthToken4322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHashAlgorithm_in_entryRuleHashAlgorithm4358 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHashAlgorithm4368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_ruleHashAlgorithm4411 = new BitSet(new long[]{0x0000000000000000L,0x0000F80000000021L});
        public static final BitSet FOLLOW_69_in_ruleHashAlgorithm4443 = new BitSet(new long[]{0x0000000000000000L,0x0000F80000000021L});
        public static final BitSet FOLLOW_ruleHashAlgKind_in_ruleHashAlgorithm4478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSigningRequirement_in_entryRuleSigningRequirement4514 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSigningRequirement4524 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleSigningRequirement4573 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSigningRequirement4585 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000380L});
        public static final BitSet FOLLOW_71_in_ruleSigningRequirement4598 = new BitSet(new long[]{0x0000000000000000L,0x01F0380000000000L});
        public static final BitSet FOLLOW_ruleSigningAlgothm_in_ruleSigningRequirement4619 = new BitSet(new long[]{0x0000000000080000L,0x01F0380000000300L});
        public static final BitSet FOLLOW_72_in_ruleSigningRequirement4635 = new BitSet(new long[]{0x0000000000000000L,0x01F0380000000000L});
        public static final BitSet FOLLOW_ruleSigningAlgothm_in_ruleSigningRequirement4656 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000200L});
        public static final BitSet FOLLOW_73_in_ruleSigningRequirement4671 = new BitSet(new long[]{0x0000000000000000L,0x000F000000000800L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_ruleSigningRequirement4692 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000400L});
        public static final BitSet FOLLOW_74_in_ruleSigningRequirement4705 = new BitSet(new long[]{0x0000000000000000L,0x000F000000000800L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_ruleSigningRequirement4726 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000400L});
        public static final BitSet FOLLOW_19_in_ruleSigningRequirement4742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_entryRuleMessagePartRef4778 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMessagePartRef4788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMessagePartRefKind_in_ruleMessagePartRef4834 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
        public static final BitSet FOLLOW_75_in_ruleMessagePartRef4847 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleMessagePartRef4864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEncryptionRequirement_in_entryRuleEncryptionRequirement4907 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEncryptionRequirement4917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_76_in_ruleEncryptionRequirement4966 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEncryptionRequirement4978 = new BitSet(new long[]{0x0000000000080000L,0x0000000000002180L});
        public static final BitSet FOLLOW_71_in_ruleEncryptionRequirement4991 = new BitSet(new long[]{0x0000000000000000L,0x3F50000000000000L});
        public static final BitSet FOLLOW_ruleCipherAlgorithmKind_in_ruleEncryptionRequirement5012 = new BitSet(new long[]{0x0000000000080000L,0x3F50000000002100L});
        public static final BitSet FOLLOW_72_in_ruleEncryptionRequirement5028 = new BitSet(new long[]{0x0000000000000000L,0x3F50000000000000L});
        public static final BitSet FOLLOW_ruleCipherAlgorithmKind_in_ruleEncryptionRequirement5049 = new BitSet(new long[]{0x0000000000080000L,0x0000000000002000L});
        public static final BitSet FOLLOW_77_in_ruleEncryptionRequirement5064 = new BitSet(new long[]{0x0000000000000000L,0x000F000000000800L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_ruleEncryptionRequirement5085 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000400L});
        public static final BitSet FOLLOW_74_in_ruleEncryptionRequirement5098 = new BitSet(new long[]{0x0000000000000000L,0x000F000000000800L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_ruleEncryptionRequirement5119 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000400L});
        public static final BitSet FOLLOW_19_in_ruleEncryptionRequirement5135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePriorityDeclaration_in_entryRulePriorityDeclaration5171 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePriorityDeclaration5181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_78_in_rulePriorityDeclaration5218 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePriorityDeclaration5235 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_rulePriorityDeclaration5252 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_rulePriorityDeclaration5269 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEscalation_in_entryRuleEscalation5310 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEscalation5320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_79_in_ruleEscalation5357 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEscalation5369 = new BitSet(new long[]{0x0000000000000000L,0x0000000000030000L});
        public static final BitSet FOLLOW_80_in_ruleEscalation5382 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEscalation5399 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
        public static final BitSet FOLLOW_81_in_ruleEscalation5418 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEscalation5430 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleEscalation5457 = new BitSet(new long[]{0x0000000000080020L});
        public static final BitSet FOLLOW_19_in_ruleEscalation5470 = new BitSet(new long[]{0x0000000000080000L,0x0000000000040000L});
        public static final BitSet FOLLOW_82_in_ruleEscalation5483 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEscalation5500 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleEscalation5519 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParty_in_entryRuleParty5555 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParty5565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCustomerParty_in_ruleParty5615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProviderParty_in_ruleParty5645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdParty_in_ruleParty5675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCustomerParty_in_entryRuleCustomerParty5710 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCustomerParty5720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_83_in_ruleCustomerParty5757 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCustomerParty5778 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleCustomerParty5790 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleRepesentative_in_ruleCustomerParty5811 = new BitSet(new long[]{0x0000000000000000L,0x0000000088800000L});
        public static final BitSet FOLLOW_ruleResponsibility_in_ruleCustomerParty5833 = new BitSet(new long[]{0x0000000000080000L,0x0000000088000000L});
        public static final BitSet FOLLOW_19_in_ruleCustomerParty5846 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProviderParty_in_entryRuleProviderParty5882 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProviderParty5892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_84_in_ruleProviderParty5929 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleProviderParty5950 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleProviderParty5962 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleRepesentative_in_ruleProviderParty5983 = new BitSet(new long[]{0x0000000000000000L,0x0000000088800000L});
        public static final BitSet FOLLOW_ruleResponsibility_in_ruleProviderParty6005 = new BitSet(new long[]{0x0000000000080000L,0x0000000088000000L});
        public static final BitSet FOLLOW_19_in_ruleProviderParty6018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdParty_in_entryRuleThirdParty6054 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleThirdParty6064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_85_in_ruleThirdParty6101 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleThirdParty6122 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleThirdParty6134 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
        public static final BitSet FOLLOW_86_in_ruleThirdParty6146 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleThirdParty6163 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleRepesentative_in_ruleThirdParty6189 = new BitSet(new long[]{0x0000000000000000L,0x0000000088800000L});
        public static final BitSet FOLLOW_ruleResponsibility_in_ruleThirdParty6211 = new BitSet(new long[]{0x0000000000080000L,0x0000000088000000L});
        public static final BitSet FOLLOW_19_in_ruleThirdParty6224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRepesentative_in_entryRuleRepesentative6260 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRepesentative6270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_87_in_ruleRepesentative6307 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleRepesentative6319 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
        public static final BitSet FOLLOW_88_in_ruleRepesentative6331 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleRepesentative6348 = new BitSet(new long[]{0x0000000000080000L,0x0000000006000000L});
        public static final BitSet FOLLOW_89_in_ruleRepesentative6366 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleRepesentative6383 = new BitSet(new long[]{0x0000000000080000L,0x0000000004000000L});
        public static final BitSet FOLLOW_90_in_ruleRepesentative6403 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleRepesentative6420 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleRepesentative6439 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleResponsibility_in_entryRuleResponsibility6475 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleResponsibility6485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleResponsibility_in_ruleResponsibility6535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReportingResponsibility_in_ruleResponsibility6565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleResponsibility_in_entryRuleSimpleResponsibility6600 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleResponsibility6610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_91_in_ruleSimpleResponsibility6647 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSimpleResponsibility6668 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSimpleResponsibility6680 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSimpleResponsibility6697 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleSimpleResponsibility6723 = new BitSet(new long[]{0x0000000000000010L,0x0000000000008000L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSimpleResponsibility6741 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleSimpleResponsibility6758 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReport_in_entryRuleReport6794 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReport6804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_92_in_ruleReport6841 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReport6858 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleReport6875 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
        public static final BitSet FOLLOW_93_in_ruleReport6887 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReport6904 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
        public static final BitSet FOLLOW_94_in_ruleReport6921 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReport6938 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleReport6955 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReportingResponsibility_in_entryRuleReportingResponsibility6991 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReportingResponsibility7001 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_95_in_ruleReportingResponsibility7038 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReportingResponsibility7055 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleReportingResponsibility7072 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
        public static final BitSet FOLLOW_93_in_ruleReportingResponsibility7084 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
        public static final BitSet FOLLOW_94_in_ruleReportingResponsibility7096 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReportingResponsibility7113 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleReportingResponsibility7139 = new BitSet(new long[]{0x0000000000000010L,0x0000000000008000L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReportingResponsibility7157 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleReportingResponsibility7174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVersionId_in_entryRuleVersionId7213 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionId7224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId7264 = new BitSet(new long[]{0x2000000000000002L,0x0000000100000000L});
        public static final BitSet FOLLOW_61_in_ruleVersionId7283 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId7298 = new BitSet(new long[]{0x2000000000000002L,0x0000000100000000L});
        public static final BitSet FOLLOW_61_in_ruleVersionId7320 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_96_in_ruleVersionId7339 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVersionId7355 = new BitSet(new long[]{0x2000000000000002L,0x0000000100000000L});
        public static final BitSet FOLLOW_ruleVersion_in_entryRuleVersion7404 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersion7414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_97_in_ruleVersion7451 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleVersion7472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVersionRef_in_entryRuleVersionRef7508 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionRef7518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_ruleVersionRef7568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_ruleVersionRef7598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef7628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_ruleVersionRef7658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_ruleVersionRef7688 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef7723 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMinVersionRef7733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_98_in_ruleMinVersionRef7770 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMinVersionRef7791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef7827 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxVersionRef7837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_99_in_ruleMaxVersionRef7874 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMaxVersionRef7895 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef7931 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef7941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_98_in_ruleLowerBoundRangeVersionRef7979 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
        public static final BitSet FOLLOW_100_in_ruleLowerBoundRangeVersionRef7991 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef8013 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
        public static final BitSet FOLLOW_74_in_ruleLowerBoundRangeVersionRef8025 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
        public static final BitSet FOLLOW_99_in_ruleLowerBoundRangeVersionRef8038 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
        public static final BitSet FOLLOW_101_in_ruleLowerBoundRangeVersionRef8050 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef8072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef8108 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMajorVersionRef8118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_102_in_ruleMajorVersionRef8155 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMajorVersionRef8172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef8213 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFixedVersionRef8223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_103_in_ruleFixedVersionRef8260 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleFixedVersionRef8281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard8318 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard8329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard8376 = new BitSet(new long[]{0x0000000000000002L,0x0000010000000000L});
        public static final BitSet FOLLOW_104_in_ruleQualifiedNameWithWildCard8395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8438 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName8449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName8489 = new BitSet(new long[]{0x2000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleQualifiedName8508 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName8523 = new BitSet(new long[]{0x2000000000000002L});
        public static final BitSet FOLLOW_ruleInfoItem_in_entryRuleInfoItem8576 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfoItem8586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_105_in_ruleInfoItem8623 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleInfoItem8640 = new BitSet(new long[]{0x0000000000000002L,0x0000040000000000L});
        public static final BitSet FOLLOW_106_in_ruleInfoItem8658 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleInfoItem8675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRoleRef_in_entryRuleRoleRef8720 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoleRef8730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRoleRef8781 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrivilegeRef_in_entryRulePrivilegeRef8818 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrivilegeRef8828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rulePrivilegeRef8879 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssetRef_in_entryRuleAssetRef8916 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssetRef8926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssetRef8978 = new BitSet(new long[]{0x0000000000000002L,0x000000CC00000000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleAssetRef8999 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_107_in_ruleHashAlgKind9050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_108_in_ruleHashAlgKind9067 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_109_in_ruleHashAlgKind9084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_110_in_ruleHashAlgKind9101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_111_in_ruleHashAlgKind9118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_112_in_ruleMessagePartRefKind9163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_113_in_ruleMessagePartRefKind9180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_114_in_ruleMessagePartRefKind9197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_115_in_ruleMessagePartRefKind9214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleMessagePartRefKind9231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_116_in_ruleSigningAlgothm9276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_108_in_ruleSigningAlgothm9293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_109_in_ruleSigningAlgothm9310 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_107_in_ruleSigningAlgothm9327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_117_in_ruleSigningAlgothm9344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_118_in_ruleSigningAlgothm9361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_119_in_ruleSigningAlgothm9378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_120_in_ruleSigningAlgothm9395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_116_in_ruleCipherAlgorithmKind9440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_121_in_ruleCipherAlgorithmKind9457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_122_in_ruleCipherAlgorithmKind9474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_123_in_ruleCipherAlgorithmKind9491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_124_in_ruleCipherAlgorithmKind9508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_125_in_ruleCipherAlgorithmKind9525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_118_in_ruleCipherAlgorithmKind9542 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_120_in_ruleCipherAlgorithmKind9559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_126_in_ruleAuthTokenKind9604 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_127_in_ruleAuthTokenKind9621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_128_in_ruleAuthTokenKind9638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_129_in_ruleAuthTokenKind9655 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_130_in_ruleAuthTokenKind9672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_131_in_ruleAuthTokenKind9689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_132_in_ruleAuthTokenKind9706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_133_in_ruleAuthTokenKind9723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_134_in_ruleAuthTokenKind9740 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_135_in_ruleLogRequirementKind9785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_112_in_ruleLogRequirementKind9802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_115_in_ruleLogRequirementKind9819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_136_in_ruleReliablilityKind9864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_137_in_ruleReliablilityKind9881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_138_in_ruleReliablilityKind9898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_139_in_ruleReliablilityKind9915 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_140_in_ruleGovernanceDecisionResult9960 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_141_in_ruleGovernanceDecisionResult9977 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_142_in_ruleGovernanceDecisionResult9994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_143_in_ruleGovernanceDecisionResult10011 = new BitSet(new long[]{0x0000000000000002L});
    }


}