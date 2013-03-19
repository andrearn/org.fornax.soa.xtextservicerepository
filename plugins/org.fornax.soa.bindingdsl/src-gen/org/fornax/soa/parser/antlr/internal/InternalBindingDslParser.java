package org.fornax.soa.parser.antlr.internal; 

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
import org.fornax.soa.services.BindingDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBindingDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'on-connector'", "','", "'bind-module'", "'as'", "'to'", "'environment'", "'{'", "'server'", "'default-protocols'", "'}'", "'default-policies'", "'default-assertions'", "'bind-service'", "'provided-contract'", "'protocols'", "'policies'", "'assertions'", "'references-module'", "'bind-channel'", "'bind-operation'", "'provider-protocols'", "'provider-policies'", "'SOAP'", "'style'", "'protocol-version'", "'transport'", "'http-context-root'", "'provided-WSDL-Url'", "'SAP'", "'client'", "'EJB'", "'jndi-name'", "'HTTP'", "'url'", "'provider-url'", "'verb'", "'REST'", "'path'", "'format'", "'consumes-format'", "'provides-format'", "'JMS'", "'provider-jndi-name'", "'topic'", "'queue'", "'SCA'", "'promote'", "'reference'", "'[]'", "'FILE'", "'interval'", "'FTP'", "'access'", "'IIOP'", "'lookup-name'", "'AMQP'", "'provider-lookup-name'", "'logging-policy'", "'authn-policy'", "'optional'", "'auth-tokens'", "'hash-algorithms'", "'use-nonce'", "'issuer'", "'Base64-encoded'", "'signing-policy'", "'supported-algorithms'", "'requires-algorithm'", "'signed-message-parts'", "'expression'", "'encryption-policy'", "'encrypted-message-parts'", "'availability'", "'mean-time-between-failure'", "'mean-time-to-repair'", "'regular-down-times'", "'latency'", "'STRING'", "'percentile'", "'num-of-requests'", "'per'", "'message-size'", "'message-exchange-reliability'", "'in-order-delivery'", "'costs'", "'billed-per-unit'", "'max-error-rate'", "'.'", "'%'", "'endpoint-qualifier'", "'import'", "'-'", "'minVersion'", "'maxVersion'", "'>='", "'<'", "'majorVersion'", "'fixedVersion'", "'.*'", "'@'", "'governance-decision'", "'subject'", "'decision-result'", "'specific-result'", "'justification-doc'", "'decision-date'", "'decision-by'", "'effective-date'", "'location'", "'document/literal-wrapped'", "'rpc/literal'", "'rpc/encoded'", "'SMTP'", "'SOAP-v1.1'", "'SOAP-v1.2'", "'IDOC'", "'RFC'", "'JSON'", "'XML'", "'BISON'", "'OTHER'", "'CREATE'", "'RETRIEVE'", "'UPDATE'", "'DELETE'", "'GET'", "'PUT'", "'POST'", "'read'", "'write'", "'MD5'", "'SHA1'", "'SHA256'", "'RSA'", "'PlainText'", "'header'", "'body'", "'attachments'", "'all'", "'NONE'", "'RSA_1_5'", "'AES128'", "'AES192'", "'AES256'", "'Basic128'", "'Basic192'", "'Basic256'", "'DES'", "'3DES'", "'UsernamePassword'", "'SAML'", "'SAML2'", "'Kerberos'", "'SPNEGO'", "'RELToken'", "'X509Certificate'", "'OAuth'", "'OAuth2'", "'none'", "'exactly-once'", "'at-most-once'", "'at-least-once'", "'best-effort'", "'pending'", "'accepted'", "'denied'", "'specific'"
    };
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__159=159;
    public static final int T__27=27;
    public static final int T__158=158;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__160=160;
    public static final int T__167=167;
    public static final int T__168=168;
    public static final int EOF=-1;
    public static final int T__165=165;
    public static final int T__166=166;
    public static final int T__163=163;
    public static final int T__164=164;
    public static final int T__161=161;
    public static final int T__162=162;
    public static final int T__93=93;
    public static final int T__19=19;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__148=148;
    public static final int T__16=16;
    public static final int T__147=147;
    public static final int T__15=15;
    public static final int T__90=90;
    public static final int T__18=18;
    public static final int T__149=149;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__154=154;
    public static final int T__155=155;
    public static final int T__156=156;
    public static final int T__157=157;
    public static final int T__99=99;
    public static final int T__150=150;
    public static final int T__98=98;
    public static final int T__151=151;
    public static final int T__97=97;
    public static final int T__152=152;
    public static final int T__96=96;
    public static final int T__153=153;
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
    public static final int T__145=145;
    public static final int T__89=89;
    public static final int T__146=146;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__143=143;
    public static final int T__144=144;
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
    public static final int T__175=175;
    public static final int T__174=174;
    public static final int T__30=30;
    public static final int T__173=173;
    public static final int T__31=31;
    public static final int T__172=172;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__177=177;
    public static final int T__35=35;
    public static final int T__176=176;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__171=171;
    public static final int T__170=170;
    public static final int RULE_WS=9;
    public static final int T__169=169;

    // delegates
    // delegators


        public InternalBindingDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBindingDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBindingDslParser.tokenNames; }
    public String getGrammarFileName() { return "../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private BindingDslGrammarAccess grammarAccess;
     	
        public InternalBindingDslParser(TokenStream input, BindingDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "BindingModel";	
       	}
       	
       	@Override
       	protected BindingDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleBindingModel"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:74:1: entryRuleBindingModel returns [EObject current=null] : iv_ruleBindingModel= ruleBindingModel EOF ;
    public final EObject entryRuleBindingModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBindingModel = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:75:2: (iv_ruleBindingModel= ruleBindingModel EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:76:2: iv_ruleBindingModel= ruleBindingModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBindingModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBindingModel_in_entryRuleBindingModel81);
            iv_ruleBindingModel=ruleBindingModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBindingModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBindingModel91); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBindingModel"


    // $ANTLR start "ruleBindingModel"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:83:1: ruleBindingModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_bindings_1_0= ruleBinding ) )* ) ;
    public final EObject ruleBindingModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_bindings_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:86:28: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_bindings_1_0= ruleBinding ) )* ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:87:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_bindings_1_0= ruleBinding ) )* )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:87:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_bindings_1_0= ruleBinding ) )* )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:87:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_bindings_1_0= ruleBinding ) )*
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:87:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==101) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:88:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:88:1: (lv_imports_0_0= ruleImport )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:89:3: lv_imports_0_0= ruleImport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBindingModelAccess().getImportsImportParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleImport_in_ruleBindingModel137);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBindingModelRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"imports",
            	              		lv_imports_0_0, 
            	              		"Import");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:105:3: ( (lv_bindings_1_0= ruleBinding ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13||LA2_0==23||LA2_0==29) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:106:1: (lv_bindings_1_0= ruleBinding )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:106:1: (lv_bindings_1_0= ruleBinding )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:107:3: lv_bindings_1_0= ruleBinding
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBindingModelAccess().getBindingsBindingParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleBinding_in_ruleBindingModel159);
            	    lv_bindings_1_0=ruleBinding();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBindingModelRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"bindings",
            	              		lv_bindings_1_0, 
            	              		"Binding");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleBindingModel"


    // $ANTLR start "entryRuleBinding"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:131:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:132:2: (iv_ruleBinding= ruleBinding EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:133:2: iv_ruleBinding= ruleBinding EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBindingRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBinding_in_entryRuleBinding196);
            iv_ruleBinding=ruleBinding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinding; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBinding206); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinding"


    // $ANTLR start "ruleBinding"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:140:1: ruleBinding returns [EObject current=null] : (this_ModuleBinding_0= ruleModuleBinding | this_ServiceBinding_1= ruleServiceBinding | this_ChannelBinding_2= ruleChannelBinding ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        EObject this_ModuleBinding_0 = null;

        EObject this_ServiceBinding_1 = null;

        EObject this_ChannelBinding_2 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:143:28: ( (this_ModuleBinding_0= ruleModuleBinding | this_ServiceBinding_1= ruleServiceBinding | this_ChannelBinding_2= ruleChannelBinding ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:144:1: (this_ModuleBinding_0= ruleModuleBinding | this_ServiceBinding_1= ruleServiceBinding | this_ChannelBinding_2= ruleChannelBinding )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:144:1: (this_ModuleBinding_0= ruleModuleBinding | this_ServiceBinding_1= ruleServiceBinding | this_ChannelBinding_2= ruleChannelBinding )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt3=1;
                }
                break;
            case 23:
                {
                alt3=2;
                }
                break;
            case 29:
                {
                alt3=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:145:2: this_ModuleBinding_0= ruleModuleBinding
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingAccess().getModuleBindingParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleModuleBinding_in_ruleBinding256);
                    this_ModuleBinding_0=ruleModuleBinding();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ModuleBinding_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:158:2: this_ServiceBinding_1= ruleServiceBinding
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingAccess().getServiceBindingParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleServiceBinding_in_ruleBinding286);
                    this_ServiceBinding_1=ruleServiceBinding();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ServiceBinding_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:171:2: this_ChannelBinding_2= ruleChannelBinding
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingAccess().getChannelBindingParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleChannelBinding_in_ruleBinding316);
                    this_ChannelBinding_2=ruleChannelBinding();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ChannelBinding_2; 
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
    // $ANTLR end "ruleBinding"


    // $ANTLR start "entryRuleConnectorQualifier"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:190:1: entryRuleConnectorQualifier returns [EObject current=null] : iv_ruleConnectorQualifier= ruleConnectorQualifier EOF ;
    public final EObject entryRuleConnectorQualifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectorQualifier = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:191:2: (iv_ruleConnectorQualifier= ruleConnectorQualifier EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:192:2: iv_ruleConnectorQualifier= ruleConnectorQualifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConnectorQualifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_entryRuleConnectorQualifier351);
            iv_ruleConnectorQualifier=ruleConnectorQualifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConnectorQualifier; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConnectorQualifier361); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConnectorQualifier"


    // $ANTLR start "ruleConnectorQualifier"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:199:1: ruleConnectorQualifier returns [EObject current=null] : (otherlv_0= 'on-connector' ( ( ruleQualifiedName ) ) (otherlv_2= ',' ( ( ruleQualifiedName ) ) )* ) ;
    public final EObject ruleConnectorQualifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:202:28: ( (otherlv_0= 'on-connector' ( ( ruleQualifiedName ) ) (otherlv_2= ',' ( ( ruleQualifiedName ) ) )* ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:203:1: (otherlv_0= 'on-connector' ( ( ruleQualifiedName ) ) (otherlv_2= ',' ( ( ruleQualifiedName ) ) )* )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:203:1: (otherlv_0= 'on-connector' ( ( ruleQualifiedName ) ) (otherlv_2= ',' ( ( ruleQualifiedName ) ) )* )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:203:3: otherlv_0= 'on-connector' ( ( ruleQualifiedName ) ) (otherlv_2= ',' ( ( ruleQualifiedName ) ) )*
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleConnectorQualifier398); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConnectorQualifierAccess().getOnConnectorKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:207:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:208:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:208:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:209:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getConnectorQualifierRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConnectorQualifierAccess().getConnectorsConnectorCrossReference_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleConnectorQualifier425);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:225:2: (otherlv_2= ',' ( ( ruleQualifiedName ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:225:4: otherlv_2= ',' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleConnectorQualifier438); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getConnectorQualifierAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:229:1: ( ( ruleQualifiedName ) )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:230:1: ( ruleQualifiedName )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:230:1: ( ruleQualifiedName )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:231:3: ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getConnectorQualifierRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConnectorQualifierAccess().getConnectorsConnectorCrossReference_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleConnectorQualifier465);
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
            	    break loop4;
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
    // $ANTLR end "ruleConnectorQualifier"


    // $ANTLR start "entryRuleModuleBinding"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:255:1: entryRuleModuleBinding returns [EObject current=null] : iv_ruleModuleBinding= ruleModuleBinding EOF ;
    public final EObject entryRuleModuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModuleBinding = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:256:2: (iv_ruleModuleBinding= ruleModuleBinding EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:257:2: iv_ruleModuleBinding= ruleModuleBinding EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModuleBindingRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModuleBinding_in_entryRuleModuleBinding503);
            iv_ruleModuleBinding=ruleModuleBinding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModuleBinding; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModuleBinding513); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModuleBinding"


    // $ANTLR start "ruleModuleBinding"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:264:1: ruleModuleBinding returns [EObject current=null] : (otherlv_0= 'bind-module' ( (lv_module_1_0= ruleModuleRef ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' ( (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ) | (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' ) ) ( (lv_endpointQualifierRef_11_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_12_0= ruleGovernanceDecision ) )* (otherlv_13= 'default-protocols' otherlv_14= '{' ( (lv_protocol_15_0= ruleBindingProtocol ) )+ otherlv_16= '}' )? (otherlv_17= 'default-policies' otherlv_18= '{' ( (lv_policies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'default-assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )? ( (lv_serviceBindings_25_0= ruleServiceBinding ) )* otherlv_26= '}' ) ;
    public final EObject ruleModuleBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        EObject lv_module_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_endpointQualifierRef_11_0 = null;

        EObject lv_governanceDecisions_12_0 = null;

        EObject lv_protocol_15_0 = null;

        EObject lv_policies_19_0 = null;

        EObject lv_assertions_23_0 = null;

        EObject lv_serviceBindings_25_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:267:28: ( (otherlv_0= 'bind-module' ( (lv_module_1_0= ruleModuleRef ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' ( (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ) | (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' ) ) ( (lv_endpointQualifierRef_11_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_12_0= ruleGovernanceDecision ) )* (otherlv_13= 'default-protocols' otherlv_14= '{' ( (lv_protocol_15_0= ruleBindingProtocol ) )+ otherlv_16= '}' )? (otherlv_17= 'default-policies' otherlv_18= '{' ( (lv_policies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'default-assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )? ( (lv_serviceBindings_25_0= ruleServiceBinding ) )* otherlv_26= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:268:1: (otherlv_0= 'bind-module' ( (lv_module_1_0= ruleModuleRef ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' ( (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ) | (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' ) ) ( (lv_endpointQualifierRef_11_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_12_0= ruleGovernanceDecision ) )* (otherlv_13= 'default-protocols' otherlv_14= '{' ( (lv_protocol_15_0= ruleBindingProtocol ) )+ otherlv_16= '}' )? (otherlv_17= 'default-policies' otherlv_18= '{' ( (lv_policies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'default-assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )? ( (lv_serviceBindings_25_0= ruleServiceBinding ) )* otherlv_26= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:268:1: (otherlv_0= 'bind-module' ( (lv_module_1_0= ruleModuleRef ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' ( (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ) | (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' ) ) ( (lv_endpointQualifierRef_11_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_12_0= ruleGovernanceDecision ) )* (otherlv_13= 'default-protocols' otherlv_14= '{' ( (lv_protocol_15_0= ruleBindingProtocol ) )+ otherlv_16= '}' )? (otherlv_17= 'default-policies' otherlv_18= '{' ( (lv_policies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'default-assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )? ( (lv_serviceBindings_25_0= ruleServiceBinding ) )* otherlv_26= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:268:3: otherlv_0= 'bind-module' ( (lv_module_1_0= ruleModuleRef ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' ( (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ) | (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' ) ) ( (lv_endpointQualifierRef_11_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_12_0= ruleGovernanceDecision ) )* (otherlv_13= 'default-protocols' otherlv_14= '{' ( (lv_protocol_15_0= ruleBindingProtocol ) )+ otherlv_16= '}' )? (otherlv_17= 'default-policies' otherlv_18= '{' ( (lv_policies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'default-assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )? ( (lv_serviceBindings_25_0= ruleServiceBinding ) )* otherlv_26= '}'
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModuleBinding550); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getModuleBindingAccess().getBindModuleKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:272:1: ( (lv_module_1_0= ruleModuleRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:273:1: (lv_module_1_0= ruleModuleRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:273:1: (lv_module_1_0= ruleModuleRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:274:3: lv_module_1_0= ruleModuleRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModuleBindingAccess().getModuleModuleRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleModuleRef_in_ruleModuleBinding571);
            lv_module_1_0=ruleModuleRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getModuleBindingRule());
              	        }
                     		set(
                     			current, 
                     			"module",
                      		lv_module_1_0, 
                      		"ModuleRef");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModuleBinding583); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getModuleBindingAccess().getAsKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:294:1: ( (lv_name_3_0= ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:295:1: (lv_name_3_0= ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:295:1: (lv_name_3_0= ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:296:3: lv_name_3_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModuleBindingAccess().getNameQualifiedNameParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModuleBinding604);
            lv_name_3_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getModuleBindingRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_3_0, 
                      		"QualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModuleBinding616); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getModuleBindingAccess().getToKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:316:1: ( (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ) | (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            else if ( (LA5_0==18) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:316:2: (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:316:2: (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:316:4: otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{'
                    {
                    otherlv_5=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModuleBinding630); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getModuleBindingAccess().getEnvironmentKeyword_5_0_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:320:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:321:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:321:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:322:3: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getModuleBindingRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getEnvironmentEnvironmentCrossReference_5_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModuleBinding657);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModuleBinding669); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getModuleBindingAccess().getLeftCurlyBracketKeyword_5_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:343:6: (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:343:6: (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:343:8: otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{'
                    {
                    otherlv_8=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModuleBinding689); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getModuleBindingAccess().getServerKeyword_5_1_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:347:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:348:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:348:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:349:3: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getModuleBindingRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getProvServerServerCrossReference_5_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModuleBinding716);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_10=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModuleBinding728); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getModuleBindingAccess().getLeftCurlyBracketKeyword_5_1_2());
                          
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:369:3: ( (lv_endpointQualifierRef_11_0= ruleEndpointQualifierRef ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==100) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:370:1: (lv_endpointQualifierRef_11_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:370:1: (lv_endpointQualifierRef_11_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:371:3: lv_endpointQualifierRef_11_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleModuleBinding751);
                    lv_endpointQualifierRef_11_0=ruleEndpointQualifierRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModuleBindingRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRef",
                              		lv_endpointQualifierRef_11_0, 
                              		"EndpointQualifierRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:387:3: ( (lv_governanceDecisions_12_0= ruleGovernanceDecision ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==111) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:388:1: (lv_governanceDecisions_12_0= ruleGovernanceDecision )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:388:1: (lv_governanceDecisions_12_0= ruleGovernanceDecision )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:389:3: lv_governanceDecisions_12_0= ruleGovernanceDecision
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getGovernanceDecisionsGovernanceDecisionParserRuleCall_7_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleGovernanceDecision_in_ruleModuleBinding773);
            	    lv_governanceDecisions_12_0=ruleGovernanceDecision();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModuleBindingRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"governanceDecisions",
            	              		lv_governanceDecisions_12_0, 
            	              		"GovernanceDecision");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:405:3: (otherlv_13= 'default-protocols' otherlv_14= '{' ( (lv_protocol_15_0= ruleBindingProtocol ) )+ otherlv_16= '}' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:405:5: otherlv_13= 'default-protocols' otherlv_14= '{' ( (lv_protocol_15_0= ruleBindingProtocol ) )+ otherlv_16= '}'
                    {
                    otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleModuleBinding787); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getModuleBindingAccess().getDefaultProtocolsKeyword_8_0());
                          
                    }
                    otherlv_14=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModuleBinding799); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getModuleBindingAccess().getLeftCurlyBracketKeyword_8_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:413:1: ( (lv_protocol_15_0= ruleBindingProtocol ) )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==33||LA8_0==39||LA8_0==41||LA8_0==43||LA8_0==47||LA8_0==52||LA8_0==56||LA8_0==60||LA8_0==62||LA8_0==64||LA8_0==66) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:414:1: (lv_protocol_15_0= ruleBindingProtocol )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:414:1: (lv_protocol_15_0= ruleBindingProtocol )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:415:3: lv_protocol_15_0= ruleBindingProtocol
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getProtocolBindingProtocolParserRuleCall_8_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleModuleBinding820);
                    	    lv_protocol_15_0=ruleBindingProtocol();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getModuleBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"protocol",
                    	              		lv_protocol_15_0, 
                    	              		"BindingProtocol");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);

                    otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleModuleBinding833); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getModuleBindingAccess().getRightCurlyBracketKeyword_8_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:435:3: (otherlv_17= 'default-policies' otherlv_18= '{' ( (lv_policies_19_0= rulePolicy ) )* otherlv_20= '}' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:435:5: otherlv_17= 'default-policies' otherlv_18= '{' ( (lv_policies_19_0= rulePolicy ) )* otherlv_20= '}'
                    {
                    otherlv_17=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleModuleBinding848); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getModuleBindingAccess().getDefaultPoliciesKeyword_9_0());
                          
                    }
                    otherlv_18=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModuleBinding860); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getModuleBindingAccess().getLeftCurlyBracketKeyword_9_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:443:1: ( (lv_policies_19_0= rulePolicy ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>=68 && LA10_0<=69)||LA10_0==76||LA10_0==81) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:444:1: (lv_policies_19_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:444:1: (lv_policies_19_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:445:3: lv_policies_19_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getPoliciesPolicyParserRuleCall_9_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleModuleBinding881);
                    	    lv_policies_19_0=rulePolicy();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getModuleBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"policies",
                    	              		lv_policies_19_0, 
                    	              		"Policy");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleModuleBinding894); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getModuleBindingAccess().getRightCurlyBracketKeyword_9_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:465:3: (otherlv_21= 'default-assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==22) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:465:5: otherlv_21= 'default-assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}'
                    {
                    otherlv_21=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleModuleBinding909); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_21, grammarAccess.getModuleBindingAccess().getDefaultAssertionsKeyword_10_0());
                          
                    }
                    otherlv_22=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModuleBinding921); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_22, grammarAccess.getModuleBindingAccess().getLeftCurlyBracketKeyword_10_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:473:1: ( (lv_assertions_23_0= ruleAssertion ) )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==20) ) {
                            int LA12_1 = input.LA(2);

                            if ( (synpred13_InternalBindingDsl()) ) {
                                alt12=1;
                            }


                        }
                        else if ( ((LA12_0>=83 && LA12_0<=87)||LA12_0==90||(LA12_0>=92 && LA12_0<=93)||LA12_0==95||LA12_0==97) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:474:1: (lv_assertions_23_0= ruleAssertion )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:474:1: (lv_assertions_23_0= ruleAssertion )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:475:3: lv_assertions_23_0= ruleAssertion
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getAssertionsAssertionParserRuleCall_10_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssertion_in_ruleModuleBinding942);
                    	    lv_assertions_23_0=ruleAssertion();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getModuleBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"assertions",
                    	              		lv_assertions_23_0, 
                    	              		"Assertion");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    otherlv_24=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleModuleBinding955); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_24, grammarAccess.getModuleBindingAccess().getRightCurlyBracketKeyword_10_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:495:3: ( (lv_serviceBindings_25_0= ruleServiceBinding ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==23) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:496:1: (lv_serviceBindings_25_0= ruleServiceBinding )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:496:1: (lv_serviceBindings_25_0= ruleServiceBinding )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:497:3: lv_serviceBindings_25_0= ruleServiceBinding
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getServiceBindingsServiceBindingParserRuleCall_11_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceBinding_in_ruleModuleBinding978);
            	    lv_serviceBindings_25_0=ruleServiceBinding();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModuleBindingRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"serviceBindings",
            	              		lv_serviceBindings_25_0, 
            	              		"ServiceBinding");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_26=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleModuleBinding991); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_26, grammarAccess.getModuleBindingAccess().getRightCurlyBracketKeyword_12());
                  
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
    // $ANTLR end "ruleModuleBinding"


    // $ANTLR start "entryRuleModuleRef"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:525:1: entryRuleModuleRef returns [EObject current=null] : iv_ruleModuleRef= ruleModuleRef EOF ;
    public final EObject entryRuleModuleRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModuleRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:526:2: (iv_ruleModuleRef= ruleModuleRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:527:2: iv_ruleModuleRef= ruleModuleRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModuleRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModuleRef_in_entryRuleModuleRef1027);
            iv_ruleModuleRef=ruleModuleRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModuleRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModuleRef1037); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModuleRef"


    // $ANTLR start "ruleModuleRef"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:534:1: ruleModuleRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) ;
    public final EObject ruleModuleRef() throws RecognitionException {
        EObject current = null;

        EObject lv_versionRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:537:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:538:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:538:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:538:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:538:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:539:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:539:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:540:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getModuleRefRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModuleRefAccess().getModuleModuleCrossReference_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModuleRef1089);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:556:2: ( (lv_versionRef_1_0= ruleVersionRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:557:1: (lv_versionRef_1_0= ruleVersionRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:557:1: (lv_versionRef_1_0= ruleVersionRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:558:3: lv_versionRef_1_0= ruleVersionRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModuleRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleModuleRef1110);
            lv_versionRef_1_0=ruleVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getModuleRefRule());
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
    // $ANTLR end "ruleModuleRef"


    // $ANTLR start "entryRuleServiceBinding"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:582:1: entryRuleServiceBinding returns [EObject current=null] : iv_ruleServiceBinding= ruleServiceBinding EOF ;
    public final EObject entryRuleServiceBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceBinding = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:583:2: (iv_ruleServiceBinding= ruleServiceBinding EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:584:2: iv_ruleServiceBinding= ruleServiceBinding EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getServiceBindingRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceBinding_in_entryRuleServiceBinding1146);
            iv_ruleServiceBinding=ruleServiceBinding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleServiceBinding; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleServiceBinding1156); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceBinding"


    // $ANTLR start "ruleServiceBinding"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:591:1: ruleServiceBinding returns [EObject current=null] : (otherlv_0= 'bind-service' ( (lv_service_1_0= ruleServiceRef ) ) (otherlv_2= 'to' ( (otherlv_3= 'environment' ( ( ruleQualifiedName ) ) ) | (otherlv_5= 'server' ( ( ruleQualifiedName ) ) ) ) )? otherlv_7= '{' ( (lv_endpointQualifierRef_8_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_9_0= ruleGovernanceDecision ) )* (otherlv_10= 'provided-contract' ( (lv_providedContract_11_0= RULE_STRING ) ) )? otherlv_12= 'protocols' otherlv_13= '{' ( (lv_protocol_14_0= ruleBindingProtocol ) )+ otherlv_15= '}' (otherlv_16= 'policies' otherlv_17= '{' ( (lv_policies_18_0= rulePolicy ) )* otherlv_19= '}' )? (otherlv_20= 'assertions' otherlv_21= '{' ( (lv_assertions_22_0= ruleAssertion ) )+ otherlv_23= '}' )? (otherlv_24= 'references-module' ( (lv_referencedModule_25_0= ruleModuleRef ) ) )? ( (lv_operation_26_0= ruleOperationBinding ) )* otherlv_27= '}' ) ;
    public final EObject ruleServiceBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        Token lv_providedContract_11_0=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_27=null;
        EObject lv_service_1_0 = null;

        EObject lv_endpointQualifierRef_8_0 = null;

        EObject lv_governanceDecisions_9_0 = null;

        EObject lv_protocol_14_0 = null;

        EObject lv_policies_18_0 = null;

        EObject lv_assertions_22_0 = null;

        EObject lv_referencedModule_25_0 = null;

        EObject lv_operation_26_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:594:28: ( (otherlv_0= 'bind-service' ( (lv_service_1_0= ruleServiceRef ) ) (otherlv_2= 'to' ( (otherlv_3= 'environment' ( ( ruleQualifiedName ) ) ) | (otherlv_5= 'server' ( ( ruleQualifiedName ) ) ) ) )? otherlv_7= '{' ( (lv_endpointQualifierRef_8_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_9_0= ruleGovernanceDecision ) )* (otherlv_10= 'provided-contract' ( (lv_providedContract_11_0= RULE_STRING ) ) )? otherlv_12= 'protocols' otherlv_13= '{' ( (lv_protocol_14_0= ruleBindingProtocol ) )+ otherlv_15= '}' (otherlv_16= 'policies' otherlv_17= '{' ( (lv_policies_18_0= rulePolicy ) )* otherlv_19= '}' )? (otherlv_20= 'assertions' otherlv_21= '{' ( (lv_assertions_22_0= ruleAssertion ) )+ otherlv_23= '}' )? (otherlv_24= 'references-module' ( (lv_referencedModule_25_0= ruleModuleRef ) ) )? ( (lv_operation_26_0= ruleOperationBinding ) )* otherlv_27= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:595:1: (otherlv_0= 'bind-service' ( (lv_service_1_0= ruleServiceRef ) ) (otherlv_2= 'to' ( (otherlv_3= 'environment' ( ( ruleQualifiedName ) ) ) | (otherlv_5= 'server' ( ( ruleQualifiedName ) ) ) ) )? otherlv_7= '{' ( (lv_endpointQualifierRef_8_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_9_0= ruleGovernanceDecision ) )* (otherlv_10= 'provided-contract' ( (lv_providedContract_11_0= RULE_STRING ) ) )? otherlv_12= 'protocols' otherlv_13= '{' ( (lv_protocol_14_0= ruleBindingProtocol ) )+ otherlv_15= '}' (otherlv_16= 'policies' otherlv_17= '{' ( (lv_policies_18_0= rulePolicy ) )* otherlv_19= '}' )? (otherlv_20= 'assertions' otherlv_21= '{' ( (lv_assertions_22_0= ruleAssertion ) )+ otherlv_23= '}' )? (otherlv_24= 'references-module' ( (lv_referencedModule_25_0= ruleModuleRef ) ) )? ( (lv_operation_26_0= ruleOperationBinding ) )* otherlv_27= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:595:1: (otherlv_0= 'bind-service' ( (lv_service_1_0= ruleServiceRef ) ) (otherlv_2= 'to' ( (otherlv_3= 'environment' ( ( ruleQualifiedName ) ) ) | (otherlv_5= 'server' ( ( ruleQualifiedName ) ) ) ) )? otherlv_7= '{' ( (lv_endpointQualifierRef_8_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_9_0= ruleGovernanceDecision ) )* (otherlv_10= 'provided-contract' ( (lv_providedContract_11_0= RULE_STRING ) ) )? otherlv_12= 'protocols' otherlv_13= '{' ( (lv_protocol_14_0= ruleBindingProtocol ) )+ otherlv_15= '}' (otherlv_16= 'policies' otherlv_17= '{' ( (lv_policies_18_0= rulePolicy ) )* otherlv_19= '}' )? (otherlv_20= 'assertions' otherlv_21= '{' ( (lv_assertions_22_0= ruleAssertion ) )+ otherlv_23= '}' )? (otherlv_24= 'references-module' ( (lv_referencedModule_25_0= ruleModuleRef ) ) )? ( (lv_operation_26_0= ruleOperationBinding ) )* otherlv_27= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:595:3: otherlv_0= 'bind-service' ( (lv_service_1_0= ruleServiceRef ) ) (otherlv_2= 'to' ( (otherlv_3= 'environment' ( ( ruleQualifiedName ) ) ) | (otherlv_5= 'server' ( ( ruleQualifiedName ) ) ) ) )? otherlv_7= '{' ( (lv_endpointQualifierRef_8_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_9_0= ruleGovernanceDecision ) )* (otherlv_10= 'provided-contract' ( (lv_providedContract_11_0= RULE_STRING ) ) )? otherlv_12= 'protocols' otherlv_13= '{' ( (lv_protocol_14_0= ruleBindingProtocol ) )+ otherlv_15= '}' (otherlv_16= 'policies' otherlv_17= '{' ( (lv_policies_18_0= rulePolicy ) )* otherlv_19= '}' )? (otherlv_20= 'assertions' otherlv_21= '{' ( (lv_assertions_22_0= ruleAssertion ) )+ otherlv_23= '}' )? (otherlv_24= 'references-module' ( (lv_referencedModule_25_0= ruleModuleRef ) ) )? ( (lv_operation_26_0= ruleOperationBinding ) )* otherlv_27= '}'
            {
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleServiceBinding1193); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getServiceBindingAccess().getBindServiceKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:599:1: ( (lv_service_1_0= ruleServiceRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:600:1: (lv_service_1_0= ruleServiceRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:600:1: (lv_service_1_0= ruleServiceRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:601:3: lv_service_1_0= ruleServiceRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getServiceBindingAccess().getServiceServiceRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleServiceBinding1214);
            lv_service_1_0=ruleServiceRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getServiceBindingRule());
              	        }
                     		set(
                     			current, 
                     			"service",
                      		lv_service_1_0, 
                      		"ServiceRef");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:617:2: (otherlv_2= 'to' ( (otherlv_3= 'environment' ( ( ruleQualifiedName ) ) ) | (otherlv_5= 'server' ( ( ruleQualifiedName ) ) ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==15) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:617:4: otherlv_2= 'to' ( (otherlv_3= 'environment' ( ( ruleQualifiedName ) ) ) | (otherlv_5= 'server' ( ( ruleQualifiedName ) ) ) )
                    {
                    otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleServiceBinding1227); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getServiceBindingAccess().getToKeyword_2_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:621:1: ( (otherlv_3= 'environment' ( ( ruleQualifiedName ) ) ) | (otherlv_5= 'server' ( ( ruleQualifiedName ) ) ) )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==16) ) {
                        alt15=1;
                    }
                    else if ( (LA15_0==18) ) {
                        alt15=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:621:2: (otherlv_3= 'environment' ( ( ruleQualifiedName ) ) )
                            {
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:621:2: (otherlv_3= 'environment' ( ( ruleQualifiedName ) ) )
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:621:4: otherlv_3= 'environment' ( ( ruleQualifiedName ) )
                            {
                            otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleServiceBinding1241); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getServiceBindingAccess().getEnvironmentKeyword_2_1_0_0());
                                  
                            }
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:625:1: ( ( ruleQualifiedName ) )
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:626:1: ( ruleQualifiedName )
                            {
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:626:1: ( ruleQualifiedName )
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:627:3: ruleQualifiedName
                            {
                            if ( state.backtracking==0 ) {
                               
                              		  /* */ 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getServiceBindingRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getServiceBindingAccess().getEnvironmentEnvironmentCrossReference_2_1_0_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleServiceBinding1268);
                            ruleQualifiedName();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:644:6: (otherlv_5= 'server' ( ( ruleQualifiedName ) ) )
                            {
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:644:6: (otherlv_5= 'server' ( ( ruleQualifiedName ) ) )
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:644:8: otherlv_5= 'server' ( ( ruleQualifiedName ) )
                            {
                            otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleServiceBinding1288); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getServiceBindingAccess().getServerKeyword_2_1_1_0());
                                  
                            }
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:648:1: ( ( ruleQualifiedName ) )
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:649:1: ( ruleQualifiedName )
                            {
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:649:1: ( ruleQualifiedName )
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:650:3: ruleQualifiedName
                            {
                            if ( state.backtracking==0 ) {
                               
                              		  /* */ 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getServiceBindingRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getServiceBindingAccess().getProvServerServerCrossReference_2_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleServiceBinding1315);
                            ruleQualifiedName();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleServiceBinding1331); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:670:1: ( (lv_endpointQualifierRef_8_0= ruleEndpointQualifierRef ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==100) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:671:1: (lv_endpointQualifierRef_8_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:671:1: (lv_endpointQualifierRef_8_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:672:3: lv_endpointQualifierRef_8_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleServiceBinding1352);
                    lv_endpointQualifierRef_8_0=ruleEndpointQualifierRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getServiceBindingRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRef",
                              		lv_endpointQualifierRef_8_0, 
                              		"EndpointQualifierRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:688:3: ( (lv_governanceDecisions_9_0= ruleGovernanceDecision ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==111) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:689:1: (lv_governanceDecisions_9_0= ruleGovernanceDecision )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:689:1: (lv_governanceDecisions_9_0= ruleGovernanceDecision )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:690:3: lv_governanceDecisions_9_0= ruleGovernanceDecision
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getGovernanceDecisionsGovernanceDecisionParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleGovernanceDecision_in_ruleServiceBinding1374);
            	    lv_governanceDecisions_9_0=ruleGovernanceDecision();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getServiceBindingRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"governanceDecisions",
            	              		lv_governanceDecisions_9_0, 
            	              		"GovernanceDecision");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:706:3: (otherlv_10= 'provided-contract' ( (lv_providedContract_11_0= RULE_STRING ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==24) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:706:5: otherlv_10= 'provided-contract' ( (lv_providedContract_11_0= RULE_STRING ) )
                    {
                    otherlv_10=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleServiceBinding1388); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getServiceBindingAccess().getProvidedContractKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:710:1: ( (lv_providedContract_11_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:711:1: (lv_providedContract_11_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:711:1: (lv_providedContract_11_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:712:3: lv_providedContract_11_0= RULE_STRING
                    {
                    lv_providedContract_11_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleServiceBinding1405); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_providedContract_11_0, grammarAccess.getServiceBindingAccess().getProvidedContractSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getServiceBindingRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"providedContract",
                              		lv_providedContract_11_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleServiceBinding1424); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getServiceBindingAccess().getProtocolsKeyword_7());
                  
            }
            otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleServiceBinding1436); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_8());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:736:1: ( (lv_protocol_14_0= ruleBindingProtocol ) )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==33||LA20_0==39||LA20_0==41||LA20_0==43||LA20_0==47||LA20_0==52||LA20_0==56||LA20_0==60||LA20_0==62||LA20_0==64||LA20_0==66) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:737:1: (lv_protocol_14_0= ruleBindingProtocol )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:737:1: (lv_protocol_14_0= ruleBindingProtocol )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:738:3: lv_protocol_14_0= ruleBindingProtocol
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getProtocolBindingProtocolParserRuleCall_9_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleServiceBinding1457);
            	    lv_protocol_14_0=ruleBindingProtocol();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getServiceBindingRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"protocol",
            	              		lv_protocol_14_0, 
            	              		"BindingProtocol");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);

            otherlv_15=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleServiceBinding1470); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getServiceBindingAccess().getRightCurlyBracketKeyword_10());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:758:1: (otherlv_16= 'policies' otherlv_17= '{' ( (lv_policies_18_0= rulePolicy ) )* otherlv_19= '}' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==26) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:758:3: otherlv_16= 'policies' otherlv_17= '{' ( (lv_policies_18_0= rulePolicy ) )* otherlv_19= '}'
                    {
                    otherlv_16=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleServiceBinding1483); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getServiceBindingAccess().getPoliciesKeyword_11_0());
                          
                    }
                    otherlv_17=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleServiceBinding1495); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_11_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:766:1: ( (lv_policies_18_0= rulePolicy ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( ((LA21_0>=68 && LA21_0<=69)||LA21_0==76||LA21_0==81) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:767:1: (lv_policies_18_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:767:1: (lv_policies_18_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:768:3: lv_policies_18_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getPoliciesPolicyParserRuleCall_11_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleServiceBinding1516);
                    	    lv_policies_18_0=rulePolicy();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getServiceBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"policies",
                    	              		lv_policies_18_0, 
                    	              		"Policy");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    otherlv_19=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleServiceBinding1529); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getServiceBindingAccess().getRightCurlyBracketKeyword_11_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:788:3: (otherlv_20= 'assertions' otherlv_21= '{' ( (lv_assertions_22_0= ruleAssertion ) )+ otherlv_23= '}' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==27) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:788:5: otherlv_20= 'assertions' otherlv_21= '{' ( (lv_assertions_22_0= ruleAssertion ) )+ otherlv_23= '}'
                    {
                    otherlv_20=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleServiceBinding1544); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getServiceBindingAccess().getAssertionsKeyword_12_0());
                          
                    }
                    otherlv_21=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleServiceBinding1556); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_21, grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_12_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:796:1: ( (lv_assertions_22_0= ruleAssertion ) )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==20) ) {
                            int LA23_1 = input.LA(2);

                            if ( (synpred24_InternalBindingDsl()) ) {
                                alt23=1;
                            }


                        }
                        else if ( ((LA23_0>=83 && LA23_0<=87)||LA23_0==90||(LA23_0>=92 && LA23_0<=93)||LA23_0==95||LA23_0==97) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:797:1: (lv_assertions_22_0= ruleAssertion )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:797:1: (lv_assertions_22_0= ruleAssertion )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:798:3: lv_assertions_22_0= ruleAssertion
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getAssertionsAssertionParserRuleCall_12_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssertion_in_ruleServiceBinding1577);
                    	    lv_assertions_22_0=ruleAssertion();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getServiceBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"assertions",
                    	              		lv_assertions_22_0, 
                    	              		"Assertion");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt23 >= 1 ) break loop23;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(23, input);
                                throw eee;
                        }
                        cnt23++;
                    } while (true);

                    otherlv_23=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleServiceBinding1590); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_23, grammarAccess.getServiceBindingAccess().getRightCurlyBracketKeyword_12_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:818:3: (otherlv_24= 'references-module' ( (lv_referencedModule_25_0= ruleModuleRef ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==28) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:818:5: otherlv_24= 'references-module' ( (lv_referencedModule_25_0= ruleModuleRef ) )
                    {
                    otherlv_24=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleServiceBinding1605); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_24, grammarAccess.getServiceBindingAccess().getReferencesModuleKeyword_13_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:822:1: ( (lv_referencedModule_25_0= ruleModuleRef ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:823:1: (lv_referencedModule_25_0= ruleModuleRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:823:1: (lv_referencedModule_25_0= ruleModuleRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:824:3: lv_referencedModule_25_0= ruleModuleRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getReferencedModuleModuleRefParserRuleCall_13_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleModuleRef_in_ruleServiceBinding1626);
                    lv_referencedModule_25_0=ruleModuleRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getServiceBindingRule());
                      	        }
                             		set(
                             			current, 
                             			"referencedModule",
                              		lv_referencedModule_25_0, 
                              		"ModuleRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:840:4: ( (lv_operation_26_0= ruleOperationBinding ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==30) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:841:1: (lv_operation_26_0= ruleOperationBinding )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:841:1: (lv_operation_26_0= ruleOperationBinding )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:842:3: lv_operation_26_0= ruleOperationBinding
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getOperationOperationBindingParserRuleCall_14_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleOperationBinding_in_ruleServiceBinding1649);
            	    lv_operation_26_0=ruleOperationBinding();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getServiceBindingRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"operation",
            	              		lv_operation_26_0, 
            	              		"OperationBinding");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            otherlv_27=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleServiceBinding1662); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_27, grammarAccess.getServiceBindingAccess().getRightCurlyBracketKeyword_15());
                  
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
    // $ANTLR end "ruleServiceBinding"


    // $ANTLR start "entryRuleServiceRef"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:870:1: entryRuleServiceRef returns [EObject current=null] : iv_ruleServiceRef= ruleServiceRef EOF ;
    public final EObject entryRuleServiceRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:871:2: (iv_ruleServiceRef= ruleServiceRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:872:2: iv_ruleServiceRef= ruleServiceRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getServiceRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_entryRuleServiceRef1698);
            iv_ruleServiceRef=ruleServiceRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleServiceRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleServiceRef1708); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceRef"


    // $ANTLR start "ruleServiceRef"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:879:1: ruleServiceRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) ;
    public final EObject ruleServiceRef() throws RecognitionException {
        EObject current = null;

        EObject lv_versionRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:882:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:883:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:883:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:883:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:883:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:884:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:884:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:885:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getServiceRefRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getServiceRefAccess().getServiceServiceCrossReference_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleServiceRef1760);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:901:2: ( (lv_versionRef_1_0= ruleVersionRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:902:1: (lv_versionRef_1_0= ruleVersionRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:902:1: (lv_versionRef_1_0= ruleVersionRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:903:3: lv_versionRef_1_0= ruleVersionRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getServiceRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleServiceRef1781);
            lv_versionRef_1_0=ruleVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getServiceRefRule());
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
    // $ANTLR end "ruleServiceRef"


    // $ANTLR start "entryRuleChannelBinding"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:927:1: entryRuleChannelBinding returns [EObject current=null] : iv_ruleChannelBinding= ruleChannelBinding EOF ;
    public final EObject entryRuleChannelBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChannelBinding = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:928:2: (iv_ruleChannelBinding= ruleChannelBinding EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:929:2: iv_ruleChannelBinding= ruleChannelBinding EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getChannelBindingRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleChannelBinding_in_entryRuleChannelBinding1817);
            iv_ruleChannelBinding=ruleChannelBinding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleChannelBinding; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChannelBinding1827); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleChannelBinding"


    // $ANTLR start "ruleChannelBinding"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:936:1: ruleChannelBinding returns [EObject current=null] : (otherlv_0= 'bind-channel' ( ( ruleQualifiedName ) ) (otherlv_2= 'to' ( (otherlv_3= 'environment' ( ( ruleQualifiedName ) ) ) | (otherlv_5= 'server' ( ( ruleQualifiedName ) ) ) ) )? otherlv_7= '{' ( (lv_endpointQualifierRef_8_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_9_0= ruleGovernanceDecision ) )* otherlv_10= 'protocols' otherlv_11= '{' ( (lv_protocol_12_0= ruleBindingProtocol ) )+ otherlv_13= '}' (otherlv_14= 'policies' otherlv_15= '{' ( (lv_policies_16_0= rulePolicy ) )* otherlv_17= '}' )? (otherlv_18= 'assertions' otherlv_19= '{' ( (lv_assertions_20_0= ruleAssertion ) )+ otherlv_21= '}' )? (otherlv_22= 'references-module' ( (lv_referencedModule_23_0= ruleModuleRef ) ) )? otherlv_24= '}' ) ;
    public final EObject ruleChannelBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        EObject lv_endpointQualifierRef_8_0 = null;

        EObject lv_governanceDecisions_9_0 = null;

        EObject lv_protocol_12_0 = null;

        EObject lv_policies_16_0 = null;

        EObject lv_assertions_20_0 = null;

        EObject lv_referencedModule_23_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:939:28: ( (otherlv_0= 'bind-channel' ( ( ruleQualifiedName ) ) (otherlv_2= 'to' ( (otherlv_3= 'environment' ( ( ruleQualifiedName ) ) ) | (otherlv_5= 'server' ( ( ruleQualifiedName ) ) ) ) )? otherlv_7= '{' ( (lv_endpointQualifierRef_8_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_9_0= ruleGovernanceDecision ) )* otherlv_10= 'protocols' otherlv_11= '{' ( (lv_protocol_12_0= ruleBindingProtocol ) )+ otherlv_13= '}' (otherlv_14= 'policies' otherlv_15= '{' ( (lv_policies_16_0= rulePolicy ) )* otherlv_17= '}' )? (otherlv_18= 'assertions' otherlv_19= '{' ( (lv_assertions_20_0= ruleAssertion ) )+ otherlv_21= '}' )? (otherlv_22= 'references-module' ( (lv_referencedModule_23_0= ruleModuleRef ) ) )? otherlv_24= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:940:1: (otherlv_0= 'bind-channel' ( ( ruleQualifiedName ) ) (otherlv_2= 'to' ( (otherlv_3= 'environment' ( ( ruleQualifiedName ) ) ) | (otherlv_5= 'server' ( ( ruleQualifiedName ) ) ) ) )? otherlv_7= '{' ( (lv_endpointQualifierRef_8_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_9_0= ruleGovernanceDecision ) )* otherlv_10= 'protocols' otherlv_11= '{' ( (lv_protocol_12_0= ruleBindingProtocol ) )+ otherlv_13= '}' (otherlv_14= 'policies' otherlv_15= '{' ( (lv_policies_16_0= rulePolicy ) )* otherlv_17= '}' )? (otherlv_18= 'assertions' otherlv_19= '{' ( (lv_assertions_20_0= ruleAssertion ) )+ otherlv_21= '}' )? (otherlv_22= 'references-module' ( (lv_referencedModule_23_0= ruleModuleRef ) ) )? otherlv_24= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:940:1: (otherlv_0= 'bind-channel' ( ( ruleQualifiedName ) ) (otherlv_2= 'to' ( (otherlv_3= 'environment' ( ( ruleQualifiedName ) ) ) | (otherlv_5= 'server' ( ( ruleQualifiedName ) ) ) ) )? otherlv_7= '{' ( (lv_endpointQualifierRef_8_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_9_0= ruleGovernanceDecision ) )* otherlv_10= 'protocols' otherlv_11= '{' ( (lv_protocol_12_0= ruleBindingProtocol ) )+ otherlv_13= '}' (otherlv_14= 'policies' otherlv_15= '{' ( (lv_policies_16_0= rulePolicy ) )* otherlv_17= '}' )? (otherlv_18= 'assertions' otherlv_19= '{' ( (lv_assertions_20_0= ruleAssertion ) )+ otherlv_21= '}' )? (otherlv_22= 'references-module' ( (lv_referencedModule_23_0= ruleModuleRef ) ) )? otherlv_24= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:940:3: otherlv_0= 'bind-channel' ( ( ruleQualifiedName ) ) (otherlv_2= 'to' ( (otherlv_3= 'environment' ( ( ruleQualifiedName ) ) ) | (otherlv_5= 'server' ( ( ruleQualifiedName ) ) ) ) )? otherlv_7= '{' ( (lv_endpointQualifierRef_8_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_9_0= ruleGovernanceDecision ) )* otherlv_10= 'protocols' otherlv_11= '{' ( (lv_protocol_12_0= ruleBindingProtocol ) )+ otherlv_13= '}' (otherlv_14= 'policies' otherlv_15= '{' ( (lv_policies_16_0= rulePolicy ) )* otherlv_17= '}' )? (otherlv_18= 'assertions' otherlv_19= '{' ( (lv_assertions_20_0= ruleAssertion ) )+ otherlv_21= '}' )? (otherlv_22= 'references-module' ( (lv_referencedModule_23_0= ruleModuleRef ) ) )? otherlv_24= '}'
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleChannelBinding1864); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getChannelBindingAccess().getBindChannelKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:944:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:945:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:945:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:946:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getChannelBindingRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getChannelBindingAccess().getChannelChannelCrossReference_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleChannelBinding1891);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:962:2: (otherlv_2= 'to' ( (otherlv_3= 'environment' ( ( ruleQualifiedName ) ) ) | (otherlv_5= 'server' ( ( ruleQualifiedName ) ) ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==15) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:962:4: otherlv_2= 'to' ( (otherlv_3= 'environment' ( ( ruleQualifiedName ) ) ) | (otherlv_5= 'server' ( ( ruleQualifiedName ) ) ) )
                    {
                    otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleChannelBinding1904); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getChannelBindingAccess().getToKeyword_2_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:966:1: ( (otherlv_3= 'environment' ( ( ruleQualifiedName ) ) ) | (otherlv_5= 'server' ( ( ruleQualifiedName ) ) ) )
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==16) ) {
                        alt27=1;
                    }
                    else if ( (LA27_0==18) ) {
                        alt27=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 27, 0, input);

                        throw nvae;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:966:2: (otherlv_3= 'environment' ( ( ruleQualifiedName ) ) )
                            {
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:966:2: (otherlv_3= 'environment' ( ( ruleQualifiedName ) ) )
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:966:4: otherlv_3= 'environment' ( ( ruleQualifiedName ) )
                            {
                            otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleChannelBinding1918); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getChannelBindingAccess().getEnvironmentKeyword_2_1_0_0());
                                  
                            }
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:970:1: ( ( ruleQualifiedName ) )
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:971:1: ( ruleQualifiedName )
                            {
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:971:1: ( ruleQualifiedName )
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:972:3: ruleQualifiedName
                            {
                            if ( state.backtracking==0 ) {
                               
                              		  /* */ 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getChannelBindingRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getChannelBindingAccess().getEnvironmentEnvironmentCrossReference_2_1_0_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleChannelBinding1945);
                            ruleQualifiedName();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:989:6: (otherlv_5= 'server' ( ( ruleQualifiedName ) ) )
                            {
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:989:6: (otherlv_5= 'server' ( ( ruleQualifiedName ) ) )
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:989:8: otherlv_5= 'server' ( ( ruleQualifiedName ) )
                            {
                            otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleChannelBinding1965); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getChannelBindingAccess().getServerKeyword_2_1_1_0());
                                  
                            }
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:993:1: ( ( ruleQualifiedName ) )
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:994:1: ( ruleQualifiedName )
                            {
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:994:1: ( ruleQualifiedName )
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:995:3: ruleQualifiedName
                            {
                            if ( state.backtracking==0 ) {
                               
                              		  /* */ 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getChannelBindingRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getChannelBindingAccess().getProvServerServerCrossReference_2_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleChannelBinding1992);
                            ruleQualifiedName();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleChannelBinding2008); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getChannelBindingAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1015:1: ( (lv_endpointQualifierRef_8_0= ruleEndpointQualifierRef ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==100) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1016:1: (lv_endpointQualifierRef_8_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1016:1: (lv_endpointQualifierRef_8_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1017:3: lv_endpointQualifierRef_8_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getChannelBindingAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleChannelBinding2029);
                    lv_endpointQualifierRef_8_0=ruleEndpointQualifierRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getChannelBindingRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRef",
                              		lv_endpointQualifierRef_8_0, 
                              		"EndpointQualifierRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1033:3: ( (lv_governanceDecisions_9_0= ruleGovernanceDecision ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==111) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1034:1: (lv_governanceDecisions_9_0= ruleGovernanceDecision )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1034:1: (lv_governanceDecisions_9_0= ruleGovernanceDecision )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1035:3: lv_governanceDecisions_9_0= ruleGovernanceDecision
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getChannelBindingAccess().getGovernanceDecisionsGovernanceDecisionParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleGovernanceDecision_in_ruleChannelBinding2051);
            	    lv_governanceDecisions_9_0=ruleGovernanceDecision();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getChannelBindingRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"governanceDecisions",
            	              		lv_governanceDecisions_9_0, 
            	              		"GovernanceDecision");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            otherlv_10=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleChannelBinding2064); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getChannelBindingAccess().getProtocolsKeyword_6());
                  
            }
            otherlv_11=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleChannelBinding2076); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getChannelBindingAccess().getLeftCurlyBracketKeyword_7());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1059:1: ( (lv_protocol_12_0= ruleBindingProtocol ) )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==33||LA31_0==39||LA31_0==41||LA31_0==43||LA31_0==47||LA31_0==52||LA31_0==56||LA31_0==60||LA31_0==62||LA31_0==64||LA31_0==66) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1060:1: (lv_protocol_12_0= ruleBindingProtocol )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1060:1: (lv_protocol_12_0= ruleBindingProtocol )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1061:3: lv_protocol_12_0= ruleBindingProtocol
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getChannelBindingAccess().getProtocolBindingProtocolParserRuleCall_8_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleChannelBinding2097);
            	    lv_protocol_12_0=ruleBindingProtocol();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getChannelBindingRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"protocol",
            	              		lv_protocol_12_0, 
            	              		"BindingProtocol");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);

            otherlv_13=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleChannelBinding2110); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getChannelBindingAccess().getRightCurlyBracketKeyword_9());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1081:1: (otherlv_14= 'policies' otherlv_15= '{' ( (lv_policies_16_0= rulePolicy ) )* otherlv_17= '}' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==26) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1081:3: otherlv_14= 'policies' otherlv_15= '{' ( (lv_policies_16_0= rulePolicy ) )* otherlv_17= '}'
                    {
                    otherlv_14=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleChannelBinding2123); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getChannelBindingAccess().getPoliciesKeyword_10_0());
                          
                    }
                    otherlv_15=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleChannelBinding2135); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getChannelBindingAccess().getLeftCurlyBracketKeyword_10_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1089:1: ( (lv_policies_16_0= rulePolicy ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( ((LA32_0>=68 && LA32_0<=69)||LA32_0==76||LA32_0==81) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1090:1: (lv_policies_16_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1090:1: (lv_policies_16_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1091:3: lv_policies_16_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getChannelBindingAccess().getPoliciesPolicyParserRuleCall_10_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleChannelBinding2156);
                    	    lv_policies_16_0=rulePolicy();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getChannelBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"policies",
                    	              		lv_policies_16_0, 
                    	              		"Policy");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);

                    otherlv_17=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleChannelBinding2169); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getChannelBindingAccess().getRightCurlyBracketKeyword_10_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1111:3: (otherlv_18= 'assertions' otherlv_19= '{' ( (lv_assertions_20_0= ruleAssertion ) )+ otherlv_21= '}' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==27) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1111:5: otherlv_18= 'assertions' otherlv_19= '{' ( (lv_assertions_20_0= ruleAssertion ) )+ otherlv_21= '}'
                    {
                    otherlv_18=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleChannelBinding2184); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getChannelBindingAccess().getAssertionsKeyword_11_0());
                          
                    }
                    otherlv_19=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleChannelBinding2196); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getChannelBindingAccess().getLeftCurlyBracketKeyword_11_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1119:1: ( (lv_assertions_20_0= ruleAssertion ) )+
                    int cnt34=0;
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==20) ) {
                            int LA34_1 = input.LA(2);

                            if ( (synpred35_InternalBindingDsl()) ) {
                                alt34=1;
                            }


                        }
                        else if ( ((LA34_0>=83 && LA34_0<=87)||LA34_0==90||(LA34_0>=92 && LA34_0<=93)||LA34_0==95||LA34_0==97) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1120:1: (lv_assertions_20_0= ruleAssertion )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1120:1: (lv_assertions_20_0= ruleAssertion )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1121:3: lv_assertions_20_0= ruleAssertion
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getChannelBindingAccess().getAssertionsAssertionParserRuleCall_11_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssertion_in_ruleChannelBinding2217);
                    	    lv_assertions_20_0=ruleAssertion();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getChannelBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"assertions",
                    	              		lv_assertions_20_0, 
                    	              		"Assertion");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt34 >= 1 ) break loop34;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(34, input);
                                throw eee;
                        }
                        cnt34++;
                    } while (true);

                    otherlv_21=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleChannelBinding2230); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_21, grammarAccess.getChannelBindingAccess().getRightCurlyBracketKeyword_11_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1141:3: (otherlv_22= 'references-module' ( (lv_referencedModule_23_0= ruleModuleRef ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==28) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1141:5: otherlv_22= 'references-module' ( (lv_referencedModule_23_0= ruleModuleRef ) )
                    {
                    otherlv_22=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleChannelBinding2245); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_22, grammarAccess.getChannelBindingAccess().getReferencesModuleKeyword_12_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1145:1: ( (lv_referencedModule_23_0= ruleModuleRef ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1146:1: (lv_referencedModule_23_0= ruleModuleRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1146:1: (lv_referencedModule_23_0= ruleModuleRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1147:3: lv_referencedModule_23_0= ruleModuleRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getChannelBindingAccess().getReferencedModuleModuleRefParserRuleCall_12_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleModuleRef_in_ruleChannelBinding2266);
                    lv_referencedModule_23_0=ruleModuleRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getChannelBindingRule());
                      	        }
                             		set(
                             			current, 
                             			"referencedModule",
                              		lv_referencedModule_23_0, 
                              		"ModuleRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_24=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleChannelBinding2280); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_24, grammarAccess.getChannelBindingAccess().getRightCurlyBracketKeyword_13());
                  
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
    // $ANTLR end "ruleChannelBinding"


    // $ANTLR start "entryRuleBindingProtocol"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1175:1: entryRuleBindingProtocol returns [EObject current=null] : iv_ruleBindingProtocol= ruleBindingProtocol EOF ;
    public final EObject entryRuleBindingProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBindingProtocol = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1176:2: (iv_ruleBindingProtocol= ruleBindingProtocol EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1177:2: iv_ruleBindingProtocol= ruleBindingProtocol EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBindingProtocolRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_entryRuleBindingProtocol2316);
            iv_ruleBindingProtocol=ruleBindingProtocol();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBindingProtocol; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBindingProtocol2326); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBindingProtocol"


    // $ANTLR start "ruleBindingProtocol"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1184:1: ruleBindingProtocol returns [EObject current=null] : (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP | this_IIOP_9= ruleIIOP | this_AMQP_10= ruleAMQP ) ;
    public final EObject ruleBindingProtocol() throws RecognitionException {
        EObject current = null;

        EObject this_SCA_0 = null;

        EObject this_SOAP_1 = null;

        EObject this_EJB_2 = null;

        EObject this_HTTP_3 = null;

        EObject this_REST_4 = null;

        EObject this_SAP_5 = null;

        EObject this_JMS_6 = null;

        EObject this_FILE_7 = null;

        EObject this_FTP_8 = null;

        EObject this_IIOP_9 = null;

        EObject this_AMQP_10 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1187:28: ( (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP | this_IIOP_9= ruleIIOP | this_AMQP_10= ruleAMQP ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1188:1: (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP | this_IIOP_9= ruleIIOP | this_AMQP_10= ruleAMQP )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1188:1: (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP | this_IIOP_9= ruleIIOP | this_AMQP_10= ruleAMQP )
            int alt37=11;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt37=1;
                }
                break;
            case 33:
                {
                alt37=2;
                }
                break;
            case 41:
                {
                alt37=3;
                }
                break;
            case 43:
                {
                alt37=4;
                }
                break;
            case 47:
                {
                alt37=5;
                }
                break;
            case 39:
                {
                alt37=6;
                }
                break;
            case 52:
                {
                alt37=7;
                }
                break;
            case 60:
                {
                alt37=8;
                }
                break;
            case 62:
                {
                alt37=9;
                }
                break;
            case 64:
                {
                alt37=10;
                }
                break;
            case 66:
                {
                alt37=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1189:2: this_SCA_0= ruleSCA
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getSCAParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSCA_in_ruleBindingProtocol2376);
                    this_SCA_0=ruleSCA();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SCA_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1202:2: this_SOAP_1= ruleSOAP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getSOAPParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSOAP_in_ruleBindingProtocol2406);
                    this_SOAP_1=ruleSOAP();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SOAP_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1215:2: this_EJB_2= ruleEJB
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getEJBParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEJB_in_ruleBindingProtocol2436);
                    this_EJB_2=ruleEJB();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_EJB_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1228:2: this_HTTP_3= ruleHTTP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getHTTPParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleHTTP_in_ruleBindingProtocol2466);
                    this_HTTP_3=ruleHTTP();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_HTTP_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1241:2: this_REST_4= ruleREST
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getRESTParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleREST_in_ruleBindingProtocol2496);
                    this_REST_4=ruleREST();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_REST_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1254:2: this_SAP_5= ruleSAP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getSAPParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSAP_in_ruleBindingProtocol2526);
                    this_SAP_5=ruleSAP();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SAP_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1267:2: this_JMS_6= ruleJMS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getJMSParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleJMS_in_ruleBindingProtocol2556);
                    this_JMS_6=ruleJMS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JMS_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1280:2: this_FILE_7= ruleFILE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getFILEParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFILE_in_ruleBindingProtocol2586);
                    this_FILE_7=ruleFILE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FILE_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1293:2: this_FTP_8= ruleFTP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getFTPParserRuleCall_8()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFTP_in_ruleBindingProtocol2616);
                    this_FTP_8=ruleFTP();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FTP_8; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1306:2: this_IIOP_9= ruleIIOP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getIIOPParserRuleCall_9()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIIOP_in_ruleBindingProtocol2646);
                    this_IIOP_9=ruleIIOP();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IIOP_9; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 11 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1319:2: this_AMQP_10= ruleAMQP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getAMQPParserRuleCall_10()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAMQP_in_ruleBindingProtocol2676);
                    this_AMQP_10=ruleAMQP();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AMQP_10; 
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
    // $ANTLR end "ruleBindingProtocol"


    // $ANTLR start "entryRuleOperationBinding"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1338:1: entryRuleOperationBinding returns [EObject current=null] : iv_ruleOperationBinding= ruleOperationBinding EOF ;
    public final EObject entryRuleOperationBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationBinding = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1339:2: (iv_ruleOperationBinding= ruleOperationBinding EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1340:2: iv_ruleOperationBinding= ruleOperationBinding EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationBindingRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOperationBinding_in_entryRuleOperationBinding2711);
            iv_ruleOperationBinding=ruleOperationBinding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperationBinding; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperationBinding2721); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperationBinding"


    // $ANTLR start "ruleOperationBinding"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1347:1: ruleOperationBinding returns [EObject current=null] : (otherlv_0= 'bind-operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* otherlv_5= 'protocols' otherlv_6= '{' ( (lv_protocol_7_0= ruleBindingProtocol ) )+ otherlv_8= '}' (otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )? (otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )? (otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )? otherlv_25= '}' ) ;
    public final EObject ruleOperationBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        EObject lv_endpointQualifierRef_3_0 = null;

        EObject lv_governanceDecisions_4_0 = null;

        EObject lv_protocol_7_0 = null;

        EObject lv_providerProtocol_11_0 = null;

        EObject lv_policies_15_0 = null;

        EObject lv_providerPolicies_19_0 = null;

        EObject lv_assertions_23_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1350:28: ( (otherlv_0= 'bind-operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* otherlv_5= 'protocols' otherlv_6= '{' ( (lv_protocol_7_0= ruleBindingProtocol ) )+ otherlv_8= '}' (otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )? (otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )? (otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )? otherlv_25= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1351:1: (otherlv_0= 'bind-operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* otherlv_5= 'protocols' otherlv_6= '{' ( (lv_protocol_7_0= ruleBindingProtocol ) )+ otherlv_8= '}' (otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )? (otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )? (otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )? otherlv_25= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1351:1: (otherlv_0= 'bind-operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* otherlv_5= 'protocols' otherlv_6= '{' ( (lv_protocol_7_0= ruleBindingProtocol ) )+ otherlv_8= '}' (otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )? (otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )? (otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )? otherlv_25= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1351:3: otherlv_0= 'bind-operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* otherlv_5= 'protocols' otherlv_6= '{' ( (lv_protocol_7_0= ruleBindingProtocol ) )+ otherlv_8= '}' (otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )? (otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )? (otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )? otherlv_25= '}'
            {
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleOperationBinding2758); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOperationBindingAccess().getBindOperationKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1355:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1356:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1356:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1357:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getOperationBindingRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getOperationBindingAccess().getOperationOperationCrossReference_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleOperationBinding2785);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleOperationBinding2797); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1377:1: ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==100) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1378:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1378:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1379:3: lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleOperationBinding2818);
                    lv_endpointQualifierRef_3_0=ruleEndpointQualifierRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOperationBindingRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRef",
                              		lv_endpointQualifierRef_3_0, 
                              		"EndpointQualifierRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1395:3: ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==111) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1396:1: (lv_governanceDecisions_4_0= ruleGovernanceDecision )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1396:1: (lv_governanceDecisions_4_0= ruleGovernanceDecision )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1397:3: lv_governanceDecisions_4_0= ruleGovernanceDecision
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getGovernanceDecisionsGovernanceDecisionParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleGovernanceDecision_in_ruleOperationBinding2840);
            	    lv_governanceDecisions_4_0=ruleGovernanceDecision();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOperationBindingRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"governanceDecisions",
            	              		lv_governanceDecisions_4_0, 
            	              		"GovernanceDecision");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            otherlv_5=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleOperationBinding2853); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getOperationBindingAccess().getProtocolsKeyword_5());
                  
            }
            otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleOperationBinding2865); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1421:1: ( (lv_protocol_7_0= ruleBindingProtocol ) )+
            int cnt40=0;
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==33||LA40_0==39||LA40_0==41||LA40_0==43||LA40_0==47||LA40_0==52||LA40_0==56||LA40_0==60||LA40_0==62||LA40_0==64||LA40_0==66) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1422:1: (lv_protocol_7_0= ruleBindingProtocol )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1422:1: (lv_protocol_7_0= ruleBindingProtocol )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1423:3: lv_protocol_7_0= ruleBindingProtocol
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getProtocolBindingProtocolParserRuleCall_7_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleOperationBinding2886);
            	    lv_protocol_7_0=ruleBindingProtocol();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOperationBindingRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"protocol",
            	              		lv_protocol_7_0, 
            	              		"BindingProtocol");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt40 >= 1 ) break loop40;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(40, input);
                        throw eee;
                }
                cnt40++;
            } while (true);

            otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleOperationBinding2899); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_8());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1443:1: (otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==31) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1443:3: otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}'
                    {
                    otherlv_9=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleOperationBinding2912); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getOperationBindingAccess().getProviderProtocolsKeyword_9_0());
                          
                    }
                    otherlv_10=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleOperationBinding2924); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_9_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1451:1: ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+
                    int cnt41=0;
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==33||LA41_0==39||LA41_0==41||LA41_0==43||LA41_0==47||LA41_0==52||LA41_0==56||LA41_0==60||LA41_0==62||LA41_0==64||LA41_0==66) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1452:1: (lv_providerProtocol_11_0= ruleBindingProtocol )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1452:1: (lv_providerProtocol_11_0= ruleBindingProtocol )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1453:3: lv_providerProtocol_11_0= ruleBindingProtocol
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getProviderProtocolBindingProtocolParserRuleCall_9_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleOperationBinding2945);
                    	    lv_providerProtocol_11_0=ruleBindingProtocol();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getOperationBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"providerProtocol",
                    	              		lv_providerProtocol_11_0, 
                    	              		"BindingProtocol");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt41 >= 1 ) break loop41;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(41, input);
                                throw eee;
                        }
                        cnt41++;
                    } while (true);

                    otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleOperationBinding2958); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_9_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1473:3: (otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==26) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1473:5: otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}'
                    {
                    otherlv_13=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleOperationBinding2973); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getOperationBindingAccess().getPoliciesKeyword_10_0());
                          
                    }
                    otherlv_14=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleOperationBinding2985); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_10_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1481:1: ( (lv_policies_15_0= rulePolicy ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( ((LA43_0>=68 && LA43_0<=69)||LA43_0==76||LA43_0==81) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1482:1: (lv_policies_15_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1482:1: (lv_policies_15_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1483:3: lv_policies_15_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getPoliciesPolicyParserRuleCall_10_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleOperationBinding3006);
                    	    lv_policies_15_0=rulePolicy();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getOperationBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"policies",
                    	              		lv_policies_15_0, 
                    	              		"Policy");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleOperationBinding3019); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_10_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1503:3: (otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==32) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1503:5: otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}'
                    {
                    otherlv_17=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleOperationBinding3034); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getOperationBindingAccess().getProviderPoliciesKeyword_11_0());
                          
                    }
                    otherlv_18=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleOperationBinding3046); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_11_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1511:1: ( (lv_providerPolicies_19_0= rulePolicy ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( ((LA45_0>=68 && LA45_0<=69)||LA45_0==76||LA45_0==81) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1512:1: (lv_providerPolicies_19_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1512:1: (lv_providerPolicies_19_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1513:3: lv_providerPolicies_19_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getProviderPoliciesPolicyParserRuleCall_11_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleOperationBinding3067);
                    	    lv_providerPolicies_19_0=rulePolicy();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getOperationBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"providerPolicies",
                    	              		lv_providerPolicies_19_0, 
                    	              		"Policy");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleOperationBinding3080); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_11_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1533:3: (otherlv_21= 'assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==27) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1533:5: otherlv_21= 'assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}'
                    {
                    otherlv_21=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleOperationBinding3095); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_21, grammarAccess.getOperationBindingAccess().getAssertionsKeyword_12_0());
                          
                    }
                    otherlv_22=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleOperationBinding3107); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_22, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_12_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1541:1: ( (lv_assertions_23_0= ruleAssertion ) )+
                    int cnt47=0;
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==20) ) {
                            int LA47_1 = input.LA(2);

                            if ( (synpred57_InternalBindingDsl()) ) {
                                alt47=1;
                            }


                        }
                        else if ( ((LA47_0>=83 && LA47_0<=87)||LA47_0==90||(LA47_0>=92 && LA47_0<=93)||LA47_0==95||LA47_0==97) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1542:1: (lv_assertions_23_0= ruleAssertion )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1542:1: (lv_assertions_23_0= ruleAssertion )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1543:3: lv_assertions_23_0= ruleAssertion
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getAssertionsAssertionParserRuleCall_12_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssertion_in_ruleOperationBinding3128);
                    	    lv_assertions_23_0=ruleAssertion();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getOperationBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"assertions",
                    	              		lv_assertions_23_0, 
                    	              		"Assertion");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt47 >= 1 ) break loop47;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(47, input);
                                throw eee;
                        }
                        cnt47++;
                    } while (true);

                    otherlv_24=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleOperationBinding3141); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_24, grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_12_3());
                          
                    }

                    }
                    break;

            }

            otherlv_25=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleOperationBinding3155); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_25, grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_13());
                  
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
    // $ANTLR end "ruleOperationBinding"


    // $ANTLR start "entryRuleSOAP"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1575:1: entryRuleSOAP returns [EObject current=null] : iv_ruleSOAP= ruleSOAP EOF ;
    public final EObject entryRuleSOAP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSOAP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1576:2: (iv_ruleSOAP= ruleSOAP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1577:2: iv_ruleSOAP= ruleSOAP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSOAPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSOAP_in_entryRuleSOAP3191);
            iv_ruleSOAP=ruleSOAP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSOAP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSOAP3201); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSOAP"


    // $ANTLR start "ruleSOAP"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1584:1: ruleSOAP returns [EObject current=null] : (otherlv_0= 'SOAP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )? (otherlv_7= 'protocol-version' ( (lv_protocolVersion_8_0= ruleSOAPProtocolVersion ) ) )? (otherlv_9= 'transport' ( (lv_transport_10_0= ruleSOAPTransport ) ) )? (otherlv_11= 'http-context-root' ( (lv_contextRoot_12_0= RULE_STRING ) ) )? (otherlv_13= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_14_0= RULE_STRING ) ) )? otherlv_15= '}' ) ;
    public final EObject ruleSOAP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token lv_contextRoot_12_0=null;
        Token otherlv_13=null;
        Token lv_providedWsdlUrl_14_0=null;
        Token otherlv_15=null;
        EObject lv_endpointQualifierRef_3_0 = null;

        EObject lv_endpointConnector_4_0 = null;

        Enumerator lv_style_6_0 = null;

        Enumerator lv_protocolVersion_8_0 = null;

        Enumerator lv_transport_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1587:28: ( (otherlv_0= 'SOAP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )? (otherlv_7= 'protocol-version' ( (lv_protocolVersion_8_0= ruleSOAPProtocolVersion ) ) )? (otherlv_9= 'transport' ( (lv_transport_10_0= ruleSOAPTransport ) ) )? (otherlv_11= 'http-context-root' ( (lv_contextRoot_12_0= RULE_STRING ) ) )? (otherlv_13= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_14_0= RULE_STRING ) ) )? otherlv_15= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1588:1: (otherlv_0= 'SOAP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )? (otherlv_7= 'protocol-version' ( (lv_protocolVersion_8_0= ruleSOAPProtocolVersion ) ) )? (otherlv_9= 'transport' ( (lv_transport_10_0= ruleSOAPTransport ) ) )? (otherlv_11= 'http-context-root' ( (lv_contextRoot_12_0= RULE_STRING ) ) )? (otherlv_13= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_14_0= RULE_STRING ) ) )? otherlv_15= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1588:1: (otherlv_0= 'SOAP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )? (otherlv_7= 'protocol-version' ( (lv_protocolVersion_8_0= ruleSOAPProtocolVersion ) ) )? (otherlv_9= 'transport' ( (lv_transport_10_0= ruleSOAPTransport ) ) )? (otherlv_11= 'http-context-root' ( (lv_contextRoot_12_0= RULE_STRING ) ) )? (otherlv_13= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_14_0= RULE_STRING ) ) )? otherlv_15= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1588:3: otherlv_0= 'SOAP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )? (otherlv_7= 'protocol-version' ( (lv_protocolVersion_8_0= ruleSOAPProtocolVersion ) ) )? (otherlv_9= 'transport' ( (lv_transport_10_0= ruleSOAPTransport ) ) )? (otherlv_11= 'http-context-root' ( (lv_contextRoot_12_0= RULE_STRING ) ) )? (otherlv_13= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_14_0= RULE_STRING ) ) )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleSOAP3238); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSOAPAccess().getSOAPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSOAP3250); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSOAPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1596:1: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1597:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getSOAPAccess().getSOAPAction_2(),
                          current);
                  
            }

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1605:2: ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==100) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1606:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1606:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1607:3: lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSOAPAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleSOAP3283);
                    lv_endpointQualifierRef_3_0=ruleEndpointQualifierRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSOAPRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRef",
                              		lv_endpointQualifierRef_3_0, 
                              		"EndpointQualifierRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1623:3: ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==11) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1624:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1624:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1625:3: lv_endpointConnector_4_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSOAPAccess().getEndpointConnectorConnectorQualifierParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleSOAP3305);
                    lv_endpointConnector_4_0=ruleConnectorQualifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSOAPRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointConnector",
                              		lv_endpointConnector_4_0, 
                              		"ConnectorQualifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1641:3: (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==34) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1641:5: otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) )
                    {
                    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleSOAP3319); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSOAPAccess().getStyleKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1645:1: ( (lv_style_6_0= ruleSOAPStyle ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1646:1: (lv_style_6_0= ruleSOAPStyle )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1646:1: (lv_style_6_0= ruleSOAPStyle )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1647:3: lv_style_6_0= ruleSOAPStyle
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSOAPAccess().getStyleSOAPStyleEnumRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSOAPStyle_in_ruleSOAP3340);
                    lv_style_6_0=ruleSOAPStyle();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSOAPRule());
                      	        }
                             		set(
                             			current, 
                             			"style",
                              		lv_style_6_0, 
                              		"SOAPStyle");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1663:4: (otherlv_7= 'protocol-version' ( (lv_protocolVersion_8_0= ruleSOAPProtocolVersion ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==35) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1663:6: otherlv_7= 'protocol-version' ( (lv_protocolVersion_8_0= ruleSOAPProtocolVersion ) )
                    {
                    otherlv_7=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleSOAP3355); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getSOAPAccess().getProtocolVersionKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1667:1: ( (lv_protocolVersion_8_0= ruleSOAPProtocolVersion ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1668:1: (lv_protocolVersion_8_0= ruleSOAPProtocolVersion )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1668:1: (lv_protocolVersion_8_0= ruleSOAPProtocolVersion )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1669:3: lv_protocolVersion_8_0= ruleSOAPProtocolVersion
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSOAPAccess().getProtocolVersionSOAPProtocolVersionEnumRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSOAPProtocolVersion_in_ruleSOAP3376);
                    lv_protocolVersion_8_0=ruleSOAPProtocolVersion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSOAPRule());
                      	        }
                             		set(
                             			current, 
                             			"protocolVersion",
                              		lv_protocolVersion_8_0, 
                              		"SOAPProtocolVersion");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1685:4: (otherlv_9= 'transport' ( (lv_transport_10_0= ruleSOAPTransport ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==36) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1685:6: otherlv_9= 'transport' ( (lv_transport_10_0= ruleSOAPTransport ) )
                    {
                    otherlv_9=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleSOAP3391); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getSOAPAccess().getTransportKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1689:1: ( (lv_transport_10_0= ruleSOAPTransport ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1690:1: (lv_transport_10_0= ruleSOAPTransport )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1690:1: (lv_transport_10_0= ruleSOAPTransport )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1691:3: lv_transport_10_0= ruleSOAPTransport
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSOAPAccess().getTransportSOAPTransportEnumRuleCall_7_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSOAPTransport_in_ruleSOAP3412);
                    lv_transport_10_0=ruleSOAPTransport();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSOAPRule());
                      	        }
                             		set(
                             			current, 
                             			"transport",
                              		lv_transport_10_0, 
                              		"SOAPTransport");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1707:4: (otherlv_11= 'http-context-root' ( (lv_contextRoot_12_0= RULE_STRING ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==37) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1707:6: otherlv_11= 'http-context-root' ( (lv_contextRoot_12_0= RULE_STRING ) )
                    {
                    otherlv_11=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleSOAP3427); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getSOAPAccess().getHttpContextRootKeyword_8_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1711:1: ( (lv_contextRoot_12_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1712:1: (lv_contextRoot_12_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1712:1: (lv_contextRoot_12_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1713:3: lv_contextRoot_12_0= RULE_STRING
                    {
                    lv_contextRoot_12_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSOAP3444); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_contextRoot_12_0, grammarAccess.getSOAPAccess().getContextRootSTRINGTerminalRuleCall_8_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSOAPRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"contextRoot",
                              		lv_contextRoot_12_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1729:4: (otherlv_13= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_14_0= RULE_STRING ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==38) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1729:6: otherlv_13= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_14_0= RULE_STRING ) )
                    {
                    otherlv_13=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleSOAP3464); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getSOAPAccess().getProvidedWSDLUrlKeyword_9_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1733:1: ( (lv_providedWsdlUrl_14_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1734:1: (lv_providedWsdlUrl_14_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1734:1: (lv_providedWsdlUrl_14_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1735:3: lv_providedWsdlUrl_14_0= RULE_STRING
                    {
                    lv_providedWsdlUrl_14_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSOAP3481); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_providedWsdlUrl_14_0, grammarAccess.getSOAPAccess().getProvidedWsdlUrlSTRINGTerminalRuleCall_9_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSOAPRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"providedWsdlUrl",
                              		lv_providedWsdlUrl_14_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSOAP3500); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getSOAPAccess().getRightCurlyBracketKeyword_10());
                  
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
    // $ANTLR end "ruleSOAP"


    // $ANTLR start "entryRuleSAP"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1763:1: entryRuleSAP returns [EObject current=null] : iv_ruleSAP= ruleSAP EOF ;
    public final EObject entryRuleSAP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1764:2: (iv_ruleSAP= ruleSAP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1765:2: iv_ruleSAP= ruleSAP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSAPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSAP_in_entryRuleSAP3536);
            iv_ruleSAP=ruleSAP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSAP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSAP3546); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSAP"


    // $ANTLR start "ruleSAP"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1772:1: ruleSAP returns [EObject current=null] : (otherlv_0= 'SAP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) ) )? (otherlv_7= 'client' ( ( ruleQualifiedName ) ) )? otherlv_9= '}' ) ;
    public final EObject ruleSAP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_endpointQualifierRef_3_0 = null;

        EObject lv_endpointConnector_4_0 = null;

        Enumerator lv_transport_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1775:28: ( (otherlv_0= 'SAP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) ) )? (otherlv_7= 'client' ( ( ruleQualifiedName ) ) )? otherlv_9= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1776:1: (otherlv_0= 'SAP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) ) )? (otherlv_7= 'client' ( ( ruleQualifiedName ) ) )? otherlv_9= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1776:1: (otherlv_0= 'SAP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) ) )? (otherlv_7= 'client' ( ( ruleQualifiedName ) ) )? otherlv_9= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1776:3: otherlv_0= 'SAP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) ) )? (otherlv_7= 'client' ( ( ruleQualifiedName ) ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleSAP3583); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSAPAccess().getSAPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSAP3595); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSAPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1784:1: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1785:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getSAPAccess().getSAPAction_2(),
                          current);
                  
            }

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1793:2: ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==100) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1794:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1794:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1795:3: lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSAPAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleSAP3628);
                    lv_endpointQualifierRef_3_0=ruleEndpointQualifierRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSAPRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRef",
                              		lv_endpointQualifierRef_3_0, 
                              		"EndpointQualifierRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1811:3: ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==11) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1812:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1812:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1813:3: lv_endpointConnector_4_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSAPAccess().getEndpointConnectorConnectorQualifierParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleSAP3650);
                    lv_endpointConnector_4_0=ruleConnectorQualifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSAPRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointConnector",
                              		lv_endpointConnector_4_0, 
                              		"ConnectorQualifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1829:3: (otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==36) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1829:5: otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) )
                    {
                    otherlv_5=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleSAP3664); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSAPAccess().getTransportKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1833:1: ( (lv_transport_6_0= ruleSAPTransport ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1834:1: (lv_transport_6_0= ruleSAPTransport )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1834:1: (lv_transport_6_0= ruleSAPTransport )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1835:3: lv_transport_6_0= ruleSAPTransport
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSAPAccess().getTransportSAPTransportEnumRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSAPTransport_in_ruleSAP3685);
                    lv_transport_6_0=ruleSAPTransport();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSAPRule());
                      	        }
                             		set(
                             			current, 
                             			"transport",
                              		lv_transport_6_0, 
                              		"SAPTransport");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1851:4: (otherlv_7= 'client' ( ( ruleQualifiedName ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==40) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1851:6: otherlv_7= 'client' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleSAP3700); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getSAPAccess().getClientKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1855:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1856:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1856:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1857:3: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getSAPRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSAPAccess().getClientSapClientCrossReference_6_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSAP3727);
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

            otherlv_9=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSAP3741); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getSAPAccess().getRightCurlyBracketKeyword_7());
                  
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
    // $ANTLR end "ruleSAP"


    // $ANTLR start "entryRuleEJB"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1885:1: entryRuleEJB returns [EObject current=null] : iv_ruleEJB= ruleEJB EOF ;
    public final EObject entryRuleEJB() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEJB = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1886:2: (iv_ruleEJB= ruleEJB EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1887:2: iv_ruleEJB= ruleEJB EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEJBRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEJB_in_entryRuleEJB3777);
            iv_ruleEJB=ruleEJB();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEJB; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEJB3787); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEJB"


    // $ANTLR start "ruleEJB"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1894:1: ruleEJB returns [EObject current=null] : (otherlv_0= 'EJB' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) otherlv_6= '}' ) ;
    public final EObject ruleEJB() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token lv_jndiName_5_0=null;
        Token otherlv_6=null;
        EObject lv_endpointQualifierRef_2_0 = null;

        EObject lv_endpointConnector_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1897:28: ( (otherlv_0= 'EJB' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) otherlv_6= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1898:1: (otherlv_0= 'EJB' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) otherlv_6= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1898:1: (otherlv_0= 'EJB' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) otherlv_6= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1898:3: otherlv_0= 'EJB' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleEJB3824); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEJBAccess().getEJBKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleEJB3836); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEJBAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1906:1: ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==100) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1907:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1907:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1908:3: lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEJBAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleEJB3857);
                    lv_endpointQualifierRef_2_0=ruleEndpointQualifierRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEJBRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRef",
                              		lv_endpointQualifierRef_2_0, 
                              		"EndpointQualifierRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1924:3: ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==11) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1925:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1925:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1926:3: lv_endpointConnector_3_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEJBAccess().getEndpointConnectorConnectorQualifierParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleEJB3879);
                    lv_endpointConnector_3_0=ruleConnectorQualifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEJBRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointConnector",
                              		lv_endpointConnector_3_0, 
                              		"ConnectorQualifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleEJB3892); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEJBAccess().getJndiNameKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1946:1: ( (lv_jndiName_5_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1947:1: (lv_jndiName_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1947:1: (lv_jndiName_5_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1948:3: lv_jndiName_5_0= RULE_STRING
            {
            lv_jndiName_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEJB3909); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_jndiName_5_0, grammarAccess.getEJBAccess().getJndiNameSTRINGTerminalRuleCall_5_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getEJBRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"jndiName",
                      		lv_jndiName_5_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleEJB3926); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getEJBAccess().getRightCurlyBracketKeyword_6());
                  
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
    // $ANTLR end "ruleEJB"


    // $ANTLR start "entryRuleHTTP"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1976:1: entryRuleHTTP returns [EObject current=null] : iv_ruleHTTP= ruleHTTP EOF ;
    public final EObject entryRuleHTTP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1977:2: (iv_ruleHTTP= ruleHTTP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1978:2: iv_ruleHTTP= ruleHTTP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHTTPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleHTTP_in_entryRuleHTTP3962);
            iv_ruleHTTP=ruleHTTP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHTTP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHTTP3972); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHTTP"


    // $ANTLR start "ruleHTTP"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1985:1: ruleHTTP returns [EObject current=null] : (otherlv_0= 'HTTP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= '}' ) ;
    public final EObject ruleHTTP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token lv_url_5_0=null;
        Token otherlv_6=null;
        Token lv_providerUrl_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_endpointQualifierRef_2_0 = null;

        EObject lv_endpointConnector_3_0 = null;

        Enumerator lv_verb_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1988:28: ( (otherlv_0= 'HTTP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1989:1: (otherlv_0= 'HTTP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1989:1: (otherlv_0= 'HTTP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1989:3: otherlv_0= 'HTTP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleHTTP4009); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getHTTPAccess().getHTTPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleHTTP4021); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getHTTPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1997:1: ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==100) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1998:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1998:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1999:3: lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getHTTPAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleHTTP4042);
                    lv_endpointQualifierRef_2_0=ruleEndpointQualifierRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getHTTPRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRef",
                              		lv_endpointQualifierRef_2_0, 
                              		"EndpointQualifierRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2015:3: ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==11) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2016:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2016:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2017:3: lv_endpointConnector_3_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getHTTPAccess().getEndpointConnectorConnectorQualifierParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleHTTP4064);
                    lv_endpointConnector_3_0=ruleConnectorQualifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getHTTPRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointConnector",
                              		lv_endpointConnector_3_0, 
                              		"ConnectorQualifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleHTTP4077); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getHTTPAccess().getUrlKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2037:1: ( (lv_url_5_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2038:1: (lv_url_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2038:1: (lv_url_5_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2039:3: lv_url_5_0= RULE_STRING
            {
            lv_url_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleHTTP4094); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_url_5_0, grammarAccess.getHTTPAccess().getUrlSTRINGTerminalRuleCall_5_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getHTTPRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"url",
                      		lv_url_5_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleHTTP4111); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getHTTPAccess().getProviderUrlKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2059:1: ( (lv_providerUrl_7_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2060:1: (lv_providerUrl_7_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2060:1: (lv_providerUrl_7_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2061:3: lv_providerUrl_7_0= RULE_STRING
            {
            lv_providerUrl_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleHTTP4128); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_providerUrl_7_0, grammarAccess.getHTTPAccess().getProviderUrlSTRINGTerminalRuleCall_7_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getHTTPRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"providerUrl",
                      		lv_providerUrl_7_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_8=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleHTTP4145); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getHTTPAccess().getVerbKeyword_8());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2081:1: ( (lv_verb_9_0= ruleVerb ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2082:1: (lv_verb_9_0= ruleVerb )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2082:1: (lv_verb_9_0= ruleVerb )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2083:3: lv_verb_9_0= ruleVerb
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getHTTPAccess().getVerbVerbEnumRuleCall_9_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVerb_in_ruleHTTP4166);
            lv_verb_9_0=ruleVerb();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getHTTPRule());
              	        }
                     		set(
                     			current, 
                     			"verb",
                      		lv_verb_9_0, 
                      		"Verb");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_10=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleHTTP4178); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getHTTPAccess().getRightCurlyBracketKeyword_10());
                  
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
    // $ANTLR end "ruleHTTP"


    // $ANTLR start "entryRuleREST"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2111:1: entryRuleREST returns [EObject current=null] : iv_ruleREST= ruleREST EOF ;
    public final EObject entryRuleREST() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleREST = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2112:2: (iv_ruleREST= ruleREST EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2113:2: iv_ruleREST= ruleREST EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRESTRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleREST_in_entryRuleREST4214);
            iv_ruleREST=ruleREST();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleREST; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleREST4224); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleREST"


    // $ANTLR start "ruleREST"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2120:1: ruleREST returns [EObject current=null] : (otherlv_0= 'REST' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'path' ( (lv_path_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) (otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) )? (otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) ) )? (otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) ) )? otherlv_16= '}' ) ;
    public final EObject ruleREST() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token lv_path_5_0=null;
        Token otherlv_6=null;
        Token lv_providerUrl_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject lv_endpointQualifierRef_2_0 = null;

        EObject lv_endpointConnector_3_0 = null;

        Enumerator lv_verb_9_0 = null;

        Enumerator lv_format_11_0 = null;

        Enumerator lv_consumesFormat_13_0 = null;

        Enumerator lv_provideFormat_15_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2123:28: ( (otherlv_0= 'REST' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'path' ( (lv_path_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) (otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) )? (otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) ) )? (otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) ) )? otherlv_16= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2124:1: (otherlv_0= 'REST' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'path' ( (lv_path_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) (otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) )? (otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) ) )? (otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) ) )? otherlv_16= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2124:1: (otherlv_0= 'REST' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'path' ( (lv_path_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) (otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) )? (otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) ) )? (otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) ) )? otherlv_16= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2124:3: otherlv_0= 'REST' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'path' ( (lv_path_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) (otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) )? (otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) ) )? (otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) ) )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleREST4261); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRESTAccess().getRESTKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleREST4273); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRESTAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2132:1: ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==100) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2133:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2133:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2134:3: lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRESTAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleREST4294);
                    lv_endpointQualifierRef_2_0=ruleEndpointQualifierRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRESTRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRef",
                              		lv_endpointQualifierRef_2_0, 
                              		"EndpointQualifierRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2150:3: ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==11) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2151:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2151:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2152:3: lv_endpointConnector_3_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRESTAccess().getEndpointConnectorConnectorQualifierParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleREST4316);
                    lv_endpointConnector_3_0=ruleConnectorQualifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRESTRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointConnector",
                              		lv_endpointConnector_3_0, 
                              		"ConnectorQualifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleREST4329); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getRESTAccess().getPathKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2172:1: ( (lv_path_5_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2173:1: (lv_path_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2173:1: (lv_path_5_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2174:3: lv_path_5_0= RULE_STRING
            {
            lv_path_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleREST4346); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_path_5_0, grammarAccess.getRESTAccess().getPathSTRINGTerminalRuleCall_5_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRESTRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"path",
                      		lv_path_5_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleREST4363); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getRESTAccess().getProviderUrlKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2194:1: ( (lv_providerUrl_7_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2195:1: (lv_providerUrl_7_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2195:1: (lv_providerUrl_7_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2196:3: lv_providerUrl_7_0= RULE_STRING
            {
            lv_providerUrl_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleREST4380); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_providerUrl_7_0, grammarAccess.getRESTAccess().getProviderUrlSTRINGTerminalRuleCall_7_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRESTRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"providerUrl",
                      		lv_providerUrl_7_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_8=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleREST4397); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getRESTAccess().getVerbKeyword_8());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2216:1: ( (lv_verb_9_0= ruleVerb ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2217:1: (lv_verb_9_0= ruleVerb )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2217:1: (lv_verb_9_0= ruleVerb )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2218:3: lv_verb_9_0= ruleVerb
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRESTAccess().getVerbVerbEnumRuleCall_9_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVerb_in_ruleREST4418);
            lv_verb_9_0=ruleVerb();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRESTRule());
              	        }
                     		set(
                     			current, 
                     			"verb",
                      		lv_verb_9_0, 
                      		"Verb");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2234:2: (otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==49) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2234:4: otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) )
                    {
                    otherlv_10=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleREST4431); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getRESTAccess().getFormatKeyword_10_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2238:1: ( (lv_format_11_0= ruleRESTFormat ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2239:1: (lv_format_11_0= ruleRESTFormat )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2239:1: (lv_format_11_0= ruleRESTFormat )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2240:3: lv_format_11_0= ruleRESTFormat
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRESTAccess().getFormatRESTFormatEnumRuleCall_10_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRESTFormat_in_ruleREST4452);
                    lv_format_11_0=ruleRESTFormat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRESTRule());
                      	        }
                             		set(
                             			current, 
                             			"format",
                              		lv_format_11_0, 
                              		"RESTFormat");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2256:4: (otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==50) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2256:6: otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) )
                    {
                    otherlv_12=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleREST4467); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getRESTAccess().getConsumesFormatKeyword_11_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2260:1: ( (lv_consumesFormat_13_0= ruleRESTFormat ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2261:1: (lv_consumesFormat_13_0= ruleRESTFormat )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2261:1: (lv_consumesFormat_13_0= ruleRESTFormat )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2262:3: lv_consumesFormat_13_0= ruleRESTFormat
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRESTAccess().getConsumesFormatRESTFormatEnumRuleCall_11_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRESTFormat_in_ruleREST4488);
                    lv_consumesFormat_13_0=ruleRESTFormat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRESTRule());
                      	        }
                             		set(
                             			current, 
                             			"consumesFormat",
                              		lv_consumesFormat_13_0, 
                              		"RESTFormat");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2278:4: (otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==51) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2278:6: otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) )
                    {
                    otherlv_14=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleREST4503); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getRESTAccess().getProvidesFormatKeyword_12_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2282:1: ( (lv_provideFormat_15_0= ruleRESTFormat ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2283:1: (lv_provideFormat_15_0= ruleRESTFormat )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2283:1: (lv_provideFormat_15_0= ruleRESTFormat )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2284:3: lv_provideFormat_15_0= ruleRESTFormat
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRESTAccess().getProvideFormatRESTFormatEnumRuleCall_12_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRESTFormat_in_ruleREST4524);
                    lv_provideFormat_15_0=ruleRESTFormat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRESTRule());
                      	        }
                             		set(
                             			current, 
                             			"provideFormat",
                              		lv_provideFormat_15_0, 
                              		"RESTFormat");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleREST4538); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_16, grammarAccess.getRESTAccess().getRightCurlyBracketKeyword_13());
                  
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
    // $ANTLR end "ruleREST"


    // $ANTLR start "entryRuleJMS"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2312:1: entryRuleJMS returns [EObject current=null] : iv_ruleJMS= ruleJMS EOF ;
    public final EObject entryRuleJMS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJMS = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2313:2: (iv_ruleJMS= ruleJMS EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2314:2: iv_ruleJMS= ruleJMS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJMSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleJMS_in_entryRuleJMS4574);
            iv_ruleJMS=ruleJMS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJMS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleJMS4584); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJMS"


    // $ANTLR start "ruleJMS"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2321:1: ruleJMS returns [EObject current=null] : (otherlv_0= 'JMS' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) ;
    public final EObject ruleJMS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_6=null;
        Token lv_jndiName_7_0=null;
        Token otherlv_8=null;
        Token lv_providerJndi_9_0=null;
        Token otherlv_10=null;
        EObject lv_endpointQualifierRef_3_0 = null;

        EObject lv_endpointConnector_4_0 = null;

        EObject lv_channel_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2324:28: ( (otherlv_0= 'JMS' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2325:1: (otherlv_0= 'JMS' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2325:1: (otherlv_0= 'JMS' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2325:3: otherlv_0= 'JMS' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleJMS4621); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJMSAccess().getJMSKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleJMS4633); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJMSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2333:1: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2334:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getJMSAccess().getJMSAction_2(),
                          current);
                  
            }

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2342:2: ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==100) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2343:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2343:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2344:3: lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJMSAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleJMS4666);
                    lv_endpointQualifierRef_3_0=ruleEndpointQualifierRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJMSRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRef",
                              		lv_endpointQualifierRef_3_0, 
                              		"EndpointQualifierRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2360:3: ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==11) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2361:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2361:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2362:3: lv_endpointConnector_4_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJMSAccess().getEndpointConnectorConnectorQualifierParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleJMS4688);
                    lv_endpointConnector_4_0=ruleConnectorQualifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJMSRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointConnector",
                              		lv_endpointConnector_4_0, 
                              		"ConnectorQualifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2378:3: ( (lv_channel_5_0= ruleTopicOrQueue ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=54 && LA71_0<=55)) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2379:1: (lv_channel_5_0= ruleTopicOrQueue )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2379:1: (lv_channel_5_0= ruleTopicOrQueue )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2380:3: lv_channel_5_0= ruleTopicOrQueue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJMSAccess().getChannelTopicOrQueueParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTopicOrQueue_in_ruleJMS4710);
                    lv_channel_5_0=ruleTopicOrQueue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJMSRule());
                      	        }
                             		set(
                             			current, 
                             			"channel",
                              		lv_channel_5_0, 
                              		"TopicOrQueue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleJMS4723); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getJMSAccess().getJndiNameKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2400:1: ( (lv_jndiName_7_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2401:1: (lv_jndiName_7_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2401:1: (lv_jndiName_7_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2402:3: lv_jndiName_7_0= RULE_STRING
            {
            lv_jndiName_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleJMS4740); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_jndiName_7_0, grammarAccess.getJMSAccess().getJndiNameSTRINGTerminalRuleCall_7_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getJMSRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"jndiName",
                      		lv_jndiName_7_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2418:2: (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==53) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2418:4: otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleJMS4758); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getJMSAccess().getProviderJndiNameKeyword_8_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2422:1: ( (lv_providerJndi_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2423:1: (lv_providerJndi_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2423:1: (lv_providerJndi_9_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2424:3: lv_providerJndi_9_0= RULE_STRING
                    {
                    lv_providerJndi_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleJMS4775); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_providerJndi_9_0, grammarAccess.getJMSAccess().getProviderJndiSTRINGTerminalRuleCall_8_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getJMSRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"providerJndi",
                              		lv_providerJndi_9_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleJMS4794); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getJMSAccess().getRightCurlyBracketKeyword_9());
                  
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
    // $ANTLR end "ruleJMS"


    // $ANTLR start "entryRuleTopicOrQueue"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2452:1: entryRuleTopicOrQueue returns [EObject current=null] : iv_ruleTopicOrQueue= ruleTopicOrQueue EOF ;
    public final EObject entryRuleTopicOrQueue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopicOrQueue = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2453:2: (iv_ruleTopicOrQueue= ruleTopicOrQueue EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2454:2: iv_ruleTopicOrQueue= ruleTopicOrQueue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTopicOrQueueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTopicOrQueue_in_entryRuleTopicOrQueue4830);
            iv_ruleTopicOrQueue=ruleTopicOrQueue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTopicOrQueue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTopicOrQueue4840); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTopicOrQueue"


    // $ANTLR start "ruleTopicOrQueue"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2461:1: ruleTopicOrQueue returns [EObject current=null] : (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue ) ;
    public final EObject ruleTopicOrQueue() throws RecognitionException {
        EObject current = null;

        EObject this_Topic_0 = null;

        EObject this_Queue_1 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2464:28: ( (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2465:1: (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2465:1: (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==54) ) {
                alt73=1;
            }
            else if ( (LA73_0==55) ) {
                alt73=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2466:2: this_Topic_0= ruleTopic
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTopicOrQueueAccess().getTopicParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTopic_in_ruleTopicOrQueue4890);
                    this_Topic_0=ruleTopic();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Topic_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2479:2: this_Queue_1= ruleQueue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTopicOrQueueAccess().getQueueParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQueue_in_ruleTopicOrQueue4920);
                    this_Queue_1=ruleQueue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Queue_1; 
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
    // $ANTLR end "ruleTopicOrQueue"


    // $ANTLR start "entryRuleTopic"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2498:1: entryRuleTopic returns [EObject current=null] : iv_ruleTopic= ruleTopic EOF ;
    public final EObject entryRuleTopic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopic = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2499:2: (iv_ruleTopic= ruleTopic EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2500:2: iv_ruleTopic= ruleTopic EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTopicRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTopic_in_entryRuleTopic4955);
            iv_ruleTopic=ruleTopic();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTopic; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTopic4965); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTopic"


    // $ANTLR start "ruleTopic"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2507:1: ruleTopic returns [EObject current=null] : (otherlv_0= 'topic' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )? ) ;
    public final EObject ruleTopic() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_endpointQualifierRefs_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2510:28: ( (otherlv_0= 'topic' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2511:1: (otherlv_0= 'topic' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2511:1: (otherlv_0= 'topic' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2511:3: otherlv_0= 'topic' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )?
            {
            otherlv_0=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleTopic5002); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTopicAccess().getTopicKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2515:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2516:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2516:1: (lv_name_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2517:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleTopic5019); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getTopicAccess().getNameSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTopicRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2533:2: ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==100) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2534:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2534:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2535:3: lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTopicAccess().getEndpointQualifierRefsEndpointQualifierRefParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleTopic5045);
                    lv_endpointQualifierRefs_2_0=ruleEndpointQualifierRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTopicRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRefs",
                              		lv_endpointQualifierRefs_2_0, 
                              		"EndpointQualifierRef");
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
    // $ANTLR end "ruleTopic"


    // $ANTLR start "entryRuleQueue"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2559:1: entryRuleQueue returns [EObject current=null] : iv_ruleQueue= ruleQueue EOF ;
    public final EObject entryRuleQueue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueue = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2560:2: (iv_ruleQueue= ruleQueue EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2561:2: iv_ruleQueue= ruleQueue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQueueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQueue_in_entryRuleQueue5082);
            iv_ruleQueue=ruleQueue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQueue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQueue5092); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueue"


    // $ANTLR start "ruleQueue"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2568:1: ruleQueue returns [EObject current=null] : (otherlv_0= 'queue' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )? ) ;
    public final EObject ruleQueue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_endpointQualifierRefs_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2571:28: ( (otherlv_0= 'queue' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2572:1: (otherlv_0= 'queue' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2572:1: (otherlv_0= 'queue' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2572:3: otherlv_0= 'queue' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )?
            {
            otherlv_0=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleQueue5129); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getQueueAccess().getQueueKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2576:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2577:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2577:1: (lv_name_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2578:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleQueue5146); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getQueueAccess().getNameSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getQueueRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2594:2: ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==100) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2595:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2595:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2596:3: lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQueueAccess().getEndpointQualifierRefsEndpointQualifierRefParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleQueue5172);
                    lv_endpointQualifierRefs_2_0=ruleEndpointQualifierRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getQueueRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRefs",
                              		lv_endpointQualifierRefs_2_0, 
                              		"EndpointQualifierRef");
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
    // $ANTLR end "ruleQueue"


    // $ANTLR start "entryRuleSCA"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2620:1: entryRuleSCA returns [EObject current=null] : iv_ruleSCA= ruleSCA EOF ;
    public final EObject entryRuleSCA() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSCA = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2621:2: (iv_ruleSCA= ruleSCA EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2622:2: iv_ruleSCA= ruleSCA EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSCARule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSCA_in_entryRuleSCA5209);
            iv_ruleSCA=ruleSCA();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSCA; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSCA5219); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSCA"


    // $ANTLR start "ruleSCA"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2629:1: ruleSCA returns [EObject current=null] : ( () otherlv_1= 'SCA' ( (lv_name_2_0= RULE_STRING ) )? otherlv_3= '{' ( (lv_endpointQualifierRef_4_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_5_0= ruleConnectorQualifier ) )? (otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) ) )? (otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? )? otherlv_11= '}' ) ;
    public final EObject ruleSCA() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token lv_promote_7_0=null;
        Token otherlv_8=null;
        Token lv_reference_9_0=null;
        Token lv_isMultipleRef_10_0=null;
        Token otherlv_11=null;
        EObject lv_endpointQualifierRef_4_0 = null;

        EObject lv_endpointConnector_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2632:28: ( ( () otherlv_1= 'SCA' ( (lv_name_2_0= RULE_STRING ) )? otherlv_3= '{' ( (lv_endpointQualifierRef_4_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_5_0= ruleConnectorQualifier ) )? (otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) ) )? (otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? )? otherlv_11= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2633:1: ( () otherlv_1= 'SCA' ( (lv_name_2_0= RULE_STRING ) )? otherlv_3= '{' ( (lv_endpointQualifierRef_4_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_5_0= ruleConnectorQualifier ) )? (otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) ) )? (otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? )? otherlv_11= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2633:1: ( () otherlv_1= 'SCA' ( (lv_name_2_0= RULE_STRING ) )? otherlv_3= '{' ( (lv_endpointQualifierRef_4_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_5_0= ruleConnectorQualifier ) )? (otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) ) )? (otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? )? otherlv_11= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2633:2: () otherlv_1= 'SCA' ( (lv_name_2_0= RULE_STRING ) )? otherlv_3= '{' ( (lv_endpointQualifierRef_4_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_5_0= ruleConnectorQualifier ) )? (otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) ) )? (otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? )? otherlv_11= '}'
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2633:2: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2634:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getSCAAccess().getSCAAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleSCA5268); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSCAAccess().getSCAKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2646:1: ( (lv_name_2_0= RULE_STRING ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_STRING) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2647:1: (lv_name_2_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2647:1: (lv_name_2_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2648:3: lv_name_2_0= RULE_STRING
                    {
                    lv_name_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSCA5285); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_2_0, grammarAccess.getSCAAccess().getNameSTRINGTerminalRuleCall_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSCARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_2_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSCA5303); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getSCAAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2668:1: ( (lv_endpointQualifierRef_4_0= ruleEndpointQualifierRef ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==100) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2669:1: (lv_endpointQualifierRef_4_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2669:1: (lv_endpointQualifierRef_4_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2670:3: lv_endpointQualifierRef_4_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSCAAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleSCA5324);
                    lv_endpointQualifierRef_4_0=ruleEndpointQualifierRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSCARule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRef",
                              		lv_endpointQualifierRef_4_0, 
                              		"EndpointQualifierRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2686:3: ( (lv_endpointConnector_5_0= ruleConnectorQualifier ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==11) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2687:1: (lv_endpointConnector_5_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2687:1: (lv_endpointConnector_5_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2688:3: lv_endpointConnector_5_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSCAAccess().getEndpointConnectorConnectorQualifierParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleSCA5346);
                    lv_endpointConnector_5_0=ruleConnectorQualifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSCARule());
                      	        }
                             		set(
                             			current, 
                             			"endpointConnector",
                              		lv_endpointConnector_5_0, 
                              		"ConnectorQualifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2704:3: (otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==57) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2704:5: otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleSCA5360); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getSCAAccess().getPromoteKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2708:1: ( (lv_promote_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2709:1: (lv_promote_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2709:1: (lv_promote_7_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2710:3: lv_promote_7_0= RULE_STRING
                    {
                    lv_promote_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSCA5377); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_promote_7_0, grammarAccess.getSCAAccess().getPromoteSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSCARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"promote",
                              		lv_promote_7_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2726:4: (otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==58) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2726:6: otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )?
                    {
                    otherlv_8=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleSCA5397); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getSCAAccess().getReferenceKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2730:1: ( (lv_reference_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2731:1: (lv_reference_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2731:1: (lv_reference_9_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2732:3: lv_reference_9_0= RULE_STRING
                    {
                    lv_reference_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSCA5414); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_reference_9_0, grammarAccess.getSCAAccess().getReferenceSTRINGTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSCARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"reference",
                              		lv_reference_9_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2748:2: ( (lv_isMultipleRef_10_0= '[]' ) )?
                    int alt80=2;
                    int LA80_0 = input.LA(1);

                    if ( (LA80_0==59) ) {
                        alt80=1;
                    }
                    switch (alt80) {
                        case 1 :
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2749:1: (lv_isMultipleRef_10_0= '[]' )
                            {
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2749:1: (lv_isMultipleRef_10_0= '[]' )
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2750:3: lv_isMultipleRef_10_0= '[]'
                            {
                            lv_isMultipleRef_10_0=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleSCA5437); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_isMultipleRef_10_0, grammarAccess.getSCAAccess().getIsMultipleRefLeftSquareBracketRightSquareBracketKeyword_7_2_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getSCARule());
                              	        }
                                     		setWithLastConsumed(current, "isMultipleRef", true, "[]");
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSCA5465); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getSCAAccess().getRightCurlyBracketKeyword_8());
                  
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
    // $ANTLR end "ruleSCA"


    // $ANTLR start "entryRuleFILE"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2775:1: entryRuleFILE returns [EObject current=null] : iv_ruleFILE= ruleFILE EOF ;
    public final EObject entryRuleFILE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFILE = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2776:2: (iv_ruleFILE= ruleFILE EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2777:2: iv_ruleFILE= ruleFILE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFILERule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFILE_in_entryRuleFILE5501);
            iv_ruleFILE=ruleFILE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFILE; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFILE5511); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFILE"


    // $ANTLR start "ruleFILE"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2784:1: ruleFILE returns [EObject current=null] : (otherlv_0= 'FILE' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? ( (lv_url_4_0= RULE_STRING ) ) ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) ;
    public final EObject ruleFILE() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_url_4_0=null;
        Token otherlv_6=null;
        Token lv_pollIntervall_7_0=null;
        Token otherlv_8=null;
        EObject lv_endpointQualifierRef_2_0 = null;

        EObject lv_endpointConnector_3_0 = null;

        Enumerator lv_accessType_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2787:28: ( (otherlv_0= 'FILE' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? ( (lv_url_4_0= RULE_STRING ) ) ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2788:1: (otherlv_0= 'FILE' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? ( (lv_url_4_0= RULE_STRING ) ) ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2788:1: (otherlv_0= 'FILE' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? ( (lv_url_4_0= RULE_STRING ) ) ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2788:3: otherlv_0= 'FILE' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? ( (lv_url_4_0= RULE_STRING ) ) ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleFILE5548); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFILEAccess().getFILEKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleFILE5560); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFILEAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2796:1: ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==100) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2797:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2797:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2798:3: lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFILEAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleFILE5581);
                    lv_endpointQualifierRef_2_0=ruleEndpointQualifierRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFILERule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRef",
                              		lv_endpointQualifierRef_2_0, 
                              		"EndpointQualifierRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2814:3: ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==11) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2815:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2815:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2816:3: lv_endpointConnector_3_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFILEAccess().getEndpointConnectorConnectorQualifierParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleFILE5603);
                    lv_endpointConnector_3_0=ruleConnectorQualifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFILERule());
                      	        }
                             		set(
                             			current, 
                             			"endpointConnector",
                              		lv_endpointConnector_3_0, 
                              		"ConnectorQualifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2832:3: ( (lv_url_4_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2833:1: (lv_url_4_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2833:1: (lv_url_4_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2834:3: lv_url_4_0= RULE_STRING
            {
            lv_url_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFILE5621); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_url_4_0, grammarAccess.getFILEAccess().getUrlSTRINGTerminalRuleCall_4_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFILERule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"url",
                      		lv_url_4_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2850:2: ( (lv_accessType_5_0= ruleReadWrite ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2851:1: (lv_accessType_5_0= ruleReadWrite )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2851:1: (lv_accessType_5_0= ruleReadWrite )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2852:3: lv_accessType_5_0= ruleReadWrite
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFILEAccess().getAccessTypeReadWriteEnumRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleReadWrite_in_ruleFILE5647);
            lv_accessType_5_0=ruleReadWrite();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFILERule());
              	        }
                     		set(
                     			current, 
                     			"accessType",
                      		lv_accessType_5_0, 
                      		"ReadWrite");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2868:2: (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==61) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2868:4: otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleFILE5660); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getFILEAccess().getIntervalKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2872:1: ( (lv_pollIntervall_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2873:1: (lv_pollIntervall_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2873:1: (lv_pollIntervall_7_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2874:3: lv_pollIntervall_7_0= RULE_STRING
                    {
                    lv_pollIntervall_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFILE5677); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_pollIntervall_7_0, grammarAccess.getFILEAccess().getPollIntervallSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFILERule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"pollIntervall",
                              		lv_pollIntervall_7_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleFILE5696); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getFILEAccess().getRightCurlyBracketKeyword_7());
                  
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
    // $ANTLR end "ruleFILE"


    // $ANTLR start "entryRuleFTP"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2902:1: entryRuleFTP returns [EObject current=null] : iv_ruleFTP= ruleFTP EOF ;
    public final EObject entryRuleFTP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFTP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2903:2: (iv_ruleFTP= ruleFTP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2904:2: iv_ruleFTP= ruleFTP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFTPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFTP_in_entryRuleFTP5732);
            iv_ruleFTP=ruleFTP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFTP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFTP5742); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFTP"


    // $ANTLR start "ruleFTP"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2911:1: ruleFTP returns [EObject current=null] : (otherlv_0= 'FTP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'access' ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) ;
    public final EObject ruleFTP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_pollIntervall_7_0=null;
        Token otherlv_8=null;
        EObject lv_endpointQualifierRef_2_0 = null;

        EObject lv_endpointConnector_3_0 = null;

        Enumerator lv_accessType_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2914:28: ( (otherlv_0= 'FTP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'access' ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2915:1: (otherlv_0= 'FTP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'access' ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2915:1: (otherlv_0= 'FTP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'access' ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2915:3: otherlv_0= 'FTP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'access' ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleFTP5779); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFTPAccess().getFTPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleFTP5791); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFTPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2923:1: ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==100) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2924:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2924:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2925:3: lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFTPAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleFTP5812);
                    lv_endpointQualifierRef_2_0=ruleEndpointQualifierRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFTPRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRef",
                              		lv_endpointQualifierRef_2_0, 
                              		"EndpointQualifierRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2941:3: ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==11) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2942:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2942:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2943:3: lv_endpointConnector_3_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFTPAccess().getEndpointConnectorConnectorQualifierParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleFTP5834);
                    lv_endpointConnector_3_0=ruleConnectorQualifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFTPRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointConnector",
                              		lv_endpointConnector_3_0, 
                              		"ConnectorQualifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleFTP5847); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getFTPAccess().getAccessKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2963:1: ( (lv_accessType_5_0= ruleReadWrite ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2964:1: (lv_accessType_5_0= ruleReadWrite )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2964:1: (lv_accessType_5_0= ruleReadWrite )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2965:3: lv_accessType_5_0= ruleReadWrite
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFTPAccess().getAccessTypeReadWriteEnumRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleReadWrite_in_ruleFTP5868);
            lv_accessType_5_0=ruleReadWrite();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFTPRule());
              	        }
                     		set(
                     			current, 
                     			"accessType",
                      		lv_accessType_5_0, 
                      		"ReadWrite");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2981:2: (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==61) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2981:4: otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleFTP5881); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getFTPAccess().getIntervalKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2985:1: ( (lv_pollIntervall_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2986:1: (lv_pollIntervall_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2986:1: (lv_pollIntervall_7_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2987:3: lv_pollIntervall_7_0= RULE_STRING
                    {
                    lv_pollIntervall_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFTP5898); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_pollIntervall_7_0, grammarAccess.getFTPAccess().getPollIntervallSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFTPRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"pollIntervall",
                              		lv_pollIntervall_7_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleFTP5917); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getFTPAccess().getRightCurlyBracketKeyword_7());
                  
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
    // $ANTLR end "ruleFTP"


    // $ANTLR start "entryRuleIIOP"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3015:1: entryRuleIIOP returns [EObject current=null] : iv_ruleIIOP= ruleIIOP EOF ;
    public final EObject entryRuleIIOP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIIOP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3016:2: (iv_ruleIIOP= ruleIIOP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3017:2: iv_ruleIIOP= ruleIIOP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIIOPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIIOP_in_entryRuleIIOP5953);
            iv_ruleIIOP=ruleIIOP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIIOP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIIOP5963); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIIOP"


    // $ANTLR start "ruleIIOP"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3024:1: ruleIIOP returns [EObject current=null] : (otherlv_0= 'IIOP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'lookup-name' ( (lv_lookupName_5_0= RULE_STRING ) ) otherlv_6= '}' ) ;
    public final EObject ruleIIOP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token lv_lookupName_5_0=null;
        Token otherlv_6=null;
        EObject lv_endpointQualifierRef_2_0 = null;

        EObject lv_endpointConnector_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3027:28: ( (otherlv_0= 'IIOP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'lookup-name' ( (lv_lookupName_5_0= RULE_STRING ) ) otherlv_6= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3028:1: (otherlv_0= 'IIOP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'lookup-name' ( (lv_lookupName_5_0= RULE_STRING ) ) otherlv_6= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3028:1: (otherlv_0= 'IIOP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'lookup-name' ( (lv_lookupName_5_0= RULE_STRING ) ) otherlv_6= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3028:3: otherlv_0= 'IIOP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'lookup-name' ( (lv_lookupName_5_0= RULE_STRING ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleIIOP6000); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIIOPAccess().getIIOPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleIIOP6012); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getIIOPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3036:1: ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==100) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3037:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3037:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3038:3: lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIIOPAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleIIOP6033);
                    lv_endpointQualifierRef_2_0=ruleEndpointQualifierRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIIOPRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRef",
                              		lv_endpointQualifierRef_2_0, 
                              		"EndpointQualifierRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3054:3: ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==11) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3055:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3055:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3056:3: lv_endpointConnector_3_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIIOPAccess().getEndpointConnectorConnectorQualifierParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleIIOP6055);
                    lv_endpointConnector_3_0=ruleConnectorQualifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIIOPRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointConnector",
                              		lv_endpointConnector_3_0, 
                              		"ConnectorQualifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleIIOP6068); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getIIOPAccess().getLookupNameKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3076:1: ( (lv_lookupName_5_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3077:1: (lv_lookupName_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3077:1: (lv_lookupName_5_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3078:3: lv_lookupName_5_0= RULE_STRING
            {
            lv_lookupName_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleIIOP6085); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_lookupName_5_0, grammarAccess.getIIOPAccess().getLookupNameSTRINGTerminalRuleCall_5_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getIIOPRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"lookupName",
                      		lv_lookupName_5_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleIIOP6102); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getIIOPAccess().getRightCurlyBracketKeyword_6());
                  
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
    // $ANTLR end "ruleIIOP"


    // $ANTLR start "entryRuleAMQP"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3106:1: entryRuleAMQP returns [EObject current=null] : iv_ruleAMQP= ruleAMQP EOF ;
    public final EObject entryRuleAMQP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAMQP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3107:2: (iv_ruleAMQP= ruleAMQP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3108:2: iv_ruleAMQP= ruleAMQP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAMQPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAMQP_in_entryRuleAMQP6138);
            iv_ruleAMQP=ruleAMQP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAMQP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAMQP6148); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAMQP"


    // $ANTLR start "ruleAMQP"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3115:1: ruleAMQP returns [EObject current=null] : (otherlv_0= 'AMQP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'lookup-name' ( (lv_lookupName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) ;
    public final EObject ruleAMQP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_6=null;
        Token lv_lookupName_7_0=null;
        Token otherlv_8=null;
        Token lv_providerLookupName_9_0=null;
        Token otherlv_10=null;
        EObject lv_endpointQualifierRef_3_0 = null;

        EObject lv_endpointConnector_4_0 = null;

        EObject lv_channel_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3118:28: ( (otherlv_0= 'AMQP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'lookup-name' ( (lv_lookupName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3119:1: (otherlv_0= 'AMQP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'lookup-name' ( (lv_lookupName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3119:1: (otherlv_0= 'AMQP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'lookup-name' ( (lv_lookupName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3119:3: otherlv_0= 'AMQP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'lookup-name' ( (lv_lookupName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) ) )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleAMQP6185); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAMQPAccess().getAMQPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAMQP6197); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAMQPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3127:1: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3128:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAMQPAccess().getAMQPAction_2(),
                          current);
                  
            }

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3136:2: ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==100) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3137:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3137:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3138:3: lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAMQPAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleAMQP6230);
                    lv_endpointQualifierRef_3_0=ruleEndpointQualifierRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAMQPRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRef",
                              		lv_endpointQualifierRef_3_0, 
                              		"EndpointQualifierRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3154:3: ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==11) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3155:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3155:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3156:3: lv_endpointConnector_4_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAMQPAccess().getEndpointConnectorConnectorQualifierParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleAMQP6252);
                    lv_endpointConnector_4_0=ruleConnectorQualifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAMQPRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointConnector",
                              		lv_endpointConnector_4_0, 
                              		"ConnectorQualifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3172:3: ( (lv_channel_5_0= ruleTopicOrQueue ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( ((LA92_0>=54 && LA92_0<=55)) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3173:1: (lv_channel_5_0= ruleTopicOrQueue )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3173:1: (lv_channel_5_0= ruleTopicOrQueue )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3174:3: lv_channel_5_0= ruleTopicOrQueue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAMQPAccess().getChannelTopicOrQueueParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTopicOrQueue_in_ruleAMQP6274);
                    lv_channel_5_0=ruleTopicOrQueue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAMQPRule());
                      	        }
                             		set(
                             			current, 
                             			"channel",
                              		lv_channel_5_0, 
                              		"TopicOrQueue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleAMQP6287); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getAMQPAccess().getLookupNameKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3194:1: ( (lv_lookupName_7_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3195:1: (lv_lookupName_7_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3195:1: (lv_lookupName_7_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3196:3: lv_lookupName_7_0= RULE_STRING
            {
            lv_lookupName_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAMQP6304); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_lookupName_7_0, grammarAccess.getAMQPAccess().getLookupNameSTRINGTerminalRuleCall_7_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAMQPRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"lookupName",
                      		lv_lookupName_7_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3212:2: (otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==67) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3212:4: otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleAMQP6322); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getAMQPAccess().getProviderLookupNameKeyword_8_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3216:1: ( (lv_providerLookupName_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3217:1: (lv_providerLookupName_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3217:1: (lv_providerLookupName_9_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3218:3: lv_providerLookupName_9_0= RULE_STRING
                    {
                    lv_providerLookupName_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAMQP6339); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_providerLookupName_9_0, grammarAccess.getAMQPAccess().getProviderLookupNameSTRINGTerminalRuleCall_8_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAMQPRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"providerLookupName",
                              		lv_providerLookupName_9_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAMQP6358); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getAMQPAccess().getRightCurlyBracketKeyword_9());
                  
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
    // $ANTLR end "ruleAMQP"


    // $ANTLR start "entryRulePolicy"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3246:1: entryRulePolicy returns [EObject current=null] : iv_rulePolicy= rulePolicy EOF ;
    public final EObject entryRulePolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3247:2: (iv_rulePolicy= rulePolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3248:2: iv_rulePolicy= rulePolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePolicy_in_entryRulePolicy6394);
            iv_rulePolicy=rulePolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePolicy6404); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePolicy"


    // $ANTLR start "rulePolicy"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3255:1: rulePolicy returns [EObject current=null] : (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy ) ;
    public final EObject rulePolicy() throws RecognitionException {
        EObject current = null;

        EObject this_LogPolicy_0 = null;

        EObject this_SecurityPolicy_1 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3258:28: ( (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3259:1: (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3259:1: (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==68) ) {
                alt94=1;
            }
            else if ( (LA94_0==69||LA94_0==76||LA94_0==81) ) {
                alt94=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3260:2: this_LogPolicy_0= ruleLogPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPolicyAccess().getLogPolicyParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLogPolicy_in_rulePolicy6454);
                    this_LogPolicy_0=ruleLogPolicy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LogPolicy_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3273:2: this_SecurityPolicy_1= ruleSecurityPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPolicyAccess().getSecurityPolicyParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSecurityPolicy_in_rulePolicy6484);
                    this_SecurityPolicy_1=ruleSecurityPolicy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SecurityPolicy_1; 
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
    // $ANTLR end "rulePolicy"


    // $ANTLR start "entryRuleLogPolicy"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3292:1: entryRuleLogPolicy returns [EObject current=null] : iv_ruleLogPolicy= ruleLogPolicy EOF ;
    public final EObject entryRuleLogPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3293:2: (iv_ruleLogPolicy= ruleLogPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3294:2: iv_ruleLogPolicy= ruleLogPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLogPolicy_in_entryRuleLogPolicy6519);
            iv_ruleLogPolicy=ruleLogPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLogPolicy6529); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogPolicy"


    // $ANTLR start "ruleLogPolicy"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3301:1: ruleLogPolicy returns [EObject current=null] : (otherlv_0= 'logging-policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) ) ;
    public final EObject ruleLogPolicy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_logPolicy_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3304:28: ( (otherlv_0= 'logging-policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3305:1: (otherlv_0= 'logging-policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3305:1: (otherlv_0= 'logging-policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3305:3: otherlv_0= 'logging-policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) )
            {
            otherlv_0=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleLogPolicy6566); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLogPolicyAccess().getLoggingPolicyKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3309:1: ( (lv_logPolicy_1_0= ruleLogPolicyKind ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3310:1: (lv_logPolicy_1_0= ruleLogPolicyKind )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3310:1: (lv_logPolicy_1_0= ruleLogPolicyKind )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3311:3: lv_logPolicy_1_0= ruleLogPolicyKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogPolicyAccess().getLogPolicyLogPolicyKindEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLogPolicyKind_in_ruleLogPolicy6587);
            lv_logPolicy_1_0=ruleLogPolicyKind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLogPolicyRule());
              	        }
                     		set(
                     			current, 
                     			"logPolicy",
                      		lv_logPolicy_1_0, 
                      		"LogPolicyKind");
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
    // $ANTLR end "ruleLogPolicy"


    // $ANTLR start "entryRuleSecurityPolicy"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3335:1: entryRuleSecurityPolicy returns [EObject current=null] : iv_ruleSecurityPolicy= ruleSecurityPolicy EOF ;
    public final EObject entryRuleSecurityPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecurityPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3336:2: (iv_ruleSecurityPolicy= ruleSecurityPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3337:2: iv_ruleSecurityPolicy= ruleSecurityPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSecurityPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSecurityPolicy_in_entryRuleSecurityPolicy6623);
            iv_ruleSecurityPolicy=ruleSecurityPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSecurityPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecurityPolicy6633); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSecurityPolicy"


    // $ANTLR start "ruleSecurityPolicy"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3344:1: ruleSecurityPolicy returns [EObject current=null] : (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | this_SigningPolicy_1= ruleSigningPolicy | this_EncryptionPolicy_2= ruleEncryptionPolicy ) ;
    public final EObject ruleSecurityPolicy() throws RecognitionException {
        EObject current = null;

        EObject this_AuthenticationPolicy_0 = null;

        EObject this_SigningPolicy_1 = null;

        EObject this_EncryptionPolicy_2 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3347:28: ( (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | this_SigningPolicy_1= ruleSigningPolicy | this_EncryptionPolicy_2= ruleEncryptionPolicy ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3348:1: (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | this_SigningPolicy_1= ruleSigningPolicy | this_EncryptionPolicy_2= ruleEncryptionPolicy )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3348:1: (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | this_SigningPolicy_1= ruleSigningPolicy | this_EncryptionPolicy_2= ruleEncryptionPolicy )
            int alt95=3;
            switch ( input.LA(1) ) {
            case 69:
                {
                alt95=1;
                }
                break;
            case 76:
                {
                alt95=2;
                }
                break;
            case 81:
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3349:2: this_AuthenticationPolicy_0= ruleAuthenticationPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityPolicyAccess().getAuthenticationPolicyParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAuthenticationPolicy_in_ruleSecurityPolicy6683);
                    this_AuthenticationPolicy_0=ruleAuthenticationPolicy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AuthenticationPolicy_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3362:2: this_SigningPolicy_1= ruleSigningPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityPolicyAccess().getSigningPolicyParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSigningPolicy_in_ruleSecurityPolicy6713);
                    this_SigningPolicy_1=ruleSigningPolicy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SigningPolicy_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3375:2: this_EncryptionPolicy_2= ruleEncryptionPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityPolicyAccess().getEncryptionPolicyParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEncryptionPolicy_in_ruleSecurityPolicy6743);
                    this_EncryptionPolicy_2=ruleEncryptionPolicy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_EncryptionPolicy_2; 
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
    // $ANTLR end "ruleSecurityPolicy"


    // $ANTLR start "entryRuleAuthenticationPolicy"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3394:1: entryRuleAuthenticationPolicy returns [EObject current=null] : iv_ruleAuthenticationPolicy= ruleAuthenticationPolicy EOF ;
    public final EObject entryRuleAuthenticationPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthenticationPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3395:2: (iv_ruleAuthenticationPolicy= ruleAuthenticationPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3396:2: iv_ruleAuthenticationPolicy= ruleAuthenticationPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAuthenticationPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthenticationPolicy_in_entryRuleAuthenticationPolicy6778);
            iv_ruleAuthenticationPolicy=ruleAuthenticationPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAuthenticationPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAuthenticationPolicy6788); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAuthenticationPolicy"


    // $ANTLR start "ruleAuthenticationPolicy"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3403:1: ruleAuthenticationPolicy returns [EObject current=null] : ( () otherlv_1= 'authn-policy' ( (lv_name_2_0= RULE_ID ) )? ( (lv_optional_3_0= 'optional' ) )? otherlv_4= '{' otherlv_5= 'auth-tokens' otherlv_6= '{' ( (lv_authTokens_7_0= ruleAuthToken ) )+ otherlv_8= '}' otherlv_9= 'hash-algorithms' otherlv_10= '{' ( (lv_hashAlgorithms_11_0= ruleHashAlgorithm ) )* otherlv_12= '}' ( (lv_useNonce_13_0= 'use-nonce' ) )? (otherlv_14= 'issuer' ( (lv_issuer_15_0= RULE_STRING ) ) )? otherlv_16= '}' ) ;
    public final EObject ruleAuthenticationPolicy() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token lv_optional_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token lv_useNonce_13_0=null;
        Token otherlv_14=null;
        Token lv_issuer_15_0=null;
        Token otherlv_16=null;
        EObject lv_authTokens_7_0 = null;

        EObject lv_hashAlgorithms_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3406:28: ( ( () otherlv_1= 'authn-policy' ( (lv_name_2_0= RULE_ID ) )? ( (lv_optional_3_0= 'optional' ) )? otherlv_4= '{' otherlv_5= 'auth-tokens' otherlv_6= '{' ( (lv_authTokens_7_0= ruleAuthToken ) )+ otherlv_8= '}' otherlv_9= 'hash-algorithms' otherlv_10= '{' ( (lv_hashAlgorithms_11_0= ruleHashAlgorithm ) )* otherlv_12= '}' ( (lv_useNonce_13_0= 'use-nonce' ) )? (otherlv_14= 'issuer' ( (lv_issuer_15_0= RULE_STRING ) ) )? otherlv_16= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3407:1: ( () otherlv_1= 'authn-policy' ( (lv_name_2_0= RULE_ID ) )? ( (lv_optional_3_0= 'optional' ) )? otherlv_4= '{' otherlv_5= 'auth-tokens' otherlv_6= '{' ( (lv_authTokens_7_0= ruleAuthToken ) )+ otherlv_8= '}' otherlv_9= 'hash-algorithms' otherlv_10= '{' ( (lv_hashAlgorithms_11_0= ruleHashAlgorithm ) )* otherlv_12= '}' ( (lv_useNonce_13_0= 'use-nonce' ) )? (otherlv_14= 'issuer' ( (lv_issuer_15_0= RULE_STRING ) ) )? otherlv_16= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3407:1: ( () otherlv_1= 'authn-policy' ( (lv_name_2_0= RULE_ID ) )? ( (lv_optional_3_0= 'optional' ) )? otherlv_4= '{' otherlv_5= 'auth-tokens' otherlv_6= '{' ( (lv_authTokens_7_0= ruleAuthToken ) )+ otherlv_8= '}' otherlv_9= 'hash-algorithms' otherlv_10= '{' ( (lv_hashAlgorithms_11_0= ruleHashAlgorithm ) )* otherlv_12= '}' ( (lv_useNonce_13_0= 'use-nonce' ) )? (otherlv_14= 'issuer' ( (lv_issuer_15_0= RULE_STRING ) ) )? otherlv_16= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3407:2: () otherlv_1= 'authn-policy' ( (lv_name_2_0= RULE_ID ) )? ( (lv_optional_3_0= 'optional' ) )? otherlv_4= '{' otherlv_5= 'auth-tokens' otherlv_6= '{' ( (lv_authTokens_7_0= ruleAuthToken ) )+ otherlv_8= '}' otherlv_9= 'hash-algorithms' otherlv_10= '{' ( (lv_hashAlgorithms_11_0= ruleHashAlgorithm ) )* otherlv_12= '}' ( (lv_useNonce_13_0= 'use-nonce' ) )? (otherlv_14= 'issuer' ( (lv_issuer_15_0= RULE_STRING ) ) )? otherlv_16= '}'
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3407:2: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3408:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAuthenticationPolicyAccess().getAuthenticationPolicyAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleAuthenticationPolicy6837); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAuthenticationPolicyAccess().getAuthnPolicyKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3420:1: ( (lv_name_2_0= RULE_ID ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==RULE_ID) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3421:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3421:1: (lv_name_2_0= RULE_ID )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3422:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAuthenticationPolicy6854); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_2_0, grammarAccess.getAuthenticationPolicyAccess().getNameIDTerminalRuleCall_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAuthenticationPolicyRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_2_0, 
                              		"ID");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3438:3: ( (lv_optional_3_0= 'optional' ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==70) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3439:1: (lv_optional_3_0= 'optional' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3439:1: (lv_optional_3_0= 'optional' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3440:3: lv_optional_3_0= 'optional'
                    {
                    lv_optional_3_0=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleAuthenticationPolicy6878); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_optional_3_0, grammarAccess.getAuthenticationPolicyAccess().getOptionalOptionalKeyword_3_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAuthenticationPolicyRule());
                      	        }
                             		setWithLastConsumed(current, "optional", true, "optional");
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAuthenticationPolicy6904); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getAuthenticationPolicyAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleAuthenticationPolicy6916); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getAuthenticationPolicyAccess().getAuthTokensKeyword_5());
                  
            }
            otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAuthenticationPolicy6928); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getAuthenticationPolicyAccess().getLeftCurlyBracketKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3465:1: ( (lv_authTokens_7_0= ruleAuthToken ) )+
            int cnt98=0;
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==70||(LA98_0>=160 && LA98_0<=168)) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3466:1: (lv_authTokens_7_0= ruleAuthToken )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3466:1: (lv_authTokens_7_0= ruleAuthToken )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3467:3: lv_authTokens_7_0= ruleAuthToken
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAuthenticationPolicyAccess().getAuthTokensAuthTokenParserRuleCall_7_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAuthToken_in_ruleAuthenticationPolicy6949);
            	    lv_authTokens_7_0=ruleAuthToken();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAuthenticationPolicyRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"authTokens",
            	              		lv_authTokens_7_0, 
            	              		"AuthToken");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt98 >= 1 ) break loop98;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(98, input);
                        throw eee;
                }
                cnt98++;
            } while (true);

            otherlv_8=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAuthenticationPolicy6962); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getAuthenticationPolicyAccess().getRightCurlyBracketKeyword_8());
                  
            }
            otherlv_9=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleAuthenticationPolicy6974); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getAuthenticationPolicyAccess().getHashAlgorithmsKeyword_9());
                  
            }
            otherlv_10=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAuthenticationPolicy6986); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getAuthenticationPolicyAccess().getLeftCurlyBracketKeyword_10());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3495:1: ( (lv_hashAlgorithms_11_0= ruleHashAlgorithm ) )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==70||LA99_0==75||(LA99_0>=141 && LA99_0<=145)) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3496:1: (lv_hashAlgorithms_11_0= ruleHashAlgorithm )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3496:1: (lv_hashAlgorithms_11_0= ruleHashAlgorithm )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3497:3: lv_hashAlgorithms_11_0= ruleHashAlgorithm
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAuthenticationPolicyAccess().getHashAlgorithmsHashAlgorithmParserRuleCall_11_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleHashAlgorithm_in_ruleAuthenticationPolicy7007);
            	    lv_hashAlgorithms_11_0=ruleHashAlgorithm();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAuthenticationPolicyRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"hashAlgorithms",
            	              		lv_hashAlgorithms_11_0, 
            	              		"HashAlgorithm");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop99;
                }
            } while (true);

            otherlv_12=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAuthenticationPolicy7020); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getAuthenticationPolicyAccess().getRightCurlyBracketKeyword_12());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3517:1: ( (lv_useNonce_13_0= 'use-nonce' ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==73) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3518:1: (lv_useNonce_13_0= 'use-nonce' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3518:1: (lv_useNonce_13_0= 'use-nonce' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3519:3: lv_useNonce_13_0= 'use-nonce'
                    {
                    lv_useNonce_13_0=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleAuthenticationPolicy7038); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_useNonce_13_0, grammarAccess.getAuthenticationPolicyAccess().getUseNonceUseNonceKeyword_13_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAuthenticationPolicyRule());
                      	        }
                             		setWithLastConsumed(current, "useNonce", true, "use-nonce");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3532:3: (otherlv_14= 'issuer' ( (lv_issuer_15_0= RULE_STRING ) ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==74) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3532:5: otherlv_14= 'issuer' ( (lv_issuer_15_0= RULE_STRING ) )
                    {
                    otherlv_14=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleAuthenticationPolicy7065); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getAuthenticationPolicyAccess().getIssuerKeyword_14_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3536:1: ( (lv_issuer_15_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3537:1: (lv_issuer_15_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3537:1: (lv_issuer_15_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3538:3: lv_issuer_15_0= RULE_STRING
                    {
                    lv_issuer_15_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAuthenticationPolicy7082); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_issuer_15_0, grammarAccess.getAuthenticationPolicyAccess().getIssuerSTRINGTerminalRuleCall_14_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAuthenticationPolicyRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"issuer",
                              		lv_issuer_15_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAuthenticationPolicy7101); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_16, grammarAccess.getAuthenticationPolicyAccess().getRightCurlyBracketKeyword_15());
                  
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
    // $ANTLR end "ruleAuthenticationPolicy"


    // $ANTLR start "entryRuleAuthToken"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3566:1: entryRuleAuthToken returns [EObject current=null] : iv_ruleAuthToken= ruleAuthToken EOF ;
    public final EObject entryRuleAuthToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthToken = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3567:2: (iv_ruleAuthToken= ruleAuthToken EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3568:2: iv_ruleAuthToken= ruleAuthToken EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAuthTokenRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthToken_in_entryRuleAuthToken7137);
            iv_ruleAuthToken=ruleAuthToken();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAuthToken; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAuthToken7147); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3575:1: ruleAuthToken returns [EObject current=null] : ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) ) ;
    public final EObject ruleAuthToken() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Enumerator lv_kind_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3578:28: ( ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3579:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3579:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3579:2: ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3579:2: ( (lv_optional_0_0= 'optional' ) )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==70) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3580:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3580:1: (lv_optional_0_0= 'optional' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3581:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleAuthToken7190); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3594:3: ( (lv_kind_1_0= ruleAuthTokenKind ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3595:1: (lv_kind_1_0= ruleAuthTokenKind )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3595:1: (lv_kind_1_0= ruleAuthTokenKind )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3596:3: lv_kind_1_0= ruleAuthTokenKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAuthTokenAccess().getKindAuthTokenKindEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthTokenKind_in_ruleAuthToken7225);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3620:1: entryRuleHashAlgorithm returns [EObject current=null] : iv_ruleHashAlgorithm= ruleHashAlgorithm EOF ;
    public final EObject entryRuleHashAlgorithm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHashAlgorithm = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3621:2: (iv_ruleHashAlgorithm= ruleHashAlgorithm EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3622:2: iv_ruleHashAlgorithm= ruleHashAlgorithm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHashAlgorithmRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleHashAlgorithm_in_entryRuleHashAlgorithm7261);
            iv_ruleHashAlgorithm=ruleHashAlgorithm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHashAlgorithm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHashAlgorithm7271); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3629:1: ruleHashAlgorithm returns [EObject current=null] : ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) ) ;
    public final EObject ruleHashAlgorithm() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Token lv_useBase64_1_0=null;
        Enumerator lv_kind_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3632:28: ( ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3633:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3633:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3633:2: ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3633:2: ( (lv_optional_0_0= 'optional' ) )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==70) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3634:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3634:1: (lv_optional_0_0= 'optional' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3635:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleHashAlgorithm7314); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3648:3: ( (lv_useBase64_1_0= 'Base64-encoded' ) )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==75) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3649:1: (lv_useBase64_1_0= 'Base64-encoded' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3649:1: (lv_useBase64_1_0= 'Base64-encoded' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3650:3: lv_useBase64_1_0= 'Base64-encoded'
                    {
                    lv_useBase64_1_0=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleHashAlgorithm7346); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3663:3: ( (lv_kind_2_0= ruleHashAlgKind ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3664:1: (lv_kind_2_0= ruleHashAlgKind )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3664:1: (lv_kind_2_0= ruleHashAlgKind )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3665:3: lv_kind_2_0= ruleHashAlgKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getHashAlgorithmAccess().getKindHashAlgKindEnumRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleHashAlgKind_in_ruleHashAlgorithm7381);
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


    // $ANTLR start "entryRuleSigningPolicy"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3689:1: entryRuleSigningPolicy returns [EObject current=null] : iv_ruleSigningPolicy= ruleSigningPolicy EOF ;
    public final EObject entryRuleSigningPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSigningPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3690:2: (iv_ruleSigningPolicy= ruleSigningPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3691:2: iv_ruleSigningPolicy= ruleSigningPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSigningPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSigningPolicy_in_entryRuleSigningPolicy7417);
            iv_ruleSigningPolicy=ruleSigningPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSigningPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSigningPolicy7427); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSigningPolicy"


    // $ANTLR start "ruleSigningPolicy"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3698:1: ruleSigningPolicy returns [EObject current=null] : ( () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' ) ;
    public final EObject ruleSigningPolicy() throws RecognitionException {
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3701:28: ( ( () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3702:1: ( () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3702:1: ( () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3702:2: () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}'
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3702:2: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3703:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getSigningPolicyAccess().getSigningPolicyAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleSigningPolicy7476); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSigningPolicyAccess().getSigningPolicyKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSigningPolicy7488); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getSigningPolicyAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3719:1: (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==77) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3719:3: otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+
                    {
                    otherlv_3=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleSigningPolicy7501); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getSigningPolicyAccess().getSupportedAlgorithmsKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3723:1: ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+
                    int cnt105=0;
                    loop105:
                    do {
                        int alt105=2;
                        int LA105_0 = input.LA(1);

                        if ( ((LA105_0>=141 && LA105_0<=143)||(LA105_0>=150 && LA105_0<=154)) ) {
                            alt105=1;
                        }


                        switch (alt105) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3724:1: (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3724:1: (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3725:3: lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSigningPolicyAccess().getSupportedSigningAlgorithmsSigningAlgothmEnumRuleCall_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleSigningAlgothm_in_ruleSigningPolicy7522);
                    	    lv_supportedSigningAlgorithms_4_0=ruleSigningAlgothm();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSigningPolicyRule());
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
                    	    if ( cnt105 >= 1 ) break loop105;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(105, input);
                                throw eee;
                        }
                        cnt105++;
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3741:5: (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==78) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3741:7: otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) )
                    {
                    otherlv_5=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleSigningPolicy7538); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSigningPolicyAccess().getRequiresAlgorithmKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3745:1: ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3746:1: (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3746:1: (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3747:3: lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSigningPolicyAccess().getRequiredSigningAlgorithmSigningAlgothmEnumRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSigningAlgothm_in_ruleSigningPolicy7559);
                    lv_requiredSigningAlgorithm_6_0=ruleSigningAlgothm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSigningPolicyRule());
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3763:4: (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==79) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3763:6: otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )*
                    {
                    otherlv_7=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleSigningPolicy7574); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getSigningPolicyAccess().getSignedMessagePartsKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3767:1: ( (lv_signedParts_8_0= ruleMessagePartRef ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3768:1: (lv_signedParts_8_0= ruleMessagePartRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3768:1: (lv_signedParts_8_0= ruleMessagePartRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3769:3: lv_signedParts_8_0= ruleMessagePartRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSigningPolicyAccess().getSignedPartsMessagePartRefParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_ruleSigningPolicy7595);
                    lv_signedParts_8_0=ruleMessagePartRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSigningPolicyRule());
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

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3785:2: (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )*
                    loop108:
                    do {
                        int alt108=2;
                        int LA108_0 = input.LA(1);

                        if ( (LA108_0==12) ) {
                            alt108=1;
                        }


                        switch (alt108) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3785:4: otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) )
                    	    {
                    	    otherlv_9=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSigningPolicy7608); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getSigningPolicyAccess().getCommaKeyword_5_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3789:1: ( (lv_signedParts_10_0= ruleMessagePartRef ) )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3790:1: (lv_signedParts_10_0= ruleMessagePartRef )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3790:1: (lv_signedParts_10_0= ruleMessagePartRef )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3791:3: lv_signedParts_10_0= ruleMessagePartRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSigningPolicyAccess().getSignedPartsMessagePartRefParserRuleCall_5_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_ruleSigningPolicy7629);
                    	    lv_signedParts_10_0=ruleMessagePartRef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getSigningPolicyRule());
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
                    	    break loop108;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSigningPolicy7645); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getSigningPolicyAccess().getRightCurlyBracketKeyword_6());
                  
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
    // $ANTLR end "ruleSigningPolicy"


    // $ANTLR start "entryRuleMessagePartRef"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3819:1: entryRuleMessagePartRef returns [EObject current=null] : iv_ruleMessagePartRef= ruleMessagePartRef EOF ;
    public final EObject entryRuleMessagePartRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessagePartRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3820:2: (iv_ruleMessagePartRef= ruleMessagePartRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3821:2: iv_ruleMessagePartRef= ruleMessagePartRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMessagePartRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_entryRuleMessagePartRef7681);
            iv_ruleMessagePartRef=ruleMessagePartRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMessagePartRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMessagePartRef7691); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3828:1: ruleMessagePartRef returns [EObject current=null] : ( ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleMessagePartRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_partRefExpression_2_0=null;
        Enumerator lv_messagePartRef_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3831:28: ( ( ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3832:1: ( ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3832:1: ( ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3832:2: ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )?
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3832:2: ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3833:1: (lv_messagePartRef_0_0= ruleMessagePartRefKind )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3833:1: (lv_messagePartRef_0_0= ruleMessagePartRefKind )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3834:3: lv_messagePartRef_0_0= ruleMessagePartRefKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMessagePartRefAccess().getMessagePartRefMessagePartRefKindEnumRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleMessagePartRefKind_in_ruleMessagePartRef7737);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3850:2: (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==80) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3850:4: otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleMessagePartRef7750); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMessagePartRefAccess().getExpressionKeyword_1_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3854:1: ( (lv_partRefExpression_2_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3855:1: (lv_partRefExpression_2_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3855:1: (lv_partRefExpression_2_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3856:3: lv_partRefExpression_2_0= RULE_STRING
                    {
                    lv_partRefExpression_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMessagePartRef7767); if (state.failed) return current;
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


    // $ANTLR start "entryRuleEncryptionPolicy"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3880:1: entryRuleEncryptionPolicy returns [EObject current=null] : iv_ruleEncryptionPolicy= ruleEncryptionPolicy EOF ;
    public final EObject entryRuleEncryptionPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEncryptionPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3881:2: (iv_ruleEncryptionPolicy= ruleEncryptionPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3882:2: iv_ruleEncryptionPolicy= ruleEncryptionPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEncryptionPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEncryptionPolicy_in_entryRuleEncryptionPolicy7810);
            iv_ruleEncryptionPolicy=ruleEncryptionPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEncryptionPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEncryptionPolicy7820); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEncryptionPolicy"


    // $ANTLR start "ruleEncryptionPolicy"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3889:1: ruleEncryptionPolicy returns [EObject current=null] : ( () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' ) ;
    public final EObject ruleEncryptionPolicy() throws RecognitionException {
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3892:28: ( ( () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3893:1: ( () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3893:1: ( () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3893:2: () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}'
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3893:2: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3894:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEncryptionPolicyAccess().getEncryptionPolicyAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleEncryptionPolicy7869); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEncryptionPolicyAccess().getEncryptionPolicyKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleEncryptionPolicy7881); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getEncryptionPolicyAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3910:1: (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==77) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3910:3: otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+
                    {
                    otherlv_3=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleEncryptionPolicy7894); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getEncryptionPolicyAccess().getSupportedAlgorithmsKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3914:1: ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+
                    int cnt111=0;
                    loop111:
                    do {
                        int alt111=2;
                        int LA111_0 = input.LA(1);

                        if ( (LA111_0==150||LA111_0==152||(LA111_0>=154 && LA111_0<=159)) ) {
                            alt111=1;
                        }


                        switch (alt111) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3915:1: (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3915:1: (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3916:3: lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getEncryptionPolicyAccess().getSupportedCipherAlgorithmsCipherAlgorithmKindEnumRuleCall_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCipherAlgorithmKind_in_ruleEncryptionPolicy7915);
                    	    lv_supportedCipherAlgorithms_4_0=ruleCipherAlgorithmKind();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getEncryptionPolicyRule());
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
                    	    if ( cnt111 >= 1 ) break loop111;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(111, input);
                                throw eee;
                        }
                        cnt111++;
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3932:5: (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==78) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3932:7: otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) )
                    {
                    otherlv_5=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleEncryptionPolicy7931); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getEncryptionPolicyAccess().getRequiresAlgorithmKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3936:1: ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3937:1: (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3937:1: (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3938:3: lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEncryptionPolicyAccess().getRequiredCipherAlgorithmCipherAlgorithmKindEnumRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCipherAlgorithmKind_in_ruleEncryptionPolicy7952);
                    lv_requiredCipherAlgorithm_6_0=ruleCipherAlgorithmKind();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEncryptionPolicyRule());
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3954:4: (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==82) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3954:6: otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )*
                    {
                    otherlv_7=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleEncryptionPolicy7967); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getEncryptionPolicyAccess().getEncryptedMessagePartsKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3958:1: ( (lv_encryptedParts_8_0= ruleMessagePartRef ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3959:1: (lv_encryptedParts_8_0= ruleMessagePartRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3959:1: (lv_encryptedParts_8_0= ruleMessagePartRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3960:3: lv_encryptedParts_8_0= ruleMessagePartRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEncryptionPolicyAccess().getEncryptedPartsMessagePartRefParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_ruleEncryptionPolicy7988);
                    lv_encryptedParts_8_0=ruleMessagePartRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEncryptionPolicyRule());
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

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3976:2: (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )*
                    loop114:
                    do {
                        int alt114=2;
                        int LA114_0 = input.LA(1);

                        if ( (LA114_0==12) ) {
                            alt114=1;
                        }


                        switch (alt114) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3976:4: otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) )
                    	    {
                    	    otherlv_9=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEncryptionPolicy8001); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getEncryptionPolicyAccess().getCommaKeyword_5_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3980:1: ( (lv_encryptedParts_10_0= ruleMessagePartRef ) )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3981:1: (lv_encryptedParts_10_0= ruleMessagePartRef )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3981:1: (lv_encryptedParts_10_0= ruleMessagePartRef )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3982:3: lv_encryptedParts_10_0= ruleMessagePartRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getEncryptionPolicyAccess().getEncryptedPartsMessagePartRefParserRuleCall_5_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_ruleEncryptionPolicy8022);
                    	    lv_encryptedParts_10_0=ruleMessagePartRef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getEncryptionPolicyRule());
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
                    	    break loop114;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleEncryptionPolicy8038); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getEncryptionPolicyAccess().getRightCurlyBracketKeyword_6());
                  
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
    // $ANTLR end "ruleEncryptionPolicy"


    // $ANTLR start "entryRuleAssertion"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4010:1: entryRuleAssertion returns [EObject current=null] : iv_ruleAssertion= ruleAssertion EOF ;
    public final EObject entryRuleAssertion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssertion = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4011:2: (iv_ruleAssertion= ruleAssertion EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4012:2: iv_ruleAssertion= ruleAssertion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssertionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAssertion_in_entryRuleAssertion8074);
            iv_ruleAssertion=ruleAssertion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssertion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssertion8084); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssertion"


    // $ANTLR start "ruleAssertion"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4019:1: ruleAssertion returns [EObject current=null] : (this_AvailabilityAssertion_0= ruleAvailabilityAssertion | this_LatencyAssertion_1= ruleLatencyAssertion | this_CapacityAssertion_2= ruleCapacityAssertion | this_ReliablityAsserttion_3= ruleReliablityAsserttion | this_CostAssertion_4= ruleCostAssertion | this_AccuracyAssertion_5= ruleAccuracyAssertion ) ;
    public final EObject ruleAssertion() throws RecognitionException {
        EObject current = null;

        EObject this_AvailabilityAssertion_0 = null;

        EObject this_LatencyAssertion_1 = null;

        EObject this_CapacityAssertion_2 = null;

        EObject this_ReliablityAsserttion_3 = null;

        EObject this_CostAssertion_4 = null;

        EObject this_AccuracyAssertion_5 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4022:28: ( (this_AvailabilityAssertion_0= ruleAvailabilityAssertion | this_LatencyAssertion_1= ruleLatencyAssertion | this_CapacityAssertion_2= ruleCapacityAssertion | this_ReliablityAsserttion_3= ruleReliablityAsserttion | this_CostAssertion_4= ruleCostAssertion | this_AccuracyAssertion_5= ruleAccuracyAssertion ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4023:1: (this_AvailabilityAssertion_0= ruleAvailabilityAssertion | this_LatencyAssertion_1= ruleLatencyAssertion | this_CapacityAssertion_2= ruleCapacityAssertion | this_ReliablityAsserttion_3= ruleReliablityAsserttion | this_CostAssertion_4= ruleCostAssertion | this_AccuracyAssertion_5= ruleAccuracyAssertion )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4023:1: (this_AvailabilityAssertion_0= ruleAvailabilityAssertion | this_LatencyAssertion_1= ruleLatencyAssertion | this_CapacityAssertion_2= ruleCapacityAssertion | this_ReliablityAsserttion_3= ruleReliablityAsserttion | this_CostAssertion_4= ruleCostAssertion | this_AccuracyAssertion_5= ruleAccuracyAssertion )
            int alt116=6;
            alt116 = dfa116.predict(input);
            switch (alt116) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4024:2: this_AvailabilityAssertion_0= ruleAvailabilityAssertion
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAssertionAccess().getAvailabilityAssertionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAvailabilityAssertion_in_ruleAssertion8134);
                    this_AvailabilityAssertion_0=ruleAvailabilityAssertion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AvailabilityAssertion_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4037:2: this_LatencyAssertion_1= ruleLatencyAssertion
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAssertionAccess().getLatencyAssertionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLatencyAssertion_in_ruleAssertion8164);
                    this_LatencyAssertion_1=ruleLatencyAssertion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LatencyAssertion_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4050:2: this_CapacityAssertion_2= ruleCapacityAssertion
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAssertionAccess().getCapacityAssertionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCapacityAssertion_in_ruleAssertion8194);
                    this_CapacityAssertion_2=ruleCapacityAssertion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CapacityAssertion_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4063:2: this_ReliablityAsserttion_3= ruleReliablityAsserttion
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAssertionAccess().getReliablityAsserttionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleReliablityAsserttion_in_ruleAssertion8224);
                    this_ReliablityAsserttion_3=ruleReliablityAsserttion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ReliablityAsserttion_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4076:2: this_CostAssertion_4= ruleCostAssertion
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAssertionAccess().getCostAssertionParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCostAssertion_in_ruleAssertion8254);
                    this_CostAssertion_4=ruleCostAssertion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CostAssertion_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4089:2: this_AccuracyAssertion_5= ruleAccuracyAssertion
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAssertionAccess().getAccuracyAssertionParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAccuracyAssertion_in_ruleAssertion8284);
                    this_AccuracyAssertion_5=ruleAccuracyAssertion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AccuracyAssertion_5; 
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
    // $ANTLR end "ruleAssertion"


    // $ANTLR start "entryRuleAvailabilityAssertion"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4108:1: entryRuleAvailabilityAssertion returns [EObject current=null] : iv_ruleAvailabilityAssertion= ruleAvailabilityAssertion EOF ;
    public final EObject entryRuleAvailabilityAssertion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAvailabilityAssertion = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4109:2: (iv_ruleAvailabilityAssertion= ruleAvailabilityAssertion EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4110:2: iv_ruleAvailabilityAssertion= ruleAvailabilityAssertion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAvailabilityAssertionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAvailabilityAssertion_in_entryRuleAvailabilityAssertion8319);
            iv_ruleAvailabilityAssertion=ruleAvailabilityAssertion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAvailabilityAssertion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAvailabilityAssertion8329); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAvailabilityAssertion"


    // $ANTLR start "ruleAvailabilityAssertion"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4117:1: ruleAvailabilityAssertion returns [EObject current=null] : ( () (otherlv_1= 'availability' ( (lv_availability_2_0= RULE_STRING ) ) )? (otherlv_3= 'mean-time-between-failure' ( (lv_mtbf_4_0= RULE_STRING ) ) )? (otherlv_5= 'mean-time-to-repair' ( (lv_mttr_6_0= RULE_STRING ) ) ( (lv_mttrPercentile_7_0= rulePercentile ) )? )? (otherlv_8= 'regular-down-times' ( (lv_regularDownTimes_9_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleAvailabilityAssertion() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_availability_2_0=null;
        Token otherlv_3=null;
        Token lv_mtbf_4_0=null;
        Token otherlv_5=null;
        Token lv_mttr_6_0=null;
        Token otherlv_8=null;
        Token lv_regularDownTimes_9_0=null;
        EObject lv_mttrPercentile_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4120:28: ( ( () (otherlv_1= 'availability' ( (lv_availability_2_0= RULE_STRING ) ) )? (otherlv_3= 'mean-time-between-failure' ( (lv_mtbf_4_0= RULE_STRING ) ) )? (otherlv_5= 'mean-time-to-repair' ( (lv_mttr_6_0= RULE_STRING ) ) ( (lv_mttrPercentile_7_0= rulePercentile ) )? )? (otherlv_8= 'regular-down-times' ( (lv_regularDownTimes_9_0= RULE_STRING ) ) )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4121:1: ( () (otherlv_1= 'availability' ( (lv_availability_2_0= RULE_STRING ) ) )? (otherlv_3= 'mean-time-between-failure' ( (lv_mtbf_4_0= RULE_STRING ) ) )? (otherlv_5= 'mean-time-to-repair' ( (lv_mttr_6_0= RULE_STRING ) ) ( (lv_mttrPercentile_7_0= rulePercentile ) )? )? (otherlv_8= 'regular-down-times' ( (lv_regularDownTimes_9_0= RULE_STRING ) ) )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4121:1: ( () (otherlv_1= 'availability' ( (lv_availability_2_0= RULE_STRING ) ) )? (otherlv_3= 'mean-time-between-failure' ( (lv_mtbf_4_0= RULE_STRING ) ) )? (otherlv_5= 'mean-time-to-repair' ( (lv_mttr_6_0= RULE_STRING ) ) ( (lv_mttrPercentile_7_0= rulePercentile ) )? )? (otherlv_8= 'regular-down-times' ( (lv_regularDownTimes_9_0= RULE_STRING ) ) )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4121:2: () (otherlv_1= 'availability' ( (lv_availability_2_0= RULE_STRING ) ) )? (otherlv_3= 'mean-time-between-failure' ( (lv_mtbf_4_0= RULE_STRING ) ) )? (otherlv_5= 'mean-time-to-repair' ( (lv_mttr_6_0= RULE_STRING ) ) ( (lv_mttrPercentile_7_0= rulePercentile ) )? )? (otherlv_8= 'regular-down-times' ( (lv_regularDownTimes_9_0= RULE_STRING ) ) )?
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4121:2: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4122:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAvailabilityAssertionAccess().getAvailabilityAssertionAction_0(),
                          current);
                  
            }

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4130:2: (otherlv_1= 'availability' ( (lv_availability_2_0= RULE_STRING ) ) )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==83) ) {
                int LA117_1 = input.LA(2);

                if ( (synpred132_InternalBindingDsl()) ) {
                    alt117=1;
                }
            }
            switch (alt117) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4130:4: otherlv_1= 'availability' ( (lv_availability_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleAvailabilityAssertion8379); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getAvailabilityAssertionAccess().getAvailabilityKeyword_1_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4134:1: ( (lv_availability_2_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4135:1: (lv_availability_2_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4135:1: (lv_availability_2_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4136:3: lv_availability_2_0= RULE_STRING
                    {
                    lv_availability_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAvailabilityAssertion8396); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_availability_2_0, grammarAccess.getAvailabilityAssertionAccess().getAvailabilitySTRINGTerminalRuleCall_1_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAvailabilityAssertionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"availability",
                              		lv_availability_2_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4152:4: (otherlv_3= 'mean-time-between-failure' ( (lv_mtbf_4_0= RULE_STRING ) ) )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==84) ) {
                int LA118_1 = input.LA(2);

                if ( (synpred133_InternalBindingDsl()) ) {
                    alt118=1;
                }
            }
            switch (alt118) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4152:6: otherlv_3= 'mean-time-between-failure' ( (lv_mtbf_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,84,FollowSets000.FOLLOW_84_in_ruleAvailabilityAssertion8416); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getAvailabilityAssertionAccess().getMeanTimeBetweenFailureKeyword_2_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4156:1: ( (lv_mtbf_4_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4157:1: (lv_mtbf_4_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4157:1: (lv_mtbf_4_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4158:3: lv_mtbf_4_0= RULE_STRING
                    {
                    lv_mtbf_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAvailabilityAssertion8433); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_mtbf_4_0, grammarAccess.getAvailabilityAssertionAccess().getMtbfSTRINGTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAvailabilityAssertionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"mtbf",
                              		lv_mtbf_4_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4174:4: (otherlv_5= 'mean-time-to-repair' ( (lv_mttr_6_0= RULE_STRING ) ) ( (lv_mttrPercentile_7_0= rulePercentile ) )? )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==85) ) {
                int LA120_1 = input.LA(2);

                if ( (synpred135_InternalBindingDsl()) ) {
                    alt120=1;
                }
            }
            switch (alt120) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4174:6: otherlv_5= 'mean-time-to-repair' ( (lv_mttr_6_0= RULE_STRING ) ) ( (lv_mttrPercentile_7_0= rulePercentile ) )?
                    {
                    otherlv_5=(Token)match(input,85,FollowSets000.FOLLOW_85_in_ruleAvailabilityAssertion8453); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getAvailabilityAssertionAccess().getMeanTimeToRepairKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4178:1: ( (lv_mttr_6_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4179:1: (lv_mttr_6_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4179:1: (lv_mttr_6_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4180:3: lv_mttr_6_0= RULE_STRING
                    {
                    lv_mttr_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAvailabilityAssertion8470); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_mttr_6_0, grammarAccess.getAvailabilityAssertionAccess().getMttrSTRINGTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAvailabilityAssertionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"mttr",
                              		lv_mttr_6_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4196:2: ( (lv_mttrPercentile_7_0= rulePercentile ) )?
                    int alt119=2;
                    int LA119_0 = input.LA(1);

                    if ( (LA119_0==RULE_INT) ) {
                        alt119=1;
                    }
                    switch (alt119) {
                        case 1 :
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4197:1: (lv_mttrPercentile_7_0= rulePercentile )
                            {
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4197:1: (lv_mttrPercentile_7_0= rulePercentile )
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4198:3: lv_mttrPercentile_7_0= rulePercentile
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAvailabilityAssertionAccess().getMttrPercentilePercentileParserRuleCall_3_2_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_rulePercentile_in_ruleAvailabilityAssertion8496);
                            lv_mttrPercentile_7_0=rulePercentile();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getAvailabilityAssertionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"mttrPercentile",
                                      		lv_mttrPercentile_7_0, 
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4214:5: (otherlv_8= 'regular-down-times' ( (lv_regularDownTimes_9_0= RULE_STRING ) ) )?
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==86) ) {
                int LA121_1 = input.LA(2);

                if ( (synpred136_InternalBindingDsl()) ) {
                    alt121=1;
                }
            }
            switch (alt121) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4214:7: otherlv_8= 'regular-down-times' ( (lv_regularDownTimes_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,86,FollowSets000.FOLLOW_86_in_ruleAvailabilityAssertion8512); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getAvailabilityAssertionAccess().getRegularDownTimesKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4218:1: ( (lv_regularDownTimes_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4219:1: (lv_regularDownTimes_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4219:1: (lv_regularDownTimes_9_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4220:3: lv_regularDownTimes_9_0= RULE_STRING
                    {
                    lv_regularDownTimes_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAvailabilityAssertion8529); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_regularDownTimes_9_0, grammarAccess.getAvailabilityAssertionAccess().getRegularDownTimesSTRINGTerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAvailabilityAssertionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"regularDownTimes",
                              		lv_regularDownTimes_9_0, 
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
    // $ANTLR end "ruleAvailabilityAssertion"


    // $ANTLR start "entryRuleLatencyAssertion"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4244:1: entryRuleLatencyAssertion returns [EObject current=null] : iv_ruleLatencyAssertion= ruleLatencyAssertion EOF ;
    public final EObject entryRuleLatencyAssertion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLatencyAssertion = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4245:2: (iv_ruleLatencyAssertion= ruleLatencyAssertion EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4246:2: iv_ruleLatencyAssertion= ruleLatencyAssertion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLatencyAssertionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLatencyAssertion_in_entryRuleLatencyAssertion8572);
            iv_ruleLatencyAssertion=ruleLatencyAssertion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLatencyAssertion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLatencyAssertion8582); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLatencyAssertion"


    // $ANTLR start "ruleLatencyAssertion"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4253:1: ruleLatencyAssertion returns [EObject current=null] : (otherlv_0= 'latency' ( (lv_latency_1_0= 'STRING' ) ) otherlv_2= 'percentile' ( (lv_percentile_3_0= rulePercentile ) ) ) ;
    public final EObject ruleLatencyAssertion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_latency_1_0=null;
        Token otherlv_2=null;
        EObject lv_percentile_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4256:28: ( (otherlv_0= 'latency' ( (lv_latency_1_0= 'STRING' ) ) otherlv_2= 'percentile' ( (lv_percentile_3_0= rulePercentile ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4257:1: (otherlv_0= 'latency' ( (lv_latency_1_0= 'STRING' ) ) otherlv_2= 'percentile' ( (lv_percentile_3_0= rulePercentile ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4257:1: (otherlv_0= 'latency' ( (lv_latency_1_0= 'STRING' ) ) otherlv_2= 'percentile' ( (lv_percentile_3_0= rulePercentile ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4257:3: otherlv_0= 'latency' ( (lv_latency_1_0= 'STRING' ) ) otherlv_2= 'percentile' ( (lv_percentile_3_0= rulePercentile ) )
            {
            otherlv_0=(Token)match(input,87,FollowSets000.FOLLOW_87_in_ruleLatencyAssertion8619); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLatencyAssertionAccess().getLatencyKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4261:1: ( (lv_latency_1_0= 'STRING' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4262:1: (lv_latency_1_0= 'STRING' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4262:1: (lv_latency_1_0= 'STRING' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4263:3: lv_latency_1_0= 'STRING'
            {
            lv_latency_1_0=(Token)match(input,88,FollowSets000.FOLLOW_88_in_ruleLatencyAssertion8637); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_latency_1_0, grammarAccess.getLatencyAssertionAccess().getLatencySTRINGKeyword_1_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getLatencyAssertionRule());
              	        }
                     		setWithLastConsumed(current, "latency", lv_latency_1_0, "STRING");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,89,FollowSets000.FOLLOW_89_in_ruleLatencyAssertion8662); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getLatencyAssertionAccess().getPercentileKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4280:1: ( (lv_percentile_3_0= rulePercentile ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4281:1: (lv_percentile_3_0= rulePercentile )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4281:1: (lv_percentile_3_0= rulePercentile )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4282:3: lv_percentile_3_0= rulePercentile
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLatencyAssertionAccess().getPercentilePercentileParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePercentile_in_ruleLatencyAssertion8683);
            lv_percentile_3_0=rulePercentile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLatencyAssertionRule());
              	        }
                     		set(
                     			current, 
                     			"percentile",
                      		lv_percentile_3_0, 
                      		"Percentile");
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
    // $ANTLR end "ruleLatencyAssertion"


    // $ANTLR start "entryRuleCapacityAssertion"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4306:1: entryRuleCapacityAssertion returns [EObject current=null] : iv_ruleCapacityAssertion= ruleCapacityAssertion EOF ;
    public final EObject entryRuleCapacityAssertion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCapacityAssertion = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4307:2: (iv_ruleCapacityAssertion= ruleCapacityAssertion EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4308:2: iv_ruleCapacityAssertion= ruleCapacityAssertion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCapacityAssertionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCapacityAssertion_in_entryRuleCapacityAssertion8719);
            iv_ruleCapacityAssertion=ruleCapacityAssertion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCapacityAssertion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCapacityAssertion8729); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCapacityAssertion"


    // $ANTLR start "ruleCapacityAssertion"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4315:1: ruleCapacityAssertion returns [EObject current=null] : ( () (otherlv_1= 'num-of-requests' ( (lv_requestNum_2_0= RULE_STRING ) ) otherlv_3= 'per' ( (lv_timeUnit_4_0= RULE_STRING ) ) )? (otherlv_5= 'message-size' ( (lv_messageSize_6_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleCapacityAssertion() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_requestNum_2_0=null;
        Token otherlv_3=null;
        Token lv_timeUnit_4_0=null;
        Token otherlv_5=null;
        Token lv_messageSize_6_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4318:28: ( ( () (otherlv_1= 'num-of-requests' ( (lv_requestNum_2_0= RULE_STRING ) ) otherlv_3= 'per' ( (lv_timeUnit_4_0= RULE_STRING ) ) )? (otherlv_5= 'message-size' ( (lv_messageSize_6_0= RULE_STRING ) ) )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4319:1: ( () (otherlv_1= 'num-of-requests' ( (lv_requestNum_2_0= RULE_STRING ) ) otherlv_3= 'per' ( (lv_timeUnit_4_0= RULE_STRING ) ) )? (otherlv_5= 'message-size' ( (lv_messageSize_6_0= RULE_STRING ) ) )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4319:1: ( () (otherlv_1= 'num-of-requests' ( (lv_requestNum_2_0= RULE_STRING ) ) otherlv_3= 'per' ( (lv_timeUnit_4_0= RULE_STRING ) ) )? (otherlv_5= 'message-size' ( (lv_messageSize_6_0= RULE_STRING ) ) )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4319:2: () (otherlv_1= 'num-of-requests' ( (lv_requestNum_2_0= RULE_STRING ) ) otherlv_3= 'per' ( (lv_timeUnit_4_0= RULE_STRING ) ) )? (otherlv_5= 'message-size' ( (lv_messageSize_6_0= RULE_STRING ) ) )?
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4319:2: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4320:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getCapacityAssertionAccess().getCapacityAssertionAction_0(),
                          current);
                  
            }

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4328:2: (otherlv_1= 'num-of-requests' ( (lv_requestNum_2_0= RULE_STRING ) ) otherlv_3= 'per' ( (lv_timeUnit_4_0= RULE_STRING ) ) )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==90) ) {
                int LA122_1 = input.LA(2);

                if ( (synpred137_InternalBindingDsl()) ) {
                    alt122=1;
                }
            }
            switch (alt122) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4328:4: otherlv_1= 'num-of-requests' ( (lv_requestNum_2_0= RULE_STRING ) ) otherlv_3= 'per' ( (lv_timeUnit_4_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,90,FollowSets000.FOLLOW_90_in_ruleCapacityAssertion8779); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCapacityAssertionAccess().getNumOfRequestsKeyword_1_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4332:1: ( (lv_requestNum_2_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4333:1: (lv_requestNum_2_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4333:1: (lv_requestNum_2_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4334:3: lv_requestNum_2_0= RULE_STRING
                    {
                    lv_requestNum_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCapacityAssertion8796); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_requestNum_2_0, grammarAccess.getCapacityAssertionAccess().getRequestNumSTRINGTerminalRuleCall_1_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getCapacityAssertionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"requestNum",
                              		lv_requestNum_2_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,91,FollowSets000.FOLLOW_91_in_ruleCapacityAssertion8813); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getCapacityAssertionAccess().getPerKeyword_1_2());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4354:1: ( (lv_timeUnit_4_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4355:1: (lv_timeUnit_4_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4355:1: (lv_timeUnit_4_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4356:3: lv_timeUnit_4_0= RULE_STRING
                    {
                    lv_timeUnit_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCapacityAssertion8830); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_timeUnit_4_0, grammarAccess.getCapacityAssertionAccess().getTimeUnitSTRINGTerminalRuleCall_1_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getCapacityAssertionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"timeUnit",
                              		lv_timeUnit_4_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4372:4: (otherlv_5= 'message-size' ( (lv_messageSize_6_0= RULE_STRING ) ) )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==92) ) {
                int LA123_1 = input.LA(2);

                if ( (synpred138_InternalBindingDsl()) ) {
                    alt123=1;
                }
            }
            switch (alt123) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4372:6: otherlv_5= 'message-size' ( (lv_messageSize_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,92,FollowSets000.FOLLOW_92_in_ruleCapacityAssertion8850); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getCapacityAssertionAccess().getMessageSizeKeyword_2_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4376:1: ( (lv_messageSize_6_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4377:1: (lv_messageSize_6_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4377:1: (lv_messageSize_6_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4378:3: lv_messageSize_6_0= RULE_STRING
                    {
                    lv_messageSize_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCapacityAssertion8867); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_messageSize_6_0, grammarAccess.getCapacityAssertionAccess().getMessageSizeSTRINGTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getCapacityAssertionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"messageSize",
                              		lv_messageSize_6_0, 
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
    // $ANTLR end "ruleCapacityAssertion"


    // $ANTLR start "entryRuleReliablityAsserttion"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4402:1: entryRuleReliablityAsserttion returns [EObject current=null] : iv_ruleReliablityAsserttion= ruleReliablityAsserttion EOF ;
    public final EObject entryRuleReliablityAsserttion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReliablityAsserttion = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4403:2: (iv_ruleReliablityAsserttion= ruleReliablityAsserttion EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4404:2: iv_ruleReliablityAsserttion= ruleReliablityAsserttion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReliablityAsserttionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReliablityAsserttion_in_entryRuleReliablityAsserttion8910);
            iv_ruleReliablityAsserttion=ruleReliablityAsserttion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReliablityAsserttion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReliablityAsserttion8920); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReliablityAsserttion"


    // $ANTLR start "ruleReliablityAsserttion"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4411:1: ruleReliablityAsserttion returns [EObject current=null] : (otherlv_0= 'message-exchange-reliability' ( (lv_reliability_1_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_2_0= 'in-order-delivery' ) )? ) ;
    public final EObject ruleReliablityAsserttion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_inOrderDelivery_2_0=null;
        Enumerator lv_reliability_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4414:28: ( (otherlv_0= 'message-exchange-reliability' ( (lv_reliability_1_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_2_0= 'in-order-delivery' ) )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4415:1: (otherlv_0= 'message-exchange-reliability' ( (lv_reliability_1_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_2_0= 'in-order-delivery' ) )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4415:1: (otherlv_0= 'message-exchange-reliability' ( (lv_reliability_1_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_2_0= 'in-order-delivery' ) )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4415:3: otherlv_0= 'message-exchange-reliability' ( (lv_reliability_1_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_2_0= 'in-order-delivery' ) )?
            {
            otherlv_0=(Token)match(input,93,FollowSets000.FOLLOW_93_in_ruleReliablityAsserttion8957); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getReliablityAsserttionAccess().getMessageExchangeReliabilityKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4419:1: ( (lv_reliability_1_0= ruleReliablilityKind ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4420:1: (lv_reliability_1_0= ruleReliablilityKind )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4420:1: (lv_reliability_1_0= ruleReliablilityKind )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4421:3: lv_reliability_1_0= ruleReliablilityKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReliablityAsserttionAccess().getReliabilityReliablilityKindEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleReliablilityKind_in_ruleReliablityAsserttion8978);
            lv_reliability_1_0=ruleReliablilityKind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getReliablityAsserttionRule());
              	        }
                     		set(
                     			current, 
                     			"reliability",
                      		lv_reliability_1_0, 
                      		"ReliablilityKind");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4437:2: ( (lv_inOrderDelivery_2_0= 'in-order-delivery' ) )?
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==94) ) {
                alt124=1;
            }
            switch (alt124) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4438:1: (lv_inOrderDelivery_2_0= 'in-order-delivery' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4438:1: (lv_inOrderDelivery_2_0= 'in-order-delivery' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4439:3: lv_inOrderDelivery_2_0= 'in-order-delivery'
                    {
                    lv_inOrderDelivery_2_0=(Token)match(input,94,FollowSets000.FOLLOW_94_in_ruleReliablityAsserttion8996); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_inOrderDelivery_2_0, grammarAccess.getReliablityAsserttionAccess().getInOrderDeliveryInOrderDeliveryKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getReliablityAsserttionRule());
                      	        }
                             		setWithLastConsumed(current, "inOrderDelivery", true, "in-order-delivery");
                      	    
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
    // $ANTLR end "ruleReliablityAsserttion"


    // $ANTLR start "entryRuleCostAssertion"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4460:1: entryRuleCostAssertion returns [EObject current=null] : iv_ruleCostAssertion= ruleCostAssertion EOF ;
    public final EObject entryRuleCostAssertion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCostAssertion = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4461:2: (iv_ruleCostAssertion= ruleCostAssertion EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4462:2: iv_ruleCostAssertion= ruleCostAssertion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCostAssertionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCostAssertion_in_entryRuleCostAssertion9046);
            iv_ruleCostAssertion=ruleCostAssertion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCostAssertion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCostAssertion9056); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCostAssertion"


    // $ANTLR start "ruleCostAssertion"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4469:1: ruleCostAssertion returns [EObject current=null] : (otherlv_0= 'costs' ( (lv_costsAmount_1_0= RULE_STRING ) ) otherlv_2= 'billed-per-unit' ( (lv_billedUnit_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleCostAssertion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_costsAmount_1_0=null;
        Token otherlv_2=null;
        Token lv_billedUnit_3_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4472:28: ( (otherlv_0= 'costs' ( (lv_costsAmount_1_0= RULE_STRING ) ) otherlv_2= 'billed-per-unit' ( (lv_billedUnit_3_0= RULE_STRING ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4473:1: (otherlv_0= 'costs' ( (lv_costsAmount_1_0= RULE_STRING ) ) otherlv_2= 'billed-per-unit' ( (lv_billedUnit_3_0= RULE_STRING ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4473:1: (otherlv_0= 'costs' ( (lv_costsAmount_1_0= RULE_STRING ) ) otherlv_2= 'billed-per-unit' ( (lv_billedUnit_3_0= RULE_STRING ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4473:3: otherlv_0= 'costs' ( (lv_costsAmount_1_0= RULE_STRING ) ) otherlv_2= 'billed-per-unit' ( (lv_billedUnit_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,95,FollowSets000.FOLLOW_95_in_ruleCostAssertion9093); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getCostAssertionAccess().getCostsKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4477:1: ( (lv_costsAmount_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4478:1: (lv_costsAmount_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4478:1: (lv_costsAmount_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4479:3: lv_costsAmount_1_0= RULE_STRING
            {
            lv_costsAmount_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCostAssertion9110); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_costsAmount_1_0, grammarAccess.getCostAssertionAccess().getCostsAmountSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getCostAssertionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"costsAmount",
                      		lv_costsAmount_1_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,96,FollowSets000.FOLLOW_96_in_ruleCostAssertion9127); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getCostAssertionAccess().getBilledPerUnitKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4499:1: ( (lv_billedUnit_3_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4500:1: (lv_billedUnit_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4500:1: (lv_billedUnit_3_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4501:3: lv_billedUnit_3_0= RULE_STRING
            {
            lv_billedUnit_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCostAssertion9144); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_billedUnit_3_0, grammarAccess.getCostAssertionAccess().getBilledUnitSTRINGTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getCostAssertionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"billedUnit",
                      		lv_billedUnit_3_0, 
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
    // $ANTLR end "ruleCostAssertion"


    // $ANTLR start "entryRuleAccuracyAssertion"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4525:1: entryRuleAccuracyAssertion returns [EObject current=null] : iv_ruleAccuracyAssertion= ruleAccuracyAssertion EOF ;
    public final EObject entryRuleAccuracyAssertion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccuracyAssertion = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4526:2: (iv_ruleAccuracyAssertion= ruleAccuracyAssertion EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4527:2: iv_ruleAccuracyAssertion= ruleAccuracyAssertion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAccuracyAssertionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAccuracyAssertion_in_entryRuleAccuracyAssertion9185);
            iv_ruleAccuracyAssertion=ruleAccuracyAssertion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAccuracyAssertion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAccuracyAssertion9195); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAccuracyAssertion"


    // $ANTLR start "ruleAccuracyAssertion"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4534:1: ruleAccuracyAssertion returns [EObject current=null] : (otherlv_0= 'max-error-rate' ( (lv_maxErrorRate_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleAccuracyAssertion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_maxErrorRate_1_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4537:28: ( (otherlv_0= 'max-error-rate' ( (lv_maxErrorRate_1_0= RULE_STRING ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4538:1: (otherlv_0= 'max-error-rate' ( (lv_maxErrorRate_1_0= RULE_STRING ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4538:1: (otherlv_0= 'max-error-rate' ( (lv_maxErrorRate_1_0= RULE_STRING ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4538:3: otherlv_0= 'max-error-rate' ( (lv_maxErrorRate_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,97,FollowSets000.FOLLOW_97_in_ruleAccuracyAssertion9232); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAccuracyAssertionAccess().getMaxErrorRateKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4542:1: ( (lv_maxErrorRate_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4543:1: (lv_maxErrorRate_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4543:1: (lv_maxErrorRate_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4544:3: lv_maxErrorRate_1_0= RULE_STRING
            {
            lv_maxErrorRate_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAccuracyAssertion9249); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_maxErrorRate_1_0, grammarAccess.getAccuracyAssertionAccess().getMaxErrorRateSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAccuracyAssertionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"maxErrorRate",
                      		lv_maxErrorRate_1_0, 
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
    // $ANTLR end "ruleAccuracyAssertion"


    // $ANTLR start "entryRulePercentile"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4568:1: entryRulePercentile returns [EObject current=null] : iv_rulePercentile= rulePercentile EOF ;
    public final EObject entryRulePercentile() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePercentile = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4569:2: (iv_rulePercentile= rulePercentile EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4570:2: iv_rulePercentile= rulePercentile EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPercentileRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePercentile_in_entryRulePercentile9290);
            iv_rulePercentile=rulePercentile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePercentile; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePercentile9300); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4577:1: rulePercentile returns [EObject current=null] : ( ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%' ) ;
    public final EObject rulePercentile() throws RecognitionException {
        EObject current = null;

        Token lv_percentile_0_0=null;
        Token otherlv_1=null;
        Token this_INT_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4580:28: ( ( ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4581:1: ( ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4581:1: ( ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4581:2: ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%'
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4581:2: ( (lv_percentile_0_0= RULE_INT ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4582:1: (lv_percentile_0_0= RULE_INT )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4582:1: (lv_percentile_0_0= RULE_INT )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4583:3: lv_percentile_0_0= RULE_INT
            {
            lv_percentile_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rulePercentile9342); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4599:2: (otherlv_1= '.' this_INT_2= RULE_INT )*
            loop125:
            do {
                int alt125=2;
                int LA125_0 = input.LA(1);

                if ( (LA125_0==98) ) {
                    alt125=1;
                }


                switch (alt125) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4599:4: otherlv_1= '.' this_INT_2= RULE_INT
            	    {
            	    otherlv_1=(Token)match(input,98,FollowSets000.FOLLOW_98_in_rulePercentile9360); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPercentileAccess().getFullStopKeyword_1_0());
            	          
            	    }
            	    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rulePercentile9371); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_INT_2, grammarAccess.getPercentileAccess().getINTTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop125;
                }
            } while (true);

            otherlv_3=(Token)match(input,99,FollowSets000.FOLLOW_99_in_rulePercentile9384); if (state.failed) return current;
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


    // $ANTLR start "entryRuleEndpointQualifierRef"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4619:1: entryRuleEndpointQualifierRef returns [EObject current=null] : iv_ruleEndpointQualifierRef= ruleEndpointQualifierRef EOF ;
    public final EObject entryRuleEndpointQualifierRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndpointQualifierRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4620:2: (iv_ruleEndpointQualifierRef= ruleEndpointQualifierRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4621:2: iv_ruleEndpointQualifierRef= ruleEndpointQualifierRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEndpointQualifierRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_entryRuleEndpointQualifierRef9420);
            iv_ruleEndpointQualifierRef=ruleEndpointQualifierRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEndpointQualifierRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEndpointQualifierRef9430); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEndpointQualifierRef"


    // $ANTLR start "ruleEndpointQualifierRef"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4628:1: ruleEndpointQualifierRef returns [EObject current=null] : (otherlv_0= 'endpoint-qualifier' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleEndpointQualifierRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4631:28: ( (otherlv_0= 'endpoint-qualifier' ( ( ruleQualifiedName ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4632:1: (otherlv_0= 'endpoint-qualifier' ( ( ruleQualifiedName ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4632:1: (otherlv_0= 'endpoint-qualifier' ( ( ruleQualifiedName ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4632:3: otherlv_0= 'endpoint-qualifier' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,100,FollowSets000.FOLLOW_100_in_ruleEndpointQualifierRef9467); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEndpointQualifierRefAccess().getEndpointQualifierKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4636:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4637:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4637:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4638:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getEndpointQualifierRefRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEndpointQualifierRefAccess().getEndpointQualifierQualifierCrossReference_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleEndpointQualifierRef9494);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
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
    // $ANTLR end "ruleEndpointQualifierRef"


    // $ANTLR start "entryRuleImport"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4662:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4663:2: (iv_ruleImport= ruleImport EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4664:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport9530);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport9540); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4671:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4674:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4675:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4675:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4675:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {
            otherlv_0=(Token)match(input,101,FollowSets000.FOLLOW_101_in_ruleImport9577); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4679:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4680:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4680:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4681:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport9598);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImportRule());
              	        }
                     		set(
                     			current, 
                     			"importedNamespace",
                      		lv_importedNamespace_1_0, 
                      		"QualifiedNameWithWildCard");
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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleVersionId"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4705:1: entryRuleVersionId returns [String current=null] : iv_ruleVersionId= ruleVersionId EOF ;
    public final String entryRuleVersionId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionId = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4706:2: (iv_ruleVersionId= ruleVersionId EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4707:2: iv_ruleVersionId= ruleVersionId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionIdRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_entryRuleVersionId9635);
            iv_ruleVersionId=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionId.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionId9646); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4714:1: ruleVersionId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleVersionId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_ID_5=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4717:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4718:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4718:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4718:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )*
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId9686); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4725:1: (kw= '.' this_INT_2= RULE_INT )*
            loop126:
            do {
                int alt126=2;
                int LA126_0 = input.LA(1);

                if ( (LA126_0==98) ) {
                    int LA126_1 = input.LA(2);

                    if ( (LA126_1==RULE_INT) ) {
                        alt126=1;
                    }


                }


                switch (alt126) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4726:2: kw= '.' this_INT_2= RULE_INT
            	    {
            	    kw=(Token)match(input,98,FollowSets000.FOLLOW_98_in_ruleVersionId9705); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId9720); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_INT_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_INT_2, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop126;
                }
            } while (true);

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4738:3: ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )*
            loop128:
            do {
                int alt128=2;
                int LA128_0 = input.LA(1);

                if ( (LA128_0==98||LA128_0==102) ) {
                    alt128=1;
                }


                switch (alt128) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4738:4: (kw= '.' | kw= '-' ) this_ID_5= RULE_ID
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4738:4: (kw= '.' | kw= '-' )
            	    int alt127=2;
            	    int LA127_0 = input.LA(1);

            	    if ( (LA127_0==98) ) {
            	        alt127=1;
            	    }
            	    else if ( (LA127_0==102) ) {
            	        alt127=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 127, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt127) {
            	        case 1 :
            	            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4739:2: kw= '.'
            	            {
            	            kw=(Token)match(input,98,FollowSets000.FOLLOW_98_in_ruleVersionId9742); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_2_0_0()); 
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4746:2: kw= '-'
            	            {
            	            kw=(Token)match(input,102,FollowSets000.FOLLOW_102_in_ruleVersionId9761); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getVersionIdAccess().getHyphenMinusKeyword_2_0_1()); 
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    this_ID_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVersionId9777); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_5);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_5, grammarAccess.getVersionIdAccess().getIDTerminalRuleCall_2_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop128;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4770:1: entryRuleVersionRef returns [EObject current=null] : iv_ruleVersionRef= ruleVersionRef EOF ;
    public final EObject entryRuleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4771:2: (iv_ruleVersionRef= ruleVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4772:2: iv_ruleVersionRef= ruleVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_entryRuleVersionRef9828);
            iv_ruleVersionRef=ruleVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionRef9838); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4779:1: ruleVersionRef returns [EObject current=null] : (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) ;
    public final EObject ruleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject this_MinVersionRef_0 = null;

        EObject this_MaxVersionRef_1 = null;

        EObject this_LowerBoundRangeVersionRef_2 = null;

        EObject this_MajorVersionRef_3 = null;

        EObject this_FixedVersionRef_4 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4782:28: ( (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4783:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4783:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            int alt129=5;
            switch ( input.LA(1) ) {
            case 103:
                {
                int LA129_1 = input.LA(2);

                if ( (LA129_1==105) ) {
                    alt129=3;
                }
                else if ( (LA129_1==RULE_INT) ) {
                    alt129=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 129, 1, input);

                    throw nvae;
                }
                }
                break;
            case 104:
                {
                alt129=2;
                }
                break;
            case 107:
                {
                alt129=4;
                }
                break;
            case 108:
                {
                alt129=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 129, 0, input);

                throw nvae;
            }

            switch (alt129) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4784:2: this_MinVersionRef_0= ruleMinVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMinVersionRefParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_ruleVersionRef9888);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4797:2: this_MaxVersionRef_1= ruleMaxVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMaxVersionRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_ruleVersionRef9918);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4810:2: this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getLowerBoundRangeVersionRefParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef9948);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4823:2: this_MajorVersionRef_3= ruleMajorVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMajorVersionRefParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_ruleVersionRef9978);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4836:2: this_FixedVersionRef_4= ruleFixedVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getFixedVersionRefParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_ruleVersionRef10008);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4855:1: entryRuleMinVersionRef returns [EObject current=null] : iv_ruleMinVersionRef= ruleMinVersionRef EOF ;
    public final EObject entryRuleMinVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinVersionRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4856:2: (iv_ruleMinVersionRef= ruleMinVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4857:2: iv_ruleMinVersionRef= ruleMinVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMinVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef10043);
            iv_ruleMinVersionRef=ruleMinVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMinVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMinVersionRef10053); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4864:1: ruleMinVersionRef returns [EObject current=null] : (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMinVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_minVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4867:28: ( (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4868:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4868:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4868:3: otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,103,FollowSets000.FOLLOW_103_in_ruleMinVersionRef10090); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMinVersionRefAccess().getMinVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4872:1: ( (lv_minVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4873:1: (lv_minVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4873:1: (lv_minVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4874:3: lv_minVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMinVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMinVersionRef10111);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4898:1: entryRuleMaxVersionRef returns [EObject current=null] : iv_ruleMaxVersionRef= ruleMaxVersionRef EOF ;
    public final EObject entryRuleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxVersionRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4899:2: (iv_ruleMaxVersionRef= ruleMaxVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4900:2: iv_ruleMaxVersionRef= ruleMaxVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMaxVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef10147);
            iv_ruleMaxVersionRef=ruleMaxVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMaxVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxVersionRef10157); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4907:1: ruleMaxVersionRef returns [EObject current=null] : (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_maxVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4910:28: ( (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4911:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4911:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4911:3: otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,104,FollowSets000.FOLLOW_104_in_ruleMaxVersionRef10194); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMaxVersionRefAccess().getMaxVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4915:1: ( (lv_maxVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4916:1: (lv_maxVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4916:1: (lv_maxVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4917:3: lv_maxVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMaxVersionRefAccess().getMaxVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMaxVersionRef10215);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4941:1: entryRuleLowerBoundRangeVersionRef returns [EObject current=null] : iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF ;
    public final EObject entryRuleLowerBoundRangeVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerBoundRangeVersionRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4942:2: (iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4943:2: iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef10251);
            iv_ruleLowerBoundRangeVersionRef=ruleLowerBoundRangeVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLowerBoundRangeVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef10261); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4950:1: ruleLowerBoundRangeVersionRef returns [EObject current=null] : ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4953:28: ( ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4954:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4954:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4954:2: (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4954:2: (otherlv_0= 'minVersion' otherlv_1= '>=' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4954:4: otherlv_0= 'minVersion' otherlv_1= '>='
            {
            otherlv_0=(Token)match(input,103,FollowSets000.FOLLOW_103_in_ruleLowerBoundRangeVersionRef10299); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionKeyword_0_0());
                  
            }
            otherlv_1=(Token)match(input,105,FollowSets000.FOLLOW_105_in_ruleLowerBoundRangeVersionRef10311); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLowerBoundRangeVersionRefAccess().getGreaterThanSignEqualsSignKeyword_0_1());
                  
            }

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4962:2: ( (lv_minVersion_2_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4963:1: (lv_minVersion_2_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4963:1: (lv_minVersion_2_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4964:3: lv_minVersion_2_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef10333);
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

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleLowerBoundRangeVersionRef10345); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLowerBoundRangeVersionRefAccess().getCommaKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4984:1: (otherlv_4= 'maxVersion' otherlv_5= '<' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4984:3: otherlv_4= 'maxVersion' otherlv_5= '<'
            {
            otherlv_4=(Token)match(input,104,FollowSets000.FOLLOW_104_in_ruleLowerBoundRangeVersionRef10358); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionKeyword_3_0());
                  
            }
            otherlv_5=(Token)match(input,106,FollowSets000.FOLLOW_106_in_ruleLowerBoundRangeVersionRef10370); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLowerBoundRangeVersionRefAccess().getLessThanSignKeyword_3_1());
                  
            }

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4992:2: ( (lv_maxVersion_6_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4993:1: (lv_maxVersion_6_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4993:1: (lv_maxVersion_6_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4994:3: lv_maxVersion_6_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionVersionIdParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef10392);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5018:1: entryRuleMajorVersionRef returns [EObject current=null] : iv_ruleMajorVersionRef= ruleMajorVersionRef EOF ;
    public final EObject entryRuleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMajorVersionRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5019:2: (iv_ruleMajorVersionRef= ruleMajorVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5020:2: iv_ruleMajorVersionRef= ruleMajorVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMajorVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef10428);
            iv_ruleMajorVersionRef=ruleMajorVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMajorVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMajorVersionRef10438); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5027:1: ruleMajorVersionRef returns [EObject current=null] : (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) ;
    public final EObject ruleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_majorVersion_1_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5030:28: ( (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5031:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5031:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5031:3: otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,107,FollowSets000.FOLLOW_107_in_ruleMajorVersionRef10475); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMajorVersionRefAccess().getMajorVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5035:1: ( (lv_majorVersion_1_0= RULE_INT ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5036:1: (lv_majorVersion_1_0= RULE_INT )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5036:1: (lv_majorVersion_1_0= RULE_INT )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5037:3: lv_majorVersion_1_0= RULE_INT
            {
            lv_majorVersion_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMajorVersionRef10492); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5061:1: entryRuleFixedVersionRef returns [EObject current=null] : iv_ruleFixedVersionRef= ruleFixedVersionRef EOF ;
    public final EObject entryRuleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedVersionRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5062:2: (iv_ruleFixedVersionRef= ruleFixedVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5063:2: iv_ruleFixedVersionRef= ruleFixedVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFixedVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef10533);
            iv_ruleFixedVersionRef=ruleFixedVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFixedVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFixedVersionRef10543); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5070:1: ruleFixedVersionRef returns [EObject current=null] : (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_fixedVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5073:28: ( (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5074:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5074:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5074:3: otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,108,FollowSets000.FOLLOW_108_in_ruleFixedVersionRef10580); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFixedVersionRefAccess().getFixedVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5078:1: ( (lv_fixedVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5079:1: (lv_fixedVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5079:1: (lv_fixedVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5080:3: lv_fixedVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFixedVersionRefAccess().getFixedVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleFixedVersionRef10601);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5104:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5105:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5106:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard10638);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard10649); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5113:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5116:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5117:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5117:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5118:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard10696);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5128:1: (kw= '.*' )?
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==109) ) {
                alt130=1;
            }
            switch (alt130) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5129:2: kw= '.*'
                    {
                    kw=(Token)match(input,109,FollowSets000.FOLLOW_109_in_ruleQualifiedNameWithWildCard10715); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5142:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5143:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5144:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10758);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName10769); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5151:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID ( (kw= '.' | kw= '@' ) this_ID_3= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_3=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5154:28: ( (this_ID_0= RULE_ID ( (kw= '.' | kw= '@' ) this_ID_3= RULE_ID )* ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5155:1: (this_ID_0= RULE_ID ( (kw= '.' | kw= '@' ) this_ID_3= RULE_ID )* )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5155:1: (this_ID_0= RULE_ID ( (kw= '.' | kw= '@' ) this_ID_3= RULE_ID )* )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5155:6: this_ID_0= RULE_ID ( (kw= '.' | kw= '@' ) this_ID_3= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName10809); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5162:1: ( (kw= '.' | kw= '@' ) this_ID_3= RULE_ID )*
            loop132:
            do {
                int alt132=2;
                int LA132_0 = input.LA(1);

                if ( (LA132_0==98||LA132_0==110) ) {
                    alt132=1;
                }


                switch (alt132) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5162:2: (kw= '.' | kw= '@' ) this_ID_3= RULE_ID
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5162:2: (kw= '.' | kw= '@' )
            	    int alt131=2;
            	    int LA131_0 = input.LA(1);

            	    if ( (LA131_0==98) ) {
            	        alt131=1;
            	    }
            	    else if ( (LA131_0==110) ) {
            	        alt131=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 131, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt131) {
            	        case 1 :
            	            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5163:2: kw= '.'
            	            {
            	            kw=(Token)match(input,98,FollowSets000.FOLLOW_98_in_ruleQualifiedName10829); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0_0()); 
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5170:2: kw= '@'
            	            {
            	            kw=(Token)match(input,110,FollowSets000.FOLLOW_110_in_ruleQualifiedName10848); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getCommercialAtKeyword_1_0_1()); 
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    this_ID_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName10864); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_3);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_3, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop132;
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


    // $ANTLR start "entryRuleGovernanceDecision"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5190:1: entryRuleGovernanceDecision returns [EObject current=null] : iv_ruleGovernanceDecision= ruleGovernanceDecision EOF ;
    public final EObject entryRuleGovernanceDecision() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGovernanceDecision = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5191:2: (iv_ruleGovernanceDecision= ruleGovernanceDecision EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5192:2: iv_ruleGovernanceDecision= ruleGovernanceDecision EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGovernanceDecisionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGovernanceDecision_in_entryRuleGovernanceDecision10911);
            iv_ruleGovernanceDecision=ruleGovernanceDecision();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGovernanceDecision; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGovernanceDecision10921); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGovernanceDecision"


    // $ANTLR start "ruleGovernanceDecision"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5199:1: ruleGovernanceDecision returns [EObject current=null] : (otherlv_0= 'governance-decision' otherlv_1= '{' (otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) ) ) (otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) ) ) (otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) ) )? (otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) ) )? (otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) ) )? (otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) ) )? (otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) ) )? otherlv_16= '}' ) ;
    public final EObject ruleGovernanceDecision() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_subject_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_specificResult_7_0=null;
        Token otherlv_8=null;
        Token lv_justificationOrDocURL_9_0=null;
        Token otherlv_10=null;
        Token lv_approvalDate_11_0=null;
        Token otherlv_12=null;
        Token lv_approvedBy_13_0=null;
        Token otherlv_14=null;
        Token lv_effectiveDate_15_0=null;
        Token otherlv_16=null;
        Enumerator lv_decisionResult_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5202:28: ( (otherlv_0= 'governance-decision' otherlv_1= '{' (otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) ) ) (otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) ) ) (otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) ) )? (otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) ) )? (otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) ) )? (otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) ) )? (otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) ) )? otherlv_16= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5203:1: (otherlv_0= 'governance-decision' otherlv_1= '{' (otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) ) ) (otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) ) ) (otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) ) )? (otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) ) )? (otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) ) )? (otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) ) )? (otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) ) )? otherlv_16= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5203:1: (otherlv_0= 'governance-decision' otherlv_1= '{' (otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) ) ) (otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) ) ) (otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) ) )? (otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) ) )? (otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) ) )? (otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) ) )? (otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) ) )? otherlv_16= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5203:3: otherlv_0= 'governance-decision' otherlv_1= '{' (otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) ) ) (otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) ) ) (otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) ) )? (otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) ) )? (otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) ) )? (otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) ) )? (otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) ) )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,111,FollowSets000.FOLLOW_111_in_ruleGovernanceDecision10958); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getGovernanceDecisionAccess().getGovernanceDecisionKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleGovernanceDecision10970); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getGovernanceDecisionAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5211:1: (otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5211:3: otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) )
            {
            otherlv_2=(Token)match(input,112,FollowSets000.FOLLOW_112_in_ruleGovernanceDecision10983); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getGovernanceDecisionAccess().getSubjectKeyword_2_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5215:1: ( (lv_subject_3_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5216:1: (lv_subject_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5216:1: (lv_subject_3_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5217:3: lv_subject_3_0= RULE_STRING
            {
            lv_subject_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGovernanceDecision11000); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_subject_3_0, grammarAccess.getGovernanceDecisionAccess().getSubjectSTRINGTerminalRuleCall_2_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getGovernanceDecisionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"subject",
                      		lv_subject_3_0, 
                      		"STRING");
              	    
            }

            }


            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5233:3: (otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5233:5: otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) )
            {
            otherlv_4=(Token)match(input,113,FollowSets000.FOLLOW_113_in_ruleGovernanceDecision11019); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getGovernanceDecisionAccess().getDecisionResultKeyword_3_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5237:1: ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5238:1: (lv_decisionResult_5_0= ruleGovernanceDecisionResult )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5238:1: (lv_decisionResult_5_0= ruleGovernanceDecisionResult )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5239:3: lv_decisionResult_5_0= ruleGovernanceDecisionResult
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGovernanceDecisionAccess().getDecisionResultGovernanceDecisionResultEnumRuleCall_3_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleGovernanceDecisionResult_in_ruleGovernanceDecision11040);
            lv_decisionResult_5_0=ruleGovernanceDecisionResult();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getGovernanceDecisionRule());
              	        }
                     		set(
                     			current, 
                     			"decisionResult",
                      		lv_decisionResult_5_0, 
                      		"GovernanceDecisionResult");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5255:3: (otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) ) )?
            int alt133=2;
            int LA133_0 = input.LA(1);

            if ( (LA133_0==114) ) {
                alt133=1;
            }
            switch (alt133) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5255:5: otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,114,FollowSets000.FOLLOW_114_in_ruleGovernanceDecision11054); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getGovernanceDecisionAccess().getSpecificResultKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5259:1: ( (lv_specificResult_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5260:1: (lv_specificResult_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5260:1: (lv_specificResult_7_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5261:3: lv_specificResult_7_0= RULE_STRING
                    {
                    lv_specificResult_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGovernanceDecision11071); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_specificResult_7_0, grammarAccess.getGovernanceDecisionAccess().getSpecificResultSTRINGTerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getGovernanceDecisionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"specificResult",
                              		lv_specificResult_7_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5277:4: (otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) ) )?
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==115) ) {
                alt134=1;
            }
            switch (alt134) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5277:6: otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,115,FollowSets000.FOLLOW_115_in_ruleGovernanceDecision11091); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getGovernanceDecisionAccess().getJustificationDocKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5281:1: ( (lv_justificationOrDocURL_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5282:1: (lv_justificationOrDocURL_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5282:1: (lv_justificationOrDocURL_9_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5283:3: lv_justificationOrDocURL_9_0= RULE_STRING
                    {
                    lv_justificationOrDocURL_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGovernanceDecision11108); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_justificationOrDocURL_9_0, grammarAccess.getGovernanceDecisionAccess().getJustificationOrDocURLSTRINGTerminalRuleCall_5_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getGovernanceDecisionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"justificationOrDocURL",
                              		lv_justificationOrDocURL_9_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5299:4: (otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) ) )?
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==116) ) {
                alt135=1;
            }
            switch (alt135) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5299:6: otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) )
                    {
                    otherlv_10=(Token)match(input,116,FollowSets000.FOLLOW_116_in_ruleGovernanceDecision11128); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getGovernanceDecisionAccess().getDecisionDateKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5303:1: ( (lv_approvalDate_11_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5304:1: (lv_approvalDate_11_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5304:1: (lv_approvalDate_11_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5305:3: lv_approvalDate_11_0= RULE_STRING
                    {
                    lv_approvalDate_11_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGovernanceDecision11145); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_approvalDate_11_0, grammarAccess.getGovernanceDecisionAccess().getApprovalDateSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getGovernanceDecisionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"approvalDate",
                              		lv_approvalDate_11_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5321:4: (otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) ) )?
            int alt136=2;
            int LA136_0 = input.LA(1);

            if ( (LA136_0==117) ) {
                alt136=1;
            }
            switch (alt136) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5321:6: otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) )
                    {
                    otherlv_12=(Token)match(input,117,FollowSets000.FOLLOW_117_in_ruleGovernanceDecision11165); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getGovernanceDecisionAccess().getDecisionByKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5325:1: ( (lv_approvedBy_13_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5326:1: (lv_approvedBy_13_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5326:1: (lv_approvedBy_13_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5327:3: lv_approvedBy_13_0= RULE_STRING
                    {
                    lv_approvedBy_13_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGovernanceDecision11182); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_approvedBy_13_0, grammarAccess.getGovernanceDecisionAccess().getApprovedBySTRINGTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getGovernanceDecisionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"approvedBy",
                              		lv_approvedBy_13_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5343:4: (otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) ) )?
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==118) ) {
                alt137=1;
            }
            switch (alt137) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5343:6: otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) )
                    {
                    otherlv_14=(Token)match(input,118,FollowSets000.FOLLOW_118_in_ruleGovernanceDecision11202); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getGovernanceDecisionAccess().getEffectiveDateKeyword_8_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5347:1: ( (lv_effectiveDate_15_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5348:1: (lv_effectiveDate_15_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5348:1: (lv_effectiveDate_15_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5349:3: lv_effectiveDate_15_0= RULE_STRING
                    {
                    lv_effectiveDate_15_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGovernanceDecision11219); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_effectiveDate_15_0, grammarAccess.getGovernanceDecisionAccess().getEffectiveDateSTRINGTerminalRuleCall_8_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getGovernanceDecisionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"effectiveDate",
                              		lv_effectiveDate_15_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleGovernanceDecision11238); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_16, grammarAccess.getGovernanceDecisionAccess().getRightCurlyBracketKeyword_9());
                  
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
    // $ANTLR end "ruleGovernanceDecision"


    // $ANTLR start "entryRuleInfoItem"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5381:1: entryRuleInfoItem returns [EObject current=null] : iv_ruleInfoItem= ruleInfoItem EOF ;
    public final EObject entryRuleInfoItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfoItem = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5382:2: (iv_ruleInfoItem= ruleInfoItem EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5383:2: iv_ruleInfoItem= ruleInfoItem EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfoItemRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfoItem_in_entryRuleInfoItem11278);
            iv_ruleInfoItem=ruleInfoItem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfoItem; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfoItem11288); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5390:1: ruleInfoItem returns [EObject current=null] : (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleInfoItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_documentLocation_1_0=null;
        Token otherlv_2=null;
        Token lv_reference_3_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5393:28: ( (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5394:1: (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5394:1: (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5394:3: otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,119,FollowSets000.FOLLOW_119_in_ruleInfoItem11325); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInfoItemAccess().getLocationKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5398:1: ( (lv_documentLocation_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5399:1: (lv_documentLocation_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5399:1: (lv_documentLocation_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5400:3: lv_documentLocation_1_0= RULE_STRING
            {
            lv_documentLocation_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleInfoItem11342); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5416:2: (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )?
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==58) ) {
                alt138=1;
            }
            switch (alt138) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5416:4: otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleInfoItem11360); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getInfoItemAccess().getReferenceKeyword_2_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5420:1: ( (lv_reference_3_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5421:1: (lv_reference_3_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5421:1: (lv_reference_3_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5422:3: lv_reference_3_0= RULE_STRING
                    {
                    lv_reference_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleInfoItem11377); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5448:1: entryRuleRoleRef returns [EObject current=null] : iv_ruleRoleRef= ruleRoleRef EOF ;
    public final EObject entryRuleRoleRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoleRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5449:2: (iv_ruleRoleRef= ruleRoleRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5450:2: iv_ruleRoleRef= ruleRoleRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRoleRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRoleRef_in_entryRuleRoleRef11422);
            iv_ruleRoleRef=ruleRoleRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRoleRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoleRef11432); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5457:1: ruleRoleRef returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleRoleRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5460:28: ( ( ( ruleQualifiedName ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5461:1: ( ( ruleQualifiedName ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5461:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5462:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5462:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5463:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleRoleRef11483);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5489:1: entryRulePrivilegeRef returns [EObject current=null] : iv_rulePrivilegeRef= rulePrivilegeRef EOF ;
    public final EObject entryRulePrivilegeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrivilegeRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5490:2: (iv_rulePrivilegeRef= rulePrivilegeRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5491:2: iv_rulePrivilegeRef= rulePrivilegeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrivilegeRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrivilegeRef_in_entryRulePrivilegeRef11520);
            iv_rulePrivilegeRef=rulePrivilegeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrivilegeRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrivilegeRef11530); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5498:1: rulePrivilegeRef returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject rulePrivilegeRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5501:28: ( ( ( ruleQualifiedName ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5502:1: ( ( ruleQualifiedName ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5502:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5503:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5503:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5504:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rulePrivilegeRef11581);
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


    // $ANTLR start "ruleSOAPStyle"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5532:1: ruleSOAPStyle returns [Enumerator current=null] : ( (enumLiteral_0= 'document/literal-wrapped' ) | (enumLiteral_1= 'rpc/literal' ) | (enumLiteral_2= 'rpc/encoded' ) ) ;
    public final Enumerator ruleSOAPStyle() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5534:28: ( ( (enumLiteral_0= 'document/literal-wrapped' ) | (enumLiteral_1= 'rpc/literal' ) | (enumLiteral_2= 'rpc/encoded' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5535:1: ( (enumLiteral_0= 'document/literal-wrapped' ) | (enumLiteral_1= 'rpc/literal' ) | (enumLiteral_2= 'rpc/encoded' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5535:1: ( (enumLiteral_0= 'document/literal-wrapped' ) | (enumLiteral_1= 'rpc/literal' ) | (enumLiteral_2= 'rpc/encoded' ) )
            int alt139=3;
            switch ( input.LA(1) ) {
            case 120:
                {
                alt139=1;
                }
                break;
            case 121:
                {
                alt139=2;
                }
                break;
            case 122:
                {
                alt139=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 139, 0, input);

                throw nvae;
            }

            switch (alt139) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5535:2: (enumLiteral_0= 'document/literal-wrapped' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5535:2: (enumLiteral_0= 'document/literal-wrapped' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5535:4: enumLiteral_0= 'document/literal-wrapped'
                    {
                    enumLiteral_0=(Token)match(input,120,FollowSets000.FOLLOW_120_in_ruleSOAPStyle11634); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSOAPStyleAccess().getDoclitwrapEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getSOAPStyleAccess().getDoclitwrapEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5541:6: (enumLiteral_1= 'rpc/literal' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5541:6: (enumLiteral_1= 'rpc/literal' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5541:8: enumLiteral_1= 'rpc/literal'
                    {
                    enumLiteral_1=(Token)match(input,121,FollowSets000.FOLLOW_121_in_ruleSOAPStyle11651); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSOAPStyleAccess().getRpclitEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getSOAPStyleAccess().getRpclitEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5547:6: (enumLiteral_2= 'rpc/encoded' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5547:6: (enumLiteral_2= 'rpc/encoded' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5547:8: enumLiteral_2= 'rpc/encoded'
                    {
                    enumLiteral_2=(Token)match(input,122,FollowSets000.FOLLOW_122_in_ruleSOAPStyle11668); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSOAPStyleAccess().getRpcencEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getSOAPStyleAccess().getRpcencEnumLiteralDeclaration_2()); 
                          
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
    // $ANTLR end "ruleSOAPStyle"


    // $ANTLR start "ruleSOAPTransport"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5557:1: ruleSOAPTransport returns [Enumerator current=null] : ( (enumLiteral_0= 'HTTP' ) | (enumLiteral_1= 'JMS' ) | (enumLiteral_2= 'SMTP' ) ) ;
    public final Enumerator ruleSOAPTransport() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5559:28: ( ( (enumLiteral_0= 'HTTP' ) | (enumLiteral_1= 'JMS' ) | (enumLiteral_2= 'SMTP' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5560:1: ( (enumLiteral_0= 'HTTP' ) | (enumLiteral_1= 'JMS' ) | (enumLiteral_2= 'SMTP' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5560:1: ( (enumLiteral_0= 'HTTP' ) | (enumLiteral_1= 'JMS' ) | (enumLiteral_2= 'SMTP' ) )
            int alt140=3;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt140=1;
                }
                break;
            case 52:
                {
                alt140=2;
                }
                break;
            case 123:
                {
                alt140=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 140, 0, input);

                throw nvae;
            }

            switch (alt140) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5560:2: (enumLiteral_0= 'HTTP' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5560:2: (enumLiteral_0= 'HTTP' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5560:4: enumLiteral_0= 'HTTP'
                    {
                    enumLiteral_0=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleSOAPTransport11713); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSOAPTransportAccess().getHTTPEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getSOAPTransportAccess().getHTTPEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5566:6: (enumLiteral_1= 'JMS' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5566:6: (enumLiteral_1= 'JMS' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5566:8: enumLiteral_1= 'JMS'
                    {
                    enumLiteral_1=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleSOAPTransport11730); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSOAPTransportAccess().getJMSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getSOAPTransportAccess().getJMSEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5572:6: (enumLiteral_2= 'SMTP' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5572:6: (enumLiteral_2= 'SMTP' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5572:8: enumLiteral_2= 'SMTP'
                    {
                    enumLiteral_2=(Token)match(input,123,FollowSets000.FOLLOW_123_in_ruleSOAPTransport11747); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSOAPTransportAccess().getSMTPEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getSOAPTransportAccess().getSMTPEnumLiteralDeclaration_2()); 
                          
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
    // $ANTLR end "ruleSOAPTransport"


    // $ANTLR start "ruleSOAPProtocolVersion"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5582:1: ruleSOAPProtocolVersion returns [Enumerator current=null] : ( (enumLiteral_0= 'SOAP-v1.1' ) | (enumLiteral_1= 'SOAP-v1.2' ) ) ;
    public final Enumerator ruleSOAPProtocolVersion() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5584:28: ( ( (enumLiteral_0= 'SOAP-v1.1' ) | (enumLiteral_1= 'SOAP-v1.2' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5585:1: ( (enumLiteral_0= 'SOAP-v1.1' ) | (enumLiteral_1= 'SOAP-v1.2' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5585:1: ( (enumLiteral_0= 'SOAP-v1.1' ) | (enumLiteral_1= 'SOAP-v1.2' ) )
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==124) ) {
                alt141=1;
            }
            else if ( (LA141_0==125) ) {
                alt141=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 141, 0, input);

                throw nvae;
            }
            switch (alt141) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5585:2: (enumLiteral_0= 'SOAP-v1.1' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5585:2: (enumLiteral_0= 'SOAP-v1.1' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5585:4: enumLiteral_0= 'SOAP-v1.1'
                    {
                    enumLiteral_0=(Token)match(input,124,FollowSets000.FOLLOW_124_in_ruleSOAPProtocolVersion11792); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSOAPProtocolVersionAccess().getSOAP11EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getSOAPProtocolVersionAccess().getSOAP11EnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5591:6: (enumLiteral_1= 'SOAP-v1.2' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5591:6: (enumLiteral_1= 'SOAP-v1.2' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5591:8: enumLiteral_1= 'SOAP-v1.2'
                    {
                    enumLiteral_1=(Token)match(input,125,FollowSets000.FOLLOW_125_in_ruleSOAPProtocolVersion11809); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSOAPProtocolVersionAccess().getSOAP12EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getSOAPProtocolVersionAccess().getSOAP12EnumLiteralDeclaration_1()); 
                          
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
    // $ANTLR end "ruleSOAPProtocolVersion"


    // $ANTLR start "ruleSAPTransport"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5601:1: ruleSAPTransport returns [Enumerator current=null] : ( (enumLiteral_0= 'IDOC' ) | (enumLiteral_1= 'RFC' ) ) ;
    public final Enumerator ruleSAPTransport() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5603:28: ( ( (enumLiteral_0= 'IDOC' ) | (enumLiteral_1= 'RFC' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5604:1: ( (enumLiteral_0= 'IDOC' ) | (enumLiteral_1= 'RFC' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5604:1: ( (enumLiteral_0= 'IDOC' ) | (enumLiteral_1= 'RFC' ) )
            int alt142=2;
            int LA142_0 = input.LA(1);

            if ( (LA142_0==126) ) {
                alt142=1;
            }
            else if ( (LA142_0==127) ) {
                alt142=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 142, 0, input);

                throw nvae;
            }
            switch (alt142) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5604:2: (enumLiteral_0= 'IDOC' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5604:2: (enumLiteral_0= 'IDOC' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5604:4: enumLiteral_0= 'IDOC'
                    {
                    enumLiteral_0=(Token)match(input,126,FollowSets000.FOLLOW_126_in_ruleSAPTransport11854); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSAPTransportAccess().getIDOCEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getSAPTransportAccess().getIDOCEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5610:6: (enumLiteral_1= 'RFC' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5610:6: (enumLiteral_1= 'RFC' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5610:8: enumLiteral_1= 'RFC'
                    {
                    enumLiteral_1=(Token)match(input,127,FollowSets000.FOLLOW_127_in_ruleSAPTransport11871); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSAPTransportAccess().getRFCEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getSAPTransportAccess().getRFCEnumLiteralDeclaration_1()); 
                          
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
    // $ANTLR end "ruleSAPTransport"


    // $ANTLR start "ruleRESTFormat"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5620:1: ruleRESTFormat returns [Enumerator current=null] : ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'XML' ) | (enumLiteral_2= 'BISON' ) | (enumLiteral_3= 'OTHER' ) ) ;
    public final Enumerator ruleRESTFormat() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5622:28: ( ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'XML' ) | (enumLiteral_2= 'BISON' ) | (enumLiteral_3= 'OTHER' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5623:1: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'XML' ) | (enumLiteral_2= 'BISON' ) | (enumLiteral_3= 'OTHER' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5623:1: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'XML' ) | (enumLiteral_2= 'BISON' ) | (enumLiteral_3= 'OTHER' ) )
            int alt143=4;
            switch ( input.LA(1) ) {
            case 128:
                {
                alt143=1;
                }
                break;
            case 129:
                {
                alt143=2;
                }
                break;
            case 130:
                {
                alt143=3;
                }
                break;
            case 131:
                {
                alt143=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 143, 0, input);

                throw nvae;
            }

            switch (alt143) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5623:2: (enumLiteral_0= 'JSON' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5623:2: (enumLiteral_0= 'JSON' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5623:4: enumLiteral_0= 'JSON'
                    {
                    enumLiteral_0=(Token)match(input,128,FollowSets000.FOLLOW_128_in_ruleRESTFormat11916); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRESTFormatAccess().getJSONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getRESTFormatAccess().getJSONEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5629:6: (enumLiteral_1= 'XML' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5629:6: (enumLiteral_1= 'XML' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5629:8: enumLiteral_1= 'XML'
                    {
                    enumLiteral_1=(Token)match(input,129,FollowSets000.FOLLOW_129_in_ruleRESTFormat11933); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRESTFormatAccess().getXMLEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getRESTFormatAccess().getXMLEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5635:6: (enumLiteral_2= 'BISON' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5635:6: (enumLiteral_2= 'BISON' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5635:8: enumLiteral_2= 'BISON'
                    {
                    enumLiteral_2=(Token)match(input,130,FollowSets000.FOLLOW_130_in_ruleRESTFormat11950); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRESTFormatAccess().getBISONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getRESTFormatAccess().getBISONEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5641:6: (enumLiteral_3= 'OTHER' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5641:6: (enumLiteral_3= 'OTHER' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5641:8: enumLiteral_3= 'OTHER'
                    {
                    enumLiteral_3=(Token)match(input,131,FollowSets000.FOLLOW_131_in_ruleRESTFormat11967); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRESTFormatAccess().getOTHEREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getRESTFormatAccess().getOTHEREnumLiteralDeclaration_3()); 
                          
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
    // $ANTLR end "ruleRESTFormat"


    // $ANTLR start "ruleVerb"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5651:1: ruleVerb returns [Enumerator current=null] : ( (enumLiteral_0= 'CREATE' ) | (enumLiteral_1= 'RETRIEVE' ) | (enumLiteral_2= 'UPDATE' ) | (enumLiteral_3= 'DELETE' ) | (enumLiteral_4= 'GET' ) | (enumLiteral_5= 'PUT' ) | (enumLiteral_6= 'POST' ) ) ;
    public final Enumerator ruleVerb() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5653:28: ( ( (enumLiteral_0= 'CREATE' ) | (enumLiteral_1= 'RETRIEVE' ) | (enumLiteral_2= 'UPDATE' ) | (enumLiteral_3= 'DELETE' ) | (enumLiteral_4= 'GET' ) | (enumLiteral_5= 'PUT' ) | (enumLiteral_6= 'POST' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5654:1: ( (enumLiteral_0= 'CREATE' ) | (enumLiteral_1= 'RETRIEVE' ) | (enumLiteral_2= 'UPDATE' ) | (enumLiteral_3= 'DELETE' ) | (enumLiteral_4= 'GET' ) | (enumLiteral_5= 'PUT' ) | (enumLiteral_6= 'POST' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5654:1: ( (enumLiteral_0= 'CREATE' ) | (enumLiteral_1= 'RETRIEVE' ) | (enumLiteral_2= 'UPDATE' ) | (enumLiteral_3= 'DELETE' ) | (enumLiteral_4= 'GET' ) | (enumLiteral_5= 'PUT' ) | (enumLiteral_6= 'POST' ) )
            int alt144=7;
            switch ( input.LA(1) ) {
            case 132:
                {
                alt144=1;
                }
                break;
            case 133:
                {
                alt144=2;
                }
                break;
            case 134:
                {
                alt144=3;
                }
                break;
            case 135:
                {
                alt144=4;
                }
                break;
            case 136:
                {
                alt144=5;
                }
                break;
            case 137:
                {
                alt144=6;
                }
                break;
            case 138:
                {
                alt144=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 144, 0, input);

                throw nvae;
            }

            switch (alt144) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5654:2: (enumLiteral_0= 'CREATE' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5654:2: (enumLiteral_0= 'CREATE' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5654:4: enumLiteral_0= 'CREATE'
                    {
                    enumLiteral_0=(Token)match(input,132,FollowSets000.FOLLOW_132_in_ruleVerb12012); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getCREATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getVerbAccess().getCREATEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5660:6: (enumLiteral_1= 'RETRIEVE' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5660:6: (enumLiteral_1= 'RETRIEVE' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5660:8: enumLiteral_1= 'RETRIEVE'
                    {
                    enumLiteral_1=(Token)match(input,133,FollowSets000.FOLLOW_133_in_ruleVerb12029); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getRETRIEVEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getVerbAccess().getRETRIEVEEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5666:6: (enumLiteral_2= 'UPDATE' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5666:6: (enumLiteral_2= 'UPDATE' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5666:8: enumLiteral_2= 'UPDATE'
                    {
                    enumLiteral_2=(Token)match(input,134,FollowSets000.FOLLOW_134_in_ruleVerb12046); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getUPDATEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getVerbAccess().getUPDATEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5672:6: (enumLiteral_3= 'DELETE' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5672:6: (enumLiteral_3= 'DELETE' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5672:8: enumLiteral_3= 'DELETE'
                    {
                    enumLiteral_3=(Token)match(input,135,FollowSets000.FOLLOW_135_in_ruleVerb12063); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getDELETEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getVerbAccess().getDELETEEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5678:6: (enumLiteral_4= 'GET' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5678:6: (enumLiteral_4= 'GET' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5678:8: enumLiteral_4= 'GET'
                    {
                    enumLiteral_4=(Token)match(input,136,FollowSets000.FOLLOW_136_in_ruleVerb12080); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getGETEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getVerbAccess().getGETEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5684:6: (enumLiteral_5= 'PUT' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5684:6: (enumLiteral_5= 'PUT' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5684:8: enumLiteral_5= 'PUT'
                    {
                    enumLiteral_5=(Token)match(input,137,FollowSets000.FOLLOW_137_in_ruleVerb12097); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getPUTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getVerbAccess().getPUTEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5690:6: (enumLiteral_6= 'POST' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5690:6: (enumLiteral_6= 'POST' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5690:8: enumLiteral_6= 'POST'
                    {
                    enumLiteral_6=(Token)match(input,138,FollowSets000.FOLLOW_138_in_ruleVerb12114); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getPOSTEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getVerbAccess().getPOSTEnumLiteralDeclaration_6()); 
                          
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
    // $ANTLR end "ruleVerb"


    // $ANTLR start "ruleReadWrite"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5700:1: ruleReadWrite returns [Enumerator current=null] : ( (enumLiteral_0= 'read' ) | (enumLiteral_1= 'write' ) ) ;
    public final Enumerator ruleReadWrite() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5702:28: ( ( (enumLiteral_0= 'read' ) | (enumLiteral_1= 'write' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5703:1: ( (enumLiteral_0= 'read' ) | (enumLiteral_1= 'write' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5703:1: ( (enumLiteral_0= 'read' ) | (enumLiteral_1= 'write' ) )
            int alt145=2;
            int LA145_0 = input.LA(1);

            if ( (LA145_0==139) ) {
                alt145=1;
            }
            else if ( (LA145_0==140) ) {
                alt145=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 145, 0, input);

                throw nvae;
            }
            switch (alt145) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5703:2: (enumLiteral_0= 'read' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5703:2: (enumLiteral_0= 'read' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5703:4: enumLiteral_0= 'read'
                    {
                    enumLiteral_0=(Token)match(input,139,FollowSets000.FOLLOW_139_in_ruleReadWrite12159); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReadWriteAccess().getReadEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getReadWriteAccess().getReadEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5709:6: (enumLiteral_1= 'write' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5709:6: (enumLiteral_1= 'write' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5709:8: enumLiteral_1= 'write'
                    {
                    enumLiteral_1=(Token)match(input,140,FollowSets000.FOLLOW_140_in_ruleReadWrite12176); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReadWriteAccess().getWriteEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getReadWriteAccess().getWriteEnumLiteralDeclaration_1()); 
                          
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
    // $ANTLR end "ruleReadWrite"


    // $ANTLR start "ruleHashAlgKind"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5719:1: ruleHashAlgKind returns [Enumerator current=null] : ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'RSA' ) | (enumLiteral_4= 'PlainText' ) ) ;
    public final Enumerator ruleHashAlgKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5721:28: ( ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'RSA' ) | (enumLiteral_4= 'PlainText' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5722:1: ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'RSA' ) | (enumLiteral_4= 'PlainText' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5722:1: ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'RSA' ) | (enumLiteral_4= 'PlainText' ) )
            int alt146=5;
            switch ( input.LA(1) ) {
            case 141:
                {
                alt146=1;
                }
                break;
            case 142:
                {
                alt146=2;
                }
                break;
            case 143:
                {
                alt146=3;
                }
                break;
            case 144:
                {
                alt146=4;
                }
                break;
            case 145:
                {
                alt146=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 146, 0, input);

                throw nvae;
            }

            switch (alt146) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5722:2: (enumLiteral_0= 'MD5' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5722:2: (enumLiteral_0= 'MD5' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5722:4: enumLiteral_0= 'MD5'
                    {
                    enumLiteral_0=(Token)match(input,141,FollowSets000.FOLLOW_141_in_ruleHashAlgKind12221); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getMD5EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getHashAlgKindAccess().getMD5EnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5728:6: (enumLiteral_1= 'SHA1' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5728:6: (enumLiteral_1= 'SHA1' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5728:8: enumLiteral_1= 'SHA1'
                    {
                    enumLiteral_1=(Token)match(input,142,FollowSets000.FOLLOW_142_in_ruleHashAlgKind12238); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getSHA1EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getHashAlgKindAccess().getSHA1EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5734:6: (enumLiteral_2= 'SHA256' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5734:6: (enumLiteral_2= 'SHA256' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5734:8: enumLiteral_2= 'SHA256'
                    {
                    enumLiteral_2=(Token)match(input,143,FollowSets000.FOLLOW_143_in_ruleHashAlgKind12255); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getSHA256EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getHashAlgKindAccess().getSHA256EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5740:6: (enumLiteral_3= 'RSA' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5740:6: (enumLiteral_3= 'RSA' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5740:8: enumLiteral_3= 'RSA'
                    {
                    enumLiteral_3=(Token)match(input,144,FollowSets000.FOLLOW_144_in_ruleHashAlgKind12272); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getRSAEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getHashAlgKindAccess().getRSAEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5746:6: (enumLiteral_4= 'PlainText' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5746:6: (enumLiteral_4= 'PlainText' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5746:8: enumLiteral_4= 'PlainText'
                    {
                    enumLiteral_4=(Token)match(input,145,FollowSets000.FOLLOW_145_in_ruleHashAlgKind12289); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5756:1: ruleMessagePartRefKind returns [Enumerator current=null] : ( (enumLiteral_0= 'header' ) | (enumLiteral_1= 'body' ) | (enumLiteral_2= 'attachments' ) | (enumLiteral_3= 'all' ) | (enumLiteral_4= 'expression' ) ) ;
    public final Enumerator ruleMessagePartRefKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5758:28: ( ( (enumLiteral_0= 'header' ) | (enumLiteral_1= 'body' ) | (enumLiteral_2= 'attachments' ) | (enumLiteral_3= 'all' ) | (enumLiteral_4= 'expression' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5759:1: ( (enumLiteral_0= 'header' ) | (enumLiteral_1= 'body' ) | (enumLiteral_2= 'attachments' ) | (enumLiteral_3= 'all' ) | (enumLiteral_4= 'expression' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5759:1: ( (enumLiteral_0= 'header' ) | (enumLiteral_1= 'body' ) | (enumLiteral_2= 'attachments' ) | (enumLiteral_3= 'all' ) | (enumLiteral_4= 'expression' ) )
            int alt147=5;
            switch ( input.LA(1) ) {
            case 146:
                {
                alt147=1;
                }
                break;
            case 147:
                {
                alt147=2;
                }
                break;
            case 148:
                {
                alt147=3;
                }
                break;
            case 149:
                {
                alt147=4;
                }
                break;
            case 80:
                {
                alt147=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 147, 0, input);

                throw nvae;
            }

            switch (alt147) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5759:2: (enumLiteral_0= 'header' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5759:2: (enumLiteral_0= 'header' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5759:4: enumLiteral_0= 'header'
                    {
                    enumLiteral_0=(Token)match(input,146,FollowSets000.FOLLOW_146_in_ruleMessagePartRefKind12334); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getHeaderEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getMessagePartRefKindAccess().getHeaderEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5765:6: (enumLiteral_1= 'body' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5765:6: (enumLiteral_1= 'body' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5765:8: enumLiteral_1= 'body'
                    {
                    enumLiteral_1=(Token)match(input,147,FollowSets000.FOLLOW_147_in_ruleMessagePartRefKind12351); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getBodyEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getMessagePartRefKindAccess().getBodyEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5771:6: (enumLiteral_2= 'attachments' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5771:6: (enumLiteral_2= 'attachments' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5771:8: enumLiteral_2= 'attachments'
                    {
                    enumLiteral_2=(Token)match(input,148,FollowSets000.FOLLOW_148_in_ruleMessagePartRefKind12368); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getAttachmentsEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getMessagePartRefKindAccess().getAttachmentsEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5777:6: (enumLiteral_3= 'all' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5777:6: (enumLiteral_3= 'all' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5777:8: enumLiteral_3= 'all'
                    {
                    enumLiteral_3=(Token)match(input,149,FollowSets000.FOLLOW_149_in_ruleMessagePartRefKind12385); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getAllEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getMessagePartRefKindAccess().getAllEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5783:6: (enumLiteral_4= 'expression' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5783:6: (enumLiteral_4= 'expression' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5783:8: enumLiteral_4= 'expression'
                    {
                    enumLiteral_4=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleMessagePartRefKind12402); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5793:1: ruleSigningAlgothm returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'MD5' ) | (enumLiteral_4= 'RSA_1_5' ) | (enumLiteral_5= 'AES128' ) | (enumLiteral_6= 'AES192' ) | (enumLiteral_7= 'AES256' ) ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5795:28: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'MD5' ) | (enumLiteral_4= 'RSA_1_5' ) | (enumLiteral_5= 'AES128' ) | (enumLiteral_6= 'AES192' ) | (enumLiteral_7= 'AES256' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5796:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'MD5' ) | (enumLiteral_4= 'RSA_1_5' ) | (enumLiteral_5= 'AES128' ) | (enumLiteral_6= 'AES192' ) | (enumLiteral_7= 'AES256' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5796:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'MD5' ) | (enumLiteral_4= 'RSA_1_5' ) | (enumLiteral_5= 'AES128' ) | (enumLiteral_6= 'AES192' ) | (enumLiteral_7= 'AES256' ) )
            int alt148=8;
            switch ( input.LA(1) ) {
            case 150:
                {
                alt148=1;
                }
                break;
            case 142:
                {
                alt148=2;
                }
                break;
            case 143:
                {
                alt148=3;
                }
                break;
            case 141:
                {
                alt148=4;
                }
                break;
            case 151:
                {
                alt148=5;
                }
                break;
            case 152:
                {
                alt148=6;
                }
                break;
            case 153:
                {
                alt148=7;
                }
                break;
            case 154:
                {
                alt148=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 148, 0, input);

                throw nvae;
            }

            switch (alt148) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5796:2: (enumLiteral_0= 'NONE' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5796:2: (enumLiteral_0= 'NONE' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5796:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,150,FollowSets000.FOLLOW_150_in_ruleSigningAlgothm12447); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getSigningAlgothmAccess().getNONEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5802:6: (enumLiteral_1= 'SHA1' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5802:6: (enumLiteral_1= 'SHA1' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5802:8: enumLiteral_1= 'SHA1'
                    {
                    enumLiteral_1=(Token)match(input,142,FollowSets000.FOLLOW_142_in_ruleSigningAlgothm12464); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getSHA1EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getSigningAlgothmAccess().getSHA1EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5808:6: (enumLiteral_2= 'SHA256' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5808:6: (enumLiteral_2= 'SHA256' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5808:8: enumLiteral_2= 'SHA256'
                    {
                    enumLiteral_2=(Token)match(input,143,FollowSets000.FOLLOW_143_in_ruleSigningAlgothm12481); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getSHA256EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getSigningAlgothmAccess().getSHA256EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5814:6: (enumLiteral_3= 'MD5' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5814:6: (enumLiteral_3= 'MD5' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5814:8: enumLiteral_3= 'MD5'
                    {
                    enumLiteral_3=(Token)match(input,141,FollowSets000.FOLLOW_141_in_ruleSigningAlgothm12498); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getMD5EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getSigningAlgothmAccess().getMD5EnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5820:6: (enumLiteral_4= 'RSA_1_5' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5820:6: (enumLiteral_4= 'RSA_1_5' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5820:8: enumLiteral_4= 'RSA_1_5'
                    {
                    enumLiteral_4=(Token)match(input,151,FollowSets000.FOLLOW_151_in_ruleSigningAlgothm12515); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getRSA_1_5EnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getSigningAlgothmAccess().getRSA_1_5EnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5826:6: (enumLiteral_5= 'AES128' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5826:6: (enumLiteral_5= 'AES128' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5826:8: enumLiteral_5= 'AES128'
                    {
                    enumLiteral_5=(Token)match(input,152,FollowSets000.FOLLOW_152_in_ruleSigningAlgothm12532); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getAES128EnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getSigningAlgothmAccess().getAES128EnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5832:6: (enumLiteral_6= 'AES192' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5832:6: (enumLiteral_6= 'AES192' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5832:8: enumLiteral_6= 'AES192'
                    {
                    enumLiteral_6=(Token)match(input,153,FollowSets000.FOLLOW_153_in_ruleSigningAlgothm12549); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getAES192EnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getSigningAlgothmAccess().getAES192EnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5838:6: (enumLiteral_7= 'AES256' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5838:6: (enumLiteral_7= 'AES256' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5838:8: enumLiteral_7= 'AES256'
                    {
                    enumLiteral_7=(Token)match(input,154,FollowSets000.FOLLOW_154_in_ruleSigningAlgothm12566); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5848:1: ruleCipherAlgorithmKind returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'Basic128' ) | (enumLiteral_2= 'Basic192' ) | (enumLiteral_3= 'Basic256' ) | (enumLiteral_4= 'DES' ) | (enumLiteral_5= '3DES' ) | (enumLiteral_6= 'AES128' ) | (enumLiteral_7= 'AES256' ) ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5850:28: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'Basic128' ) | (enumLiteral_2= 'Basic192' ) | (enumLiteral_3= 'Basic256' ) | (enumLiteral_4= 'DES' ) | (enumLiteral_5= '3DES' ) | (enumLiteral_6= 'AES128' ) | (enumLiteral_7= 'AES256' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5851:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'Basic128' ) | (enumLiteral_2= 'Basic192' ) | (enumLiteral_3= 'Basic256' ) | (enumLiteral_4= 'DES' ) | (enumLiteral_5= '3DES' ) | (enumLiteral_6= 'AES128' ) | (enumLiteral_7= 'AES256' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5851:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'Basic128' ) | (enumLiteral_2= 'Basic192' ) | (enumLiteral_3= 'Basic256' ) | (enumLiteral_4= 'DES' ) | (enumLiteral_5= '3DES' ) | (enumLiteral_6= 'AES128' ) | (enumLiteral_7= 'AES256' ) )
            int alt149=8;
            switch ( input.LA(1) ) {
            case 150:
                {
                alt149=1;
                }
                break;
            case 155:
                {
                alt149=2;
                }
                break;
            case 156:
                {
                alt149=3;
                }
                break;
            case 157:
                {
                alt149=4;
                }
                break;
            case 158:
                {
                alt149=5;
                }
                break;
            case 159:
                {
                alt149=6;
                }
                break;
            case 152:
                {
                alt149=7;
                }
                break;
            case 154:
                {
                alt149=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 149, 0, input);

                throw nvae;
            }

            switch (alt149) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5851:2: (enumLiteral_0= 'NONE' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5851:2: (enumLiteral_0= 'NONE' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5851:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,150,FollowSets000.FOLLOW_150_in_ruleCipherAlgorithmKind12611); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getCipherAlgorithmKindAccess().getNONEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5857:6: (enumLiteral_1= 'Basic128' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5857:6: (enumLiteral_1= 'Basic128' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5857:8: enumLiteral_1= 'Basic128'
                    {
                    enumLiteral_1=(Token)match(input,155,FollowSets000.FOLLOW_155_in_ruleCipherAlgorithmKind12628); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getBasic128EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getCipherAlgorithmKindAccess().getBasic128EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5863:6: (enumLiteral_2= 'Basic192' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5863:6: (enumLiteral_2= 'Basic192' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5863:8: enumLiteral_2= 'Basic192'
                    {
                    enumLiteral_2=(Token)match(input,156,FollowSets000.FOLLOW_156_in_ruleCipherAlgorithmKind12645); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getBasic192EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getCipherAlgorithmKindAccess().getBasic192EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5869:6: (enumLiteral_3= 'Basic256' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5869:6: (enumLiteral_3= 'Basic256' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5869:8: enumLiteral_3= 'Basic256'
                    {
                    enumLiteral_3=(Token)match(input,157,FollowSets000.FOLLOW_157_in_ruleCipherAlgorithmKind12662); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getBasic256EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getCipherAlgorithmKindAccess().getBasic256EnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5875:6: (enumLiteral_4= 'DES' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5875:6: (enumLiteral_4= 'DES' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5875:8: enumLiteral_4= 'DES'
                    {
                    enumLiteral_4=(Token)match(input,158,FollowSets000.FOLLOW_158_in_ruleCipherAlgorithmKind12679); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getDESEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getCipherAlgorithmKindAccess().getDESEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5881:6: (enumLiteral_5= '3DES' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5881:6: (enumLiteral_5= '3DES' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5881:8: enumLiteral_5= '3DES'
                    {
                    enumLiteral_5=(Token)match(input,159,FollowSets000.FOLLOW_159_in_ruleCipherAlgorithmKind12696); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getTRIPLE_DESEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getCipherAlgorithmKindAccess().getTRIPLE_DESEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5887:6: (enumLiteral_6= 'AES128' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5887:6: (enumLiteral_6= 'AES128' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5887:8: enumLiteral_6= 'AES128'
                    {
                    enumLiteral_6=(Token)match(input,152,FollowSets000.FOLLOW_152_in_ruleCipherAlgorithmKind12713); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getAES128EnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getCipherAlgorithmKindAccess().getAES128EnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5893:6: (enumLiteral_7= 'AES256' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5893:6: (enumLiteral_7= 'AES256' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5893:8: enumLiteral_7= 'AES256'
                    {
                    enumLiteral_7=(Token)match(input,154,FollowSets000.FOLLOW_154_in_ruleCipherAlgorithmKind12730); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5903:1: ruleAuthTokenKind returns [Enumerator current=null] : ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'SPNEGO' ) | (enumLiteral_5= 'RELToken' ) | (enumLiteral_6= 'X509Certificate' ) | (enumLiteral_7= 'OAuth' ) | (enumLiteral_8= 'OAuth2' ) ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5905:28: ( ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'SPNEGO' ) | (enumLiteral_5= 'RELToken' ) | (enumLiteral_6= 'X509Certificate' ) | (enumLiteral_7= 'OAuth' ) | (enumLiteral_8= 'OAuth2' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5906:1: ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'SPNEGO' ) | (enumLiteral_5= 'RELToken' ) | (enumLiteral_6= 'X509Certificate' ) | (enumLiteral_7= 'OAuth' ) | (enumLiteral_8= 'OAuth2' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5906:1: ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'SPNEGO' ) | (enumLiteral_5= 'RELToken' ) | (enumLiteral_6= 'X509Certificate' ) | (enumLiteral_7= 'OAuth' ) | (enumLiteral_8= 'OAuth2' ) )
            int alt150=9;
            switch ( input.LA(1) ) {
            case 160:
                {
                alt150=1;
                }
                break;
            case 161:
                {
                alt150=2;
                }
                break;
            case 162:
                {
                alt150=3;
                }
                break;
            case 163:
                {
                alt150=4;
                }
                break;
            case 164:
                {
                alt150=5;
                }
                break;
            case 165:
                {
                alt150=6;
                }
                break;
            case 166:
                {
                alt150=7;
                }
                break;
            case 167:
                {
                alt150=8;
                }
                break;
            case 168:
                {
                alt150=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 150, 0, input);

                throw nvae;
            }

            switch (alt150) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5906:2: (enumLiteral_0= 'UsernamePassword' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5906:2: (enumLiteral_0= 'UsernamePassword' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5906:4: enumLiteral_0= 'UsernamePassword'
                    {
                    enumLiteral_0=(Token)match(input,160,FollowSets000.FOLLOW_160_in_ruleAuthTokenKind12775); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getUsernamePasswordEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAuthTokenKindAccess().getUsernamePasswordEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5912:6: (enumLiteral_1= 'SAML' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5912:6: (enumLiteral_1= 'SAML' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5912:8: enumLiteral_1= 'SAML'
                    {
                    enumLiteral_1=(Token)match(input,161,FollowSets000.FOLLOW_161_in_ruleAuthTokenKind12792); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSAMLEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getAuthTokenKindAccess().getSAMLEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5918:6: (enumLiteral_2= 'SAML2' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5918:6: (enumLiteral_2= 'SAML2' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5918:8: enumLiteral_2= 'SAML2'
                    {
                    enumLiteral_2=(Token)match(input,162,FollowSets000.FOLLOW_162_in_ruleAuthTokenKind12809); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSAML2EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getAuthTokenKindAccess().getSAML2EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5924:6: (enumLiteral_3= 'Kerberos' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5924:6: (enumLiteral_3= 'Kerberos' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5924:8: enumLiteral_3= 'Kerberos'
                    {
                    enumLiteral_3=(Token)match(input,163,FollowSets000.FOLLOW_163_in_ruleAuthTokenKind12826); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getKerberosEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getAuthTokenKindAccess().getKerberosEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5930:6: (enumLiteral_4= 'SPNEGO' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5930:6: (enumLiteral_4= 'SPNEGO' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5930:8: enumLiteral_4= 'SPNEGO'
                    {
                    enumLiteral_4=(Token)match(input,164,FollowSets000.FOLLOW_164_in_ruleAuthTokenKind12843); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSPNEGOEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getAuthTokenKindAccess().getSPNEGOEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5936:6: (enumLiteral_5= 'RELToken' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5936:6: (enumLiteral_5= 'RELToken' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5936:8: enumLiteral_5= 'RELToken'
                    {
                    enumLiteral_5=(Token)match(input,165,FollowSets000.FOLLOW_165_in_ruleAuthTokenKind12860); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getRELTokenEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getAuthTokenKindAccess().getRELTokenEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5942:6: (enumLiteral_6= 'X509Certificate' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5942:6: (enumLiteral_6= 'X509Certificate' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5942:8: enumLiteral_6= 'X509Certificate'
                    {
                    enumLiteral_6=(Token)match(input,166,FollowSets000.FOLLOW_166_in_ruleAuthTokenKind12877); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getX509CertificateEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getAuthTokenKindAccess().getX509CertificateEnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5948:6: (enumLiteral_7= 'OAuth' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5948:6: (enumLiteral_7= 'OAuth' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5948:8: enumLiteral_7= 'OAuth'
                    {
                    enumLiteral_7=(Token)match(input,167,FollowSets000.FOLLOW_167_in_ruleAuthTokenKind12894); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getOAuthEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_7, grammarAccess.getAuthTokenKindAccess().getOAuthEnumLiteralDeclaration_7()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5954:6: (enumLiteral_8= 'OAuth2' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5954:6: (enumLiteral_8= 'OAuth2' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5954:8: enumLiteral_8= 'OAuth2'
                    {
                    enumLiteral_8=(Token)match(input,168,FollowSets000.FOLLOW_168_in_ruleAuthTokenKind12911); if (state.failed) return current;
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


    // $ANTLR start "ruleLogPolicyKind"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5964:1: ruleLogPolicyKind returns [Enumerator current=null] : ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'header' ) | (enumLiteral_2= 'all' ) ) ;
    public final Enumerator ruleLogPolicyKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5966:28: ( ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'header' ) | (enumLiteral_2= 'all' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5967:1: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'header' ) | (enumLiteral_2= 'all' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5967:1: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'header' ) | (enumLiteral_2= 'all' ) )
            int alt151=3;
            switch ( input.LA(1) ) {
            case 169:
                {
                alt151=1;
                }
                break;
            case 146:
                {
                alt151=2;
                }
                break;
            case 149:
                {
                alt151=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 151, 0, input);

                throw nvae;
            }

            switch (alt151) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5967:2: (enumLiteral_0= 'none' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5967:2: (enumLiteral_0= 'none' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5967:4: enumLiteral_0= 'none'
                    {
                    enumLiteral_0=(Token)match(input,169,FollowSets000.FOLLOW_169_in_ruleLogPolicyKind12956); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getLogPolicyKindAccess().getNoneEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getLogPolicyKindAccess().getNoneEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5973:6: (enumLiteral_1= 'header' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5973:6: (enumLiteral_1= 'header' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5973:8: enumLiteral_1= 'header'
                    {
                    enumLiteral_1=(Token)match(input,146,FollowSets000.FOLLOW_146_in_ruleLogPolicyKind12973); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getLogPolicyKindAccess().getHeaderEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getLogPolicyKindAccess().getHeaderEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5979:6: (enumLiteral_2= 'all' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5979:6: (enumLiteral_2= 'all' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5979:8: enumLiteral_2= 'all'
                    {
                    enumLiteral_2=(Token)match(input,149,FollowSets000.FOLLOW_149_in_ruleLogPolicyKind12990); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getLogPolicyKindAccess().getAllEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getLogPolicyKindAccess().getAllEnumLiteralDeclaration_2()); 
                          
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
    // $ANTLR end "ruleLogPolicyKind"


    // $ANTLR start "ruleReliablilityKind"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5989:1: ruleReliablilityKind returns [Enumerator current=null] : ( (enumLiteral_0= 'exactly-once' ) | (enumLiteral_1= 'at-most-once' ) | (enumLiteral_2= 'at-least-once' ) | (enumLiteral_3= 'best-effort' ) ) ;
    public final Enumerator ruleReliablilityKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5991:28: ( ( (enumLiteral_0= 'exactly-once' ) | (enumLiteral_1= 'at-most-once' ) | (enumLiteral_2= 'at-least-once' ) | (enumLiteral_3= 'best-effort' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5992:1: ( (enumLiteral_0= 'exactly-once' ) | (enumLiteral_1= 'at-most-once' ) | (enumLiteral_2= 'at-least-once' ) | (enumLiteral_3= 'best-effort' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5992:1: ( (enumLiteral_0= 'exactly-once' ) | (enumLiteral_1= 'at-most-once' ) | (enumLiteral_2= 'at-least-once' ) | (enumLiteral_3= 'best-effort' ) )
            int alt152=4;
            switch ( input.LA(1) ) {
            case 170:
                {
                alt152=1;
                }
                break;
            case 171:
                {
                alt152=2;
                }
                break;
            case 172:
                {
                alt152=3;
                }
                break;
            case 173:
                {
                alt152=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 152, 0, input);

                throw nvae;
            }

            switch (alt152) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5992:2: (enumLiteral_0= 'exactly-once' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5992:2: (enumLiteral_0= 'exactly-once' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5992:4: enumLiteral_0= 'exactly-once'
                    {
                    enumLiteral_0=(Token)match(input,170,FollowSets000.FOLLOW_170_in_ruleReliablilityKind13035); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReliablilityKindAccess().getEXACTLY_ONCEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getReliablilityKindAccess().getEXACTLY_ONCEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5998:6: (enumLiteral_1= 'at-most-once' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5998:6: (enumLiteral_1= 'at-most-once' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5998:8: enumLiteral_1= 'at-most-once'
                    {
                    enumLiteral_1=(Token)match(input,171,FollowSets000.FOLLOW_171_in_ruleReliablilityKind13052); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReliablilityKindAccess().getAT_MOST_ONCEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getReliablilityKindAccess().getAT_MOST_ONCEEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6004:6: (enumLiteral_2= 'at-least-once' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6004:6: (enumLiteral_2= 'at-least-once' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6004:8: enumLiteral_2= 'at-least-once'
                    {
                    enumLiteral_2=(Token)match(input,172,FollowSets000.FOLLOW_172_in_ruleReliablilityKind13069); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReliablilityKindAccess().getAT_LEAST_ONCEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getReliablilityKindAccess().getAT_LEAST_ONCEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6010:6: (enumLiteral_3= 'best-effort' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6010:6: (enumLiteral_3= 'best-effort' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6010:8: enumLiteral_3= 'best-effort'
                    {
                    enumLiteral_3=(Token)match(input,173,FollowSets000.FOLLOW_173_in_ruleReliablilityKind13086); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6020:1: ruleGovernanceDecisionResult returns [Enumerator current=null] : ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) ) ;
    public final Enumerator ruleGovernanceDecisionResult() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6022:28: ( ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6023:1: ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6023:1: ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) )
            int alt153=4;
            switch ( input.LA(1) ) {
            case 174:
                {
                alt153=1;
                }
                break;
            case 175:
                {
                alt153=2;
                }
                break;
            case 176:
                {
                alt153=3;
                }
                break;
            case 177:
                {
                alt153=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 153, 0, input);

                throw nvae;
            }

            switch (alt153) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6023:2: (enumLiteral_0= 'pending' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6023:2: (enumLiteral_0= 'pending' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6023:4: enumLiteral_0= 'pending'
                    {
                    enumLiteral_0=(Token)match(input,174,FollowSets000.FOLLOW_174_in_ruleGovernanceDecisionResult13131); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getPendingEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getGovernanceDecisionResultAccess().getPendingEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6029:6: (enumLiteral_1= 'accepted' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6029:6: (enumLiteral_1= 'accepted' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6029:8: enumLiteral_1= 'accepted'
                    {
                    enumLiteral_1=(Token)match(input,175,FollowSets000.FOLLOW_175_in_ruleGovernanceDecisionResult13148); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getAcceptedEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getGovernanceDecisionResultAccess().getAcceptedEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6035:6: (enumLiteral_2= 'denied' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6035:6: (enumLiteral_2= 'denied' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6035:8: enumLiteral_2= 'denied'
                    {
                    enumLiteral_2=(Token)match(input,176,FollowSets000.FOLLOW_176_in_ruleGovernanceDecisionResult13165); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getDeniedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getGovernanceDecisionResultAccess().getDeniedEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6041:6: (enumLiteral_3= 'specific' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6041:6: (enumLiteral_3= 'specific' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:6041:8: enumLiteral_3= 'specific'
                    {
                    enumLiteral_3=(Token)match(input,177,FollowSets000.FOLLOW_177_in_ruleGovernanceDecisionResult13182); if (state.failed) return current;
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

    // $ANTLR start synpred13_InternalBindingDsl
    public final void synpred13_InternalBindingDsl_fragment() throws RecognitionException {   
        EObject lv_assertions_23_0 = null;


        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:474:1: ( (lv_assertions_23_0= ruleAssertion ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:474:1: (lv_assertions_23_0= ruleAssertion )
        {
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:474:1: (lv_assertions_23_0= ruleAssertion )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:475:3: lv_assertions_23_0= ruleAssertion
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getModuleBindingAccess().getAssertionsAssertionParserRuleCall_10_2_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleAssertion_in_synpred13_InternalBindingDsl942);
        lv_assertions_23_0=ruleAssertion();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalBindingDsl

    // $ANTLR start synpred24_InternalBindingDsl
    public final void synpred24_InternalBindingDsl_fragment() throws RecognitionException {   
        EObject lv_assertions_22_0 = null;


        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:797:1: ( (lv_assertions_22_0= ruleAssertion ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:797:1: (lv_assertions_22_0= ruleAssertion )
        {
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:797:1: (lv_assertions_22_0= ruleAssertion )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:798:3: lv_assertions_22_0= ruleAssertion
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getServiceBindingAccess().getAssertionsAssertionParserRuleCall_12_2_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleAssertion_in_synpred24_InternalBindingDsl1577);
        lv_assertions_22_0=ruleAssertion();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred24_InternalBindingDsl

    // $ANTLR start synpred35_InternalBindingDsl
    public final void synpred35_InternalBindingDsl_fragment() throws RecognitionException {   
        EObject lv_assertions_20_0 = null;


        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1120:1: ( (lv_assertions_20_0= ruleAssertion ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1120:1: (lv_assertions_20_0= ruleAssertion )
        {
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1120:1: (lv_assertions_20_0= ruleAssertion )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1121:3: lv_assertions_20_0= ruleAssertion
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getChannelBindingAccess().getAssertionsAssertionParserRuleCall_11_2_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleAssertion_in_synpred35_InternalBindingDsl2217);
        lv_assertions_20_0=ruleAssertion();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred35_InternalBindingDsl

    // $ANTLR start synpred57_InternalBindingDsl
    public final void synpred57_InternalBindingDsl_fragment() throws RecognitionException {   
        EObject lv_assertions_23_0 = null;


        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1542:1: ( (lv_assertions_23_0= ruleAssertion ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1542:1: (lv_assertions_23_0= ruleAssertion )
        {
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1542:1: (lv_assertions_23_0= ruleAssertion )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1543:3: lv_assertions_23_0= ruleAssertion
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getOperationBindingAccess().getAssertionsAssertionParserRuleCall_12_2_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleAssertion_in_synpred57_InternalBindingDsl3128);
        lv_assertions_23_0=ruleAssertion();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred57_InternalBindingDsl

    // $ANTLR start synpred127_InternalBindingDsl
    public final void synpred127_InternalBindingDsl_fragment() throws RecognitionException {   
        EObject this_AvailabilityAssertion_0 = null;


        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4024:2: (this_AvailabilityAssertion_0= ruleAvailabilityAssertion )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4024:2: this_AvailabilityAssertion_0= ruleAvailabilityAssertion
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleAvailabilityAssertion_in_synpred127_InternalBindingDsl8134);
        this_AvailabilityAssertion_0=ruleAvailabilityAssertion();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred127_InternalBindingDsl

    // $ANTLR start synpred128_InternalBindingDsl
    public final void synpred128_InternalBindingDsl_fragment() throws RecognitionException {   
        EObject this_LatencyAssertion_1 = null;


        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4037:2: (this_LatencyAssertion_1= ruleLatencyAssertion )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4037:2: this_LatencyAssertion_1= ruleLatencyAssertion
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleLatencyAssertion_in_synpred128_InternalBindingDsl8164);
        this_LatencyAssertion_1=ruleLatencyAssertion();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred128_InternalBindingDsl

    // $ANTLR start synpred129_InternalBindingDsl
    public final void synpred129_InternalBindingDsl_fragment() throws RecognitionException {   
        EObject this_CapacityAssertion_2 = null;


        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4050:2: (this_CapacityAssertion_2= ruleCapacityAssertion )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4050:2: this_CapacityAssertion_2= ruleCapacityAssertion
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleCapacityAssertion_in_synpred129_InternalBindingDsl8194);
        this_CapacityAssertion_2=ruleCapacityAssertion();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred129_InternalBindingDsl

    // $ANTLR start synpred130_InternalBindingDsl
    public final void synpred130_InternalBindingDsl_fragment() throws RecognitionException {   
        EObject this_ReliablityAsserttion_3 = null;


        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4063:2: (this_ReliablityAsserttion_3= ruleReliablityAsserttion )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4063:2: this_ReliablityAsserttion_3= ruleReliablityAsserttion
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleReliablityAsserttion_in_synpred130_InternalBindingDsl8224);
        this_ReliablityAsserttion_3=ruleReliablityAsserttion();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred130_InternalBindingDsl

    // $ANTLR start synpred131_InternalBindingDsl
    public final void synpred131_InternalBindingDsl_fragment() throws RecognitionException {   
        EObject this_CostAssertion_4 = null;


        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4076:2: (this_CostAssertion_4= ruleCostAssertion )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4076:2: this_CostAssertion_4= ruleCostAssertion
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleCostAssertion_in_synpred131_InternalBindingDsl8254);
        this_CostAssertion_4=ruleCostAssertion();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred131_InternalBindingDsl

    // $ANTLR start synpred132_InternalBindingDsl
    public final void synpred132_InternalBindingDsl_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        Token lv_availability_2_0=null;

        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4130:4: (otherlv_1= 'availability' ( (lv_availability_2_0= RULE_STRING ) ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4130:4: otherlv_1= 'availability' ( (lv_availability_2_0= RULE_STRING ) )
        {
        otherlv_1=(Token)match(input,83,FollowSets000.FOLLOW_83_in_synpred132_InternalBindingDsl8379); if (state.failed) return ;
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4134:1: ( (lv_availability_2_0= RULE_STRING ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4135:1: (lv_availability_2_0= RULE_STRING )
        {
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4135:1: (lv_availability_2_0= RULE_STRING )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4136:3: lv_availability_2_0= RULE_STRING
        {
        lv_availability_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred132_InternalBindingDsl8396); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred132_InternalBindingDsl

    // $ANTLR start synpred133_InternalBindingDsl
    public final void synpred133_InternalBindingDsl_fragment() throws RecognitionException {   
        Token otherlv_3=null;
        Token lv_mtbf_4_0=null;

        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4152:6: (otherlv_3= 'mean-time-between-failure' ( (lv_mtbf_4_0= RULE_STRING ) ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4152:6: otherlv_3= 'mean-time-between-failure' ( (lv_mtbf_4_0= RULE_STRING ) )
        {
        otherlv_3=(Token)match(input,84,FollowSets000.FOLLOW_84_in_synpred133_InternalBindingDsl8416); if (state.failed) return ;
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4156:1: ( (lv_mtbf_4_0= RULE_STRING ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4157:1: (lv_mtbf_4_0= RULE_STRING )
        {
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4157:1: (lv_mtbf_4_0= RULE_STRING )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4158:3: lv_mtbf_4_0= RULE_STRING
        {
        lv_mtbf_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred133_InternalBindingDsl8433); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred133_InternalBindingDsl

    // $ANTLR start synpred135_InternalBindingDsl
    public final void synpred135_InternalBindingDsl_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        Token lv_mttr_6_0=null;
        EObject lv_mttrPercentile_7_0 = null;


        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4174:6: (otherlv_5= 'mean-time-to-repair' ( (lv_mttr_6_0= RULE_STRING ) ) ( (lv_mttrPercentile_7_0= rulePercentile ) )? )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4174:6: otherlv_5= 'mean-time-to-repair' ( (lv_mttr_6_0= RULE_STRING ) ) ( (lv_mttrPercentile_7_0= rulePercentile ) )?
        {
        otherlv_5=(Token)match(input,85,FollowSets000.FOLLOW_85_in_synpred135_InternalBindingDsl8453); if (state.failed) return ;
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4178:1: ( (lv_mttr_6_0= RULE_STRING ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4179:1: (lv_mttr_6_0= RULE_STRING )
        {
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4179:1: (lv_mttr_6_0= RULE_STRING )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4180:3: lv_mttr_6_0= RULE_STRING
        {
        lv_mttr_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred135_InternalBindingDsl8470); if (state.failed) return ;

        }


        }

        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4196:2: ( (lv_mttrPercentile_7_0= rulePercentile ) )?
        int alt172=2;
        int LA172_0 = input.LA(1);

        if ( (LA172_0==RULE_INT) ) {
            alt172=1;
        }
        switch (alt172) {
            case 1 :
                // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4197:1: (lv_mttrPercentile_7_0= rulePercentile )
                {
                // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4197:1: (lv_mttrPercentile_7_0= rulePercentile )
                // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4198:3: lv_mttrPercentile_7_0= rulePercentile
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getAvailabilityAssertionAccess().getMttrPercentilePercentileParserRuleCall_3_2_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_rulePercentile_in_synpred135_InternalBindingDsl8496);
                lv_mttrPercentile_7_0=rulePercentile();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred135_InternalBindingDsl

    // $ANTLR start synpred136_InternalBindingDsl
    public final void synpred136_InternalBindingDsl_fragment() throws RecognitionException {   
        Token otherlv_8=null;
        Token lv_regularDownTimes_9_0=null;

        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4214:7: (otherlv_8= 'regular-down-times' ( (lv_regularDownTimes_9_0= RULE_STRING ) ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4214:7: otherlv_8= 'regular-down-times' ( (lv_regularDownTimes_9_0= RULE_STRING ) )
        {
        otherlv_8=(Token)match(input,86,FollowSets000.FOLLOW_86_in_synpred136_InternalBindingDsl8512); if (state.failed) return ;
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4218:1: ( (lv_regularDownTimes_9_0= RULE_STRING ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4219:1: (lv_regularDownTimes_9_0= RULE_STRING )
        {
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4219:1: (lv_regularDownTimes_9_0= RULE_STRING )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4220:3: lv_regularDownTimes_9_0= RULE_STRING
        {
        lv_regularDownTimes_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred136_InternalBindingDsl8529); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred136_InternalBindingDsl

    // $ANTLR start synpred137_InternalBindingDsl
    public final void synpred137_InternalBindingDsl_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        Token lv_requestNum_2_0=null;
        Token otherlv_3=null;
        Token lv_timeUnit_4_0=null;

        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4328:4: (otherlv_1= 'num-of-requests' ( (lv_requestNum_2_0= RULE_STRING ) ) otherlv_3= 'per' ( (lv_timeUnit_4_0= RULE_STRING ) ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4328:4: otherlv_1= 'num-of-requests' ( (lv_requestNum_2_0= RULE_STRING ) ) otherlv_3= 'per' ( (lv_timeUnit_4_0= RULE_STRING ) )
        {
        otherlv_1=(Token)match(input,90,FollowSets000.FOLLOW_90_in_synpred137_InternalBindingDsl8779); if (state.failed) return ;
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4332:1: ( (lv_requestNum_2_0= RULE_STRING ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4333:1: (lv_requestNum_2_0= RULE_STRING )
        {
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4333:1: (lv_requestNum_2_0= RULE_STRING )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4334:3: lv_requestNum_2_0= RULE_STRING
        {
        lv_requestNum_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred137_InternalBindingDsl8796); if (state.failed) return ;

        }


        }

        otherlv_3=(Token)match(input,91,FollowSets000.FOLLOW_91_in_synpred137_InternalBindingDsl8813); if (state.failed) return ;
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4354:1: ( (lv_timeUnit_4_0= RULE_STRING ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4355:1: (lv_timeUnit_4_0= RULE_STRING )
        {
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4355:1: (lv_timeUnit_4_0= RULE_STRING )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4356:3: lv_timeUnit_4_0= RULE_STRING
        {
        lv_timeUnit_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred137_InternalBindingDsl8830); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred137_InternalBindingDsl

    // $ANTLR start synpred138_InternalBindingDsl
    public final void synpred138_InternalBindingDsl_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        Token lv_messageSize_6_0=null;

        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4372:6: (otherlv_5= 'message-size' ( (lv_messageSize_6_0= RULE_STRING ) ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4372:6: otherlv_5= 'message-size' ( (lv_messageSize_6_0= RULE_STRING ) )
        {
        otherlv_5=(Token)match(input,92,FollowSets000.FOLLOW_92_in_synpred138_InternalBindingDsl8850); if (state.failed) return ;
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4376:1: ( (lv_messageSize_6_0= RULE_STRING ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4377:1: (lv_messageSize_6_0= RULE_STRING )
        {
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4377:1: (lv_messageSize_6_0= RULE_STRING )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4378:3: lv_messageSize_6_0= RULE_STRING
        {
        lv_messageSize_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred138_InternalBindingDsl8867); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred138_InternalBindingDsl

    // Delegated rules

    public final boolean synpred130_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred130_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred135_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred135_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred133_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred133_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred138_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred138_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred129_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred129_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred131_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred131_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred127_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred127_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred128_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred128_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred136_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred136_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred132_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred132_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred137_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred137_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA116 dfa116 = new DFA116(this);
    static final String DFA116_eotS =
        "\23\uffff";
    static final String DFA116_eofS =
        "\1\14\22\uffff";
    static final String DFA116_minS =
        "\1\24\14\0\6\uffff";
    static final String DFA116_maxS =
        "\1\141\14\0\6\uffff";
    static final String DFA116_acceptS =
        "\15\uffff\1\1\1\3\1\2\1\4\1\5\1\6";
    static final String DFA116_specialS =
        "\1\uffff\1\10\1\0\1\6\1\13\1\1\1\7\1\4\1\2\1\5\1\11\1\12\1\3\6\uffff}>";
    static final String[] DFA116_transitionS = {
            "\1\5\76\uffff\1\1\1\2\1\3\1\4\1\6\2\uffff\1\7\1\uffff\1\10\1"+
            "\11\1\uffff\1\12\1\uffff\1\13",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA116_eot = DFA.unpackEncodedString(DFA116_eotS);
    static final short[] DFA116_eof = DFA.unpackEncodedString(DFA116_eofS);
    static final char[] DFA116_min = DFA.unpackEncodedStringToUnsignedChars(DFA116_minS);
    static final char[] DFA116_max = DFA.unpackEncodedStringToUnsignedChars(DFA116_maxS);
    static final short[] DFA116_accept = DFA.unpackEncodedString(DFA116_acceptS);
    static final short[] DFA116_special = DFA.unpackEncodedString(DFA116_specialS);
    static final short[][] DFA116_transition;

    static {
        int numStates = DFA116_transitionS.length;
        DFA116_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA116_transition[i] = DFA.unpackEncodedString(DFA116_transitionS[i]);
        }
    }

    class DFA116 extends DFA {

        public DFA116(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 116;
            this.eot = DFA116_eot;
            this.eof = DFA116_eof;
            this.min = DFA116_min;
            this.max = DFA116_max;
            this.accept = DFA116_accept;
            this.special = DFA116_special;
            this.transition = DFA116_transition;
        }
        public String getDescription() {
            return "4023:1: (this_AvailabilityAssertion_0= ruleAvailabilityAssertion | this_LatencyAssertion_1= ruleLatencyAssertion | this_CapacityAssertion_2= ruleCapacityAssertion | this_ReliablityAsserttion_3= ruleReliablityAsserttion | this_CostAssertion_4= ruleCostAssertion | this_AccuracyAssertion_5= ruleAccuracyAssertion )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA116_2 = input.LA(1);

                         
                        int index116_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred127_InternalBindingDsl()) ) {s = 13;}

                        else if ( (synpred129_InternalBindingDsl()) ) {s = 14;}

                         
                        input.seek(index116_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA116_5 = input.LA(1);

                         
                        int index116_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred127_InternalBindingDsl()) ) {s = 13;}

                        else if ( (synpred129_InternalBindingDsl()) ) {s = 14;}

                         
                        input.seek(index116_5);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA116_8 = input.LA(1);

                         
                        int index116_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred127_InternalBindingDsl()) ) {s = 13;}

                        else if ( (synpred129_InternalBindingDsl()) ) {s = 14;}

                         
                        input.seek(index116_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA116_12 = input.LA(1);

                         
                        int index116_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred127_InternalBindingDsl()) ) {s = 13;}

                        else if ( (synpred129_InternalBindingDsl()) ) {s = 14;}

                         
                        input.seek(index116_12);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA116_7 = input.LA(1);

                         
                        int index116_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred127_InternalBindingDsl()) ) {s = 13;}

                        else if ( (synpred129_InternalBindingDsl()) ) {s = 14;}

                         
                        input.seek(index116_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA116_9 = input.LA(1);

                         
                        int index116_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred127_InternalBindingDsl()) ) {s = 13;}

                        else if ( (synpred129_InternalBindingDsl()) ) {s = 14;}

                        else if ( (synpred130_InternalBindingDsl()) ) {s = 16;}

                         
                        input.seek(index116_9);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA116_3 = input.LA(1);

                         
                        int index116_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred127_InternalBindingDsl()) ) {s = 13;}

                        else if ( (synpred129_InternalBindingDsl()) ) {s = 14;}

                         
                        input.seek(index116_3);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA116_6 = input.LA(1);

                         
                        int index116_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred127_InternalBindingDsl()) ) {s = 13;}

                        else if ( (synpred128_InternalBindingDsl()) ) {s = 15;}

                        else if ( (synpred129_InternalBindingDsl()) ) {s = 14;}

                         
                        input.seek(index116_6);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA116_1 = input.LA(1);

                         
                        int index116_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred127_InternalBindingDsl()) ) {s = 13;}

                        else if ( (synpred129_InternalBindingDsl()) ) {s = 14;}

                         
                        input.seek(index116_1);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA116_10 = input.LA(1);

                         
                        int index116_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred127_InternalBindingDsl()) ) {s = 13;}

                        else if ( (synpred129_InternalBindingDsl()) ) {s = 14;}

                        else if ( (synpred131_InternalBindingDsl()) ) {s = 17;}

                         
                        input.seek(index116_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA116_11 = input.LA(1);

                         
                        int index116_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred127_InternalBindingDsl()) ) {s = 13;}

                        else if ( (synpred129_InternalBindingDsl()) ) {s = 14;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index116_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA116_4 = input.LA(1);

                         
                        int index116_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred127_InternalBindingDsl()) ) {s = 13;}

                        else if ( (synpred129_InternalBindingDsl()) ) {s = 14;}

                         
                        input.seek(index116_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 116, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleBindingModel_in_entryRuleBindingModel81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBindingModel91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_ruleBindingModel137 = new BitSet(new long[]{0x0000000020802002L,0x0000002000000000L});
        public static final BitSet FOLLOW_ruleBinding_in_ruleBindingModel159 = new BitSet(new long[]{0x0000000020802002L});
        public static final BitSet FOLLOW_ruleBinding_in_entryRuleBinding196 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBinding206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModuleBinding_in_ruleBinding256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceBinding_in_ruleBinding286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChannelBinding_in_ruleBinding316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_entryRuleConnectorQualifier351 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConnectorQualifier361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleConnectorQualifier398 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleConnectorQualifier425 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_12_in_ruleConnectorQualifier438 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleConnectorQualifier465 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_ruleModuleBinding_in_entryRuleModuleBinding503 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModuleBinding513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleModuleBinding550 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleModuleRef_in_ruleModuleBinding571 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleModuleBinding583 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModuleBinding604 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleModuleBinding616 = new BitSet(new long[]{0x0000000000050000L});
        public static final BitSet FOLLOW_16_in_ruleModuleBinding630 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModuleBinding657 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleModuleBinding669 = new BitSet(new long[]{0x0000000000F80000L,0x0000801000000000L});
        public static final BitSet FOLLOW_18_in_ruleModuleBinding689 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModuleBinding716 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleModuleBinding728 = new BitSet(new long[]{0x0000000000F80000L,0x0000801000000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleModuleBinding751 = new BitSet(new long[]{0x0000000000F80000L,0x0000800000000000L});
        public static final BitSet FOLLOW_ruleGovernanceDecision_in_ruleModuleBinding773 = new BitSet(new long[]{0x0000000000F80000L,0x0000800000000000L});
        public static final BitSet FOLLOW_19_in_ruleModuleBinding787 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleModuleBinding799 = new BitSet(new long[]{0x51108A8200000000L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleModuleBinding820 = new BitSet(new long[]{0x51108A8200100000L,0x0000000000000005L});
        public static final BitSet FOLLOW_20_in_ruleModuleBinding833 = new BitSet(new long[]{0x0000000000F00000L});
        public static final BitSet FOLLOW_21_in_ruleModuleBinding848 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleModuleBinding860 = new BitSet(new long[]{0x0000000000100000L,0x0000000000021030L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleModuleBinding881 = new BitSet(new long[]{0x0000000000100000L,0x0000000000021030L});
        public static final BitSet FOLLOW_20_in_ruleModuleBinding894 = new BitSet(new long[]{0x0000000000D00000L});
        public static final BitSet FOLLOW_22_in_ruleModuleBinding909 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleModuleBinding921 = new BitSet(new long[]{0x0000000000000000L,0x00000002B4F80000L});
        public static final BitSet FOLLOW_ruleAssertion_in_ruleModuleBinding942 = new BitSet(new long[]{0x0000000000100000L,0x00000002B4F80000L});
        public static final BitSet FOLLOW_20_in_ruleModuleBinding955 = new BitSet(new long[]{0x0000000000900000L});
        public static final BitSet FOLLOW_ruleServiceBinding_in_ruleModuleBinding978 = new BitSet(new long[]{0x0000000000900000L});
        public static final BitSet FOLLOW_20_in_ruleModuleBinding991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModuleRef_in_entryRuleModuleRef1027 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModuleRef1037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModuleRef1089 = new BitSet(new long[]{0x0000000000000000L,0x0000198000000000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleModuleRef1110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceBinding_in_entryRuleServiceBinding1146 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleServiceBinding1156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleServiceBinding1193 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleServiceBinding1214 = new BitSet(new long[]{0x0000000000028000L});
        public static final BitSet FOLLOW_15_in_ruleServiceBinding1227 = new BitSet(new long[]{0x0000000000050000L});
        public static final BitSet FOLLOW_16_in_ruleServiceBinding1241 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleServiceBinding1268 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_18_in_ruleServiceBinding1288 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleServiceBinding1315 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleServiceBinding1331 = new BitSet(new long[]{0x0000000003000000L,0x0000801000000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleServiceBinding1352 = new BitSet(new long[]{0x0000000003000000L,0x0000800000000000L});
        public static final BitSet FOLLOW_ruleGovernanceDecision_in_ruleServiceBinding1374 = new BitSet(new long[]{0x0000000003000000L,0x0000800000000000L});
        public static final BitSet FOLLOW_24_in_ruleServiceBinding1388 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleServiceBinding1405 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleServiceBinding1424 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleServiceBinding1436 = new BitSet(new long[]{0x51108A8200000000L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleServiceBinding1457 = new BitSet(new long[]{0x51108A8200100000L,0x0000000000000005L});
        public static final BitSet FOLLOW_20_in_ruleServiceBinding1470 = new BitSet(new long[]{0x000000005C100000L});
        public static final BitSet FOLLOW_26_in_ruleServiceBinding1483 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleServiceBinding1495 = new BitSet(new long[]{0x0000000000100000L,0x0000000000021030L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleServiceBinding1516 = new BitSet(new long[]{0x0000000000100000L,0x0000000000021030L});
        public static final BitSet FOLLOW_20_in_ruleServiceBinding1529 = new BitSet(new long[]{0x0000000058100000L});
        public static final BitSet FOLLOW_27_in_ruleServiceBinding1544 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleServiceBinding1556 = new BitSet(new long[]{0x0000000000000000L,0x00000002B4F80000L});
        public static final BitSet FOLLOW_ruleAssertion_in_ruleServiceBinding1577 = new BitSet(new long[]{0x0000000000100000L,0x00000002B4F80000L});
        public static final BitSet FOLLOW_20_in_ruleServiceBinding1590 = new BitSet(new long[]{0x0000000050100000L});
        public static final BitSet FOLLOW_28_in_ruleServiceBinding1605 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleModuleRef_in_ruleServiceBinding1626 = new BitSet(new long[]{0x0000000040100000L});
        public static final BitSet FOLLOW_ruleOperationBinding_in_ruleServiceBinding1649 = new BitSet(new long[]{0x0000000040100000L});
        public static final BitSet FOLLOW_20_in_ruleServiceBinding1662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceRef_in_entryRuleServiceRef1698 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleServiceRef1708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleServiceRef1760 = new BitSet(new long[]{0x0000000000000000L,0x0000198000000000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleServiceRef1781 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChannelBinding_in_entryRuleChannelBinding1817 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChannelBinding1827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleChannelBinding1864 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleChannelBinding1891 = new BitSet(new long[]{0x0000000000028000L});
        public static final BitSet FOLLOW_15_in_ruleChannelBinding1904 = new BitSet(new long[]{0x0000000000050000L});
        public static final BitSet FOLLOW_16_in_ruleChannelBinding1918 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleChannelBinding1945 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_18_in_ruleChannelBinding1965 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleChannelBinding1992 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleChannelBinding2008 = new BitSet(new long[]{0x0000000002000000L,0x0000801000000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleChannelBinding2029 = new BitSet(new long[]{0x0000000002000000L,0x0000800000000000L});
        public static final BitSet FOLLOW_ruleGovernanceDecision_in_ruleChannelBinding2051 = new BitSet(new long[]{0x0000000002000000L,0x0000800000000000L});
        public static final BitSet FOLLOW_25_in_ruleChannelBinding2064 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleChannelBinding2076 = new BitSet(new long[]{0x51108A8200000000L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleChannelBinding2097 = new BitSet(new long[]{0x51108A8200100000L,0x0000000000000005L});
        public static final BitSet FOLLOW_20_in_ruleChannelBinding2110 = new BitSet(new long[]{0x000000001C100000L});
        public static final BitSet FOLLOW_26_in_ruleChannelBinding2123 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleChannelBinding2135 = new BitSet(new long[]{0x0000000000100000L,0x0000000000021030L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleChannelBinding2156 = new BitSet(new long[]{0x0000000000100000L,0x0000000000021030L});
        public static final BitSet FOLLOW_20_in_ruleChannelBinding2169 = new BitSet(new long[]{0x0000000018100000L});
        public static final BitSet FOLLOW_27_in_ruleChannelBinding2184 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleChannelBinding2196 = new BitSet(new long[]{0x0000000000000000L,0x00000002B4F80000L});
        public static final BitSet FOLLOW_ruleAssertion_in_ruleChannelBinding2217 = new BitSet(new long[]{0x0000000000100000L,0x00000002B4F80000L});
        public static final BitSet FOLLOW_20_in_ruleChannelBinding2230 = new BitSet(new long[]{0x0000000010100000L});
        public static final BitSet FOLLOW_28_in_ruleChannelBinding2245 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleModuleRef_in_ruleChannelBinding2266 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleChannelBinding2280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_entryRuleBindingProtocol2316 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBindingProtocol2326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSCA_in_ruleBindingProtocol2376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSOAP_in_ruleBindingProtocol2406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEJB_in_ruleBindingProtocol2436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHTTP_in_ruleBindingProtocol2466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleREST_in_ruleBindingProtocol2496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSAP_in_ruleBindingProtocol2526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJMS_in_ruleBindingProtocol2556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFILE_in_ruleBindingProtocol2586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFTP_in_ruleBindingProtocol2616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIIOP_in_ruleBindingProtocol2646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAMQP_in_ruleBindingProtocol2676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperationBinding_in_entryRuleOperationBinding2711 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperationBinding2721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleOperationBinding2758 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleOperationBinding2785 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleOperationBinding2797 = new BitSet(new long[]{0x0000000002000000L,0x0000801000000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleOperationBinding2818 = new BitSet(new long[]{0x0000000002000000L,0x0000800000000000L});
        public static final BitSet FOLLOW_ruleGovernanceDecision_in_ruleOperationBinding2840 = new BitSet(new long[]{0x0000000002000000L,0x0000800000000000L});
        public static final BitSet FOLLOW_25_in_ruleOperationBinding2853 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleOperationBinding2865 = new BitSet(new long[]{0x51108A8200000000L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleOperationBinding2886 = new BitSet(new long[]{0x51108A8200100000L,0x0000000000000005L});
        public static final BitSet FOLLOW_20_in_ruleOperationBinding2899 = new BitSet(new long[]{0x000000018C100000L});
        public static final BitSet FOLLOW_31_in_ruleOperationBinding2912 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleOperationBinding2924 = new BitSet(new long[]{0x51108A8200000000L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleOperationBinding2945 = new BitSet(new long[]{0x51108A8200100000L,0x0000000000000005L});
        public static final BitSet FOLLOW_20_in_ruleOperationBinding2958 = new BitSet(new long[]{0x000000010C100000L});
        public static final BitSet FOLLOW_26_in_ruleOperationBinding2973 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleOperationBinding2985 = new BitSet(new long[]{0x0000000000100000L,0x0000000000021030L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleOperationBinding3006 = new BitSet(new long[]{0x0000000000100000L,0x0000000000021030L});
        public static final BitSet FOLLOW_20_in_ruleOperationBinding3019 = new BitSet(new long[]{0x0000000108100000L});
        public static final BitSet FOLLOW_32_in_ruleOperationBinding3034 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleOperationBinding3046 = new BitSet(new long[]{0x0000000000100000L,0x0000000000021030L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleOperationBinding3067 = new BitSet(new long[]{0x0000000000100000L,0x0000000000021030L});
        public static final BitSet FOLLOW_20_in_ruleOperationBinding3080 = new BitSet(new long[]{0x0000000008100000L});
        public static final BitSet FOLLOW_27_in_ruleOperationBinding3095 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleOperationBinding3107 = new BitSet(new long[]{0x0000000000000000L,0x00000002B4F80000L});
        public static final BitSet FOLLOW_ruleAssertion_in_ruleOperationBinding3128 = new BitSet(new long[]{0x0000000000100000L,0x00000002B4F80000L});
        public static final BitSet FOLLOW_20_in_ruleOperationBinding3141 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleOperationBinding3155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSOAP_in_entryRuleSOAP3191 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSOAP3201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleSOAP3238 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleSOAP3250 = new BitSet(new long[]{0x0000007C00100800L,0x0000001000000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleSOAP3283 = new BitSet(new long[]{0x0000007C00100800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleSOAP3305 = new BitSet(new long[]{0x0000007C00100000L});
        public static final BitSet FOLLOW_34_in_ruleSOAP3319 = new BitSet(new long[]{0x0000000000000000L,0x0700000000000000L});
        public static final BitSet FOLLOW_ruleSOAPStyle_in_ruleSOAP3340 = new BitSet(new long[]{0x0000007800100000L});
        public static final BitSet FOLLOW_35_in_ruleSOAP3355 = new BitSet(new long[]{0x0000000000000000L,0x3000000000000000L});
        public static final BitSet FOLLOW_ruleSOAPProtocolVersion_in_ruleSOAP3376 = new BitSet(new long[]{0x0000007000100000L});
        public static final BitSet FOLLOW_36_in_ruleSOAP3391 = new BitSet(new long[]{0x0010080000000000L,0x0800000000000000L});
        public static final BitSet FOLLOW_ruleSOAPTransport_in_ruleSOAP3412 = new BitSet(new long[]{0x0000006000100000L});
        public static final BitSet FOLLOW_37_in_ruleSOAP3427 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSOAP3444 = new BitSet(new long[]{0x0000004000100000L});
        public static final BitSet FOLLOW_38_in_ruleSOAP3464 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSOAP3481 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleSOAP3500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSAP_in_entryRuleSAP3536 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSAP3546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleSAP3583 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleSAP3595 = new BitSet(new long[]{0x0000011000100800L,0x0000001000000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleSAP3628 = new BitSet(new long[]{0x0000011000100800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleSAP3650 = new BitSet(new long[]{0x0000011000100000L});
        public static final BitSet FOLLOW_36_in_ruleSAP3664 = new BitSet(new long[]{0x0000000000000000L,0xC000000000000000L});
        public static final BitSet FOLLOW_ruleSAPTransport_in_ruleSAP3685 = new BitSet(new long[]{0x0000010000100000L});
        public static final BitSet FOLLOW_40_in_ruleSAP3700 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSAP3727 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleSAP3741 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEJB_in_entryRuleEJB3777 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEJB3787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleEJB3824 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleEJB3836 = new BitSet(new long[]{0x0000040000000800L,0x0000001000000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleEJB3857 = new BitSet(new long[]{0x0000040000000800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleEJB3879 = new BitSet(new long[]{0x0000040000000000L});
        public static final BitSet FOLLOW_42_in_ruleEJB3892 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEJB3909 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleEJB3926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHTTP_in_entryRuleHTTP3962 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHTTP3972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleHTTP4009 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleHTTP4021 = new BitSet(new long[]{0x0000100000000800L,0x0000001000000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleHTTP4042 = new BitSet(new long[]{0x0000100000000800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleHTTP4064 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_ruleHTTP4077 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleHTTP4094 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleHTTP4111 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleHTTP4128 = new BitSet(new long[]{0x0000400000000000L});
        public static final BitSet FOLLOW_46_in_ruleHTTP4145 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000007F0L});
        public static final BitSet FOLLOW_ruleVerb_in_ruleHTTP4166 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleHTTP4178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleREST_in_entryRuleREST4214 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleREST4224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleREST4261 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleREST4273 = new BitSet(new long[]{0x0001000000000800L,0x0000001000000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleREST4294 = new BitSet(new long[]{0x0001000000000800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleREST4316 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleREST4329 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleREST4346 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleREST4363 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleREST4380 = new BitSet(new long[]{0x0000400000000000L});
        public static final BitSet FOLLOW_46_in_ruleREST4397 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000007F0L});
        public static final BitSet FOLLOW_ruleVerb_in_ruleREST4418 = new BitSet(new long[]{0x000E000000100000L});
        public static final BitSet FOLLOW_49_in_ruleREST4431 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x000000000000000FL});
        public static final BitSet FOLLOW_ruleRESTFormat_in_ruleREST4452 = new BitSet(new long[]{0x000C000000100000L});
        public static final BitSet FOLLOW_50_in_ruleREST4467 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x000000000000000FL});
        public static final BitSet FOLLOW_ruleRESTFormat_in_ruleREST4488 = new BitSet(new long[]{0x0008000000100000L});
        public static final BitSet FOLLOW_51_in_ruleREST4503 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x000000000000000FL});
        public static final BitSet FOLLOW_ruleRESTFormat_in_ruleREST4524 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleREST4538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJMS_in_entryRuleJMS4574 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleJMS4584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleJMS4621 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleJMS4633 = new BitSet(new long[]{0x00C0040000000800L,0x0000001000000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleJMS4666 = new BitSet(new long[]{0x00C0040000000800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleJMS4688 = new BitSet(new long[]{0x00C0040000000000L});
        public static final BitSet FOLLOW_ruleTopicOrQueue_in_ruleJMS4710 = new BitSet(new long[]{0x0000040000000000L});
        public static final BitSet FOLLOW_42_in_ruleJMS4723 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleJMS4740 = new BitSet(new long[]{0x0020000000100000L});
        public static final BitSet FOLLOW_53_in_ruleJMS4758 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleJMS4775 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleJMS4794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTopicOrQueue_in_entryRuleTopicOrQueue4830 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTopicOrQueue4840 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTopic_in_ruleTopicOrQueue4890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQueue_in_ruleTopicOrQueue4920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTopic_in_entryRuleTopic4955 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTopic4965 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleTopic5002 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleTopic5019 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleTopic5045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQueue_in_entryRuleQueue5082 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQueue5092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleQueue5129 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleQueue5146 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleQueue5172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSCA_in_entryRuleSCA5209 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSCA5219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleSCA5268 = new BitSet(new long[]{0x0000000000020010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSCA5285 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleSCA5303 = new BitSet(new long[]{0x0600000000100800L,0x0000001000000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleSCA5324 = new BitSet(new long[]{0x0600000000100800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleSCA5346 = new BitSet(new long[]{0x0600000000100000L});
        public static final BitSet FOLLOW_57_in_ruleSCA5360 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSCA5377 = new BitSet(new long[]{0x0400000000100000L});
        public static final BitSet FOLLOW_58_in_ruleSCA5397 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSCA5414 = new BitSet(new long[]{0x0800000000100000L});
        public static final BitSet FOLLOW_59_in_ruleSCA5437 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleSCA5465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFILE_in_entryRuleFILE5501 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFILE5511 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleFILE5548 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleFILE5560 = new BitSet(new long[]{0x0000000000000810L,0x0000001000000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleFILE5581 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleFILE5603 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFILE5621 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001800L});
        public static final BitSet FOLLOW_ruleReadWrite_in_ruleFILE5647 = new BitSet(new long[]{0x2000000000100000L});
        public static final BitSet FOLLOW_61_in_ruleFILE5660 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFILE5677 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleFILE5696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFTP_in_entryRuleFTP5732 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFTP5742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleFTP5779 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleFTP5791 = new BitSet(new long[]{0x8000000000000800L,0x0000001000000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleFTP5812 = new BitSet(new long[]{0x8000000000000800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleFTP5834 = new BitSet(new long[]{0x8000000000000000L});
        public static final BitSet FOLLOW_63_in_ruleFTP5847 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001800L});
        public static final BitSet FOLLOW_ruleReadWrite_in_ruleFTP5868 = new BitSet(new long[]{0x2000000000100000L});
        public static final BitSet FOLLOW_61_in_ruleFTP5881 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFTP5898 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleFTP5917 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIIOP_in_entryRuleIIOP5953 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIIOP5963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_ruleIIOP6000 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleIIOP6012 = new BitSet(new long[]{0x0000000000000800L,0x0000001000000002L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleIIOP6033 = new BitSet(new long[]{0x0000000000000800L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleIIOP6055 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleIIOP6068 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleIIOP6085 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleIIOP6102 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAMQP_in_entryRuleAMQP6138 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAMQP6148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleAMQP6185 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleAMQP6197 = new BitSet(new long[]{0x00C0000000000800L,0x0000001000000002L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleAMQP6230 = new BitSet(new long[]{0x00C0000000000800L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleAMQP6252 = new BitSet(new long[]{0x00C0000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTopicOrQueue_in_ruleAMQP6274 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleAMQP6287 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAMQP6304 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleAMQP6322 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAMQP6339 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleAMQP6358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePolicy_in_entryRulePolicy6394 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePolicy6404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLogPolicy_in_rulePolicy6454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecurityPolicy_in_rulePolicy6484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLogPolicy_in_entryRuleLogPolicy6519 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLogPolicy6529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleLogPolicy6566 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000020000240000L});
        public static final BitSet FOLLOW_ruleLogPolicyKind_in_ruleLogPolicy6587 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecurityPolicy_in_entryRuleSecurityPolicy6623 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecurityPolicy6633 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthenticationPolicy_in_ruleSecurityPolicy6683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSigningPolicy_in_ruleSecurityPolicy6713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEncryptionPolicy_in_ruleSecurityPolicy6743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthenticationPolicy_in_entryRuleAuthenticationPolicy6778 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAuthenticationPolicy6788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_69_in_ruleAuthenticationPolicy6837 = new BitSet(new long[]{0x0000000000020020L,0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAuthenticationPolicy6854 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000040L});
        public static final BitSet FOLLOW_70_in_ruleAuthenticationPolicy6878 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleAuthenticationPolicy6904 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_ruleAuthenticationPolicy6916 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleAuthenticationPolicy6928 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L,0x000001FF00000000L});
        public static final BitSet FOLLOW_ruleAuthToken_in_ruleAuthenticationPolicy6949 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000040L,0x000001FF00000000L});
        public static final BitSet FOLLOW_20_in_ruleAuthenticationPolicy6962 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_72_in_ruleAuthenticationPolicy6974 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleAuthenticationPolicy6986 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000840L,0x000000000003E000L});
        public static final BitSet FOLLOW_ruleHashAlgorithm_in_ruleAuthenticationPolicy7007 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000840L,0x000000000003E000L});
        public static final BitSet FOLLOW_20_in_ruleAuthenticationPolicy7020 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000600L});
        public static final BitSet FOLLOW_73_in_ruleAuthenticationPolicy7038 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000400L});
        public static final BitSet FOLLOW_74_in_ruleAuthenticationPolicy7065 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAuthenticationPolicy7082 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleAuthenticationPolicy7101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthToken_in_entryRuleAuthToken7137 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAuthToken7147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleAuthToken7190 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L,0x000001FF00000000L});
        public static final BitSet FOLLOW_ruleAuthTokenKind_in_ruleAuthToken7225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHashAlgorithm_in_entryRuleHashAlgorithm7261 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHashAlgorithm7271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleHashAlgorithm7314 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000840L,0x000000000003E000L});
        public static final BitSet FOLLOW_75_in_ruleHashAlgorithm7346 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000840L,0x000000000003E000L});
        public static final BitSet FOLLOW_ruleHashAlgKind_in_ruleHashAlgorithm7381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSigningPolicy_in_entryRuleSigningPolicy7417 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSigningPolicy7427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_76_in_ruleSigningPolicy7476 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleSigningPolicy7488 = new BitSet(new long[]{0x0000000000100000L,0x000000000000E000L});
        public static final BitSet FOLLOW_77_in_ruleSigningPolicy7501 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000007C0E000L});
        public static final BitSet FOLLOW_ruleSigningAlgothm_in_ruleSigningPolicy7522 = new BitSet(new long[]{0x0000000000100000L,0x000000000000C000L,0x0000000007C0E000L});
        public static final BitSet FOLLOW_78_in_ruleSigningPolicy7538 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000007C0E000L});
        public static final BitSet FOLLOW_ruleSigningAlgothm_in_ruleSigningPolicy7559 = new BitSet(new long[]{0x0000000000100000L,0x0000000000008000L});
        public static final BitSet FOLLOW_79_in_ruleSigningPolicy7574 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x00000000003C0000L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_ruleSigningPolicy7595 = new BitSet(new long[]{0x0000000000101000L});
        public static final BitSet FOLLOW_12_in_ruleSigningPolicy7608 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x00000000003C0000L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_ruleSigningPolicy7629 = new BitSet(new long[]{0x0000000000101000L});
        public static final BitSet FOLLOW_20_in_ruleSigningPolicy7645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_entryRuleMessagePartRef7681 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMessagePartRef7691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMessagePartRefKind_in_ruleMessagePartRef7737 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
        public static final BitSet FOLLOW_80_in_ruleMessagePartRef7750 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleMessagePartRef7767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEncryptionPolicy_in_entryRuleEncryptionPolicy7810 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEncryptionPolicy7820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_81_in_ruleEncryptionPolicy7869 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleEncryptionPolicy7881 = new BitSet(new long[]{0x0000000000100000L,0x0000000000046000L});
        public static final BitSet FOLLOW_77_in_ruleEncryptionPolicy7894 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000FD400000L});
        public static final BitSet FOLLOW_ruleCipherAlgorithmKind_in_ruleEncryptionPolicy7915 = new BitSet(new long[]{0x0000000000100000L,0x0000000000044000L,0x00000000FD400000L});
        public static final BitSet FOLLOW_78_in_ruleEncryptionPolicy7931 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000FD400000L});
        public static final BitSet FOLLOW_ruleCipherAlgorithmKind_in_ruleEncryptionPolicy7952 = new BitSet(new long[]{0x0000000000100000L,0x0000000000040000L});
        public static final BitSet FOLLOW_82_in_ruleEncryptionPolicy7967 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x00000000003C0000L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_ruleEncryptionPolicy7988 = new BitSet(new long[]{0x0000000000101000L});
        public static final BitSet FOLLOW_12_in_ruleEncryptionPolicy8001 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x00000000003C0000L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_ruleEncryptionPolicy8022 = new BitSet(new long[]{0x0000000000101000L});
        public static final BitSet FOLLOW_20_in_ruleEncryptionPolicy8038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssertion_in_entryRuleAssertion8074 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssertion8084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAvailabilityAssertion_in_ruleAssertion8134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLatencyAssertion_in_ruleAssertion8164 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCapacityAssertion_in_ruleAssertion8194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReliablityAsserttion_in_ruleAssertion8224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCostAssertion_in_ruleAssertion8254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAccuracyAssertion_in_ruleAssertion8284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAvailabilityAssertion_in_entryRuleAvailabilityAssertion8319 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAvailabilityAssertion8329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_83_in_ruleAvailabilityAssertion8379 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAvailabilityAssertion8396 = new BitSet(new long[]{0x0000000000000002L,0x0000000000700000L});
        public static final BitSet FOLLOW_84_in_ruleAvailabilityAssertion8416 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAvailabilityAssertion8433 = new BitSet(new long[]{0x0000000000000002L,0x0000000000600000L});
        public static final BitSet FOLLOW_85_in_ruleAvailabilityAssertion8453 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAvailabilityAssertion8470 = new BitSet(new long[]{0x0000000000000042L,0x0000000000400000L});
        public static final BitSet FOLLOW_rulePercentile_in_ruleAvailabilityAssertion8496 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
        public static final BitSet FOLLOW_86_in_ruleAvailabilityAssertion8512 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAvailabilityAssertion8529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLatencyAssertion_in_entryRuleLatencyAssertion8572 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLatencyAssertion8582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_87_in_ruleLatencyAssertion8619 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
        public static final BitSet FOLLOW_88_in_ruleLatencyAssertion8637 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
        public static final BitSet FOLLOW_89_in_ruleLatencyAssertion8662 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rulePercentile_in_ruleLatencyAssertion8683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCapacityAssertion_in_entryRuleCapacityAssertion8719 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCapacityAssertion8729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_90_in_ruleCapacityAssertion8779 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCapacityAssertion8796 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
        public static final BitSet FOLLOW_91_in_ruleCapacityAssertion8813 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCapacityAssertion8830 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
        public static final BitSet FOLLOW_92_in_ruleCapacityAssertion8850 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCapacityAssertion8867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReliablityAsserttion_in_entryRuleReliablityAsserttion8910 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReliablityAsserttion8920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_93_in_ruleReliablityAsserttion8957 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00003C0000000000L});
        public static final BitSet FOLLOW_ruleReliablilityKind_in_ruleReliablityAsserttion8978 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
        public static final BitSet FOLLOW_94_in_ruleReliablityAsserttion8996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCostAssertion_in_entryRuleCostAssertion9046 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCostAssertion9056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_95_in_ruleCostAssertion9093 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCostAssertion9110 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
        public static final BitSet FOLLOW_96_in_ruleCostAssertion9127 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCostAssertion9144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAccuracyAssertion_in_entryRuleAccuracyAssertion9185 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAccuracyAssertion9195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_97_in_ruleAccuracyAssertion9232 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAccuracyAssertion9249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePercentile_in_entryRulePercentile9290 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePercentile9300 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rulePercentile9342 = new BitSet(new long[]{0x0000000000000000L,0x0000000C00000000L});
        public static final BitSet FOLLOW_98_in_rulePercentile9360 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_rulePercentile9371 = new BitSet(new long[]{0x0000000000000000L,0x0000000C00000000L});
        public static final BitSet FOLLOW_99_in_rulePercentile9384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_entryRuleEndpointQualifierRef9420 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEndpointQualifierRef9430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_100_in_ruleEndpointQualifierRef9467 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleEndpointQualifierRef9494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport9530 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport9540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_101_in_ruleImport9577 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport9598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVersionId_in_entryRuleVersionId9635 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionId9646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId9686 = new BitSet(new long[]{0x0000000000000002L,0x0000004400000000L});
        public static final BitSet FOLLOW_98_in_ruleVersionId9705 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId9720 = new BitSet(new long[]{0x0000000000000002L,0x0000004400000000L});
        public static final BitSet FOLLOW_98_in_ruleVersionId9742 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_102_in_ruleVersionId9761 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVersionId9777 = new BitSet(new long[]{0x0000000000000002L,0x0000004400000000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_entryRuleVersionRef9828 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionRef9838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_ruleVersionRef9888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_ruleVersionRef9918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef9948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_ruleVersionRef9978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_ruleVersionRef10008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef10043 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMinVersionRef10053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_103_in_ruleMinVersionRef10090 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMinVersionRef10111 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef10147 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxVersionRef10157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_104_in_ruleMaxVersionRef10194 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMaxVersionRef10215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef10251 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef10261 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_103_in_ruleLowerBoundRangeVersionRef10299 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
        public static final BitSet FOLLOW_105_in_ruleLowerBoundRangeVersionRef10311 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef10333 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleLowerBoundRangeVersionRef10345 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
        public static final BitSet FOLLOW_104_in_ruleLowerBoundRangeVersionRef10358 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
        public static final BitSet FOLLOW_106_in_ruleLowerBoundRangeVersionRef10370 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef10392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef10428 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMajorVersionRef10438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_107_in_ruleMajorVersionRef10475 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMajorVersionRef10492 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef10533 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFixedVersionRef10543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_108_in_ruleFixedVersionRef10580 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleFixedVersionRef10601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard10638 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard10649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard10696 = new BitSet(new long[]{0x0000000000000002L,0x0000200000000000L});
        public static final BitSet FOLLOW_109_in_ruleQualifiedNameWithWildCard10715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10758 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName10769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName10809 = new BitSet(new long[]{0x0000000000000002L,0x0000400400000000L});
        public static final BitSet FOLLOW_98_in_ruleQualifiedName10829 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_110_in_ruleQualifiedName10848 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName10864 = new BitSet(new long[]{0x0000000000000002L,0x0000400400000000L});
        public static final BitSet FOLLOW_ruleGovernanceDecision_in_entryRuleGovernanceDecision10911 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGovernanceDecision10921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_111_in_ruleGovernanceDecision10958 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleGovernanceDecision10970 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
        public static final BitSet FOLLOW_112_in_ruleGovernanceDecision10983 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGovernanceDecision11000 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
        public static final BitSet FOLLOW_113_in_ruleGovernanceDecision11019 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0003C00000000000L});
        public static final BitSet FOLLOW_ruleGovernanceDecisionResult_in_ruleGovernanceDecision11040 = new BitSet(new long[]{0x0000000000100000L,0x007C000000000000L});
        public static final BitSet FOLLOW_114_in_ruleGovernanceDecision11054 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGovernanceDecision11071 = new BitSet(new long[]{0x0000000000100000L,0x0078000000000000L});
        public static final BitSet FOLLOW_115_in_ruleGovernanceDecision11091 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGovernanceDecision11108 = new BitSet(new long[]{0x0000000000100000L,0x0070000000000000L});
        public static final BitSet FOLLOW_116_in_ruleGovernanceDecision11128 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGovernanceDecision11145 = new BitSet(new long[]{0x0000000000100000L,0x0060000000000000L});
        public static final BitSet FOLLOW_117_in_ruleGovernanceDecision11165 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGovernanceDecision11182 = new BitSet(new long[]{0x0000000000100000L,0x0040000000000000L});
        public static final BitSet FOLLOW_118_in_ruleGovernanceDecision11202 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGovernanceDecision11219 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleGovernanceDecision11238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfoItem_in_entryRuleInfoItem11278 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfoItem11288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_119_in_ruleInfoItem11325 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleInfoItem11342 = new BitSet(new long[]{0x0400000000000002L});
        public static final BitSet FOLLOW_58_in_ruleInfoItem11360 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleInfoItem11377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRoleRef_in_entryRuleRoleRef11422 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoleRef11432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRoleRef11483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrivilegeRef_in_entryRulePrivilegeRef11520 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrivilegeRef11530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rulePrivilegeRef11581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_120_in_ruleSOAPStyle11634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_121_in_ruleSOAPStyle11651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_122_in_ruleSOAPStyle11668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleSOAPTransport11713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleSOAPTransport11730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_123_in_ruleSOAPTransport11747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_124_in_ruleSOAPProtocolVersion11792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_125_in_ruleSOAPProtocolVersion11809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_126_in_ruleSAPTransport11854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_127_in_ruleSAPTransport11871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_128_in_ruleRESTFormat11916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_129_in_ruleRESTFormat11933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_130_in_ruleRESTFormat11950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_131_in_ruleRESTFormat11967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_132_in_ruleVerb12012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_133_in_ruleVerb12029 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_134_in_ruleVerb12046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_135_in_ruleVerb12063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_136_in_ruleVerb12080 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_137_in_ruleVerb12097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_138_in_ruleVerb12114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_139_in_ruleReadWrite12159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_140_in_ruleReadWrite12176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_141_in_ruleHashAlgKind12221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_142_in_ruleHashAlgKind12238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_143_in_ruleHashAlgKind12255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_144_in_ruleHashAlgKind12272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_145_in_ruleHashAlgKind12289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_146_in_ruleMessagePartRefKind12334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_147_in_ruleMessagePartRefKind12351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_148_in_ruleMessagePartRefKind12368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_149_in_ruleMessagePartRefKind12385 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_80_in_ruleMessagePartRefKind12402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_150_in_ruleSigningAlgothm12447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_142_in_ruleSigningAlgothm12464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_143_in_ruleSigningAlgothm12481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_141_in_ruleSigningAlgothm12498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_151_in_ruleSigningAlgothm12515 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_152_in_ruleSigningAlgothm12532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_153_in_ruleSigningAlgothm12549 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_154_in_ruleSigningAlgothm12566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_150_in_ruleCipherAlgorithmKind12611 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_155_in_ruleCipherAlgorithmKind12628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_156_in_ruleCipherAlgorithmKind12645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_157_in_ruleCipherAlgorithmKind12662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_158_in_ruleCipherAlgorithmKind12679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_159_in_ruleCipherAlgorithmKind12696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_152_in_ruleCipherAlgorithmKind12713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_154_in_ruleCipherAlgorithmKind12730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_160_in_ruleAuthTokenKind12775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_161_in_ruleAuthTokenKind12792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_162_in_ruleAuthTokenKind12809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_163_in_ruleAuthTokenKind12826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_164_in_ruleAuthTokenKind12843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_165_in_ruleAuthTokenKind12860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_166_in_ruleAuthTokenKind12877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_167_in_ruleAuthTokenKind12894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_168_in_ruleAuthTokenKind12911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_169_in_ruleLogPolicyKind12956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_146_in_ruleLogPolicyKind12973 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_149_in_ruleLogPolicyKind12990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_170_in_ruleReliablilityKind13035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_171_in_ruleReliablilityKind13052 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_172_in_ruleReliablilityKind13069 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_173_in_ruleReliablilityKind13086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_174_in_ruleGovernanceDecisionResult13131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_175_in_ruleGovernanceDecisionResult13148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_176_in_ruleGovernanceDecisionResult13165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_177_in_ruleGovernanceDecisionResult13182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssertion_in_synpred13_InternalBindingDsl942 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssertion_in_synpred24_InternalBindingDsl1577 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssertion_in_synpred35_InternalBindingDsl2217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssertion_in_synpred57_InternalBindingDsl3128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAvailabilityAssertion_in_synpred127_InternalBindingDsl8134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLatencyAssertion_in_synpred128_InternalBindingDsl8164 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCapacityAssertion_in_synpred129_InternalBindingDsl8194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReliablityAsserttion_in_synpred130_InternalBindingDsl8224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCostAssertion_in_synpred131_InternalBindingDsl8254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_83_in_synpred132_InternalBindingDsl8379 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred132_InternalBindingDsl8396 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_84_in_synpred133_InternalBindingDsl8416 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred133_InternalBindingDsl8433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_85_in_synpred135_InternalBindingDsl8453 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred135_InternalBindingDsl8470 = new BitSet(new long[]{0x0000000000000042L});
        public static final BitSet FOLLOW_rulePercentile_in_synpred135_InternalBindingDsl8496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_86_in_synpred136_InternalBindingDsl8512 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred136_InternalBindingDsl8529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_90_in_synpred137_InternalBindingDsl8779 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred137_InternalBindingDsl8796 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
        public static final BitSet FOLLOW_91_in_synpred137_InternalBindingDsl8813 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred137_InternalBindingDsl8830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_92_in_synpred138_InternalBindingDsl8850 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred138_InternalBindingDsl8867 = new BitSet(new long[]{0x0000000000000002L});
    }


}