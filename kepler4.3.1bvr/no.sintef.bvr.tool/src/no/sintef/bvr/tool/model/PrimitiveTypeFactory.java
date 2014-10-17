package no.sintef.bvr.tool.model;


import java.util.ArrayList;
import java.util.List;

import no.sintef.bvr.tool.context.Context;
import bvr.BCLExpression;
import bvr.BVRModel;
import bvr.BooleanLiteralExp;
import bvr.BvrFactory;
import bvr.IntegerLiteralExp;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitiveValueSpecification;
import bvr.PrimitveType;
import bvr.RealLiteralExp;
import bvr.StringLiteralExp;
import bvr.UnlimitedLiteralExp;
import bvr.VPackageable;
import bvr.ValueResolution;
import bvr.ValueSpecification;
import bvr.Variable;
import bvr.Variabletype;

public class PrimitiveTypeFactory {
	
	private static PrimitiveTypeFactory instance = null;
	private PrimitiveTypeFactory(){
		
	}
	public static synchronized PrimitiveTypeFactory getInstance(){
		if(instance == null){
			instance = new PrimitiveTypeFactory();
		}
		return instance;
	}
	
	public List<PrimitveType> testModelsPrimitiveTypes(BVRModel model){
		List<PrimitveType> primitiveType = new ArrayList<PrimitveType>();
		for(PrimitiveTypeEnum x : PrimitiveTypeEnum.VALUES)
			primitiveType.add(testPrimitiveType(model, x));
		return primitiveType;
	}
	
	public PrimitveType testPrimitiveType(BVRModel model, PrimitiveTypeEnum type){
		PrimitveType vt = null;
		for(VPackageable x : model.getPackageElement()){
			if(x instanceof Variabletype){
				if(x instanceof PrimitveType){
					PrimitveType pt = (PrimitveType)x;
					if(pt.getType() == type)
						vt = pt;
				}else{
					//throw new UnsupportedOperationException("Unsupported variable type, only primitive types are supported " + x);
				}
			}
		}
	
		// Create type
		if(vt == null){
			vt = BvrFactory.eINSTANCE.createPrimitveType();
			vt.setType(type);
			vt.setName(type.getLiteral());
			Context.eINSTANCE.getEditorCommands().addOwnedVariationType(model, vt);
		}
		return vt;
	}
	
	public PrimitiveValueSpecification makeValueSpecification(Variable v) {
		PrimitiveValueSpecification value = BvrFactory.eINSTANCE.createPrimitiveValueSpecification();
		PrimitiveTypeEnum type = ((PrimitveType) v.getType()).getType();

		if (type == PrimitiveTypeEnum.INTEGER) {
			IntegerLiteralExp ie = BvrFactory.eINSTANCE.createIntegerLiteralExp();
			ie.setInteger(0);
			value.setExpression(ie);

		} else if (type == PrimitiveTypeEnum.REAL) {
			RealLiteralExp ie = BvrFactory.eINSTANCE.createRealLiteralExp();
			ie.setReal("0.0");
			value.setExpression(ie);

		} else if (type == PrimitiveTypeEnum.BOOLEAN) {
			BooleanLiteralExp ie = BvrFactory.eINSTANCE.createBooleanLiteralExp();
			ie.setBool(false);
			value.setExpression(ie);

		} else if (type == PrimitiveTypeEnum.STRING) {
			StringLiteralExp ie = BvrFactory.eINSTANCE.createStringLiteralExp();
			ie.setString("");
			value.setExpression(ie);

		} else if (type == PrimitiveTypeEnum.UNLIMITED_NATURAL) {
			UnlimitedLiteralExp ie = BvrFactory.eINSTANCE.createUnlimitedLiteralExp();
			ie.setUnlimited(0);
			value.setExpression(ie);

		} else {
			throw new UnsupportedOperationException("Unsupported: " + type);
		}
		return value;
	}
	
	public PrimitiveValueSpecification makeValueSpecification(Variable v, String valueStr) {
		PrimitiveValueSpecification value = BvrFactory.eINSTANCE.createPrimitiveValueSpecification();
		PrimitiveTypeEnum type = ((PrimitveType) v.getType()).getType();
		
		if (type == PrimitiveTypeEnum.INTEGER) {
			IntegerLiteralExp ie = BvrFactory.eINSTANCE.createIntegerLiteralExp();
			ie.setInteger(Integer.parseInt(valueStr));
			value.setExpression(ie);
			
		} else if (type == PrimitiveTypeEnum.REAL) {
			RealLiteralExp ie = BvrFactory.eINSTANCE.createRealLiteralExp();
			ie.setReal(valueStr);
			value.setExpression(ie);
			
		} else if (type == PrimitiveTypeEnum.BOOLEAN) {
			BooleanLiteralExp ie = BvrFactory.eINSTANCE.createBooleanLiteralExp();
			ie.setBool(Boolean.parseBoolean(valueStr));
			value.setExpression(ie);
			
		} else if (type == PrimitiveTypeEnum.STRING) {
			StringLiteralExp ie = BvrFactory.eINSTANCE.createStringLiteralExp();
			ie.setString(valueStr);
			value.setExpression(ie);
			
		} else if (type == PrimitiveTypeEnum.UNLIMITED_NATURAL) {
			UnlimitedLiteralExp ie = BvrFactory.eINSTANCE.createUnlimitedLiteralExp();
			ie.setUnlimited(Integer.parseInt(valueStr));
			value.setExpression(ie);
			
		} else {
			throw new UnsupportedOperationException("Unsupported: " + type);
		}
		return value;
	}
	
	public String getValueAsString(ValueResolution elem) {
		String value = "";
		ValueSpecification vs = elem.getValue();
		if (vs instanceof PrimitiveValueSpecification) {
			PrimitiveValueSpecification pvs = (PrimitiveValueSpecification) vs;
			BCLExpression e = pvs.getExpression();
			if (e instanceof StringLiteralExp) {
				StringLiteralExp sle = (StringLiteralExp) e;
				value = sle.getString();
			} else if (e instanceof IntegerLiteralExp) {
				IntegerLiteralExp sle = (IntegerLiteralExp) e;
				value = "" + sle.getInteger();
			} else if (e instanceof RealLiteralExp) {
				RealLiteralExp sle = (RealLiteralExp) e;
				value = sle.getReal();
			} else if (e instanceof BooleanLiteralExp) {
				BooleanLiteralExp sle = (BooleanLiteralExp) e;
				value = "" + sle.isBool();
			} else if (e instanceof UnlimitedLiteralExp) {
				UnlimitedLiteralExp sle = (UnlimitedLiteralExp) e;
				value = "" + sle.getUnlimited();
			} else {
				throw new UnsupportedOperationException("Unsupported Expression for PrimitiveValueSpecification " + e);
			}
		} else {
			throw new UnsupportedOperationException("not PrimitiveValueSpecification is not suppoerted yet " + vs);
		}
		return value;
	}
}
