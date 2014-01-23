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
import no.sintef.bvr.tool.filter.CVLFilter;
import no.sintef.bvr.tool.filter.FMFilter;
import no.sintef.bvr.tool.primitive.Symbol;
import no.sintef.bvr.tool.ui.loader.CVLModel;
import no.sintef.bvr.tool.ui.loader.CVLView;
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
	
	private final List<CVLModel> bvrModels = new ArrayList<CVLModel>();
	private final List<CVLView> bvrViews = new ArrayList<CVLView>();
	
	private final SubstitutionEngine subEngine = SubstitutionEngine.eINSTANCE;
	
	public Logger logger = environment.getLogger();
	
	private static Context getContext(){
		return new Context();
	}
	
	public void setIWorkbenchWindow(IWorkbenchWindow workbench){
		environment = ContextFactory.eINSTANCE.createEnvironment(workbench);
		logger = environment.getLogger();
	}
	
	public CVLModel loadModelFromFile(File file){
		String extension = LoaderUtility.getExtension(file);
		CVLModel model = null;
		if(extension.equals(CVLFilter.CVL_EXT) || extension.equals(CVLFilter.XMI_EXT)){
			model = environment.loadModelFromFile(file);
		}else if(extension.equals(FMFilter.M_EXT)){
			try{
				no.sintef.ict.splcatool.CVLModel bvrm = new GUIDSL(file).getGraphMLFM().getCVLModel();
				model = new CVLModel(file, bvrm);
			}catch(Exception e){
				throw new UnsupportedOperationException("Loading model failed: " + e.getMessage());
			}
		}else if(extension.equals(FMFilter.XML_EXT)){
			try {
				SXFM sxfm = new SXFM(file.getAbsolutePath());
				GraphMLFM gml = sxfm.getGUIDSL().getGraphMLFM();
				no.sintef.ict.splcatool.CVLModel bvrm = gml.getCVLModel();
				model = new CVLModel(file, bvrm);
			} catch (Exception e) {
				throw new UnsupportedOperationException("Loading model failed: " + e.getMessage());
			}
		}else{
			throw new UnsupportedOperationException("unsupported extension " + extension);
		}
		return model;
	}
	
	public void writeModelToFile(CVLModel model, File file){
		environment.writeModelToFile(model, file);
	}
	
	public void writeProductsToFiles(HashMap<Resource, ResourceContentCopier> baseProductMap, File file){
		environment.writeProductsToFiles(baseProductMap, file);
	}
	
	public void performSubstitutions(List<Symbol> symbols){
		environment.performSubstitutions(symbols);
	}
	
	public void reloadModel(CVLModel model){
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
	
	public final List<CVLModel> getBvrModels(){
		return bvrModels;
	}
	
	public final List<CVLView> getBvrViews(){
		return bvrViews;
	}
	
	public void addBvrModel(CVLModel model){
		bvrModels.add(model);
	}
	
	public void addBvrView(CVLView view){
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
