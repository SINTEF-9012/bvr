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
package de.ovgu.featureide.fm.core.configuration;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import de.ovgu.featureide.fm.core.FMCorePlugin;
import de.ovgu.featureide.fm.core.Feature;

public class ConfigurationReader {

	private Configuration configuration;

	private LinkedList<String> warnings = new LinkedList<String>();
	private LinkedList<Integer> positions = new LinkedList<Integer>();

	public ConfigurationReader(Configuration configuration) {
		this.configuration = configuration;
	}

	public boolean readFromString(String text) {
		InputStream inputStream = null;
		try {
			inputStream = new ByteArrayInputStream(text.getBytes());
			return readFromInputStream(inputStream);
		} catch (IOException e) {
			FMCorePlugin.getDefault().logError(e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					FMCorePlugin.getDefault().logError(e);
				}
			}
		}
		return false;
	}

	private boolean readFromInputStream(InputStream inputStream)
			throws IOException {
		configuration.resetValues();
		BufferedReader reader = null;
		String line = null;
		Integer lineNumber = 1;
		boolean successful = true;
		try {
			reader = new BufferedReader(new InputStreamReader(inputStream));
			while ((line = reader.readLine()) != null) {
				if (line.startsWith("#") || line.isEmpty()) {
					lineNumber++;
					continue;
				}
				// the string tokenizer is used to also support the expression
				// format used by FeatureHouse
				StringTokenizer tokenizer = new StringTokenizer(line);
				LinkedList<String> hiddenFeatures = new LinkedList<String>();
				while (tokenizer.hasMoreTokens()) {
					String name = tokenizer.nextToken();
					Feature feature = configuration.getFeatureModel()
							.getFeature(name);
					if (feature != null && feature.isHidden()) {
						hiddenFeatures.add(name);
					} else {
						try {
							configuration.setManual(name, Selection.SELECTED);
						} catch (FeatureNotFoundException e) {
							successful = false;
							warnings.add("Feature " + name
									+ " does not exist anymore");
							positions.add(lineNumber);
						} catch (SelectionNotPossibleException e) {
							successful = false;
							warnings.add("Feature " + name
									+ " cannot be selected anymore");
							positions.add(lineNumber);
						}
					}
					lineNumber++;
				}
				for (String name : hiddenFeatures) {
					try {
						configuration.setManual(name, Selection.SELECTED);
					} catch (FeatureNotFoundException e) {
						successful = false;
						warnings.add("Feature " + name
								+ " does not exist anymore");
						positions.add(lineNumber);
					} catch (SelectionNotPossibleException e) {
						successful = false;
						warnings.add("Feature " + name
								+ " cannot be selected anymore");
						positions.add(lineNumber);
					}
					lineNumber++;
				}
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return successful;
	}

	public List<String> getWarnings() {
		return Collections.unmodifiableList(warnings);
	}

	public List<Integer> getPositions() {
		return Collections.unmodifiableList(positions);
	}

}
