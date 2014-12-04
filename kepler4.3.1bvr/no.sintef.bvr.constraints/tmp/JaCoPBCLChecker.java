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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import JaCoP.constraints.And;
import JaCoP.constraints.IfThen;
import JaCoP.constraints.IfThenBool;
import JaCoP.constraints.Not;
import JaCoP.constraints.Or;
import JaCoP.constraints.PrimitiveConstraint;
import JaCoP.constraints.XeqY;
import JaCoP.constraints.XgtY;
import JaCoP.core.BooleanVar;
import JaCoP.core.IntVar;
import JaCoP.core.Store;
import JaCoP.core.Var;
import JaCoP.search.DepthFirstSearch;
import JaCoP.search.IndomainMin;
import JaCoP.search.InputOrderSelect;
import JaCoP.search.Search;
import JaCoP.search.SelectChoicePoint;
import JaCoP.set.constraints.AeqB;

import no.sintef.ict.splcatool.BVRModel;

import bvr.BCLConstraint;
import bvr.BCLExpression;
import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.ConfigurableUnit;
import bvr.Constraint;
import bvr.NamedElement;
import bvr.OperationCallExp;
import bvr.PrimitveType;
import bvr.VSpec;
import bvr.VSpecRef;
import bvr.VSpecResolution;
import bvr.Variable;

public class JaCoPBCLChecker implements BCLChecker {
	private BVRModel cm;
	private Store store;
	private List<IntVar> vars;
	
	private IntVar inc;
	private IntVar exc;

	public JaCoPBCLChecker(BVRModel cm) {
		this.cm = cm;
		vars = new ArrayList<IntVar>();
		this.store = buildStore();
	}

	private Store buildStore() {
		Store store = new Store();
		inc = new BooleanVar(store, "included", 1, 1);
		exc = new BooleanVar(store, "excluded", 0, 0);
		
		// Add root
		ConfigurableUnit cu = cm.getCU();
		BooleanVar bv = new BooleanVar(store, cu.getName());
		vars.add(bv);
		bv.setDomain(1, 1); // Must be true
		
		// Add VSpecs as vars
		for(VSpec vs : cu.getOwnedVSpec()){
			buildStore(store, bv, vs);			
		}
		
		// Add additional constraints
		for(Constraint c : cu.getOwnedConstraint()){
			BCLConstraint bc = (BCLConstraint)c;
			JaCoP.constraints.Constraint pc = buildConstraint(bc.getExpression().get(0));
			store.impose(pc);
		}
		
		// Done
		return store;
	}

	private void buildStore(Store store, IntVar parent, VSpec vs) {
		if(vs instanceof Choice){
			Choice c = (Choice)vs;
			
			BooleanVar bv = new BooleanVar(store, vs.getName());
			vars.add(bv);
	
			if(!c.isIsImpliedByParent()){
				// c -> r = !c or r
				store.impose(new Or(new PrimitiveConstraint[] {new XeqY(parent, inc), new Not(new XeqY(bv, inc))}));
			}else{
				// c <-> r = c = r
				store.impose(new XeqY(parent, bv));
			}
			
			// Add VSpecs as vars
			for(VSpec v : vs.getChild()){
				buildStore(store, bv, v);			
			}
		}else if(vs instanceof Variable){
			Variable v = (Variable)vs;
			
			String tname = ((PrimitveType)v.getType()).getType().getName();
			
			if(tname.equals("Integer")){
				IntVar iv = new IntVar(store, v.getName(), Integer.MIN_VALUE, Integer.MAX_VALUE);
				vars.add(iv);
			}else{
				throw new UnsupportedOperationException(tname);
			}
		}else{
			throw new UnsupportedOperationException(vs.getClass().getName());
		}
	}
	
