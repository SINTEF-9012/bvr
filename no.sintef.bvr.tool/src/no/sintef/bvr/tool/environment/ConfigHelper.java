/*******************************************************************************
 * Copyright (c) All rights reserved. This program and the accompanying
 * materials are made available under the terms of the Eclipse Public License
 * v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.environment;

public interface ConfigHelper {

	public String lastLocation();

	public void saveLastLocation(String location);

	public String getPropertyFileName();

	public void setToReplacementPermutation(boolean isSet);

	public boolean isToReplacementPermutation();

	public void setFromPlacementPermutation(boolean isSet);

	public boolean isFromPlacementPermutation();

	public void loadProperties();

	public void setContainmentSelectionMode(boolean isSet);

	public boolean isContainmentSelectionMode();

	public void setHighlightingMode(boolean isSet);

	public boolean isHighlightingMode();

	public boolean isIntersectionDetectionMode();

	public void setIntersectionDetectionMode(boolean isSet);
}
