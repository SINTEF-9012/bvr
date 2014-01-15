package no.sintef.cvl.tool.environment;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import no.sintef.cvl.common.logging.Logger;
import no.sintef.cvl.engine.common.ResourceContentCopier;
import no.sintef.cvl.tool.primitive.Symbol;
import no.sintef.cvl.tool.ui.loader.CVLModel;

public interface Environment {
	
	public CVLModel loadModelFromFile(File file);
	
	public void writeModelToFile(CVLModel model, File file);
	
	public void writeProductsToFiles(HashMap<Resource, ResourceContentCopier> baseProductMap, File file);
	
	public void performSubstitutions(List<Symbol> symbols);
	
	public void reloadModel(CVLModel model);
	
	public EObject getEObject(Object object);
	
	public List<Object> getSelections();
	
	public void highlightObjects(EList<HashMap<EObject, Integer>> objectsToHighlightList);
	
	public void clearHighlights();
	
	public JFileChooser getFileChooser();
	
	public Logger getLogger();
	
	public ConfigHelper getConfig();
}
