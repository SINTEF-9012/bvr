/*******************************************************************************
 * Copyright (c) All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.environment;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;

import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.common.logging.ResetableLogger;
import no.sintef.bvr.engine.interfaces.common.IResourceContentCopier;
import no.sintef.bvr.tool.interfaces.model.IBVREditingDomain;
import no.sintef.bvr.tool.model.BVRToolModel;
import no.sintef.bvr.tool.primitive.SymbolVSpec;
import no.sintef.bvr.ui.editor.commands.EditorCommands;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public interface Environment {

	public BVRToolModel loadModelFromFile(File file);

	public void writeModelToFile(BVRToolModel model, File file);

	public void writeProductsToFiles(HashMap<Resource, IResourceContentCopier> baseProductMap, File file);

	public void performSubstitutions(List<SymbolVSpec> symbols);

	public void reloadModel(BVRToolModel model);

	public EObject getEObject(Object object);

	public List<Object> getSelections();

	public void highlightObjects(EList<HashMap<EObject, Integer>> objectsToHighlightList);

	public void clearHighlights();

	public JFileChooser getFileChooser();

	public Logger getLogger();

	public ConfigHelper getConfig();

	public EditorCommands getEditorCommands();

	public void disposeModel(BVRToolModel model);

	public ResetableLogger getProblemLogger();

	public IBVREditingDomain getCurrentExecutionEditingDomain();

	public void setCurrentExecutionEditingDomain(IBVREditingDomain editingDomain);
}
