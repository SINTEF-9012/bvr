package no.sintef.cvl.ui.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class FileHelper {

	private static Properties properties = new Properties();

	public static String lastLocation() {
		File last = null;
		FileInputStream fis = null;
		String loc = null;
		try {
			fis = new FileInputStream("cvl.properties"); 
			properties.load(fis);
			last = new File(properties.getProperty("lastLocation"));
			loc = last.getAbsolutePath();
		} 
		catch (IOException e) {} 
		finally {
			if (fis != null){
				try {
					fis.close();
				} catch (final IOException e) {}
			}else{
				File f = new File("cvl.properties");
				try {
					f.createNewFile();
					saveLastLocation("");
					
					fis = new FileInputStream("cvl.properties"); 
					properties.load(fis);
					last = new File(properties.getProperty("lastLocation"));
					loc = last.getAbsolutePath();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return loc;
		}
	}

	public static void saveLastLocation(String loc) {
		properties.setProperty("lastLocation", loc);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("cvl.properties");
			properties.store(fos, new Date().toString());
			fos.close();
		} catch (IOException e) {}
	}



}
