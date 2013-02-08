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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'on'", "'connector'", "','", "'bind-module'", "'as'", "'to'", "'environment'", "'{'", "'server'", "'default-protocols'", "'}'", "'default-policies'", "'default-SLAs'", "'bind-service'", "'provided-contract'", "'protocols'", "'policies'", "'SLAs'", "'references-module'", "'bind-operation'", "'provider-protocols'", "'provider-policies'", "'SOAP'", "'style'", "'http-context-root'", "'provided-WSDL-Url'", "'SAP'", "'transport'", "'client'", "'EJB'", "'jndi-name'", "'HTTP'", "'url'", "'provider-url'", "'verb'", "'REST'", "'path'", "'format'", "'consumes-format'", "'provides-format'", "'JMS'", "'provider-jndi-name'", "'topic'", "'queue'", "'SCA'", "'promote'", "'reference'", "'[]'", "'FILE'", "'interval'", "'FTP'", "'access'", "'IIOP'", "'lookup-name'", "'AMQP'", "'provider-lookup-name'", "'logging policy'", "'authn policy'", "'optional'", "'auth tokens'", "'hash algorithms'", "'Base64-encoded'", "'authorization policy'", "'signing policy'", "'encryption policy'", "'endpoint-qualifier'", "'import'", "'.'", "'-'", "'minVersion'", "'maxVersion'", "'>='", "'<'", "'majorVersion'", "'fixedVersion'", "'.*'", "'governance-decision'", "'subject'", "'decision-result'", "'specific-result'", "'justification-doc'", "'decision-date'", "'decision-by'", "'effective-date'", "'document/literal-wrapped'", "'rpc/literal'", "'rpc/encoded'", "'IDOC'", "'RFC'", "'JSON'", "'XML'", "'BISON'", "'OTHER'", "'CREATE'", "'RETRIEVE'", "'UPDATE'", "'DELETE'", "'GET'", "'PUT'", "'POST'", "'read'", "'write'", "'MD5'", "'SHA1'", "'SHA256'", "'PlainText'", "'UsernamePassword'", "'SAML'", "'SAML2'", "'Kerberos'", "'X509Certificate'", "'OAuth'", "'NONE'", "'HEADER'", "'ALL'", "'pending'", "'accepted'", "'denied'", "'specific'"
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
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
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

                if ( (LA1_0==77) ) {
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:255:1: ruleModuleBinding returns [EObject current=null] : (otherlv_0= 'bind-module' ( (lv_module_1_0= ruleModuleRef ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' ( (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ) | (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' ) ) ( (lv_endpointQualifierRefs_11_0= ruleEndpointQualifierRefs ) )? ( (lv_governanceDecisions_12_0= ruleGovernanceDecision ) )* (otherlv_13= 'default-protocols' otherlv_14= '{' ( (lv_protocol_15_0= ruleBindingProtocol ) )+ otherlv_16= '}' )? (otherlv_17= 'default-policies' otherlv_18= '{' ( (lv_policies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'default-SLAs' ( ( ruleQualifiedName ) ) (otherlv_23= ',' ( ( ruleQualifiedName ) ) )* )? ( (lv_serviceBindings_25_0= ruleServiceBinding ) )* otherlv_26= '}' ) ;
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
        Token otherlv_23=null;
        Token otherlv_26=null;
        EObject lv_module_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_endpointQualifierRefs_11_0 = null;

        EObject lv_governanceDecisions_12_0 = null;

        EObject lv_protocol_15_0 = null;

        EObject lv_policies_19_0 = null;

        EObject lv_serviceBindings_25_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:258:28: ( (otherlv_0= 'bind-module' ( (lv_module_1_0= ruleModuleRef ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' ( (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ) | (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' ) ) ( (lv_endpointQualifierRefs_11_0= ruleEndpointQualifierRefs ) )? ( (lv_governanceDecisions_12_0= ruleGovernanceDecision ) )* (otherlv_13= 'default-protocols' otherlv_14= '{' ( (lv_protocol_15_0= ruleBindingProtocol ) )+ otherlv_16= '}' )? (otherlv_17= 'default-policies' otherlv_18= '{' ( (lv_policies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'default-SLAs' ( ( ruleQualifiedName ) ) (otherlv_23= ',' ( ( ruleQualifiedName ) ) )* )? ( (lv_serviceBindings_25_0= ruleServiceBinding ) )* otherlv_26= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:259:1: (otherlv_0= 'bind-module' ( (lv_module_1_0= ruleModuleRef ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' ( (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ) | (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' ) ) ( (lv_endpointQualifierRefs_11_0= ruleEndpointQualifierRefs ) )? ( (lv_governanceDecisions_12_0= ruleGovernanceDecision ) )* (otherlv_13= 'default-protocols' otherlv_14= '{' ( (lv_protocol_15_0= ruleBindingProtocol ) )+ otherlv_16= '}' )? (otherlv_17= 'default-policies' otherlv_18= '{' ( (lv_policies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'default-SLAs' ( ( ruleQualifiedName ) ) (otherlv_23= ',' ( ( ruleQualifiedName ) ) )* )? ( (lv_serviceBindings_25_0= ruleServiceBinding ) )* otherlv_26= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:259:1: (otherlv_0= 'bind-module' ( (lv_module_1_0= ruleModuleRef ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' ( (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ) | (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' ) ) ( (lv_endpointQualifierRefs_11_0= ruleEndpointQualifierRefs ) )? ( (lv_governanceDecisions_12_0= ruleGovernanceDecision ) )* (otherlv_13= 'default-protocols' otherlv_14= '{' ( (lv_protocol_15_0= ruleBindingProtocol ) )+ otherlv_16= '}' )? (otherlv_17= 'default-policies' otherlv_18= '{' ( (lv_policies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'default-SLAs' ( ( ruleQualifiedName ) ) (otherlv_23= ',' ( ( ruleQualifiedName ) ) )* )? ( (lv_serviceBindings_25_0= ruleServiceBinding ) )* otherlv_26= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:259:3: otherlv_0= 'bind-module' ( (lv_module_1_0= ruleModuleRef ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' ( (otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ) | (otherlv_8= 'server' ( ( ruleQualifiedName ) ) otherlv_10= '{' ) ) ( (lv_endpointQualifierRefs_11_0= ruleEndpointQualifierRefs ) )? ( (lv_governanceDecisions_12_0= ruleGovernanceDecision ) )* (otherlv_13= 'default-protocols' otherlv_14= '{' ( (lv_protocol_15_0= ruleBindingProtocol ) )+ otherlv_16= '}' )? (otherlv_17= 'default-policies' otherlv_18= '{' ( (lv_policies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'default-SLAs' ( ( ruleQualifiedName ) ) (otherlv_23= ',' ( ( ruleQualifiedName ) ) )* )? ( (lv_serviceBindings_25_0= ruleServiceBinding ) )* otherlv_26= '}'
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:360:3: ( (lv_endpointQualifierRefs_11_0= ruleEndpointQualifierRefs ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==76) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:361:1: (lv_endpointQualifierRefs_11_0= ruleEndpointQualifierRefs )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:361:1: (lv_endpointQualifierRefs_11_0= ruleEndpointQualifierRefs )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:362:3: lv_endpointQualifierRefs_11_0= ruleEndpointQualifierRefs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getEndpointQualifierRefsEndpointQualifierRefsParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRefs_in_ruleModuleBinding733);
                    lv_endpointQualifierRefs_11_0=ruleEndpointQualifierRefs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModuleBindingRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRefs",
                              		lv_endpointQualifierRefs_11_0, 
                              		"EndpointQualifierRefs");
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

                if ( (LA7_0==87) ) {
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

                        if ( ((LA10_0>=67 && LA10_0<=68)||(LA10_0>=73 && LA10_0<=75)) ) {
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:456:3: (otherlv_21= 'default-SLAs' ( ( ruleQualifiedName ) ) (otherlv_23= ',' ( ( ruleQualifiedName ) ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==23) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:456:5: otherlv_21= 'default-SLAs' ( ( ruleQualifiedName ) ) (otherlv_23= ',' ( ( ruleQualifiedName ) ) )*
                    {
                    otherlv_21=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleModuleBinding891); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_21, grammarAccess.getModuleBindingAccess().getDefaultSLAsKeyword_10_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:460:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:461:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:461:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:462:3: ruleQualifiedName
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
                       
                      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getSlaSLACrossReference_10_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModuleBinding918);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:478:2: (otherlv_23= ',' ( ( ruleQualifiedName ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==13) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:478:4: otherlv_23= ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_23=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModuleBinding931); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_23, grammarAccess.getModuleBindingAccess().getCommaKeyword_10_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:482:1: ( ( ruleQualifiedName ) )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:483:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:483:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:484:3: ruleQualifiedName
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
                    	       
                    	      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getSlaSLACrossReference_10_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModuleBinding958);
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
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:500:6: ( (lv_serviceBindings_25_0= ruleServiceBinding ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==24) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:501:1: (lv_serviceBindings_25_0= ruleServiceBinding )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:501:1: (lv_serviceBindings_25_0= ruleServiceBinding )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:502:3: lv_serviceBindings_25_0= ruleServiceBinding
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getServiceBindingsServiceBindingParserRuleCall_11_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceBinding_in_ruleModuleBinding983);
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

            otherlv_26=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleModuleBinding996); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:530:1: entryRuleModuleRef returns [EObject current=null] : iv_ruleModuleRef= ruleModuleRef EOF ;
    public final EObject entryRuleModuleRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModuleRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:531:2: (iv_ruleModuleRef= ruleModuleRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:532:2: iv_ruleModuleRef= ruleModuleRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModuleRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModuleRef_in_entryRuleModuleRef1032);
            iv_ruleModuleRef=ruleModuleRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModuleRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModuleRef1042); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:539:1: ruleModuleRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) ;
    public final EObject ruleModuleRef() throws RecognitionException {
        EObject current = null;

        EObject lv_versionRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:542:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:543:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:543:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:543:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:543:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:544:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:544:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:545:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModuleRef1094);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:561:2: ( (lv_versionRef_1_0= ruleVersionRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:562:1: (lv_versionRef_1_0= ruleVersionRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:562:1: (lv_versionRef_1_0= ruleVersionRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:563:3: lv_versionRef_1_0= ruleVersionRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModuleRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleModuleRef1115);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:587:1: entryRuleServiceBinding returns [EObject current=null] : iv_ruleServiceBinding= ruleServiceBinding EOF ;
    public final EObject entryRuleServiceBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceBinding = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:588:2: (iv_ruleServiceBinding= ruleServiceBinding EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:589:2: iv_ruleServiceBinding= ruleServiceBinding EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getServiceBindingRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceBinding_in_entryRuleServiceBinding1151);
            iv_ruleServiceBinding=ruleServiceBinding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleServiceBinding; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleServiceBinding1161); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:596:1: ruleServiceBinding returns [EObject current=null] : (otherlv_0= 'bind-service' ( (lv_service_1_0= ruleServiceRef ) ) otherlv_2= '{' ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* (otherlv_5= 'provided-contract' ( (lv_providedContract_6_0= RULE_STRING ) ) )? otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocol_9_0= ruleBindingProtocol ) )+ otherlv_10= '}' (otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}' )? (otherlv_15= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_17= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_19= 'references-module' ( (lv_referencedModule_20_0= ruleModuleRef ) ) )? ( (lv_operation_21_0= ruleOperationBinding ) )* otherlv_22= '}' ) ;
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
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_22=null;
        EObject lv_service_1_0 = null;

        EObject lv_endpointQualifierRefs_3_0 = null;

        EObject lv_governanceDecisions_4_0 = null;

        EObject lv_protocol_9_0 = null;

        EObject lv_policies_13_0 = null;

        EObject lv_referencedModule_20_0 = null;

        EObject lv_operation_21_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:599:28: ( (otherlv_0= 'bind-service' ( (lv_service_1_0= ruleServiceRef ) ) otherlv_2= '{' ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* (otherlv_5= 'provided-contract' ( (lv_providedContract_6_0= RULE_STRING ) ) )? otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocol_9_0= ruleBindingProtocol ) )+ otherlv_10= '}' (otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}' )? (otherlv_15= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_17= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_19= 'references-module' ( (lv_referencedModule_20_0= ruleModuleRef ) ) )? ( (lv_operation_21_0= ruleOperationBinding ) )* otherlv_22= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:600:1: (otherlv_0= 'bind-service' ( (lv_service_1_0= ruleServiceRef ) ) otherlv_2= '{' ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* (otherlv_5= 'provided-contract' ( (lv_providedContract_6_0= RULE_STRING ) ) )? otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocol_9_0= ruleBindingProtocol ) )+ otherlv_10= '}' (otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}' )? (otherlv_15= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_17= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_19= 'references-module' ( (lv_referencedModule_20_0= ruleModuleRef ) ) )? ( (lv_operation_21_0= ruleOperationBinding ) )* otherlv_22= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:600:1: (otherlv_0= 'bind-service' ( (lv_service_1_0= ruleServiceRef ) ) otherlv_2= '{' ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* (otherlv_5= 'provided-contract' ( (lv_providedContract_6_0= RULE_STRING ) ) )? otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocol_9_0= ruleBindingProtocol ) )+ otherlv_10= '}' (otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}' )? (otherlv_15= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_17= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_19= 'references-module' ( (lv_referencedModule_20_0= ruleModuleRef ) ) )? ( (lv_operation_21_0= ruleOperationBinding ) )* otherlv_22= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:600:3: otherlv_0= 'bind-service' ( (lv_service_1_0= ruleServiceRef ) ) otherlv_2= '{' ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* (otherlv_5= 'provided-contract' ( (lv_providedContract_6_0= RULE_STRING ) ) )? otherlv_7= 'protocols' otherlv_8= '{' ( (lv_protocol_9_0= ruleBindingProtocol ) )+ otherlv_10= '}' (otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}' )? (otherlv_15= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_17= ',' ( ( ruleQualifiedName ) ) )* )? (otherlv_19= 'references-module' ( (lv_referencedModule_20_0= ruleModuleRef ) ) )? ( (lv_operation_21_0= ruleOperationBinding ) )* otherlv_22= '}'
            {
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleServiceBinding1198); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getServiceBindingAccess().getBindServiceKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:604:1: ( (lv_service_1_0= ruleServiceRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:605:1: (lv_service_1_0= ruleServiceRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:605:1: (lv_service_1_0= ruleServiceRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:606:3: lv_service_1_0= ruleServiceRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getServiceBindingAccess().getServiceServiceRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleServiceBinding1219);
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

            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleServiceBinding1231); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:626:1: ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==76) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:627:1: (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:627:1: (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:628:3: lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getEndpointQualifierRefsEndpointQualifierRefsParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRefs_in_ruleServiceBinding1252);
                    lv_endpointQualifierRefs_3_0=ruleEndpointQualifierRefs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getServiceBindingRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRefs",
                              		lv_endpointQualifierRefs_3_0, 
                              		"EndpointQualifierRefs");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:644:3: ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==87) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:645:1: (lv_governanceDecisions_4_0= ruleGovernanceDecision )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:645:1: (lv_governanceDecisions_4_0= ruleGovernanceDecision )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:646:3: lv_governanceDecisions_4_0= ruleGovernanceDecision
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getGovernanceDecisionsGovernanceDecisionParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleGovernanceDecision_in_ruleServiceBinding1274);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:662:3: (otherlv_5= 'provided-contract' ( (lv_providedContract_6_0= RULE_STRING ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==25) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:662:5: otherlv_5= 'provided-contract' ( (lv_providedContract_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleServiceBinding1288); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getServiceBindingAccess().getProvidedContractKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:666:1: ( (lv_providedContract_6_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:667:1: (lv_providedContract_6_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:667:1: (lv_providedContract_6_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:668:3: lv_providedContract_6_0= RULE_STRING
                    {
                    lv_providedContract_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleServiceBinding1305); if (state.failed) return current;
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

            otherlv_7=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleServiceBinding1324); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getServiceBindingAccess().getProtocolsKeyword_6());
                  
            }
            otherlv_8=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleServiceBinding1336); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_7());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:692:1: ( (lv_protocol_9_0= ruleBindingProtocol ) )+
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
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:693:1: (lv_protocol_9_0= ruleBindingProtocol )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:693:1: (lv_protocol_9_0= ruleBindingProtocol )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:694:3: lv_protocol_9_0= ruleBindingProtocol
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getProtocolBindingProtocolParserRuleCall_8_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleServiceBinding1357);
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

            otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleServiceBinding1370); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getServiceBindingAccess().getRightCurlyBracketKeyword_9());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:714:1: (otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:714:3: otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleServiceBinding1383); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getServiceBindingAccess().getPoliciesKeyword_10_0());
                          
                    }
                    otherlv_12=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleServiceBinding1395); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_10_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:722:1: ( (lv_policies_13_0= rulePolicy ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=67 && LA19_0<=68)||(LA19_0>=73 && LA19_0<=75)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:723:1: (lv_policies_13_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:723:1: (lv_policies_13_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:724:3: lv_policies_13_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getPoliciesPolicyParserRuleCall_10_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleServiceBinding1416);
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

                    otherlv_14=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleServiceBinding1429); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getServiceBindingAccess().getRightCurlyBracketKeyword_10_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:744:3: (otherlv_15= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_17= ',' ( ( ruleQualifiedName ) ) )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==28) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:744:5: otherlv_15= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_17= ',' ( ( ruleQualifiedName ) ) )*
                    {
                    otherlv_15=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleServiceBinding1444); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getServiceBindingAccess().getSLAsKeyword_11_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:748:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:749:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:749:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:750:3: ruleQualifiedName
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
                       
                      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getSlaSLACrossReference_11_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleServiceBinding1471);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:766:2: (otherlv_17= ',' ( ( ruleQualifiedName ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==13) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:766:4: otherlv_17= ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_17=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleServiceBinding1484); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_17, grammarAccess.getServiceBindingAccess().getCommaKeyword_11_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:770:1: ( ( ruleQualifiedName ) )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:771:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:771:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:772:3: ruleQualifiedName
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
                    	       
                    	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getSlaSLACrossReference_11_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleServiceBinding1511);
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
                    	    break loop21;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:788:6: (otherlv_19= 'references-module' ( (lv_referencedModule_20_0= ruleModuleRef ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==29) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:788:8: otherlv_19= 'references-module' ( (lv_referencedModule_20_0= ruleModuleRef ) )
                    {
                    otherlv_19=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleServiceBinding1528); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getServiceBindingAccess().getReferencesModuleKeyword_12_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:792:1: ( (lv_referencedModule_20_0= ruleModuleRef ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:793:1: (lv_referencedModule_20_0= ruleModuleRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:793:1: (lv_referencedModule_20_0= ruleModuleRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:794:3: lv_referencedModule_20_0= ruleModuleRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getReferencedModuleModuleRefParserRuleCall_12_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleModuleRef_in_ruleServiceBinding1549);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:810:4: ( (lv_operation_21_0= ruleOperationBinding ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==30) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:811:1: (lv_operation_21_0= ruleOperationBinding )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:811:1: (lv_operation_21_0= ruleOperationBinding )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:812:3: lv_operation_21_0= ruleOperationBinding
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getOperationOperationBindingParserRuleCall_13_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleOperationBinding_in_ruleServiceBinding1572);
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

            otherlv_22=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleServiceBinding1585); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:840:1: entryRuleServiceRef returns [EObject current=null] : iv_ruleServiceRef= ruleServiceRef EOF ;
    public final EObject entryRuleServiceRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:841:2: (iv_ruleServiceRef= ruleServiceRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:842:2: iv_ruleServiceRef= ruleServiceRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getServiceRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_entryRuleServiceRef1621);
            iv_ruleServiceRef=ruleServiceRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleServiceRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleServiceRef1631); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:849:1: ruleServiceRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) ;
    public final EObject ruleServiceRef() throws RecognitionException {
        EObject current = null;

        EObject lv_versionRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:852:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:853:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:853:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:853:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:853:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:854:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:854:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:855:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleServiceRef1683);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:871:2: ( (lv_versionRef_1_0= ruleVersionRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:872:1: (lv_versionRef_1_0= ruleVersionRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:872:1: (lv_versionRef_1_0= ruleVersionRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:873:3: lv_versionRef_1_0= ruleVersionRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getServiceRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleServiceRef1704);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:897:1: entryRuleBindingProtocol returns [EObject current=null] : iv_ruleBindingProtocol= ruleBindingProtocol EOF ;
    public final EObject entryRuleBindingProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBindingProtocol = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:898:2: (iv_ruleBindingProtocol= ruleBindingProtocol EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:899:2: iv_ruleBindingProtocol= ruleBindingProtocol EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBindingProtocolRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_entryRuleBindingProtocol1740);
            iv_ruleBindingProtocol=ruleBindingProtocol();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBindingProtocol; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBindingProtocol1750); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:906:1: ruleBindingProtocol returns [EObject current=null] : (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP | this_IIOP_9= ruleIIOP | this_AMQP_10= ruleAMQP ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:909:28: ( (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP | this_IIOP_9= ruleIIOP | this_AMQP_10= ruleAMQP ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:910:1: (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP | this_IIOP_9= ruleIIOP | this_AMQP_10= ruleAMQP )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:910:1: (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP | this_IIOP_9= ruleIIOP | this_AMQP_10= ruleAMQP )
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:911:2: this_SCA_0= ruleSCA
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getSCAParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSCA_in_ruleBindingProtocol1800);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:924:2: this_SOAP_1= ruleSOAP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getSOAPParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSOAP_in_ruleBindingProtocol1830);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:937:2: this_EJB_2= ruleEJB
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getEJBParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEJB_in_ruleBindingProtocol1860);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:950:2: this_HTTP_3= ruleHTTP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getHTTPParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleHTTP_in_ruleBindingProtocol1890);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:963:2: this_REST_4= ruleREST
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getRESTParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleREST_in_ruleBindingProtocol1920);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:976:2: this_SAP_5= ruleSAP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getSAPParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSAP_in_ruleBindingProtocol1950);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:989:2: this_JMS_6= ruleJMS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getJMSParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleJMS_in_ruleBindingProtocol1980);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1002:2: this_FILE_7= ruleFILE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getFILEParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFILE_in_ruleBindingProtocol2010);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1015:2: this_FTP_8= ruleFTP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getFTPParserRuleCall_8()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFTP_in_ruleBindingProtocol2040);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1028:2: this_IIOP_9= ruleIIOP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getIIOPParserRuleCall_9()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIIOP_in_ruleBindingProtocol2070);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1041:2: this_AMQP_10= ruleAMQP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getAMQPParserRuleCall_10()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAMQP_in_ruleBindingProtocol2100);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1060:1: entryRuleOperationBinding returns [EObject current=null] : iv_ruleOperationBinding= ruleOperationBinding EOF ;
    public final EObject entryRuleOperationBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationBinding = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1061:2: (iv_ruleOperationBinding= ruleOperationBinding EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1062:2: iv_ruleOperationBinding= ruleOperationBinding EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationBindingRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOperationBinding_in_entryRuleOperationBinding2135);
            iv_ruleOperationBinding=ruleOperationBinding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperationBinding; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperationBinding2145); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1069:1: ruleOperationBinding returns [EObject current=null] : (otherlv_0= 'bind-operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* otherlv_5= 'protocols' otherlv_6= '{' ( (lv_protocol_7_0= ruleBindingProtocol ) )+ otherlv_8= '}' (otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )? (otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )? (otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_23= ',' ( ( ruleQualifiedName ) ) )* )? otherlv_25= '}' ) ;
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
        Token otherlv_23=null;
        Token otherlv_25=null;
        EObject lv_endpointQualifierRefs_3_0 = null;

        EObject lv_governanceDecisions_4_0 = null;

        EObject lv_protocol_7_0 = null;

        EObject lv_providerProtocol_11_0 = null;

        EObject lv_policies_15_0 = null;

        EObject lv_providerPolicies_19_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1072:28: ( (otherlv_0= 'bind-operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* otherlv_5= 'protocols' otherlv_6= '{' ( (lv_protocol_7_0= ruleBindingProtocol ) )+ otherlv_8= '}' (otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )? (otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )? (otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_23= ',' ( ( ruleQualifiedName ) ) )* )? otherlv_25= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1073:1: (otherlv_0= 'bind-operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* otherlv_5= 'protocols' otherlv_6= '{' ( (lv_protocol_7_0= ruleBindingProtocol ) )+ otherlv_8= '}' (otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )? (otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )? (otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_23= ',' ( ( ruleQualifiedName ) ) )* )? otherlv_25= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1073:1: (otherlv_0= 'bind-operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* otherlv_5= 'protocols' otherlv_6= '{' ( (lv_protocol_7_0= ruleBindingProtocol ) )+ otherlv_8= '}' (otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )? (otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )? (otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_23= ',' ( ( ruleQualifiedName ) ) )* )? otherlv_25= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1073:3: otherlv_0= 'bind-operation' ( ( ruleQualifiedName ) ) otherlv_2= '{' ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )* otherlv_5= 'protocols' otherlv_6= '{' ( (lv_protocol_7_0= ruleBindingProtocol ) )+ otherlv_8= '}' (otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )? (otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )? (otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}' )? (otherlv_21= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_23= ',' ( ( ruleQualifiedName ) ) )* )? otherlv_25= '}'
            {
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleOperationBinding2182); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOperationBindingAccess().getBindOperationKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1077:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1078:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1078:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1079:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleOperationBinding2209);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOperationBinding2221); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1099:1: ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==76) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1100:1: (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1100:1: (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1101:3: lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getEndpointQualifierRefsEndpointQualifierRefsParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRefs_in_ruleOperationBinding2242);
                    lv_endpointQualifierRefs_3_0=ruleEndpointQualifierRefs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getOperationBindingRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRefs",
                              		lv_endpointQualifierRefs_3_0, 
                              		"EndpointQualifierRefs");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1117:3: ( (lv_governanceDecisions_4_0= ruleGovernanceDecision ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==87) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1118:1: (lv_governanceDecisions_4_0= ruleGovernanceDecision )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1118:1: (lv_governanceDecisions_4_0= ruleGovernanceDecision )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1119:3: lv_governanceDecisions_4_0= ruleGovernanceDecision
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getGovernanceDecisionsGovernanceDecisionParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleGovernanceDecision_in_ruleOperationBinding2264);
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

            otherlv_5=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleOperationBinding2277); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getOperationBindingAccess().getProtocolsKeyword_5());
                  
            }
            otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOperationBinding2289); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1143:1: ( (lv_protocol_7_0= ruleBindingProtocol ) )+
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
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1144:1: (lv_protocol_7_0= ruleBindingProtocol )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1144:1: (lv_protocol_7_0= ruleBindingProtocol )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1145:3: lv_protocol_7_0= ruleBindingProtocol
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getProtocolBindingProtocolParserRuleCall_7_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleOperationBinding2310);
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

            otherlv_8=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleOperationBinding2323); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_8());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1165:1: (otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==31) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1165:3: otherlv_9= 'provider-protocols' otherlv_10= '{' ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}'
                    {
                    otherlv_9=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleOperationBinding2336); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getOperationBindingAccess().getProviderProtocolsKeyword_9_0());
                          
                    }
                    otherlv_10=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOperationBinding2348); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_9_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1173:1: ( (lv_providerProtocol_11_0= ruleBindingProtocol ) )+
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
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1174:1: (lv_providerProtocol_11_0= ruleBindingProtocol )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1174:1: (lv_providerProtocol_11_0= ruleBindingProtocol )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1175:3: lv_providerProtocol_11_0= ruleBindingProtocol
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getProviderProtocolBindingProtocolParserRuleCall_9_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleOperationBinding2369);
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

                    otherlv_12=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleOperationBinding2382); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_9_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1195:3: (otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==27) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1195:5: otherlv_13= 'policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}'
                    {
                    otherlv_13=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleOperationBinding2397); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getOperationBindingAccess().getPoliciesKeyword_10_0());
                          
                    }
                    otherlv_14=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOperationBinding2409); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_10_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1203:1: ( (lv_policies_15_0= rulePolicy ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( ((LA31_0>=67 && LA31_0<=68)||(LA31_0>=73 && LA31_0<=75)) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1204:1: (lv_policies_15_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1204:1: (lv_policies_15_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1205:3: lv_policies_15_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getPoliciesPolicyParserRuleCall_10_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleOperationBinding2430);
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

                    otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleOperationBinding2443); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_10_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1225:3: (otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==32) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1225:5: otherlv_17= 'provider-policies' otherlv_18= '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* otherlv_20= '}'
                    {
                    otherlv_17=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleOperationBinding2458); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getOperationBindingAccess().getProviderPoliciesKeyword_11_0());
                          
                    }
                    otherlv_18=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOperationBinding2470); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_11_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1233:1: ( (lv_providerPolicies_19_0= rulePolicy ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( ((LA33_0>=67 && LA33_0<=68)||(LA33_0>=73 && LA33_0<=75)) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1234:1: (lv_providerPolicies_19_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1234:1: (lv_providerPolicies_19_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1235:3: lv_providerPolicies_19_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getProviderPoliciesPolicyParserRuleCall_11_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleOperationBinding2491);
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

                    otherlv_20=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleOperationBinding2504); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_11_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1255:3: (otherlv_21= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_23= ',' ( ( ruleQualifiedName ) ) )* )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==28) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1255:5: otherlv_21= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_23= ',' ( ( ruleQualifiedName ) ) )*
                    {
                    otherlv_21=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleOperationBinding2519); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_21, grammarAccess.getOperationBindingAccess().getSLAsKeyword_12_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1259:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1260:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1260:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1261:3: ruleQualifiedName
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
                       
                      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getSlaSLACrossReference_12_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleOperationBinding2546);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1277:2: (otherlv_23= ',' ( ( ruleQualifiedName ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==13) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1277:4: otherlv_23= ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_23=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleOperationBinding2559); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_23, grammarAccess.getOperationBindingAccess().getCommaKeyword_12_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1281:1: ( ( ruleQualifiedName ) )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1282:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1282:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1283:3: ruleQualifiedName
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
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getSlaSLACrossReference_12_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleOperationBinding2586);
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
                    	    break loop35;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_25=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleOperationBinding2602); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1311:1: entryRuleSOAP returns [EObject current=null] : iv_ruleSOAP= ruleSOAP EOF ;
    public final EObject entryRuleSOAP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSOAP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1312:2: (iv_ruleSOAP= ruleSOAP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1313:2: iv_ruleSOAP= ruleSOAP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSOAPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSOAP_in_entryRuleSOAP2638);
            iv_ruleSOAP=ruleSOAP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSOAP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSOAP2648); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1320:1: ruleSOAP returns [EObject current=null] : (otherlv_0= 'SOAP' otherlv_1= '{' () ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )? (otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) ) )? (otherlv_9= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_10_0= RULE_STRING ) ) )? otherlv_11= '}' ) ;
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
        EObject lv_endpointQualifierRefs_3_0 = null;

        EObject lv_endpointConnector_4_0 = null;

        Enumerator lv_style_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1323:28: ( (otherlv_0= 'SOAP' otherlv_1= '{' () ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )? (otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) ) )? (otherlv_9= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_10_0= RULE_STRING ) ) )? otherlv_11= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1324:1: (otherlv_0= 'SOAP' otherlv_1= '{' () ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )? (otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) ) )? (otherlv_9= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_10_0= RULE_STRING ) ) )? otherlv_11= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1324:1: (otherlv_0= 'SOAP' otherlv_1= '{' () ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )? (otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) ) )? (otherlv_9= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_10_0= RULE_STRING ) ) )? otherlv_11= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1324:3: otherlv_0= 'SOAP' otherlv_1= '{' () ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )? (otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) ) )? (otherlv_9= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_10_0= RULE_STRING ) ) )? otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleSOAP2685); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSOAPAccess().getSOAPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSOAP2697); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSOAPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1332:1: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1333:2: 
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1341:2: ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==76) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1342:1: (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1342:1: (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1343:3: lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSOAPAccess().getEndpointQualifierRefsEndpointQualifierRefsParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRefs_in_ruleSOAP2730);
                    lv_endpointQualifierRefs_3_0=ruleEndpointQualifierRefs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSOAPRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRefs",
                              		lv_endpointQualifierRefs_3_0, 
                              		"EndpointQualifierRefs");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1359:3: ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==11) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1360:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1360:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1361:3: lv_endpointConnector_4_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSOAPAccess().getEndpointConnectorConnectorQualifierParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleSOAP2752);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1377:3: (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==34) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1377:5: otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) )
                    {
                    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleSOAP2766); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSOAPAccess().getStyleKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1381:1: ( (lv_style_6_0= ruleSOAPStyle ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1382:1: (lv_style_6_0= ruleSOAPStyle )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1382:1: (lv_style_6_0= ruleSOAPStyle )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1383:3: lv_style_6_0= ruleSOAPStyle
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSOAPAccess().getStyleSOAPStyleEnumRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSOAPStyle_in_ruleSOAP2787);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1399:4: (otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==35) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1399:6: otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleSOAP2802); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getSOAPAccess().getHttpContextRootKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1403:1: ( (lv_contextRoot_8_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1404:1: (lv_contextRoot_8_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1404:1: (lv_contextRoot_8_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1405:3: lv_contextRoot_8_0= RULE_STRING
                    {
                    lv_contextRoot_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSOAP2819); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1421:4: (otherlv_9= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_10_0= RULE_STRING ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==36) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1421:6: otherlv_9= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleSOAP2839); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getSOAPAccess().getProvidedWSDLUrlKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1425:1: ( (lv_providedWsdlUrl_10_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1426:1: (lv_providedWsdlUrl_10_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1426:1: (lv_providedWsdlUrl_10_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1427:3: lv_providedWsdlUrl_10_0= RULE_STRING
                    {
                    lv_providedWsdlUrl_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSOAP2856); if (state.failed) return current;
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

            otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleSOAP2875); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1455:1: entryRuleSAP returns [EObject current=null] : iv_ruleSAP= ruleSAP EOF ;
    public final EObject entryRuleSAP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1456:2: (iv_ruleSAP= ruleSAP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1457:2: iv_ruleSAP= ruleSAP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSAPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSAP_in_entryRuleSAP2911);
            iv_ruleSAP=ruleSAP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSAP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSAP2921); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1464:1: ruleSAP returns [EObject current=null] : (otherlv_0= 'SAP' otherlv_1= '{' () ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) ) )? (otherlv_7= 'client' ( ( ruleQualifiedName ) ) )? otherlv_9= '}' ) ;
    public final EObject ruleSAP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_endpointQualifierRefs_3_0 = null;

        EObject lv_endpointConnector_4_0 = null;

        Enumerator lv_transport_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1467:28: ( (otherlv_0= 'SAP' otherlv_1= '{' () ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) ) )? (otherlv_7= 'client' ( ( ruleQualifiedName ) ) )? otherlv_9= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1468:1: (otherlv_0= 'SAP' otherlv_1= '{' () ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) ) )? (otherlv_7= 'client' ( ( ruleQualifiedName ) ) )? otherlv_9= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1468:1: (otherlv_0= 'SAP' otherlv_1= '{' () ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) ) )? (otherlv_7= 'client' ( ( ruleQualifiedName ) ) )? otherlv_9= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1468:3: otherlv_0= 'SAP' otherlv_1= '{' () ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? (otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) ) )? (otherlv_7= 'client' ( ( ruleQualifiedName ) ) )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleSAP2958); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSAPAccess().getSAPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSAP2970); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSAPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1476:1: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1477:2: 
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1485:2: ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==76) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1486:1: (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1486:1: (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1487:3: lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSAPAccess().getEndpointQualifierRefsEndpointQualifierRefsParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRefs_in_ruleSAP3003);
                    lv_endpointQualifierRefs_3_0=ruleEndpointQualifierRefs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSAPRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRefs",
                              		lv_endpointQualifierRefs_3_0, 
                              		"EndpointQualifierRefs");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1503:3: ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==11) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1504:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1504:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1505:3: lv_endpointConnector_4_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSAPAccess().getEndpointConnectorConnectorQualifierParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleSAP3025);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1521:3: (otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==38) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1521:5: otherlv_5= 'transport' ( (lv_transport_6_0= ruleSAPTransport ) )
                    {
                    otherlv_5=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleSAP3039); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSAPAccess().getTransportKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1525:1: ( (lv_transport_6_0= ruleSAPTransport ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1526:1: (lv_transport_6_0= ruleSAPTransport )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1526:1: (lv_transport_6_0= ruleSAPTransport )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1527:3: lv_transport_6_0= ruleSAPTransport
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSAPAccess().getTransportSAPTransportEnumRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSAPTransport_in_ruleSAP3060);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1543:4: (otherlv_7= 'client' ( ( ruleQualifiedName ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==39) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1543:6: otherlv_7= 'client' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleSAP3075); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getSAPAccess().getClientKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1547:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1548:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1548:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1549:3: ruleQualifiedName
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
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSAP3102);
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

            otherlv_9=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleSAP3116); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1577:1: entryRuleEJB returns [EObject current=null] : iv_ruleEJB= ruleEJB EOF ;
    public final EObject entryRuleEJB() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEJB = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1578:2: (iv_ruleEJB= ruleEJB EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1579:2: iv_ruleEJB= ruleEJB EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEJBRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEJB_in_entryRuleEJB3152);
            iv_ruleEJB=ruleEJB();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEJB; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEJB3162); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1586:1: ruleEJB returns [EObject current=null] : (otherlv_0= 'EJB' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) otherlv_6= '}' ) ;
    public final EObject ruleEJB() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token lv_jndiName_5_0=null;
        Token otherlv_6=null;
        EObject lv_endpointQualifierRefs_2_0 = null;

        EObject lv_endpointConnector_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1589:28: ( (otherlv_0= 'EJB' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) otherlv_6= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1590:1: (otherlv_0= 'EJB' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) otherlv_6= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1590:1: (otherlv_0= 'EJB' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) otherlv_6= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1590:3: otherlv_0= 'EJB' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleEJB3199); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEJBAccess().getEJBKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleEJB3211); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEJBAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1598:1: ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==76) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1599:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1599:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1600:3: lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEJBAccess().getEndpointQualifierRefsEndpointQualifierRefsParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRefs_in_ruleEJB3232);
                    lv_endpointQualifierRefs_2_0=ruleEndpointQualifierRefs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEJBRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRefs",
                              		lv_endpointQualifierRefs_2_0, 
                              		"EndpointQualifierRefs");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1616:3: ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==11) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1617:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1617:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1618:3: lv_endpointConnector_3_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEJBAccess().getEndpointConnectorConnectorQualifierParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleEJB3254);
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

            otherlv_4=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleEJB3267); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEJBAccess().getJndiNameKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1638:1: ( (lv_jndiName_5_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1639:1: (lv_jndiName_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1639:1: (lv_jndiName_5_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1640:3: lv_jndiName_5_0= RULE_STRING
            {
            lv_jndiName_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEJB3284); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleEJB3301); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1668:1: entryRuleHTTP returns [EObject current=null] : iv_ruleHTTP= ruleHTTP EOF ;
    public final EObject entryRuleHTTP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1669:2: (iv_ruleHTTP= ruleHTTP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1670:2: iv_ruleHTTP= ruleHTTP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHTTPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleHTTP_in_entryRuleHTTP3337);
            iv_ruleHTTP=ruleHTTP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHTTP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHTTP3347); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1677:1: ruleHTTP returns [EObject current=null] : (otherlv_0= 'HTTP' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= '}' ) ;
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
        EObject lv_endpointQualifierRefs_2_0 = null;

        EObject lv_endpointConnector_3_0 = null;

        Enumerator lv_verb_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1680:28: ( (otherlv_0= 'HTTP' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1681:1: (otherlv_0= 'HTTP' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1681:1: (otherlv_0= 'HTTP' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1681:3: otherlv_0= 'HTTP' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleHTTP3384); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getHTTPAccess().getHTTPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleHTTP3396); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getHTTPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1689:1: ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==76) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1690:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1690:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1691:3: lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getHTTPAccess().getEndpointQualifierRefsEndpointQualifierRefsParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRefs_in_ruleHTTP3417);
                    lv_endpointQualifierRefs_2_0=ruleEndpointQualifierRefs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getHTTPRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRefs",
                              		lv_endpointQualifierRefs_2_0, 
                              		"EndpointQualifierRefs");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1707:3: ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==11) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1708:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1708:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1709:3: lv_endpointConnector_3_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getHTTPAccess().getEndpointConnectorConnectorQualifierParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleHTTP3439);
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

            otherlv_4=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleHTTP3452); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getHTTPAccess().getUrlKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1729:1: ( (lv_url_5_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1730:1: (lv_url_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1730:1: (lv_url_5_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1731:3: lv_url_5_0= RULE_STRING
            {
            lv_url_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleHTTP3469); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleHTTP3486); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getHTTPAccess().getProviderUrlKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1751:1: ( (lv_providerUrl_7_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1752:1: (lv_providerUrl_7_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1752:1: (lv_providerUrl_7_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1753:3: lv_providerUrl_7_0= RULE_STRING
            {
            lv_providerUrl_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleHTTP3503); if (state.failed) return current;
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

            otherlv_8=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleHTTP3520); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getHTTPAccess().getVerbKeyword_8());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1773:1: ( (lv_verb_9_0= ruleVerb ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1774:1: (lv_verb_9_0= ruleVerb )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1774:1: (lv_verb_9_0= ruleVerb )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1775:3: lv_verb_9_0= ruleVerb
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getHTTPAccess().getVerbVerbEnumRuleCall_9_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVerb_in_ruleHTTP3541);
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

            otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleHTTP3553); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1803:1: entryRuleREST returns [EObject current=null] : iv_ruleREST= ruleREST EOF ;
    public final EObject entryRuleREST() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleREST = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1804:2: (iv_ruleREST= ruleREST EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1805:2: iv_ruleREST= ruleREST EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRESTRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleREST_in_entryRuleREST3589);
            iv_ruleREST=ruleREST();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleREST; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleREST3599); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1812:1: ruleREST returns [EObject current=null] : (otherlv_0= 'REST' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'path' ( (lv_path_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) (otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) )? (otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) ) )? (otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) ) )? otherlv_16= '}' ) ;
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
        EObject lv_endpointQualifierRefs_2_0 = null;

        EObject lv_endpointConnector_3_0 = null;

        Enumerator lv_verb_9_0 = null;

        Enumerator lv_format_11_0 = null;

        Enumerator lv_consumesFormat_13_0 = null;

        Enumerator lv_provideFormat_15_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1815:28: ( (otherlv_0= 'REST' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'path' ( (lv_path_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) (otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) )? (otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) ) )? (otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) ) )? otherlv_16= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1816:1: (otherlv_0= 'REST' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'path' ( (lv_path_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) (otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) )? (otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) ) )? (otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) ) )? otherlv_16= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1816:1: (otherlv_0= 'REST' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'path' ( (lv_path_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) (otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) )? (otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) ) )? (otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) ) )? otherlv_16= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1816:3: otherlv_0= 'REST' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'path' ( (lv_path_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) (otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) )? (otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) ) )? (otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) ) )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleREST3636); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRESTAccess().getRESTKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleREST3648); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRESTAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1824:1: ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==76) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1825:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1825:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1826:3: lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRESTAccess().getEndpointQualifierRefsEndpointQualifierRefsParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRefs_in_ruleREST3669);
                    lv_endpointQualifierRefs_2_0=ruleEndpointQualifierRefs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRESTRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRefs",
                              		lv_endpointQualifierRefs_2_0, 
                              		"EndpointQualifierRefs");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1842:3: ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==11) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1843:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1843:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1844:3: lv_endpointConnector_3_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRESTAccess().getEndpointConnectorConnectorQualifierParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleREST3691);
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

            otherlv_4=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleREST3704); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getRESTAccess().getPathKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1864:1: ( (lv_path_5_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1865:1: (lv_path_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1865:1: (lv_path_5_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1866:3: lv_path_5_0= RULE_STRING
            {
            lv_path_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleREST3721); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleREST3738); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getRESTAccess().getProviderUrlKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1886:1: ( (lv_providerUrl_7_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1887:1: (lv_providerUrl_7_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1887:1: (lv_providerUrl_7_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1888:3: lv_providerUrl_7_0= RULE_STRING
            {
            lv_providerUrl_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleREST3755); if (state.failed) return current;
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

            otherlv_8=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleREST3772); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getRESTAccess().getVerbKeyword_8());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1908:1: ( (lv_verb_9_0= ruleVerb ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1909:1: (lv_verb_9_0= ruleVerb )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1909:1: (lv_verb_9_0= ruleVerb )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1910:3: lv_verb_9_0= ruleVerb
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRESTAccess().getVerbVerbEnumRuleCall_9_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVerb_in_ruleREST3793);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1926:2: (otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==48) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1926:4: otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) )
                    {
                    otherlv_10=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleREST3806); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getRESTAccess().getFormatKeyword_10_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1930:1: ( (lv_format_11_0= ruleRESTFormat ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1931:1: (lv_format_11_0= ruleRESTFormat )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1931:1: (lv_format_11_0= ruleRESTFormat )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1932:3: lv_format_11_0= ruleRESTFormat
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRESTAccess().getFormatRESTFormatEnumRuleCall_10_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRESTFormat_in_ruleREST3827);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1948:4: (otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==49) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1948:6: otherlv_12= 'consumes-format' ( (lv_consumesFormat_13_0= ruleRESTFormat ) )
                    {
                    otherlv_12=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleREST3842); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getRESTAccess().getConsumesFormatKeyword_11_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1952:1: ( (lv_consumesFormat_13_0= ruleRESTFormat ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1953:1: (lv_consumesFormat_13_0= ruleRESTFormat )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1953:1: (lv_consumesFormat_13_0= ruleRESTFormat )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1954:3: lv_consumesFormat_13_0= ruleRESTFormat
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRESTAccess().getConsumesFormatRESTFormatEnumRuleCall_11_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRESTFormat_in_ruleREST3863);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1970:4: (otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==50) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1970:6: otherlv_14= 'provides-format' ( (lv_provideFormat_15_0= ruleRESTFormat ) )
                    {
                    otherlv_14=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleREST3878); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getRESTAccess().getProvidesFormatKeyword_12_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1974:1: ( (lv_provideFormat_15_0= ruleRESTFormat ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1975:1: (lv_provideFormat_15_0= ruleRESTFormat )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1975:1: (lv_provideFormat_15_0= ruleRESTFormat )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1976:3: lv_provideFormat_15_0= ruleRESTFormat
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRESTAccess().getProvideFormatRESTFormatEnumRuleCall_12_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRESTFormat_in_ruleREST3899);
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

            otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleREST3913); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2004:1: entryRuleJMS returns [EObject current=null] : iv_ruleJMS= ruleJMS EOF ;
    public final EObject entryRuleJMS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJMS = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2005:2: (iv_ruleJMS= ruleJMS EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2006:2: iv_ruleJMS= ruleJMS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJMSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleJMS_in_entryRuleJMS3949);
            iv_ruleJMS=ruleJMS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJMS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleJMS3959); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2013:1: ruleJMS returns [EObject current=null] : (otherlv_0= 'JMS' otherlv_1= '{' () ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) ;
    public final EObject ruleJMS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_6=null;
        Token lv_jndiName_7_0=null;
        Token otherlv_8=null;
        Token lv_providerJndi_9_0=null;
        Token otherlv_10=null;
        EObject lv_endpointQualifierRefs_3_0 = null;

        EObject lv_endpointConnector_4_0 = null;

        EObject lv_channel_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2016:28: ( (otherlv_0= 'JMS' otherlv_1= '{' () ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2017:1: (otherlv_0= 'JMS' otherlv_1= '{' () ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2017:1: (otherlv_0= 'JMS' otherlv_1= '{' () ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2017:3: otherlv_0= 'JMS' otherlv_1= '{' () ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleJMS3996); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJMSAccess().getJMSKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleJMS4008); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJMSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2025:1: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2026:2: 
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2034:2: ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==76) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2035:1: (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2035:1: (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2036:3: lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJMSAccess().getEndpointQualifierRefsEndpointQualifierRefsParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRefs_in_ruleJMS4041);
                    lv_endpointQualifierRefs_3_0=ruleEndpointQualifierRefs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJMSRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRefs",
                              		lv_endpointQualifierRefs_3_0, 
                              		"EndpointQualifierRefs");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2052:3: ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==11) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2053:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2053:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2054:3: lv_endpointConnector_4_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJMSAccess().getEndpointConnectorConnectorQualifierParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleJMS4063);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2070:3: ( (lv_channel_5_0= ruleTopicOrQueue ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( ((LA57_0>=53 && LA57_0<=54)) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2071:1: (lv_channel_5_0= ruleTopicOrQueue )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2071:1: (lv_channel_5_0= ruleTopicOrQueue )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2072:3: lv_channel_5_0= ruleTopicOrQueue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJMSAccess().getChannelTopicOrQueueParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTopicOrQueue_in_ruleJMS4085);
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

            otherlv_6=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleJMS4098); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getJMSAccess().getJndiNameKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2092:1: ( (lv_jndiName_7_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2093:1: (lv_jndiName_7_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2093:1: (lv_jndiName_7_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2094:3: lv_jndiName_7_0= RULE_STRING
            {
            lv_jndiName_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleJMS4115); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2110:2: (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==52) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2110:4: otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleJMS4133); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getJMSAccess().getProviderJndiNameKeyword_8_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2114:1: ( (lv_providerJndi_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2115:1: (lv_providerJndi_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2115:1: (lv_providerJndi_9_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2116:3: lv_providerJndi_9_0= RULE_STRING
                    {
                    lv_providerJndi_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleJMS4150); if (state.failed) return current;
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

            otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleJMS4169); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2144:1: entryRuleTopicOrQueue returns [EObject current=null] : iv_ruleTopicOrQueue= ruleTopicOrQueue EOF ;
    public final EObject entryRuleTopicOrQueue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopicOrQueue = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2145:2: (iv_ruleTopicOrQueue= ruleTopicOrQueue EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2146:2: iv_ruleTopicOrQueue= ruleTopicOrQueue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTopicOrQueueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTopicOrQueue_in_entryRuleTopicOrQueue4205);
            iv_ruleTopicOrQueue=ruleTopicOrQueue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTopicOrQueue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTopicOrQueue4215); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2153:1: ruleTopicOrQueue returns [EObject current=null] : (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue ) ;
    public final EObject ruleTopicOrQueue() throws RecognitionException {
        EObject current = null;

        EObject this_Topic_0 = null;

        EObject this_Queue_1 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2156:28: ( (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2157:1: (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2157:1: (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue )
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2158:2: this_Topic_0= ruleTopic
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTopicOrQueueAccess().getTopicParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTopic_in_ruleTopicOrQueue4265);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2171:2: this_Queue_1= ruleQueue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTopicOrQueueAccess().getQueueParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQueue_in_ruleTopicOrQueue4295);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2190:1: entryRuleTopic returns [EObject current=null] : iv_ruleTopic= ruleTopic EOF ;
    public final EObject entryRuleTopic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopic = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2191:2: (iv_ruleTopic= ruleTopic EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2192:2: iv_ruleTopic= ruleTopic EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTopicRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTopic_in_entryRuleTopic4330);
            iv_ruleTopic=ruleTopic();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTopic; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTopic4340); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2199:1: ruleTopic returns [EObject current=null] : (otherlv_0= 'topic' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ) ;
    public final EObject ruleTopic() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_endpointQualifierRefs_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2202:28: ( (otherlv_0= 'topic' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2203:1: (otherlv_0= 'topic' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2203:1: (otherlv_0= 'topic' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2203:3: otherlv_0= 'topic' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )?
            {
            otherlv_0=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleTopic4377); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTopicAccess().getTopicKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2207:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2208:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2208:1: (lv_name_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2209:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleTopic4394); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2225:2: ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==76) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2226:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2226:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2227:3: lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTopicAccess().getEndpointQualifierRefsEndpointQualifierRefsParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRefs_in_ruleTopic4420);
                    lv_endpointQualifierRefs_2_0=ruleEndpointQualifierRefs();

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
                              		"EndpointQualifierRefs");
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2251:1: entryRuleQueue returns [EObject current=null] : iv_ruleQueue= ruleQueue EOF ;
    public final EObject entryRuleQueue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueue = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2252:2: (iv_ruleQueue= ruleQueue EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2253:2: iv_ruleQueue= ruleQueue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQueueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQueue_in_entryRuleQueue4457);
            iv_ruleQueue=ruleQueue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQueue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQueue4467); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2260:1: ruleQueue returns [EObject current=null] : (otherlv_0= 'queue' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ) ;
    public final EObject ruleQueue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_endpointQualifierRefs_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2263:28: ( (otherlv_0= 'queue' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2264:1: (otherlv_0= 'queue' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2264:1: (otherlv_0= 'queue' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2264:3: otherlv_0= 'queue' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )?
            {
            otherlv_0=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleQueue4504); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getQueueAccess().getQueueKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2268:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2269:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2269:1: (lv_name_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2270:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleQueue4521); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2286:2: ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==76) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2287:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2287:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2288:3: lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getQueueAccess().getEndpointQualifierRefsEndpointQualifierRefsParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRefs_in_ruleQueue4547);
                    lv_endpointQualifierRefs_2_0=ruleEndpointQualifierRefs();

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
                              		"EndpointQualifierRefs");
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2312:1: entryRuleSCA returns [EObject current=null] : iv_ruleSCA= ruleSCA EOF ;
    public final EObject entryRuleSCA() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSCA = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2313:2: (iv_ruleSCA= ruleSCA EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2314:2: iv_ruleSCA= ruleSCA EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSCARule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSCA_in_entryRuleSCA4584);
            iv_ruleSCA=ruleSCA();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSCA; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSCA4594); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2321:1: ruleSCA returns [EObject current=null] : ( () otherlv_1= 'SCA' ( (lv_name_2_0= RULE_STRING ) )? otherlv_3= '{' ( (lv_endpointQualifierRefs_4_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_5_0= ruleConnectorQualifier ) )? (otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) ) )? (otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? )? otherlv_11= '}' ) ;
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
        EObject lv_endpointQualifierRefs_4_0 = null;

        EObject lv_endpointConnector_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2324:28: ( ( () otherlv_1= 'SCA' ( (lv_name_2_0= RULE_STRING ) )? otherlv_3= '{' ( (lv_endpointQualifierRefs_4_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_5_0= ruleConnectorQualifier ) )? (otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) ) )? (otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? )? otherlv_11= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2325:1: ( () otherlv_1= 'SCA' ( (lv_name_2_0= RULE_STRING ) )? otherlv_3= '{' ( (lv_endpointQualifierRefs_4_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_5_0= ruleConnectorQualifier ) )? (otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) ) )? (otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? )? otherlv_11= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2325:1: ( () otherlv_1= 'SCA' ( (lv_name_2_0= RULE_STRING ) )? otherlv_3= '{' ( (lv_endpointQualifierRefs_4_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_5_0= ruleConnectorQualifier ) )? (otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) ) )? (otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? )? otherlv_11= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2325:2: () otherlv_1= 'SCA' ( (lv_name_2_0= RULE_STRING ) )? otherlv_3= '{' ( (lv_endpointQualifierRefs_4_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_5_0= ruleConnectorQualifier ) )? (otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) ) )? (otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? )? otherlv_11= '}'
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2325:2: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2326:2: 
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

            otherlv_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleSCA4643); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSCAAccess().getSCAKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2338:1: ( (lv_name_2_0= RULE_STRING ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==RULE_STRING) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2339:1: (lv_name_2_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2339:1: (lv_name_2_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2340:3: lv_name_2_0= RULE_STRING
                    {
                    lv_name_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSCA4660); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSCA4678); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getSCAAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2360:1: ( (lv_endpointQualifierRefs_4_0= ruleEndpointQualifierRefs ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==76) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2361:1: (lv_endpointQualifierRefs_4_0= ruleEndpointQualifierRefs )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2361:1: (lv_endpointQualifierRefs_4_0= ruleEndpointQualifierRefs )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2362:3: lv_endpointQualifierRefs_4_0= ruleEndpointQualifierRefs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSCAAccess().getEndpointQualifierRefsEndpointQualifierRefsParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRefs_in_ruleSCA4699);
                    lv_endpointQualifierRefs_4_0=ruleEndpointQualifierRefs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSCARule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRefs",
                              		lv_endpointQualifierRefs_4_0, 
                              		"EndpointQualifierRefs");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2378:3: ( (lv_endpointConnector_5_0= ruleConnectorQualifier ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==11) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2379:1: (lv_endpointConnector_5_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2379:1: (lv_endpointConnector_5_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2380:3: lv_endpointConnector_5_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSCAAccess().getEndpointConnectorConnectorQualifierParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleSCA4721);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2396:3: (otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==56) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2396:5: otherlv_6= 'promote' ( (lv_promote_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleSCA4735); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getSCAAccess().getPromoteKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2400:1: ( (lv_promote_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2401:1: (lv_promote_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2401:1: (lv_promote_7_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2402:3: lv_promote_7_0= RULE_STRING
                    {
                    lv_promote_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSCA4752); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2418:4: (otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==57) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2418:6: otherlv_8= 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )?
                    {
                    otherlv_8=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleSCA4772); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getSCAAccess().getReferenceKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2422:1: ( (lv_reference_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2423:1: (lv_reference_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2423:1: (lv_reference_9_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2424:3: lv_reference_9_0= RULE_STRING
                    {
                    lv_reference_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSCA4789); if (state.failed) return current;
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

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2440:2: ( (lv_isMultipleRef_10_0= '[]' ) )?
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==58) ) {
                        alt66=1;
                    }
                    switch (alt66) {
                        case 1 :
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2441:1: (lv_isMultipleRef_10_0= '[]' )
                            {
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2441:1: (lv_isMultipleRef_10_0= '[]' )
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2442:3: lv_isMultipleRef_10_0= '[]'
                            {
                            lv_isMultipleRef_10_0=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleSCA4812); if (state.failed) return current;
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

            otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleSCA4840); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2467:1: entryRuleFILE returns [EObject current=null] : iv_ruleFILE= ruleFILE EOF ;
    public final EObject entryRuleFILE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFILE = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2468:2: (iv_ruleFILE= ruleFILE EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2469:2: iv_ruleFILE= ruleFILE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFILERule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFILE_in_entryRuleFILE4876);
            iv_ruleFILE=ruleFILE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFILE; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFILE4886); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2476:1: ruleFILE returns [EObject current=null] : (otherlv_0= 'FILE' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? ( (lv_url_4_0= RULE_STRING ) ) ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) ;
    public final EObject ruleFILE() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_url_4_0=null;
        Token otherlv_6=null;
        Token lv_pollIntervall_7_0=null;
        Token otherlv_8=null;
        EObject lv_endpointQualifierRefs_2_0 = null;

        EObject lv_endpointConnector_3_0 = null;

        Enumerator lv_accessType_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2479:28: ( (otherlv_0= 'FILE' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? ( (lv_url_4_0= RULE_STRING ) ) ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2480:1: (otherlv_0= 'FILE' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? ( (lv_url_4_0= RULE_STRING ) ) ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2480:1: (otherlv_0= 'FILE' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? ( (lv_url_4_0= RULE_STRING ) ) ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2480:3: otherlv_0= 'FILE' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? ( (lv_url_4_0= RULE_STRING ) ) ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleFILE4923); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFILEAccess().getFILEKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleFILE4935); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFILEAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2488:1: ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==76) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2489:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2489:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2490:3: lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFILEAccess().getEndpointQualifierRefsEndpointQualifierRefsParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRefs_in_ruleFILE4956);
                    lv_endpointQualifierRefs_2_0=ruleEndpointQualifierRefs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFILERule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRefs",
                              		lv_endpointQualifierRefs_2_0, 
                              		"EndpointQualifierRefs");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2506:3: ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==11) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2507:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2507:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2508:3: lv_endpointConnector_3_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFILEAccess().getEndpointConnectorConnectorQualifierParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleFILE4978);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2524:3: ( (lv_url_4_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2525:1: (lv_url_4_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2525:1: (lv_url_4_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2526:3: lv_url_4_0= RULE_STRING
            {
            lv_url_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFILE4996); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2542:2: ( (lv_accessType_5_0= ruleReadWrite ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2543:1: (lv_accessType_5_0= ruleReadWrite )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2543:1: (lv_accessType_5_0= ruleReadWrite )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2544:3: lv_accessType_5_0= ruleReadWrite
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFILEAccess().getAccessTypeReadWriteEnumRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleReadWrite_in_ruleFILE5022);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2560:2: (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==60) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2560:4: otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleFILE5035); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getFILEAccess().getIntervalKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2564:1: ( (lv_pollIntervall_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2565:1: (lv_pollIntervall_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2565:1: (lv_pollIntervall_7_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2566:3: lv_pollIntervall_7_0= RULE_STRING
                    {
                    lv_pollIntervall_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFILE5052); if (state.failed) return current;
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

            otherlv_8=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleFILE5071); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2594:1: entryRuleFTP returns [EObject current=null] : iv_ruleFTP= ruleFTP EOF ;
    public final EObject entryRuleFTP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFTP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2595:2: (iv_ruleFTP= ruleFTP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2596:2: iv_ruleFTP= ruleFTP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFTPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFTP_in_entryRuleFTP5107);
            iv_ruleFTP=ruleFTP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFTP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFTP5117); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2603:1: ruleFTP returns [EObject current=null] : (otherlv_0= 'FTP' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'access' ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) ;
    public final EObject ruleFTP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_pollIntervall_7_0=null;
        Token otherlv_8=null;
        EObject lv_endpointQualifierRefs_2_0 = null;

        EObject lv_endpointConnector_3_0 = null;

        Enumerator lv_accessType_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2606:28: ( (otherlv_0= 'FTP' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'access' ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2607:1: (otherlv_0= 'FTP' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'access' ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2607:1: (otherlv_0= 'FTP' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'access' ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2607:3: otherlv_0= 'FTP' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'access' ( (lv_accessType_5_0= ruleReadWrite ) ) (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleFTP5154); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFTPAccess().getFTPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleFTP5166); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFTPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2615:1: ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==76) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2616:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2616:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2617:3: lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFTPAccess().getEndpointQualifierRefsEndpointQualifierRefsParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRefs_in_ruleFTP5187);
                    lv_endpointQualifierRefs_2_0=ruleEndpointQualifierRefs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFTPRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRefs",
                              		lv_endpointQualifierRefs_2_0, 
                              		"EndpointQualifierRefs");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2633:3: ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==11) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2634:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2634:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2635:3: lv_endpointConnector_3_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFTPAccess().getEndpointConnectorConnectorQualifierParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleFTP5209);
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

            otherlv_4=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleFTP5222); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getFTPAccess().getAccessKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2655:1: ( (lv_accessType_5_0= ruleReadWrite ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2656:1: (lv_accessType_5_0= ruleReadWrite )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2656:1: (lv_accessType_5_0= ruleReadWrite )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2657:3: lv_accessType_5_0= ruleReadWrite
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFTPAccess().getAccessTypeReadWriteEnumRuleCall_5_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleReadWrite_in_ruleFTP5243);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2673:2: (otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==60) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2673:4: otherlv_6= 'interval' ( (lv_pollIntervall_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleFTP5256); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getFTPAccess().getIntervalKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2677:1: ( (lv_pollIntervall_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2678:1: (lv_pollIntervall_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2678:1: (lv_pollIntervall_7_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2679:3: lv_pollIntervall_7_0= RULE_STRING
                    {
                    lv_pollIntervall_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFTP5273); if (state.failed) return current;
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

            otherlv_8=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleFTP5292); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2707:1: entryRuleIIOP returns [EObject current=null] : iv_ruleIIOP= ruleIIOP EOF ;
    public final EObject entryRuleIIOP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIIOP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2708:2: (iv_ruleIIOP= ruleIIOP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2709:2: iv_ruleIIOP= ruleIIOP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIIOPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIIOP_in_entryRuleIIOP5328);
            iv_ruleIIOP=ruleIIOP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIIOP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIIOP5338); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2716:1: ruleIIOP returns [EObject current=null] : (otherlv_0= 'IIOP' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'lookup-name' ( (lv_lookupName_5_0= RULE_STRING ) ) otherlv_6= '}' ) ;
    public final EObject ruleIIOP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token lv_lookupName_5_0=null;
        Token otherlv_6=null;
        EObject lv_endpointQualifierRefs_2_0 = null;

        EObject lv_endpointConnector_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2719:28: ( (otherlv_0= 'IIOP' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'lookup-name' ( (lv_lookupName_5_0= RULE_STRING ) ) otherlv_6= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2720:1: (otherlv_0= 'IIOP' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'lookup-name' ( (lv_lookupName_5_0= RULE_STRING ) ) otherlv_6= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2720:1: (otherlv_0= 'IIOP' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'lookup-name' ( (lv_lookupName_5_0= RULE_STRING ) ) otherlv_6= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2720:3: otherlv_0= 'IIOP' otherlv_1= '{' ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )? otherlv_4= 'lookup-name' ( (lv_lookupName_5_0= RULE_STRING ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleIIOP5375); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIIOPAccess().getIIOPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleIIOP5387); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getIIOPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2728:1: ( (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==76) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2729:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2729:1: (lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2730:3: lv_endpointQualifierRefs_2_0= ruleEndpointQualifierRefs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIIOPAccess().getEndpointQualifierRefsEndpointQualifierRefsParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRefs_in_ruleIIOP5408);
                    lv_endpointQualifierRefs_2_0=ruleEndpointQualifierRefs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIIOPRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRefs",
                              		lv_endpointQualifierRefs_2_0, 
                              		"EndpointQualifierRefs");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2746:3: ( (lv_endpointConnector_3_0= ruleConnectorQualifier ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==11) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2747:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2747:1: (lv_endpointConnector_3_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2748:3: lv_endpointConnector_3_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIIOPAccess().getEndpointConnectorConnectorQualifierParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleIIOP5430);
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

            otherlv_4=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleIIOP5443); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getIIOPAccess().getLookupNameKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2768:1: ( (lv_lookupName_5_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2769:1: (lv_lookupName_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2769:1: (lv_lookupName_5_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2770:3: lv_lookupName_5_0= RULE_STRING
            {
            lv_lookupName_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleIIOP5460); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleIIOP5477); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2798:1: entryRuleAMQP returns [EObject current=null] : iv_ruleAMQP= ruleAMQP EOF ;
    public final EObject entryRuleAMQP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAMQP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2799:2: (iv_ruleAMQP= ruleAMQP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2800:2: iv_ruleAMQP= ruleAMQP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAMQPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAMQP_in_entryRuleAMQP5513);
            iv_ruleAMQP=ruleAMQP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAMQP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAMQP5523); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2807:1: ruleAMQP returns [EObject current=null] : (otherlv_0= 'AMQP' otherlv_1= '{' () ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'lookup-name' ( (lv_lookupName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) ;
    public final EObject ruleAMQP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_6=null;
        Token lv_lookupName_7_0=null;
        Token otherlv_8=null;
        Token lv_providerLookupName_9_0=null;
        Token otherlv_10=null;
        EObject lv_endpointQualifierRefs_3_0 = null;

        EObject lv_endpointConnector_4_0 = null;

        EObject lv_channel_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2810:28: ( (otherlv_0= 'AMQP' otherlv_1= '{' () ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'lookup-name' ( (lv_lookupName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2811:1: (otherlv_0= 'AMQP' otherlv_1= '{' () ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'lookup-name' ( (lv_lookupName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2811:1: (otherlv_0= 'AMQP' otherlv_1= '{' () ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'lookup-name' ( (lv_lookupName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2811:3: otherlv_0= 'AMQP' otherlv_1= '{' () ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )? ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'lookup-name' ( (lv_lookupName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) ) )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleAMQP5560); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAMQPAccess().getAMQPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAMQP5572); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAMQPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2819:1: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2820:2: 
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2828:2: ( (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==76) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2829:1: (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2829:1: (lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2830:3: lv_endpointQualifierRefs_3_0= ruleEndpointQualifierRefs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAMQPAccess().getEndpointQualifierRefsEndpointQualifierRefsParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRefs_in_ruleAMQP5605);
                    lv_endpointQualifierRefs_3_0=ruleEndpointQualifierRefs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAMQPRule());
                      	        }
                             		set(
                             			current, 
                             			"endpointQualifierRefs",
                              		lv_endpointQualifierRefs_3_0, 
                              		"EndpointQualifierRefs");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2846:3: ( (lv_endpointConnector_4_0= ruleConnectorQualifier ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==11) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2847:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2847:1: (lv_endpointConnector_4_0= ruleConnectorQualifier )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2848:3: lv_endpointConnector_4_0= ruleConnectorQualifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAMQPAccess().getEndpointConnectorConnectorQualifierParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConnectorQualifier_in_ruleAMQP5627);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2864:3: ( (lv_channel_5_0= ruleTopicOrQueue ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( ((LA78_0>=53 && LA78_0<=54)) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2865:1: (lv_channel_5_0= ruleTopicOrQueue )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2865:1: (lv_channel_5_0= ruleTopicOrQueue )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2866:3: lv_channel_5_0= ruleTopicOrQueue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAMQPAccess().getChannelTopicOrQueueParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTopicOrQueue_in_ruleAMQP5649);
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

            otherlv_6=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleAMQP5662); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getAMQPAccess().getLookupNameKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2886:1: ( (lv_lookupName_7_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2887:1: (lv_lookupName_7_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2887:1: (lv_lookupName_7_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2888:3: lv_lookupName_7_0= RULE_STRING
            {
            lv_lookupName_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAMQP5679); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2904:2: (otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==66) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2904:4: otherlv_8= 'provider-lookup-name' ( (lv_providerLookupName_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleAMQP5697); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getAMQPAccess().getProviderLookupNameKeyword_8_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2908:1: ( (lv_providerLookupName_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2909:1: (lv_providerLookupName_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2909:1: (lv_providerLookupName_9_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2910:3: lv_providerLookupName_9_0= RULE_STRING
                    {
                    lv_providerLookupName_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAMQP5714); if (state.failed) return current;
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

            otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAMQP5733); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2938:1: entryRulePolicy returns [EObject current=null] : iv_rulePolicy= rulePolicy EOF ;
    public final EObject entryRulePolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2939:2: (iv_rulePolicy= rulePolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2940:2: iv_rulePolicy= rulePolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePolicy_in_entryRulePolicy5769);
            iv_rulePolicy=rulePolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePolicy5779); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2947:1: rulePolicy returns [EObject current=null] : (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy ) ;
    public final EObject rulePolicy() throws RecognitionException {
        EObject current = null;

        EObject this_LogPolicy_0 = null;

        EObject this_SecurityPolicy_1 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2950:28: ( (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2951:1: (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2951:1: (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==67) ) {
                alt80=1;
            }
            else if ( (LA80_0==68||(LA80_0>=73 && LA80_0<=75)) ) {
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2952:2: this_LogPolicy_0= ruleLogPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPolicyAccess().getLogPolicyParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLogPolicy_in_rulePolicy5829);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2965:2: this_SecurityPolicy_1= ruleSecurityPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPolicyAccess().getSecurityPolicyParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSecurityPolicy_in_rulePolicy5859);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2984:1: entryRuleLogPolicy returns [EObject current=null] : iv_ruleLogPolicy= ruleLogPolicy EOF ;
    public final EObject entryRuleLogPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2985:2: (iv_ruleLogPolicy= ruleLogPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2986:2: iv_ruleLogPolicy= ruleLogPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLogPolicy_in_entryRuleLogPolicy5894);
            iv_ruleLogPolicy=ruleLogPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLogPolicy5904); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2993:1: ruleLogPolicy returns [EObject current=null] : (otherlv_0= 'logging policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) ) ;
    public final EObject ruleLogPolicy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_logPolicy_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2996:28: ( (otherlv_0= 'logging policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2997:1: (otherlv_0= 'logging policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2997:1: (otherlv_0= 'logging policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2997:3: otherlv_0= 'logging policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) )
            {
            otherlv_0=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleLogPolicy5941); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLogPolicyAccess().getLoggingPolicyKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3001:1: ( (lv_logPolicy_1_0= ruleLogPolicyKind ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3002:1: (lv_logPolicy_1_0= ruleLogPolicyKind )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3002:1: (lv_logPolicy_1_0= ruleLogPolicyKind )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3003:3: lv_logPolicy_1_0= ruleLogPolicyKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogPolicyAccess().getLogPolicyLogPolicyKindEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLogPolicyKind_in_ruleLogPolicy5962);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3027:1: entryRuleSecurityPolicy returns [EObject current=null] : iv_ruleSecurityPolicy= ruleSecurityPolicy EOF ;
    public final EObject entryRuleSecurityPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecurityPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3028:2: (iv_ruleSecurityPolicy= ruleSecurityPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3029:2: iv_ruleSecurityPolicy= ruleSecurityPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSecurityPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSecurityPolicy_in_entryRuleSecurityPolicy5998);
            iv_ruleSecurityPolicy=ruleSecurityPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSecurityPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecurityPolicy6008); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3036:1: ruleSecurityPolicy returns [EObject current=null] : (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | this_AuthorizationPolicy_1= ruleAuthorizationPolicy | this_SigningPolicy_2= ruleSigningPolicy | this_EncryptionPolicy_3= ruleEncryptionPolicy ) ;
    public final EObject ruleSecurityPolicy() throws RecognitionException {
        EObject current = null;

        EObject this_AuthenticationPolicy_0 = null;

        EObject this_AuthorizationPolicy_1 = null;

        EObject this_SigningPolicy_2 = null;

        EObject this_EncryptionPolicy_3 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3039:28: ( (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | this_AuthorizationPolicy_1= ruleAuthorizationPolicy | this_SigningPolicy_2= ruleSigningPolicy | this_EncryptionPolicy_3= ruleEncryptionPolicy ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3040:1: (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | this_AuthorizationPolicy_1= ruleAuthorizationPolicy | this_SigningPolicy_2= ruleSigningPolicy | this_EncryptionPolicy_3= ruleEncryptionPolicy )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3040:1: (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | this_AuthorizationPolicy_1= ruleAuthorizationPolicy | this_SigningPolicy_2= ruleSigningPolicy | this_EncryptionPolicy_3= ruleEncryptionPolicy )
            int alt81=4;
            switch ( input.LA(1) ) {
            case 68:
                {
                alt81=1;
                }
                break;
            case 73:
                {
                alt81=2;
                }
                break;
            case 74:
                {
                alt81=3;
                }
                break;
            case 75:
                {
                alt81=4;
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3041:2: this_AuthenticationPolicy_0= ruleAuthenticationPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityPolicyAccess().getAuthenticationPolicyParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAuthenticationPolicy_in_ruleSecurityPolicy6058);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3054:2: this_AuthorizationPolicy_1= ruleAuthorizationPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityPolicyAccess().getAuthorizationPolicyParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAuthorizationPolicy_in_ruleSecurityPolicy6088);
                    this_AuthorizationPolicy_1=ruleAuthorizationPolicy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AuthorizationPolicy_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3067:2: this_SigningPolicy_2= ruleSigningPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityPolicyAccess().getSigningPolicyParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSigningPolicy_in_ruleSecurityPolicy6118);
                    this_SigningPolicy_2=ruleSigningPolicy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SigningPolicy_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3080:2: this_EncryptionPolicy_3= ruleEncryptionPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityPolicyAccess().getEncryptionPolicyParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEncryptionPolicy_in_ruleSecurityPolicy6148);
                    this_EncryptionPolicy_3=ruleEncryptionPolicy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_EncryptionPolicy_3; 
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3099:1: entryRuleAuthenticationPolicy returns [EObject current=null] : iv_ruleAuthenticationPolicy= ruleAuthenticationPolicy EOF ;
    public final EObject entryRuleAuthenticationPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthenticationPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3100:2: (iv_ruleAuthenticationPolicy= ruleAuthenticationPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3101:2: iv_ruleAuthenticationPolicy= ruleAuthenticationPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAuthenticationPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthenticationPolicy_in_entryRuleAuthenticationPolicy6183);
            iv_ruleAuthenticationPolicy=ruleAuthenticationPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAuthenticationPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAuthenticationPolicy6193); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3108:1: ruleAuthenticationPolicy returns [EObject current=null] : ( () otherlv_1= 'authn policy' ( (lv_name_2_0= RULE_ID ) )? ( (lv_optional_3_0= 'optional' ) )? otherlv_4= '{' otherlv_5= 'auth tokens' otherlv_6= '{' ( (lv_authTokens_7_0= ruleAuthToken ) )+ otherlv_8= '}' otherlv_9= 'hash algorithms' otherlv_10= '{' ( (lv_hashAlgorithms_11_0= ruleHashAlgorithm ) )* otherlv_12= '}' otherlv_13= '}' ) ;
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
        Token otherlv_13=null;
        EObject lv_authTokens_7_0 = null;

        EObject lv_hashAlgorithms_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3111:28: ( ( () otherlv_1= 'authn policy' ( (lv_name_2_0= RULE_ID ) )? ( (lv_optional_3_0= 'optional' ) )? otherlv_4= '{' otherlv_5= 'auth tokens' otherlv_6= '{' ( (lv_authTokens_7_0= ruleAuthToken ) )+ otherlv_8= '}' otherlv_9= 'hash algorithms' otherlv_10= '{' ( (lv_hashAlgorithms_11_0= ruleHashAlgorithm ) )* otherlv_12= '}' otherlv_13= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3112:1: ( () otherlv_1= 'authn policy' ( (lv_name_2_0= RULE_ID ) )? ( (lv_optional_3_0= 'optional' ) )? otherlv_4= '{' otherlv_5= 'auth tokens' otherlv_6= '{' ( (lv_authTokens_7_0= ruleAuthToken ) )+ otherlv_8= '}' otherlv_9= 'hash algorithms' otherlv_10= '{' ( (lv_hashAlgorithms_11_0= ruleHashAlgorithm ) )* otherlv_12= '}' otherlv_13= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3112:1: ( () otherlv_1= 'authn policy' ( (lv_name_2_0= RULE_ID ) )? ( (lv_optional_3_0= 'optional' ) )? otherlv_4= '{' otherlv_5= 'auth tokens' otherlv_6= '{' ( (lv_authTokens_7_0= ruleAuthToken ) )+ otherlv_8= '}' otherlv_9= 'hash algorithms' otherlv_10= '{' ( (lv_hashAlgorithms_11_0= ruleHashAlgorithm ) )* otherlv_12= '}' otherlv_13= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3112:2: () otherlv_1= 'authn policy' ( (lv_name_2_0= RULE_ID ) )? ( (lv_optional_3_0= 'optional' ) )? otherlv_4= '{' otherlv_5= 'auth tokens' otherlv_6= '{' ( (lv_authTokens_7_0= ruleAuthToken ) )+ otherlv_8= '}' otherlv_9= 'hash algorithms' otherlv_10= '{' ( (lv_hashAlgorithms_11_0= ruleHashAlgorithm ) )* otherlv_12= '}' otherlv_13= '}'
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3112:2: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3113:2: 
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

            otherlv_1=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleAuthenticationPolicy6242); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAuthenticationPolicyAccess().getAuthnPolicyKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3125:1: ( (lv_name_2_0= RULE_ID ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==RULE_ID) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3126:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3126:1: (lv_name_2_0= RULE_ID )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3127:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAuthenticationPolicy6259); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3143:3: ( (lv_optional_3_0= 'optional' ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==69) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3144:1: (lv_optional_3_0= 'optional' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3144:1: (lv_optional_3_0= 'optional' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3145:3: lv_optional_3_0= 'optional'
                    {
                    lv_optional_3_0=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleAuthenticationPolicy6283); if (state.failed) return current;
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

            otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAuthenticationPolicy6309); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getAuthenticationPolicyAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleAuthenticationPolicy6321); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getAuthenticationPolicyAccess().getAuthTokensKeyword_5());
                  
            }
            otherlv_6=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAuthenticationPolicy6333); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getAuthenticationPolicyAccess().getLeftCurlyBracketKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3170:1: ( (lv_authTokens_7_0= ruleAuthToken ) )+
            int cnt84=0;
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==69||(LA84_0>=117 && LA84_0<=122)) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3171:1: (lv_authTokens_7_0= ruleAuthToken )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3171:1: (lv_authTokens_7_0= ruleAuthToken )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3172:3: lv_authTokens_7_0= ruleAuthToken
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAuthenticationPolicyAccess().getAuthTokensAuthTokenParserRuleCall_7_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAuthToken_in_ruleAuthenticationPolicy6354);
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

            otherlv_8=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAuthenticationPolicy6367); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getAuthenticationPolicyAccess().getRightCurlyBracketKeyword_8());
                  
            }
            otherlv_9=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleAuthenticationPolicy6379); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getAuthenticationPolicyAccess().getHashAlgorithmsKeyword_9());
                  
            }
            otherlv_10=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAuthenticationPolicy6391); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getAuthenticationPolicyAccess().getLeftCurlyBracketKeyword_10());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3200:1: ( (lv_hashAlgorithms_11_0= ruleHashAlgorithm ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==69||LA85_0==72||(LA85_0>=113 && LA85_0<=116)) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3201:1: (lv_hashAlgorithms_11_0= ruleHashAlgorithm )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3201:1: (lv_hashAlgorithms_11_0= ruleHashAlgorithm )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3202:3: lv_hashAlgorithms_11_0= ruleHashAlgorithm
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAuthenticationPolicyAccess().getHashAlgorithmsHashAlgorithmParserRuleCall_11_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleHashAlgorithm_in_ruleAuthenticationPolicy6412);
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

            otherlv_12=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAuthenticationPolicy6425); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getAuthenticationPolicyAccess().getRightCurlyBracketKeyword_12());
                  
            }
            otherlv_13=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAuthenticationPolicy6437); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getAuthenticationPolicyAccess().getRightCurlyBracketKeyword_13());
                  
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3234:1: entryRuleAuthToken returns [EObject current=null] : iv_ruleAuthToken= ruleAuthToken EOF ;
    public final EObject entryRuleAuthToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthToken = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3235:2: (iv_ruleAuthToken= ruleAuthToken EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3236:2: iv_ruleAuthToken= ruleAuthToken EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAuthTokenRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthToken_in_entryRuleAuthToken6473);
            iv_ruleAuthToken=ruleAuthToken();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAuthToken; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAuthToken6483); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3243:1: ruleAuthToken returns [EObject current=null] : ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) ) ;
    public final EObject ruleAuthToken() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Enumerator lv_kind_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3246:28: ( ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3247:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3247:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3247:2: ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3247:2: ( (lv_optional_0_0= 'optional' ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==69) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3248:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3248:1: (lv_optional_0_0= 'optional' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3249:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleAuthToken6526); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3262:3: ( (lv_kind_1_0= ruleAuthTokenKind ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3263:1: (lv_kind_1_0= ruleAuthTokenKind )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3263:1: (lv_kind_1_0= ruleAuthTokenKind )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3264:3: lv_kind_1_0= ruleAuthTokenKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAuthTokenAccess().getKindAuthTokenKindEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthTokenKind_in_ruleAuthToken6561);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3288:1: entryRuleHashAlgorithm returns [EObject current=null] : iv_ruleHashAlgorithm= ruleHashAlgorithm EOF ;
    public final EObject entryRuleHashAlgorithm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHashAlgorithm = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3289:2: (iv_ruleHashAlgorithm= ruleHashAlgorithm EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3290:2: iv_ruleHashAlgorithm= ruleHashAlgorithm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHashAlgorithmRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleHashAlgorithm_in_entryRuleHashAlgorithm6597);
            iv_ruleHashAlgorithm=ruleHashAlgorithm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHashAlgorithm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHashAlgorithm6607); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3297:1: ruleHashAlgorithm returns [EObject current=null] : ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) ) ;
    public final EObject ruleHashAlgorithm() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Token lv_useBase64_1_0=null;
        Enumerator lv_kind_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3300:28: ( ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3301:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3301:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3301:2: ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3301:2: ( (lv_optional_0_0= 'optional' ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==69) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3302:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3302:1: (lv_optional_0_0= 'optional' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3303:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleHashAlgorithm6650); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3316:3: ( (lv_useBase64_1_0= 'Base64-encoded' ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==72) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3317:1: (lv_useBase64_1_0= 'Base64-encoded' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3317:1: (lv_useBase64_1_0= 'Base64-encoded' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3318:3: lv_useBase64_1_0= 'Base64-encoded'
                    {
                    lv_useBase64_1_0=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleHashAlgorithm6682); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3331:3: ( (lv_kind_2_0= ruleHashAlgKind ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3332:1: (lv_kind_2_0= ruleHashAlgKind )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3332:1: (lv_kind_2_0= ruleHashAlgKind )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3333:3: lv_kind_2_0= ruleHashAlgKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getHashAlgorithmAccess().getKindHashAlgKindEnumRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleHashAlgKind_in_ruleHashAlgorithm6717);
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


    // $ANTLR start "entryRuleAuthorizationPolicy"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3357:1: entryRuleAuthorizationPolicy returns [EObject current=null] : iv_ruleAuthorizationPolicy= ruleAuthorizationPolicy EOF ;
    public final EObject entryRuleAuthorizationPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthorizationPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3358:2: (iv_ruleAuthorizationPolicy= ruleAuthorizationPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3359:2: iv_ruleAuthorizationPolicy= ruleAuthorizationPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAuthorizationPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthorizationPolicy_in_entryRuleAuthorizationPolicy6753);
            iv_ruleAuthorizationPolicy=ruleAuthorizationPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAuthorizationPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAuthorizationPolicy6763); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAuthorizationPolicy"


    // $ANTLR start "ruleAuthorizationPolicy"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3366:1: ruleAuthorizationPolicy returns [EObject current=null] : ( () otherlv_1= 'authorization policy' ) ;
    public final EObject ruleAuthorizationPolicy() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3369:28: ( ( () otherlv_1= 'authorization policy' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3370:1: ( () otherlv_1= 'authorization policy' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3370:1: ( () otherlv_1= 'authorization policy' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3370:2: () otherlv_1= 'authorization policy'
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3370:2: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3371:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAuthorizationPolicyAccess().getAuthorizationPolicyAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleAuthorizationPolicy6812); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAuthorizationPolicyAccess().getAuthorizationPolicyKeyword_1());
                  
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
    // $ANTLR end "ruleAuthorizationPolicy"


    // $ANTLR start "entryRuleSigningPolicy"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3391:1: entryRuleSigningPolicy returns [EObject current=null] : iv_ruleSigningPolicy= ruleSigningPolicy EOF ;
    public final EObject entryRuleSigningPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSigningPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3392:2: (iv_ruleSigningPolicy= ruleSigningPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3393:2: iv_ruleSigningPolicy= ruleSigningPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSigningPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSigningPolicy_in_entryRuleSigningPolicy6848);
            iv_ruleSigningPolicy=ruleSigningPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSigningPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSigningPolicy6858); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3400:1: ruleSigningPolicy returns [EObject current=null] : ( () otherlv_1= 'signing policy' ) ;
    public final EObject ruleSigningPolicy() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3403:28: ( ( () otherlv_1= 'signing policy' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3404:1: ( () otherlv_1= 'signing policy' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3404:1: ( () otherlv_1= 'signing policy' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3404:2: () otherlv_1= 'signing policy'
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3404:2: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3405:2: 
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

            otherlv_1=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleSigningPolicy6907); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSigningPolicyAccess().getSigningPolicyKeyword_1());
                  
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


    // $ANTLR start "entryRuleEncryptionPolicy"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3425:1: entryRuleEncryptionPolicy returns [EObject current=null] : iv_ruleEncryptionPolicy= ruleEncryptionPolicy EOF ;
    public final EObject entryRuleEncryptionPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEncryptionPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3426:2: (iv_ruleEncryptionPolicy= ruleEncryptionPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3427:2: iv_ruleEncryptionPolicy= ruleEncryptionPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEncryptionPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEncryptionPolicy_in_entryRuleEncryptionPolicy6943);
            iv_ruleEncryptionPolicy=ruleEncryptionPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEncryptionPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEncryptionPolicy6953); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3434:1: ruleEncryptionPolicy returns [EObject current=null] : ( () otherlv_1= 'encryption policy' ) ;
    public final EObject ruleEncryptionPolicy() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3437:28: ( ( () otherlv_1= 'encryption policy' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3438:1: ( () otherlv_1= 'encryption policy' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3438:1: ( () otherlv_1= 'encryption policy' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3438:2: () otherlv_1= 'encryption policy'
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3438:2: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3439:2: 
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

            otherlv_1=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleEncryptionPolicy7002); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEncryptionPolicyAccess().getEncryptionPolicyKeyword_1());
                  
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


    // $ANTLR start "entryRuleEndpointQualifierRefs"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3459:1: entryRuleEndpointQualifierRefs returns [EObject current=null] : iv_ruleEndpointQualifierRefs= ruleEndpointQualifierRefs EOF ;
    public final EObject entryRuleEndpointQualifierRefs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndpointQualifierRefs = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3460:2: (iv_ruleEndpointQualifierRefs= ruleEndpointQualifierRefs EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3461:2: iv_ruleEndpointQualifierRefs= ruleEndpointQualifierRefs EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEndpointQualifierRefsRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEndpointQualifierRefs_in_entryRuleEndpointQualifierRefs7038);
            iv_ruleEndpointQualifierRefs=ruleEndpointQualifierRefs();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEndpointQualifierRefs; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEndpointQualifierRefs7048); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEndpointQualifierRefs"


    // $ANTLR start "ruleEndpointQualifierRefs"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3468:1: ruleEndpointQualifierRefs returns [EObject current=null] : (otherlv_0= 'endpoint-qualifier' ( ( ruleQualifiedName ) ) (otherlv_2= ',' ( ( ruleQualifiedName ) ) )* ) ;
    public final EObject ruleEndpointQualifierRefs() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3471:28: ( (otherlv_0= 'endpoint-qualifier' ( ( ruleQualifiedName ) ) (otherlv_2= ',' ( ( ruleQualifiedName ) ) )* ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3472:1: (otherlv_0= 'endpoint-qualifier' ( ( ruleQualifiedName ) ) (otherlv_2= ',' ( ( ruleQualifiedName ) ) )* )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3472:1: (otherlv_0= 'endpoint-qualifier' ( ( ruleQualifiedName ) ) (otherlv_2= ',' ( ( ruleQualifiedName ) ) )* )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3472:3: otherlv_0= 'endpoint-qualifier' ( ( ruleQualifiedName ) ) (otherlv_2= ',' ( ( ruleQualifiedName ) ) )*
            {
            otherlv_0=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleEndpointQualifierRefs7085); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEndpointQualifierRefsAccess().getEndpointQualifierKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3476:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3477:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3477:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3478:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getEndpointQualifierRefsRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEndpointQualifierRefsAccess().getEndpointQualifiersQualifierCrossReference_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleEndpointQualifierRefs7112);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3494:2: (otherlv_2= ',' ( ( ruleQualifiedName ) ) )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==13) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3494:4: otherlv_2= ',' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleEndpointQualifierRefs7125); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getEndpointQualifierRefsAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3498:1: ( ( ruleQualifiedName ) )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3499:1: ( ruleQualifiedName )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3499:1: ( ruleQualifiedName )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3500:3: ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getEndpointQualifierRefsRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEndpointQualifierRefsAccess().getEndpointQualifiersQualifierCrossReference_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleEndpointQualifierRefs7152);
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
    // $ANTLR end "ruleEndpointQualifierRefs"


    // $ANTLR start "entryRuleImport"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3524:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3525:2: (iv_ruleImport= ruleImport EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3526:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport7190);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport7200); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3533:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3536:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3537:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3537:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3537:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {
            otherlv_0=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleImport7237); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3541:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3542:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3542:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3543:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport7258);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3567:1: entryRuleVersionId returns [String current=null] : iv_ruleVersionId= ruleVersionId EOF ;
    public final String entryRuleVersionId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionId = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3568:2: (iv_ruleVersionId= ruleVersionId EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3569:2: iv_ruleVersionId= ruleVersionId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionIdRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_entryRuleVersionId7295);
            iv_ruleVersionId=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionId.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionId7306); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3576:1: ruleVersionId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleVersionId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_ID_5=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3579:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3580:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3580:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3580:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )*
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId7346); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3587:1: (kw= '.' this_INT_2= RULE_INT )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==78) ) {
                    int LA90_1 = input.LA(2);

                    if ( (LA90_1==RULE_INT) ) {
                        alt90=1;
                    }


                }


                switch (alt90) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3588:2: kw= '.' this_INT_2= RULE_INT
            	    {
            	    kw=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleVersionId7365); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId7380); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_INT_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_INT_2, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop90;
                }
            } while (true);

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3600:3: ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( ((LA92_0>=78 && LA92_0<=79)) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3600:4: (kw= '.' | kw= '-' ) this_ID_5= RULE_ID
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3600:4: (kw= '.' | kw= '-' )
            	    int alt91=2;
            	    int LA91_0 = input.LA(1);

            	    if ( (LA91_0==78) ) {
            	        alt91=1;
            	    }
            	    else if ( (LA91_0==79) ) {
            	        alt91=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 91, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt91) {
            	        case 1 :
            	            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3601:2: kw= '.'
            	            {
            	            kw=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleVersionId7402); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_2_0_0()); 
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3608:2: kw= '-'
            	            {
            	            kw=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleVersionId7421); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getVersionIdAccess().getHyphenMinusKeyword_2_0_1()); 
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    this_ID_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVersionId7437); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_5);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_5, grammarAccess.getVersionIdAccess().getIDTerminalRuleCall_2_1()); 
            	          
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
    // $ANTLR end "ruleVersionId"


    // $ANTLR start "entryRuleVersionRef"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3632:1: entryRuleVersionRef returns [EObject current=null] : iv_ruleVersionRef= ruleVersionRef EOF ;
    public final EObject entryRuleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3633:2: (iv_ruleVersionRef= ruleVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3634:2: iv_ruleVersionRef= ruleVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_entryRuleVersionRef7488);
            iv_ruleVersionRef=ruleVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionRef7498); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3641:1: ruleVersionRef returns [EObject current=null] : (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) ;
    public final EObject ruleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject this_MinVersionRef_0 = null;

        EObject this_MaxVersionRef_1 = null;

        EObject this_LowerBoundRangeVersionRef_2 = null;

        EObject this_MajorVersionRef_3 = null;

        EObject this_FixedVersionRef_4 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3644:28: ( (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3645:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3645:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            int alt93=5;
            switch ( input.LA(1) ) {
            case 80:
                {
                int LA93_1 = input.LA(2);

                if ( (LA93_1==RULE_INT) ) {
                    alt93=1;
                }
                else if ( (LA93_1==82) ) {
                    alt93=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 93, 1, input);

                    throw nvae;
                }
                }
                break;
            case 81:
                {
                alt93=2;
                }
                break;
            case 84:
                {
                alt93=4;
                }
                break;
            case 85:
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3646:2: this_MinVersionRef_0= ruleMinVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMinVersionRefParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_ruleVersionRef7548);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3659:2: this_MaxVersionRef_1= ruleMaxVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMaxVersionRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_ruleVersionRef7578);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3672:2: this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getLowerBoundRangeVersionRefParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef7608);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3685:2: this_MajorVersionRef_3= ruleMajorVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMajorVersionRefParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_ruleVersionRef7638);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3698:2: this_FixedVersionRef_4= ruleFixedVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getFixedVersionRefParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_ruleVersionRef7668);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3717:1: entryRuleMinVersionRef returns [EObject current=null] : iv_ruleMinVersionRef= ruleMinVersionRef EOF ;
    public final EObject entryRuleMinVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinVersionRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3718:2: (iv_ruleMinVersionRef= ruleMinVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3719:2: iv_ruleMinVersionRef= ruleMinVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMinVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef7703);
            iv_ruleMinVersionRef=ruleMinVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMinVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMinVersionRef7713); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3726:1: ruleMinVersionRef returns [EObject current=null] : (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMinVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_minVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3729:28: ( (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3730:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3730:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3730:3: otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleMinVersionRef7750); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMinVersionRefAccess().getMinVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3734:1: ( (lv_minVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3735:1: (lv_minVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3735:1: (lv_minVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3736:3: lv_minVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMinVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMinVersionRef7771);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3760:1: entryRuleMaxVersionRef returns [EObject current=null] : iv_ruleMaxVersionRef= ruleMaxVersionRef EOF ;
    public final EObject entryRuleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxVersionRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3761:2: (iv_ruleMaxVersionRef= ruleMaxVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3762:2: iv_ruleMaxVersionRef= ruleMaxVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMaxVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef7807);
            iv_ruleMaxVersionRef=ruleMaxVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMaxVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxVersionRef7817); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3769:1: ruleMaxVersionRef returns [EObject current=null] : (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_maxVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3772:28: ( (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3773:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3773:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3773:3: otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleMaxVersionRef7854); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMaxVersionRefAccess().getMaxVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3777:1: ( (lv_maxVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3778:1: (lv_maxVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3778:1: (lv_maxVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3779:3: lv_maxVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMaxVersionRefAccess().getMaxVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMaxVersionRef7875);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3803:1: entryRuleLowerBoundRangeVersionRef returns [EObject current=null] : iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF ;
    public final EObject entryRuleLowerBoundRangeVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerBoundRangeVersionRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3804:2: (iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3805:2: iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef7911);
            iv_ruleLowerBoundRangeVersionRef=ruleLowerBoundRangeVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLowerBoundRangeVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef7921); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3812:1: ruleLowerBoundRangeVersionRef returns [EObject current=null] : ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3815:28: ( ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3816:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3816:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3816:2: (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3816:2: (otherlv_0= 'minVersion' otherlv_1= '>=' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3816:4: otherlv_0= 'minVersion' otherlv_1= '>='
            {
            otherlv_0=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleLowerBoundRangeVersionRef7959); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionKeyword_0_0());
                  
            }
            otherlv_1=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleLowerBoundRangeVersionRef7971); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLowerBoundRangeVersionRefAccess().getGreaterThanSignEqualsSignKeyword_0_1());
                  
            }

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3824:2: ( (lv_minVersion_2_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3825:1: (lv_minVersion_2_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3825:1: (lv_minVersion_2_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3826:3: lv_minVersion_2_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef7993);
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

            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleLowerBoundRangeVersionRef8005); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLowerBoundRangeVersionRefAccess().getCommaKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3846:1: (otherlv_4= 'maxVersion' otherlv_5= '<' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3846:3: otherlv_4= 'maxVersion' otherlv_5= '<'
            {
            otherlv_4=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleLowerBoundRangeVersionRef8018); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionKeyword_3_0());
                  
            }
            otherlv_5=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleLowerBoundRangeVersionRef8030); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLowerBoundRangeVersionRefAccess().getLessThanSignKeyword_3_1());
                  
            }

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3854:2: ( (lv_maxVersion_6_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3855:1: (lv_maxVersion_6_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3855:1: (lv_maxVersion_6_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3856:3: lv_maxVersion_6_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionVersionIdParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef8052);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3880:1: entryRuleMajorVersionRef returns [EObject current=null] : iv_ruleMajorVersionRef= ruleMajorVersionRef EOF ;
    public final EObject entryRuleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMajorVersionRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3881:2: (iv_ruleMajorVersionRef= ruleMajorVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3882:2: iv_ruleMajorVersionRef= ruleMajorVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMajorVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef8088);
            iv_ruleMajorVersionRef=ruleMajorVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMajorVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMajorVersionRef8098); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3889:1: ruleMajorVersionRef returns [EObject current=null] : (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) ;
    public final EObject ruleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_majorVersion_1_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3892:28: ( (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3893:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3893:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3893:3: otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,84,FollowSets000.FOLLOW_84_in_ruleMajorVersionRef8135); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMajorVersionRefAccess().getMajorVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3897:1: ( (lv_majorVersion_1_0= RULE_INT ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3898:1: (lv_majorVersion_1_0= RULE_INT )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3898:1: (lv_majorVersion_1_0= RULE_INT )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3899:3: lv_majorVersion_1_0= RULE_INT
            {
            lv_majorVersion_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMajorVersionRef8152); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3923:1: entryRuleFixedVersionRef returns [EObject current=null] : iv_ruleFixedVersionRef= ruleFixedVersionRef EOF ;
    public final EObject entryRuleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedVersionRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3924:2: (iv_ruleFixedVersionRef= ruleFixedVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3925:2: iv_ruleFixedVersionRef= ruleFixedVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFixedVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef8193);
            iv_ruleFixedVersionRef=ruleFixedVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFixedVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFixedVersionRef8203); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3932:1: ruleFixedVersionRef returns [EObject current=null] : (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_fixedVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3935:28: ( (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3936:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3936:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3936:3: otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,85,FollowSets000.FOLLOW_85_in_ruleFixedVersionRef8240); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFixedVersionRefAccess().getFixedVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3940:1: ( (lv_fixedVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3941:1: (lv_fixedVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3941:1: (lv_fixedVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3942:3: lv_fixedVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFixedVersionRefAccess().getFixedVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleFixedVersionRef8261);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3966:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3967:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3968:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard8298);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard8309); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3975:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3978:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3979:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3979:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3980:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard8356);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3990:1: (kw= '.*' )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==86) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3991:2: kw= '.*'
                    {
                    kw=(Token)match(input,86,FollowSets000.FOLLOW_86_in_ruleQualifiedNameWithWildCard8375); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4004:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4005:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4006:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8418);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName8429); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4013:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4016:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4017:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4017:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4017:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName8469); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4024:1: (kw= '.' this_ID_2= RULE_ID )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==78) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4025:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleQualifiedName8488); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName8503); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop95;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4045:1: entryRuleGovernanceDecision returns [EObject current=null] : iv_ruleGovernanceDecision= ruleGovernanceDecision EOF ;
    public final EObject entryRuleGovernanceDecision() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGovernanceDecision = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4046:2: (iv_ruleGovernanceDecision= ruleGovernanceDecision EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4047:2: iv_ruleGovernanceDecision= ruleGovernanceDecision EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGovernanceDecisionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGovernanceDecision_in_entryRuleGovernanceDecision8550);
            iv_ruleGovernanceDecision=ruleGovernanceDecision();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGovernanceDecision; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGovernanceDecision8560); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4054:1: ruleGovernanceDecision returns [EObject current=null] : (otherlv_0= 'governance-decision' otherlv_1= '{' (otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) ) ) (otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) ) ) (otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) ) )? (otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) ) )? (otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) ) )? (otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) ) )? (otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) ) )? otherlv_16= '}' ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4057:28: ( (otherlv_0= 'governance-decision' otherlv_1= '{' (otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) ) ) (otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) ) ) (otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) ) )? (otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) ) )? (otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) ) )? (otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) ) )? (otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) ) )? otherlv_16= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4058:1: (otherlv_0= 'governance-decision' otherlv_1= '{' (otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) ) ) (otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) ) ) (otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) ) )? (otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) ) )? (otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) ) )? (otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) ) )? (otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) ) )? otherlv_16= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4058:1: (otherlv_0= 'governance-decision' otherlv_1= '{' (otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) ) ) (otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) ) ) (otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) ) )? (otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) ) )? (otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) ) )? (otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) ) )? (otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) ) )? otherlv_16= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4058:3: otherlv_0= 'governance-decision' otherlv_1= '{' (otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) ) ) (otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) ) ) (otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) ) )? (otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) ) )? (otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) ) )? (otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) ) )? (otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) ) )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,87,FollowSets000.FOLLOW_87_in_ruleGovernanceDecision8597); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getGovernanceDecisionAccess().getGovernanceDecisionKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleGovernanceDecision8609); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getGovernanceDecisionAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4066:1: (otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4066:3: otherlv_2= 'subject' ( (lv_subject_3_0= RULE_STRING ) )
            {
            otherlv_2=(Token)match(input,88,FollowSets000.FOLLOW_88_in_ruleGovernanceDecision8622); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getGovernanceDecisionAccess().getSubjectKeyword_2_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4070:1: ( (lv_subject_3_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4071:1: (lv_subject_3_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4071:1: (lv_subject_3_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4072:3: lv_subject_3_0= RULE_STRING
            {
            lv_subject_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGovernanceDecision8639); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4088:3: (otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4088:5: otherlv_4= 'decision-result' ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) )
            {
            otherlv_4=(Token)match(input,89,FollowSets000.FOLLOW_89_in_ruleGovernanceDecision8658); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getGovernanceDecisionAccess().getDecisionResultKeyword_3_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4092:1: ( (lv_decisionResult_5_0= ruleGovernanceDecisionResult ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4093:1: (lv_decisionResult_5_0= ruleGovernanceDecisionResult )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4093:1: (lv_decisionResult_5_0= ruleGovernanceDecisionResult )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4094:3: lv_decisionResult_5_0= ruleGovernanceDecisionResult
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGovernanceDecisionAccess().getDecisionResultGovernanceDecisionResultEnumRuleCall_3_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleGovernanceDecisionResult_in_ruleGovernanceDecision8679);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4110:3: (otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==90) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4110:5: otherlv_6= 'specific-result' ( (lv_specificResult_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,90,FollowSets000.FOLLOW_90_in_ruleGovernanceDecision8693); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getGovernanceDecisionAccess().getSpecificResultKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4114:1: ( (lv_specificResult_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4115:1: (lv_specificResult_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4115:1: (lv_specificResult_7_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4116:3: lv_specificResult_7_0= RULE_STRING
                    {
                    lv_specificResult_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGovernanceDecision8710); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4132:4: (otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==91) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4132:6: otherlv_8= 'justification-doc' ( (lv_justificationOrDocURL_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,91,FollowSets000.FOLLOW_91_in_ruleGovernanceDecision8730); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getGovernanceDecisionAccess().getJustificationDocKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4136:1: ( (lv_justificationOrDocURL_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4137:1: (lv_justificationOrDocURL_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4137:1: (lv_justificationOrDocURL_9_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4138:3: lv_justificationOrDocURL_9_0= RULE_STRING
                    {
                    lv_justificationOrDocURL_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGovernanceDecision8747); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4154:4: (otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) ) )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==92) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4154:6: otherlv_10= 'decision-date' ( (lv_approvalDate_11_0= RULE_STRING ) )
                    {
                    otherlv_10=(Token)match(input,92,FollowSets000.FOLLOW_92_in_ruleGovernanceDecision8767); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getGovernanceDecisionAccess().getDecisionDateKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4158:1: ( (lv_approvalDate_11_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4159:1: (lv_approvalDate_11_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4159:1: (lv_approvalDate_11_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4160:3: lv_approvalDate_11_0= RULE_STRING
                    {
                    lv_approvalDate_11_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGovernanceDecision8784); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4176:4: (otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==93) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4176:6: otherlv_12= 'decision-by' ( (lv_approvedBy_13_0= RULE_STRING ) )
                    {
                    otherlv_12=(Token)match(input,93,FollowSets000.FOLLOW_93_in_ruleGovernanceDecision8804); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getGovernanceDecisionAccess().getDecisionByKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4180:1: ( (lv_approvedBy_13_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4181:1: (lv_approvedBy_13_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4181:1: (lv_approvedBy_13_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4182:3: lv_approvedBy_13_0= RULE_STRING
                    {
                    lv_approvedBy_13_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGovernanceDecision8821); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4198:4: (otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==94) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4198:6: otherlv_14= 'effective-date' ( (lv_effectiveDate_15_0= RULE_STRING ) )
                    {
                    otherlv_14=(Token)match(input,94,FollowSets000.FOLLOW_94_in_ruleGovernanceDecision8841); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getGovernanceDecisionAccess().getEffectiveDateKeyword_8_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4202:1: ( (lv_effectiveDate_15_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4203:1: (lv_effectiveDate_15_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4203:1: (lv_effectiveDate_15_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4204:3: lv_effectiveDate_15_0= RULE_STRING
                    {
                    lv_effectiveDate_15_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleGovernanceDecision8858); if (state.failed) return current;
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

            otherlv_16=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleGovernanceDecision8877); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4234:1: ruleSOAPStyle returns [Enumerator current=null] : ( (enumLiteral_0= 'document/literal-wrapped' ) | (enumLiteral_1= 'rpc/literal' ) | (enumLiteral_2= 'rpc/encoded' ) ) ;
    public final Enumerator ruleSOAPStyle() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4236:28: ( ( (enumLiteral_0= 'document/literal-wrapped' ) | (enumLiteral_1= 'rpc/literal' ) | (enumLiteral_2= 'rpc/encoded' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4237:1: ( (enumLiteral_0= 'document/literal-wrapped' ) | (enumLiteral_1= 'rpc/literal' ) | (enumLiteral_2= 'rpc/encoded' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4237:1: ( (enumLiteral_0= 'document/literal-wrapped' ) | (enumLiteral_1= 'rpc/literal' ) | (enumLiteral_2= 'rpc/encoded' ) )
            int alt101=3;
            switch ( input.LA(1) ) {
            case 95:
                {
                alt101=1;
                }
                break;
            case 96:
                {
                alt101=2;
                }
                break;
            case 97:
                {
                alt101=3;
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4237:2: (enumLiteral_0= 'document/literal-wrapped' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4237:2: (enumLiteral_0= 'document/literal-wrapped' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4237:4: enumLiteral_0= 'document/literal-wrapped'
                    {
                    enumLiteral_0=(Token)match(input,95,FollowSets000.FOLLOW_95_in_ruleSOAPStyle8929); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSOAPStyleAccess().getDoclitwrapEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getSOAPStyleAccess().getDoclitwrapEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4243:6: (enumLiteral_1= 'rpc/literal' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4243:6: (enumLiteral_1= 'rpc/literal' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4243:8: enumLiteral_1= 'rpc/literal'
                    {
                    enumLiteral_1=(Token)match(input,96,FollowSets000.FOLLOW_96_in_ruleSOAPStyle8946); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSOAPStyleAccess().getRpclitEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getSOAPStyleAccess().getRpclitEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4249:6: (enumLiteral_2= 'rpc/encoded' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4249:6: (enumLiteral_2= 'rpc/encoded' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4249:8: enumLiteral_2= 'rpc/encoded'
                    {
                    enumLiteral_2=(Token)match(input,97,FollowSets000.FOLLOW_97_in_ruleSOAPStyle8963); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4259:1: ruleSAPTransport returns [Enumerator current=null] : ( (enumLiteral_0= 'IDOC' ) | (enumLiteral_1= 'RFC' ) ) ;
    public final Enumerator ruleSAPTransport() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4261:28: ( ( (enumLiteral_0= 'IDOC' ) | (enumLiteral_1= 'RFC' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4262:1: ( (enumLiteral_0= 'IDOC' ) | (enumLiteral_1= 'RFC' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4262:1: ( (enumLiteral_0= 'IDOC' ) | (enumLiteral_1= 'RFC' ) )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==98) ) {
                alt102=1;
            }
            else if ( (LA102_0==99) ) {
                alt102=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }
            switch (alt102) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4262:2: (enumLiteral_0= 'IDOC' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4262:2: (enumLiteral_0= 'IDOC' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4262:4: enumLiteral_0= 'IDOC'
                    {
                    enumLiteral_0=(Token)match(input,98,FollowSets000.FOLLOW_98_in_ruleSAPTransport9008); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSAPTransportAccess().getIDOCEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getSAPTransportAccess().getIDOCEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4268:6: (enumLiteral_1= 'RFC' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4268:6: (enumLiteral_1= 'RFC' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4268:8: enumLiteral_1= 'RFC'
                    {
                    enumLiteral_1=(Token)match(input,99,FollowSets000.FOLLOW_99_in_ruleSAPTransport9025); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4278:1: ruleRESTFormat returns [Enumerator current=null] : ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'XML' ) | (enumLiteral_2= 'BISON' ) | (enumLiteral_3= 'OTHER' ) ) ;
    public final Enumerator ruleRESTFormat() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4280:28: ( ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'XML' ) | (enumLiteral_2= 'BISON' ) | (enumLiteral_3= 'OTHER' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4281:1: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'XML' ) | (enumLiteral_2= 'BISON' ) | (enumLiteral_3= 'OTHER' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4281:1: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'XML' ) | (enumLiteral_2= 'BISON' ) | (enumLiteral_3= 'OTHER' ) )
            int alt103=4;
            switch ( input.LA(1) ) {
            case 100:
                {
                alt103=1;
                }
                break;
            case 101:
                {
                alt103=2;
                }
                break;
            case 102:
                {
                alt103=3;
                }
                break;
            case 103:
                {
                alt103=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }

            switch (alt103) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4281:2: (enumLiteral_0= 'JSON' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4281:2: (enumLiteral_0= 'JSON' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4281:4: enumLiteral_0= 'JSON'
                    {
                    enumLiteral_0=(Token)match(input,100,FollowSets000.FOLLOW_100_in_ruleRESTFormat9070); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRESTFormatAccess().getJSONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getRESTFormatAccess().getJSONEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4287:6: (enumLiteral_1= 'XML' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4287:6: (enumLiteral_1= 'XML' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4287:8: enumLiteral_1= 'XML'
                    {
                    enumLiteral_1=(Token)match(input,101,FollowSets000.FOLLOW_101_in_ruleRESTFormat9087); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRESTFormatAccess().getXMLEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getRESTFormatAccess().getXMLEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4293:6: (enumLiteral_2= 'BISON' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4293:6: (enumLiteral_2= 'BISON' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4293:8: enumLiteral_2= 'BISON'
                    {
                    enumLiteral_2=(Token)match(input,102,FollowSets000.FOLLOW_102_in_ruleRESTFormat9104); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRESTFormatAccess().getBISONEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getRESTFormatAccess().getBISONEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4299:6: (enumLiteral_3= 'OTHER' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4299:6: (enumLiteral_3= 'OTHER' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4299:8: enumLiteral_3= 'OTHER'
                    {
                    enumLiteral_3=(Token)match(input,103,FollowSets000.FOLLOW_103_in_ruleRESTFormat9121); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4309:1: ruleVerb returns [Enumerator current=null] : ( (enumLiteral_0= 'CREATE' ) | (enumLiteral_1= 'RETRIEVE' ) | (enumLiteral_2= 'UPDATE' ) | (enumLiteral_3= 'DELETE' ) | (enumLiteral_4= 'GET' ) | (enumLiteral_5= 'PUT' ) | (enumLiteral_6= 'POST' ) ) ;
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
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4311:28: ( ( (enumLiteral_0= 'CREATE' ) | (enumLiteral_1= 'RETRIEVE' ) | (enumLiteral_2= 'UPDATE' ) | (enumLiteral_3= 'DELETE' ) | (enumLiteral_4= 'GET' ) | (enumLiteral_5= 'PUT' ) | (enumLiteral_6= 'POST' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4312:1: ( (enumLiteral_0= 'CREATE' ) | (enumLiteral_1= 'RETRIEVE' ) | (enumLiteral_2= 'UPDATE' ) | (enumLiteral_3= 'DELETE' ) | (enumLiteral_4= 'GET' ) | (enumLiteral_5= 'PUT' ) | (enumLiteral_6= 'POST' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4312:1: ( (enumLiteral_0= 'CREATE' ) | (enumLiteral_1= 'RETRIEVE' ) | (enumLiteral_2= 'UPDATE' ) | (enumLiteral_3= 'DELETE' ) | (enumLiteral_4= 'GET' ) | (enumLiteral_5= 'PUT' ) | (enumLiteral_6= 'POST' ) )
            int alt104=7;
            switch ( input.LA(1) ) {
            case 104:
                {
                alt104=1;
                }
                break;
            case 105:
                {
                alt104=2;
                }
                break;
            case 106:
                {
                alt104=3;
                }
                break;
            case 107:
                {
                alt104=4;
                }
                break;
            case 108:
                {
                alt104=5;
                }
                break;
            case 109:
                {
                alt104=6;
                }
                break;
            case 110:
                {
                alt104=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }

            switch (alt104) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4312:2: (enumLiteral_0= 'CREATE' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4312:2: (enumLiteral_0= 'CREATE' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4312:4: enumLiteral_0= 'CREATE'
                    {
                    enumLiteral_0=(Token)match(input,104,FollowSets000.FOLLOW_104_in_ruleVerb9166); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getCREATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getVerbAccess().getCREATEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4318:6: (enumLiteral_1= 'RETRIEVE' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4318:6: (enumLiteral_1= 'RETRIEVE' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4318:8: enumLiteral_1= 'RETRIEVE'
                    {
                    enumLiteral_1=(Token)match(input,105,FollowSets000.FOLLOW_105_in_ruleVerb9183); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getRETRIEVEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getVerbAccess().getRETRIEVEEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4324:6: (enumLiteral_2= 'UPDATE' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4324:6: (enumLiteral_2= 'UPDATE' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4324:8: enumLiteral_2= 'UPDATE'
                    {
                    enumLiteral_2=(Token)match(input,106,FollowSets000.FOLLOW_106_in_ruleVerb9200); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getUPDATEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getVerbAccess().getUPDATEEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4330:6: (enumLiteral_3= 'DELETE' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4330:6: (enumLiteral_3= 'DELETE' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4330:8: enumLiteral_3= 'DELETE'
                    {
                    enumLiteral_3=(Token)match(input,107,FollowSets000.FOLLOW_107_in_ruleVerb9217); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getDELETEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getVerbAccess().getDELETEEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4336:6: (enumLiteral_4= 'GET' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4336:6: (enumLiteral_4= 'GET' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4336:8: enumLiteral_4= 'GET'
                    {
                    enumLiteral_4=(Token)match(input,108,FollowSets000.FOLLOW_108_in_ruleVerb9234); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getGETEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getVerbAccess().getGETEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4342:6: (enumLiteral_5= 'PUT' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4342:6: (enumLiteral_5= 'PUT' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4342:8: enumLiteral_5= 'PUT'
                    {
                    enumLiteral_5=(Token)match(input,109,FollowSets000.FOLLOW_109_in_ruleVerb9251); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getPUTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getVerbAccess().getPUTEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4348:6: (enumLiteral_6= 'POST' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4348:6: (enumLiteral_6= 'POST' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4348:8: enumLiteral_6= 'POST'
                    {
                    enumLiteral_6=(Token)match(input,110,FollowSets000.FOLLOW_110_in_ruleVerb9268); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4358:1: ruleReadWrite returns [Enumerator current=null] : ( (enumLiteral_0= 'read' ) | (enumLiteral_1= 'write' ) ) ;
    public final Enumerator ruleReadWrite() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4360:28: ( ( (enumLiteral_0= 'read' ) | (enumLiteral_1= 'write' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4361:1: ( (enumLiteral_0= 'read' ) | (enumLiteral_1= 'write' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4361:1: ( (enumLiteral_0= 'read' ) | (enumLiteral_1= 'write' ) )
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==111) ) {
                alt105=1;
            }
            else if ( (LA105_0==112) ) {
                alt105=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;
            }
            switch (alt105) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4361:2: (enumLiteral_0= 'read' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4361:2: (enumLiteral_0= 'read' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4361:4: enumLiteral_0= 'read'
                    {
                    enumLiteral_0=(Token)match(input,111,FollowSets000.FOLLOW_111_in_ruleReadWrite9313); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReadWriteAccess().getReadEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getReadWriteAccess().getReadEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4367:6: (enumLiteral_1= 'write' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4367:6: (enumLiteral_1= 'write' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4367:8: enumLiteral_1= 'write'
                    {
                    enumLiteral_1=(Token)match(input,112,FollowSets000.FOLLOW_112_in_ruleReadWrite9330); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4377:1: ruleHashAlgKind returns [Enumerator current=null] : ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'PlainText' ) ) ;
    public final Enumerator ruleHashAlgKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4379:28: ( ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'PlainText' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4380:1: ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'PlainText' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4380:1: ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'PlainText' ) )
            int alt106=4;
            switch ( input.LA(1) ) {
            case 113:
                {
                alt106=1;
                }
                break;
            case 114:
                {
                alt106=2;
                }
                break;
            case 115:
                {
                alt106=3;
                }
                break;
            case 116:
                {
                alt106=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }

            switch (alt106) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4380:2: (enumLiteral_0= 'MD5' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4380:2: (enumLiteral_0= 'MD5' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4380:4: enumLiteral_0= 'MD5'
                    {
                    enumLiteral_0=(Token)match(input,113,FollowSets000.FOLLOW_113_in_ruleHashAlgKind9375); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getMD5EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getHashAlgKindAccess().getMD5EnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4386:6: (enumLiteral_1= 'SHA1' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4386:6: (enumLiteral_1= 'SHA1' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4386:8: enumLiteral_1= 'SHA1'
                    {
                    enumLiteral_1=(Token)match(input,114,FollowSets000.FOLLOW_114_in_ruleHashAlgKind9392); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getSHA1EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getHashAlgKindAccess().getSHA1EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4392:6: (enumLiteral_2= 'SHA256' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4392:6: (enumLiteral_2= 'SHA256' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4392:8: enumLiteral_2= 'SHA256'
                    {
                    enumLiteral_2=(Token)match(input,115,FollowSets000.FOLLOW_115_in_ruleHashAlgKind9409); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getSHA256EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getHashAlgKindAccess().getSHA256EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4398:6: (enumLiteral_3= 'PlainText' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4398:6: (enumLiteral_3= 'PlainText' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4398:8: enumLiteral_3= 'PlainText'
                    {
                    enumLiteral_3=(Token)match(input,116,FollowSets000.FOLLOW_116_in_ruleHashAlgKind9426); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getPlainTextEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getHashAlgKindAccess().getPlainTextEnumLiteralDeclaration_3()); 
                          
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


    // $ANTLR start "ruleAuthTokenKind"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4408:1: ruleAuthTokenKind returns [Enumerator current=null] : ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'X509Certificate' ) | (enumLiteral_5= 'OAuth' ) ) ;
    public final Enumerator ruleAuthTokenKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4410:28: ( ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'X509Certificate' ) | (enumLiteral_5= 'OAuth' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4411:1: ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'X509Certificate' ) | (enumLiteral_5= 'OAuth' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4411:1: ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) | (enumLiteral_4= 'X509Certificate' ) | (enumLiteral_5= 'OAuth' ) )
            int alt107=6;
            switch ( input.LA(1) ) {
            case 117:
                {
                alt107=1;
                }
                break;
            case 118:
                {
                alt107=2;
                }
                break;
            case 119:
                {
                alt107=3;
                }
                break;
            case 120:
                {
                alt107=4;
                }
                break;
            case 121:
                {
                alt107=5;
                }
                break;
            case 122:
                {
                alt107=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;
            }

            switch (alt107) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4411:2: (enumLiteral_0= 'UsernamePassword' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4411:2: (enumLiteral_0= 'UsernamePassword' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4411:4: enumLiteral_0= 'UsernamePassword'
                    {
                    enumLiteral_0=(Token)match(input,117,FollowSets000.FOLLOW_117_in_ruleAuthTokenKind9471); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getUsernamePasswordEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAuthTokenKindAccess().getUsernamePasswordEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4417:6: (enumLiteral_1= 'SAML' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4417:6: (enumLiteral_1= 'SAML' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4417:8: enumLiteral_1= 'SAML'
                    {
                    enumLiteral_1=(Token)match(input,118,FollowSets000.FOLLOW_118_in_ruleAuthTokenKind9488); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSAMLEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getAuthTokenKindAccess().getSAMLEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4423:6: (enumLiteral_2= 'SAML2' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4423:6: (enumLiteral_2= 'SAML2' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4423:8: enumLiteral_2= 'SAML2'
                    {
                    enumLiteral_2=(Token)match(input,119,FollowSets000.FOLLOW_119_in_ruleAuthTokenKind9505); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSAML2EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getAuthTokenKindAccess().getSAML2EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4429:6: (enumLiteral_3= 'Kerberos' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4429:6: (enumLiteral_3= 'Kerberos' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4429:8: enumLiteral_3= 'Kerberos'
                    {
                    enumLiteral_3=(Token)match(input,120,FollowSets000.FOLLOW_120_in_ruleAuthTokenKind9522); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getKerberosEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getAuthTokenKindAccess().getKerberosEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4435:6: (enumLiteral_4= 'X509Certificate' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4435:6: (enumLiteral_4= 'X509Certificate' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4435:8: enumLiteral_4= 'X509Certificate'
                    {
                    enumLiteral_4=(Token)match(input,121,FollowSets000.FOLLOW_121_in_ruleAuthTokenKind9539); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getX509CertificateEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getAuthTokenKindAccess().getX509CertificateEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4441:6: (enumLiteral_5= 'OAuth' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4441:6: (enumLiteral_5= 'OAuth' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4441:8: enumLiteral_5= 'OAuth'
                    {
                    enumLiteral_5=(Token)match(input,122,FollowSets000.FOLLOW_122_in_ruleAuthTokenKind9556); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getOAuthEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getAuthTokenKindAccess().getOAuthEnumLiteralDeclaration_5()); 
                          
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4451:1: ruleLogPolicyKind returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'HEADER' ) | (enumLiteral_2= 'ALL' ) ) ;
    public final Enumerator ruleLogPolicyKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4453:28: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'HEADER' ) | (enumLiteral_2= 'ALL' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4454:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'HEADER' ) | (enumLiteral_2= 'ALL' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4454:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'HEADER' ) | (enumLiteral_2= 'ALL' ) )
            int alt108=3;
            switch ( input.LA(1) ) {
            case 123:
                {
                alt108=1;
                }
                break;
            case 124:
                {
                alt108=2;
                }
                break;
            case 125:
                {
                alt108=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;
            }

            switch (alt108) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4454:2: (enumLiteral_0= 'NONE' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4454:2: (enumLiteral_0= 'NONE' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4454:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,123,FollowSets000.FOLLOW_123_in_ruleLogPolicyKind9601); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getLogPolicyKindAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getLogPolicyKindAccess().getNONEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4460:6: (enumLiteral_1= 'HEADER' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4460:6: (enumLiteral_1= 'HEADER' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4460:8: enumLiteral_1= 'HEADER'
                    {
                    enumLiteral_1=(Token)match(input,124,FollowSets000.FOLLOW_124_in_ruleLogPolicyKind9618); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getLogPolicyKindAccess().getHEADEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getLogPolicyKindAccess().getHEADEREnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4466:6: (enumLiteral_2= 'ALL' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4466:6: (enumLiteral_2= 'ALL' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4466:8: enumLiteral_2= 'ALL'
                    {
                    enumLiteral_2=(Token)match(input,125,FollowSets000.FOLLOW_125_in_ruleLogPolicyKind9635); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getLogPolicyKindAccess().getALLEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getLogPolicyKindAccess().getALLEnumLiteralDeclaration_2()); 
                          
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


    // $ANTLR start "ruleGovernanceDecisionResult"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4476:1: ruleGovernanceDecisionResult returns [Enumerator current=null] : ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) ) ;
    public final Enumerator ruleGovernanceDecisionResult() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4478:28: ( ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4479:1: ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4479:1: ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) )
            int alt109=4;
            switch ( input.LA(1) ) {
            case 126:
                {
                alt109=1;
                }
                break;
            case 127:
                {
                alt109=2;
                }
                break;
            case 128:
                {
                alt109=3;
                }
                break;
            case 129:
                {
                alt109=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;
            }

            switch (alt109) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4479:2: (enumLiteral_0= 'pending' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4479:2: (enumLiteral_0= 'pending' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4479:4: enumLiteral_0= 'pending'
                    {
                    enumLiteral_0=(Token)match(input,126,FollowSets000.FOLLOW_126_in_ruleGovernanceDecisionResult9680); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getPendingEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getGovernanceDecisionResultAccess().getPendingEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4485:6: (enumLiteral_1= 'accepted' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4485:6: (enumLiteral_1= 'accepted' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4485:8: enumLiteral_1= 'accepted'
                    {
                    enumLiteral_1=(Token)match(input,127,FollowSets000.FOLLOW_127_in_ruleGovernanceDecisionResult9697); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getAcceptedEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getGovernanceDecisionResultAccess().getAcceptedEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4491:6: (enumLiteral_2= 'denied' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4491:6: (enumLiteral_2= 'denied' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4491:8: enumLiteral_2= 'denied'
                    {
                    enumLiteral_2=(Token)match(input,128,FollowSets000.FOLLOW_128_in_ruleGovernanceDecisionResult9714); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getDeniedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getGovernanceDecisionResultAccess().getDeniedEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4497:6: (enumLiteral_3= 'specific' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4497:6: (enumLiteral_3= 'specific' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4497:8: enumLiteral_3= 'specific'
                    {
                    enumLiteral_3=(Token)match(input,129,FollowSets000.FOLLOW_129_in_ruleGovernanceDecisionResult9731); if (state.failed) return current;
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
        public static final BitSet FOLLOW_ruleBindingModel_in_entryRuleBindingModel81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBindingModel91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_ruleBindingModel137 = new BitSet(new long[]{0x0000000001004002L,0x0000000000002000L});
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
        public static final BitSet FOLLOW_18_in_ruleModuleBinding651 = new BitSet(new long[]{0x0000000001F04000L,0x0000000000801000L});
        public static final BitSet FOLLOW_19_in_ruleModuleBinding671 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModuleBinding698 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleModuleBinding710 = new BitSet(new long[]{0x0000000001F04000L,0x0000000000801000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRefs_in_ruleModuleBinding733 = new BitSet(new long[]{0x0000000001F04000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleGovernanceDecision_in_ruleModuleBinding755 = new BitSet(new long[]{0x0000000001F04000L,0x0000000000800000L});
        public static final BitSet FOLLOW_20_in_ruleModuleBinding769 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleModuleBinding781 = new BitSet(new long[]{0xA888452200000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleModuleBinding802 = new BitSet(new long[]{0xA888452200200000L,0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleModuleBinding815 = new BitSet(new long[]{0x0000000001E04000L});
        public static final BitSet FOLLOW_22_in_ruleModuleBinding830 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleModuleBinding842 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000E18L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleModuleBinding863 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000E18L});
        public static final BitSet FOLLOW_21_in_ruleModuleBinding876 = new BitSet(new long[]{0x0000000001A04000L});
        public static final BitSet FOLLOW_23_in_ruleModuleBinding891 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModuleBinding918 = new BitSet(new long[]{0x0000000001206000L});
        public static final BitSet FOLLOW_13_in_ruleModuleBinding931 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModuleBinding958 = new BitSet(new long[]{0x0000000001206000L});
        public static final BitSet FOLLOW_ruleServiceBinding_in_ruleModuleBinding983 = new BitSet(new long[]{0x0000000001204000L});
        public static final BitSet FOLLOW_21_in_ruleModuleBinding996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModuleRef_in_entryRuleModuleRef1032 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModuleRef1042 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModuleRef1094 = new BitSet(new long[]{0x0000000000000000L,0x0000000000330000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleModuleRef1115 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceBinding_in_entryRuleServiceBinding1151 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleServiceBinding1161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleServiceBinding1198 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleServiceBinding1219 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleServiceBinding1231 = new BitSet(new long[]{0x0000000006000000L,0x0000000000801000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRefs_in_ruleServiceBinding1252 = new BitSet(new long[]{0x0000000006000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleGovernanceDecision_in_ruleServiceBinding1274 = new BitSet(new long[]{0x0000000006000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_25_in_ruleServiceBinding1288 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleServiceBinding1305 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleServiceBinding1324 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleServiceBinding1336 = new BitSet(new long[]{0xA888452200000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleServiceBinding1357 = new BitSet(new long[]{0xA888452200200000L,0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleServiceBinding1370 = new BitSet(new long[]{0x0000000078200000L});
        public static final BitSet FOLLOW_27_in_ruleServiceBinding1383 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleServiceBinding1395 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000E18L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleServiceBinding1416 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000E18L});
        public static final BitSet FOLLOW_21_in_ruleServiceBinding1429 = new BitSet(new long[]{0x0000000070200000L});
        public static final BitSet FOLLOW_28_in_ruleServiceBinding1444 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleServiceBinding1471 = new BitSet(new long[]{0x0000000060202000L});
        public static final BitSet FOLLOW_13_in_ruleServiceBinding1484 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleServiceBinding1511 = new BitSet(new long[]{0x0000000060202000L});
        public static final BitSet FOLLOW_29_in_ruleServiceBinding1528 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleModuleRef_in_ruleServiceBinding1549 = new BitSet(new long[]{0x0000000040200000L});
        public static final BitSet FOLLOW_ruleOperationBinding_in_ruleServiceBinding1572 = new BitSet(new long[]{0x0000000040200000L});
        public static final BitSet FOLLOW_21_in_ruleServiceBinding1585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceRef_in_entryRuleServiceRef1621 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleServiceRef1631 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleServiceRef1683 = new BitSet(new long[]{0x0000000000000000L,0x0000000000330000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleServiceRef1704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_entryRuleBindingProtocol1740 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBindingProtocol1750 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSCA_in_ruleBindingProtocol1800 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSOAP_in_ruleBindingProtocol1830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEJB_in_ruleBindingProtocol1860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHTTP_in_ruleBindingProtocol1890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleREST_in_ruleBindingProtocol1920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSAP_in_ruleBindingProtocol1950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJMS_in_ruleBindingProtocol1980 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFILE_in_ruleBindingProtocol2010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFTP_in_ruleBindingProtocol2040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIIOP_in_ruleBindingProtocol2070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAMQP_in_ruleBindingProtocol2100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperationBinding_in_entryRuleOperationBinding2135 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperationBinding2145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleOperationBinding2182 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleOperationBinding2209 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleOperationBinding2221 = new BitSet(new long[]{0x0000000004000000L,0x0000000000801000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRefs_in_ruleOperationBinding2242 = new BitSet(new long[]{0x0000000004000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_ruleGovernanceDecision_in_ruleOperationBinding2264 = new BitSet(new long[]{0x0000000004000000L,0x0000000000800000L});
        public static final BitSet FOLLOW_26_in_ruleOperationBinding2277 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleOperationBinding2289 = new BitSet(new long[]{0xA888452200000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleOperationBinding2310 = new BitSet(new long[]{0xA888452200200000L,0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleOperationBinding2323 = new BitSet(new long[]{0x0000000198200000L});
        public static final BitSet FOLLOW_31_in_ruleOperationBinding2336 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleOperationBinding2348 = new BitSet(new long[]{0xA888452200000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleOperationBinding2369 = new BitSet(new long[]{0xA888452200200000L,0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleOperationBinding2382 = new BitSet(new long[]{0x0000000118200000L});
        public static final BitSet FOLLOW_27_in_ruleOperationBinding2397 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleOperationBinding2409 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000E18L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleOperationBinding2430 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000E18L});
        public static final BitSet FOLLOW_21_in_ruleOperationBinding2443 = new BitSet(new long[]{0x0000000110200000L});
        public static final BitSet FOLLOW_32_in_ruleOperationBinding2458 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleOperationBinding2470 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000E18L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleOperationBinding2491 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000E18L});
        public static final BitSet FOLLOW_21_in_ruleOperationBinding2504 = new BitSet(new long[]{0x0000000010200000L});
        public static final BitSet FOLLOW_28_in_ruleOperationBinding2519 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleOperationBinding2546 = new BitSet(new long[]{0x0000000000202000L});
        public static final BitSet FOLLOW_13_in_ruleOperationBinding2559 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleOperationBinding2586 = new BitSet(new long[]{0x0000000000202000L});
        public static final BitSet FOLLOW_21_in_ruleOperationBinding2602 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSOAP_in_entryRuleSOAP2638 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSOAP2648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleSOAP2685 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleSOAP2697 = new BitSet(new long[]{0x0000001C00200800L,0x0000000000001000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRefs_in_ruleSOAP2730 = new BitSet(new long[]{0x0000001C00200800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleSOAP2752 = new BitSet(new long[]{0x0000001C00200000L});
        public static final BitSet FOLLOW_34_in_ruleSOAP2766 = new BitSet(new long[]{0x0000000000000000L,0x0000000380000000L});
        public static final BitSet FOLLOW_ruleSOAPStyle_in_ruleSOAP2787 = new BitSet(new long[]{0x0000001800200000L});
        public static final BitSet FOLLOW_35_in_ruleSOAP2802 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSOAP2819 = new BitSet(new long[]{0x0000001000200000L});
        public static final BitSet FOLLOW_36_in_ruleSOAP2839 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSOAP2856 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleSOAP2875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSAP_in_entryRuleSAP2911 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSAP2921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleSAP2958 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleSAP2970 = new BitSet(new long[]{0x000000C000200800L,0x0000000000001000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRefs_in_ruleSAP3003 = new BitSet(new long[]{0x000000C000200800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleSAP3025 = new BitSet(new long[]{0x000000C000200000L});
        public static final BitSet FOLLOW_38_in_ruleSAP3039 = new BitSet(new long[]{0x0000000000000000L,0x0000000C00000000L});
        public static final BitSet FOLLOW_ruleSAPTransport_in_ruleSAP3060 = new BitSet(new long[]{0x0000008000200000L});
        public static final BitSet FOLLOW_39_in_ruleSAP3075 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSAP3102 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleSAP3116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEJB_in_entryRuleEJB3152 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEJB3162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleEJB3199 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleEJB3211 = new BitSet(new long[]{0x0000020000000800L,0x0000000000001000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRefs_in_ruleEJB3232 = new BitSet(new long[]{0x0000020000000800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleEJB3254 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_41_in_ruleEJB3267 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEJB3284 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleEJB3301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHTTP_in_entryRuleHTTP3337 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHTTP3347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleHTTP3384 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleHTTP3396 = new BitSet(new long[]{0x0000080000000800L,0x0000000000001000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRefs_in_ruleHTTP3417 = new BitSet(new long[]{0x0000080000000800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleHTTP3439 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_43_in_ruleHTTP3452 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleHTTP3469 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_ruleHTTP3486 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleHTTP3503 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleHTTP3520 = new BitSet(new long[]{0x0000000000000000L,0x00007F0000000000L});
        public static final BitSet FOLLOW_ruleVerb_in_ruleHTTP3541 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleHTTP3553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleREST_in_entryRuleREST3589 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleREST3599 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleREST3636 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleREST3648 = new BitSet(new long[]{0x0000800000000800L,0x0000000000001000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRefs_in_ruleREST3669 = new BitSet(new long[]{0x0000800000000800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleREST3691 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleREST3704 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleREST3721 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_ruleREST3738 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleREST3755 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleREST3772 = new BitSet(new long[]{0x0000000000000000L,0x00007F0000000000L});
        public static final BitSet FOLLOW_ruleVerb_in_ruleREST3793 = new BitSet(new long[]{0x0007000000200000L});
        public static final BitSet FOLLOW_48_in_ruleREST3806 = new BitSet(new long[]{0x0000000000000000L,0x000000F000000000L});
        public static final BitSet FOLLOW_ruleRESTFormat_in_ruleREST3827 = new BitSet(new long[]{0x0006000000200000L});
        public static final BitSet FOLLOW_49_in_ruleREST3842 = new BitSet(new long[]{0x0000000000000000L,0x000000F000000000L});
        public static final BitSet FOLLOW_ruleRESTFormat_in_ruleREST3863 = new BitSet(new long[]{0x0004000000200000L});
        public static final BitSet FOLLOW_50_in_ruleREST3878 = new BitSet(new long[]{0x0000000000000000L,0x000000F000000000L});
        public static final BitSet FOLLOW_ruleRESTFormat_in_ruleREST3899 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleREST3913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJMS_in_entryRuleJMS3949 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleJMS3959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleJMS3996 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleJMS4008 = new BitSet(new long[]{0x0060020000000800L,0x0000000000001000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRefs_in_ruleJMS4041 = new BitSet(new long[]{0x0060020000000800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleJMS4063 = new BitSet(new long[]{0x0060020000000000L});
        public static final BitSet FOLLOW_ruleTopicOrQueue_in_ruleJMS4085 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_41_in_ruleJMS4098 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleJMS4115 = new BitSet(new long[]{0x0010000000200000L});
        public static final BitSet FOLLOW_52_in_ruleJMS4133 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleJMS4150 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleJMS4169 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTopicOrQueue_in_entryRuleTopicOrQueue4205 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTopicOrQueue4215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTopic_in_ruleTopicOrQueue4265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQueue_in_ruleTopicOrQueue4295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTopic_in_entryRuleTopic4330 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTopic4340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleTopic4377 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleTopic4394 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRefs_in_ruleTopic4420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQueue_in_entryRuleQueue4457 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQueue4467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleQueue4504 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleQueue4521 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRefs_in_ruleQueue4547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSCA_in_entryRuleSCA4584 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSCA4594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleSCA4643 = new BitSet(new long[]{0x0000000000040010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSCA4660 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleSCA4678 = new BitSet(new long[]{0x0300000000200800L,0x0000000000001000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRefs_in_ruleSCA4699 = new BitSet(new long[]{0x0300000000200800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleSCA4721 = new BitSet(new long[]{0x0300000000200000L});
        public static final BitSet FOLLOW_56_in_ruleSCA4735 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSCA4752 = new BitSet(new long[]{0x0200000000200000L});
        public static final BitSet FOLLOW_57_in_ruleSCA4772 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSCA4789 = new BitSet(new long[]{0x0400000000200000L});
        public static final BitSet FOLLOW_58_in_ruleSCA4812 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleSCA4840 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFILE_in_entryRuleFILE4876 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFILE4886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_ruleFILE4923 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleFILE4935 = new BitSet(new long[]{0x0000000000000810L,0x0000000000001000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRefs_in_ruleFILE4956 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleFILE4978 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFILE4996 = new BitSet(new long[]{0x0000000000000000L,0x0001800000000000L});
        public static final BitSet FOLLOW_ruleReadWrite_in_ruleFILE5022 = new BitSet(new long[]{0x1000000000200000L});
        public static final BitSet FOLLOW_60_in_ruleFILE5035 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFILE5052 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleFILE5071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFTP_in_entryRuleFTP5107 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFTP5117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleFTP5154 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleFTP5166 = new BitSet(new long[]{0x4000000000000800L,0x0000000000001000L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRefs_in_ruleFTP5187 = new BitSet(new long[]{0x4000000000000800L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleFTP5209 = new BitSet(new long[]{0x4000000000000000L});
        public static final BitSet FOLLOW_62_in_ruleFTP5222 = new BitSet(new long[]{0x0000000000000000L,0x0001800000000000L});
        public static final BitSet FOLLOW_ruleReadWrite_in_ruleFTP5243 = new BitSet(new long[]{0x1000000000200000L});
        public static final BitSet FOLLOW_60_in_ruleFTP5256 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFTP5273 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleFTP5292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIIOP_in_entryRuleIIOP5328 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIIOP5338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleIIOP5375 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleIIOP5387 = new BitSet(new long[]{0x0000000000000800L,0x0000000000001001L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRefs_in_ruleIIOP5408 = new BitSet(new long[]{0x0000000000000800L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleIIOP5430 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_64_in_ruleIIOP5443 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleIIOP5460 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleIIOP5477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAMQP_in_entryRuleAMQP5513 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAMQP5523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleAMQP5560 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleAMQP5572 = new BitSet(new long[]{0x0060000000000800L,0x0000000000001001L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRefs_in_ruleAMQP5605 = new BitSet(new long[]{0x0060000000000800L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleConnectorQualifier_in_ruleAMQP5627 = new BitSet(new long[]{0x0060000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleTopicOrQueue_in_ruleAMQP5649 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_64_in_ruleAMQP5662 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAMQP5679 = new BitSet(new long[]{0x0000000000200000L,0x0000000000000004L});
        public static final BitSet FOLLOW_66_in_ruleAMQP5697 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAMQP5714 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleAMQP5733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePolicy_in_entryRulePolicy5769 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePolicy5779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLogPolicy_in_rulePolicy5829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecurityPolicy_in_rulePolicy5859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLogPolicy_in_entryRuleLogPolicy5894 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLogPolicy5904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_ruleLogPolicy5941 = new BitSet(new long[]{0x0000000000000000L,0x3800000000000000L});
        public static final BitSet FOLLOW_ruleLogPolicyKind_in_ruleLogPolicy5962 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecurityPolicy_in_entryRuleSecurityPolicy5998 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecurityPolicy6008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthenticationPolicy_in_ruleSecurityPolicy6058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthorizationPolicy_in_ruleSecurityPolicy6088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSigningPolicy_in_ruleSecurityPolicy6118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEncryptionPolicy_in_ruleSecurityPolicy6148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthenticationPolicy_in_entryRuleAuthenticationPolicy6183 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAuthenticationPolicy6193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleAuthenticationPolicy6242 = new BitSet(new long[]{0x0000000000040020L,0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAuthenticationPolicy6259 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000020L});
        public static final BitSet FOLLOW_69_in_ruleAuthenticationPolicy6283 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleAuthenticationPolicy6309 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_70_in_ruleAuthenticationPolicy6321 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleAuthenticationPolicy6333 = new BitSet(new long[]{0x0000000000000000L,0x07E0000000000020L});
        public static final BitSet FOLLOW_ruleAuthToken_in_ruleAuthenticationPolicy6354 = new BitSet(new long[]{0x0000000000200000L,0x07E0000000000020L});
        public static final BitSet FOLLOW_21_in_ruleAuthenticationPolicy6367 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_ruleAuthenticationPolicy6379 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleAuthenticationPolicy6391 = new BitSet(new long[]{0x0000000000200000L,0x001E000000000120L});
        public static final BitSet FOLLOW_ruleHashAlgorithm_in_ruleAuthenticationPolicy6412 = new BitSet(new long[]{0x0000000000200000L,0x001E000000000120L});
        public static final BitSet FOLLOW_21_in_ruleAuthenticationPolicy6425 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleAuthenticationPolicy6437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthToken_in_entryRuleAuthToken6473 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAuthToken6483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_69_in_ruleAuthToken6526 = new BitSet(new long[]{0x0000000000000000L,0x07E0000000000020L});
        public static final BitSet FOLLOW_ruleAuthTokenKind_in_ruleAuthToken6561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHashAlgorithm_in_entryRuleHashAlgorithm6597 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHashAlgorithm6607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_69_in_ruleHashAlgorithm6650 = new BitSet(new long[]{0x0000000000000000L,0x001E000000000120L});
        public static final BitSet FOLLOW_72_in_ruleHashAlgorithm6682 = new BitSet(new long[]{0x0000000000000000L,0x001E000000000120L});
        public static final BitSet FOLLOW_ruleHashAlgKind_in_ruleHashAlgorithm6717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthorizationPolicy_in_entryRuleAuthorizationPolicy6753 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAuthorizationPolicy6763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_73_in_ruleAuthorizationPolicy6812 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSigningPolicy_in_entryRuleSigningPolicy6848 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSigningPolicy6858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_74_in_ruleSigningPolicy6907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEncryptionPolicy_in_entryRuleEncryptionPolicy6943 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEncryptionPolicy6953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleEncryptionPolicy7002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEndpointQualifierRefs_in_entryRuleEndpointQualifierRefs7038 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEndpointQualifierRefs7048 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_76_in_ruleEndpointQualifierRefs7085 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleEndpointQualifierRefs7112 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleEndpointQualifierRefs7125 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleEndpointQualifierRefs7152 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport7190 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport7200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_77_in_ruleImport7237 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport7258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVersionId_in_entryRuleVersionId7295 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionId7306 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId7346 = new BitSet(new long[]{0x0000000000000002L,0x000000000000C000L});
        public static final BitSet FOLLOW_78_in_ruleVersionId7365 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId7380 = new BitSet(new long[]{0x0000000000000002L,0x000000000000C000L});
        public static final BitSet FOLLOW_78_in_ruleVersionId7402 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_79_in_ruleVersionId7421 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVersionId7437 = new BitSet(new long[]{0x0000000000000002L,0x000000000000C000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_entryRuleVersionRef7488 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionRef7498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_ruleVersionRef7548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_ruleVersionRef7578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef7608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_ruleVersionRef7638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_ruleVersionRef7668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef7703 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMinVersionRef7713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_80_in_ruleMinVersionRef7750 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMinVersionRef7771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef7807 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxVersionRef7817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_81_in_ruleMaxVersionRef7854 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMaxVersionRef7875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef7911 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef7921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_80_in_ruleLowerBoundRangeVersionRef7959 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
        public static final BitSet FOLLOW_82_in_ruleLowerBoundRangeVersionRef7971 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef7993 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleLowerBoundRangeVersionRef8005 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
        public static final BitSet FOLLOW_81_in_ruleLowerBoundRangeVersionRef8018 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
        public static final BitSet FOLLOW_83_in_ruleLowerBoundRangeVersionRef8030 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef8052 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef8088 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMajorVersionRef8098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_84_in_ruleMajorVersionRef8135 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMajorVersionRef8152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef8193 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFixedVersionRef8203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_85_in_ruleFixedVersionRef8240 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleFixedVersionRef8261 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard8298 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard8309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard8356 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
        public static final BitSet FOLLOW_86_in_ruleQualifiedNameWithWildCard8375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName8418 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName8429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName8469 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
        public static final BitSet FOLLOW_78_in_ruleQualifiedName8488 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName8503 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleGovernanceDecision_in_entryRuleGovernanceDecision8550 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGovernanceDecision8560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_87_in_ruleGovernanceDecision8597 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleGovernanceDecision8609 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
        public static final BitSet FOLLOW_88_in_ruleGovernanceDecision8622 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGovernanceDecision8639 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
        public static final BitSet FOLLOW_89_in_ruleGovernanceDecision8658 = new BitSet(new long[]{0x0000000000000000L,0xC000000000000000L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleGovernanceDecisionResult_in_ruleGovernanceDecision8679 = new BitSet(new long[]{0x0000000000200000L,0x000000007C000000L});
        public static final BitSet FOLLOW_90_in_ruleGovernanceDecision8693 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGovernanceDecision8710 = new BitSet(new long[]{0x0000000000200000L,0x0000000078000000L});
        public static final BitSet FOLLOW_91_in_ruleGovernanceDecision8730 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGovernanceDecision8747 = new BitSet(new long[]{0x0000000000200000L,0x0000000070000000L});
        public static final BitSet FOLLOW_92_in_ruleGovernanceDecision8767 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGovernanceDecision8784 = new BitSet(new long[]{0x0000000000200000L,0x0000000060000000L});
        public static final BitSet FOLLOW_93_in_ruleGovernanceDecision8804 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGovernanceDecision8821 = new BitSet(new long[]{0x0000000000200000L,0x0000000040000000L});
        public static final BitSet FOLLOW_94_in_ruleGovernanceDecision8841 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleGovernanceDecision8858 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleGovernanceDecision8877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_95_in_ruleSOAPStyle8929 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_96_in_ruleSOAPStyle8946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_97_in_ruleSOAPStyle8963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_98_in_ruleSAPTransport9008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_99_in_ruleSAPTransport9025 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_100_in_ruleRESTFormat9070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_101_in_ruleRESTFormat9087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_102_in_ruleRESTFormat9104 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_103_in_ruleRESTFormat9121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_104_in_ruleVerb9166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_105_in_ruleVerb9183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_106_in_ruleVerb9200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_107_in_ruleVerb9217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_108_in_ruleVerb9234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_109_in_ruleVerb9251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_110_in_ruleVerb9268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_111_in_ruleReadWrite9313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_112_in_ruleReadWrite9330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_113_in_ruleHashAlgKind9375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_114_in_ruleHashAlgKind9392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_115_in_ruleHashAlgKind9409 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_116_in_ruleHashAlgKind9426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_117_in_ruleAuthTokenKind9471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_118_in_ruleAuthTokenKind9488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_119_in_ruleAuthTokenKind9505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_120_in_ruleAuthTokenKind9522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_121_in_ruleAuthTokenKind9539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_122_in_ruleAuthTokenKind9556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_123_in_ruleLogPolicyKind9601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_124_in_ruleLogPolicyKind9618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_125_in_ruleLogPolicyKind9635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_126_in_ruleGovernanceDecisionResult9680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_127_in_ruleGovernanceDecisionResult9697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_128_in_ruleGovernanceDecisionResult9714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_129_in_ruleGovernanceDecisionResult9731 = new BitSet(new long[]{0x0000000000000002L});
    }


}