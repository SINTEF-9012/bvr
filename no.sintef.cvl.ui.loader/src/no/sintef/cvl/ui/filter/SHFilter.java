package no.sintef.cvl.ui.filter;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import no.sintef.cvl.ui.common.Utility;

public class SHFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
	    if (f.isDirectory()) {
	        return true;
	    }
	    
	    String extension = Utility.getExtension(f);
	    if (extension != null) {
	    	if(extension.equals("xlsx")) return true;
	    	if(extension.equals("csv")) return true;
	    }
		return false;
	}

	@Override
	public String getDescription() {
		return "Spread Sheet Files (*.xlsx, *.csv)";
	}

}
