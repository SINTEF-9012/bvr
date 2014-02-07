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
package de.ovgu.featureide.fm.core.io.waterloo;

import java.io.StringWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.prop4j.NodeWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import de.ovgu.featureide.fm.core.FMCorePlugin;
import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.core.io.AbstractFeatureModelWriter;


/**
 * Prints feature models in the Waterloo format.
 * 
 * @author Fabian Wielgorz
 */
public class WaterlooWriter extends AbstractFeatureModelWriter {
	
	/**
	 * Creates a new writer and sets the feature model to write out.
	 * 
	 * @param featureModel the structure to write
	 */
	public WaterlooWriter(FeatureModel featureModel) {
		setFeatureModel(featureModel);
	}
	
	//@Override
	public String writeToString() {
		//Create Empty DOM Document
    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        dbf.setIgnoringComments(true);
        dbf.setIgnoringElementContentWhitespace(false);
		dbf.setCoalescing(false);
		dbf.setExpandEntityReferences(false);
		DocumentBuilder db = null;
		try {
		    db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException pce) {
		    FMCorePlugin.getDefault().logError(pce);
		}
		Document doc = db.newDocument();
		//Create the Xml Representation
		createXmlDoc(doc);
		
		//Transform the Xml Representation into a String
		Transformer transfo = null;
		try {
			transfo = TransformerFactory.newInstance().newTransformer();
		} catch (TransformerConfigurationException e) {
			FMCorePlugin.getDefault().logError(e);
		} catch (TransformerFactoryConfigurationError e) {
			FMCorePlugin.getDefault().logError(e);
		}
		transfo.setOutputProperty(OutputKeys.METHOD, "xml");
		transfo.setOutputProperty(OutputKeys.INDENT, "yes");
		transfo.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		StreamResult result = new StreamResult(new StringWriter());
		DOMSource source = new DOMSource(doc);
		try {
			transfo.transform(source, result);
		} catch (TransformerException e) {
			FMCorePlugin.getDefault().logError(e);
		}
		return result.getWriter().toString();
	}
	
	/**
     * Creates the DOM Document Representation from the feature model fmodel
     * by using createXmlDocRec
     * @param doc Document where the feature model is put
     */
    private void createXmlDoc(Document doc) {
    	Element elem = doc.createElement("feature_model");
        elem.setAttribute("name", "FeatureIDE model");
        doc.appendChild(elem);
        Node featTree = doc.createElement("feature_tree");
        elem.appendChild(featTree);
        featTree.appendChild(doc.createTextNode("\n"));
        createXmlDocRec(doc, featTree, featureModel.getRoot(), false, "");
        createPropositionalConstraints(doc, elem);
    }
	
    
    /**
     * Creates the DOM Document Representation from the feature model fmodel
     * by recursively building the Nodes
     * @param doc Document where the feature model is put
     * @param nod Current Node in the Document Tree
     * @param feat Current Feature in the feature model Tree
     * @param andMode true if the connection between the current feature and 
     * its parent is of the type "and", false otherwise
     * @param indent indentation of the parent feature
     */
    private void createXmlDocRec(Document doc, Node nod, Feature feat, 
    		Boolean andMode, String indent) {
    	String newIndent;
    	Node textNode;
    	LinkedList<Feature> children;
    	Boolean nextAndMode = false;
    	if (feat == null) return;
    	String fName = feat.getName();
    	if (feat.isRoot()) {
    		textNode = doc.createTextNode(":r " + fName + "(" + fName + ")\n");
    		newIndent = "\t";
    	} else if (andMode) {
    		if (feat.isMandatory()) {
        		textNode = doc.createTextNode(indent + ":m " + fName + "(" + 
        									  fName + ")\n") ;
        	} else {
        		textNode = doc.createTextNode(indent + ":o " + fName + "(" + 
        									  fName + ")\n") ;
        	}
    	} else {
    		textNode = doc.createTextNode(indent + ": " + fName + "(" + 
    									  fName + ")\n");
    	}
    	nod.appendChild(textNode);
    	children = feat.getChildren();
    	if (children.isEmpty()) return;
    	if (feat.isAnd()) {
    		nextAndMode = true;
    		newIndent = indent + "\t";
    	} else if (feat.isOr()) {
    		textNode = doc.createTextNode(indent + "\t:g [1,*]\n");
    		nod.appendChild(textNode);
    		newIndent = indent + "\t\t";
    		nextAndMode = false;
    	} else if (feat.isAlternative()) {
    		textNode = doc.createTextNode(indent + "\t:g [1,1]\n");
    		nod.appendChild(textNode);
    		newIndent = indent + "\t\t";
    		nextAndMode = false;
    	} else throw new IllegalStateException ("Can't determine " +
				"Connectiontype of Rootfeature");
    	
    	Iterator<Feature> i = children.iterator();
    	while (i.hasNext()) {
    		createXmlDocRec(doc, nod , i.next(), nextAndMode, newIndent);
    	}
    }
    
    /**
     * Inserts the tags concerning propositional constraints into the DOM 
     * document representation
     * @param doc
     * @param FeatMod Parent node for the propositonal nodes
     */
    private void createPropositionalConstraints(Document doc, Node FeatMod) {
    	if (featureModel.getPropositionalNodes().isEmpty())
			return;
    	Node propConstr = doc.createElement("constraints");
    	Node newNode; 
		FeatMod.appendChild(propConstr);
		newNode = doc.createTextNode("\n");
		propConstr.appendChild(newNode);
		int i = 1;
		for (org.prop4j.Node node : featureModel.getPropositionalNodes()) {
			String[] symbols =  new String[] {"~", " and ", " or ", 
					" imp ", " biimp ", ", ", "choose", "atleast", "atmost"};
			String nodeString = NodeWriter.nodeToString(node, symbols, true);
			if ((nodeString.startsWith("(")) && (nodeString.endsWith(")"))) {
				nodeString = nodeString.substring(1, nodeString.length() - 1);
			}
			nodeString = addBrackets(nodeString);
			newNode = doc.createTextNode("C" + i + ":" + nodeString + "\n");			
			propConstr.appendChild(newNode);
			i++;
		}
	}
    
    /**
     * Adding Brackets around negated Literals
     * @param original String describing propositional constraint
     * @return
     */
    private String addBrackets (String original) {
    	return original; // MFJ Hack: Do not do this
/*    	StringBuffer result = new StringBuffer();
    	String newLine = original.replace("(", " ( ");
		newLine = newLine.replace(")", " ) ");
		newLine = newLine.replace("~", " ~ ");
    	Scanner scan = new Scanner(newLine);		
		while (scan.hasNext()) {
			String token = scan.next();
			if ((token.equals("~")) && scan.hasNext()) {
				String token2 = scan.next();
				if (!token2.equals("(")) {
					result.append("( ~");
					result.append(token2);
					result.append(" )");
				} else {
					result.append("( ~(");					
				}
			} else {
				result.append(token);
			}
			result.append(" ");
		}
		scan.close();
    	return result.toString();
    	*/
    }
    
}
