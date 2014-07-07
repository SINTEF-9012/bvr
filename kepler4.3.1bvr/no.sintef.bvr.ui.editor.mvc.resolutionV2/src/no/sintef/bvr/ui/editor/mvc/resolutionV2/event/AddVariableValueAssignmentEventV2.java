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
import bvr.common.PrimitiveTypeGenerator;
import bvr.common.PrimitiveValueGenerator;



public class AddVariableValueAssignmentEventV2 implements ActionListener {
	private VSpecResolution cr;
	private Variable target;
	private BVRView view;
	static private int count = 0;
	private VariableValueAssignment vi;



	public AddVariableValueAssignmentEventV2(VSpecResolution parent, Variable toResolve, BVRView view) {
		cr = parent;
		target = toResolve;
		this.view = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		Variable v = target;

		vi = BvrFactory.eINSTANCE.createVariableValueAssignment();

		// Variable
		vi.setResolvedVSpec(v);

		// Name
		count++;
		vi.setName(target.getName() + " Assignment " + count);

		// Value
		PrimitiveValueSpecification value = (new PrimitiveValueGenerator().make(v));
		PrimitiveTypeEnum type = ((PrimitveType) v.getType()).getType();
		// Try searching for a type

		//This is wrong, ReplacementGragmentType is a Variabletype, but not a  PrimitveType, thus we throw an exeption
		//COMMENTED OUT for now!!!
		PrimitveType vt = (new PrimitiveTypeGenerator().make(view.getCU(), type));
		value.setType(vt);

		// Set exp
		vi.setValue(value);

		// Add
		Context.eINSTANCE.getEditorCommands().addVariableValueAssignment(cr, vi);
		//cr.getChild().add(vi);



		//view.notifyResolutionViewUpdate();
	}
	public VariableValueAssignment getVarableValueAssignment(){
		return vi;
	}

}