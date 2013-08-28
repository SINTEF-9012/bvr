package no.sintef.cvl.ui.filter;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import no.sintef.cvl.ui.common.Utility;

public class PNGFilter extends FileFilter {
	
	public static final String PNG_EXT = "png";

	@Override
	public boolean accept(File f) {
	    if (f.isDirectory()) {
	        return true;
	    }
	    
	    String extension = Utility.getExtension(f);
	    if (extension != null) {
	    	if(extension.equals(PNG_EXT)) return true;
	    }
	    return false;
	}
	@Override
	public String getDescription() {
		return "PNG files (*.png)";
	}

}