package no.sintef.cvl.ui.command.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import no.sintef.cvl.thirdparty.common.Utility;
import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.context.StaticUICommands;

public class CopyModelEvent implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		try{
			FileFilter[] filters = {};
			JFileChooser filechooser = StaticUICommands.getFileChooser(filters, null);
			
			int status = filechooser.showOpenDialog(null);
			if(status == JFileChooser.CANCEL_OPTION)
				return;
			
			File file = filechooser.getSelectedFile();
			if(file == null) return;
			
			String filepath = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separator));
			filepath = (filepath.endsWith(File.separator)) ? filepath : filepath + File.separator;
			filepath = filepath.replaceAll("\\\\", "/");
			if(!filepath.startsWith(Utility.getWorkspaceRowLocation()))
				throw new UnsupportedOperationException("can not save a product to the file, incorrect loacation: use workspace location");
			
			filepath = file.getAbsolutePath().replaceAll("\\\\", "/");
			filepath = filepath.replaceAll(Utility.getWorkspaceRowLocation(), "");
			
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
			ResourceSet resSet = new ResourceSetImpl();
			URI uri = URI.createPlatformResourceURI(filepath, true);
			Resource resource = resSet.getResource(uri, true);
			
			URI resourceURI = resource.getURI();
			String baseName = resourceURI.segment(resourceURI.segmentCount() - 1);
			String productName = "copy_" + baseName;
			
			filepath = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separator));
			filepath = (filepath.endsWith(File.separator)) ? filepath : filepath + File.separator;
			filepath = filepath.replaceAll("\\\\", "/");
			filepath = filepath.replaceAll(Utility.getWorkspaceRowLocation(), "");
			String productFullName = filepath + productName;
			
		    ResourceSet resSetCopy = new ResourceSetImpl();
		    URI uriCopy = URI.createPlatformResourceURI(productFullName, true);
		    Context.eINSTANCE.logger.debug("saving a copy of the model to the file file " + uriCopy);
		    Resource productResource = resSetCopy.createResource(uriCopy);
		    
		    productResource.getContents().addAll(EcoreUtil.copyAll(resource.getContents()));
		    
		    Map<Object, Object> options = new HashMap<Object, Object>();
			options.put(XMIResource.OPTION_ENCODING, ((XMIResource) resource).getEncoding());
			
			productResource.save(options);
		} catch (Exception e) {
			Context.eINSTANCE.logger.error("some exception on copying", e);
			StaticUICommands.showMessageErrorDialog(null, e, "some exception on copying");
		}
	}

}
