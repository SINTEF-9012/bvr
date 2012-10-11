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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.prop4j.Node;
import org.xml.sax.SAXException;

import de.ovgu.featureide.fm.core.Constraint;
import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.core.io.UnsupportedModelException;
import de.ovgu.featureide.fm.core.io.guidsl.GuidslReader;
import de.ovgu.featureide.fm.core.io.guidsl.GuidslWriter;
import de.ovgu.featureide.fm.core.io.waterloo.WaterlooWriter;
import splar.core.fm.FeatureModelException;

public class GUIDSL {
	private FeatureModel fma;
	private String orgFileName;
	
/*	public GUIDSL(String model) throws UnsupportedModelException {
		fma = new de.ovgu.featureide.fm.core.FeatureModel();
		GuidslReader fmr = new GuidslReader(fma);
        fmr.readFromString(model);
	}
*/
	public GUIDSL(File file) throws UnsupportedModelException, IOException {
		fma = new de.ovgu.featureide.fm.core.FeatureModel();
		GuidslReader fmr = new GuidslReader(fma);
		InputStream inputStream = new FileInputStream(file);
        fmr.parseInputStream(inputStream);
        inputStream.close();
        this.orgFileName = file.getAbsoluteFile().toString();
	}

	public GUIDSL(FeatureModel fma) {
		this.fma = fma;
	}

	public void writeToFile(String fileName) throws IOException {
		GuidslWriter ww = new GuidslWriter(fma);
		String guidslString = ww.writeToString();
		FileOutputStream fos = new FileOutputStream(fileName);
		OutputStreamWriter out = new OutputStreamWriter(fos);
		out.write(guidslString);
		out.close();
		fos.close();
	}

	@Override
	public boolean equals(Object fmo) {
		FeatureModel fmb = ((GUIDSL) fmo).fma;
		
		if(!fma.getFeatureNames().containsAll(fmb.getFeatureNames()))
			return false;
		if(!fmb.getFeatureNames().containsAll(fma.getFeatureNames()))
			return false;
		if(fma.getConstraintCount() != fmb.getConstraintCount())
			return false;
		if(fma.countConcreteFeatures() != fmb.countConcreteFeatures())
			return false;
		if(fma.countTerminalFeatures() != fmb.countTerminalFeatures())
			return false;
		if(!fmb.getAnnotations().containsAll(fma.getAnnotations()))
			return false;
/* TODO There are bugs in the comment handling
		if(!fmb.getComments().containsAll(fm.getComments()))
			return false;
*/
		if(!fma.getPropositionalNodes().containsAll(fmb.getPropositionalNodes()))
			return false;
		if(!fmb.getPropositionalNodes().containsAll(fma.getPropositionalNodes()))
			return false;
		if(!fma.getRoot().getName().equals(fmb.getRoot().getName()))
			return false;
		if(fma.getFeatures().containsAll(fmb.getFeatures()))
			return false;
		// TODO Not complete
		
		return true;
	}

	public SXFM getSXFM() throws FeatureModelException{
		FeatureModel fma_clone = fma.clone();
		
		/* convert constraints to CNF clauses */{
			List<Node> ln_u = fma_clone.getPropositionalNodes();
			List<Node> ln = new ArrayList<Node>();
			// - Clone list
			for(Node n : ln_u)
				ln.add(n.clone());
			// - Remove all propositional constraints
			for(Node n : ln)
				fma_clone.removePropositionalNode(n);
			
			// - Add them back as CNF nodes
			for(Node n : ln){
				Node cnf = n.toCNF();
				if(cnf.getChildren() == null){
					fma_clone.addPropositionalNode(cnf);
				}else
					for(Node x : cnf.getChildren()){ 
						fma_clone.addPropositionalNode(x);
					}
			}
		}
		
		// Convert
		SXFM sxfm = null;
		try {
			WaterlooWriter ww = new WaterlooWriter(fma_clone);
			String sxfm_str = ww.writeToString();
			
			/* bug: if there is not constraints, add an empty field */if(sxfm_str.indexOf("<constraints>")==-1){
				sxfm_str = sxfm_str.replace("</feature_model>", "<constraints>\n</constraints>\n</feature_model>");
			}
			
			File temp = File.createTempFile("tempfile", "data");
			FileOutputStream fos = new FileOutputStream(temp);
			OutputStreamWriter out = new OutputStreamWriter(fos);
			out.write(sxfm_str);
			out.close();
			fos.close();
			sxfm = new SXFM(temp.getAbsolutePath(), orgFileName);
		} catch (IOException e) {
		}
		return sxfm;
	}

	public GraphMLFM getGraphMLFM() throws ParserConfigurationException, SAXException {
		GraphMLFM g = new GraphMLFM();
		
		for(Feature f : fma.getFeatures()){
			g.addNode(f.getName());
		}
		
		for(Feature source : fma.getFeatures()){
			String sourcename = source.getName();
			Boolean override = null;
			
/*			if(source.isOr()) System.out.println(source.getName() + " has OR");
			if(source.isAlternative()) System.out.println(source.getName() + " has ALTERNATIVE");
			if(source.isAnd()) System.out.println(source.getName() + " has AND");
*/
			if(source.isOr()){
				sourcename = g.addOrGroup(source);
				override = false;
			}
			
			if(source.isAlternative()){
				sourcename = g.addAltGroup(source);
				override = false;
			}
			
			for(Feature target : source.getChildren()){
				boolean mandatory = target.isMandatory();
				if(override != null)
					mandatory = override;
				g.addEdge(sourcename, target.getName(), mandatory);
			}
		}
		
		for(Node c : fma.getPropositionalNodes()){
			g.addConstraint(c.toString());
		}
		
		return g;
	}

}
