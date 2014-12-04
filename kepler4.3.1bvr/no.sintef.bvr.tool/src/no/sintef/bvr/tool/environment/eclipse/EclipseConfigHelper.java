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
package no.sintef.bvr.tool.environment.eclipse;


import no.sintef.bvr.thirdparty.common.Constants;
import no.sintef.bvr.thirdparty.common.Utility;
import no.sintef.bvr.tool.environment.AbstractConfigHelper;
import no.sintef.bvr.tool.environment.ConfigHelper;

public class EclipseConfigHelper extends AbstractConfigHelper {

	private final String propertyFileName = "";
	
	private static final EclipseConfigHelper configHelper = new EclipseConfigHelper();
	
	public static ConfigHelper getConfig(){
		return configHelper;
	}
	
	private void setProperty(String name, String value){
		Utility.setValueToPropertyStore(Constants.PLUGIN_ID_BVR_LAUNCHER, name, value);
	}
	
	private String getProperty(String name){
		return Utility.getValueFromPropertyStore(Constants.PLUGIN_ID_BVR_LAUNCHER, name);
	}
	
	@Override
	public String lastLocation() {
		return getProperty(propertyLastLocation);
	}
	
	@Override
	public void saveLastLocation(String loc) {
		setProperty(propertyLastLocation, loc);
	}
	
	@Override
	public String getPropertyFileName() {
		return propertyFileName;
	}

	@Override
	public void setToReplacementPermutation(boolean isSet) {
		setProperty(propertyPermutationToReplacement, (isSet) ? "true" : "false");
	}

	@Override
	public boolean isToReplacementPermutation() {
		String value = getProperty(propertyPermutationToReplacement);
		return (value.equals("") || defaultToReplacementPermuatation.equals(value)) ? false : true;
	}

	@Override
	public void setFromPlacementPermutation(boolean isSet) {
		setProperty(propertyPermutationFromPlacement, (isSet) ? "true" : "false");
	}

	@Override
	public boolean isFromPlacementPermutation() {
		String value = getProperty(propertyPermutationFromPlacement);
		return (value.equals("") || defaultFromPlacementPermuatation.equals(value)) ? false : true;
	}

	@Override
	public void setContainmentSelectionMode(boolean isSet) {
		setProperty(propertyContainmentSelection, (isSet) ? "true" : "false");
	}

	@Override
	public boolean isContainmentSelectionMode() {
		String value = getProperty(propertyContainmentSelection);
		return (value.equals("") || defaultContainmentSelectionMode.equals(value)) ? true : false;
	}

	@Override
	public void setHighlightingMode(boolean isSet) {
		setProperty(propertyHighlightingMode, (isSet) ? "true" : "false");
	}

	@Override
	public boolean isHighlightingMode() {
		String value = getProperty(propertyHighlightingMode);
		return (value.equals("") || defaultHighlightingMode.equals(value)) ? true : false;
	}
}
