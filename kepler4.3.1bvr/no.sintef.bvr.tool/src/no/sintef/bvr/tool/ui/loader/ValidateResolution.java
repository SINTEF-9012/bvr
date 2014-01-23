package no.sintef.bvr.tool.ui.loader;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;


import bvr.BCLConstraint;
import bvr.BCLExpression;
import bvr.BooleanLiteralExp;
import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.ConfigurableUnit;
import bvr.Constraint;
import bvr.IntegerLiteralExp;
import bvr.MultiplicityInterval;
import bvr.Operation;
import bvr.OperationCallExp;
import bvr.PrimitiveValueSpecification;
import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecRef;
import bvr.VSpecResolution;
import bvr.ValueSpecification;
import bvr.VariableValueAssignment;
import bvr.impl.OperationCallExpImpl;

public class ValidateResolution implements ActionListener {
	
	private JTabbedPane filePane;
	private List<BVRModel> models;
	private List<BVRView> views;

	public ValidateResolution(JTabbedPane filePane, List<BVRModel> models, List<BVRView> views) {
		this.filePane = filePane;
		this.models = models;
		this.views = views;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int mi = filePane.getSelectedIndex();
		JTabbedPane x = (JTabbedPane) ((JTabbedPane)filePane.getSelectedComponent()).getSelectedComponent();
		int i = x.getSelectedIndex();
		ConfigurableUnit cu = models.get(mi).getBVRM().getCU();
		VSpecResolution vsr = cu.getOwnedVSpecResolution().get(i);
		
		//System.out.println("validating: " + cu.getName());
		//System.out.println("validating: " + vsr);
		
		boolean res = check(cu, vsr);
		
		if(res){
			JOptionPane.showMessageDialog(null, "Valid");
		}else{
			
		}
	}

	private boolean check(ConfigurableUnit cu, VSpecResolution vsr) {
		boolean res = true;
		
		// Check for null
		res = checkNull(vsr);
		if(res == false){
			JOptionPane.showMessageDialog(null, "Invalid: one VSpecResolution resolves nothing");
			return false;
		}
		
		// Check that all VSpecs have been resolved
		res = checkAllResolved(cu, vsr);
		if(res == false){
			JOptionPane.showMessageDialog(null, "Invalid: Some VSpecs have not been resolved");
			return false;
		}
		
		// Check correct parent
		res = checkCorrectParentRel(cu, vsr);
		if(res == false){
			JOptionPane.showMessageDialog(null, "Invalid: Parent-child relationships inconsistent");
			return false;
		}
		
		// Check mandatory
		res = checkMandatory(cu, vsr);
		if(res == false){
			JOptionPane.showMessageDialog(null, "Invalid: Mandatory feature needs to be included");
			return false;
		}
		
		// Check parent-child
		res = checkPC(cu, vsr);
		if(res == false){
			JOptionPane.showMessageDialog(null, "Invalid: Child cannot be included if parent is not");
			return false;
		}
		
		// Check group
		res = checkGroups(cu, vsr);
		if(res == false){
			JOptionPane.showMessageDialog(null, "Invalid: Group constraint violated");
			return false;
		}
		
		// Evaluate Constraints
		for(Constraint c : cu.getOwnedConstraint()){
			if(c instanceof BCLConstraint){
				res = checkBCLConstraint(((BCLConstraint)c).getExpression().get(0), vsr);
				if(res == false){
					JOptionPane.showMessageDialog(null, "Invalid: Constraint Failed");
					return false;
				}
			}else{
				throw new UnsupportedOperationException();
			}
		}
		
		// Done
		
		return res;
	}