	private JaCoP.constraints.Constraint buildConstraint(BCLExpression e) {
		JaCoP.constraints.Constraint res = null; 
		
		if(e instanceof OperationCallExp){
			OperationCallExp o = (OperationCallExp)e;
			if(o.getOperation().getName().equals("logImplies")){
				PrimitiveConstraint a1;
				PrimitiveConstraint a2;
				a1 = (PrimitiveConstraint)buildConstraint(o.getArgument().get(0));
				a2 = (PrimitiveConstraint)buildConstraint(o.getArgument().get(1));
				
				res = new Or(new PrimitiveConstraint[] {new Not(a1), a2});
			}else if(o.getOperation().getName().equals("logNot")){
				PrimitiveConstraint a1;
				a1 = (PrimitiveConstraint)buildConstraint(o.getArgument().get(0));
				
				res = new Not(a1);
			}else if(o.getOperation().getName().equals("logAnd")){
				PrimitiveConstraint a1;
				PrimitiveConstraint a2;
				a1 = (PrimitiveConstraint)buildConstraint(o.getArgument().get(0));
				a2 = (PrimitiveConstraint)buildConstraint(o.getArgument().get(1));
				
				res = new And(new PrimitiveConstraint[] {a1, a2});
			}else if(o.getOperation().getName().equals("logOr")){
				PrimitiveConstraint a1;
				PrimitiveConstraint a2;
				a1 = (PrimitiveConstraint)buildConstraint(o.getArgument().get(0));
				a2 = (PrimitiveConstraint)buildConstraint(o.getArgument().get(1));
				
				res = new Or(new PrimitiveConstraint[] {a1, a2});
			}else if(o.getOperation().getName().equals("gt")){
				IntVar a1 = null;
				IntVar a2 = null;
				
				// a1
				BCLExpression n = o.getArgument().get(0);
				if(n instanceof VSpecRef){
					String name = ((VSpecRef)n).getVSpec().getName();
					IntVar v = null;
					for(IntVar iv : vars){
						if(iv.id.equals(name))
							a1 = iv;
					}
				}else{
					throw new UnsupportedOperationException(n.getClass().getName());
				}
				
				// a2
				n = o.getArgument().get(1);
				if(n instanceof VSpecRef){
					String name = ((VSpecRef)n).getVSpec().getName();
					IntVar v = null;
					for(IntVar iv : vars){
						if(iv.id.equals(name))
							a2 = iv;
					}
				}else{
					throw new UnsupportedOperationException(n.getClass().getName());
				}
				
				res = new XgtY(a1, a2);
			}else if(o.getOperation().getName().equals("eq")){
				IntVar a1 = null;
				IntVar a2 = null;
				
				// a1
				BCLExpression n = o.getArgument().get(0);
				if(n instanceof VSpecRef){
					String name = ((VSpecRef)n).getVSpec().getName();
					IntVar v = null;
					for(IntVar iv : vars){
						if(iv.id.equals(name))
							a1 = iv;
					}
				}else{
					throw new UnsupportedOperationException(n.getClass().getName());
				}
				
				// a2
				n = o.getArgument().get(1);
				if(n instanceof VSpecRef){
					String name = ((VSpecRef)n).getVSpec().getName();
					IntVar v = null;
					for(IntVar iv : vars){
						if(iv.id.equals(name))
							a2 = iv;
					}
				}/*else if(n instanceof OperationCallExp){
					a2 = buildConstraint(n);
				}*/else{
					throw new UnsupportedOperationException(n.getClass().getName());
				}
				
				res = new XeqY(a1, a2);
			}else{
				throw new UnsupportedOperationException(o.getOperation().getName());
			}
		}else if(e instanceof VSpecRef){
			String n = ((VSpecRef)e).getVSpec().getName();
			IntVar v = null;
			for(IntVar iv : vars){
				if(iv.id.equals(n))
					v = iv;
			}
			res = new XeqY(v, inc);
		}else{
			throw new UnsupportedOperationException(e.getClass().getName());
		}
		
		return res;
	}

	@Override
	public Set<NamedElement> getValidChildren(VSpecResolution parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getValidAssignments(VSpecResolution vsr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid() {
		IntVar[] vs = new IntVar[vars.size()];
		for(int i = 0; i < vars.size(); i++)
			vs[i] = vars.get(i);
		
		Search<IntVar> search = new DepthFirstSearch<IntVar>(); 
		SelectChoicePoint<IntVar> select = new InputOrderSelect<IntVar>(store, vs, new IndomainMin<IntVar>()); 
		boolean result = search.labeling(store, select); 
		
		return result;
	}

	@Override
	public boolean isValid(VSpecResolution vr) {
		Map<IntVar, Boolean> va = new HashMap<IntVar, Boolean>();
		
		getVarAssignments(va, vr);
		System.out.println(va);
		
		for(Entry<IntVar, Boolean> v : va.entrySet()){
			IntVar val = new IntVar(store, v.getValue()?1:0, v.getValue()?1:0);
			store.impose(new XeqY(v.getKey(), val));
		}
		
		System.out.println(this);
		
		return isValid();
	}

	private void getVarAssignments(Map<IntVar, Boolean> va, VSpecResolution vr) {
		if(vr instanceof ChoiceResolutuion){
			ChoiceResolutuion cr = (ChoiceResolutuion)vr;
			String name = cr.getResolvedChoice().getName();
			for(IntVar x : vars){
				if(x.id.equals(name))
					va.put(x, cr.isDecision());
			}
			
		}else{
			throw new UnsupportedOperationException(vr.getClass().getName());
		}
		
		for(VSpecResolution v : vr.getChild()){
			getVarAssignments(va, v);
		}
	}

	@Override
	public boolean hasConfigurations() {
		// TODO Auto-generated method stub
		return false;
	}


	public String toString(){
		return store.toString();
		
	}
}
