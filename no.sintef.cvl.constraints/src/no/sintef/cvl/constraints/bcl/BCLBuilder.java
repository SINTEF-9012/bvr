package no.sintef.cvl.constraints.bcl;

import java.util.ArrayList;
import java.util.List;

import no.sintef.cvl.constraints.bcl.BCLParser.LiteralexpContext;
import no.sintef.cvl.constraints.bcl.BCLParser.VspecContext;

import org.antlr.v4.runtime.tree.RuleNode;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import cvl.BCLExpression;
import cvl.ConfigurableUnit;
import cvl.IntegerLiteralExp;
import cvl.OperationCallExp;
import cvl.RealLiteralExp;
import cvl.StringLiteralExp;
import cvl.VSpec;
import cvl.VSpecRef;
import cvl.CvlFactory;

class BCLBuilder{
	
	public BCLExpression recurse(RuleNode root, int depth, ConfigurableUnit cu, boolean verbose) {
		String name;
		
		// Collapse place holder nodes
		while(true){
			while(root.getChildCount() == 1 &&  root.getChild(0) instanceof RuleNode)
				root = (RuleNode) root.getChild(0);
			
			// Get name
			name = root.getClass().getSimpleName();
			name = name.substring(0, name.length()-7);
			
			if(name.equals("Expterm") || name.equals("ExpLog")){
				if(root.getChildCount() == 3 && root.getChild(0).toString().equals("(") && root.getChild(2).toString().equals(")"))
					root = (RuleNode) root.getChild(1);
				else
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
			VSpecRef r = CvlFactory.eINSTANCE.createVSpecRef();
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
			r.setVSpec(cur);
			e = r;
		}else if(root instanceof LiteralexpContext){
			String s = root.getChild(0).toString();
			if(s.startsWith("\"") && s.endsWith("\"")){
				StringLiteralExp r = CvlFactory.eINSTANCE.createStringLiteralExp();
				s = s.substring(1, s.length()-1);
				r.setString(s);
				e = r;
			}else if(s.contains(".")){
				RealLiteralExp r = CvlFactory.eINSTANCE.createRealLiteralExp();
				r.setReal(s);
				e = r;
			}else{
				IntegerLiteralExp r = CvlFactory.eINSTANCE.createIntegerLiteralExp();
				r.setInteger(new Integer(s));
				e = r;
			}
			
			if(verbose)
				System.out.println(" " + s);
		}else{
			OperationCallExp o = CvlFactory.eINSTANCE.createOperationCallExp();
			
			if(verbose)
				System.out.println();
			
			// Find operation
			String opStr = root.getChild(1).getChild(0).toString();
			// Map
			if(opStr.equals("implies")) o.setOperation(cvl.Operation.getByName("logImplies"));
			if(opStr.equals("and")) o.setOperation(cvl.Operation.getByName("logAnd"));
			if(opStr.equals("or")) o.setOperation(cvl.Operation.getByName("logOr"));
			if(opStr.equals("xor")) o.setOperation(cvl.Operation.getByName("logXor"));
			if(opStr.equals("=")) o.setOperation(cvl.Operation.getByName("eq"));
			if(opStr.equals("<=")) o.setOperation(cvl.Operation.getByName("lte"));
			if(opStr.equals(">=")) o.setOperation(cvl.Operation.getByName("gte"));
			if(opStr.equals("<")) o.setOperation(cvl.Operation.getByName("lt"));
			if(opStr.equals(">")) o.setOperation(cvl.Operation.getByName("gt"));
			if(opStr.equals("*")) o.setOperation(cvl.Operation.getByName("arithMult"));
			if(opStr.equals("/")) o.setOperation(cvl.Operation.getByName("arithDev"));
			if(opStr.equals("+")) o.setOperation(cvl.Operation.getByName("arithPlus"));
			if(opStr.equals("-")) o.setOperation(cvl.Operation.getByName("arithMinus"));
			
			// Recurse
			//System.out.println("\"" + root.getChild(0).toString()+"\"");
			BCLExpression a1 = recurse((RuleNode) root.getChild(0), depth+1, cu, verbose);
			o.getArgument().add(a1);
			BCLExpression a2 = recurse((RuleNode) root.getChild(2), depth+1, cu, verbose);
			o.getArgument().add(a2);
			
			e = o;
		}
		
		return e;
	}

	private VSpec findVspec(String id, ConfigurableUnit cu) {
		TreeIterator<EObject> ti = cu.eAllContents();
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
		EList<VSpec> ti = parent.getChild();
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