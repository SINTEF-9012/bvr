package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIcommands;

import javax.swing.JComponent;

import no.sintef.bvr.tool.controller.command.Command;
import no.sintef.bvr.tool.ui.command.AddVariableValueAssignment;
import no.sintef.bvr.tool.ui.command.CommandMouseListener;
import no.sintef.bvr.tool.ui.command.Helper;
import no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements.DropdownListners.VariableValueAssignmentDropDownListenerV2;
import no.sintef.bvr.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.bvr.ui.framework.elements.VariableAssignmentPanel;
import bvr.BCLExpression;
import bvr.BooleanLiteralExp;
import bvr.IntegerLiteralExp;
import bvr.PrimitiveValueSpecification;
import bvr.RealLiteralExp;
import bvr.StringLiteralExp;
import bvr.UnlimitedLiteralExp;

public class AddVariableValueAssignmentV2 extends AddVariableValueAssignment implements Command {

	private boolean stripContains;

	public AddVariableValueAssignmentV2(boolean minContains, boolean stripContains) {
		super(minContains);
		this.stripContains = stripContains;
	}

	@Override
	public JComponent execute() {
		return null;
		//System.out.println("adding variable assignment");
		/*
		VariableAssignmentPanel cp = new VariableAssignmentPanel();
		nodes.add(cp);
		
        listener = new CommandMouseListener();
        cp.addMouseListener(new VariableValueAssignmentDropDownListenerV2(cp, /*c,*/// view, vmMap));
        /*
        SelectInstanceCommandV2 command = new SelectInstanceCommandV2();
        command.init(rootPanel, cp, parent, vmMap, nodes, bindings, view);
        listener.setLeftClickCommand(command);
        cp.addMouseListener(listener);
        
		String name = c.getName();
		
		
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

        cp.setTitle((contains?"(+) ":"") + (stripContains?"(*) ":"") + name + " = " + value);
		rootPanel.getModelPanel().addNode(cp);
        Helper.bind(parent, cp, rootPanel.getModelPanel(), OPTION_STATE.MANDATORY, bindings);
        return cp;
        */
	}

}
