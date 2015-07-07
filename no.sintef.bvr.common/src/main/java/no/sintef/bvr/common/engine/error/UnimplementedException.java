/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.common.engine.error;

public class UnimplementedException extends BasicBVREngineException {

	private static final long serialVersionUID = -695224714610907825L;
	
	public UnimplementedException(String message) {
		super(message);
	}
}
