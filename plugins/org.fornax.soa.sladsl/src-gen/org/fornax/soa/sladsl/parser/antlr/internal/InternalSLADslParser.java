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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'service-level-agreement'", "'{'", "'owner'", "'effective-date'", "'effective-until'", "'preample'", "'description'", "'scope'", "'applies-to'", "'}'", "'service-quality-requirements'", "'data-security-and-protection'", "'general-security-terms'", "'security-requirements'", "'restrictions'", "'additional-services'", "'cancellation'", "'extraordinary-cancellation'", "'effort-accounting'", "'tags'", "'costs'", "'amount'", "'billed-per-unit'", "'penalty'", "'availability'", "'percentile'", "'mean-time-between-failure'", "'mean-time-to-repair'", "'regular-down-times'", "'throughput'", "'score-to-be-kept'", "'latency'", "'STRING'", "'max-downtime'", "'duration'", "'capacity'", "'num-of-requests'", "'per'", "'message-size'", "'message-exchange-reliability'", "'in-order-delivery'", "'accuracy'", "'max-error-rate'", "'logging'", "'message-log-level'", "'additional-logging-requirements'", "'.'", "'%'", "'authentication-procedure'", "'optional'", "'auth-tokens'", "'hash-algorithms'", "'use-nonce'", "'issuer'", "'Base64-encoded'", "'signing-policy'", "'supported-algorithms'", "'requires-algorithm'", "'signed-message-parts'", "','", "'expression'", "'encryption-policy'", "'encrypted-message-parts'", "'priority'", "'escalation'", "'cause'", "'escalate-to'", "'procedure'", "'contact'", "'name'", "'phone'", "'email'", "'customer-party'", "'provider-party'", "'third-party'", "'participation-role'", "'representative'", "'responsibility'", "'report'", "'report-to'", "'contents'", "'reporting-responsibility'", "'-'", "'minVersion'", "'maxVersion'", "'>='", "'<'", "'majorVersion'", "'fixedVersion'", "'.*'", "'location'", "'reference'", "'MD5'", "'SHA1'", "'SHA256'", "'RSA'", "'PlainText'", "'header'", "'body'", "'attachments'", "'all'", "'NONE'", "'RSA_1_5'", "'AES128'", "'AES192'", "'AES256'", "'Basic128'", "'Basic192'", "'Basic256'", "'DES'", "'3DES'", "'UsernamePassword'", "'SAML'", "'SAML2'", "'Kerberos'", "'SPNEGO'", "'RELToken'", "'X509Certificate'", "'OAuth'", "'OAuth2'", "'none'", "'exactly-once'", "'at-most-once'", "'at-least-once'", "'best-effort'", "'pending'", "'accepted'", "'denied'", "'specific'"
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
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:122:1: ruleSLA returns [EObject current=null] : (otherlv_0= 'service-level-agreement' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'owner' ( (lv_owner_4_0= RULE_STRING ) ) )? otherlv_5= 'effective-date' ( (lv_effectiveDate_6_0= RULE_STRING ) ) (otherlv_7= 'effective-until' ( (lv_effectiveUntil_8_0= RULE_STRING ) ) )? (otherlv_9= 'preample' ( (lv_preample_10_0= RULE_STRING ) ) )? (otherlv_11= 'description' ( (lv_description_12_0= RULE_STRING ) ) )? (otherlv_13= 'scope' ( (lv_scope_14_0= RULE_STRING ) ) )? (otherlv_15= 'applies-to' otherlv_16= '{' ( (lv_appliesTo_17_0= ruleAssetRef ) )* otherlv_18= '}' ) ( (lv_costs_19_0= ruleCost ) )? (otherlv_20= 'service-quality-requirements' otherlv_21= '{' ( (lv_serviceQualityProperties_22_0= ruleServiceQualityProperty ) )* otherlv_23= '}' ) (otherlv_24= 'data-security-and-protection' otherlv_25= '{' (otherlv_26= 'general-security-terms' ( (lv_dataSecProtClause_27_0= RULE_STRING ) ) )? (otherlv_28= 'security-requirements' otherlv_29= '{' ( (lv_securityRequirements_30_0= ruleSecurityRequirement ) )* otherlv_31= '}' ) otherlv_32= '}' )? (otherlv_33= 'restrictions' ( (lv_restrictions_34_0= RULE_STRING ) ) )? ( (lv_priorities_35_0= rulePriorityDeclaration ) )* ( (lv_escalationProcedure_36_0= ruleEscalation ) )? (otherlv_37= 'additional-services' ( (lv_additionalServices_38_0= RULE_STRING ) ) )? ( (lv_parties_39_0= ruleParty ) )* (otherlv_40= 'cancellation' ( (lv_cancellation_41_0= RULE_STRING ) ) )? (otherlv_42= 'extraordinary-cancellation' ( (lv_extraordinaryCancellation_43_0= RULE_STRING ) ) )? (otherlv_44= 'effort-accounting' ( (lv_effortAccounting_45_0= RULE_STRING ) ) )? ( (lv_reports_46_0= ruleReport ) )* (otherlv_47= 'tags' ( (otherlv_48= RULE_ID ) )+ )* otherlv_49= '}' ) ;
    public final EObject ruleSLA() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_owner_4_0=null;
        Token otherlv_5=null;
        Token lv_effectiveDate_6_0=null;
        Token otherlv_7=null;
        Token lv_effectiveUntil_8_0=null;
        Token otherlv_9=null;
        Token lv_preample_10_0=null;
        Token otherlv_11=null;
        Token lv_description_12_0=null;
        Token otherlv_13=null;
        Token lv_scope_14_0=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token lv_dataSecProtClause_27_0=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        Token lv_restrictions_34_0=null;
        Token otherlv_37=null;
        Token lv_additionalServices_38_0=null;
        Token otherlv_40=null;
        Token lv_cancellation_41_0=null;
        Token otherlv_42=null;
        Token lv_extraordinaryCancellation_43_0=null;
        Token otherlv_44=null;
        Token lv_effortAccounting_45_0=null;
        Token otherlv_47=null;
        Token otherlv_48=null;
        Token otherlv_49=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_appliesTo_17_0 = null;

        EObject lv_costs_19_0 = null;

        EObject lv_serviceQualityProperties_22_0 = null;

        EObject lv_securityRequirements_30_0 = null;

        EObject lv_priorities_35_0 = null;

        EObject lv_escalationProcedure_36_0 = null;

        EObject lv_parties_39_0 = null;

        EObject lv_reports_46_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:125:28: ( (otherlv_0= 'service-level-agreement' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'owner' ( (lv_owner_4_0= RULE_STRING ) ) )? otherlv_5= 'effective-date' ( (lv_effectiveDate_6_0= RULE_STRING ) ) (otherlv_7= 'effective-until' ( (lv_effectiveUntil_8_0= RULE_STRING ) ) )? (otherlv_9= 'preample' ( (lv_preample_10_0= RULE_STRING ) ) )? (otherlv_11= 'description' ( (lv_description_12_0= RULE_STRING ) ) )? (otherlv_13= 'scope' ( (lv_scope_14_0= RULE_STRING ) ) )? (otherlv_15= 'applies-to' otherlv_16= '{' ( (lv_appliesTo_17_0= ruleAssetRef ) )* otherlv_18= '}' ) ( (lv_costs_19_0= ruleCost ) )? (otherlv_20= 'service-quality-requirements' otherlv_21= '{' ( (lv_serviceQualityProperties_22_0= ruleServiceQualityProperty ) )* otherlv_23= '}' ) (otherlv_24= 'data-security-and-protection' otherlv_25= '{' (otherlv_26= 'general-security-terms' ( (lv_dataSecProtClause_27_0= RULE_STRING ) ) )? (otherlv_28= 'security-requirements' otherlv_29= '{' ( (lv_securityRequirements_30_0= ruleSecurityRequirement ) )* otherlv_31= '}' ) otherlv_32= '}' )? (otherlv_33= 'restrictions' ( (lv_restrictions_34_0= RULE_STRING ) ) )? ( (lv_priorities_35_0= rulePriorityDeclaration ) )* ( (lv_escalationProcedure_36_0= ruleEscalation ) )? (otherlv_37= 'additional-services' ( (lv_additionalServices_38_0= RULE_STRING ) ) )? ( (lv_parties_39_0= ruleParty ) )* (otherlv_40= 'cancellation' ( (lv_cancellation_41_0= RULE_STRING ) ) )? (otherlv_42= 'extraordinary-cancellation' ( (lv_extraordinaryCancellation_43_0= RULE_STRING ) ) )? (otherlv_44= 'effort-accounting' ( (lv_effortAccounting_45_0= RULE_STRING ) ) )? ( (lv_reports_46_0= ruleReport ) )* (otherlv_47= 'tags' ( (otherlv_48= RULE_ID ) )+ )* otherlv_49= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:126:1: (otherlv_0= 'service-level-agreement' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'owner' ( (lv_owner_4_0= RULE_STRING ) ) )? otherlv_5= 'effective-date' ( (lv_effectiveDate_6_0= RULE_STRING ) ) (otherlv_7= 'effective-until' ( (lv_effectiveUntil_8_0= RULE_STRING ) ) )? (otherlv_9= 'preample' ( (lv_preample_10_0= RULE_STRING ) ) )? (otherlv_11= 'description' ( (lv_description_12_0= RULE_STRING ) ) )? (otherlv_13= 'scope' ( (lv_scope_14_0= RULE_STRING ) ) )? (otherlv_15= 'applies-to' otherlv_16= '{' ( (lv_appliesTo_17_0= ruleAssetRef ) )* otherlv_18= '}' ) ( (lv_costs_19_0= ruleCost ) )? (otherlv_20= 'service-quality-requirements' otherlv_21= '{' ( (lv_serviceQualityProperties_22_0= ruleServiceQualityProperty ) )* otherlv_23= '}' ) (otherlv_24= 'data-security-and-protection' otherlv_25= '{' (otherlv_26= 'general-security-terms' ( (lv_dataSecProtClause_27_0= RULE_STRING ) ) )? (otherlv_28= 'security-requirements' otherlv_29= '{' ( (lv_securityRequirements_30_0= ruleSecurityRequirement ) )* otherlv_31= '}' ) otherlv_32= '}' )? (otherlv_33= 'restrictions' ( (lv_restrictions_34_0= RULE_STRING ) ) )? ( (lv_priorities_35_0= rulePriorityDeclaration ) )* ( (lv_escalationProcedure_36_0= ruleEscalation ) )? (otherlv_37= 'additional-services' ( (lv_additionalServices_38_0= RULE_STRING ) ) )? ( (lv_parties_39_0= ruleParty ) )* (otherlv_40= 'cancellation' ( (lv_cancellation_41_0= RULE_STRING ) ) )? (otherlv_42= 'extraordinary-cancellation' ( (lv_extraordinaryCancellation_43_0= RULE_STRING ) ) )? (otherlv_44= 'effort-accounting' ( (lv_effortAccounting_45_0= RULE_STRING ) ) )? ( (lv_reports_46_0= ruleReport ) )* (otherlv_47= 'tags' ( (otherlv_48= RULE_ID ) )+ )* otherlv_49= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:126:1: (otherlv_0= 'service-level-agreement' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'owner' ( (lv_owner_4_0= RULE_STRING ) ) )? otherlv_5= 'effective-date' ( (lv_effectiveDate_6_0= RULE_STRING ) ) (otherlv_7= 'effective-until' ( (lv_effectiveUntil_8_0= RULE_STRING ) ) )? (otherlv_9= 'preample' ( (lv_preample_10_0= RULE_STRING ) ) )? (otherlv_11= 'description' ( (lv_description_12_0= RULE_STRING ) ) )? (otherlv_13= 'scope' ( (lv_scope_14_0= RULE_STRING ) ) )? (otherlv_15= 'applies-to' otherlv_16= '{' ( (lv_appliesTo_17_0= ruleAssetRef ) )* otherlv_18= '}' ) ( (lv_costs_19_0= ruleCost ) )? (otherlv_20= 'service-quality-requirements' otherlv_21= '{' ( (lv_serviceQualityProperties_22_0= ruleServiceQualityProperty ) )* otherlv_23= '}' ) (otherlv_24= 'data-security-and-protection' otherlv_25= '{' (otherlv_26= 'general-security-terms' ( (lv_dataSecProtClause_27_0= RULE_STRING ) ) )? (otherlv_28= 'security-requirements' otherlv_29= '{' ( (lv_securityRequirements_30_0= ruleSecurityRequirement ) )* otherlv_31= '}' ) otherlv_32= '}' )? (otherlv_33= 'restrictions' ( (lv_restrictions_34_0= RULE_STRING ) ) )? ( (lv_priorities_35_0= rulePriorityDeclaration ) )* ( (lv_escalationProcedure_36_0= ruleEscalation ) )? (otherlv_37= 'additional-services' ( (lv_additionalServices_38_0= RULE_STRING ) ) )? ( (lv_parties_39_0= ruleParty ) )* (otherlv_40= 'cancellation' ( (lv_cancellation_41_0= RULE_STRING ) ) )? (otherlv_42= 'extraordinary-cancellation' ( (lv_extraordinaryCancellation_43_0= RULE_STRING ) ) )? (otherlv_44= 'effort-accounting' ( (lv_effortAccounting_45_0= RULE_STRING ) ) )? ( (lv_reports_46_0= ruleReport ) )* (otherlv_47= 'tags' ( (otherlv_48= RULE_ID ) )+ )* otherlv_49= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:126:3: otherlv_0= 'service-level-agreement' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'owner' ( (lv_owner_4_0= RULE_STRING ) ) )? otherlv_5= 'effective-date' ( (lv_effectiveDate_6_0= RULE_STRING ) ) (otherlv_7= 'effective-until' ( (lv_effectiveUntil_8_0= RULE_STRING ) ) )? (otherlv_9= 'preample' ( (lv_preample_10_0= RULE_STRING ) ) )? (otherlv_11= 'description' ( (lv_description_12_0= RULE_STRING ) ) )? (otherlv_13= 'scope' ( (lv_scope_14_0= RULE_STRING ) ) )? (otherlv_15= 'applies-to' otherlv_16= '{' ( (lv_appliesTo_17_0= ruleAssetRef ) )* otherlv_18= '}' ) ( (lv_costs_19_0= ruleCost ) )? (otherlv_20= 'service-quality-requirements' otherlv_21= '{' ( (lv_serviceQualityProperties_22_0= ruleServiceQualityProperty ) )* otherlv_23= '}' ) (otherlv_24= 'data-security-and-protection' otherlv_25= '{' (otherlv_26= 'general-security-terms' ( (lv_dataSecProtClause_27_0= RULE_STRING ) ) )? (otherlv_28= 'security-requirements' otherlv_29= '{' ( (lv_securityRequirements_30_0= ruleSecurityRequirement ) )* otherlv_31= '}' ) otherlv_32= '}' )? (otherlv_33= 'restrictions' ( (lv_restrictions_34_0= RULE_STRING ) ) )? ( (lv_priorities_35_0= rulePriorityDeclaration ) )* ( (lv_escalationProcedure_36_0= ruleEscalation ) )? (otherlv_37= 'additional-services' ( (lv_additionalServices_38_0= RULE_STRING ) ) )? ( (lv_parties_39_0= ruleParty ) )* (otherlv_40= 'cancellation' ( (lv_cancellation_41_0= RULE_STRING ) ) )? (otherlv_42= 'extraordinary-cancellation' ( (lv_extraordinaryCancellation_43_0= RULE_STRING ) ) )? (otherlv_44= 'effort-accounting' ( (lv_effortAccounting_45_0= RULE_STRING ) ) )? ( (lv_reports_46_0= ruleReport ) )* (otherlv_47= 'tags' ( (otherlv_48= RULE_ID ) )+ )* otherlv_49= '}'
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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSLA252); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getSLAAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:152:1: (otherlv_3= 'owner' ( (lv_owner_4_0= RULE_STRING ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:152:3: otherlv_3= 'owner' ( (lv_owner_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSLA265); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getSLAAccess().getOwnerKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:156:1: ( (lv_owner_4_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:157:1: (lv_owner_4_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:157:1: (lv_owner_4_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:158:3: lv_owner_4_0= RULE_STRING
                    {
                    lv_owner_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA282); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_owner_4_0, grammarAccess.getSLAAccess().getOwnerSTRINGTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"owner",
                              		lv_owner_4_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSLA301); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getSLAAccess().getEffectiveDateKeyword_4());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:178:1: ( (lv_effectiveDate_6_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:179:1: (lv_effectiveDate_6_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:179:1: (lv_effectiveDate_6_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:180:3: lv_effectiveDate_6_0= RULE_STRING
            {
            lv_effectiveDate_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA318); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_effectiveDate_6_0, grammarAccess.getSLAAccess().getEffectiveDateSTRINGTerminalRuleCall_5_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getSLARule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"effectiveDate",
                      		lv_effectiveDate_6_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:196:2: (otherlv_7= 'effective-until' ( (lv_effectiveUntil_8_0= RULE_STRING ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:196:4: otherlv_7= 'effective-until' ( (lv_effectiveUntil_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSLA336); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getSLAAccess().getEffectiveUntilKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:200:1: ( (lv_effectiveUntil_8_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:201:1: (lv_effectiveUntil_8_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:201:1: (lv_effectiveUntil_8_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:202:3: lv_effectiveUntil_8_0= RULE_STRING
                    {
                    lv_effectiveUntil_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA353); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_effectiveUntil_8_0, grammarAccess.getSLAAccess().getEffectiveUntilSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"effectiveUntil",
                              		lv_effectiveUntil_8_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:218:4: (otherlv_9= 'preample' ( (lv_preample_10_0= RULE_STRING ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:218:6: otherlv_9= 'preample' ( (lv_preample_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSLA373); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getSLAAccess().getPreampleKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:222:1: ( (lv_preample_10_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:223:1: (lv_preample_10_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:223:1: (lv_preample_10_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:224:3: lv_preample_10_0= RULE_STRING
                    {
                    lv_preample_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA390); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_preample_10_0, grammarAccess.getSLAAccess().getPreampleSTRINGTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"preample",
                              		lv_preample_10_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:240:4: (otherlv_11= 'description' ( (lv_description_12_0= RULE_STRING ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:240:6: otherlv_11= 'description' ( (lv_description_12_0= RULE_STRING ) )
                    {
                    otherlv_11=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSLA410); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getSLAAccess().getDescriptionKeyword_8_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:244:1: ( (lv_description_12_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:245:1: (lv_description_12_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:245:1: (lv_description_12_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:246:3: lv_description_12_0= RULE_STRING
                    {
                    lv_description_12_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA427); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_description_12_0, grammarAccess.getSLAAccess().getDescriptionSTRINGTerminalRuleCall_8_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"description",
                              		lv_description_12_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:262:4: (otherlv_13= 'scope' ( (lv_scope_14_0= RULE_STRING ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:262:6: otherlv_13= 'scope' ( (lv_scope_14_0= RULE_STRING ) )
                    {
                    otherlv_13=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSLA447); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getSLAAccess().getScopeKeyword_9_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:266:1: ( (lv_scope_14_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:267:1: (lv_scope_14_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:267:1: (lv_scope_14_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:268:3: lv_scope_14_0= RULE_STRING
                    {
                    lv_scope_14_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA464); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_scope_14_0, grammarAccess.getSLAAccess().getScopeSTRINGTerminalRuleCall_9_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"scope",
                              		lv_scope_14_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:284:4: (otherlv_15= 'applies-to' otherlv_16= '{' ( (lv_appliesTo_17_0= ruleAssetRef ) )* otherlv_18= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:284:6: otherlv_15= 'applies-to' otherlv_16= '{' ( (lv_appliesTo_17_0= ruleAssetRef ) )* otherlv_18= '}'
            {
            otherlv_15=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSLA484); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getSLAAccess().getAppliesToKeyword_10_0());
                  
            }
            otherlv_16=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSLA496); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_16, grammarAccess.getSLAAccess().getLeftCurlyBracketKeyword_10_1());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:292:1: ( (lv_appliesTo_17_0= ruleAssetRef ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:293:1: (lv_appliesTo_17_0= ruleAssetRef )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:293:1: (lv_appliesTo_17_0= ruleAssetRef )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:294:3: lv_appliesTo_17_0= ruleAssetRef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSLAAccess().getAppliesToAssetRefParserRuleCall_10_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAssetRef_in_ruleSLA517);
            	    lv_appliesTo_17_0=ruleAssetRef();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSLARule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"appliesTo",
            	              		lv_appliesTo_17_0, 
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

            otherlv_18=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSLA530); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_18, grammarAccess.getSLAAccess().getRightCurlyBracketKeyword_10_3());
                  
            }

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:314:2: ( (lv_costs_19_0= ruleCost ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==31) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:315:1: (lv_costs_19_0= ruleCost )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:315:1: (lv_costs_19_0= ruleCost )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:316:3: lv_costs_19_0= ruleCost
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSLAAccess().getCostsCostParserRuleCall_11_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCost_in_ruleSLA552);
                    lv_costs_19_0=ruleCost();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSLARule());
                      	        }
                             		set(
                             			current, 
                             			"costs",
                              		lv_costs_19_0, 
                              		"Cost");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:332:3: (otherlv_20= 'service-quality-requirements' otherlv_21= '{' ( (lv_serviceQualityProperties_22_0= ruleServiceQualityProperty ) )* otherlv_23= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:332:5: otherlv_20= 'service-quality-requirements' otherlv_21= '{' ( (lv_serviceQualityProperties_22_0= ruleServiceQualityProperty ) )* otherlv_23= '}'
            {
            otherlv_20=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleSLA566); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_20, grammarAccess.getSLAAccess().getServiceQualityRequirementsKeyword_12_0());
                  
            }
            otherlv_21=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSLA578); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_21, grammarAccess.getSLAAccess().getLeftCurlyBracketKeyword_12_1());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:340:1: ( (lv_serviceQualityProperties_22_0= ruleServiceQualityProperty ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==35||LA9_0==40||LA9_0==42||LA9_0==44||LA9_0==46||LA9_0==50||LA9_0==52||LA9_0==54) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:341:1: (lv_serviceQualityProperties_22_0= ruleServiceQualityProperty )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:341:1: (lv_serviceQualityProperties_22_0= ruleServiceQualityProperty )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:342:3: lv_serviceQualityProperties_22_0= ruleServiceQualityProperty
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSLAAccess().getServiceQualityPropertiesServiceQualityPropertyParserRuleCall_12_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceQualityProperty_in_ruleSLA599);
            	    lv_serviceQualityProperties_22_0=ruleServiceQualityProperty();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSLARule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"serviceQualityProperties",
            	              		lv_serviceQualityProperties_22_0, 
            	              		"ServiceQualityProperty");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_23=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSLA612); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_23, grammarAccess.getSLAAccess().getRightCurlyBracketKeyword_12_3());
                  
            }

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:362:2: (otherlv_24= 'data-security-and-protection' otherlv_25= '{' (otherlv_26= 'general-security-terms' ( (lv_dataSecProtClause_27_0= RULE_STRING ) ) )? (otherlv_28= 'security-requirements' otherlv_29= '{' ( (lv_securityRequirements_30_0= ruleSecurityRequirement ) )* otherlv_31= '}' ) otherlv_32= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==22) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:362:4: otherlv_24= 'data-security-and-protection' otherlv_25= '{' (otherlv_26= 'general-security-terms' ( (lv_dataSecProtClause_27_0= RULE_STRING ) ) )? (otherlv_28= 'security-requirements' otherlv_29= '{' ( (lv_securityRequirements_30_0= ruleSecurityRequirement ) )* otherlv_31= '}' ) otherlv_32= '}'
                    {
                    otherlv_24=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleSLA626); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_24, grammarAccess.getSLAAccess().getDataSecurityAndProtectionKeyword_13_0());
                          
                    }
                    otherlv_25=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSLA638); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_25, grammarAccess.getSLAAccess().getLeftCurlyBracketKeyword_13_1());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:370:1: (otherlv_26= 'general-security-terms' ( (lv_dataSecProtClause_27_0= RULE_STRING ) ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==23) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:370:3: otherlv_26= 'general-security-terms' ( (lv_dataSecProtClause_27_0= RULE_STRING ) )
                            {
                            otherlv_26=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleSLA651); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_26, grammarAccess.getSLAAccess().getGeneralSecurityTermsKeyword_13_2_0());
                                  
                            }
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:374:1: ( (lv_dataSecProtClause_27_0= RULE_STRING ) )
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:375:1: (lv_dataSecProtClause_27_0= RULE_STRING )
                            {
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:375:1: (lv_dataSecProtClause_27_0= RULE_STRING )
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:376:3: lv_dataSecProtClause_27_0= RULE_STRING
                            {
                            lv_dataSecProtClause_27_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA668); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_dataSecProtClause_27_0, grammarAccess.getSLAAccess().getDataSecProtClauseSTRINGTerminalRuleCall_13_2_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSLARule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"dataSecProtClause",
                                      		lv_dataSecProtClause_27_0, 
                                      		"STRING");
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:392:4: (otherlv_28= 'security-requirements' otherlv_29= '{' ( (lv_securityRequirements_30_0= ruleSecurityRequirement ) )* otherlv_31= '}' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:392:6: otherlv_28= 'security-requirements' otherlv_29= '{' ( (lv_securityRequirements_30_0= ruleSecurityRequirement ) )* otherlv_31= '}'
                    {
                    otherlv_28=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleSLA688); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_28, grammarAccess.getSLAAccess().getSecurityRequirementsKeyword_13_3_0());
                          
                    }
                    otherlv_29=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSLA700); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_29, grammarAccess.getSLAAccess().getLeftCurlyBracketKeyword_13_3_1());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:400:1: ( (lv_securityRequirements_30_0= ruleSecurityRequirement ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==59||LA11_0==66||LA11_0==72) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:401:1: (lv_securityRequirements_30_0= ruleSecurityRequirement )
                    	    {
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:401:1: (lv_securityRequirements_30_0= ruleSecurityRequirement )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:402:3: lv_securityRequirements_30_0= ruleSecurityRequirement
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSLAAccess().getSecurityRequirementsSecurityRequirementParserRuleCall_13_3_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleSecurityRequirement_in_ruleSLA721);
                    	    lv_securityRequirements_30_0=ruleSecurityRequirement();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSLARule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"securityRequirements",
                    	              		lv_securityRequirements_30_0, 
                    	              		"SecurityRequirement");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    otherlv_31=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSLA734); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_31, grammarAccess.getSLAAccess().getRightCurlyBracketKeyword_13_3_3());
                          
                    }

                    }

                    otherlv_32=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSLA747); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_32, grammarAccess.getSLAAccess().getRightCurlyBracketKeyword_13_4());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:426:3: (otherlv_33= 'restrictions' ( (lv_restrictions_34_0= RULE_STRING ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==25) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:426:5: otherlv_33= 'restrictions' ( (lv_restrictions_34_0= RULE_STRING ) )
                    {
                    otherlv_33=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleSLA762); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_33, grammarAccess.getSLAAccess().getRestrictionsKeyword_14_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:430:1: ( (lv_restrictions_34_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:431:1: (lv_restrictions_34_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:431:1: (lv_restrictions_34_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:432:3: lv_restrictions_34_0= RULE_STRING
                    {
                    lv_restrictions_34_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA779); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_restrictions_34_0, grammarAccess.getSLAAccess().getRestrictionsSTRINGTerminalRuleCall_14_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"restrictions",
                              		lv_restrictions_34_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:448:4: ( (lv_priorities_35_0= rulePriorityDeclaration ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==74) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:449:1: (lv_priorities_35_0= rulePriorityDeclaration )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:449:1: (lv_priorities_35_0= rulePriorityDeclaration )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:450:3: lv_priorities_35_0= rulePriorityDeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSLAAccess().getPrioritiesPriorityDeclarationParserRuleCall_15_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_rulePriorityDeclaration_in_ruleSLA807);
            	    lv_priorities_35_0=rulePriorityDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSLARule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"priorities",
            	              		lv_priorities_35_0, 
            	              		"PriorityDeclaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:466:3: ( (lv_escalationProcedure_36_0= ruleEscalation ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==75) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:467:1: (lv_escalationProcedure_36_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:467:1: (lv_escalationProcedure_36_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:468:3: lv_escalationProcedure_36_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSLAAccess().getEscalationProcedureEscalationParserRuleCall_16_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleSLA829);
                    lv_escalationProcedure_36_0=ruleEscalation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSLARule());
                      	        }
                             		set(
                             			current, 
                             			"escalationProcedure",
                              		lv_escalationProcedure_36_0, 
                              		"Escalation");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:484:3: (otherlv_37= 'additional-services' ( (lv_additionalServices_38_0= RULE_STRING ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:484:5: otherlv_37= 'additional-services' ( (lv_additionalServices_38_0= RULE_STRING ) )
                    {
                    otherlv_37=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleSLA843); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_37, grammarAccess.getSLAAccess().getAdditionalServicesKeyword_17_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:488:1: ( (lv_additionalServices_38_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:489:1: (lv_additionalServices_38_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:489:1: (lv_additionalServices_38_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:490:3: lv_additionalServices_38_0= RULE_STRING
                    {
                    lv_additionalServices_38_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA860); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_additionalServices_38_0, grammarAccess.getSLAAccess().getAdditionalServicesSTRINGTerminalRuleCall_17_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"additionalServices",
                              		lv_additionalServices_38_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:506:4: ( (lv_parties_39_0= ruleParty ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=83 && LA17_0<=85)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:507:1: (lv_parties_39_0= ruleParty )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:507:1: (lv_parties_39_0= ruleParty )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:508:3: lv_parties_39_0= ruleParty
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSLAAccess().getPartiesPartyParserRuleCall_18_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleParty_in_ruleSLA888);
            	    lv_parties_39_0=ruleParty();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSLARule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"parties",
            	              		lv_parties_39_0, 
            	              		"Party");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:524:3: (otherlv_40= 'cancellation' ( (lv_cancellation_41_0= RULE_STRING ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:524:5: otherlv_40= 'cancellation' ( (lv_cancellation_41_0= RULE_STRING ) )
                    {
                    otherlv_40=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleSLA902); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_40, grammarAccess.getSLAAccess().getCancellationKeyword_19_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:528:1: ( (lv_cancellation_41_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:529:1: (lv_cancellation_41_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:529:1: (lv_cancellation_41_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:530:3: lv_cancellation_41_0= RULE_STRING
                    {
                    lv_cancellation_41_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA919); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_cancellation_41_0, grammarAccess.getSLAAccess().getCancellationSTRINGTerminalRuleCall_19_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"cancellation",
                              		lv_cancellation_41_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:546:4: (otherlv_42= 'extraordinary-cancellation' ( (lv_extraordinaryCancellation_43_0= RULE_STRING ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==28) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:546:6: otherlv_42= 'extraordinary-cancellation' ( (lv_extraordinaryCancellation_43_0= RULE_STRING ) )
                    {
                    otherlv_42=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleSLA939); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_42, grammarAccess.getSLAAccess().getExtraordinaryCancellationKeyword_20_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:550:1: ( (lv_extraordinaryCancellation_43_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:551:1: (lv_extraordinaryCancellation_43_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:551:1: (lv_extraordinaryCancellation_43_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:552:3: lv_extraordinaryCancellation_43_0= RULE_STRING
                    {
                    lv_extraordinaryCancellation_43_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA956); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_extraordinaryCancellation_43_0, grammarAccess.getSLAAccess().getExtraordinaryCancellationSTRINGTerminalRuleCall_20_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"extraordinaryCancellation",
                              		lv_extraordinaryCancellation_43_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:568:4: (otherlv_44= 'effort-accounting' ( (lv_effortAccounting_45_0= RULE_STRING ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==29) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:568:6: otherlv_44= 'effort-accounting' ( (lv_effortAccounting_45_0= RULE_STRING ) )
                    {
                    otherlv_44=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleSLA976); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_44, grammarAccess.getSLAAccess().getEffortAccountingKeyword_21_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:572:1: ( (lv_effortAccounting_45_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:573:1: (lv_effortAccounting_45_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:573:1: (lv_effortAccounting_45_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:574:3: lv_effortAccounting_45_0= RULE_STRING
                    {
                    lv_effortAccounting_45_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSLA993); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_effortAccounting_45_0, grammarAccess.getSLAAccess().getEffortAccountingSTRINGTerminalRuleCall_21_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSLARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"effortAccounting",
                              		lv_effortAccounting_45_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:590:4: ( (lv_reports_46_0= ruleReport ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==89) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:591:1: (lv_reports_46_0= ruleReport )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:591:1: (lv_reports_46_0= ruleReport )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:592:3: lv_reports_46_0= ruleReport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSLAAccess().getReportsReportParserRuleCall_22_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleReport_in_ruleSLA1021);
            	    lv_reports_46_0=ruleReport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSLARule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"reports",
            	              		lv_reports_46_0, 
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:608:3: (otherlv_47= 'tags' ( (otherlv_48= RULE_ID ) )+ )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==30) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:608:5: otherlv_47= 'tags' ( (otherlv_48= RULE_ID ) )+
            	    {
            	    otherlv_47=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleSLA1035); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_47, grammarAccess.getSLAAccess().getTagsKeyword_23_0());
            	          
            	    }
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:612:1: ( (otherlv_48= RULE_ID ) )+
            	    int cnt22=0;
            	    loop22:
            	    do {
            	        int alt22=2;
            	        int LA22_0 = input.LA(1);

            	        if ( (LA22_0==RULE_ID) ) {
            	            alt22=1;
            	        }


            	        switch (alt22) {
            	    	case 1 :
            	    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:613:1: (otherlv_48= RULE_ID )
            	    	    {
            	    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:613:1: (otherlv_48= RULE_ID )
            	    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:614:3: otherlv_48= RULE_ID
            	    	    {
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	      		  /* */ 
            	    	      		
            	    	    }
            	    	    if ( state.backtracking==0 ) {

            	    	      			if (current==null) {
            	    	      	            current = createModelElement(grammarAccess.getSLARule());
            	    	      	        }
            	    	              
            	    	    }
            	    	    otherlv_48=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSLA1059); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      		newLeafNode(otherlv_48, grammarAccess.getSLAAccess().getTagsTagCrossReference_23_1_0()); 
            	    	      	
            	    	    }

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt22 >= 1 ) break loop22;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(22, input);
            	                throw eee;
            	        }
            	        cnt22++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            otherlv_49=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSLA1074); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_49, grammarAccess.getSLAAccess().getRightCurlyBracketKeyword_24());
                  
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


    // $ANTLR start "entryRuleAssetRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:640:1: entryRuleAssetRef returns [EObject current=null] : iv_ruleAssetRef= ruleAssetRef EOF ;
    public final EObject entryRuleAssetRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssetRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:641:2: (iv_ruleAssetRef= ruleAssetRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:642:2: iv_ruleAssetRef= ruleAssetRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssetRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAssetRef_in_entryRuleAssetRef1110);
            iv_ruleAssetRef=ruleAssetRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssetRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssetRef1120); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:649:1: ruleAssetRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )? ) ;
    public final EObject ruleAssetRef() throws RecognitionException {
        EObject current = null;

        EObject lv_versionRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:652:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )? ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:653:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )? )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:653:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )? )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:653:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )?
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:653:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:654:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:654:1: ( ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:655:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleAssetRef1172);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:671:2: ( (lv_versionRef_1_0= ruleVersionRef ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=94 && LA24_0<=95)||(LA24_0>=98 && LA24_0<=99)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:672:1: (lv_versionRef_1_0= ruleVersionRef )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:672:1: (lv_versionRef_1_0= ruleVersionRef )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:673:3: lv_versionRef_1_0= ruleVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssetRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleAssetRef1193);
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


    // $ANTLR start "entryRuleCost"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:697:1: entryRuleCost returns [EObject current=null] : iv_ruleCost= ruleCost EOF ;
    public final EObject entryRuleCost() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCost = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:698:2: (iv_ruleCost= ruleCost EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:699:2: iv_ruleCost= ruleCost EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCostRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCost_in_entryRuleCost1230);
            iv_ruleCost=ruleCost();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCost; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCost1240); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:706:1: ruleCost returns [EObject current=null] : (otherlv_0= 'costs' otherlv_1= '{' otherlv_2= 'amount' ( (lv_costsAmount_3_0= RULE_STRING ) ) otherlv_4= 'billed-per-unit' ( (lv_billedUnit_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:709:28: ( (otherlv_0= 'costs' otherlv_1= '{' otherlv_2= 'amount' ( (lv_costsAmount_3_0= RULE_STRING ) ) otherlv_4= 'billed-per-unit' ( (lv_billedUnit_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:710:1: (otherlv_0= 'costs' otherlv_1= '{' otherlv_2= 'amount' ( (lv_costsAmount_3_0= RULE_STRING ) ) otherlv_4= 'billed-per-unit' ( (lv_billedUnit_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:710:1: (otherlv_0= 'costs' otherlv_1= '{' otherlv_2= 'amount' ( (lv_costsAmount_3_0= RULE_STRING ) ) otherlv_4= 'billed-per-unit' ( (lv_billedUnit_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:710:3: otherlv_0= 'costs' otherlv_1= '{' otherlv_2= 'amount' ( (lv_costsAmount_3_0= RULE_STRING ) ) otherlv_4= 'billed-per-unit' ( (lv_billedUnit_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleCost1277); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getCostAccess().getCostsKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleCost1289); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCostAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleCost1301); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getCostAccess().getAmountKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:722:1: ( (lv_costsAmount_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:723:1: (lv_costsAmount_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:723:1: (lv_costsAmount_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:724:3: lv_costsAmount_3_0= RULE_STRING
            {
            lv_costsAmount_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCost1318); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleCost1335); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getCostAccess().getBilledPerUnitKeyword_4());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:744:1: ( (lv_billedUnit_5_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:745:1: (lv_billedUnit_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:745:1: (lv_billedUnit_5_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:746:3: lv_billedUnit_5_0= RULE_STRING
            {
            lv_billedUnit_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCost1352); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:762:2: ( (lv_escalation_6_0= ruleEscalation ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==75) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:763:1: (lv_escalation_6_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:763:1: (lv_escalation_6_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:764:3: lv_escalation_6_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCostAccess().getEscalationEscalationParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleCost1378);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:780:3: (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==34) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:780:5: otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleCost1392); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getCostAccess().getPenaltyKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:784:1: ( (lv_penalty_8_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:785:1: (lv_penalty_8_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:785:1: (lv_penalty_8_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:786:3: lv_penalty_8_0= RULE_STRING
                    {
                    lv_penalty_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCost1409); if (state.failed) return current;
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

            otherlv_9=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleCost1428); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:814:1: entryRuleServiceQualityProperty returns [EObject current=null] : iv_ruleServiceQualityProperty= ruleServiceQualityProperty EOF ;
    public final EObject entryRuleServiceQualityProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceQualityProperty = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:815:2: (iv_ruleServiceQualityProperty= ruleServiceQualityProperty EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:816:2: iv_ruleServiceQualityProperty= ruleServiceQualityProperty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getServiceQualityPropertyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceQualityProperty_in_entryRuleServiceQualityProperty1464);
            iv_ruleServiceQualityProperty=ruleServiceQualityProperty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleServiceQualityProperty; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleServiceQualityProperty1474); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:823:1: ruleServiceQualityProperty returns [EObject current=null] : (this_Availability_0= ruleAvailability | this_Throughput_1= ruleThroughput | this_Latency_2= ruleLatency | this_MaxDownTime_3= ruleMaxDownTime | this_CapacityRequirement_4= ruleCapacityRequirement | this_AccuracyRequirement_5= ruleAccuracyRequirement | this_ReliablityRequirement_6= ruleReliablityRequirement | this_LogRequirement_7= ruleLogRequirement ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:826:28: ( (this_Availability_0= ruleAvailability | this_Throughput_1= ruleThroughput | this_Latency_2= ruleLatency | this_MaxDownTime_3= ruleMaxDownTime | this_CapacityRequirement_4= ruleCapacityRequirement | this_AccuracyRequirement_5= ruleAccuracyRequirement | this_ReliablityRequirement_6= ruleReliablityRequirement | this_LogRequirement_7= ruleLogRequirement ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:827:1: (this_Availability_0= ruleAvailability | this_Throughput_1= ruleThroughput | this_Latency_2= ruleLatency | this_MaxDownTime_3= ruleMaxDownTime | this_CapacityRequirement_4= ruleCapacityRequirement | this_AccuracyRequirement_5= ruleAccuracyRequirement | this_ReliablityRequirement_6= ruleReliablityRequirement | this_LogRequirement_7= ruleLogRequirement )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:827:1: (this_Availability_0= ruleAvailability | this_Throughput_1= ruleThroughput | this_Latency_2= ruleLatency | this_MaxDownTime_3= ruleMaxDownTime | this_CapacityRequirement_4= ruleCapacityRequirement | this_AccuracyRequirement_5= ruleAccuracyRequirement | this_ReliablityRequirement_6= ruleReliablityRequirement | this_LogRequirement_7= ruleLogRequirement )
            int alt27=8;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt27=1;
                }
                break;
            case 40:
                {
                alt27=2;
                }
                break;
            case 42:
                {
                alt27=3;
                }
                break;
            case 44:
                {
                alt27=4;
                }
                break;
            case 46:
                {
                alt27=5;
                }
                break;
            case 52:
                {
                alt27=6;
                }
                break;
            case 50:
                {
                alt27=7;
                }
                break;
            case 54:
                {
                alt27=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:828:2: this_Availability_0= ruleAvailability
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getAvailabilityParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAvailability_in_ruleServiceQualityProperty1524);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:841:2: this_Throughput_1= ruleThroughput
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getThroughputParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleThroughput_in_ruleServiceQualityProperty1554);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:854:2: this_Latency_2= ruleLatency
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getLatencyParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLatency_in_ruleServiceQualityProperty1584);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:867:2: this_MaxDownTime_3= ruleMaxDownTime
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getMaxDownTimeParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMaxDownTime_in_ruleServiceQualityProperty1614);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:880:2: this_CapacityRequirement_4= ruleCapacityRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getCapacityRequirementParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCapacityRequirement_in_ruleServiceQualityProperty1644);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:893:2: this_AccuracyRequirement_5= ruleAccuracyRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getAccuracyRequirementParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAccuracyRequirement_in_ruleServiceQualityProperty1674);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:906:2: this_ReliablityRequirement_6= ruleReliablityRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getReliablityRequirementParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleReliablityRequirement_in_ruleServiceQualityProperty1704);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:919:2: this_LogRequirement_7= ruleLogRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getServiceQualityPropertyAccess().getLogRequirementParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLogRequirement_in_ruleServiceQualityProperty1734);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:938:1: entryRuleAvailability returns [EObject current=null] : iv_ruleAvailability= ruleAvailability EOF ;
    public final EObject entryRuleAvailability() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAvailability = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:939:2: (iv_ruleAvailability= ruleAvailability EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:940:2: iv_ruleAvailability= ruleAvailability EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAvailabilityRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAvailability_in_entryRuleAvailability1769);
            iv_ruleAvailability=ruleAvailability();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAvailability; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAvailability1779); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:947:1: ruleAvailability returns [EObject current=null] : (otherlv_0= 'availability' otherlv_1= '{' otherlv_2= 'availability' ( (lv_availability_3_0= RULE_STRING ) ) otherlv_4= 'percentile' ( (lv_percentile_5_0= rulePercentile ) ) (otherlv_6= 'mean-time-between-failure' ( (lv_mtbf_7_0= RULE_STRING ) ) )? (otherlv_8= 'mean-time-to-repair' ( (lv_mttr_9_0= RULE_STRING ) ) ( (lv_mttrPercentile_10_0= rulePercentile ) )? )? (otherlv_11= 'regular-down-times' ( (lv_regularDownTimes_12_0= RULE_STRING ) ) )? otherlv_13= '}' ) ;
    public final EObject ruleAvailability() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_availability_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_mtbf_7_0=null;
        Token otherlv_8=null;
        Token lv_mttr_9_0=null;
        Token otherlv_11=null;
        Token lv_regularDownTimes_12_0=null;
        Token otherlv_13=null;
        EObject lv_percentile_5_0 = null;

        EObject lv_mttrPercentile_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:950:28: ( (otherlv_0= 'availability' otherlv_1= '{' otherlv_2= 'availability' ( (lv_availability_3_0= RULE_STRING ) ) otherlv_4= 'percentile' ( (lv_percentile_5_0= rulePercentile ) ) (otherlv_6= 'mean-time-between-failure' ( (lv_mtbf_7_0= RULE_STRING ) ) )? (otherlv_8= 'mean-time-to-repair' ( (lv_mttr_9_0= RULE_STRING ) ) ( (lv_mttrPercentile_10_0= rulePercentile ) )? )? (otherlv_11= 'regular-down-times' ( (lv_regularDownTimes_12_0= RULE_STRING ) ) )? otherlv_13= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:951:1: (otherlv_0= 'availability' otherlv_1= '{' otherlv_2= 'availability' ( (lv_availability_3_0= RULE_STRING ) ) otherlv_4= 'percentile' ( (lv_percentile_5_0= rulePercentile ) ) (otherlv_6= 'mean-time-between-failure' ( (lv_mtbf_7_0= RULE_STRING ) ) )? (otherlv_8= 'mean-time-to-repair' ( (lv_mttr_9_0= RULE_STRING ) ) ( (lv_mttrPercentile_10_0= rulePercentile ) )? )? (otherlv_11= 'regular-down-times' ( (lv_regularDownTimes_12_0= RULE_STRING ) ) )? otherlv_13= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:951:1: (otherlv_0= 'availability' otherlv_1= '{' otherlv_2= 'availability' ( (lv_availability_3_0= RULE_STRING ) ) otherlv_4= 'percentile' ( (lv_percentile_5_0= rulePercentile ) ) (otherlv_6= 'mean-time-between-failure' ( (lv_mtbf_7_0= RULE_STRING ) ) )? (otherlv_8= 'mean-time-to-repair' ( (lv_mttr_9_0= RULE_STRING ) ) ( (lv_mttrPercentile_10_0= rulePercentile ) )? )? (otherlv_11= 'regular-down-times' ( (lv_regularDownTimes_12_0= RULE_STRING ) ) )? otherlv_13= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:951:3: otherlv_0= 'availability' otherlv_1= '{' otherlv_2= 'availability' ( (lv_availability_3_0= RULE_STRING ) ) otherlv_4= 'percentile' ( (lv_percentile_5_0= rulePercentile ) ) (otherlv_6= 'mean-time-between-failure' ( (lv_mtbf_7_0= RULE_STRING ) ) )? (otherlv_8= 'mean-time-to-repair' ( (lv_mttr_9_0= RULE_STRING ) ) ( (lv_mttrPercentile_10_0= rulePercentile ) )? )? (otherlv_11= 'regular-down-times' ( (lv_regularDownTimes_12_0= RULE_STRING ) ) )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleAvailability1816); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAvailabilityAccess().getAvailabilityKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAvailability1828); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAvailabilityAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleAvailability1840); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAvailabilityAccess().getAvailabilityKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:963:1: ( (lv_availability_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:964:1: (lv_availability_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:964:1: (lv_availability_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:965:3: lv_availability_3_0= RULE_STRING
            {
            lv_availability_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAvailability1857); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleAvailability1874); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getAvailabilityAccess().getPercentileKeyword_4());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:985:1: ( (lv_percentile_5_0= rulePercentile ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:986:1: (lv_percentile_5_0= rulePercentile )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:986:1: (lv_percentile_5_0= rulePercentile )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:987:3: lv_percentile_5_0= rulePercentile
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAvailabilityAccess().getPercentilePercentileParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePercentile_in_ruleAvailability1895);
            lv_percentile_5_0=rulePercentile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAvailabilityRule());
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1003:2: (otherlv_6= 'mean-time-between-failure' ( (lv_mtbf_7_0= RULE_STRING ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==37) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1003:4: otherlv_6= 'mean-time-between-failure' ( (lv_mtbf_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleAvailability1908); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getAvailabilityAccess().getMeanTimeBetweenFailureKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1007:1: ( (lv_mtbf_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1008:1: (lv_mtbf_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1008:1: (lv_mtbf_7_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1009:3: lv_mtbf_7_0= RULE_STRING
                    {
                    lv_mtbf_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAvailability1925); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_mtbf_7_0, grammarAccess.getAvailabilityAccess().getMtbfSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAvailabilityRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"mtbf",
                              		lv_mtbf_7_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1025:4: (otherlv_8= 'mean-time-to-repair' ( (lv_mttr_9_0= RULE_STRING ) ) ( (lv_mttrPercentile_10_0= rulePercentile ) )? )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==38) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1025:6: otherlv_8= 'mean-time-to-repair' ( (lv_mttr_9_0= RULE_STRING ) ) ( (lv_mttrPercentile_10_0= rulePercentile ) )?
                    {
                    otherlv_8=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleAvailability1945); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getAvailabilityAccess().getMeanTimeToRepairKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1029:1: ( (lv_mttr_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1030:1: (lv_mttr_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1030:1: (lv_mttr_9_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1031:3: lv_mttr_9_0= RULE_STRING
                    {
                    lv_mttr_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAvailability1962); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_mttr_9_0, grammarAccess.getAvailabilityAccess().getMttrSTRINGTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAvailabilityRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"mttr",
                              		lv_mttr_9_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1047:2: ( (lv_mttrPercentile_10_0= rulePercentile ) )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==RULE_INT) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1048:1: (lv_mttrPercentile_10_0= rulePercentile )
                            {
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1048:1: (lv_mttrPercentile_10_0= rulePercentile )
                            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1049:3: lv_mttrPercentile_10_0= rulePercentile
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAvailabilityAccess().getMttrPercentilePercentileParserRuleCall_7_2_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_rulePercentile_in_ruleAvailability1988);
                            lv_mttrPercentile_10_0=rulePercentile();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getAvailabilityRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"mttrPercentile",
                                      		lv_mttrPercentile_10_0, 
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1065:5: (otherlv_11= 'regular-down-times' ( (lv_regularDownTimes_12_0= RULE_STRING ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==39) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1065:7: otherlv_11= 'regular-down-times' ( (lv_regularDownTimes_12_0= RULE_STRING ) )
                    {
                    otherlv_11=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleAvailability2004); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getAvailabilityAccess().getRegularDownTimesKeyword_8_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1069:1: ( (lv_regularDownTimes_12_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1070:1: (lv_regularDownTimes_12_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1070:1: (lv_regularDownTimes_12_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1071:3: lv_regularDownTimes_12_0= RULE_STRING
                    {
                    lv_regularDownTimes_12_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAvailability2021); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_regularDownTimes_12_0, grammarAccess.getAvailabilityAccess().getRegularDownTimesSTRINGTerminalRuleCall_8_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAvailabilityRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"regularDownTimes",
                              		lv_regularDownTimes_12_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAvailability2040); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getAvailabilityAccess().getRightCurlyBracketKeyword_9());
                  
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1099:1: entryRuleThroughput returns [EObject current=null] : iv_ruleThroughput= ruleThroughput EOF ;
    public final EObject entryRuleThroughput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThroughput = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1100:2: (iv_ruleThroughput= ruleThroughput EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1101:2: iv_ruleThroughput= ruleThroughput EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getThroughputRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleThroughput_in_entryRuleThroughput2076);
            iv_ruleThroughput=ruleThroughput();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleThroughput; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleThroughput2086); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1108:1: ruleThroughput returns [EObject current=null] : (otherlv_0= 'throughput' otherlv_1= '{' otherlv_2= 'throughput' ( (lv_definition_3_0= RULE_STRING ) ) otherlv_4= 'score-to-be-kept' ( (lv_score_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1111:28: ( (otherlv_0= 'throughput' otherlv_1= '{' otherlv_2= 'throughput' ( (lv_definition_3_0= RULE_STRING ) ) otherlv_4= 'score-to-be-kept' ( (lv_score_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1112:1: (otherlv_0= 'throughput' otherlv_1= '{' otherlv_2= 'throughput' ( (lv_definition_3_0= RULE_STRING ) ) otherlv_4= 'score-to-be-kept' ( (lv_score_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1112:1: (otherlv_0= 'throughput' otherlv_1= '{' otherlv_2= 'throughput' ( (lv_definition_3_0= RULE_STRING ) ) otherlv_4= 'score-to-be-kept' ( (lv_score_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1112:3: otherlv_0= 'throughput' otherlv_1= '{' otherlv_2= 'throughput' ( (lv_definition_3_0= RULE_STRING ) ) otherlv_4= 'score-to-be-kept' ( (lv_score_5_0= RULE_STRING ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleThroughput2123); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getThroughputAccess().getThroughputKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleThroughput2135); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getThroughputAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleThroughput2147); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getThroughputAccess().getThroughputKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1124:1: ( (lv_definition_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1125:1: (lv_definition_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1125:1: (lv_definition_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1126:3: lv_definition_3_0= RULE_STRING
            {
            lv_definition_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleThroughput2164); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleThroughput2181); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getThroughputAccess().getScoreToBeKeptKeyword_4());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1146:1: ( (lv_score_5_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1147:1: (lv_score_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1147:1: (lv_score_5_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1148:3: lv_score_5_0= RULE_STRING
            {
            lv_score_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleThroughput2198); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1164:2: ( (lv_escalation_6_0= ruleEscalation ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==75) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1165:1: (lv_escalation_6_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1165:1: (lv_escalation_6_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1166:3: lv_escalation_6_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getThroughputAccess().getEscalationEscalationParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleThroughput2224);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1182:3: (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==34) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1182:5: otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleThroughput2238); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getThroughputAccess().getPenaltyKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1186:1: ( (lv_penalty_8_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1187:1: (lv_penalty_8_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1187:1: (lv_penalty_8_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1188:3: lv_penalty_8_0= RULE_STRING
                    {
                    lv_penalty_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleThroughput2255); if (state.failed) return current;
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

            otherlv_9=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleThroughput2274); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1216:1: entryRuleLatency returns [EObject current=null] : iv_ruleLatency= ruleLatency EOF ;
    public final EObject entryRuleLatency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLatency = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1217:2: (iv_ruleLatency= ruleLatency EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1218:2: iv_ruleLatency= ruleLatency EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLatencyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLatency_in_entryRuleLatency2310);
            iv_ruleLatency=ruleLatency();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLatency; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLatency2320); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1225:1: ruleLatency returns [EObject current=null] : (otherlv_0= 'latency' otherlv_1= '{' otherlv_2= 'latency' ( (lv_latency_3_0= 'STRING' ) ) otherlv_4= 'percentile' ( (lv_percentile_5_0= rulePercentile ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1228:28: ( (otherlv_0= 'latency' otherlv_1= '{' otherlv_2= 'latency' ( (lv_latency_3_0= 'STRING' ) ) otherlv_4= 'percentile' ( (lv_percentile_5_0= rulePercentile ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1229:1: (otherlv_0= 'latency' otherlv_1= '{' otherlv_2= 'latency' ( (lv_latency_3_0= 'STRING' ) ) otherlv_4= 'percentile' ( (lv_percentile_5_0= rulePercentile ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1229:1: (otherlv_0= 'latency' otherlv_1= '{' otherlv_2= 'latency' ( (lv_latency_3_0= 'STRING' ) ) otherlv_4= 'percentile' ( (lv_percentile_5_0= rulePercentile ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1229:3: otherlv_0= 'latency' otherlv_1= '{' otherlv_2= 'latency' ( (lv_latency_3_0= 'STRING' ) ) otherlv_4= 'percentile' ( (lv_percentile_5_0= rulePercentile ) ) ( (lv_escalation_6_0= ruleEscalation ) )? (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleLatency2357); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLatencyAccess().getLatencyKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleLatency2369); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLatencyAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleLatency2381); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getLatencyAccess().getLatencyKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1241:1: ( (lv_latency_3_0= 'STRING' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1242:1: (lv_latency_3_0= 'STRING' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1242:1: (lv_latency_3_0= 'STRING' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1243:3: lv_latency_3_0= 'STRING'
            {
            lv_latency_3_0=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleLatency2399); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleLatency2424); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLatencyAccess().getPercentileKeyword_4());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1260:1: ( (lv_percentile_5_0= rulePercentile ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1261:1: (lv_percentile_5_0= rulePercentile )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1261:1: (lv_percentile_5_0= rulePercentile )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1262:3: lv_percentile_5_0= rulePercentile
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLatencyAccess().getPercentilePercentileParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePercentile_in_ruleLatency2445);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1278:2: ( (lv_escalation_6_0= ruleEscalation ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==75) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1279:1: (lv_escalation_6_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1279:1: (lv_escalation_6_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1280:3: lv_escalation_6_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLatencyAccess().getEscalationEscalationParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleLatency2466);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1296:3: (otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==34) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1296:5: otherlv_7= 'penalty' ( (lv_penalty_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleLatency2480); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getLatencyAccess().getPenaltyKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1300:1: ( (lv_penalty_8_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1301:1: (lv_penalty_8_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1301:1: (lv_penalty_8_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1302:3: lv_penalty_8_0= RULE_STRING
                    {
                    lv_penalty_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleLatency2497); if (state.failed) return current;
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

            otherlv_9=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleLatency2516); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1330:1: entryRuleMaxDownTime returns [EObject current=null] : iv_ruleMaxDownTime= ruleMaxDownTime EOF ;
    public final EObject entryRuleMaxDownTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxDownTime = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1331:2: (iv_ruleMaxDownTime= ruleMaxDownTime EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1332:2: iv_ruleMaxDownTime= ruleMaxDownTime EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMaxDownTimeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMaxDownTime_in_entryRuleMaxDownTime2552);
            iv_ruleMaxDownTime=ruleMaxDownTime();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMaxDownTime; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxDownTime2562); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1339:1: ruleMaxDownTime returns [EObject current=null] : (otherlv_0= 'max-downtime' otherlv_1= '{' otherlv_2= 'duration' ( (lv_definition_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1342:28: ( (otherlv_0= 'max-downtime' otherlv_1= '{' otherlv_2= 'duration' ( (lv_definition_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1343:1: (otherlv_0= 'max-downtime' otherlv_1= '{' otherlv_2= 'duration' ( (lv_definition_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1343:1: (otherlv_0= 'max-downtime' otherlv_1= '{' otherlv_2= 'duration' ( (lv_definition_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1343:3: otherlv_0= 'max-downtime' otherlv_1= '{' otherlv_2= 'duration' ( (lv_definition_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleMaxDownTime2599); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMaxDownTimeAccess().getMaxDowntimeKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleMaxDownTime2611); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMaxDownTimeAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleMaxDownTime2623); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMaxDownTimeAccess().getDurationKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1355:1: ( (lv_definition_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1356:1: (lv_definition_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1356:1: (lv_definition_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1357:3: lv_definition_3_0= RULE_STRING
            {
            lv_definition_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMaxDownTime2640); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1373:2: ( (lv_escalation_4_0= ruleEscalation ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==75) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1374:1: (lv_escalation_4_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1374:1: (lv_escalation_4_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1375:3: lv_escalation_4_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMaxDownTimeAccess().getEscalationEscalationParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleMaxDownTime2666);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1391:3: (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==34) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1391:5: otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleMaxDownTime2680); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getMaxDownTimeAccess().getPenaltyKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1395:1: ( (lv_penalty_6_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1396:1: (lv_penalty_6_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1396:1: (lv_penalty_6_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1397:3: lv_penalty_6_0= RULE_STRING
                    {
                    lv_penalty_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMaxDownTime2697); if (state.failed) return current;
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

            otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleMaxDownTime2716); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1425:1: entryRuleCapacityRequirement returns [EObject current=null] : iv_ruleCapacityRequirement= ruleCapacityRequirement EOF ;
    public final EObject entryRuleCapacityRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCapacityRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1426:2: (iv_ruleCapacityRequirement= ruleCapacityRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1427:2: iv_ruleCapacityRequirement= ruleCapacityRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCapacityRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCapacityRequirement_in_entryRuleCapacityRequirement2752);
            iv_ruleCapacityRequirement=ruleCapacityRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCapacityRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCapacityRequirement2762); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1434:1: ruleCapacityRequirement returns [EObject current=null] : (otherlv_0= 'capacity' otherlv_1= '{' () (otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) ) )? (otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) ) )? ( (lv_escalation_9_0= ruleEscalation ) )? (otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) ) )? otherlv_12= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1437:28: ( (otherlv_0= 'capacity' otherlv_1= '{' () (otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) ) )? (otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) ) )? ( (lv_escalation_9_0= ruleEscalation ) )? (otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) ) )? otherlv_12= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1438:1: (otherlv_0= 'capacity' otherlv_1= '{' () (otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) ) )? (otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) ) )? ( (lv_escalation_9_0= ruleEscalation ) )? (otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) ) )? otherlv_12= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1438:1: (otherlv_0= 'capacity' otherlv_1= '{' () (otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) ) )? (otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) ) )? ( (lv_escalation_9_0= ruleEscalation ) )? (otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) ) )? otherlv_12= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1438:3: otherlv_0= 'capacity' otherlv_1= '{' () (otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) ) )? (otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) ) )? ( (lv_escalation_9_0= ruleEscalation ) )? (otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleCapacityRequirement2799); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getCapacityRequirementAccess().getCapacityKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleCapacityRequirement2811); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCapacityRequirementAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1446:1: ()
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1447:2: 
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1455:2: (otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==47) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1455:4: otherlv_3= 'num-of-requests' ( (lv_requestNum_4_0= RULE_STRING ) ) otherlv_5= 'per' ( (lv_timeUnit_6_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleCapacityRequirement2836); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getCapacityRequirementAccess().getNumOfRequestsKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1459:1: ( (lv_requestNum_4_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1460:1: (lv_requestNum_4_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1460:1: (lv_requestNum_4_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1461:3: lv_requestNum_4_0= RULE_STRING
                    {
                    lv_requestNum_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCapacityRequirement2853); if (state.failed) return current;
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

                    otherlv_5=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleCapacityRequirement2870); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getCapacityRequirementAccess().getPerKeyword_3_2());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1481:1: ( (lv_timeUnit_6_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1482:1: (lv_timeUnit_6_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1482:1: (lv_timeUnit_6_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1483:3: lv_timeUnit_6_0= RULE_STRING
                    {
                    lv_timeUnit_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCapacityRequirement2887); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1499:4: (otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==49) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1499:6: otherlv_7= 'message-size' ( (lv_messageSize_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleCapacityRequirement2907); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getCapacityRequirementAccess().getMessageSizeKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1503:1: ( (lv_messageSize_8_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1504:1: (lv_messageSize_8_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1504:1: (lv_messageSize_8_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1505:3: lv_messageSize_8_0= RULE_STRING
                    {
                    lv_messageSize_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCapacityRequirement2924); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1521:4: ( (lv_escalation_9_0= ruleEscalation ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==75) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1522:1: (lv_escalation_9_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1522:1: (lv_escalation_9_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1523:3: lv_escalation_9_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCapacityRequirementAccess().getEscalationEscalationParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleCapacityRequirement2952);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1539:3: (otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==34) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1539:5: otherlv_10= 'penalty' ( (lv_penalty_11_0= RULE_STRING ) )
                    {
                    otherlv_10=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleCapacityRequirement2966); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getCapacityRequirementAccess().getPenaltyKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1543:1: ( (lv_penalty_11_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1544:1: (lv_penalty_11_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1544:1: (lv_penalty_11_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1545:3: lv_penalty_11_0= RULE_STRING
                    {
                    lv_penalty_11_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCapacityRequirement2983); if (state.failed) return current;
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

            otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleCapacityRequirement3002); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1573:1: entryRuleReliablityRequirement returns [EObject current=null] : iv_ruleReliablityRequirement= ruleReliablityRequirement EOF ;
    public final EObject entryRuleReliablityRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReliablityRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1574:2: (iv_ruleReliablityRequirement= ruleReliablityRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1575:2: iv_ruleReliablityRequirement= ruleReliablityRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReliablityRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReliablityRequirement_in_entryRuleReliablityRequirement3038);
            iv_ruleReliablityRequirement=ruleReliablityRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReliablityRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReliablityRequirement3048); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1582:1: ruleReliablityRequirement returns [EObject current=null] : (otherlv_0= 'message-exchange-reliability' otherlv_1= '{' ( (lv_reliability_2_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_3_0= 'in-order-delivery' ) )? otherlv_4= '}' ) ;
    public final EObject ruleReliablityRequirement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_inOrderDelivery_3_0=null;
        Token otherlv_4=null;
        Enumerator lv_reliability_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1585:28: ( (otherlv_0= 'message-exchange-reliability' otherlv_1= '{' ( (lv_reliability_2_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_3_0= 'in-order-delivery' ) )? otherlv_4= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1586:1: (otherlv_0= 'message-exchange-reliability' otherlv_1= '{' ( (lv_reliability_2_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_3_0= 'in-order-delivery' ) )? otherlv_4= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1586:1: (otherlv_0= 'message-exchange-reliability' otherlv_1= '{' ( (lv_reliability_2_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_3_0= 'in-order-delivery' ) )? otherlv_4= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1586:3: otherlv_0= 'message-exchange-reliability' otherlv_1= '{' ( (lv_reliability_2_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_3_0= 'in-order-delivery' ) )? otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleReliablityRequirement3085); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getReliablityRequirementAccess().getMessageExchangeReliabilityKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleReliablityRequirement3097); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getReliablityRequirementAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1594:1: ( (lv_reliability_2_0= ruleReliablilityKind ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1595:1: (lv_reliability_2_0= ruleReliablilityKind )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1595:1: (lv_reliability_2_0= ruleReliablilityKind )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1596:3: lv_reliability_2_0= ruleReliablilityKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReliablityRequirementAccess().getReliabilityReliablilityKindEnumRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleReliablilityKind_in_ruleReliablityRequirement3118);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1612:2: ( (lv_inOrderDelivery_3_0= 'in-order-delivery' ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==51) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1613:1: (lv_inOrderDelivery_3_0= 'in-order-delivery' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1613:1: (lv_inOrderDelivery_3_0= 'in-order-delivery' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1614:3: lv_inOrderDelivery_3_0= 'in-order-delivery'
                    {
                    lv_inOrderDelivery_3_0=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleReliablityRequirement3136); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleReliablityRequirement3162); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1639:1: entryRuleAccuracyRequirement returns [EObject current=null] : iv_ruleAccuracyRequirement= ruleAccuracyRequirement EOF ;
    public final EObject entryRuleAccuracyRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccuracyRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1640:2: (iv_ruleAccuracyRequirement= ruleAccuracyRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1641:2: iv_ruleAccuracyRequirement= ruleAccuracyRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAccuracyRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAccuracyRequirement_in_entryRuleAccuracyRequirement3198);
            iv_ruleAccuracyRequirement=ruleAccuracyRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAccuracyRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAccuracyRequirement3208); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1648:1: ruleAccuracyRequirement returns [EObject current=null] : (otherlv_0= 'accuracy' otherlv_1= '{' otherlv_2= 'max-error-rate' ( (lv_maxErrorRate_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1651:28: ( (otherlv_0= 'accuracy' otherlv_1= '{' otherlv_2= 'max-error-rate' ( (lv_maxErrorRate_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1652:1: (otherlv_0= 'accuracy' otherlv_1= '{' otherlv_2= 'max-error-rate' ( (lv_maxErrorRate_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1652:1: (otherlv_0= 'accuracy' otherlv_1= '{' otherlv_2= 'max-error-rate' ( (lv_maxErrorRate_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1652:3: otherlv_0= 'accuracy' otherlv_1= '{' otherlv_2= 'max-error-rate' ( (lv_maxErrorRate_3_0= RULE_STRING ) ) ( (lv_escalation_4_0= ruleEscalation ) )? (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleAccuracyRequirement3245); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAccuracyRequirementAccess().getAccuracyKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAccuracyRequirement3257); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAccuracyRequirementAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleAccuracyRequirement3269); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAccuracyRequirementAccess().getMaxErrorRateKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1664:1: ( (lv_maxErrorRate_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1665:1: (lv_maxErrorRate_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1665:1: (lv_maxErrorRate_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1666:3: lv_maxErrorRate_3_0= RULE_STRING
            {
            lv_maxErrorRate_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAccuracyRequirement3286); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1682:2: ( (lv_escalation_4_0= ruleEscalation ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==75) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1683:1: (lv_escalation_4_0= ruleEscalation )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1683:1: (lv_escalation_4_0= ruleEscalation )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1684:3: lv_escalation_4_0= ruleEscalation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAccuracyRequirementAccess().getEscalationEscalationParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleAccuracyRequirement3312);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1700:3: (otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==34) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1700:5: otherlv_5= 'penalty' ( (lv_penalty_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAccuracyRequirement3326); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getAccuracyRequirementAccess().getPenaltyKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1704:1: ( (lv_penalty_6_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1705:1: (lv_penalty_6_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1705:1: (lv_penalty_6_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1706:3: lv_penalty_6_0= RULE_STRING
                    {
                    lv_penalty_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAccuracyRequirement3343); if (state.failed) return current;
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

            otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAccuracyRequirement3362); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1734:1: entryRuleLogRequirement returns [EObject current=null] : iv_ruleLogRequirement= ruleLogRequirement EOF ;
    public final EObject entryRuleLogRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1735:2: (iv_ruleLogRequirement= ruleLogRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1736:2: iv_ruleLogRequirement= ruleLogRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLogRequirement_in_entryRuleLogRequirement3398);
            iv_ruleLogRequirement=ruleLogRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLogRequirement3408); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1743:1: ruleLogRequirement returns [EObject current=null] : (otherlv_0= 'logging' otherlv_1= '{' otherlv_2= 'message-log-level' ( (lv_logLevel_3_0= ruleLogRequirementKind ) ) otherlv_4= 'additional-logging-requirements' ( (lv_additionalLoggingRequirement_5_0= RULE_STRING ) ) ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1746:28: ( (otherlv_0= 'logging' otherlv_1= '{' otherlv_2= 'message-log-level' ( (lv_logLevel_3_0= ruleLogRequirementKind ) ) otherlv_4= 'additional-logging-requirements' ( (lv_additionalLoggingRequirement_5_0= RULE_STRING ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1747:1: (otherlv_0= 'logging' otherlv_1= '{' otherlv_2= 'message-log-level' ( (lv_logLevel_3_0= ruleLogRequirementKind ) ) otherlv_4= 'additional-logging-requirements' ( (lv_additionalLoggingRequirement_5_0= RULE_STRING ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1747:1: (otherlv_0= 'logging' otherlv_1= '{' otherlv_2= 'message-log-level' ( (lv_logLevel_3_0= ruleLogRequirementKind ) ) otherlv_4= 'additional-logging-requirements' ( (lv_additionalLoggingRequirement_5_0= RULE_STRING ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1747:3: otherlv_0= 'logging' otherlv_1= '{' otherlv_2= 'message-log-level' ( (lv_logLevel_3_0= ruleLogRequirementKind ) ) otherlv_4= 'additional-logging-requirements' ( (lv_additionalLoggingRequirement_5_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleLogRequirement3445); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLogRequirementAccess().getLoggingKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleLogRequirement3457); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLogRequirementAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleLogRequirement3469); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getLogRequirementAccess().getMessageLogLevelKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1759:1: ( (lv_logLevel_3_0= ruleLogRequirementKind ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1760:1: (lv_logLevel_3_0= ruleLogRequirementKind )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1760:1: (lv_logLevel_3_0= ruleLogRequirementKind )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1761:3: lv_logLevel_3_0= ruleLogRequirementKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogRequirementAccess().getLogLevelLogRequirementKindEnumRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLogRequirementKind_in_ruleLogRequirement3490);
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

            otherlv_4=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleLogRequirement3502); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLogRequirementAccess().getAdditionalLoggingRequirementsKeyword_4());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1781:1: ( (lv_additionalLoggingRequirement_5_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1782:1: (lv_additionalLoggingRequirement_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1782:1: (lv_additionalLoggingRequirement_5_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1783:3: lv_additionalLoggingRequirement_5_0= RULE_STRING
            {
            lv_additionalLoggingRequirement_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleLogRequirement3519); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1807:1: entryRulePercentile returns [EObject current=null] : iv_rulePercentile= rulePercentile EOF ;
    public final EObject entryRulePercentile() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePercentile = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1808:2: (iv_rulePercentile= rulePercentile EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1809:2: iv_rulePercentile= rulePercentile EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPercentileRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePercentile_in_entryRulePercentile3560);
            iv_rulePercentile=rulePercentile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePercentile; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePercentile3570); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1816:1: rulePercentile returns [EObject current=null] : ( ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%' ) ;
    public final EObject rulePercentile() throws RecognitionException {
        EObject current = null;

        Token lv_percentile_0_0=null;
        Token otherlv_1=null;
        Token this_INT_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1819:28: ( ( ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1820:1: ( ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1820:1: ( ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1820:2: ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%'
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1820:2: ( (lv_percentile_0_0= RULE_INT ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1821:1: (lv_percentile_0_0= RULE_INT )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1821:1: (lv_percentile_0_0= RULE_INT )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1822:3: lv_percentile_0_0= RULE_INT
            {
            lv_percentile_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rulePercentile3612); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1838:2: (otherlv_1= '.' this_INT_2= RULE_INT )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==57) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1838:4: otherlv_1= '.' this_INT_2= RULE_INT
            	    {
            	    otherlv_1=(Token)match(input,57,FollowSets000.FOLLOW_57_in_rulePercentile3630); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPercentileAccess().getFullStopKeyword_1_0());
            	          
            	    }
            	    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rulePercentile3641); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_INT_2, grammarAccess.getPercentileAccess().getINTTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            otherlv_3=(Token)match(input,58,FollowSets000.FOLLOW_58_in_rulePercentile3654); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1858:1: entryRuleSecurityRequirement returns [EObject current=null] : iv_ruleSecurityRequirement= ruleSecurityRequirement EOF ;
    public final EObject entryRuleSecurityRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecurityRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1859:2: (iv_ruleSecurityRequirement= ruleSecurityRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1860:2: iv_ruleSecurityRequirement= ruleSecurityRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSecurityRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSecurityRequirement_in_entryRuleSecurityRequirement3690);
            iv_ruleSecurityRequirement=ruleSecurityRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSecurityRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecurityRequirement3700); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1867:1: ruleSecurityRequirement returns [EObject current=null] : (this_AuthenticationRequirement_0= ruleAuthenticationRequirement | this_SigningRequirement_1= ruleSigningRequirement | this_EncryptionRequirement_2= ruleEncryptionRequirement ) ;
    public final EObject ruleSecurityRequirement() throws RecognitionException {
        EObject current = null;

        EObject this_AuthenticationRequirement_0 = null;

        EObject this_SigningRequirement_1 = null;

        EObject this_EncryptionRequirement_2 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1870:28: ( (this_AuthenticationRequirement_0= ruleAuthenticationRequirement | this_SigningRequirement_1= ruleSigningRequirement | this_EncryptionRequirement_2= ruleEncryptionRequirement ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1871:1: (this_AuthenticationRequirement_0= ruleAuthenticationRequirement | this_SigningRequirement_1= ruleSigningRequirement | this_EncryptionRequirement_2= ruleEncryptionRequirement )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1871:1: (this_AuthenticationRequirement_0= ruleAuthenticationRequirement | this_SigningRequirement_1= ruleSigningRequirement | this_EncryptionRequirement_2= ruleEncryptionRequirement )
            int alt46=3;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt46=1;
                }
                break;
            case 66:
                {
                alt46=2;
                }
                break;
            case 72:
                {
                alt46=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1872:2: this_AuthenticationRequirement_0= ruleAuthenticationRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityRequirementAccess().getAuthenticationRequirementParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAuthenticationRequirement_in_ruleSecurityRequirement3750);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1885:2: this_SigningRequirement_1= ruleSigningRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityRequirementAccess().getSigningRequirementParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSigningRequirement_in_ruleSecurityRequirement3780);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1898:2: this_EncryptionRequirement_2= ruleEncryptionRequirement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityRequirementAccess().getEncryptionRequirementParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEncryptionRequirement_in_ruleSecurityRequirement3810);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1917:1: entryRuleAuthenticationRequirement returns [EObject current=null] : iv_ruleAuthenticationRequirement= ruleAuthenticationRequirement EOF ;
    public final EObject entryRuleAuthenticationRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthenticationRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1918:2: (iv_ruleAuthenticationRequirement= ruleAuthenticationRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1919:2: iv_ruleAuthenticationRequirement= ruleAuthenticationRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAuthenticationRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthenticationRequirement_in_entryRuleAuthenticationRequirement3845);
            iv_ruleAuthenticationRequirement=ruleAuthenticationRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAuthenticationRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAuthenticationRequirement3855); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1926:1: ruleAuthenticationRequirement returns [EObject current=null] : ( () otherlv_1= 'authentication-procedure' ( (lv_optional_2_0= 'optional' ) )? otherlv_3= '{' otherlv_4= 'auth-tokens' otherlv_5= '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ otherlv_7= '}' otherlv_8= 'hash-algorithms' otherlv_9= '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* otherlv_11= '}' ( (lv_useNonce_12_0= 'use-nonce' ) )? (otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) ) )? otherlv_15= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1929:28: ( ( () otherlv_1= 'authentication-procedure' ( (lv_optional_2_0= 'optional' ) )? otherlv_3= '{' otherlv_4= 'auth-tokens' otherlv_5= '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ otherlv_7= '}' otherlv_8= 'hash-algorithms' otherlv_9= '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* otherlv_11= '}' ( (lv_useNonce_12_0= 'use-nonce' ) )? (otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) ) )? otherlv_15= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1930:1: ( () otherlv_1= 'authentication-procedure' ( (lv_optional_2_0= 'optional' ) )? otherlv_3= '{' otherlv_4= 'auth-tokens' otherlv_5= '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ otherlv_7= '}' otherlv_8= 'hash-algorithms' otherlv_9= '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* otherlv_11= '}' ( (lv_useNonce_12_0= 'use-nonce' ) )? (otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) ) )? otherlv_15= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1930:1: ( () otherlv_1= 'authentication-procedure' ( (lv_optional_2_0= 'optional' ) )? otherlv_3= '{' otherlv_4= 'auth-tokens' otherlv_5= '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ otherlv_7= '}' otherlv_8= 'hash-algorithms' otherlv_9= '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* otherlv_11= '}' ( (lv_useNonce_12_0= 'use-nonce' ) )? (otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) ) )? otherlv_15= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1930:2: () otherlv_1= 'authentication-procedure' ( (lv_optional_2_0= 'optional' ) )? otherlv_3= '{' otherlv_4= 'auth-tokens' otherlv_5= '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ otherlv_7= '}' otherlv_8= 'hash-algorithms' otherlv_9= '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* otherlv_11= '}' ( (lv_useNonce_12_0= 'use-nonce' ) )? (otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) ) )? otherlv_15= '}'
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1930:2: ()
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1931:2: 
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

            otherlv_1=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleAuthenticationRequirement3904); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAuthenticationRequirementAccess().getAuthenticationProcedureKeyword_1());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1943:1: ( (lv_optional_2_0= 'optional' ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==60) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1944:1: (lv_optional_2_0= 'optional' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1944:1: (lv_optional_2_0= 'optional' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1945:3: lv_optional_2_0= 'optional'
                    {
                    lv_optional_2_0=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleAuthenticationRequirement3922); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAuthenticationRequirement3948); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAuthenticationRequirementAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleAuthenticationRequirement3960); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getAuthenticationRequirementAccess().getAuthTokensKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAuthenticationRequirement3972); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getAuthenticationRequirementAccess().getLeftCurlyBracketKeyword_5());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1970:1: ( (lv_authTokens_6_0= ruleAuthToken ) )+
            int cnt48=0;
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==60||(LA48_0>=122 && LA48_0<=130)) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1971:1: (lv_authTokens_6_0= ruleAuthToken )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1971:1: (lv_authTokens_6_0= ruleAuthToken )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:1972:3: lv_authTokens_6_0= ruleAuthToken
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAuthenticationRequirementAccess().getAuthTokensAuthTokenParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAuthToken_in_ruleAuthenticationRequirement3993);
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
            	    if ( cnt48 >= 1 ) break loop48;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(48, input);
                        throw eee;
                }
                cnt48++;
            } while (true);

            otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAuthenticationRequirement4006); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getAuthenticationRequirementAccess().getRightCurlyBracketKeyword_7());
                  
            }
            otherlv_8=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleAuthenticationRequirement4018); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getAuthenticationRequirementAccess().getHashAlgorithmsKeyword_8());
                  
            }
            otherlv_9=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAuthenticationRequirement4030); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getAuthenticationRequirementAccess().getLeftCurlyBracketKeyword_9());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2000:1: ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==60||LA49_0==65||(LA49_0>=103 && LA49_0<=107)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2001:1: (lv_hashAlgorithms_10_0= ruleHashAlgorithm )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2001:1: (lv_hashAlgorithms_10_0= ruleHashAlgorithm )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2002:3: lv_hashAlgorithms_10_0= ruleHashAlgorithm
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAuthenticationRequirementAccess().getHashAlgorithmsHashAlgorithmParserRuleCall_10_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleHashAlgorithm_in_ruleAuthenticationRequirement4051);
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
            	    break loop49;
                }
            } while (true);

            otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAuthenticationRequirement4064); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getAuthenticationRequirementAccess().getRightCurlyBracketKeyword_11());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2022:1: ( (lv_useNonce_12_0= 'use-nonce' ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==63) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2023:1: (lv_useNonce_12_0= 'use-nonce' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2023:1: (lv_useNonce_12_0= 'use-nonce' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2024:3: lv_useNonce_12_0= 'use-nonce'
                    {
                    lv_useNonce_12_0=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleAuthenticationRequirement4082); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2037:3: (otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==64) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2037:5: otherlv_13= 'issuer' ( (lv_issuer_14_0= RULE_STRING ) )
                    {
                    otherlv_13=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleAuthenticationRequirement4109); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getAuthenticationRequirementAccess().getIssuerKeyword_13_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2041:1: ( (lv_issuer_14_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2042:1: (lv_issuer_14_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2042:1: (lv_issuer_14_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2043:3: lv_issuer_14_0= RULE_STRING
                    {
                    lv_issuer_14_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAuthenticationRequirement4126); if (state.failed) return current;
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

            otherlv_15=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAuthenticationRequirement4145); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2071:1: entryRuleAuthToken returns [EObject current=null] : iv_ruleAuthToken= ruleAuthToken EOF ;
    public final EObject entryRuleAuthToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthToken = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2072:2: (iv_ruleAuthToken= ruleAuthToken EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2073:2: iv_ruleAuthToken= ruleAuthToken EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAuthTokenRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthToken_in_entryRuleAuthToken4181);
            iv_ruleAuthToken=ruleAuthToken();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAuthToken; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAuthToken4191); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2080:1: ruleAuthToken returns [EObject current=null] : ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) ) ;
    public final EObject ruleAuthToken() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Enumerator lv_kind_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2083:28: ( ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2084:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2084:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2084:2: ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2084:2: ( (lv_optional_0_0= 'optional' ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==60) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2085:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2085:1: (lv_optional_0_0= 'optional' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2086:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleAuthToken4234); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2099:3: ( (lv_kind_1_0= ruleAuthTokenKind ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2100:1: (lv_kind_1_0= ruleAuthTokenKind )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2100:1: (lv_kind_1_0= ruleAuthTokenKind )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2101:3: lv_kind_1_0= ruleAuthTokenKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAuthTokenAccess().getKindAuthTokenKindEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthTokenKind_in_ruleAuthToken4269);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2125:1: entryRuleHashAlgorithm returns [EObject current=null] : iv_ruleHashAlgorithm= ruleHashAlgorithm EOF ;
    public final EObject entryRuleHashAlgorithm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHashAlgorithm = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2126:2: (iv_ruleHashAlgorithm= ruleHashAlgorithm EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2127:2: iv_ruleHashAlgorithm= ruleHashAlgorithm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHashAlgorithmRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleHashAlgorithm_in_entryRuleHashAlgorithm4305);
            iv_ruleHashAlgorithm=ruleHashAlgorithm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHashAlgorithm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHashAlgorithm4315); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2134:1: ruleHashAlgorithm returns [EObject current=null] : ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) ) ;
    public final EObject ruleHashAlgorithm() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Token lv_useBase64_1_0=null;
        Enumerator lv_kind_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2137:28: ( ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2138:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2138:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2138:2: ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2138:2: ( (lv_optional_0_0= 'optional' ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==60) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2139:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2139:1: (lv_optional_0_0= 'optional' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2140:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleHashAlgorithm4358); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2153:3: ( (lv_useBase64_1_0= 'Base64-encoded' ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==65) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2154:1: (lv_useBase64_1_0= 'Base64-encoded' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2154:1: (lv_useBase64_1_0= 'Base64-encoded' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2155:3: lv_useBase64_1_0= 'Base64-encoded'
                    {
                    lv_useBase64_1_0=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleHashAlgorithm4390); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2168:3: ( (lv_kind_2_0= ruleHashAlgKind ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2169:1: (lv_kind_2_0= ruleHashAlgKind )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2169:1: (lv_kind_2_0= ruleHashAlgKind )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2170:3: lv_kind_2_0= ruleHashAlgKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getHashAlgorithmAccess().getKindHashAlgKindEnumRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleHashAlgKind_in_ruleHashAlgorithm4425);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2194:1: entryRuleSigningRequirement returns [EObject current=null] : iv_ruleSigningRequirement= ruleSigningRequirement EOF ;
    public final EObject entryRuleSigningRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSigningRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2195:2: (iv_ruleSigningRequirement= ruleSigningRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2196:2: iv_ruleSigningRequirement= ruleSigningRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSigningRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSigningRequirement_in_entryRuleSigningRequirement4461);
            iv_ruleSigningRequirement=ruleSigningRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSigningRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSigningRequirement4471); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2203:1: ruleSigningRequirement returns [EObject current=null] : ( () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2206:28: ( ( () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2207:1: ( () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2207:1: ( () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2207:2: () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}'
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2207:2: ()
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2208:2: 
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

            otherlv_1=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleSigningRequirement4520); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSigningRequirementAccess().getSigningPolicyKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSigningRequirement4532); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getSigningRequirementAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2224:1: (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==67) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2224:3: otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+
                    {
                    otherlv_3=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleSigningRequirement4545); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getSigningRequirementAccess().getSupportedAlgorithmsKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2228:1: ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+
                    int cnt55=0;
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( ((LA55_0>=103 && LA55_0<=105)||(LA55_0>=112 && LA55_0<=116)) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2229:1: (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm )
                    	    {
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2229:1: (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2230:3: lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSigningRequirementAccess().getSupportedSigningAlgorithmsSigningAlgothmEnumRuleCall_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleSigningAlgothm_in_ruleSigningRequirement4566);
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
                    	    if ( cnt55 >= 1 ) break loop55;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(55, input);
                                throw eee;
                        }
                        cnt55++;
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2246:5: (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==68) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2246:7: otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) )
                    {
                    otherlv_5=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleSigningRequirement4582); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSigningRequirementAccess().getRequiresAlgorithmKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2250:1: ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2251:1: (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2251:1: (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2252:3: lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSigningRequirementAccess().getRequiredSigningAlgorithmSigningAlgothmEnumRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSigningAlgothm_in_ruleSigningRequirement4603);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2268:4: (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==69) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2268:6: otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )*
                    {
                    otherlv_7=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleSigningRequirement4618); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getSigningRequirementAccess().getSignedMessagePartsKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2272:1: ( (lv_signedParts_8_0= ruleMessagePartRef ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2273:1: (lv_signedParts_8_0= ruleMessagePartRef )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2273:1: (lv_signedParts_8_0= ruleMessagePartRef )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2274:3: lv_signedParts_8_0= ruleMessagePartRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSigningRequirementAccess().getSignedPartsMessagePartRefParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_ruleSigningRequirement4639);
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

                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2290:2: (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==70) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2290:4: otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) )
                    	    {
                    	    otherlv_9=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleSigningRequirement4652); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getSigningRequirementAccess().getCommaKeyword_5_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2294:1: ( (lv_signedParts_10_0= ruleMessagePartRef ) )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2295:1: (lv_signedParts_10_0= ruleMessagePartRef )
                    	    {
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2295:1: (lv_signedParts_10_0= ruleMessagePartRef )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2296:3: lv_signedParts_10_0= ruleMessagePartRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSigningRequirementAccess().getSignedPartsMessagePartRefParserRuleCall_5_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_ruleSigningRequirement4673);
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
                    	    break loop58;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSigningRequirement4689); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2324:1: entryRuleMessagePartRef returns [EObject current=null] : iv_ruleMessagePartRef= ruleMessagePartRef EOF ;
    public final EObject entryRuleMessagePartRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessagePartRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2325:2: (iv_ruleMessagePartRef= ruleMessagePartRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2326:2: iv_ruleMessagePartRef= ruleMessagePartRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMessagePartRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_entryRuleMessagePartRef4725);
            iv_ruleMessagePartRef=ruleMessagePartRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMessagePartRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMessagePartRef4735); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2333:1: ruleMessagePartRef returns [EObject current=null] : ( ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleMessagePartRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_partRefExpression_2_0=null;
        Enumerator lv_messagePartRef_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2336:28: ( ( ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )? ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2337:1: ( ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )? )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2337:1: ( ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )? )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2337:2: ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )?
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2337:2: ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2338:1: (lv_messagePartRef_0_0= ruleMessagePartRefKind )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2338:1: (lv_messagePartRef_0_0= ruleMessagePartRefKind )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2339:3: lv_messagePartRef_0_0= ruleMessagePartRefKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMessagePartRefAccess().getMessagePartRefMessagePartRefKindEnumRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleMessagePartRefKind_in_ruleMessagePartRef4781);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2355:2: (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==71) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2355:4: otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleMessagePartRef4794); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMessagePartRefAccess().getExpressionKeyword_1_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2359:1: ( (lv_partRefExpression_2_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2360:1: (lv_partRefExpression_2_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2360:1: (lv_partRefExpression_2_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2361:3: lv_partRefExpression_2_0= RULE_STRING
                    {
                    lv_partRefExpression_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMessagePartRef4811); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2385:1: entryRuleEncryptionRequirement returns [EObject current=null] : iv_ruleEncryptionRequirement= ruleEncryptionRequirement EOF ;
    public final EObject entryRuleEncryptionRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEncryptionRequirement = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2386:2: (iv_ruleEncryptionRequirement= ruleEncryptionRequirement EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2387:2: iv_ruleEncryptionRequirement= ruleEncryptionRequirement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEncryptionRequirementRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEncryptionRequirement_in_entryRuleEncryptionRequirement4854);
            iv_ruleEncryptionRequirement=ruleEncryptionRequirement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEncryptionRequirement; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEncryptionRequirement4864); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2394:1: ruleEncryptionRequirement returns [EObject current=null] : ( () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2397:28: ( ( () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2398:1: ( () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2398:1: ( () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2398:2: () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}'
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2398:2: ()
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2399:2: 
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

            otherlv_1=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleEncryptionRequirement4913); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEncryptionRequirementAccess().getEncryptionPolicyKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEncryptionRequirement4925); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getEncryptionRequirementAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2415:1: (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==67) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2415:3: otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+
                    {
                    otherlv_3=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleEncryptionRequirement4938); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getEncryptionRequirementAccess().getSupportedAlgorithmsKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2419:1: ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+
                    int cnt61=0;
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==112||LA61_0==114||(LA61_0>=116 && LA61_0<=121)) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2420:1: (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind )
                    	    {
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2420:1: (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2421:3: lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getEncryptionRequirementAccess().getSupportedCipherAlgorithmsCipherAlgorithmKindEnumRuleCall_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCipherAlgorithmKind_in_ruleEncryptionRequirement4959);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2437:5: (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==68) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2437:7: otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) )
                    {
                    otherlv_5=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleEncryptionRequirement4975); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getEncryptionRequirementAccess().getRequiresAlgorithmKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2441:1: ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2442:1: (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2442:1: (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2443:3: lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEncryptionRequirementAccess().getRequiredCipherAlgorithmCipherAlgorithmKindEnumRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCipherAlgorithmKind_in_ruleEncryptionRequirement4996);
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2459:4: (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==73) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2459:6: otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )*
                    {
                    otherlv_7=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleEncryptionRequirement5011); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getEncryptionRequirementAccess().getEncryptedMessagePartsKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2463:1: ( (lv_encryptedParts_8_0= ruleMessagePartRef ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2464:1: (lv_encryptedParts_8_0= ruleMessagePartRef )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2464:1: (lv_encryptedParts_8_0= ruleMessagePartRef )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2465:3: lv_encryptedParts_8_0= ruleMessagePartRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEncryptionRequirementAccess().getEncryptedPartsMessagePartRefParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_ruleEncryptionRequirement5032);
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

                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2481:2: (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==70) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2481:4: otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) )
                    	    {
                    	    otherlv_9=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleEncryptionRequirement5045); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getEncryptionRequirementAccess().getCommaKeyword_5_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2485:1: ( (lv_encryptedParts_10_0= ruleMessagePartRef ) )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2486:1: (lv_encryptedParts_10_0= ruleMessagePartRef )
                    	    {
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2486:1: (lv_encryptedParts_10_0= ruleMessagePartRef )
                    	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2487:3: lv_encryptedParts_10_0= ruleMessagePartRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getEncryptionRequirementAccess().getEncryptedPartsMessagePartRefParserRuleCall_5_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_ruleEncryptionRequirement5066);
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
                    	    break loop64;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleEncryptionRequirement5082); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2515:1: entryRulePriorityDeclaration returns [EObject current=null] : iv_rulePriorityDeclaration= rulePriorityDeclaration EOF ;
    public final EObject entryRulePriorityDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePriorityDeclaration = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2516:2: (iv_rulePriorityDeclaration= rulePriorityDeclaration EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2517:2: iv_rulePriorityDeclaration= rulePriorityDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPriorityDeclarationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePriorityDeclaration_in_entryRulePriorityDeclaration5118);
            iv_rulePriorityDeclaration=rulePriorityDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePriorityDeclaration; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePriorityDeclaration5128); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2524:1: rulePriorityDeclaration returns [EObject current=null] : (otherlv_0= 'priority' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) ) ;
    public final EObject rulePriorityDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_description_3_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2527:28: ( (otherlv_0= 'priority' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2528:1: (otherlv_0= 'priority' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2528:1: (otherlv_0= 'priority' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2528:3: otherlv_0= 'priority' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,74,FollowSets000.FOLLOW_74_in_rulePriorityDeclaration5165); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPriorityDeclarationAccess().getPriorityKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2532:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2533:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2533:1: (lv_name_1_0= RULE_ID )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2534:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePriorityDeclaration5182); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_rulePriorityDeclaration5199); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getPriorityDeclarationAccess().getDescriptionKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2554:1: ( (lv_description_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2555:1: (lv_description_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2555:1: (lv_description_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2556:3: lv_description_3_0= RULE_STRING
            {
            lv_description_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rulePriorityDeclaration5216); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2580:1: entryRuleEscalation returns [EObject current=null] : iv_ruleEscalation= ruleEscalation EOF ;
    public final EObject entryRuleEscalation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEscalation = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2581:2: (iv_ruleEscalation= ruleEscalation EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2582:2: iv_ruleEscalation= ruleEscalation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEscalationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_entryRuleEscalation5257);
            iv_ruleEscalation=ruleEscalation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEscalation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEscalation5267); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2589:1: ruleEscalation returns [EObject current=null] : (otherlv_0= 'escalation' otherlv_1= '{' (otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) ) )? otherlv_4= 'escalate-to' otherlv_5= '{' ( (lv_escalationTargets_6_0= ruleContact ) )+ otherlv_7= '}' (otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) ;
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
        EObject lv_escalationTargets_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2592:28: ( (otherlv_0= 'escalation' otherlv_1= '{' (otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) ) )? otherlv_4= 'escalate-to' otherlv_5= '{' ( (lv_escalationTargets_6_0= ruleContact ) )+ otherlv_7= '}' (otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2593:1: (otherlv_0= 'escalation' otherlv_1= '{' (otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) ) )? otherlv_4= 'escalate-to' otherlv_5= '{' ( (lv_escalationTargets_6_0= ruleContact ) )+ otherlv_7= '}' (otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2593:1: (otherlv_0= 'escalation' otherlv_1= '{' (otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) ) )? otherlv_4= 'escalate-to' otherlv_5= '{' ( (lv_escalationTargets_6_0= ruleContact ) )+ otherlv_7= '}' (otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2593:3: otherlv_0= 'escalation' otherlv_1= '{' (otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) ) )? otherlv_4= 'escalate-to' otherlv_5= '{' ( (lv_escalationTargets_6_0= ruleContact ) )+ otherlv_7= '}' (otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) ) )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleEscalation5304); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEscalationAccess().getEscalationKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEscalation5316); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEscalationAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2601:1: (otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==76) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2601:3: otherlv_2= 'cause' ( (lv_cause_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleEscalation5329); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getEscalationAccess().getCauseKeyword_2_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2605:1: ( (lv_cause_3_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2606:1: (lv_cause_3_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2606:1: (lv_cause_3_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2607:3: lv_cause_3_0= RULE_STRING
                    {
                    lv_cause_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEscalation5346); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleEscalation5365); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEscalationAccess().getEscalateToKeyword_3());
                  
            }
            otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEscalation5377); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getEscalationAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2631:1: ( (lv_escalationTargets_6_0= ruleContact ) )+
            int cnt67=0;
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==79) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2632:1: (lv_escalationTargets_6_0= ruleContact )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2632:1: (lv_escalationTargets_6_0= ruleContact )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2633:3: lv_escalationTargets_6_0= ruleContact
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEscalationAccess().getEscalationTargetsContactParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleContact_in_ruleEscalation5398);
            	    lv_escalationTargets_6_0=ruleContact();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEscalationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"escalationTargets",
            	              		lv_escalationTargets_6_0, 
            	              		"Contact");
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

            otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleEscalation5411); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getEscalationAccess().getRightCurlyBracketKeyword_6());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2653:1: (otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==78) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2653:3: otherlv_8= 'procedure' ( (lv_procedure_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleEscalation5424); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getEscalationAccess().getProcedureKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2657:1: ( (lv_procedure_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2658:1: (lv_procedure_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2658:1: (lv_procedure_9_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2659:3: lv_procedure_9_0= RULE_STRING
                    {
                    lv_procedure_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEscalation5441); if (state.failed) return current;
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

            otherlv_10=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleEscalation5460); if (state.failed) return current;
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


    // $ANTLR start "entryRuleContact"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2687:1: entryRuleContact returns [EObject current=null] : iv_ruleContact= ruleContact EOF ;
    public final EObject entryRuleContact() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContact = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2688:2: (iv_ruleContact= ruleContact EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2689:2: iv_ruleContact= ruleContact EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContactRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleContact_in_entryRuleContact5496);
            iv_ruleContact=ruleContact();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContact; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContact5506); if (state.failed) return current;

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
    // $ANTLR end "entryRuleContact"


    // $ANTLR start "ruleContact"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2696:1: ruleContact returns [EObject current=null] : (otherlv_0= 'contact' otherlv_1= '{' otherlv_2= 'name' ( (lv_fullname_3_0= RULE_STRING ) ) (otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) ) )? (otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) ;
    public final EObject ruleContact() throws RecognitionException {
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2699:28: ( (otherlv_0= 'contact' otherlv_1= '{' otherlv_2= 'name' ( (lv_fullname_3_0= RULE_STRING ) ) (otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) ) )? (otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2700:1: (otherlv_0= 'contact' otherlv_1= '{' otherlv_2= 'name' ( (lv_fullname_3_0= RULE_STRING ) ) (otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) ) )? (otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2700:1: (otherlv_0= 'contact' otherlv_1= '{' otherlv_2= 'name' ( (lv_fullname_3_0= RULE_STRING ) ) (otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) ) )? (otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2700:3: otherlv_0= 'contact' otherlv_1= '{' otherlv_2= 'name' ( (lv_fullname_3_0= RULE_STRING ) ) (otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) ) )? (otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) ) )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleContact5543); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getContactAccess().getContactKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleContact5555); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getContactAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleContact5567); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getContactAccess().getNameKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2712:1: ( (lv_fullname_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2713:1: (lv_fullname_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2713:1: (lv_fullname_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2714:3: lv_fullname_3_0= RULE_STRING
            {
            lv_fullname_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleContact5584); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_fullname_3_0, grammarAccess.getContactAccess().getFullnameSTRINGTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getContactRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"fullname",
                      		lv_fullname_3_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2730:2: (otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==81) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2730:4: otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleContact5602); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getContactAccess().getPhoneKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2734:1: ( (lv_phone_5_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2735:1: (lv_phone_5_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2735:1: (lv_phone_5_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2736:3: lv_phone_5_0= RULE_STRING
                    {
                    lv_phone_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleContact5619); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_phone_5_0, grammarAccess.getContactAccess().getPhoneSTRINGTerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getContactRule());
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2752:4: (otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==82) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2752:6: otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleContact5639); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getContactAccess().getEmailKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2756:1: ( (lv_email_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2757:1: (lv_email_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2757:1: (lv_email_7_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2758:3: lv_email_7_0= RULE_STRING
                    {
                    lv_email_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleContact5656); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_email_7_0, grammarAccess.getContactAccess().getEmailSTRINGTerminalRuleCall_5_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getContactRule());
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

            otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleContact5675); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getContactAccess().getRightCurlyBracketKeyword_6());
                  
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
    // $ANTLR end "ruleContact"


    // $ANTLR start "entryRuleParty"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2786:1: entryRuleParty returns [EObject current=null] : iv_ruleParty= ruleParty EOF ;
    public final EObject entryRuleParty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParty = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2787:2: (iv_ruleParty= ruleParty EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2788:2: iv_ruleParty= ruleParty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPartyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleParty_in_entryRuleParty5711);
            iv_ruleParty=ruleParty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParty; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParty5721); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2795:1: ruleParty returns [EObject current=null] : (this_CustomerParty_0= ruleCustomerParty | this_ProviderParty_1= ruleProviderParty | this_ThirdParty_2= ruleThirdParty ) ;
    public final EObject ruleParty() throws RecognitionException {
        EObject current = null;

        EObject this_CustomerParty_0 = null;

        EObject this_ProviderParty_1 = null;

        EObject this_ThirdParty_2 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2798:28: ( (this_CustomerParty_0= ruleCustomerParty | this_ProviderParty_1= ruleProviderParty | this_ThirdParty_2= ruleThirdParty ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2799:1: (this_CustomerParty_0= ruleCustomerParty | this_ProviderParty_1= ruleProviderParty | this_ThirdParty_2= ruleThirdParty )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2799:1: (this_CustomerParty_0= ruleCustomerParty | this_ProviderParty_1= ruleProviderParty | this_ThirdParty_2= ruleThirdParty )
            int alt71=3;
            switch ( input.LA(1) ) {
            case 83:
                {
                alt71=1;
                }
                break;
            case 84:
                {
                alt71=2;
                }
                break;
            case 85:
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2800:2: this_CustomerParty_0= ruleCustomerParty
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartyAccess().getCustomerPartyParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCustomerParty_in_ruleParty5771);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2813:2: this_ProviderParty_1= ruleProviderParty
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartyAccess().getProviderPartyParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProviderParty_in_ruleParty5801);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2826:2: this_ThirdParty_2= ruleThirdParty
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPartyAccess().getThirdPartyParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleThirdParty_in_ruleParty5831);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2845:1: entryRuleCustomerParty returns [EObject current=null] : iv_ruleCustomerParty= ruleCustomerParty EOF ;
    public final EObject entryRuleCustomerParty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomerParty = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2846:2: (iv_ruleCustomerParty= ruleCustomerParty EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2847:2: iv_ruleCustomerParty= ruleCustomerParty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCustomerPartyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCustomerParty_in_entryRuleCustomerParty5866);
            iv_ruleCustomerParty=ruleCustomerParty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCustomerParty; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCustomerParty5876); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2854:1: ruleCustomerParty returns [EObject current=null] : (otherlv_0= 'customer-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepesentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2857:28: ( (otherlv_0= 'customer-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepesentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2858:1: (otherlv_0= 'customer-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepesentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2858:1: (otherlv_0= 'customer-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepesentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2858:3: otherlv_0= 'customer-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepesentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleCustomerParty5913); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getCustomerPartyAccess().getCustomerPartyKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2862:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2863:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2863:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2864:3: lv_name_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCustomerPartyAccess().getNameQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleCustomerParty5934);
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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleCustomerParty5946); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getCustomerPartyAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2884:1: ( (lv_representatives_3_0= ruleRepesentative ) )+
            int cnt72=0;
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==87) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2885:1: (lv_representatives_3_0= ruleRepesentative )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2885:1: (lv_representatives_3_0= ruleRepesentative )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2886:3: lv_representatives_3_0= ruleRepesentative
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCustomerPartyAccess().getRepresentativesRepesentativeParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleRepesentative_in_ruleCustomerParty5967);
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
            	    if ( cnt72 >= 1 ) break loop72;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(72, input);
                        throw eee;
                }
                cnt72++;
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2902:3: ( (lv_responsibilities_4_0= ruleResponsibility ) )+
            int cnt73=0;
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==88||LA73_0==92) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2903:1: (lv_responsibilities_4_0= ruleResponsibility )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2903:1: (lv_responsibilities_4_0= ruleResponsibility )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2904:3: lv_responsibilities_4_0= ruleResponsibility
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCustomerPartyAccess().getResponsibilitiesResponsibilityParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleResponsibility_in_ruleCustomerParty5989);
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

            otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleCustomerParty6002); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2932:1: entryRuleProviderParty returns [EObject current=null] : iv_ruleProviderParty= ruleProviderParty EOF ;
    public final EObject entryRuleProviderParty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProviderParty = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2933:2: (iv_ruleProviderParty= ruleProviderParty EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2934:2: iv_ruleProviderParty= ruleProviderParty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProviderPartyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleProviderParty_in_entryRuleProviderParty6038);
            iv_ruleProviderParty=ruleProviderParty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProviderParty; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProviderParty6048); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2941:1: ruleProviderParty returns [EObject current=null] : (otherlv_0= 'provider-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepesentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2944:28: ( (otherlv_0= 'provider-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepesentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2945:1: (otherlv_0= 'provider-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepesentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2945:1: (otherlv_0= 'provider-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepesentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2945:3: otherlv_0= 'provider-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_representatives_3_0= ruleRepesentative ) )+ ( (lv_responsibilities_4_0= ruleResponsibility ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,84,FollowSets000.FOLLOW_84_in_ruleProviderParty6085); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getProviderPartyAccess().getProviderPartyKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2949:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2950:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2950:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2951:3: lv_name_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProviderPartyAccess().getNameQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleProviderParty6106);
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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleProviderParty6118); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getProviderPartyAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2971:1: ( (lv_representatives_3_0= ruleRepesentative ) )+
            int cnt74=0;
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==87) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2972:1: (lv_representatives_3_0= ruleRepesentative )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2972:1: (lv_representatives_3_0= ruleRepesentative )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2973:3: lv_representatives_3_0= ruleRepesentative
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProviderPartyAccess().getRepresentativesRepesentativeParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleRepesentative_in_ruleProviderParty6139);
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
            	    if ( cnt74 >= 1 ) break loop74;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(74, input);
                        throw eee;
                }
                cnt74++;
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2989:3: ( (lv_responsibilities_4_0= ruleResponsibility ) )+
            int cnt75=0;
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==88||LA75_0==92) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2990:1: (lv_responsibilities_4_0= ruleResponsibility )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2990:1: (lv_responsibilities_4_0= ruleResponsibility )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:2991:3: lv_responsibilities_4_0= ruleResponsibility
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getProviderPartyAccess().getResponsibilitiesResponsibilityParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleResponsibility_in_ruleProviderParty6161);
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

            otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleProviderParty6174); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3019:1: entryRuleThirdParty returns [EObject current=null] : iv_ruleThirdParty= ruleThirdParty EOF ;
    public final EObject entryRuleThirdParty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThirdParty = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3020:2: (iv_ruleThirdParty= ruleThirdParty EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3021:2: iv_ruleThirdParty= ruleThirdParty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getThirdPartyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleThirdParty_in_entryRuleThirdParty6210);
            iv_ruleThirdParty=ruleThirdParty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleThirdParty; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleThirdParty6220); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3028:1: ruleThirdParty returns [EObject current=null] : (otherlv_0= 'third-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' otherlv_3= 'participation-role' ( (lv_role_4_0= RULE_STRING ) ) ( (lv_representatives_5_0= ruleRepesentative ) )+ ( (lv_responsibilities_6_0= ruleResponsibility ) )+ otherlv_7= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3031:28: ( (otherlv_0= 'third-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' otherlv_3= 'participation-role' ( (lv_role_4_0= RULE_STRING ) ) ( (lv_representatives_5_0= ruleRepesentative ) )+ ( (lv_responsibilities_6_0= ruleResponsibility ) )+ otherlv_7= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3032:1: (otherlv_0= 'third-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' otherlv_3= 'participation-role' ( (lv_role_4_0= RULE_STRING ) ) ( (lv_representatives_5_0= ruleRepesentative ) )+ ( (lv_responsibilities_6_0= ruleResponsibility ) )+ otherlv_7= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3032:1: (otherlv_0= 'third-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' otherlv_3= 'participation-role' ( (lv_role_4_0= RULE_STRING ) ) ( (lv_representatives_5_0= ruleRepesentative ) )+ ( (lv_responsibilities_6_0= ruleResponsibility ) )+ otherlv_7= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3032:3: otherlv_0= 'third-party' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' otherlv_3= 'participation-role' ( (lv_role_4_0= RULE_STRING ) ) ( (lv_representatives_5_0= ruleRepesentative ) )+ ( (lv_responsibilities_6_0= ruleResponsibility ) )+ otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,85,FollowSets000.FOLLOW_85_in_ruleThirdParty6257); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getThirdPartyAccess().getThirdPartyKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3036:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3037:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3037:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3038:3: lv_name_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getThirdPartyAccess().getNameQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleThirdParty6278);
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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleThirdParty6290); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getThirdPartyAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,86,FollowSets000.FOLLOW_86_in_ruleThirdParty6302); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getThirdPartyAccess().getParticipationRoleKeyword_3());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3062:1: ( (lv_role_4_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3063:1: (lv_role_4_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3063:1: (lv_role_4_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3064:3: lv_role_4_0= RULE_STRING
            {
            lv_role_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleThirdParty6319); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3080:2: ( (lv_representatives_5_0= ruleRepesentative ) )+
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
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3081:1: (lv_representatives_5_0= ruleRepesentative )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3081:1: (lv_representatives_5_0= ruleRepesentative )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3082:3: lv_representatives_5_0= ruleRepesentative
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getThirdPartyAccess().getRepresentativesRepesentativeParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleRepesentative_in_ruleThirdParty6345);
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
            	    if ( cnt76 >= 1 ) break loop76;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(76, input);
                        throw eee;
                }
                cnt76++;
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3098:3: ( (lv_responsibilities_6_0= ruleResponsibility ) )+
            int cnt77=0;
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==88||LA77_0==92) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3099:1: (lv_responsibilities_6_0= ruleResponsibility )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3099:1: (lv_responsibilities_6_0= ruleResponsibility )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3100:3: lv_responsibilities_6_0= ruleResponsibility
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getThirdPartyAccess().getResponsibilitiesResponsibilityParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleResponsibility_in_ruleThirdParty6367);
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

            otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleThirdParty6380); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3128:1: entryRuleRepesentative returns [EObject current=null] : iv_ruleRepesentative= ruleRepesentative EOF ;
    public final EObject entryRuleRepesentative() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRepesentative = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3129:2: (iv_ruleRepesentative= ruleRepesentative EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3130:2: iv_ruleRepesentative= ruleRepesentative EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRepesentativeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRepesentative_in_entryRuleRepesentative6416);
            iv_ruleRepesentative=ruleRepesentative();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRepesentative; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRepesentative6426); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3137:1: ruleRepesentative returns [EObject current=null] : (otherlv_0= 'representative' otherlv_1= '{' otherlv_2= 'name' ( (lv_fullname_3_0= RULE_STRING ) ) (otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) ) )? (otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3140:28: ( (otherlv_0= 'representative' otherlv_1= '{' otherlv_2= 'name' ( (lv_fullname_3_0= RULE_STRING ) ) (otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) ) )? (otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3141:1: (otherlv_0= 'representative' otherlv_1= '{' otherlv_2= 'name' ( (lv_fullname_3_0= RULE_STRING ) ) (otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) ) )? (otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3141:1: (otherlv_0= 'representative' otherlv_1= '{' otherlv_2= 'name' ( (lv_fullname_3_0= RULE_STRING ) ) (otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) ) )? (otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3141:3: otherlv_0= 'representative' otherlv_1= '{' otherlv_2= 'name' ( (lv_fullname_3_0= RULE_STRING ) ) (otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) ) )? (otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) ) )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,87,FollowSets000.FOLLOW_87_in_ruleRepesentative6463); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRepesentativeAccess().getRepresentativeKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleRepesentative6475); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRepesentativeAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleRepesentative6487); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getRepesentativeAccess().getNameKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3153:1: ( (lv_fullname_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3154:1: (lv_fullname_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3154:1: (lv_fullname_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3155:3: lv_fullname_3_0= RULE_STRING
            {
            lv_fullname_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleRepesentative6504); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3171:2: (otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==81) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3171:4: otherlv_4= 'phone' ( (lv_phone_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleRepesentative6522); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getRepesentativeAccess().getPhoneKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3175:1: ( (lv_phone_5_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3176:1: (lv_phone_5_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3176:1: (lv_phone_5_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3177:3: lv_phone_5_0= RULE_STRING
                    {
                    lv_phone_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleRepesentative6539); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3193:4: (otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==82) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3193:6: otherlv_6= 'email' ( (lv_email_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleRepesentative6559); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getRepesentativeAccess().getEmailKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3197:1: ( (lv_email_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3198:1: (lv_email_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3198:1: (lv_email_7_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3199:3: lv_email_7_0= RULE_STRING
                    {
                    lv_email_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleRepesentative6576); if (state.failed) return current;
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

            otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleRepesentative6595); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3227:1: entryRuleResponsibility returns [EObject current=null] : iv_ruleResponsibility= ruleResponsibility EOF ;
    public final EObject entryRuleResponsibility() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResponsibility = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3228:2: (iv_ruleResponsibility= ruleResponsibility EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3229:2: iv_ruleResponsibility= ruleResponsibility EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResponsibilityRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleResponsibility_in_entryRuleResponsibility6631);
            iv_ruleResponsibility=ruleResponsibility();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResponsibility; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleResponsibility6641); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3236:1: ruleResponsibility returns [EObject current=null] : (this_SimpleResponsibility_0= ruleSimpleResponsibility | this_ReportingResponsibility_1= ruleReportingResponsibility ) ;
    public final EObject ruleResponsibility() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleResponsibility_0 = null;

        EObject this_ReportingResponsibility_1 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3239:28: ( (this_SimpleResponsibility_0= ruleSimpleResponsibility | this_ReportingResponsibility_1= ruleReportingResponsibility ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3240:1: (this_SimpleResponsibility_0= ruleSimpleResponsibility | this_ReportingResponsibility_1= ruleReportingResponsibility )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3240:1: (this_SimpleResponsibility_0= ruleSimpleResponsibility | this_ReportingResponsibility_1= ruleReportingResponsibility )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==88) ) {
                alt80=1;
            }
            else if ( (LA80_0==92) ) {
                alt80=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3241:2: this_SimpleResponsibility_0= ruleSimpleResponsibility
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getResponsibilityAccess().getSimpleResponsibilityParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleResponsibility_in_ruleResponsibility6691);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3254:2: this_ReportingResponsibility_1= ruleReportingResponsibility
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getResponsibilityAccess().getReportingResponsibilityParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleReportingResponsibility_in_ruleResponsibility6721);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3273:1: entryRuleSimpleResponsibility returns [EObject current=null] : iv_ruleSimpleResponsibility= ruleSimpleResponsibility EOF ;
    public final EObject entryRuleSimpleResponsibility() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleResponsibility = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3274:2: (iv_ruleSimpleResponsibility= ruleSimpleResponsibility EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3275:2: iv_ruleSimpleResponsibility= ruleSimpleResponsibility EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleResponsibilityRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleResponsibility_in_entryRuleSimpleResponsibility6756);
            iv_ruleSimpleResponsibility=ruleSimpleResponsibility();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleResponsibility; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleResponsibility6766); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3282:1: ruleSimpleResponsibility returns [EObject current=null] : (otherlv_0= 'responsibility' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_description_3_0= RULE_STRING ) ) ( (lv_escalations_4_0= ruleEscalation ) )+ ( (lv_penalty_5_0= RULE_STRING ) ) otherlv_6= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3285:28: ( (otherlv_0= 'responsibility' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_description_3_0= RULE_STRING ) ) ( (lv_escalations_4_0= ruleEscalation ) )+ ( (lv_penalty_5_0= RULE_STRING ) ) otherlv_6= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3286:1: (otherlv_0= 'responsibility' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_description_3_0= RULE_STRING ) ) ( (lv_escalations_4_0= ruleEscalation ) )+ ( (lv_penalty_5_0= RULE_STRING ) ) otherlv_6= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3286:1: (otherlv_0= 'responsibility' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_description_3_0= RULE_STRING ) ) ( (lv_escalations_4_0= ruleEscalation ) )+ ( (lv_penalty_5_0= RULE_STRING ) ) otherlv_6= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3286:3: otherlv_0= 'responsibility' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_description_3_0= RULE_STRING ) ) ( (lv_escalations_4_0= ruleEscalation ) )+ ( (lv_penalty_5_0= RULE_STRING ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,88,FollowSets000.FOLLOW_88_in_ruleSimpleResponsibility6803); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSimpleResponsibilityAccess().getResponsibilityKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3290:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3291:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3291:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3292:3: lv_name_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSimpleResponsibilityAccess().getNameQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSimpleResponsibility6824);
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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSimpleResponsibility6836); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getSimpleResponsibilityAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3312:1: ( (lv_description_3_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3313:1: (lv_description_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3313:1: (lv_description_3_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3314:3: lv_description_3_0= RULE_STRING
            {
            lv_description_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSimpleResponsibility6853); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3330:2: ( (lv_escalations_4_0= ruleEscalation ) )+
            int cnt81=0;
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==75) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3331:1: (lv_escalations_4_0= ruleEscalation )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3331:1: (lv_escalations_4_0= ruleEscalation )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3332:3: lv_escalations_4_0= ruleEscalation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSimpleResponsibilityAccess().getEscalationsEscalationParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleSimpleResponsibility6879);
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
            	    if ( cnt81 >= 1 ) break loop81;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(81, input);
                        throw eee;
                }
                cnt81++;
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3348:3: ( (lv_penalty_5_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3349:1: (lv_penalty_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3349:1: (lv_penalty_5_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3350:3: lv_penalty_5_0= RULE_STRING
            {
            lv_penalty_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSimpleResponsibility6897); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSimpleResponsibility6914); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3378:1: entryRuleReport returns [EObject current=null] : iv_ruleReport= ruleReport EOF ;
    public final EObject entryRuleReport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReport = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3379:2: (iv_ruleReport= ruleReport EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3380:2: iv_ruleReport= ruleReport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReportRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReport_in_entryRuleReport6950);
            iv_ruleReport=ruleReport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReport; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReport6960); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3387:1: ruleReport returns [EObject current=null] : (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' ( (lv_reportTo_4_0= RULE_STRING ) ) otherlv_5= 'contents' ( (lv_content_6_0= RULE_STRING ) ) otherlv_7= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3390:28: ( (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' ( (lv_reportTo_4_0= RULE_STRING ) ) otherlv_5= 'contents' ( (lv_content_6_0= RULE_STRING ) ) otherlv_7= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3391:1: (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' ( (lv_reportTo_4_0= RULE_STRING ) ) otherlv_5= 'contents' ( (lv_content_6_0= RULE_STRING ) ) otherlv_7= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3391:1: (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' ( (lv_reportTo_4_0= RULE_STRING ) ) otherlv_5= 'contents' ( (lv_content_6_0= RULE_STRING ) ) otherlv_7= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3391:3: otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' ( (lv_reportTo_4_0= RULE_STRING ) ) otherlv_5= 'contents' ( (lv_content_6_0= RULE_STRING ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,89,FollowSets000.FOLLOW_89_in_ruleReport6997); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getReportAccess().getReportKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3395:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3396:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3396:1: (lv_name_1_0= RULE_ID )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3397:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReport7014); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleReport7031); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getReportAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,90,FollowSets000.FOLLOW_90_in_ruleReport7043); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getReportAccess().getReportToKeyword_3());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3421:1: ( (lv_reportTo_4_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3422:1: (lv_reportTo_4_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3422:1: (lv_reportTo_4_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3423:3: lv_reportTo_4_0= RULE_STRING
            {
            lv_reportTo_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReport7060); if (state.failed) return current;
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

            otherlv_5=(Token)match(input,91,FollowSets000.FOLLOW_91_in_ruleReport7077); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getReportAccess().getContentsKeyword_5());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3443:1: ( (lv_content_6_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3444:1: (lv_content_6_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3444:1: (lv_content_6_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3445:3: lv_content_6_0= RULE_STRING
            {
            lv_content_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReport7094); if (state.failed) return current;
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

            otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleReport7111); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3473:1: entryRuleReportingResponsibility returns [EObject current=null] : iv_ruleReportingResponsibility= ruleReportingResponsibility EOF ;
    public final EObject entryRuleReportingResponsibility() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReportingResponsibility = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3474:2: (iv_ruleReportingResponsibility= ruleReportingResponsibility EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3475:2: iv_ruleReportingResponsibility= ruleReportingResponsibility EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReportingResponsibilityRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReportingResponsibility_in_entryRuleReportingResponsibility7147);
            iv_ruleReportingResponsibility=ruleReportingResponsibility();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReportingResponsibility; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReportingResponsibility7157); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3482:1: ruleReportingResponsibility returns [EObject current=null] : (otherlv_0= 'reporting-responsibility' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' otherlv_4= 'contents' ( (lv_content_5_0= RULE_STRING ) ) ( (lv_escalations_6_0= ruleEscalation ) )+ ( (lv_penalty_7_0= RULE_STRING ) ) otherlv_8= '}' ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3485:28: ( (otherlv_0= 'reporting-responsibility' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' otherlv_4= 'contents' ( (lv_content_5_0= RULE_STRING ) ) ( (lv_escalations_6_0= ruleEscalation ) )+ ( (lv_penalty_7_0= RULE_STRING ) ) otherlv_8= '}' ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3486:1: (otherlv_0= 'reporting-responsibility' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' otherlv_4= 'contents' ( (lv_content_5_0= RULE_STRING ) ) ( (lv_escalations_6_0= ruleEscalation ) )+ ( (lv_penalty_7_0= RULE_STRING ) ) otherlv_8= '}' )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3486:1: (otherlv_0= 'reporting-responsibility' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' otherlv_4= 'contents' ( (lv_content_5_0= RULE_STRING ) ) ( (lv_escalations_6_0= ruleEscalation ) )+ ( (lv_penalty_7_0= RULE_STRING ) ) otherlv_8= '}' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3486:3: otherlv_0= 'reporting-responsibility' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'report-to' otherlv_4= 'contents' ( (lv_content_5_0= RULE_STRING ) ) ( (lv_escalations_6_0= ruleEscalation ) )+ ( (lv_penalty_7_0= RULE_STRING ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,92,FollowSets000.FOLLOW_92_in_ruleReportingResponsibility7194); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getReportingResponsibilityAccess().getReportingResponsibilityKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3490:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3491:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3491:1: (lv_name_1_0= RULE_ID )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3492:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReportingResponsibility7211); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleReportingResponsibility7228); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getReportingResponsibilityAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,90,FollowSets000.FOLLOW_90_in_ruleReportingResponsibility7240); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getReportingResponsibilityAccess().getReportToKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,91,FollowSets000.FOLLOW_91_in_ruleReportingResponsibility7252); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getReportingResponsibilityAccess().getContentsKeyword_4());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3520:1: ( (lv_content_5_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3521:1: (lv_content_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3521:1: (lv_content_5_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3522:3: lv_content_5_0= RULE_STRING
            {
            lv_content_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReportingResponsibility7269); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3538:2: ( (lv_escalations_6_0= ruleEscalation ) )+
            int cnt82=0;
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==75) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3539:1: (lv_escalations_6_0= ruleEscalation )
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3539:1: (lv_escalations_6_0= ruleEscalation )
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3540:3: lv_escalations_6_0= ruleEscalation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getReportingResponsibilityAccess().getEscalationsEscalationParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleEscalation_in_ruleReportingResponsibility7295);
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
            	    if ( cnt82 >= 1 ) break loop82;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(82, input);
                        throw eee;
                }
                cnt82++;
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3556:3: ( (lv_penalty_7_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3557:1: (lv_penalty_7_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3557:1: (lv_penalty_7_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3558:3: lv_penalty_7_0= RULE_STRING
            {
            lv_penalty_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReportingResponsibility7313); if (state.failed) return current;
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

            otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleReportingResponsibility7330); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3588:1: entryRuleVersionId returns [String current=null] : iv_ruleVersionId= ruleVersionId EOF ;
    public final String entryRuleVersionId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionId = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3589:2: (iv_ruleVersionId= ruleVersionId EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3590:2: iv_ruleVersionId= ruleVersionId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionIdRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_entryRuleVersionId7369);
            iv_ruleVersionId=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionId.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionId7380); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3597:1: ruleVersionId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleVersionId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_ID_5=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3600:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3601:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3601:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3601:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )*
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId7420); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3608:1: (kw= '.' this_INT_2= RULE_INT )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==57) ) {
                    int LA83_1 = input.LA(2);

                    if ( (LA83_1==RULE_INT) ) {
                        alt83=1;
                    }


                }


                switch (alt83) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3609:2: kw= '.' this_INT_2= RULE_INT
            	    {
            	    kw=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleVersionId7439); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId7454); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_INT_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_INT_2, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop83;
                }
            } while (true);

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3621:3: ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==57||LA85_0==93) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3621:4: (kw= '.' | kw= '-' ) this_ID_5= RULE_ID
            	    {
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3621:4: (kw= '.' | kw= '-' )
            	    int alt84=2;
            	    int LA84_0 = input.LA(1);

            	    if ( (LA84_0==57) ) {
            	        alt84=1;
            	    }
            	    else if ( (LA84_0==93) ) {
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
            	            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3622:2: kw= '.'
            	            {
            	            kw=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleVersionId7476); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_2_0_0()); 
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3629:2: kw= '-'
            	            {
            	            kw=(Token)match(input,93,FollowSets000.FOLLOW_93_in_ruleVersionId7495); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getVersionIdAccess().getHyphenMinusKeyword_2_0_1()); 
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    this_ID_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVersionId7511); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_5);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_5, grammarAccess.getVersionIdAccess().getIDTerminalRuleCall_2_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop85;
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


    // $ANTLR start "entryRuleVersionRef"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3653:1: entryRuleVersionRef returns [EObject current=null] : iv_ruleVersionRef= ruleVersionRef EOF ;
    public final EObject entryRuleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3654:2: (iv_ruleVersionRef= ruleVersionRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3655:2: iv_ruleVersionRef= ruleVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_entryRuleVersionRef7562);
            iv_ruleVersionRef=ruleVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionRef7572); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3662:1: ruleVersionRef returns [EObject current=null] : (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) ;
    public final EObject ruleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject this_MinVersionRef_0 = null;

        EObject this_MaxVersionRef_1 = null;

        EObject this_LowerBoundRangeVersionRef_2 = null;

        EObject this_MajorVersionRef_3 = null;

        EObject this_FixedVersionRef_4 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3665:28: ( (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3666:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3666:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            int alt86=5;
            switch ( input.LA(1) ) {
            case 94:
                {
                int LA86_1 = input.LA(2);

                if ( (LA86_1==RULE_INT) ) {
                    alt86=1;
                }
                else if ( (LA86_1==96) ) {
                    alt86=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 1, input);

                    throw nvae;
                }
                }
                break;
            case 95:
                {
                alt86=2;
                }
                break;
            case 98:
                {
                alt86=4;
                }
                break;
            case 99:
                {
                alt86=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }

            switch (alt86) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3667:2: this_MinVersionRef_0= ruleMinVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMinVersionRefParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_ruleVersionRef7622);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3680:2: this_MaxVersionRef_1= ruleMaxVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMaxVersionRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_ruleVersionRef7652);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3693:2: this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getLowerBoundRangeVersionRefParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef7682);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3706:2: this_MajorVersionRef_3= ruleMajorVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMajorVersionRefParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_ruleVersionRef7712);
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3719:2: this_FixedVersionRef_4= ruleFixedVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getFixedVersionRefParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_ruleVersionRef7742);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3738:1: entryRuleMinVersionRef returns [EObject current=null] : iv_ruleMinVersionRef= ruleMinVersionRef EOF ;
    public final EObject entryRuleMinVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinVersionRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3739:2: (iv_ruleMinVersionRef= ruleMinVersionRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3740:2: iv_ruleMinVersionRef= ruleMinVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMinVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef7777);
            iv_ruleMinVersionRef=ruleMinVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMinVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMinVersionRef7787); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3747:1: ruleMinVersionRef returns [EObject current=null] : (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMinVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_minVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3750:28: ( (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3751:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3751:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3751:3: otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,94,FollowSets000.FOLLOW_94_in_ruleMinVersionRef7824); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMinVersionRefAccess().getMinVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3755:1: ( (lv_minVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3756:1: (lv_minVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3756:1: (lv_minVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3757:3: lv_minVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMinVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMinVersionRef7845);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3781:1: entryRuleMaxVersionRef returns [EObject current=null] : iv_ruleMaxVersionRef= ruleMaxVersionRef EOF ;
    public final EObject entryRuleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxVersionRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3782:2: (iv_ruleMaxVersionRef= ruleMaxVersionRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3783:2: iv_ruleMaxVersionRef= ruleMaxVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMaxVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef7881);
            iv_ruleMaxVersionRef=ruleMaxVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMaxVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxVersionRef7891); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3790:1: ruleMaxVersionRef returns [EObject current=null] : (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_maxVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3793:28: ( (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3794:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3794:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3794:3: otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,95,FollowSets000.FOLLOW_95_in_ruleMaxVersionRef7928); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMaxVersionRefAccess().getMaxVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3798:1: ( (lv_maxVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3799:1: (lv_maxVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3799:1: (lv_maxVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3800:3: lv_maxVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMaxVersionRefAccess().getMaxVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMaxVersionRef7949);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3824:1: entryRuleLowerBoundRangeVersionRef returns [EObject current=null] : iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF ;
    public final EObject entryRuleLowerBoundRangeVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerBoundRangeVersionRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3825:2: (iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3826:2: iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef7985);
            iv_ruleLowerBoundRangeVersionRef=ruleLowerBoundRangeVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLowerBoundRangeVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef7995); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3833:1: ruleLowerBoundRangeVersionRef returns [EObject current=null] : ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3836:28: ( ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3837:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3837:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3837:2: (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3837:2: (otherlv_0= 'minVersion' otherlv_1= '>=' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3837:4: otherlv_0= 'minVersion' otherlv_1= '>='
            {
            otherlv_0=(Token)match(input,94,FollowSets000.FOLLOW_94_in_ruleLowerBoundRangeVersionRef8033); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionKeyword_0_0());
                  
            }
            otherlv_1=(Token)match(input,96,FollowSets000.FOLLOW_96_in_ruleLowerBoundRangeVersionRef8045); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLowerBoundRangeVersionRefAccess().getGreaterThanSignEqualsSignKeyword_0_1());
                  
            }

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3845:2: ( (lv_minVersion_2_0= ruleVersionId ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3846:1: (lv_minVersion_2_0= ruleVersionId )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3846:1: (lv_minVersion_2_0= ruleVersionId )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3847:3: lv_minVersion_2_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef8067);
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

            otherlv_3=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleLowerBoundRangeVersionRef8079); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLowerBoundRangeVersionRefAccess().getCommaKeyword_2());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3867:1: (otherlv_4= 'maxVersion' otherlv_5= '<' )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3867:3: otherlv_4= 'maxVersion' otherlv_5= '<'
            {
            otherlv_4=(Token)match(input,95,FollowSets000.FOLLOW_95_in_ruleLowerBoundRangeVersionRef8092); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionKeyword_3_0());
                  
            }
            otherlv_5=(Token)match(input,97,FollowSets000.FOLLOW_97_in_ruleLowerBoundRangeVersionRef8104); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLowerBoundRangeVersionRefAccess().getLessThanSignKeyword_3_1());
                  
            }

            }

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3875:2: ( (lv_maxVersion_6_0= ruleVersionId ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3876:1: (lv_maxVersion_6_0= ruleVersionId )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3876:1: (lv_maxVersion_6_0= ruleVersionId )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3877:3: lv_maxVersion_6_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionVersionIdParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef8126);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3901:1: entryRuleMajorVersionRef returns [EObject current=null] : iv_ruleMajorVersionRef= ruleMajorVersionRef EOF ;
    public final EObject entryRuleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMajorVersionRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3902:2: (iv_ruleMajorVersionRef= ruleMajorVersionRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3903:2: iv_ruleMajorVersionRef= ruleMajorVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMajorVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef8162);
            iv_ruleMajorVersionRef=ruleMajorVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMajorVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMajorVersionRef8172); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3910:1: ruleMajorVersionRef returns [EObject current=null] : (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) ;
    public final EObject ruleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_majorVersion_1_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3913:28: ( (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3914:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3914:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3914:3: otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,98,FollowSets000.FOLLOW_98_in_ruleMajorVersionRef8209); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMajorVersionRefAccess().getMajorVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3918:1: ( (lv_majorVersion_1_0= RULE_INT ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3919:1: (lv_majorVersion_1_0= RULE_INT )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3919:1: (lv_majorVersion_1_0= RULE_INT )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3920:3: lv_majorVersion_1_0= RULE_INT
            {
            lv_majorVersion_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMajorVersionRef8226); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3944:1: entryRuleFixedVersionRef returns [EObject current=null] : iv_ruleFixedVersionRef= ruleFixedVersionRef EOF ;
    public final EObject entryRuleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedVersionRef = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3945:2: (iv_ruleFixedVersionRef= ruleFixedVersionRef EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3946:2: iv_ruleFixedVersionRef= ruleFixedVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFixedVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef8267);
            iv_ruleFixedVersionRef=ruleFixedVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFixedVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFixedVersionRef8277); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3953:1: ruleFixedVersionRef returns [EObject current=null] : (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_fixedVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3956:28: ( (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3957:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3957:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3957:3: otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,99,FollowSets000.FOLLOW_99_in_ruleFixedVersionRef8314); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFixedVersionRefAccess().getFixedVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3961:1: ( (lv_fixedVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3962:1: (lv_fixedVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3962:1: (lv_fixedVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3963:3: lv_fixedVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFixedVersionRefAccess().getFixedVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleFixedVersionRef8335);
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3987:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3988:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3989:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard8372);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard8383); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3996:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:3999:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4000:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4000:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4001:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard8430);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4011:1: (kw= '.*' )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==100) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4012:2: kw= '.*'
                    {
                    kw=(Token)match(input,100,FollowSets000.FOLLOW_100_in_ruleQualifiedNameWithWildCard8449); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4025:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4026:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4027:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8492);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName8503); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4034:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4037:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4038:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4038:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4038:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName8543); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4045:1: (kw= '.' this_ID_2= RULE_ID )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==57) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4046:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleQualifiedName8562); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName8577); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop88;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4072:1: entryRuleInfoItem returns [EObject current=null] : iv_ruleInfoItem= ruleInfoItem EOF ;
    public final EObject entryRuleInfoItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfoItem = null;


        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4073:2: (iv_ruleInfoItem= ruleInfoItem EOF )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4074:2: iv_ruleInfoItem= ruleInfoItem EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfoItemRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfoItem_in_entryRuleInfoItem8630);
            iv_ruleInfoItem=ruleInfoItem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfoItem; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfoItem8640); if (state.failed) return current;

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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4081:1: ruleInfoItem returns [EObject current=null] : (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleInfoItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_documentLocation_1_0=null;
        Token otherlv_2=null;
        Token lv_reference_3_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4084:28: ( (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4085:1: (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4085:1: (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4085:3: otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,101,FollowSets000.FOLLOW_101_in_ruleInfoItem8677); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInfoItemAccess().getLocationKeyword_0());
                  
            }
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4089:1: ( (lv_documentLocation_1_0= RULE_STRING ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4090:1: (lv_documentLocation_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4090:1: (lv_documentLocation_1_0= RULE_STRING )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4091:3: lv_documentLocation_1_0= RULE_STRING
            {
            lv_documentLocation_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleInfoItem8694); if (state.failed) return current;
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

            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4107:2: (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==102) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4107:4: otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,102,FollowSets000.FOLLOW_102_in_ruleInfoItem8712); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getInfoItemAccess().getReferenceKeyword_2_0());
                          
                    }
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4111:1: ( (lv_reference_3_0= RULE_STRING ) )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4112:1: (lv_reference_3_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4112:1: (lv_reference_3_0= RULE_STRING )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4113:3: lv_reference_3_0= RULE_STRING
                    {
                    lv_reference_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleInfoItem8729); if (state.failed) return current;
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


    // $ANTLR start "ruleHashAlgKind"
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4137:1: ruleHashAlgKind returns [Enumerator current=null] : ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'RSA' ) | (enumLiteral_4= 'PlainText' ) ) ;
    public final Enumerator ruleHashAlgKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4139:28: ( ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'RSA' ) | (enumLiteral_4= 'PlainText' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4140:1: ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'RSA' ) | (enumLiteral_4= 'PlainText' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4140:1: ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'RSA' ) | (enumLiteral_4= 'PlainText' ) )
            int alt90=5;
            switch ( input.LA(1) ) {
            case 103:
                {
                alt90=1;
                }
                break;
            case 104:
                {
                alt90=2;
                }
                break;
            case 105:
                {
                alt90=3;
                }
                break;
            case 106:
                {
                alt90=4;
                }
                break;
            case 107:
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4140:2: (enumLiteral_0= 'MD5' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4140:2: (enumLiteral_0= 'MD5' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4140:4: enumLiteral_0= 'MD5'
                    {
                    enumLiteral_0=(Token)match(input,103,FollowSets000.FOLLOW_103_in_ruleHashAlgKind8786); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getMD5EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getHashAlgKindAccess().getMD5EnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4146:6: (enumLiteral_1= 'SHA1' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4146:6: (enumLiteral_1= 'SHA1' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4146:8: enumLiteral_1= 'SHA1'
                    {
                    enumLiteral_1=(Token)match(input,104,FollowSets000.FOLLOW_104_in_ruleHashAlgKind8803); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getSHA1EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getHashAlgKindAccess().getSHA1EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4152:6: (enumLiteral_2= 'SHA256' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4152:6: (enumLiteral_2= 'SHA256' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4152:8: enumLiteral_2= 'SHA256'
                    {
                    enumLiteral_2=(Token)match(input,105,FollowSets000.FOLLOW_105_in_ruleHashAlgKind8820); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getSHA256EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getHashAlgKindAccess().getSHA256EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4158:6: (enumLiteral_3= 'RSA' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4158:6: (enumLiteral_3= 'RSA' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4158:8: enumLiteral_3= 'RSA'
                    {
                    enumLiteral_3=(Token)match(input,106,FollowSets000.FOLLOW_106_in_ruleHashAlgKind8837); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getRSAEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getHashAlgKindAccess().getRSAEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4164:6: (enumLiteral_4= 'PlainText' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4164:6: (enumLiteral_4= 'PlainText' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4164:8: enumLiteral_4= 'PlainText'
                    {
                    enumLiteral_4=(Token)match(input,107,FollowSets000.FOLLOW_107_in_ruleHashAlgKind8854); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4174:1: ruleMessagePartRefKind returns [Enumerator current=null] : ( (enumLiteral_0= 'header' ) | (enumLiteral_1= 'body' ) | (enumLiteral_2= 'attachments' ) | (enumLiteral_3= 'all' ) | (enumLiteral_4= 'expression' ) ) ;
    public final Enumerator ruleMessagePartRefKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4176:28: ( ( (enumLiteral_0= 'header' ) | (enumLiteral_1= 'body' ) | (enumLiteral_2= 'attachments' ) | (enumLiteral_3= 'all' ) | (enumLiteral_4= 'expression' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4177:1: ( (enumLiteral_0= 'header' ) | (enumLiteral_1= 'body' ) | (enumLiteral_2= 'attachments' ) | (enumLiteral_3= 'all' ) | (enumLiteral_4= 'expression' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4177:1: ( (enumLiteral_0= 'header' ) | (enumLiteral_1= 'body' ) | (enumLiteral_2= 'attachments' ) | (enumLiteral_3= 'all' ) | (enumLiteral_4= 'expression' ) )
            int alt91=5;
            switch ( input.LA(1) ) {
            case 108:
                {
                alt91=1;
                }
                break;
            case 109:
                {
                alt91=2;
                }
                break;
            case 110:
                {
                alt91=3;
                }
                break;
            case 111:
                {
                alt91=4;
                }
                break;
            case 71:
                {
                alt91=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }

            switch (alt91) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4177:2: (enumLiteral_0= 'header' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4177:2: (enumLiteral_0= 'header' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4177:4: enumLiteral_0= 'header'
                    {
                    enumLiteral_0=(Token)match(input,108,FollowSets000.FOLLOW_108_in_ruleMessagePartRefKind8899); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getHeaderEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getMessagePartRefKindAccess().getHeaderEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4183:6: (enumLiteral_1= 'body' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4183:6: (enumLiteral_1= 'body' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4183:8: enumLiteral_1= 'body'
                    {
                    enumLiteral_1=(Token)match(input,109,FollowSets000.FOLLOW_109_in_ruleMessagePartRefKind8916); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getBodyEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getMessagePartRefKindAccess().getBodyEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4189:6: (enumLiteral_2= 'attachments' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4189:6: (enumLiteral_2= 'attachments' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4189:8: enumLiteral_2= 'attachments'
                    {
                    enumLiteral_2=(Token)match(input,110,FollowSets000.FOLLOW_110_in_ruleMessagePartRefKind8933); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getAttachmentsEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getMessagePartRefKindAccess().getAttachmentsEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4195:6: (enumLiteral_3= 'all' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4195:6: (enumLiteral_3= 'all' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4195:8: enumLiteral_3= 'all'
                    {
                    enumLiteral_3=(Token)match(input,111,FollowSets000.FOLLOW_111_in_ruleMessagePartRefKind8950); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getAllEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getMessagePartRefKindAccess().getAllEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4201:6: (enumLiteral_4= 'expression' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4201:6: (enumLiteral_4= 'expression' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4201:8: enumLiteral_4= 'expression'
                    {
                    enumLiteral_4=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleMessagePartRefKind8967); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4211:1: ruleSigningAlgothm returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'MD5' ) | (enumLiteral_4= 'RSA_1_5' ) | (enumLiteral_5= 'AES128' ) | (enumLiteral_6= 'AES192' ) | (enumLiteral_7= 'AES256' ) ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4213:28: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'MD5' ) | (enumLiteral_4= 'RSA_1_5' ) | (enumLiteral_5= 'AES128' ) | (enumLiteral_6= 'AES192' ) | (enumLiteral_7= 'AES256' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4214:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'MD5' ) | (enumLiteral_4= 'RSA_1_5' ) | (enumLiteral_5= 'AES128' ) | (enumLiteral_6= 'AES192' ) | (enumLiteral_7= 'AES256' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4214:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'MD5' ) | (enumLiteral_4= 'RSA_1_5' ) | (enumLiteral_5= 'AES128' ) | (enumLiteral_6= 'AES192' ) | (enumLiteral_7= 'AES256' ) )
            int alt92=8;
            switch ( input.LA(1) ) {
            case 112:
                {
                alt92=1;
                }
                break;
            case 104:
                {
                alt92=2;
                }
                break;
            case 105:
                {
                alt92=3;
                }
                break;
            case 103:
                {
                alt92=4;
                }
                break;
            case 113:
                {
                alt92=5;
                }
                break;
            case 114:
                {
                alt92=6;
                }
                break;
            case 115:
                {
                alt92=7;
                }
                break;
            case 116:
                {
                alt92=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4214:2: (enumLiteral_0= 'NONE' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4214:2: (enumLiteral_0= 'NONE' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4214:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,112,FollowSets000.FOLLOW_112_in_ruleSigningAlgothm9012); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getSigningAlgothmAccess().getNONEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4220:6: (enumLiteral_1= 'SHA1' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4220:6: (enumLiteral_1= 'SHA1' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4220:8: enumLiteral_1= 'SHA1'
                    {
                    enumLiteral_1=(Token)match(input,104,FollowSets000.FOLLOW_104_in_ruleSigningAlgothm9029); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getSHA1EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getSigningAlgothmAccess().getSHA1EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4226:6: (enumLiteral_2= 'SHA256' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4226:6: (enumLiteral_2= 'SHA256' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4226:8: enumLiteral_2= 'SHA256'
                    {
                    enumLiteral_2=(Token)match(input,105,FollowSets000.FOLLOW_105_in_ruleSigningAlgothm9046); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getSHA256EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getSigningAlgothmAccess().getSHA256EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4232:6: (enumLiteral_3= 'MD5' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4232:6: (enumLiteral_3= 'MD5' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4232:8: enumLiteral_3= 'MD5'
                    {
                    enumLiteral_3=(Token)match(input,103,FollowSets000.FOLLOW_103_in_ruleSigningAlgothm9063); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getMD5EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getSigningAlgothmAccess().getMD5EnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4238:6: (enumLiteral_4= 'RSA_1_5' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4238:6: (enumLiteral_4= 'RSA_1_5' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4238:8: enumLiteral_4= 'RSA_1_5'
                    {
                    enumLiteral_4=(Token)match(input,113,FollowSets000.FOLLOW_113_in_ruleSigningAlgothm9080); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getRSA_1_5EnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getSigningAlgothmAccess().getRSA_1_5EnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4244:6: (enumLiteral_5= 'AES128' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4244:6: (enumLiteral_5= 'AES128' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4244:8: enumLiteral_5= 'AES128'
                    {
                    enumLiteral_5=(Token)match(input,114,FollowSets000.FOLLOW_114_in_ruleSigningAlgothm9097); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getAES128EnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getSigningAlgothmAccess().getAES128EnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4250:6: (enumLiteral_6= 'AES192' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4250:6: (enumLiteral_6= 'AES192' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4250:8: enumLiteral_6= 'AES192'
                    {
                    enumLiteral_6=(Token)match(input,115,FollowSets000.FOLLOW_115_in_ruleSigningAlgothm9114); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getAES192EnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getSigningAlgothmAccess().getAES192EnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4256:6: (enumLiteral_7= 'AES256' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4256:6: (enumLiteral_7= 'AES256' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4256:8: enumLiteral_7= 'AES256'
                    {
                    enumLiteral_7=(Token)match(input,116,FollowSets000.FOLLOW_116_in_ruleSigningAlgothm9131); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4266:1: ruleCipherAlgorithmKind returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'Basic128' ) | (enumLiteral_2= 'Basic192' ) | (enumLiteral_3= 'Basic256' ) | (enumLiteral_4= 'DES' ) | (enumLiteral_5= '3DES' ) | (enumLiteral_6= 'AES128' ) | (enumLiteral_7= 'AES256' ) ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4268:28: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'Basic128' ) | (enumLiteral_2= 'Basic192' ) | (enumLiteral_3= 'Basic256' ) | (enumLiteral_4= 'DES' ) | (enumLiteral_5= '3DES' ) | (enumLiteral_6= 'AES128' ) | (enumLiteral_7= 'AES256' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4269:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'Basic128' ) | (enumLiteral_2= 'Basic192' ) | (enumLiteral_3= 'Basic256' ) | (enumLiteral_4= 'DES' ) | (enumLiteral_5= '3DES' ) | (enumLiteral_6= 'AES128' ) | (enumLiteral_7= 'AES256' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4269:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'Basic128' ) | (enumLiteral_2= 'Basic192' ) | (enumLiteral_3= 'Basic256' ) | (enumLiteral_4= 'DES' ) | (enumLiteral_5= '3DES' ) | (enumLiteral_6= 'AES128' ) | (enumLiteral_7= 'AES256' ) )
            int alt93=8;
            switch ( input.LA(1) ) {
            case 112:
                {
                alt93=1;
                }
                break;
            case 117:
                {
                alt93=2;
                }
                break;
            case 118:
                {
                alt93=3;
                }
                break;
            case 119:
                {
                alt93=4;
                }
                break;
            case 120:
                {
                alt93=5;
                }
                break;
            case 121:
                {
                alt93=6;
                }
                break;
            case 114:
                {
                alt93=7;
                }
                break;
            case 116:
                {
                alt93=8;
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4269:2: (enumLiteral_0= 'NONE' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4269:2: (enumLiteral_0= 'NONE' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4269:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,112,FollowSets000.FOLLOW_112_in_ruleCipherAlgorithmKind9176); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getCipherAlgorithmKindAccess().getNONEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4275:6: (enumLiteral_1= 'Basic128' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4275:6: (enumLiteral_1= 'Basic128' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4275:8: enumLiteral_1= 'Basic128'
                    {
                    enumLiteral_1=(Token)match(input,117,FollowSets000.FOLLOW_117_in_ruleCipherAlgorithmKind9193); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getBasic128EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getCipherAlgorithmKindAccess().getBasic128EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4281:6: (enumLiteral_2= 'Basic192' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4281:6: (enumLiteral_2= 'Basic192' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4281:8: enumLiteral_2= 'Basic192'
                    {
                    enumLiteral_2=(Token)match(input,118,FollowSets000.FOLLOW_118_in_ruleCipherAlgorithmKind9210); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getBasic192EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getCipherAlgorithmKindAccess().getBasic192EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4287:6: (enumLiteral_3= 'Basic256' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4287:6: (enumLiteral_3= 'Basic256' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4287:8: enumLiteral_3= 'Basic256'
                    {
                    enumLiteral_3=(Token)match(input,119,FollowSets000.FOLLOW_119_in_ruleCipherAlgorithmKind9227); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getBasic256EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getCipherAlgorithmKindAccess().getBasic256EnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4293:6: (enumLiteral_4= 'DES' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4293:6: (enumLiteral_4= 'DES' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4293:8: enumLiteral_4= 'DES'
                    {
                    enumLiteral_4=(Token)match(input,120,FollowSets000.FOLLOW_120_in_ruleCipherAlgorithmKind9244); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getDESEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getCipherAlgorithmKindAccess().getDESEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4299:6: (enumLiteral_5= '3DES' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4299:6: (enumLiteral_5= '3DES' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4299:8: enumLiteral_5= '3DES'
                    {
                    enumLiteral_5=(Token)match(input,121,FollowSets000.FOLLOW_121_in_ruleCipherAlgorithmKind9261); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getTRIPLE_DESEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getCipherAlgorithmKindAccess().getTRIPLE_DESEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4305:6: (enumLiteral_6= 'AES128' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4305:6: (enumLiteral_6= 'AES128' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4305:8: enumLiteral_6= 'AES128'
                    {
                    enumLiteral_6=(Token)match(input,114,FollowSets000.FOLLOW_114_in_ruleCipherAlgorithmKind9278); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getAES128EnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getCipherAlgorithmKindAccess().getAES128EnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4311:6: (enumLiteral_7= 'AES256' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4311:6: (enumLiteral_7= 'AES256' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4311:8: enumLiteral_7= 'AES256'
                    {
                    enumLiteral_7=(Token)match(input,116,FollowSets000.FOLLOW_116_in_ruleCipherAlgorithmKind9295); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4321:1: ruleAuthTokenKind returns [Enumerator current=null] : ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'SPNEGO' ) | (enumLiteral_5= 'RELToken' ) | (enumLiteral_6= 'X509Certificate' ) | (enumLiteral_7= 'OAuth' ) | (enumLiteral_8= 'OAuth2' ) ) ;
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
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4323:28: ( ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'SPNEGO' ) | (enumLiteral_5= 'RELToken' ) | (enumLiteral_6= 'X509Certificate' ) | (enumLiteral_7= 'OAuth' ) | (enumLiteral_8= 'OAuth2' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4324:1: ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'SPNEGO' ) | (enumLiteral_5= 'RELToken' ) | (enumLiteral_6= 'X509Certificate' ) | (enumLiteral_7= 'OAuth' ) | (enumLiteral_8= 'OAuth2' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4324:1: ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'SPNEGO' ) | (enumLiteral_5= 'RELToken' ) | (enumLiteral_6= 'X509Certificate' ) | (enumLiteral_7= 'OAuth' ) | (enumLiteral_8= 'OAuth2' ) )
            int alt94=9;
            switch ( input.LA(1) ) {
            case 122:
                {
                alt94=1;
                }
                break;
            case 123:
                {
                alt94=2;
                }
                break;
            case 124:
                {
                alt94=3;
                }
                break;
            case 125:
                {
                alt94=4;
                }
                break;
            case 126:
                {
                alt94=5;
                }
                break;
            case 127:
                {
                alt94=6;
                }
                break;
            case 128:
                {
                alt94=7;
                }
                break;
            case 129:
                {
                alt94=8;
                }
                break;
            case 130:
                {
                alt94=9;
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4324:2: (enumLiteral_0= 'UsernamePassword' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4324:2: (enumLiteral_0= 'UsernamePassword' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4324:4: enumLiteral_0= 'UsernamePassword'
                    {
                    enumLiteral_0=(Token)match(input,122,FollowSets000.FOLLOW_122_in_ruleAuthTokenKind9340); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getUsernamePasswordEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAuthTokenKindAccess().getUsernamePasswordEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4330:6: (enumLiteral_1= 'SAML' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4330:6: (enumLiteral_1= 'SAML' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4330:8: enumLiteral_1= 'SAML'
                    {
                    enumLiteral_1=(Token)match(input,123,FollowSets000.FOLLOW_123_in_ruleAuthTokenKind9357); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSAMLEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getAuthTokenKindAccess().getSAMLEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4336:6: (enumLiteral_2= 'SAML2' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4336:6: (enumLiteral_2= 'SAML2' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4336:8: enumLiteral_2= 'SAML2'
                    {
                    enumLiteral_2=(Token)match(input,124,FollowSets000.FOLLOW_124_in_ruleAuthTokenKind9374); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSAML2EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getAuthTokenKindAccess().getSAML2EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4342:6: (enumLiteral_3= 'Kerberos' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4342:6: (enumLiteral_3= 'Kerberos' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4342:8: enumLiteral_3= 'Kerberos'
                    {
                    enumLiteral_3=(Token)match(input,125,FollowSets000.FOLLOW_125_in_ruleAuthTokenKind9391); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getKerberosEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getAuthTokenKindAccess().getKerberosEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4348:6: (enumLiteral_4= 'SPNEGO' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4348:6: (enumLiteral_4= 'SPNEGO' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4348:8: enumLiteral_4= 'SPNEGO'
                    {
                    enumLiteral_4=(Token)match(input,126,FollowSets000.FOLLOW_126_in_ruleAuthTokenKind9408); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSPNEGOEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getAuthTokenKindAccess().getSPNEGOEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4354:6: (enumLiteral_5= 'RELToken' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4354:6: (enumLiteral_5= 'RELToken' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4354:8: enumLiteral_5= 'RELToken'
                    {
                    enumLiteral_5=(Token)match(input,127,FollowSets000.FOLLOW_127_in_ruleAuthTokenKind9425); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getRELTokenEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getAuthTokenKindAccess().getRELTokenEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4360:6: (enumLiteral_6= 'X509Certificate' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4360:6: (enumLiteral_6= 'X509Certificate' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4360:8: enumLiteral_6= 'X509Certificate'
                    {
                    enumLiteral_6=(Token)match(input,128,FollowSets000.FOLLOW_128_in_ruleAuthTokenKind9442); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getX509CertificateEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getAuthTokenKindAccess().getX509CertificateEnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4366:6: (enumLiteral_7= 'OAuth' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4366:6: (enumLiteral_7= 'OAuth' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4366:8: enumLiteral_7= 'OAuth'
                    {
                    enumLiteral_7=(Token)match(input,129,FollowSets000.FOLLOW_129_in_ruleAuthTokenKind9459); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getOAuthEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_7, grammarAccess.getAuthTokenKindAccess().getOAuthEnumLiteralDeclaration_7()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4372:6: (enumLiteral_8= 'OAuth2' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4372:6: (enumLiteral_8= 'OAuth2' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4372:8: enumLiteral_8= 'OAuth2'
                    {
                    enumLiteral_8=(Token)match(input,130,FollowSets000.FOLLOW_130_in_ruleAuthTokenKind9476); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4382:1: ruleLogRequirementKind returns [Enumerator current=null] : ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'header' ) | (enumLiteral_2= 'all' ) ) ;
    public final Enumerator ruleLogRequirementKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4384:28: ( ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'header' ) | (enumLiteral_2= 'all' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4385:1: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'header' ) | (enumLiteral_2= 'all' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4385:1: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'header' ) | (enumLiteral_2= 'all' ) )
            int alt95=3;
            switch ( input.LA(1) ) {
            case 131:
                {
                alt95=1;
                }
                break;
            case 108:
                {
                alt95=2;
                }
                break;
            case 111:
                {
                alt95=3;
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4385:2: (enumLiteral_0= 'none' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4385:2: (enumLiteral_0= 'none' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4385:4: enumLiteral_0= 'none'
                    {
                    enumLiteral_0=(Token)match(input,131,FollowSets000.FOLLOW_131_in_ruleLogRequirementKind9521); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getLogRequirementKindAccess().getNoneEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getLogRequirementKindAccess().getNoneEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4391:6: (enumLiteral_1= 'header' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4391:6: (enumLiteral_1= 'header' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4391:8: enumLiteral_1= 'header'
                    {
                    enumLiteral_1=(Token)match(input,108,FollowSets000.FOLLOW_108_in_ruleLogRequirementKind9538); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getLogRequirementKindAccess().getHeaderEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getLogRequirementKindAccess().getHeaderEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4397:6: (enumLiteral_2= 'all' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4397:6: (enumLiteral_2= 'all' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4397:8: enumLiteral_2= 'all'
                    {
                    enumLiteral_2=(Token)match(input,111,FollowSets000.FOLLOW_111_in_ruleLogRequirementKind9555); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4407:1: ruleReliablilityKind returns [Enumerator current=null] : ( (enumLiteral_0= 'exactly-once' ) | (enumLiteral_1= 'at-most-once' ) | (enumLiteral_2= 'at-least-once' ) | (enumLiteral_3= 'best-effort' ) ) ;
    public final Enumerator ruleReliablilityKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4409:28: ( ( (enumLiteral_0= 'exactly-once' ) | (enumLiteral_1= 'at-most-once' ) | (enumLiteral_2= 'at-least-once' ) | (enumLiteral_3= 'best-effort' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4410:1: ( (enumLiteral_0= 'exactly-once' ) | (enumLiteral_1= 'at-most-once' ) | (enumLiteral_2= 'at-least-once' ) | (enumLiteral_3= 'best-effort' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4410:1: ( (enumLiteral_0= 'exactly-once' ) | (enumLiteral_1= 'at-most-once' ) | (enumLiteral_2= 'at-least-once' ) | (enumLiteral_3= 'best-effort' ) )
            int alt96=4;
            switch ( input.LA(1) ) {
            case 132:
                {
                alt96=1;
                }
                break;
            case 133:
                {
                alt96=2;
                }
                break;
            case 134:
                {
                alt96=3;
                }
                break;
            case 135:
                {
                alt96=4;
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4410:2: (enumLiteral_0= 'exactly-once' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4410:2: (enumLiteral_0= 'exactly-once' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4410:4: enumLiteral_0= 'exactly-once'
                    {
                    enumLiteral_0=(Token)match(input,132,FollowSets000.FOLLOW_132_in_ruleReliablilityKind9600); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReliablilityKindAccess().getEXACTLY_ONCEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getReliablilityKindAccess().getEXACTLY_ONCEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4416:6: (enumLiteral_1= 'at-most-once' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4416:6: (enumLiteral_1= 'at-most-once' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4416:8: enumLiteral_1= 'at-most-once'
                    {
                    enumLiteral_1=(Token)match(input,133,FollowSets000.FOLLOW_133_in_ruleReliablilityKind9617); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReliablilityKindAccess().getAT_MOST_ONCEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getReliablilityKindAccess().getAT_MOST_ONCEEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4422:6: (enumLiteral_2= 'at-least-once' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4422:6: (enumLiteral_2= 'at-least-once' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4422:8: enumLiteral_2= 'at-least-once'
                    {
                    enumLiteral_2=(Token)match(input,134,FollowSets000.FOLLOW_134_in_ruleReliablilityKind9634); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReliablilityKindAccess().getAT_LEAST_ONCEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getReliablilityKindAccess().getAT_LEAST_ONCEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4428:6: (enumLiteral_3= 'best-effort' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4428:6: (enumLiteral_3= 'best-effort' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4428:8: enumLiteral_3= 'best-effort'
                    {
                    enumLiteral_3=(Token)match(input,135,FollowSets000.FOLLOW_135_in_ruleReliablilityKind9651); if (state.failed) return current;
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
    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4438:1: ruleGovernanceDecisionResult returns [Enumerator current=null] : ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) ) ;
    public final Enumerator ruleGovernanceDecisionResult() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4440:28: ( ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) ) )
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4441:1: ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) )
            {
            // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4441:1: ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) )
            int alt97=4;
            switch ( input.LA(1) ) {
            case 136:
                {
                alt97=1;
                }
                break;
            case 137:
                {
                alt97=2;
                }
                break;
            case 138:
                {
                alt97=3;
                }
                break;
            case 139:
                {
                alt97=4;
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
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4441:2: (enumLiteral_0= 'pending' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4441:2: (enumLiteral_0= 'pending' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4441:4: enumLiteral_0= 'pending'
                    {
                    enumLiteral_0=(Token)match(input,136,FollowSets000.FOLLOW_136_in_ruleGovernanceDecisionResult9696); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getPendingEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getGovernanceDecisionResultAccess().getPendingEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4447:6: (enumLiteral_1= 'accepted' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4447:6: (enumLiteral_1= 'accepted' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4447:8: enumLiteral_1= 'accepted'
                    {
                    enumLiteral_1=(Token)match(input,137,FollowSets000.FOLLOW_137_in_ruleGovernanceDecisionResult9713); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getAcceptedEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getGovernanceDecisionResultAccess().getAcceptedEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4453:6: (enumLiteral_2= 'denied' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4453:6: (enumLiteral_2= 'denied' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4453:8: enumLiteral_2= 'denied'
                    {
                    enumLiteral_2=(Token)match(input,138,FollowSets000.FOLLOW_138_in_ruleGovernanceDecisionResult9730); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getDeniedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getGovernanceDecisionResultAccess().getDeniedEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4459:6: (enumLiteral_3= 'specific' )
                    {
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4459:6: (enumLiteral_3= 'specific' )
                    // ../org.fornax.soa.sladsl/src-gen/org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.g:4459:8: enumLiteral_3= 'specific'
                    {
                    enumLiteral_3=(Token)match(input,139,FollowSets000.FOLLOW_139_in_ruleGovernanceDecisionResult9747); if (state.failed) return current;
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
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSLA240 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSLA252 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_13_in_ruleSLA265 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA282 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleSLA301 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA318 = new BitSet(new long[]{0x00000000000F8000L});
        public static final BitSet FOLLOW_15_in_ruleSLA336 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA353 = new BitSet(new long[]{0x00000000000F0000L});
        public static final BitSet FOLLOW_16_in_ruleSLA373 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA390 = new BitSet(new long[]{0x00000000000E0000L});
        public static final BitSet FOLLOW_17_in_ruleSLA410 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA427 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_18_in_ruleSLA447 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA464 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleSLA484 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSLA496 = new BitSet(new long[]{0x0000000000100020L});
        public static final BitSet FOLLOW_ruleAssetRef_in_ruleSLA517 = new BitSet(new long[]{0x0000000000100020L});
        public static final BitSet FOLLOW_20_in_ruleSLA530 = new BitSet(new long[]{0x0000000080200000L});
        public static final BitSet FOLLOW_ruleCost_in_ruleSLA552 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleSLA566 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSLA578 = new BitSet(new long[]{0x0054550800100000L});
        public static final BitSet FOLLOW_ruleServiceQualityProperty_in_ruleSLA599 = new BitSet(new long[]{0x0054550800100000L});
        public static final BitSet FOLLOW_20_in_ruleSLA612 = new BitSet(new long[]{0x000000007E500000L,0x0000000002380C00L});
        public static final BitSet FOLLOW_22_in_ruleSLA626 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSLA638 = new BitSet(new long[]{0x0000000001800000L});
        public static final BitSet FOLLOW_23_in_ruleSLA651 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA668 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleSLA688 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSLA700 = new BitSet(new long[]{0x0800000000100000L,0x0000000000000104L});
        public static final BitSet FOLLOW_ruleSecurityRequirement_in_ruleSLA721 = new BitSet(new long[]{0x0800000000100000L,0x0000000000000104L});
        public static final BitSet FOLLOW_20_in_ruleSLA734 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleSLA747 = new BitSet(new long[]{0x000000007E100000L,0x0000000002380C00L});
        public static final BitSet FOLLOW_25_in_ruleSLA762 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA779 = new BitSet(new long[]{0x000000007C100000L,0x0000000002380C00L});
        public static final BitSet FOLLOW_rulePriorityDeclaration_in_ruleSLA807 = new BitSet(new long[]{0x000000007C100000L,0x0000000002380C00L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleSLA829 = new BitSet(new long[]{0x000000007C100000L,0x0000000002380000L});
        public static final BitSet FOLLOW_26_in_ruleSLA843 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA860 = new BitSet(new long[]{0x0000000078100000L,0x0000000002380000L});
        public static final BitSet FOLLOW_ruleParty_in_ruleSLA888 = new BitSet(new long[]{0x0000000078100000L,0x0000000002380000L});
        public static final BitSet FOLLOW_27_in_ruleSLA902 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA919 = new BitSet(new long[]{0x0000000070100000L,0x0000000002000000L});
        public static final BitSet FOLLOW_28_in_ruleSLA939 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA956 = new BitSet(new long[]{0x0000000060100000L,0x0000000002000000L});
        public static final BitSet FOLLOW_29_in_ruleSLA976 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSLA993 = new BitSet(new long[]{0x0000000040100000L,0x0000000002000000L});
        public static final BitSet FOLLOW_ruleReport_in_ruleSLA1021 = new BitSet(new long[]{0x0000000040100000L,0x0000000002000000L});
        public static final BitSet FOLLOW_30_in_ruleSLA1035 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSLA1059 = new BitSet(new long[]{0x0000000040100020L});
        public static final BitSet FOLLOW_20_in_ruleSLA1074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssetRef_in_entryRuleAssetRef1110 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssetRef1120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleAssetRef1172 = new BitSet(new long[]{0x0000000000000002L,0x0000000CC0000000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleAssetRef1193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCost_in_entryRuleCost1230 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCost1240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleCost1277 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleCost1289 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleCost1301 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCost1318 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleCost1335 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCost1352 = new BitSet(new long[]{0x0000000400100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleCost1378 = new BitSet(new long[]{0x0000000400100000L});
        public static final BitSet FOLLOW_34_in_ruleCost1392 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCost1409 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleCost1428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceQualityProperty_in_entryRuleServiceQualityProperty1464 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleServiceQualityProperty1474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAvailability_in_ruleServiceQualityProperty1524 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThroughput_in_ruleServiceQualityProperty1554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLatency_in_ruleServiceQualityProperty1584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxDownTime_in_ruleServiceQualityProperty1614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCapacityRequirement_in_ruleServiceQualityProperty1644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAccuracyRequirement_in_ruleServiceQualityProperty1674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReliablityRequirement_in_ruleServiceQualityProperty1704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLogRequirement_in_ruleServiceQualityProperty1734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAvailability_in_entryRuleAvailability1769 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAvailability1779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleAvailability1816 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAvailability1828 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_35_in_ruleAvailability1840 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAvailability1857 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleAvailability1874 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rulePercentile_in_ruleAvailability1895 = new BitSet(new long[]{0x000000E000100000L});
        public static final BitSet FOLLOW_37_in_ruleAvailability1908 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAvailability1925 = new BitSet(new long[]{0x000000C000100000L});
        public static final BitSet FOLLOW_38_in_ruleAvailability1945 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAvailability1962 = new BitSet(new long[]{0x0000008000100040L});
        public static final BitSet FOLLOW_rulePercentile_in_ruleAvailability1988 = new BitSet(new long[]{0x0000008000100000L});
        public static final BitSet FOLLOW_39_in_ruleAvailability2004 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAvailability2021 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleAvailability2040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThroughput_in_entryRuleThroughput2076 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleThroughput2086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleThroughput2123 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleThroughput2135 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_40_in_ruleThroughput2147 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleThroughput2164 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_41_in_ruleThroughput2181 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleThroughput2198 = new BitSet(new long[]{0x0000000400100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleThroughput2224 = new BitSet(new long[]{0x0000000400100000L});
        public static final BitSet FOLLOW_34_in_ruleThroughput2238 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleThroughput2255 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleThroughput2274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLatency_in_entryRuleLatency2310 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLatency2320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleLatency2357 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleLatency2369 = new BitSet(new long[]{0x0000040000000000L});
        public static final BitSet FOLLOW_42_in_ruleLatency2381 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_43_in_ruleLatency2399 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleLatency2424 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rulePercentile_in_ruleLatency2445 = new BitSet(new long[]{0x0000000400100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleLatency2466 = new BitSet(new long[]{0x0000000400100000L});
        public static final BitSet FOLLOW_34_in_ruleLatency2480 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleLatency2497 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleLatency2516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxDownTime_in_entryRuleMaxDownTime2552 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxDownTime2562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleMaxDownTime2599 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleMaxDownTime2611 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleMaxDownTime2623 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleMaxDownTime2640 = new BitSet(new long[]{0x0000000400100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleMaxDownTime2666 = new BitSet(new long[]{0x0000000400100000L});
        public static final BitSet FOLLOW_34_in_ruleMaxDownTime2680 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleMaxDownTime2697 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleMaxDownTime2716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCapacityRequirement_in_entryRuleCapacityRequirement2752 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCapacityRequirement2762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleCapacityRequirement2799 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleCapacityRequirement2811 = new BitSet(new long[]{0x0002800400100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_47_in_ruleCapacityRequirement2836 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCapacityRequirement2853 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleCapacityRequirement2870 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCapacityRequirement2887 = new BitSet(new long[]{0x0002000400100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_49_in_ruleCapacityRequirement2907 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCapacityRequirement2924 = new BitSet(new long[]{0x0000000400100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleCapacityRequirement2952 = new BitSet(new long[]{0x0000000400100000L});
        public static final BitSet FOLLOW_34_in_ruleCapacityRequirement2966 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCapacityRequirement2983 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleCapacityRequirement3002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReliablityRequirement_in_entryRuleReliablityRequirement3038 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReliablityRequirement3048 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleReliablityRequirement3085 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleReliablityRequirement3097 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000F0L});
        public static final BitSet FOLLOW_ruleReliablilityKind_in_ruleReliablityRequirement3118 = new BitSet(new long[]{0x0008000000100000L});
        public static final BitSet FOLLOW_51_in_ruleReliablityRequirement3136 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleReliablityRequirement3162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAccuracyRequirement_in_entryRuleAccuracyRequirement3198 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAccuracyRequirement3208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleAccuracyRequirement3245 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAccuracyRequirement3257 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_ruleAccuracyRequirement3269 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAccuracyRequirement3286 = new BitSet(new long[]{0x0000000400100000L,0x0000000000000800L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleAccuracyRequirement3312 = new BitSet(new long[]{0x0000000400100000L});
        public static final BitSet FOLLOW_34_in_ruleAccuracyRequirement3326 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAccuracyRequirement3343 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleAccuracyRequirement3362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLogRequirement_in_entryRuleLogRequirement3398 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLogRequirement3408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleLogRequirement3445 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleLogRequirement3457 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleLogRequirement3469 = new BitSet(new long[]{0x0000000000000000L,0x0000900000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_ruleLogRequirementKind_in_ruleLogRequirement3490 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleLogRequirement3502 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleLogRequirement3519 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePercentile_in_entryRulePercentile3560 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePercentile3570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rulePercentile3612 = new BitSet(new long[]{0x0600000000000000L});
        public static final BitSet FOLLOW_57_in_rulePercentile3630 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_rulePercentile3641 = new BitSet(new long[]{0x0600000000000000L});
        public static final BitSet FOLLOW_58_in_rulePercentile3654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecurityRequirement_in_entryRuleSecurityRequirement3690 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecurityRequirement3700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthenticationRequirement_in_ruleSecurityRequirement3750 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSigningRequirement_in_ruleSecurityRequirement3780 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEncryptionRequirement_in_ruleSecurityRequirement3810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthenticationRequirement_in_entryRuleAuthenticationRequirement3845 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAuthenticationRequirement3855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_ruleAuthenticationRequirement3904 = new BitSet(new long[]{0x1000000000001000L});
        public static final BitSet FOLLOW_60_in_ruleAuthenticationRequirement3922 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAuthenticationRequirement3948 = new BitSet(new long[]{0x2000000000000000L});
        public static final BitSet FOLLOW_61_in_ruleAuthenticationRequirement3960 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAuthenticationRequirement3972 = new BitSet(new long[]{0x1000000000000000L,0xFC00000000000000L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleAuthToken_in_ruleAuthenticationRequirement3993 = new BitSet(new long[]{0x1000000000100000L,0xFC00000000000000L,0x0000000000000007L});
        public static final BitSet FOLLOW_20_in_ruleAuthenticationRequirement4006 = new BitSet(new long[]{0x4000000000000000L});
        public static final BitSet FOLLOW_62_in_ruleAuthenticationRequirement4018 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAuthenticationRequirement4030 = new BitSet(new long[]{0x1000000000100000L,0x00000F8000000002L});
        public static final BitSet FOLLOW_ruleHashAlgorithm_in_ruleAuthenticationRequirement4051 = new BitSet(new long[]{0x1000000000100000L,0x00000F8000000002L});
        public static final BitSet FOLLOW_20_in_ruleAuthenticationRequirement4064 = new BitSet(new long[]{0x8000000000100000L,0x0000000000000001L});
        public static final BitSet FOLLOW_63_in_ruleAuthenticationRequirement4082 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000001L});
        public static final BitSet FOLLOW_64_in_ruleAuthenticationRequirement4109 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAuthenticationRequirement4126 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleAuthenticationRequirement4145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthToken_in_entryRuleAuthToken4181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAuthToken4191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleAuthToken4234 = new BitSet(new long[]{0x1000000000000000L,0xFC00000000000000L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleAuthTokenKind_in_ruleAuthToken4269 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHashAlgorithm_in_entryRuleHashAlgorithm4305 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHashAlgorithm4315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleHashAlgorithm4358 = new BitSet(new long[]{0x1000000000000000L,0x00000F8000000002L});
        public static final BitSet FOLLOW_65_in_ruleHashAlgorithm4390 = new BitSet(new long[]{0x1000000000000000L,0x00000F8000000002L});
        public static final BitSet FOLLOW_ruleHashAlgKind_in_ruleHashAlgorithm4425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSigningRequirement_in_entryRuleSigningRequirement4461 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSigningRequirement4471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleSigningRequirement4520 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSigningRequirement4532 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000038L});
        public static final BitSet FOLLOW_67_in_ruleSigningRequirement4545 = new BitSet(new long[]{0x0000000000000000L,0x001F038000000000L});
        public static final BitSet FOLLOW_ruleSigningAlgothm_in_ruleSigningRequirement4566 = new BitSet(new long[]{0x0000000000100000L,0x001F038000000030L});
        public static final BitSet FOLLOW_68_in_ruleSigningRequirement4582 = new BitSet(new long[]{0x0000000000000000L,0x001F038000000000L});
        public static final BitSet FOLLOW_ruleSigningAlgothm_in_ruleSigningRequirement4603 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000020L});
        public static final BitSet FOLLOW_69_in_ruleSigningRequirement4618 = new BitSet(new long[]{0x0000000000000000L,0x0000F00000000080L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_ruleSigningRequirement4639 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000040L});
        public static final BitSet FOLLOW_70_in_ruleSigningRequirement4652 = new BitSet(new long[]{0x0000000000000000L,0x0000F00000000080L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_ruleSigningRequirement4673 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000040L});
        public static final BitSet FOLLOW_20_in_ruleSigningRequirement4689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_entryRuleMessagePartRef4725 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMessagePartRef4735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMessagePartRefKind_in_ruleMessagePartRef4781 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_ruleMessagePartRef4794 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleMessagePartRef4811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEncryptionRequirement_in_entryRuleEncryptionRequirement4854 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEncryptionRequirement4864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_72_in_ruleEncryptionRequirement4913 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEncryptionRequirement4925 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000218L});
        public static final BitSet FOLLOW_67_in_ruleEncryptionRequirement4938 = new BitSet(new long[]{0x0000000000000000L,0x03F5000000000000L});
        public static final BitSet FOLLOW_ruleCipherAlgorithmKind_in_ruleEncryptionRequirement4959 = new BitSet(new long[]{0x0000000000100000L,0x03F5000000000210L});
        public static final BitSet FOLLOW_68_in_ruleEncryptionRequirement4975 = new BitSet(new long[]{0x0000000000000000L,0x03F5000000000000L});
        public static final BitSet FOLLOW_ruleCipherAlgorithmKind_in_ruleEncryptionRequirement4996 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000200L});
        public static final BitSet FOLLOW_73_in_ruleEncryptionRequirement5011 = new BitSet(new long[]{0x0000000000000000L,0x0000F00000000080L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_ruleEncryptionRequirement5032 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000040L});
        public static final BitSet FOLLOW_70_in_ruleEncryptionRequirement5045 = new BitSet(new long[]{0x0000000000000000L,0x0000F00000000080L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_ruleEncryptionRequirement5066 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000040L});
        public static final BitSet FOLLOW_20_in_ruleEncryptionRequirement5082 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePriorityDeclaration_in_entryRulePriorityDeclaration5118 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePriorityDeclaration5128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_74_in_rulePriorityDeclaration5165 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePriorityDeclaration5182 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_rulePriorityDeclaration5199 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_rulePriorityDeclaration5216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEscalation_in_entryRuleEscalation5257 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEscalation5267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleEscalation5304 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEscalation5316 = new BitSet(new long[]{0x0000000000000000L,0x0000000000003000L});
        public static final BitSet FOLLOW_76_in_ruleEscalation5329 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEscalation5346 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
        public static final BitSet FOLLOW_77_in_ruleEscalation5365 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleEscalation5377 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
        public static final BitSet FOLLOW_ruleContact_in_ruleEscalation5398 = new BitSet(new long[]{0x0000000000100000L,0x0000000000008000L});
        public static final BitSet FOLLOW_20_in_ruleEscalation5411 = new BitSet(new long[]{0x0000000000100000L,0x0000000000004000L});
        public static final BitSet FOLLOW_78_in_ruleEscalation5424 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEscalation5441 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleEscalation5460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContact_in_entryRuleContact5496 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContact5506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_79_in_ruleContact5543 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleContact5555 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
        public static final BitSet FOLLOW_80_in_ruleContact5567 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleContact5584 = new BitSet(new long[]{0x0000000000100000L,0x0000000000060000L});
        public static final BitSet FOLLOW_81_in_ruleContact5602 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleContact5619 = new BitSet(new long[]{0x0000000000100000L,0x0000000000040000L});
        public static final BitSet FOLLOW_82_in_ruleContact5639 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleContact5656 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleContact5675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParty_in_entryRuleParty5711 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParty5721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCustomerParty_in_ruleParty5771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProviderParty_in_ruleParty5801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdParty_in_ruleParty5831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCustomerParty_in_entryRuleCustomerParty5866 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCustomerParty5876 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_83_in_ruleCustomerParty5913 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCustomerParty5934 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleCustomerParty5946 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleRepesentative_in_ruleCustomerParty5967 = new BitSet(new long[]{0x0000000000000000L,0x0000000011800000L});
        public static final BitSet FOLLOW_ruleResponsibility_in_ruleCustomerParty5989 = new BitSet(new long[]{0x0000000000100000L,0x0000000011000000L});
        public static final BitSet FOLLOW_20_in_ruleCustomerParty6002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProviderParty_in_entryRuleProviderParty6038 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProviderParty6048 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_84_in_ruleProviderParty6085 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleProviderParty6106 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleProviderParty6118 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleRepesentative_in_ruleProviderParty6139 = new BitSet(new long[]{0x0000000000000000L,0x0000000011800000L});
        public static final BitSet FOLLOW_ruleResponsibility_in_ruleProviderParty6161 = new BitSet(new long[]{0x0000000000100000L,0x0000000011000000L});
        public static final BitSet FOLLOW_20_in_ruleProviderParty6174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleThirdParty_in_entryRuleThirdParty6210 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleThirdParty6220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_85_in_ruleThirdParty6257 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleThirdParty6278 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleThirdParty6290 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
        public static final BitSet FOLLOW_86_in_ruleThirdParty6302 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleThirdParty6319 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleRepesentative_in_ruleThirdParty6345 = new BitSet(new long[]{0x0000000000000000L,0x0000000011800000L});
        public static final BitSet FOLLOW_ruleResponsibility_in_ruleThirdParty6367 = new BitSet(new long[]{0x0000000000100000L,0x0000000011000000L});
        public static final BitSet FOLLOW_20_in_ruleThirdParty6380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRepesentative_in_entryRuleRepesentative6416 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRepesentative6426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_87_in_ruleRepesentative6463 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleRepesentative6475 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
        public static final BitSet FOLLOW_80_in_ruleRepesentative6487 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleRepesentative6504 = new BitSet(new long[]{0x0000000000100000L,0x0000000000060000L});
        public static final BitSet FOLLOW_81_in_ruleRepesentative6522 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleRepesentative6539 = new BitSet(new long[]{0x0000000000100000L,0x0000000000040000L});
        public static final BitSet FOLLOW_82_in_ruleRepesentative6559 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleRepesentative6576 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleRepesentative6595 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleResponsibility_in_entryRuleResponsibility6631 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleResponsibility6641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleResponsibility_in_ruleResponsibility6691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReportingResponsibility_in_ruleResponsibility6721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleResponsibility_in_entryRuleSimpleResponsibility6756 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleResponsibility6766 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_88_in_ruleSimpleResponsibility6803 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSimpleResponsibility6824 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSimpleResponsibility6836 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSimpleResponsibility6853 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleSimpleResponsibility6879 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000800L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSimpleResponsibility6897 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleSimpleResponsibility6914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReport_in_entryRuleReport6950 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReport6960 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_89_in_ruleReport6997 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReport7014 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleReport7031 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
        public static final BitSet FOLLOW_90_in_ruleReport7043 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReport7060 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
        public static final BitSet FOLLOW_91_in_ruleReport7077 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReport7094 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleReport7111 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReportingResponsibility_in_entryRuleReportingResponsibility7147 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReportingResponsibility7157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_92_in_ruleReportingResponsibility7194 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReportingResponsibility7211 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleReportingResponsibility7228 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
        public static final BitSet FOLLOW_90_in_ruleReportingResponsibility7240 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
        public static final BitSet FOLLOW_91_in_ruleReportingResponsibility7252 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReportingResponsibility7269 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
        public static final BitSet FOLLOW_ruleEscalation_in_ruleReportingResponsibility7295 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000800L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReportingResponsibility7313 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleReportingResponsibility7330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVersionId_in_entryRuleVersionId7369 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionId7380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId7420 = new BitSet(new long[]{0x0200000000000002L,0x0000000020000000L});
        public static final BitSet FOLLOW_57_in_ruleVersionId7439 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId7454 = new BitSet(new long[]{0x0200000000000002L,0x0000000020000000L});
        public static final BitSet FOLLOW_57_in_ruleVersionId7476 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_93_in_ruleVersionId7495 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVersionId7511 = new BitSet(new long[]{0x0200000000000002L,0x0000000020000000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_entryRuleVersionRef7562 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionRef7572 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_ruleVersionRef7622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_ruleVersionRef7652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef7682 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_ruleVersionRef7712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_ruleVersionRef7742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef7777 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMinVersionRef7787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_94_in_ruleMinVersionRef7824 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMinVersionRef7845 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef7881 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxVersionRef7891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_95_in_ruleMaxVersionRef7928 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMaxVersionRef7949 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef7985 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef7995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_94_in_ruleLowerBoundRangeVersionRef8033 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
        public static final BitSet FOLLOW_96_in_ruleLowerBoundRangeVersionRef8045 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef8067 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_70_in_ruleLowerBoundRangeVersionRef8079 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
        public static final BitSet FOLLOW_95_in_ruleLowerBoundRangeVersionRef8092 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
        public static final BitSet FOLLOW_97_in_ruleLowerBoundRangeVersionRef8104 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef8126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef8162 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMajorVersionRef8172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_98_in_ruleMajorVersionRef8209 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMajorVersionRef8226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef8267 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFixedVersionRef8277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_99_in_ruleFixedVersionRef8314 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleFixedVersionRef8335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard8372 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard8383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard8430 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
        public static final BitSet FOLLOW_100_in_ruleQualifiedNameWithWildCard8449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8492 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName8503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName8543 = new BitSet(new long[]{0x0200000000000002L});
        public static final BitSet FOLLOW_57_in_ruleQualifiedName8562 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName8577 = new BitSet(new long[]{0x0200000000000002L});
        public static final BitSet FOLLOW_ruleInfoItem_in_entryRuleInfoItem8630 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfoItem8640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_101_in_ruleInfoItem8677 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleInfoItem8694 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
        public static final BitSet FOLLOW_102_in_ruleInfoItem8712 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleInfoItem8729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_103_in_ruleHashAlgKind8786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_104_in_ruleHashAlgKind8803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_105_in_ruleHashAlgKind8820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_106_in_ruleHashAlgKind8837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_107_in_ruleHashAlgKind8854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_108_in_ruleMessagePartRefKind8899 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_109_in_ruleMessagePartRefKind8916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_110_in_ruleMessagePartRefKind8933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_111_in_ruleMessagePartRefKind8950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_71_in_ruleMessagePartRefKind8967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_112_in_ruleSigningAlgothm9012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_104_in_ruleSigningAlgothm9029 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_105_in_ruleSigningAlgothm9046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_103_in_ruleSigningAlgothm9063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_113_in_ruleSigningAlgothm9080 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_114_in_ruleSigningAlgothm9097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_115_in_ruleSigningAlgothm9114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_116_in_ruleSigningAlgothm9131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_112_in_ruleCipherAlgorithmKind9176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_117_in_ruleCipherAlgorithmKind9193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_118_in_ruleCipherAlgorithmKind9210 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_119_in_ruleCipherAlgorithmKind9227 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_120_in_ruleCipherAlgorithmKind9244 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_121_in_ruleCipherAlgorithmKind9261 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_114_in_ruleCipherAlgorithmKind9278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_116_in_ruleCipherAlgorithmKind9295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_122_in_ruleAuthTokenKind9340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_123_in_ruleAuthTokenKind9357 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_124_in_ruleAuthTokenKind9374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_125_in_ruleAuthTokenKind9391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_126_in_ruleAuthTokenKind9408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_127_in_ruleAuthTokenKind9425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_128_in_ruleAuthTokenKind9442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_129_in_ruleAuthTokenKind9459 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_130_in_ruleAuthTokenKind9476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_131_in_ruleLogRequirementKind9521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_108_in_ruleLogRequirementKind9538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_111_in_ruleLogRequirementKind9555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_132_in_ruleReliablilityKind9600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_133_in_ruleReliablilityKind9617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_134_in_ruleReliablilityKind9634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_135_in_ruleReliablilityKind9651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_136_in_ruleGovernanceDecisionResult9696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_137_in_ruleGovernanceDecisionResult9713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_138_in_ruleGovernanceDecisionResult9730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_139_in_ruleGovernanceDecisionResult9747 = new BitSet(new long[]{0x0000000000000002L});
    }


}