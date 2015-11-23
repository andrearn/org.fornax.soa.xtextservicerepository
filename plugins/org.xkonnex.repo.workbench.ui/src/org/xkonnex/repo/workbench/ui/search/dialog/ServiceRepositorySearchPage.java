/*
 * based on JavaSearchPage from JDT
 */
package org.xkonnex.repo.workbench.ui.search.dialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.ButtonGroup;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.compiler.IScanner;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.ISearchPageContainer;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.xkonnex.repo.core.query.FindAssetsWithStateQuery;
import org.xkonnex.repo.core.query.FindUnapprovedAssetsQuery;
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.ProfileDslPackage;
import org.xkonnex.repo.workbench.ui.internal.ServiceRepositoryActivator;
import org.xkonnex.repo.workbench.ui.search.ServiceRepositoryQuerySpec;
import org.xkonnex.repo.workbench.ui.search.ServiceRepositorySearchQuery;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.inject.Injector;

public class ServiceRepositorySearchPage extends DialogPage implements ISearchPage {
	
	private static final String ANY_ASSET_QUERY = "Any asset";
	private static final String DEFAULT_PATTERN = "*";
	private static final String DEFAULT_ASSET_TYPE = "org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Service";

	public static final String DIALOG_SETTINGS_SECTION = "org.xkonnex.repo.dsl.bindingdsl.servicerepo.ui.search";

	private static Injector injector;

    private boolean fFirstTime= true;
    private IDialogSettings fDialogSettings;
    private boolean fIsCaseSensitive;

    private Combo fPattern;
    private ISearchPageContainer fContainer;
    private Button fCaseSensitive;

    private ServiceRepositoryQueryData fInitialData;
    private EObject fElement;
    private Group limitToGroup;

	private Combo searchForCombo;
	private Combo queryCombo;

    private static final int HISTORY_SIZE= 12;

    // Dialog store id constants
    private final static String PAGE_NAME= "ServiceRepositorySearchPage"; //$NON-NLS-1$
    private final static String STORE_CASE_SENSITIVE= "CASE_SENSITIVE"; //$NON-NLS-1$
    private final static String STORE_INCLUDE_MASK= "INCLUDE_MASK"; //$NON-NLS-1$
    private final static String STORE_HISTORY= "HISTORY"; //$NON-NLS-1$
    private final static String STORE_HISTORY_SIZE= "HISTORY_SIZE"; //$NON-NLS-1$
	private static final String STORE_PATTERN = "PATTERN";
	private static final String STORE_QUERY = "QUERY";
	private static final String STORE_SEARCH_FOR = "SCOPE";

    private final List fPreviousSearchPatterns;
	private Combo minStateCombo;
	private Combo maxStateCombo;
	private Text minVersionText;
	private Text maxVersionText;
	private Text tagsText;
	private Button canonicalCheckButton;
	private Button nonCanonicalCheckButton;
	private Button withTagsFromParentButton;
	private Composite result_1;
	private IPredicateSearch predicateSearch;
	private Button oneOfTagsRadioButton;
	private Button allOfTagsRadioButton;
	private boolean allTags;

    public ServiceRepositorySearchPage() {
		fPreviousSearchPatterns = new ArrayList();
		fDialogSettings = ServiceRepositoryActivator.getInstance().getDialogSetting(DIALOG_SETTINGS_SECTION);
	}

	public void createControl(Composite parent) {
		injector = ServiceRepositoryActivator.getInstance().getInjector();
		predicateSearch = injector.getInstance(IPredicateSearch.class);
		initializeDialogUnits (parent);

		result_1= new Composite(parent, SWT.FILL);

        GridLayout gl_result_1= new GridLayout(1, false);
        gl_result_1.horizontalSpacing= 10;
        result_1.setLayout(gl_result_1);

        Control expressionComposite= createExpression(result_1);
        expressionComposite.setLayoutData(new GridData(SWT.FILL, GridData.CENTER, true, false, 1, 1));

        Label separator= new Label(result_1, SWT.FILL);
        separator.setVisible(false);
        GridData data= new GridData(GridData.FILL, GridData.FILL, false, false, 1, 1);
        data.heightHint= convertHeightInCharsToPixels(1) / 3;
        separator.setLayoutData(data);
        new Label(result_1, SWT.NONE);
        
        readConfiguration ();
	}
	
