package no.sintef.cvl.ui.commands.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.ui.framework.elements.ConfigurableUnitSymbolPanel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.loader.Pair;
import cvl.BCLConstraint;
import cvl.BCLExpression;
import cvl.ConfigurableUnit;
import cvl.Constraint;
import cvl.CvlFactory;
import cvl.MultiplicityInterval;
import cvl.NamedElement;
import cvl.OpaqueConstraint;
import cvl.VClassifier;
import cvl.VSpec;
import cvl.VSpecRef;

public class AddConstraintEvent implements ActionListener {

	private JComponent p;
	private Map<JComponent, NamedElement> vmMap;
	private CVLView view;

	public AddConstraintEvent(JComponent p, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view) {
		this.p = p;
		this.vmMap = vmMap;
		this.view = view;
	}
	
	static int x = 1;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		VSpec v = (VSpec)vmMap.get(p);
		//System.out.println("we are here " + p.getTitle() + ", " + v);
		
		// Modify model
		/*
		OpaqueConstraint c = CvlFactory.eINSTANCE.createOpaqueConstraint();
		c.setConstraint("xx");
		c.setConstraintLanguage("PropLogic");
		c.setName("Constraint"+x);
		*/
		BCLConstraint c = CvlFactory.eINSTANCE.createBCLConstraint();
		c.setName("Constraint"+x);
		x++;
		VSpecRef e = CvlFactory.eINSTANCE.createVSpecRef();
		e.setVSpec(null);
		c.getExpression().add(e);
		c.setContext(v);
		
		ConfigurableUnit cu = view.getCU();
		cu.getOwnedConstraint().add(c);
		
		// Regenerate view
		view.notifyVspecViewUpdate();
	}

}
