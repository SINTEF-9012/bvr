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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.naming.OperationNotSupportedException;

import de.ovgu.featureide.fm.core.io.UnsupportedModelException;
import de.ovgu.featureide.fm.core.io.waterloo.WaterlooReader;

import splar.core.constraints.PropositionalFormula;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureModelException;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.XMLFeatureModel;
import splar.core.heuristics.RandomVariableOrderingHeuristic;
import splar.core.heuristics.VariableOrderingHeuristic;
import splar.plugins.reasoners.bdd.javabdd.BDDExceededBuildingTimeException;
import splar.plugins.reasoners.bdd.javabdd.FMReasoningWithBDD;

public class SXFM {
	FeatureModel fm;
	private String fileName;

	public SXFM(String fileName) throws FeatureModelException {
		this(fileName, fileName);
	}

	public SXFM(String absolutePath, String orgFileName) throws FeatureModelException {
		this.fileName = orgFileName;
		fm = new XMLFeatureModel(absolutePath, XMLFeatureModel.USE_VARIABLE_NAME_AS_ID);
		fm.loadModel();
		// bug: have to add root as mandatory
		try{
			PropositionalFormula pr = new PropositionalFormula("needroot", fm.getRoot().getID());
			fm.addConstraint(pr);
		}catch(Exception e){
			throw new FeatureModelException("Unable to mark root as mandatory");
		}
	}

	public void writeToFile(String fileName) throws IOException {
		// bug: Have to redirect out
		PrintStream out = System.out;
		ByteArrayOutputStream fos = new ByteArrayOutputStream();
    	PrintStream ps = new PrintStream(fos);
    	System.setOut(ps);
		fm.dumpXML();
		System.setOut(out);
		String xml = new String(fos.toByteArray());
		fos.close();
		ps.close();
		
		// bug: have to remove parenthesis
		String constrOrg = xml.substring(xml.indexOf("<constraints>"));
		String constr = new String(constrOrg);
		constr = constr.replaceAll("\\(", "");
		constr = constr.replaceAll("\\)", "");
		xml = xml.replace(constrOrg, constr);
		//System.out.println(xml);
		
		new FileUtility().writeStringToFile(fileName, xml);
		
	}

	@Override
	public boolean equals(Object fmo) {
		FeatureModel fmb = ((SXFM)fmo).fm;
		
		if(fm.getAverageDepth() != fmb.getAverageDepth())
			return false;
		if(fm.countConstraints() != fmb.countConstraints())
			return false;
		if(fm.countConstraintsVariables() != fmb.countConstraintsVariables())
			return false;
		if(fm.countFeatures() != fmb.countFeatures())
			return false;
		if(fm.countNodes() != fmb.countNodes())
			return false;
		if(fm.depth() != fmb.depth())
			return false;
//		if(fm.FM2CNF().getClauseDensity() != fmb.FM2CNF().getClauseDensity())
//			return false;
		// Not complete
		
		return true;
	}

	public GUIDSL getGUIDSL() throws UnsupportedModelException{
		// bug: Have to redirect out
		PrintStream out = System.out;
		ByteArrayOutputStream fos = new ByteArrayOutputStream();
    	PrintStream ps = new PrintStream(fos);
    	System.setOut(ps);
		fm.dumpXML();
		System.setOut(out);
		String xml = new String(fos.toByteArray());
		try {
			fos.close();
		} catch (IOException e) {
		}
		ps.close();
		
		de.ovgu.featureide.fm.core.FeatureModel m = new de.ovgu.featureide.fm.core.FeatureModel();
		WaterlooReader wr = new WaterlooReader(m);
		xml = xml.substring(0, xml.indexOf("<meta>")) + xml.substring(xml.indexOf("<feature_tree>"));
		//System.out.println(xml);
		wr.readFromString(xml);
		
		return new GUIDSL(m);
	}

	public CNF getCNF() {
		return new CNF(fm.FM2CNF(), fileName);
	}

	public int getFeatures() {
		return fm.countFeatures();
	}

	public FeatureTreeNode getNodeByID(String nodeName) {
		return fm.getNodeByID(nodeName);
	}

	public void removeConstraints() {
		fm.removeAllConstraints();
	}
	
	private long timeout = 1000;
	public void setTimeout(long timeout){
		this.timeout = timeout;
	}

	public double getNrOfProducts() throws BDDExceededBuildingTimeException {
		int bddNodeNum = 10000, bddCacheSize = 10000;
		VariableOrderingHeuristic voh = new RandomVariableOrderingHeuristic("voh");
		FMReasoningWithBDD fmr = new FMReasoningWithBDD(fm, voh, bddNodeNum, bddCacheSize, timeout, "pre-order");
		try {
			fmr.init();
		} catch (Exception e) {
		}
		double solutions = -1;
		try {
			solutions = fmr.countValidConfigurations();
		} catch (OperationNotSupportedException e) {
			e.printStackTrace();
		} catch (NullPointerException npe){
			npe.printStackTrace();
		}
		return solutions;
	}
}
