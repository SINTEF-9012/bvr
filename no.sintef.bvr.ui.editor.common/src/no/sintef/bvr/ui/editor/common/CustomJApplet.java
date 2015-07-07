/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
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
