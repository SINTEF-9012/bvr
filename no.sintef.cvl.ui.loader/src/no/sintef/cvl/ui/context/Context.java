package no.sintef.cvl.ui.context;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;

import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.common.ViewChanageManager;
import no.sintef.cvl.ui.filter.CVLFilter;
import no.sintef.cvl.ui.filter.FMFilter;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;
import no.sintef.cvl.ui.loader.FileHelper;
import no.sintef.ict.splcatool.GUIDSL;
import no.sintef.ict.splcatool.GraphMLFM;
import no.sintef.ict.splcatool.SXFM;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IWorkbenchWindow;

public final class Context {

	private Environment environment = FactoryCreator.eINSTANCE.createEnvironment(null);
	private ViewChanageManager viewChnageManager = FactoryCreator.eINSTANCE.createViewChanageManager();
	
	private final List<CVLModel> cvlModels = new ArrayList<CVLModel>();
	private final List<CVLView> cvlViews = new ArrayList<CVLView>();
	
	public static final Context eINSTANCE = getContext();
	
	private static Context getContext(){
		return new Context();
	}
	
	public void setIWorkbenchWindow(IWorkbenchWindow workbench){
		environment = FactoryCreator.eINSTANCE.createEnvironment(workbench);
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
		FileHelper.saveLastLocation(fc.getCurrentDirectory().getAbsolutePath());
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
}
