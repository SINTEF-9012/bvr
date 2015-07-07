/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.engine.interfaces.strategy;

import org.eclipse.emf.common.util.EList;

import no.sintef.bvr.engine.interfaces.common.IHolderDataElement;
import bvr.ReplacementBoundaryElement;


public interface IReplacementElementFinderStrategy {

	public IHolderDataElement locateReplacementElements(EList<ReplacementBoundaryElement> rbe);
	
	public void flush();
}
