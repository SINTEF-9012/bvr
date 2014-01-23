package no.sintef.cvl.tool.filter;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import no.sintef.cvl.tool.common.LoaderUtility;

public class SVGFilter extends FileFilter {
	
	public static final String SVG_EXT = "svg";

	@Override
	public boolean accept(File f) {
	    if (f.isDirectory()) {
	        return true;
	    }
	    
	    String extension = LoaderUtility.getExtension(f);
	    if (extension != null) {
	    	if(extension.equals(SVG_EXT)) return true;
	    }
	    return false;
	}
	@Override
	public String getDescription() {
		return "SVG files (*.svg)";
	}

}
