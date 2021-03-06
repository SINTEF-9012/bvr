package no.sintef.ict.splcatool;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.TopologicalOrderIterator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import bvr.Choice;
import bvr.CompoundNode;
import bvr.MultiplicityInterval;
import bvr.OpaqueConstraint;
import bvr.VClassifier;
import bvr.VSpec;
import bvr.VNode;
import bvr.BvrFactory;
import bvr.impl.BvrPackageImpl;
import de.ovgu.featureide.fm.core.Feature;

public class GraphMLFM {
	private Document doc;
	private Schema schema;
	Element graph;
	Element root;
	
	public GraphMLFM() throws ParserConfigurationException, SAXException{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
		URL schemaLocation = GraphMLFM.class.getResource("/schema/graphml.xsd");
		schema = factory.newSchema(schemaLocation);
		docFactory.setSchema(schema);
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// root elements
		doc = docBuilder.newDocument();
		root = doc.createElementNS("http://graphml.graphdrawing.org/xmlns", "graphml");
		
		// xmlns="http://graphml.graphdrawing.org/xmlns"
		// xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		root.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
		// xmlns:y="http://www.yworks.com/xml/graphml"
		root.setAttribute("xmlns:y", "http://www.yworks.com/xml/graphml");
		// xmlns:yed="http://www.yworks.com/xml/yed/3"
		root.setAttribute("xmlns:yed", "http://www.yworks.com/xml/yed/3");
		// xsi:schemaLocation="http://graphml.graphdrawing.org/xmlns http://www.yworks.com/xml/schema/graphml/1.1/ygraphml.xsd"
		root.setAttribute("xsi:schemaLocation", "http://graphml.graphdrawing.org/xmlns http://www.yworks.com/xml/schema/graphml/1.1/ygraphml.xsd");
		
		doc.appendChild(root);
		
		Element key = doc.createElementNS("http://graphml.graphdrawing.org/xmlns", "key");
		key.setAttribute("for", "node");
		key.setAttribute("id", "d6");
		key.setAttribute("yfiles.type", "nodegraphics");
		root.appendChild(key);
		
		Element key2 = doc.createElementNS("http://graphml.graphdrawing.org/xmlns", "key");
		key2.setAttribute("for", "edge");
		key2.setAttribute("id", "d10");
		key2.setAttribute("yfiles.type", "edgegraphics");
		root.appendChild(key2);
		
		graph = doc.createElementNS("http://graphml.graphdrawing.org/xmlns", "graph");
		graph.setAttribute("edgedefault", "directed");
		root.appendChild(graph);
	}

