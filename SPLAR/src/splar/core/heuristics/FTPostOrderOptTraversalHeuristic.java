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
package splar.core.heuristics;

import java.util.Comparator;
import java.util.Set;
import java.util.Stack;

import splar.core.constraints.BooleanVariableInterface;
import splar.core.constraints.CNFFormula;
import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;


public class FTPostOrderOptTraversalHeuristic extends FTPostOrderTraversalHeuristic {

	public FTPostOrderOptTraversalHeuristic(String name, FeatureModel featureModel) {
		super(name, featureModel);
	}

	protected FeatureTreeNode[] orderChildNodes(FeatureTreeNode node) {

		// sort nodes in non-ascending order 
		Comparator<FeatureTreeNode> c = new Comparator<FeatureTreeNode>() {
			public int compare(FeatureTreeNode node1, FeatureTreeNode node2) {

				Integer countNodes1 = (Integer)node1.getAttachedData();
				Integer countNodes2 = (Integer)node2.getAttachedData();
				
				if ( countNodes1 == null ) {
					countNodes1 = new Integer(featureModel.countNodes(node1));
					node1.attachData(countNodes1);
				}
				
				if ( countNodes2 == null ) {
					countNodes2 = new Integer(featureModel.countNodes(node2));
					node2.attachData(countNodes2);
				}
				
				if ( countNodes1 > countNodes2 ) {
					return -1;
				}
				if ( countNodes1 < countNodes2 ) {
					return 1;
				}
				return 0;
			}
		};
		
		int count = node.getChildCount();
		FeatureTreeNode nodes[] = new FeatureTreeNode[count];
		for( int i = 0 ; i < count ; i++ ) {
			nodes[i] = ((FeatureTreeNode)node.getChildAt(i));									
		}
		
		java.util.Arrays.sort(nodes, c);
		
		return nodes;
	}
	
}
