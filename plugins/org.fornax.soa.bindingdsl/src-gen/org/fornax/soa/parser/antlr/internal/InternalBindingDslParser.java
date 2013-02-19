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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'on'", "'connector'", "','", "'bind-module'", "'as'", "'to'", "'environment'", "'{'", "'server'", "'default-protocols'", "'}'", "'default-policies'", "'default-assertions'", "'bind-service'", "'provided-contract'", "'protocols'", "'policies'", "'assertions'", "'references-module'", "'bind-operation'", "'provider-protocols'", "'provider-policies'", "'SOAP'", "'style'", "'http-context-root'", "'provided-WSDL-Url'", "'SAP'", "'transport'", "'client'", "'EJB'", "'jndi-name'", "'HTTP'", "'url'", "'provider-url'", "'verb'", "'REST'", "'path'", "'format'", "'consumes-format'", "'provides-format'", "'JMS'", "'provider-jndi-name'", "'topic'", "'queue'", "'SCA'", "'promote'", "'reference'", "'[]'", "'FILE'", "'interval'", "'FTP'", "'access'", "'IIOP'", "'lookup-name'", "'AMQP'", "'provider-lookup-name'", "'logging-policy'", "'authn-policy'", "'optional'", "'auth-tokens'", "'hash-algorithms'", "'use-nonce'", "'issuer'", "'Base64-encoded'", "'signing-policy'", "'supported-algorithms'", "'requires-algorithm'", "'signed-message-parts'", "'expression'", "'encryption-policy'", "'encrypted-message-parts'", "'availability'", "'percentile'", "'mean-time-between-failure'", "'mean-time-to-repair'", "'latency'", "'STRING'", "'num-of-requests'", "'per'", "'message-size'", "'message-exchange-reliability'", "'in-order-delivery'", "'costs'", "'billed-per-unit'", "'max-error-rate'", "'.'", "'%'", "'endpoint-qualifier'", "'import'", "'-'", "'minVersion'", "'maxVersion'", "'>='", "'<'", "'majorVersion'", "'fixedVersion'", "'.*'", "'governance-decision'", "'subject'", "'decision-result'", "'specific-result'", "'justification-doc'", "'decision-date'", "'decision-by'", "'effective-date'", "'document/literal-wrapped'", "'rpc/literal'", "'rpc/encoded'", "'IDOC'", "'RFC'", "'JSON'", "'XML'", "'BISON'", "'OTHER'", "'CREATE'", "'RETRIEVE'", "'UPDATE'", "'DELETE'", "'GET'", "'PUT'", "'POST'", "'read'", "'write'", "'MD5'", "'SHA1'", "'SHA256'", "'RSA'", "'PlainText'", "'header'", "'body'", "'attachments'", "'all'", "'NONE'", "'RSA_1_5'", "'AES128'", "'AES192'", "'AES256'", "'Basic128'", "'Basic192'", "'Basic256'", "'DES'", "'3DES'", "'UsernamePassword'", "'SAML'", "'SAML2'", "'Kerberos'", "'SPNEGO'", "'RELToken'", "'X509Certificate'", "'OAuth'", "'OAuth2'", "'none'", "'exactly-once'", "'at-most-once'", "'at-least-once'", "'best-effort'", "'pending'", "'accepted'", "'denied'", "'specific'"
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

                if ( (LA1_0==99) ) {
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

                if ( (LA2_0==14||LA2_0==24) ) {
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:140:1: ruleBinding returns [EObject current=null] : (this_ModuleBinding_0= ruleModuleBinding | this_ServiceBinding_1= ruleServiceBinding ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        EObject this_ModuleBinding_0 = null;

        EObject this_ServiceBinding_1 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:143:28: ( (this_ModuleBinding_0= ruleModuleBinding | this_ServiceBinding_1= ruleServiceBinding ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:144:1: (this_ModuleBinding_0= ruleModuleBinding | this_ServiceBinding_1= ruleServiceBinding )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:144:1: (this_ModuleBinding_0= ruleModuleBinding | this_ServiceBinding_1= ruleServiceBinding )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            else if ( (LA3_0==24) ) {
                alt3=2;
            }
            else {
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:177:1: entryRuleConnectorQualifier returns [EObject current=null] : iv_ruleConnectorQualifier= ruleConnectorQualifier EOF ;
    public final EObject entryRuleConnectorQualifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectorQualifier = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:178:2: (iv_ruleConnectorQualifier= ruleConnectorQualifier EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:179:2: iv_ruleConnectorQualifier= ruleConnectorQualifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConnectorQualifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_entryRuleConnectorQualifier321);
            iv_ruleConnectorQualifier=ruleConnectorQualifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConnectorQualifier; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConnectorQualifier331); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:186:1: ruleConnectorQualifier returns [EObject current=null] : (otherlv_0= 'on' otherlv_1= 'connector' ( ( ruleQualifiedName ) ) (otherlv_3= ',' ( ( ruleQualifiedName ) ) )* ) ;
    public final EObject ruleConnectorQualifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:189:28: ( (otherlv_0= 'on' otherlv_1= 'connector' ( ( ruleQualifiedName ) ) (otherlv_3= ',' ( ( ruleQualifiedName ) ) )* ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:190:1: (otherlv_0= 'on' otherlv_1= 'connector' ( ( ruleQualifiedName ) ) (otherlv_3= ',' ( ( ruleQualifiedName ) ) )* )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:190:1: (otherlv_0= 'on' otherlv_1= 'connector' ( ( ruleQualifiedName ) ) (otherlv_3= ',' ( ( ruleQualifiedName ) ) )* )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:190:3: otherlv_0= 'on' otherlv_1= 'connector' ( ( ruleQualifiedName ) ) (otherlv_3= ',' ( ( ruleQualifiedName ) ) )*
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleConnectorQualifier368); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getConnectorQualifierAccess().getOnKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleConnectorQualifier380); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getConnectorQualifierAccess().getConnectorKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:198:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:199:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:199:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:200:3: ruleQualifiedName
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
               
              	        newCompositeNode(grammarAccess.getConnectorQualifierAccess().getConnectorsConnectorCrossReference_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleConnectorQualifier407);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:216:2: (otherlv_3= ',' ( ( ruleQualifiedName ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:216:4: otherlv_3= ',' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleConnectorQualifier420); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getConnectorQualifierAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:220:1: ( ( ruleQualifiedName ) )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:221:1: ( ruleQualifiedName )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:221:1: ( ruleQualifiedName )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:222:3: ruleQualifiedName
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
            	       
            	      	        newCompositeNode(grammarAccess.getConnectorQualifierAccess().getConnectorsConnectorCrossReference_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleConnectorQualifier447);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:246:1: entryRuleModuleBinding returns [EObject current=null] : iv_ruleModuleBinding= ruleModuleBinding EOF ;
    public final EObject entryRuleModuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModuleBinding = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:247:2: (iv_ruleModuleBinding= ruleModuleBinding EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:248:2: iv_ruleModuleBinding= ruleModuleBinding EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModuleBindingRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModuleBinding_in_entryRuleModuleBinding485);
            iv_ruleModuleBinding=ruleModuleBinding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModuleBinding; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModuleBinding495); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:255:1: ruleModuleBinding returns [EObject current=null] : (otherlv_0= 'bind-module' ( (lv_module_1_0= ruleModuleRef ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' ( (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ) | (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' ) ) ( (lv_endpointQualifierRef_11_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_12_0= ruleGovernanceDecision ) )* (otherlv_13= 'default-protocols' otherlv_14= '{' ( (lv_protocol_15_0= ruleBindingProtocol ) )+ otherlv_16= '}' )? (otherlv_17= 'default-policies' otherlv_18= '{' ( (lv_policies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'default-assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )? ( (lv_serviceBindings_25_0= ruleServiceBinding ) )* otherlv_26= '}' ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:258:28: ( (otherlv_0= 'bind-module' ( (lv_module_1_0= ruleModuleRef ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' ( (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ) | (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' ) ) ( (lv_endpointQualifierRef_11_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_12_0= ruleGovernanceDecision ) )* (otherlv_13= 'default-protocols' otherlv_14= '{' ( (lv_protocol_15_0= ruleBindingProtocol ) )+ otherlv_16= '}' )? (otherlv_17= 'default-policies' otherlv_18= '{' ( (lv_policies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'default-assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )? ( (lv_serviceBindings_25_0= ruleServiceBinding ) )* otherlv_26= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:259:1: (otherlv_0= 'bind-module' ( (lv_module_1_0= ruleModuleRef ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' ( (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ) | (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' ) ) ( (lv_endpointQualifierRef_11_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_12_0= ruleGovernanceDecision ) )* (otherlv_13= 'default-protocols' otherlv_14= '{' ( (lv_protocol_15_0= ruleBindingProtocol ) )+ otherlv_16= '}' )? (otherlv_17= 'default-policies' otherlv_18= '{' ( (lv_policies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'default-assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )? ( (lv_serviceBindings_25_0= ruleServiceBinding ) )* otherlv_26= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:259:1: (otherlv_0= 'bind-module' ( (lv_module_1_0= ruleModuleRef ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' ( (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ) | (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' ) ) ( (lv_endpointQualifierRef_11_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_12_0= ruleGovernanceDecision ) )* (otherlv_13= 'default-protocols' otherlv_14= '{' ( (lv_protocol_15_0= ruleBindingProtocol ) )+ otherlv_16= '}' )? (otherlv_17= 'default-policies' otherlv_18= '{' ( (lv_policies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'default-assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )? ( (lv_serviceBindings_25_0= ruleServiceBinding ) )* otherlv_26= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:259:3: otherlv_0= 'bind-module' ( (lv_module_1_0= ruleModuleRef ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' ( (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ) | (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' ) ) ( (lv_endpointQualifierRef_11_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_12_0= ruleGovernanceDecision ) )* (otherlv_13= 'default-protocols' otherlv_14= '{' ( (lv_protocol_15_0= ruleBindingProtocol ) )+ otherlv_16= '}' )? (otherlv_17= 'default-policies' otherlv_18= '{' ( (lv_policies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'default-assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )? ( (lv_serviceBindings_25_0= ruleServiceBinding ) )* otherlv_26= '}'
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModuleBinding532); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getModuleBindingAccess().getBindModuleKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:263:1: ( (lv_module_1_0= ruleModuleRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:264:1: (lv_module_1_0= ruleModuleRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:264:1: (lv_module_1_0= ruleModuleRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:265:3: lv_module_1_0= ruleModuleRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModuleBindingAccess().getModuleModuleRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleModuleRef_in_ruleModuleBinding553);
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

            otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModuleBinding565); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getModuleBindingAccess().getAsKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:285:1: ( (lv_name_3_0= ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:286:1: (lv_name_3_0= ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:286:1: (lv_name_3_0= ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:287:3: lv_name_3_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModuleBindingAccess().getNameQualifiedNameParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModuleBinding586);
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

            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModuleBinding598); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getModuleBindingAccess().getToKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:307:1: ( (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ) | (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            else if ( (LA5_0==19) ) {
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:307:2: (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:307:2: (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:307:4: otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{'
                    {
                    otherlv_5=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModuleBinding612); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getModuleBindingAccess().getEnvironmentKeyword_5_0_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:311:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:312:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:312:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:313:3: ruleQualifiedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModuleBinding639);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_7=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModuleBinding651); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getModuleBindingAccess().getLeftCurlyBracketKeyword_5_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:334:6: (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:334:6: (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:334:8: otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{'
                    {
                    otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleModuleBinding671); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getModuleBindingAccess().getServerKeyword_5_1_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:338:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:339:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:339:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:340:3: ruleQualifiedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModuleBinding698);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_10=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModuleBinding710); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getModuleBindingAccess().getLeftCurlyBracketKeyword_5_1_2());
                          
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:360:3: ( (lv_endpointQualifierRef_11_0= ruleEndpointQualifierRef ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==98) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:361:1: (lv_endpointQualifierRef_11_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:361:1: (lv_endpointQualifierRef_11_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:362:3: lv_endpointQualifierRef_11_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleModuleBinding733);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:378:3: ( (lv_governanceDecisions_12_0= ruleGovernanceDecision ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==108) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:379:1: (lv_governanceDecisions_12_0= ruleGovernanceDecision )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:379:1: (lv_governanceDecisions_12_0= ruleGovernanceDecision )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:380:3: lv_governanceDecisions_12_0= ruleGovernanceDecision
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getGovernanceDecisionsGovernanceDecisionParserRuleCall_7_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleGovernanceDecision_in_ruleModuleBinding755);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:396:3: (otherlv_13= 'default-protocols' otherlv_14= '{' ( (lv_protocol_15_0= ruleBindingProtocol ) )+ otherlv_16= '}' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:396:5: otherlv_13= 'default-protocols' otherlv_14= '{' ( (lv_protocol_15_0= ruleBindingProtocol ) )+ otherlv_16= '}'
                    {
                    otherlv_13=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleModuleBinding769); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getModuleBindingAccess().getDefaultProtocolsKeyword_8_0());
                          
                    }
                    otherlv_14=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModuleBinding781); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getModuleBindingAccess().getLeftCurlyBracketKeyword_8_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:404:1: ( (lv_protocol_15_0= ruleBindingProtocol ) )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==33||LA8_0==37||LA8_0==40||LA8_0==42||LA8_0==46||LA8_0==51||LA8_0==55||LA8_0==59||LA8_0==61||LA8_0==63||LA8_0==65) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:405:1: (lv_protocol_15_0= ruleBindingProtocol )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:405:1: (lv_protocol_15_0= ruleBindingProtocol )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:406:3: lv_protocol_15_0= ruleBindingProtocol
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getProtocolBindingProtocolParserRuleCall_8_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleModuleBinding802);
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

                    otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleModuleBinding815); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getModuleBindingAccess().getRightCurlyBracketKeyword_8_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:426:3: (otherlv_17= 'default-policies' otherlv_18= '{' ( (lv_policies_19_0= rulePolicy ) )* otherlv_20= '}' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:426:5: otherlv_17= 'default-policies' otherlv_18= '{' ( (lv_policies_19_0= rulePolicy ) )* otherlv_20= '}'
                    {
                    otherlv_17=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleModuleBinding830); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getModuleBindingAccess().getDefaultPoliciesKeyword_9_0());
                          
                    }
                    otherlv_18=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModuleBinding842); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getModuleBindingAccess().getLeftCurlyBracketKeyword_9_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:434:1: ( (lv_policies_19_0= rulePolicy ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>=67 && LA10_0<=68)||LA10_0==75||LA10_0==80) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:435:1: (lv_policies_19_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:435:1: (lv_policies_19_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:436:3: lv_policies_19_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getPoliciesPolicyParserRuleCall_9_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleModuleBinding863);
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

                    otherlv_20=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleModuleBinding876); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getModuleBindingAccess().getRightCurlyBracketKeyword_9_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:456:3: (otherlv_21= 'default-assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==23) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:456:5: otherlv_21= 'default-assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}'
                    {
                    otherlv_21=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleModuleBinding891); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_21, grammarAccess.getModuleBindingAccess().getDefaultAssertionsKeyword_10_0());
                          
                    }
                    otherlv_22=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModuleBinding903); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_22, grammarAccess.getModuleBindingAccess().getLeftCurlyBracketKeyword_10_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:464:1: ( (lv_assertions_23_0= ruleAssertion ) )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==21) ) {
                            int LA12_1 = input.LA(2);

                            if ( (synpred12_InternalBindingDsl()) ) {
                                alt12=1;
                            }


                        }
                        else if ( (LA12_0==82||LA12_0==86||LA12_0==88||(LA12_0>=90 && LA12_0<=91)||LA12_0==93||LA12_0==95) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:465:1: (lv_assertions_23_0= ruleAssertion )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:465:1: (lv_assertions_23_0= ruleAssertion )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:466:3: lv_assertions_23_0= ruleAssertion
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getAssertionsAssertionParserRuleCall_10_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssertion_in_ruleModuleBinding924);
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

                    otherlv_24=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleModuleBinding937); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_24, grammarAccess.getModuleBindingAccess().getRightCurlyBracketKeyword_10_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:486:3: ( (lv_serviceBindings_25_0= ruleServiceBinding ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==24) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:487:1: (lv_serviceBindings_25_0= ruleServiceBinding )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:487:1: (lv_serviceBindings_25_0= ruleServiceBinding )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:488:3: lv_serviceBindings_25_0= ruleServiceBinding
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getServiceBindingsServiceBindingParserRuleCall_11_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceBinding_in_ruleModuleBinding960);
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

            otherlv_26=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleModuleBinding973); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:516:1: entryRuleModuleRef returns [EObject current=null] : iv_ruleModuleRef= ruleModuleRef EOF ;
    public final EObject entryRuleModuleRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModuleRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:517:2: (iv_ruleModuleRef= ruleModuleRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:518:2: iv_ruleModuleRef= ruleModuleRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModuleRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModuleRef_in_entryRuleModuleRef1009);
            iv_ruleModuleRef=ruleModuleRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModuleRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModuleRef1019); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:525:1: ruleModuleRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) ;
    public final EObject ruleModuleRef() throws RecognitionException {
        EObject current = null;

        EObject lv_versionRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:528:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:529:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:529:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:529:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:529:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:530:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:530:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:531:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModuleRef1071);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:547:2: ( (lv_versionRef_1_0= ruleVersionRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:548:1: (lv_versionRef_1_0= ruleVersionRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:548:1: (lv_versionRef_1_0= ruleVersionRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:549:3: lv_versionRef_1_0= ruleVersionRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModuleRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleModuleRef1092);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:573:1: entryRuleServiceBinding returns [EObject current=null] : iv_ruleServiceBinding= ruleServiceBinding EOF ;
    public final EObject entryRuleServiceBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceBinding = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:574:2: (iv_ruleServiceBinding= ruleServiceBinding EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:575:2: iv_ruleServiceBinding= ruleServiceBinding EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getServiceBindingRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceBinding_in_entryRuleServiceBinding1128);
            iv_ruleServiceBinding=ruleServiceBinding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleServiceBinding; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleServiceBinding1138); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:582:1: ruleServiceBinding returns [EObject current=null] : (otherlv_0= 'bind-service' ( (lv_service_1_0= ruleServiceRef ) ) otherlv_2= '{' ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* (otherlv_5= 'provided-contract' ( (lv_providedContract_6_0= RULE_STRING ) ) )? otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocol_9_0= ruleBindingProtocol ) )+ otherlv_10= '}' (otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}' )? (otherlv_15= 'assertions' otherlv_16= '{' ( (lv_assertions_17_0= ruleAssertion ) )+ otherlv_18= '}' )? (otherlv_19= 'references-module' ( (lv_referencedModule_20_0= ruleModuleRef ) ) )? ( (lv_operation_21_0= ruleOperationBinding ) )* otherlv_22= '}' ) ;
    public final EObject ruleServiceBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token lv_providedContract_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_22=null;
        EObject lv_service_1_0 = null;

        EObject lv_endpointQualifierRef_3_0 = null;

        EObject lv_governanceDecisions_4_0 = null;

        EObject lv_protocol_9_0 = null;

        EObject lv_policies_13_0 = null;

        EObject lv_assertions_17_0 = null;

        EObject lv_referencedModule_20_0 = null;

        EObject lv_operation_21_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:585:28: ( (otherlv_0= 'bind-service' ( (lv_service_1_0= ruleServiceRef ) ) otherlv_2= '{' ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* (otherlv_5= 'provided-contract' ( (lv_providedContract_6_0= RULE_STRING ) ) )? otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocol_9_0= ruleBindingProtocol ) )+ otherlv_10= '}' (otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}' )? (otherlv_15= 'assertions' otherlv_16= '{' ( (lv_assertions_17_0= ruleAssertion ) )+ otherlv_18= '}' )? (otherlv_19= 'references-module' ( (lv_referencedModule_20_0= ruleModuleRef ) ) )? ( (lv_operation_21_0= ruleOperationBinding ) )* otherlv_22= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:586:1: (otherlv_0= 'bind-service' ( (lv_service_1_0= ruleServiceRef ) ) otherlv_2= '{' ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* (otherlv_5= 'provided-contract' ( (lv_providedContract_6_0= RULE_STRING ) ) )? otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocol_9_0= ruleBindingProtocol ) )+ otherlv_10= '}' (otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}' )? (otherlv_15= 'assertions' otherlv_16= '{' ( (lv_assertions_17_0= ruleAssertion ) )+ otherlv_18= '}' )? (otherlv_19= 'references-module' ( (lv_referencedModule_20_0= ruleModuleRef ) ) )? ( (lv_operation_21_0= ruleOperationBinding ) )* otherlv_22= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:586:1: (otherlv_0= 'bind-service' ( (lv_service_1_0= ruleServiceRef ) ) otherlv_2= '{' ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* (otherlv_5= 'provided-contract' ( (lv_providedContract_6_0= RULE_STRING ) ) )? otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocol_9_0= ruleBindingProtocol ) )+ otherlv_10= '}' (otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}' )? (otherlv_15= 'assertions' otherlv_16= '{' ( (lv_assertions_17_0= ruleAssertion ) )+ otherlv_18= '}' )? (otherlv_19= 'references-module' ( (lv_referencedModule_20_0= ruleModuleRef ) ) )? ( (lv_operation_21_0= ruleOperationBinding ) )* otherlv_22= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:586:3: otherlv_0= 'bind-service' ( (lv_service_1_0= ruleServiceRef ) ) otherlv_2= '{' ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* (otherlv_5= 'provided-contract' ( (lv_providedContract_6_0= RULE_STRING ) ) )? otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocol_9_0= ruleBindingProtocol ) )+ otherlv_10= '}' (otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}' )? (otherlv_15= 'assertions' otherlv_16= '{' ( (lv_assertions_17_0= ruleAssertion ) )+ otherlv_18= '}' )? (otherlv_19= 'references-module' ( (lv_referencedModule_20_0= ruleModuleRef ) ) )? ( (lv_operation_21_0= ruleOperationBinding ) )* otherlv_22= '}'
            {
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleServiceBinding1175); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getServiceBindingAccess().getBindServiceKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:590:1: ( (lv_service_1_0= ruleServiceRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:591:1: (lv_service_1_0= ruleServiceRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:591:1: (lv_service_1_0= ruleServiceRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:592:3: lv_service_1_0= ruleServiceRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getServiceBindingAccess().getServiceServiceRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleServiceBinding1196);
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

            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleServiceBinding1208); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:612:1: ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==98) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:613:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:613:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:614:3: lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleServiceBinding1229);
                    lv_endpointQualifierRef_3_0=ruleEndpointQualifierRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getServiceBindingRule());
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:630:3: ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==108) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:631:1: (lv_governanceDecisions_4_0= ruleGovernanceDecision )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:631:1: (lv_governanceDecisions_4_0= ruleGovernanceDecision )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:632:3: lv_governanceDecisions_4_0= ruleGovernanceDecision
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getGovernanceDecisionsGovernanceDecisionParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleGovernanceDecision_in_ruleServiceBinding1251);
            	    lv_governanceDecisions_4_0=ruleGovernanceDecision();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getServiceBindingRule());
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
            	    break loop16;
                }
            } while (true);

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:648:3: (otherlv_5= 'provided-contract' ( (lv_providedContract_6_0= RULE_STRING ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==25) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:648:5: otherlv_5= 'provided-contract' ( (lv_providedContract_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleServiceBinding1265); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getServiceBindingAccess().getProvidedContractKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:652:1: ( (lv_providedContract_6_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:653:1: (lv_providedContract_6_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:653:1: (lv_providedContract_6_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:654:3: lv_providedContract_6_0= RULE_STRING
                    {
                    lv_providedContract_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleServiceBinding1282); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_providedContract_6_0, grammarAccess.getServiceBindingAccess().getProvidedContractSTRINGTerminalRuleCall_5_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getServiceBindingRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"providedContract",
                              		lv_providedContract_6_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleServiceBinding1301); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getServiceBindingAccess().getProtocolsKeyword_6());
                  
            }
            otherlv_8=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleServiceBinding1313); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_7());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:678:1: ( (lv_protocol_9_0= ruleBindingProtocol ) )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==33||LA18_0==37||LA18_0==40||LA18_0==42||LA18_0==46||LA18_0==51||LA18_0==55||LA18_0==59||LA18_0==61||LA18_0==63||LA18_0==65) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:679:1: (lv_protocol_9_0= ruleBindingProtocol )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:679:1: (lv_protocol_9_0= ruleBindingProtocol )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:680:3: lv_protocol_9_0= ruleBindingProtocol
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getProtocolBindingProtocolParserRuleCall_8_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleServiceBinding1334);
            	    lv_protocol_9_0=ruleBindingProtocol();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getServiceBindingRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"protocol",
            	              		lv_protocol_9_0, 
            	              		"BindingProtocol");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

            otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleServiceBinding1347); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getServiceBindingAccess().getRightCurlyBracketKeyword_9());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:700:1: (otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:700:3: otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleServiceBinding1360); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getServiceBindingAccess().getPoliciesKeyword_10_0());
                          
                    }
                    otherlv_12=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleServiceBinding1372); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_10_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:708:1: ( (lv_policies_13_0= rulePolicy ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=67 && LA19_0<=68)||LA19_0==75||LA19_0==80) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:709:1: (lv_policies_13_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:709:1: (lv_policies_13_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:710:3: lv_policies_13_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getPoliciesPolicyParserRuleCall_10_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleServiceBinding1393);
                    	    lv_policies_13_0=rulePolicy();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getServiceBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"policies",
                    	              		lv_policies_13_0, 
                    	              		"Policy");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleServiceBinding1406); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getServiceBindingAccess().getRightCurlyBracketKeyword_10_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:730:3: (otherlv_15= 'assertions' otherlv_16= '{' ( (lv_assertions_17_0= ruleAssertion ) )+ otherlv_18= '}' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==28) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:730:5: otherlv_15= 'assertions' otherlv_16= '{' ( (lv_assertions_17_0= ruleAssertion ) )+ otherlv_18= '}'
                    {
                    otherlv_15=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleServiceBinding1421); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getServiceBindingAccess().getAssertionsKeyword_11_0());
                          
                    }
                    otherlv_16=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleServiceBinding1433); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_11_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:738:1: ( (lv_assertions_17_0= ruleAssertion ) )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==21) ) {
                            int LA21_1 = input.LA(2);

                            if ( (synpred21_InternalBindingDsl()) ) {
                                alt21=1;
                            }


                        }
                        else if ( (LA21_0==82||LA21_0==86||LA21_0==88||(LA21_0>=90 && LA21_0<=91)||LA21_0==93||LA21_0==95) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:739:1: (lv_assertions_17_0= ruleAssertion )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:739:1: (lv_assertions_17_0= ruleAssertion )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:740:3: lv_assertions_17_0= ruleAssertion
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getAssertionsAssertionParserRuleCall_11_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssertion_in_ruleServiceBinding1454);
                    	    lv_assertions_17_0=ruleAssertion();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getServiceBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"assertions",
                    	              		lv_assertions_17_0, 
                    	              		"Assertion");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt21 >= 1 ) break loop21;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
                    } while (true);

                    otherlv_18=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleServiceBinding1467); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getServiceBindingAccess().getRightCurlyBracketKeyword_11_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:760:3: (otherlv_19= 'references-module' ( (lv_referencedModule_20_0= ruleModuleRef ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==29) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:760:5: otherlv_19= 'references-module' ( (lv_referencedModule_20_0= ruleModuleRef ) )
                    {
                    otherlv_19=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleServiceBinding1482); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getServiceBindingAccess().getReferencesModuleKeyword_12_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:764:1: ( (lv_referencedModule_20_0= ruleModuleRef ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:765:1: (lv_referencedModule_20_0= ruleModuleRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:765:1: (lv_referencedModule_20_0= ruleModuleRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:766:3: lv_referencedModule_20_0= ruleModuleRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getReferencedModuleModuleRefParserRuleCall_12_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleModuleRef_in_ruleServiceBinding1503);
                    lv_referencedModule_20_0=ruleModuleRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getServiceBindingRule());
                      	        }
                             		set(
                             			current, 
                             			"referencedModule",
                              		lv_referencedModule_20_0, 
                              		"ModuleRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:782:4: ( (lv_operation_21_0= ruleOperationBinding ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==30) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:783:1: (lv_operation_21_0= ruleOperationBinding )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:783:1: (lv_operation_21_0= ruleOperationBinding )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:784:3: lv_operation_21_0= ruleOperationBinding
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getOperationOperationBindingParserRuleCall_13_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleOperationBinding_in_ruleServiceBinding1526);
            	    lv_operation_21_0=ruleOperationBinding();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getServiceBindingRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"operation",
            	              		lv_operation_21_0, 
            	              		"OperationBinding");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            otherlv_22=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleServiceBinding1539); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_22, grammarAccess.getServiceBindingAccess().getRightCurlyBracketKeyword_14());
                  
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:812:1: entryRuleServiceRef returns [EObject current=null] : iv_ruleServiceRef= ruleServiceRef EOF ;
    public final EObject entryRuleServiceRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:813:2: (iv_ruleServiceRef= ruleServiceRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:814:2: iv_ruleServiceRef= ruleServiceRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getServiceRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_entryRuleServiceRef1575);
            iv_ruleServiceRef=ruleServiceRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleServiceRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleServiceRef1585); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:821:1: ruleServiceRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) ;
    public final EObject ruleServiceRef() throws RecognitionException {
        EObject current = null;

        EObject lv_versionRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:824:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:825:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:825:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:825:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:825:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:826:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:826:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:827:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleServiceRef1637);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:843:2: ( (lv_versionRef_1_0= ruleVersionRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:844:1: (lv_versionRef_1_0= ruleVersionRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:844:1: (lv_versionRef_1_0= ruleVersionRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:845:3: lv_versionRef_1_0= ruleVersionRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getServiceRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleServiceRef1658);
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


    // $ANTLR start "entryRuleBindingProtocol"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:869:1: entryRuleBindingProtocol returns [EObject current=null] : iv_ruleBindingProtocol= ruleBindingProtocol EOF ;
    public final EObject entryRuleBindingProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBindingProtocol = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:870:2: (iv_ruleBindingProtocol= ruleBindingProtocol EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:871:2: iv_ruleBindingProtocol= ruleBindingProtocol EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBindingProtocolRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_entryRuleBindingProtocol1694);
            iv_ruleBindingProtocol=ruleBindingProtocol();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBindingProtocol; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBindingProtocol1704); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:878:1: ruleBindingProtocol returns [EObject current=null] : (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP | this_IIOP_9= ruleIIOP | this_AMQP_10= ruleAMQP ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:881:28: ( (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP | this_IIOP_9= ruleIIOP | this_AMQP_10= ruleAMQP ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:882:1: (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP | this_IIOP_9= ruleIIOP | this_AMQP_10= ruleAMQP )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:882:1: (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP | this_IIOP_9= ruleIIOP | this_AMQP_10= ruleAMQP )
            int alt25=11;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt25=1;
                }
                break;
            case 33:
                {
                alt25=2;
                }
                break;
            case 40:
                {
                alt25=3;
                }
                break;
            case 42:
                {
                alt25=4;
                }
                break;
            case 46:
                {
                alt25=5;
                }
                break;
            case 37:
                {
                alt25=6;
                }
                break;
            case 51:
                {
                alt25=7;
                }
                break;
            case 59:
                {
                alt25=8;
                }
                break;
            case 61:
                {
                alt25=9;
                }
                break;
            case 63:
                {
                alt25=10;
                }
                break;
            case 65:
                {
                alt25=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:883:2: this_SCA_0= ruleSCA
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getSCAParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSCA_in_ruleBindingProtocol1754);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:896:2: this_SOAP_1= ruleSOAP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getSOAPParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSOAP_in_ruleBindingProtocol1784);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:909:2: this_EJB_2= ruleEJB
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getEJBParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEJB_in_ruleBindingProtocol1814);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:922:2: this_HTTP_3= ruleHTTP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getHTTPParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleHTTP_in_ruleBindingProtocol1844);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:935:2: this_REST_4= ruleREST
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getRESTParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleREST_in_ruleBindingProtocol1874);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:948:2: this_SAP_5= ruleSAP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getSAPParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSAP_in_ruleBindingProtocol1904);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:961:2: this_JMS_6= ruleJMS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getJMSParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleJMS_in_ruleBindingProtocol1934);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:974:2: this_FILE_7= ruleFILE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getFILEParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFILE_in_ruleBindingProtocol1964);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:987:2: this_FTP_8= ruleFTP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getFTPParserRuleCall_8()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFTP_in_ruleBindingProtocol1994);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1000:2: this_IIOP_9= ruleIIOP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getIIOPParserRuleCall_9()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIIOP_in_ruleBindingProtocol2024);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1013:2: this_AMQP_10= ruleAMQP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getAMQPParserRuleCall_10()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAMQP_in_ruleBindingProtocol2054);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1032:1: entryRuleOperationBinding returns [EObject current=null] : iv_ruleOperationBinding= ruleOperationBinding EOF ;
    public final EObject entryRuleOperationBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationBinding = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1033:2: (iv_ruleOperationBinding= ruleOperationBinding EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1034:2: iv_ruleOperationBinding= ruleOperationBinding EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationBindingRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOperationBinding_in_entryRuleOperationBinding2089);
            iv_ruleOperationBinding=ruleOperationBinding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperationBinding; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperationBinding2099); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1041:1: ruleOperationBinding returns [EObject current=null] : (otherlv_0= 'bind-operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* otherlv_5= 'protocols' otherlv_6= '{' ( (lv_protocol_7_0= ruleBindingProtocol ) )+ otherlv_8= '}' (otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )? (otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )? (otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )? otherlv_25= '}' ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1044:28: ( (otherlv_0= 'bind-operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* otherlv_5= 'protocols' otherlv_6= '{' ( (lv_protocol_7_0= ruleBindingProtocol ) )+ otherlv_8= '}' (otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )? (otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )? (otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )? otherlv_25= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1045:1: (otherlv_0= 'bind-operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* otherlv_5= 'protocols' otherlv_6= '{' ( (lv_protocol_7_0= ruleBindingProtocol ) )+ otherlv_8= '}' (otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )? (otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )? (otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )? otherlv_25= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1045:1: (otherlv_0= 'bind-operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* otherlv_5= 'protocols' otherlv_6= '{' ( (lv_protocol_7_0= ruleBindingProtocol ) )+ otherlv_8= '}' (otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )? (otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )? (otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )? otherlv_25= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1045:3: otherlv_0= 'bind-operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* otherlv_5= 'protocols' otherlv_6= '{' ( (lv_protocol_7_0= ruleBindingProtocol ) )+ otherlv_8= '}' (otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )? (otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )? (otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )? otherlv_25= '}'
            {
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleOperationBinding2136); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOperationBindingAccess().getBindOperationKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1049:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1050:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1050:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1051:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleOperationBinding2163);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOperationBinding2175); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1071:1: ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==98) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1072:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1072:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1073:3: lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleOperationBinding2196);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1089:3: ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==108) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1090:1: (lv_governanceDecisions_4_0= ruleGovernanceDecision )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1090:1: (lv_governanceDecisions_4_0= ruleGovernanceDecision )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1091:3: lv_governanceDecisions_4_0= ruleGovernanceDecision
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getGovernanceDecisionsGovernanceDecisionParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleGovernanceDecision_in_ruleOperationBinding2218);
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
            	    break loop27;
                }
            } while (true);

            otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleOperationBinding2231); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getOperationBindingAccess().getProtocolsKeyword_5());
                  
            }
            otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOperationBinding2243); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1115:1: ( (lv_protocol_7_0= ruleBindingProtocol ) )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==33||LA28_0==37||LA28_0==40||LA28_0==42||LA28_0==46||LA28_0==51||LA28_0==55||LA28_0==59||LA28_0==61||LA28_0==63||LA28_0==65) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1116:1: (lv_protocol_7_0= ruleBindingProtocol )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1116:1: (lv_protocol_7_0= ruleBindingProtocol )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1117:3: lv_protocol_7_0= ruleBindingProtocol
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getProtocolBindingProtocolParserRuleCall_7_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleOperationBinding2264);
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
            	    if ( cnt28 >= 1 ) break loop28;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);

            otherlv_8=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleOperationBinding2277); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_8());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1137:1: (otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==31) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1137:3: otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}'
                    {
                    otherlv_9=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleOperationBinding2290); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getOperationBindingAccess().getProviderProtocolsKeyword_9_0());
                          
                    }
                    otherlv_10=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOperationBinding2302); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_9_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1145:1: ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+
                    int cnt29=0;
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==33||LA29_0==37||LA29_0==40||LA29_0==42||LA29_0==46||LA29_0==51||LA29_0==55||LA29_0==59||LA29_0==61||LA29_0==63||LA29_0==65) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1146:1: (lv_providerProtocol_11_0= ruleBindingProtocol )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1146:1: (lv_providerProtocol_11_0= ruleBindingProtocol )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1147:3: lv_providerProtocol_11_0= ruleBindingProtocol
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getProviderProtocolBindingProtocolParserRuleCall_9_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleOperationBinding2323);
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
                    	    if ( cnt29 >= 1 ) break loop29;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(29, input);
                                throw eee;
                        }
                        cnt29++;
                    } while (true);

                    otherlv_12=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleOperationBinding2336); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_9_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1167:3: (otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==27) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1167:5: otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}'
                    {
                    otherlv_13=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleOperationBinding2351); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getOperationBindingAccess().getPoliciesKeyword_10_0());
                          
                    }
                    otherlv_14=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOperationBinding2363); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_10_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1175:1: ( (lv_policies_15_0= rulePolicy ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( ((LA31_0>=67 && LA31_0<=68)||LA31_0==75||LA31_0==80) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1176:1: (lv_policies_15_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1176:1: (lv_policies_15_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1177:3: lv_policies_15_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getPoliciesPolicyParserRuleCall_10_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleOperationBinding2384);
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
                    	    break loop31;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleOperationBinding2397); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_10_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1197:3: (otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==32) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1197:5: otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}'
                    {
                    otherlv_17=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleOperationBinding2412); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getOperationBindingAccess().getProviderPoliciesKeyword_11_0());
                          
                    }
                    otherlv_18=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOperationBinding2424); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_11_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1205:1: ( (lv_providerPolicies_19_0= rulePolicy ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( ((LA33_0>=67 && LA33_0<=68)||LA33_0==75||LA33_0==80) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1206:1: (lv_providerPolicies_19_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1206:1: (lv_providerPolicies_19_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1207:3: lv_providerPolicies_19_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getProviderPoliciesPolicyParserRuleCall_11_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleOperationBinding2445);
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
                    	    break loop33;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleOperationBinding2458); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_11_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1227:3: (otherlv_21= 'assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==28) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1227:5: otherlv_21= 'assertions' otherlv_22= '{' ( (lv_assertions_23_0= ruleAssertion ) )+ otherlv_24= '}'
                    {
                    otherlv_21=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleOperationBinding2473); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_21, grammarAccess.getOperationBindingAccess().getAssertionsKeyword_12_0());
                          
                    }
                    otherlv_22=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOperationBinding2485); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_22, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_12_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1235:1: ( (lv_assertions_23_0= ruleAssertion ) )+
                    int cnt35=0;
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==21) ) {
                            int LA35_1 = input.LA(2);

                            if ( (synpred44_InternalBindingDsl()) ) {
                                alt35=1;
                            }


                        }
                        else if ( (LA35_0==82||LA35_0==86||LA35_0==88||(LA35_0>=90 && LA35_0<=91)||LA35_0==93||LA35_0==95) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1236:1: (lv_assertions_23_0= ruleAssertion )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1236:1: (lv_assertions_23_0= ruleAssertion )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1237:3: lv_assertions_23_0= ruleAssertion
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getAssertionsAssertionParserRuleCall_12_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssertion_in_ruleOperationBinding2506);
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
                    	    if ( cnt35 >= 1 ) break loop35;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(35, input);
                                throw eee;
                        }
                        cnt35++;
                    } while (true);

                    otherlv_24=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleOperationBinding2519); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_24, grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_12_3());
                          
                    }

                    }
                    break;

            }

            otherlv_25=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleOperationBinding2533); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1269:1: entryRuleSOAP returns [EObject current=null] : iv_ruleSOAP= ruleSOAP EOF ;
    public final EObject entryRuleSOAP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSOAP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1270:2: (iv_ruleSOAP= ruleSOAP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1271:2: iv_ruleSOAP= ruleSOAP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSOAPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSOAP_in_entryRuleSOAP2569);
            iv_ruleSOAP=ruleSOAP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSOAP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSOAP2579); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1278:1: ruleSOAP returns [EObject current=null] : (otherlv_0= 'SOAP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )? (otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) ) )? (otherlv_9= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_10_0= RULE_STRING ) ) )? otherlv_11= '}' ) ;
    public final EObject ruleSOAP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_contextRoot_8_0=null;
        Token otherlv_9=null;
        Token lv_providedWsdlUrl_10_0=null;
        Token otherlv_11=null;
        EObject lv_endpointQualifierRef_3_0 = null;

        EObject lv_endpointConnector_4_0 = null;

        Enumerator lv_style_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1281:28: ( (otherlv_0= 'SOAP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )? (otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) ) )? (otherlv_9= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_10_0= RULE_STRING ) ) )? otherlv_11= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1282:1: (otherlv_0= 'SOAP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )? (otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) ) )? (otherlv_9= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_10_0= RULE_STRING ) ) )? otherlv_11= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1282:1: (otherlv_0= 'SOAP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )? (otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) ) )? (otherlv_9= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_10_0= RULE_STRING ) ) )? otherlv_11= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1282:3: otherlv_0= 'SOAP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )? (otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) ) )? (otherlv_9= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_10_0= RULE_STRING ) ) )? otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleSOAP2616); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSOAPAccess().getSOAPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSOAP2628); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSOAPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1290:1: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1291:2: 
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1299:2: ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==98) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1300:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1300:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1301:3: lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSOAPAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleSOAP2661);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1317:3: ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==11) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1318:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1318:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1319:3: lv_endpointConnector_4_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSOAPAccess().getEndpointConnectorConnectorQualifierParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleSOAP2683);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1335:3: (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==34) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1335:5: otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) )
                    {
                    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleSOAP2697); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSOAPAccess().getStyleKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1339:1: ( (lv_style_6_0= ruleSOAPStyle ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1340:1: (lv_style_6_0= ruleSOAPStyle )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1340:1: (lv_style_6_0= ruleSOAPStyle )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1341:3: lv_style_6_0= ruleSOAPStyle
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSOAPAccess().getStyleSOAPStyleEnumRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSOAPStyle_in_ruleSOAP2718);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1357:4: (otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==35) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1357:6: otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleSOAP2733); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getSOAPAccess().getHttpContextRootKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1361:1: ( (lv_contextRoot_8_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1362:1: (lv_contextRoot_8_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1362:1: (lv_contextRoot_8_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1363:3: lv_contextRoot_8_0= RULE_STRING
                    {
                    lv_contextRoot_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSOAP2750); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_contextRoot_8_0, grammarAccess.getSOAPAccess().getContextRootSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSOAPRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"contextRoot",
                              		lv_contextRoot_8_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1379:4: (otherlv_9= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_10_0= RULE_STRING ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==36) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1379:6: otherlv_9= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleSOAP2770); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getSOAPAccess().getProvidedWSDLUrlKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1383:1: ( (lv_providedWsdlUrl_10_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1384:1: (lv_providedWsdlUrl_10_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1384:1: (lv_providedWsdlUrl_10_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1385:3: lv_providedWsdlUrl_10_0= RULE_STRING
                    {
                    lv_providedWsdlUrl_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSOAP2787); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_providedWsdlUrl_10_0, grammarAccess.getSOAPAccess().getProvidedWsdlUrlSTRINGTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSOAPRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"providedWsdlUrl",
                              		lv_providedWsdlUrl_10_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleSOAP2806); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getSOAPAccess().getRightCurlyBracketKeyword_8());
                  
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1413:1: entryRuleSAP returns [EObject current=null] : iv_ruleSAP= ruleSAP EOF ;
    public final EObject entryRuleSAP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1414:2: (iv_ruleSAP= ruleSAP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1415:2: iv_ruleSAP= ruleSAP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSAPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSAP_in_entryRuleSAP2842);
            iv_ruleSAP=ruleSAP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSAP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSAP2852); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1422:1: ruleSAP returns [EObject current=null] : (otherlv_0= 'SAP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) ) )? (otherlv_7= 'client' ( ( ruleQualifiedName ) ) )? otherlv_9= '}' ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1425:28: ( (otherlv_0= 'SAP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) ) )? (otherlv_7= 'client' ( ( ruleQualifiedName ) ) )? otherlv_9= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1426:1: (otherlv_0= 'SAP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) ) )? (otherlv_7= 'client' ( ( ruleQualifiedName ) ) )? otherlv_9= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1426:1: (otherlv_0= 'SAP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) ) )? (otherlv_7= 'client' ( ( ruleQualifiedName ) ) )? otherlv_9= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1426:3: otherlv_0= 'SAP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) ) )? (otherlv_7= 'client' ( ( ruleQualifiedName ) ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleSAP2889); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSAPAccess().getSAPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSAP2901); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSAPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1434:1: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1435:2: 
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1443:2: ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==98) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1444:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1444:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1445:3: lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSAPAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleSAP2934);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1461:3: ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==11) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1462:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1462:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1463:3: lv_endpointConnector_4_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSAPAccess().getEndpointConnectorConnectorQualifierParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleSAP2956);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1479:3: (otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==38) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1479:5: otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) )
                    {
                    otherlv_5=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleSAP2970); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSAPAccess().getTransportKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1483:1: ( (lv_transport_6_0= ruleSAPTransport ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1484:1: (lv_transport_6_0= ruleSAPTransport )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1484:1: (lv_transport_6_0= ruleSAPTransport )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1485:3: lv_transport_6_0= ruleSAPTransport
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSAPAccess().getTransportSAPTransportEnumRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSAPTransport_in_ruleSAP2991);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1501:4: (otherlv_7= 'client' ( ( ruleQualifiedName ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==39) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1501:6: otherlv_7= 'client' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleSAP3006); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getSAPAccess().getClientKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1505:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1506:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1506:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1507:3: ruleQualifiedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSAP3033);
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

            otherlv_9=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleSAP3047); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1535:1: entryRuleEJB returns [EObject current=null] : iv_ruleEJB= ruleEJB EOF ;
    public final EObject entryRuleEJB() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEJB = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1536:2: (iv_ruleEJB= ruleEJB EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1537:2: iv_ruleEJB= ruleEJB EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEJBRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEJB_in_entryRuleEJB3083);
            iv_ruleEJB=ruleEJB();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEJB; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEJB3093); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1544:1: ruleEJB returns [EObject current=null] : (otherlv_0= 'EJB' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) otherlv_6= '}' ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1547:28: ( (otherlv_0= 'EJB' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) otherlv_6= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1548:1: (otherlv_0= 'EJB' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) otherlv_6= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1548:1: (otherlv_0= 'EJB' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) otherlv_6= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1548:3: otherlv_0= 'EJB' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleEJB3130); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEJBAccess().getEJBKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleEJB3142); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEJBAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1556:1: ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==98) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1557:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1557:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1558:3: lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEJBAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleEJB3163);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1574:3: ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==11) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1575:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1575:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1576:3: lv_endpointConnector_3_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEJBAccess().getEndpointConnectorConnectorQualifierParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleEJB3185);
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

            otherlv_4=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleEJB3198); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEJBAccess().getJndiNameKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1596:1: ( (lv_jndiName_5_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1597:1: (lv_jndiName_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1597:1: (lv_jndiName_5_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1598:3: lv_jndiName_5_0= RULE_STRING
            {
            lv_jndiName_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEJB3215); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleEJB3232); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1626:1: entryRuleHTTP returns [EObject current=null] : iv_ruleHTTP= ruleHTTP EOF ;
    public final EObject entryRuleHTTP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1627:2: (iv_ruleHTTP= ruleHTTP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1628:2: iv_ruleHTTP= ruleHTTP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHTTPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleHTTP_in_entryRuleHTTP3268);
            iv_ruleHTTP=ruleHTTP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHTTP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHTTP3278); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1635:1: ruleHTTP returns [EObject current=null] : (otherlv_0= 'HTTP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= '}' ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1638:28: ( (otherlv_0= 'HTTP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1639:1: (otherlv_0= 'HTTP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1639:1: (otherlv_0= 'HTTP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1639:3: otherlv_0= 'HTTP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleHTTP3315); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getHTTPAccess().getHTTPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleHTTP3327); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getHTTPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1647:1: ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==98) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1648:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1648:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1649:3: lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getHTTPAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleHTTP3348);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1665:3: ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==11) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1666:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1666:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1667:3: lv_endpointConnector_3_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getHTTPAccess().getEndpointConnectorConnectorQualifierParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleHTTP3370);
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

            otherlv_4=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleHTTP3383); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getHTTPAccess().getUrlKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1687:1: ( (lv_url_5_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1688:1: (lv_url_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1688:1: (lv_url_5_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1689:3: lv_url_5_0= RULE_STRING
            {
            lv_url_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleHTTP3400); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleHTTP3417); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getHTTPAccess().getProviderUrlKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1709:1: ( (lv_providerUrl_7_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1710:1: (lv_providerUrl_7_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1710:1: (lv_providerUrl_7_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1711:3: lv_providerUrl_7_0= RULE_STRING
            {
            lv_providerUrl_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleHTTP3434); if (state.failed) return current;
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

            otherlv_8=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleHTTP3451); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getHTTPAccess().getVerbKeyword_8());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1731:1: ( (lv_verb_9_0= ruleVerb ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1732:1: (lv_verb_9_0= ruleVerb )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1732:1: (lv_verb_9_0= ruleVerb )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1733:3: lv_verb_9_0= ruleVerb
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getHTTPAccess().getVerbVerbEnumRuleCall_9_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVerb_in_ruleHTTP3472);
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

            otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleHTTP3484); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1761:1: entryRuleREST returns [EObject current=null] : iv_ruleREST= ruleREST EOF ;
    public final EObject entryRuleREST() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleREST = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1762:2: (iv_ruleREST= ruleREST EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1763:2: iv_ruleREST= ruleREST EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRESTRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleREST_in_entryRuleREST3520);
            iv_ruleREST=ruleREST();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleREST; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleREST3530); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1770:1: ruleREST returns [EObject current=null] : (otherlv_0= 'REST' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'path' ( (lv_path_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) (otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) )? (otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) ) )? (otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) ) )? otherlv_16= '}' ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1773:28: ( (otherlv_0= 'REST' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'path' ( (lv_path_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) (otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) )? (otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) ) )? (otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) ) )? otherlv_16= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1774:1: (otherlv_0= 'REST' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'path' ( (lv_path_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) (otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) )? (otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) ) )? (otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) ) )? otherlv_16= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1774:1: (otherlv_0= 'REST' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'path' ( (lv_path_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) (otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) )? (otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) ) )? (otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) ) )? otherlv_16= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1774:3: otherlv_0= 'REST' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'path' ( (lv_path_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) (otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) )? (otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) ) )? (otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) ) )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleREST3567); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRESTAccess().getRESTKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleREST3579); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRESTAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1782:1: ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==98) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1783:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1783:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1784:3: lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRESTAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleREST3600);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1800:3: ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==11) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1801:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1801:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1802:3: lv_endpointConnector_3_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRESTAccess().getEndpointConnectorConnectorQualifierParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleREST3622);
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

            otherlv_4=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleREST3635); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getRESTAccess().getPathKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1822:1: ( (lv_path_5_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1823:1: (lv_path_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1823:1: (lv_path_5_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1824:3: lv_path_5_0= RULE_STRING
            {
            lv_path_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleREST3652); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleREST3669); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getRESTAccess().getProviderUrlKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1844:1: ( (lv_providerUrl_7_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1845:1: (lv_providerUrl_7_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1845:1: (lv_providerUrl_7_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1846:3: lv_providerUrl_7_0= RULE_STRING
            {
            lv_providerUrl_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleREST3686); if (state.failed) return current;
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

            otherlv_8=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleREST3703); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getRESTAccess().getVerbKeyword_8());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1866:1: ( (lv_verb_9_0= ruleVerb ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1867:1: (lv_verb_9_0= ruleVerb )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1867:1: (lv_verb_9_0= ruleVerb )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1868:3: lv_verb_9_0= ruleVerb
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRESTAccess().getVerbVerbEnumRuleCall_9_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVerb_in_ruleREST3724);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1884:2: (otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==48) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1884:4: otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) )
                    {
                    otherlv_10=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleREST3737); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getRESTAccess().getFormatKeyword_10_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1888:1: ( (lv_format_11_0= ruleRESTFormat ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1889:1: (lv_format_11_0= ruleRESTFormat )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1889:1: (lv_format_11_0= ruleRESTFormat )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1890:3: lv_format_11_0= ruleRESTFormat
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRESTAccess().getFormatRESTFormatEnumRuleCall_10_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRESTFormat_in_ruleREST3758);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1906:4: (otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==49) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1906:6: otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) )
                    {
                    otherlv_12=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleREST3773); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getRESTAccess().getConsumesFormatKeyword_11_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1910:1: ( (lv_consumesFormat_13_0= ruleRESTFormat ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1911:1: (lv_consumesFormat_13_0= ruleRESTFormat )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1911:1: (lv_consumesFormat_13_0= ruleRESTFormat )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1912:3: lv_consumesFormat_13_0= ruleRESTFormat
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRESTAccess().getConsumesFormatRESTFormatEnumRuleCall_11_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRESTFormat_in_ruleREST3794);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1928:4: (otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==50) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1928:6: otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) )
                    {
                    otherlv_14=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleREST3809); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getRESTAccess().getProvidesFormatKeyword_12_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1932:1: ( (lv_provideFormat_15_0= ruleRESTFormat ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1933:1: (lv_provideFormat_15_0= ruleRESTFormat )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1933:1: (lv_provideFormat_15_0= ruleRESTFormat )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1934:3: lv_provideFormat_15_0= ruleRESTFormat
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRESTAccess().getProvideFormatRESTFormatEnumRuleCall_12_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRESTFormat_in_ruleREST3830);
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

            otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleREST3844); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1962:1: entryRuleJMS returns [EObject current=null] : iv_ruleJMS= ruleJMS EOF ;
    public final EObject entryRuleJMS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJMS = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1963:2: (iv_ruleJMS= ruleJMS EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1964:2: iv_ruleJMS= ruleJMS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJMSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleJMS_in_entryRuleJMS3880);
            iv_ruleJMS=ruleJMS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJMS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleJMS3890); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1971:1: ruleJMS returns [EObject current=null] : (otherlv_0= 'JMS' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1974:28: ( (otherlv_0= 'JMS' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1975:1: (otherlv_0= 'JMS' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1975:1: (otherlv_0= 'JMS' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1975:3: otherlv_0= 'JMS' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleJMS3927); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJMSAccess().getJMSKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleJMS3939); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJMSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1983:1: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1984:2: 
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1992:2: ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==98) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1993:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1993:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1994:3: lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJMSAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleJMS3972);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2010:3: ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==11) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2011:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2011:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2012:3: lv_endpointConnector_4_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJMSAccess().getEndpointConnectorConnectorQualifierParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleJMS3994);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2028:3: ( (lv_channel_5_0= ruleTopicOrQueue ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( ((LA57_0>=53 && LA57_0<=54)) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2029:1: (lv_channel_5_0= ruleTopicOrQueue )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2029:1: (lv_channel_5_0= ruleTopicOrQueue )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2030:3: lv_channel_5_0= ruleTopicOrQueue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJMSAccess().getChannelTopicOrQueueParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTopicOrQueue_in_ruleJMS4016);
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

            otherlv_6=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleJMS4029); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getJMSAccess().getJndiNameKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2050:1: ( (lv_jndiName_7_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2051:1: (lv_jndiName_7_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2051:1: (lv_jndiName_7_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2052:3: lv_jndiName_7_0= RULE_STRING
            {
            lv_jndiName_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleJMS4046); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2068:2: (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==52) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2068:4: otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleJMS4064); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getJMSAccess().getProviderJndiNameKeyword_8_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2072:1: ( (lv_providerJndi_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2073:1: (lv_providerJndi_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2073:1: (lv_providerJndi_9_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2074:3: lv_providerJndi_9_0= RULE_STRING
                    {
                    lv_providerJndi_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleJMS4081); if (state.failed) return current;
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

            otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleJMS4100); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2102:1: entryRuleTopicOrQueue returns [EObject current=null] : iv_ruleTopicOrQueue= ruleTopicOrQueue EOF ;
    public final EObject entryRuleTopicOrQueue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopicOrQueue = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2103:2: (iv_ruleTopicOrQueue= ruleTopicOrQueue EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2104:2: iv_ruleTopicOrQueue= ruleTopicOrQueue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTopicOrQueueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTopicOrQueue_in_entryRuleTopicOrQueue4136);
            iv_ruleTopicOrQueue=ruleTopicOrQueue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTopicOrQueue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTopicOrQueue4146); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2111:1: ruleTopicOrQueue returns [EObject current=null] : (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue ) ;
    public final EObject ruleTopicOrQueue() throws RecognitionException {
        EObject current = null;

        EObject this_Topic_0 = null;

        EObject this_Queue_1 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2114:28: ( (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2115:1: (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2115:1: (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==53) ) {
                alt59=1;
            }
            else if ( (LA59_0==54) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2116:2: this_Topic_0= ruleTopic
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTopicOrQueueAccess().getTopicParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTopic_in_ruleTopicOrQueue4196);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2129:2: this_Queue_1= ruleQueue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTopicOrQueueAccess().getQueueParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQueue_in_ruleTopicOrQueue4226);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2148:1: entryRuleTopic returns [EObject current=null] : iv_ruleTopic= ruleTopic EOF ;
    public final EObject entryRuleTopic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopic = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2149:2: (iv_ruleTopic= ruleTopic EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2150:2: iv_ruleTopic= ruleTopic EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTopicRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTopic_in_entryRuleTopic4261);
            iv_ruleTopic=ruleTopic();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTopic; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTopic4271); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2157:1: ruleTopic returns [EObject current=null] : (otherlv_0= 'topic' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )? ) ;
    public final EObject ruleTopic() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_endpointQualifierRefs_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2160:28: ( (otherlv_0= 'topic' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2161:1: (otherlv_0= 'topic' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2161:1: (otherlv_0= 'topic' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2161:3: otherlv_0= 'topic' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )?
            {
            otherlv_0=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleTopic4308); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTopicAccess().getTopicKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2165:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2166:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2166:1: (lv_name_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2167:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleTopic4325); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2183:2: ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==98) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2184:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2184:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2185:3: lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTopicAccess().getEndpointQualifierRefsEndpointQualifierRefParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleTopic4351);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2209:1: entryRuleQueue returns [EObject current=null] : iv_ruleQueue= ruleQueue EOF ;
    public final EObject entryRuleQueue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueue = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2210:2: (iv_ruleQueue= ruleQueue EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2211:2: iv_ruleQueue= ruleQueue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQueueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQueue_in_entryRuleQueue4388);
            iv_ruleQueue=ruleQueue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQueue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQueue4398); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2218:1: ruleQueue returns [EObject current=null] : (otherlv_0= 'queue' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )? ) ;
    public final EObject ruleQueue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_endpointQualifierRefs_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2221:28: ( (otherlv_0= 'queue' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2222:1: (otherlv_0= 'queue' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2222:1: (otherlv_0= 'queue' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2222:3: otherlv_0= 'queue' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )?
            {
            otherlv_0=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleQueue4435); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getQueueAccess().getQueueKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2226:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2227:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2227:1: (lv_name_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2228:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleQueue4452); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2244:2: ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==98) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2245:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2245:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2246:3: lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQueueAccess().getEndpointQualifierRefsEndpointQualifierRefParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleQueue4478);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2270:1: entryRuleSCA returns [EObject current=null] : iv_ruleSCA= ruleSCA EOF ;
    public final EObject entryRuleSCA() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSCA = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2271:2: (iv_ruleSCA= ruleSCA EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2272:2: iv_ruleSCA= ruleSCA EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSCARule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSCA_in_entryRuleSCA4515);
            iv_ruleSCA=ruleSCA();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSCA; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSCA4525); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2279:1: ruleSCA returns [EObject current=null] : ( () otherlv_1= 'SCA' ( (lv_name_2_0= RULE_STRING ) )? otherlv_3= '{' ( (lv_endpointQualifierRef_4_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_5_0= ruleConnectorQualifier ) )? (otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) ) )? (otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? )? otherlv_11= '}' ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2282:28: ( ( () otherlv_1= 'SCA' ( (lv_name_2_0= RULE_STRING ) )? otherlv_3= '{' ( (lv_endpointQualifierRef_4_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_5_0= ruleConnectorQualifier ) )? (otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) ) )? (otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? )? otherlv_11= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2283:1: ( () otherlv_1= 'SCA' ( (lv_name_2_0= RULE_STRING ) )? otherlv_3= '{' ( (lv_endpointQualifierRef_4_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_5_0= ruleConnectorQualifier ) )? (otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) ) )? (otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? )? otherlv_11= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2283:1: ( () otherlv_1= 'SCA' ( (lv_name_2_0= RULE_STRING ) )? otherlv_3= '{' ( (lv_endpointQualifierRef_4_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_5_0= ruleConnectorQualifier ) )? (otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) ) )? (otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? )? otherlv_11= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2283:2: () otherlv_1= 'SCA' ( (lv_name_2_0= RULE_STRING ) )? otherlv_3= '{' ( (lv_endpointQualifierRef_4_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_5_0= ruleConnectorQualifier ) )? (otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) ) )? (otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? )? otherlv_11= '}'
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2283:2: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2284:2: 
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

            otherlv_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleSCA4574); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSCAAccess().getSCAKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2296:1: ( (lv_name_2_0= RULE_STRING ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==RULE_STRING) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2297:1: (lv_name_2_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2297:1: (lv_name_2_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2298:3: lv_name_2_0= RULE_STRING
                    {
                    lv_name_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSCA4591); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSCA4609); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getSCAAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2318:1: ( (lv_endpointQualifierRef_4_0= ruleEndpointQualifierRef ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==98) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2319:1: (lv_endpointQualifierRef_4_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2319:1: (lv_endpointQualifierRef_4_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2320:3: lv_endpointQualifierRef_4_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSCAAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleSCA4630);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2336:3: ( (lv_endpointConnector_5_0= ruleConnectorQualifier ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==11) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2337:1: (lv_endpointConnector_5_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2337:1: (lv_endpointConnector_5_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2338:3: lv_endpointConnector_5_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSCAAccess().getEndpointConnectorConnectorQualifierParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleSCA4652);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2354:3: (otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==56) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2354:5: otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleSCA4666); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getSCAAccess().getPromoteKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2358:1: ( (lv_promote_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2359:1: (lv_promote_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2359:1: (lv_promote_7_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2360:3: lv_promote_7_0= RULE_STRING
                    {
                    lv_promote_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSCA4683); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2376:4: (otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==57) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2376:6: otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )?
                    {
                    otherlv_8=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleSCA4703); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getSCAAccess().getReferenceKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2380:1: ( (lv_reference_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2381:1: (lv_reference_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2381:1: (lv_reference_9_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2382:3: lv_reference_9_0= RULE_STRING
                    {
                    lv_reference_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSCA4720); if (state.failed) return current;
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

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2398:2: ( (lv_isMultipleRef_10_0= '[]' ) )?
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==58) ) {
                        alt66=1;
                    }
                    switch (alt66) {
                        case 1 :
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2399:1: (lv_isMultipleRef_10_0= '[]' )
                            {
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2399:1: (lv_isMultipleRef_10_0= '[]' )
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2400:3: lv_isMultipleRef_10_0= '[]'
                            {
                            lv_isMultipleRef_10_0=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleSCA4743); if (state.failed) return current;
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

            otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleSCA4771); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2425:1: entryRuleFILE returns [EObject current=null] : iv_ruleFILE= ruleFILE EOF ;
    public final EObject entryRuleFILE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFILE = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2426:2: (iv_ruleFILE= ruleFILE EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2427:2: iv_ruleFILE= ruleFILE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFILERule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFILE_in_entryRuleFILE4807);
            iv_ruleFILE=ruleFILE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFILE; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFILE4817); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2434:1: ruleFILE returns [EObject current=null] : (otherlv_0= 'FILE' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? ( (lv_url_4_0= RULE_STRING ) ) ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2437:28: ( (otherlv_0= 'FILE' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? ( (lv_url_4_0= RULE_STRING ) ) ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2438:1: (otherlv_0= 'FILE' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? ( (lv_url_4_0= RULE_STRING ) ) ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2438:1: (otherlv_0= 'FILE' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? ( (lv_url_4_0= RULE_STRING ) ) ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2438:3: otherlv_0= 'FILE' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? ( (lv_url_4_0= RULE_STRING ) ) ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleFILE4854); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFILEAccess().getFILEKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleFILE4866); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFILEAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2446:1: ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==98) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2447:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2447:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2448:3: lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFILEAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleFILE4887);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2464:3: ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==11) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2465:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2465:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2466:3: lv_endpointConnector_3_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFILEAccess().getEndpointConnectorConnectorQualifierParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleFILE4909);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2482:3: ( (lv_url_4_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2483:1: (lv_url_4_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2483:1: (lv_url_4_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2484:3: lv_url_4_0= RULE_STRING
            {
            lv_url_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFILE4927); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2500:2: ( (lv_accessType_5_0= ruleReadWrite ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2501:1: (lv_accessType_5_0= ruleReadWrite )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2501:1: (lv_accessType_5_0= ruleReadWrite )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2502:3: lv_accessType_5_0= ruleReadWrite
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFILEAccess().getAccessTypeReadWriteEnumRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleReadWrite_in_ruleFILE4953);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2518:2: (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==60) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2518:4: otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleFILE4966); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getFILEAccess().getIntervalKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2522:1: ( (lv_pollIntervall_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2523:1: (lv_pollIntervall_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2523:1: (lv_pollIntervall_7_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2524:3: lv_pollIntervall_7_0= RULE_STRING
                    {
                    lv_pollIntervall_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFILE4983); if (state.failed) return current;
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

            otherlv_8=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleFILE5002); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2552:1: entryRuleFTP returns [EObject current=null] : iv_ruleFTP= ruleFTP EOF ;
    public final EObject entryRuleFTP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFTP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2553:2: (iv_ruleFTP= ruleFTP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2554:2: iv_ruleFTP= ruleFTP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFTPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFTP_in_entryRuleFTP5038);
            iv_ruleFTP=ruleFTP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFTP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFTP5048); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2561:1: ruleFTP returns [EObject current=null] : (otherlv_0= 'FTP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'access' ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2564:28: ( (otherlv_0= 'FTP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'access' ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2565:1: (otherlv_0= 'FTP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'access' ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2565:1: (otherlv_0= 'FTP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'access' ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2565:3: otherlv_0= 'FTP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'access' ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleFTP5085); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFTPAccess().getFTPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleFTP5097); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFTPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2573:1: ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==98) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2574:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2574:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2575:3: lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFTPAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleFTP5118);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2591:3: ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==11) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2592:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2592:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2593:3: lv_endpointConnector_3_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFTPAccess().getEndpointConnectorConnectorQualifierParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleFTP5140);
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

            otherlv_4=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleFTP5153); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getFTPAccess().getAccessKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2613:1: ( (lv_accessType_5_0= ruleReadWrite ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2614:1: (lv_accessType_5_0= ruleReadWrite )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2614:1: (lv_accessType_5_0= ruleReadWrite )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2615:3: lv_accessType_5_0= ruleReadWrite
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFTPAccess().getAccessTypeReadWriteEnumRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleReadWrite_in_ruleFTP5174);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2631:2: (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==60) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2631:4: otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleFTP5187); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getFTPAccess().getIntervalKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2635:1: ( (lv_pollIntervall_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2636:1: (lv_pollIntervall_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2636:1: (lv_pollIntervall_7_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2637:3: lv_pollIntervall_7_0= RULE_STRING
                    {
                    lv_pollIntervall_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFTP5204); if (state.failed) return current;
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

            otherlv_8=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleFTP5223); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2665:1: entryRuleIIOP returns [EObject current=null] : iv_ruleIIOP= ruleIIOP EOF ;
    public final EObject entryRuleIIOP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIIOP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2666:2: (iv_ruleIIOP= ruleIIOP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2667:2: iv_ruleIIOP= ruleIIOP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIIOPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIIOP_in_entryRuleIIOP5259);
            iv_ruleIIOP=ruleIIOP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIIOP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIIOP5269); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2674:1: ruleIIOP returns [EObject current=null] : (otherlv_0= 'IIOP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'lookup-name' ( (lv_lookupName_5_0= RULE_STRING ) ) otherlv_6= '}' ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2677:28: ( (otherlv_0= 'IIOP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'lookup-name' ( (lv_lookupName_5_0= RULE_STRING ) ) otherlv_6= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2678:1: (otherlv_0= 'IIOP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'lookup-name' ( (lv_lookupName_5_0= RULE_STRING ) ) otherlv_6= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2678:1: (otherlv_0= 'IIOP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'lookup-name' ( (lv_lookupName_5_0= RULE_STRING ) ) otherlv_6= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2678:3: otherlv_0= 'IIOP' otherlv_1= '{' ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'lookup-name' ( (lv_lookupName_5_0= RULE_STRING ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleIIOP5306); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIIOPAccess().getIIOPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleIIOP5318); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getIIOPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2686:1: ( (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==98) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2687:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2687:1: (lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2688:3: lv_endpointQualifierRef_2_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIIOPAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleIIOP5339);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2704:3: ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==11) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2705:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2705:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2706:3: lv_endpointConnector_3_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIIOPAccess().getEndpointConnectorConnectorQualifierParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleIIOP5361);
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

            otherlv_4=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleIIOP5374); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getIIOPAccess().getLookupNameKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2726:1: ( (lv_lookupName_5_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2727:1: (lv_lookupName_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2727:1: (lv_lookupName_5_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2728:3: lv_lookupName_5_0= RULE_STRING
            {
            lv_lookupName_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleIIOP5391); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleIIOP5408); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2756:1: entryRuleAMQP returns [EObject current=null] : iv_ruleAMQP= ruleAMQP EOF ;
    public final EObject entryRuleAMQP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAMQP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2757:2: (iv_ruleAMQP= ruleAMQP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2758:2: iv_ruleAMQP= ruleAMQP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAMQPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAMQP_in_entryRuleAMQP5444);
            iv_ruleAMQP=ruleAMQP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAMQP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAMQP5454); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2765:1: ruleAMQP returns [EObject current=null] : (otherlv_0= 'AMQP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'lookup-name' ( (lv_lookupName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2768:28: ( (otherlv_0= 'AMQP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'lookup-name' ( (lv_lookupName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2769:1: (otherlv_0= 'AMQP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'lookup-name' ( (lv_lookupName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2769:1: (otherlv_0= 'AMQP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'lookup-name' ( (lv_lookupName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2769:3: otherlv_0= 'AMQP' otherlv_1= '{' () ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'lookup-name' ( (lv_lookupName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) ) )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleAMQP5491); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAMQPAccess().getAMQPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAMQP5503); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAMQPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2777:1: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2778:2: 
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2786:2: ( (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==98) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2787:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2787:1: (lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2788:3: lv_endpointQualifierRef_3_0= ruleEndpointQualifierRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAMQPAccess().getEndpointQualifierRefEndpointQualifierRefParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_ruleAMQP5536);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2804:3: ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==11) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2805:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2805:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2806:3: lv_endpointConnector_4_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAMQPAccess().getEndpointConnectorConnectorQualifierParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleAMQP5558);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2822:3: ( (lv_channel_5_0= ruleTopicOrQueue ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( ((LA78_0>=53 && LA78_0<=54)) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2823:1: (lv_channel_5_0= ruleTopicOrQueue )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2823:1: (lv_channel_5_0= ruleTopicOrQueue )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2824:3: lv_channel_5_0= ruleTopicOrQueue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAMQPAccess().getChannelTopicOrQueueParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTopicOrQueue_in_ruleAMQP5580);
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

            otherlv_6=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleAMQP5593); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getAMQPAccess().getLookupNameKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2844:1: ( (lv_lookupName_7_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2845:1: (lv_lookupName_7_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2845:1: (lv_lookupName_7_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2846:3: lv_lookupName_7_0= RULE_STRING
            {
            lv_lookupName_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAMQP5610); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2862:2: (otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==66) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2862:4: otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleAMQP5628); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getAMQPAccess().getProviderLookupNameKeyword_8_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2866:1: ( (lv_providerLookupName_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2867:1: (lv_providerLookupName_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2867:1: (lv_providerLookupName_9_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2868:3: lv_providerLookupName_9_0= RULE_STRING
                    {
                    lv_providerLookupName_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAMQP5645); if (state.failed) return current;
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

            otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAMQP5664); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2896:1: entryRulePolicy returns [EObject current=null] : iv_rulePolicy= rulePolicy EOF ;
    public final EObject entryRulePolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2897:2: (iv_rulePolicy= rulePolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2898:2: iv_rulePolicy= rulePolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePolicy_in_entryRulePolicy5700);
            iv_rulePolicy=rulePolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePolicy5710); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2905:1: rulePolicy returns [EObject current=null] : (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy ) ;
    public final EObject rulePolicy() throws RecognitionException {
        EObject current = null;

        EObject this_LogPolicy_0 = null;

        EObject this_SecurityPolicy_1 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2908:28: ( (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2909:1: (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2909:1: (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==67) ) {
                alt80=1;
            }
            else if ( (LA80_0==68||LA80_0==75||LA80_0==80) ) {
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2910:2: this_LogPolicy_0= ruleLogPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPolicyAccess().getLogPolicyParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLogPolicy_in_rulePolicy5760);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2923:2: this_SecurityPolicy_1= ruleSecurityPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPolicyAccess().getSecurityPolicyParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSecurityPolicy_in_rulePolicy5790);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2942:1: entryRuleLogPolicy returns [EObject current=null] : iv_ruleLogPolicy= ruleLogPolicy EOF ;
    public final EObject entryRuleLogPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2943:2: (iv_ruleLogPolicy= ruleLogPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2944:2: iv_ruleLogPolicy= ruleLogPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLogPolicy_in_entryRuleLogPolicy5825);
            iv_ruleLogPolicy=ruleLogPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLogPolicy5835); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2951:1: ruleLogPolicy returns [EObject current=null] : (otherlv_0= 'logging-policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) ) ;
    public final EObject ruleLogPolicy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_logPolicy_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2954:28: ( (otherlv_0= 'logging-policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2955:1: (otherlv_0= 'logging-policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2955:1: (otherlv_0= 'logging-policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2955:3: otherlv_0= 'logging-policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) )
            {
            otherlv_0=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleLogPolicy5872); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLogPolicyAccess().getLoggingPolicyKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2959:1: ( (lv_logPolicy_1_0= ruleLogPolicyKind ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2960:1: (lv_logPolicy_1_0= ruleLogPolicyKind )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2960:1: (lv_logPolicy_1_0= ruleLogPolicyKind )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2961:3: lv_logPolicy_1_0= ruleLogPolicyKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogPolicyAccess().getLogPolicyLogPolicyKindEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLogPolicyKind_in_ruleLogPolicy5893);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2985:1: entryRuleSecurityPolicy returns [EObject current=null] : iv_ruleSecurityPolicy= ruleSecurityPolicy EOF ;
    public final EObject entryRuleSecurityPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecurityPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2986:2: (iv_ruleSecurityPolicy= ruleSecurityPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2987:2: iv_ruleSecurityPolicy= ruleSecurityPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSecurityPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSecurityPolicy_in_entryRuleSecurityPolicy5929);
            iv_ruleSecurityPolicy=ruleSecurityPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSecurityPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecurityPolicy5939); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2994:1: ruleSecurityPolicy returns [EObject current=null] : (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | this_SigningPolicy_1= ruleSigningPolicy | this_EncryptionPolicy_2= ruleEncryptionPolicy ) ;
    public final EObject ruleSecurityPolicy() throws RecognitionException {
        EObject current = null;

        EObject this_AuthenticationPolicy_0 = null;

        EObject this_SigningPolicy_1 = null;

        EObject this_EncryptionPolicy_2 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2997:28: ( (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | this_SigningPolicy_1= ruleSigningPolicy | this_EncryptionPolicy_2= ruleEncryptionPolicy ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2998:1: (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | this_SigningPolicy_1= ruleSigningPolicy | this_EncryptionPolicy_2= ruleEncryptionPolicy )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2998:1: (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | this_SigningPolicy_1= ruleSigningPolicy | this_EncryptionPolicy_2= ruleEncryptionPolicy )
            int alt81=3;
            switch ( input.LA(1) ) {
            case 68:
                {
                alt81=1;
                }
                break;
            case 75:
                {
                alt81=2;
                }
                break;
            case 80:
                {
                alt81=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }

            switch (alt81) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2999:2: this_AuthenticationPolicy_0= ruleAuthenticationPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityPolicyAccess().getAuthenticationPolicyParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAuthenticationPolicy_in_ruleSecurityPolicy5989);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3012:2: this_SigningPolicy_1= ruleSigningPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityPolicyAccess().getSigningPolicyParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSigningPolicy_in_ruleSecurityPolicy6019);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3025:2: this_EncryptionPolicy_2= ruleEncryptionPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityPolicyAccess().getEncryptionPolicyParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEncryptionPolicy_in_ruleSecurityPolicy6049);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3044:1: entryRuleAuthenticationPolicy returns [EObject current=null] : iv_ruleAuthenticationPolicy= ruleAuthenticationPolicy EOF ;
    public final EObject entryRuleAuthenticationPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthenticationPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3045:2: (iv_ruleAuthenticationPolicy= ruleAuthenticationPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3046:2: iv_ruleAuthenticationPolicy= ruleAuthenticationPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAuthenticationPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthenticationPolicy_in_entryRuleAuthenticationPolicy6084);
            iv_ruleAuthenticationPolicy=ruleAuthenticationPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAuthenticationPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAuthenticationPolicy6094); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3053:1: ruleAuthenticationPolicy returns [EObject current=null] : ( () otherlv_1= 'authn-policy' ( (lv_name_2_0= RULE_ID ) )? ( (lv_optional_3_0= 'optional' ) )? otherlv_4= '{' otherlv_5= 'auth-tokens' otherlv_6= '{' ( (lv_authTokens_7_0= ruleAuthToken ) )+ otherlv_8= '}' otherlv_9= 'hash-algorithms' otherlv_10= '{' ( (lv_hashAlgorithms_11_0= ruleHashAlgorithm ) )* otherlv_12= '}' ( (lv_useNonce_13_0= 'use-nonce' ) )? (otherlv_14= 'issuer' ( (lv_issuer_15_0= RULE_STRING ) ) )? otherlv_16= '}' ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3056:28: ( ( () otherlv_1= 'authn-policy' ( (lv_name_2_0= RULE_ID ) )? ( (lv_optional_3_0= 'optional' ) )? otherlv_4= '{' otherlv_5= 'auth-tokens' otherlv_6= '{' ( (lv_authTokens_7_0= ruleAuthToken ) )+ otherlv_8= '}' otherlv_9= 'hash-algorithms' otherlv_10= '{' ( (lv_hashAlgorithms_11_0= ruleHashAlgorithm ) )* otherlv_12= '}' ( (lv_useNonce_13_0= 'use-nonce' ) )? (otherlv_14= 'issuer' ( (lv_issuer_15_0= RULE_STRING ) ) )? otherlv_16= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3057:1: ( () otherlv_1= 'authn-policy' ( (lv_name_2_0= RULE_ID ) )? ( (lv_optional_3_0= 'optional' ) )? otherlv_4= '{' otherlv_5= 'auth-tokens' otherlv_6= '{' ( (lv_authTokens_7_0= ruleAuthToken ) )+ otherlv_8= '}' otherlv_9= 'hash-algorithms' otherlv_10= '{' ( (lv_hashAlgorithms_11_0= ruleHashAlgorithm ) )* otherlv_12= '}' ( (lv_useNonce_13_0= 'use-nonce' ) )? (otherlv_14= 'issuer' ( (lv_issuer_15_0= RULE_STRING ) ) )? otherlv_16= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3057:1: ( () otherlv_1= 'authn-policy' ( (lv_name_2_0= RULE_ID ) )? ( (lv_optional_3_0= 'optional' ) )? otherlv_4= '{' otherlv_5= 'auth-tokens' otherlv_6= '{' ( (lv_authTokens_7_0= ruleAuthToken ) )+ otherlv_8= '}' otherlv_9= 'hash-algorithms' otherlv_10= '{' ( (lv_hashAlgorithms_11_0= ruleHashAlgorithm ) )* otherlv_12= '}' ( (lv_useNonce_13_0= 'use-nonce' ) )? (otherlv_14= 'issuer' ( (lv_issuer_15_0= RULE_STRING ) ) )? otherlv_16= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3057:2: () otherlv_1= 'authn-policy' ( (lv_name_2_0= RULE_ID ) )? ( (lv_optional_3_0= 'optional' ) )? otherlv_4= '{' otherlv_5= 'auth-tokens' otherlv_6= '{' ( (lv_authTokens_7_0= ruleAuthToken ) )+ otherlv_8= '}' otherlv_9= 'hash-algorithms' otherlv_10= '{' ( (lv_hashAlgorithms_11_0= ruleHashAlgorithm ) )* otherlv_12= '}' ( (lv_useNonce_13_0= 'use-nonce' ) )? (otherlv_14= 'issuer' ( (lv_issuer_15_0= RULE_STRING ) ) )? otherlv_16= '}'
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3057:2: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3058:2: 
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

            otherlv_1=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleAuthenticationPolicy6143); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAuthenticationPolicyAccess().getAuthnPolicyKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3070:1: ( (lv_name_2_0= RULE_ID ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==RULE_ID) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3071:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3071:1: (lv_name_2_0= RULE_ID )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3072:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAuthenticationPolicy6160); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3088:3: ( (lv_optional_3_0= 'optional' ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==69) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3089:1: (lv_optional_3_0= 'optional' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3089:1: (lv_optional_3_0= 'optional' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3090:3: lv_optional_3_0= 'optional'
                    {
                    lv_optional_3_0=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleAuthenticationPolicy6184); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAuthenticationPolicy6210); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getAuthenticationPolicyAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleAuthenticationPolicy6222); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getAuthenticationPolicyAccess().getAuthTokensKeyword_5());
                  
            }
            otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAuthenticationPolicy6234); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getAuthenticationPolicyAccess().getLeftCurlyBracketKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3115:1: ( (lv_authTokens_7_0= ruleAuthToken ) )+
            int cnt84=0;
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==69||(LA84_0>=153 && LA84_0<=161)) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3116:1: (lv_authTokens_7_0= ruleAuthToken )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3116:1: (lv_authTokens_7_0= ruleAuthToken )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3117:3: lv_authTokens_7_0= ruleAuthToken
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAuthenticationPolicyAccess().getAuthTokensAuthTokenParserRuleCall_7_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAuthToken_in_ruleAuthenticationPolicy6255);
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
            	    if ( cnt84 >= 1 ) break loop84;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(84, input);
                        throw eee;
                }
                cnt84++;
            } while (true);

            otherlv_8=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAuthenticationPolicy6268); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getAuthenticationPolicyAccess().getRightCurlyBracketKeyword_8());
                  
            }
            otherlv_9=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleAuthenticationPolicy6280); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getAuthenticationPolicyAccess().getHashAlgorithmsKeyword_9());
                  
            }
            otherlv_10=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAuthenticationPolicy6292); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getAuthenticationPolicyAccess().getLeftCurlyBracketKeyword_10());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3145:1: ( (lv_hashAlgorithms_11_0= ruleHashAlgorithm ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==69||LA85_0==74||(LA85_0>=134 && LA85_0<=138)) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3146:1: (lv_hashAlgorithms_11_0= ruleHashAlgorithm )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3146:1: (lv_hashAlgorithms_11_0= ruleHashAlgorithm )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3147:3: lv_hashAlgorithms_11_0= ruleHashAlgorithm
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAuthenticationPolicyAccess().getHashAlgorithmsHashAlgorithmParserRuleCall_11_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleHashAlgorithm_in_ruleAuthenticationPolicy6313);
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
            	    break loop85;
                }
            } while (true);

            otherlv_12=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAuthenticationPolicy6326); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getAuthenticationPolicyAccess().getRightCurlyBracketKeyword_12());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3167:1: ( (lv_useNonce_13_0= 'use-nonce' ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==72) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3168:1: (lv_useNonce_13_0= 'use-nonce' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3168:1: (lv_useNonce_13_0= 'use-nonce' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3169:3: lv_useNonce_13_0= 'use-nonce'
                    {
                    lv_useNonce_13_0=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleAuthenticationPolicy6344); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3182:3: (otherlv_14= 'issuer' ( (lv_issuer_15_0= RULE_STRING ) ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==73) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3182:5: otherlv_14= 'issuer' ( (lv_issuer_15_0= RULE_STRING ) )
                    {
                    otherlv_14=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleAuthenticationPolicy6371); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getAuthenticationPolicyAccess().getIssuerKeyword_14_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3186:1: ( (lv_issuer_15_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3187:1: (lv_issuer_15_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3187:1: (lv_issuer_15_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3188:3: lv_issuer_15_0= RULE_STRING
                    {
                    lv_issuer_15_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAuthenticationPolicy6388); if (state.failed) return current;
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

            otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAuthenticationPolicy6407); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3216:1: entryRuleAuthToken returns [EObject current=null] : iv_ruleAuthToken= ruleAuthToken EOF ;
    public final EObject entryRuleAuthToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthToken = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3217:2: (iv_ruleAuthToken= ruleAuthToken EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3218:2: iv_ruleAuthToken= ruleAuthToken EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAuthTokenRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthToken_in_entryRuleAuthToken6443);
            iv_ruleAuthToken=ruleAuthToken();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAuthToken; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAuthToken6453); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3225:1: ruleAuthToken returns [EObject current=null] : ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) ) ;
    public final EObject ruleAuthToken() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Enumerator lv_kind_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3228:28: ( ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3229:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3229:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3229:2: ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3229:2: ( (lv_optional_0_0= 'optional' ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==69) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3230:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3230:1: (lv_optional_0_0= 'optional' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3231:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleAuthToken6496); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3244:3: ( (lv_kind_1_0= ruleAuthTokenKind ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3245:1: (lv_kind_1_0= ruleAuthTokenKind )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3245:1: (lv_kind_1_0= ruleAuthTokenKind )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3246:3: lv_kind_1_0= ruleAuthTokenKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAuthTokenAccess().getKindAuthTokenKindEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthTokenKind_in_ruleAuthToken6531);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3270:1: entryRuleHashAlgorithm returns [EObject current=null] : iv_ruleHashAlgorithm= ruleHashAlgorithm EOF ;
    public final EObject entryRuleHashAlgorithm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHashAlgorithm = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3271:2: (iv_ruleHashAlgorithm= ruleHashAlgorithm EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3272:2: iv_ruleHashAlgorithm= ruleHashAlgorithm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHashAlgorithmRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleHashAlgorithm_in_entryRuleHashAlgorithm6567);
            iv_ruleHashAlgorithm=ruleHashAlgorithm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHashAlgorithm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHashAlgorithm6577); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3279:1: ruleHashAlgorithm returns [EObject current=null] : ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) ) ;
    public final EObject ruleHashAlgorithm() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Token lv_useBase64_1_0=null;
        Enumerator lv_kind_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3282:28: ( ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3283:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3283:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3283:2: ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3283:2: ( (lv_optional_0_0= 'optional' ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==69) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3284:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3284:1: (lv_optional_0_0= 'optional' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3285:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleHashAlgorithm6620); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3298:3: ( (lv_useBase64_1_0= 'Base64-encoded' ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==74) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3299:1: (lv_useBase64_1_0= 'Base64-encoded' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3299:1: (lv_useBase64_1_0= 'Base64-encoded' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3300:3: lv_useBase64_1_0= 'Base64-encoded'
                    {
                    lv_useBase64_1_0=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleHashAlgorithm6652); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3313:3: ( (lv_kind_2_0= ruleHashAlgKind ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3314:1: (lv_kind_2_0= ruleHashAlgKind )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3314:1: (lv_kind_2_0= ruleHashAlgKind )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3315:3: lv_kind_2_0= ruleHashAlgKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getHashAlgorithmAccess().getKindHashAlgKindEnumRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleHashAlgKind_in_ruleHashAlgorithm6687);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3339:1: entryRuleSigningPolicy returns [EObject current=null] : iv_ruleSigningPolicy= ruleSigningPolicy EOF ;
    public final EObject entryRuleSigningPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSigningPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3340:2: (iv_ruleSigningPolicy= ruleSigningPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3341:2: iv_ruleSigningPolicy= ruleSigningPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSigningPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSigningPolicy_in_entryRuleSigningPolicy6723);
            iv_ruleSigningPolicy=ruleSigningPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSigningPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSigningPolicy6733); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3348:1: ruleSigningPolicy returns [EObject current=null] : ( () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3351:28: ( ( () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3352:1: ( () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3352:1: ( () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3352:2: () otherlv_1= 'signing-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )? (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}'
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3352:2: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3353:2: 
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

            otherlv_1=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleSigningPolicy6782); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSigningPolicyAccess().getSigningPolicyKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSigningPolicy6794); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getSigningPolicyAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3369:1: (otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+ )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==76) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3369:3: otherlv_3= 'supported-algorithms' ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+
                    {
                    otherlv_3=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleSigningPolicy6807); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getSigningPolicyAccess().getSupportedAlgorithmsKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3373:1: ( (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm ) )+
                    int cnt91=0;
                    loop91:
                    do {
                        int alt91=2;
                        int LA91_0 = input.LA(1);

                        if ( ((LA91_0>=134 && LA91_0<=136)||(LA91_0>=143 && LA91_0<=147)) ) {
                            alt91=1;
                        }


                        switch (alt91) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3374:1: (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3374:1: (lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3375:3: lv_supportedSigningAlgorithms_4_0= ruleSigningAlgothm
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSigningPolicyAccess().getSupportedSigningAlgorithmsSigningAlgothmEnumRuleCall_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleSigningAlgothm_in_ruleSigningPolicy6828);
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
                    	    if ( cnt91 >= 1 ) break loop91;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(91, input);
                                throw eee;
                        }
                        cnt91++;
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3391:5: (otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==77) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3391:7: otherlv_5= 'requires-algorithm' ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) )
                    {
                    otherlv_5=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleSigningPolicy6844); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSigningPolicyAccess().getRequiresAlgorithmKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3395:1: ( (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3396:1: (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3396:1: (lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3397:3: lv_requiredSigningAlgorithm_6_0= ruleSigningAlgothm
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSigningPolicyAccess().getRequiredSigningAlgorithmSigningAlgothmEnumRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSigningAlgothm_in_ruleSigningPolicy6865);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3413:4: (otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )* )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==78) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3413:6: otherlv_7= 'signed-message-parts' ( (lv_signedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )*
                    {
                    otherlv_7=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleSigningPolicy6880); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getSigningPolicyAccess().getSignedMessagePartsKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3417:1: ( (lv_signedParts_8_0= ruleMessagePartRef ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3418:1: (lv_signedParts_8_0= ruleMessagePartRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3418:1: (lv_signedParts_8_0= ruleMessagePartRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3419:3: lv_signedParts_8_0= ruleMessagePartRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSigningPolicyAccess().getSignedPartsMessagePartRefParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_ruleSigningPolicy6901);
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

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3435:2: (otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) ) )*
                    loop94:
                    do {
                        int alt94=2;
                        int LA94_0 = input.LA(1);

                        if ( (LA94_0==13) ) {
                            alt94=1;
                        }


                        switch (alt94) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3435:4: otherlv_9= ',' ( (lv_signedParts_10_0= ruleMessagePartRef ) )
                    	    {
                    	    otherlv_9=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSigningPolicy6914); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getSigningPolicyAccess().getCommaKeyword_5_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3439:1: ( (lv_signedParts_10_0= ruleMessagePartRef ) )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3440:1: (lv_signedParts_10_0= ruleMessagePartRef )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3440:1: (lv_signedParts_10_0= ruleMessagePartRef )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3441:3: lv_signedParts_10_0= ruleMessagePartRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getSigningPolicyAccess().getSignedPartsMessagePartRefParserRuleCall_5_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_ruleSigningPolicy6935);
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
                    	    break loop94;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleSigningPolicy6951); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3469:1: entryRuleMessagePartRef returns [EObject current=null] : iv_ruleMessagePartRef= ruleMessagePartRef EOF ;
    public final EObject entryRuleMessagePartRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessagePartRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3470:2: (iv_ruleMessagePartRef= ruleMessagePartRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3471:2: iv_ruleMessagePartRef= ruleMessagePartRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMessagePartRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_entryRuleMessagePartRef6987);
            iv_ruleMessagePartRef=ruleMessagePartRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMessagePartRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMessagePartRef6997); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3478:1: ruleMessagePartRef returns [EObject current=null] : ( ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleMessagePartRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_partRefExpression_2_0=null;
        Enumerator lv_messagePartRef_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3481:28: ( ( ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3482:1: ( ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3482:1: ( ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3482:2: ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) ) (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )?
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3482:2: ( (lv_messagePartRef_0_0= ruleMessagePartRefKind ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3483:1: (lv_messagePartRef_0_0= ruleMessagePartRefKind )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3483:1: (lv_messagePartRef_0_0= ruleMessagePartRefKind )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3484:3: lv_messagePartRef_0_0= ruleMessagePartRefKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMessagePartRefAccess().getMessagePartRefMessagePartRefKindEnumRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleMessagePartRefKind_in_ruleMessagePartRef7043);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3500:2: (otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==79) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3500:4: otherlv_1= 'expression' ( (lv_partRefExpression_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleMessagePartRef7056); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMessagePartRefAccess().getExpressionKeyword_1_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3504:1: ( (lv_partRefExpression_2_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3505:1: (lv_partRefExpression_2_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3505:1: (lv_partRefExpression_2_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3506:3: lv_partRefExpression_2_0= RULE_STRING
                    {
                    lv_partRefExpression_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMessagePartRef7073); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3530:1: entryRuleEncryptionPolicy returns [EObject current=null] : iv_ruleEncryptionPolicy= ruleEncryptionPolicy EOF ;
    public final EObject entryRuleEncryptionPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEncryptionPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3531:2: (iv_ruleEncryptionPolicy= ruleEncryptionPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3532:2: iv_ruleEncryptionPolicy= ruleEncryptionPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEncryptionPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEncryptionPolicy_in_entryRuleEncryptionPolicy7116);
            iv_ruleEncryptionPolicy=ruleEncryptionPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEncryptionPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEncryptionPolicy7126); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3539:1: ruleEncryptionPolicy returns [EObject current=null] : ( () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3542:28: ( ( () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3543:1: ( () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3543:1: ( () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3543:2: () otherlv_1= 'encryption-policy' otherlv_2= '{' (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )? (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )? (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )? otherlv_11= '}'
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3543:2: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3544:2: 
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

            otherlv_1=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleEncryptionPolicy7175); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEncryptionPolicyAccess().getEncryptionPolicyKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleEncryptionPolicy7187); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getEncryptionPolicyAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3560:1: (otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+ )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==76) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3560:3: otherlv_3= 'supported-algorithms' ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+
                    {
                    otherlv_3=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleEncryptionPolicy7200); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getEncryptionPolicyAccess().getSupportedAlgorithmsKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3564:1: ( (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind ) )+
                    int cnt97=0;
                    loop97:
                    do {
                        int alt97=2;
                        int LA97_0 = input.LA(1);

                        if ( (LA97_0==143||LA97_0==145||(LA97_0>=147 && LA97_0<=152)) ) {
                            alt97=1;
                        }


                        switch (alt97) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3565:1: (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3565:1: (lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3566:3: lv_supportedCipherAlgorithms_4_0= ruleCipherAlgorithmKind
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getEncryptionPolicyAccess().getSupportedCipherAlgorithmsCipherAlgorithmKindEnumRuleCall_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCipherAlgorithmKind_in_ruleEncryptionPolicy7221);
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
                    	    if ( cnt97 >= 1 ) break loop97;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(97, input);
                                throw eee;
                        }
                        cnt97++;
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3582:5: (otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==77) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3582:7: otherlv_5= 'requires-algorithm' ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) )
                    {
                    otherlv_5=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleEncryptionPolicy7237); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getEncryptionPolicyAccess().getRequiresAlgorithmKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3586:1: ( (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3587:1: (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3587:1: (lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3588:3: lv_requiredCipherAlgorithm_6_0= ruleCipherAlgorithmKind
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEncryptionPolicyAccess().getRequiredCipherAlgorithmCipherAlgorithmKindEnumRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCipherAlgorithmKind_in_ruleEncryptionPolicy7258);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3604:4: (otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )* )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==81) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3604:6: otherlv_7= 'encrypted-message-parts' ( (lv_encryptedParts_8_0= ruleMessagePartRef ) ) (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )*
                    {
                    otherlv_7=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleEncryptionPolicy7273); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getEncryptionPolicyAccess().getEncryptedMessagePartsKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3608:1: ( (lv_encryptedParts_8_0= ruleMessagePartRef ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3609:1: (lv_encryptedParts_8_0= ruleMessagePartRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3609:1: (lv_encryptedParts_8_0= ruleMessagePartRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3610:3: lv_encryptedParts_8_0= ruleMessagePartRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEncryptionPolicyAccess().getEncryptedPartsMessagePartRefParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_ruleEncryptionPolicy7294);
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

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3626:2: (otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) ) )*
                    loop100:
                    do {
                        int alt100=2;
                        int LA100_0 = input.LA(1);

                        if ( (LA100_0==13) ) {
                            alt100=1;
                        }


                        switch (alt100) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3626:4: otherlv_9= ',' ( (lv_encryptedParts_10_0= ruleMessagePartRef ) )
                    	    {
                    	    otherlv_9=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleEncryptionPolicy7307); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getEncryptionPolicyAccess().getCommaKeyword_5_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3630:1: ( (lv_encryptedParts_10_0= ruleMessagePartRef ) )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3631:1: (lv_encryptedParts_10_0= ruleMessagePartRef )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3631:1: (lv_encryptedParts_10_0= ruleMessagePartRef )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3632:3: lv_encryptedParts_10_0= ruleMessagePartRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getEncryptionPolicyAccess().getEncryptedPartsMessagePartRefParserRuleCall_5_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleMessagePartRef_in_ruleEncryptionPolicy7328);
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
                    	    break loop100;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleEncryptionPolicy7344); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3660:1: entryRuleAssertion returns [EObject current=null] : iv_ruleAssertion= ruleAssertion EOF ;
    public final EObject entryRuleAssertion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssertion = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3661:2: (iv_ruleAssertion= ruleAssertion EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3662:2: iv_ruleAssertion= ruleAssertion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssertionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAssertion_in_entryRuleAssertion7380);
            iv_ruleAssertion=ruleAssertion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssertion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssertion7390); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3669:1: ruleAssertion returns [EObject current=null] : (this_AvailabilityAssertion_0= ruleAvailabilityAssertion | this_LatencyAssertion_1= ruleLatencyAssertion | this_CapacityAssertion_2= ruleCapacityAssertion | this_ReliablityAsserttion_3= ruleReliablityAsserttion | this_CostAssertion_4= ruleCostAssertion | this_AccuracyAssertion_5= ruleAccuracyAssertion ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3672:28: ( (this_AvailabilityAssertion_0= ruleAvailabilityAssertion | this_LatencyAssertion_1= ruleLatencyAssertion | this_CapacityAssertion_2= ruleCapacityAssertion | this_ReliablityAsserttion_3= ruleReliablityAsserttion | this_CostAssertion_4= ruleCostAssertion | this_AccuracyAssertion_5= ruleAccuracyAssertion ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3673:1: (this_AvailabilityAssertion_0= ruleAvailabilityAssertion | this_LatencyAssertion_1= ruleLatencyAssertion | this_CapacityAssertion_2= ruleCapacityAssertion | this_ReliablityAsserttion_3= ruleReliablityAsserttion | this_CostAssertion_4= ruleCostAssertion | this_AccuracyAssertion_5= ruleAccuracyAssertion )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3673:1: (this_AvailabilityAssertion_0= ruleAvailabilityAssertion | this_LatencyAssertion_1= ruleLatencyAssertion | this_CapacityAssertion_2= ruleCapacityAssertion | this_ReliablityAsserttion_3= ruleReliablityAsserttion | this_CostAssertion_4= ruleCostAssertion | this_AccuracyAssertion_5= ruleAccuracyAssertion )
            int alt102=6;
            alt102 = dfa102.predict(input);
            switch (alt102) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3674:2: this_AvailabilityAssertion_0= ruleAvailabilityAssertion
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAssertionAccess().getAvailabilityAssertionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAvailabilityAssertion_in_ruleAssertion7440);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3687:2: this_LatencyAssertion_1= ruleLatencyAssertion
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAssertionAccess().getLatencyAssertionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLatencyAssertion_in_ruleAssertion7470);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3700:2: this_CapacityAssertion_2= ruleCapacityAssertion
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAssertionAccess().getCapacityAssertionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCapacityAssertion_in_ruleAssertion7500);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3713:2: this_ReliablityAsserttion_3= ruleReliablityAsserttion
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAssertionAccess().getReliablityAsserttionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleReliablityAsserttion_in_ruleAssertion7530);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3726:2: this_CostAssertion_4= ruleCostAssertion
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAssertionAccess().getCostAssertionParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCostAssertion_in_ruleAssertion7560);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3739:2: this_AccuracyAssertion_5= ruleAccuracyAssertion
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAssertionAccess().getAccuracyAssertionParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAccuracyAssertion_in_ruleAssertion7590);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3758:1: entryRuleAvailabilityAssertion returns [EObject current=null] : iv_ruleAvailabilityAssertion= ruleAvailabilityAssertion EOF ;
    public final EObject entryRuleAvailabilityAssertion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAvailabilityAssertion = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3759:2: (iv_ruleAvailabilityAssertion= ruleAvailabilityAssertion EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3760:2: iv_ruleAvailabilityAssertion= ruleAvailabilityAssertion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAvailabilityAssertionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAvailabilityAssertion_in_entryRuleAvailabilityAssertion7625);
            iv_ruleAvailabilityAssertion=ruleAvailabilityAssertion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAvailabilityAssertion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAvailabilityAssertion7635); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3767:1: ruleAvailabilityAssertion returns [EObject current=null] : (otherlv_0= 'availability' ( (lv_availability_1_0= RULE_STRING ) ) otherlv_2= 'percentile' ( (lv_percentile_3_0= rulePercentile ) ) otherlv_4= 'mean-time-between-failure' ( (lv_mtbf_5_0= RULE_STRING ) ) otherlv_6= 'mean-time-to-repair' ( (lv_mttr_7_0= RULE_STRING ) ) ( (lv_mttrPercentile_8_0= rulePercentile ) )? ) ;
    public final EObject ruleAvailabilityAssertion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_availability_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_mtbf_5_0=null;
        Token otherlv_6=null;
        Token lv_mttr_7_0=null;
        EObject lv_percentile_3_0 = null;

        EObject lv_mttrPercentile_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3770:28: ( (otherlv_0= 'availability' ( (lv_availability_1_0= RULE_STRING ) ) otherlv_2= 'percentile' ( (lv_percentile_3_0= rulePercentile ) ) otherlv_4= 'mean-time-between-failure' ( (lv_mtbf_5_0= RULE_STRING ) ) otherlv_6= 'mean-time-to-repair' ( (lv_mttr_7_0= RULE_STRING ) ) ( (lv_mttrPercentile_8_0= rulePercentile ) )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3771:1: (otherlv_0= 'availability' ( (lv_availability_1_0= RULE_STRING ) ) otherlv_2= 'percentile' ( (lv_percentile_3_0= rulePercentile ) ) otherlv_4= 'mean-time-between-failure' ( (lv_mtbf_5_0= RULE_STRING ) ) otherlv_6= 'mean-time-to-repair' ( (lv_mttr_7_0= RULE_STRING ) ) ( (lv_mttrPercentile_8_0= rulePercentile ) )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3771:1: (otherlv_0= 'availability' ( (lv_availability_1_0= RULE_STRING ) ) otherlv_2= 'percentile' ( (lv_percentile_3_0= rulePercentile ) ) otherlv_4= 'mean-time-between-failure' ( (lv_mtbf_5_0= RULE_STRING ) ) otherlv_6= 'mean-time-to-repair' ( (lv_mttr_7_0= RULE_STRING ) ) ( (lv_mttrPercentile_8_0= rulePercentile ) )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3771:3: otherlv_0= 'availability' ( (lv_availability_1_0= RULE_STRING ) ) otherlv_2= 'percentile' ( (lv_percentile_3_0= rulePercentile ) ) otherlv_4= 'mean-time-between-failure' ( (lv_mtbf_5_0= RULE_STRING ) ) otherlv_6= 'mean-time-to-repair' ( (lv_mttr_7_0= RULE_STRING ) ) ( (lv_mttrPercentile_8_0= rulePercentile ) )?
            {
            otherlv_0=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleAvailabilityAssertion7672); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAvailabilityAssertionAccess().getAvailabilityKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3775:1: ( (lv_availability_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3776:1: (lv_availability_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3776:1: (lv_availability_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3777:3: lv_availability_1_0= RULE_STRING
            {
            lv_availability_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAvailabilityAssertion7689); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_availability_1_0, grammarAccess.getAvailabilityAssertionAccess().getAvailabilitySTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAvailabilityAssertionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"availability",
                      		lv_availability_1_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleAvailabilityAssertion7706); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAvailabilityAssertionAccess().getPercentileKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3797:1: ( (lv_percentile_3_0= rulePercentile ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3798:1: (lv_percentile_3_0= rulePercentile )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3798:1: (lv_percentile_3_0= rulePercentile )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3799:3: lv_percentile_3_0= rulePercentile
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAvailabilityAssertionAccess().getPercentilePercentileParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePercentile_in_ruleAvailabilityAssertion7727);
            lv_percentile_3_0=rulePercentile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAvailabilityAssertionRule());
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

            otherlv_4=(Token)match(input,84,FollowSets000.FOLLOW_84_in_ruleAvailabilityAssertion7739); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getAvailabilityAssertionAccess().getMeanTimeBetweenFailureKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3819:1: ( (lv_mtbf_5_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3820:1: (lv_mtbf_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3820:1: (lv_mtbf_5_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3821:3: lv_mtbf_5_0= RULE_STRING
            {
            lv_mtbf_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAvailabilityAssertion7756); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_mtbf_5_0, grammarAccess.getAvailabilityAssertionAccess().getMtbfSTRINGTerminalRuleCall_5_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAvailabilityAssertionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"mtbf",
                      		lv_mtbf_5_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,85,FollowSets000.FOLLOW_85_in_ruleAvailabilityAssertion7773); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getAvailabilityAssertionAccess().getMeanTimeToRepairKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3841:1: ( (lv_mttr_7_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3842:1: (lv_mttr_7_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3842:1: (lv_mttr_7_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3843:3: lv_mttr_7_0= RULE_STRING
            {
            lv_mttr_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAvailabilityAssertion7790); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_mttr_7_0, grammarAccess.getAvailabilityAssertionAccess().getMttrSTRINGTerminalRuleCall_7_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAvailabilityAssertionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"mttr",
                      		lv_mttr_7_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3859:2: ( (lv_mttrPercentile_8_0= rulePercentile ) )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==RULE_INT) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3860:1: (lv_mttrPercentile_8_0= rulePercentile )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3860:1: (lv_mttrPercentile_8_0= rulePercentile )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3861:3: lv_mttrPercentile_8_0= rulePercentile
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAvailabilityAssertionAccess().getMttrPercentilePercentileParserRuleCall_8_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePercentile_in_ruleAvailabilityAssertion7816);
                    lv_mttrPercentile_8_0=rulePercentile();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAvailabilityAssertionRule());
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3885:1: entryRuleLatencyAssertion returns [EObject current=null] : iv_ruleLatencyAssertion= ruleLatencyAssertion EOF ;
    public final EObject entryRuleLatencyAssertion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLatencyAssertion = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3886:2: (iv_ruleLatencyAssertion= ruleLatencyAssertion EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3887:2: iv_ruleLatencyAssertion= ruleLatencyAssertion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLatencyAssertionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLatencyAssertion_in_entryRuleLatencyAssertion7853);
            iv_ruleLatencyAssertion=ruleLatencyAssertion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLatencyAssertion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLatencyAssertion7863); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3894:1: ruleLatencyAssertion returns [EObject current=null] : (otherlv_0= 'latency' ( (lv_latency_1_0= 'STRING' ) ) otherlv_2= 'percentile' ( (lv_percentile_3_0= rulePercentile ) ) ) ;
    public final EObject ruleLatencyAssertion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_latency_1_0=null;
        Token otherlv_2=null;
        EObject lv_percentile_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3897:28: ( (otherlv_0= 'latency' ( (lv_latency_1_0= 'STRING' ) ) otherlv_2= 'percentile' ( (lv_percentile_3_0= rulePercentile ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3898:1: (otherlv_0= 'latency' ( (lv_latency_1_0= 'STRING' ) ) otherlv_2= 'percentile' ( (lv_percentile_3_0= rulePercentile ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3898:1: (otherlv_0= 'latency' ( (lv_latency_1_0= 'STRING' ) ) otherlv_2= 'percentile' ( (lv_percentile_3_0= rulePercentile ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3898:3: otherlv_0= 'latency' ( (lv_latency_1_0= 'STRING' ) ) otherlv_2= 'percentile' ( (lv_percentile_3_0= rulePercentile ) )
            {
            otherlv_0=(Token)match(input,86,FollowSets000.FOLLOW_86_in_ruleLatencyAssertion7900); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLatencyAssertionAccess().getLatencyKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3902:1: ( (lv_latency_1_0= 'STRING' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3903:1: (lv_latency_1_0= 'STRING' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3903:1: (lv_latency_1_0= 'STRING' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3904:3: lv_latency_1_0= 'STRING'
            {
            lv_latency_1_0=(Token)match(input,87,FollowSets000.FOLLOW_87_in_ruleLatencyAssertion7918); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleLatencyAssertion7943); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getLatencyAssertionAccess().getPercentileKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3921:1: ( (lv_percentile_3_0= rulePercentile ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3922:1: (lv_percentile_3_0= rulePercentile )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3922:1: (lv_percentile_3_0= rulePercentile )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3923:3: lv_percentile_3_0= rulePercentile
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLatencyAssertionAccess().getPercentilePercentileParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePercentile_in_ruleLatencyAssertion7964);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3947:1: entryRuleCapacityAssertion returns [EObject current=null] : iv_ruleCapacityAssertion= ruleCapacityAssertion EOF ;
    public final EObject entryRuleCapacityAssertion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCapacityAssertion = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3948:2: (iv_ruleCapacityAssertion= ruleCapacityAssertion EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3949:2: iv_ruleCapacityAssertion= ruleCapacityAssertion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCapacityAssertionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCapacityAssertion_in_entryRuleCapacityAssertion8000);
            iv_ruleCapacityAssertion=ruleCapacityAssertion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCapacityAssertion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCapacityAssertion8010); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3956:1: ruleCapacityAssertion returns [EObject current=null] : ( () (otherlv_1= 'num-of-requests' ( (lv_requestNum_2_0= RULE_STRING ) ) otherlv_3= 'per' ( (lv_timeUnit_4_0= RULE_STRING ) ) )? (otherlv_5= 'message-size' ( (lv_messageSize_6_0= RULE_STRING ) ) )? ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3959:28: ( ( () (otherlv_1= 'num-of-requests' ( (lv_requestNum_2_0= RULE_STRING ) ) otherlv_3= 'per' ( (lv_timeUnit_4_0= RULE_STRING ) ) )? (otherlv_5= 'message-size' ( (lv_messageSize_6_0= RULE_STRING ) ) )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3960:1: ( () (otherlv_1= 'num-of-requests' ( (lv_requestNum_2_0= RULE_STRING ) ) otherlv_3= 'per' ( (lv_timeUnit_4_0= RULE_STRING ) ) )? (otherlv_5= 'message-size' ( (lv_messageSize_6_0= RULE_STRING ) ) )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3960:1: ( () (otherlv_1= 'num-of-requests' ( (lv_requestNum_2_0= RULE_STRING ) ) otherlv_3= 'per' ( (lv_timeUnit_4_0= RULE_STRING ) ) )? (otherlv_5= 'message-size' ( (lv_messageSize_6_0= RULE_STRING ) ) )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3960:2: () (otherlv_1= 'num-of-requests' ( (lv_requestNum_2_0= RULE_STRING ) ) otherlv_3= 'per' ( (lv_timeUnit_4_0= RULE_STRING ) ) )? (otherlv_5= 'message-size' ( (lv_messageSize_6_0= RULE_STRING ) ) )?
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3960:2: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3961:2: 
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3969:2: (otherlv_1= 'num-of-requests' ( (lv_requestNum_2_0= RULE_STRING ) ) otherlv_3= 'per' ( (lv_timeUnit_4_0= RULE_STRING ) ) )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==88) ) {
                int LA104_1 = input.LA(2);

                if ( (synpred118_InternalBindingDsl()) ) {
                    alt104=1;
                }
            }
            switch (alt104) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3969:4: otherlv_1= 'num-of-requests' ( (lv_requestNum_2_0= RULE_STRING ) ) otherlv_3= 'per' ( (lv_timeUnit_4_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,88,FollowSets000.FOLLOW_88_in_ruleCapacityAssertion8060); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCapacityAssertionAccess().getNumOfRequestsKeyword_1_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3973:1: ( (lv_requestNum_2_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3974:1: (lv_requestNum_2_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3974:1: (lv_requestNum_2_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3975:3: lv_requestNum_2_0= RULE_STRING
                    {
                    lv_requestNum_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCapacityAssertion8077); if (state.failed) return current;
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

                    otherlv_3=(Token)match(input,89,FollowSets000.FOLLOW_89_in_ruleCapacityAssertion8094); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getCapacityAssertionAccess().getPerKeyword_1_2());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3995:1: ( (lv_timeUnit_4_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3996:1: (lv_timeUnit_4_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3996:1: (lv_timeUnit_4_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3997:3: lv_timeUnit_4_0= RULE_STRING
                    {
                    lv_timeUnit_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCapacityAssertion8111); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4013:4: (otherlv_5= 'message-size' ( (lv_messageSize_6_0= RULE_STRING ) ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==90) ) {
                int LA105_1 = input.LA(2);

                if ( (synpred119_InternalBindingDsl()) ) {
                    alt105=1;
                }
            }
            switch (alt105) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4013:6: otherlv_5= 'message-size' ( (lv_messageSize_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,90,FollowSets000.FOLLOW_90_in_ruleCapacityAssertion8131); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getCapacityAssertionAccess().getMessageSizeKeyword_2_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4017:1: ( (lv_messageSize_6_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4018:1: (lv_messageSize_6_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4018:1: (lv_messageSize_6_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4019:3: lv_messageSize_6_0= RULE_STRING
                    {
                    lv_messageSize_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCapacityAssertion8148); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4043:1: entryRuleReliablityAsserttion returns [EObject current=null] : iv_ruleReliablityAsserttion= ruleReliablityAsserttion EOF ;
    public final EObject entryRuleReliablityAsserttion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReliablityAsserttion = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4044:2: (iv_ruleReliablityAsserttion= ruleReliablityAsserttion EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4045:2: iv_ruleReliablityAsserttion= ruleReliablityAsserttion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReliablityAsserttionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReliablityAsserttion_in_entryRuleReliablityAsserttion8191);
            iv_ruleReliablityAsserttion=ruleReliablityAsserttion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReliablityAsserttion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReliablityAsserttion8201); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4052:1: ruleReliablityAsserttion returns [EObject current=null] : (otherlv_0= 'message-exchange-reliability' ( (lv_reliability_1_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_2_0= 'in-order-delivery' ) )? ) ;
    public final EObject ruleReliablityAsserttion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_inOrderDelivery_2_0=null;
        Enumerator lv_reliability_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4055:28: ( (otherlv_0= 'message-exchange-reliability' ( (lv_reliability_1_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_2_0= 'in-order-delivery' ) )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4056:1: (otherlv_0= 'message-exchange-reliability' ( (lv_reliability_1_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_2_0= 'in-order-delivery' ) )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4056:1: (otherlv_0= 'message-exchange-reliability' ( (lv_reliability_1_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_2_0= 'in-order-delivery' ) )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4056:3: otherlv_0= 'message-exchange-reliability' ( (lv_reliability_1_0= ruleReliablilityKind ) ) ( (lv_inOrderDelivery_2_0= 'in-order-delivery' ) )?
            {
            otherlv_0=(Token)match(input,91,FollowSets000.FOLLOW_91_in_ruleReliablityAsserttion8238); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getReliablityAsserttionAccess().getMessageExchangeReliabilityKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4060:1: ( (lv_reliability_1_0= ruleReliablilityKind ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4061:1: (lv_reliability_1_0= ruleReliablilityKind )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4061:1: (lv_reliability_1_0= ruleReliablilityKind )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4062:3: lv_reliability_1_0= ruleReliablilityKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReliablityAsserttionAccess().getReliabilityReliablilityKindEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleReliablilityKind_in_ruleReliablityAsserttion8259);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4078:2: ( (lv_inOrderDelivery_2_0= 'in-order-delivery' ) )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==92) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4079:1: (lv_inOrderDelivery_2_0= 'in-order-delivery' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4079:1: (lv_inOrderDelivery_2_0= 'in-order-delivery' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4080:3: lv_inOrderDelivery_2_0= 'in-order-delivery'
                    {
                    lv_inOrderDelivery_2_0=(Token)match(input,92,FollowSets000.FOLLOW_92_in_ruleReliablityAsserttion8277); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4101:1: entryRuleCostAssertion returns [EObject current=null] : iv_ruleCostAssertion= ruleCostAssertion EOF ;
    public final EObject entryRuleCostAssertion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCostAssertion = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4102:2: (iv_ruleCostAssertion= ruleCostAssertion EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4103:2: iv_ruleCostAssertion= ruleCostAssertion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCostAssertionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCostAssertion_in_entryRuleCostAssertion8327);
            iv_ruleCostAssertion=ruleCostAssertion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCostAssertion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCostAssertion8337); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4110:1: ruleCostAssertion returns [EObject current=null] : (otherlv_0= 'costs' ( (lv_costsAmount_1_0= RULE_STRING ) ) otherlv_2= 'billed-per-unit' ( (lv_billedUnit_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleCostAssertion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_costsAmount_1_0=null;
        Token otherlv_2=null;
        Token lv_billedUnit_3_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4113:28: ( (otherlv_0= 'costs' ( (lv_costsAmount_1_0= RULE_STRING ) ) otherlv_2= 'billed-per-unit' ( (lv_billedUnit_3_0= RULE_STRING ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4114:1: (otherlv_0= 'costs' ( (lv_costsAmount_1_0= RULE_STRING ) ) otherlv_2= 'billed-per-unit' ( (lv_billedUnit_3_0= RULE_STRING ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4114:1: (otherlv_0= 'costs' ( (lv_costsAmount_1_0= RULE_STRING ) ) otherlv_2= 'billed-per-unit' ( (lv_billedUnit_3_0= RULE_STRING ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4114:3: otherlv_0= 'costs' ( (lv_costsAmount_1_0= RULE_STRING ) ) otherlv_2= 'billed-per-unit' ( (lv_billedUnit_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,93,FollowSets000.FOLLOW_93_in_ruleCostAssertion8374); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getCostAssertionAccess().getCostsKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4118:1: ( (lv_costsAmount_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4119:1: (lv_costsAmount_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4119:1: (lv_costsAmount_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4120:3: lv_costsAmount_1_0= RULE_STRING
            {
            lv_costsAmount_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCostAssertion8391); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,94,FollowSets000.FOLLOW_94_in_ruleCostAssertion8408); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getCostAssertionAccess().getBilledPerUnitKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4140:1: ( (lv_billedUnit_3_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4141:1: (lv_billedUnit_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4141:1: (lv_billedUnit_3_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4142:3: lv_billedUnit_3_0= RULE_STRING
            {
            lv_billedUnit_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCostAssertion8425); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4166:1: entryRuleAccuracyAssertion returns [EObject current=null] : iv_ruleAccuracyAssertion= ruleAccuracyAssertion EOF ;
    public final EObject entryRuleAccuracyAssertion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccuracyAssertion = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4167:2: (iv_ruleAccuracyAssertion= ruleAccuracyAssertion EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4168:2: iv_ruleAccuracyAssertion= ruleAccuracyAssertion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAccuracyAssertionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAccuracyAssertion_in_entryRuleAccuracyAssertion8466);
            iv_ruleAccuracyAssertion=ruleAccuracyAssertion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAccuracyAssertion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAccuracyAssertion8476); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4175:1: ruleAccuracyAssertion returns [EObject current=null] : (otherlv_0= 'max-error-rate' ( (lv_maxErrorRate_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleAccuracyAssertion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_maxErrorRate_1_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4178:28: ( (otherlv_0= 'max-error-rate' ( (lv_maxErrorRate_1_0= RULE_STRING ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4179:1: (otherlv_0= 'max-error-rate' ( (lv_maxErrorRate_1_0= RULE_STRING ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4179:1: (otherlv_0= 'max-error-rate' ( (lv_maxErrorRate_1_0= RULE_STRING ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4179:3: otherlv_0= 'max-error-rate' ( (lv_maxErrorRate_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,95,FollowSets000.FOLLOW_95_in_ruleAccuracyAssertion8513); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAccuracyAssertionAccess().getMaxErrorRateKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4183:1: ( (lv_maxErrorRate_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4184:1: (lv_maxErrorRate_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4184:1: (lv_maxErrorRate_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4185:3: lv_maxErrorRate_1_0= RULE_STRING
            {
            lv_maxErrorRate_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAccuracyAssertion8530); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4209:1: entryRulePercentile returns [EObject current=null] : iv_rulePercentile= rulePercentile EOF ;
    public final EObject entryRulePercentile() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePercentile = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4210:2: (iv_rulePercentile= rulePercentile EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4211:2: iv_rulePercentile= rulePercentile EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPercentileRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePercentile_in_entryRulePercentile8571);
            iv_rulePercentile=rulePercentile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePercentile; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePercentile8581); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4218:1: rulePercentile returns [EObject current=null] : ( ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%' ) ;
    public final EObject rulePercentile() throws RecognitionException {
        EObject current = null;

        Token lv_percentile_0_0=null;
        Token otherlv_1=null;
        Token this_INT_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4221:28: ( ( ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4222:1: ( ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4222:1: ( ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4222:2: ( (lv_percentile_0_0= RULE_INT ) ) (otherlv_1= '.' this_INT_2= RULE_INT )* otherlv_3= '%'
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4222:2: ( (lv_percentile_0_0= RULE_INT ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4223:1: (lv_percentile_0_0= RULE_INT )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4223:1: (lv_percentile_0_0= RULE_INT )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4224:3: lv_percentile_0_0= RULE_INT
            {
            lv_percentile_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rulePercentile8623); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4240:2: (otherlv_1= '.' this_INT_2= RULE_INT )*
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( (LA107_0==96) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4240:4: otherlv_1= '.' this_INT_2= RULE_INT
            	    {
            	    otherlv_1=(Token)match(input,96,FollowSets000.FOLLOW_96_in_rulePercentile8641); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPercentileAccess().getFullStopKeyword_1_0());
            	          
            	    }
            	    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rulePercentile8652); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_INT_2, grammarAccess.getPercentileAccess().getINTTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop107;
                }
            } while (true);

            otherlv_3=(Token)match(input,97,FollowSets000.FOLLOW_97_in_rulePercentile8665); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4260:1: entryRuleEndpointQualifierRef returns [EObject current=null] : iv_ruleEndpointQualifierRef= ruleEndpointQualifierRef EOF ;
    public final EObject entryRuleEndpointQualifierRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndpointQualifierRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4261:2: (iv_ruleEndpointQualifierRef= ruleEndpointQualifierRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4262:2: iv_ruleEndpointQualifierRef= ruleEndpointQualifierRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEndpointQualifierRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRef_in_entryRuleEndpointQualifierRef8701);
            iv_ruleEndpointQualifierRef=ruleEndpointQualifierRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEndpointQualifierRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEndpointQualifierRef8711); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4269:1: ruleEndpointQualifierRef returns [EObject current=null] : (otherlv_0= 'endpoint-qualifier' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleEndpointQualifierRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4272:28: ( (otherlv_0= 'endpoint-qualifier' ( ( ruleQualifiedName ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4273:1: (otherlv_0= 'endpoint-qualifier' ( ( ruleQualifiedName ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4273:1: (otherlv_0= 'endpoint-qualifier' ( ( ruleQualifiedName ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4273:3: otherlv_0= 'endpoint-qualifier' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,98,FollowSets000.FOLLOW_98_in_ruleEndpointQualifierRef8748); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEndpointQualifierRefAccess().getEndpointQualifierKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4277:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4278:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4278:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4279:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleEndpointQualifierRef8775);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4303:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4304:2: (iv_ruleImport= ruleImport EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4305:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport8811);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport8821); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4312:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4315:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4316:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4316:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4316:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {
            otherlv_0=(Token)match(input,99,FollowSets000.FOLLOW_99_in_ruleImport8858); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4320:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4321:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4321:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4322:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport8879);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4346:1: entryRuleVersionId returns [String current=null] : iv_ruleVersionId= ruleVersionId EOF ;
    public final String entryRuleVersionId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionId = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4347:2: (iv_ruleVersionId= ruleVersionId EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4348:2: iv_ruleVersionId= ruleVersionId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionIdRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_entryRuleVersionId8916);
            iv_ruleVersionId=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionId.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionId8927); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4355:1: ruleVersionId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleVersionId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_ID_5=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4358:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4359:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4359:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4359:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )*
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId8967); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4366:1: (kw= '.' this_INT_2= RULE_INT )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( (LA108_0==96) ) {
                    int LA108_1 = input.LA(2);

                    if ( (LA108_1==RULE_INT) ) {
                        alt108=1;
                    }


                }


                switch (alt108) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4367:2: kw= '.' this_INT_2= RULE_INT
            	    {
            	    kw=(Token)match(input,96,FollowSets000.FOLLOW_96_in_ruleVersionId8986); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId9001); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_INT_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_INT_2, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop108;
                }
            } while (true);

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4379:3: ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )*
            loop110:
            do {
                int alt110=2;
                int LA110_0 = input.LA(1);

                if ( (LA110_0==96||LA110_0==100) ) {
                    alt110=1;
                }


                switch (alt110) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4379:4: (kw= '.' | kw= '-' ) this_ID_5= RULE_ID
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4379:4: (kw= '.' | kw= '-' )
            	    int alt109=2;
            	    int LA109_0 = input.LA(1);

            	    if ( (LA109_0==96) ) {
            	        alt109=1;
            	    }
            	    else if ( (LA109_0==100) ) {
            	        alt109=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 109, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt109) {
            	        case 1 :
            	            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4380:2: kw= '.'
            	            {
            	            kw=(Token)match(input,96,FollowSets000.FOLLOW_96_in_ruleVersionId9023); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_2_0_0()); 
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4387:2: kw= '-'
            	            {
            	            kw=(Token)match(input,100,FollowSets000.FOLLOW_100_in_ruleVersionId9042); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getVersionIdAccess().getHyphenMinusKeyword_2_0_1()); 
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    this_ID_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVersionId9058); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_5);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_5, grammarAccess.getVersionIdAccess().getIDTerminalRuleCall_2_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop110;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4411:1: entryRuleVersionRef returns [EObject current=null] : iv_ruleVersionRef= ruleVersionRef EOF ;
    public final EObject entryRuleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4412:2: (iv_ruleVersionRef= ruleVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4413:2: iv_ruleVersionRef= ruleVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_entryRuleVersionRef9109);
            iv_ruleVersionRef=ruleVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionRef9119); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4420:1: ruleVersionRef returns [EObject current=null] : (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) ;
    public final EObject ruleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject this_MinVersionRef_0 = null;

        EObject this_MaxVersionRef_1 = null;

        EObject this_LowerBoundRangeVersionRef_2 = null;

        EObject this_MajorVersionRef_3 = null;

        EObject this_FixedVersionRef_4 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4423:28: ( (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4424:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4424:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            int alt111=5;
            switch ( input.LA(1) ) {
            case 101:
                {
                int LA111_1 = input.LA(2);

                if ( (LA111_1==103) ) {
                    alt111=3;
                }
                else if ( (LA111_1==RULE_INT) ) {
                    alt111=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 111, 1, input);

                    throw nvae;
                }
                }
                break;
            case 102:
                {
                alt111=2;
                }
                break;
            case 105:
                {
                alt111=4;
                }
                break;
            case 106:
                {
                alt111=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;
            }

            switch (alt111) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4425:2: this_MinVersionRef_0= ruleMinVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMinVersionRefParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_ruleVersionRef9169);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4438:2: this_MaxVersionRef_1= ruleMaxVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMaxVersionRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_ruleVersionRef9199);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4451:2: this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getLowerBoundRangeVersionRefParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef9229);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4464:2: this_MajorVersionRef_3= ruleMajorVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMajorVersionRefParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_ruleVersionRef9259);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4477:2: this_FixedVersionRef_4= ruleFixedVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getFixedVersionRefParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_ruleVersionRef9289);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4496:1: entryRuleMinVersionRef returns [EObject current=null] : iv_ruleMinVersionRef= ruleMinVersionRef EOF ;
    public final EObject entryRuleMinVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinVersionRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4497:2: (iv_ruleMinVersionRef= ruleMinVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4498:2: iv_ruleMinVersionRef= ruleMinVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMinVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef9324);
            iv_ruleMinVersionRef=ruleMinVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMinVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMinVersionRef9334); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4505:1: ruleMinVersionRef returns [EObject current=null] : (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMinVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_minVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4508:28: ( (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4509:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4509:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4509:3: otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,101,FollowSets000.FOLLOW_101_in_ruleMinVersionRef9371); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMinVersionRefAccess().getMinVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4513:1: ( (lv_minVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4514:1: (lv_minVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4514:1: (lv_minVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4515:3: lv_minVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMinVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMinVersionRef9392);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4539:1: entryRuleMaxVersionRef returns [EObject current=null] : iv_ruleMaxVersionRef= ruleMaxVersionRef EOF ;
    public final EObject entryRuleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxVersionRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4540:2: (iv_ruleMaxVersionRef= ruleMaxVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4541:2: iv_ruleMaxVersionRef= ruleMaxVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMaxVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef9428);
            iv_ruleMaxVersionRef=ruleMaxVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMaxVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxVersionRef9438); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4548:1: ruleMaxVersionRef returns [EObject current=null] : (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_maxVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4551:28: ( (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4552:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4552:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4552:3: otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,102,FollowSets000.FOLLOW_102_in_ruleMaxVersionRef9475); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMaxVersionRefAccess().getMaxVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4556:1: ( (lv_maxVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4557:1: (lv_maxVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4557:1: (lv_maxVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4558:3: lv_maxVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMaxVersionRefAccess().getMaxVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMaxVersionRef9496);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4582:1: entryRuleLowerBoundRangeVersionRef returns [EObject current=null] : iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF ;
    public final EObject entryRuleLowerBoundRangeVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerBoundRangeVersionRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4583:2: (iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4584:2: iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef9532);
            iv_ruleLowerBoundRangeVersionRef=ruleLowerBoundRangeVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLowerBoundRangeVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef9542); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4591:1: ruleLowerBoundRangeVersionRef returns [EObject current=null] : ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4594:28: ( ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4595:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4595:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4595:2: (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4595:2: (otherlv_0= 'minVersion' otherlv_1= '>=' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4595:4: otherlv_0= 'minVersion' otherlv_1= '>='
            {
            otherlv_0=(Token)match(input,101,FollowSets000.FOLLOW_101_in_ruleLowerBoundRangeVersionRef9580); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionKeyword_0_0());
                  
            }
            otherlv_1=(Token)match(input,103,FollowSets000.FOLLOW_103_in_ruleLowerBoundRangeVersionRef9592); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLowerBoundRangeVersionRefAccess().getGreaterThanSignEqualsSignKeyword_0_1());
                  
            }

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4603:2: ( (lv_minVersion_2_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4604:1: (lv_minVersion_2_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4604:1: (lv_minVersion_2_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4605:3: lv_minVersion_2_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef9614);
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

            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleLowerBoundRangeVersionRef9626); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLowerBoundRangeVersionRefAccess().getCommaKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4625:1: (otherlv_4= 'maxVersion' otherlv_5= '<' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4625:3: otherlv_4= 'maxVersion' otherlv_5= '<'
            {
            otherlv_4=(Token)match(input,102,FollowSets000.FOLLOW_102_in_ruleLowerBoundRangeVersionRef9639); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionKeyword_3_0());
                  
            }
            otherlv_5=(Token)match(input,104,FollowSets000.FOLLOW_104_in_ruleLowerBoundRangeVersionRef9651); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLowerBoundRangeVersionRefAccess().getLessThanSignKeyword_3_1());
                  
            }

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4633:2: ( (lv_maxVersion_6_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4634:1: (lv_maxVersion_6_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4634:1: (lv_maxVersion_6_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4635:3: lv_maxVersion_6_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionVersionIdParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef9673);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4659:1: entryRuleMajorVersionRef returns [EObject current=null] : iv_ruleMajorVersionRef= ruleMajorVersionRef EOF ;
    public final EObject entryRuleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMajorVersionRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4660:2: (iv_ruleMajorVersionRef= ruleMajorVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4661:2: iv_ruleMajorVersionRef= ruleMajorVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMajorVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef9709);
            iv_ruleMajorVersionRef=ruleMajorVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMajorVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMajorVersionRef9719); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4668:1: ruleMajorVersionRef returns [EObject current=null] : (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) ;
    public final EObject ruleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_majorVersion_1_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4671:28: ( (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4672:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4672:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4672:3: otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,105,FollowSets000.FOLLOW_105_in_ruleMajorVersionRef9756); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMajorVersionRefAccess().getMajorVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4676:1: ( (lv_majorVersion_1_0= RULE_INT ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4677:1: (lv_majorVersion_1_0= RULE_INT )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4677:1: (lv_majorVersion_1_0= RULE_INT )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4678:3: lv_majorVersion_1_0= RULE_INT
            {
            lv_majorVersion_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMajorVersionRef9773); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4702:1: entryRuleFixedVersionRef returns [EObject current=null] : iv_ruleFixedVersionRef= ruleFixedVersionRef EOF ;
    public final EObject entryRuleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedVersionRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4703:2: (iv_ruleFixedVersionRef= ruleFixedVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4704:2: iv_ruleFixedVersionRef= ruleFixedVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFixedVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef9814);
            iv_ruleFixedVersionRef=ruleFixedVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFixedVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFixedVersionRef9824); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4711:1: ruleFixedVersionRef returns [EObject current=null] : (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_fixedVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4714:28: ( (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4715:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4715:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4715:3: otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,106,FollowSets000.FOLLOW_106_in_ruleFixedVersionRef9861); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFixedVersionRefAccess().getFixedVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4719:1: ( (lv_fixedVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4720:1: (lv_fixedVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4720:1: (lv_fixedVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4721:3: lv_fixedVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFixedVersionRefAccess().getFixedVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleFixedVersionRef9882);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4745:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4746:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4747:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard9919);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard9930); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4754:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4757:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4758:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4758:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4759:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard9977);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4769:1: (kw= '.*' )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==107) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4770:2: kw= '.*'
                    {
                    kw=(Token)match(input,107,FollowSets000.FOLLOW_107_in_ruleQualifiedNameWithWildCard9996); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4783:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4784:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4785:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10039);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName10050); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4792:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4795:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4796:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4796:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4796:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName10090); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4803:1: (kw= '.' this_ID_2= RULE_ID )*
            loop113:
            do {
                int alt113=2;
                int LA113_0 = input.LA(1);

                if ( (LA113_0==96) ) {
                    alt113=1;
                }


                switch (alt113) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4804:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,96,FollowSets000.FOLLOW_96_in_ruleQualifiedName10109); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName10124); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop113;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4824:1: entryRuleGovernanceDecision returns [EObject current=null] : iv_ruleGovernanceDecision= ruleGovernanceDecision EOF ;
    public final EObject entryRuleGovernanceDecision() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGovernanceDecision = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4825:2: (iv_ruleGovernanceDecision= ruleGovernanceDecision EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4826:2: iv_ruleGovernanceDecision= ruleGovernanceDecision EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGovernanceDecisionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGovernanceDecision_in_entryRuleGovernanceDecision10171);
            iv_ruleGovernanceDecision=ruleGovernanceDecision();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGovernanceDecision; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGovernanceDecision10181); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4833:1: ruleGovernanceDecision returns [EObject current=null] : (otherlv_0= 'governance-decision' otherlv_1= '{' (otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) ) ) (otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) ) ) (otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) ) )? (otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) ) )? (otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) ) )? (otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) ) )? (otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) ) )? otherlv_16= '}' ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4836:28: ( (otherlv_0= 'governance-decision' otherlv_1= '{' (otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) ) ) (otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) ) ) (otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) ) )? (otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) ) )? (otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) ) )? (otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) ) )? (otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) ) )? otherlv_16= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4837:1: (otherlv_0= 'governance-decision' otherlv_1= '{' (otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) ) ) (otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) ) ) (otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) ) )? (otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) ) )? (otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) ) )? (otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) ) )? (otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) ) )? otherlv_16= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4837:1: (otherlv_0= 'governance-decision' otherlv_1= '{' (otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) ) ) (otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) ) ) (otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) ) )? (otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) ) )? (otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) ) )? (otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) ) )? (otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) ) )? otherlv_16= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4837:3: otherlv_0= 'governance-decision' otherlv_1= '{' (otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) ) ) (otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) ) ) (otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) ) )? (otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) ) )? (otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) ) )? (otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) ) )? (otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) ) )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,108,FollowSets000.FOLLOW_108_in_ruleGovernanceDecision10218); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getGovernanceDecisionAccess().getGovernanceDecisionKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleGovernanceDecision10230); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getGovernanceDecisionAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4845:1: (otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4845:3: otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) )
            {
            otherlv_2=(Token)match(input,109,FollowSets000.FOLLOW_109_in_ruleGovernanceDecision10243); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getGovernanceDecisionAccess().getSubjectKeyword_2_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4849:1: ( (lv_subject_3_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4850:1: (lv_subject_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4850:1: (lv_subject_3_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4851:3: lv_subject_3_0= RULE_STRING
            {
            lv_subject_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGovernanceDecision10260); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4867:3: (otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4867:5: otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) )
            {
            otherlv_4=(Token)match(input,110,FollowSets000.FOLLOW_110_in_ruleGovernanceDecision10279); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getGovernanceDecisionAccess().getDecisionResultKeyword_3_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4871:1: ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4872:1: (lv_decisionResult_5_0= ruleGovernanceDecisionResult )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4872:1: (lv_decisionResult_5_0= ruleGovernanceDecisionResult )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4873:3: lv_decisionResult_5_0= ruleGovernanceDecisionResult
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGovernanceDecisionAccess().getDecisionResultGovernanceDecisionResultEnumRuleCall_3_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleGovernanceDecisionResult_in_ruleGovernanceDecision10300);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4889:3: (otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) ) )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==111) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4889:5: otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,111,FollowSets000.FOLLOW_111_in_ruleGovernanceDecision10314); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getGovernanceDecisionAccess().getSpecificResultKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4893:1: ( (lv_specificResult_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4894:1: (lv_specificResult_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4894:1: (lv_specificResult_7_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4895:3: lv_specificResult_7_0= RULE_STRING
                    {
                    lv_specificResult_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGovernanceDecision10331); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4911:4: (otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) ) )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==112) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4911:6: otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,112,FollowSets000.FOLLOW_112_in_ruleGovernanceDecision10351); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getGovernanceDecisionAccess().getJustificationDocKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4915:1: ( (lv_justificationOrDocURL_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4916:1: (lv_justificationOrDocURL_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4916:1: (lv_justificationOrDocURL_9_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4917:3: lv_justificationOrDocURL_9_0= RULE_STRING
                    {
                    lv_justificationOrDocURL_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGovernanceDecision10368); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4933:4: (otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) ) )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==113) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4933:6: otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) )
                    {
                    otherlv_10=(Token)match(input,113,FollowSets000.FOLLOW_113_in_ruleGovernanceDecision10388); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getGovernanceDecisionAccess().getDecisionDateKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4937:1: ( (lv_approvalDate_11_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4938:1: (lv_approvalDate_11_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4938:1: (lv_approvalDate_11_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4939:3: lv_approvalDate_11_0= RULE_STRING
                    {
                    lv_approvalDate_11_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGovernanceDecision10405); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4955:4: (otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) ) )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==114) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4955:6: otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) )
                    {
                    otherlv_12=(Token)match(input,114,FollowSets000.FOLLOW_114_in_ruleGovernanceDecision10425); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getGovernanceDecisionAccess().getDecisionByKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4959:1: ( (lv_approvedBy_13_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4960:1: (lv_approvedBy_13_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4960:1: (lv_approvedBy_13_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4961:3: lv_approvedBy_13_0= RULE_STRING
                    {
                    lv_approvedBy_13_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGovernanceDecision10442); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4977:4: (otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) ) )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==115) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4977:6: otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) )
                    {
                    otherlv_14=(Token)match(input,115,FollowSets000.FOLLOW_115_in_ruleGovernanceDecision10462); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getGovernanceDecisionAccess().getEffectiveDateKeyword_8_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4981:1: ( (lv_effectiveDate_15_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4982:1: (lv_effectiveDate_15_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4982:1: (lv_effectiveDate_15_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4983:3: lv_effectiveDate_15_0= RULE_STRING
                    {
                    lv_effectiveDate_15_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGovernanceDecision10479); if (state.failed) return current;
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

            otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleGovernanceDecision10498); if (state.failed) return current;
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


    // $ANTLR start "ruleSOAPStyle"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5013:1: ruleSOAPStyle returns [Enumerator current=null] : ( (enumLiteral_0= 'document/literal-wrapped' ) | (enumLiteral_1= 'rpc/literal' ) | (enumLiteral_2= 'rpc/encoded' ) ) ;
    public final Enumerator ruleSOAPStyle() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5015:28: ( ( (enumLiteral_0= 'document/literal-wrapped' ) | (enumLiteral_1= 'rpc/literal' ) | (enumLiteral_2= 'rpc/encoded' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5016:1: ( (enumLiteral_0= 'document/literal-wrapped' ) | (enumLiteral_1= 'rpc/literal' ) | (enumLiteral_2= 'rpc/encoded' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5016:1: ( (enumLiteral_0= 'document/literal-wrapped' ) | (enumLiteral_1= 'rpc/literal' ) | (enumLiteral_2= 'rpc/encoded' ) )
            int alt119=3;
            switch ( input.LA(1) ) {
            case 116:
                {
                alt119=1;
                }
                break;
            case 117:
                {
                alt119=2;
                }
                break;
            case 118:
                {
                alt119=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 119, 0, input);

                throw nvae;
            }

            switch (alt119) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5016:2: (enumLiteral_0= 'document/literal-wrapped' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5016:2: (enumLiteral_0= 'document/literal-wrapped' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5016:4: enumLiteral_0= 'document/literal-wrapped'
                    {
                    enumLiteral_0=(Token)match(input,116,FollowSets000.FOLLOW_116_in_ruleSOAPStyle10550); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSOAPStyleAccess().getDoclitwrapEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getSOAPStyleAccess().getDoclitwrapEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5022:6: (enumLiteral_1= 'rpc/literal' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5022:6: (enumLiteral_1= 'rpc/literal' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5022:8: enumLiteral_1= 'rpc/literal'
                    {
                    enumLiteral_1=(Token)match(input,117,FollowSets000.FOLLOW_117_in_ruleSOAPStyle10567); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSOAPStyleAccess().getRpclitEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getSOAPStyleAccess().getRpclitEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5028:6: (enumLiteral_2= 'rpc/encoded' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5028:6: (enumLiteral_2= 'rpc/encoded' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5028:8: enumLiteral_2= 'rpc/encoded'
                    {
                    enumLiteral_2=(Token)match(input,118,FollowSets000.FOLLOW_118_in_ruleSOAPStyle10584); if (state.failed) return current;
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


    // $ANTLR start "ruleSAPTransport"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5038:1: ruleSAPTransport returns [Enumerator current=null] : ( (enumLiteral_0= 'IDOC' ) | (enumLiteral_1= 'RFC' ) ) ;
    public final Enumerator ruleSAPTransport() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5040:28: ( ( (enumLiteral_0= 'IDOC' ) | (enumLiteral_1= 'RFC' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5041:1: ( (enumLiteral_0= 'IDOC' ) | (enumLiteral_1= 'RFC' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5041:1: ( (enumLiteral_0= 'IDOC' ) | (enumLiteral_1= 'RFC' ) )
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==119) ) {
                alt120=1;
            }
            else if ( (LA120_0==120) ) {
                alt120=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 120, 0, input);

                throw nvae;
            }
            switch (alt120) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5041:2: (enumLiteral_0= 'IDOC' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5041:2: (enumLiteral_0= 'IDOC' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5041:4: enumLiteral_0= 'IDOC'
                    {
                    enumLiteral_0=(Token)match(input,119,FollowSets000.FOLLOW_119_in_ruleSAPTransport10629); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSAPTransportAccess().getIDOCEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getSAPTransportAccess().getIDOCEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5047:6: (enumLiteral_1= 'RFC' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5047:6: (enumLiteral_1= 'RFC' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5047:8: enumLiteral_1= 'RFC'
                    {
                    enumLiteral_1=(Token)match(input,120,FollowSets000.FOLLOW_120_in_ruleSAPTransport10646); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5057:1: ruleRESTFormat returns [Enumerator current=null] : ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'XML' ) | (enumLiteral_2= 'BISON' ) | (enumLiteral_3= 'OTHER' ) ) ;
    public final Enumerator ruleRESTFormat() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5059:28: ( ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'XML' ) | (enumLiteral_2= 'BISON' ) | (enumLiteral_3= 'OTHER' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5060:1: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'XML' ) | (enumLiteral_2= 'BISON' ) | (enumLiteral_3= 'OTHER' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5060:1: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'XML' ) | (enumLiteral_2= 'BISON' ) | (enumLiteral_3= 'OTHER' ) )
            int alt121=4;
            switch ( input.LA(1) ) {
            case 121:
                {
                alt121=1;
                }
                break;
            case 122:
                {
                alt121=2;
                }
                break;
            case 123:
                {
                alt121=3;
                }
                break;
            case 124:
                {
                alt121=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);

                throw nvae;
            }

            switch (alt121) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5060:2: (enumLiteral_0= 'JSON' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5060:2: (enumLiteral_0= 'JSON' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5060:4: enumLiteral_0= 'JSON'
                    {
                    enumLiteral_0=(Token)match(input,121,FollowSets000.FOLLOW_121_in_ruleRESTFormat10691); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRESTFormatAccess().getJSONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getRESTFormatAccess().getJSONEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5066:6: (enumLiteral_1= 'XML' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5066:6: (enumLiteral_1= 'XML' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5066:8: enumLiteral_1= 'XML'
                    {
                    enumLiteral_1=(Token)match(input,122,FollowSets000.FOLLOW_122_in_ruleRESTFormat10708); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRESTFormatAccess().getXMLEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getRESTFormatAccess().getXMLEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5072:6: (enumLiteral_2= 'BISON' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5072:6: (enumLiteral_2= 'BISON' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5072:8: enumLiteral_2= 'BISON'
                    {
                    enumLiteral_2=(Token)match(input,123,FollowSets000.FOLLOW_123_in_ruleRESTFormat10725); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRESTFormatAccess().getBISONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getRESTFormatAccess().getBISONEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5078:6: (enumLiteral_3= 'OTHER' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5078:6: (enumLiteral_3= 'OTHER' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5078:8: enumLiteral_3= 'OTHER'
                    {
                    enumLiteral_3=(Token)match(input,124,FollowSets000.FOLLOW_124_in_ruleRESTFormat10742); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5088:1: ruleVerb returns [Enumerator current=null] : ( (enumLiteral_0= 'CREATE' ) | (enumLiteral_1= 'RETRIEVE' ) | (enumLiteral_2= 'UPDATE' ) | (enumLiteral_3= 'DELETE' ) | (enumLiteral_4= 'GET' ) | (enumLiteral_5= 'PUT' ) | (enumLiteral_6= 'POST' ) ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5090:28: ( ( (enumLiteral_0= 'CREATE' ) | (enumLiteral_1= 'RETRIEVE' ) | (enumLiteral_2= 'UPDATE' ) | (enumLiteral_3= 'DELETE' ) | (enumLiteral_4= 'GET' ) | (enumLiteral_5= 'PUT' ) | (enumLiteral_6= 'POST' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5091:1: ( (enumLiteral_0= 'CREATE' ) | (enumLiteral_1= 'RETRIEVE' ) | (enumLiteral_2= 'UPDATE' ) | (enumLiteral_3= 'DELETE' ) | (enumLiteral_4= 'GET' ) | (enumLiteral_5= 'PUT' ) | (enumLiteral_6= 'POST' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5091:1: ( (enumLiteral_0= 'CREATE' ) | (enumLiteral_1= 'RETRIEVE' ) | (enumLiteral_2= 'UPDATE' ) | (enumLiteral_3= 'DELETE' ) | (enumLiteral_4= 'GET' ) | (enumLiteral_5= 'PUT' ) | (enumLiteral_6= 'POST' ) )
            int alt122=7;
            switch ( input.LA(1) ) {
            case 125:
                {
                alt122=1;
                }
                break;
            case 126:
                {
                alt122=2;
                }
                break;
            case 127:
                {
                alt122=3;
                }
                break;
            case 128:
                {
                alt122=4;
                }
                break;
            case 129:
                {
                alt122=5;
                }
                break;
            case 130:
                {
                alt122=6;
                }
                break;
            case 131:
                {
                alt122=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);

                throw nvae;
            }

            switch (alt122) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5091:2: (enumLiteral_0= 'CREATE' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5091:2: (enumLiteral_0= 'CREATE' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5091:4: enumLiteral_0= 'CREATE'
                    {
                    enumLiteral_0=(Token)match(input,125,FollowSets000.FOLLOW_125_in_ruleVerb10787); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getCREATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getVerbAccess().getCREATEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5097:6: (enumLiteral_1= 'RETRIEVE' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5097:6: (enumLiteral_1= 'RETRIEVE' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5097:8: enumLiteral_1= 'RETRIEVE'
                    {
                    enumLiteral_1=(Token)match(input,126,FollowSets000.FOLLOW_126_in_ruleVerb10804); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getRETRIEVEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getVerbAccess().getRETRIEVEEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5103:6: (enumLiteral_2= 'UPDATE' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5103:6: (enumLiteral_2= 'UPDATE' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5103:8: enumLiteral_2= 'UPDATE'
                    {
                    enumLiteral_2=(Token)match(input,127,FollowSets000.FOLLOW_127_in_ruleVerb10821); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getUPDATEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getVerbAccess().getUPDATEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5109:6: (enumLiteral_3= 'DELETE' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5109:6: (enumLiteral_3= 'DELETE' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5109:8: enumLiteral_3= 'DELETE'
                    {
                    enumLiteral_3=(Token)match(input,128,FollowSets000.FOLLOW_128_in_ruleVerb10838); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getDELETEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getVerbAccess().getDELETEEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5115:6: (enumLiteral_4= 'GET' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5115:6: (enumLiteral_4= 'GET' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5115:8: enumLiteral_4= 'GET'
                    {
                    enumLiteral_4=(Token)match(input,129,FollowSets000.FOLLOW_129_in_ruleVerb10855); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getGETEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getVerbAccess().getGETEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5121:6: (enumLiteral_5= 'PUT' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5121:6: (enumLiteral_5= 'PUT' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5121:8: enumLiteral_5= 'PUT'
                    {
                    enumLiteral_5=(Token)match(input,130,FollowSets000.FOLLOW_130_in_ruleVerb10872); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getPUTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getVerbAccess().getPUTEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5127:6: (enumLiteral_6= 'POST' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5127:6: (enumLiteral_6= 'POST' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5127:8: enumLiteral_6= 'POST'
                    {
                    enumLiteral_6=(Token)match(input,131,FollowSets000.FOLLOW_131_in_ruleVerb10889); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5137:1: ruleReadWrite returns [Enumerator current=null] : ( (enumLiteral_0= 'read' ) | (enumLiteral_1= 'write' ) ) ;
    public final Enumerator ruleReadWrite() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5139:28: ( ( (enumLiteral_0= 'read' ) | (enumLiteral_1= 'write' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5140:1: ( (enumLiteral_0= 'read' ) | (enumLiteral_1= 'write' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5140:1: ( (enumLiteral_0= 'read' ) | (enumLiteral_1= 'write' ) )
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==132) ) {
                alt123=1;
            }
            else if ( (LA123_0==133) ) {
                alt123=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;
            }
            switch (alt123) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5140:2: (enumLiteral_0= 'read' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5140:2: (enumLiteral_0= 'read' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5140:4: enumLiteral_0= 'read'
                    {
                    enumLiteral_0=(Token)match(input,132,FollowSets000.FOLLOW_132_in_ruleReadWrite10934); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReadWriteAccess().getReadEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getReadWriteAccess().getReadEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5146:6: (enumLiteral_1= 'write' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5146:6: (enumLiteral_1= 'write' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5146:8: enumLiteral_1= 'write'
                    {
                    enumLiteral_1=(Token)match(input,133,FollowSets000.FOLLOW_133_in_ruleReadWrite10951); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5156:1: ruleHashAlgKind returns [Enumerator current=null] : ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'RSA' ) | (enumLiteral_4= 'PlainText' ) ) ;
    public final Enumerator ruleHashAlgKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5158:28: ( ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'RSA' ) | (enumLiteral_4= 'PlainText' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5159:1: ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'RSA' ) | (enumLiteral_4= 'PlainText' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5159:1: ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'RSA' ) | (enumLiteral_4= 'PlainText' ) )
            int alt124=5;
            switch ( input.LA(1) ) {
            case 134:
                {
                alt124=1;
                }
                break;
            case 135:
                {
                alt124=2;
                }
                break;
            case 136:
                {
                alt124=3;
                }
                break;
            case 137:
                {
                alt124=4;
                }
                break;
            case 138:
                {
                alt124=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 124, 0, input);

                throw nvae;
            }

            switch (alt124) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5159:2: (enumLiteral_0= 'MD5' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5159:2: (enumLiteral_0= 'MD5' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5159:4: enumLiteral_0= 'MD5'
                    {
                    enumLiteral_0=(Token)match(input,134,FollowSets000.FOLLOW_134_in_ruleHashAlgKind10996); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getMD5EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getHashAlgKindAccess().getMD5EnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5165:6: (enumLiteral_1= 'SHA1' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5165:6: (enumLiteral_1= 'SHA1' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5165:8: enumLiteral_1= 'SHA1'
                    {
                    enumLiteral_1=(Token)match(input,135,FollowSets000.FOLLOW_135_in_ruleHashAlgKind11013); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getSHA1EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getHashAlgKindAccess().getSHA1EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5171:6: (enumLiteral_2= 'SHA256' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5171:6: (enumLiteral_2= 'SHA256' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5171:8: enumLiteral_2= 'SHA256'
                    {
                    enumLiteral_2=(Token)match(input,136,FollowSets000.FOLLOW_136_in_ruleHashAlgKind11030); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getSHA256EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getHashAlgKindAccess().getSHA256EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5177:6: (enumLiteral_3= 'RSA' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5177:6: (enumLiteral_3= 'RSA' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5177:8: enumLiteral_3= 'RSA'
                    {
                    enumLiteral_3=(Token)match(input,137,FollowSets000.FOLLOW_137_in_ruleHashAlgKind11047); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getRSAEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getHashAlgKindAccess().getRSAEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5183:6: (enumLiteral_4= 'PlainText' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5183:6: (enumLiteral_4= 'PlainText' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5183:8: enumLiteral_4= 'PlainText'
                    {
                    enumLiteral_4=(Token)match(input,138,FollowSets000.FOLLOW_138_in_ruleHashAlgKind11064); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5193:1: ruleMessagePartRefKind returns [Enumerator current=null] : ( (enumLiteral_0= 'header' ) | (enumLiteral_1= 'body' ) | (enumLiteral_2= 'attachments' ) | (enumLiteral_3= 'all' ) | (enumLiteral_4= 'expression' ) ) ;
    public final Enumerator ruleMessagePartRefKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5195:28: ( ( (enumLiteral_0= 'header' ) | (enumLiteral_1= 'body' ) | (enumLiteral_2= 'attachments' ) | (enumLiteral_3= 'all' ) | (enumLiteral_4= 'expression' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5196:1: ( (enumLiteral_0= 'header' ) | (enumLiteral_1= 'body' ) | (enumLiteral_2= 'attachments' ) | (enumLiteral_3= 'all' ) | (enumLiteral_4= 'expression' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5196:1: ( (enumLiteral_0= 'header' ) | (enumLiteral_1= 'body' ) | (enumLiteral_2= 'attachments' ) | (enumLiteral_3= 'all' ) | (enumLiteral_4= 'expression' ) )
            int alt125=5;
            switch ( input.LA(1) ) {
            case 139:
                {
                alt125=1;
                }
                break;
            case 140:
                {
                alt125=2;
                }
                break;
            case 141:
                {
                alt125=3;
                }
                break;
            case 142:
                {
                alt125=4;
                }
                break;
            case 79:
                {
                alt125=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 125, 0, input);

                throw nvae;
            }

            switch (alt125) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5196:2: (enumLiteral_0= 'header' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5196:2: (enumLiteral_0= 'header' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5196:4: enumLiteral_0= 'header'
                    {
                    enumLiteral_0=(Token)match(input,139,FollowSets000.FOLLOW_139_in_ruleMessagePartRefKind11109); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getHeaderEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getMessagePartRefKindAccess().getHeaderEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5202:6: (enumLiteral_1= 'body' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5202:6: (enumLiteral_1= 'body' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5202:8: enumLiteral_1= 'body'
                    {
                    enumLiteral_1=(Token)match(input,140,FollowSets000.FOLLOW_140_in_ruleMessagePartRefKind11126); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getBodyEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getMessagePartRefKindAccess().getBodyEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5208:6: (enumLiteral_2= 'attachments' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5208:6: (enumLiteral_2= 'attachments' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5208:8: enumLiteral_2= 'attachments'
                    {
                    enumLiteral_2=(Token)match(input,141,FollowSets000.FOLLOW_141_in_ruleMessagePartRefKind11143); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getAttachmentsEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getMessagePartRefKindAccess().getAttachmentsEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5214:6: (enumLiteral_3= 'all' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5214:6: (enumLiteral_3= 'all' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5214:8: enumLiteral_3= 'all'
                    {
                    enumLiteral_3=(Token)match(input,142,FollowSets000.FOLLOW_142_in_ruleMessagePartRefKind11160); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getMessagePartRefKindAccess().getAllEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getMessagePartRefKindAccess().getAllEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5220:6: (enumLiteral_4= 'expression' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5220:6: (enumLiteral_4= 'expression' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5220:8: enumLiteral_4= 'expression'
                    {
                    enumLiteral_4=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleMessagePartRefKind11177); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5230:1: ruleSigningAlgothm returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'MD5' ) | (enumLiteral_4= 'RSA_1_5' ) | (enumLiteral_5= 'AES128' ) | (enumLiteral_6= 'AES192' ) | (enumLiteral_7= 'AES256' ) ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5232:28: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'MD5' ) | (enumLiteral_4= 'RSA_1_5' ) | (enumLiteral_5= 'AES128' ) | (enumLiteral_6= 'AES192' ) | (enumLiteral_7= 'AES256' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5233:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'MD5' ) | (enumLiteral_4= 'RSA_1_5' ) | (enumLiteral_5= 'AES128' ) | (enumLiteral_6= 'AES192' ) | (enumLiteral_7= 'AES256' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5233:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'MD5' ) | (enumLiteral_4= 'RSA_1_5' ) | (enumLiteral_5= 'AES128' ) | (enumLiteral_6= 'AES192' ) | (enumLiteral_7= 'AES256' ) )
            int alt126=8;
            switch ( input.LA(1) ) {
            case 143:
                {
                alt126=1;
                }
                break;
            case 135:
                {
                alt126=2;
                }
                break;
            case 136:
                {
                alt126=3;
                }
                break;
            case 134:
                {
                alt126=4;
                }
                break;
            case 144:
                {
                alt126=5;
                }
                break;
            case 145:
                {
                alt126=6;
                }
                break;
            case 146:
                {
                alt126=7;
                }
                break;
            case 147:
                {
                alt126=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 126, 0, input);

                throw nvae;
            }

            switch (alt126) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5233:2: (enumLiteral_0= 'NONE' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5233:2: (enumLiteral_0= 'NONE' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5233:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,143,FollowSets000.FOLLOW_143_in_ruleSigningAlgothm11222); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getSigningAlgothmAccess().getNONEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5239:6: (enumLiteral_1= 'SHA1' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5239:6: (enumLiteral_1= 'SHA1' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5239:8: enumLiteral_1= 'SHA1'
                    {
                    enumLiteral_1=(Token)match(input,135,FollowSets000.FOLLOW_135_in_ruleSigningAlgothm11239); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getSHA1EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getSigningAlgothmAccess().getSHA1EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5245:6: (enumLiteral_2= 'SHA256' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5245:6: (enumLiteral_2= 'SHA256' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5245:8: enumLiteral_2= 'SHA256'
                    {
                    enumLiteral_2=(Token)match(input,136,FollowSets000.FOLLOW_136_in_ruleSigningAlgothm11256); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getSHA256EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getSigningAlgothmAccess().getSHA256EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5251:6: (enumLiteral_3= 'MD5' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5251:6: (enumLiteral_3= 'MD5' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5251:8: enumLiteral_3= 'MD5'
                    {
                    enumLiteral_3=(Token)match(input,134,FollowSets000.FOLLOW_134_in_ruleSigningAlgothm11273); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getMD5EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getSigningAlgothmAccess().getMD5EnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5257:6: (enumLiteral_4= 'RSA_1_5' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5257:6: (enumLiteral_4= 'RSA_1_5' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5257:8: enumLiteral_4= 'RSA_1_5'
                    {
                    enumLiteral_4=(Token)match(input,144,FollowSets000.FOLLOW_144_in_ruleSigningAlgothm11290); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getRSA_1_5EnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getSigningAlgothmAccess().getRSA_1_5EnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5263:6: (enumLiteral_5= 'AES128' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5263:6: (enumLiteral_5= 'AES128' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5263:8: enumLiteral_5= 'AES128'
                    {
                    enumLiteral_5=(Token)match(input,145,FollowSets000.FOLLOW_145_in_ruleSigningAlgothm11307); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getAES128EnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getSigningAlgothmAccess().getAES128EnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5269:6: (enumLiteral_6= 'AES192' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5269:6: (enumLiteral_6= 'AES192' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5269:8: enumLiteral_6= 'AES192'
                    {
                    enumLiteral_6=(Token)match(input,146,FollowSets000.FOLLOW_146_in_ruleSigningAlgothm11324); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSigningAlgothmAccess().getAES192EnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getSigningAlgothmAccess().getAES192EnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5275:6: (enumLiteral_7= 'AES256' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5275:6: (enumLiteral_7= 'AES256' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5275:8: enumLiteral_7= 'AES256'
                    {
                    enumLiteral_7=(Token)match(input,147,FollowSets000.FOLLOW_147_in_ruleSigningAlgothm11341); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5285:1: ruleCipherAlgorithmKind returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'Basic128' ) | (enumLiteral_2= 'Basic192' ) | (enumLiteral_3= 'Basic256' ) | (enumLiteral_4= 'DES' ) | (enumLiteral_5= '3DES' ) | (enumLiteral_6= 'AES128' ) | (enumLiteral_7= 'AES256' ) ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5287:28: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'Basic128' ) | (enumLiteral_2= 'Basic192' ) | (enumLiteral_3= 'Basic256' ) | (enumLiteral_4= 'DES' ) | (enumLiteral_5= '3DES' ) | (enumLiteral_6= 'AES128' ) | (enumLiteral_7= 'AES256' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5288:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'Basic128' ) | (enumLiteral_2= 'Basic192' ) | (enumLiteral_3= 'Basic256' ) | (enumLiteral_4= 'DES' ) | (enumLiteral_5= '3DES' ) | (enumLiteral_6= 'AES128' ) | (enumLiteral_7= 'AES256' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5288:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'Basic128' ) | (enumLiteral_2= 'Basic192' ) | (enumLiteral_3= 'Basic256' ) | (enumLiteral_4= 'DES' ) | (enumLiteral_5= '3DES' ) | (enumLiteral_6= 'AES128' ) | (enumLiteral_7= 'AES256' ) )
            int alt127=8;
            switch ( input.LA(1) ) {
            case 143:
                {
                alt127=1;
                }
                break;
            case 148:
                {
                alt127=2;
                }
                break;
            case 149:
                {
                alt127=3;
                }
                break;
            case 150:
                {
                alt127=4;
                }
                break;
            case 151:
                {
                alt127=5;
                }
                break;
            case 152:
                {
                alt127=6;
                }
                break;
            case 145:
                {
                alt127=7;
                }
                break;
            case 147:
                {
                alt127=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 127, 0, input);

                throw nvae;
            }

            switch (alt127) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5288:2: (enumLiteral_0= 'NONE' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5288:2: (enumLiteral_0= 'NONE' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5288:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,143,FollowSets000.FOLLOW_143_in_ruleCipherAlgorithmKind11386); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getCipherAlgorithmKindAccess().getNONEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5294:6: (enumLiteral_1= 'Basic128' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5294:6: (enumLiteral_1= 'Basic128' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5294:8: enumLiteral_1= 'Basic128'
                    {
                    enumLiteral_1=(Token)match(input,148,FollowSets000.FOLLOW_148_in_ruleCipherAlgorithmKind11403); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getBasic128EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getCipherAlgorithmKindAccess().getBasic128EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5300:6: (enumLiteral_2= 'Basic192' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5300:6: (enumLiteral_2= 'Basic192' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5300:8: enumLiteral_2= 'Basic192'
                    {
                    enumLiteral_2=(Token)match(input,149,FollowSets000.FOLLOW_149_in_ruleCipherAlgorithmKind11420); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getBasic192EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getCipherAlgorithmKindAccess().getBasic192EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5306:6: (enumLiteral_3= 'Basic256' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5306:6: (enumLiteral_3= 'Basic256' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5306:8: enumLiteral_3= 'Basic256'
                    {
                    enumLiteral_3=(Token)match(input,150,FollowSets000.FOLLOW_150_in_ruleCipherAlgorithmKind11437); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getBasic256EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getCipherAlgorithmKindAccess().getBasic256EnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5312:6: (enumLiteral_4= 'DES' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5312:6: (enumLiteral_4= 'DES' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5312:8: enumLiteral_4= 'DES'
                    {
                    enumLiteral_4=(Token)match(input,151,FollowSets000.FOLLOW_151_in_ruleCipherAlgorithmKind11454); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getDESEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getCipherAlgorithmKindAccess().getDESEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5318:6: (enumLiteral_5= '3DES' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5318:6: (enumLiteral_5= '3DES' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5318:8: enumLiteral_5= '3DES'
                    {
                    enumLiteral_5=(Token)match(input,152,FollowSets000.FOLLOW_152_in_ruleCipherAlgorithmKind11471); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getTRIPLE_DESEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getCipherAlgorithmKindAccess().getTRIPLE_DESEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5324:6: (enumLiteral_6= 'AES128' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5324:6: (enumLiteral_6= 'AES128' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5324:8: enumLiteral_6= 'AES128'
                    {
                    enumLiteral_6=(Token)match(input,145,FollowSets000.FOLLOW_145_in_ruleCipherAlgorithmKind11488); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCipherAlgorithmKindAccess().getAES128EnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getCipherAlgorithmKindAccess().getAES128EnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5330:6: (enumLiteral_7= 'AES256' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5330:6: (enumLiteral_7= 'AES256' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5330:8: enumLiteral_7= 'AES256'
                    {
                    enumLiteral_7=(Token)match(input,147,FollowSets000.FOLLOW_147_in_ruleCipherAlgorithmKind11505); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5340:1: ruleAuthTokenKind returns [Enumerator current=null] : ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'SPNEGO' ) | (enumLiteral_5= 'RELToken' ) | (enumLiteral_6= 'X509Certificate' ) | (enumLiteral_7= 'OAuth' ) | (enumLiteral_8= 'OAuth2' ) ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5342:28: ( ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'SPNEGO' ) | (enumLiteral_5= 'RELToken' ) | (enumLiteral_6= 'X509Certificate' ) | (enumLiteral_7= 'OAuth' ) | (enumLiteral_8= 'OAuth2' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5343:1: ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'SPNEGO' ) | (enumLiteral_5= 'RELToken' ) | (enumLiteral_6= 'X509Certificate' ) | (enumLiteral_7= 'OAuth' ) | (enumLiteral_8= 'OAuth2' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5343:1: ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'SPNEGO' ) | (enumLiteral_5= 'RELToken' ) | (enumLiteral_6= 'X509Certificate' ) | (enumLiteral_7= 'OAuth' ) | (enumLiteral_8= 'OAuth2' ) )
            int alt128=9;
            switch ( input.LA(1) ) {
            case 153:
                {
                alt128=1;
                }
                break;
            case 154:
                {
                alt128=2;
                }
                break;
            case 155:
                {
                alt128=3;
                }
                break;
            case 156:
                {
                alt128=4;
                }
                break;
            case 157:
                {
                alt128=5;
                }
                break;
            case 158:
                {
                alt128=6;
                }
                break;
            case 159:
                {
                alt128=7;
                }
                break;
            case 160:
                {
                alt128=8;
                }
                break;
            case 161:
                {
                alt128=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 128, 0, input);

                throw nvae;
            }

            switch (alt128) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5343:2: (enumLiteral_0= 'UsernamePassword' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5343:2: (enumLiteral_0= 'UsernamePassword' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5343:4: enumLiteral_0= 'UsernamePassword'
                    {
                    enumLiteral_0=(Token)match(input,153,FollowSets000.FOLLOW_153_in_ruleAuthTokenKind11550); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getUsernamePasswordEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAuthTokenKindAccess().getUsernamePasswordEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5349:6: (enumLiteral_1= 'SAML' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5349:6: (enumLiteral_1= 'SAML' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5349:8: enumLiteral_1= 'SAML'
                    {
                    enumLiteral_1=(Token)match(input,154,FollowSets000.FOLLOW_154_in_ruleAuthTokenKind11567); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSAMLEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getAuthTokenKindAccess().getSAMLEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5355:6: (enumLiteral_2= 'SAML2' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5355:6: (enumLiteral_2= 'SAML2' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5355:8: enumLiteral_2= 'SAML2'
                    {
                    enumLiteral_2=(Token)match(input,155,FollowSets000.FOLLOW_155_in_ruleAuthTokenKind11584); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSAML2EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getAuthTokenKindAccess().getSAML2EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5361:6: (enumLiteral_3= 'Kerberos' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5361:6: (enumLiteral_3= 'Kerberos' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5361:8: enumLiteral_3= 'Kerberos'
                    {
                    enumLiteral_3=(Token)match(input,156,FollowSets000.FOLLOW_156_in_ruleAuthTokenKind11601); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getKerberosEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getAuthTokenKindAccess().getKerberosEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5367:6: (enumLiteral_4= 'SPNEGO' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5367:6: (enumLiteral_4= 'SPNEGO' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5367:8: enumLiteral_4= 'SPNEGO'
                    {
                    enumLiteral_4=(Token)match(input,157,FollowSets000.FOLLOW_157_in_ruleAuthTokenKind11618); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSPNEGOEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getAuthTokenKindAccess().getSPNEGOEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5373:6: (enumLiteral_5= 'RELToken' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5373:6: (enumLiteral_5= 'RELToken' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5373:8: enumLiteral_5= 'RELToken'
                    {
                    enumLiteral_5=(Token)match(input,158,FollowSets000.FOLLOW_158_in_ruleAuthTokenKind11635); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getRELTokenEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getAuthTokenKindAccess().getRELTokenEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5379:6: (enumLiteral_6= 'X509Certificate' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5379:6: (enumLiteral_6= 'X509Certificate' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5379:8: enumLiteral_6= 'X509Certificate'
                    {
                    enumLiteral_6=(Token)match(input,159,FollowSets000.FOLLOW_159_in_ruleAuthTokenKind11652); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getX509CertificateEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getAuthTokenKindAccess().getX509CertificateEnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5385:6: (enumLiteral_7= 'OAuth' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5385:6: (enumLiteral_7= 'OAuth' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5385:8: enumLiteral_7= 'OAuth'
                    {
                    enumLiteral_7=(Token)match(input,160,FollowSets000.FOLLOW_160_in_ruleAuthTokenKind11669); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getOAuthEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_7, grammarAccess.getAuthTokenKindAccess().getOAuthEnumLiteralDeclaration_7()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5391:6: (enumLiteral_8= 'OAuth2' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5391:6: (enumLiteral_8= 'OAuth2' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5391:8: enumLiteral_8= 'OAuth2'
                    {
                    enumLiteral_8=(Token)match(input,161,FollowSets000.FOLLOW_161_in_ruleAuthTokenKind11686); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5401:1: ruleLogPolicyKind returns [Enumerator current=null] : ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'header' ) | (enumLiteral_2= 'all' ) ) ;
    public final Enumerator ruleLogPolicyKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5403:28: ( ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'header' ) | (enumLiteral_2= 'all' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5404:1: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'header' ) | (enumLiteral_2= 'all' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5404:1: ( (enumLiteral_0= 'none' ) | (enumLiteral_1= 'header' ) | (enumLiteral_2= 'all' ) )
            int alt129=3;
            switch ( input.LA(1) ) {
            case 162:
                {
                alt129=1;
                }
                break;
            case 139:
                {
                alt129=2;
                }
                break;
            case 142:
                {
                alt129=3;
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5404:2: (enumLiteral_0= 'none' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5404:2: (enumLiteral_0= 'none' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5404:4: enumLiteral_0= 'none'
                    {
                    enumLiteral_0=(Token)match(input,162,FollowSets000.FOLLOW_162_in_ruleLogPolicyKind11731); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getLogPolicyKindAccess().getNoneEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getLogPolicyKindAccess().getNoneEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5410:6: (enumLiteral_1= 'header' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5410:6: (enumLiteral_1= 'header' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5410:8: enumLiteral_1= 'header'
                    {
                    enumLiteral_1=(Token)match(input,139,FollowSets000.FOLLOW_139_in_ruleLogPolicyKind11748); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getLogPolicyKindAccess().getHeaderEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getLogPolicyKindAccess().getHeaderEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5416:6: (enumLiteral_2= 'all' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5416:6: (enumLiteral_2= 'all' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5416:8: enumLiteral_2= 'all'
                    {
                    enumLiteral_2=(Token)match(input,142,FollowSets000.FOLLOW_142_in_ruleLogPolicyKind11765); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5426:1: ruleReliablilityKind returns [Enumerator current=null] : ( (enumLiteral_0= 'exactly-once' ) | (enumLiteral_1= 'at-most-once' ) | (enumLiteral_2= 'at-least-once' ) | (enumLiteral_3= 'best-effort' ) ) ;
    public final Enumerator ruleReliablilityKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5428:28: ( ( (enumLiteral_0= 'exactly-once' ) | (enumLiteral_1= 'at-most-once' ) | (enumLiteral_2= 'at-least-once' ) | (enumLiteral_3= 'best-effort' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5429:1: ( (enumLiteral_0= 'exactly-once' ) | (enumLiteral_1= 'at-most-once' ) | (enumLiteral_2= 'at-least-once' ) | (enumLiteral_3= 'best-effort' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5429:1: ( (enumLiteral_0= 'exactly-once' ) | (enumLiteral_1= 'at-most-once' ) | (enumLiteral_2= 'at-least-once' ) | (enumLiteral_3= 'best-effort' ) )
            int alt130=4;
            switch ( input.LA(1) ) {
            case 163:
                {
                alt130=1;
                }
                break;
            case 164:
                {
                alt130=2;
                }
                break;
            case 165:
                {
                alt130=3;
                }
                break;
            case 166:
                {
                alt130=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 130, 0, input);

                throw nvae;
            }

            switch (alt130) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5429:2: (enumLiteral_0= 'exactly-once' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5429:2: (enumLiteral_0= 'exactly-once' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5429:4: enumLiteral_0= 'exactly-once'
                    {
                    enumLiteral_0=(Token)match(input,163,FollowSets000.FOLLOW_163_in_ruleReliablilityKind11810); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReliablilityKindAccess().getEXACTLY_ONCEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getReliablilityKindAccess().getEXACTLY_ONCEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5435:6: (enumLiteral_1= 'at-most-once' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5435:6: (enumLiteral_1= 'at-most-once' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5435:8: enumLiteral_1= 'at-most-once'
                    {
                    enumLiteral_1=(Token)match(input,164,FollowSets000.FOLLOW_164_in_ruleReliablilityKind11827); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReliablilityKindAccess().getAT_MOST_ONCEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getReliablilityKindAccess().getAT_MOST_ONCEEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5441:6: (enumLiteral_2= 'at-least-once' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5441:6: (enumLiteral_2= 'at-least-once' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5441:8: enumLiteral_2= 'at-least-once'
                    {
                    enumLiteral_2=(Token)match(input,165,FollowSets000.FOLLOW_165_in_ruleReliablilityKind11844); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReliablilityKindAccess().getAT_LEAST_ONCEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getReliablilityKindAccess().getAT_LEAST_ONCEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5447:6: (enumLiteral_3= 'best-effort' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5447:6: (enumLiteral_3= 'best-effort' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5447:8: enumLiteral_3= 'best-effort'
                    {
                    enumLiteral_3=(Token)match(input,166,FollowSets000.FOLLOW_166_in_ruleReliablilityKind11861); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5457:1: ruleGovernanceDecisionResult returns [Enumerator current=null] : ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) ) ;
    public final Enumerator ruleGovernanceDecisionResult() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5459:28: ( ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5460:1: ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5460:1: ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) )
            int alt131=4;
            switch ( input.LA(1) ) {
            case 167:
                {
                alt131=1;
                }
                break;
            case 168:
                {
                alt131=2;
                }
                break;
            case 169:
                {
                alt131=3;
                }
                break;
            case 170:
                {
                alt131=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 131, 0, input);

                throw nvae;
            }

            switch (alt131) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5460:2: (enumLiteral_0= 'pending' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5460:2: (enumLiteral_0= 'pending' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5460:4: enumLiteral_0= 'pending'
                    {
                    enumLiteral_0=(Token)match(input,167,FollowSets000.FOLLOW_167_in_ruleGovernanceDecisionResult11906); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getPendingEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getGovernanceDecisionResultAccess().getPendingEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5466:6: (enumLiteral_1= 'accepted' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5466:6: (enumLiteral_1= 'accepted' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5466:8: enumLiteral_1= 'accepted'
                    {
                    enumLiteral_1=(Token)match(input,168,FollowSets000.FOLLOW_168_in_ruleGovernanceDecisionResult11923); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getAcceptedEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getGovernanceDecisionResultAccess().getAcceptedEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5472:6: (enumLiteral_2= 'denied' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5472:6: (enumLiteral_2= 'denied' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5472:8: enumLiteral_2= 'denied'
                    {
                    enumLiteral_2=(Token)match(input,169,FollowSets000.FOLLOW_169_in_ruleGovernanceDecisionResult11940); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getDeniedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getGovernanceDecisionResultAccess().getDeniedEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5478:6: (enumLiteral_3= 'specific' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5478:6: (enumLiteral_3= 'specific' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:5478:8: enumLiteral_3= 'specific'
                    {
                    enumLiteral_3=(Token)match(input,170,FollowSets000.FOLLOW_170_in_ruleGovernanceDecisionResult11957); if (state.failed) return current;
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

    // $ANTLR start synpred12_InternalBindingDsl
    public final void synpred12_InternalBindingDsl_fragment() throws RecognitionException {   
        EObject lv_assertions_23_0 = null;


        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:465:1: ( (lv_assertions_23_0= ruleAssertion ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:465:1: (lv_assertions_23_0= ruleAssertion )
        {
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:465:1: (lv_assertions_23_0= ruleAssertion )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:466:3: lv_assertions_23_0= ruleAssertion
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getModuleBindingAccess().getAssertionsAssertionParserRuleCall_10_2_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleAssertion_in_synpred12_InternalBindingDsl924);
        lv_assertions_23_0=ruleAssertion();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred12_InternalBindingDsl

    // $ANTLR start synpred21_InternalBindingDsl
    public final void synpred21_InternalBindingDsl_fragment() throws RecognitionException {   
        EObject lv_assertions_17_0 = null;


        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:739:1: ( (lv_assertions_17_0= ruleAssertion ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:739:1: (lv_assertions_17_0= ruleAssertion )
        {
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:739:1: (lv_assertions_17_0= ruleAssertion )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:740:3: lv_assertions_17_0= ruleAssertion
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getServiceBindingAccess().getAssertionsAssertionParserRuleCall_11_2_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleAssertion_in_synpred21_InternalBindingDsl1454);
        lv_assertions_17_0=ruleAssertion();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred21_InternalBindingDsl

    // $ANTLR start synpred44_InternalBindingDsl
    public final void synpred44_InternalBindingDsl_fragment() throws RecognitionException {   
        EObject lv_assertions_23_0 = null;


        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1236:1: ( (lv_assertions_23_0= ruleAssertion ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1236:1: (lv_assertions_23_0= ruleAssertion )
        {
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1236:1: (lv_assertions_23_0= ruleAssertion )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1237:3: lv_assertions_23_0= ruleAssertion
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getOperationBindingAccess().getAssertionsAssertionParserRuleCall_12_2_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleAssertion_in_synpred44_InternalBindingDsl2506);
        lv_assertions_23_0=ruleAssertion();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred44_InternalBindingDsl

    // $ANTLR start synpred112_InternalBindingDsl
    public final void synpred112_InternalBindingDsl_fragment() throws RecognitionException {   
        EObject this_AvailabilityAssertion_0 = null;


        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3674:2: (this_AvailabilityAssertion_0= ruleAvailabilityAssertion )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3674:2: this_AvailabilityAssertion_0= ruleAvailabilityAssertion
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleAvailabilityAssertion_in_synpred112_InternalBindingDsl7440);
        this_AvailabilityAssertion_0=ruleAvailabilityAssertion();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred112_InternalBindingDsl

    // $ANTLR start synpred113_InternalBindingDsl
    public final void synpred113_InternalBindingDsl_fragment() throws RecognitionException {   
        EObject this_LatencyAssertion_1 = null;


        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3687:2: (this_LatencyAssertion_1= ruleLatencyAssertion )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3687:2: this_LatencyAssertion_1= ruleLatencyAssertion
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleLatencyAssertion_in_synpred113_InternalBindingDsl7470);
        this_LatencyAssertion_1=ruleLatencyAssertion();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred113_InternalBindingDsl

    // $ANTLR start synpred114_InternalBindingDsl
    public final void synpred114_InternalBindingDsl_fragment() throws RecognitionException {   
        EObject this_CapacityAssertion_2 = null;


        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3700:2: (this_CapacityAssertion_2= ruleCapacityAssertion )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3700:2: this_CapacityAssertion_2= ruleCapacityAssertion
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleCapacityAssertion_in_synpred114_InternalBindingDsl7500);
        this_CapacityAssertion_2=ruleCapacityAssertion();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred114_InternalBindingDsl

    // $ANTLR start synpred115_InternalBindingDsl
    public final void synpred115_InternalBindingDsl_fragment() throws RecognitionException {   
        EObject this_ReliablityAsserttion_3 = null;


        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3713:2: (this_ReliablityAsserttion_3= ruleReliablityAsserttion )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3713:2: this_ReliablityAsserttion_3= ruleReliablityAsserttion
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleReliablityAsserttion_in_synpred115_InternalBindingDsl7530);
        this_ReliablityAsserttion_3=ruleReliablityAsserttion();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred115_InternalBindingDsl

    // $ANTLR start synpred116_InternalBindingDsl
    public final void synpred116_InternalBindingDsl_fragment() throws RecognitionException {   
        EObject this_CostAssertion_4 = null;


        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3726:2: (this_CostAssertion_4= ruleCostAssertion )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3726:2: this_CostAssertion_4= ruleCostAssertion
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleCostAssertion_in_synpred116_InternalBindingDsl7560);
        this_CostAssertion_4=ruleCostAssertion();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred116_InternalBindingDsl

    // $ANTLR start synpred118_InternalBindingDsl
    public final void synpred118_InternalBindingDsl_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        Token lv_requestNum_2_0=null;
        Token otherlv_3=null;
        Token lv_timeUnit_4_0=null;

        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3969:4: (otherlv_1= 'num-of-requests' ( (lv_requestNum_2_0= RULE_STRING ) ) otherlv_3= 'per' ( (lv_timeUnit_4_0= RULE_STRING ) ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3969:4: otherlv_1= 'num-of-requests' ( (lv_requestNum_2_0= RULE_STRING ) ) otherlv_3= 'per' ( (lv_timeUnit_4_0= RULE_STRING ) )
        {
        otherlv_1=(Token)match(input,88,FollowSets000.FOLLOW_88_in_synpred118_InternalBindingDsl8060); if (state.failed) return ;
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3973:1: ( (lv_requestNum_2_0= RULE_STRING ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3974:1: (lv_requestNum_2_0= RULE_STRING )
        {
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3974:1: (lv_requestNum_2_0= RULE_STRING )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3975:3: lv_requestNum_2_0= RULE_STRING
        {
        lv_requestNum_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred118_InternalBindingDsl8077); if (state.failed) return ;

        }


        }

        otherlv_3=(Token)match(input,89,FollowSets000.FOLLOW_89_in_synpred118_InternalBindingDsl8094); if (state.failed) return ;
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3995:1: ( (lv_timeUnit_4_0= RULE_STRING ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3996:1: (lv_timeUnit_4_0= RULE_STRING )
        {
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3996:1: (lv_timeUnit_4_0= RULE_STRING )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3997:3: lv_timeUnit_4_0= RULE_STRING
        {
        lv_timeUnit_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred118_InternalBindingDsl8111); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred118_InternalBindingDsl

    // $ANTLR start synpred119_InternalBindingDsl
    public final void synpred119_InternalBindingDsl_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        Token lv_messageSize_6_0=null;

        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4013:6: (otherlv_5= 'message-size' ( (lv_messageSize_6_0= RULE_STRING ) ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4013:6: otherlv_5= 'message-size' ( (lv_messageSize_6_0= RULE_STRING ) )
        {
        otherlv_5=(Token)match(input,90,FollowSets000.FOLLOW_90_in_synpred119_InternalBindingDsl8131); if (state.failed) return ;
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4017:1: ( (lv_messageSize_6_0= RULE_STRING ) )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4018:1: (lv_messageSize_6_0= RULE_STRING )
        {
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4018:1: (lv_messageSize_6_0= RULE_STRING )
        // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4019:3: lv_messageSize_6_0= RULE_STRING
        {
        lv_messageSize_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_synpred119_InternalBindingDsl8148); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred119_InternalBindingDsl

    // Delegated rules

    public final boolean synpred118_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred118_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred113_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred114_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred114_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred116_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred116_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred112_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred112_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred115_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred115_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred119_InternalBindingDsl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred119_InternalBindingDsl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA102 dfa102 = new DFA102(this);
    static final String DFA102_eotS =
        "\14\uffff";
    static final String DFA102_eofS =
        "\1\3\13\uffff";
    static final String DFA102_minS =
        "\1\25\2\0\1\uffff\3\0\5\uffff";
    static final String DFA102_maxS =
        "\1\137\2\0\1\uffff\3\0\5\uffff";
    static final String DFA102_acceptS =
        "\3\uffff\1\3\3\uffff\1\1\1\2\1\4\1\5\1\6";
    static final String DFA102_specialS =
        "\1\uffff\1\0\1\4\1\uffff\1\1\1\3\1\2\5\uffff}>";
    static final String[] DFA102_transitionS = {
            "\1\3\74\uffff\1\1\3\uffff\1\2\1\uffff\1\3\1\uffff\1\3\1\4\1"+
            "\uffff\1\5\1\uffff\1\6",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA102_eot = DFA.unpackEncodedString(DFA102_eotS);
    static final short[] DFA102_eof = DFA.unpackEncodedString(DFA102_eofS);
    static final char[] DFA102_min = DFA.unpackEncodedStringToUnsignedChars(DFA102_minS);
    static final char[] DFA102_max = DFA.unpackEncodedStringToUnsignedChars(DFA102_maxS);
    static final short[] DFA102_accept = DFA.unpackEncodedString(DFA102_acceptS);
    static final short[] DFA102_special = DFA.unpackEncodedString(DFA102_specialS);
    static final short[][] DFA102_transition;

    static {
        int numStates = DFA102_transitionS.length;
        DFA102_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA102_transition[i] = DFA.unpackEncodedString(DFA102_transitionS[i]);
        }
    }

    class DFA102 extends DFA {

        public DFA102(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 102;
            this.eot = DFA102_eot;
            this.eof = DFA102_eof;
            this.min = DFA102_min;
            this.max = DFA102_max;
            this.accept = DFA102_accept;
            this.special = DFA102_special;
            this.transition = DFA102_transition;
        }
        public String getDescription() {
            return "3673:1: (this_AvailabilityAssertion_0= ruleAvailabilityAssertion | this_LatencyAssertion_1= ruleLatencyAssertion | this_CapacityAssertion_2= ruleCapacityAssertion | this_ReliablityAsserttion_3= ruleReliablityAsserttion | this_CostAssertion_4= ruleCostAssertion | this_AccuracyAssertion_5= ruleAccuracyAssertion )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA102_1 = input.LA(1);

                         
                        int index102_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred112_InternalBindingDsl()) ) {s = 7;}

                        else if ( (synpred114_InternalBindingDsl()) ) {s = 3;}

                         
                        input.seek(index102_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA102_4 = input.LA(1);

                         
                        int index102_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred114_InternalBindingDsl()) ) {s = 3;}

                        else if ( (synpred115_InternalBindingDsl()) ) {s = 9;}

                         
                        input.seek(index102_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA102_6 = input.LA(1);

                         
                        int index102_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred114_InternalBindingDsl()) ) {s = 3;}

                        else if ( (true) ) {s = 11;}

                         
                        input.seek(index102_6);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA102_5 = input.LA(1);

                         
                        int index102_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred114_InternalBindingDsl()) ) {s = 3;}

                        else if ( (synpred116_InternalBindingDsl()) ) {s = 10;}

                         
                        input.seek(index102_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA102_2 = input.LA(1);

                         
                        int index102_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_InternalBindingDsl()) ) {s = 8;}

                        else if ( (synpred114_InternalBindingDsl()) ) {s = 3;}

                         
                        input.seek(index102_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 102, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleBindingModel_in_entryRuleBindingModel81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBindingModel91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_ruleBindingModel137 = new BitSet(new long[]{0x0000000001004002L,0x0000000800000000L});
        public static final BitSet FOLLOW_ruleBinding_in_ruleBindingModel159 = new BitSet(new long[]{0x0000000001004002L});
        public static final BitSet FOLLOW_ruleBinding_in_entryRuleBinding196 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBinding206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModuleBinding_in_ruleBinding256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceBinding_in_ruleBinding286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_entryRuleConnectorQualifier321 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConnectorQualifier331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleConnectorQualifier368 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleConnectorQualifier380 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleConnectorQualifier407 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleConnectorQualifier420 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleConnectorQualifier447 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_ruleModuleBinding_in_entryRuleModuleBinding485 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModuleBinding495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleModuleBinding532 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleModuleRef_in_ruleModuleBinding553 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleModuleBinding565 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModuleBinding586 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleModuleBinding598 = new BitSet(new long[]{0x00000000000A0000L});
        public static final BitSet FOLLOW_17_in_ruleModuleBinding612 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModuleBinding639 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleModuleBinding651 = new BitSet(new long[]{0x0000000001F04000L,0x0000100400000000L});
        public static final BitSet FOLLOW_19_in_ruleModuleBinding671 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModuleBinding698 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleModuleBinding710 = new BitSet(new long[]{0x0000000001F04000L,0x0000100400000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleModuleBinding733 = new BitSet(new long[]{0x0000000001F04000L,0x0000100000000000L});
        public static final BitSet FOLLOW_ruleGovernanceDecision_in_ruleModuleBinding755 = new BitSet(new long[]{0x0000000001F04000L,0x0000100000000000L});
        public static final BitSet FOLLOW_20_in_ruleModuleBinding769 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleModuleBinding781 = new BitSet(new long[]{0xA888452200000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleModuleBinding802 = new BitSet(new long[]{0xA888452200200000L,0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleModuleBinding815 = new BitSet(new long[]{0x0000000001E04000L});
        public static final BitSet FOLLOW_22_in_ruleModuleBinding830 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleModuleBinding842 = new BitSet(new long[]{0x0000000000200000L,0x0000000000010818L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleModuleBinding863 = new BitSet(new long[]{0x0000000000200000L,0x0000000000010818L});
        public static final BitSet FOLLOW_21_in_ruleModuleBinding876 = new BitSet(new long[]{0x0000000001A04000L});
        public static final BitSet FOLLOW_23_in_ruleModuleBinding891 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleModuleBinding903 = new BitSet(new long[]{0x0000000000000000L,0x00000000AD440000L});
        public static final BitSet FOLLOW_ruleAssertion_in_ruleModuleBinding924 = new BitSet(new long[]{0x0000000000200000L,0x00000000AD440000L});
        public static final BitSet FOLLOW_21_in_ruleModuleBinding937 = new BitSet(new long[]{0x0000000001204000L});
        public static final BitSet FOLLOW_ruleServiceBinding_in_ruleModuleBinding960 = new BitSet(new long[]{0x0000000001204000L});
        public static final BitSet FOLLOW_21_in_ruleModuleBinding973 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModuleRef_in_entryRuleModuleRef1009 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModuleRef1019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModuleRef1071 = new BitSet(new long[]{0x0000000000000000L,0x0000066000000000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleModuleRef1092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceBinding_in_entryRuleServiceBinding1128 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleServiceBinding1138 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleServiceBinding1175 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleServiceBinding1196 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleServiceBinding1208 = new BitSet(new long[]{0x0000000006000000L,0x0000100400000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleServiceBinding1229 = new BitSet(new long[]{0x0000000006000000L,0x0000100000000000L});
        public static final BitSet FOLLOW_ruleGovernanceDecision_in_ruleServiceBinding1251 = new BitSet(new long[]{0x0000000006000000L,0x0000100000000000L});
        public static final BitSet FOLLOW_25_in_ruleServiceBinding1265 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleServiceBinding1282 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleServiceBinding1301 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleServiceBinding1313 = new BitSet(new long[]{0xA888452200000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleServiceBinding1334 = new BitSet(new long[]{0xA888452200200000L,0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleServiceBinding1347 = new BitSet(new long[]{0x0000000078200000L});
        public static final BitSet FOLLOW_27_in_ruleServiceBinding1360 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleServiceBinding1372 = new BitSet(new long[]{0x0000000000200000L,0x0000000000010818L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleServiceBinding1393 = new BitSet(new long[]{0x0000000000200000L,0x0000000000010818L});
        public static final BitSet FOLLOW_21_in_ruleServiceBinding1406 = new BitSet(new long[]{0x0000000070200000L});
        public static final BitSet FOLLOW_28_in_ruleServiceBinding1421 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleServiceBinding1433 = new BitSet(new long[]{0x0000000000000000L,0x00000000AD440000L});
        public static final BitSet FOLLOW_ruleAssertion_in_ruleServiceBinding1454 = new BitSet(new long[]{0x0000000000200000L,0x00000000AD440000L});
        public static final BitSet FOLLOW_21_in_ruleServiceBinding1467 = new BitSet(new long[]{0x0000000060200000L});
        public static final BitSet FOLLOW_29_in_ruleServiceBinding1482 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleModuleRef_in_ruleServiceBinding1503 = new BitSet(new long[]{0x0000000040200000L});
        public static final BitSet FOLLOW_ruleOperationBinding_in_ruleServiceBinding1526 = new BitSet(new long[]{0x0000000040200000L});
        public static final BitSet FOLLOW_21_in_ruleServiceBinding1539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceRef_in_entryRuleServiceRef1575 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleServiceRef1585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleServiceRef1637 = new BitSet(new long[]{0x0000000000000000L,0x0000066000000000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleServiceRef1658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_entryRuleBindingProtocol1694 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBindingProtocol1704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSCA_in_ruleBindingProtocol1754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSOAP_in_ruleBindingProtocol1784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEJB_in_ruleBindingProtocol1814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHTTP_in_ruleBindingProtocol1844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleREST_in_ruleBindingProtocol1874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSAP_in_ruleBindingProtocol1904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJMS_in_ruleBindingProtocol1934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFILE_in_ruleBindingProtocol1964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFTP_in_ruleBindingProtocol1994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIIOP_in_ruleBindingProtocol2024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAMQP_in_ruleBindingProtocol2054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperationBinding_in_entryRuleOperationBinding2089 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperationBinding2099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleOperationBinding2136 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleOperationBinding2163 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleOperationBinding2175 = new BitSet(new long[]{0x0000000004000000L,0x0000100400000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleOperationBinding2196 = new BitSet(new long[]{0x0000000004000000L,0x0000100000000000L});
        public static final BitSet FOLLOW_ruleGovernanceDecision_in_ruleOperationBinding2218 = new BitSet(new long[]{0x0000000004000000L,0x0000100000000000L});
        public static final BitSet FOLLOW_26_in_ruleOperationBinding2231 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleOperationBinding2243 = new BitSet(new long[]{0xA888452200000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleOperationBinding2264 = new BitSet(new long[]{0xA888452200200000L,0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleOperationBinding2277 = new BitSet(new long[]{0x0000000198200000L});
        public static final BitSet FOLLOW_31_in_ruleOperationBinding2290 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleOperationBinding2302 = new BitSet(new long[]{0xA888452200000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleOperationBinding2323 = new BitSet(new long[]{0xA888452200200000L,0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleOperationBinding2336 = new BitSet(new long[]{0x0000000118200000L});
        public static final BitSet FOLLOW_27_in_ruleOperationBinding2351 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleOperationBinding2363 = new BitSet(new long[]{0x0000000000200000L,0x0000000000010818L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleOperationBinding2384 = new BitSet(new long[]{0x0000000000200000L,0x0000000000010818L});
        public static final BitSet FOLLOW_21_in_ruleOperationBinding2397 = new BitSet(new long[]{0x0000000110200000L});
        public static final BitSet FOLLOW_32_in_ruleOperationBinding2412 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleOperationBinding2424 = new BitSet(new long[]{0x0000000000200000L,0x0000000000010818L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleOperationBinding2445 = new BitSet(new long[]{0x0000000000200000L,0x0000000000010818L});
        public static final BitSet FOLLOW_21_in_ruleOperationBinding2458 = new BitSet(new long[]{0x0000000010200000L});
        public static final BitSet FOLLOW_28_in_ruleOperationBinding2473 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleOperationBinding2485 = new BitSet(new long[]{0x0000000000000000L,0x00000000AD440000L});
        public static final BitSet FOLLOW_ruleAssertion_in_ruleOperationBinding2506 = new BitSet(new long[]{0x0000000000200000L,0x00000000AD440000L});
        public static final BitSet FOLLOW_21_in_ruleOperationBinding2519 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleOperationBinding2533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSOAP_in_entryRuleSOAP2569 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSOAP2579 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleSOAP2616 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleSOAP2628 = new BitSet(new long[]{0x0000001C00200800L,0x0000000400000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleSOAP2661 = new BitSet(new long[]{0x0000001C00200800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleSOAP2683 = new BitSet(new long[]{0x0000001C00200000L});
        public static final BitSet FOLLOW_34_in_ruleSOAP2697 = new BitSet(new long[]{0x0000000000000000L,0x0070000000000000L});
        public static final BitSet FOLLOW_ruleSOAPStyle_in_ruleSOAP2718 = new BitSet(new long[]{0x0000001800200000L});
        public static final BitSet FOLLOW_35_in_ruleSOAP2733 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSOAP2750 = new BitSet(new long[]{0x0000001000200000L});
        public static final BitSet FOLLOW_36_in_ruleSOAP2770 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSOAP2787 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleSOAP2806 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSAP_in_entryRuleSAP2842 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSAP2852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleSAP2889 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleSAP2901 = new BitSet(new long[]{0x000000C000200800L,0x0000000400000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleSAP2934 = new BitSet(new long[]{0x000000C000200800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleSAP2956 = new BitSet(new long[]{0x000000C000200000L});
        public static final BitSet FOLLOW_38_in_ruleSAP2970 = new BitSet(new long[]{0x0000000000000000L,0x0180000000000000L});
        public static final BitSet FOLLOW_ruleSAPTransport_in_ruleSAP2991 = new BitSet(new long[]{0x0000008000200000L});
        public static final BitSet FOLLOW_39_in_ruleSAP3006 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSAP3033 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleSAP3047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEJB_in_entryRuleEJB3083 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEJB3093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleEJB3130 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleEJB3142 = new BitSet(new long[]{0x0000020000000800L,0x0000000400000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleEJB3163 = new BitSet(new long[]{0x0000020000000800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleEJB3185 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_41_in_ruleEJB3198 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEJB3215 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleEJB3232 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHTTP_in_entryRuleHTTP3268 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHTTP3278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleHTTP3315 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleHTTP3327 = new BitSet(new long[]{0x0000080000000800L,0x0000000400000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleHTTP3348 = new BitSet(new long[]{0x0000080000000800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleHTTP3370 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_43_in_ruleHTTP3383 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleHTTP3400 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_ruleHTTP3417 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleHTTP3434 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleHTTP3451 = new BitSet(new long[]{0x0000000000000000L,0xE000000000000000L,0x000000000000000FL});
        public static final BitSet FOLLOW_ruleVerb_in_ruleHTTP3472 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleHTTP3484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleREST_in_entryRuleREST3520 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleREST3530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleREST3567 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleREST3579 = new BitSet(new long[]{0x0000800000000800L,0x0000000400000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleREST3600 = new BitSet(new long[]{0x0000800000000800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleREST3622 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleREST3635 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleREST3652 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_ruleREST3669 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleREST3686 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleREST3703 = new BitSet(new long[]{0x0000000000000000L,0xE000000000000000L,0x000000000000000FL});
        public static final BitSet FOLLOW_ruleVerb_in_ruleREST3724 = new BitSet(new long[]{0x0007000000200000L});
        public static final BitSet FOLLOW_48_in_ruleREST3737 = new BitSet(new long[]{0x0000000000000000L,0x1E00000000000000L});
        public static final BitSet FOLLOW_ruleRESTFormat_in_ruleREST3758 = new BitSet(new long[]{0x0006000000200000L});
        public static final BitSet FOLLOW_49_in_ruleREST3773 = new BitSet(new long[]{0x0000000000000000L,0x1E00000000000000L});
        public static final BitSet FOLLOW_ruleRESTFormat_in_ruleREST3794 = new BitSet(new long[]{0x0004000000200000L});
        public static final BitSet FOLLOW_50_in_ruleREST3809 = new BitSet(new long[]{0x0000000000000000L,0x1E00000000000000L});
        public static final BitSet FOLLOW_ruleRESTFormat_in_ruleREST3830 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleREST3844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJMS_in_entryRuleJMS3880 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleJMS3890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleJMS3927 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleJMS3939 = new BitSet(new long[]{0x0060020000000800L,0x0000000400000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleJMS3972 = new BitSet(new long[]{0x0060020000000800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleJMS3994 = new BitSet(new long[]{0x0060020000000000L});
        public static final BitSet FOLLOW_ruleTopicOrQueue_in_ruleJMS4016 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_41_in_ruleJMS4029 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleJMS4046 = new BitSet(new long[]{0x0010000000200000L});
        public static final BitSet FOLLOW_52_in_ruleJMS4064 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleJMS4081 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleJMS4100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTopicOrQueue_in_entryRuleTopicOrQueue4136 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTopicOrQueue4146 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTopic_in_ruleTopicOrQueue4196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQueue_in_ruleTopicOrQueue4226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTopic_in_entryRuleTopic4261 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTopic4271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleTopic4308 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleTopic4325 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleTopic4351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQueue_in_entryRuleQueue4388 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQueue4398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleQueue4435 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleQueue4452 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleQueue4478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSCA_in_entryRuleSCA4515 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSCA4525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleSCA4574 = new BitSet(new long[]{0x0000000000040010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSCA4591 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleSCA4609 = new BitSet(new long[]{0x0300000000200800L,0x0000000400000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleSCA4630 = new BitSet(new long[]{0x0300000000200800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleSCA4652 = new BitSet(new long[]{0x0300000000200000L});
        public static final BitSet FOLLOW_56_in_ruleSCA4666 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSCA4683 = new BitSet(new long[]{0x0200000000200000L});
        public static final BitSet FOLLOW_57_in_ruleSCA4703 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSCA4720 = new BitSet(new long[]{0x0400000000200000L});
        public static final BitSet FOLLOW_58_in_ruleSCA4743 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleSCA4771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFILE_in_entryRuleFILE4807 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFILE4817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_ruleFILE4854 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleFILE4866 = new BitSet(new long[]{0x0000000000000810L,0x0000000400000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleFILE4887 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleFILE4909 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFILE4927 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000030L});
        public static final BitSet FOLLOW_ruleReadWrite_in_ruleFILE4953 = new BitSet(new long[]{0x1000000000200000L});
        public static final BitSet FOLLOW_60_in_ruleFILE4966 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFILE4983 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleFILE5002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFTP_in_entryRuleFTP5038 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFTP5048 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleFTP5085 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleFTP5097 = new BitSet(new long[]{0x4000000000000800L,0x0000000400000000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleFTP5118 = new BitSet(new long[]{0x4000000000000800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleFTP5140 = new BitSet(new long[]{0x4000000000000000L});
        public static final BitSet FOLLOW_62_in_ruleFTP5153 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000030L});
        public static final BitSet FOLLOW_ruleReadWrite_in_ruleFTP5174 = new BitSet(new long[]{0x1000000000200000L});
        public static final BitSet FOLLOW_60_in_ruleFTP5187 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFTP5204 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleFTP5223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIIOP_in_entryRuleIIOP5259 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIIOP5269 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleIIOP5306 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleIIOP5318 = new BitSet(new long[]{0x0000000000000800L,0x0000000400000001L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleIIOP5339 = new BitSet(new long[]{0x0000000000000800L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleIIOP5361 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_64_in_ruleIIOP5374 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleIIOP5391 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleIIOP5408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAMQP_in_entryRuleAMQP5444 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAMQP5454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleAMQP5491 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleAMQP5503 = new BitSet(new long[]{0x0060000000000800L,0x0000000400000001L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_ruleAMQP5536 = new BitSet(new long[]{0x0060000000000800L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleAMQP5558 = new BitSet(new long[]{0x0060000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleTopicOrQueue_in_ruleAMQP5580 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_64_in_ruleAMQP5593 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAMQP5610 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000004L});
        public static final BitSet FOLLOW_66_in_ruleAMQP5628 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAMQP5645 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleAMQP5664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePolicy_in_entryRulePolicy5700 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePolicy5710 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLogPolicy_in_rulePolicy5760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecurityPolicy_in_rulePolicy5790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLogPolicy_in_entryRuleLogPolicy5825 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLogPolicy5835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_ruleLogPolicy5872 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000400004800L});
        public static final BitSet FOLLOW_ruleLogPolicyKind_in_ruleLogPolicy5893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecurityPolicy_in_entryRuleSecurityPolicy5929 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecurityPolicy5939 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthenticationPolicy_in_ruleSecurityPolicy5989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSigningPolicy_in_ruleSecurityPolicy6019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEncryptionPolicy_in_ruleSecurityPolicy6049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthenticationPolicy_in_entryRuleAuthenticationPolicy6084 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAuthenticationPolicy6094 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleAuthenticationPolicy6143 = new BitSet(new long[]{0x0000000000040020L,0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAuthenticationPolicy6160 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000020L});
        public static final BitSet FOLLOW_69_in_ruleAuthenticationPolicy6184 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleAuthenticationPolicy6210 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_70_in_ruleAuthenticationPolicy6222 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleAuthenticationPolicy6234 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L,0x00000003FE000000L});
        public static final BitSet FOLLOW_ruleAuthToken_in_ruleAuthenticationPolicy6255 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000020L,0x00000003FE000000L});
        public static final BitSet FOLLOW_21_in_ruleAuthenticationPolicy6268 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_ruleAuthenticationPolicy6280 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleAuthenticationPolicy6292 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000420L,0x00000000000007C0L});
        public static final BitSet FOLLOW_ruleHashAlgorithm_in_ruleAuthenticationPolicy6313 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000420L,0x00000000000007C0L});
        public static final BitSet FOLLOW_21_in_ruleAuthenticationPolicy6326 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000300L});
        public static final BitSet FOLLOW_72_in_ruleAuthenticationPolicy6344 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000200L});
        public static final BitSet FOLLOW_73_in_ruleAuthenticationPolicy6371 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAuthenticationPolicy6388 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleAuthenticationPolicy6407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthToken_in_entryRuleAuthToken6443 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAuthToken6453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_69_in_ruleAuthToken6496 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L,0x00000003FE000000L});
        public static final BitSet FOLLOW_ruleAuthTokenKind_in_ruleAuthToken6531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHashAlgorithm_in_entryRuleHashAlgorithm6567 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHashAlgorithm6577 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_69_in_ruleHashAlgorithm6620 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000420L,0x00000000000007C0L});
        public static final BitSet FOLLOW_74_in_ruleHashAlgorithm6652 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000420L,0x00000000000007C0L});
        public static final BitSet FOLLOW_ruleHashAlgKind_in_ruleHashAlgorithm6687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSigningPolicy_in_entryRuleSigningPolicy6723 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSigningPolicy6733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleSigningPolicy6782 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleSigningPolicy6794 = new BitSet(new long[]{0x0000000000200000L,0x0000000000007000L});
        public static final BitSet FOLLOW_76_in_ruleSigningPolicy6807 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000F81C0L});
        public static final BitSet FOLLOW_ruleSigningAlgothm_in_ruleSigningPolicy6828 = new BitSet(new long[]{0x0000000000200000L,0x0000000000006000L,0x00000000000F81C0L});
        public static final BitSet FOLLOW_77_in_ruleSigningPolicy6844 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000F81C0L});
        public static final BitSet FOLLOW_ruleSigningAlgothm_in_ruleSigningPolicy6865 = new BitSet(new long[]{0x0000000000200000L,0x0000000000004000L});
        public static final BitSet FOLLOW_78_in_ruleSigningPolicy6880 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L,0x0000000000007800L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_ruleSigningPolicy6901 = new BitSet(new long[]{0x0000000000202000L});
        public static final BitSet FOLLOW_13_in_ruleSigningPolicy6914 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L,0x0000000000007800L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_ruleSigningPolicy6935 = new BitSet(new long[]{0x0000000000202000L});
        public static final BitSet FOLLOW_21_in_ruleSigningPolicy6951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_entryRuleMessagePartRef6987 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMessagePartRef6997 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMessagePartRefKind_in_ruleMessagePartRef7043 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
        public static final BitSet FOLLOW_79_in_ruleMessagePartRef7056 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleMessagePartRef7073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEncryptionPolicy_in_entryRuleEncryptionPolicy7116 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEncryptionPolicy7126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_80_in_ruleEncryptionPolicy7175 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleEncryptionPolicy7187 = new BitSet(new long[]{0x0000000000200000L,0x0000000000023000L});
        public static final BitSet FOLLOW_76_in_ruleEncryptionPolicy7200 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000001FA8000L});
        public static final BitSet FOLLOW_ruleCipherAlgorithmKind_in_ruleEncryptionPolicy7221 = new BitSet(new long[]{0x0000000000200000L,0x0000000000022000L,0x0000000001FA8000L});
        public static final BitSet FOLLOW_77_in_ruleEncryptionPolicy7237 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000001FA8000L});
        public static final BitSet FOLLOW_ruleCipherAlgorithmKind_in_ruleEncryptionPolicy7258 = new BitSet(new long[]{0x0000000000200000L,0x0000000000020000L});
        public static final BitSet FOLLOW_81_in_ruleEncryptionPolicy7273 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L,0x0000000000007800L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_ruleEncryptionPolicy7294 = new BitSet(new long[]{0x0000000000202000L});
        public static final BitSet FOLLOW_13_in_ruleEncryptionPolicy7307 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L,0x0000000000007800L});
        public static final BitSet FOLLOW_ruleMessagePartRef_in_ruleEncryptionPolicy7328 = new BitSet(new long[]{0x0000000000202000L});
        public static final BitSet FOLLOW_21_in_ruleEncryptionPolicy7344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssertion_in_entryRuleAssertion7380 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssertion7390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAvailabilityAssertion_in_ruleAssertion7440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLatencyAssertion_in_ruleAssertion7470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCapacityAssertion_in_ruleAssertion7500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReliablityAsserttion_in_ruleAssertion7530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCostAssertion_in_ruleAssertion7560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAccuracyAssertion_in_ruleAssertion7590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAvailabilityAssertion_in_entryRuleAvailabilityAssertion7625 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAvailabilityAssertion7635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_82_in_ruleAvailabilityAssertion7672 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAvailabilityAssertion7689 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
        public static final BitSet FOLLOW_83_in_ruleAvailabilityAssertion7706 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rulePercentile_in_ruleAvailabilityAssertion7727 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
        public static final BitSet FOLLOW_84_in_ruleAvailabilityAssertion7739 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAvailabilityAssertion7756 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
        public static final BitSet FOLLOW_85_in_ruleAvailabilityAssertion7773 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAvailabilityAssertion7790 = new BitSet(new long[]{0x0000000000000042L});
        public static final BitSet FOLLOW_rulePercentile_in_ruleAvailabilityAssertion7816 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLatencyAssertion_in_entryRuleLatencyAssertion7853 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLatencyAssertion7863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_86_in_ruleLatencyAssertion7900 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_87_in_ruleLatencyAssertion7918 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
        public static final BitSet FOLLOW_83_in_ruleLatencyAssertion7943 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rulePercentile_in_ruleLatencyAssertion7964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCapacityAssertion_in_entryRuleCapacityAssertion8000 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCapacityAssertion8010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_88_in_ruleCapacityAssertion8060 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCapacityAssertion8077 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
        public static final BitSet FOLLOW_89_in_ruleCapacityAssertion8094 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCapacityAssertion8111 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
        public static final BitSet FOLLOW_90_in_ruleCapacityAssertion8131 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCapacityAssertion8148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReliablityAsserttion_in_entryRuleReliablityAsserttion8191 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReliablityAsserttion8201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_91_in_ruleReliablityAsserttion8238 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000007800000000L});
        public static final BitSet FOLLOW_ruleReliablilityKind_in_ruleReliablityAsserttion8259 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
        public static final BitSet FOLLOW_92_in_ruleReliablityAsserttion8277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCostAssertion_in_entryRuleCostAssertion8327 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCostAssertion8337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_93_in_ruleCostAssertion8374 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCostAssertion8391 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
        public static final BitSet FOLLOW_94_in_ruleCostAssertion8408 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCostAssertion8425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAccuracyAssertion_in_entryRuleAccuracyAssertion8466 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAccuracyAssertion8476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_95_in_ruleAccuracyAssertion8513 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAccuracyAssertion8530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePercentile_in_entryRulePercentile8571 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePercentile8581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rulePercentile8623 = new BitSet(new long[]{0x0000000000000000L,0x0000000300000000L});
        public static final BitSet FOLLOW_96_in_rulePercentile8641 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_rulePercentile8652 = new BitSet(new long[]{0x0000000000000000L,0x0000000300000000L});
        public static final BitSet FOLLOW_97_in_rulePercentile8665 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRef_in_entryRuleEndpointQualifierRef8701 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEndpointQualifierRef8711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_98_in_ruleEndpointQualifierRef8748 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleEndpointQualifierRef8775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport8811 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport8821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_99_in_ruleImport8858 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport8879 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVersionId_in_entryRuleVersionId8916 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionId8927 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId8967 = new BitSet(new long[]{0x0000000000000002L,0x0000001100000000L});
        public static final BitSet FOLLOW_96_in_ruleVersionId8986 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId9001 = new BitSet(new long[]{0x0000000000000002L,0x0000001100000000L});
        public static final BitSet FOLLOW_96_in_ruleVersionId9023 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_100_in_ruleVersionId9042 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVersionId9058 = new BitSet(new long[]{0x0000000000000002L,0x0000001100000000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_entryRuleVersionRef9109 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionRef9119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_ruleVersionRef9169 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_ruleVersionRef9199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef9229 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_ruleVersionRef9259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_ruleVersionRef9289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef9324 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMinVersionRef9334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_101_in_ruleMinVersionRef9371 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMinVersionRef9392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef9428 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxVersionRef9438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_102_in_ruleMaxVersionRef9475 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMaxVersionRef9496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef9532 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef9542 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_101_in_ruleLowerBoundRangeVersionRef9580 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
        public static final BitSet FOLLOW_103_in_ruleLowerBoundRangeVersionRef9592 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef9614 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleLowerBoundRangeVersionRef9626 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
        public static final BitSet FOLLOW_102_in_ruleLowerBoundRangeVersionRef9639 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
        public static final BitSet FOLLOW_104_in_ruleLowerBoundRangeVersionRef9651 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef9673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef9709 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMajorVersionRef9719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_105_in_ruleMajorVersionRef9756 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMajorVersionRef9773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef9814 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFixedVersionRef9824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_106_in_ruleFixedVersionRef9861 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleFixedVersionRef9882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard9919 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard9930 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard9977 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
        public static final BitSet FOLLOW_107_in_ruleQualifiedNameWithWildCard9996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10039 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName10050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName10090 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
        public static final BitSet FOLLOW_96_in_ruleQualifiedName10109 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName10124 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
        public static final BitSet FOLLOW_ruleGovernanceDecision_in_entryRuleGovernanceDecision10171 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGovernanceDecision10181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_108_in_ruleGovernanceDecision10218 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleGovernanceDecision10230 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
        public static final BitSet FOLLOW_109_in_ruleGovernanceDecision10243 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGovernanceDecision10260 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000000L});
        public static final BitSet FOLLOW_110_in_ruleGovernanceDecision10279 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000078000000000L});
        public static final BitSet FOLLOW_ruleGovernanceDecisionResult_in_ruleGovernanceDecision10300 = new BitSet(new long[]{0x0000000000200000L,0x000F800000000000L});
        public static final BitSet FOLLOW_111_in_ruleGovernanceDecision10314 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGovernanceDecision10331 = new BitSet(new long[]{0x0000000000200000L,0x000F000000000000L});
        public static final BitSet FOLLOW_112_in_ruleGovernanceDecision10351 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGovernanceDecision10368 = new BitSet(new long[]{0x0000000000200000L,0x000E000000000000L});
        public static final BitSet FOLLOW_113_in_ruleGovernanceDecision10388 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGovernanceDecision10405 = new BitSet(new long[]{0x0000000000200000L,0x000C000000000000L});
        public static final BitSet FOLLOW_114_in_ruleGovernanceDecision10425 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGovernanceDecision10442 = new BitSet(new long[]{0x0000000000200000L,0x0008000000000000L});
        public static final BitSet FOLLOW_115_in_ruleGovernanceDecision10462 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGovernanceDecision10479 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleGovernanceDecision10498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_116_in_ruleSOAPStyle10550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_117_in_ruleSOAPStyle10567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_118_in_ruleSOAPStyle10584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_119_in_ruleSAPTransport10629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_120_in_ruleSAPTransport10646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_121_in_ruleRESTFormat10691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_122_in_ruleRESTFormat10708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_123_in_ruleRESTFormat10725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_124_in_ruleRESTFormat10742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_125_in_ruleVerb10787 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_126_in_ruleVerb10804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_127_in_ruleVerb10821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_128_in_ruleVerb10838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_129_in_ruleVerb10855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_130_in_ruleVerb10872 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_131_in_ruleVerb10889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_132_in_ruleReadWrite10934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_133_in_ruleReadWrite10951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_134_in_ruleHashAlgKind10996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_135_in_ruleHashAlgKind11013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_136_in_ruleHashAlgKind11030 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_137_in_ruleHashAlgKind11047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_138_in_ruleHashAlgKind11064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_139_in_ruleMessagePartRefKind11109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_140_in_ruleMessagePartRefKind11126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_141_in_ruleMessagePartRefKind11143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_142_in_ruleMessagePartRefKind11160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_79_in_ruleMessagePartRefKind11177 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_143_in_ruleSigningAlgothm11222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_135_in_ruleSigningAlgothm11239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_136_in_ruleSigningAlgothm11256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_134_in_ruleSigningAlgothm11273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_144_in_ruleSigningAlgothm11290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_145_in_ruleSigningAlgothm11307 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_146_in_ruleSigningAlgothm11324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_147_in_ruleSigningAlgothm11341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_143_in_ruleCipherAlgorithmKind11386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_148_in_ruleCipherAlgorithmKind11403 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_149_in_ruleCipherAlgorithmKind11420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_150_in_ruleCipherAlgorithmKind11437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_151_in_ruleCipherAlgorithmKind11454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_152_in_ruleCipherAlgorithmKind11471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_145_in_ruleCipherAlgorithmKind11488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_147_in_ruleCipherAlgorithmKind11505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_153_in_ruleAuthTokenKind11550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_154_in_ruleAuthTokenKind11567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_155_in_ruleAuthTokenKind11584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_156_in_ruleAuthTokenKind11601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_157_in_ruleAuthTokenKind11618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_158_in_ruleAuthTokenKind11635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_159_in_ruleAuthTokenKind11652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_160_in_ruleAuthTokenKind11669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_161_in_ruleAuthTokenKind11686 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_162_in_ruleLogPolicyKind11731 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_139_in_ruleLogPolicyKind11748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_142_in_ruleLogPolicyKind11765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_163_in_ruleReliablilityKind11810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_164_in_ruleReliablilityKind11827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_165_in_ruleReliablilityKind11844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_166_in_ruleReliablilityKind11861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_167_in_ruleGovernanceDecisionResult11906 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_168_in_ruleGovernanceDecisionResult11923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_169_in_ruleGovernanceDecisionResult11940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_170_in_ruleGovernanceDecisionResult11957 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssertion_in_synpred12_InternalBindingDsl924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssertion_in_synpred21_InternalBindingDsl1454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssertion_in_synpred44_InternalBindingDsl2506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAvailabilityAssertion_in_synpred112_InternalBindingDsl7440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLatencyAssertion_in_synpred113_InternalBindingDsl7470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCapacityAssertion_in_synpred114_InternalBindingDsl7500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReliablityAsserttion_in_synpred115_InternalBindingDsl7530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCostAssertion_in_synpred116_InternalBindingDsl7560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_88_in_synpred118_InternalBindingDsl8060 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred118_InternalBindingDsl8077 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
        public static final BitSet FOLLOW_89_in_synpred118_InternalBindingDsl8094 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred118_InternalBindingDsl8111 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_90_in_synpred119_InternalBindingDsl8131 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_synpred119_InternalBindingDsl8148 = new BitSet(new long[]{0x0000000000000002L});
    }


}