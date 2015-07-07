/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.thirdparty.interfaces.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

public abstract class AbstractBVREnabledEditor implements IBVREnabledEditor {

	@Override
	public void highlightObject(Object object, int type) {
		// TODO Auto-generated method stub
	}

	@Override
	public void clearHighlighting() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Object> getSelectedObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectObjects(List<Object> objects) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EObject> getModelObjects(List<Object> objects) {
		return new ArrayList<EObject>();
	}

	@Override
	public List<Object> getGraphicalObjects(List<EObject> objects) {
		return new ArrayList<Object>();
	}

}
