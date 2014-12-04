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
package no.sintef.bvr.ui.editor.mvc.resolutionV2;

import java.awt.Toolkit;
import java.io.File;
import java.util.List;

import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;
import no.sintef.bvr.tool.observer.ResourceSavedSubject;
import no.sintef.bvr.tool.observer.ResourceSetEditedSubject;
import no.sintef.bvr.ui.editor.common.MVCEditor;
import no.sintef.bvr.ui.editor.common.RefreshViewEvent;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSavedSubjectMap;
import no.sintef.bvr.ui.editor.common.observer.ResourceResourceSetSubjectMap;

public class MVCResolutionEditorV2 extends MVCEditor{

	@Override
	public void setTitle() {
		setPartName(new File(filename).getName() + " (Resolution)");
	}

	@Override
	public void setContents() {
		jApplet.add(((ResolutionRootController)controllerNotifiable).getResolutionPane());
	}
/*
 *create view object and add to subject list
 */
	@Override
	public synchronized void createView() {
		controllerNotifiable = new ResolutionRootController(toolModel);
		List<ResourceSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE.getSubjects(resourceURI);
		ResourceSetEditedSubject subject = testResourceSetEditedSubject(subjects);
		subject.attach(this);
		ResourceResourceSetSubjectMap.eINSTANCE.testResourceSubject(resourceURI, subject);
		
		ResourceSavedSubject sbjct = ResourceResourceSavedSubjectMap.eINSTANCE.testResourceSavedSubject(resourceURI);
		sbjct.attach(this);

	}
	//if a change occurs, check if is is a save, if not mark as not saved and post RefreshViewEvent to eventQueue . if it is a save, mark as saved. then run update.

	@Override
	public void update(ResourceSubject subject) {
		if(subject instanceof ResourceSetEditedSubject){
			toolModel.markNotSaved();
			Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new RefreshViewEvent(jApplet,controllerNotifiable));
		}
		if(subject instanceof ResourceSavedSubject){
			toolModel.markSaved();
		}
		super.update(subject);
	}

	@Override
	public void dispose() {
		List<ResourceSubject> subjects = ResourceResourceSetSubjectMap.eINSTANCE.getSubjects(resourceURI);
		ResourceSetEditedSubject subject = testResourceSetEditedSubject(subjects);
		subject.markObseleteObsever(this);
		
		ResourceSavedSubject subjectSaved = ResourceResourceSavedSubjectMap.eINSTANCE.testResourceSavedSubject(resourceURI);
		subjectSaved.markObseleteObsever(this);
		
		super.dispose();
	}

}
