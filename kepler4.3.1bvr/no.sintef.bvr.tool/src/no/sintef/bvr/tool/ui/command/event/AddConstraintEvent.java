package no.sintef.bvr.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.elements.ConfigurableUnitSymbolPanel;
import bvr.BCLConstraint;
import bvr.BCLExpression;
import bvr.ConfigurableUnit;
import bvr.Constraint;
import bvr.BvrFactory;
import bvr.MultiplicityInterval;
import bvr.NamedElement;
import bvr.OpaqueConstraint;
import bvr.VClassifier;
import bvr.VSpec;
import bvr.VSpecRef;

public class AddConstraintEvent implements ActionListener {

	private JComponent p;
	private Map<JComponent, NamedElement> vmMap;
	private BVRView view;

	public AddConstraintEvent(JComponent p, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRView view) {
		this.p = p;
		this.vmMap = vmMap;
		this.view = view;
	}
	
	static int x = 1;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		VSpec v = (VSpec)vmMap.get(p);
		BCLConstraint c = BvrFactory.eINSTANCE.createBCLConstraint();
		c.setName("Constraint"+x);
		x++;
		VSpecRef e = BvrFactory.eINSTANCE.createVSpecRef();
		e.setVSpec(null);
		c.getExpression().add(e);
		c.setContext(v);
		
		ConfigurableUnit cu = view.getCU();
		Context.eINSTANCE.getEditorCommands().addBCLConstraint(cu, c);
		//cu.getOwnedConstraint().add(c);
		
		// Regenerate view
		//view.notifyVspecViewUpdate();
	}

}
