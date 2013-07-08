package no.sintef.cvl.thirdparty.common;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;

public class Utility {

	public static String getWorkspaceRowLocation(){
		IPath path = ResourcesPlugin.getWorkspace().getRoot().getRawLocation();
		return path.toString();
	}

}
