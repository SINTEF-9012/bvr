package no.sintef.bvr.ui.editor.commands;


import bvr.Choice;
import bvr.ConfigurableUnit;
import bvr.VSpec;

public class EditorEMFTransactionalCommands implements EditorCommands {

	static private EditorEMFTransactionalCommands eINSTANCE = null;
	
	static public EditorEMFTransactionalCommands Get(){
		if(eINSTANCE == null){
			eINSTANCE = new EditorEMFTransactionalCommands();
		}
		return eINSTANCE;
	}
	
	@Override
	public void addChoice(Choice choice, ConfigurableUnit cu) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addChoice(Choice choice, VSpec vs) {
		throw new UnsupportedOperationException();
	}

}
