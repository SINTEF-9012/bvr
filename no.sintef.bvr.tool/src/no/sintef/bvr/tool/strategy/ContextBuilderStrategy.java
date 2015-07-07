/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.strategy;

import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.tool.primitive.SymbolTableEObject;


public interface ContextBuilderStrategy {

		public void testEObject(EObject parent, EObject child);
		
		public void reset();
		
		public SymbolTableEObject getRootScope();
}
