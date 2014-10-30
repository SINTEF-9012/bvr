package no.sintef.bvr.ui.editor.commands;

public class EditorCommandsFactory {

	public static EditorCommands eINSTANCE = null;
	
	public static EditorCommands Create(boolean transactional){
		if(eINSTANCE == null)
			eINSTANCE = (transactional) ? EditorEMFTransactionalCommands.Get() : EditorMVCCommands.Get();
		return eINSTANCE;
	}
	
	public static EditorCommands Create(){
		if(eINSTANCE == null)
			eINSTANCE = EditorMVCCommands.Get();
		return eINSTANCE;
	}
}
