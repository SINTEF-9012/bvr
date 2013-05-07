package no.sintef.cvl.ui.commands.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.cvl.ui.loader.CVLView;
import cvl.BCLExpression;
import cvl.BooleanLiteralExp;
import cvl.ChoiceResolutuion;
import cvl.CvlFactory;
import cvl.IntegerLiteralExp;
import cvl.NumericLiteralExp;
import cvl.PrimitiveTypeEnum;
import cvl.PrimitiveValueSpecification;
import cvl.PrimitveType;
import cvl.RealLiteralExp;
import cvl.StringLiteralExp;
import cvl.UnlimitedLiteralExp;
import cvl.VClassifier;
import cvl.VInstance;
import cvl.VSpecResolution;
import cvl.Variable;
import cvl.VariableValueAssignment;
import cvl.Variabletype;

public class AddVariableValueAssignmentEvent implements ActionListener {
	private VSpecResolution cr;
	private Variable target;
	private CVLView view;
	static private int count = 0;
	
	public AddVariableValueAssignmentEvent(VSpecResolution parent, Variable toResolve, CVLView view) {
		cr = parent;
		target = toResolve;
		this.view = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		Variable v = target;
		
		VariableValueAssignment vi = CvlFactory.eINSTANCE.createVariableValueAssignment();
		
		// Variable
		vi.setResolvedVariable(v);
		
		// Name
		count++;
		vi.setName("variable"+count);
		
		// Value
		PrimitiveValueSpecification value = CvlFactory.eINSTANCE.createPrimitiveValueSpecification();
		PrimitiveTypeEnum type = ((PrimitveType)v.getType()).getType();
		
		BCLExpression le;
		if(type == PrimitiveTypeEnum.INTEGER){
			IntegerLiteralExp ie = CvlFactory.eINSTANCE.createIntegerLiteralExp();
			ie.setInteger(0);
			value.setExpression(ie);
			
			le = ie;
		}else if(type == PrimitiveTypeEnum.REAL){
			RealLiteralExp ie = CvlFactory.eINSTANCE.createRealLiteralExp();
			ie.setReal("0.0");
			value.setExpression(ie);
			
			le = ie;
		}else if(type == PrimitiveTypeEnum.BOOLEAN){
			BooleanLiteralExp ie = CvlFactory.eINSTANCE.createBooleanLiteralExp();
			ie.setBool(false);
			value.setExpression(ie);
			
			le = ie;
		}else if(type == PrimitiveTypeEnum.STRING){
			StringLiteralExp ie = CvlFactory.eINSTANCE.createStringLiteralExp();
			ie.setString("");
			value.setExpression(ie);
			
			le = ie;
		}else if(type == PrimitiveTypeEnum.UNLIMITED_NATURAL){
			UnlimitedLiteralExp ie = CvlFactory.eINSTANCE.createUnlimitedLiteralExp();
			ie.setUnlimited(0);
			value.setExpression(ie);
			
			le = ie;
		}else{
			throw new UnsupportedOperationException("Unsupported: "+type);
		}
		
		// Try searching for a type
		PrimitveType vt = null;
		for(Variabletype x : view.getCU().getOwnedVariabletype()){
			if(x instanceof PrimitveType){
				PrimitveType pt = (PrimitveType)x;
				if(pt.getType() == type)
					vt = pt;
			}else{
				throw new UnsupportedOperationException();
			}
		}
		
		// Create type
		if(vt == null){
			vt = CvlFactory.eINSTANCE.createPrimitveType();
			vt.setType(type);
			vt.setName("xx");
			view.getCU().getOwnedVariabletype().add(vt);
		}
		value.setType(vt);
		
		// Set exp
		vi.setValue(value);
		
		// Add
		cr.getChild().add(vi);
		

		
		view.notifyResolutionViewUpdate();
	}

}
