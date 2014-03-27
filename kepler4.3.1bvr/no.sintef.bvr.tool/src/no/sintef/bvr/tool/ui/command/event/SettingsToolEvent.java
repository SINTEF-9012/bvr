package no.sintef.bvr.tool.ui.command.event;


import no.sintef.bvr.tool.context.Context;

public class SettingsToolEvent {

	public static class SettingsCommand {
		
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
