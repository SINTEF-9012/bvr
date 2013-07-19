package no.sintef.cvl.ui.environment;

import java.util.Properties;

public interface ConfigHelper {

	public String lastLocation();
	
	public void saveLastLocation(String location);
	
	public Properties getProperties();
	
	public String getPropertyFileName();
}
