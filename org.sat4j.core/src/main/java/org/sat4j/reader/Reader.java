/*******************************************************************************
 * SAT4J: a SATisfiability library for Java Copyright (C) 2004-2008 Daniel Le Berre
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU Lesser General Public License Version 2.1 or later (the
 * "LGPL"), in which case the provisions of the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of the LGPL, and not to allow others to use your version of
 * this file under the terms of the EPL, indicate your decision by deleting
 * the provisions above and replace them with the notice and other provisions
 * required by the LGPL. If you do not delete the provisions above, a recipient
 * may use your version of this file under the terms of the EPL or the LGPL.
 * 
 * Based on the original MiniSat specification from:
 * 
 * An extensible SAT solver. Niklas Een and Niklas Sorensson. Proceedings of the
 * Sixth International Conference on Theory and Applications of Satisfiability
 * Testing, LNCS 2919, pp 502-518, 2003.
 *
 * See www.minisat.se for the original solver in C++.
 * 
 *******************************************************************************/
package org.sat4j.reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.zip.GZIPInputStream;

import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IProblem;

/**
 * A reader is responsible to feed an ISolver from a text file and to convert
 * the model found by the solver to a textual representation.
 * 
 * @author leberre
 */
public abstract class Reader {

	/**
	 * This is the usual method to feed a solver with a benchmark.
	 * 
	 * @param filename
	 *            the fully qualified name of the benchmark. The filename
	 *            extension may by used to detect which type of benchmarks it is
	 *            (SAT, OPB, MAXSAT, etc).
	 * @return the problem to solve (an ISolver in fact).
	 * @throws FileNotFoundException
	 *             if the file cannot be found.
	 * @throws ParseFormatException
	 *             if an error occurs during parsing.
	 * @throws IOException
	 *             if an I/O error occurs.
	 * @throws ContradictionException
	 *             if the problem is found trivially inconsistent.
	 */
	public IProblem parseInstance(final String filename)
			throws FileNotFoundException, ParseFormatException, IOException,
			ContradictionException {
		InputStream in = null;
		try {
			if (filename.startsWith("http://")) {
				in = (new URL(filename)).openStream();
			} else {
				in = new FileInputStream(filename);
			}
			if (filename.endsWith(".gz")) {
				in = new GZIPInputStream(in);
			}
			IProblem problem;
			problem = parseInstance(in);
			return problem;
		} catch (FileNotFoundException e) {
			throw e;
		} catch (ParseFormatException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} catch (ContradictionException e) {
			throw e;
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

	/**
	 * Read a file from a stream.
	 * 
	 * It is important to note that benchmarks are usually encoded in ASCII, not
	 * UTF8. As such, the only reasonable way to feed a solver from a stream is
	 * to use a stream.
	 * 
	 * @param in
	 *            a stream containing the benchmark.
	 * @return the problem to solve (an ISolver in fact).
	 * @throws ParseFormatException
	 *             if an error occurs during parsing.
	 * @throws IOException
	 *             if an I/O error occurs.
	 * @throws ContradictionException
	 *             if the problem is found trivially inconsistent.
	 */
	public abstract IProblem parseInstance(final InputStream in)
			throws ParseFormatException, ContradictionException, IOException;

	/**
	 * Read a file from a reader.
	 * 
	 * Do not use that method, it is no longer supported.
	 * 
	 * @param in
	 *            a stream containing the benchmark.
	 * @return the problem to solve (an ISolver in fact).
	 * @throws ParseFormatException
	 *             if an error occurs during parsing.
	 * @throws IOException
	 *             if an I/O error occurs.
	 * @throws ContradictionException
	 *             if the problem is found trivially inconsistent.
	 * @see #parseInstance(InputStream)
	 */
	@Deprecated
	public IProblem parseInstance(java.io.Reader in)
			throws ParseFormatException, ContradictionException, IOException {
		throw new UnsupportedOperationException(
				"Use #parseInstance(InputStream) instead");
	}

	/**
	 * Produce a model using the reader format.
	 * 
	 * @param model
	 *            a model using the Dimacs format.
	 * @return a human readable view of the model.
	 */
	@Deprecated
	public abstract String decode(int[] model);

	/**
	 * Produce a model using the reader format on a provided printwriter.
	 * 
	 * @param model
	 *            a model using the Dimacs format.
	 * @param out
	 *            the place where to display the model
	 */
	public abstract void decode(int[] model, PrintWriter out);

	public boolean isVerbose() {
		return verbose;
	}

	public void setVerbosity(boolean b) {
		verbose = b;
	}

	private boolean verbose = false;
}
