package no.sintef.cvl.thirdparty.editor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import no.sintef.cvl.thirdparty.editor.ICVLEnabledEditor.IDProvider;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableFontProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;


public class CVLLabelProvider implements ILabelProvider, ITableLabelProvider, INotifyChangedListener, IColorProvider, ITableColorProvider, IFontProvider, ITableFontProvider {
	
	protected AdapterFactoryLabelProvider adapterFactoryLabelProvider = null;
	
	protected HashMap<String, Integer> highlight = new HashMap<String, Integer>();
	
	public CVLLabelProvider(AdapterFactoryLabelProvider adapterFactoryLabelProvider) {
		this.adapterFactoryLabelProvider = adapterFactoryLabelProvider;
	}
	
	FontRegistry registry = new FontRegistry();
	
	@Override
	public Font getFont(Object element) {
		return getFont(element, 0);
	}

	@Override
	public Color getBackground(Object element) {
		return getBackground(element, 0);
	}

	@Override
	public Color getForeground(Object element) {
		return getForeground(element, 0);
	}

	@Override
	public Font getFont(Object element, int columnIndex) {
		if (highlight.containsKey(element)) {
			return registry.getBold(Display.getCurrent().getSystemFont().getFontData()[0].getName());
		}
		return null;
	}

	@Override
	public Color getBackground(Object element, int columnIndex) {
		return null;
	}

	@Override
	public Color getForeground(Object element, int columnIndex) {
		if(!(element instanceof EObject)) return null;
		if(!highlight.containsKey(IDProvider.getObjectId((EObject) element))) return null;
		
		switch (highlight.get(IDProvider.getObjectId((EObject) element))) {
		case ICVLEnabledEditor.HL_PLACEMENT : 
			return ICVLEnabledEditor.PLACEMENT;
		case ICVLEnabledEditor.HL_PLACEMENT_OUT : 
			return ICVLEnabledEditor.PLACEMENT_OUT;
		case ICVLEnabledEditor.HL_PLACEMENT_IN : 
			return ICVLEnabledEditor.PLACEMENT_IN;
		case ICVLEnabledEditor.HL_REPLACEMENT : 
			return ICVLEnabledEditor.REPLACEMENT;
		case ICVLEnabledEditor.HL_REPLACEMENT_OUT : 
			return ICVLEnabledEditor.REPLACEMENT_OUT;
		case ICVLEnabledEditor.HL_REPLACEMENT_IN : 
			return ICVLEnabledEditor.REPLACEMENT_IN;
		default : 
			return null;
		}
	}

	@Override
	public Image getImage(Object element) {
		return adapterFactoryLabelProvider.getImage(element);
	}

	@Override
	public String getText(Object element) {
		return adapterFactoryLabelProvider.getText(element);
	}

	@Override
	public void notifyChanged(Notification notification) {
		adapterFactoryLabelProvider.notifyChanged(notification);
		
	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return adapterFactoryLabelProvider.getColumnImage(element, columnIndex);
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		return adapterFactoryLabelProvider.getColumnText(element, columnIndex);
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		adapterFactoryLabelProvider.addListener(listener);
		
	}

	@Override
	public void dispose() {
		adapterFactoryLabelProvider.dispose();
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return adapterFactoryLabelProvider.isLabelProperty(element, property);
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		adapterFactoryLabelProvider.removeListener(listener);
	}
	
	public void clearHighlighting() {
		highlight.clear();
	}

	public void highlightObjects(ArrayList<String> xmi_ids, int type) {
		if (type == ICVLEnabledEditor.HL_NONE) {
			for(String xmi_id : xmi_ids) highlight.remove(xmi_id);
		}
		else {
			for(String xmi_id : xmi_ids) highlight.put(xmi_id, type);
		}
	}
	
	public void highlightObject(String xmi_id, int type) {
		if (type == ICVLEnabledEditor.HL_NONE) {
			highlight.remove(xmi_id);
		}
		else {
			highlight.put(xmi_id, type);
		}
	}
	
}
