package no.sintef.bvr.ui.editor.mvc.realization.action;

import no.sintef.bvr.tool.ui.edit.BVROptionsEditor;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;

public class OpenSetting implements IHandler {
	
	private BVROptionsEditor settingsEditor;

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {		
		if(settingsEditor != null)
			settingsEditor.unshowEditor();
		settingsEditor = new BVROptionsEditor();
		settingsEditor.showEditor();
		return false;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
	}

}
