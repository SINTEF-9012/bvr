package no.sintef.cvl.thirdparty.editor;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

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
	public static final int HL_REPLACEMENT_IN = 6; // replacement_in, usually pink
	
	public static final Color PLACEMENT = new Color(Display.getDefault(), 240, 70, 0); // placement elements = red
	public static final Color PLACEMENT_OUT = new Color(Display.getDefault(), 240, 170, 0); //fromPlacement outside element = orange
	public static final Color PLACEMENT_IN = new Color(Display.getDefault(), 126, 0, 123); //toPlacement outside element = violet
	//public static final Color PLACEMENT_IN = PLACEMENT;
	
	public static final Color REPLACEMENT = new Color(Display.getDefault(), 50, 80, 250); //replacement elements = blue
	public static final Color REPLACEMENT_OUT = new Color(Display.getDefault(), 80, 210, 70); //fromReplacement outside element = green
	public static final Color REPLACEMENT_IN = new Color(Display.getDefault(), 255, 0, 255); // toReplacement outside element = pink
	//public static final Color REPLACEMENT_IN = REPLACEMENT;
	
	/**
	 * Highlight in the editor the object identified by xmi_id with the color 
	 * corresponding to type. 
	 * The ID of object is provided by the static operation
	 * ICVLEnabledEditor.IDProvider.getObjectId(EObject obj). Only this operation
	 * should be used to compute the ID of EObjects.
	 * @param xmi_id The ID of the object
	 * @param type The type of highlighting to use
	 */
	public void highlightObject(Object object, int type);
	
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
	public void selectObjects(ArrayList<Object> objects);
	
	public static class IDProvider {
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
}
