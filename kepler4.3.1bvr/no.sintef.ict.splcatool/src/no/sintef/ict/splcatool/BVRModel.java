package no.sintef.ict.splcatool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.prop4j.Node;
import org.prop4j.NodeReader;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.ConfigurableUnit;
import bvr.MultiplicityInterval;
import bvr.OpaqueConstraint;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.BvrFactory;
import bvr.BvrPackage;
import bvr.Constraint;
import de.ovgu.featureide.fm.core.Feature;
import de.ovgu.featureide.fm.core.FeatureModel;
import de.ovgu.featureide.fm.core.io.UnsupportedModelException;

public class CVLModel {
	private ConfigurableUnit cu;
	
	private final static String utf8Encoding = "UTF-8"; 

	public CVLModel(){
		BvrPackage.eINSTANCE.eClass();
		BvrFactory factory = BvrFactory.eINSTANCE;
		cu = factory.createConfigurableUnit();
		cu.setName("Configurable Unit 1");
	}

	public CVLModel(File f) {
		cu = loadFromFile(f);
	}
	
	public CVLModel(String bvrFileName, boolean isPlatform) {
		cu = (!isPlatform) ?  loadFromFile(new File(bvrFileName)) : loadFromPlatformFile(bvrFileName);
	}

	public CVLModel(ConfigurableUnit cu) {
		this.cu = cu;
	}

	public CVLModel(String bvrfile) {
		this(new File(bvrfile));
	}
	
	private ConfigurableUnit loadFromFile(File file){
		BvrPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(URI.createFileURI(file.getAbsolutePath()), true);
		return (ConfigurableUnit) resource.getContents().get(0);
	}
	
	private ConfigurableUnit loadFromPlatformFile(String bvrFileName){
		BvrPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		URI uri = URI.createPlatformResourceURI(bvrFileName, true);
		Resource resource = resSet.getResource(uri, true);
		return (ConfigurableUnit) resource.getContents().get(0);
	}
	