	public boolean performAction() {
        return performNewSearch();
    }


	private Control createExpression(Composite parent) {
        Composite result= new Composite(parent, SWT.NONE);
        GridLayout layout= new GridLayout(3, false);
        layout.marginWidth= 0;
        layout.marginHeight= 0;
        result.setLayout(layout);

        // Pattern text + info

        Label exprLabel = new Label (result, SWT.NONE);
        exprLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        exprLabel.setText (ServiceRepositorySearchMessages.SearchPage_expression_label);
       
        // Pattern combo
        fPattern= new Combo(result, SWT.SINGLE | SWT.BORDER);
        fPattern.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                handlePatternSelected();
                updateOKStatus();
            }

        });
        fPattern.addModifyListener (new ModifyListener() {
            public void modifyText (ModifyEvent e) {
                doPatternModified();
                updateOKStatus();
            }

        });
        fPattern.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false, 1, 1));

        // Ignore case checkbox
//        fCaseSensitive= new Button(result, SWT.CHECK);
//        fCaseSensitive.setText(ServiceRepositorySearchMessages.SearchPage_expression_caseSensitive);
//        fCaseSensitive.addSelectionListener(new SelectionAdapter() {
//            public void widgetSelected(SelectionEvent e) {
//                fIsCaseSensitive= fCaseSensitive.getSelection();
//            }
//        });
//        fCaseSensitive.setLayoutData(new GridData(SWT.LEFT, GridData.FILL, false, false, 1, 1));
        new Label(result, SWT.NONE);

        Label queryLabel = new Label (result, SWT.NONE);
        queryLabel.setText (ServiceRepositorySearchMessages.SearchPage_query_label);

        queryCombo = new Combo(result, SWT.READ_ONLY);
        initializeQuery();
        queryCombo.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
            	handleQueryNameSelected ();
                updateOKStatus();
            }

        });
        GridData queryData= new GridData(GridData.FILL, GridData.FILL, true, false, 1, 1);
        queryData.widthHint= convertWidthInCharsToPixels(50);
        queryCombo.setLayoutData(queryData);
        
        new Label(result, SWT.NONE);

        
        Label scopeLabel = new Label (result, SWT.NONE);
        scopeLabel.setText (ServiceRepositorySearchMessages.SearchPage_searchFor_label);

        searchForCombo = new Combo(result, SWT.NONE);
        initializeSearchFor();
        searchForCombo.setLayoutData (new GridData (SWT.FILL, SWT.FILL, true, false, 1, 1));
        searchForCombo.addSelectionListener (new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                handleAssetTypeSelected();
                updateOKStatus();
            }

        });
        searchForCombo.addModifyListener (new ModifyListener() {
	        public void modifyText (ModifyEvent e) {
	            doSearchForModified();
	        }

        });
        new Label(result, SWT.NONE);
        
        Control limitToControl = createLimitTo(parent);
        limitToControl.setVisible(true);
        
        
        new Label(limitToGroup, SWT.NONE);
        new Label(limitToGroup, SWT.NONE);
        
        new Label(limitToGroup, SWT.NONE);
        new Label(limitToGroup, SWT.NONE);
        new Label(limitToGroup, SWT.NONE);
        
        setControl(result);
        
        return result;
	}
	
    private Control createLimitTo(Composite parent) {
    	limitToGroup= new Group(parent, SWT.NONE);
    	limitToGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
     	limitToGroup.setVisible(false);
    	limitToGroup.setText(ServiceRepositorySearchMessages.SearchPage_limitTo_label);
    	GridLayout gl_limitToGroup = new GridLayout(5, false);
    	gl_limitToGroup.marginTop = 5;
    	limitToGroup.setLayout(gl_limitToGroup);
        fillLimitToGroup();
        return limitToGroup;
	}

	private void fillLimitToGroup() {
		Control[] children = limitToGroup.getChildren();
		for (Control child : children) {
			child.dispose();
		}
        
        Label minStateLabel = new Label (limitToGroup, SWT.NONE);
        GridData gd_minStateLabel = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
        gd_minStateLabel.widthHint = 121;
        minStateLabel.setLayoutData(gd_minStateLabel);
        minStateLabel.setText (ServiceRepositorySearchMessages.SearchPage_minState_label);
        
        minStateCombo = new Combo(limitToGroup, SWT.NONE);
        minStateCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

        new Label(limitToGroup, SWT.NONE);
        
        Label minVersionLabel = new Label (limitToGroup, SWT.NONE);
        GridData gd_minVersionLabel = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
        gd_minVersionLabel.widthHint = 121;
        minVersionLabel.setLayoutData(gd_minVersionLabel);
        minVersionLabel.setText (ServiceRepositorySearchMessages.SearchPage_minVersion_label);
        
        minVersionText = new Text (limitToGroup, SWT.BORDER);
        GridData gd_minVersionText = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
        gd_minVersionText.widthHint = 245;
        minVersionText.setLayoutData(gd_minVersionText);

        Label maxStateLabel = new Label (limitToGroup, SWT.NONE);
        maxStateLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        maxStateLabel.setText (ServiceRepositorySearchMessages.SearchPage_maxState_label);
        
        maxStateCombo = new Combo(limitToGroup, SWT.NONE);
        maxStateCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        

        new Label(limitToGroup, SWT.NONE);

        Label maxVersionLabel = new Label (limitToGroup, SWT.NONE);
        maxVersionLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        maxVersionLabel.setText (ServiceRepositorySearchMessages.SearchPage_maxVersion_label);
        
        maxVersionText = new Text (limitToGroup, SWT.BORDER);
        maxVersionText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

        initializeStates();
        
        canonicalCheckButton = new Button(limitToGroup, SWT.CHECK);
        canonicalCheckButton.setText(ServiceRepositorySearchMessages.SearchPage_canonical_label);

        new Label(limitToGroup, SWT.NONE);
        new Label(limitToGroup, SWT.NONE);
        
        Label tagsLabel = new Label (limitToGroup, SWT.NONE);
        tagsLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        tagsLabel.setText (ServiceRepositorySearchMessages.SearchPage_tags_label);
        
        tagsText = new Text (limitToGroup, SWT.BORDER);
        tagsText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

        nonCanonicalCheckButton = new Button(limitToGroup, SWT.CHECK);
        nonCanonicalCheckButton.setText(ServiceRepositorySearchMessages.SearchPage_noncanonical_label);

        new Label(limitToGroup, SWT.NONE);
        new Label(limitToGroup, SWT.NONE);
        oneOfTagsRadioButton = new Button(limitToGroup, SWT.RADIO);
        oneOfTagsRadioButton.addSelectionListener(new SelectionAdapter() {
        	
        	public void widgetSelected(SelectionEvent e) {
        		allTags = false; 
        	}
        });
        oneOfTagsRadioButton.setText(ServiceRepositorySearchMessages.ServiceRepositorySearchPage_oneOfTagsRadioButton_text);
        oneOfTagsRadioButton.setSelection(true);
        withTagsFromParentButton = new Button(limitToGroup, SWT.CHECK);
        withTagsFromParentButton.setText(ServiceRepositorySearchMessages.SearchPage_parentTags_label);
        new Label(limitToGroup, SWT.NONE);
        new Label(limitToGroup, SWT.NONE);
        new Label(limitToGroup, SWT.NONE);
        allOfTagsRadioButton = new Button(limitToGroup, SWT.RADIO);
        allOfTagsRadioButton.addSelectionListener(new SelectionAdapter() {
        	
        	public void widgetSelected(SelectionEvent e) {
        		allTags = true;
        	}
        });
        allOfTagsRadioButton.setText(ServiceRepositorySearchMessages.ServiceRepositorySearchPage_allOfTagsRadioButton_text);
        allOfTagsRadioButton.setSelection(false);

        new Label(limitToGroup, SWT.NONE);

        canonicalCheckButton.setSelection(true);
        nonCanonicalCheckButton.setSelection(true);

        Dialog.applyDialogFont(limitToGroup); // re-apply font as we disposed the previous widgets
        limitToGroup.layout();
	}


    public void dispose() {
        writeConfiguration();
        super.dispose();
    }
    
    private void initializeSearchFor () {
        searchForCombo.setItems(new String[] {"Any", "Service ", "Operation ", "BusinessObject ", "QueryObject ", "Enumeration ", "Exception ", "Type ", "Module ", "ModuleBinding ", "Environment ", "ESB ", "AppServer ", "Host ", "Solution "});
    }
    
    private void initializeQuery () {
        queryCombo.setItems(new String[] {"Any asset", "Unapproved assets"});
        queryCombo.select(0);
    }
    
    private void initializeStates () {
    	minStateCombo.add("");
    	maxStateCombo.add("");
    	Predicate<IEObjectDescription> predicate = Predicates.alwaysTrue();
    	Iterable<IEObjectDescription> states = predicateSearch.search(ProfileDslPackage.Literals.LIFECYCLE_STATE.getName(), predicate);
    	List<String> stateNames = new ArrayList<String>();
    	for (IEObjectDescription stateDesc : states) {
			String state = stateDesc.getQualifiedName().getLastSegment();
			if (! stateNames.contains(state))
				stateNames.add (state);
		}
    	for (String state : stateNames) {
			minStateCombo.add(state);
			maxStateCombo.add(state);
		}
    }
    
    private String[] getPreviousSearchPatterns() {
        // Search results are not persistent
        int patternCount= fPreviousSearchPatterns.size();
        String [] patterns= new String[patternCount];
        for (int i= 0; i < patternCount; i++)
            patterns[i]= ((ServiceRepositoryQueryData) fPreviousSearchPatterns.get(i)).getPattern();
        return patterns;
    }


    private void updateOKStatus() {
		getContainer().setPerformActionEnabled (true);
	}   

    private void handlePatternSelected() {
        int selectionIndex= fPattern.getSelectionIndex();
        if (selectionIndex < 0 || selectionIndex >= fPreviousSearchPatterns.size())
            return;

        ServiceRepositoryQueryData initialData= (ServiceRepositoryQueryData) fPreviousSearchPatterns.get(selectionIndex);
        setSearchFor(initialData.getSearchFor());

        fPattern.setText(initialData.getPattern());
//        fIsCaseSensitive = initialData.isCaseSensitive();
        fElement = initialData.getEObject();
//        fCaseSensitive.setEnabled (fJavaElement == null);
//        fCaseSensitive.setSelection (initialData.isCaseSensitive());

        if (initialData.getWorkingSets() != null)
            getContainer().setSelectedWorkingSets(initialData.getWorkingSets());
        else
            getContainer().setSelectedScope(initialData.getScope());

        fInitialData = initialData;
    }

    private void doPatternModified() {
        if (fInitialData != null && getQueryData().equals(fInitialData.getPattern()) && fInitialData.getEObject() != null && fInitialData.getSearchFor() == getSearchFor()) {
//            fCaseSensitive.setEnabled(false);
//            fCaseSensitive.setSelection(true);
            fElement= fInitialData.getEObject();
        } else {
//            fCaseSensitive.setEnabled(true);
//            fCaseSensitive.setSelection(fIsCaseSensitive);
            fElement= null;
        }
    }

	protected void handleQueryNameSelected() {
	}

	private void doSearchForModified() {
		// TODO Auto-generated method stub
				
	}
	private void handleAssetTypeSelected() {
		// TODO Auto-generated method stub
				
	}


    private boolean performNewSearch() {
    	ServiceRepositoryQueryData data= getQueryData();

        // Setup search scope
        String scopeDescription= ""; //$NON-NLS-1$

        String searchFor= data.getSearchFor();

        switch (getContainer().getSelectedScope()) {
            case ISearchPageContainer.WORKSPACE_SCOPE:
                break;
            case ISearchPageContainer.SELECTION_SCOPE:
                break;
            case ISearchPageContainer.SELECTED_PROJECTS_SCOPE: {
                String[] projectNames= getContainer().getSelectedProjectNames();
                break;
            }
            case ISearchPageContainer.WORKING_SET_SCOPE: {
                IWorkingSet[] workingSets= getContainer().getSelectedWorkingSets();
                // should not happen - just to be sure
                if (workingSets == null || workingSets.length < 1)
                    return false;
//                SearchUtil.updateLRUWorkingSets(workingSets);
            }
        }
        
       	ServiceRepositoryQuerySpec querySpec= new ServiceRepositoryQuerySpec (
       			data.getPattern(), 
       			data.getSearchFor(), 
       			data.getQueryName(), 
       			data.isCaseSensitive(), 
       			scopeDescription);
       	
       	querySpec.setMinState (getMinState());
       	querySpec.setMaxState (getMaxState());
       	querySpec.setMinVersion (getMinVersion());
       	querySpec.setMaxVersion (getMaxVersion());
       	querySpec.setCanonicalNamespaces (inclCanonicalModel());
       	querySpec.setNonCanonicalNamespaces (inclNonCanonicalModel());
       	querySpec.setTagNames (getTagNames());
       	querySpec.setWithTagsFromParent (isWithTagsFromParent());
       	querySpec.setAllTags(isAllTags());

        ServiceRepositorySearchQuery textSearchJob= injector.getInstance (ServiceRepositorySearchQuery.class);
        textSearchJob.init (querySpec);
        NewSearchUI.runQueryInBackground (textSearchJob);
        return true;
    }

    
    private String getQueryName() {
        return queryCombo.getText();
    }
    
    private void setQueryName(String queryName) {
    	queryCombo.setText(queryName);
    }
    
    private String getMinState () {
    	return minStateCombo.getText();
    }
    
    private String getMaxState () {
    	return maxStateCombo.getText();
    }
    private String getMinVersion () {
    	return minVersionText.getText();
    }
    
    private String getMaxVersion () {
    	return maxVersionText.getText();
    }
    
    private boolean inclCanonicalModel() {
    	if(canonicalCheckButton == null)
    		return true;
    	return canonicalCheckButton.getSelection();
    }
    
    private boolean inclNonCanonicalModel() {
    	if(nonCanonicalCheckButton == null)
    		return true;
    	return nonCanonicalCheckButton.getSelection();
    }
    
    private boolean isWithTagsFromParent() {
    	if (withTagsFromParentButton == null)
    		return false;
    	return withTagsFromParentButton.getSelection();
    }
    
    private boolean isAllTags () {
    	return allTags;
    }
    
    private List<String> getTagNames () {
    	String tagString = tagsText.getText();
    	tagString = tagString.replaceAll("  ", " ");
    	tagString = tagString.replaceAll(",", " ");
    	String[] tagArray = tagString.split(" ");
    	List<String> tagNames = new ArrayList<String>();
    	for (String tag : tagArray) {
    		String trimmedTagName = tag.trim();
    		if (!"".equals(trimmedTagName)) {
    			tagNames.add (trimmedTagName);
    		}
		}
    	return tagNames;
    }
    
    private String getSearchFor() {
        return searchForCombo.getText();
    }

    private void setSearchFor(String searchFor) {
    	searchForCombo.setText(searchFor);
    }

    private String getPattern() {
        return fPattern.getText();
    }

    private ServiceRepositoryQueryData findInPrevious(String pattern) {
        for (Iterator iter= fPreviousSearchPatterns.iterator(); iter.hasNext();) {
        	ServiceRepositoryQueryData element= (ServiceRepositoryQueryData) iter.next();
            if (pattern.equals(element.getPattern())) {
                return element;
            }
        }
        return null;
    }

	private ServiceRepositoryQueryData getQueryData() {
		String pattern = getPattern();
		ServiceRepositoryQueryData match = findInPrevious(pattern);
		if (match != null) {
			fPreviousSearchPatterns.remove(match);
		}
		String queryName = "Any";
		if ("Unapproved assets".equals(getQueryName())) {
			queryName = FindUnapprovedAssetsQuery.class.getName();
		} else {
			queryName = FindAssetsWithStateQuery.class.getName();
		}
		match = new ServiceRepositoryQueryData(
				queryName,
				getSearchFor(), 
				pattern,
//				fCaseSensitive.getSelection(), 
				false,
				fElement, 
				getContainer().getSelectedScope(), 
				getContainer().getSelectedWorkingSets());
		if (queryName == FindAssetsWithStateQuery.class.getName()) {
			match.setMinState(getMinState());
			match.setMaxState(getMaxState());
		}

		fPreviousSearchPatterns.add(0, match); // insert on top
		return match;
	}

    private ServiceRepositoryQueryData getDefaultInitValues() {
        if (!fPreviousSearchPatterns.isEmpty()) {
            return (ServiceRepositoryQueryData) fPreviousSearchPatterns.get(0);
        }

        return new ServiceRepositoryQueryData(ANY_ASSET_QUERY, DEFAULT_ASSET_TYPE, fIsCaseSensitive, DEFAULT_PATTERN, null); //$NON-NLS-1$
    }

	public void setContainer(ISearchPageContainer container) {
		fContainer = container;
	}
	
    /**
     * Returns the search page's container.
     * @return the search page container
     */
    private ISearchPageContainer getContainer() {
        return fContainer;
    }

    private IEditorPart getActiveEditor(ExecutionEvent event) {
		XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
        return editor;
    }

    //--------------- Configuration handling --------------

    /**
     * Returns the page settings for this Java search page.
     *
     * @return the page settings to be used
     */
    private IDialogSettings getDialogSettings() {
        if (fDialogSettings == null) {
        	fDialogSettings = DialogSettings.getOrCreateSection (
        			ServiceRepositoryActivator.getInstance().getDialogSetting(DIALOG_SETTINGS_SECTION), DIALOG_SETTINGS_SECTION);
        }
        return fDialogSettings;
    }

    /**
     * Initializes itself from the stored page settings.
     */
    private void readConfiguration() {
        IDialogSettings s= getDialogSettings();
        fIsCaseSensitive= s.getBoolean(STORE_CASE_SENSITIVE);
        String pattern = s.get(STORE_PATTERN);
        if (pattern != null) {
        	fPattern.setText(s.get(STORE_PATTERN));
        }
        String query = s.get(STORE_QUERY);
        if (query != null) {
        	queryCombo.setText(query);
        }
        String searchFor = s.get(STORE_SEARCH_FOR);
        if (searchFor != null) {
        	searchForCombo.setText(searchFor);
        }

        try {
            int historySize= s.getInt(STORE_HISTORY_SIZE);
            for (int i= 0; i < historySize; i++) {
                IDialogSettings histSettings= s.getSection(STORE_HISTORY + i);
                if (histSettings != null) {
                	ServiceRepositoryQueryData data= ServiceRepositoryQueryData.create(histSettings);
                    if (data != null) {
                        fPreviousSearchPatterns.add(data);
                    }
                }
            }
        } catch (NumberFormatException e) {
            // ignore
        }
    }

    /**
     * Stores the current configuration in the dialog store.
     */
    private void writeConfiguration() {
        IDialogSettings s= getDialogSettings();
        s.put(STORE_PATTERN, fPattern.getText());
        s.put(STORE_QUERY, queryCombo.getText());
        s.put(STORE_SEARCH_FOR, searchForCombo.getText());
        s.put(STORE_CASE_SENSITIVE, fIsCaseSensitive);

        int historySize= Math.min(fPreviousSearchPatterns.size(), HISTORY_SIZE);
        s.put(STORE_HISTORY_SIZE, historySize);
        for (int i= 0; i < historySize; i++) {
            IDialogSettings histSettings= s.addNewSection(STORE_HISTORY + i);
            ServiceRepositoryQueryData data= ((ServiceRepositoryQueryData) fPreviousSearchPatterns.get(i));
            data.store(histSettings);
        }
    }



	private static class ServiceRepositoryQueryData {
		private final String queryName;
        private final String searchFor;
        private final String pattern;
        private final boolean isCaseSensitive;
        private final int scope;
        private final IWorkingSet[] workingSets;
        private EObject element;
        private String minState;
        private String maxState;
        private String minVersion;
        private String maxVersion;

        public ServiceRepositoryQueryData (String queryName, String searchFor, boolean isCaseSensitive, String pattern, EObject element) {
            this(queryName, searchFor, pattern, isCaseSensitive, element, ISearchPageContainer.WORKSPACE_SCOPE, null);
        }

        public ServiceRepositoryQueryData (String queryName, String searchFor, String pattern, boolean isCaseSensitive, EObject element, int scope, IWorkingSet[] workingSets) {
        	this.queryName = queryName;
            this.searchFor= searchFor;
            this.pattern= pattern;
            this.isCaseSensitive= isCaseSensitive;
            this.scope= scope;
            this.workingSets= workingSets;

            setEObject(element);
            injector = ServiceRepositoryActivator.getInstance().getInjector();
        }

        public void setEObject(EObject element) {
            this.element= element;
        }

        public boolean isCaseSensitive() {
            return isCaseSensitive;
        }

        public EObject getEObject() {
            return element;
        }

        public String getPattern() {
            return pattern;
        }

        public int getScope() {
            return scope;
        }

        public String getSearchFor() {
            return searchFor;
        }

		public String getQueryName() {
			return queryName;
		}

        public IWorkingSet[] getWorkingSets() {
            return workingSets;
        }

        public void setMinState(String minState) {
			this.minState = minState;
		}

		public String getMinState() {
			return minState;
		}

		public void setMaxState(String maxState) {
			this.maxState = maxState;
		}

		public String getMaxState() {
			return maxState;
		}

		public void store(IDialogSettings settings) {
            settings.put("searchFor", searchFor); //$NON-NLS-1$
            settings.put("scope", scope); //$NON-NLS-1$
            settings.put("pattern", pattern); //$NON-NLS-1$
//            settings.put("element", element != null ? element.getHandleIdentifier() : ""); //$NON-NLS-1$ //$NON-NLS-2$
            settings.put("isCaseSensitive", isCaseSensitive); //$NON-NLS-1$
            if (workingSets != null) {
                String[] wsIds= new String[workingSets.length];
                for (int i= 0; i < workingSets.length; i++) {
                    wsIds[i]= workingSets[i].getName();
                }
                settings.put("workingSets", wsIds); //$NON-NLS-1$
            } else {
                settings.put("workingSets", new String[0]); //$NON-NLS-1$
            }
        }

        public static ServiceRepositoryQueryData create(IDialogSettings settings) {
            String pattern= settings.get("pattern"); //$NON-NLS-1$
            if (pattern.length() == 0) {
                return null;
            }
            EObject elem= null;
            String[] wsIds= settings.getArray("workingSets"); //$NON-NLS-1$
            IWorkingSet[] workingSets= null;
            if (wsIds != null && wsIds.length > 0) {
                IWorkingSetManager workingSetManager= PlatformUI.getWorkbench().getWorkingSetManager();
                workingSets= new IWorkingSet[wsIds.length];
                for (int i= 0; workingSets != null && i < wsIds.length; i++) {
                    workingSets[i]= workingSetManager.getWorkingSet(wsIds[i]);
                    if (workingSets[i] == null) {
                        workingSets= null;
                    }
                }
            }

            try {
                String queryName= settings.get("queryName"); //$NON-NLS-1$
                String searchFor= settings.get("searchFor"); //$NON-NLS-1$
                int scope= settings.getInt("scope"); //$NON-NLS-1$

                boolean isCaseSensitive= settings.getBoolean("isCaseSensitive"); //$NON-NLS-1$

                return new ServiceRepositoryQueryData(queryName, searchFor, pattern, isCaseSensitive, elem, scope, workingSets);
            } catch (NumberFormatException e) {
                return null;
            }
        }

		public String getMinVersion() {
			return minVersion;
		}

		public void setMinVersion(String minVersion) {
			this.minVersion = minVersion;
		}

		public String getMaxVersion() {
			return maxVersion;
		}

		public void setMaxVersion(String maxVersion) {
			this.maxVersion = maxVersion;
		}

    }

}
