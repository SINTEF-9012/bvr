package no.sintef.bvr.ui.editor.commands;

public class EditorCommandsFactory {

	static public EditorCommands eINSTANCE = null;
	
	static EditorCommands Create(boolean transactional){
		if(eINSTANCE == null){
			eINSTANCE = (transactional) ? EditorEMFTransactionalCommands.Get() : EditorMVCCommands.Get();
		}
		return eINSTANCE;
	}
}
