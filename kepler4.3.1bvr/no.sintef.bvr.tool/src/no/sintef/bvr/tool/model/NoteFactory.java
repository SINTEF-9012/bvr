package no.sintef.bvr.tool.model;

import no.sintef.bvr.tool.context.Context;

import org.eclipse.emf.common.util.EList;

import bvr.BvrPackage;
import bvr.NamedElement;
import bvr.Note;

public final class NoteFactory {
	
	final private String COMMENT_KIND = "comment"; 
	
	public static NoteFactory eINSTANCE = getInstance();
	
	private static NoteFactory getInstance() {
		if(eINSTANCE == null)
			eINSTANCE = new NoteFactory();
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
