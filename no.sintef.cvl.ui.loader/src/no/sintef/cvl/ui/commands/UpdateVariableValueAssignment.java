package no.sintef.cvl.ui.commands;

import java.util.List;
import java.util.Map;
import javax.swing.JComponent;

import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.loader.Pair;
import cvl.BCLExpression;
import cvl.BooleanLiteralExp;
import cvl.IntegerLiteralExp;
import cvl.NamedElement;
import cvl.PrimitiveValueSpecification;
import cvl.RealLiteralExp;
import cvl.StringLiteralExp;
import cvl.UnlimitedLiteralExp;
import cvl.ValueSpecification;
import cvl.VariableValueAssignment;

public class UpdateVariableValueAssignment extends UpdateVSpec  {
	@Override
	public Command init(CVLUIKernel rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, CVLView view) {
		return super.init(rootPanel, p, parent, vmMap, nodes, bindings, view);
	}

	@Override
	public JComponent execute() {
		super.execute();
		view.notifyResolutionViewUpdate();
		return null;
	}

	public void setValue(String value) {
		System.out.println("whey!");
		
		setValueAsString((VariableValueAssignment)vc, value);
	}
	
	private void setValueAsString(VariableValueAssignment elem, String value) {
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
	}
}
