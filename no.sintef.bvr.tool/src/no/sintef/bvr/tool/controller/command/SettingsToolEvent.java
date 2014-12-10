/*******************************************************************************
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package no.sintef.bvr.tool.controller.command;


import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;
import no.sintef.bvr.tool.ui.edit.BVROptionsEditor;

public class SettingsToolEvent implements SimpleExeCommandInterface {
	
	private BVROptionsEditor settingsEditor;

	@Override
	public void execute() {
		if(settingsEditor != null)
			settingsEditor.unshowEditor();
		settingsEditor = new BVROptionsEditor();
		settingsEditor.showEditor();
	}
	
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