	public void writeToPlatformFile(String filename) throws IOException {
		//filename should be of in the form /<project>/<folders0..N>/filename
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
	    ResourceSet resSet = new ResourceSetImpl();
	    URI uri = URI.createPlatformResourceURI(filename, true);
	    Resource resource = resSet.createResource(uri);
	    resource.getContents().add(cu);
	    
	    Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMIResource.OPTION_ENCODING, utf8Encoding);
	    resource.save(options);
	}

	public void writeToFile(String filename) throws IOException {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
	    ResourceSet resSet = new ResourceSetImpl();
	    URI uri = URI.createFileURI(filename);
	    Resource resource = resSet.createResource(uri);
	    resource.getContents().add(cu);
	    
	    Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMIResource.OPTION_ENCODING, utf8Encoding);
	    resource.save(options);
	}

	public ConfigurableUnit getCU() {
		return cu;
	}

	public GUIDSL getGUIDSL() throws IOException, UnsupportedModelException {
		FeatureModel fm = new FeatureModel();
		Feature root = recursiveConvert(fm, (Choice)cu.getOwnedVSpec().get(0)); // This is an assumption
		fm.setRoot(root);
		
		// Add constraints
		//System.out.println(fm.getFeatureNames());
		for(Constraint c : cu.getOwnedConstraint()){
			OpaqueConstraint oc = (OpaqueConstraint)c;
			NodeReader nr = new NodeReader();
			Node n = nr.stringToNode(oc.getConstraint(), new ArrayList<String>(fm.getFeatureNames()));
			fm.addPropositionalNode(n);
			//System.out.println(n.toString(NodeWriter.textualSymbols));
			//System.out.println(oc.getConstraint() + " became " + NodeWriter.nodeToString(n));
		}
		
		// Store
		GUIDSL gd = new GUIDSL(fm);
		
//		gd.writeToFile("temp.m");
		//String s = new FileUtility().readFileAsString("temp.m");
		//System.out.println(".m file: {\n" + s + "\n}");
		
//		gd = new GUIDSL("temp.m");
//		System.out.println(fm.getFeatureNames());
	
		return gd;
	}

	private Feature recursiveConvert(FeatureModel fm, Choice vs) throws UnsupportedModelException {
		Feature f = new Feature(fm);
		f.setName(vs.getName());
		fm.addFeature(f);
		
		// Add children
		for(VSpec vc : vs.getChild()){
			Choice c = (Choice)vc;
			Feature fc = recursiveConvert(fm, c);
			fc.setMandatory(c.isIsImpliedByParent());
			f.addChild(fc);
		}
		
		// Set group
		if(vs.getGroupMultiplicity() != null){
			MultiplicityInterval gm = vs.getGroupMultiplicity();
			if(gm.getLower()==1 && gm.getUpper()==1){
				f.setAlternative();
			}else if(gm.getLower()==1 && gm.getUpper()==-1){
				f.setOr();
			}else{
				throw new UnsupportedModelException("Group multiplicity not supported: [" + gm.getLower() + ".." + gm.getUpper() + "]", 0);
			}
		}else{
			f.setAnd();
		}
		
		return f;
	}

	public void injectConfigurations(GraphMLFM gfm) {
		Element e = gfm.graph;
		
		//System.out.println(e);
		
		List<Map<String, Boolean>> confs = new ArrayList<Map<String, Boolean>>();
		
		for(int i = 0; i < e.getChildNodes().getLength(); i++){
			org.w3c.dom.Node x = e.getChildNodes().item(i);
			if(!x.getNodeName().equals("node")) continue;
			String id = x.getAttributes().getNamedItem("id").getTextContent();
			String label = getLabel(e, id);
			
			String fname = label.split("=")[0];
			boolean fa = new Boolean(label.split("=")[1]);
			int nr = new Integer(id.substring(id.lastIndexOf('_')+1, id.length()));
			
			// done
			//System.out.println(fname + "["+nr+"]" + " = " + fa);
			
			// add
			while(confs.size()<=nr)
				confs.add(new HashMap<String, Boolean>());
			
			confs.get(nr).put(fname, fa);
		}
		
		for(Map<String, Boolean> conf : confs){
			ChoiceResolutuion cr = recursivelyResolve(conf, (Choice)cu.getOwnedVSpec().get(0));
			cu.getOwnedVSpecResolution().add(cr);
		}
	}
	
	private ChoiceResolutuion recursivelyResolve(Map<String, Boolean> conf, Choice choice) {
		// Add node
		ChoiceResolutuion cr = BvrFactory.eINSTANCE.createChoiceResolutuion();
		cr.setResolvedVSpec(choice);
		cr.setDecision(conf.get(choice.getName()));
		
		// Add children
		for(VSpec x : choice.getChild()){
			ChoiceResolutuion crc = recursivelyResolve(conf, (Choice) x);
			cr.getChild().add(crc);
		}
		
		// Done
		return cr;
	}

	private org.w3c.dom.Node getXMLNode(Element graph, String id){
		org.w3c.dom.Node element = null;
		
		for(int i = 0; i < graph.getChildNodes().getLength(); i++){
			org.w3c.dom.Node x = graph.getChildNodes().item(i);
			if(!x.getNodeName().equals("node")) continue;
			//System.out.println(x.getAttributes().getNamedItem("id").getNodeValue());
			if(x.getAttributes().getNamedItem("id").getNodeValue().equals(id))
				element = x;
		}
		return element;
	}
	
	private String getLabel(Element graph, String id) {
		org.w3c.dom.Node element = getXMLNode(graph, id);
		
		NodeList nl = graph.getElementsByTagName("y:NodeLabel");
		
		String name = null;
		for(int i = 0; i < nl.getLength(); i++){
			org.w3c.dom.Node n = nl.item(i);
			org.w3c.dom.Node p = n.getParentNode().getParentNode().getParentNode();
			if(p == element){
				name =  n.getTextContent().trim();
			}
		}
		
		return name;
	}

	public CoveringArray getCoveringArray() throws CVLException, CSVException {
		//System.out.println("--------------------------------");
		
		//System.out.println(cu.getOwnedVSpecResolution().size());
		
		// Read in
		List<Map<String, Boolean>> prods = new ArrayList<Map<String,Boolean>>();
		for(VSpecResolution c : cu.getOwnedVSpecResolution()){
			Map<String, Boolean> as = new HashMap<String, Boolean>();
			if(!(c instanceof ChoiceResolutuion)){
				throw new CVLException(c.getName() + " is not a choice resolution. Only choices supported in this mode.");
			}
			as.putAll(recurse((ChoiceResolutuion)c));
			//System.out.println(as);
			prods.add(as);
		}
		
		// Get features
		Set<String> fs = new HashSet<String>();
		for(Map<String, Boolean> p : prods){
			fs.addAll(p.keySet());		
		}
		//System.out.println(fs);
		
		// Convert
		//System.out.println(prods);
		//System.out.println("Size: " + (prods.size()+1) + ", " + (prods.get(0).size() + 1));
		String csv[][] = new String[prods.size()+1][prods.get(0).size() + 1];
		csv[0][0] = "Feature\\Product";
		for(int i = 0; i < prods.size(); i++){
			csv[i+1][0] = "" + (i+1);
		}
		
		{
		int i = 0;
		for(String f : fs){
			csv[0][i+1] = f;
			int j = 0;
			for(Map<String, Boolean> p : prods){
				csv[j+1][i+1] = p.get(f)?"X":"-"; 
				j++;
			}
			i++;
		}
		}
		
		// Print
		String csvString = "";
		for(int i = 0; i < csv[0].length; i++){
			for(int j = 0; j < csv.length; j++){
				csvString += csv[j][i] + ";";
			}
			csvString += "\n";
		}
		
		//System.out.println(csvString);
		
		CoveringArray ca = new CoveringArrayFile(csvString);
		return ca;
	}

	private Map<String, Boolean> recurse(ChoiceResolutuion x) throws CVLException {
		Map<String, Boolean> as = new HashMap<String, Boolean>();
		
		as.put(x.getResolvedVSpec().getName(), x.isDecision());
		
		for(VSpecResolution c : x.getChild()){
			if(!(c instanceof ChoiceResolutuion)){
				throw new CVLException(c.getName() + " is not a choice resolution. Only choices supported in this mode.");
			}
			as.putAll(recurse((ChoiceResolutuion)c));
		}
		
		return as;
	}
}
