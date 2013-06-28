package no.sintef.cvl.ui.strategy.impl;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import cvl.ConfigurableUnit;

import no.sintef.cvl.ui.common.Messages;
import no.sintef.cvl.ui.loader.CVLModel;
import no.sintef.cvl.ui.loader.FileHelper;
import no.sintef.cvl.ui.strategy.SaveProductStrategy;

public class SimpleSaveProductStrategy implements SaveProductStrategy {

	@Override
	public void saveProduct(HashMap<String, Object> keywords) {
		ConfigurableUnit cu = (ConfigurableUnit) keywords.get("cu");
		JComponent parent = (JComponent) keywords.get("parentComponent");
		CVLModel model = (CVLModel) keywords.get("cvlModel");
		
		ResourceSet resSet = cu.eResource().getResourceSet();
		EList<Resource> resources = resSet.getResources();
		EList<Resource> resourcesModified = new BasicEList<Resource>();
		for(Resource resource : resources){
			if(this.isResourceModified(resource))
				resourcesModified.add(resource);
		}
		
		final JFileChooser fc = new JFileChooser();
		if(FileHelper.lastLocation() != null)
			fc.setCurrentDirectory(new File(FileHelper.lastLocation()));
		
		fc.showSaveDialog(parent);
		File sf = fc.getSelectedFile();
		if(sf == null) return;
		
		String absolutName = sf.getAbsolutePath();
		for(Resource resource : resourcesModified){
			URI uri = resource.getURI();
			String lastSegmant = uri.lastSegment();
			String newFileName = absolutName + "_" + lastSegmant;
			newFileName = newFileName.replaceAll("\\\\", "/");
			
			File file = new File(newFileName);
			if(file.exists()){
				int result = JOptionPane.showConfirmDialog(parent, Messages.DIALOG_MSG_FILE_EXISTS, Messages.DIALOG_TITLE_ALERT, JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.NO_OPTION)
					continue;
			}
			
			//do not save variability model itself
			if(model.getCU().eResource().equals(resource)){
				continue;
			}
			
			resource.setURI(URI.createFileURI(newFileName));
			try {
				resource.save(Collections.EMPTY_MAP);
			} catch (IOException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(parent, Messages.DIALOG_MSG_FAIL_TOSAVE_RES + "\n" + resource);
			}
		}

	}
	
	private boolean isResourceModified(Resource resource){
		return true;
	}

}
