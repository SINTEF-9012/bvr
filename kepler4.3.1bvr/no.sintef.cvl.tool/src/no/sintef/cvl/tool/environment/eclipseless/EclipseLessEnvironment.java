package no.sintef.cvl.tool.environment.eclipseless;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFileChooser;

import no.sintef.cvl.common.logging.Logger;
import no.sintef.cvl.tool.environment.AbstractEnvironment;
import no.sintef.cvl.tool.environment.ConfigHelper;
import no.sintef.cvl.tool.logging.impl.DefaultLogger;
import no.sintef.cvl.tool.ui.loader.CVLModel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public class EclipseLessEnvironment extends AbstractEnvironment {

	private Logger logger = new DefaultLogger();
	private ConfigHelper configHelper = EclipseLessConfigHelper.getConfig();
	
	@Override
	public CVLModel loadModelFromFile(File file) {
		no.sintef.ict.splcatool.CVLModel cvlm = new no.sintef.ict.splcatool.CVLModel(file);
		return new CVLModel(file, cvlm);
	}
	
	@Override
	public void writeModelToFile(CVLModel model, File file) {
		try {
			model.getCVLM().writeToFile(file.getAbsolutePath());
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
	public ConfigHelper getConfig() {
		return configHelper;
	}

}
