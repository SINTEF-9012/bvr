/*******************************************************************************
 * Copyright (c) All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.thirdparty.common;

import java.io.File;
import java.net.URI;
import java.util.HashMap;

import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.transaction.Transaction;
import org.osgi.service.prefs.BackingStoreException;

public final class Utility {

	public static String getWorkspaceRowLocation() {
		IPath path = ResourcesPlugin.getWorkspace().getRoot().getRawLocation();
		return path.toString();
	}

	public static String findFileInWorkspace(File file) {
		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		URI uri = URIUtil.toURI(file.getAbsolutePath());
		IFile[] files = myWorkspaceRoot.findFilesForLocationURI(uri);
		return (files.length == 1) ? files[0].getFullPath().toString() : null;
	}

	public static IFile findIFileInWorkspaceFile(File file) {
		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		URI uri = URIUtil.toURI(file.getAbsolutePath());
		IFile[] files = myWorkspaceRoot.findFilesForLocationURI(uri);
		return (files.length == 1) ? files[0] : null;
	}

	public final static String statusCode = "statusCode";
	public final static String message = "message";
	public final static String isOk = "isOk";

	public static HashMap<String, Object> parseTransaction(Transaction transaction) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		IStatus status = transaction.getStatus();
		result.put(isOk, status.isOK());
		result.put(statusCode, status.getSeverity());
		result.put(message, status.getMessage());
		return result;
	}

	public static String getValueFromPropertyStore(String pluginId, String fieldName) {
		IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(pluginId);
		String value = prefs.get(fieldName, "");
		return value;
	}

	public static void setValueToPropertyStore(String pluginId, String fieldName, String value) {
		IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(pluginId);
		prefs.put(fieldName, value);
		try {
			prefs.flush();
		} catch (BackingStoreException e) {
			throw new UnsupportedOperationException(e);
		}
	}

}
