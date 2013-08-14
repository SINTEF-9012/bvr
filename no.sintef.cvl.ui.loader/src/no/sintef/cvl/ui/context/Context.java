package no.sintef.cvl.ui.context;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.swing.JFileChooser;

import no.sintef.cvl.common.logging.Logger;
import no.sintef.cvl.engine.common.ResourceContentCopier;
import no.sintef.cvl.engine.common.SubstitutionEngine;
import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.common.ViewChanageManager;
import no.sintef.cvl.ui.environment.Environment;
import no.sintef.cvl.ui.filter.CVLFilter;
import no.sintef.cvl.ui.filter.FMFilter;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.primitive.Symbol;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.GraphMLFM;
import no.sintef.ict.splcatool.SXFM;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IWorkbenchWindow;

import cvl.FragmentSubstitution;
import cvl.PlacementFragment;
import cvl.ReplacementFragmentType;

public final class Context {

	public static final Context eINSTANCE = getContext();
	
	private Environment environment = FactoryCreator.eINSTANCE.createEnvironment();
	private ViewChanageManager viewChnageManager = FactoryCreator.eINSTANCE.createViewChanageManager(); 
	
	private final List<CVLModel> cvlModels = new ArrayList<CVLModel>();
	private final List<CVLView> cvlViews = new ArrayList<CVLView>();
	
	private final SubstitutionEngine subEngine = SubstitutionEngine.eINSTANCE;
	
	public Logger logger = environment.getLogger();
	
	public HashMap<ReplacementFragmentType, HashSet<PlacementFragment>> replcmntPlcmntMap;
	public HashMap<PlacementFragment, HashSet<ReplacementFragmentType>> plcmntReplcmntMap;
	
	//remove this shit
	public CVLModel cvlmodel;
	//end of the shit
	
	private static Context getContext(){
		return new Context();
	}
	
	public void setIWorkbenchWindow(IWorkbenchWindow workbench){
		environment = FactoryCreator.eINSTANCE.createEnvironment(workbench);
		logger = environment.getLogger();
	}
	
	public CVLModel loadModelFromFile(File file){
		String extension = Utility.getExtension(file);
		CVLModel model = null;
		if(extension.equals(CVLFilter.CVL_EXT) || extension.equals(CVLFilter.XMI_EXT)){
			model = environment.loadModelFromFile(file);
		}else if(extension.equals(FMFilter.M_EXT)){
			try{
				no.sintef.ict.splcatool.CVLModel cvlm = new GUIDSL(file).getGraphMLFM().getCVLModel();
				model = new CVLModel(file, cvlm);
			}catch(Exception e){
				throw new UnsupportedOperationException("Loading model failed: " + e.getMessage());
			}
		}else if(extension.equals(FMFilter.XML_EXT)){
			try {
				SXFM sxfm = new SXFM(file.getAbsolutePath());
				GraphMLFM gml = sxfm.getGUIDSL().getGraphMLFM();
				no.sintef.ict.splcatool.CVLModel cvlm = gml.getCVLModel();
				model = new CVLModel(file, cvlm);
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
		fc.addChoosableFileFilter(new FMFilter());
		fc.addChoosableFileFilter(new CVLFilter());
		return fc;
	}
	
	public final List<CVLModel> getCvlModels(){
		return cvlModels;
	}
	
	public final List<CVLView> getCvlViews(){
		return cvlViews;
	}
	
	public void addCvlModel(CVLModel model){
		cvlModels.add(model);
	}
	
	public void addCvlView(CVLView view){
		cvlViews.add(view);
	}

	public ViewChanageManager getViewChnageManager() {
		return viewChnageManager;
	}
	
	public void initSubEngine(EList<FragmentSubstitution> frgamentSusbstitutions){
		subEngine.setLogger(logger);
		subEngine.init(frgamentSusbstitutions);
	}
	
	public SubstitutionEngine getSubEngine(){
		return subEngine;
	}
}
