/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.chain;

import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.primitive.ExecutionRequest;

public interface ExecutionHandler {

	public void handleRequest(ExecutionRequest request) throws AbstractError;
}
