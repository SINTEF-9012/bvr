package no.sintef.cvl.ui.environment.eclipseless;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import no.sintef.cvl.ui.environment.AbstractConfigHelper;
import no.sintef.cvl.ui.environment.ConfigHelper;

public class EclipseLessConfigHelper extends AbstractConfigHelper{

	private static final String propertyFileName = "cvl.properties";
	private static Properties properties = new Properties();
	
	private static final EclipseLessConfigHelper configHelper = new EclipseLessConfigHelper();
	
	public static ConfigHelper getConfig(){
		return configHelper;
	}

	@Override
	public String lastLocation() {
		File last;
		FileInputStream fis = null;
		String loc = new String();
		try {
			fis = new FileInputStream(propertyFileName); 
			properties.load(fis);
			last = new File(properties.getProperty(propertyLastLocation));
			loc = last.getAbsolutePath();
		} 
		catch (IOException e) {
			File f = new File(propertyFileName);
			try {
				f.createNewFile();
				saveLastLocation("");
				
				fis = new FileInputStream(propertyFileName); 
				properties.load(fis);
				last = new File(properties.getProperty(propertyLastLocation));
				loc = last.getAbsolutePath();
			} catch (final IOException e1) {
				throw new UnsupportedOperationException(e1);
			}
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
		return loc;
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
