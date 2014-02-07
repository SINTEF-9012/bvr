package no.sintef.bvr.tool.context;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;

import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.engine.common.ResourceContentCopier;
import no.sintef.bvr.engine.common.SubstitutionEngine;
import no.sintef.bvr.tool.common.LoaderUtility;
import no.sintef.bvr.tool.environment.ConfigHelper;
import no.sintef.bvr.tool.environment.Environment;
import no.sintef.bvr.tool.filter.BVRFilter;
import no.sintef.bvr.tool.filter.FMFilter;
import no.sintef.bvr.tool.primitive.Symbol;
import no.sintef.bvr.tool.ui.loader.BVRModel;
import no.sintef.bvr.tool.ui.loader.BVRView;
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
	
	private final List<BVRModel> bvrModels = new ArrayList<BVRModel>();
	private final List<BVRView> bvrViews = new ArrayList<BVRView>();
	
	private final SubstitutionEngine subEngine = SubstitutionEngine.eINSTANCE;
	
	public Logger logger = environment.getLogger();
	
	private static Context getContext(){
		return new Context();
	}
	
	public void setIWorkbenchWindow(IWorkbenchWindow workbench){
		environment = ContextFactory.eINSTANCE.createEnvironment(workbench);
		logger = environment.getLogger();
	}
	
	public BVRModel loadModelFromFile(File file){
		String extension = LoaderUtility.getExtension(file);
		BVRModel model = null;
		if(extension.equals(BVRFilter.BVR_EXT) || extension.equals(BVRFilter.XMI_EXT)){
			model = environment.loadModelFromFile(file);
		}else if(extension.equals(FMFilter.M_EXT)){
			try{
				no.sintef.ict.splcatool.BVRModel bvrm = new GUIDSL(file).getGraphMLFM().getBVRModel();
				model = new BVRModel(file, bvrm);
			}catch(Exception e){
				throw new UnsupportedOperationException("Loading model failed: " + e.getMessage());
			}
		}else if(extension.equals(FMFilter.XML_EXT)){
			try {
				SXFM sxfm = new SXFM(file.getAbsolutePath());
				GraphMLFM gml = sxfm.getGUIDSL().getGraphMLFM();
				no.sintef.ict.splcatool.BVRModel bvrm = gml.getBVRModel();
				model = new BVRModel(file, bvrm);
			} catch (Exception e) {
				throw new UnsupportedOperationException("Loading model failed: " + e.getMessage());
			}
		}else{
			throw new UnsupportedOperationException("unsupported extension " + extension);
		}
		return model;
	}
	
	public void writeModelToFile(BVRModel model, File file){
		environment.writeModelToFile(model, file);
	}
	
	public void writeProductsToFiles(HashMap<Resource, ResourceContentCopier> baseProductMap, File file){
		environment.writeProductsToFiles(baseProductMap, file);
	}
	
	public void performSubstitutions(List<Symbol> symbols){
		environment.performSubstitutions(symbols);
	}
	
	public void reloadModel(BVRModel model){
		environment.reloadModel(model);
	}
	
	public EObject getEObject(Object object){
		return environment.getEObject(object);
	}
	
	public List<Object> getSelections(){
		return environment.getSelections();
	}
	
	public void highlightObjects(EList<HashMap<EObject, Integer>> objectsToHighlightList){
		environment.highlightObjects(objectsToHighlightList);
	}
	
	public void clearHighlights(){
		environment.clearHighlights();
	}
	
	public JFileChooser getFileChooser(){
		JFileChooser fc = environment.getFileChooser();
		return fc;
	}
	
	public final List<BVRModel> getBvrModels(){
		return bvrModels;
	}
	
	public final List<BVRView> getBvrViews(){
		return bvrViews;
	}
	
	public void addBvrModel(BVRModel model){
		bvrModels.add(model);
	}
	
	public void addBvrView(BVRView view){
		bvrViews.add(view);
	}

	public ViewChanageManager getViewChangeManager() {
		return viewChnageManager;
	}
	
	public void initSubEngine(EList<FragmentSubstitution> frgamentSusbstitutions){
		subEngine.setLogger(logger);
		subEngine.init(frgamentSusbstitutions);
	}
	
	public SubstitutionEngine getSubEngine(){
		return subEngine;
	}
	
	public ConfigHelper getConfig() {
		return environment.getConfig();
	}
}
