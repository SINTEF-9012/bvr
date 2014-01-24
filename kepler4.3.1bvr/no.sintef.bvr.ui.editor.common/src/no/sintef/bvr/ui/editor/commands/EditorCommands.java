package no.sintef.bvr.ui.editor.commands;

import bvr.Choice;
import bvr.ConfigurableUnit;
import bvr.VSpec;

public interface EditorCommands {
	
	public void addChoice(Choice choice, ConfigurableUnit cu);
	
	public void addChoice(Choice choice, VSpec vs);

}
