package no.sintef.bvr.tool.filter;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import no.sintef.bvr.tool.common.LoaderUtility;

public class FMFilter extends FileFilter {

	public static final String M_EXT = "m";
	public static final String XML_EXT = "xml";
	
	@Override
	public boolean accept(File f) {
	    if (f.isDirectory()) {
	        return true;
	    }

	    String extension = LoaderUtility.getExtension(f);
	    if (extension != null) {
	    	if(extension.equals(M_EXT)) return true;
	    	if(extension.equals(XML_EXT)) return true;
	    }
	    return false;
	}
	@Override
	public String getDescription() {
		return "Other Feature Diagram (*.m, *.xml)";
	}

}
