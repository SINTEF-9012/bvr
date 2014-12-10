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
package no.sintef.bvr.constraints.bcl;

import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.constraints.bcl.BCLParser.LiteralexpContext;
import no.sintef.bvr.constraints.bcl.BCLParser.VspecContext;
import no.sintef.bvr.constraints.interfaces.strategy.IBCLBuilderStrategy;
import no.sintef.bvr.constraints.strategy.DefaultTestBCLBuilderStartegy;

import org.antlr.v4.runtime.tree.RuleNode;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import bvr.BCLExpression;
import bvr.BVRModel;
import bvr.BooleanLiteralExp;
import bvr.CompoundNode;
import bvr.IntegerLiteralExp;
import bvr.OperationCallExp;
import bvr.RealLiteralExp;
import bvr.StringLiteralExp;
import bvr.Target;
import bvr.TargetRef;
import bvr.VNode;
import bvr.VSpec;
import bvr.BvrFactory;


public class BCLBuilder {
	
	private IBCLBuilderStrategy strategy;
	
	public BCLBuilder(){
		strategy = new DefaultTestBCLBuilderStartegy();
	}
	
	public BCLBuilder(IBCLBuilderStrategy _strategy){
		strategy = _strategy;
	}
	
	public BCLExpression recurse(RuleNode root, int depth, BVRModel cu, boolean verbose) {
		String name;
		
		// Collapse place holder nodes
		while(true){
			while(root.getChildCount() == 1 && (root.getChild(0) instanceof RuleNode))
				root = (RuleNode) root.getChild(0);
			
			// Get name
			name = root.getClass().getSimpleName();
			name = name.substring(0, name.length()-7);
			
			if(name.equals("Expterm") || name.equals("ExpLogUn")){
				if(root.getChildCount() == 3 && root.getChild(0).toString().equals("(") && root.getChild(2).toString().equals(")"))
					root = (RuleNode) root.getChild(1);
				else if(root.getChildCount() == 4 && root.getChild(1).toString().equals("(") && root.getChild(3).toString().equals(")")){
					break;
				}else
					break;
			}else{
				break;
			}
		}
		
		// Get name
		name = root.getClass().getSimpleName();
		name = name.substring(0, name.length()-7);
		
		// print type
		if(verbose){
			for(int i = 0; i < depth; i++)
				System.out.print("  ");
			System.out.print(name);
		}
		
		// Construct Node
		BCLExpression e;
		if(root instanceof VspecContext){
			// Get fully qualified name
			VspecContext rt = (VspecContext)root;
			List<String> fcname = new ArrayList<String>();
			fcname.add(root.getChild(0).toString());
			while(rt.getChildCount() == 3){
				rt = (VspecContext) rt.getChild(2);
				fcname.add(rt.getChild(0).toString());
			}
			TargetRef r = BvrFactory.eINSTANCE.createTargetRef();
			VSpec prev = null, cur = null;
			for(String s : fcname){
				if(prev == null){
					prev = findVspec(s, cu);
					cur = prev;
				}else{
					cur = findVspec(s, prev);
				}
			}
			if(verbose)
				System.out.println(" " +  fcname);
			
			if(cur == null)
				throw new UnsupportedOperationException("can not find vspec with the given name -> " + fcname);
			
			Target vspecTarget = strategy.getVSpecTarget(cur);
			r.setTarget(vspecTarget);
			e = r;
		}else if(root instanceof LiteralexpContext){
			String s = root.getChild(0).toString();
			if(s.startsWith("\"") && s.endsWith("\"")){
				StringLiteralExp r = BvrFactory.eINSTANCE.createStringLiteralExp();
				s = s.substring(1, s.length()-1);
				r.setString(s);
				e = r;
			}else if(s.contains(".")){
				RealLiteralExp r = BvrFactory.eINSTANCE.createRealLiteralExp();
				r.setReal(s);
				e = r;
			}else if(s.equals("true") || s.equals("false")){
				BooleanLiteralExp r = BvrFactory.eINSTANCE.createBooleanLiteralExp();
				r.setBool(Boolean.parseBoolean(s));
				e = r;
			}else {
				IntegerLiteralExp r = BvrFactory.eINSTANCE.createIntegerLiteralExp();
				r.setInteger(new Integer(s));
				e = r;
			}
			
			if(verbose)
				System.out.println(" " + s);
		}else{
			OperationCallExp o = BvrFactory.eINSTANCE.createOperationCallExp();
			
			if(verbose)
				System.out.println();
			
			if(root.getChildCount() == 3){
				// Find operation
				String opStr = root.getChild(1).toString();
				// Map
				if(opStr.equals("implies")) o.setOperation(bvr.Operation.getByName("logImplies"));
				else if(opStr.equals("iff")) o.setOperation(bvr.Operation.getByName("logIff"));
				else if(opStr.equals("and")) o.setOperation(bvr.Operation.getByName("logAnd"));
				else if(opStr.equals("or")) o.setOperation(bvr.Operation.getByName("logOr"));
				else if(opStr.equals("xor")) o.setOperation(bvr.Operation.getByName("logXor"));
				else if(opStr.equals("=")) o.setOperation(bvr.Operation.getByName("eq"));
				else if(opStr.equals("<=")) o.setOperation(bvr.Operation.getByName("lte"));
				else if(opStr.equals(">=")) o.setOperation(bvr.Operation.getByName("gte"));
				else if(opStr.equals("<")) o.setOperation(bvr.Operation.getByName("lt"));
				else if(opStr.equals(">")) o.setOperation(bvr.Operation.getByName("gt"));
				else if(opStr.equals("*")) o.setOperation(bvr.Operation.getByName("arithMult"));
				else if(opStr.equals("/")) o.setOperation(bvr.Operation.getByName("arithDev"));
				else if(opStr.equals("+")) o.setOperation(bvr.Operation.getByName("arithPlus"));
				else if(opStr.equals("-")) o.setOperation(bvr.Operation.getByName("arithMinus"));
				else{
					for(int i = 0; i < root.getChildCount(); i++)
						System.out.println(root.getChild(i));
					throw new UnsupportedOperationException();	
				}
				
				// Recurse
				//System.out.println("\"" + root.getChild(0).toString()+"\"");
				BCLExpression a1 = recurse((RuleNode) root.getChild(0), depth+1, cu, verbose);
				o.getArgument().add(a1);
				BCLExpression a2 = recurse((RuleNode) root.getChild(2), depth+1, cu, verbose);
				o.getArgument().add(a2);
			}else if(root.getChildCount() == 2){
				// Find operation
				String opStr = root.getChild(0).toString();
				// Map
				if(opStr.equals("not")) o.setOperation(bvr.Operation.getByName("logNot"));
				else if(opStr.equals("isDefined")) o.setOperation(bvr.Operation.getByName("isDefined"));
				else if(opStr.equals("isUndefined")) o.setOperation(bvr.Operation.getByName("isUndefined"));
				else if(opStr.equals("-")) o.setOperation(bvr.Operation.getByName("arithNeg"));
				else throw new UnsupportedOperationException();
				
				// Recurse
				//System.out.println("\"" + root.getChild(0).toString()+"\"");
				BCLExpression a1 = recurse((RuleNode) root.getChild(1), depth+1, cu, verbose);
				o.getArgument().add(a1);
			}else if(root.getChildCount() == 4){
				// Find operation
				String opStr = root.getChild(0).toString();
				// Map
				if(opStr.equals("not")) o.setOperation(bvr.Operation.getByName("logNot"));
				else if(opStr.equals("isDefined")) o.setOperation(bvr.Operation.getByName("isDefined"));
				else if(opStr.equals("isUndefined")) o.setOperation(bvr.Operation.getByName("isUndefined"));
				else throw new UnsupportedOperationException();
				
				// Recurse
				//System.out.println("\"" + root.getChild(0).toString()+"\"");
				BCLExpression a1 = recurse((RuleNode) root.getChild(2), depth+1, cu, verbose);
				o.getArgument().add(a1);
			}else{
				for(int i = 0; i < root.getChildCount(); i++)
					System.out.println(root.getChild(i));
				throw new UnsupportedOperationException();
			}
			
			e = o;
		}
		
		return e;
	}

	private VSpec findVspec(String id, BVRModel model) {
		TreeIterator<EObject> ti = model.eAllContents();
		while(ti.hasNext()){
			EObject eo = ti.next();
			if(eo instanceof VSpec){
				VSpec vs = (VSpec) eo;
				if(vs.getName() != null && vs.getName().equals(id))
					return vs;
			}
		}
		return null;
	}
	
	private VSpec findVspec(String id, VSpec parent) {
		EList<VNode> ti = ((CompoundNode) parent).getMember();
		for(EObject eo : ti){
			if(eo instanceof VSpec){
				VSpec vs = (VSpec) eo;
				if(vs.getName() != null && vs.getName().equals(id))
					return vs;
			}
		}
		return null;
	}
}
