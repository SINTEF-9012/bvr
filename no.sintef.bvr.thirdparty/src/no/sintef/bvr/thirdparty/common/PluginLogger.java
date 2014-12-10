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
package no.sintef.bvr.thirdparty.common;

import java.util.Calendar;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.common.logging.Logger;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;


public class PluginLogger implements Logger {
	
	private static final String pluginId = Constants.PLUGIN_ID_THIRDPARTY;
	private static final Calendar calendar = Calendar.getInstance();
	private ILog logger = Platform.getLog(Platform.getBundle(pluginId));
	
	private static final PluginLogger pluginLogger = new PluginLogger();
	
	public static PluginLogger getLogger(){
		return pluginLogger;
	}
	
	@Override
	public void error(String message) {
		logger.log(new Status(Status.ERROR, pluginId, "[PLUGIN ERROR " + calendar.getTime().toString() + "] " + message));
	}

	@Override
	public void warn(String message) {
		logger.log(new Status(Status.WARNING, pluginId, "[PLUGIN WARNING " + calendar.getTime().toString() + "] " + message));
	}

	@Override
	public void info(String message) {
		logger.log(new Status(Status.INFO, pluginId, "[PLUGIN INFO " + calendar.getTime().toString() + "] " + message));
	}

	@Override
	public void debug(String message) {
		logger.log(new Status(Status.INFO, pluginId, "[PLUGIN DEBUG " + calendar.getTime().toString() + "] " + message));
	}

	@Override
	public void error(String message, Throwable e) {
		String stackTrace = CommonUtility.getStackTraceAsString(e);
		error("Failed with the message: '" + message + "' and stack trace:\n" + stackTrace);
	}
}
