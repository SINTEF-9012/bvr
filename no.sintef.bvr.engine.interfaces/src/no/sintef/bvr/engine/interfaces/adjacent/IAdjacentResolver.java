/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.engine.interfaces.adjacent;

import no.sintef.bvr.common.engine.error.BasicBVREngineException;
import no.sintef.bvr.engine.interfaces.fragment.IFragSubHolder;


public interface IAdjacentResolver {

	public void resolve(IFragSubHolder fragmentHolder) throws BasicBVREngineException;
}
