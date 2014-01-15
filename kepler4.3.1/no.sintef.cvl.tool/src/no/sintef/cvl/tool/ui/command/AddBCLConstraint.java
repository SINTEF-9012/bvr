package no.sintef.cvl.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.constraints.bcl.BCLPrettyPrinter;
import no.sintef.cvl.tool.ui.dropdown.BCLConstraintDropDownListener;
import no.sintef.cvl.tool.ui.editor.CVLUIKernel;
import no.sintef.cvl.tool.ui.loader.VSpecView;
import no.sintef.cvl.tool.ui.loader.Main;
import no.sintef.cvl.tool.ui.loader.Pair;
import no.sintef.cvl.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.cvl.ui.framework.ParallelogramTitledPanel;
import no.sintef.cvl.ui.framework.elements.ConstraintPanel;
import cvl.BCLConstraint;
import cvl.NamedElement;
import cvl.OpaqueConstraint;
import cvl.VSpec;

public class AddBCLConstraint implements Command {

	CVLUIKernel rootPanel;
	BCLConstraint oc;
	JComponent parent;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private VSpecView view;
	private Map<JComponent, NamedElement> vmMap;
	
	public Command init(CVLUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, VSpecView view) {
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
		//ConstraintPanel constraint1 = new ConstraintPanel(rootPanel.getModelPanel());
		ParallelogramTitledPanel constraint1 = new ParallelogramTitledPanel();
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
	}

}
