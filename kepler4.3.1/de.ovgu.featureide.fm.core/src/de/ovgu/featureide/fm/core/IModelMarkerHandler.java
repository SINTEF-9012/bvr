/* FeatureIDE - An IDE to support feature-oriented software development
 * Copyright (C) 2005-2011  FeatureIDE Team, University of Magdeburg
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see http://www.gnu.org/licenses/.
 *
 * See http://www.fosd.de/featureide/ for further information.
 */
package de.ovgu.featureide.fm.core;

public interface IModelMarkerHandler {

	/**
	 * Creates a new marker at the model file with the given message. If the
	 * file not exists, the marker will be set to the associated project.
	 * 
	 * @param  message  the message to remark
	 * @param lineNumber 
	 */
	public abstract void createModelMarker(String message, int severity, int lineNumber);

	public abstract void deleteAllModelMarkers();

	public abstract boolean hasModelMarkers();

}
