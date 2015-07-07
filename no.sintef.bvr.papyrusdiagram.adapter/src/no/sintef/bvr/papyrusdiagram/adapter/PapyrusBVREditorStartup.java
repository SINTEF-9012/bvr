/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.papyrusdiagram.adapter;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IStartup;

// TODO: Auto-generated Javadoc
/**
 * The Class PapyrusBVREditorStartup.
 */
public class PapyrusBVREditorStartup implements IStartup {

	/** The Constant PLUGIN_ID. */
	public static final String PLUGIN_ID = PapyrusBVREditorActivator.class.getPackage().getName();

	/** The logger. */
	private ILog logger = Platform.getLog(Platform.getBundle(PLUGIN_ID));

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IStartup#earlyStartup()
	 */
	@Override
	public void earlyStartup() {
		logger.log(new Status(IStatus.INFO, PLUGIN_ID, "[PLUGIN " + PLUGIN_ID + "] " + "starting and activating the Papyrus and BVR integration"));
	}

}
