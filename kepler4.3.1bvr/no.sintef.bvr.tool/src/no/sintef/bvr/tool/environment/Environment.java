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
package no.sintef.bvr.tool.environment;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.common.logging.ResetableLogger;
import no.sintef.bvr.engine.interfaces.common.IResourceContentCopier;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.primitive.SymbolVSpec;
import no.sintef.bvr.ui.editor.commands.EditorCommands;

public interface Environment {
	
	public BVRToolModel loadModelFromFile(File file);
	
	public void writeModelToFile(BVRToolModel model, File file);
	
	public void writeProductsToFiles(HashMap<Resource, IResourceContentCopier> baseProductMap, File file);
	
	public void performSubstitutions(List<SymbolVSpec> symbols);
	
	public void reloadModel(BVRToolModel model);
	
	public EObject getEObject(Object object);
	
	public List<Object> getSelections();
	
	public void highlightObjects(EList<HashMap<EObject, Integer>> objectsToHighlightList);
	
	public void clearHighlights();
	
	public JFileChooser getFileChooser();
	
	public Logger getLogger();
	
	public ConfigHelper getConfig();
	
	public EditorCommands getEditorCommands();
	
	public void disposeModel(BVRToolModel model);

	public ResetableLogger getProblemLogger();
}
