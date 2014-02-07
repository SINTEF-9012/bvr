package no.sintef.cvl.tool.environment.eclipse;


import no.sintef.cvl.thirdparty.common.Constants;
import no.sintef.cvl.thirdparty.common.Utility;
import no.sintef.cvl.tool.environment.AbstractConfigHelper;
import no.sintef.cvl.tool.environment.ConfigHelper;

public class EclipseConfigHelper extends AbstractConfigHelper {

	private final String propertyFileName = "";
	
	private static final EclipseConfigHelper configHelper = new EclipseConfigHelper();
	
	public static ConfigHelper getConfig(){
		return configHelper;
	}
	
	private void setProperty(String name, String value){
		Utility.setValueToPropertyStore(Constants.PLUGIN_ID_CVL_LAUNCHER, name, value);
	}
	
	private String getProperty(String name){
		return Utility.getValueFromPropertyStore(Constants.PLUGIN_ID_CVL_LAUNCHER, name);
	}
	
	@Override
	public String lastLocation() {
		return getProperty(propertyLastLocation);
	}
	
	@Override
	public void saveLastLocation(String loc) {
		setProperty(propertyLastLocation, loc);
	}
	
	@Override
	public String getPropertyFileName() {
		return propertyFileName;
	}

	@Override
	public void setToReplacementPermutation(boolean isSet) {
		setProperty(propertyPermutationToReplacement, (isSet) ? "true" : "false");
	}

	@Override
	public boolean isToReplacementPermutation() {
		String value = getProperty(propertyPermutationToReplacement);
		return (value.equals("") || defaultToReplacementPermuatation.equals(value)) ? false : true;
	}

	@Override
	public void setFromPlacementPermutation(boolean isSet) {
		setProperty(propertyPermutationFromPlacement, (isSet) ? "true" : "false");
	}

	@Override
	public boolean isFromPlacementPermutation() {
		String value = getProperty(propertyPermutationFromPlacement);
		return (value.equals("") || defaultFromPlacementPermuatation.equals(value)) ? false : true;
	}

	@Override
	public void setContainmentSelectionMode(boolean isSet) {
		setProperty(propertyContainmentSelection, (isSet) ? "true" : "false");
	}

	@Override
	public boolean isContainmentSelectionMode() {
		String value = getProperty(propertyContainmentSelection);
		return (value.equals("") || defaultContainmentSelectionMode.equals(value)) ? true : false;
	}

	@Override
	public void setHighlightingMode(boolean isSet) {
		setProperty(propertyHighlightingMode, (isSet) ? "true" : "false");
	}

	@Override
	public boolean isHighlightingMode() {
		String value = getProperty(propertyHighlightingMode);
		return (value.equals("") || defaultHighlightingMode.equals(value)) ? true : false;
	}
}
