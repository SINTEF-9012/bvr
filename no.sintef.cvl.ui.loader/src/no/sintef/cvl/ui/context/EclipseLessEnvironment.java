package no.sintef.cvl.ui.context;

import java.io.File;
import java.util.HashMap;

import javax.swing.JFileChooser;

import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.FileHelper;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public class EclipseLessEnvironment extends AbstractEnvironment {

	@Override
	public CVLModel loadModelFromFile(File file) {
		no.sintef.ict.splcatool.CVLModel cvlm = new no.sintef.ict.splcatool.CVLModel(file);
		return new CVLModel(file, cvlm);
	}

	@Override
	public void highlightObjects(EList<HashMap<EObject, Integer>> objectsToHighlightList) {
		LOG.warn("can not highlight objects, not implemeted");
	}

	@Override
	public void clearHighlights() {
		LOG.warn("can not clear highlighting objects, not implemeted");
	}

	@Override
	public JFileChooser getFileChooser() {
		JFileChooser fc = new JFileChooser();
		if(FileHelper.lastLocation() != null)
			fc.setCurrentDirectory(new File(FileHelper.lastLocation()));
		return fc;
	}

}
