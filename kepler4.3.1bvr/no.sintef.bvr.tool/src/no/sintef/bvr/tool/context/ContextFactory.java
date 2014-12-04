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
package no.sintef.bvr.tool.context;

import no.sintef.bvr.tool.environment.Environment;
import no.sintef.bvr.tool.environment.eclipse.EclipseEnvironment;
import no.sintef.bvr.tool.environment.eclipseless.EclipseLessEnvironment;

import org.eclipse.ui.IWorkbenchWindow;

public final class ContextFactory {
	
	public final static ContextFactory eINSTANCE = getFactoryCreator();
	
	private static ContextFactory getFactoryCreator(){
		return new ContextFactory();
	}
	
	public Environment createEnvironment(IWorkbenchWindow workbanch){
		return (workbanch == null) ? new EclipseLessEnvironment() : new EclipseEnvironment(workbanch);
	}
	
	public Environment createEnvironment(){
		return new EclipseLessEnvironment();
	}
	
	public ViewChanageManager createViewChanageManager(){
		return ViewChanageManager.getChangeManager();
	}

}
