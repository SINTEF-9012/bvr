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
package no.sintef.bvr.ui.editor.common.observer;

import java.util.List;

import no.sintef.bvr.tool.interfaces.observer.ResourceSubject;

import org.eclipse.emf.common.util.URI;

public interface ResourceSubjectMap {
	
	public List<ResourceSubject> getSubjects(URI resourceURI);	
	public void testResourceSubject(URI resourceURI, ResourceSubject subject);
	public void pokeResourceSubjects(URI resourceURI);
}
