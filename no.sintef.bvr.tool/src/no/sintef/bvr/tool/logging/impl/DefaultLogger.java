/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.logging.impl;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.common.logging.ConsoleLogger;
import no.sintef.bvr.common.logging.ResetableLogger;

public class DefaultLogger extends ConsoleLogger implements ResetableLogger {

	@Override
	public void setSource(EObject src) {
	}

	@Override
	public void setResource(IResource resource) {
		
	}

	@Override
	public void resetLogger() {
		
	}
}
