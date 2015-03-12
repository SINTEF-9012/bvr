/*******************************************************************************
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June
 * 2007; you may not use this file except in compliance with the License. You
 * may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package no.sintef.bvr.tool.context;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JApplet;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

import no.sintef.bvr.common.OSDetector;
import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.common.logging.ResetableLogger;
import no.sintef.bvr.engine.interfaces.common.IResourceContentCopier;
import no.sintef.bvr.engine.interfaces.common.ISubstitutionEngine;
import no.sintef.bvr.tool.common.LoaderUtility;
import no.sintef.bvr.tool.environment.ConfigHelper;
import no.sintef.bvr.tool.environment.Environment;
import no.sintef.bvr.tool.filter.BVRFilter;
import no.sintef.bvr.tool.filter.FMFilter;
import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;
import no.sintef.bvr.tool.model.BVRSimpleToolModel;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.model.BVRTransactionalModel;
import no.sintef.bvr.tool.primitive.SymbolVSpec;
import no.sintef.bvr.ui.editor.commands.EditorCommands;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.GraphMLFM;
import no.sintef.ict.splcatool.SXFM;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IWorkbenchWindow;

import bvr.FragmentSubstitution;

public final class Context {

	public static final Context eINSTANCE = getContext();

	private Environment environment = ContextFactory.eINSTANCE.createEnvironment();
	private ViewChanageManager viewChnageManager = ContextFactory.eINSTANCE.createViewChanageManager();

	private final List<BVRToolModel> bvrModels = new ArrayList<BVRToolModel>();
	private final List<BVRNotifiableController> bvrViews = new ArrayList<BVRNotifiableController>();

	private ISubstitutionEngine subEngine;

	public Logger logger = environment.getLogger();
	public ResetableLogger problemLogger = environment.getProblemLogger();

	private Map<File, BVRTransactionalModel> loadedModels = new HashMap<File, BVRTransactionalModel>();
	private JApplet focusedJApplet = null;

	private static Context getContext() {
		return new Context();
	}

	private BVRTransactionalModel testBVRTransactionalModel(File file) {
		synchronized (this) {
			if (loadedModels.get(file) == null)
				loadedModels.put(file, new BVRTransactionalModel(file));
		}
		return loadedModels.get(file);
	}

	public void setIWorkbenchWindow(IWorkbenchWindow workbench) {
		environment = ContextFactory.eINSTANCE.createEnvironment(workbench);
		logger = environment.getLogger();
		problemLogger = environment.getProblemLogger();
	}

	public BVRToolModel loadModelFromFile(File file) {
		String extension = LoaderUtility.getExtension(file);
		BVRToolModel model = null;
		if (extension.equals(BVRFilter.BVR_EXT) || extension.equals(BVRFilter.XMI_EXT)) {
			model = environment.loadModelFromFile(file);
		} else if (extension.equals(FMFilter.M_EXT)) {
			try {
				no.sintef.ict.splcatool.SPLCABVRModel bvrm = new GUIDSL(file).getGraphMLFM().getBVRModel();
				model = new BVRSimpleToolModel(file, bvrm);
			} catch (Exception e) {
				throw new UnsupportedOperationException("Loading model failed: " + e.getMessage());
			}
		} else if (extension.equals(FMFilter.XML_EXT)) {
			try {
				SXFM sxfm = new SXFM(file.getAbsolutePath());
				GraphMLFM gml = sxfm.getGUIDSL().getGraphMLFM();
				no.sintef.ict.splcatool.SPLCABVRModel bvrm = gml.getBVRModel();
				model = new BVRSimpleToolModel(file, bvrm);
			} catch (Exception e) {
				throw new UnsupportedOperationException("Loading model failed: " + e.getMessage());
			}
		} else {
			throw new UnsupportedOperationException("unsupported extension " + extension);
		}
		return model;
	}

	public void writeModelToFile(BVRToolModel model, File file) {
		environment.writeModelToFile(model, file);
	}

	public void writeProductsToFiles(HashMap<Resource, IResourceContentCopier> baseProductMap, File file) {
		environment.writeProductsToFiles(baseProductMap, file);
	}

	public void performSubstitutions(List<SymbolVSpec> symbols) {
		environment.performSubstitutions(symbols);
	}

	public void reloadModel(BVRToolModel model) {
		environment.reloadModel(model);
	}

	public EObject getEObject(Object object) {
		return environment.getEObject(object);
	}

	public List<Object> getSelections() {
		return environment.getSelections();
	}

	public void highlightObjects(EList<HashMap<EObject, Integer>> objectsToHighlightList) {
		environment.highlightObjects(objectsToHighlightList);
	}

	public void clearHighlights() {
		environment.clearHighlights();
	}

	public void nullSetModel(BVRToolModel model) {
		environment.disposeModel(model);
	}

	public JFileChooser getFileChooser() {
		JFileChooser fc = environment.getFileChooser();
		return fc;
	}

	public final List<BVRToolModel> getBvrModels() {
		return bvrModels;
	}

	public final List<BVRNotifiableController> getBvrViews() {
		return bvrViews;
	}

	public void addBvrModel(BVRToolModel model) {
		bvrModels.add(model);
	}

	public void addBvrView(BVRNotifiableController view) {
		bvrViews.add(view);
	}

	public ViewChanageManager getViewChangeManager() {
		return viewChnageManager;
	}

	public void initSubEngine(EList<FragmentSubstitution> frgamentSusbstitutions) {
		subEngine.setLogger(logger);
		subEngine.init(frgamentSusbstitutions);
	}

	public synchronized ISubstitutionEngine testSubEngine(ISubstitutionEngine engine) {
		if (subEngine == null)
			subEngine = engine;
		return subEngine;
	}

	public ISubstitutionEngine getSubEngine() {
		return subEngine;
	}

	public ConfigHelper getConfig() {
		return environment.getConfig();
	}

	public EditorCommands getEditorCommands() {
		return environment.getEditorCommands();
	}

	public BVRToolModel testBVRToolModel(File file) {
		return testBVRTransactionalModel(file);
	}

	public void disposeModel(BVRToolModel model) {
		File file = model.getFile();
		loadedModels.remove(file);
	}

	public void setActiveJApplet(JApplet jApplet) {
		focusedJApplet = jApplet;
	}

	public JApplet getActiveJApplet() {
		return focusedJApplet;
	}

	public void setNativeLookAndFeel() {
		if (OSDetector.getOSType() == OSDetector.OSType.Windows) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				logger.error("failed to set systems look and feel", e);
			}
		} else {
			logger.debug("do not know how to set systems look and fell for " + OSDetector.getOSType());
		}
	}

}
