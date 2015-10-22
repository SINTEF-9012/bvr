/*******************************************************************************
 * Copyright (c) All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.engine.interfaces.common;

import java.util.HashMap;

import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.engine.interfaces.fragment.IPlacementElementHolder;
import no.sintef.bvr.engine.interfaces.fragment.IReplacementElementHolder;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;

import bvr.FragmentSubstitution;
import bvr.PlacementFragment;
import bvr.ReplacementFragmentType;

public interface ISubstitutionEngine {

	public void setLogger(Logger logger);

	public void init(EList<FragmentSubstitution> fragmentSubstitutions);

	public void subsitute(FragmentSubstitution fragmentSubstitution, boolean replace) throws RuntimeException;

	public HashMap<Resource, IResourceContentCopier> getCopiedBaseModels();

	public IBVRElementDeepCopier createBVRElementDeepCopier();

	public IEngineUtility getUtility();

	public IReplacementElementHolder createReplacementElementHolder(ReplacementFragmentType replacement);

	public IPlacementElementHolder createPlacementElementHolder(PlacementFragment placement);

	public void setIntersectionDetectionMode(boolean mode);

	public IResourceContentCopier getResourceContentCopier();

	void setCopyBaseModelMap(HashMap<Resource, IResourceContentCopier> map);

}
