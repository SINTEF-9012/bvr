/*******************************************************************************
 * Copyright (c) All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.controller.command;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;
import no.sintef.bvr.tool.ui.edit.BVROptionsEditor;

public class SettingsToolEvent implements SimpleExeCommandInterface {

	private BVROptionsEditor settingsEditor;

	@Override
	public void execute() {
		if (settingsEditor != null)
			settingsEditor.unshowEditor();
		settingsEditor = new BVROptionsEditor();
		settingsEditor.showEditor();
	}

	public static class SettingsCommand {

		public static void setFromPlacementPermutation(Boolean isSet) {
			Context.eINSTANCE.getConfig().setFromPlacementPermutation(isSet);
		}

		public static boolean getFromPlacementPermutation() {
			return Context.eINSTANCE.getConfig().isFromPlacementPermutation();
		}

		public static void setToReplacementPermutation(Boolean isSet) {
			Context.eINSTANCE.getConfig().setToReplacementPermutation(isSet);
		}

		public static boolean getToReplacementPermutation() {
			return Context.eINSTANCE.getConfig().isToReplacementPermutation();
		}

		public static void setContainmentSelectionMode(Boolean isSet) {
			Context.eINSTANCE.getConfig().setContainmentSelectionMode(isSet);
		}

		public static boolean getContainmentSelectionMode() {
			return Context.eINSTANCE.getConfig().isContainmentSelectionMode();
		}

		public static void setHighlightingMode(Boolean isSet) {
			Context.eINSTANCE.getConfig().setHighlightingMode(isSet);
		}

		public static boolean getHighlightingMode() {
			return Context.eINSTANCE.getConfig().isHighlightingMode();
		}

		public static boolean getIntersectionDetection() {
			return Context.eINSTANCE.getConfig().isIntersectionDetectionMode();
		}

		public static void setIntersectionDetectionMode(boolean isSet) {
			Context.eINSTANCE.getConfig().setIntersectionDetectionMode(isSet);
		}
	}

}
