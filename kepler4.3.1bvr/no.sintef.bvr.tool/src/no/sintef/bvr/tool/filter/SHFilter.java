package no.sintef.bvr.tool.filter;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import no.sintef.bvr.tool.common.LoaderUtility;

public class SHFilter extends FileFilter {

	public static final String XLSX_EXT = "xlsx";
	public static final String CSV_EXT = "csv";
	
	@Override
	public boolean accept(File f) {
	    if (f.isDirectory()) {
	        return true;
	    }
	    
	    String extension = LoaderUtility.getExtension(f);
	    if (extension != null) {
	    	if(extension.equals(XLSX_EXT)) return true;
	    	if(extension.equals(CSV_EXT)) return true;
	    }
		return false;
	}

	@Override
	public String getDescription() {
		return "Spread Sheet Files (*.xlsx, *.csv)";
	}

}
