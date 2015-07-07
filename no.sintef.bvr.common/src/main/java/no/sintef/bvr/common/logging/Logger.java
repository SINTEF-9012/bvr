/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.common.logging;

public interface Logger {

	public void error(String message);
	
	public void error(String message, Throwable e);
	
	public void warn(String message);
	
	public void info(String message);
	
	public void debug(String message);
}
