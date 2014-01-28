package no.sintef.bvr.tool.ui.command;

import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import no.sintef.bvr.tool.ui.dropdown.VariableValueAssignmentDropDownListener;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRView;
import no.sintef.bvr.tool.ui.loader.Pair;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.VariableAssignmentPanel;
import bvr.BCLExpression;
import bvr.BooleanLiteralExp;
import bvr.BvrFactory;
import bvr.IntegerLiteralExp;
import bvr.NamedElement;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitiveValueSpecification;
import bvr.PrimitveType;
import bvr.RealLiteralExp;
import bvr.StringLiteralExp;
import bvr.UnlimitedLiteralExp;
import bvr.VariableValueAssignment;

public class AddVariableValueAssignment implements Command {
	private Map<JComponent, NamedElement> vmMap;
	private List<JComponent> nodes;
	private List<Pair<JComponent, JComponent>> bindings;
	private BVRView view;
	private JComponent parent;
	private BVRUIKernel rootPanel;
	private VariableValueAssignment c;
	private CommandMouseListener listener;

	public Command init(BVRUIKernel rootPanel, Object p, JComponent parent, Map<JComponent, NamedElement> vmMap, List<JComponent> nodes, List<Pair<JComponent, JComponent>> bindings, BVRView view) {
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