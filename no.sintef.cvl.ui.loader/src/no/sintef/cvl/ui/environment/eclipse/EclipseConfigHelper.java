package no.sintef.cvl.ui.environment.eclipse;

import java.util.Properties;

import no.sintef.cvl.thirdparty.common.Constants;
import no.sintef.cvl.thirdparty.common.Utility;
import no.sintef.cvl.ui.environment.AbstractConfigHelper;
import no.sintef.cvl.ui.environment.ConfigHelper;

public class EclipseConfigHelper extends AbstractConfigHelper {

	private final String propertyFileName = "";
	
	private static final EclipseConfigHelper configHelper = new EclipseConfigHelper();
	
	public static ConfigHelper getConfig(){
		return configHelper;
	}
	
	@Override
	public String lastLocation() {
		return Utility.getValueFromPropertyStore(Constants.PLUGIN_ID_CVL_LAUNCHER, propertyLastLocation);
	}
	
	@Override
	public void saveLastLocation(String loc) {
		Utility.setValueToPropertyStore(Constants.PLUGIN_ID_CVL_LAUNCHER, propertyLastLocation, loc);
	}

	@Override
	public Properties getProperties() {
		return properties;
	}
	
	@Override
	public String getPropertyFileName() {
		return propertyFileName;
	}
}
