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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;

import no.sintef.bvr.common.logging.ResetableLogger;
import no.sintef.bvr.thirdparty.exception.UnexpectedThirdPartyException;

public class ProblemLoger implements ResetableLogger {
	
	private IResource iresource;
	private EObject srcObject;


	private static final ProblemLoger problemLogger = new ProblemLoger();
	
	public static ProblemLoger getLogger(){
		return problemLogger;
	}
	
	@Override
	public void error(String message) {
		IMarker m;
		try {
			m = iresource.createMarker(IMarker.PROBLEM);
			m.setAttribute(IMarker.MESSAGE, message);
			m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
			m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
		} catch (CoreException e) {
			throw new UnexpectedThirdPartyException(e);
		}

	}

	@Override
	public void error(String message, Throwable e) {
		IMarker m;
		try {
			m = iresource.createMarker(IMarker.PROBLEM);
			m.setAttribute(IMarker.MESSAGE, message);
			m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
			m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
		} catch (CoreException ex) {
			throw new UnexpectedThirdPartyException(ex);
		}
	}

	@Override
	public void warn(String message) {
		IMarker m;
		try {
			m = iresource.createMarker(IMarker.PROBLEM);
			m.setAttribute(IMarker.MESSAGE, message);
			m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);
			m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
		} catch (CoreException ex) {
			throw new UnexpectedThirdPartyException(ex);
		}
	}

	@Override
	public void info(String message) {
		IMarker m;
		try {
			m = iresource.createMarker(IMarker.PROBLEM);
			m.setAttribute(IMarker.MESSAGE, message);
			m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);
			m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
		} catch (CoreException ex) {
			throw new UnexpectedThirdPartyException(ex);
		}

	}

	@Override
	public void debug(String message) {
		IMarker m;
		try {
			m = iresource.createMarker(IMarker.PROBLEM);
			m.setAttribute(IMarker.MESSAGE, message);
			m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_LOW);
			m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
		} catch (CoreException ex) {
			throw new UnexpectedThirdPartyException(ex);
		}
	}

	@Override
	public void setSource(EObject src) {
		srcObject = (EObject) src;
		
	}

	@Override
	public void setResource(IResource resource) {
		iresource = (IResource) resource;
		
	}

	@Override
	public void resetLogger() {
		try {
			iresource.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		} catch (CoreException e) {
			throw new RuntimeException("Rethrowing exception", e);
		}
		
	}

}
