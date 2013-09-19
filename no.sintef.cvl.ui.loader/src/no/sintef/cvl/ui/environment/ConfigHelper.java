package no.sintef.cvl.ui.environment;

public interface ConfigHelper {

	public String lastLocation();
	
	public void saveLastLocation(String location);
	
	public String getPropertyFileName();
	
	public void setToReplacementPermutation(boolean isSet);
	
	public boolean isToReplacementPermutation();
	
	public void setFromPlacementPermutation(boolean isSet);
	
	public boolean isFromPlacementPermutation();
	
	public void loadProperties();
}
