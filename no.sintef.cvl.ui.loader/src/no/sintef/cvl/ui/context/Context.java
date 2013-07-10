package no.sintef.cvl.ui.context;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import no.sintef.cvl.ui.common.ViewChanageManager;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.CVLView;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IWorkbenchWindow;

public final class Context {

	private Environment environment = FactoryCreator.eINSTANCE.createEnvironment(null);
	private ViewChanageManager viewChnageManager = FactoryCreator.eINSTANCE.createViewChanageManager();
	
	private final List<CVLModel> cvlModels = new ArrayList<CVLModel>();
	private final List<CVLView> cvlViews = new ArrayList<CVLView>();
	
	public static final Context eINSTANCE = getContext();
	
	public static Context getContext(){
		return new Context();
	}
	
	public void setIWorkbenchWindow(IWorkbenchWindow workbench){
		environment = FactoryCreator.eINSTANCE.createEnvironment(workbench);
	}
	
	public CVLModel loadModelFromFile(File file){
		return environment.loadModelFromFile(file);
	}
	
	public void writeModelToFile(CVLModel model, String filename){
		environment.writeModelToFile(model, filename);
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
	
	public List<CVLModel> getCvlModels(){
		return cvlModels;
	}
	
	public List<CVLView> getCvlViews(){
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
