package bvr.common;

import bvr.BooleanLiteralExp;
import bvr.BvrFactory;
import bvr.IntegerLiteralExp;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitiveValueSpecification;
import bvr.PrimitveType;
import bvr.RealLiteralExp;
import bvr.StringLiteralExp;
import bvr.UnlimitedLiteralExp;
import bvr.Variable;

public class PrimitiveValueGenerator {
	public PrimitiveValueSpecification make(Variable v) {
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
	public PrimitiveValueSpecification make(Variable v, String valueStr) {
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
}
