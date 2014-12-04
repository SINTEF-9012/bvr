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

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

import splar.core.constraints.BooleanVariableInterface;
import splar.core.constraints.CNFClause;
import splar.core.constraints.CNFFormula;
import splar.core.constraints.PropositionalFormula;
import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;



// First: Extra constraint variables visited in natural order (first to last)
// Second: Feature tree variables visited in pre-order
public class ECFT_FORCEPreOrderHeuristic extends FTTraversalHeuristic {

	public ECFT_FORCEPreOrderHeuristic(String name, FeatureModel featureModel) {
		super(name, featureModel);
	}
	
	public String[] runHeuristic(CNFFormula cnf) {		
		
		Set<String> variables = new LinkedHashSet<String>();
		
		// Visit Extra constraint variables in natural order
		for( PropositionalFormula formula : featureModel.getConstraints() ) {
			for( CNFClause clause : formula.toCNFClauses() ) {
				for( BooleanVariableInterface var : clause.getVariables()) {
					if ( !variables.contains(var.getID()) ) {
						variables.add(var.getID());
					}
				}
			}
		}			
		
		// Order Extra Constraint variables using FORCE - Minimum Span!
		VariableOrderingHeuristic heuristic = new FORCEVariableOrderingHeuristic("FORCE", VariableOrderingHeuristic.variableOrderingAsBooleanVariableArray(variables.toArray(new String[0])), 1);
		String order[] = heuristic.run(featureModel.EC2CNF());
		variables.clear();
		for( String var : order ) {
			variables.add(var);
		}
				
		// Feature tree variables
		Set<BooleanVariableInterface> cnfVariables = cnf.getVariables();
		Stack<FeatureTreeNode> nodes = new Stack<FeatureTreeNode>();
		nodes.push(getFeatureModel().getRoot());
		while ( nodes.size() > 0 ) {
			FeatureTreeNode curNode = nodes.pop();
			if ( curNode != null ) {		
				if ( !(curNode instanceof FeatureGroup) ) {
					if ( cnfVariables.contains(curNode) && !variables.contains(curNode.getID())) {
						variables.add(curNode.getID());						
					}
				}
				FeatureTreeNode childNodes[] = orderChildNodes(curNode);
				for( int i = childNodes.length-1 ; i >= 0 ; i-- ) {
					nodes.push(childNodes[i]);						
				}
			}
		}
		return variables.toArray(new String[0]);
	}	
	
//	protected void runPreProcessing(CNFFormula cnf) {		
//	}
//
//	protected void runPostProcessing(CNFFormula cnf) {		
//	}

	protected FeatureTreeNode[] orderChildNodes(FeatureTreeNode node) {
		int count = node.getChildCount();
		FeatureTreeNode nodes[] = new FeatureTreeNode[count];
		for( int i = 0 ; i < count ; i++ ) {
			nodes[i] = ((FeatureTreeNode)node.getChildAt(i));									
		}
		return nodes;
	}
}
