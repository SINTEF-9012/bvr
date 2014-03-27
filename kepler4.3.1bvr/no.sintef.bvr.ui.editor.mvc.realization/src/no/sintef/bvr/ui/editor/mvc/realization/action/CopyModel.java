package no.sintef.bvr.ui.editor.mvc.realization.action;

import java.awt.Toolkit;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.ui.command.event.CopyModelEvent;
import no.sintef.bvr.ui.editor.common.ExecuteCommandEvent;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class CopyModel extends AbstractHandler {


	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new ExecuteCommandEvent(Context.eINSTANCE.getActiveJApplet(), new CopyModelEvent()));
		return null;
	}
}
