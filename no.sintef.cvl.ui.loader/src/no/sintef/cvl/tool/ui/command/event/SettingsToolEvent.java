package no.sintef.cvl.tool.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.sintef.cvl.tool.context.Context;
import no.sintef.cvl.tool.ui.edit.CVLOptionsEditor;

public class SettingsToolEvent implements ActionListener {


	private CVLOptionsEditor settingsEditor;

	@Override
	public void actionPerformed(ActionEvent event) {
		if(settingsEditor != null)
			settingsEditor.unshowEditor();
		settingsEditor = new CVLOptionsEditor();
		settingsEditor.showEditor();
	}
	
	public static class SettingsCommand{
		
		public static void setFromPlacementPermutation(Boolean isSet){
			Context.eINSTANCE.getConfig().setFromPlacementPermutation(isSet);
		}
		
		public static boolean getFromPlacementPermutation(){
			return Context.eINSTANCE.getConfig().isFromPlacementPermutation();
		}
		
		public static void setToReplacementPermutation(Boolean isSet){
			Context.eINSTANCE.getConfig().setToReplacementPermutation(isSet);
		}
		
		public static boolean getToReplacementPermutation(){
			return Context.eINSTANCE.getConfig().isToReplacementPermutation();
		}
		
		public static void setContainmentSelectionMode(Boolean isSet){
			Context.eINSTANCE.getConfig().setContainmentSelectionMode(isSet);
		}
		
		public static boolean getContainmentSelectionMode(){
			return Context.eINSTANCE.getConfig().isContainmentSelectionMode();
		}
		
		public static void setHighlightingMode(Boolean isSet){
			Context.eINSTANCE.getConfig().setHighlightingMode(isSet);
		}
		
		public static boolean getHighlightingMode(){
			return Context.eINSTANCE.getConfig().isHighlightingMode();
		}
	}

}
