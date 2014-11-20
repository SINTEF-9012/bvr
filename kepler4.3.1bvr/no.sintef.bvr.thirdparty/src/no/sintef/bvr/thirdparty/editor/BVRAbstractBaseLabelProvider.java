package no.sintef.bvr.thirdparty.editor;

import java.util.ArrayList;
import java.util.HashMap;

import no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;



public abstract class BVRAbstractBaseLabelProvider implements ILabelProvider {

	protected HashMap<String, Integer> highlight = new HashMap<String, Integer>();
	protected ILabelProvider labelProvider;
	
	public BVRAbstractBaseLabelProvider(ILabelProvider _lableProvider) {
		labelProvider = _lableProvider;
	}
	
	public void clearHighlighting() {
		highlight.clear();
	}

	public void highlightObjects(ArrayList<String> xmi_ids, int type) {
		if (type == IBVREnabledEditor.HL_NONE) {
			for(String xmi_id : xmi_ids) highlight.remove(xmi_id);
		}
		else {
			for(String xmi_id : xmi_ids) highlight.put(xmi_id, type);
		}
	}
	
	public void highlightObject(String xmi_id, int type) {
		if (type == IBVREnabledEditor.HL_NONE) {
			highlight.remove(xmi_id);
		}
		else {
			highlight.put(xmi_id, type);
		}
	}
	
	@Override
	public void addListener(ILabelProviderListener listener) {
		labelProvider.addListener(listener);
		
	}

	@Override
	public void dispose() {
		labelProvider.dispose();
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return labelProvider.isLabelProperty(element, property);
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		labelProvider.removeListener(listener);
	}
	
	@Override
	public Image getImage(Object element) {
		return labelProvider.getImage(element);
	}
	
	@Override
	public String getText(Object element) {
		return labelProvider.getText(element);
	}
}
