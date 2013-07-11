package no.sintef.cvl.thirdparty.common;

import java.io.File;
import java.net.URI;

import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;

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

}
