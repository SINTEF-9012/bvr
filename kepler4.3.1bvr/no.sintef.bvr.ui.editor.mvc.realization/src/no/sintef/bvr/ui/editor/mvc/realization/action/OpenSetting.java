package no.sintef.bvr.ui.editor.mvc.realization.action;

import java.awt.Toolkit;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.controller.command.SettingsToolEvent;
import no.sintef.bvr.ui.editor.common.ExecuteCommandEvent;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class OpenSetting extends AbstractHandler {
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new ExecuteCommandEvent(Context.eINSTANCE.getActiveJApplet(), new SettingsToolEvent()));
		return null;
	}
}
