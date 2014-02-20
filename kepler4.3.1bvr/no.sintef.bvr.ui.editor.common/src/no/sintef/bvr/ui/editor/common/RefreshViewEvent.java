package no.sintef.bvr.ui.editor.common;

import java.awt.AWTEvent;

import no.sintef.bvr.tool.ui.loader.BVRView;

public class RefreshViewEvent extends AWTEvent {

	private static final long serialVersionUID = -8365918870492060388L;
	
	public  static final int EVENT_ID = AWTEvent.RESERVED_ID_MAX + 1;
	
	private BVRView view;
	
	public RefreshViewEvent(Object target, BVRView view) {
		super(target, EVENT_ID);
		this.view = view;
	}
	
	public void refreshView(){
		view.refresh();
	}
}
