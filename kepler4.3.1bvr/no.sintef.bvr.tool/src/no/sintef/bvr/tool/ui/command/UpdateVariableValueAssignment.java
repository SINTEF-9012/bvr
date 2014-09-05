package no.sintef.bvr.tool.ui.command;

import java.util.List;
import java.util.Map;
import javax.swing.JComponent;

import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRToolView;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.BCLExpression;
import bvr.BooleanLiteralExp;
import bvr.IntegerLiteralExp;
import bvr.NamedElement;
import bvr.PrimitiveValueSpecification;
import bvr.RealLiteralExp;
import bvr.StringLiteralExp;
import bvr.UnlimitedLiteralExp;
import bvr.ValueSpecification;

public class UpdateVariableValueAssignment extends UpdateVSpec  {
	@Override
	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, BVRToolView view) {
		return super.init(rootPanel, p, parent, vmMap, nodes, bindings, view);
	}

	@Override
	public JComponent execute() {
		super.execute();
		return null;
	}

	public void setValue(String value) {
		//System.out.println("whey!");
		
		///setValueAsString((VariableValueAssignment)vc, value);
	}
	
	/*private void setValueAsString(VariableValueAssignment elem, String value) {
		ValueSpecification vs = elem.getValue();
		if(vs instanceof PrimitiveValueSpecification){
			PrimitiveValueSpecification pvs = (PrimitiveValueSpecification) vs;
			BCLExpression e = pvs.getExpression();
			if(e instanceof StringLiteralExp){
				StringLiteralExp sle = (StringLiteralExp) e;
				sle.setString(value);
			}else if(e instanceof IntegerLiteralExp){
				IntegerLiteralExp sle = (IntegerLiteralExp) e;
				sle.setInteger(Integer.parseInt(value));
			}else if(e instanceof RealLiteralExp){
				RealLiteralExp sle = (RealLiteralExp) e;
				sle.setReal(""+Double.parseDouble(value));
			}else if(e instanceof BooleanLiteralExp){
				BooleanLiteralExp sle = (BooleanLiteralExp) e;
				sle.setBool(Boolean.parseBoolean(value));
			}else if(e instanceof UnlimitedLiteralExp){
				UnlimitedLiteralExp sle = (UnlimitedLiteralExp) e;
				sle.setUnlimited(Integer.parseInt(value));
			}else{
				throw new UnsupportedOperationException();
			}
		}else{
			throw new UnsupportedOperationException();
		}
	}*/
}
