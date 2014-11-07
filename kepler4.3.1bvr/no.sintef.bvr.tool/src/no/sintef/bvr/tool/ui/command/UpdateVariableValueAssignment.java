package no.sintef.bvr.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.controller.command.Command;
import no.sintef.bvr.tool.controller.command.UpdateVSpec;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.NamedElement;
import bvr.PrimitiveValueSpecification;
import bvr.RealLiteralExp;
import bvr.StringLiteralExp;
import bvr.UnlimitedLiteralExp;
import bvr.ValueSpecification;
import bvr.Variable;

public class UpdateVariableValueAssignment extends UpdateVSpec  {
	@Override
	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, BVRNotifiableController view) {
		return super.init(rootPanel, p, parent, vmMap, nodes, bindings, view);
	}

	@Override
	public JComponent execute() {
		//super.execute();
		return null;
	}

	public void setValue(String value) {
		//System.out.println("whey!");
		
		///setValueAsString((VariableValueAssignment)vc, value);
	}

	@Override
	public void setVariable(Variable v, String name, String type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setComment(String text) {
		// TODO Auto-generated method stub
		
	}
	
/*	//TODO replace with functionality for new model
	//this was not transactional, logic for creating primitivs moved to bvr.common for reusability, 
	private void setValueAsString(VariableValueAssignment elem, String strValue) {
		PrimitiveValueSpecification value = (PrimitiveTypeHandler.getInstance().makeValueSpecification((Variable) elem.getResolvedVSpec(), strValue));
		PrimitiveTypeEnum type = ((PrimitveType)((Variable)elem.getResolvedVSpec()).getType()).getType();
		PrimitveType vt = PrimitiveTypeHandler.getInstance().makeType(view.getCU(), type);
		value.setType(vt);

		Context.eINSTANCE.getEditorCommands().SetValueForVariableValueAssignment(elem, value);

	}
*/
}
