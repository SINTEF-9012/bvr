/*******************************************************************************
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package no.sintef.bvr.tool.ui.command.event;

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

import no.sintef.bvr.thirdparty.common.Utility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.interfaces.controller.command.SimpleExeCommandInterface;
import no.sintef.bvr.tool.ui.context.StaticUICommands;

public class CopyModelEvent implements SimpleExeCommandInterface {

	@Override
	public void execute () {
		try{
			FileFilter[] filters = {};
			JFileChooser filechooser = StaticUICommands.getFileChooser(filters, null);
			
			int status = filechooser.showOpenDialog(Context.eINSTANCE.getActiveJApplet());
			if(status == JFileChooser.CANCEL_OPTION)
				return;
			
			File file = filechooser.getSelectedFile();
			if(file == null) return;
			
			String pathOriginal = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separator));
			pathOriginal = (pathOriginal.endsWith(File.separator)) ? pathOriginal : pathOriginal + File.separator;
			String path = pathOriginal.replaceAll("\\\\", "/");
			if(!path.startsWith(Utility.getWorkspaceRowLocation()))
				throw new UnsupportedOperationException("can not save a product to the file, incorrect loacation: use workspace location");
			
			String platformFilepath = file.getAbsolutePath().replaceAll("\\\\", "/");
			platformFilepath = platformFilepath.replaceAll(Utility.getWorkspaceRowLocation(), "");
			
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
			ResourceSet resSet = new ResourceSetImpl();
			URI uri = URI.createPlatformResourceURI(platformFilepath, true);
			Resource resource = resSet.getResource(uri, true);
			
			URI resourceURI = resource.getURI();
			String baseName = resourceURI.segment(resourceURI.segmentCount() - 1);
			String productName = "copy_" + baseName;
			
			String productPlatformFileName = path.replaceAll(Utility.getWorkspaceRowLocation(), "") + productName;
			
		    ResourceSet resSetCopy = new ResourceSetImpl();
		    URI uriCopy = URI.createPlatformResourceURI(productPlatformFileName, true);
		    Context.eINSTANCE.logger.debug("saving a copy of the model to the file file " + uriCopy);
		    Resource productResource = resSetCopy.createResource(uriCopy);
		    
		    productResource.getContents().addAll(EcoreUtil.copyAll(resource.getContents()));
		    
		    Map<Object, Object> options = new HashMap<Object, Object>();
			options.put(XMIResource.OPTION_ENCODING, ((XMIResource) resource).getEncoding());
			
			productResource.save(options);
		} catch (Exception e) {
			Context.eINSTANCE.logger.error("some exception on copying", e);
			StaticUICommands.showMessageErrorDialog(Context.eINSTANCE.getActiveJApplet(), e, "some exception on copying");
		}
	}

}
