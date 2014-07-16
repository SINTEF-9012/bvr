package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRView;
import bvr.BvrFactory;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitiveValueSpecification;
import bvr.PrimitveType;
import bvr.VSpecResolution;
import bvr.Variable;
import bvr.VariableValueAssignment;
import bvr.common.PrimitiveTypeHandler;



public class AddVariableValueAssignmentEventV2 implements ActionListener {
	private VSpecResolution vsr;
	private Variable target;
	private BVRView view;
	static private int count = 0;
	private VariableValueAssignment vva;



	public AddVariableValueAssignmentEventV2(VSpecResolution parent, Variable toResolve, BVRView view) {
		vsr = parent;
		target = toResolve;
		this.view = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		Variable v = target;

		vva = BvrFactory.eINSTANCE.createVariableValueAssignment();

		// Variable
		vva.setResolvedVSpec(v);

		// Name
		count++;
		vva.setName(target.getName() + " Assignment " + count);

		// Value
		PrimitiveValueSpecification value = PrimitiveTypeHandler.getInstance().makeValueSpecification(v);
		PrimitiveTypeEnum type = ((PrimitveType) v.getType()).getType();
		// Try searching for a type

		PrimitveType vt = PrimitiveTypeHandler.getInstance().makeType(view.getCU(), type);
		value.setType(vt);

		// Set exp
		vva.setValue(value);

		// Add
		Context.eINSTANCE.getEditorCommands().addVariableValueAssignment(vsr, vva);




		//view.notifyResolutionViewUpdate();
	}
	public VariableValueAssignment getVarableValueAssignment(){
		return vva;
	}

}