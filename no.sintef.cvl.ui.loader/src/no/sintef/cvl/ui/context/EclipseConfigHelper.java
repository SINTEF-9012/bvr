package no.sintef.cvl.ui.context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import no.sintef.cvl.thirdparty.common.Constants;
import no.sintef.cvl.thirdparty.common.Utility;

public class EclipseConfigHelper extends AbstractConfigHelper {

	private final String propertyFileName = "META-INF/data/configs/cvl.properties";
	
	private static final EclipseConfigHelper configHelper = new EclipseConfigHelper();
	
	public static ConfigHelper getConfig(){
		return configHelper;
	}
	
	@Override
	public String lastLocation() {
		File last;
		String loc = new String();
		FileInputStream inputStream = null;
		try {
			File file = Utility.findFileInPlugin(Constants.PLUGIN_ID_CVL_LAUNCHER, getPropertyFileName());
			inputStream = new FileInputStream(file);
			getProperties().load(inputStream);
			last = new File(getProperties().getProperty(propertyLastLocation));
			loc = last.getAbsolutePath();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			if (inputStream != null){
				try {
					inputStream.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}
		return loc;
	}
	
	@Override
	public void saveLastLocation(String loc) {
		getProperties().setProperty(propertyLastLocation, loc);
		FileOutputStream outputStream = null;
		try {
			File file = Utility.findFileInPlugin(Constants.PLUGIN_ID_CVL_LAUNCHER, getPropertyFileName());
			outputStream = new FileOutputStream(file);
			getProperties().store(outputStream, new Date().toString());
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (outputStream != null){
				try {
					outputStream.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}
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
