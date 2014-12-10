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
package splar.apps.experiments;

import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureModelException;
import splar.core.fm.FeatureModelStatistics;
import splar.core.fm.XMLFeatureModel;

public class Extractor {

	public static void main(String args[]) {
		new Extractor().start();
	}
	
	String models[] = {
			"04-eshop_fm.xml",
			"01-model_transformation.xml",
			"11-his.xml",
			"18-doc_gen.xml",
			"20-thread.xml",
			"03-web_portal2_fm.xml",
			"19-graph.xml",
			"16-dvs.xml",
			"15-kwic.xml",
			"17-insurance_product.xml",
			"02-weather_station_fm.xml",
			"14-text_editor.xml",
			"08-monitor_engine_system.xml",
			"05-GPL.xml",
			"07-jplug.xml",
			"09-james.xml",
			"10-vof.xml",
			"12-search_engine.xml",
			"13-tecom.xml",
			"06-cellphone.xml"
	};	
	
	String fmPath = "c:\\users\\marcilio\\eclipse\\4watreason\\fm_samples\\real_fms\\";
	FeatureModelStatistics stats = null;
	
	public void start() {

		for( String modelName : models ) {
//			System.out.println("Processing model " + modelName);
			FeatureModel fm = new XMLFeatureModel(fmPath+modelName, XMLFeatureModel.USE_VARIABLE_NAME_AS_ID);
			stats = new FeatureModelStatistics(fm);
			try {
				fm.loadModel();
			} catch (FeatureModelException e) {
				e.printStackTrace();
			}
			stats.update();
			System.out.println(fm.getName() + ": " + fm.countFeatures() +" features");
//			stats.dump();
		}		
	}
	
}




