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
package no.sintef.bvr.common.logging;

import java.util.Calendar;

import no.sintef.bvr.common.CommonUtility;
import no.sintef.bvr.common.logging.Logger;


public class ConsoleLogger implements Logger {

	private static Calendar calendar = Calendar.getInstance();

	@Override
	public void error(String message) {
		this.debug(message);
	}

	@Override
	public void warn(String message) {
		this.debug(message);
	}

	@Override
	public void info(String message) {
		this.debug(message);
	}

	@Override
	public void debug(String message) {
		System.out.println("[CONSOLE LOGGER] " + calendar.getTime().toString() + ": " + message);
	}

	@Override
	public void error(String message, Throwable e) {
		String stackTrace = CommonUtility.getStackTraceAsString(e);
		error(message + " with the stack trace:\n" + stackTrace);
	}	

}
