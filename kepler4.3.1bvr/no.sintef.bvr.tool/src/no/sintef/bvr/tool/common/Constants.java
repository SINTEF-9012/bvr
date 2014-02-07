package no.sintef.bvr.tool.common;

public class Constants {
	
	//relaization
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
	public static final String SETTINGS_HIGHLIGHTING_MODE = "Highlightinh mode (on/off)";
	
	/*//placement colors
	public static final Color RED = new Color(Display.getDefault(), 240, 70, 0); // placement elements
	public static final Color ORANGE = new Color(Display.getDefault(), 240, 170, 0); //fromPlacement outside element
	public static final Color VIOLET = new Color(Display.getDefault(), 126, 0, 123); //toPlacement outside element
	
	//replacement colors
	public static final Color BLUE = new Color(Display.getDefault(), 50, 80, 250); //replacement elements
	public static final Color GREEN = new Color(Display.getDefault(), 80, 210, 70); //fromReplacement outside element
	public static final Color PINK = new Color(Display.getDefault(), 255, 0, 255); // toReplacement outside element
	*/
}
