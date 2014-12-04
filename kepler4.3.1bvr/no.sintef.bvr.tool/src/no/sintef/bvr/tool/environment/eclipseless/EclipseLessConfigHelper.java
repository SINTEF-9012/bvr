/*******************************************************************************
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package no.sintef.bvr.tool.environment.eclipseless;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import no.sintef.bvr.tool.environment.AbstractConfigHelper;
import no.sintef.bvr.tool.environment.ConfigHelper;

public class EclipseLessConfigHelper extends AbstractConfigHelper{

	private static final String propertyFileName = "bvr.properties";
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

	@Override
	public void setHighlightingMode(boolean isSet) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isHighlightingMode() {
		return true;
	}
}
