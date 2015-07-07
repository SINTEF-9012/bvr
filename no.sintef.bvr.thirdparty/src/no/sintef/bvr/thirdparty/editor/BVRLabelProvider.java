/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.thirdparty.editor;

import no.sintef.bvr.thirdparty.exception.NotSupportedLabelProvider;


import no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor;
import no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor.IDProvider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;


public class BVRLabelProvider extends BVRAbstractBaseLabelProvider implements IColorProvider, IFontProvider {
	
	FontRegistry registry = new FontRegistry();
	
	public BVRLabelProvider(ILabelProvider _lableProvider) {
		super(_lableProvider);
		if(!((labelProvider instanceof IColorProvider && labelProvider instanceof IFontProvider) || labelProvider instanceof AdapterFactoryLabelProvider))
			throw new NotSupportedLabelProvider("label provider -> " + labelProvider + " <- must implement either IColorProvider and IFontProvider or AdapterFactoryLabelProvider to higlight elements ");
	}
	
	@Override
	public Font getFont(Object element) {
		Font font = getBoldFont(element);
		if(font == null) {
			if(labelProvider instanceof AdapterFactoryLabelProvider){
				font = ((AdapterFactoryLabelProvider) labelProvider).getFont(element);
			} else {
				font = ((IFontProvider) labelProvider).getFont(element);
			}
		}
		return font;
	}

	@Override
	public Color getBackground(Object element) {
		return (labelProvider instanceof AdapterFactoryLabelProvider) ?
				((AdapterFactoryLabelProvider) labelProvider).getBackground(element) :
					((IColorProvider) labelProvider).getBackground(element);
	}

	@Override
	public Color getForeground(Object element) {
		Color color = getFontForeground(element);
		if(color == null){
			if(labelProvider instanceof AdapterFactoryLabelProvider) {
				color = ((AdapterFactoryLabelProvider) labelProvider).getForeground(element);
			} else {
				color =  ((IColorProvider) labelProvider).getForeground(element);
			}
		}
		return color;
	}


	public Font getBoldFont(Object element) {
		if ((element instanceof EObject) && highlight.containsKey(IDProvider.getObjectId((EObject) element))) {
			return registry.getBold(Display.getCurrent().getSystemFont().getFontData()[0].getName());
		}
		return null;
	}

	public Color getFontForeground(Object element) {
		if(!(element instanceof EObject)) return null;
		if(!highlight.containsKey(IDProvider.getObjectId((EObject) element))) return null;
		
		switch (highlight.get(IDProvider.getObjectId((EObject) element))) {
		case IBVREnabledEditor.HL_PLACEMENT : 
			return IBVREnabledEditor.PLACEMENT;
		case IBVREnabledEditor.HL_PLACEMENT_OUT : 
			return IBVREnabledEditor.PLACEMENT_OUT;
		case IBVREnabledEditor.HL_PLACEMENT_IN : 
			return IBVREnabledEditor.PLACEMENT_IN;
		case IBVREnabledEditor.HL_PLACEMENT_IN_OUT : 
			return IBVREnabledEditor.PLACEMENT_IN_OUT;
		case IBVREnabledEditor.HL_REPLACEMENT : 
			return IBVREnabledEditor.REPLACEMENT;
		case IBVREnabledEditor.HL_REPLACEMENT_OUT : 
			return IBVREnabledEditor.REPLACEMENT_OUT;
		case IBVREnabledEditor.HL_REPLACEMENT_IN : 
			return IBVREnabledEditor.REPLACEMENT_IN;
		case IBVREnabledEditor.HL_REPLACEMENT_IN_OUT : 
			return IBVREnabledEditor.REPLACEMENT_IN_OUT;
		default : 
			return null;
		}
	}
}
