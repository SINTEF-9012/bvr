package no.sintef.cvl.ui.environment.eclipseless;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
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
	
	public EclipseLessConfigHelper(){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(getPropertyFileName()); 
			properties.load(fis);
		} 
		catch (IOException e) {
			File f = new File(getPropertyFileName());
			try {
				f.createNewFile();
				setDefaultValues();
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
	}
	
	@Override
	public void saveLastLocation(String loc) {
		properties.setProperty(propertyLastLocation, loc);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(getPropertyFileName());
			properties.store(fos, new Date().toString());
			fos.close();
		} catch (IOException e) {
			throw new UnsupportedOperationException(e);
		}
	}
	
	@Override
	public void setFromPlacementPermutation(boolean isSet) {
		properties.setProperty(propertyPermutationFromPlacement, (isSet) ? "true" : "false");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(getPropertyFileName());
			properties.store(fos, new Date().toString());
			fos.close();
		} catch (IOException e) {
			throw new UnsupportedOperationException(e);
		}
	}
	
	@Override
	public void setToReplacementPermutation(boolean isSet) {
		properties.setProperty(propertyPermutationToReplacement, (isSet) ? "true" : "false");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(getPropertyFileName());
			properties.store(fos, new Date().toString());
			fos.close();
		} catch (IOException e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public String lastLocation() {
		loadProperties();
		File last = new File(properties.getProperty(propertyLastLocation));
		return last.getAbsolutePath();
	}

	@Override
	public boolean isFromPlacementPermutation() {
		loadProperties();
		String value = properties.getProperty(propertyPermutationFromPlacement);
		return (value == null || value.equals(defaultFromPlacementPermuatation)) ? false : true;
	}
	
	@Override
	public boolean isToReplacementPermutation() {
		loadProperties();
		String value = properties.getProperty(propertyPermutationToReplacement);
		return (value == null || value.equals(defaultToReplacementPermuatation)) ? false : true;
	}
		
	@Override
	public String getPropertyFileName() {
		return propertyFileName;
	}

	@Override
	public void setContainmentSelectionMode(boolean isSet) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isContainmentSelectionMode() {
		return true;
	}
}
