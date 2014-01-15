package no.sintef.cvl.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.tool.ui.loader.VSpecView;
import no.sintef.cvl.tool.ui.loader.Pair;
import cvl.BCLConstraint;
import cvl.ConfigurableUnit;
import cvl.CvlFactory;
import cvl.NamedElement;
import cvl.PrimitiveTypeEnum;
import cvl.PrimitveType;
import cvl.VSpec;
import cvl.VSpecRef;
import cvl.Variable;
import cvl.Variabletype;

public class AddVariableEvent implements ActionListener {
	
	private JComponent p;
	private Map<JComponent, NamedElement> vmMap;
	private VSpecView view;

	public AddVariableEvent(JComponent p, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, VSpecView view) {
		this.p = p;
		this.vmMap = vmMap;
		this.view = view;
	}
	
	static int x = 1;

	@Override
	public void actionPerformed(ActionEvent e) {
		VSpec v = (VSpec)vmMap.get(p);
		
		//System.out.println("Adding variable to " + v.getName());
		
		Variable var = CvlFactory.eINSTANCE.createVariable();
		PrimitveType vt = CvlFactory.eINSTANCE.createPrimitveType();
		
		vt.setType(PrimitiveTypeEnum.INTEGER);
		vt.setName("xx");
		
		view.getCU().getOwnedVariabletype().add(vt);
		
		var.setName("Var" + x);
		var.setType(vt);
		x++;
		
		v.getChild().add(var);
		
		// Regenerate view
		view.notifyVspecViewUpdate();
	}

}
