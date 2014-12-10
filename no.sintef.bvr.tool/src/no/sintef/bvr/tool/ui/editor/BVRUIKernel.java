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
package no.sintef.bvr.tool.ui.editor;


import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.interfaces.ui.editor.BVRUIKernelInterface;
import no.sintef.bvr.tool.ui.edit.BVREditorPanel;
import no.sintef.bvr.ui.framework.elements.BVRModelPanel;


public class BVRUIKernel<EDITOR_PANEL extends BVREditorPanel, MODEL_PANEL extends BVRModelPanel>
		implements BVRUIKernelInterface<EDITOR_PANEL, MODEL_PANEL> {
	
	private BVREditorPanel editorPanel;
	private BVRModelPanel modelPanel;
	
	public BVRUIKernel(BVRNotifiableController controller) {
		modelPanel = new BVRModelPanel();
		editorPanel = new BVREditorPanel(this, controller);
	}
	
	@Override
	public EDITOR_PANEL getEditorPanel() {
		return (EDITOR_PANEL) editorPanel;
	}
	
	@Override
	public MODEL_PANEL getModelPanel() {
		return (MODEL_PANEL) modelPanel;
	}

	@Override
	public void setEditorPanel(EDITOR_PANEL editorPanel) {
		editorPanel = (EDITOR_PANEL) editorPanel;
	}
}
