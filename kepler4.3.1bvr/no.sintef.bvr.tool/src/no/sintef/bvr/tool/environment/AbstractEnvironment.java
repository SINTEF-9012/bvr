package no.sintef.bvr.tool.environment;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;

import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.engine.common.ResourceContentCopier;
import no.sintef.bvr.tool.exception.UnimplementedBVRException;
import no.sintef.bvr.tool.primitive.Symbol;
import no.sintef.bvr.tool.ui.loader.BVRModel;
import no.sintef.bvr.ui.editor.commands.EditorCommands;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class AbstractEnvironment implements Environment {
	
	@Override
	public BVRModel loadModelFromFile(File file) {
		throw new UnimplementedBVRException("loadModelFromFile is not implemented");
	}

	@Override
	public void writeModelToFile(BVRModel model, File file) {
		throw new UnimplementedBVRException("writeModelToFile is not implemented");
	}

	@Override
	public void reloadModel(BVRModel model) {
		throw new UnimplementedBVRException("reloadModel is not implemented");
	}

	@Override
	public EObject getEObject(Object object) {
		throw new UnimplementedBVRException("getEObject is not implemented");
	}

	@Override
	public List<Object> getSelections() {
		throw new UnimplementedBVRException("getSelections is not implemented");
	}

	@Override
	public void highlightObjects(
			EList<HashMap<EObject, Integer>> objectsToHighlightList) {
		throw new UnimplementedBVRException("highlightObjects is not implemented");

	}

	@Override
	public void clearHighlights() {
		throw new UnimplementedBVRException("clearHighlights is not implemented");
	}

	@Override
	public JFileChooser getFileChooser() {
		throw new UnimplementedBVRException("getFileChooser is not implemented");
	}

	@Override
	public void writeProductsToFiles(
			HashMap<Resource, ResourceContentCopier> baseProductMap, File file) {
		throw new UnimplementedBVRException("writeProductsToFiles is not implemented");
	}

	@Override
	public void performSubstitutions(List<Symbol> symbols) {
		throw new UnimplementedBVRException("performSubstitutions is not implemented");
	}

	@Override
	public Logger getLogger() {
		throw new UnimplementedBVRException("getLogger is not implemented");
	}

	@Override
	public ConfigHelper getConfig() {
		throw new UnimplementedBVRException("getConfig is not implemented");
	}

	@Override
	public EditorCommands getEditorCommands() {
		throw new UnimplementedBVRException("Commands are not implemented for this environment");
	}

	@Override
	public void disposeModel(BVRModel model) {
		throw new UnimplementedBVRException("disposeModel is not implemented for this environment");
	}
}
