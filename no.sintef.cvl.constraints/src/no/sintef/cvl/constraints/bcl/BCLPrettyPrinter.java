package no.sintef.cvl.constraints.bcl;

import cvl.BCLExpression;
import cvl.ConfigurableUnit;
import cvl.IntegerLiteralExp;
import cvl.OperationCallExp;
import cvl.RealLiteralExp;
import cvl.StringLiteralExp;
import cvl.VSpecRef;

class BCLPrettyPrinter{
	public String prettyPrint(BCLExpression e, ConfigurableUnit cu) {
		return prettyPrint(e, cu, 0);
	}
	
	private String prettyPrint(BCLExpression e, ConfigurableUnit cu, int depth) {
		if(e instanceof VSpecRef){
			if(((VSpecRef) e).getVSpec() == null)
				return "[null]";
			else
				return ((VSpecRef) e).getVSpec().getName();
		}else if(e instanceof StringLiteralExp){
			return "\"" + ((StringLiteralExp)e).getString() + "\"";
		}else if(e instanceof IntegerLiteralExp){
			return ""+((IntegerLiteralExp)e).getInteger();
		}else if(e instanceof RealLiteralExp){
			return ""+((RealLiteralExp)e).getReal();
		}else if(e instanceof OperationCallExp){
			OperationCallExp o = (OperationCallExp) e;
			String opSym = "";
			if(o.getOperation() == cvl.Operation.getByName("logImplies")) opSym = "implies";
			if(o.getOperation() == cvl.Operation.getByName("logAnd")) opSym = "and"; 
			if(o.getOperation() == cvl.Operation.getByName("logOr")) opSym = "or"; 
			if(o.getOperation() == cvl.Operation.getByName("logXor")) opSym = "xor"; 
			if(o.getOperation() == cvl.Operation.getByName("eq")) opSym = "="; 
			if(o.getOperation() == cvl.Operation.getByName("lte")) opSym = "<="; 
			if(o.getOperation() == cvl.Operation.getByName("gte")) opSym = ">="; 
			if(o.getOperation() == cvl.Operation.getByName("lt")) opSym = "<"; 
			if(o.getOperation() == cvl.Operation.getByName("gt")) opSym = ">"; 
			if(o.getOperation() == cvl.Operation.getByName("arithMult")) opSym = "*";
			if(o.getOperation() == cvl.Operation.getByName("arithDev")) opSym = "/";
			if(o.getOperation() == cvl.Operation.getByName("arithPlus")) opSym = "+";
			if(o.getOperation() == cvl.Operation.getByName("arithMinus")) opSym = "-";
			
			String a1 = prettyPrint(o.getArgument().get(0), cu, depth+1);
			String a2 = prettyPrint(o.getArgument().get(1), cu, depth+1);
			
			String in = a1 + " " + opSym + " " + a2;
			if(depth != 0)
				return "(" + in + ")";
			else return in;
		}else{
			throw new UnsupportedOperationException("Unsupported type: " + e.getClass().getName());
		}
	}
}