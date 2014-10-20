package no.sintef.bvr.tool.environment.eclipseless;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFileChooser;

import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.common.logging.ResetableLogger;
import no.sintef.bvr.tool.environment.AbstractEnvironment;
import no.sintef.bvr.tool.environment.ConfigHelper;
import no.sintef.bvr.tool.logging.impl.DefaultLogger;
import no.sintef.bvr.tool.ui.loader.BVRSimpleToolModel;
import no.sintef.bvr.tool.ui.loader.BVRToolModel;
import no.sintef.bvr.ui.editor.commands.EditorCommands;
import no.sintef.bvr.ui.editor.commands.EditorMVCCommands;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public class EclipseLessEnvironment extends AbstractEnvironment {

	private Logger logger = new DefaultLogger();
	private ConfigHelper configHelper = EclipseLessConfigHelper.getConfig();
	private EditorCommands commands = EditorMVCCommands.Get();
	
	@Override
	public BVRToolModel loadModelFromFile(File file) {
		no.sintef.ict.splcatool.SPLCABVRModel bvrm = new no.sintef.ict.splcatool.SPLCABVRModel(file);
		return new BVRSimpleToolModel(file, bvrm);
	}
	
	@Override
	public void writeModelToFile(BVRToolModel model, File file) {
		try {
			model.getBVRM().writeToFile(file.getAbsolutePath());
			model.setFile(file);
			configHelper.saveLastLocation(file.getAbsolutePath());
		} catch (IOException e) {
			logger.error("can not save file, IOException", e);
			throw new UnsupportedOperationException("can not save file, IOException " + e.getMessage());
		}
	}

	@Override
	public void highlightObjects(EList<HashMap<EObject, Integer>> objectsToHighlightList) {
		logger.warn("can not highlight objects, not implemeted");
	}

	@Override
	public void clearHighlights() {
		logger.warn("can not clear highlighting objects, not implemeted");
	}

	@Override
	public JFileChooser getFileChooser() {
		JFileChooser fc = new JFileChooser();
		if(configHelper.lastLocation() != null)
			fc.setCurrentDirectory(new File(configHelper.lastLocation()));
		configHelper.saveLastLocation(fc.getCurrentDirectory().getAbsolutePath());
		return fc;
	}
	
	@Override
	public Logger getLogger() {
		return logger;
	}
	
	@Override
	public ResetableLogger getProblemLogger() {
		return (ResetableLogger) logger;
	}
	
	@Override
	public ConfigHelper getConfig() {
		return configHelper;
	}

	@Override
	public EditorCommands getEditorCommands() {
		return commands;
	}

}
