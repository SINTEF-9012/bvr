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
package splar.apps;

import splar.core.fm.FeatureModel;
import splar.core.fm.XMLFeatureModel;
import splar.plugins.reasoners.sat.sat4j.FMReasoningWithSAT;

public class DevelopmentTests {

	public static void main(String args[]) {
		new DevelopmentTests().run();
	}
	
	public void run() {
		try {
			FeatureModel featureModelConsistent = new XMLFeatureModel("file:///c:\\users\\marcilio\\eclipse\\splar\\resources\\tests\\test_fm_consistent.xml", XMLFeatureModel.USE_VARIABLE_NAME_AS_ID);
			featureModelConsistent.loadModel();
			
			FMReasoningWithSAT reasoner = new FMReasoningWithSAT("MiniSAT", featureModelConsistent, 60000);
			reasoner.init();			
			
			reasoner.validDomain("b2");

			for( String name : reasoner.getVarName2IndexMap().keySet() ) {
				int index = reasoner.getVariableIndex(name);
				System.out.println( index + " : " + reasoner.getVariableName(index) );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
