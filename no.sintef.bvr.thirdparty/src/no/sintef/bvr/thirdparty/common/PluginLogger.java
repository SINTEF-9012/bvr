/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.thirdparty.common;

import java.util.Calendar;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.common.logging.Logger;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;


public class PluginLogger implements Logger {
	
	private static final String pluginId = Constants.PLUGIN_ID_THIRDPARTY;
	private static final Calendar calendar = Calendar.getInstance();
	private ILog logger = Platform.getLog(Platform.getBundle(pluginId));
	
	private static final PluginLogger pluginLogger = new PluginLogger();
	
	public static PluginLogger getLogger(){
		return pluginLogger;
	}
	
	@Override
	public void error(String message) {
		logger.log(new Status(Status.ERROR, pluginId, "[PLUGIN ERROR " + calendar.getTime().toString() + "] " + message));
	}

	@Override
	public void warn(String message) {
		logger.log(new Status(Status.WARNING, pluginId, "[PLUGIN WARNING " + calendar.getTime().toString() + "] " + message));
	}

	@Override
	public void info(String message) {
		logger.log(new Status(Status.INFO, pluginId, "[PLUGIN INFO " + calendar.getTime().toString() + "] " + message));
	}

	@Override
	public void debug(String message) {
		logger.log(new Status(Status.INFO, pluginId, "[PLUGIN DEBUG " + calendar.getTime().toString() + "] " + message));
	}

	@Override
	public void error(String message, Throwable e) {
		String stackTrace = CommonUtility.getStackTraceAsString(e);
		error("Failed with the message: '" + message + "' and stack trace:\n" + stackTrace);
	}
}
