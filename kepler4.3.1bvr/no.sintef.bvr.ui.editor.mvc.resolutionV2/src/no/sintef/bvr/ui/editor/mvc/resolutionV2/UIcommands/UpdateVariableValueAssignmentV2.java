package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.command.Command;
import no.sintef.bvr.tool.ui.command.UpdateVariableValueAssignment;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.tool.ui.loader.Pair;
import bvr.NamedElement;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitiveValueSpecification;
import bvr.PrimitveType;
import bvr.Variable;
import bvr.VariableValueAssignment;
import bvr.common.PrimitiveTypeGenerator;
import bvr.common.PrimitiveValueGenerator;

public class UpdateVariableValueAssignmentV2 extends UpdateVariableValueAssignment  {
	@Override
	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, BVRView view) {
		return super.init(rootPanel, p, parent, vmMap, nodes, bindings, view);
	}

	@Override
	public JComponent execute() {
		super.execute();
		return null;
	}

	public void setValue(String value) {
		//System.out.println("whey!");
		
		setValueAsString((VariableValueAssignment)vc, value);
	}
	
	//this was not transactional, logic for creating primitivs moved to bvr.common for reusability, 
	private void setValueAsString(VariableValueAssignment elem, String strValue) {
	PrimitiveValueSpecification value = (new PrimitiveValueGenerator().make((Variable) elem.getResolvedVSpec(), strValue));
	PrimitiveTypeEnum type = ((PrimitveType)((Variable)elem.getResolvedVSpec()).getType()).getType();
	PrimitveType vt = (new PrimitiveTypeGenerator().make(view.getCU(), type));
	value.setType(vt);

	Context.eINSTANCE.getEditorCommands().SetValueForVariableValueAssignment(elem, value);

	}
}