	public GraphMLFM(String file) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		doc = docBuilder.parse (new File(file));
		root = doc.getDocumentElement();
		for(int i = 0; i < root.getChildNodes().getLength(); i++){
			org.w3c.dom.Node x = root.getChildNodes().item(i);
			//System.out.println(x.getNodeName());
			if(x.getNodeName().equals("graph"))
				graph = (Element) x;
		}
	}

	public void writeToFile(String filename) throws TransformerException, SAXException, IOException {
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(filename));
		
		// validate
		//validator.validate(source); // TODO: Make it work. Maybe load file anew?
 
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);
 
		transformer.transform(source, result);
 
		//System.out.println("File saved!");	
	}
	
	public void addNode(String name) {
		addNode(name, name);
	}

	public void addNode(String name, String label) {
		Element node = doc.createElementNS("http://graphml.graphdrawing.org/xmlns", "node");
		node.setAttribute("id", name);
		graph.appendChild(node);
		Element data = doc.createElementNS("http://graphml.graphdrawing.org/xmlns", "data");
		data.setAttribute("key", "d6"); // TODO: What is d6?
		node.appendChild(data);
		
		// Shape
		Element shapenode = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:ShapeNode");
		data.appendChild(shapenode);
		
		Element shape = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:Shape");
		shape.setAttribute("type", "roundrectangle");
		shapenode.appendChild(shape);
		
		Element geo = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:Geometry");
		geo.setAttribute("height", "30.0");
		geo.setAttribute("width", "127.0");
		shapenode.appendChild(geo);
		
		Element fill = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:Fill");
		fill.setAttribute("color", "#FFFFFF");
		fill.setAttribute("transparent", "false");
		shapenode.appendChild(fill);
		
		Element border = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:BorderStyle");
		border.setAttribute("color", "#000000");
		border.setAttribute("type", "line");
		border.setAttribute("width", "1.0");
		shapenode.appendChild(border);
		
		Element nodelabel = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:NodeLabel");
		nodelabel.setAttribute("alignment", "center");
		nodelabel.setAttribute("autoSizePolicy", "content");
		nodelabel.setAttribute("fontFamily", "Dialog");
		nodelabel.setAttribute("fontSize", "12");
		nodelabel.setAttribute("fontStyle", "plain");
		nodelabel.setAttribute("hasBackgroundColor", "false");
		nodelabel.setAttribute("hasLineColor", "false");
		nodelabel.setAttribute("height", "18.701171875");
		nodelabel.setAttribute("modelName", "custom");
		nodelabel.setAttribute("textColor", "#000000");
		nodelabel.setAttribute("visible", "true");
		nodelabel.setTextContent(label);
		shapenode.appendChild(nodelabel);
	}
	
	private int edgecount = 0;

	public void addEdge(String source, String target, boolean mandatory) {
		edgecount++;
		
		Element edge = doc.createElementNS("http://graphml.graphdrawing.org/xmlns", "edge");
		edge.setAttribute("id", "e"+edgecount);
		edge.setAttribute("source", source);
		edge.setAttribute("target", target);
		graph.appendChild(edge);
		
		Element data = doc.createElementNS("http://graphml.graphdrawing.org/xmlns", "data");
		data.setAttribute("key", "d10"); // TODO: What is d10?
		edge.appendChild(data);
		
		Element polylineedge = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:PolyLineEdge");
		data.appendChild(polylineedge);
		
		Element lineStyle = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:LineStyle");
		lineStyle.setAttribute("color", "#000000");
		if(mandatory){
			lineStyle.setAttribute("type", "line");
		}else{
			lineStyle.setAttribute("type", "dashed");
		}
		lineStyle.setAttribute("width", "1.0");
		polylineedge.appendChild(lineStyle);
		
		Element arrows = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:Arrows");
		arrows.setAttribute("source", "none");
		arrows.setAttribute("target", "none");
		polylineedge.appendChild(arrows);
	}
	
	private int nodenr = 0;

	public String addOrGroup(Feature source) {
		{
			nodenr++;
			
			Element node = doc.createElementNS("http://graphml.graphdrawing.org/xmlns", "node");
			node.setAttribute("id", "n" + nodenr);
			graph.appendChild(node);
			Element data = doc.createElementNS("http://graphml.graphdrawing.org/xmlns", "data");
			data.setAttribute("key", "d6"); // TODO: What is d6?
			node.appendChild(data);
			
			// Shape
			Element shapenode = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:ShapeNode");
			data.appendChild(shapenode);
			
			Element shape = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:Shape");
			shape.setAttribute("type", "triangle");
			shapenode.appendChild(shape);
			
			Element geo = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:Geometry");
			geo.setAttribute("height", "25.0");
			geo.setAttribute("width", "30.0");
			shapenode.appendChild(geo);
			
			Element fill = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:Fill");
			fill.setAttribute("color", "#FFFFFF");
			fill.setAttribute("transparent", "false");
			shapenode.appendChild(fill);
			
			Element border = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:BorderStyle");
			border.setAttribute("color", "#000000");
			border.setAttribute("type", "line");
			border.setAttribute("width", "1.0");
			shapenode.appendChild(border);
			
			Element nodelabel = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:NodeLabel");
			nodelabel.setAttribute("alignment", "center");
			nodelabel.setAttribute("autoSizePolicy", "content");
			nodelabel.setAttribute("fontFamily", "Dialog");
			nodelabel.setAttribute("fontSize", "12");
			nodelabel.setAttribute("fontStyle", "plain");
			nodelabel.setAttribute("hasBackgroundColor", "false");
			nodelabel.setAttribute("hasLineColor", "false");
			nodelabel.setAttribute("height", "18.701171875");
			nodelabel.setAttribute("modelName", "custom");
			nodelabel.setAttribute("textColor", "#000000");
			nodelabel.setAttribute("visible", "true");
			nodelabel.setAttribute("modelName", "sides");
			nodelabel.setAttribute("modelPosition", "e");
			nodelabel.setTextContent("1..*");
			shapenode.appendChild(nodelabel);
		}
		
		// Add edge
		{
			edgecount++;
			
			Element edge = doc.createElementNS("http://graphml.graphdrawing.org/xmlns", "edge");
			edge.setAttribute("id", "e"+edgecount);
			edge.setAttribute("source", source.getName());
			edge.setAttribute("target", "n" + nodenr);
			graph.appendChild(edge);
			
			Element data = doc.createElementNS("http://graphml.graphdrawing.org/xmlns", "data");
			data.setAttribute("key", "d10"); // TODO: What is d10?
			edge.appendChild(data);
			
			Element polylineedge = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:PolyLineEdge");
			data.appendChild(polylineedge);
			
			Element lineStyle = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:LineStyle");
			lineStyle.setAttribute("color", "#000000");
			lineStyle.setAttribute("type", "line");
			lineStyle.setAttribute("width", "1.0");
			polylineedge.appendChild(lineStyle);
			
			Element arrows = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:Arrows");
			arrows.setAttribute("source", "none");
			arrows.setAttribute("target", "none");
			polylineedge.appendChild(arrows);
		}
		
		return "n" + nodenr;
	}

	public String addAltGroup(Feature source) {
		{
			nodenr++;
			
			Element node = doc.createElementNS("http://graphml.graphdrawing.org/xmlns", "node");
			node.setAttribute("id", "n" + nodenr);
			graph.appendChild(node);
			Element data = doc.createElementNS("http://graphml.graphdrawing.org/xmlns", "data");
			data.setAttribute("key", "d6"); // TODO: What is d6?
			node.appendChild(data);
			
			// Shape
			Element shapenode = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:ShapeNode");
			data.appendChild(shapenode);
			
			Element shape = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:Shape");
			shape.setAttribute("type", "triangle");
			shapenode.appendChild(shape);
			
			Element geo = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:Geometry");
			geo.setAttribute("height", "25.0");
			geo.setAttribute("width", "30.0");
			shapenode.appendChild(geo);
			
			Element fill = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:Fill");
			fill.setAttribute("color", "#FFFFFF");
			fill.setAttribute("transparent", "false");
			shapenode.appendChild(fill);
			
			Element border = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:BorderStyle");
			border.setAttribute("color", "#000000");
			border.setAttribute("type", "line");
			border.setAttribute("width", "1.0");
			shapenode.appendChild(border);
			
			Element nodelabel = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:NodeLabel");
			nodelabel.setAttribute("alignment", "center");
			nodelabel.setAttribute("autoSizePolicy", "content");
			nodelabel.setAttribute("fontFamily", "Dialog");
			nodelabel.setAttribute("fontSize", "12");
			nodelabel.setAttribute("fontStyle", "plain");
			nodelabel.setAttribute("hasBackgroundColor", "false");
			nodelabel.setAttribute("hasLineColor", "false");
			nodelabel.setAttribute("height", "18.701171875");
			nodelabel.setAttribute("modelName", "custom");
			nodelabel.setAttribute("textColor", "#000000");
			nodelabel.setAttribute("visible", "true");
			nodelabel.setAttribute("modelName", "sides");
			nodelabel.setAttribute("modelPosition", "e");
			nodelabel.setTextContent("1..1");
			shapenode.appendChild(nodelabel);
		}
		
		// Add edge
		{
			edgecount++;
			
			Element edge = doc.createElementNS("http://graphml.graphdrawing.org/xmlns", "edge");
			edge.setAttribute("id", "e"+edgecount);
			edge.setAttribute("source", source.getName());
			edge.setAttribute("target", "n" + nodenr);
			graph.appendChild(edge);
			
			Element data = doc.createElementNS("http://graphml.graphdrawing.org/xmlns", "data");
			data.setAttribute("key", "d10"); // TODO: What is d10?
			edge.appendChild(data);
			
			Element polylineedge = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:PolyLineEdge");
			data.appendChild(polylineedge);
			
			Element lineStyle = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:LineStyle");
			lineStyle.setAttribute("color", "#000000");
			lineStyle.setAttribute("type", "line");
			lineStyle.setAttribute("width", "1.0");
			polylineedge.appendChild(lineStyle);
			
			Element arrows = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:Arrows");
			arrows.setAttribute("source", "none");
			arrows.setAttribute("target", "none");
			polylineedge.appendChild(arrows);
		}
		
		return "n" + nodenr;
	}
	
	private int ccount = 0; 

	public void addConstraint(String constraint) {
		ccount++;
		
		Element node = doc.createElementNS("http://graphml.graphdrawing.org/xmlns", "node");
		node.setAttribute("id", "c" + ccount);
		graph.appendChild(node);
		Element data = doc.createElementNS("http://graphml.graphdrawing.org/xmlns", "data");
		data.setAttribute("key", "d6"); // TODO: What is d6?
		node.appendChild(data);
		
		// Shape
		Element shapenode = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:ShapeNode");
		data.appendChild(shapenode);
		
		Element shape = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:Shape");
		shape.setAttribute("type", "parallelogram");
		shapenode.appendChild(shape);
		
		Element geo = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:Geometry");
		geo.setAttribute("height", "30.0");
		geo.setAttribute("width", "127.0");
		shapenode.appendChild(geo);
		
		Element fill = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:Fill");
		fill.setAttribute("color", "#FFFFFF");
		fill.setAttribute("transparent", "false");
		shapenode.appendChild(fill);
		
		Element border = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:BorderStyle");
		border.setAttribute("color", "#000000");
		border.setAttribute("type", "line");
		border.setAttribute("width", "1.0");
		shapenode.appendChild(border);
		
		Element nodelabel = doc.createElementNS("http://www.yworks.com/xml/graphml", "y:NodeLabel");
		nodelabel.setAttribute("alignment", "center");
		nodelabel.setAttribute("autoSizePolicy", "content");
		nodelabel.setAttribute("fontFamily", "Dialog");
		nodelabel.setAttribute("fontSize", "12");
		nodelabel.setAttribute("fontStyle", "plain");
		nodelabel.setAttribute("hasBackgroundColor", "false");
		nodelabel.setAttribute("hasLineColor", "false");
		nodelabel.setAttribute("height", "18.701171875");
		nodelabel.setAttribute("modelName", "custom");
		nodelabel.setAttribute("textColor", "#000000");
		nodelabel.setAttribute("visible", "true");
		nodelabel.setTextContent(constraint);
		shapenode.appendChild(nodelabel);
	}
	
	SPLCABVRModel bvr;
	Map<String, Boolean> mandatories = new HashMap<String, Boolean>();

	public SPLCABVRModel getBVRModel() {
		// Make empty BVR model
		BvrPackageImpl.init();
		bvr.BVRModel bvrModel = BvrFactory.eINSTANCE.createBVRModel();
		bvr = new SPLCABVRModel(bvrModel);
		
		// Make graph
		DirectedGraph<String, DefaultEdge> g = new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
		
		if(graph == null){
			for(int i = 0; i < doc.getChildNodes().item(0).getChildNodes().getLength(); i++){
				Node x = doc.getChildNodes().item(0).getChildNodes().item(i);
				//System.out.println(x.getNodeName());
				if(x.getNodeName().equals("graph")){
					graph = (Element) x;
				}
			}
		}
		
		for(int i = 0; i < graph.getChildNodes().getLength(); i++){
			Node x = graph.getChildNodes().item(i);
			if(x.getNodeName().equals("node")){
				String nodeName = x.getAttributes().getNamedItem("id").getTextContent();
				//System.out.println(nodeName);
				g.addVertex(nodeName);
			}
		}
		
		for(int i = 0; i < graph.getChildNodes().getLength(); i++){
			Node x = graph.getChildNodes().item(i);
			if(x.getNodeName().equals("edge")){
				String srcName = x.getAttributes().getNamedItem("source").getTextContent();
				String targetName = x.getAttributes().getNamedItem("target").getTextContent();
				
				//System.out.println(srcName + " -> " + targetName);
								
				if(!mandatories.containsKey(srcName)) mandatories.put(srcName, true);
				if(!mandatories.containsKey(targetName)) mandatories.put(targetName, true);
				boolean mandatory = true;
				String type = "";
				try{
					type = x.getFirstChild().getFirstChild().getFirstChild().getAttributes().getNamedItem("type").getTextContent();
				}catch(NullPointerException ne){
				}
				if(type.equals("")){
					try{
						type = x.getFirstChild().getNextSibling().getFirstChild().getFirstChild().getAttributes().getNamedItem("type").getTextContent();
					}catch(NullPointerException ne){
					}
				}
				if(type.equals("dashed")){
					mandatory = false;
				}
				mandatories.put(targetName, mandatory);
				
				//g.addVertex(x.getAttributes().getNamedItem("source").getTextContent());
			}
		}
		
		// Iterate
		TopologicalOrderIterator<String, DefaultEdge> ti = new TopologicalOrderIterator<String, DefaultEdge>(g);
		String root = ti.next();
		bvrModel.setName(root);
		
		CompoundNode vs = traverse(g, root);
		//cu.getOwnedVSpec().add(vs);
		bvrModel.setVariabilityModel(vs);
		
		// Do global constraints
		Set<String> done = mandatories.keySet();
		for(int i = 0; i < graph.getChildNodes().getLength(); i++){
			Node x = graph.getChildNodes().item(i);
			String id = "";
			try{
				id = x.getAttributes().getNamedItem("id").getTextContent();
			}catch(NullPointerException ne){
				continue;
			}
			if(!done.contains(id)){
				if(x.getNodeName().equals("edge")) continue;
				//System.out.println(id);
				
				OpaqueConstraint e = BvrFactory.eINSTANCE.createOpaqueConstraint();
				e.setConstraint(getLabel(id));
				//cu.getOwnedConstraint().add(e);
				vs.getOwnedConstraint().add(e);
			}
		}
		
		// Return
		return bvr;
	}
	
	CompoundNode traverse(DirectedGraph<String, DefaultEdge> g, String root){
		return traverse(g, root, 0);
	}
	
	Map<String, CompoundNode> idmap = new HashMap<String, CompoundNode>();
	
	CompoundNode traverse(DirectedGraph<String, DefaultEdge> g, String root, int level){
		// Print
/*		for(int i = 0; i < level; i++)
			System.out.print("\t");
*/
		// Identify
		String tag = getTag(root);
		
		// Create
		CompoundNode v = null;
		//System.out.println(tag);
		if(tag.equals("roundrectangle")){
			Choice c = BvrFactory.eINSTANCE.createChoice();
			idmap.put(root, c);
			c.setName(getLabel(root));
			c.setIsImpliedByParent(mandatories.get(root));
			v = c;
		}else if(tag.equals("rectangle")){
			VClassifier c = BvrFactory.eINSTANCE.createVClassifier();
			idmap.put(root, c);
			String mstr = getMultiplicity(root);
			c.setName(getLabel(root).replace("[" + mstr + "]", ""));
			v = c;
		}else if(tag.equals("parallelogram")){
			OpaqueConstraint c =  BvrFactory.eINSTANCE.createOpaqueConstraint();
			String l = getLabel(root);
			c.setConstraint(l);
			for(DefaultEdge e : g.edgesOf(root)){
				if(!g.getEdgeTarget(e).equals(root)) continue;
				//System.out.println("Constrain of " + g.getEdgeSource(e));
				//c.setContext(idmap.get(g.getEdgeSource(e)));
				CompoundNode vSpec = idmap.get(g.getEdgeSource(e));
				((VNode) vSpec).getOwnedConstraint().add(c);
				
			}

			//bvr.getCU().getOwnedConstraint().add(c);
		}else if(tag.equals("UMLClassNode")){
			v = (CompoundNode) BvrFactory.eINSTANCE.createVClassifier();
			idmap.put(root, v);
			String mstr = getMultiplicity(root);
			((VSpec) v).setName(getLabel(root).replace("[" + mstr + "]", ""));
		}else{
			throw new UnsupportedOperationException("Unsupported type: " + tag);
		}
		
		// Recurse
		if(tag.equals("roundrectangle")){
			Choice c = (Choice) v;
			restartloop: for(;;){
				for(DefaultEdge e : g.edgesOf(root)){
					if(g.getEdgeTarget(e).equals(root)) continue;
					
					String childtag = getTag(g.getEdgeTarget(e));
					if(childtag.equals("triangle")){
						String mstr = getMultiplicity(g.getEdgeTarget(e)).trim();
						setGroupMultiplicity(c, mstr);
						
						// restart
						root = g.getEdgeTarget(e);
						continue restartloop;
					}else{
						CompoundNode child = traverse(g, g.getEdgeTarget(e), level+1);
						if(child != null) // TODO fix, should not be necessary
							//c.getChild().add(child);
							c.getMember().add(child);
					}
				}
				break;
			}
		}else if(tag.equals("rectangle")){
			VClassifier c = (VClassifier) v;
			String mstr = getMultiplicity(root);
			setInstanceMultiplicity(c, mstr);
			restartloop: for(;;){
				for(DefaultEdge e : g.edgesOf(root)){
					if(g.getEdgeTarget(e).equals(root)) continue;
					
					String childtag = getTag(g.getEdgeTarget(e));
					if(childtag.equals("triangle")){
						mstr = getMultiplicity(g.getEdgeTarget(e)).trim();
						setGroupMultiplicity(c, mstr);
						
						// restart
						root = g.getEdgeTarget(e);
						continue restartloop;
					}else{
						CompoundNode child = traverse(g, g.getEdgeTarget(e), level+1);
						if(child != null) // TODO fix, should not be necessary
							c.getMember().add(child);
					}
				}
				break;
			}
		}else if(tag.equals("parallelogram")){
			// TODO
		}else if(tag.equals("UMLClassNode")){
			VClassifier c = (VClassifier) v;
			String mstr = getMultiplicity(root);
			setInstanceMultiplicity(c, mstr);
			restartloop: for(;;){
				for(DefaultEdge e : g.edgesOf(root)){
					if(g.getEdgeTarget(e).equals(root)) continue;
					
					String childtag = getTag(g.getEdgeTarget(e));
					if(childtag.equals("triangle")){
						mstr = getMultiplicity(g.getEdgeTarget(e)).trim();
						setGroupMultiplicity(c, mstr);
						
						// restart
						root = g.getEdgeTarget(e);
						continue restartloop;
					}else{
						CompoundNode child = traverse(g, g.getEdgeTarget(e), level+1);
						if(child != null) // TODO fix, should not be necessary
							c.getMember().add(child);
					}
				}
				break;
			}
		}else{
			throw new UnsupportedOperationException("Unsupported type: " + tag);
		}
		
		// Return
		return v;
	}

	private void setInstanceMultiplicity(VClassifier c, String mstr) {
		String lstr = mstr.split("\\.\\.")[0];
		String ustr = mstr.split("\\.\\.")[1];
		int li = -1;
		if(!lstr.equals("*")) li = Integer.parseInt(lstr);
		int ui = -1;
		if(!ustr.equals("*")) ui = Integer.parseInt(ustr);
		MultiplicityInterval mi = BvrFactory.eINSTANCE.createMultiplicityInterval();
		mi.setLower(li);
		mi.setUpper(ui);
		c.setInstanceMultiplicity(mi);
	}

	private void setGroupMultiplicity(VSpec c, String mstr) {
		String lstr = mstr.split("\\.\\.")[0];
		String ustr = mstr.split("\\.\\.")[1];
		int li = -1;
		if(!lstr.equals("*")) li = Integer.parseInt(lstr);
		int ui = -1;
		if(!ustr.equals("*")) ui = Integer.parseInt(ustr);
		MultiplicityInterval mi = BvrFactory.eINSTANCE.createMultiplicityInterval();
		mi.setLower(li);
		mi.setUpper(ui);
		((VNode) c).setGroupMultiplicity(mi);
	}

	private String getLabel(String id) {
		Node element = getXMLNode(graph, id);
		
		NodeList nl = graph.getElementsByTagName("y:NodeLabel");
		
		String name = null;
		for(int i = 0; i < nl.getLength(); i++){
			Node n = nl.item(i);
			Node p = n.getParentNode().getParentNode().getParentNode();
			if(p == element){
				name =  n.getTextContent().trim();
			}
		}
		
		return name;
	}
	
	private Node getXMLNode(Element graph, String id){
		Node element = null;
		
		for(int i = 0; i < graph.getChildNodes().getLength(); i++){
			Node x = graph.getChildNodes().item(i);
			if(!x.getNodeName().equals("node")) continue;
			//System.out.println(x.getAttributes().getNamedItem("id").getNodeValue());
			if(x.getAttributes().getNamedItem("id").getNodeValue().equals(id))
				element = x;
		}
		return element;
	}

	private String getTag(String root) {
		Node element = getXMLNode(graph, root);

		String tag = null;
		if(element != null){
			tag = element.getNodeName();
			//try{
				Node node = element.getChildNodes().item(0);
				if(node.getNodeName().equals("#text")){
					node = element.getChildNodes().item(1);
				}
				//System.out.println("trying: " + node);
				for(int i = 0; i < element.getChildNodes().getLength(); i++){
					Node n = element.getChildNodes().item(i);
					if(n.getNodeName().equals("data")){
						//System.out.println(n.getNodeName() + ", " + n.getAttributes().getNamedItem("key").getNodeValue());
					}
					if(n.getNodeName().equals("data") && n.getAttributes().getNamedItem("key").getNodeValue().equals("d6"))
						node = n;
				}
				
				//System.out.println("reached: " + node);

				Node node2 = node.getChildNodes().item(0);
				if(node2.getNodeName().equals("#text")){
					node2 = node.getChildNodes().item(1);
				}
				node = node2;
				
				//System.out.println(node.getNodeName());
				if(node.getNodeName().equals("y:UMLClassNode")){
					//shape = node;
					tag = "UMLClassNode";
					return tag;
				}
				
				//System.out.println(element.getChildNodes().item(1));
				Node shape = null;
				for(int i = 0; i < node.getChildNodes().getLength(); i++){
					Node n = node.getChildNodes().item(i);
					if(n.getNodeName().equals("y:Shape")){
						shape = n;
						//System.out.println(n.getNodeName());
						tag = shape.getAttributes().getNamedItem("type").getNodeValue();
					}
				}
			/*}catch(NullPointerException ne){
				System.out.println(ne);
			}*/
		}
		return tag;
	}
	
	private String getMultiplicity(String id) {
		String m = getLabel(id);
		if(m.contains("[")){
			m = m.split("\\[")[1].trim();
			m = m.replace("]", "").trim();
		}
		//System.out.println(m);
		return m;
	}
}
