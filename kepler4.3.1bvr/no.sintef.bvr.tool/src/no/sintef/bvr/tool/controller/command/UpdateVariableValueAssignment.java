package no.sintef.bvr.tool.controller.command;


import javax.swing.JComponent;


public class UpdateVariableValueAssignment<EDITOR_PANEL, MODEL_PANEL> extends UpdateAbstractNamedElement<EDITOR_PANEL, MODEL_PANEL> {


	@SuppressWarnings("unchecked")
	@Override
	public JComponent execute() {
		controller.getResolutionControllerInterface().setValueResolutionValue(parent, value);
		super.execute();
		return parent;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
