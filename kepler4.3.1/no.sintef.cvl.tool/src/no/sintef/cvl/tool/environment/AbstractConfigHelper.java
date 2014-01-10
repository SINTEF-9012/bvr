package no.sintef.cvl.tool.environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;


public abstract class AbstractConfigHelper implements ConfigHelper {
	
	protected final String propertyLastLocation = "lastLocation";
	protected final String propertyPermutationToReplacement = "permToReplacement";
	protected final String propertyPermutationFromPlacement = "permFromPlacement";
	protected final String propertyContainmentSelection = "containmentSelection";
	protected final String propertyHighlightingMode = "highlightingMode";
	
	protected static final String defaultLastLocation = "";
	protected static final String defaultFromPlacementPermuatation = "false";
	protected static final String defaultToReplacementPermuatation = "false";
	protected static final String defaultContainmentSelectionMode = "true";
	protected static final String defaultHighlightingMode = "true";
	
	protected final Properties properties = new Properties();

	@Override
	public void loadProperties(){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(getPropertyFileName()); 
			properties.load(fis);
		} 
		catch (IOException e) {
			throw new UnsupportedOperationException(e);
		} 
		finally {
			if (fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					throw new UnsupportedOperationException(e);
				}
			}
		}
	}
	
	protected void setDefaultValues(){
		saveLastLocation(defaultLastLocation);
		setFromPlacementPermutation(defaultFromPlacementPermuatation.equals("false") ? false : true);
		setToReplacementPermutation(defaultToReplacementPermuatation.equals("false") ? false : true);
	}
}
