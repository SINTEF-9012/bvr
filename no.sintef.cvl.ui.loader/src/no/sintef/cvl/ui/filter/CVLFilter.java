package no.sintef.cvl.ui.filter;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import no.sintef.cvl.ui.common.LoaderUtility;

public class CVLFilter extends FileFilter {
	
	public static final String CVL_EXT = "cvl";
	public static final String XMI_EXT = "xmi";

	@Override
	public boolean accept(File f) {
	    if (f.isDirectory()) {
	        return true;
	    }
	    
	    String extension = LoaderUtility.getExtension(f);
	    if (extension != null) {
	    	if(extension.equals(CVL_EXT)) return true;
	    	if(extension.equals(XMI_EXT)) return true;
	    }
	    return false;
	}
	@Override
	public String getDescription() {
		return "CVL Model (*.cvl, *.xmi)";
	}

}
