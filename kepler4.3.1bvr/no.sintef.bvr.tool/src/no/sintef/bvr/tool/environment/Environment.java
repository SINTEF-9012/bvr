package no.sintef.bvr.tool.environment;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.engine.common.ResourceContentCopier;
import no.sintef.bvr.tool.primitive.Symbol;
import no.sintef.bvr.tool.ui.loader.BVRToolModel;
import no.sintef.bvr.ui.editor.commands.EditorCommands;

public interface Environment {
	
	public BVRToolModel loadModelFromFile(File file);
	
	public void writeModelToFile(BVRToolModel model, File file);
	
	public void writeProductsToFiles(HashMap<Resource, ResourceContentCopier> baseProductMap, File file);
	
	public void performSubstitutions(List<Symbol> symbols);
	
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
}
