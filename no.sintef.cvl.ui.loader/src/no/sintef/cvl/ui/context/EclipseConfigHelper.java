package no.sintef.cvl.ui.context;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

public class EclipseConfigHelper extends AbstractConfigHelper {

	private static final String propertyFileName = "platform:/plugin/no.sintef.cvl.ui.editor.eclipselauncher/META-INF/data/configs/cvl.properties";
	private static Properties properties = new Properties();
	
	private static final EclipseConfigHelper configHelper = new EclipseConfigHelper();
	
	public static ConfigHelper getConfig(){
		return configHelper;
	}
	
	@Override
	public String lastLocation() {
		File last;
		String loc = new String();
		InputStream inputStream = null;
		try {
			URL url = new URL(propertyFileName);
			inputStream = url.openConnection().getInputStream();
			properties.load(inputStream);
			last = new File(properties.getProperty(propertyLastLocation));
			loc = last.getAbsolutePath();
		} 
		catch (IOException e) {} 
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
		OutputStream outputStream = null;
		try {
			URL url = new URL(propertyFileName);
			outputStream = url.openConnection().getOutputStream();
			getProperties().store(outputStream, new Date().toString());
			outputStream.close();
		} catch (IOException e) {}
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
