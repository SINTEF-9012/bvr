package no.sintef.bvr.tool.environment;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.engine.common.ResourceContentCopier;
import no.sintef.bvr.tool.primitive.Symbol;
import no.sintef.bvr.tool.ui.loader.BVRModel;
import no.sintef.bvr.ui.editor.commands.EditorCommands;

public interface Environment {
	
	public BVRModel loadModelFromFile(File file);
	
	public void writeModelToFile(BVRModel model, File file);
	
	public void writeProductsToFiles(HashMap<Resource, ResourceContentCopier> baseProductMap, File file);
	
	public void performSubstitutions(List<Symbol> symbols);
	
	public void reloadModel(BVRModel model);
	
	public EObject getEObject(Object object);
	
	public List<Object> getSelections();
	
	public void highlightObjects(EList<HashMap<EObject, Integer>> objectsToHighlightList);
	
	public void clearHighlights();
	
	public JFileChooser getFileChooser();
	
	public Logger getLogger();
	
	public ConfigHelper getConfig();
	
	public EditorCommands getEditorCommands();
}
