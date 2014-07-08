package no.sintef.bvr.ui.editor.mvc.resolutionV2.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRView;
import bvr.BvrFactory;
import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitiveValueSpecification;
import bvr.PrimitveType;
import bvr.VClassifier;
import bvr.VInstance;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.Variable;
import bvr.VariableValueAssignment;
import bvr.common.PrimitiveTypeGenerator;
import bvr.common.PrimitiveValueGenerator;

public class AddVInstanceTreeEvent implements ActionListener {

	private BVRView view;
	private VSpec target;
	VSpecResolution c;

	public AddVInstanceTreeEvent(VSpecResolution c, VSpec x, BVRView view) {

		this.view = view;
		this.target = x;
		this.c = c;
	}
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("starting tree event");
		System.out.println("target is " + target.getName());
		VInstance root = BvrFactory.eINSTANCE.createVInstance();
		for(VSpec y : target.getChild()){
			System.out.println("y is of type: " +y.getClass() +"and is named: "+ y.getName());
			if (y instanceof Choice) {
				System.out.println("adding choice");
				VSpecResolution e = BvrFactory.eINSTANCE.createChoiceResolutuion();
				e.setResolvedVSpec(y);
				e.setName(y.getName());
				((ChoiceResolutuion)e).setDecision(false);
				root.getChild().add(e);
				
			}
			if (y instanceof VClassifier) {
				int min;
				if (((VClassifier) y).getInstanceMultiplicity() != null) {
					min = ((VClassifier) y).getInstanceMultiplicity().getLower();
				} else {
					System.err.println("instance error");
					min = 1;
				}
				for (int i = 0; i < min; i++) {
					VSpecResolution e = BvrFactory.eINSTANCE.createVInstance();
					e.setResolvedVSpec(y);
					e.setName(y.getName());
					root.getChild().add(e);
					
				}
				min = 0;
			}
			if (y instanceof Variable) {
				VSpecResolution e = BvrFactory.eINSTANCE.createVariableValueAssignment();
				e.setResolvedVSpec(y);
				e.setName(target.getName() + " Assignment ");
				// Value		
				PrimitiveValueSpecification value = (new PrimitiveValueGenerator().make((Variable) y));
				PrimitiveTypeEnum type = ((PrimitveType) ((Variable)y).getType()).getType();
				// Try searching for a type

				PrimitveType vt = (new PrimitiveTypeGenerator().make(view.getCU(), type));
				value.setType(vt);
				
				((VariableValueAssignment)e).setValue(value);
				root.getChild().add(e);
			}
		}
		root.setResolvedVSpec(target);
		root.setName(target.getName() + "Get ccount for name in AddVInstanceTreeEvent");
		Context.eINSTANCE.getEditorCommands().addVInstance(c, root);
		/*
		start = System.currentTimeMillis();
		List<VSpecResolution> thisResolution = new ArrayList<VSpecResolution>();
		thisResolution = new AddResolution().init(view, target, c, true).execute();
		new Iterators().iterateEmptyWithChildren(view, new AddResolution(), target, thisResolution.get(0), false);
		System.out.println("time taken for old = " + (System.currentTimeMillis() - start));*/
	}

}
