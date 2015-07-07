/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.common;

import java.util.HashMap;
import java.util.List;

import no.sintef.bvr.tool.exception.NoEclipseDetectedException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface ModelSelector {
	
	public void highlightObjects(EList<HashMap<EObject, Integer>> objectsToHighlightList) throws NoEclipseDetectedException;
	
	public void clearHighlights() throws NoEclipseDetectedException;
	
	public EObject getEObject(Object object);
	
	public List<Object> getSelections() throws NoEclipseDetectedException;
}
