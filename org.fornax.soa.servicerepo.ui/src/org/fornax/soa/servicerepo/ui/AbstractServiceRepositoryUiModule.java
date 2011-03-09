package org.fornax.soa.servicerepo.ui;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.fornax.soa.servicerepo.ui.wizards.ServiceRepositoryProjectCreator;

import com.google.inject.Binder;

/**
 * Manual modifications go to {org.fornax.soa.ui.BindingDslUiModule}
 */
@SuppressWarnings("all")
public abstract class AbstractServiceRepositoryUiModule extends AbstractGenericModule {
	
	private final AbstractUIPlugin plugin;

	public AbstractServiceRepositoryUiModule(AbstractUIPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(AbstractUIPlugin.class).toInstance(plugin);
		binder.bind(IDialogSettings.class).toInstance(plugin.getDialogSettings());
	}
	
	public Class<? extends org.eclipse.xtext.ui.wizard.IProjectCreator> bindIProjectCreator() {
		return ServiceRepositoryProjectCreator.class;
	}

	
	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
//	public com.google.inject.Provider<org.eclipse.xtext.resource.containers.IAllContainersState> provideIAllContainersState() {
//		return org.eclipse.xtext.ui.shared.Access.getJavaProjectsState();
//	}
//
//	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
//	public Class<? extends org.eclipse.jface.text.rules.ITokenScanner> bindITokenScanner() {
//		return org.eclipse.xtext.ui.editor.syntaxcoloring.antlr.AntlrTokenScanner.class;
//	}
//
//	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
//	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper> bindIProposalConflictHelper() {
//		return org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper.class;
//	}
//
//	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
//	public Class<? extends org.eclipse.xtext.ui.editor.IDamagerRepairer> bindIDamagerRepairer() {
//		return org.eclipse.xtext.ui.editor.FastDamagerRepairer.class;
//	}
//
//	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
//	public void configureHighlightingLexer(com.google.inject.Binder binder) {
//		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING)).to(org.fornax.soa.parser.antlr.internal.InternalBindingDslLexer.class);
//	}
//
//	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
//	public void configureHighlightingTokenDefProvider(com.google.inject.Binder binder) {
//		binder.bind(org.eclipse.xtext.parser.antlr.ITokenDefProvider.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING)).to(org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider.class);
//	}
//
//	// contributed by org.eclipse.xtext.generator.exporting.QualifiedNamesFragment
//	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher> bindPrefixMatcher() {
//		return org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher.class;
//	}
//
//	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
//	public void configureIResourceDescriptionsBuilderScope(com.google.inject.Binder binder) {
//		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.scoping.impl.AbstractGlobalScopeProvider.NAMED_BUILDER_SCOPE)).to(org.eclipse.xtext.builder.builderState.ShadowingResourceDescriptions.class);
//	}
//
//	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
//	public Class<? extends org.eclipse.xtext.ui.editor.IXtextEditorCallback> bindIXtextEditorCallback() {
//		return org.eclipse.xtext.builder.nature.NatureAddingEditorCallback.class;
//	}
//
//	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
//	public void configureIResourceDescriptionsPersisted(com.google.inject.Binder binder) {
//		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.builder.impl.PersistentDataAwareDirtyResource.PERSISTED_DESCRIPTIONS)).to(org.eclipse.xtext.builder.builderState.IBuilderState.class);
//	}
//
//	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
//	public Class<? extends org.eclipse.xtext.ui.editor.DocumentBasedDirtyResource> bindDocumentBasedDirtyResource() {
//		return org.eclipse.xtext.builder.impl.PersistentDataAwareDirtyResource.class;
//	}
//
//	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
//	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext.Factory> bindContentAssistContext$Factory() {
//		return org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.class;
//	}
//
//	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
//	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser> bindIContentAssistParser() {
//		return org.fornax.soa.ui.contentassist.antlr.BindingDslParser.class;
//	}

}
