package no.sintef.bvr.ui.editor.commands;

import bvr.Choice;
import bvr.ConfigurableUnit;
import bvr.VSpec;

public class EditorMVCCommands implements EditorCommands {
	
	static private EditorMVCCommands eINSTANCE = null;
	
	static public EditorMVCCommands Get(){
		if(eINSTANCE == null){
			eINSTANCE = new EditorMVCCommands();
		}
		return eINSTANCE;
	}

	@Override
	public void addChoice(Choice choice, ConfigurableUnit cu) {
		cu.getOwnedVSpec().add(choice);
	}

	@Override
	public void addChoice(Choice choice, VSpec vs) {
		vs.getChild().add(choice);
	}

}
