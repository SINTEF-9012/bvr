package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import bvr.BCLExpression;
import bvr.BooleanLiteralExp;
import bvr.BvrFactory;
import bvr.IntegerLiteralExp;
import bvr.NumericLiteralExp;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitiveValueSpecification;
import bvr.PrimitveType;
import bvr.RealLiteralExp;
import bvr.StringLiteralExp;
import bvr.UnlimitedLiteralExp;
import bvr.VClassifier;
import bvr.VSpecResolution;
import bvr.Variable;
import bvr.Variabletype;

public class AddValueResolutionEvent implements ActionListener {
	private VSpecResolution cr;
	private Variable target;
	private BVRNotifiableController view;
	static private int count = 0;
	
	public AddValueResolutionEvent(VSpecResolution parent, Variable toResolve, BVRNotifiableController view) {
		cr = parent;
		target = toResolve;
		this.view = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		
		System.out.println("AddValueResolutionEvent running but unimplemented");
		/*Variable v = target;
		
		VariableValueAssignment vi = BvrFactory.eINSTANCE.createVariableValueAssignment();
		
		// Variable
		vi.setResolvedVSpec(v);
		
		// Name
		count++;
		vi.setName("variableAssignment"+count);
		
		// Value
		PrimitiveValueSpecification value = BvrFactory.eINSTANCE.createPrimitiveValueSpecification();
		PrimitiveTypeEnum type = ((PrimitveType)v.getType()).getType();
		
		BCLExpression le;
		if(type == PrimitiveTypeEnum.INTEGER){
			IntegerLiteralExp ie = BvrFactory.eINSTANCE.createIntegerLiteralExp();
			ie.setInteger(0);
			value.setExpression(ie);
			
			le = ie;
		}else if(type == PrimitiveTypeEnum.REAL){
			RealLiteralExp ie = BvrFactory.eINSTANCE.createRealLiteralExp();
			ie.setReal("0.0");
			value.setExpression(ie);
			
			le = ie;
		}else if(type == PrimitiveTypeEnum.BOOLEAN){
			BooleanLiteralExp ie = BvrFactory.eINSTANCE.createBooleanLiteralExp();
			ie.setBool(false);
			value.setExpression(ie);
			
			le = ie;
		}else if(type == PrimitiveTypeEnum.STRING){
			StringLiteralExp ie = BvrFactory.eINSTANCE.createStringLiteralExp();
			ie.setString("");
			value.setExpression(ie);
			
			le = ie;
		}else if(type == PrimitiveTypeEnum.UNLIMITED_NATURAL){
			UnlimitedLiteralExp ie = BvrFactory.eINSTANCE.createUnlimitedLiteralExp();
			ie.setUnlimited(0);
			value.setExpression(ie);
			
			le = ie;
		}else{
			throw new UnsupportedOperationException("Unsupported: "+type);
		}
		
		// Try searching for a type
		
		//This is wrong, ReplacementGragmentType is a Variabletype, but not a  PrimitveType, thus we throw an exeption
		//COMMENTED OUT for now!!!
		PrimitveType vt = null;
		for(Variabletype x : view.getCU().getOwnedVariabletype()){
			if(x instanceof PrimitveType){
				PrimitveType pt = (PrimitveType)x;
				if(pt.getType() == type)
					vt = pt;
			}else{
				System.out.println("we shoould throw here exception COMMENTED OUT");
				//throw new UnsupportedOperationException();
			}
		}
		
		// Create type
		if(vt == null){
			vt = BvrFactory.eINSTANCE.createPrimitveType();
			vt.setType(type);
			vt.setName("xx");
			//view.getCU().getOwnedVariabletype().add(vt);
			Context.eINSTANCE.getEditorCommands().addVariableType(view.getCU(), vt);
		}
		value.setType(vt);
		
		// Set exp
		vi.setValue(value);
		
		// Add
		Context.eINSTANCE.getEditorCommands().addVariableValueAssignment(cr, vi);*/
	}

}
