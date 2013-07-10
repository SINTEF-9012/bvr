package no.sintef.cvl.ui.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class FileHelper {

	private static final String propertyFileName = "cvl.properties";
	private static Properties properties = new Properties();
	
	private static final String propertyLastLocation = "lastLocation";

	public static String lastLocation() {
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
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}
		return loc;
	}

	public static void saveLastLocation(String loc) {
		properties.setProperty(propertyLastLocation, loc);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(propertyFileName);
			properties.store(fos, new Date().toString());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}
