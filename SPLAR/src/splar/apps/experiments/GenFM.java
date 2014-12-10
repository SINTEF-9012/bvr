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
import splar.core.fm.randomization.RandomFeatureModel2;

public class GenFM {
	
	public static void main(String args[]) {
		FeatureModel fm = new RandomFeatureModel2("RandomFM", 300, 0, 50, 23, 22, 2, 8, 5, 0);
		try {
			fm.loadModel();
		} catch (FeatureModelException e) {
			e.printStackTrace();
		}
		RandomFeatureModel2.createExtraConstraints(fm, 100, 50, 2, new int[][] {{1,30,100,80},{20,35,90,70},{40,35,80,100}});

//		RandomFeatureModel2.createExtraConstraints(fm, 66, 30, 2, new int[][] {{1,40,80,60},{20,60,60,60}});
		fm.dumpXML();
		System.out.println("<!--");
		FeatureModelStatistics stats = new FeatureModelStatistics(fm);
		stats.update();
		stats.dump();
		System.out.println("-->");
	}
}
