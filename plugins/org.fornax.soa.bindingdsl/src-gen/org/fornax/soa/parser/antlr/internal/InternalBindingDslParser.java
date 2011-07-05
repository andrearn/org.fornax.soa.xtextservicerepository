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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'bind namespace'", "'as'", "'to'", "'environment'", "'{'", "'protocols'", "'}'", "'policies'", "'provider-policies'", "'SLAs'", "','", "'publish on'", "'provided on'", "'bind service'", "'provider-protocols'", "'bind op'", "'bind-module'", "'default-protocols'", "'default-policies'", "'default-SLAs'", "'for'", "'service'", "'component'", "'implements'", "'bind to environment'", "'provided-services'", "'referenced-services'", "'implementation'", "'sourceURL'", "'SOAP'", "'style'", "'http-context-root'", "'provider-http-context-root'", "'provided-WSDL-Url'", "'SAP'", "'transport'", "'client'", "'EJB'", "'jndi-name'", "'HTTP'", "'url'", "'provider-url'", "'verb'", "'REST'", "'format'", "'JMS'", "'provider-jndi-name'", "'topic'", "'queue'", "'SCA'", "'promote'", "'reference'", "'[]'", "'FILE'", "'interval'", "'FTP'", "'access'", "'logging policy'", "'authn policy'", "'optional'", "'auth tokens'", "'hash algorithms'", "'Base64-encoded'", "'authorization rolicy'", "'signing policy'", "'encryption policy'", "'import'", "'.'", "'minVersion'", "'maxVersion'", "'>='", "'<'", "'majorVersion'", "'fixedVersion'", "'.*'", "'BPMN'", "'BPMN2'", "'BPEL'", "'WS-HT'", "'RuleML'", "'Drools'", "'Mediation'", "'Java'", "'C#'", "'C++'", "'Scala'", "'Ruby'", "'PHP'", "'WS-Document/Literal'", "'WS-RPC/Literal'", "'WS-RPC/Encoded'", "'REST-XML'", "'REST-JSON'", "'Spring'", "'EJB2'", "'SAP/iDoc'", "'SAP/BAPI'", "'Corba'", "'Shell'", "'Siebel'", "'Tuxedo'", "'File'", "'SQL'", "'Ivy'", "'jPDL3'", "'jPDL4'", "'document/literal-wrapped'", "'rpc/literal'", "'rpc/encoded'", "'IDOC'", "'RFC'", "'JSON'", "'XML'", "'OTHER'", "'create'", "'retrieve'", "'update'", "'delete'", "'read'", "'write'", "'MD5'", "'SHA1'", "'SHA256'", "'PlainText'", "'UsernamePassword'", "'SAML'", "'SAML2'", "'Kerberos'", "'NONE'", "'HEADER'", "'ALL'"
    };
    public static final int RULE_ID=4;
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
    public static final int RULE_STRING=5;
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


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:78:2: (iv_ruleBindingModel= ruleBindingModel EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:79:2: iv_ruleBindingModel= ruleBindingModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBindingModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBindingModel_in_entryRuleBindingModel87);
            iv_ruleBindingModel=ruleBindingModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBindingModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBindingModel97); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleBindingModel"


    // $ANTLR start "ruleBindingModel"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:89:1: ruleBindingModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_bindings_1_0= ruleBinding ) )* ) ;
    public final EObject ruleBindingModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_bindings_1_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:93:28: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_bindings_1_0= ruleBinding ) )* ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:94:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_bindings_1_0= ruleBinding ) )* )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:94:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_bindings_1_0= ruleBinding ) )* )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:94:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_bindings_1_0= ruleBinding ) )*
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:94:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==77) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:95:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:95:1: (lv_imports_0_0= ruleImport )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:96:3: lv_imports_0_0= ruleImport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBindingModelAccess().getImportsImportParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleImport_in_ruleBindingModel147);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:112:3: ( (lv_bindings_1_0= ruleBinding ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11||LA2_0==24||LA2_0==27) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:113:1: (lv_bindings_1_0= ruleBinding )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:113:1: (lv_bindings_1_0= ruleBinding )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:114:3: lv_bindings_1_0= ruleBinding
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBindingModelAccess().getBindingsBindingParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleBinding_in_ruleBindingModel169);
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleBindingModel"


    // $ANTLR start "entryRuleBinding"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:141:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:142:2: (iv_ruleBinding= ruleBinding EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:143:2: iv_ruleBinding= ruleBinding EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBindingRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBinding_in_entryRuleBinding210);
            iv_ruleBinding=ruleBinding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinding; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBinding220); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:150:1: ruleBinding returns [EObject current=null] : (this_DomainBinding_0= ruleDomainBinding | this_ModuleBinding_1= ruleModuleBinding | this_ServiceBinding_2= ruleServiceBinding ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        EObject this_DomainBinding_0 = null;

        EObject this_ModuleBinding_1 = null;

        EObject this_ServiceBinding_2 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:153:28: ( (this_DomainBinding_0= ruleDomainBinding | this_ModuleBinding_1= ruleModuleBinding | this_ServiceBinding_2= ruleServiceBinding ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:154:1: (this_DomainBinding_0= ruleDomainBinding | this_ModuleBinding_1= ruleModuleBinding | this_ServiceBinding_2= ruleServiceBinding )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:154:1: (this_DomainBinding_0= ruleDomainBinding | this_ModuleBinding_1= ruleModuleBinding | this_ServiceBinding_2= ruleServiceBinding )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt3=1;
                }
                break;
            case 27:
                {
                alt3=2;
                }
                break;
            case 24:
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:155:2: this_DomainBinding_0= ruleDomainBinding
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingAccess().getDomainBindingParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDomainBinding_in_ruleBinding270);
                    this_DomainBinding_0=ruleDomainBinding();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_DomainBinding_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:168:2: this_ModuleBinding_1= ruleModuleBinding
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingAccess().getModuleBindingParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleModuleBinding_in_ruleBinding300);
                    this_ModuleBinding_1=ruleModuleBinding();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ModuleBinding_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:181:2: this_ServiceBinding_2= ruleServiceBinding
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingAccess().getServiceBindingParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleServiceBinding_in_ruleBinding330);
                    this_ServiceBinding_2=ruleServiceBinding();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ServiceBinding_2; 
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


    // $ANTLR start "entryRuleDomainBinding"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:200:1: entryRuleDomainBinding returns [EObject current=null] : iv_ruleDomainBinding= ruleDomainBinding EOF ;
    public final EObject entryRuleDomainBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomainBinding = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:201:2: (iv_ruleDomainBinding= ruleDomainBinding EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:202:2: iv_ruleDomainBinding= ruleDomainBinding EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDomainBindingRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDomainBinding_in_entryRuleDomainBinding365);
            iv_ruleDomainBinding=ruleDomainBinding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDomainBinding; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDomainBinding375); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDomainBinding"


    // $ANTLR start "ruleDomainBinding"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:209:1: ruleDomainBinding returns [EObject current=null] : (otherlv_0= 'bind namespace' ( ( ruleQualifiedName ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' otherlv_5= 'environment' ( (otherlv_6= RULE_ID ) ) otherlv_7= '{' (otherlv_8= 'protocols' otherlv_9= '{' ( (lv_protocol_10_0= ruleBindingProtocol ) )+ otherlv_11= '}' )? (otherlv_12= 'policies' otherlv_13= '{' ( (lv_policies_14_0= rulePolicy ) )* otherlv_15= '}' )? (otherlv_16= 'provider-policies' otherlv_17= '{' ( (lv_providerPolicies_18_0= rulePolicy ) )* otherlv_19= '}' )? (otherlv_20= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_22= ',' ( ( ruleQualifiedName ) ) )* )? ( (lv_serviceBinding_24_0= ruleServiceBinding ) )* ( (lv_components_25_0= ruleComponent ) )* otherlv_26= '}' ) ;
    public final EObject ruleDomainBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_26=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_protocol_10_0 = null;

        EObject lv_policies_14_0 = null;

        EObject lv_providerPolicies_18_0 = null;

        EObject lv_serviceBinding_24_0 = null;

        EObject lv_components_25_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:212:28: ( (otherlv_0= 'bind namespace' ( ( ruleQualifiedName ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' otherlv_5= 'environment' ( (otherlv_6= RULE_ID ) ) otherlv_7= '{' (otherlv_8= 'protocols' otherlv_9= '{' ( (lv_protocol_10_0= ruleBindingProtocol ) )+ otherlv_11= '}' )? (otherlv_12= 'policies' otherlv_13= '{' ( (lv_policies_14_0= rulePolicy ) )* otherlv_15= '}' )? (otherlv_16= 'provider-policies' otherlv_17= '{' ( (lv_providerPolicies_18_0= rulePolicy ) )* otherlv_19= '}' )? (otherlv_20= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_22= ',' ( ( ruleQualifiedName ) ) )* )? ( (lv_serviceBinding_24_0= ruleServiceBinding ) )* ( (lv_components_25_0= ruleComponent ) )* otherlv_26= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:213:1: (otherlv_0= 'bind namespace' ( ( ruleQualifiedName ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' otherlv_5= 'environment' ( (otherlv_6= RULE_ID ) ) otherlv_7= '{' (otherlv_8= 'protocols' otherlv_9= '{' ( (lv_protocol_10_0= ruleBindingProtocol ) )+ otherlv_11= '}' )? (otherlv_12= 'policies' otherlv_13= '{' ( (lv_policies_14_0= rulePolicy ) )* otherlv_15= '}' )? (otherlv_16= 'provider-policies' otherlv_17= '{' ( (lv_providerPolicies_18_0= rulePolicy ) )* otherlv_19= '}' )? (otherlv_20= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_22= ',' ( ( ruleQualifiedName ) ) )* )? ( (lv_serviceBinding_24_0= ruleServiceBinding ) )* ( (lv_components_25_0= ruleComponent ) )* otherlv_26= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:213:1: (otherlv_0= 'bind namespace' ( ( ruleQualifiedName ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' otherlv_5= 'environment' ( (otherlv_6= RULE_ID ) ) otherlv_7= '{' (otherlv_8= 'protocols' otherlv_9= '{' ( (lv_protocol_10_0= ruleBindingProtocol ) )+ otherlv_11= '}' )? (otherlv_12= 'policies' otherlv_13= '{' ( (lv_policies_14_0= rulePolicy ) )* otherlv_15= '}' )? (otherlv_16= 'provider-policies' otherlv_17= '{' ( (lv_providerPolicies_18_0= rulePolicy ) )* otherlv_19= '}' )? (otherlv_20= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_22= ',' ( ( ruleQualifiedName ) ) )* )? ( (lv_serviceBinding_24_0= ruleServiceBinding ) )* ( (lv_components_25_0= ruleComponent ) )* otherlv_26= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:213:3: otherlv_0= 'bind namespace' ( ( ruleQualifiedName ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' otherlv_5= 'environment' ( (otherlv_6= RULE_ID ) ) otherlv_7= '{' (otherlv_8= 'protocols' otherlv_9= '{' ( (lv_protocol_10_0= ruleBindingProtocol ) )+ otherlv_11= '}' )? (otherlv_12= 'policies' otherlv_13= '{' ( (lv_policies_14_0= rulePolicy ) )* otherlv_15= '}' )? (otherlv_16= 'provider-policies' otherlv_17= '{' ( (lv_providerPolicies_18_0= rulePolicy ) )* otherlv_19= '}' )? (otherlv_20= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_22= ',' ( ( ruleQualifiedName ) ) )* )? ( (lv_serviceBinding_24_0= ruleServiceBinding ) )* ( (lv_components_25_0= ruleComponent ) )* otherlv_26= '}'
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleDomainBinding412); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDomainBindingAccess().getBindNamespaceKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:217:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:218:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:218:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:219:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getDomainBindingRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDomainBindingAccess().getSubNamespaceSubNamespaceCrossReference_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleDomainBinding439);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleDomainBinding451); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getDomainBindingAccess().getAsKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:239:1: ( (lv_name_3_0= ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:240:1: (lv_name_3_0= ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:240:1: (lv_name_3_0= ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:241:3: lv_name_3_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDomainBindingAccess().getNameQualifiedNameParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleDomainBinding472);
            lv_name_3_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDomainBindingRule());
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

            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleDomainBinding484); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getDomainBindingAccess().getToKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleDomainBinding496); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getDomainBindingAccess().getEnvironmentKeyword_5());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:265:1: ( (otherlv_6= RULE_ID ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:266:1: (otherlv_6= RULE_ID )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:266:1: (otherlv_6= RULE_ID )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:267:3: otherlv_6= RULE_ID
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getDomainBindingRule());
              	        }
                      
            }
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDomainBinding520); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_6, grammarAccess.getDomainBindingAccess().getEnvironmentEnvironmentCrossReference_6_0()); 
              	
            }

            }


            }

            otherlv_7=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleDomainBinding532); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getDomainBindingAccess().getLeftCurlyBracketKeyword_7());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:285:1: (otherlv_8= 'protocols' otherlv_9= '{' ( (lv_protocol_10_0= ruleBindingProtocol ) )+ otherlv_11= '}' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:285:3: otherlv_8= 'protocols' otherlv_9= '{' ( (lv_protocol_10_0= ruleBindingProtocol ) )+ otherlv_11= '}'
                    {
                    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleDomainBinding545); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getDomainBindingAccess().getProtocolsKeyword_8_0());
                          
                    }
                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleDomainBinding557); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getDomainBindingAccess().getLeftCurlyBracketKeyword_8_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:293:1: ( (lv_protocol_10_0= ruleBindingProtocol ) )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==40||LA4_0==45||LA4_0==48||LA4_0==50||LA4_0==54||LA4_0==56||LA4_0==60||LA4_0==64||LA4_0==66) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:294:1: (lv_protocol_10_0= ruleBindingProtocol )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:294:1: (lv_protocol_10_0= ruleBindingProtocol )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:295:3: lv_protocol_10_0= ruleBindingProtocol
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDomainBindingAccess().getProtocolBindingProtocolParserRuleCall_8_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleDomainBinding578);
                    	    lv_protocol_10_0=ruleBindingProtocol();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDomainBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"protocol",
                    	              		lv_protocol_10_0, 
                    	              		"BindingProtocol");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);

                    otherlv_11=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleDomainBinding591); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getDomainBindingAccess().getRightCurlyBracketKeyword_8_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:315:3: (otherlv_12= 'policies' otherlv_13= '{' ( (lv_policies_14_0= rulePolicy ) )* otherlv_15= '}' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:315:5: otherlv_12= 'policies' otherlv_13= '{' ( (lv_policies_14_0= rulePolicy ) )* otherlv_15= '}'
                    {
                    otherlv_12=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleDomainBinding606); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getDomainBindingAccess().getPoliciesKeyword_9_0());
                          
                    }
                    otherlv_13=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleDomainBinding618); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getDomainBindingAccess().getLeftCurlyBracketKeyword_9_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:323:1: ( (lv_policies_14_0= rulePolicy ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=68 && LA6_0<=69)||(LA6_0>=74 && LA6_0<=76)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:324:1: (lv_policies_14_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:324:1: (lv_policies_14_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:325:3: lv_policies_14_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDomainBindingAccess().getPoliciesPolicyParserRuleCall_9_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleDomainBinding639);
                    	    lv_policies_14_0=rulePolicy();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDomainBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"policies",
                    	              		lv_policies_14_0, 
                    	              		"Policy");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleDomainBinding652); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getDomainBindingAccess().getRightCurlyBracketKeyword_9_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:345:3: (otherlv_16= 'provider-policies' otherlv_17= '{' ( (lv_providerPolicies_18_0= rulePolicy ) )* otherlv_19= '}' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:345:5: otherlv_16= 'provider-policies' otherlv_17= '{' ( (lv_providerPolicies_18_0= rulePolicy ) )* otherlv_19= '}'
                    {
                    otherlv_16=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleDomainBinding667); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getDomainBindingAccess().getProviderPoliciesKeyword_10_0());
                          
                    }
                    otherlv_17=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleDomainBinding679); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getDomainBindingAccess().getLeftCurlyBracketKeyword_10_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:353:1: ( (lv_providerPolicies_18_0= rulePolicy ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>=68 && LA8_0<=69)||(LA8_0>=74 && LA8_0<=76)) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:354:1: (lv_providerPolicies_18_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:354:1: (lv_providerPolicies_18_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:355:3: lv_providerPolicies_18_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDomainBindingAccess().getProviderPoliciesPolicyParserRuleCall_10_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleDomainBinding700);
                    	    lv_providerPolicies_18_0=rulePolicy();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDomainBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"providerPolicies",
                    	              		lv_providerPolicies_18_0, 
                    	              		"Policy");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    otherlv_19=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleDomainBinding713); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getDomainBindingAccess().getRightCurlyBracketKeyword_10_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:375:3: (otherlv_20= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_22= ',' ( ( ruleQualifiedName ) ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:375:5: otherlv_20= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_22= ',' ( ( ruleQualifiedName ) ) )*
                    {
                    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleDomainBinding728); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getDomainBindingAccess().getSLAsKeyword_11_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:379:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:380:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:380:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:381:3: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getDomainBindingRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDomainBindingAccess().getSlaSLACrossReference_11_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleDomainBinding755);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:397:2: (otherlv_22= ',' ( ( ruleQualifiedName ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==21) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:397:4: otherlv_22= ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_22=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleDomainBinding768); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_22, grammarAccess.getDomainBindingAccess().getCommaKeyword_11_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:401:1: ( ( ruleQualifiedName ) )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:402:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:402:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:403:3: ruleQualifiedName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getDomainBindingRule());
                    	      	        }
                    	              
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDomainBindingAccess().getSlaSLACrossReference_11_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleDomainBinding795);
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
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:419:6: ( (lv_serviceBinding_24_0= ruleServiceBinding ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==24) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:420:1: (lv_serviceBinding_24_0= ruleServiceBinding )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:420:1: (lv_serviceBinding_24_0= ruleServiceBinding )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:421:3: lv_serviceBinding_24_0= ruleServiceBinding
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDomainBindingAccess().getServiceBindingServiceBindingParserRuleCall_12_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceBinding_in_ruleDomainBinding820);
            	    lv_serviceBinding_24_0=ruleServiceBinding();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getDomainBindingRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"serviceBinding",
            	              		lv_serviceBinding_24_0, 
            	              		"ServiceBinding");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:437:3: ( (lv_components_25_0= ruleComponent ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==33) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:438:1: (lv_components_25_0= ruleComponent )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:438:1: (lv_components_25_0= ruleComponent )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:439:3: lv_components_25_0= ruleComponent
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getDomainBindingAccess().getComponentsComponentParserRuleCall_13_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleComponent_in_ruleDomainBinding842);
            	    lv_components_25_0=ruleComponent();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getDomainBindingRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"components",
            	              		lv_components_25_0, 
            	              		"Component");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_26=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleDomainBinding855); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_26, grammarAccess.getDomainBindingAccess().getRightCurlyBracketKeyword_14());
                  
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
    // $ANTLR end "ruleDomainBinding"


    // $ANTLR start "entryRulePublisher"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:467:1: entryRulePublisher returns [EObject current=null] : iv_rulePublisher= rulePublisher EOF ;
    public final EObject entryRulePublisher() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePublisher = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:468:2: (iv_rulePublisher= rulePublisher EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:469:2: iv_rulePublisher= rulePublisher EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPublisherRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePublisher_in_entryRulePublisher891);
            iv_rulePublisher=rulePublisher();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePublisher; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePublisher901); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePublisher"


    // $ANTLR start "rulePublisher"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:476:1: rulePublisher returns [EObject current=null] : (otherlv_0= 'publish on' ( ( ruleQualifiedName ) ) ) ;
    public final EObject rulePublisher() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:479:28: ( (otherlv_0= 'publish on' ( ( ruleQualifiedName ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:480:1: (otherlv_0= 'publish on' ( ( ruleQualifiedName ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:480:1: (otherlv_0= 'publish on' ( ( ruleQualifiedName ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:480:3: otherlv_0= 'publish on' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_rulePublisher938); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getPublisherAccess().getPublishOnKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:484:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:485:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:485:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:486:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPublisherRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPublisherAccess().getPubServerServerCrossReference_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rulePublisher965);
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
    // $ANTLR end "rulePublisher"


    // $ANTLR start "entryRuleProvider"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:510:1: entryRuleProvider returns [EObject current=null] : iv_ruleProvider= ruleProvider EOF ;
    public final EObject entryRuleProvider() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProvider = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:511:2: (iv_ruleProvider= ruleProvider EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:512:2: iv_ruleProvider= ruleProvider EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProviderRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleProvider_in_entryRuleProvider1001);
            iv_ruleProvider=ruleProvider();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProvider; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProvider1011); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProvider"


    // $ANTLR start "ruleProvider"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:519:1: ruleProvider returns [EObject current=null] : (otherlv_0= 'provided on' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleProvider() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:522:28: ( (otherlv_0= 'provided on' ( ( ruleQualifiedName ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:523:1: (otherlv_0= 'provided on' ( ( ruleQualifiedName ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:523:1: (otherlv_0= 'provided on' ( ( ruleQualifiedName ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:523:3: otherlv_0= 'provided on' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleProvider1048); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getProviderAccess().getProvidedOnKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:527:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:528:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:528:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:529:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getProviderRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProviderAccess().getProvServerServerCrossReference_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleProvider1075);
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
    // $ANTLR end "ruleProvider"


    // $ANTLR start "entryRuleServiceBinding"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:553:1: entryRuleServiceBinding returns [EObject current=null] : iv_ruleServiceBinding= ruleServiceBinding EOF ;
    public final EObject entryRuleServiceBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceBinding = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:554:2: (iv_ruleServiceBinding= ruleServiceBinding EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:555:2: iv_ruleServiceBinding= ruleServiceBinding EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getServiceBindingRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceBinding_in_entryRuleServiceBinding1111);
            iv_ruleServiceBinding=ruleServiceBinding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleServiceBinding; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleServiceBinding1121); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:562:1: ruleServiceBinding returns [EObject current=null] : (otherlv_0= 'bind service' ( (lv_service_1_0= ruleServiceRef ) ) otherlv_2= 'to' otherlv_3= 'environment' ( (otherlv_4= RULE_ID ) )? otherlv_5= '{' otherlv_6= 'protocols' otherlv_7= '{' ( (lv_protocol_8_0= ruleBindingProtocol ) )+ otherlv_9= '}' (otherlv_10= 'provider-protocols' otherlv_11= '{' ( (lv_providerProtocol_12_0= ruleBindingProtocol ) )+ otherlv_13= '}' )? (otherlv_14= 'policies' otherlv_15= '{' ( (lv_policies_16_0= rulePolicy ) )* otherlv_17= '}' )? (otherlv_18= 'provider-policies' otherlv_19= '{' ( (lv_providerPolicies_20_0= rulePolicy ) )* otherlv_21= '}' )? (otherlv_22= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_24= ',' ( ( ruleQualifiedName ) ) )* )? ( (lv_operation_26_0= ruleOperationBinding ) )* otherlv_27= '}' ) ;
    public final EObject ruleServiceBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
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
        Token otherlv_27=null;
        EObject lv_service_1_0 = null;

        EObject lv_protocol_8_0 = null;

        EObject lv_providerProtocol_12_0 = null;

        EObject lv_policies_16_0 = null;

        EObject lv_providerPolicies_20_0 = null;

        EObject lv_operation_26_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:565:28: ( (otherlv_0= 'bind service' ( (lv_service_1_0= ruleServiceRef ) ) otherlv_2= 'to' otherlv_3= 'environment' ( (otherlv_4= RULE_ID ) )? otherlv_5= '{' otherlv_6= 'protocols' otherlv_7= '{' ( (lv_protocol_8_0= ruleBindingProtocol ) )+ otherlv_9= '}' (otherlv_10= 'provider-protocols' otherlv_11= '{' ( (lv_providerProtocol_12_0= ruleBindingProtocol ) )+ otherlv_13= '}' )? (otherlv_14= 'policies' otherlv_15= '{' ( (lv_policies_16_0= rulePolicy ) )* otherlv_17= '}' )? (otherlv_18= 'provider-policies' otherlv_19= '{' ( (lv_providerPolicies_20_0= rulePolicy ) )* otherlv_21= '}' )? (otherlv_22= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_24= ',' ( ( ruleQualifiedName ) ) )* )? ( (lv_operation_26_0= ruleOperationBinding ) )* otherlv_27= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:566:1: (otherlv_0= 'bind service' ( (lv_service_1_0= ruleServiceRef ) ) otherlv_2= 'to' otherlv_3= 'environment' ( (otherlv_4= RULE_ID ) )? otherlv_5= '{' otherlv_6= 'protocols' otherlv_7= '{' ( (lv_protocol_8_0= ruleBindingProtocol ) )+ otherlv_9= '}' (otherlv_10= 'provider-protocols' otherlv_11= '{' ( (lv_providerProtocol_12_0= ruleBindingProtocol ) )+ otherlv_13= '}' )? (otherlv_14= 'policies' otherlv_15= '{' ( (lv_policies_16_0= rulePolicy ) )* otherlv_17= '}' )? (otherlv_18= 'provider-policies' otherlv_19= '{' ( (lv_providerPolicies_20_0= rulePolicy ) )* otherlv_21= '}' )? (otherlv_22= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_24= ',' ( ( ruleQualifiedName ) ) )* )? ( (lv_operation_26_0= ruleOperationBinding ) )* otherlv_27= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:566:1: (otherlv_0= 'bind service' ( (lv_service_1_0= ruleServiceRef ) ) otherlv_2= 'to' otherlv_3= 'environment' ( (otherlv_4= RULE_ID ) )? otherlv_5= '{' otherlv_6= 'protocols' otherlv_7= '{' ( (lv_protocol_8_0= ruleBindingProtocol ) )+ otherlv_9= '}' (otherlv_10= 'provider-protocols' otherlv_11= '{' ( (lv_providerProtocol_12_0= ruleBindingProtocol ) )+ otherlv_13= '}' )? (otherlv_14= 'policies' otherlv_15= '{' ( (lv_policies_16_0= rulePolicy ) )* otherlv_17= '}' )? (otherlv_18= 'provider-policies' otherlv_19= '{' ( (lv_providerPolicies_20_0= rulePolicy ) )* otherlv_21= '}' )? (otherlv_22= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_24= ',' ( ( ruleQualifiedName ) ) )* )? ( (lv_operation_26_0= ruleOperationBinding ) )* otherlv_27= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:566:3: otherlv_0= 'bind service' ( (lv_service_1_0= ruleServiceRef ) ) otherlv_2= 'to' otherlv_3= 'environment' ( (otherlv_4= RULE_ID ) )? otherlv_5= '{' otherlv_6= 'protocols' otherlv_7= '{' ( (lv_protocol_8_0= ruleBindingProtocol ) )+ otherlv_9= '}' (otherlv_10= 'provider-protocols' otherlv_11= '{' ( (lv_providerProtocol_12_0= ruleBindingProtocol ) )+ otherlv_13= '}' )? (otherlv_14= 'policies' otherlv_15= '{' ( (lv_policies_16_0= rulePolicy ) )* otherlv_17= '}' )? (otherlv_18= 'provider-policies' otherlv_19= '{' ( (lv_providerPolicies_20_0= rulePolicy ) )* otherlv_21= '}' )? (otherlv_22= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_24= ',' ( ( ruleQualifiedName ) ) )* )? ( (lv_operation_26_0= ruleOperationBinding ) )* otherlv_27= '}'
            {
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleServiceBinding1158); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getServiceBindingAccess().getBindServiceKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:570:1: ( (lv_service_1_0= ruleServiceRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:571:1: (lv_service_1_0= ruleServiceRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:571:1: (lv_service_1_0= ruleServiceRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:572:3: lv_service_1_0= ruleServiceRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getServiceBindingAccess().getServiceServiceRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleServiceBinding1179);
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

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleServiceBinding1191); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getServiceBindingAccess().getToKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleServiceBinding1203); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getServiceBindingAccess().getEnvironmentKeyword_3());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:596:1: ( (otherlv_4= RULE_ID ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:597:1: (otherlv_4= RULE_ID )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:597:1: (otherlv_4= RULE_ID )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:598:3: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getServiceBindingRule());
                      	        }
                              
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleServiceBinding1227); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_4, grammarAccess.getServiceBindingAccess().getEnvironmentEnvironmentCrossReference_4_0()); 
                      	
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleServiceBinding1240); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_5());
                  
            }
            otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleServiceBinding1252); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getServiceBindingAccess().getProtocolsKeyword_6());
                  
            }
            otherlv_7=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleServiceBinding1264); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_7());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:624:1: ( (lv_protocol_8_0= ruleBindingProtocol ) )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==40||LA15_0==45||LA15_0==48||LA15_0==50||LA15_0==54||LA15_0==56||LA15_0==60||LA15_0==64||LA15_0==66) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:625:1: (lv_protocol_8_0= ruleBindingProtocol )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:625:1: (lv_protocol_8_0= ruleBindingProtocol )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:626:3: lv_protocol_8_0= ruleBindingProtocol
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getProtocolBindingProtocolParserRuleCall_8_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleServiceBinding1285);
            	    lv_protocol_8_0=ruleBindingProtocol();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getServiceBindingRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"protocol",
            	              		lv_protocol_8_0, 
            	              		"BindingProtocol");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);

            otherlv_9=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleServiceBinding1298); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getServiceBindingAccess().getRightCurlyBracketKeyword_9());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:646:1: (otherlv_10= 'provider-protocols' otherlv_11= '{' ( (lv_providerProtocol_12_0= ruleBindingProtocol ) )+ otherlv_13= '}' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==25) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:646:3: otherlv_10= 'provider-protocols' otherlv_11= '{' ( (lv_providerProtocol_12_0= ruleBindingProtocol ) )+ otherlv_13= '}'
                    {
                    otherlv_10=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleServiceBinding1311); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getServiceBindingAccess().getProviderProtocolsKeyword_10_0());
                          
                    }
                    otherlv_11=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleServiceBinding1323); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_10_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:654:1: ( (lv_providerProtocol_12_0= ruleBindingProtocol ) )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==40||LA16_0==45||LA16_0==48||LA16_0==50||LA16_0==54||LA16_0==56||LA16_0==60||LA16_0==64||LA16_0==66) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:655:1: (lv_providerProtocol_12_0= ruleBindingProtocol )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:655:1: (lv_providerProtocol_12_0= ruleBindingProtocol )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:656:3: lv_providerProtocol_12_0= ruleBindingProtocol
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getProviderProtocolBindingProtocolParserRuleCall_10_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleServiceBinding1344);
                    	    lv_providerProtocol_12_0=ruleBindingProtocol();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getServiceBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"providerProtocol",
                    	              		lv_providerProtocol_12_0, 
                    	              		"BindingProtocol");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);

                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleServiceBinding1357); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getServiceBindingAccess().getRightCurlyBracketKeyword_10_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:676:3: (otherlv_14= 'policies' otherlv_15= '{' ( (lv_policies_16_0= rulePolicy ) )* otherlv_17= '}' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==18) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:676:5: otherlv_14= 'policies' otherlv_15= '{' ( (lv_policies_16_0= rulePolicy ) )* otherlv_17= '}'
                    {
                    otherlv_14=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleServiceBinding1372); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getServiceBindingAccess().getPoliciesKeyword_11_0());
                          
                    }
                    otherlv_15=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleServiceBinding1384); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_11_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:684:1: ( (lv_policies_16_0= rulePolicy ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>=68 && LA18_0<=69)||(LA18_0>=74 && LA18_0<=76)) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:685:1: (lv_policies_16_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:685:1: (lv_policies_16_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:686:3: lv_policies_16_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getPoliciesPolicyParserRuleCall_11_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleServiceBinding1405);
                    	    lv_policies_16_0=rulePolicy();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getServiceBindingRule());
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
                    	    break loop18;
                        }
                    } while (true);

                    otherlv_17=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleServiceBinding1418); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getServiceBindingAccess().getRightCurlyBracketKeyword_11_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:706:3: (otherlv_18= 'provider-policies' otherlv_19= '{' ( (lv_providerPolicies_20_0= rulePolicy ) )* otherlv_21= '}' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==19) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:706:5: otherlv_18= 'provider-policies' otherlv_19= '{' ( (lv_providerPolicies_20_0= rulePolicy ) )* otherlv_21= '}'
                    {
                    otherlv_18=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleServiceBinding1433); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getServiceBindingAccess().getProviderPoliciesKeyword_12_0());
                          
                    }
                    otherlv_19=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleServiceBinding1445); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_12_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:714:1: ( (lv_providerPolicies_20_0= rulePolicy ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>=68 && LA20_0<=69)||(LA20_0>=74 && LA20_0<=76)) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:715:1: (lv_providerPolicies_20_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:715:1: (lv_providerPolicies_20_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:716:3: lv_providerPolicies_20_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getProviderPoliciesPolicyParserRuleCall_12_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleServiceBinding1466);
                    	    lv_providerPolicies_20_0=rulePolicy();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getServiceBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"providerPolicies",
                    	              		lv_providerPolicies_20_0, 
                    	              		"Policy");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    otherlv_21=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleServiceBinding1479); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_21, grammarAccess.getServiceBindingAccess().getRightCurlyBracketKeyword_12_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:736:3: (otherlv_22= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_24= ',' ( ( ruleQualifiedName ) ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==20) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:736:5: otherlv_22= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_24= ',' ( ( ruleQualifiedName ) ) )*
                    {
                    otherlv_22=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleServiceBinding1494); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_22, grammarAccess.getServiceBindingAccess().getSLAsKeyword_13_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:740:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:741:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:741:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:742:3: ruleQualifiedName
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
                       
                      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getSlaSLACrossReference_13_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleServiceBinding1521);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:758:2: (otherlv_24= ',' ( ( ruleQualifiedName ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==21) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:758:4: otherlv_24= ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_24=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleServiceBinding1534); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_24, grammarAccess.getServiceBindingAccess().getCommaKeyword_13_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:762:1: ( ( ruleQualifiedName ) )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:763:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:763:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:764:3: ruleQualifiedName
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
                    	       
                    	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getSlaSLACrossReference_13_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleServiceBinding1561);
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
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:780:6: ( (lv_operation_26_0= ruleOperationBinding ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==26) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:781:1: (lv_operation_26_0= ruleOperationBinding )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:781:1: (lv_operation_26_0= ruleOperationBinding )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:782:3: lv_operation_26_0= ruleOperationBinding
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getServiceBindingAccess().getOperationOperationBindingParserRuleCall_14_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleOperationBinding_in_ruleServiceBinding1586);
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
            	    break loop24;
                }
            } while (true);

            otherlv_27=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleServiceBinding1599); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:810:1: entryRuleServiceRef returns [EObject current=null] : iv_ruleServiceRef= ruleServiceRef EOF ;
    public final EObject entryRuleServiceRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:811:2: (iv_ruleServiceRef= ruleServiceRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:812:2: iv_ruleServiceRef= ruleServiceRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getServiceRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_entryRuleServiceRef1635);
            iv_ruleServiceRef=ruleServiceRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleServiceRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleServiceRef1645); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:819:1: ruleServiceRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) ;
    public final EObject ruleServiceRef() throws RecognitionException {
        EObject current = null;

        EObject lv_versionRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:822:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:823:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:823:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:823:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:823:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:824:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:824:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:825:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleServiceRef1697);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:841:2: ( (lv_versionRef_1_0= ruleVersionRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:842:1: (lv_versionRef_1_0= ruleVersionRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:842:1: (lv_versionRef_1_0= ruleVersionRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:843:3: lv_versionRef_1_0= ruleVersionRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getServiceRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleServiceRef1718);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:867:1: entryRuleBindingProtocol returns [EObject current=null] : iv_ruleBindingProtocol= ruleBindingProtocol EOF ;
    public final EObject entryRuleBindingProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBindingProtocol = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:868:2: (iv_ruleBindingProtocol= ruleBindingProtocol EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:869:2: iv_ruleBindingProtocol= ruleBindingProtocol EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBindingProtocolRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_entryRuleBindingProtocol1754);
            iv_ruleBindingProtocol=ruleBindingProtocol();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBindingProtocol; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBindingProtocol1764); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:876:1: ruleBindingProtocol returns [EObject current=null] : (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP ) ;
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


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:879:28: ( (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:880:1: (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:880:1: (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP )
            int alt25=9;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt25=1;
                }
                break;
            case 40:
                {
                alt25=2;
                }
                break;
            case 48:
                {
                alt25=3;
                }
                break;
            case 50:
                {
                alt25=4;
                }
                break;
            case 54:
                {
                alt25=5;
                }
                break;
            case 45:
                {
                alt25=6;
                }
                break;
            case 56:
                {
                alt25=7;
                }
                break;
            case 64:
                {
                alt25=8;
                }
                break;
            case 66:
                {
                alt25=9;
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:881:2: this_SCA_0= ruleSCA
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getSCAParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSCA_in_ruleBindingProtocol1814);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:894:2: this_SOAP_1= ruleSOAP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getSOAPParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSOAP_in_ruleBindingProtocol1844);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:907:2: this_EJB_2= ruleEJB
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getEJBParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEJB_in_ruleBindingProtocol1874);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:920:2: this_HTTP_3= ruleHTTP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getHTTPParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleHTTP_in_ruleBindingProtocol1904);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:933:2: this_REST_4= ruleREST
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getRESTParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleREST_in_ruleBindingProtocol1934);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:946:2: this_SAP_5= ruleSAP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getSAPParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSAP_in_ruleBindingProtocol1964);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:959:2: this_JMS_6= ruleJMS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getJMSParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleJMS_in_ruleBindingProtocol1994);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:972:2: this_FILE_7= ruleFILE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getFILEParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFILE_in_ruleBindingProtocol2024);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:985:2: this_FTP_8= ruleFTP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBindingProtocolAccess().getFTPParserRuleCall_8()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFTP_in_ruleBindingProtocol2054);
                    this_FTP_8=ruleFTP();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FTP_8; 
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1004:1: entryRuleOperationBinding returns [EObject current=null] : iv_ruleOperationBinding= ruleOperationBinding EOF ;
    public final EObject entryRuleOperationBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationBinding = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1005:2: (iv_ruleOperationBinding= ruleOperationBinding EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1006:2: iv_ruleOperationBinding= ruleOperationBinding EOF
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1013:1: ruleOperationBinding returns [EObject current=null] : (otherlv_0= 'bind op' ( ( ruleQualifiedName ) ) otherlv_2= '{' otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocol_5_0= ruleBindingProtocol ) )+ otherlv_6= '}' (otherlv_7= 'provider-protocols' otherlv_8= '{' ( (lv_providerProtocol_9_0= ruleBindingProtocol ) )+ otherlv_10= '}' )? (otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}' )? (otherlv_15= 'provider-policies' otherlv_16= '{' ( (lv_providerPolicies_17_0= rulePolicy ) )* otherlv_18= '}' )? (otherlv_19= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_21= ',' ( ( ruleQualifiedName ) ) )* )? otherlv_23= '}' ) ;
    public final EObject ruleOperationBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
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
        Token otherlv_21=null;
        Token otherlv_23=null;
        EObject lv_protocol_5_0 = null;

        EObject lv_providerProtocol_9_0 = null;

        EObject lv_policies_13_0 = null;

        EObject lv_providerPolicies_17_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1016:28: ( (otherlv_0= 'bind op' ( ( ruleQualifiedName ) ) otherlv_2= '{' otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocol_5_0= ruleBindingProtocol ) )+ otherlv_6= '}' (otherlv_7= 'provider-protocols' otherlv_8= '{' ( (lv_providerProtocol_9_0= ruleBindingProtocol ) )+ otherlv_10= '}' )? (otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}' )? (otherlv_15= 'provider-policies' otherlv_16= '{' ( (lv_providerPolicies_17_0= rulePolicy ) )* otherlv_18= '}' )? (otherlv_19= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_21= ',' ( ( ruleQualifiedName ) ) )* )? otherlv_23= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1017:1: (otherlv_0= 'bind op' ( ( ruleQualifiedName ) ) otherlv_2= '{' otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocol_5_0= ruleBindingProtocol ) )+ otherlv_6= '}' (otherlv_7= 'provider-protocols' otherlv_8= '{' ( (lv_providerProtocol_9_0= ruleBindingProtocol ) )+ otherlv_10= '}' )? (otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}' )? (otherlv_15= 'provider-policies' otherlv_16= '{' ( (lv_providerPolicies_17_0= rulePolicy ) )* otherlv_18= '}' )? (otherlv_19= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_21= ',' ( ( ruleQualifiedName ) ) )* )? otherlv_23= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1017:1: (otherlv_0= 'bind op' ( ( ruleQualifiedName ) ) otherlv_2= '{' otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocol_5_0= ruleBindingProtocol ) )+ otherlv_6= '}' (otherlv_7= 'provider-protocols' otherlv_8= '{' ( (lv_providerProtocol_9_0= ruleBindingProtocol ) )+ otherlv_10= '}' )? (otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}' )? (otherlv_15= 'provider-policies' otherlv_16= '{' ( (lv_providerPolicies_17_0= rulePolicy ) )* otherlv_18= '}' )? (otherlv_19= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_21= ',' ( ( ruleQualifiedName ) ) )* )? otherlv_23= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1017:3: otherlv_0= 'bind op' ( ( ruleQualifiedName ) ) otherlv_2= '{' otherlv_3= 'protocols' otherlv_4= '{' ( (lv_protocol_5_0= ruleBindingProtocol ) )+ otherlv_6= '}' (otherlv_7= 'provider-protocols' otherlv_8= '{' ( (lv_providerProtocol_9_0= ruleBindingProtocol ) )+ otherlv_10= '}' )? (otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}' )? (otherlv_15= 'provider-policies' otherlv_16= '{' ( (lv_providerPolicies_17_0= rulePolicy ) )* otherlv_18= '}' )? (otherlv_19= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_21= ',' ( ( ruleQualifiedName ) ) )* )? otherlv_23= '}'
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleOperationBinding2136); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getOperationBindingAccess().getBindOpKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1021:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1022:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1022:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1023:3: ruleQualifiedName
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

            otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOperationBinding2175); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleOperationBinding2187); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getOperationBindingAccess().getProtocolsKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOperationBinding2199); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1051:1: ( (lv_protocol_5_0= ruleBindingProtocol ) )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==40||LA26_0==45||LA26_0==48||LA26_0==50||LA26_0==54||LA26_0==56||LA26_0==60||LA26_0==64||LA26_0==66) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1052:1: (lv_protocol_5_0= ruleBindingProtocol )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1052:1: (lv_protocol_5_0= ruleBindingProtocol )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1053:3: lv_protocol_5_0= ruleBindingProtocol
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getProtocolBindingProtocolParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleOperationBinding2220);
            	    lv_protocol_5_0=ruleBindingProtocol();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getOperationBindingRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"protocol",
            	              		lv_protocol_5_0, 
            	              		"BindingProtocol");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);

            otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleOperationBinding2233); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1073:1: (otherlv_7= 'provider-protocols' otherlv_8= '{' ( (lv_providerProtocol_9_0= ruleBindingProtocol ) )+ otherlv_10= '}' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==25) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1073:3: otherlv_7= 'provider-protocols' otherlv_8= '{' ( (lv_providerProtocol_9_0= ruleBindingProtocol ) )+ otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleOperationBinding2246); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getOperationBindingAccess().getProviderProtocolsKeyword_7_0());
                          
                    }
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOperationBinding2258); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_7_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1081:1: ( (lv_providerProtocol_9_0= ruleBindingProtocol ) )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==40||LA27_0==45||LA27_0==48||LA27_0==50||LA27_0==54||LA27_0==56||LA27_0==60||LA27_0==64||LA27_0==66) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1082:1: (lv_providerProtocol_9_0= ruleBindingProtocol )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1082:1: (lv_providerProtocol_9_0= ruleBindingProtocol )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1083:3: lv_providerProtocol_9_0= ruleBindingProtocol
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getProviderProtocolBindingProtocolParserRuleCall_7_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleOperationBinding2279);
                    	    lv_providerProtocol_9_0=ruleBindingProtocol();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getOperationBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"providerProtocol",
                    	              		lv_providerProtocol_9_0, 
                    	              		"BindingProtocol");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt27 >= 1 ) break loop27;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
                    } while (true);

                    otherlv_10=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleOperationBinding2292); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_7_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1103:3: (otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==18) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1103:5: otherlv_11= 'policies' otherlv_12= '{' ( (lv_policies_13_0= rulePolicy ) )* otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleOperationBinding2307); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getOperationBindingAccess().getPoliciesKeyword_8_0());
                          
                    }
                    otherlv_12=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOperationBinding2319); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_8_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1111:1: ( (lv_policies_13_0= rulePolicy ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( ((LA29_0>=68 && LA29_0<=69)||(LA29_0>=74 && LA29_0<=76)) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1112:1: (lv_policies_13_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1112:1: (lv_policies_13_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1113:3: lv_policies_13_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getPoliciesPolicyParserRuleCall_8_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleOperationBinding2340);
                    	    lv_policies_13_0=rulePolicy();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getOperationBindingRule());
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
                    	    break loop29;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleOperationBinding2353); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_8_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1133:3: (otherlv_15= 'provider-policies' otherlv_16= '{' ( (lv_providerPolicies_17_0= rulePolicy ) )* otherlv_18= '}' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==19) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1133:5: otherlv_15= 'provider-policies' otherlv_16= '{' ( (lv_providerPolicies_17_0= rulePolicy ) )* otherlv_18= '}'
                    {
                    otherlv_15=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleOperationBinding2368); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getOperationBindingAccess().getProviderPoliciesKeyword_9_0());
                          
                    }
                    otherlv_16=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOperationBinding2380); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_9_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1141:1: ( (lv_providerPolicies_17_0= rulePolicy ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( ((LA31_0>=68 && LA31_0<=69)||(LA31_0>=74 && LA31_0<=76)) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1142:1: (lv_providerPolicies_17_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1142:1: (lv_providerPolicies_17_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1143:3: lv_providerPolicies_17_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getProviderPoliciesPolicyParserRuleCall_9_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleOperationBinding2401);
                    	    lv_providerPolicies_17_0=rulePolicy();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getOperationBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"providerPolicies",
                    	              		lv_providerPolicies_17_0, 
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

                    otherlv_18=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleOperationBinding2414); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_9_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1163:3: (otherlv_19= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_21= ',' ( ( ruleQualifiedName ) ) )* )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==20) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1163:5: otherlv_19= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_21= ',' ( ( ruleQualifiedName ) ) )*
                    {
                    otherlv_19=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleOperationBinding2429); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getOperationBindingAccess().getSLAsKeyword_10_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1167:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1168:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1168:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1169:3: ruleQualifiedName
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
                       
                      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getSlaSLACrossReference_10_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleOperationBinding2456);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1185:2: (otherlv_21= ',' ( ( ruleQualifiedName ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==21) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1185:4: otherlv_21= ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_21=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleOperationBinding2469); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_21, grammarAccess.getOperationBindingAccess().getCommaKeyword_10_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1189:1: ( ( ruleQualifiedName ) )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1190:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1190:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1191:3: ruleQualifiedName
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
                    	       
                    	      	        newCompositeNode(grammarAccess.getOperationBindingAccess().getSlaSLACrossReference_10_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleOperationBinding2496);
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
                    	    break loop33;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_23=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleOperationBinding2512); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_23, grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_11());
                  
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


    // $ANTLR start "entryRuleModuleBinding"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1219:1: entryRuleModuleBinding returns [EObject current=null] : iv_ruleModuleBinding= ruleModuleBinding EOF ;
    public final EObject entryRuleModuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModuleBinding = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1220:2: (iv_ruleModuleBinding= ruleModuleBinding EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1221:2: iv_ruleModuleBinding= ruleModuleBinding EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModuleBindingRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModuleBinding_in_entryRuleModuleBinding2548);
            iv_ruleModuleBinding=ruleModuleBinding();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModuleBinding; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModuleBinding2558); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1228:1: ruleModuleBinding returns [EObject current=null] : (otherlv_0= 'bind-module' ( (lv_module_1_0= ruleModuleRef ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ( (lv_provider_8_0= ruleProvider ) ) (otherlv_9= 'default-protocols' otherlv_10= '{' ( (lv_protocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )? (otherlv_13= 'default-policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )? (otherlv_17= 'default-SLAs' ( ( ruleQualifiedName ) ) (otherlv_19= ',' ( ( ruleQualifiedName ) ) )* )? ( (lv_protocolSpecs_21_0= ruleServiceProtocolSpec ) )* ( (lv_policySpecs_22_0= ruleServicePolicySpec ) )* ( (lv_slaSpecs_23_0= ruleServiceSLASpec ) )* otherlv_24= '}' ) ;
    public final EObject ruleModuleBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_24=null;
        EObject lv_module_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_provider_8_0 = null;

        EObject lv_protocol_11_0 = null;

        EObject lv_policies_15_0 = null;

        EObject lv_protocolSpecs_21_0 = null;

        EObject lv_policySpecs_22_0 = null;

        EObject lv_slaSpecs_23_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1231:28: ( (otherlv_0= 'bind-module' ( (lv_module_1_0= ruleModuleRef ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ( (lv_provider_8_0= ruleProvider ) ) (otherlv_9= 'default-protocols' otherlv_10= '{' ( (lv_protocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )? (otherlv_13= 'default-policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )? (otherlv_17= 'default-SLAs' ( ( ruleQualifiedName ) ) (otherlv_19= ',' ( ( ruleQualifiedName ) ) )* )? ( (lv_protocolSpecs_21_0= ruleServiceProtocolSpec ) )* ( (lv_policySpecs_22_0= ruleServicePolicySpec ) )* ( (lv_slaSpecs_23_0= ruleServiceSLASpec ) )* otherlv_24= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1232:1: (otherlv_0= 'bind-module' ( (lv_module_1_0= ruleModuleRef ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ( (lv_provider_8_0= ruleProvider ) ) (otherlv_9= 'default-protocols' otherlv_10= '{' ( (lv_protocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )? (otherlv_13= 'default-policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )? (otherlv_17= 'default-SLAs' ( ( ruleQualifiedName ) ) (otherlv_19= ',' ( ( ruleQualifiedName ) ) )* )? ( (lv_protocolSpecs_21_0= ruleServiceProtocolSpec ) )* ( (lv_policySpecs_22_0= ruleServicePolicySpec ) )* ( (lv_slaSpecs_23_0= ruleServiceSLASpec ) )* otherlv_24= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1232:1: (otherlv_0= 'bind-module' ( (lv_module_1_0= ruleModuleRef ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ( (lv_provider_8_0= ruleProvider ) ) (otherlv_9= 'default-protocols' otherlv_10= '{' ( (lv_protocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )? (otherlv_13= 'default-policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )? (otherlv_17= 'default-SLAs' ( ( ruleQualifiedName ) ) (otherlv_19= ',' ( ( ruleQualifiedName ) ) )* )? ( (lv_protocolSpecs_21_0= ruleServiceProtocolSpec ) )* ( (lv_policySpecs_22_0= ruleServicePolicySpec ) )* ( (lv_slaSpecs_23_0= ruleServiceSLASpec ) )* otherlv_24= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1232:3: otherlv_0= 'bind-module' ( (lv_module_1_0= ruleModuleRef ) ) otherlv_2= 'as' ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'to' otherlv_5= 'environment' ( ( ruleQualifiedName ) ) otherlv_7= '{' ( (lv_provider_8_0= ruleProvider ) ) (otherlv_9= 'default-protocols' otherlv_10= '{' ( (lv_protocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )? (otherlv_13= 'default-policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )? (otherlv_17= 'default-SLAs' ( ( ruleQualifiedName ) ) (otherlv_19= ',' ( ( ruleQualifiedName ) ) )* )? ( (lv_protocolSpecs_21_0= ruleServiceProtocolSpec ) )* ( (lv_policySpecs_22_0= ruleServicePolicySpec ) )* ( (lv_slaSpecs_23_0= ruleServiceSLASpec ) )* otherlv_24= '}'
            {
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleModuleBinding2595); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getModuleBindingAccess().getBindModuleKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1236:1: ( (lv_module_1_0= ruleModuleRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1237:1: (lv_module_1_0= ruleModuleRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1237:1: (lv_module_1_0= ruleModuleRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1238:3: lv_module_1_0= ruleModuleRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModuleBindingAccess().getModuleModuleRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleModuleRef_in_ruleModuleBinding2616);
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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModuleBinding2628); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getModuleBindingAccess().getAsKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1258:1: ( (lv_name_3_0= ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1259:1: (lv_name_3_0= ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1259:1: (lv_name_3_0= ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1260:3: lv_name_3_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModuleBindingAccess().getNameQualifiedNameParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModuleBinding2649);
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

            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModuleBinding2661); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getModuleBindingAccess().getToKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModuleBinding2673); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getModuleBindingAccess().getEnvironmentKeyword_5());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1284:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1285:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1285:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1286:3: ruleQualifiedName
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
               
              	        newCompositeNode(grammarAccess.getModuleBindingAccess().getEnvironmentEnvironmentCrossReference_6_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModuleBinding2700);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModuleBinding2712); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getModuleBindingAccess().getLeftCurlyBracketKeyword_7());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1306:1: ( (lv_provider_8_0= ruleProvider ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1307:1: (lv_provider_8_0= ruleProvider )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1307:1: (lv_provider_8_0= ruleProvider )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1308:3: lv_provider_8_0= ruleProvider
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModuleBindingAccess().getProviderProviderParserRuleCall_8_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleProvider_in_ruleModuleBinding2733);
            lv_provider_8_0=ruleProvider();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getModuleBindingRule());
              	        }
                     		set(
                     			current, 
                     			"provider",
                      		lv_provider_8_0, 
                      		"Provider");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1324:2: (otherlv_9= 'default-protocols' otherlv_10= '{' ( (lv_protocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==28) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1324:4: otherlv_9= 'default-protocols' otherlv_10= '{' ( (lv_protocol_11_0= ruleBindingProtocol ) )+ otherlv_12= '}'
                    {
                    otherlv_9=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleModuleBinding2746); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getModuleBindingAccess().getDefaultProtocolsKeyword_9_0());
                          
                    }
                    otherlv_10=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModuleBinding2758); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getModuleBindingAccess().getLeftCurlyBracketKeyword_9_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1332:1: ( (lv_protocol_11_0= ruleBindingProtocol ) )+
                    int cnt35=0;
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==40||LA35_0==45||LA35_0==48||LA35_0==50||LA35_0==54||LA35_0==56||LA35_0==60||LA35_0==64||LA35_0==66) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1333:1: (lv_protocol_11_0= ruleBindingProtocol )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1333:1: (lv_protocol_11_0= ruleBindingProtocol )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1334:3: lv_protocol_11_0= ruleBindingProtocol
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getProtocolBindingProtocolParserRuleCall_9_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleModuleBinding2779);
                    	    lv_protocol_11_0=ruleBindingProtocol();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getModuleBindingRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"protocol",
                    	              		lv_protocol_11_0, 
                    	              		"BindingProtocol");
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

                    otherlv_12=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModuleBinding2792); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getModuleBindingAccess().getRightCurlyBracketKeyword_9_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1354:3: (otherlv_13= 'default-policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==29) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1354:5: otherlv_13= 'default-policies' otherlv_14= '{' ( (lv_policies_15_0= rulePolicy ) )* otherlv_16= '}'
                    {
                    otherlv_13=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleModuleBinding2807); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getModuleBindingAccess().getDefaultPoliciesKeyword_10_0());
                          
                    }
                    otherlv_14=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModuleBinding2819); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getModuleBindingAccess().getLeftCurlyBracketKeyword_10_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1362:1: ( (lv_policies_15_0= rulePolicy ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( ((LA37_0>=68 && LA37_0<=69)||(LA37_0>=74 && LA37_0<=76)) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1363:1: (lv_policies_15_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1363:1: (lv_policies_15_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1364:3: lv_policies_15_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getPoliciesPolicyParserRuleCall_10_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleModuleBinding2840);
                    	    lv_policies_15_0=rulePolicy();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getModuleBindingRule());
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
                    	    break loop37;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModuleBinding2853); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getModuleBindingAccess().getRightCurlyBracketKeyword_10_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1384:3: (otherlv_17= 'default-SLAs' ( ( ruleQualifiedName ) ) (otherlv_19= ',' ( ( ruleQualifiedName ) ) )* )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==30) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1384:5: otherlv_17= 'default-SLAs' ( ( ruleQualifiedName ) ) (otherlv_19= ',' ( ( ruleQualifiedName ) ) )*
                    {
                    otherlv_17=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleModuleBinding2868); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getModuleBindingAccess().getDefaultSLAsKeyword_11_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1388:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1389:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1389:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1390:3: ruleQualifiedName
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
                       
                      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getSlaSLACrossReference_11_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModuleBinding2895);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1406:2: (otherlv_19= ',' ( ( ruleQualifiedName ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==21) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1406:4: otherlv_19= ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_19=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleModuleBinding2908); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_19, grammarAccess.getModuleBindingAccess().getCommaKeyword_11_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1410:1: ( ( ruleQualifiedName ) )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1411:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1411:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1412:3: ruleQualifiedName
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
                    	       
                    	      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getSlaSLACrossReference_11_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModuleBinding2935);
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
                    	    break loop39;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1428:6: ( (lv_protocolSpecs_21_0= ruleServiceProtocolSpec ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==16) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1429:1: (lv_protocolSpecs_21_0= ruleServiceProtocolSpec )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1429:1: (lv_protocolSpecs_21_0= ruleServiceProtocolSpec )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1430:3: lv_protocolSpecs_21_0= ruleServiceProtocolSpec
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getProtocolSpecsServiceProtocolSpecParserRuleCall_12_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceProtocolSpec_in_ruleModuleBinding2960);
            	    lv_protocolSpecs_21_0=ruleServiceProtocolSpec();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModuleBindingRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"protocolSpecs",
            	              		lv_protocolSpecs_21_0, 
            	              		"ServiceProtocolSpec");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1446:3: ( (lv_policySpecs_22_0= ruleServicePolicySpec ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==18) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1447:1: (lv_policySpecs_22_0= ruleServicePolicySpec )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1447:1: (lv_policySpecs_22_0= ruleServicePolicySpec )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1448:3: lv_policySpecs_22_0= ruleServicePolicySpec
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getPolicySpecsServicePolicySpecParserRuleCall_13_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServicePolicySpec_in_ruleModuleBinding2982);
            	    lv_policySpecs_22_0=ruleServicePolicySpec();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModuleBindingRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"policySpecs",
            	              		lv_policySpecs_22_0, 
            	              		"ServicePolicySpec");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1464:3: ( (lv_slaSpecs_23_0= ruleServiceSLASpec ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==20) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1465:1: (lv_slaSpecs_23_0= ruleServiceSLASpec )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1465:1: (lv_slaSpecs_23_0= ruleServiceSLASpec )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1466:3: lv_slaSpecs_23_0= ruleServiceSLASpec
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleBindingAccess().getSlaSpecsServiceSLASpecParserRuleCall_14_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceSLASpec_in_ruleModuleBinding3004);
            	    lv_slaSpecs_23_0=ruleServiceSLASpec();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModuleBindingRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"slaSpecs",
            	              		lv_slaSpecs_23_0, 
            	              		"ServiceSLASpec");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            otherlv_24=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModuleBinding3017); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_24, grammarAccess.getModuleBindingAccess().getRightCurlyBracketKeyword_15());
                  
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1494:1: entryRuleModuleRef returns [EObject current=null] : iv_ruleModuleRef= ruleModuleRef EOF ;
    public final EObject entryRuleModuleRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModuleRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1495:2: (iv_ruleModuleRef= ruleModuleRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1496:2: iv_ruleModuleRef= ruleModuleRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModuleRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModuleRef_in_entryRuleModuleRef3053);
            iv_ruleModuleRef=ruleModuleRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModuleRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModuleRef3063); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1503:1: ruleModuleRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) ;
    public final EObject ruleModuleRef() throws RecognitionException {
        EObject current = null;

        EObject lv_versionRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1506:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1507:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1507:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1507:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1507:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1508:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1508:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1509:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModuleRef3115);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1525:2: ( (lv_versionRef_1_0= ruleVersionRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1526:1: (lv_versionRef_1_0= ruleVersionRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1526:1: (lv_versionRef_1_0= ruleVersionRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1527:3: lv_versionRef_1_0= ruleVersionRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModuleRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleModuleRef3136);
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


    // $ANTLR start "entryRuleServiceProtocolSpec"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1551:1: entryRuleServiceProtocolSpec returns [EObject current=null] : iv_ruleServiceProtocolSpec= ruleServiceProtocolSpec EOF ;
    public final EObject entryRuleServiceProtocolSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceProtocolSpec = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1552:2: (iv_ruleServiceProtocolSpec= ruleServiceProtocolSpec EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1553:2: iv_ruleServiceProtocolSpec= ruleServiceProtocolSpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getServiceProtocolSpecRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceProtocolSpec_in_entryRuleServiceProtocolSpec3172);
            iv_ruleServiceProtocolSpec=ruleServiceProtocolSpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleServiceProtocolSpec; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleServiceProtocolSpec3182); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceProtocolSpec"


    // $ANTLR start "ruleServiceProtocolSpec"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1560:1: ruleServiceProtocolSpec returns [EObject current=null] : (otherlv_0= 'protocols' otherlv_1= 'for' otherlv_2= 'service' ( (lv_service_3_0= ruleServiceRef ) ) otherlv_4= '{' ( (lv_protocol_5_0= ruleBindingProtocol ) )+ otherlv_6= '}' ) ;
    public final EObject ruleServiceProtocolSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_service_3_0 = null;

        EObject lv_protocol_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1563:28: ( (otherlv_0= 'protocols' otherlv_1= 'for' otherlv_2= 'service' ( (lv_service_3_0= ruleServiceRef ) ) otherlv_4= '{' ( (lv_protocol_5_0= ruleBindingProtocol ) )+ otherlv_6= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1564:1: (otherlv_0= 'protocols' otherlv_1= 'for' otherlv_2= 'service' ( (lv_service_3_0= ruleServiceRef ) ) otherlv_4= '{' ( (lv_protocol_5_0= ruleBindingProtocol ) )+ otherlv_6= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1564:1: (otherlv_0= 'protocols' otherlv_1= 'for' otherlv_2= 'service' ( (lv_service_3_0= ruleServiceRef ) ) otherlv_4= '{' ( (lv_protocol_5_0= ruleBindingProtocol ) )+ otherlv_6= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1564:3: otherlv_0= 'protocols' otherlv_1= 'for' otherlv_2= 'service' ( (lv_service_3_0= ruleServiceRef ) ) otherlv_4= '{' ( (lv_protocol_5_0= ruleBindingProtocol ) )+ otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleServiceProtocolSpec3219); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getServiceProtocolSpecAccess().getProtocolsKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleServiceProtocolSpec3231); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getServiceProtocolSpecAccess().getForKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleServiceProtocolSpec3243); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getServiceProtocolSpecAccess().getServiceKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1576:1: ( (lv_service_3_0= ruleServiceRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1577:1: (lv_service_3_0= ruleServiceRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1577:1: (lv_service_3_0= ruleServiceRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1578:3: lv_service_3_0= ruleServiceRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getServiceProtocolSpecAccess().getServiceServiceRefParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleServiceProtocolSpec3264);
            lv_service_3_0=ruleServiceRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getServiceProtocolSpecRule());
              	        }
                     		set(
                     			current, 
                     			"service",
                      		lv_service_3_0, 
                      		"ServiceRef");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleServiceProtocolSpec3276); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getServiceProtocolSpecAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1598:1: ( (lv_protocol_5_0= ruleBindingProtocol ) )+
            int cnt44=0;
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==40||LA44_0==45||LA44_0==48||LA44_0==50||LA44_0==54||LA44_0==56||LA44_0==60||LA44_0==64||LA44_0==66) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1599:1: (lv_protocol_5_0= ruleBindingProtocol )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1599:1: (lv_protocol_5_0= ruleBindingProtocol )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1600:3: lv_protocol_5_0= ruleBindingProtocol
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getServiceProtocolSpecAccess().getProtocolBindingProtocolParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleServiceProtocolSpec3297);
            	    lv_protocol_5_0=ruleBindingProtocol();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getServiceProtocolSpecRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"protocol",
            	              		lv_protocol_5_0, 
            	              		"BindingProtocol");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt44 >= 1 ) break loop44;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(44, input);
                        throw eee;
                }
                cnt44++;
            } while (true);

            otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleServiceProtocolSpec3310); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getServiceProtocolSpecAccess().getRightCurlyBracketKeyword_6());
                  
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
    // $ANTLR end "ruleServiceProtocolSpec"


    // $ANTLR start "entryRuleServicePolicySpec"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1628:1: entryRuleServicePolicySpec returns [EObject current=null] : iv_ruleServicePolicySpec= ruleServicePolicySpec EOF ;
    public final EObject entryRuleServicePolicySpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServicePolicySpec = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1629:2: (iv_ruleServicePolicySpec= ruleServicePolicySpec EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1630:2: iv_ruleServicePolicySpec= ruleServicePolicySpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getServicePolicySpecRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleServicePolicySpec_in_entryRuleServicePolicySpec3346);
            iv_ruleServicePolicySpec=ruleServicePolicySpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleServicePolicySpec; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleServicePolicySpec3356); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServicePolicySpec"


    // $ANTLR start "ruleServicePolicySpec"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1637:1: ruleServicePolicySpec returns [EObject current=null] : (otherlv_0= 'policies' otherlv_1= 'for' otherlv_2= 'service' ( (lv_service_3_0= ruleServiceRef ) ) otherlv_4= '{' ( (lv_policies_5_0= rulePolicy ) )+ otherlv_6= '}' ) ;
    public final EObject ruleServicePolicySpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_service_3_0 = null;

        EObject lv_policies_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1640:28: ( (otherlv_0= 'policies' otherlv_1= 'for' otherlv_2= 'service' ( (lv_service_3_0= ruleServiceRef ) ) otherlv_4= '{' ( (lv_policies_5_0= rulePolicy ) )+ otherlv_6= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1641:1: (otherlv_0= 'policies' otherlv_1= 'for' otherlv_2= 'service' ( (lv_service_3_0= ruleServiceRef ) ) otherlv_4= '{' ( (lv_policies_5_0= rulePolicy ) )+ otherlv_6= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1641:1: (otherlv_0= 'policies' otherlv_1= 'for' otherlv_2= 'service' ( (lv_service_3_0= ruleServiceRef ) ) otherlv_4= '{' ( (lv_policies_5_0= rulePolicy ) )+ otherlv_6= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1641:3: otherlv_0= 'policies' otherlv_1= 'for' otherlv_2= 'service' ( (lv_service_3_0= ruleServiceRef ) ) otherlv_4= '{' ( (lv_policies_5_0= rulePolicy ) )+ otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleServicePolicySpec3393); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getServicePolicySpecAccess().getPoliciesKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleServicePolicySpec3405); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getServicePolicySpecAccess().getForKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleServicePolicySpec3417); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getServicePolicySpecAccess().getServiceKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1653:1: ( (lv_service_3_0= ruleServiceRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1654:1: (lv_service_3_0= ruleServiceRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1654:1: (lv_service_3_0= ruleServiceRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1655:3: lv_service_3_0= ruleServiceRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getServicePolicySpecAccess().getServiceServiceRefParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleServicePolicySpec3438);
            lv_service_3_0=ruleServiceRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getServicePolicySpecRule());
              	        }
                     		set(
                     			current, 
                     			"service",
                      		lv_service_3_0, 
                      		"ServiceRef");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleServicePolicySpec3450); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getServicePolicySpecAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1675:1: ( (lv_policies_5_0= rulePolicy ) )+
            int cnt45=0;
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( ((LA45_0>=68 && LA45_0<=69)||(LA45_0>=74 && LA45_0<=76)) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1676:1: (lv_policies_5_0= rulePolicy )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1676:1: (lv_policies_5_0= rulePolicy )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1677:3: lv_policies_5_0= rulePolicy
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getServicePolicySpecAccess().getPoliciesPolicyParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleServicePolicySpec3471);
            	    lv_policies_5_0=rulePolicy();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getServicePolicySpecRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"policies",
            	              		lv_policies_5_0, 
            	              		"Policy");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt45 >= 1 ) break loop45;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(45, input);
                        throw eee;
                }
                cnt45++;
            } while (true);

            otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleServicePolicySpec3484); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getServicePolicySpecAccess().getRightCurlyBracketKeyword_6());
                  
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
    // $ANTLR end "ruleServicePolicySpec"


    // $ANTLR start "entryRuleServiceSLASpec"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1705:1: entryRuleServiceSLASpec returns [EObject current=null] : iv_ruleServiceSLASpec= ruleServiceSLASpec EOF ;
    public final EObject entryRuleServiceSLASpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceSLASpec = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1706:2: (iv_ruleServiceSLASpec= ruleServiceSLASpec EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1707:2: iv_ruleServiceSLASpec= ruleServiceSLASpec EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getServiceSLASpecRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceSLASpec_in_entryRuleServiceSLASpec3520);
            iv_ruleServiceSLASpec=ruleServiceSLASpec();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleServiceSLASpec; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleServiceSLASpec3530); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceSLASpec"


    // $ANTLR start "ruleServiceSLASpec"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1714:1: ruleServiceSLASpec returns [EObject current=null] : (otherlv_0= 'SLAs' otherlv_1= 'for' otherlv_2= 'service' ( (lv_service_3_0= ruleServiceRef ) ) ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( ( ruleQualifiedName ) ) )* ) ;
    public final EObject ruleServiceSLASpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_service_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1717:28: ( (otherlv_0= 'SLAs' otherlv_1= 'for' otherlv_2= 'service' ( (lv_service_3_0= ruleServiceRef ) ) ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( ( ruleQualifiedName ) ) )* ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1718:1: (otherlv_0= 'SLAs' otherlv_1= 'for' otherlv_2= 'service' ( (lv_service_3_0= ruleServiceRef ) ) ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( ( ruleQualifiedName ) ) )* )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1718:1: (otherlv_0= 'SLAs' otherlv_1= 'for' otherlv_2= 'service' ( (lv_service_3_0= ruleServiceRef ) ) ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( ( ruleQualifiedName ) ) )* )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1718:3: otherlv_0= 'SLAs' otherlv_1= 'for' otherlv_2= 'service' ( (lv_service_3_0= ruleServiceRef ) ) ( ( ruleQualifiedName ) ) (otherlv_5= ',' ( ( ruleQualifiedName ) ) )*
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleServiceSLASpec3567); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getServiceSLASpecAccess().getSLAsKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleServiceSLASpec3579); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getServiceSLASpecAccess().getForKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleServiceSLASpec3591); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getServiceSLASpecAccess().getServiceKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1730:1: ( (lv_service_3_0= ruleServiceRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1731:1: (lv_service_3_0= ruleServiceRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1731:1: (lv_service_3_0= ruleServiceRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1732:3: lv_service_3_0= ruleServiceRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getServiceSLASpecAccess().getServiceServiceRefParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleServiceSLASpec3612);
            lv_service_3_0=ruleServiceRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getServiceSLASpecRule());
              	        }
                     		set(
                     			current, 
                     			"service",
                      		lv_service_3_0, 
                      		"ServiceRef");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1748:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1749:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1749:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1750:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getServiceSLASpecRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getServiceSLASpecAccess().getSlaSLACrossReference_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleServiceSLASpec3639);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1766:2: (otherlv_5= ',' ( ( ruleQualifiedName ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==21) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1766:4: otherlv_5= ',' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_5=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleServiceSLASpec3652); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getServiceSLASpecAccess().getCommaKeyword_5_0());
            	          
            	    }
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1770:1: ( ( ruleQualifiedName ) )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1771:1: ( ruleQualifiedName )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1771:1: ( ruleQualifiedName )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1772:3: ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getServiceSLASpecRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getServiceSLASpecAccess().getSlaSLACrossReference_5_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleServiceSLASpec3679);
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
            	    break loop46;
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
    // $ANTLR end "ruleServiceSLASpec"


    // $ANTLR start "entryRuleComponent"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1796:1: entryRuleComponent returns [EObject current=null] : iv_ruleComponent= ruleComponent EOF ;
    public final EObject entryRuleComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponent = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1797:2: (iv_ruleComponent= ruleComponent EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1798:2: iv_ruleComponent= ruleComponent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComponentRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleComponent_in_entryRuleComponent3717);
            iv_ruleComponent=ruleComponent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComponent; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleComponent3727); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponent"


    // $ANTLR start "ruleComponent"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1805:1: ruleComponent returns [EObject current=null] : (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'implements' ( (lv_implements_3_0= ruleServiceRef ) ) otherlv_4= '{' otherlv_5= 'bind to environment' ( ( ruleQualifiedName ) ) otherlv_7= 'provided-services' ( (lv_services_8_0= ruleServiceRef ) ) (otherlv_9= ',' ( (lv_services_10_0= ruleServiceRef ) ) )* (otherlv_11= 'referenced-services' ( (lv_referencedServices_12_0= ruleServiceRef ) ) (otherlv_13= ',' )* )? otherlv_14= 'protocols' otherlv_15= '{' ( (lv_protocol_16_0= ruleBindingProtocol ) )+ otherlv_17= '}' ( (lv_operation_18_0= ruleOperationBinding ) )* (otherlv_19= 'policies' otherlv_20= '{' ( (lv_policies_21_0= rulePolicy ) )* otherlv_22= '}' )? (otherlv_23= 'provider-policies' otherlv_24= '{' ( (lv_providerPolicies_25_0= rulePolicy ) )* otherlv_26= '}' )? (otherlv_27= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_29= ',' ( ( ruleQualifiedName ) ) )* )? otherlv_31= 'implementation' ( (lv_implementation_32_0= ruleImplementationType ) ) (otherlv_33= 'sourceURL' ( (lv_source_34_0= RULE_STRING ) ) )? otherlv_35= '}' ) ;
    public final EObject ruleComponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token lv_source_34_0=null;
        Token otherlv_35=null;
        EObject lv_implements_3_0 = null;

        EObject lv_services_8_0 = null;

        EObject lv_services_10_0 = null;

        EObject lv_referencedServices_12_0 = null;

        EObject lv_protocol_16_0 = null;

        EObject lv_operation_18_0 = null;

        EObject lv_policies_21_0 = null;

        EObject lv_providerPolicies_25_0 = null;

        Enumerator lv_implementation_32_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1808:28: ( (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'implements' ( (lv_implements_3_0= ruleServiceRef ) ) otherlv_4= '{' otherlv_5= 'bind to environment' ( ( ruleQualifiedName ) ) otherlv_7= 'provided-services' ( (lv_services_8_0= ruleServiceRef ) ) (otherlv_9= ',' ( (lv_services_10_0= ruleServiceRef ) ) )* (otherlv_11= 'referenced-services' ( (lv_referencedServices_12_0= ruleServiceRef ) ) (otherlv_13= ',' )* )? otherlv_14= 'protocols' otherlv_15= '{' ( (lv_protocol_16_0= ruleBindingProtocol ) )+ otherlv_17= '}' ( (lv_operation_18_0= ruleOperationBinding ) )* (otherlv_19= 'policies' otherlv_20= '{' ( (lv_policies_21_0= rulePolicy ) )* otherlv_22= '}' )? (otherlv_23= 'provider-policies' otherlv_24= '{' ( (lv_providerPolicies_25_0= rulePolicy ) )* otherlv_26= '}' )? (otherlv_27= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_29= ',' ( ( ruleQualifiedName ) ) )* )? otherlv_31= 'implementation' ( (lv_implementation_32_0= ruleImplementationType ) ) (otherlv_33= 'sourceURL' ( (lv_source_34_0= RULE_STRING ) ) )? otherlv_35= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1809:1: (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'implements' ( (lv_implements_3_0= ruleServiceRef ) ) otherlv_4= '{' otherlv_5= 'bind to environment' ( ( ruleQualifiedName ) ) otherlv_7= 'provided-services' ( (lv_services_8_0= ruleServiceRef ) ) (otherlv_9= ',' ( (lv_services_10_0= ruleServiceRef ) ) )* (otherlv_11= 'referenced-services' ( (lv_referencedServices_12_0= ruleServiceRef ) ) (otherlv_13= ',' )* )? otherlv_14= 'protocols' otherlv_15= '{' ( (lv_protocol_16_0= ruleBindingProtocol ) )+ otherlv_17= '}' ( (lv_operation_18_0= ruleOperationBinding ) )* (otherlv_19= 'policies' otherlv_20= '{' ( (lv_policies_21_0= rulePolicy ) )* otherlv_22= '}' )? (otherlv_23= 'provider-policies' otherlv_24= '{' ( (lv_providerPolicies_25_0= rulePolicy ) )* otherlv_26= '}' )? (otherlv_27= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_29= ',' ( ( ruleQualifiedName ) ) )* )? otherlv_31= 'implementation' ( (lv_implementation_32_0= ruleImplementationType ) ) (otherlv_33= 'sourceURL' ( (lv_source_34_0= RULE_STRING ) ) )? otherlv_35= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1809:1: (otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'implements' ( (lv_implements_3_0= ruleServiceRef ) ) otherlv_4= '{' otherlv_5= 'bind to environment' ( ( ruleQualifiedName ) ) otherlv_7= 'provided-services' ( (lv_services_8_0= ruleServiceRef ) ) (otherlv_9= ',' ( (lv_services_10_0= ruleServiceRef ) ) )* (otherlv_11= 'referenced-services' ( (lv_referencedServices_12_0= ruleServiceRef ) ) (otherlv_13= ',' )* )? otherlv_14= 'protocols' otherlv_15= '{' ( (lv_protocol_16_0= ruleBindingProtocol ) )+ otherlv_17= '}' ( (lv_operation_18_0= ruleOperationBinding ) )* (otherlv_19= 'policies' otherlv_20= '{' ( (lv_policies_21_0= rulePolicy ) )* otherlv_22= '}' )? (otherlv_23= 'provider-policies' otherlv_24= '{' ( (lv_providerPolicies_25_0= rulePolicy ) )* otherlv_26= '}' )? (otherlv_27= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_29= ',' ( ( ruleQualifiedName ) ) )* )? otherlv_31= 'implementation' ( (lv_implementation_32_0= ruleImplementationType ) ) (otherlv_33= 'sourceURL' ( (lv_source_34_0= RULE_STRING ) ) )? otherlv_35= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1809:3: otherlv_0= 'component' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'implements' ( (lv_implements_3_0= ruleServiceRef ) ) otherlv_4= '{' otherlv_5= 'bind to environment' ( ( ruleQualifiedName ) ) otherlv_7= 'provided-services' ( (lv_services_8_0= ruleServiceRef ) ) (otherlv_9= ',' ( (lv_services_10_0= ruleServiceRef ) ) )* (otherlv_11= 'referenced-services' ( (lv_referencedServices_12_0= ruleServiceRef ) ) (otherlv_13= ',' )* )? otherlv_14= 'protocols' otherlv_15= '{' ( (lv_protocol_16_0= ruleBindingProtocol ) )+ otherlv_17= '}' ( (lv_operation_18_0= ruleOperationBinding ) )* (otherlv_19= 'policies' otherlv_20= '{' ( (lv_policies_21_0= rulePolicy ) )* otherlv_22= '}' )? (otherlv_23= 'provider-policies' otherlv_24= '{' ( (lv_providerPolicies_25_0= rulePolicy ) )* otherlv_26= '}' )? (otherlv_27= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_29= ',' ( ( ruleQualifiedName ) ) )* )? otherlv_31= 'implementation' ( (lv_implementation_32_0= ruleImplementationType ) ) (otherlv_33= 'sourceURL' ( (lv_source_34_0= RULE_STRING ) ) )? otherlv_35= '}'
            {
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleComponent3764); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getComponentAccess().getComponentKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1813:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1814:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1814:1: (lv_name_1_0= RULE_ID )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1815:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleComponent3781); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getComponentAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getComponentRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleComponent3798); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getComponentAccess().getImplementsKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1835:1: ( (lv_implements_3_0= ruleServiceRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1836:1: (lv_implements_3_0= ruleServiceRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1836:1: (lv_implements_3_0= ruleServiceRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1837:3: lv_implements_3_0= ruleServiceRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getComponentAccess().getImplementsServiceRefParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleComponent3819);
            lv_implements_3_0=ruleServiceRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getComponentRule());
              	        }
                     		set(
                     			current, 
                     			"implements",
                      		lv_implements_3_0, 
                      		"ServiceRef");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleComponent3831); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getComponentAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleComponent3843); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getComponentAccess().getBindToEnvironmentKeyword_5());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1861:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1862:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1862:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1863:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getComponentRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getComponentAccess().getEnvironmentEnvironmentCrossReference_6_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleComponent3870);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleComponent3882); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getComponentAccess().getProvidedServicesKeyword_7());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1883:1: ( (lv_services_8_0= ruleServiceRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1884:1: (lv_services_8_0= ruleServiceRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1884:1: (lv_services_8_0= ruleServiceRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1885:3: lv_services_8_0= ruleServiceRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getComponentAccess().getServicesServiceRefParserRuleCall_8_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleComponent3903);
            lv_services_8_0=ruleServiceRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getComponentRule());
              	        }
                     		add(
                     			current, 
                     			"services",
                      		lv_services_8_0, 
                      		"ServiceRef");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1901:2: (otherlv_9= ',' ( (lv_services_10_0= ruleServiceRef ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==21) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1901:4: otherlv_9= ',' ( (lv_services_10_0= ruleServiceRef ) )
            	    {
            	    otherlv_9=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleComponent3916); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_9, grammarAccess.getComponentAccess().getCommaKeyword_9_0());
            	          
            	    }
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1905:1: ( (lv_services_10_0= ruleServiceRef ) )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1906:1: (lv_services_10_0= ruleServiceRef )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1906:1: (lv_services_10_0= ruleServiceRef )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1907:3: lv_services_10_0= ruleServiceRef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getComponentAccess().getServicesServiceRefParserRuleCall_9_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleComponent3937);
            	    lv_services_10_0=ruleServiceRef();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getComponentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"services",
            	              		lv_services_10_0, 
            	              		"ServiceRef");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1923:4: (otherlv_11= 'referenced-services' ( (lv_referencedServices_12_0= ruleServiceRef ) ) (otherlv_13= ',' )* )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==37) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1923:6: otherlv_11= 'referenced-services' ( (lv_referencedServices_12_0= ruleServiceRef ) ) (otherlv_13= ',' )*
                    {
                    otherlv_11=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleComponent3952); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getComponentAccess().getReferencedServicesKeyword_10_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1927:1: ( (lv_referencedServices_12_0= ruleServiceRef ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1928:1: (lv_referencedServices_12_0= ruleServiceRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1928:1: (lv_referencedServices_12_0= ruleServiceRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1929:3: lv_referencedServices_12_0= ruleServiceRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getComponentAccess().getReferencedServicesServiceRefParserRuleCall_10_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleComponent3973);
                    lv_referencedServices_12_0=ruleServiceRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getComponentRule());
                      	        }
                             		add(
                             			current, 
                             			"referencedServices",
                              		lv_referencedServices_12_0, 
                              		"ServiceRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1945:2: (otherlv_13= ',' )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==21) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1945:4: otherlv_13= ','
                    	    {
                    	    otherlv_13=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleComponent3986); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_13, grammarAccess.getComponentAccess().getCommaKeyword_10_2());
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_14=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleComponent4002); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_14, grammarAccess.getComponentAccess().getProtocolsKeyword_11());
                  
            }
            otherlv_15=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleComponent4014); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getComponentAccess().getLeftCurlyBracketKeyword_12());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1957:1: ( (lv_protocol_16_0= ruleBindingProtocol ) )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==40||LA50_0==45||LA50_0==48||LA50_0==50||LA50_0==54||LA50_0==56||LA50_0==60||LA50_0==64||LA50_0==66) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1958:1: (lv_protocol_16_0= ruleBindingProtocol )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1958:1: (lv_protocol_16_0= ruleBindingProtocol )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1959:3: lv_protocol_16_0= ruleBindingProtocol
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getComponentAccess().getProtocolBindingProtocolParserRuleCall_13_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleComponent4035);
            	    lv_protocol_16_0=ruleBindingProtocol();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getComponentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"protocol",
            	              		lv_protocol_16_0, 
            	              		"BindingProtocol");
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

            otherlv_17=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleComponent4048); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_17, grammarAccess.getComponentAccess().getRightCurlyBracketKeyword_14());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1979:1: ( (lv_operation_18_0= ruleOperationBinding ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==26) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1980:1: (lv_operation_18_0= ruleOperationBinding )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1980:1: (lv_operation_18_0= ruleOperationBinding )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1981:3: lv_operation_18_0= ruleOperationBinding
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getComponentAccess().getOperationOperationBindingParserRuleCall_15_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleOperationBinding_in_ruleComponent4069);
            	    lv_operation_18_0=ruleOperationBinding();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getComponentRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"operation",
            	              		lv_operation_18_0, 
            	              		"OperationBinding");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1997:3: (otherlv_19= 'policies' otherlv_20= '{' ( (lv_policies_21_0= rulePolicy ) )* otherlv_22= '}' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==18) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1997:5: otherlv_19= 'policies' otherlv_20= '{' ( (lv_policies_21_0= rulePolicy ) )* otherlv_22= '}'
                    {
                    otherlv_19=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleComponent4083); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getComponentAccess().getPoliciesKeyword_16_0());
                          
                    }
                    otherlv_20=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleComponent4095); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_20, grammarAccess.getComponentAccess().getLeftCurlyBracketKeyword_16_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2005:1: ( (lv_policies_21_0= rulePolicy ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( ((LA52_0>=68 && LA52_0<=69)||(LA52_0>=74 && LA52_0<=76)) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2006:1: (lv_policies_21_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2006:1: (lv_policies_21_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2007:3: lv_policies_21_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getComponentAccess().getPoliciesPolicyParserRuleCall_16_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleComponent4116);
                    	    lv_policies_21_0=rulePolicy();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getComponentRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"policies",
                    	              		lv_policies_21_0, 
                    	              		"Policy");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);

                    otherlv_22=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleComponent4129); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_22, grammarAccess.getComponentAccess().getRightCurlyBracketKeyword_16_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2027:3: (otherlv_23= 'provider-policies' otherlv_24= '{' ( (lv_providerPolicies_25_0= rulePolicy ) )* otherlv_26= '}' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==19) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2027:5: otherlv_23= 'provider-policies' otherlv_24= '{' ( (lv_providerPolicies_25_0= rulePolicy ) )* otherlv_26= '}'
                    {
                    otherlv_23=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleComponent4144); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_23, grammarAccess.getComponentAccess().getProviderPoliciesKeyword_17_0());
                          
                    }
                    otherlv_24=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleComponent4156); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_24, grammarAccess.getComponentAccess().getLeftCurlyBracketKeyword_17_1());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2035:1: ( (lv_providerPolicies_25_0= rulePolicy ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( ((LA54_0>=68 && LA54_0<=69)||(LA54_0>=74 && LA54_0<=76)) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2036:1: (lv_providerPolicies_25_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2036:1: (lv_providerPolicies_25_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2037:3: lv_providerPolicies_25_0= rulePolicy
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getComponentAccess().getProviderPoliciesPolicyParserRuleCall_17_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleComponent4177);
                    	    lv_providerPolicies_25_0=rulePolicy();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getComponentRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"providerPolicies",
                    	              		lv_providerPolicies_25_0, 
                    	              		"Policy");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);

                    otherlv_26=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleComponent4190); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_26, grammarAccess.getComponentAccess().getRightCurlyBracketKeyword_17_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2057:3: (otherlv_27= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_29= ',' ( ( ruleQualifiedName ) ) )* )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==20) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2057:5: otherlv_27= 'SLAs' ( ( ruleQualifiedName ) ) (otherlv_29= ',' ( ( ruleQualifiedName ) ) )*
                    {
                    otherlv_27=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleComponent4205); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_27, grammarAccess.getComponentAccess().getSLAsKeyword_18_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2061:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2062:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2062:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2063:3: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getComponentRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getComponentAccess().getSlaSLACrossReference_18_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleComponent4232);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2079:2: (otherlv_29= ',' ( ( ruleQualifiedName ) ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==21) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2079:4: otherlv_29= ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_29=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleComponent4245); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_29, grammarAccess.getComponentAccess().getCommaKeyword_18_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2083:1: ( ( ruleQualifiedName ) )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2084:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2084:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2085:3: ruleQualifiedName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getComponentRule());
                    	      	        }
                    	              
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getComponentAccess().getSlaSLACrossReference_18_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleComponent4272);
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
                    	    break loop56;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_31=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleComponent4288); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_31, grammarAccess.getComponentAccess().getImplementationKeyword_19());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2105:1: ( (lv_implementation_32_0= ruleImplementationType ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2106:1: (lv_implementation_32_0= ruleImplementationType )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2106:1: (lv_implementation_32_0= ruleImplementationType )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2107:3: lv_implementation_32_0= ruleImplementationType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getComponentAccess().getImplementationImplementationTypeEnumRuleCall_20_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleImplementationType_in_ruleComponent4309);
            lv_implementation_32_0=ruleImplementationType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getComponentRule());
              	        }
                     		set(
                     			current, 
                     			"implementation",
                      		lv_implementation_32_0, 
                      		"ImplementationType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2123:2: (otherlv_33= 'sourceURL' ( (lv_source_34_0= RULE_STRING ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==39) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2123:4: otherlv_33= 'sourceURL' ( (lv_source_34_0= RULE_STRING ) )
                    {
                    otherlv_33=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleComponent4322); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_33, grammarAccess.getComponentAccess().getSourceURLKeyword_21_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2127:1: ( (lv_source_34_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2128:1: (lv_source_34_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2128:1: (lv_source_34_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2129:3: lv_source_34_0= RULE_STRING
                    {
                    lv_source_34_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleComponent4339); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_source_34_0, grammarAccess.getComponentAccess().getSourceSTRINGTerminalRuleCall_21_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getComponentRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"source",
                              		lv_source_34_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_35=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleComponent4358); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_35, grammarAccess.getComponentAccess().getRightCurlyBracketKeyword_22());
                  
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
    // $ANTLR end "ruleComponent"


    // $ANTLR start "entryRuleSOAP"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2157:1: entryRuleSOAP returns [EObject current=null] : iv_ruleSOAP= ruleSOAP EOF ;
    public final EObject entryRuleSOAP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSOAP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2158:2: (iv_ruleSOAP= ruleSOAP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2159:2: iv_ruleSOAP= ruleSOAP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSOAPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSOAP_in_entryRuleSOAP4394);
            iv_ruleSOAP=ruleSOAP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSOAP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSOAP4404); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2166:1: ruleSOAP returns [EObject current=null] : (otherlv_0= 'SOAP' otherlv_1= '{' () ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )? (otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) ) )? (otherlv_9= 'provider-http-context-root' ( (lv_providerContextRoot_10_0= RULE_STRING ) ) )? (otherlv_11= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_12_0= RULE_STRING ) ) )? otherlv_13= '}' ) ;
    public final EObject ruleSOAP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_contextRoot_8_0=null;
        Token otherlv_9=null;
        Token lv_providerContextRoot_10_0=null;
        Token otherlv_11=null;
        Token lv_providedWsdlUrl_12_0=null;
        Token otherlv_13=null;
        EObject lv_publisher_3_0 = null;

        EObject lv_provider_4_0 = null;

        Enumerator lv_style_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2169:28: ( (otherlv_0= 'SOAP' otherlv_1= '{' () ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )? (otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) ) )? (otherlv_9= 'provider-http-context-root' ( (lv_providerContextRoot_10_0= RULE_STRING ) ) )? (otherlv_11= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_12_0= RULE_STRING ) ) )? otherlv_13= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2170:1: (otherlv_0= 'SOAP' otherlv_1= '{' () ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )? (otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) ) )? (otherlv_9= 'provider-http-context-root' ( (lv_providerContextRoot_10_0= RULE_STRING ) ) )? (otherlv_11= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_12_0= RULE_STRING ) ) )? otherlv_13= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2170:1: (otherlv_0= 'SOAP' otherlv_1= '{' () ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )? (otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) ) )? (otherlv_9= 'provider-http-context-root' ( (lv_providerContextRoot_10_0= RULE_STRING ) ) )? (otherlv_11= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_12_0= RULE_STRING ) ) )? otherlv_13= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2170:3: otherlv_0= 'SOAP' otherlv_1= '{' () ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )? (otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) ) )? (otherlv_9= 'provider-http-context-root' ( (lv_providerContextRoot_10_0= RULE_STRING ) ) )? (otherlv_11= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_12_0= RULE_STRING ) ) )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleSOAP4441); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSOAPAccess().getSOAPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSOAP4453); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSOAPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2178:1: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2179:2: 
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2187:2: ( (lv_publisher_3_0= rulePublisher ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==22) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2188:1: (lv_publisher_3_0= rulePublisher )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2188:1: (lv_publisher_3_0= rulePublisher )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2189:3: lv_publisher_3_0= rulePublisher
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSOAPAccess().getPublisherPublisherParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePublisher_in_ruleSOAP4486);
                    lv_publisher_3_0=rulePublisher();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSOAPRule());
                      	        }
                             		set(
                             			current, 
                             			"publisher",
                              		lv_publisher_3_0, 
                              		"Publisher");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2205:3: ( (lv_provider_4_0= ruleProvider ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==23) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2206:1: (lv_provider_4_0= ruleProvider )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2206:1: (lv_provider_4_0= ruleProvider )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2207:3: lv_provider_4_0= ruleProvider
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSOAPAccess().getProviderProviderParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProvider_in_ruleSOAP4508);
                    lv_provider_4_0=ruleProvider();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSOAPRule());
                      	        }
                             		set(
                             			current, 
                             			"provider",
                              		lv_provider_4_0, 
                              		"Provider");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2223:3: (otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==41) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2223:5: otherlv_5= 'style' ( (lv_style_6_0= ruleSOAPStyle ) )
                    {
                    otherlv_5=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleSOAP4522); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSOAPAccess().getStyleKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2227:1: ( (lv_style_6_0= ruleSOAPStyle ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2228:1: (lv_style_6_0= ruleSOAPStyle )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2228:1: (lv_style_6_0= ruleSOAPStyle )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2229:3: lv_style_6_0= ruleSOAPStyle
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSOAPAccess().getStyleSOAPStyleEnumRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSOAPStyle_in_ruleSOAP4543);
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2245:4: (otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==42) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2245:6: otherlv_7= 'http-context-root' ( (lv_contextRoot_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleSOAP4558); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getSOAPAccess().getHttpContextRootKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2249:1: ( (lv_contextRoot_8_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2250:1: (lv_contextRoot_8_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2250:1: (lv_contextRoot_8_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2251:3: lv_contextRoot_8_0= RULE_STRING
                    {
                    lv_contextRoot_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSOAP4575); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2267:4: (otherlv_9= 'provider-http-context-root' ( (lv_providerContextRoot_10_0= RULE_STRING ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==43) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2267:6: otherlv_9= 'provider-http-context-root' ( (lv_providerContextRoot_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleSOAP4595); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getSOAPAccess().getProviderHttpContextRootKeyword_7_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2271:1: ( (lv_providerContextRoot_10_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2272:1: (lv_providerContextRoot_10_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2272:1: (lv_providerContextRoot_10_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2273:3: lv_providerContextRoot_10_0= RULE_STRING
                    {
                    lv_providerContextRoot_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSOAP4612); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_providerContextRoot_10_0, grammarAccess.getSOAPAccess().getProviderContextRootSTRINGTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSOAPRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"providerContextRoot",
                              		lv_providerContextRoot_10_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2289:4: (otherlv_11= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_12_0= RULE_STRING ) ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==44) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2289:6: otherlv_11= 'provided-WSDL-Url' ( (lv_providedWsdlUrl_12_0= RULE_STRING ) )
                    {
                    otherlv_11=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleSOAP4632); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getSOAPAccess().getProvidedWSDLUrlKeyword_8_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2293:1: ( (lv_providedWsdlUrl_12_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2294:1: (lv_providedWsdlUrl_12_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2294:1: (lv_providedWsdlUrl_12_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2295:3: lv_providedWsdlUrl_12_0= RULE_STRING
                    {
                    lv_providedWsdlUrl_12_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSOAP4649); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_providedWsdlUrl_12_0, grammarAccess.getSOAPAccess().getProvidedWsdlUrlSTRINGTerminalRuleCall_8_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSOAPRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"providedWsdlUrl",
                              		lv_providedWsdlUrl_12_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSOAP4668); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getSOAPAccess().getRightCurlyBracketKeyword_9());
                  
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2323:1: entryRuleSAP returns [EObject current=null] : iv_ruleSAP= ruleSAP EOF ;
    public final EObject entryRuleSAP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2324:2: (iv_ruleSAP= ruleSAP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2325:2: iv_ruleSAP= ruleSAP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSAPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSAP_in_entryRuleSAP4704);
            iv_ruleSAP=ruleSAP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSAP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSAP4714); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2332:1: ruleSAP returns [EObject current=null] : (otherlv_0= 'SAP' otherlv_1= '{' () ( (lv_provider_3_0= ruleProvider ) )? (otherlv_4= 'transport' ( (lv_transport_5_0= ruleSAPTransport ) ) )? (otherlv_6= 'client' ( ( ruleQualifiedName ) ) )? otherlv_8= '}' ) ;
    public final EObject ruleSAP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_provider_3_0 = null;

        Enumerator lv_transport_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2335:28: ( (otherlv_0= 'SAP' otherlv_1= '{' () ( (lv_provider_3_0= ruleProvider ) )? (otherlv_4= 'transport' ( (lv_transport_5_0= ruleSAPTransport ) ) )? (otherlv_6= 'client' ( ( ruleQualifiedName ) ) )? otherlv_8= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2336:1: (otherlv_0= 'SAP' otherlv_1= '{' () ( (lv_provider_3_0= ruleProvider ) )? (otherlv_4= 'transport' ( (lv_transport_5_0= ruleSAPTransport ) ) )? (otherlv_6= 'client' ( ( ruleQualifiedName ) ) )? otherlv_8= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2336:1: (otherlv_0= 'SAP' otherlv_1= '{' () ( (lv_provider_3_0= ruleProvider ) )? (otherlv_4= 'transport' ( (lv_transport_5_0= ruleSAPTransport ) ) )? (otherlv_6= 'client' ( ( ruleQualifiedName ) ) )? otherlv_8= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2336:3: otherlv_0= 'SAP' otherlv_1= '{' () ( (lv_provider_3_0= ruleProvider ) )? (otherlv_4= 'transport' ( (lv_transport_5_0= ruleSAPTransport ) ) )? (otherlv_6= 'client' ( ( ruleQualifiedName ) ) )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleSAP4751); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSAPAccess().getSAPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSAP4763); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSAPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2344:1: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2345:2: 
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2353:2: ( (lv_provider_3_0= ruleProvider ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==23) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2354:1: (lv_provider_3_0= ruleProvider )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2354:1: (lv_provider_3_0= ruleProvider )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2355:3: lv_provider_3_0= ruleProvider
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSAPAccess().getProviderProviderParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProvider_in_ruleSAP4796);
                    lv_provider_3_0=ruleProvider();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSAPRule());
                      	        }
                             		set(
                             			current, 
                             			"provider",
                              		lv_provider_3_0, 
                              		"Provider");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2371:3: (otherlv_4= 'transport' ( (lv_transport_5_0= ruleSAPTransport ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==46) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2371:5: otherlv_4= 'transport' ( (lv_transport_5_0= ruleSAPTransport ) )
                    {
                    otherlv_4=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleSAP4810); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getSAPAccess().getTransportKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2375:1: ( (lv_transport_5_0= ruleSAPTransport ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2376:1: (lv_transport_5_0= ruleSAPTransport )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2376:1: (lv_transport_5_0= ruleSAPTransport )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2377:3: lv_transport_5_0= ruleSAPTransport
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSAPAccess().getTransportSAPTransportEnumRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSAPTransport_in_ruleSAP4831);
                    lv_transport_5_0=ruleSAPTransport();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSAPRule());
                      	        }
                             		set(
                             			current, 
                             			"transport",
                              		lv_transport_5_0, 
                              		"SAPTransport");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2393:4: (otherlv_6= 'client' ( ( ruleQualifiedName ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==47) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2393:6: otherlv_6= 'client' ( ( ruleQualifiedName ) )
                    {
                    otherlv_6=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleSAP4846); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getSAPAccess().getClientKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2397:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2398:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2398:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2399:3: ruleQualifiedName
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
                       
                      	        newCompositeNode(grammarAccess.getSAPAccess().getClientSapClientCrossReference_5_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSAP4873);
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

            otherlv_8=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSAP4887); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getSAPAccess().getRightCurlyBracketKeyword_6());
                  
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2427:1: entryRuleEJB returns [EObject current=null] : iv_ruleEJB= ruleEJB EOF ;
    public final EObject entryRuleEJB() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEJB = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2428:2: (iv_ruleEJB= ruleEJB EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2429:2: iv_ruleEJB= ruleEJB EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEJBRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEJB_in_entryRuleEJB4923);
            iv_ruleEJB=ruleEJB();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEJB; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEJB4933); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2436:1: ruleEJB returns [EObject current=null] : (otherlv_0= 'EJB' otherlv_1= '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? otherlv_4= 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) otherlv_6= '}' ) ;
    public final EObject ruleEJB() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token lv_jndiName_5_0=null;
        Token otherlv_6=null;
        EObject lv_publisher_2_0 = null;

        EObject lv_provider_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2439:28: ( (otherlv_0= 'EJB' otherlv_1= '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? otherlv_4= 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) otherlv_6= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2440:1: (otherlv_0= 'EJB' otherlv_1= '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? otherlv_4= 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) otherlv_6= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2440:1: (otherlv_0= 'EJB' otherlv_1= '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? otherlv_4= 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) otherlv_6= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2440:3: otherlv_0= 'EJB' otherlv_1= '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? otherlv_4= 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleEJB4970); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getEJBAccess().getEJBKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEJB4982); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getEJBAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2448:1: ( (lv_publisher_2_0= rulePublisher ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==22) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2449:1: (lv_publisher_2_0= rulePublisher )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2449:1: (lv_publisher_2_0= rulePublisher )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2450:3: lv_publisher_2_0= rulePublisher
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEJBAccess().getPublisherPublisherParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePublisher_in_ruleEJB5003);
                    lv_publisher_2_0=rulePublisher();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEJBRule());
                      	        }
                             		set(
                             			current, 
                             			"publisher",
                              		lv_publisher_2_0, 
                              		"Publisher");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2466:3: ( (lv_provider_3_0= ruleProvider ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==23) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2467:1: (lv_provider_3_0= ruleProvider )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2467:1: (lv_provider_3_0= ruleProvider )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2468:3: lv_provider_3_0= ruleProvider
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getEJBAccess().getProviderProviderParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProvider_in_ruleEJB5025);
                    lv_provider_3_0=ruleProvider();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getEJBRule());
                      	        }
                             		set(
                             			current, 
                             			"provider",
                              		lv_provider_3_0, 
                              		"Provider");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleEJB5038); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getEJBAccess().getJndiNameKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2488:1: ( (lv_jndiName_5_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2489:1: (lv_jndiName_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2489:1: (lv_jndiName_5_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2490:3: lv_jndiName_5_0= RULE_STRING
            {
            lv_jndiName_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEJB5055); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleEJB5072); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2518:1: entryRuleHTTP returns [EObject current=null] : iv_ruleHTTP= ruleHTTP EOF ;
    public final EObject entryRuleHTTP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2519:2: (iv_ruleHTTP= ruleHTTP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2520:2: iv_ruleHTTP= ruleHTTP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHTTPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleHTTP_in_entryRuleHTTP5108);
            iv_ruleHTTP=ruleHTTP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHTTP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHTTP5118); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2527:1: ruleHTTP returns [EObject current=null] : (otherlv_0= 'HTTP' otherlv_1= '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= '}' ) ;
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
        EObject lv_publisher_2_0 = null;

        EObject lv_provider_3_0 = null;

        Enumerator lv_verb_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2530:28: ( (otherlv_0= 'HTTP' otherlv_1= '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2531:1: (otherlv_0= 'HTTP' otherlv_1= '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2531:1: (otherlv_0= 'HTTP' otherlv_1= '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2531:3: otherlv_0= 'HTTP' otherlv_1= '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleHTTP5155); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getHTTPAccess().getHTTPKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleHTTP5167); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getHTTPAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2539:1: ( (lv_publisher_2_0= rulePublisher ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==22) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2540:1: (lv_publisher_2_0= rulePublisher )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2540:1: (lv_publisher_2_0= rulePublisher )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2541:3: lv_publisher_2_0= rulePublisher
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getHTTPAccess().getPublisherPublisherParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePublisher_in_ruleHTTP5188);
                    lv_publisher_2_0=rulePublisher();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getHTTPRule());
                      	        }
                             		set(
                             			current, 
                             			"publisher",
                              		lv_publisher_2_0, 
                              		"Publisher");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2557:3: ( (lv_provider_3_0= ruleProvider ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==23) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2558:1: (lv_provider_3_0= ruleProvider )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2558:1: (lv_provider_3_0= ruleProvider )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2559:3: lv_provider_3_0= ruleProvider
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getHTTPAccess().getProviderProviderParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProvider_in_ruleHTTP5210);
                    lv_provider_3_0=ruleProvider();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getHTTPRule());
                      	        }
                             		set(
                             			current, 
                             			"provider",
                              		lv_provider_3_0, 
                              		"Provider");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleHTTP5223); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getHTTPAccess().getUrlKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2579:1: ( (lv_url_5_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2580:1: (lv_url_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2580:1: (lv_url_5_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2581:3: lv_url_5_0= RULE_STRING
            {
            lv_url_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleHTTP5240); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleHTTP5257); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getHTTPAccess().getProviderUrlKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2601:1: ( (lv_providerUrl_7_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2602:1: (lv_providerUrl_7_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2602:1: (lv_providerUrl_7_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2603:3: lv_providerUrl_7_0= RULE_STRING
            {
            lv_providerUrl_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleHTTP5274); if (state.failed) return current;
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

            otherlv_8=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleHTTP5291); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getHTTPAccess().getVerbKeyword_8());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2623:1: ( (lv_verb_9_0= ruleVerb ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2624:1: (lv_verb_9_0= ruleVerb )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2624:1: (lv_verb_9_0= ruleVerb )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2625:3: lv_verb_9_0= ruleVerb
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getHTTPAccess().getVerbVerbEnumRuleCall_9_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVerb_in_ruleHTTP5312);
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

            otherlv_10=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleHTTP5324); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2653:1: entryRuleREST returns [EObject current=null] : iv_ruleREST= ruleREST EOF ;
    public final EObject entryRuleREST() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleREST = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2654:2: (iv_ruleREST= ruleREST EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2655:2: iv_ruleREST= ruleREST EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRESTRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleREST_in_entryRuleREST5360);
            iv_ruleREST=ruleREST();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleREST; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleREST5370); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2662:1: ruleREST returns [EObject current=null] : (otherlv_0= 'REST' otherlv_1= '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) otherlv_12= '}' ) ;
    public final EObject ruleREST() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token lv_url_5_0=null;
        Token otherlv_6=null;
        Token lv_providerUrl_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_publisher_2_0 = null;

        EObject lv_provider_3_0 = null;

        Enumerator lv_verb_9_0 = null;

        Enumerator lv_format_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2665:28: ( (otherlv_0= 'REST' otherlv_1= '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) otherlv_12= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2666:1: (otherlv_0= 'REST' otherlv_1= '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) otherlv_12= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2666:1: (otherlv_0= 'REST' otherlv_1= '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) otherlv_12= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2666:3: otherlv_0= 'REST' otherlv_1= '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? otherlv_4= 'url' ( (lv_url_5_0= RULE_STRING ) ) otherlv_6= 'provider-url' ( (lv_providerUrl_7_0= RULE_STRING ) ) otherlv_8= 'verb' ( (lv_verb_9_0= ruleVerb ) ) otherlv_10= 'format' ( (lv_format_11_0= ruleRESTFormat ) ) otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleREST5407); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getRESTAccess().getRESTKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleREST5419); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRESTAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2674:1: ( (lv_publisher_2_0= rulePublisher ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==22) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2675:1: (lv_publisher_2_0= rulePublisher )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2675:1: (lv_publisher_2_0= rulePublisher )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2676:3: lv_publisher_2_0= rulePublisher
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRESTAccess().getPublisherPublisherParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePublisher_in_ruleREST5440);
                    lv_publisher_2_0=rulePublisher();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRESTRule());
                      	        }
                             		set(
                             			current, 
                             			"publisher",
                              		lv_publisher_2_0, 
                              		"Publisher");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2692:3: ( (lv_provider_3_0= ruleProvider ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==23) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2693:1: (lv_provider_3_0= ruleProvider )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2693:1: (lv_provider_3_0= ruleProvider )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2694:3: lv_provider_3_0= ruleProvider
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRESTAccess().getProviderProviderParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProvider_in_ruleREST5462);
                    lv_provider_3_0=ruleProvider();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRESTRule());
                      	        }
                             		set(
                             			current, 
                             			"provider",
                              		lv_provider_3_0, 
                              		"Provider");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleREST5475); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getRESTAccess().getUrlKeyword_4());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2714:1: ( (lv_url_5_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2715:1: (lv_url_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2715:1: (lv_url_5_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2716:3: lv_url_5_0= RULE_STRING
            {
            lv_url_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleREST5492); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_url_5_0, grammarAccess.getRESTAccess().getUrlSTRINGTerminalRuleCall_5_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRESTRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"url",
                      		lv_url_5_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleREST5509); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getRESTAccess().getProviderUrlKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2736:1: ( (lv_providerUrl_7_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2737:1: (lv_providerUrl_7_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2737:1: (lv_providerUrl_7_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2738:3: lv_providerUrl_7_0= RULE_STRING
            {
            lv_providerUrl_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleREST5526); if (state.failed) return current;
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

            otherlv_8=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleREST5543); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getRESTAccess().getVerbKeyword_8());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2758:1: ( (lv_verb_9_0= ruleVerb ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2759:1: (lv_verb_9_0= ruleVerb )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2759:1: (lv_verb_9_0= ruleVerb )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2760:3: lv_verb_9_0= ruleVerb
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRESTAccess().getVerbVerbEnumRuleCall_9_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVerb_in_ruleREST5564);
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

            otherlv_10=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleREST5576); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getRESTAccess().getFormatKeyword_10());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2780:1: ( (lv_format_11_0= ruleRESTFormat ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2781:1: (lv_format_11_0= ruleRESTFormat )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2781:1: (lv_format_11_0= ruleRESTFormat )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2782:3: lv_format_11_0= ruleRESTFormat
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRESTAccess().getFormatRESTFormatEnumRuleCall_11_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleRESTFormat_in_ruleREST5597);
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

            otherlv_12=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleREST5609); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getRESTAccess().getRightCurlyBracketKeyword_12());
                  
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2810:1: entryRuleJMS returns [EObject current=null] : iv_ruleJMS= ruleJMS EOF ;
    public final EObject entryRuleJMS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJMS = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2811:2: (iv_ruleJMS= ruleJMS EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2812:2: iv_ruleJMS= ruleJMS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJMSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleJMS_in_entryRuleJMS5645);
            iv_ruleJMS=ruleJMS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJMS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleJMS5655); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2819:1: ruleJMS returns [EObject current=null] : (otherlv_0= 'JMS' otherlv_1= '{' () ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) ;
    public final EObject ruleJMS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_6=null;
        Token lv_jndiName_7_0=null;
        Token otherlv_8=null;
        Token lv_providerJndi_9_0=null;
        Token otherlv_10=null;
        EObject lv_publisher_3_0 = null;

        EObject lv_provider_4_0 = null;

        EObject lv_channel_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2822:28: ( (otherlv_0= 'JMS' otherlv_1= '{' () ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2823:1: (otherlv_0= 'JMS' otherlv_1= '{' () ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2823:1: (otherlv_0= 'JMS' otherlv_1= '{' () ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2823:3: otherlv_0= 'JMS' otherlv_1= '{' () ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? otherlv_6= 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleJMS5692); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJMSAccess().getJMSKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleJMS5704); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJMSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2831:1: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2832:2: 
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2840:2: ( (lv_publisher_3_0= rulePublisher ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==22) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2841:1: (lv_publisher_3_0= rulePublisher )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2841:1: (lv_publisher_3_0= rulePublisher )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2842:3: lv_publisher_3_0= rulePublisher
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJMSAccess().getPublisherPublisherParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePublisher_in_ruleJMS5737);
                    lv_publisher_3_0=rulePublisher();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJMSRule());
                      	        }
                             		set(
                             			current, 
                             			"publisher",
                              		lv_publisher_3_0, 
                              		"Publisher");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2858:3: ( (lv_provider_4_0= ruleProvider ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==23) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2859:1: (lv_provider_4_0= ruleProvider )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2859:1: (lv_provider_4_0= ruleProvider )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2860:3: lv_provider_4_0= ruleProvider
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJMSAccess().getProviderProviderParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProvider_in_ruleJMS5759);
                    lv_provider_4_0=ruleProvider();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJMSRule());
                      	        }
                             		set(
                             			current, 
                             			"provider",
                              		lv_provider_4_0, 
                              		"Provider");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2876:3: ( (lv_channel_5_0= ruleTopicOrQueue ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( ((LA76_0>=58 && LA76_0<=59)) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2877:1: (lv_channel_5_0= ruleTopicOrQueue )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2877:1: (lv_channel_5_0= ruleTopicOrQueue )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2878:3: lv_channel_5_0= ruleTopicOrQueue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJMSAccess().getChannelTopicOrQueueParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTopicOrQueue_in_ruleJMS5781);
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

            otherlv_6=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleJMS5794); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getJMSAccess().getJndiNameKeyword_6());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2898:1: ( (lv_jndiName_7_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2899:1: (lv_jndiName_7_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2899:1: (lv_jndiName_7_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2900:3: lv_jndiName_7_0= RULE_STRING
            {
            lv_jndiName_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleJMS5811); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2916:2: (otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==57) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2916:4: otherlv_8= 'provider-jndi-name' ( (lv_providerJndi_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleJMS5829); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getJMSAccess().getProviderJndiNameKeyword_8_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2920:1: ( (lv_providerJndi_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2921:1: (lv_providerJndi_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2921:1: (lv_providerJndi_9_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2922:3: lv_providerJndi_9_0= RULE_STRING
                    {
                    lv_providerJndi_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleJMS5846); if (state.failed) return current;
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

            otherlv_10=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleJMS5865); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2950:1: entryRuleTopicOrQueue returns [EObject current=null] : iv_ruleTopicOrQueue= ruleTopicOrQueue EOF ;
    public final EObject entryRuleTopicOrQueue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopicOrQueue = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2951:2: (iv_ruleTopicOrQueue= ruleTopicOrQueue EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2952:2: iv_ruleTopicOrQueue= ruleTopicOrQueue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTopicOrQueueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTopicOrQueue_in_entryRuleTopicOrQueue5901);
            iv_ruleTopicOrQueue=ruleTopicOrQueue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTopicOrQueue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTopicOrQueue5911); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2959:1: ruleTopicOrQueue returns [EObject current=null] : (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue ) ;
    public final EObject ruleTopicOrQueue() throws RecognitionException {
        EObject current = null;

        EObject this_Topic_0 = null;

        EObject this_Queue_1 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2962:28: ( (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2963:1: (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2963:1: (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==58) ) {
                alt78=1;
            }
            else if ( (LA78_0==59) ) {
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2964:2: this_Topic_0= ruleTopic
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTopicOrQueueAccess().getTopicParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTopic_in_ruleTopicOrQueue5961);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2977:2: this_Queue_1= ruleQueue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTopicOrQueueAccess().getQueueParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQueue_in_ruleTopicOrQueue5991);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2996:1: entryRuleTopic returns [EObject current=null] : iv_ruleTopic= ruleTopic EOF ;
    public final EObject entryRuleTopic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopic = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2997:2: (iv_ruleTopic= ruleTopic EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2998:2: iv_ruleTopic= ruleTopic EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTopicRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTopic_in_entryRuleTopic6026);
            iv_ruleTopic=ruleTopic();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTopic; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTopic6036); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3005:1: ruleTopic returns [EObject current=null] : (otherlv_0= 'topic' ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleTopic() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3008:28: ( (otherlv_0= 'topic' ( (lv_name_1_0= RULE_STRING ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3009:1: (otherlv_0= 'topic' ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3009:1: (otherlv_0= 'topic' ( (lv_name_1_0= RULE_STRING ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3009:3: otherlv_0= 'topic' ( (lv_name_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleTopic6073); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTopicAccess().getTopicKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3013:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3014:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3014:1: (lv_name_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3015:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleTopic6090); if (state.failed) return current;
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


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3039:1: entryRuleQueue returns [EObject current=null] : iv_ruleQueue= ruleQueue EOF ;
    public final EObject entryRuleQueue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueue = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3040:2: (iv_ruleQueue= ruleQueue EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3041:2: iv_ruleQueue= ruleQueue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQueueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQueue_in_entryRuleQueue6131);
            iv_ruleQueue=ruleQueue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQueue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQueue6141); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3048:1: ruleQueue returns [EObject current=null] : (otherlv_0= 'queue' ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleQueue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3051:28: ( (otherlv_0= 'queue' ( (lv_name_1_0= RULE_STRING ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3052:1: (otherlv_0= 'queue' ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3052:1: (otherlv_0= 'queue' ( (lv_name_1_0= RULE_STRING ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3052:3: otherlv_0= 'queue' ( (lv_name_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleQueue6178); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getQueueAccess().getQueueKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3056:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3057:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3057:1: (lv_name_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3058:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleQueue6195); if (state.failed) return current;
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


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3082:1: entryRuleSCA returns [EObject current=null] : iv_ruleSCA= ruleSCA EOF ;
    public final EObject entryRuleSCA() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSCA = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3083:2: (iv_ruleSCA= ruleSCA EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3084:2: iv_ruleSCA= ruleSCA EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSCARule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSCA_in_entryRuleSCA6236);
            iv_ruleSCA=ruleSCA();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSCA; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSCA6246); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3091:1: ruleSCA returns [EObject current=null] : (otherlv_0= 'SCA' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? (otherlv_5= 'promote' ( (lv_promote_6_0= RULE_STRING ) ) )? (otherlv_7= 'reference' ( (lv_reference_8_0= RULE_STRING ) ) ( (lv_isMultipleRef_9_0= '[]' ) )? )? otherlv_10= '}' ) ;
    public final EObject ruleSCA() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token lv_promote_6_0=null;
        Token otherlv_7=null;
        Token lv_reference_8_0=null;
        Token lv_isMultipleRef_9_0=null;
        Token otherlv_10=null;
        EObject lv_publisher_3_0 = null;

        EObject lv_provider_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3094:28: ( (otherlv_0= 'SCA' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? (otherlv_5= 'promote' ( (lv_promote_6_0= RULE_STRING ) ) )? (otherlv_7= 'reference' ( (lv_reference_8_0= RULE_STRING ) ) ( (lv_isMultipleRef_9_0= '[]' ) )? )? otherlv_10= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3095:1: (otherlv_0= 'SCA' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? (otherlv_5= 'promote' ( (lv_promote_6_0= RULE_STRING ) ) )? (otherlv_7= 'reference' ( (lv_reference_8_0= RULE_STRING ) ) ( (lv_isMultipleRef_9_0= '[]' ) )? )? otherlv_10= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3095:1: (otherlv_0= 'SCA' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? (otherlv_5= 'promote' ( (lv_promote_6_0= RULE_STRING ) ) )? (otherlv_7= 'reference' ( (lv_reference_8_0= RULE_STRING ) ) ( (lv_isMultipleRef_9_0= '[]' ) )? )? otherlv_10= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3095:3: otherlv_0= 'SCA' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? (otherlv_5= 'promote' ( (lv_promote_6_0= RULE_STRING ) ) )? (otherlv_7= 'reference' ( (lv_reference_8_0= RULE_STRING ) ) ( (lv_isMultipleRef_9_0= '[]' ) )? )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleSCA6283); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSCAAccess().getSCAKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3099:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3100:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3100:1: (lv_name_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3101:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSCA6300); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getSCAAccess().getNameSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getSCARule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSCA6317); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getSCAAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3121:1: ( (lv_publisher_3_0= rulePublisher ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==22) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3122:1: (lv_publisher_3_0= rulePublisher )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3122:1: (lv_publisher_3_0= rulePublisher )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3123:3: lv_publisher_3_0= rulePublisher
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSCAAccess().getPublisherPublisherParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePublisher_in_ruleSCA6338);
                    lv_publisher_3_0=rulePublisher();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSCARule());
                      	        }
                             		set(
                             			current, 
                             			"publisher",
                              		lv_publisher_3_0, 
                              		"Publisher");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3139:3: ( (lv_provider_4_0= ruleProvider ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==23) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3140:1: (lv_provider_4_0= ruleProvider )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3140:1: (lv_provider_4_0= ruleProvider )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3141:3: lv_provider_4_0= ruleProvider
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSCAAccess().getProviderProviderParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProvider_in_ruleSCA6360);
                    lv_provider_4_0=ruleProvider();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSCARule());
                      	        }
                             		set(
                             			current, 
                             			"provider",
                              		lv_provider_4_0, 
                              		"Provider");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3157:3: (otherlv_5= 'promote' ( (lv_promote_6_0= RULE_STRING ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==61) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3157:5: otherlv_5= 'promote' ( (lv_promote_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleSCA6374); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSCAAccess().getPromoteKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3161:1: ( (lv_promote_6_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3162:1: (lv_promote_6_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3162:1: (lv_promote_6_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3163:3: lv_promote_6_0= RULE_STRING
                    {
                    lv_promote_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSCA6391); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_promote_6_0, grammarAccess.getSCAAccess().getPromoteSTRINGTerminalRuleCall_5_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSCARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"promote",
                              		lv_promote_6_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3179:4: (otherlv_7= 'reference' ( (lv_reference_8_0= RULE_STRING ) ) ( (lv_isMultipleRef_9_0= '[]' ) )? )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==62) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3179:6: otherlv_7= 'reference' ( (lv_reference_8_0= RULE_STRING ) ) ( (lv_isMultipleRef_9_0= '[]' ) )?
                    {
                    otherlv_7=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleSCA6411); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getSCAAccess().getReferenceKeyword_6_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3183:1: ( (lv_reference_8_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3184:1: (lv_reference_8_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3184:1: (lv_reference_8_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3185:3: lv_reference_8_0= RULE_STRING
                    {
                    lv_reference_8_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSCA6428); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_reference_8_0, grammarAccess.getSCAAccess().getReferenceSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSCARule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"reference",
                              		lv_reference_8_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3201:2: ( (lv_isMultipleRef_9_0= '[]' ) )?
                    int alt82=2;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==63) ) {
                        alt82=1;
                    }
                    switch (alt82) {
                        case 1 :
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3202:1: (lv_isMultipleRef_9_0= '[]' )
                            {
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3202:1: (lv_isMultipleRef_9_0= '[]' )
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3203:3: lv_isMultipleRef_9_0= '[]'
                            {
                            lv_isMultipleRef_9_0=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleSCA6451); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_isMultipleRef_9_0, grammarAccess.getSCAAccess().getIsMultipleRefLeftSquareBracketRightSquareBracketKeyword_6_2_0());
                                  
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

            otherlv_10=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSCA6479); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getSCAAccess().getRightCurlyBracketKeyword_7());
                  
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3228:1: entryRuleFILE returns [EObject current=null] : iv_ruleFILE= ruleFILE EOF ;
    public final EObject entryRuleFILE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFILE = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3229:2: (iv_ruleFILE= ruleFILE EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3230:2: iv_ruleFILE= ruleFILE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFILERule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFILE_in_entryRuleFILE6515);
            iv_ruleFILE=ruleFILE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFILE; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFILE6525); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3237:1: ruleFILE returns [EObject current=null] : (otherlv_0= 'FILE' ( (lv_url_1_0= RULE_STRING ) ) ( (lv_accessType_2_0= ruleReadWrite ) ) (otherlv_3= 'interval' ( (lv_pollIntervall_4_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleFILE() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_url_1_0=null;
        Token otherlv_3=null;
        Token lv_pollIntervall_4_0=null;
        Enumerator lv_accessType_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3240:28: ( (otherlv_0= 'FILE' ( (lv_url_1_0= RULE_STRING ) ) ( (lv_accessType_2_0= ruleReadWrite ) ) (otherlv_3= 'interval' ( (lv_pollIntervall_4_0= RULE_STRING ) ) )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3241:1: (otherlv_0= 'FILE' ( (lv_url_1_0= RULE_STRING ) ) ( (lv_accessType_2_0= ruleReadWrite ) ) (otherlv_3= 'interval' ( (lv_pollIntervall_4_0= RULE_STRING ) ) )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3241:1: (otherlv_0= 'FILE' ( (lv_url_1_0= RULE_STRING ) ) ( (lv_accessType_2_0= ruleReadWrite ) ) (otherlv_3= 'interval' ( (lv_pollIntervall_4_0= RULE_STRING ) ) )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3241:3: otherlv_0= 'FILE' ( (lv_url_1_0= RULE_STRING ) ) ( (lv_accessType_2_0= ruleReadWrite ) ) (otherlv_3= 'interval' ( (lv_pollIntervall_4_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleFILE6562); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFILEAccess().getFILEKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3245:1: ( (lv_url_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3246:1: (lv_url_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3246:1: (lv_url_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3247:3: lv_url_1_0= RULE_STRING
            {
            lv_url_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFILE6579); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_url_1_0, grammarAccess.getFILEAccess().getUrlSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFILERule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"url",
                      		lv_url_1_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3263:2: ( (lv_accessType_2_0= ruleReadWrite ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3264:1: (lv_accessType_2_0= ruleReadWrite )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3264:1: (lv_accessType_2_0= ruleReadWrite )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3265:3: lv_accessType_2_0= ruleReadWrite
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFILEAccess().getAccessTypeReadWriteEnumRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleReadWrite_in_ruleFILE6605);
            lv_accessType_2_0=ruleReadWrite();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFILERule());
              	        }
                     		set(
                     			current, 
                     			"accessType",
                      		lv_accessType_2_0, 
                      		"ReadWrite");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3281:2: (otherlv_3= 'interval' ( (lv_pollIntervall_4_0= RULE_STRING ) ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==65) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3281:4: otherlv_3= 'interval' ( (lv_pollIntervall_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleFILE6618); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getFILEAccess().getIntervalKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3285:1: ( (lv_pollIntervall_4_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3286:1: (lv_pollIntervall_4_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3286:1: (lv_pollIntervall_4_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3287:3: lv_pollIntervall_4_0= RULE_STRING
                    {
                    lv_pollIntervall_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFILE6635); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_pollIntervall_4_0, grammarAccess.getFILEAccess().getPollIntervallSTRINGTerminalRuleCall_3_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFILERule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"pollIntervall",
                              		lv_pollIntervall_4_0, 
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
    // $ANTLR end "ruleFILE"


    // $ANTLR start "entryRuleFTP"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3311:1: entryRuleFTP returns [EObject current=null] : iv_ruleFTP= ruleFTP EOF ;
    public final EObject entryRuleFTP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFTP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3312:2: (iv_ruleFTP= ruleFTP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3313:2: iv_ruleFTP= ruleFTP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFTPRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFTP_in_entryRuleFTP6678);
            iv_ruleFTP=ruleFTP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFTP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFTP6688); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3320:1: ruleFTP returns [EObject current=null] : (otherlv_0= 'FTP' ( (lv_url_1_0= RULE_STRING ) ) otherlv_2= 'access' ( (lv_accessType_3_0= ruleReadWrite ) ) (otherlv_4= 'interval' ( (lv_pollIntervall_5_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleFTP() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_url_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_pollIntervall_5_0=null;
        Enumerator lv_accessType_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3323:28: ( (otherlv_0= 'FTP' ( (lv_url_1_0= RULE_STRING ) ) otherlv_2= 'access' ( (lv_accessType_3_0= ruleReadWrite ) ) (otherlv_4= 'interval' ( (lv_pollIntervall_5_0= RULE_STRING ) ) )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3324:1: (otherlv_0= 'FTP' ( (lv_url_1_0= RULE_STRING ) ) otherlv_2= 'access' ( (lv_accessType_3_0= ruleReadWrite ) ) (otherlv_4= 'interval' ( (lv_pollIntervall_5_0= RULE_STRING ) ) )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3324:1: (otherlv_0= 'FTP' ( (lv_url_1_0= RULE_STRING ) ) otherlv_2= 'access' ( (lv_accessType_3_0= ruleReadWrite ) ) (otherlv_4= 'interval' ( (lv_pollIntervall_5_0= RULE_STRING ) ) )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3324:3: otherlv_0= 'FTP' ( (lv_url_1_0= RULE_STRING ) ) otherlv_2= 'access' ( (lv_accessType_3_0= ruleReadWrite ) ) (otherlv_4= 'interval' ( (lv_pollIntervall_5_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleFTP6725); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFTPAccess().getFTPKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3328:1: ( (lv_url_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3329:1: (lv_url_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3329:1: (lv_url_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3330:3: lv_url_1_0= RULE_STRING
            {
            lv_url_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFTP6742); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_url_1_0, grammarAccess.getFTPAccess().getUrlSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFTPRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"url",
                      		lv_url_1_0, 
                      		"STRING");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleFTP6759); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFTPAccess().getAccessKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3350:1: ( (lv_accessType_3_0= ruleReadWrite ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3351:1: (lv_accessType_3_0= ruleReadWrite )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3351:1: (lv_accessType_3_0= ruleReadWrite )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3352:3: lv_accessType_3_0= ruleReadWrite
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFTPAccess().getAccessTypeReadWriteEnumRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleReadWrite_in_ruleFTP6780);
            lv_accessType_3_0=ruleReadWrite();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFTPRule());
              	        }
                     		set(
                     			current, 
                     			"accessType",
                      		lv_accessType_3_0, 
                      		"ReadWrite");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3368:2: (otherlv_4= 'interval' ( (lv_pollIntervall_5_0= RULE_STRING ) ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==65) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3368:4: otherlv_4= 'interval' ( (lv_pollIntervall_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleFTP6793); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getFTPAccess().getIntervalKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3372:1: ( (lv_pollIntervall_5_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3373:1: (lv_pollIntervall_5_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3373:1: (lv_pollIntervall_5_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3374:3: lv_pollIntervall_5_0= RULE_STRING
                    {
                    lv_pollIntervall_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFTP6810); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_pollIntervall_5_0, grammarAccess.getFTPAccess().getPollIntervallSTRINGTerminalRuleCall_4_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFTPRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"pollIntervall",
                              		lv_pollIntervall_5_0, 
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
    // $ANTLR end "ruleFTP"


    // $ANTLR start "entryRulePolicy"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3398:1: entryRulePolicy returns [EObject current=null] : iv_rulePolicy= rulePolicy EOF ;
    public final EObject entryRulePolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3399:2: (iv_rulePolicy= rulePolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3400:2: iv_rulePolicy= rulePolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePolicy_in_entryRulePolicy6853);
            iv_rulePolicy=rulePolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePolicy6863); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3407:1: rulePolicy returns [EObject current=null] : (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy ) ;
    public final EObject rulePolicy() throws RecognitionException {
        EObject current = null;

        EObject this_LogPolicy_0 = null;

        EObject this_SecurityPolicy_1 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3410:28: ( (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3411:1: (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3411:1: (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==68) ) {
                alt86=1;
            }
            else if ( (LA86_0==69||(LA86_0>=74 && LA86_0<=76)) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3412:2: this_LogPolicy_0= ruleLogPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPolicyAccess().getLogPolicyParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLogPolicy_in_rulePolicy6913);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3425:2: this_SecurityPolicy_1= ruleSecurityPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPolicyAccess().getSecurityPolicyParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSecurityPolicy_in_rulePolicy6943);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3444:1: entryRuleLogPolicy returns [EObject current=null] : iv_ruleLogPolicy= ruleLogPolicy EOF ;
    public final EObject entryRuleLogPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3445:2: (iv_ruleLogPolicy= ruleLogPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3446:2: iv_ruleLogPolicy= ruleLogPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLogPolicy_in_entryRuleLogPolicy6978);
            iv_ruleLogPolicy=ruleLogPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLogPolicy6988); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3453:1: ruleLogPolicy returns [EObject current=null] : (otherlv_0= 'logging policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) ) ;
    public final EObject ruleLogPolicy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_logPolicy_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3456:28: ( (otherlv_0= 'logging policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3457:1: (otherlv_0= 'logging policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3457:1: (otherlv_0= 'logging policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3457:3: otherlv_0= 'logging policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) )
            {
            otherlv_0=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleLogPolicy7025); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLogPolicyAccess().getLoggingPolicyKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3461:1: ( (lv_logPolicy_1_0= ruleLogPolicyKind ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3462:1: (lv_logPolicy_1_0= ruleLogPolicyKind )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3462:1: (lv_logPolicy_1_0= ruleLogPolicyKind )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3463:3: lv_logPolicy_1_0= ruleLogPolicyKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogPolicyAccess().getLogPolicyLogPolicyKindEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLogPolicyKind_in_ruleLogPolicy7046);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3487:1: entryRuleSecurityPolicy returns [EObject current=null] : iv_ruleSecurityPolicy= ruleSecurityPolicy EOF ;
    public final EObject entryRuleSecurityPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecurityPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3488:2: (iv_ruleSecurityPolicy= ruleSecurityPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3489:2: iv_ruleSecurityPolicy= ruleSecurityPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSecurityPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSecurityPolicy_in_entryRuleSecurityPolicy7082);
            iv_ruleSecurityPolicy=ruleSecurityPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSecurityPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecurityPolicy7092); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3496:1: ruleSecurityPolicy returns [EObject current=null] : (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | ruleAuthorizationPolicy | ruleSigningPolicy | ruleEncryptionPolicy ) ;
    public final EObject ruleSecurityPolicy() throws RecognitionException {
        EObject current = null;

        EObject this_AuthenticationPolicy_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3499:28: ( (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | ruleAuthorizationPolicy | ruleSigningPolicy | ruleEncryptionPolicy ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3500:1: (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | ruleAuthorizationPolicy | ruleSigningPolicy | ruleEncryptionPolicy )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3500:1: (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | ruleAuthorizationPolicy | ruleSigningPolicy | ruleEncryptionPolicy )
            int alt87=4;
            switch ( input.LA(1) ) {
            case 69:
                {
                alt87=1;
                }
                break;
            case 74:
                {
                alt87=2;
                }
                break;
            case 75:
                {
                alt87=3;
                }
                break;
            case 76:
                {
                alt87=4;
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3501:2: this_AuthenticationPolicy_0= ruleAuthenticationPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityPolicyAccess().getAuthenticationPolicyParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAuthenticationPolicy_in_ruleSecurityPolicy7142);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3514:2: ruleAuthorizationPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityPolicyAccess().getAuthorizationPolicyParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAuthorizationPolicy_in_ruleSecurityPolicy7166);
                    ruleAuthorizationPolicy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3526:2: ruleSigningPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityPolicyAccess().getSigningPolicyParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSigningPolicy_in_ruleSecurityPolicy7190);
                    ruleSigningPolicy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3538:2: ruleEncryptionPolicy
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSecurityPolicyAccess().getEncryptionPolicyParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEncryptionPolicy_in_ruleSecurityPolicy7214);
                    ruleEncryptionPolicy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3556:1: entryRuleAuthenticationPolicy returns [EObject current=null] : iv_ruleAuthenticationPolicy= ruleAuthenticationPolicy EOF ;
    public final EObject entryRuleAuthenticationPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthenticationPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3557:2: (iv_ruleAuthenticationPolicy= ruleAuthenticationPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3558:2: iv_ruleAuthenticationPolicy= ruleAuthenticationPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAuthenticationPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthenticationPolicy_in_entryRuleAuthenticationPolicy7249);
            iv_ruleAuthenticationPolicy=ruleAuthenticationPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAuthenticationPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAuthenticationPolicy7259); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3565:1: ruleAuthenticationPolicy returns [EObject current=null] : (otherlv_0= 'authn policy' ( (lv_name_1_0= RULE_ID ) )? ( (lv_optional_2_0= 'optional' ) )? otherlv_3= '{' otherlv_4= 'auth tokens' otherlv_5= '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ otherlv_7= '}' otherlv_8= 'hash algorithms' otherlv_9= '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* otherlv_11= '}' otherlv_12= '}' ) ;
    public final EObject ruleAuthenticationPolicy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_optional_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_authTokens_6_0 = null;

        EObject lv_hashAlgorithms_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3568:28: ( (otherlv_0= 'authn policy' ( (lv_name_1_0= RULE_ID ) )? ( (lv_optional_2_0= 'optional' ) )? otherlv_3= '{' otherlv_4= 'auth tokens' otherlv_5= '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ otherlv_7= '}' otherlv_8= 'hash algorithms' otherlv_9= '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* otherlv_11= '}' otherlv_12= '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3569:1: (otherlv_0= 'authn policy' ( (lv_name_1_0= RULE_ID ) )? ( (lv_optional_2_0= 'optional' ) )? otherlv_3= '{' otherlv_4= 'auth tokens' otherlv_5= '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ otherlv_7= '}' otherlv_8= 'hash algorithms' otherlv_9= '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* otherlv_11= '}' otherlv_12= '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3569:1: (otherlv_0= 'authn policy' ( (lv_name_1_0= RULE_ID ) )? ( (lv_optional_2_0= 'optional' ) )? otherlv_3= '{' otherlv_4= 'auth tokens' otherlv_5= '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ otherlv_7= '}' otherlv_8= 'hash algorithms' otherlv_9= '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* otherlv_11= '}' otherlv_12= '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3569:3: otherlv_0= 'authn policy' ( (lv_name_1_0= RULE_ID ) )? ( (lv_optional_2_0= 'optional' ) )? otherlv_3= '{' otherlv_4= 'auth tokens' otherlv_5= '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ otherlv_7= '}' otherlv_8= 'hash algorithms' otherlv_9= '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* otherlv_11= '}' otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleAuthenticationPolicy7296); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAuthenticationPolicyAccess().getAuthnPolicyKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3573:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==RULE_ID) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3574:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3574:1: (lv_name_1_0= RULE_ID )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3575:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAuthenticationPolicy7313); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_1_0, grammarAccess.getAuthenticationPolicyAccess().getNameIDTerminalRuleCall_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAuthenticationPolicyRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"ID");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3591:3: ( (lv_optional_2_0= 'optional' ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==70) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3592:1: (lv_optional_2_0= 'optional' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3592:1: (lv_optional_2_0= 'optional' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3593:3: lv_optional_2_0= 'optional'
                    {
                    lv_optional_2_0=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleAuthenticationPolicy7337); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_optional_2_0, grammarAccess.getAuthenticationPolicyAccess().getOptionalOptionalKeyword_2_0());
                          
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

            otherlv_3=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleAuthenticationPolicy7363); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAuthenticationPolicyAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleAuthenticationPolicy7375); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getAuthenticationPolicyAccess().getAuthTokensKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleAuthenticationPolicy7387); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getAuthenticationPolicyAccess().getLeftCurlyBracketKeyword_5());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3618:1: ( (lv_authTokens_6_0= ruleAuthToken ) )+
            int cnt90=0;
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==70||(LA90_0>=135 && LA90_0<=138)) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3619:1: (lv_authTokens_6_0= ruleAuthToken )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3619:1: (lv_authTokens_6_0= ruleAuthToken )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3620:3: lv_authTokens_6_0= ruleAuthToken
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAuthenticationPolicyAccess().getAuthTokensAuthTokenParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAuthToken_in_ruleAuthenticationPolicy7408);
            	    lv_authTokens_6_0=ruleAuthToken();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAuthenticationPolicyRule());
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
            	    if ( cnt90 >= 1 ) break loop90;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(90, input);
                        throw eee;
                }
                cnt90++;
            } while (true);

            otherlv_7=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAuthenticationPolicy7421); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getAuthenticationPolicyAccess().getRightCurlyBracketKeyword_7());
                  
            }
            otherlv_8=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleAuthenticationPolicy7433); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getAuthenticationPolicyAccess().getHashAlgorithmsKeyword_8());
                  
            }
            otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleAuthenticationPolicy7445); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getAuthenticationPolicyAccess().getLeftCurlyBracketKeyword_9());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3648:1: ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==70||LA91_0==73||(LA91_0>=131 && LA91_0<=134)) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3649:1: (lv_hashAlgorithms_10_0= ruleHashAlgorithm )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3649:1: (lv_hashAlgorithms_10_0= ruleHashAlgorithm )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3650:3: lv_hashAlgorithms_10_0= ruleHashAlgorithm
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAuthenticationPolicyAccess().getHashAlgorithmsHashAlgorithmParserRuleCall_10_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleHashAlgorithm_in_ruleAuthenticationPolicy7466);
            	    lv_hashAlgorithms_10_0=ruleHashAlgorithm();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAuthenticationPolicyRule());
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
            	    break loop91;
                }
            } while (true);

            otherlv_11=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAuthenticationPolicy7479); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getAuthenticationPolicyAccess().getRightCurlyBracketKeyword_11());
                  
            }
            otherlv_12=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleAuthenticationPolicy7491); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getAuthenticationPolicyAccess().getRightCurlyBracketKeyword_12());
                  
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3682:1: entryRuleAuthToken returns [EObject current=null] : iv_ruleAuthToken= ruleAuthToken EOF ;
    public final EObject entryRuleAuthToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthToken = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3683:2: (iv_ruleAuthToken= ruleAuthToken EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3684:2: iv_ruleAuthToken= ruleAuthToken EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAuthTokenRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthToken_in_entryRuleAuthToken7527);
            iv_ruleAuthToken=ruleAuthToken();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAuthToken; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAuthToken7537); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3691:1: ruleAuthToken returns [EObject current=null] : ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) ) ;
    public final EObject ruleAuthToken() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Enumerator lv_kind_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3694:28: ( ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3695:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3695:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3695:2: ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3695:2: ( (lv_optional_0_0= 'optional' ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==70) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3696:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3696:1: (lv_optional_0_0= 'optional' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3697:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleAuthToken7580); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3710:3: ( (lv_kind_1_0= ruleAuthTokenKind ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3711:1: (lv_kind_1_0= ruleAuthTokenKind )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3711:1: (lv_kind_1_0= ruleAuthTokenKind )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3712:3: lv_kind_1_0= ruleAuthTokenKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAuthTokenAccess().getKindAuthTokenKindEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthTokenKind_in_ruleAuthToken7615);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3736:1: entryRuleHashAlgorithm returns [EObject current=null] : iv_ruleHashAlgorithm= ruleHashAlgorithm EOF ;
    public final EObject entryRuleHashAlgorithm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHashAlgorithm = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3737:2: (iv_ruleHashAlgorithm= ruleHashAlgorithm EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3738:2: iv_ruleHashAlgorithm= ruleHashAlgorithm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHashAlgorithmRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleHashAlgorithm_in_entryRuleHashAlgorithm7651);
            iv_ruleHashAlgorithm=ruleHashAlgorithm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHashAlgorithm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHashAlgorithm7661); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3745:1: ruleHashAlgorithm returns [EObject current=null] : ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) ) ;
    public final EObject ruleHashAlgorithm() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Token lv_useBase64_1_0=null;
        Enumerator lv_kind_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3748:28: ( ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3749:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3749:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3749:2: ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3749:2: ( (lv_optional_0_0= 'optional' ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==70) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3750:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3750:1: (lv_optional_0_0= 'optional' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3751:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleHashAlgorithm7704); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3764:3: ( (lv_useBase64_1_0= 'Base64-encoded' ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==73) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3765:1: (lv_useBase64_1_0= 'Base64-encoded' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3765:1: (lv_useBase64_1_0= 'Base64-encoded' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3766:3: lv_useBase64_1_0= 'Base64-encoded'
                    {
                    lv_useBase64_1_0=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleHashAlgorithm7736); if (state.failed) return current;
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

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3779:3: ( (lv_kind_2_0= ruleHashAlgKind ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3780:1: (lv_kind_2_0= ruleHashAlgKind )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3780:1: (lv_kind_2_0= ruleHashAlgKind )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3781:3: lv_kind_2_0= ruleHashAlgKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getHashAlgorithmAccess().getKindHashAlgKindEnumRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleHashAlgKind_in_ruleHashAlgorithm7771);
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3805:1: entryRuleAuthorizationPolicy returns [String current=null] : iv_ruleAuthorizationPolicy= ruleAuthorizationPolicy EOF ;
    public final String entryRuleAuthorizationPolicy() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAuthorizationPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3806:2: (iv_ruleAuthorizationPolicy= ruleAuthorizationPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3807:2: iv_ruleAuthorizationPolicy= ruleAuthorizationPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAuthorizationPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthorizationPolicy_in_entryRuleAuthorizationPolicy7808);
            iv_ruleAuthorizationPolicy=ruleAuthorizationPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAuthorizationPolicy.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAuthorizationPolicy7819); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3814:1: ruleAuthorizationPolicy returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'authorization rolicy' ;
    public final AntlrDatatypeRuleToken ruleAuthorizationPolicy() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3817:28: (kw= 'authorization rolicy' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3819:2: kw= 'authorization rolicy'
            {
            kw=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleAuthorizationPolicy7856); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getAuthorizationPolicyAccess().getAuthorizationRolicyKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3832:1: entryRuleSigningPolicy returns [String current=null] : iv_ruleSigningPolicy= ruleSigningPolicy EOF ;
    public final String entryRuleSigningPolicy() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSigningPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3833:2: (iv_ruleSigningPolicy= ruleSigningPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3834:2: iv_ruleSigningPolicy= ruleSigningPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSigningPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSigningPolicy_in_entryRuleSigningPolicy7896);
            iv_ruleSigningPolicy=ruleSigningPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSigningPolicy.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSigningPolicy7907); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3841:1: ruleSigningPolicy returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'signing policy' ;
    public final AntlrDatatypeRuleToken ruleSigningPolicy() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3844:28: (kw= 'signing policy' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3846:2: kw= 'signing policy'
            {
            kw=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleSigningPolicy7944); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getSigningPolicyAccess().getSigningPolicyKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3859:1: entryRuleEncryptionPolicy returns [String current=null] : iv_ruleEncryptionPolicy= ruleEncryptionPolicy EOF ;
    public final String entryRuleEncryptionPolicy() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEncryptionPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3860:2: (iv_ruleEncryptionPolicy= ruleEncryptionPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3861:2: iv_ruleEncryptionPolicy= ruleEncryptionPolicy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEncryptionPolicyRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEncryptionPolicy_in_entryRuleEncryptionPolicy7984);
            iv_ruleEncryptionPolicy=ruleEncryptionPolicy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEncryptionPolicy.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEncryptionPolicy7995); if (state.failed) return current;

            }

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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3868:1: ruleEncryptionPolicy returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'encryption policy' ;
    public final AntlrDatatypeRuleToken ruleEncryptionPolicy() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3871:28: (kw= 'encryption policy' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3873:2: kw= 'encryption policy'
            {
            kw=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleEncryptionPolicy8032); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getEncryptionPolicyAccess().getEncryptionPolicyKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
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


    // $ANTLR start "entryRuleImport"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3886:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3890:2: (iv_ruleImport= ruleImport EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3891:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport8077);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport8087); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3901:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3905:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3906:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3906:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3906:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {
            otherlv_0=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleImport8128); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3910:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3911:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3911:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3912:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport8149);
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleVersionId"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3939:1: entryRuleVersionId returns [String current=null] : iv_ruleVersionId= ruleVersionId EOF ;
    public final String entryRuleVersionId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionId = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3943:2: (iv_ruleVersionId= ruleVersionId EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3944:2: iv_ruleVersionId= ruleVersionId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionIdRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_entryRuleVersionId8196);
            iv_ruleVersionId=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionId.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionId8207); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleVersionId"


    // $ANTLR start "ruleVersionId"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3954:1: ruleVersionId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ) ;
    public final AntlrDatatypeRuleToken ruleVersionId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3958:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3959:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3959:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3959:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )*
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId8251); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3966:1: (kw= '.' this_INT_2= RULE_INT )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==78) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3967:2: kw= '.' this_INT_2= RULE_INT
            	    {
            	    kw=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleVersionId8270); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId8285); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_INT_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_INT_2, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_1_1()); 
            	          
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleVersionId"


    // $ANTLR start "entryRuleVersionRef"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3994:1: entryRuleVersionRef returns [EObject current=null] : iv_ruleVersionRef= ruleVersionRef EOF ;
    public final EObject entryRuleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionRef = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3998:2: (iv_ruleVersionRef= ruleVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3999:2: iv_ruleVersionRef= ruleVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_entryRuleVersionRef8346);
            iv_ruleVersionRef=ruleVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionRef8356); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleVersionRef"


    // $ANTLR start "ruleVersionRef"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4009:1: ruleVersionRef returns [EObject current=null] : (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) ;
    public final EObject ruleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject this_MinVersionRef_0 = null;

        EObject this_MaxVersionRef_1 = null;

        EObject this_LowerBoundRangeVersionRef_2 = null;

        EObject this_MajorVersionRef_3 = null;

        EObject this_FixedVersionRef_4 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4013:28: ( (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4014:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4014:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            int alt96=5;
            switch ( input.LA(1) ) {
            case 79:
                {
                int LA96_1 = input.LA(2);

                if ( (LA96_1==81) ) {
                    alt96=3;
                }
                else if ( (LA96_1==RULE_INT) ) {
                    alt96=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 96, 1, input);

                    throw nvae;
                }
                }
                break;
            case 80:
                {
                alt96=2;
                }
                break;
            case 83:
                {
                alt96=4;
                }
                break;
            case 84:
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4015:2: this_MinVersionRef_0= ruleMinVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMinVersionRefParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_ruleVersionRef8410);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4028:2: this_MaxVersionRef_1= ruleMaxVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMaxVersionRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_ruleVersionRef8440);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4041:2: this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getLowerBoundRangeVersionRefParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef8470);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4054:2: this_MajorVersionRef_3= ruleMajorVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMajorVersionRefParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_ruleVersionRef8500);
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4067:2: this_FixedVersionRef_4= ruleFixedVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getFixedVersionRefParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_ruleVersionRef8530);
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleVersionRef"


    // $ANTLR start "entryRuleMinVersionRef"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4089:1: entryRuleMinVersionRef returns [EObject current=null] : iv_ruleMinVersionRef= ruleMinVersionRef EOF ;
    public final EObject entryRuleMinVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinVersionRef = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4093:2: (iv_ruleMinVersionRef= ruleMinVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4094:2: iv_ruleMinVersionRef= ruleMinVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMinVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef8575);
            iv_ruleMinVersionRef=ruleMinVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMinVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMinVersionRef8585); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleMinVersionRef"


    // $ANTLR start "ruleMinVersionRef"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4104:1: ruleMinVersionRef returns [EObject current=null] : (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMinVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_minVersion_1_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4108:28: ( (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4109:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4109:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4109:3: otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleMinVersionRef8626); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMinVersionRefAccess().getMinVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4113:1: ( (lv_minVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4114:1: (lv_minVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4114:1: (lv_minVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4115:3: lv_minVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMinVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMinVersionRef8647);
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleMinVersionRef"


    // $ANTLR start "entryRuleMaxVersionRef"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4142:1: entryRuleMaxVersionRef returns [EObject current=null] : iv_ruleMaxVersionRef= ruleMaxVersionRef EOF ;
    public final EObject entryRuleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxVersionRef = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4146:2: (iv_ruleMaxVersionRef= ruleMaxVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4147:2: iv_ruleMaxVersionRef= ruleMaxVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMaxVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef8693);
            iv_ruleMaxVersionRef=ruleMaxVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMaxVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxVersionRef8703); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleMaxVersionRef"


    // $ANTLR start "ruleMaxVersionRef"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4157:1: ruleMaxVersionRef returns [EObject current=null] : (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_maxVersion_1_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4161:28: ( (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4162:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4162:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4162:3: otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleMaxVersionRef8744); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMaxVersionRefAccess().getMaxVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4166:1: ( (lv_maxVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4167:1: (lv_maxVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4167:1: (lv_maxVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4168:3: lv_maxVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMaxVersionRefAccess().getMaxVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMaxVersionRef8765);
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleMaxVersionRef"


    // $ANTLR start "entryRuleLowerBoundRangeVersionRef"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4195:1: entryRuleLowerBoundRangeVersionRef returns [EObject current=null] : iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF ;
    public final EObject entryRuleLowerBoundRangeVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerBoundRangeVersionRef = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4199:2: (iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4200:2: iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef8811);
            iv_ruleLowerBoundRangeVersionRef=ruleLowerBoundRangeVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLowerBoundRangeVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef8821); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleLowerBoundRangeVersionRef"


    // $ANTLR start "ruleLowerBoundRangeVersionRef"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4210:1: ruleLowerBoundRangeVersionRef returns [EObject current=null] : ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) ;
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
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4214:28: ( ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4215:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4215:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4215:2: (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4215:2: (otherlv_0= 'minVersion' otherlv_1= '>=' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4215:4: otherlv_0= 'minVersion' otherlv_1= '>='
            {
            otherlv_0=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleLowerBoundRangeVersionRef8863); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionKeyword_0_0());
                  
            }
            otherlv_1=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleLowerBoundRangeVersionRef8875); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLowerBoundRangeVersionRefAccess().getGreaterThanSignEqualsSignKeyword_0_1());
                  
            }

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4223:2: ( (lv_minVersion_2_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4224:1: (lv_minVersion_2_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4224:1: (lv_minVersion_2_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4225:3: lv_minVersion_2_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef8897);
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

            otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleLowerBoundRangeVersionRef8909); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLowerBoundRangeVersionRefAccess().getCommaKeyword_2());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4245:1: (otherlv_4= 'maxVersion' otherlv_5= '<' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4245:3: otherlv_4= 'maxVersion' otherlv_5= '<'
            {
            otherlv_4=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleLowerBoundRangeVersionRef8922); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionKeyword_3_0());
                  
            }
            otherlv_5=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleLowerBoundRangeVersionRef8934); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLowerBoundRangeVersionRefAccess().getLessThanSignKeyword_3_1());
                  
            }

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4253:2: ( (lv_maxVersion_6_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4254:1: (lv_maxVersion_6_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4254:1: (lv_maxVersion_6_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4255:3: lv_maxVersion_6_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionVersionIdParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef8956);
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleLowerBoundRangeVersionRef"


    // $ANTLR start "entryRuleMajorVersionRef"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4282:1: entryRuleMajorVersionRef returns [EObject current=null] : iv_ruleMajorVersionRef= ruleMajorVersionRef EOF ;
    public final EObject entryRuleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMajorVersionRef = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4286:2: (iv_ruleMajorVersionRef= ruleMajorVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4287:2: iv_ruleMajorVersionRef= ruleMajorVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMajorVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef9002);
            iv_ruleMajorVersionRef=ruleMajorVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMajorVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMajorVersionRef9012); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleMajorVersionRef"


    // $ANTLR start "ruleMajorVersionRef"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4297:1: ruleMajorVersionRef returns [EObject current=null] : (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) ;
    public final EObject ruleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_majorVersion_1_0=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4301:28: ( (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4302:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4302:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4302:3: otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleMajorVersionRef9053); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMajorVersionRefAccess().getMajorVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4306:1: ( (lv_majorVersion_1_0= RULE_INT ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4307:1: (lv_majorVersion_1_0= RULE_INT )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4307:1: (lv_majorVersion_1_0= RULE_INT )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4308:3: lv_majorVersion_1_0= RULE_INT
            {
            lv_majorVersion_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMajorVersionRef9070); if (state.failed) return current;
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleMajorVersionRef"


    // $ANTLR start "entryRuleFixedVersionRef"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4335:1: entryRuleFixedVersionRef returns [EObject current=null] : iv_ruleFixedVersionRef= ruleFixedVersionRef EOF ;
    public final EObject entryRuleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedVersionRef = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4339:2: (iv_ruleFixedVersionRef= ruleFixedVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4340:2: iv_ruleFixedVersionRef= ruleFixedVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFixedVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef9121);
            iv_ruleFixedVersionRef=ruleFixedVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFixedVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFixedVersionRef9131); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleFixedVersionRef"


    // $ANTLR start "ruleFixedVersionRef"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4350:1: ruleFixedVersionRef returns [EObject current=null] : (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_fixedVersion_1_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4354:28: ( (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4355:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4355:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4355:3: otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,84,FollowSets000.FOLLOW_84_in_ruleFixedVersionRef9172); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFixedVersionRefAccess().getFixedVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4359:1: ( (lv_fixedVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4360:1: (lv_fixedVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4360:1: (lv_fixedVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4361:3: lv_fixedVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFixedVersionRefAccess().getFixedVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleFixedVersionRef9193);
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleFixedVersionRef"


    // $ANTLR start "entryRuleQualifiedNameWithWildCard"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4388:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4392:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4393:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard9240);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard9251); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildCard"


    // $ANTLR start "ruleQualifiedNameWithWildCard"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4403:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4407:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4408:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4408:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4409:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard9302);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4419:1: (kw= '.*' )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==85) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4420:2: kw= '.*'
                    {
                    kw=(Token)match(input,85,FollowSets000.FOLLOW_85_in_ruleQualifiedNameWithWildCard9321); if (state.failed) return current;
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameWithWildCard"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4436:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4440:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4441:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName9374);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName9385); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4451:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4455:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4456:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4456:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4456:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName9429); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4463:1: (kw= '.' this_ID_2= RULE_ID )*
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==78) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4464:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleQualifiedName9448); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName9463); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop98;
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "ruleImplementationType"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4489:1: ruleImplementationType returns [Enumerator current=null] : ( (enumLiteral_0= 'BPMN' ) | (enumLiteral_1= 'BPMN2' ) | (enumLiteral_2= 'BPEL' ) | (enumLiteral_3= 'WS-HT' ) | (enumLiteral_4= 'RuleML' ) | (enumLiteral_5= 'Drools' ) | (enumLiteral_6= 'Mediation' ) | (enumLiteral_7= 'Java' ) | (enumLiteral_8= 'C#' ) | (enumLiteral_9= 'C++' ) | (enumLiteral_10= 'Scala' ) | (enumLiteral_11= 'Ruby' ) | (enumLiteral_12= 'PHP' ) | (enumLiteral_13= 'WS-Document/Literal' ) | (enumLiteral_14= 'WS-RPC/Literal' ) | (enumLiteral_15= 'WS-RPC/Encoded' ) | (enumLiteral_16= 'REST-XML' ) | (enumLiteral_17= 'REST-JSON' ) | (enumLiteral_18= 'EJB' ) | (enumLiteral_19= 'Spring' ) | (enumLiteral_20= 'EJB2' ) | (enumLiteral_21= 'SAP' ) | (enumLiteral_22= 'SAP/iDoc' ) | (enumLiteral_23= 'SAP/BAPI' ) | (enumLiteral_24= 'Corba' ) | (enumLiteral_25= 'Shell' ) | (enumLiteral_26= 'Siebel' ) | (enumLiteral_27= 'Tuxedo' ) | (enumLiteral_28= 'File' ) | (enumLiteral_29= 'SQL' ) | (enumLiteral_30= 'Ivy' ) | (enumLiteral_31= 'jPDL3' ) | (enumLiteral_32= 'jPDL4' ) ) ;
    public final Enumerator ruleImplementationType() throws RecognitionException {
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
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;
        Token enumLiteral_16=null;
        Token enumLiteral_17=null;
        Token enumLiteral_18=null;
        Token enumLiteral_19=null;
        Token enumLiteral_20=null;
        Token enumLiteral_21=null;
        Token enumLiteral_22=null;
        Token enumLiteral_23=null;
        Token enumLiteral_24=null;
        Token enumLiteral_25=null;
        Token enumLiteral_26=null;
        Token enumLiteral_27=null;
        Token enumLiteral_28=null;
        Token enumLiteral_29=null;
        Token enumLiteral_30=null;
        Token enumLiteral_31=null;
        Token enumLiteral_32=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4491:28: ( ( (enumLiteral_0= 'BPMN' ) | (enumLiteral_1= 'BPMN2' ) | (enumLiteral_2= 'BPEL' ) | (enumLiteral_3= 'WS-HT' ) | (enumLiteral_4= 'RuleML' ) | (enumLiteral_5= 'Drools' ) | (enumLiteral_6= 'Mediation' ) | (enumLiteral_7= 'Java' ) | (enumLiteral_8= 'C#' ) | (enumLiteral_9= 'C++' ) | (enumLiteral_10= 'Scala' ) | (enumLiteral_11= 'Ruby' ) | (enumLiteral_12= 'PHP' ) | (enumLiteral_13= 'WS-Document/Literal' ) | (enumLiteral_14= 'WS-RPC/Literal' ) | (enumLiteral_15= 'WS-RPC/Encoded' ) | (enumLiteral_16= 'REST-XML' ) | (enumLiteral_17= 'REST-JSON' ) | (enumLiteral_18= 'EJB' ) | (enumLiteral_19= 'Spring' ) | (enumLiteral_20= 'EJB2' ) | (enumLiteral_21= 'SAP' ) | (enumLiteral_22= 'SAP/iDoc' ) | (enumLiteral_23= 'SAP/BAPI' ) | (enumLiteral_24= 'Corba' ) | (enumLiteral_25= 'Shell' ) | (enumLiteral_26= 'Siebel' ) | (enumLiteral_27= 'Tuxedo' ) | (enumLiteral_28= 'File' ) | (enumLiteral_29= 'SQL' ) | (enumLiteral_30= 'Ivy' ) | (enumLiteral_31= 'jPDL3' ) | (enumLiteral_32= 'jPDL4' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4492:1: ( (enumLiteral_0= 'BPMN' ) | (enumLiteral_1= 'BPMN2' ) | (enumLiteral_2= 'BPEL' ) | (enumLiteral_3= 'WS-HT' ) | (enumLiteral_4= 'RuleML' ) | (enumLiteral_5= 'Drools' ) | (enumLiteral_6= 'Mediation' ) | (enumLiteral_7= 'Java' ) | (enumLiteral_8= 'C#' ) | (enumLiteral_9= 'C++' ) | (enumLiteral_10= 'Scala' ) | (enumLiteral_11= 'Ruby' ) | (enumLiteral_12= 'PHP' ) | (enumLiteral_13= 'WS-Document/Literal' ) | (enumLiteral_14= 'WS-RPC/Literal' ) | (enumLiteral_15= 'WS-RPC/Encoded' ) | (enumLiteral_16= 'REST-XML' ) | (enumLiteral_17= 'REST-JSON' ) | (enumLiteral_18= 'EJB' ) | (enumLiteral_19= 'Spring' ) | (enumLiteral_20= 'EJB2' ) | (enumLiteral_21= 'SAP' ) | (enumLiteral_22= 'SAP/iDoc' ) | (enumLiteral_23= 'SAP/BAPI' ) | (enumLiteral_24= 'Corba' ) | (enumLiteral_25= 'Shell' ) | (enumLiteral_26= 'Siebel' ) | (enumLiteral_27= 'Tuxedo' ) | (enumLiteral_28= 'File' ) | (enumLiteral_29= 'SQL' ) | (enumLiteral_30= 'Ivy' ) | (enumLiteral_31= 'jPDL3' ) | (enumLiteral_32= 'jPDL4' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4492:1: ( (enumLiteral_0= 'BPMN' ) | (enumLiteral_1= 'BPMN2' ) | (enumLiteral_2= 'BPEL' ) | (enumLiteral_3= 'WS-HT' ) | (enumLiteral_4= 'RuleML' ) | (enumLiteral_5= 'Drools' ) | (enumLiteral_6= 'Mediation' ) | (enumLiteral_7= 'Java' ) | (enumLiteral_8= 'C#' ) | (enumLiteral_9= 'C++' ) | (enumLiteral_10= 'Scala' ) | (enumLiteral_11= 'Ruby' ) | (enumLiteral_12= 'PHP' ) | (enumLiteral_13= 'WS-Document/Literal' ) | (enumLiteral_14= 'WS-RPC/Literal' ) | (enumLiteral_15= 'WS-RPC/Encoded' ) | (enumLiteral_16= 'REST-XML' ) | (enumLiteral_17= 'REST-JSON' ) | (enumLiteral_18= 'EJB' ) | (enumLiteral_19= 'Spring' ) | (enumLiteral_20= 'EJB2' ) | (enumLiteral_21= 'SAP' ) | (enumLiteral_22= 'SAP/iDoc' ) | (enumLiteral_23= 'SAP/BAPI' ) | (enumLiteral_24= 'Corba' ) | (enumLiteral_25= 'Shell' ) | (enumLiteral_26= 'Siebel' ) | (enumLiteral_27= 'Tuxedo' ) | (enumLiteral_28= 'File' ) | (enumLiteral_29= 'SQL' ) | (enumLiteral_30= 'Ivy' ) | (enumLiteral_31= 'jPDL3' ) | (enumLiteral_32= 'jPDL4' ) )
            int alt99=33;
            switch ( input.LA(1) ) {
            case 86:
                {
                alt99=1;
                }
                break;
            case 87:
                {
                alt99=2;
                }
                break;
            case 88:
                {
                alt99=3;
                }
                break;
            case 89:
                {
                alt99=4;
                }
                break;
            case 90:
                {
                alt99=5;
                }
                break;
            case 91:
                {
                alt99=6;
                }
                break;
            case 92:
                {
                alt99=7;
                }
                break;
            case 93:
                {
                alt99=8;
                }
                break;
            case 94:
                {
                alt99=9;
                }
                break;
            case 95:
                {
                alt99=10;
                }
                break;
            case 96:
                {
                alt99=11;
                }
                break;
            case 97:
                {
                alt99=12;
                }
                break;
            case 98:
                {
                alt99=13;
                }
                break;
            case 99:
                {
                alt99=14;
                }
                break;
            case 100:
                {
                alt99=15;
                }
                break;
            case 101:
                {
                alt99=16;
                }
                break;
            case 102:
                {
                alt99=17;
                }
                break;
            case 103:
                {
                alt99=18;
                }
                break;
            case 48:
                {
                alt99=19;
                }
                break;
            case 104:
                {
                alt99=20;
                }
                break;
            case 105:
                {
                alt99=21;
                }
                break;
            case 45:
                {
                alt99=22;
                }
                break;
            case 106:
                {
                alt99=23;
                }
                break;
            case 107:
                {
                alt99=24;
                }
                break;
            case 108:
                {
                alt99=25;
                }
                break;
            case 109:
                {
                alt99=26;
                }
                break;
            case 110:
                {
                alt99=27;
                }
                break;
            case 111:
                {
                alt99=28;
                }
                break;
            case 112:
                {
                alt99=29;
                }
                break;
            case 113:
                {
                alt99=30;
                }
                break;
            case 114:
                {
                alt99=31;
                }
                break;
            case 115:
                {
                alt99=32;
                }
                break;
            case 116:
                {
                alt99=33;
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4492:2: (enumLiteral_0= 'BPMN' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4492:2: (enumLiteral_0= 'BPMN' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4492:4: enumLiteral_0= 'BPMN'
                    {
                    enumLiteral_0=(Token)match(input,86,FollowSets000.FOLLOW_86_in_ruleImplementationType9530); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getBPMNEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getImplementationTypeAccess().getBPMNEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4498:6: (enumLiteral_1= 'BPMN2' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4498:6: (enumLiteral_1= 'BPMN2' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4498:8: enumLiteral_1= 'BPMN2'
                    {
                    enumLiteral_1=(Token)match(input,87,FollowSets000.FOLLOW_87_in_ruleImplementationType9547); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getBPMN2EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getImplementationTypeAccess().getBPMN2EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4504:6: (enumLiteral_2= 'BPEL' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4504:6: (enumLiteral_2= 'BPEL' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4504:8: enumLiteral_2= 'BPEL'
                    {
                    enumLiteral_2=(Token)match(input,88,FollowSets000.FOLLOW_88_in_ruleImplementationType9564); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getBPELEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getImplementationTypeAccess().getBPELEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4510:6: (enumLiteral_3= 'WS-HT' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4510:6: (enumLiteral_3= 'WS-HT' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4510:8: enumLiteral_3= 'WS-HT'
                    {
                    enumLiteral_3=(Token)match(input,89,FollowSets000.FOLLOW_89_in_ruleImplementationType9581); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getWSHTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getImplementationTypeAccess().getWSHTEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4516:6: (enumLiteral_4= 'RuleML' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4516:6: (enumLiteral_4= 'RuleML' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4516:8: enumLiteral_4= 'RuleML'
                    {
                    enumLiteral_4=(Token)match(input,90,FollowSets000.FOLLOW_90_in_ruleImplementationType9598); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getRuleMLEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getImplementationTypeAccess().getRuleMLEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4522:6: (enumLiteral_5= 'Drools' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4522:6: (enumLiteral_5= 'Drools' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4522:8: enumLiteral_5= 'Drools'
                    {
                    enumLiteral_5=(Token)match(input,91,FollowSets000.FOLLOW_91_in_ruleImplementationType9615); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getDroolsEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getImplementationTypeAccess().getDroolsEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4528:6: (enumLiteral_6= 'Mediation' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4528:6: (enumLiteral_6= 'Mediation' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4528:8: enumLiteral_6= 'Mediation'
                    {
                    enumLiteral_6=(Token)match(input,92,FollowSets000.FOLLOW_92_in_ruleImplementationType9632); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getMediationEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getImplementationTypeAccess().getMediationEnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4534:6: (enumLiteral_7= 'Java' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4534:6: (enumLiteral_7= 'Java' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4534:8: enumLiteral_7= 'Java'
                    {
                    enumLiteral_7=(Token)match(input,93,FollowSets000.FOLLOW_93_in_ruleImplementationType9649); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getJavaEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_7, grammarAccess.getImplementationTypeAccess().getJavaEnumLiteralDeclaration_7()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4540:6: (enumLiteral_8= 'C#' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4540:6: (enumLiteral_8= 'C#' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4540:8: enumLiteral_8= 'C#'
                    {
                    enumLiteral_8=(Token)match(input,94,FollowSets000.FOLLOW_94_in_ruleImplementationType9666); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getCSEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_8, grammarAccess.getImplementationTypeAccess().getCSEnumLiteralDeclaration_8()); 
                          
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4546:6: (enumLiteral_9= 'C++' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4546:6: (enumLiteral_9= 'C++' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4546:8: enumLiteral_9= 'C++'
                    {
                    enumLiteral_9=(Token)match(input,95,FollowSets000.FOLLOW_95_in_ruleImplementationType9683); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getCPPEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_9, grammarAccess.getImplementationTypeAccess().getCPPEnumLiteralDeclaration_9()); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4552:6: (enumLiteral_10= 'Scala' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4552:6: (enumLiteral_10= 'Scala' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4552:8: enumLiteral_10= 'Scala'
                    {
                    enumLiteral_10=(Token)match(input,96,FollowSets000.FOLLOW_96_in_ruleImplementationType9700); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getScalaEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_10, grammarAccess.getImplementationTypeAccess().getScalaEnumLiteralDeclaration_10()); 
                          
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4558:6: (enumLiteral_11= 'Ruby' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4558:6: (enumLiteral_11= 'Ruby' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4558:8: enumLiteral_11= 'Ruby'
                    {
                    enumLiteral_11=(Token)match(input,97,FollowSets000.FOLLOW_97_in_ruleImplementationType9717); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getRubyEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_11, grammarAccess.getImplementationTypeAccess().getRubyEnumLiteralDeclaration_11()); 
                          
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4564:6: (enumLiteral_12= 'PHP' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4564:6: (enumLiteral_12= 'PHP' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4564:8: enumLiteral_12= 'PHP'
                    {
                    enumLiteral_12=(Token)match(input,98,FollowSets000.FOLLOW_98_in_ruleImplementationType9734); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getPHPEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_12, grammarAccess.getImplementationTypeAccess().getPHPEnumLiteralDeclaration_12()); 
                          
                    }

                    }


                    }
                    break;
                case 14 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4570:6: (enumLiteral_13= 'WS-Document/Literal' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4570:6: (enumLiteral_13= 'WS-Document/Literal' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4570:8: enumLiteral_13= 'WS-Document/Literal'
                    {
                    enumLiteral_13=(Token)match(input,99,FollowSets000.FOLLOW_99_in_ruleImplementationType9751); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getWSDocLitEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_13, grammarAccess.getImplementationTypeAccess().getWSDocLitEnumLiteralDeclaration_13()); 
                          
                    }

                    }


                    }
                    break;
                case 15 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4576:6: (enumLiteral_14= 'WS-RPC/Literal' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4576:6: (enumLiteral_14= 'WS-RPC/Literal' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4576:8: enumLiteral_14= 'WS-RPC/Literal'
                    {
                    enumLiteral_14=(Token)match(input,100,FollowSets000.FOLLOW_100_in_ruleImplementationType9768); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getWSRPCEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_14, grammarAccess.getImplementationTypeAccess().getWSRPCEnumLiteralDeclaration_14()); 
                          
                    }

                    }


                    }
                    break;
                case 16 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4582:6: (enumLiteral_15= 'WS-RPC/Encoded' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4582:6: (enumLiteral_15= 'WS-RPC/Encoded' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4582:8: enumLiteral_15= 'WS-RPC/Encoded'
                    {
                    enumLiteral_15=(Token)match(input,101,FollowSets000.FOLLOW_101_in_ruleImplementationType9785); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getWSRPCEncEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_15, grammarAccess.getImplementationTypeAccess().getWSRPCEncEnumLiteralDeclaration_15()); 
                          
                    }

                    }


                    }
                    break;
                case 17 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4588:6: (enumLiteral_16= 'REST-XML' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4588:6: (enumLiteral_16= 'REST-XML' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4588:8: enumLiteral_16= 'REST-XML'
                    {
                    enumLiteral_16=(Token)match(input,102,FollowSets000.FOLLOW_102_in_ruleImplementationType9802); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getREST_XMLEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_16, grammarAccess.getImplementationTypeAccess().getREST_XMLEnumLiteralDeclaration_16()); 
                          
                    }

                    }


                    }
                    break;
                case 18 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4594:6: (enumLiteral_17= 'REST-JSON' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4594:6: (enumLiteral_17= 'REST-JSON' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4594:8: enumLiteral_17= 'REST-JSON'
                    {
                    enumLiteral_17=(Token)match(input,103,FollowSets000.FOLLOW_103_in_ruleImplementationType9819); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getREST_JSONEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_17, grammarAccess.getImplementationTypeAccess().getREST_JSONEnumLiteralDeclaration_17()); 
                          
                    }

                    }


                    }
                    break;
                case 19 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4600:6: (enumLiteral_18= 'EJB' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4600:6: (enumLiteral_18= 'EJB' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4600:8: enumLiteral_18= 'EJB'
                    {
                    enumLiteral_18=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleImplementationType9836); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getEJBEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_18, grammarAccess.getImplementationTypeAccess().getEJBEnumLiteralDeclaration_18()); 
                          
                    }

                    }


                    }
                    break;
                case 20 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4606:6: (enumLiteral_19= 'Spring' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4606:6: (enumLiteral_19= 'Spring' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4606:8: enumLiteral_19= 'Spring'
                    {
                    enumLiteral_19=(Token)match(input,104,FollowSets000.FOLLOW_104_in_ruleImplementationType9853); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getSpringEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_19, grammarAccess.getImplementationTypeAccess().getSpringEnumLiteralDeclaration_19()); 
                          
                    }

                    }


                    }
                    break;
                case 21 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4612:6: (enumLiteral_20= 'EJB2' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4612:6: (enumLiteral_20= 'EJB2' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4612:8: enumLiteral_20= 'EJB2'
                    {
                    enumLiteral_20=(Token)match(input,105,FollowSets000.FOLLOW_105_in_ruleImplementationType9870); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getEJB2EnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_20, grammarAccess.getImplementationTypeAccess().getEJB2EnumLiteralDeclaration_20()); 
                          
                    }

                    }


                    }
                    break;
                case 22 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4618:6: (enumLiteral_21= 'SAP' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4618:6: (enumLiteral_21= 'SAP' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4618:8: enumLiteral_21= 'SAP'
                    {
                    enumLiteral_21=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleImplementationType9887); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getSAPEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_21, grammarAccess.getImplementationTypeAccess().getSAPEnumLiteralDeclaration_21()); 
                          
                    }

                    }


                    }
                    break;
                case 23 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4624:6: (enumLiteral_22= 'SAP/iDoc' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4624:6: (enumLiteral_22= 'SAP/iDoc' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4624:8: enumLiteral_22= 'SAP/iDoc'
                    {
                    enumLiteral_22=(Token)match(input,106,FollowSets000.FOLLOW_106_in_ruleImplementationType9904); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getSAP_IDOCEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_22, grammarAccess.getImplementationTypeAccess().getSAP_IDOCEnumLiteralDeclaration_22()); 
                          
                    }

                    }


                    }
                    break;
                case 24 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4630:6: (enumLiteral_23= 'SAP/BAPI' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4630:6: (enumLiteral_23= 'SAP/BAPI' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4630:8: enumLiteral_23= 'SAP/BAPI'
                    {
                    enumLiteral_23=(Token)match(input,107,FollowSets000.FOLLOW_107_in_ruleImplementationType9921); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getSAP_BAPIEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_23, grammarAccess.getImplementationTypeAccess().getSAP_BAPIEnumLiteralDeclaration_23()); 
                          
                    }

                    }


                    }
                    break;
                case 25 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4636:6: (enumLiteral_24= 'Corba' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4636:6: (enumLiteral_24= 'Corba' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4636:8: enumLiteral_24= 'Corba'
                    {
                    enumLiteral_24=(Token)match(input,108,FollowSets000.FOLLOW_108_in_ruleImplementationType9938); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getCorbaEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_24, grammarAccess.getImplementationTypeAccess().getCorbaEnumLiteralDeclaration_24()); 
                          
                    }

                    }


                    }
                    break;
                case 26 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4642:6: (enumLiteral_25= 'Shell' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4642:6: (enumLiteral_25= 'Shell' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4642:8: enumLiteral_25= 'Shell'
                    {
                    enumLiteral_25=(Token)match(input,109,FollowSets000.FOLLOW_109_in_ruleImplementationType9955); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getShellEnumLiteralDeclaration_25().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_25, grammarAccess.getImplementationTypeAccess().getShellEnumLiteralDeclaration_25()); 
                          
                    }

                    }


                    }
                    break;
                case 27 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4648:6: (enumLiteral_26= 'Siebel' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4648:6: (enumLiteral_26= 'Siebel' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4648:8: enumLiteral_26= 'Siebel'
                    {
                    enumLiteral_26=(Token)match(input,110,FollowSets000.FOLLOW_110_in_ruleImplementationType9972); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getSiebelEnumLiteralDeclaration_26().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_26, grammarAccess.getImplementationTypeAccess().getSiebelEnumLiteralDeclaration_26()); 
                          
                    }

                    }


                    }
                    break;
                case 28 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4654:6: (enumLiteral_27= 'Tuxedo' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4654:6: (enumLiteral_27= 'Tuxedo' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4654:8: enumLiteral_27= 'Tuxedo'
                    {
                    enumLiteral_27=(Token)match(input,111,FollowSets000.FOLLOW_111_in_ruleImplementationType9989); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getTuxedoEnumLiteralDeclaration_27().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_27, grammarAccess.getImplementationTypeAccess().getTuxedoEnumLiteralDeclaration_27()); 
                          
                    }

                    }


                    }
                    break;
                case 29 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4660:6: (enumLiteral_28= 'File' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4660:6: (enumLiteral_28= 'File' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4660:8: enumLiteral_28= 'File'
                    {
                    enumLiteral_28=(Token)match(input,112,FollowSets000.FOLLOW_112_in_ruleImplementationType10006); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getFileEnumLiteralDeclaration_28().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_28, grammarAccess.getImplementationTypeAccess().getFileEnumLiteralDeclaration_28()); 
                          
                    }

                    }


                    }
                    break;
                case 30 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4666:6: (enumLiteral_29= 'SQL' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4666:6: (enumLiteral_29= 'SQL' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4666:8: enumLiteral_29= 'SQL'
                    {
                    enumLiteral_29=(Token)match(input,113,FollowSets000.FOLLOW_113_in_ruleImplementationType10023); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getSQLEnumLiteralDeclaration_29().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_29, grammarAccess.getImplementationTypeAccess().getSQLEnumLiteralDeclaration_29()); 
                          
                    }

                    }


                    }
                    break;
                case 31 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4672:6: (enumLiteral_30= 'Ivy' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4672:6: (enumLiteral_30= 'Ivy' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4672:8: enumLiteral_30= 'Ivy'
                    {
                    enumLiteral_30=(Token)match(input,114,FollowSets000.FOLLOW_114_in_ruleImplementationType10040); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getIvyEnumLiteralDeclaration_30().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_30, grammarAccess.getImplementationTypeAccess().getIvyEnumLiteralDeclaration_30()); 
                          
                    }

                    }


                    }
                    break;
                case 32 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4678:6: (enumLiteral_31= 'jPDL3' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4678:6: (enumLiteral_31= 'jPDL3' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4678:8: enumLiteral_31= 'jPDL3'
                    {
                    enumLiteral_31=(Token)match(input,115,FollowSets000.FOLLOW_115_in_ruleImplementationType10057); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getJPDL3EnumLiteralDeclaration_31().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_31, grammarAccess.getImplementationTypeAccess().getJPDL3EnumLiteralDeclaration_31()); 
                          
                    }

                    }


                    }
                    break;
                case 33 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4684:6: (enumLiteral_32= 'jPDL4' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4684:6: (enumLiteral_32= 'jPDL4' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4684:8: enumLiteral_32= 'jPDL4'
                    {
                    enumLiteral_32=(Token)match(input,116,FollowSets000.FOLLOW_116_in_ruleImplementationType10074); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getJPDL4EnumLiteralDeclaration_32().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_32, grammarAccess.getImplementationTypeAccess().getJPDL4EnumLiteralDeclaration_32()); 
                          
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
    // $ANTLR end "ruleImplementationType"


    // $ANTLR start "ruleSOAPStyle"
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4694:1: ruleSOAPStyle returns [Enumerator current=null] : ( (enumLiteral_0= 'document/literal-wrapped' ) | (enumLiteral_1= 'rpc/literal' ) | (enumLiteral_2= 'rpc/encoded' ) ) ;
    public final Enumerator ruleSOAPStyle() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4696:28: ( ( (enumLiteral_0= 'document/literal-wrapped' ) | (enumLiteral_1= 'rpc/literal' ) | (enumLiteral_2= 'rpc/encoded' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4697:1: ( (enumLiteral_0= 'document/literal-wrapped' ) | (enumLiteral_1= 'rpc/literal' ) | (enumLiteral_2= 'rpc/encoded' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4697:1: ( (enumLiteral_0= 'document/literal-wrapped' ) | (enumLiteral_1= 'rpc/literal' ) | (enumLiteral_2= 'rpc/encoded' ) )
            int alt100=3;
            switch ( input.LA(1) ) {
            case 117:
                {
                alt100=1;
                }
                break;
            case 118:
                {
                alt100=2;
                }
                break;
            case 119:
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4697:2: (enumLiteral_0= 'document/literal-wrapped' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4697:2: (enumLiteral_0= 'document/literal-wrapped' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4697:4: enumLiteral_0= 'document/literal-wrapped'
                    {
                    enumLiteral_0=(Token)match(input,117,FollowSets000.FOLLOW_117_in_ruleSOAPStyle10119); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSOAPStyleAccess().getDoclitwrapEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getSOAPStyleAccess().getDoclitwrapEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4703:6: (enumLiteral_1= 'rpc/literal' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4703:6: (enumLiteral_1= 'rpc/literal' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4703:8: enumLiteral_1= 'rpc/literal'
                    {
                    enumLiteral_1=(Token)match(input,118,FollowSets000.FOLLOW_118_in_ruleSOAPStyle10136); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSOAPStyleAccess().getRpclitEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getSOAPStyleAccess().getRpclitEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4709:6: (enumLiteral_2= 'rpc/encoded' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4709:6: (enumLiteral_2= 'rpc/encoded' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4709:8: enumLiteral_2= 'rpc/encoded'
                    {
                    enumLiteral_2=(Token)match(input,119,FollowSets000.FOLLOW_119_in_ruleSOAPStyle10153); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4719:1: ruleSAPTransport returns [Enumerator current=null] : ( (enumLiteral_0= 'IDOC' ) | (enumLiteral_1= 'RFC' ) ) ;
    public final Enumerator ruleSAPTransport() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4721:28: ( ( (enumLiteral_0= 'IDOC' ) | (enumLiteral_1= 'RFC' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4722:1: ( (enumLiteral_0= 'IDOC' ) | (enumLiteral_1= 'RFC' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4722:1: ( (enumLiteral_0= 'IDOC' ) | (enumLiteral_1= 'RFC' ) )
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==120) ) {
                alt101=1;
            }
            else if ( (LA101_0==121) ) {
                alt101=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }
            switch (alt101) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4722:2: (enumLiteral_0= 'IDOC' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4722:2: (enumLiteral_0= 'IDOC' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4722:4: enumLiteral_0= 'IDOC'
                    {
                    enumLiteral_0=(Token)match(input,120,FollowSets000.FOLLOW_120_in_ruleSAPTransport10198); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getSAPTransportAccess().getIDOCEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getSAPTransportAccess().getIDOCEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4728:6: (enumLiteral_1= 'RFC' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4728:6: (enumLiteral_1= 'RFC' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4728:8: enumLiteral_1= 'RFC'
                    {
                    enumLiteral_1=(Token)match(input,121,FollowSets000.FOLLOW_121_in_ruleSAPTransport10215); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4738:1: ruleRESTFormat returns [Enumerator current=null] : ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'XML' ) | (enumLiteral_2= 'OTHER' ) ) ;
    public final Enumerator ruleRESTFormat() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4740:28: ( ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'XML' ) | (enumLiteral_2= 'OTHER' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4741:1: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'XML' ) | (enumLiteral_2= 'OTHER' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4741:1: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'XML' ) | (enumLiteral_2= 'OTHER' ) )
            int alt102=3;
            switch ( input.LA(1) ) {
            case 122:
                {
                alt102=1;
                }
                break;
            case 123:
                {
                alt102=2;
                }
                break;
            case 124:
                {
                alt102=3;
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4741:2: (enumLiteral_0= 'JSON' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4741:2: (enumLiteral_0= 'JSON' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4741:4: enumLiteral_0= 'JSON'
                    {
                    enumLiteral_0=(Token)match(input,122,FollowSets000.FOLLOW_122_in_ruleRESTFormat10260); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRESTFormatAccess().getJSONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getRESTFormatAccess().getJSONEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4747:6: (enumLiteral_1= 'XML' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4747:6: (enumLiteral_1= 'XML' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4747:8: enumLiteral_1= 'XML'
                    {
                    enumLiteral_1=(Token)match(input,123,FollowSets000.FOLLOW_123_in_ruleRESTFormat10277); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRESTFormatAccess().getXMLEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getRESTFormatAccess().getXMLEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4753:6: (enumLiteral_2= 'OTHER' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4753:6: (enumLiteral_2= 'OTHER' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4753:8: enumLiteral_2= 'OTHER'
                    {
                    enumLiteral_2=(Token)match(input,124,FollowSets000.FOLLOW_124_in_ruleRESTFormat10294); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRESTFormatAccess().getOTHEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getRESTFormatAccess().getOTHEREnumLiteralDeclaration_2()); 
                          
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4763:1: ruleVerb returns [Enumerator current=null] : ( (enumLiteral_0= 'create' ) | (enumLiteral_1= 'retrieve' ) | (enumLiteral_2= 'update' ) | (enumLiteral_3= 'delete' ) ) ;
    public final Enumerator ruleVerb() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4765:28: ( ( (enumLiteral_0= 'create' ) | (enumLiteral_1= 'retrieve' ) | (enumLiteral_2= 'update' ) | (enumLiteral_3= 'delete' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4766:1: ( (enumLiteral_0= 'create' ) | (enumLiteral_1= 'retrieve' ) | (enumLiteral_2= 'update' ) | (enumLiteral_3= 'delete' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4766:1: ( (enumLiteral_0= 'create' ) | (enumLiteral_1= 'retrieve' ) | (enumLiteral_2= 'update' ) | (enumLiteral_3= 'delete' ) )
            int alt103=4;
            switch ( input.LA(1) ) {
            case 125:
                {
                alt103=1;
                }
                break;
            case 126:
                {
                alt103=2;
                }
                break;
            case 127:
                {
                alt103=3;
                }
                break;
            case 128:
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4766:2: (enumLiteral_0= 'create' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4766:2: (enumLiteral_0= 'create' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4766:4: enumLiteral_0= 'create'
                    {
                    enumLiteral_0=(Token)match(input,125,FollowSets000.FOLLOW_125_in_ruleVerb10339); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getCreateEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getVerbAccess().getCreateEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4772:6: (enumLiteral_1= 'retrieve' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4772:6: (enumLiteral_1= 'retrieve' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4772:8: enumLiteral_1= 'retrieve'
                    {
                    enumLiteral_1=(Token)match(input,126,FollowSets000.FOLLOW_126_in_ruleVerb10356); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getRetrieveEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getVerbAccess().getRetrieveEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4778:6: (enumLiteral_2= 'update' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4778:6: (enumLiteral_2= 'update' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4778:8: enumLiteral_2= 'update'
                    {
                    enumLiteral_2=(Token)match(input,127,FollowSets000.FOLLOW_127_in_ruleVerb10373); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getUpdateEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getVerbAccess().getUpdateEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4784:6: (enumLiteral_3= 'delete' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4784:6: (enumLiteral_3= 'delete' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4784:8: enumLiteral_3= 'delete'
                    {
                    enumLiteral_3=(Token)match(input,128,FollowSets000.FOLLOW_128_in_ruleVerb10390); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getDeleteEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getVerbAccess().getDeleteEnumLiteralDeclaration_3()); 
                          
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4794:1: ruleReadWrite returns [Enumerator current=null] : ( (enumLiteral_0= 'read' ) | (enumLiteral_1= 'write' ) ) ;
    public final Enumerator ruleReadWrite() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4796:28: ( ( (enumLiteral_0= 'read' ) | (enumLiteral_1= 'write' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4797:1: ( (enumLiteral_0= 'read' ) | (enumLiteral_1= 'write' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4797:1: ( (enumLiteral_0= 'read' ) | (enumLiteral_1= 'write' ) )
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==129) ) {
                alt104=1;
            }
            else if ( (LA104_0==130) ) {
                alt104=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }
            switch (alt104) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4797:2: (enumLiteral_0= 'read' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4797:2: (enumLiteral_0= 'read' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4797:4: enumLiteral_0= 'read'
                    {
                    enumLiteral_0=(Token)match(input,129,FollowSets000.FOLLOW_129_in_ruleReadWrite10435); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getReadWriteAccess().getReadEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getReadWriteAccess().getReadEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4803:6: (enumLiteral_1= 'write' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4803:6: (enumLiteral_1= 'write' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4803:8: enumLiteral_1= 'write'
                    {
                    enumLiteral_1=(Token)match(input,130,FollowSets000.FOLLOW_130_in_ruleReadWrite10452); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4813:1: ruleHashAlgKind returns [Enumerator current=null] : ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'PlainText' ) ) ;
    public final Enumerator ruleHashAlgKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4815:28: ( ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'PlainText' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4816:1: ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'PlainText' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4816:1: ( (enumLiteral_0= 'MD5' ) | (enumLiteral_1= 'SHA1' ) | (enumLiteral_2= 'SHA256' ) | (enumLiteral_3= 'PlainText' ) )
            int alt105=4;
            switch ( input.LA(1) ) {
            case 131:
                {
                alt105=1;
                }
                break;
            case 132:
                {
                alt105=2;
                }
                break;
            case 133:
                {
                alt105=3;
                }
                break;
            case 134:
                {
                alt105=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;
            }

            switch (alt105) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4816:2: (enumLiteral_0= 'MD5' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4816:2: (enumLiteral_0= 'MD5' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4816:4: enumLiteral_0= 'MD5'
                    {
                    enumLiteral_0=(Token)match(input,131,FollowSets000.FOLLOW_131_in_ruleHashAlgKind10497); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getMD5EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getHashAlgKindAccess().getMD5EnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4822:6: (enumLiteral_1= 'SHA1' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4822:6: (enumLiteral_1= 'SHA1' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4822:8: enumLiteral_1= 'SHA1'
                    {
                    enumLiteral_1=(Token)match(input,132,FollowSets000.FOLLOW_132_in_ruleHashAlgKind10514); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getSHA1EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getHashAlgKindAccess().getSHA1EnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4828:6: (enumLiteral_2= 'SHA256' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4828:6: (enumLiteral_2= 'SHA256' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4828:8: enumLiteral_2= 'SHA256'
                    {
                    enumLiteral_2=(Token)match(input,133,FollowSets000.FOLLOW_133_in_ruleHashAlgKind10531); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getSHA256EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getHashAlgKindAccess().getSHA256EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4834:6: (enumLiteral_3= 'PlainText' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4834:6: (enumLiteral_3= 'PlainText' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4834:8: enumLiteral_3= 'PlainText'
                    {
                    enumLiteral_3=(Token)match(input,134,FollowSets000.FOLLOW_134_in_ruleHashAlgKind10548); if (state.failed) return current;
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4844:1: ruleAuthTokenKind returns [Enumerator current=null] : ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) ) ;
    public final Enumerator ruleAuthTokenKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4846:28: ( ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4847:1: ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4847:1: ( (enumLiteral_0= 'UsernamePassword' ) | (enumLiteral_1= 'SAML' ) | (enumLiteral_2= 'SAML2' ) | (enumLiteral_3= 'Kerberos' ) )
            int alt106=4;
            switch ( input.LA(1) ) {
            case 135:
                {
                alt106=1;
                }
                break;
            case 136:
                {
                alt106=2;
                }
                break;
            case 137:
                {
                alt106=3;
                }
                break;
            case 138:
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4847:2: (enumLiteral_0= 'UsernamePassword' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4847:2: (enumLiteral_0= 'UsernamePassword' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4847:4: enumLiteral_0= 'UsernamePassword'
                    {
                    enumLiteral_0=(Token)match(input,135,FollowSets000.FOLLOW_135_in_ruleAuthTokenKind10593); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getUsernamePasswordEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAuthTokenKindAccess().getUsernamePasswordEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4853:6: (enumLiteral_1= 'SAML' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4853:6: (enumLiteral_1= 'SAML' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4853:8: enumLiteral_1= 'SAML'
                    {
                    enumLiteral_1=(Token)match(input,136,FollowSets000.FOLLOW_136_in_ruleAuthTokenKind10610); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSAMLEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getAuthTokenKindAccess().getSAMLEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4859:6: (enumLiteral_2= 'SAML2' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4859:6: (enumLiteral_2= 'SAML2' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4859:8: enumLiteral_2= 'SAML2'
                    {
                    enumLiteral_2=(Token)match(input,137,FollowSets000.FOLLOW_137_in_ruleAuthTokenKind10627); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSAML2EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getAuthTokenKindAccess().getSAML2EnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4865:6: (enumLiteral_3= 'Kerberos' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4865:6: (enumLiteral_3= 'Kerberos' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4865:8: enumLiteral_3= 'Kerberos'
                    {
                    enumLiteral_3=(Token)match(input,138,FollowSets000.FOLLOW_138_in_ruleAuthTokenKind10644); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getKerberosEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getAuthTokenKindAccess().getKerberosEnumLiteralDeclaration_3()); 
                          
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
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4875:1: ruleLogPolicyKind returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'HEADER' ) | (enumLiteral_2= 'ALL' ) ) ;
    public final Enumerator ruleLogPolicyKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4877:28: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'HEADER' ) | (enumLiteral_2= 'ALL' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4878:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'HEADER' ) | (enumLiteral_2= 'ALL' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4878:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'HEADER' ) | (enumLiteral_2= 'ALL' ) )
            int alt107=3;
            switch ( input.LA(1) ) {
            case 139:
                {
                alt107=1;
                }
                break;
            case 140:
                {
                alt107=2;
                }
                break;
            case 141:
                {
                alt107=3;
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
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4878:2: (enumLiteral_0= 'NONE' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4878:2: (enumLiteral_0= 'NONE' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4878:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,139,FollowSets000.FOLLOW_139_in_ruleLogPolicyKind10689); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getLogPolicyKindAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getLogPolicyKindAccess().getNONEEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4884:6: (enumLiteral_1= 'HEADER' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4884:6: (enumLiteral_1= 'HEADER' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4884:8: enumLiteral_1= 'HEADER'
                    {
                    enumLiteral_1=(Token)match(input,140,FollowSets000.FOLLOW_140_in_ruleLogPolicyKind10706); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getLogPolicyKindAccess().getHEADEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getLogPolicyKindAccess().getHEADEREnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4890:6: (enumLiteral_2= 'ALL' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4890:6: (enumLiteral_2= 'ALL' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4890:8: enumLiteral_2= 'ALL'
                    {
                    enumLiteral_2=(Token)match(input,141,FollowSets000.FOLLOW_141_in_ruleLogPolicyKind10723); if (state.failed) return current;
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

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleBindingModel_in_entryRuleBindingModel87 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBindingModel97 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_ruleBindingModel147 = new BitSet(new long[]{0x0000000009000802L,0x0000000000002000L});
        public static final BitSet FOLLOW_ruleBinding_in_ruleBindingModel169 = new BitSet(new long[]{0x0000000009000802L});
        public static final BitSet FOLLOW_ruleBinding_in_entryRuleBinding210 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBinding220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDomainBinding_in_ruleBinding270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModuleBinding_in_ruleBinding300 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceBinding_in_ruleBinding330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDomainBinding_in_entryRuleDomainBinding365 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDomainBinding375 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleDomainBinding412 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDomainBinding439 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleDomainBinding451 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDomainBinding472 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleDomainBinding484 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleDomainBinding496 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDomainBinding520 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleDomainBinding532 = new BitSet(new long[]{0x00000002091F0800L});
        public static final BitSet FOLLOW_16_in_ruleDomainBinding545 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleDomainBinding557 = new BitSet(new long[]{0x1145210000000000L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleDomainBinding578 = new BitSet(new long[]{0x1145210000020000L,0x0000000000000005L});
        public static final BitSet FOLLOW_17_in_ruleDomainBinding591 = new BitSet(new long[]{0x00000002091E0800L});
        public static final BitSet FOLLOW_18_in_ruleDomainBinding606 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleDomainBinding618 = new BitSet(new long[]{0x0000000000020000L,0x0000000000001C30L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleDomainBinding639 = new BitSet(new long[]{0x0000000000020000L,0x0000000000001C30L});
        public static final BitSet FOLLOW_17_in_ruleDomainBinding652 = new BitSet(new long[]{0x00000002091A0800L});
        public static final BitSet FOLLOW_19_in_ruleDomainBinding667 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleDomainBinding679 = new BitSet(new long[]{0x0000000000020000L,0x0000000000001C30L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleDomainBinding700 = new BitSet(new long[]{0x0000000000020000L,0x0000000000001C30L});
        public static final BitSet FOLLOW_17_in_ruleDomainBinding713 = new BitSet(new long[]{0x0000000209120800L});
        public static final BitSet FOLLOW_20_in_ruleDomainBinding728 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDomainBinding755 = new BitSet(new long[]{0x0000000209220800L});
        public static final BitSet FOLLOW_21_in_ruleDomainBinding768 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDomainBinding795 = new BitSet(new long[]{0x0000000209220800L});
        public static final BitSet FOLLOW_ruleServiceBinding_in_ruleDomainBinding820 = new BitSet(new long[]{0x0000000209020800L});
        public static final BitSet FOLLOW_ruleComponent_in_ruleDomainBinding842 = new BitSet(new long[]{0x0000000200020000L});
        public static final BitSet FOLLOW_17_in_ruleDomainBinding855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePublisher_in_entryRulePublisher891 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePublisher901 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rulePublisher938 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rulePublisher965 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProvider_in_entryRuleProvider1001 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProvider1011 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleProvider1048 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleProvider1075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceBinding_in_entryRuleServiceBinding1111 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleServiceBinding1121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleServiceBinding1158 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleServiceBinding1179 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleServiceBinding1191 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleServiceBinding1203 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleServiceBinding1227 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleServiceBinding1240 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleServiceBinding1252 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleServiceBinding1264 = new BitSet(new long[]{0x1145210000000000L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleServiceBinding1285 = new BitSet(new long[]{0x1145210000020000L,0x0000000000000005L});
        public static final BitSet FOLLOW_17_in_ruleServiceBinding1298 = new BitSet(new long[]{0x00000000061E0000L});
        public static final BitSet FOLLOW_25_in_ruleServiceBinding1311 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleServiceBinding1323 = new BitSet(new long[]{0x1145210000000000L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleServiceBinding1344 = new BitSet(new long[]{0x1145210000020000L,0x0000000000000005L});
        public static final BitSet FOLLOW_17_in_ruleServiceBinding1357 = new BitSet(new long[]{0x00000000041E0000L});
        public static final BitSet FOLLOW_18_in_ruleServiceBinding1372 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleServiceBinding1384 = new BitSet(new long[]{0x0000000000020000L,0x0000000000001C30L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleServiceBinding1405 = new BitSet(new long[]{0x0000000000020000L,0x0000000000001C30L});
        public static final BitSet FOLLOW_17_in_ruleServiceBinding1418 = new BitSet(new long[]{0x00000000041A0000L});
        public static final BitSet FOLLOW_19_in_ruleServiceBinding1433 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleServiceBinding1445 = new BitSet(new long[]{0x0000000000020000L,0x0000000000001C30L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleServiceBinding1466 = new BitSet(new long[]{0x0000000000020000L,0x0000000000001C30L});
        public static final BitSet FOLLOW_17_in_ruleServiceBinding1479 = new BitSet(new long[]{0x0000000004120000L});
        public static final BitSet FOLLOW_20_in_ruleServiceBinding1494 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleServiceBinding1521 = new BitSet(new long[]{0x0000000004220000L});
        public static final BitSet FOLLOW_21_in_ruleServiceBinding1534 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleServiceBinding1561 = new BitSet(new long[]{0x0000000004220000L});
        public static final BitSet FOLLOW_ruleOperationBinding_in_ruleServiceBinding1586 = new BitSet(new long[]{0x0000000004020000L});
        public static final BitSet FOLLOW_17_in_ruleServiceBinding1599 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceRef_in_entryRuleServiceRef1635 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleServiceRef1645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleServiceRef1697 = new BitSet(new long[]{0x0000000000000000L,0x0000000000198000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleServiceRef1718 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_entryRuleBindingProtocol1754 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBindingProtocol1764 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSCA_in_ruleBindingProtocol1814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSOAP_in_ruleBindingProtocol1844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEJB_in_ruleBindingProtocol1874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHTTP_in_ruleBindingProtocol1904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleREST_in_ruleBindingProtocol1934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSAP_in_ruleBindingProtocol1964 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJMS_in_ruleBindingProtocol1994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFILE_in_ruleBindingProtocol2024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFTP_in_ruleBindingProtocol2054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperationBinding_in_entryRuleOperationBinding2089 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperationBinding2099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleOperationBinding2136 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleOperationBinding2163 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOperationBinding2175 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleOperationBinding2187 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOperationBinding2199 = new BitSet(new long[]{0x1145210000000000L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleOperationBinding2220 = new BitSet(new long[]{0x1145210000020000L,0x0000000000000005L});
        public static final BitSet FOLLOW_17_in_ruleOperationBinding2233 = new BitSet(new long[]{0x00000000021E0000L});
        public static final BitSet FOLLOW_25_in_ruleOperationBinding2246 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOperationBinding2258 = new BitSet(new long[]{0x1145210000000000L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleOperationBinding2279 = new BitSet(new long[]{0x1145210000020000L,0x0000000000000005L});
        public static final BitSet FOLLOW_17_in_ruleOperationBinding2292 = new BitSet(new long[]{0x00000000001E0000L});
        public static final BitSet FOLLOW_18_in_ruleOperationBinding2307 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOperationBinding2319 = new BitSet(new long[]{0x0000000000020000L,0x0000000000001C30L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleOperationBinding2340 = new BitSet(new long[]{0x0000000000020000L,0x0000000000001C30L});
        public static final BitSet FOLLOW_17_in_ruleOperationBinding2353 = new BitSet(new long[]{0x00000000001A0000L});
        public static final BitSet FOLLOW_19_in_ruleOperationBinding2368 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleOperationBinding2380 = new BitSet(new long[]{0x0000000000020000L,0x0000000000001C30L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleOperationBinding2401 = new BitSet(new long[]{0x0000000000020000L,0x0000000000001C30L});
        public static final BitSet FOLLOW_17_in_ruleOperationBinding2414 = new BitSet(new long[]{0x0000000000120000L});
        public static final BitSet FOLLOW_20_in_ruleOperationBinding2429 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleOperationBinding2456 = new BitSet(new long[]{0x0000000000220000L});
        public static final BitSet FOLLOW_21_in_ruleOperationBinding2469 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleOperationBinding2496 = new BitSet(new long[]{0x0000000000220000L});
        public static final BitSet FOLLOW_17_in_ruleOperationBinding2512 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModuleBinding_in_entryRuleModuleBinding2548 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModuleBinding2558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleModuleBinding2595 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleModuleRef_in_ruleModuleBinding2616 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModuleBinding2628 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModuleBinding2649 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleModuleBinding2661 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleModuleBinding2673 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModuleBinding2700 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleModuleBinding2712 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_ruleProvider_in_ruleModuleBinding2733 = new BitSet(new long[]{0x0000000070170000L});
        public static final BitSet FOLLOW_28_in_ruleModuleBinding2746 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleModuleBinding2758 = new BitSet(new long[]{0x1145210000000000L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleModuleBinding2779 = new BitSet(new long[]{0x1145210000020000L,0x0000000000000005L});
        public static final BitSet FOLLOW_17_in_ruleModuleBinding2792 = new BitSet(new long[]{0x0000000060170000L});
        public static final BitSet FOLLOW_29_in_ruleModuleBinding2807 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleModuleBinding2819 = new BitSet(new long[]{0x0000000000020000L,0x0000000000001C30L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleModuleBinding2840 = new BitSet(new long[]{0x0000000000020000L,0x0000000000001C30L});
        public static final BitSet FOLLOW_17_in_ruleModuleBinding2853 = new BitSet(new long[]{0x0000000040170000L});
        public static final BitSet FOLLOW_30_in_ruleModuleBinding2868 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModuleBinding2895 = new BitSet(new long[]{0x0000000000370000L});
        public static final BitSet FOLLOW_21_in_ruleModuleBinding2908 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModuleBinding2935 = new BitSet(new long[]{0x0000000000370000L});
        public static final BitSet FOLLOW_ruleServiceProtocolSpec_in_ruleModuleBinding2960 = new BitSet(new long[]{0x0000000000170000L});
        public static final BitSet FOLLOW_ruleServicePolicySpec_in_ruleModuleBinding2982 = new BitSet(new long[]{0x0000000000160000L});
        public static final BitSet FOLLOW_ruleServiceSLASpec_in_ruleModuleBinding3004 = new BitSet(new long[]{0x0000000000120000L});
        public static final BitSet FOLLOW_17_in_ruleModuleBinding3017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModuleRef_in_entryRuleModuleRef3053 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModuleRef3063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModuleRef3115 = new BitSet(new long[]{0x0000000000000000L,0x0000000000198000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleModuleRef3136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceProtocolSpec_in_entryRuleServiceProtocolSpec3172 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleServiceProtocolSpec3182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleServiceProtocolSpec3219 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleServiceProtocolSpec3231 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleServiceProtocolSpec3243 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleServiceProtocolSpec3264 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleServiceProtocolSpec3276 = new BitSet(new long[]{0x1145210000000000L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleServiceProtocolSpec3297 = new BitSet(new long[]{0x1145210000020000L,0x0000000000000005L});
        public static final BitSet FOLLOW_17_in_ruleServiceProtocolSpec3310 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServicePolicySpec_in_entryRuleServicePolicySpec3346 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleServicePolicySpec3356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleServicePolicySpec3393 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleServicePolicySpec3405 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleServicePolicySpec3417 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleServicePolicySpec3438 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleServicePolicySpec3450 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001C30L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleServicePolicySpec3471 = new BitSet(new long[]{0x0000000000020000L,0x0000000000001C30L});
        public static final BitSet FOLLOW_17_in_ruleServicePolicySpec3484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceSLASpec_in_entryRuleServiceSLASpec3520 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleServiceSLASpec3530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleServiceSLASpec3567 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleServiceSLASpec3579 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleServiceSLASpec3591 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleServiceSLASpec3612 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleServiceSLASpec3639 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_21_in_ruleServiceSLASpec3652 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleServiceSLASpec3679 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_ruleComponent_in_entryRuleComponent3717 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleComponent3727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleComponent3764 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleComponent3781 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleComponent3798 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleComponent3819 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleComponent3831 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_35_in_ruleComponent3843 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleComponent3870 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleComponent3882 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleComponent3903 = new BitSet(new long[]{0x0000002000210000L});
        public static final BitSet FOLLOW_21_in_ruleComponent3916 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleComponent3937 = new BitSet(new long[]{0x0000002000210000L});
        public static final BitSet FOLLOW_37_in_ruleComponent3952 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleComponent3973 = new BitSet(new long[]{0x0000000000210000L});
        public static final BitSet FOLLOW_21_in_ruleComponent3986 = new BitSet(new long[]{0x0000000000210000L});
        public static final BitSet FOLLOW_16_in_ruleComponent4002 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleComponent4014 = new BitSet(new long[]{0x1145210000000000L,0x0000000000000005L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleComponent4035 = new BitSet(new long[]{0x1145210000020000L,0x0000000000000005L});
        public static final BitSet FOLLOW_17_in_ruleComponent4048 = new BitSet(new long[]{0x00000040041C0000L});
        public static final BitSet FOLLOW_ruleOperationBinding_in_ruleComponent4069 = new BitSet(new long[]{0x00000040041C0000L});
        public static final BitSet FOLLOW_18_in_ruleComponent4083 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleComponent4095 = new BitSet(new long[]{0x0000000000020000L,0x0000000000001C30L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleComponent4116 = new BitSet(new long[]{0x0000000000020000L,0x0000000000001C30L});
        public static final BitSet FOLLOW_17_in_ruleComponent4129 = new BitSet(new long[]{0x0000004000180000L});
        public static final BitSet FOLLOW_19_in_ruleComponent4144 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleComponent4156 = new BitSet(new long[]{0x0000000000020000L,0x0000000000001C30L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleComponent4177 = new BitSet(new long[]{0x0000000000020000L,0x0000000000001C30L});
        public static final BitSet FOLLOW_17_in_ruleComponent4190 = new BitSet(new long[]{0x0000004000100000L});
        public static final BitSet FOLLOW_20_in_ruleComponent4205 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleComponent4232 = new BitSet(new long[]{0x0000004000200000L});
        public static final BitSet FOLLOW_21_in_ruleComponent4245 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleComponent4272 = new BitSet(new long[]{0x0000004000200000L});
        public static final BitSet FOLLOW_38_in_ruleComponent4288 = new BitSet(new long[]{0x0001200000000000L,0x001FFFFFFFC00000L});
        public static final BitSet FOLLOW_ruleImplementationType_in_ruleComponent4309 = new BitSet(new long[]{0x0000008000020000L});
        public static final BitSet FOLLOW_39_in_ruleComponent4322 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleComponent4339 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleComponent4358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSOAP_in_entryRuleSOAP4394 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSOAP4404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleSOAP4441 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleSOAP4453 = new BitSet(new long[]{0x00001E0000C20000L});
        public static final BitSet FOLLOW_rulePublisher_in_ruleSOAP4486 = new BitSet(new long[]{0x00001E0000820000L});
        public static final BitSet FOLLOW_ruleProvider_in_ruleSOAP4508 = new BitSet(new long[]{0x00001E0000020000L});
        public static final BitSet FOLLOW_41_in_ruleSOAP4522 = new BitSet(new long[]{0x0000000000000000L,0x00E0000000000000L});
        public static final BitSet FOLLOW_ruleSOAPStyle_in_ruleSOAP4543 = new BitSet(new long[]{0x00001C0000020000L});
        public static final BitSet FOLLOW_42_in_ruleSOAP4558 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSOAP4575 = new BitSet(new long[]{0x0000180000020000L});
        public static final BitSet FOLLOW_43_in_ruleSOAP4595 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSOAP4612 = new BitSet(new long[]{0x0000100000020000L});
        public static final BitSet FOLLOW_44_in_ruleSOAP4632 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSOAP4649 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleSOAP4668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSAP_in_entryRuleSAP4704 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSAP4714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleSAP4751 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleSAP4763 = new BitSet(new long[]{0x0000C00000820000L});
        public static final BitSet FOLLOW_ruleProvider_in_ruleSAP4796 = new BitSet(new long[]{0x0000C00000020000L});
        public static final BitSet FOLLOW_46_in_ruleSAP4810 = new BitSet(new long[]{0x0000000000000000L,0x0300000000000000L});
        public static final BitSet FOLLOW_ruleSAPTransport_in_ruleSAP4831 = new BitSet(new long[]{0x0000800000020000L});
        public static final BitSet FOLLOW_47_in_ruleSAP4846 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSAP4873 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleSAP4887 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEJB_in_entryRuleEJB4923 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEJB4933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleEJB4970 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleEJB4982 = new BitSet(new long[]{0x0002000000C00000L});
        public static final BitSet FOLLOW_rulePublisher_in_ruleEJB5003 = new BitSet(new long[]{0x0002000000800000L});
        public static final BitSet FOLLOW_ruleProvider_in_ruleEJB5025 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleEJB5038 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEJB5055 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleEJB5072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHTTP_in_entryRuleHTTP5108 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHTTP5118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleHTTP5155 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleHTTP5167 = new BitSet(new long[]{0x0008000000C00000L});
        public static final BitSet FOLLOW_rulePublisher_in_ruleHTTP5188 = new BitSet(new long[]{0x0008000000800000L});
        public static final BitSet FOLLOW_ruleProvider_in_ruleHTTP5210 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_51_in_ruleHTTP5223 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleHTTP5240 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_52_in_ruleHTTP5257 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleHTTP5274 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_ruleHTTP5291 = new BitSet(new long[]{0x0000000000000000L,0xE000000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleVerb_in_ruleHTTP5312 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleHTTP5324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleREST_in_entryRuleREST5360 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleREST5370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleREST5407 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleREST5419 = new BitSet(new long[]{0x0008000000C00000L});
        public static final BitSet FOLLOW_rulePublisher_in_ruleREST5440 = new BitSet(new long[]{0x0008000000800000L});
        public static final BitSet FOLLOW_ruleProvider_in_ruleREST5462 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_51_in_ruleREST5475 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleREST5492 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_52_in_ruleREST5509 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleREST5526 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_ruleREST5543 = new BitSet(new long[]{0x0000000000000000L,0xE000000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleVerb_in_ruleREST5564 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleREST5576 = new BitSet(new long[]{0x0000000000000000L,0x1C00000000000000L});
        public static final BitSet FOLLOW_ruleRESTFormat_in_ruleREST5597 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleREST5609 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJMS_in_entryRuleJMS5645 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleJMS5655 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleJMS5692 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleJMS5704 = new BitSet(new long[]{0x0C02000000C00000L});
        public static final BitSet FOLLOW_rulePublisher_in_ruleJMS5737 = new BitSet(new long[]{0x0C02000000800000L});
        public static final BitSet FOLLOW_ruleProvider_in_ruleJMS5759 = new BitSet(new long[]{0x0C02000000000000L});
        public static final BitSet FOLLOW_ruleTopicOrQueue_in_ruleJMS5781 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleJMS5794 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleJMS5811 = new BitSet(new long[]{0x0200000000020000L});
        public static final BitSet FOLLOW_57_in_ruleJMS5829 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleJMS5846 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleJMS5865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTopicOrQueue_in_entryRuleTopicOrQueue5901 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTopicOrQueue5911 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTopic_in_ruleTopicOrQueue5961 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQueue_in_ruleTopicOrQueue5991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTopic_in_entryRuleTopic6026 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTopic6036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleTopic6073 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleTopic6090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQueue_in_entryRuleQueue6131 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQueue6141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_ruleQueue6178 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleQueue6195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSCA_in_entryRuleSCA6236 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSCA6246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleSCA6283 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSCA6300 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleSCA6317 = new BitSet(new long[]{0x6000000000C20000L});
        public static final BitSet FOLLOW_rulePublisher_in_ruleSCA6338 = new BitSet(new long[]{0x6000000000820000L});
        public static final BitSet FOLLOW_ruleProvider_in_ruleSCA6360 = new BitSet(new long[]{0x6000000000020000L});
        public static final BitSet FOLLOW_61_in_ruleSCA6374 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSCA6391 = new BitSet(new long[]{0x4000000000020000L});
        public static final BitSet FOLLOW_62_in_ruleSCA6411 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSCA6428 = new BitSet(new long[]{0x8000000000020000L});
        public static final BitSet FOLLOW_63_in_ruleSCA6451 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleSCA6479 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFILE_in_entryRuleFILE6515 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFILE6525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_ruleFILE6562 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFILE6579 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000006L});
        public static final BitSet FOLLOW_ruleReadWrite_in_ruleFILE6605 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleFILE6618 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFILE6635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFTP_in_entryRuleFTP6678 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFTP6688 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleFTP6725 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFTP6742 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleFTP6759 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000006L});
        public static final BitSet FOLLOW_ruleReadWrite_in_ruleFTP6780 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleFTP6793 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFTP6810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePolicy_in_entryRulePolicy6853 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePolicy6863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLogPolicy_in_rulePolicy6913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecurityPolicy_in_rulePolicy6943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLogPolicy_in_entryRuleLogPolicy6978 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLogPolicy6988 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleLogPolicy7025 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000003800L});
        public static final BitSet FOLLOW_ruleLogPolicyKind_in_ruleLogPolicy7046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecurityPolicy_in_entryRuleSecurityPolicy7082 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecurityPolicy7092 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthenticationPolicy_in_ruleSecurityPolicy7142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthorizationPolicy_in_ruleSecurityPolicy7166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSigningPolicy_in_ruleSecurityPolicy7190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEncryptionPolicy_in_ruleSecurityPolicy7214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthenticationPolicy_in_entryRuleAuthenticationPolicy7249 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAuthenticationPolicy7259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_69_in_ruleAuthenticationPolicy7296 = new BitSet(new long[]{0x0000000000008010L,0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAuthenticationPolicy7313 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000040L});
        public static final BitSet FOLLOW_70_in_ruleAuthenticationPolicy7337 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleAuthenticationPolicy7363 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_ruleAuthenticationPolicy7375 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleAuthenticationPolicy7387 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L,0x0000000000000780L});
        public static final BitSet FOLLOW_ruleAuthToken_in_ruleAuthenticationPolicy7408 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000040L,0x0000000000000780L});
        public static final BitSet FOLLOW_17_in_ruleAuthenticationPolicy7421 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_72_in_ruleAuthenticationPolicy7433 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleAuthenticationPolicy7445 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000240L,0x0000000000000078L});
        public static final BitSet FOLLOW_ruleHashAlgorithm_in_ruleAuthenticationPolicy7466 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000240L,0x0000000000000078L});
        public static final BitSet FOLLOW_17_in_ruleAuthenticationPolicy7479 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleAuthenticationPolicy7491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthToken_in_entryRuleAuthToken7527 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAuthToken7537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleAuthToken7580 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L,0x0000000000000780L});
        public static final BitSet FOLLOW_ruleAuthTokenKind_in_ruleAuthToken7615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHashAlgorithm_in_entryRuleHashAlgorithm7651 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHashAlgorithm7661 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleHashAlgorithm7704 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000240L,0x0000000000000078L});
        public static final BitSet FOLLOW_73_in_ruleHashAlgorithm7736 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000240L,0x0000000000000078L});
        public static final BitSet FOLLOW_ruleHashAlgKind_in_ruleHashAlgorithm7771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthorizationPolicy_in_entryRuleAuthorizationPolicy7808 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAuthorizationPolicy7819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_74_in_ruleAuthorizationPolicy7856 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSigningPolicy_in_entryRuleSigningPolicy7896 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSigningPolicy7907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleSigningPolicy7944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEncryptionPolicy_in_entryRuleEncryptionPolicy7984 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEncryptionPolicy7995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_76_in_ruleEncryptionPolicy8032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport8077 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport8087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_77_in_ruleImport8128 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport8149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVersionId_in_entryRuleVersionId8196 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionId8207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId8251 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
        public static final BitSet FOLLOW_78_in_ruleVersionId8270 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId8285 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_entryRuleVersionRef8346 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionRef8356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_ruleVersionRef8410 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_ruleVersionRef8440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef8470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_ruleVersionRef8500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_ruleVersionRef8530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef8575 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMinVersionRef8585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_79_in_ruleMinVersionRef8626 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMinVersionRef8647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef8693 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxVersionRef8703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_80_in_ruleMaxVersionRef8744 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMaxVersionRef8765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef8811 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef8821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_79_in_ruleLowerBoundRangeVersionRef8863 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
        public static final BitSet FOLLOW_81_in_ruleLowerBoundRangeVersionRef8875 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef8897 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleLowerBoundRangeVersionRef8909 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
        public static final BitSet FOLLOW_80_in_ruleLowerBoundRangeVersionRef8922 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
        public static final BitSet FOLLOW_82_in_ruleLowerBoundRangeVersionRef8934 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef8956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef9002 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMajorVersionRef9012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_83_in_ruleMajorVersionRef9053 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMajorVersionRef9070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef9121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFixedVersionRef9131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_84_in_ruleFixedVersionRef9172 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleFixedVersionRef9193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard9240 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard9251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard9302 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
        public static final BitSet FOLLOW_85_in_ruleQualifiedNameWithWildCard9321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName9374 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName9385 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName9429 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
        public static final BitSet FOLLOW_78_in_ruleQualifiedName9448 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName9463 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
        public static final BitSet FOLLOW_86_in_ruleImplementationType9530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_87_in_ruleImplementationType9547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_88_in_ruleImplementationType9564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_89_in_ruleImplementationType9581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_90_in_ruleImplementationType9598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_91_in_ruleImplementationType9615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_92_in_ruleImplementationType9632 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_93_in_ruleImplementationType9649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_94_in_ruleImplementationType9666 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_95_in_ruleImplementationType9683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_96_in_ruleImplementationType9700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_97_in_ruleImplementationType9717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_98_in_ruleImplementationType9734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_99_in_ruleImplementationType9751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_100_in_ruleImplementationType9768 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_101_in_ruleImplementationType9785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_102_in_ruleImplementationType9802 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_103_in_ruleImplementationType9819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleImplementationType9836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_104_in_ruleImplementationType9853 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_105_in_ruleImplementationType9870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleImplementationType9887 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_106_in_ruleImplementationType9904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_107_in_ruleImplementationType9921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_108_in_ruleImplementationType9938 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_109_in_ruleImplementationType9955 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_110_in_ruleImplementationType9972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_111_in_ruleImplementationType9989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_112_in_ruleImplementationType10006 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_113_in_ruleImplementationType10023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_114_in_ruleImplementationType10040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_115_in_ruleImplementationType10057 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_116_in_ruleImplementationType10074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_117_in_ruleSOAPStyle10119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_118_in_ruleSOAPStyle10136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_119_in_ruleSOAPStyle10153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_120_in_ruleSAPTransport10198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_121_in_ruleSAPTransport10215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_122_in_ruleRESTFormat10260 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_123_in_ruleRESTFormat10277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_124_in_ruleRESTFormat10294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_125_in_ruleVerb10339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_126_in_ruleVerb10356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_127_in_ruleVerb10373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_128_in_ruleVerb10390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_129_in_ruleReadWrite10435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_130_in_ruleReadWrite10452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_131_in_ruleHashAlgKind10497 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_132_in_ruleHashAlgKind10514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_133_in_ruleHashAlgKind10531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_134_in_ruleHashAlgKind10548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_135_in_ruleAuthTokenKind10593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_136_in_ruleAuthTokenKind10610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_137_in_ruleAuthTokenKind10627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_138_in_ruleAuthTokenKind10644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_139_in_ruleLogPolicyKind10689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_140_in_ruleLogPolicyKind10706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_141_in_ruleLogPolicyKind10723 = new BitSet(new long[]{0x0000000000000002L});
    }


}