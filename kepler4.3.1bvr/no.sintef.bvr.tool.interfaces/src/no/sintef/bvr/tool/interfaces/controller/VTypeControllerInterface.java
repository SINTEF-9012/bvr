package no.sintef.bvr.tool.interfaces.controller;


import no.sintef.bvr.tool.interfaces.controller.command.Command;


public interface VTypeControllerInterface<GUI_NODE, MODEL_OBJECT, SERIALIZABLE>
		extends
		EditorsCommonControllerInterface<SERIALIZABLE, GUI_NODE, MODEL_OBJECT> {

	public Command<?,?> createUpdateVTypeCommand(GUI_NODE elem);

	public void removeVType(GUI_NODE parent);

}
