package no.sintef.cvl.ui.environment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;


public abstract class AbstractConfigHelper implements ConfigHelper {
	
	protected final String propertyLastLocation = "lastLocation";
	protected final Properties properties = new Properties();
	
	@Override
	public void saveLastLocation(String loc) {
		getProperties().setProperty(propertyLastLocation, loc);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(getPropertyFileName());
			getProperties().store(fos, new Date().toString());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
