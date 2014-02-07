package no.sintef.bvr.thirdparty.editor;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

/** 
 * This interface should be implemented by the the DSL EditorPart.
 * An example editor is provided in package bvr.emfEditor.
 */
public interface IBVREnabledEditor {
	
	public static final int HL_NONE = 0; // no highlighting
	public static final int HL_PLACEMENT = 1; // placement,  red
	public static final int HL_REPLACEMENT = 2; // replacement,  blue
	public static final int HL_PLACEMENT_OUT = 3; // placement_out,  orange
	public static final int HL_REPLACEMENT_OUT = 4; // replacement,  green
	public static final int HL_PLACEMENT_IN = 5; // placement_out,  violet
	public static final int HL_REPLACEMENT_IN = 6; // replacement_in,  pink
	public static final int HL_PLACEMENT_IN_OUT = 7; // placement_in_out,  yellow
	public static final int HL_REPLACEMENT_IN_OUT = 8; // replacement_in_out,  
	
	public static final Color PLACEMENT = new Color(Display.getDefault(), 240, 70, 0); // placement elements = red
	public static final Color PLACEMENT_OUT = new Color(Display.getDefault(), 240, 170, 0); //fromPlacement outside element = orange
	public static final Color PLACEMENT_IN = new Color(Display.getDefault(), 126, 0, 123); //toPlacement outside element = violet
	public static final Color PLACEMENT_IN_OUT = new Color(Display.getDefault(), 0, 238, 250); // frotoPlacement outside element = light blue
	//public static final Color PLACEMENT_IN = PLACEMENT;
	
	public static final Color REPLACEMENT = new Color(Display.getDefault(), 50, 80, 250); //replacement elements = blue
	//public static final Color REPLACEMENT_OUT = new Color(Display.getDefault(), 80, 210, 70); //fromReplacement outside element = green
	//public static final Color REPLACEMENT_IN = new Color(Display.getDefault(), 255, 0, 255); // toReplacement outside element = pink
	//public static final Color REPLACEMENT_IN_OUT = new Color(Display.getDefault(), 253, 247, 2); //fromtoReplacement outside element = yellow
	//public static final Color REPLACEMENT_IN = REPLACEMENT;
	
	public static final Color REPLACEMENT_OUT = PLACEMENT_OUT;
	public static final Color REPLACEMENT_IN = PLACEMENT_IN;
	public static final Color REPLACEMENT_IN_OUT = PLACEMENT_IN_OUT;
	
	/**
	 * Highlight in the editor the object identified by xmi_id with the color 
	 * corresponding to type. 
	 * The ID of object is provided by the static operation
	 * IBVREnabledEditor.IDProvider.getObjectId(EObject obj). Only this operation
	 * should be used to compute the ID of EObjects.
	 * @param object The object to highlight
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
		 * Returns the identification which is a fully resolved URI to  an EObject
		 * @param obj the object
		 * @return String the id
		 */
		public static String getObjectId(EObject obj){
			String id = EcoreUtil.getIdentification(obj);
			int index = id.indexOf('{');
			if (index > -1)
			id = id.substring(index + 1, id.length() - 1);
			return id;
		}
		
		/**
		 * Returns the XMI ID of an EObject
		 * @param obj the object
		 * @return String the XMI ID
		 */
		public static String getXMIId(EObject obj) {
			String id = EMFCoreUtil.getProxyID(obj);
			return id;
		}
	}
}
