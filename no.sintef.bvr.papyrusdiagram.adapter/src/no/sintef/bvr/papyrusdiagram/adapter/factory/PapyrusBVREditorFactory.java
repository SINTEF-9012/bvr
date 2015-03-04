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
package no.sintef.bvr.papyrusdiagram.adapter.factory;

import java.util.HashMap;
import java.util.Map;

import no.sintef.bvr.papyrusdiagram.adapter.PapyrusBVREditorAdapter;
import no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;

public class PapyrusBVREditorFactory implements IAdapterFactory {

	private Map<Object, IBVREnabledEditor> adapterMap = new HashMap<Object, IBVREnabledEditor>();

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {

		if (adapterType == IBVREnabledEditor.class
				&& adaptableObject instanceof PapyrusMultiDiagramEditor) {

			if (adapterMap.containsKey(adaptableObject)) {
				return adapterMap.get(adaptableObject);
			}

			// Ensure that adapter is removed in case the editor is closed
			PapyrusMultiDiagramEditor editor = (PapyrusMultiDiagramEditor) adaptableObject;
			editor.getActiveEditor().getSite().getPage()
					.addPartListener(new IPartListener() {

						@Override
						public void partOpened(IWorkbenchPart part) {

						}

						@Override
						public void partDeactivated(IWorkbenchPart part) {
							// TODO Auto-generated method stub

						}

						@Override
						public void partClosed(IWorkbenchPart part) {
							adapterMap.remove(adaptableObject);

						}

						@Override
						public void partBroughtToTop(IWorkbenchPart part) {
							// TODO Auto-generated method stub

						}

						@Override
						public void partActivated(IWorkbenchPart part) {
							// TODO Auto-generated method stub

						}
					});

			// Create and return new adapter
			IBVREnabledEditor adapter = new PapyrusBVREditorAdapter(editor);
			adapterMap.put(adaptableObject, adapter);

			return adapter;
		}
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		return new Class[] { IBVREnabledEditor.class };
	}

}