	private boolean checkPC(ConfigurableUnit cu, VSpecResolution vsr) {
		Set<VSpecResolution> vsrs = new HashSet<VSpecResolution>();
		recAddvResChild(vsrs, vsr);
		
		for(VSpecResolution r : vsrs){ // parent
			if(r instanceof ChoiceResolutuion){
				ChoiceResolutuion cr = (ChoiceResolutuion) r;
				for(VSpecResolution c : r.getChild()){
					if(c instanceof VInstance){
						if(cr.isDecision() == false){
							return false;
						}
					}
					if(c instanceof ChoiceResolutuion){
						ChoiceResolutuion crc = (ChoiceResolutuion) c;
						if(cr.isDecision() == false && crc.isDecision() == true){
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}

	private boolean checkGroups(ConfigurableUnit cu, VSpecResolution vsr) {
		Set<VSpecResolution> vsrs = new HashSet<VSpecResolution>();
		recAddvResChild(vsrs, vsr);
		
		for(VSpecResolution r : vsrs){
			VSpec vs = r.getResolvedVSpec();
			MultiplicityInterval mi = vs.getGroupMultiplicity();
			int lower = 0;
			int upper = -1;
			
			if(mi != null){
				lower = mi.getLower();
				upper = mi.getUpper();
			}
			if(upper == -1)
				upper = Integer.MAX_VALUE;
			
			// count included children
			int count = 0;
			for(VSpecResolution c : r.getChild()){
				if(c instanceof VInstance){
					count++;
				}else if(c instanceof ChoiceResolutuion){
					if(((ChoiceResolutuion) c).isDecision())
						count++;
				}else if(c instanceof VariableValueAssignment){
					count++;
				}else{
					throw new UnsupportedOperationException();
				}
			}
			
			// Check
			if(r instanceof ChoiceResolutuion){
				if(((ChoiceResolutuion) r).isDecision()){
					if(count < lower || count > upper)
						return false;
				}
			}else if(r instanceof VInstance){
				if(count < lower || count > upper)
					return false;
			}
		}
		
		return true;
	}

	private boolean checkMandatory(ConfigurableUnit cu, VSpecResolution vsr) {
		Set<VSpecResolution> vsrs = new HashSet<VSpecResolution>();
		recAddvResChild(vsrs, vsr);
		
		for(VSpecResolution r : vsrs){
			if(r instanceof ChoiceResolutuion){
				ChoiceResolutuion cr = (ChoiceResolutuion) r;
				for(VSpecResolution pr : vsrs){
					if(pr instanceof ChoiceResolutuion){
						ChoiceResolutuion pcr = (ChoiceResolutuion) pr;
						if(pcr.getChild().contains(cr)){ // Parent-child
							//System.out.println("Checking " + r.getResolvedVSpec().getName() + ", " + cr.isDecision());
							if(pcr.isDecision() == true && cr.isDecision() == false && ((Choice)cr.getResolvedVSpec()).isIsImpliedByParent()){
								return false;
							}
						}
					}
				}
			}
		}
		
		return true;
	}

	private boolean checkBCLConstraint(BCLExpression exp, VSpecResolution vsr) {
		Set<VSpecResolution> vsrs = new HashSet<VSpecResolution>();
		recAddvResChild(vsrs, vsr);
		
		//System.out.println(vsrs);
		
		if(exp instanceof BooleanLiteralExp){
			return ((BooleanLiteralExp)exp).isBool();
		}else if(exp instanceof VSpecRef){
			for(VSpecResolution r : vsrs){
				if(r.getResolvedVSpec() == ((VSpecRef)exp).getVSpec()){
					return ((ChoiceResolutuion) r).isDecision();
				}
			}
			// Will never happen
			throw new UnsupportedOperationException();
		}else if(exp instanceof OperationCallExp){
			OperationCallExp o = (OperationCallExp)exp;
			if(o.getOperation() == Operation.LOG_NOT){
				boolean res = checkBCLConstraint(o.getArgument().get(0), vsr);
				return !res;
			}else if(o.getOperation() == Operation.LOG_AND){
				boolean res1 = checkBCLConstraint(o.getArgument().get(0), vsr);
				boolean res2 = checkBCLConstraint(o.getArgument().get(1), vsr);
				return res1 && res2;
			}else if(o.getOperation() == Operation.LOG_OR){
				boolean res1 = checkBCLConstraint(o.getArgument().get(0), vsr);
				boolean res2 = checkBCLConstraint(o.getArgument().get(1), vsr);
				return res1 || res2;
			}else if(o.getOperation() == Operation.LOG_IFF){
				boolean res1 = checkBCLConstraint(o.getArgument().get(0), vsr);
				boolean res2 = checkBCLConstraint(o.getArgument().get(1), vsr);
				return (res1 && res2) || (!res1 && !res2);
			}else if(o.getOperation() == Operation.LOG_IMPLIES){
				boolean res1 = checkBCLConstraint(o.getArgument().get(0), vsr);
				boolean res2 = checkBCLConstraint(o.getArgument().get(1), vsr);
				return !res1 || res2;
			}else if(o.getOperation() == Operation.LOG_XOR){
				boolean res1 = checkBCLConstraint(o.getArgument().get(0), vsr);
				boolean res2 = checkBCLConstraint(o.getArgument().get(1), vsr);
				return (!res1 && res2) || (res1 && !res2);
			}else if(o.getOperation() == Operation.GT){
				double res1 = checkBCLConstraintNum(o.getArgument().get(0), vsr);
				double res2 = checkBCLConstraintNum(o.getArgument().get(1), vsr);
				return res1 > res2;
			}else if(o.getOperation() == Operation.LT){
				double res1 = checkBCLConstraintNum(o.getArgument().get(0), vsr);
				double res2 = checkBCLConstraintNum(o.getArgument().get(1), vsr);
				return res1 < res2;
			}else if(o.getOperation() == Operation.EQ){
				double res1 = checkBCLConstraintNum(o.getArgument().get(0), vsr);
				double res2 = checkBCLConstraintNum(o.getArgument().get(1), vsr);
				return res1 == res2;
			}else if(o.getOperation() == Operation.GTE){
				double res1 = checkBCLConstraintNum(o.getArgument().get(0), vsr);
				double res2 = checkBCLConstraintNum(o.getArgument().get(1), vsr);
				return res1 >= res2;
			}else if(o.getOperation() == Operation.LTE){
				double res1 = checkBCLConstraintNum(o.getArgument().get(0), vsr);
				double res2 = checkBCLConstraintNum(o.getArgument().get(1), vsr);
				return res1 <= res2;
			}else{
				throw new UnsupportedOperationException(o.getOperation().getName());
			}
		}else{
			throw new UnsupportedOperationException(exp.getClass().getName());
		}
		
		// Will never happen
		//return false;
	}

	private double checkBCLConstraintNum(BCLExpression exp, VSpecResolution vsr) {
		Set<VSpecResolution> vsrs = new HashSet<VSpecResolution>();
		recAddvResChild(vsrs, vsr);
		
		//System.out.println(vsrs);
		
		if(exp instanceof VSpecRef){
			for(VSpecResolution r : vsrs){
				if(r.getResolvedVSpec() == ((VSpecRef)exp).getVSpec()){
					VariableValueAssignment vva = (VariableValueAssignment)r;
					BCLExpression vs = ((PrimitiveValueSpecification) vva.getValue()).getExpression();
					if(vs instanceof IntegerLiteralExp){
						return ((IntegerLiteralExp) vs).getInteger();						
					}else{
						throw new UnsupportedOperationException(vs.getClass().getName());
					}
				}
			}
			// Will never happen
			throw new UnsupportedOperationException();
		}else if(exp instanceof IntegerLiteralExp){
			return ((IntegerLiteralExp) exp).getInteger();
		}else if(exp instanceof OperationCallExp){
			OperationCallExp o = (OperationCallExp)exp;
			
			if(o.getOperation() == Operation.ARITH_PLUS){
				double res1 = checkBCLConstraintNum(o.getArgument().get(0), vsr);
				double res2 = checkBCLConstraintNum(o.getArgument().get(1), vsr);
				return res1 + res2;
			}else if(o.getOperation() == Operation.ARITH_MINUS){
				double res1 = checkBCLConstraintNum(o.getArgument().get(0), vsr);
				double res2 = checkBCLConstraintNum(o.getArgument().get(1), vsr);
				return res1 - res2;
			}else if(o.getOperation() == Operation.ARITH_MULT){
				double res1 = checkBCLConstraintNum(o.getArgument().get(0), vsr);
				double res2 = checkBCLConstraintNum(o.getArgument().get(1), vsr);
				return res1 * res2;
			}else if(o.getOperation() == Operation.ARITH_DEV){
				double res1 = checkBCLConstraintNum(o.getArgument().get(0), vsr);
				double res2 = checkBCLConstraintNum(o.getArgument().get(1), vsr);
				return res1 / res2;
			}else if(o.getOperation() == Operation.ARITH_NEG){
				double res1 = checkBCLConstraintNum(o.getArgument().get(0), vsr);
				return -res1;
			}else{
				throw new UnsupportedOperationException(o.getOperation().getName());
			}
		}else{
			throw new UnsupportedOperationException(exp.getClass().getName());
		}
	}

	private boolean checkCorrectParentRel(ConfigurableUnit cu, VSpecResolution vsr) {
		// Check roots
		if(!cu.getOwnedVSpecResolution().contains(vsr)){
			return false;
		}
		if(!cu.getOwnedVSpec().contains(vsr.getResolvedVSpec())){
			return false;
		}
		
		// Check the rest
		Set<VSpecResolution> vsrs = new HashSet<VSpecResolution>();
		recAddvResChild(vsrs, vsr);
		
		for(VSpecResolution r : vsrs){ // parent
			for(VSpecResolution c : r.getChild()){ // child
				if(!r.getResolvedVSpec().getChild().contains(c.getResolvedVSpec()))
					return false;
			}
		}
		
		return true;
	}

	private void recAddvResChild(Set<VSpecResolution> vsrs, VSpecResolution vsr) {
		vsrs.add(vsr);
		for(VSpecResolution v : vsr.getChild()){
			recAddvResChild(vsrs, v);
		}
	}

	private boolean checkAllResolved(ConfigurableUnit cu, VSpecResolution vsr) {
		// Collect VSpec
		Set<VSpec> vss = new HashSet<VSpec>();
		recAddChild(vss, vsr.getResolvedVSpec());
		
		// Collected Resolved VSpec
		Set<VSpec> vssr = new HashSet<VSpec>();
		recAddResChild(vssr, vsr);
		
		// Check
		vss.removeAll(vssr);
		if(vss.size() > 0){
			//JOptionPane.showMessageDialog(null, vss.toString());
			return false;
		}
		
		return true;
	}

	private void recAddResChild(Set<VSpec> vssr, VSpecResolution x) {
		vssr.add(x.getResolvedVSpec());
		for(VSpecResolution v : x.getChild()){
			recAddResChild(vssr, v);
		}
	}

	private void recAddChild(Set<VSpec> vss, VSpec x) {
		vss.add(x);
		for(VSpec v : x.getChild()){
			recAddChild(vss, v);
		}
	}

	private boolean checkNull(VSpecResolution vsr) {
		if(vsr.getResolvedVSpec() == null)
			return false;
		else{
			for(VSpecResolution v : vsr.getChild())
				return checkNull(v);
		}
		return true;
	}

}
