package no.sintef.cvl.ui.thirdparty;

import java.util.ArrayList;

import no.sintef.cvl.ui.common.Constants;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.graphics.Color;

/** 
 * This interface should be implemented by the the DSL EditorPart.
 * An example editor is provided in package cvl.emfEditor.
 */
public interface ICVLEnabledEditor {
	
	public static final int HL_NONE = 0; // no highlighting
	public static final int HL_PLACEMENT = 1; // placement, usually red
	public static final int HL_REPLACEMENT = 2; // replacement, usually blue
	public static final int HL_PLACEMENT_OUT = 3; // placement_out, usually orange
	public static final int HL_REPLACEMENT_OUT = 4; // replacement, usually green
	public static final int HL_PLACEMENT_IN = 5; // placement_out, usually violet
	public static final int HL_REPLACEMENT_IN = 6; // placement_out, usually pink
	
	/**
	 * Highlight in the editor the object identified by xmi_id with the color 
	 * corresponding to type. 
	 * The ID of object is provided by the static operation
	 * ICVLEnabledEditor.IDProvider.getObjectId(EObject obj). Only this operation
	 * should be used to compute the ID of EObjects.
	 * @param xmi_id The ID of the object
	 * @param type The type of highlighting to use
	 */
	public void highlightObject(String xmi_id, int type);
	
	/**
	 * Remove highlighting for all object in the editor
	 */
	public void clearHighlighting();
	
	/**
	 * Get the editor selection 
	 * @return The set of domain objects (instances of the DSL meta-model) 
	 * selected in the editor
	 */
	public ArrayList<Object> getSelectedObjects();
	
	/**
	 * Set the selection of the editor
	 * @param objects The IDs of the set of domain object which should be selected
	 */
	public void selectObjects(ArrayList<String> objects);
	
	static class IDProvider {
		private IDProvider() {}
		
		/**
		 * Returns the XMI ID of an EObject
		 * @param obj the object
		 * @return String the XMI ID
		 */
		public static String getObjectId(EObject obj) {
			String id = EcoreUtil.getIdentification(obj);
			int index = id.indexOf('{');
			if (index > -1)
				id = id.substring(index + 1, id.length() - 1);
			return id;
		}
	}
	
	static class CVLColorConstants {
		public static final Color PLACEMENT = Constants.RED;
		public static final Color PLACEMENT_OUT = Constants.ORANGE;
		public static final Color PLACEMENT_IN = Constants.VIOLET;
		
		public static final Color REPLACEMENT = Constants.BLUE;
		public static final Color REPLACEMENT_OUT = Constants.GREEN;
		public static final Color REPLACEMENT_IN = Constants.PINK;
	}
}
