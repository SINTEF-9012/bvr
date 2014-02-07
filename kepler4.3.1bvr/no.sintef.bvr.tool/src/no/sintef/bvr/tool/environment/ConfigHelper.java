package no.sintef.bvr.tool.environment;

public interface ConfigHelper {

	public String lastLocation();
	
	public void saveLastLocation(String location);
	
	public String getPropertyFileName();
	
	public void setToReplacementPermutation(boolean isSet);
	
	public boolean isToReplacementPermutation();
	
	public void setFromPlacementPermutation(boolean isSet);
	
	public boolean isFromPlacementPermutation();
	
	public void loadProperties();
	
	public void setContainmentSelectionMode(boolean isSet);
	
	public boolean isContainmentSelectionMode();
	
	public void setHighlightingMode(boolean isSet);
	
	public boolean isHighlightingMode();
}
