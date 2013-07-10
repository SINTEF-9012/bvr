package no.sintef.cvl.ui.context;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;
import no.sintef.cvl.thirdparty.common.Utility;
import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.editor.RestrictedJFileChooser;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.FileHelper;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IWorkbenchWindow;

public class EclipseEnvironment extends AbstractEnvironment {
	
	private IWorkbenchWindow workbench;

	public EclipseEnvironment(IWorkbenchWindow workbench) {
		this.workbench = workbench;
	}

	@Override
	public CVLModel loadModelFromFile(File file) {
		String fileName = file.getAbsolutePath();
		
		return null;
	}

	@Override
	public int writeModelToFile(CVLModel model, String filename) {
		String filepath = filename.replaceAll("\\\\", "/");
		if(!filepath.startsWith(Utility.getWorkspaceRowLocation())){
			return Constants.CODE_MODEL_SAVE_INCORRECT_LOCATION;
		}
		filepath = filepath.replaceAll(Utility.getWorkspaceRowLocation(), "");
		try {
			model.getCVLM().writeToPlatformFile(filepath);
		} catch (IOException e) {
			String stackTrace = no.sintef.cvl.ui.common.Utility.getStackTraceAsString(e);
			LOG.error(stackTrace);
			return Constants.CODE_MODEL_SAVE_IOEXCEPTION;
		}
		return Constants.CODE_MODEL_SAVE_OK;
	}

	@Override
	public void reloadModel(CVLModel model) {
		// TODO Auto-generated method stub

	}

	@Override
	public EObject getEObject(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getSelections() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void highlightObjects(
			EList<HashMap<EObject, Integer>> objectsToHighlightList) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearHighlights() {
		// TODO Auto-generated method stub

	}

	@Override
	public JFileChooser getFileChooser() {
		String path = Utility.getWorkspaceRowLocation();
		RestrictedJFileChooser fc = new RestrictedJFileChooser(path);
		String lastLocation = FileHelper.lastLocation().replaceAll("\\\\", "/");
		if(lastLocation.startsWith(path))
			fc.setCurrentDirectory(new File(lastLocation));
		return fc;
	}

}
