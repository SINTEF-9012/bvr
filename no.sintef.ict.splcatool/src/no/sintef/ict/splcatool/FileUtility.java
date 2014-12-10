/*******************************************************************************
 * Copyright (c) 2011, 2012 SINTEF, Martin F. Johansen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SINTEF, Martin F. Johansen - the implementation
 *******************************************************************************/

package no.sintef.ict.splcatool;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {
	public String readFileAsString(String filePath) throws java.io.IOException {
		StringBuffer fileData = new StringBuffer(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
		reader.close();
		return fileData.toString();
	}

	public List<String> traverseDirCollectFiles(String rootDir) {
		List<String> files = new ArrayList<String>();
		traverseDirCollectFilesR(files, rootDir);
		return files;
	}

	private void traverseDirCollectFilesR(List<String> files, String rootDir) {
		File[] tfiles = new File(rootDir).listFiles();
		for (File f : tfiles) {
			if (f.isFile())
				files.add(f.getAbsolutePath());
			else if (f.isDirectory())
				traverseDirCollectFilesR(files, f.getAbsolutePath());
		}
	}

	public void writeStringToFile(String filename, String fileContents) throws FileNotFoundException, IOException {
		File aFile = new File(filename);

		OutputStream fout= new FileOutputStream(aFile);
        OutputStream bout= new BufferedOutputStream(fout);
        OutputStreamWriter out = new OutputStreamWriter(bout, "UTF8");
		
		try {
			out.write(fileContents);
		} finally {
			out.close();
			bout.close();
			fout.close();
		}
	}
}
