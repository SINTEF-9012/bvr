package no.sintef.cvl.ui.context;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
				e1.printStackTrace();
			}
		} 
		finally {
			if (fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
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
