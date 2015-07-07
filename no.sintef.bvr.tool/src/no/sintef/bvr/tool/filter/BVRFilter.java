/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.filter;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import no.sintef.bvr.tool.common.LoaderUtility;

public class BVRFilter extends FileFilter {
	
	public static final String BVR_EXT = "bvr";
	public static final String XMI_EXT = "xmi";

	@Override
	public boolean accept(File f) {
	    if (f.isDirectory()) {
	        return true;
	    }
	    
	    String extension = LoaderUtility.getExtension(f);
	    if (extension != null) {
	    	if(extension.equals(BVR_EXT)) return true;
	    	if(extension.equals(XMI_EXT)) return true;
	    }
	    return false;
	}
	@Override
	public String getDescription() {
		return "BVR Model (*.bvr, *.xmi)";
	}

}
