package no.sintef.cvl.tool.environment;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;

import no.sintef.cvl.common.logging.Logger;
import no.sintef.cvl.engine.common.ResourceContentCopier;
import no.sintef.cvl.tool.exception.UnimplementedCVLException;
import no.sintef.cvl.tool.primitive.Symbol;
import no.sintef.cvl.tool.ui.loader.CVLModel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class AbstractEnvironment implements Environment {
	
	@Override
	public CVLModel loadModelFromFile(File file) {
		throw new UnimplementedCVLException("loadModelFromFile is not implemented");
	}

	@Override
	public void writeModelToFile(CVLModel model, File file) {
		throw new UnimplementedCVLException("writeModelToFile is not implemented");
	}

	@Override
	public void reloadModel(CVLModel model) {
		throw new UnimplementedCVLException("reloadModel is not implemented");
	}

	@Override
	public EObject getEObject(Object object) {
		throw new UnimplementedCVLException("getEObject is not implemented");
	}

	@Override
	public List<Object> getSelections() {
		throw new UnimplementedCVLException("getSelections is not implemented");
	}

	@Override
	public void highlightObjects(
			EList<HashMap<EObject, Integer>> objectsToHighlightList) {
		throw new UnimplementedCVLException("highlightObjects is not implemented");

	}

	@Override
	public void clearHighlights() {
		throw new UnimplementedCVLException("clearHighlights is not implemented");
	}

	@Override
	public JFileChooser getFileChooser() {
		throw new UnimplementedCVLException("getFileChooser is not implemented");
	}

	@Override
	public void writeProductsToFiles(
			HashMap<Resource, ResourceContentCopier> baseProductMap, File file) {
		throw new UnimplementedCVLException("writeProductsToFiles is not implemented");
	}

	@Override
	public void performSubstitutions(List<Symbol> symbols) {
		throw new UnimplementedCVLException("performSubstitutions is not implemented");
	}

	@Override
	public Logger getLogger() {
		throw new UnimplementedCVLException("getLogger is not implemented");
	}

	@Override
	public ConfigHelper getConfig() {
		throw new UnimplementedCVLException("getConfig is not implemented");
	}

}
