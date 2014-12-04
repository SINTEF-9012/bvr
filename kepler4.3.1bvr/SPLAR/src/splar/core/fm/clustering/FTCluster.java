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
package splar.core.fm.clustering;

import java.util.ArrayList;
import java.util.List;

import splar.core.constraints.BooleanVariableInterface;
import splar.core.fm.FeatureTreeNode;


public class FTCluster {

	private FeatureTreeNode ancestor;
	private FeatureTreeNode root;
	private List<List<FeatureTreeNode>> clusterNodesRelations;
	private List<List<BooleanVariableInterface>> clauseNodesRelations;
	
	public FTCluster(FeatureTreeNode root) {
		this.root = root;
		ancestor = null;
		clusterNodesRelations = new ArrayList<List<FeatureTreeNode>>();
		clauseNodesRelations = new ArrayList<List<BooleanVariableInterface>>();
	}
	
	public FeatureTreeNode getRoot() {
		return root;
	}
	
	public void setAncestor(FeatureTreeNode ancestor) {
		this.ancestor = ancestor;
	}
	
	public FeatureTreeNode getAncestor() {
		return ancestor;  
	}
	
	public List<FeatureTreeNode> getChildren() {
		List<FeatureTreeNode> children = new ArrayList<FeatureTreeNode>();
		int count = root.getChildCount();
		for( int i = 0 ; i < count ; i++ ) {
			children.add((FeatureTreeNode)root.getChildAt(i));
		}
		return children;
	}
	
	public void addRelation(List<FeatureTreeNode> clusterNodesRelation, List<BooleanVariableInterface> clauseNodesRelation) {
		clusterNodesRelations.add(clusterNodesRelation);
		clauseNodesRelations.add(clauseNodesRelation);
	}
	
	public List<List<FeatureTreeNode>> getClusterNodesRelations() {
		return clusterNodesRelations;
	}
	
	public List<List<BooleanVariableInterface>> getClauseNodesRelations() {
		return clauseNodesRelations;
	}
}
