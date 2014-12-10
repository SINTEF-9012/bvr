/*******************************************************************************
 * Copyright (c) 2011, 2012 SINTEF, Martin F. Johansen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SINTEF, Martin F. Johansen - the implementation
 *******************************************************************************/

package no.sintef.ict.splcatool;

public class CoveringArrayGenerationException extends Exception {
	private static final long serialVersionUID = -7993004150350889088L;
	private String message;

	public CoveringArrayGenerationException() {
		this("");
	}

	public CoveringArrayGenerationException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	
}
