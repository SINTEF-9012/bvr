/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.ui.editor.common;

import java.awt.AWTEvent;

import no.sintef.bvr.tool.interfaces.controller.BVRNotifiableController;



public class RefreshViewEvent extends AWTEvent {

	private static final long serialVersionUID = -8365918870492060388L;
	
	public  static final int EVENT_ID = AWTEvent.RESERVED_ID_MAX + 1;
	
	private BVRNotifiableController view;
	
	public RefreshViewEvent(Object target, BVRNotifiableController view) {
		super(target, EVENT_ID);
		this.view = view;
	}
	
	public void refreshView(){
		view.refresh();
	}
}
