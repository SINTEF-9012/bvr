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
package no.sintef.bvr.tool.model;

import no.sintef.bvr.tool.context.Context;

import org.eclipse.emf.common.util.EList;

import bvr.BvrPackage;
import bvr.NamedElement;
import bvr.Note;

public final class NoteFacade {
	
	final private String COMMENT_KIND = "comment"; 
	
	public static NoteFacade eINSTANCE = getInstance();
	
	private static NoteFacade getInstance() {
		if(eINSTANCE == null)
			eINSTANCE = new NoteFacade();
		return eINSTANCE;
	}

	public Note testCommentNote(NamedElement parent) {
		Note commentNote = null;
		EList<Note> notes = parent.getNote();
		for(Note note : notes){
			if(note.getKind().equals(COMMENT_KIND)){
				commentNote = note;
				break;
			}
		}
		
		if(commentNote == null){
			commentNote = BvrPackage.eINSTANCE.getBvrFactory().createNote();
			commentNote.setKind(COMMENT_KIND);
			commentNote.setExpr("");
			commentNote.setName(COMMENT_KIND);
			Context.eINSTANCE.getEditorCommands().createNote(parent, commentNote);
		}
		return commentNote;
	}
	
	public String getCommentText(NamedElement parent) {
		Note commentNote = null;
		EList<Note> notes = parent.getNote();
		for(Note note : notes){
			if(note.getKind().equals(COMMENT_KIND)){
				commentNote = note;
				break;
			}
		}
		
		return (commentNote != null) ? commentNote.getExpr() : "";
	}
}
