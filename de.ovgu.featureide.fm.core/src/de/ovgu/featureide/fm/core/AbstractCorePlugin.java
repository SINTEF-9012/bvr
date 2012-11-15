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

/**
 * A default implementation for non-UI plug-ins within FeatureIDE.
 * 
 * @author Thomas Thuem
 */
abstract public class AbstractCorePlugin {

	/**
	 * Returns the plug-in ID as specified at the plug-in manifest.
	 * 
	 * @return the plug-in id
	 */
	abstract public String getID();

	
	/**
	 * Convenience method for easy and clean logging. All messages collected by
	 * this method will be written to the eclipse log file.
	 * 
	 * Messages are only written to the error log, if the debug option is set
	 * for this plug-in
	 * 
	 * @param message
	 *            A message that should be written to the eclipse log file
	 */
	public void logInfo(String message) {

	}

	/**
	 * Convenience method for easy and clean logging of warnings. All messages
	 * collected by this method will be written to the eclipse log file.
	 * 
	 * @param message
	 *            A message that should be written to the eclipse log file
	 */
	public void logWarning(String message) {

	}

	/**
	 * Convenience method for easy and clean logging of exceptions. All messages
	 * collected by this method will be written to the eclipse log file. The
	 * exception's stack trace is added to the log as well.
	 * 
	 * @param message
	 *            A message that should be written to the eclipse log file
	 * @param exception
	 *            Exception containing the stack trace
	 */
	public void logError(String message, Throwable exception) {
	}

	/**
	 * Convenience method for easy and clean logging of exceptions. All messages
	 * collected by this method will be written to the eclipse log file. The
	 * exception's stack trace is added to the log as well.
	 * 
	 * @param exception
	 *            Exception containing the stack trace
	 */
	public void logError(Throwable exception) {
		if (exception != null)
			logError(exception.getMessage(), exception);
	}

	/**
	 * Logging any kind of message.
	 * 
	 * @param severity
	 * @param message
	 * @param exception
	 */
	private void log(int severity, String message, Throwable exception) {

	}

}
