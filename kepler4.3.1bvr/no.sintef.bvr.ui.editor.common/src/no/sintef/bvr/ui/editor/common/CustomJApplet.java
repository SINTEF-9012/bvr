package no.sintef.bvr.ui.editor.common;

import java.awt.AWTEvent;

import javax.swing.JApplet;


public class CustomJApplet extends JApplet  {
	
	private static final long serialVersionUID = 1255230275000525945L;

	public CustomJApplet(){
		super();
		enableEvents( RefreshViewEvent.EVENT_ID | ExecuteCommandEvent.EVENT_ID | AWTEvent.KEY_EVENT_MASK);
	}

	@Override
	protected void processEvent(AWTEvent event) {
		if(event instanceof RefreshViewEvent){
			((RefreshViewEvent) event).refreshView();
		}else if(event instanceof ExecuteCommandEvent){
			((ExecuteCommandEvent) event).execute();
		}else{
			super.processEvent(event);
		}
	}
}
