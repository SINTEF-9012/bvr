package no.sintef.cvl.ui.commands;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.cvl.ui.dropdowns.VariableValueAssignmentDropDownListener;
import no.sintef.cvl.ui.editors.CVLUIKernel;
import no.sintef.cvl.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.cvl.ui.framework.elements.VariableAssignmentPanel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.loader.Pair;
import cvl.BCLExpression;
import cvl.BooleanLiteralExp;
import cvl.CvlFactory;
import cvl.IntegerLiteralExp;
import cvl.NamedElement;
import cvl.PrimitiveTypeEnum;
import cvl.PrimitiveValueSpecification;
import cvl.PrimitveType;
import cvl.RealLiteralExp;
import cvl.StringLiteralExp;
import cvl.UnlimitedLiteralExp;
import cvl.VariableValueAssignment;

public class AddVariableValueAssignment implements Command {
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private CVLView view;
	private JComponent parent;
	private CVLUIKernel rootPanel;
	private VariableValueAssignment c;
	private CommandMouseListener listener;

	public Command init(CVLUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, CVLView view) {
		this.rootPanel = rootPanel;
		this.c = (VariableValueAssignment) p;
		this.parent = parent;
		
		this.vmMap = vmMap;
		this.nodes = nodes;
		this.bindings = bindings;
		this.view = view;
		this.parent = parent;
		
		return this;  
	}

	public JComponent execute() {
		//System.out.println("adding variable assignment");
		
		VariableAssignmentPanel cp = new VariableAssignmentPanel();
		nodes.add(cp);
		
        listener = new CommandMouseListener();
        cp.addMouseListener(new VariableValueAssignmentDropDownListener(cp, c, view, vmMap));
        
        SelectInstanceCommand command = new SelectInstanceCommand();
        command.init(rootPanel, cp, parent, vmMap, nodes, bindings, view);
        listener.setLeftClickCommand(command);
        cp.addMouseListener(listener);
        
		String name = "null";
		if(c.getResolvedVSpec() != null){
			name = c.getResolvedVSpec().getName();
		}
		
		String value = "null";
		if(c.getValue() != null){
			BCLExpression e = ((PrimitiveValueSpecification)c.getValue()).getExpression();
			
			if(e instanceof IntegerLiteralExp){
				value = "" + ((IntegerLiteralExp)e).getInteger();
			}else if(e instanceof RealLiteralExp){
				value = "" + ((RealLiteralExp)e).getReal();
			}else if(e instanceof BooleanLiteralExp){
				value = "" + ((BooleanLiteralExp)e).isBool();
			}else if(e instanceof StringLiteralExp){
				value = "\"" + ((StringLiteralExp)e).getString() + "\"";
			}else if(e instanceof UnlimitedLiteralExp){
				value = "" + ((UnlimitedLiteralExp)e).getUnlimited();
			}else
				throw new UnsupportedOperationException();
		}

        cp.setTitle(name + " = " + value);
		rootPanel.getModelPanel().addNode(cp);
        Helper.bind(parent, cp, rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);
        return cp;
	}

}
