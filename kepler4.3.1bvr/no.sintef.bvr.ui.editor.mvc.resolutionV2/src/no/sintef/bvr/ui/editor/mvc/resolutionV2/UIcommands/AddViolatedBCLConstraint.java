
package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.BVRNotifiableController;
import no.sintef.bvr.tool.ui.command.CommandMouseListener;
import no.sintef.bvr.tool.ui.command.Helper;
//import no.sintef.bvr.tool.ui.command.SelectInstanceCommand;
import no.sintef.bvr.tool.ui.dropdown.BCLConstraintDropDownListener;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.BVRResolutionToolView;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
//import no.sintef.bvr.ui.framework.ParallelogramTitledErrorPanel;
import no.sintef.bvr.ui.framework.ParallelogramTitledPanel;
import no.sintef.ict.splcatool.BCLPrettyPrinter;
import bvr.BCLConstraint;
import bvr.NamedElement;

public class AddViolatedBCLConstraint implements UICommand {

	BVRUIKernel rootPanel;
	BCLConstraint oc;
	JComponent parent;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRResolutionToolView view;
	private Map<JComponent, NamedElement> vmMap;
	
	public UICommand init(BVRUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRResolutionToolView view) {
		this.rootPanel = rootPanel;
		this.oc = (BCLConstraint) p;
		this.parent = parent;
		this.view = view;
		this.vmMap = vmMap;
		
		this.nodes = nodes;
		this.bindings = bindings;
		
		return this;
	}

	public JComponent execute() {
		return null;
		/*
		//ConstraintPanel constraint1 = new ConstraintPanel(rootPanel.getModelPanel());
		ParallelogramTitledPanel constraint1 = new ParallelogramTitledErrorPanel();
		nodes.add(constraint1);
		String s = new BCLPrettyPrinter().prettyPrint(oc.getExpression().get(0), view.getCU());
		// Add newlines
		s = wrap(s, 15);
		constraint1.setTitle(s);
		//constraint1.setConstraint(oc.getConstraint());
		rootPanel.getModelPanel().addNode(constraint1);
		
		// Editor
		CommandMouseListener listener = new CommandMouseListener();
		constraint1.addMouseListener(listener);
		constraint1.title.addMouseListener(listener);
		
		constraint1.title.addMouseListener(new BCLConstraintDropDownListener(constraint1, vmMap, nodes, bindings, view));
		constraint1.addMouseListener(new BCLConstraintDropDownListener(constraint1, vmMap, nodes, bindings, view));
		
        SelectInstanceCommand command = new SelectInstanceCommand();
        command.init(rootPanel, constraint1, parent, vmMap, nodes, bindings, view);
        listener.setLeftClickCommand(command);

		Helper.bind(parent, constraint1, rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);
		
		return constraint1;
	}

	private String wrap(String s, int i) {
		String n = "";
		
		for(;;){
			//System.out.println("s \"" + s + "\"");
			if(s.length() < i){
				n += s;
				break;
			}
			int ws = s.substring(i).indexOf(" ");
			if(ws == -1){
				n += s;
				break;
			}else{
				ws += i;
				n += s.substring(0, ws).trim() + "\n";
				s = s.substring(ws).trim();
				//System.out.println("s \"" + s + "\"" + ws);
			}
		}
		
		return n;
*/
	}
}

