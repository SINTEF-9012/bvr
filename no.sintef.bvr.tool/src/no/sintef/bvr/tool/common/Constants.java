/*******************************************************************************
 * Copyright (c) All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.common;

public class Constants {
	public static final String GENERAL_REMOVE_MENU_ITEM = "Remove";
	public static final String GENERAL_ADD_MENU_ITEM = "Add";
	public static final String GENERAL_CHOICE_MENU_ITEM = "Choice";
	public static final String GENERAL_VCLASSIFIER_MENU_ITEM = "VClassifier";
	public static final String GENERAL_PAST_AS_CHILD_MENU_ITEM = "Paste As Child";

	// relaization
	public static final int FRAG_SUBS_VARIATION_POINT_CLMN = 0;
	public static final int FRAG_SUBS_VSPEC_CLMN = 1;

	public static final int FRAG_SUB_VSPEC_CLICK_COUNT_TO_EDIT = 2;
	public static final int FRAG_SUB_FS_CLICK_COUNT_TO_EDIT = FRAG_SUB_VSPEC_CLICK_COUNT_TO_EDIT;
	public static final int SUB_FRAG_FS_CLICK_COUNT_TO_EDIT = FRAG_SUB_VSPEC_CLICK_COUNT_TO_EDIT;
	public static final int BINDING_BOUNDARIES_CLICK_COUNT_TO_EDIT = FRAG_SUB_VSPEC_CLICK_COUNT_TO_EDIT;

	public static final int SUB_FRAG_KIND_CLMN = 0;
	public static final int SUB_FRAG_FRAG_CLMN = 1;

	public static final int BINDING_TYPE_CLMN = 0;
	public static final int BINDING_PROP_CLMN = 1;
	public static final int BINDING_VALUE_CLMN = 2;

	public static final String REALIZATION_TAB_NAME = "Realization";
	public static final String REALIZATION_VP_SUBTAB_NAME = "Variation points";
	public static final String REALIZATION_MAIN_MENU_NAME = "Realization";
	public static final String REALIZATION_CR_PLCMT_NAME = "Create Placement";
	public static final String REALIZATION_CR_RPLCMT_NAME = "Create Replacement";
	public static final String REALIZATION_CR_PLCMT_CNTLESS_NAME = "Create Placement (Containmentless)";
	public static final String REALIZATION_CR_RPLCMT_CNTLESS_NAME = "Create Replacement (Containmentless)";
	public static final String REALIZATION_CR_FS_NAME = "Create FragmentSubstitution";
	public static final String REALIZATION_CLEAR_SELECTION_NAME = "Clear Selection";
	public static final String REALIZATION_DL_PLCMT_RPLCMT_NAME = "Delete Placement/Replacement";
	public static final String REALIZATION_DL_FS_NAME = "Delete FragmentSubstitution";
	public static final String REALIZATION_GENERATE_BINDINGS = "Generate Bindings";
	public static final String REALIZATION_GENERATE_TO_BINDING = "Generate ToBinding (from selection)";
	public static final String REALIZATION_GENERATE_FROM_BINDING = "Generate FromBinding (from selection)";
	public static final String REALIZATION_DELETE_BINDING = "Delete Binding";
	public static final String REALIZATION_DELETE_ALL_BINDING = "Delete All Binding-s";

	public static final String TOOLS_MENU_NAME = "Help";
	public static final String TOOLS_COPY_MODEL = "Copy model";
	public static final String TOOLS_OPTIONS = "Options";

	public static final String FRAG_SUB_VP_CLMN_NAME = "Variation points";
	public static final String FRAG_SUB_VSPEC_CLMN_NAME = "VSpec";

	public static final String SUB_FRAG_KIND_CLMN_NAME = "Kind";
	public static final String SUB_FRAG_FRAG_CLMN_NAME = "Fragment";
	public static final String SUB_FRAG_TYPE_PLC_NAME = "Placement";
	public static final String SUB_FRAG_TYPE_RPLC_NAME = "Replacement";

	public static final String BINDING_TYPE_CLMN_NAME = "Type";
	public static final String BINDING_PROPERTY_CLMN_NAME = "[Object].property";
	public static final String BINDING_VALUE_CLMN_NAME = "Values";
	public static final String BINDING_TYPE_TO_BINDING_NAME = "ToBinding";
	public static final String BINDING_TYPE_FROM_BINDING_NAME = "FromBinding";
	public static final String BINDING_EDITOR_NAME = "Bindings";
	public static final String NULL_NAME = "NULL";

	public static final String RESOLUTION_EXECUTE_NAME = "Execute";
	public static final String RESOLUTION_EXECUTE_ALL_NAME = "Execute All";
	public static final String PLACEMENT_DEFAULT_NAME = "PlacementFragment";
	public static final String REPLACEMENT_DEFAULT_NAME = "ReplacementFragment";

	public static final int CODE_MODEL_SAVE_OK = 0;
	public static final int CODE_MODEL_SAVE_INCORRECT_LOCATION = 1;
	public static final int CODE_MODEL_SAVE_IOEXCEPTION = 2;

	public static final String SETTINGS_FROMPLACEMENT_PERMUTATION = "FromPlacement permutation";
	public static final String SETTINGS_TOREPLACEMENT_PERMUTATION = "ToReplacement permutation";
	public static final String SETTINGS_CONTAINMENT_SELECTION_MODE = "Containment selection mode";
	public static final String SETTINGS_HIGHLIGHTING_MODE = "Highlight fragments";
	public static final String SETTINGS_DETECT_INERSECTION = "Detect intersection";

	public static final String PLUGIN_ID = "no.sintef.bvr.tool";

	/*
	 * //placement colors public static final Color RED = new
	 * Color(Display.getDefault(), 240, 70, 0); // placement elements public
	 * static final Color ORANGE = new Color(Display.getDefault(), 240, 170, 0);
	 * //fromPlacement outside element public static final Color VIOLET = new
	 * Color(Display.getDefault(), 126, 0, 123); //toPlacement outside element
	 *
	 * //replacement colors public static final Color BLUE = new
	 * Color(Display.getDefault(), 50, 80, 250); //replacement elements public
	 * static final Color GREEN = new Color(Display.getDefault(), 80, 210, 70);
	 * //fromReplacement outside element public static final Color PINK = new
	 * Color(Display.getDefault(), 255, 0, 255); // toReplacement outside
	 * element
	 */

	public static final String RESOLUTION_DROPDOWN_RESOLVE_CHOICE_ITEM = "Resolve " + GENERAL_CHOICE_MENU_ITEM;
	public static final String RESOLUTION_DROPDOWN_RESOLVE_VCLASS_ITEM = "Resolve " + GENERAL_VCLASSIFIER_MENU_ITEM;
	public static final String RESOLUTION_DROPDOWN_RESOLVE_VAR_ITEM = "Resolve Varibale";
	public static final String RESOLUTION_DROPDOWN_VINST_SUBTREE_ITEM = "Resolve Multiple VClassifier";
	public static final String RESOLUTION_DROPDOWN_RESOLVE_SUBTREE_ITEM = "Resolve Subtree";
	public static final String RESOLUTION_DROPDOWN_MININIZE_ITEM = "Minimize";
	public static final String RESOLUTION_DROPDOWN_MAXIMIZE_ITEM = "Maximize";
	public static final String RESOLUTION_DROPDOWN_REMOVE_ITEM = GENERAL_REMOVE_MENU_ITEM;
	public static final String RESOLUTION_DROPDOWN_VALIDATE_ITEM = "Validate";
	public static final String DEFAULT_TYPE_TITLE = "Undefined";
	public static final String RESOLUTION_DROPDOWN_RESOLVE_CHOICE_OCC_ITEM = "Resolve ChoiceOccurence";
	public static final String RESOLUTION_DROPDOWN_RESOLVE_VCLASS_OCC_ITEM = "Resolve VClassOccurence";
	public static final String RESOLUTION_DROPDOWN_REMOVE_UNCONTAINED = "Remove uncontained resolutions";

	public static final String RESOLUTION_NEW = "New";
	public static final String RESOLUTION_RENAME = "Rename";
	public static final String RESOLUTION_REMOVE = "Remove";
	public static final String RESOLUTION_REMOVE_ALL = "Remove All";
	public static final String RESOLUTION_IMPORT = "Import...";
	public static final String RESOLUTION_MODELS_CHOICES_ONLY = "Models With Choices";
	public static final String RESOLUTION_MODEL_CHOICES_ONLY = "Model With Choices";
	public static final String RESOLUTION_MODELS_CHOICES_ONLY_VALIDATE = "Validate Resolutions";
	public static final String RESOLUTION_MODELS_CHOICES_CALC_COV = "Calculate Covarege";
	public static final String RESOLUTION_MODELS_CHOICES_1_WISE = "1-Wise";
	public static final String RESOLUTION_MODELS_CHOICES_2_WISE = "2-Wise";
	public static final String RESOLUTION_MODELS_CHOICES_3_WISE = "3-Wise";
	public static final String RESOLUTION_MODELS_CHOICES_ALL_PROD = "Generate All Products";
	public static final String RESOLUTION_MODELS_CHOICES_GEN_COV_ARRAY = "Generate Covering Array";
	public static final String RESOLUTION_MODELS_CHOICES_CALC_COSTS = "Calculate Costs";
	public static final String RESOLUTION_MODELS_EXPORT_AS_PNG = "Export As PNG";
	public static final String RESOLUTION_MODELS_SHOWHIDE_GRP = "Show/Hide Grouping";
	public static final String RESOLUTION_MODELS_SHOWHIDE_CNSTR = "Show/Hide Constraints";
	public static final String RESOLUTION_MODELS_EXECUTE = "Execute";

	public static final String VSPEC_DROPDOWN_ADD = "Add";
	public static final String VSPEC_DROPDOWN_ADD_CHOICE = "Choice";
	public static final String VSPEC_DROPDOWN_ADD_VCLASSIFIER = "VClassifier";
	public static final String VSPEC_DROPDOWN_ADD_CONSTRAINT = "Constraint";
	public static final String VSPEC_DROPDOWN_ADD_VARIABLE = "Variable";
	public static final String VSPEC_DROPDOWN_ADD_VTYPE = "VType";
	public static final String VSPEC_DROPDOWN_ADD_CHOICEOCC = "ChoiceOccurence";
	public static final String VSPEC_DROPDOWN_ADD_VCLASSOCC = "VClassOccurence";
	public static final String VSPEC_DROPDOWN_REMOVE = "Remove";
	public static final String VSPEC_DROPDOWN_CUT = "Cut";
	public static final String VSPEC_DROPDOWN_PAST_CHILD = "Past As Child";
	public static final String VSPEC_DROPDOWN_PAST_SIBLING = "Past As Sibling";
	public static final String VSPEC_DROPDOWN_TOGGLE = "Un-/Toggle Optional";
	public static final String VSPEC_DROPDOWN_SET_GROUP = "Set Group";
	public static final String VSPEC_DROPDOWN_SET_GROUP_NONE = "None (0..*)";
	public static final String VSPEC_DROPDOWN_SET_GROUP_XOR = "Xor (1..1)";
	public static final String VSPEC_DROPDOWN_SET_GROUP_OR = "Or (1..*)";
	public static final String VSPEC_DROPDOWN_SET_GROUP_CUSTOM = "Custom...";
	public static final String VSPEC_DROPDOWN_MINIMIZE = RESOLUTION_DROPDOWN_MININIZE_ITEM;
	public static final String VSPEC_DROPDOWN_MAXIMIZE = RESOLUTION_DROPDOWN_MAXIMIZE_ITEM;
	public static final String VSPEC_VTYPE_TITLE = "VType";
	public static final String NULL_TARGET = "[NULL]";

}
