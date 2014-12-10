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
package splar.plugins.reasoners.bdd.javabdd;

import java.util.ArrayList;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDFactory;

public class BDDGenerationStatistics {
	
	private ArrayList<BDDGenerationStatisticsRecord> stats;
	private double pathCount = -1;
	private int bvoIndex = -1;   // BVO = best variable order
	private int wvoIndex = -1;   // WVO = worst variable order
	private double wvoCountNodes = -1;
	private double bvoCountNodes = Integer.MAX_VALUE;
	private int index;
	
	public BDDGenerationStatistics(int countVars) {
		stats = new ArrayList<BDDGenerationStatisticsRecord>();
		index = 0;
		wvoCountNodes = -1;
		bvoCountNodes = Integer.MAX_VALUE;
	}
	
	public void addStats(BDDFactory bddFactory, BDD bdd, String[] varOrder) {
		if (pathCount == -1 ) {
			pathCount = bdd.pathCount();
		}
		int bddNodeCount = bdd.nodeCount();		

		if ( bddNodeCount < bvoCountNodes ) {
			bvoCountNodes = bddNodeCount;
			bvoIndex = index;
		}
		if ( bddNodeCount > wvoCountNodes ) {
			wvoCountNodes = bddNodeCount; 
			wvoIndex = index;
		}
		stats.add(index, new BDDGenerationStatisticsRecord(bddFactory, bdd, varOrder, bddNodeCount));
		index++;
				
//		System.out.print("\n" + index +"-Count: "); 
//		for ( int i = 0 ; i < varOrder.length ; i++ ) {
//			System.out.print(varOrder[i] + ",");			
//		}
//		System.out.print("\nBest: " + bvoIndex +"(" + bvoCountNodes + ")" + "Worst: " + wvoIndex + "(" + wvoCountNodes + ")");
	}
	
	public int countStats() {
		return stats.size();
	}
	
	public BDD getBDD(int index) {
		return stats.get(index).bdd;
	}
	
	public double getPathsCount() {
		return pathCount;
	}
	
	public String[] getVariableOrder(int index) {
		return stats.get(index).varOrder;
	}
	
	public double getNodesCount(int index) {
		return stats.get(index).nodesCount;
	}
	
	public int getBestVariableOrderIndex() {
		return bvoIndex;
	}

	public int getWorstVariableOrderIndex() {
		return wvoIndex;
	}
}

class BDDGenerationStatisticsRecord {
	
	public BDDGenerationStatisticsRecord(BDDFactory bddFactory , BDD bdd, String[] varOrder, int nodesCount) {
		this.bddFactory = bddFactory;
		this.bdd = bdd;
		this.varOrder = new String[varOrder.length];
		System.arraycopy(varOrder, 0, this.varOrder, 0, varOrder.length);
		this.nodesCount = nodesCount;
	}
	
	public BDDFactory bddFactory;
	public BDD bdd;
	public String[] varOrder;
	public int nodesCount;
}
