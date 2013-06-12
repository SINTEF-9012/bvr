package no.sintef.cvl.ui.filters;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import no.sintef.cvl.ui.common.Utility;

public class FMFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
	    if (f.isDirectory()) {
	        return true;
	    }

	    String extension = Utility.getExtension(f);
	    if (extension != null) {
	    	if(extension.equals("m")) return true;
	    	if(extension.equals("xml")) return true;
	    }
	    return false;
	}
	@Override
	public String getDescription() {
		return "Other Feature Diagram (*.m, *.xml)";
	}

}
