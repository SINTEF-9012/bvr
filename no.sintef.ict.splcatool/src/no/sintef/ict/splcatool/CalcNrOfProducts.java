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

import splar.core.fm.FeatureModelException;
import splar.plugins.reasoners.bdd.javabdd.BDDExceededBuildingTimeException;

public class CalcNrOfProducts {

	/**
	 * @param args
	 * @throws FeatureModelException 
	 * @throws BDDExceededBuildingTimeException 
	 */
	public static void main(String[] args) throws FeatureModelException, BDDExceededBuildingTimeException {
		String file = "..\\INWCA\\TestData\\Processed\\Realistic\\Eshop-fm.xml";
		SXFM fm = new SXFM(file);
		double nr = fm.getNrOfProducts();
		System.out.println(nr);
	}

}
