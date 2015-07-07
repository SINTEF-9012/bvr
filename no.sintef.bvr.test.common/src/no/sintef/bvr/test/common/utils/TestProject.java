/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.test.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroManager;
import org.eclipse.ui.intro.IIntroPart;
import org.osgi.framework.Bundle;

public class TestProject {

	protected IProject iProject;
	protected String plugin_id;
	protected IProgressMonitor progressMonitor;
	protected String name;
	protected static boolean closed = false;

	public TestProject(String projectName, String _plugin_id)
			throws CoreException {
		name = projectName;
		plugin_id = _plugin_id;
		progressMonitor = new NullProgressMonitor();
		IWorkspaceRoot iWorcspaceRoot = ResourcesPlugin.getWorkspace()
				.getRoot();
		iProject = iWorcspaceRoot.getProject(projectName);
		iProject.create(progressMonitor);
		iProject.open(progressMonitor);
	}
	
	public String getName() {
		return name;
	}

	public IFolder createFolder(String testName) throws CoreException {
		IFolder iFolder = iProject.getFolder(testName);
		iFolder.create(true, true, null);
		return iFolder;
	}

	public void disposeTestProject() throws CoreException {
		iProject.close(progressMonitor);
		//iProject.delete(true, progressMonitor);
		iProject.delete(true, true, progressMonitor);
	}

	public IFile copyFileFromPlugin(String source, String target)
			throws IOException, CoreException {
		Bundle bundle = Platform.getBundle(plugin_id);
		URL url = bundle.getEntry(source);
		InputStream stream = url.openConnection().getInputStream();
		IFile iFile = iProject.getFile(target);
		iFile.create(stream, true, null);
		return iFile;
	}

	public IWorkbenchWindow getActionWorkbenchWindow() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	}

	public void createFolders(String[] testFolders) throws CoreException {
		for (String folder : testFolders)
			createFolder(folder);
	}
	
	public void createResources(TestResourceHolder[] testResources) throws IOException, CoreException {
		for(TestResourceHolder resource : testResources){
			IFile iFile = copyFileFromPlugin(resource.getSource(), resource.getTarget());
			resource.setiFile(iFile);
		}
	}
	
	public void closeWelcome() {
		if(!closed) {
			IIntroManager manager = PlatformUI.getWorkbench().getIntroManager();
			IIntroPart part = manager.getIntro();
			manager.closeIntro(part);
			closed = true;
		}
	}
	
	public IProject getIProject() {
		return iProject;
	}

}
