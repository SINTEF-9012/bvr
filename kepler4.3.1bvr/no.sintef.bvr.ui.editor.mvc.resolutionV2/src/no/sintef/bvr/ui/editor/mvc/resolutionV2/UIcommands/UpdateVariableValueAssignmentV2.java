package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.UpdateVariableValueAssignment;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import bvr.NamedElement;
//import bvr.PrimitiveTypeEnum;
import bvr.PrimitiveValueSpecification;
import bvr.PrimitveType;
import bvr.Variable;
//import bvr.VariableValueAssignment;
//import bvr.common.PrimitiveTypeHandler;

public class UpdateVariableValueAssignmentV2 implements UICommand  {
	protected BVRUIKernel rootPanel;
	protected JComponent parent;
	protected NamedElement vc;
	protected Map<JComponent, NamedElement> vmMap;
	protected List<JComponent> nodes;
	protected List<Pair<JComponent, JComponent>> bindings;
	protected BVRNotifiableController view;
	
	protected String name;
	@Override
	public UICommand init(BVRUIKernel rootPanel, Object p, JComponent parent,
			Map<JComponent, NamedElement> vmMap, List<JComponent> nodes,
			List<Pair<JComponent, JComponent>> bindings, BVRResolutionToolView view) {
		if(p instanceof NamedElement){
			this.rootPanel = rootPanel;
			this.vc = (NamedElement) p;
			this.parent = parent;
			
			this.name = vc.getName();
		}
		
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.view = view;
		
		return this;
		
	}

	@Override
	public JComponent execute() {

		return null;
	}

	public void setValue(String value) {
		//System.out.println("whey!");
		
		//setValueAsString((VariableValueAssignment)vc, value);
	}
	
	//this was not transactional, logic for creating primitivs moved to bvr.common for reusability, 
/*	private void setValueAsString(VariableValueAssignment elem, String strValue) {
	PrimitiveValueSpecification value = PrimitiveTypeHandler.getInstance().makeValueSpecification((Variable) elem.getResolvedVSpec(), strValue);
	PrimitiveTypeEnum type = ((PrimitveType)((Variable)elem.getResolvedVSpec()).getType()).getType();
	PrimitveType vt = PrimitiveTypeHandler.getInstance().makeType(view.getCU(), type);
	value.setType(vt);

	Context.eINSTANCE.getEditorCommands().SetValueForVariableValueAssignment(elem, value);

	}*/
}
