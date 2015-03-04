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
package no.sintef.bvr.papyrusdiagram.adapter;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IStartup;

// TODO: Auto-generated Javadoc
/**
 * The Class PapyrusBVREditorStartup.
 */
public class PapyrusBVREditorStartup implements IStartup {

	/** The Constant PLUGIN_ID. */
	public static final String PLUGIN_ID = PapyrusBVREditorActivator.class.getPackage().getName();

	/** The logger. */
	private ILog logger = Platform.getLog(Platform.getBundle(PLUGIN_ID));

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IStartup#earlyStartup()
	 */
	@Override
	public void earlyStartup() {
		logger.log(new Status(IStatus.INFO, PLUGIN_ID, "[PLUGIN " + PLUGIN_ID + "] " + "starting and activating the Papyrus and BVR integration"));
	}

}
