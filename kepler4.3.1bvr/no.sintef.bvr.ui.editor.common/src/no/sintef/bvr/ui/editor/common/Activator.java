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
package no.sintef.bvr.ui.editor.common;

import javax.swing.JOptionPane;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.context.StaticUICommands;
import no.sintef.bvr.ui.editor.commands.EditorEMFTransactionalCommands;
import no.sintef.bvr.ui.editor.common.listener.DomainResourceSetListener;
import no.sintef.bvr.ui.editor.common.listener.ResourceSetChangedListener;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "no.sintef.bvr.ui.editor.common"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
		EditorEMFTransactionalCommands commands = EditorEMFTransactionalCommands.Get();
		TransactionalEditingDomain editingDomain = commands.testTransactionalEditingDomain();
		editingDomain.addResourceSetListener(new DomainResourceSetListener());
		ResourcesPlugin.getWorkspace().addResourceChangeListener(new ResourceSetChangedListener());		
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
		      public void uncaughtException(Thread t, Throwable e) {
		    	  Context.eINSTANCE.logger.error("Unhandled Error in Thread: " + t, e);
		    	  Context.eINSTANCE.getEditorCommands().reset();
		    	  //StaticUICommands.showMessageErrorDialog(Context.eINSTANCE.getActiveJApplet(), e, "Error : " + e.getMessage());
		    	  JOptionPane.showMessageDialog(Context.eINSTANCE.getActiveJApplet(),
		    			  "Failed with message : " + e.getMessage(), "Error : see error log for more details!",
							JOptionPane.ERROR_MESSAGE);
		      }
		 });
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
