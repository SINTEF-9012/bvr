package no.sintef.cvl.thirdparty.common;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;

import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.transaction.Transaction;
import org.osgi.framework.Bundle;

public final class Utility {
	
	public static String getWorkspaceRowLocation(){
		IPath path = ResourcesPlugin.getWorkspace().getRoot().getRawLocation();
		return path.toString();
	}
	
	public static String findFileInWorkspace(File file){
		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		URI uri = URIUtil.toURI(file.getAbsolutePath());
		IFile[] files = myWorkspaceRoot.findFilesForLocationURI(uri);
		return (files.length == 1) ? files[0].getFullPath().toString() : null;
	}
	
	
	public final static String statusCode = "statusCode";
	public final static String message = "message";
	public final static String isOk = "isOk";
	
	public static HashMap<String, Object> parseTransaction(Transaction transaction){
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put(isOk, transaction.getStatus().isOK());
		result.put(statusCode, transaction.getStatus().getSeverity());
		result.put(message, transaction.getStatus().getMessage());
		return result;
	}
	
	public static File findFileInPlugin(String pluginId, String filePath) throws IOException{
		Bundle bundle = Platform.getBundle(pluginId);
		URL fileURL = bundle.getEntry(filePath);
		File file = null;
		try {
			file = new File(FileLocator.resolve(fileURL).toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return file;
	}

}
