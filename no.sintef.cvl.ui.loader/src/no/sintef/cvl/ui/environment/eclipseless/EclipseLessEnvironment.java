package no.sintef.cvl.ui.environment.eclipseless;

import java.io.File;
import java.util.HashMap;

import javax.swing.JFileChooser;

import no.sintef.cvl.common.logging.Logger;
import no.sintef.cvl.ui.environment.AbstractEnvironment;
import no.sintef.cvl.ui.environment.ConfigHelper;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.logging.impl.DefaultLogger;

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
