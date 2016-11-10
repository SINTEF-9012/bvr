package no.sintef.bvr.dvl.execution.autoreal;

import no.sintef.bvr.planner.operators.And;
import no.sintef.bvr.planner.operators.Not;
import no.sintef.bvr.planner.operators.Or;
import no.sintef.bvr.planner.operators.Xor;
import no.sintef.bvr.planner.operators.interfaces.IExpression;
import no.sintef.bvr.planner.operators.interfaces.IOperator;
import no.sintef.bvr.planner.repository.ReaderException;
import realop.AndExp;
import realop.Expression;
import realop.IsNegative;
import realop.IsPositive;
import realop.IsRealised;
import realop.NotExp;
import realop.Operator;
import realop.OrExp;
import realop.XorExp;

public class EcoreModelOperatorConverter {
	private IOperator operator;
	private IExpression preExp;
	private IExpression postExp;

	public IOperator convert(Operator ecore_operator) throws ReaderException {
		preExp = convertExpression(ecore_operator.getExpPre(), preExp);
		postExp = convertExpression(ecore_operator.getExpPost(), postExp);

		operator = new no.sintef.bvr.planner.operators.Operator(ecore_operator.getName(), preExp, postExp);

		return operator;
	}

	private IExpression convertExpression(Expression ecore_exp, IExpression result) throws ReaderException {
		if (isExpression(ecore_exp))
			return convertIsExpression(ecore_exp, result);

		if (ecore_exp instanceof AndExp) {
			AndExp ecore_and = (AndExp) ecore_exp;
			IExpression left = convertExpression(ecore_and.getLeft(), result);
			IExpression right = convertExpression(ecore_and.getRight(), result);
			result = new And(left, right);
		} else if (ecore_exp instanceof NotExp) {
			NotExp ecore_not = (NotExp) ecore_exp;
			IExpression exp = convertExpression(ecore_not.getExp(), result);
			result = new Not(exp);
		} else if (ecore_exp instanceof OrExp) {
			OrExp ecore_or = (OrExp) ecore_exp;
			IExpression left = convertExpression(ecore_or.getLeft(), result);
			IExpression right = convertExpression(ecore_or.getRight(), result);
			result = new Or(left, right);
		} else if (ecore_exp instanceof XorExp) {
			XorExp ecore_xor = (XorExp) ecore_exp;
			IExpression left = convertExpression(ecore_xor.getLeft(), result);
			IExpression right = convertExpression(ecore_xor.getRight(), result);
			result = new Xor(left, right);
		} else {
			throw new ReaderException("do not know how to conver " + ecore_exp);
		}

		return result;
	}

	private IExpression convertIsExpression(Expression ecore_isexp, IExpression result) throws ReaderException {

		if (ecore_isexp instanceof IsRealised) {
			result = new no.sintef.bvr.planner.operators.IsRealised(((IsRealised) ecore_isexp).getFeatureName());
		} else if (ecore_isexp instanceof IsPositive) {
			result = new no.sintef.bvr.planner.operators.IsPositive(((IsPositive) ecore_isexp).getFeatureName());
		} else if (ecore_isexp instanceof IsNegative) {
			result = new no.sintef.bvr.planner.operators.IsNegative(((IsNegative) ecore_isexp).getFeatureName());
		} else {
			throw new ReaderException("do not know how to conver " + ecore_isexp);
		}
		return result;
	}

	private boolean isExpression(Expression exp) {
		return (exp instanceof IsRealised || exp instanceof IsNegative || exp instanceof IsPositive);
	}

}
