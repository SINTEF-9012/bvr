/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.thirdparty.exception;

import no.sintef.bvr.common.CommonUtility;

public class UnexpectedThirdPartyException extends
		AbstractThirdPartyEditorError {

	private static final long serialVersionUID = 5017329250280437942L;
	
	public UnexpectedThirdPartyException(String msg) {
		super(msg);
	}

	public UnexpectedThirdPartyException(Throwable ex) {
		super(CommonUtility.getStackTraceAsString(ex));
	}

}
