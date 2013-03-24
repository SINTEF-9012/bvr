package no.sintef.cvl.engine.converters.rls;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import no.sintef.cvl.engine.converters.common.Utility;
import no.sintef.dsl.node.Node;
import no.sintef.dsl.node.nodePackage;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import cvl.BoundaryElementBinding;
import cvl.ConfigurableUnit;
import cvl.FragmentSubstitution;
import cvl.FromBinding;
import cvl.FromPlacement;
import cvl.FromReplacement;
import cvl.ObjectHandle;
import cvl.PlacementBoundaryElement;
import cvl.PlacementFragment;
import cvl.ReplacementBoundaryElement;
import cvl.ReplacementFragmentType;
import cvl.ToBinding;
import cvl.ToPlacement;
import cvl.ToReplacement;
import cvl.Variabletype;
import cvl.VariationPoint;
import cvl.cvlFactory;
import cvl.cvlPackage;

public class CloneModel {
	
	private File base;
	private File lib;
	private File cvlmodel;
	private int times;
	private ResourceSetImpl resSet;
	private File base_new;
	private File lib_new;
	private File cvlmodel_new;
	private String[] baseEls;
	private String[] libEls;
	private cvlFactory factory = cvlFactory.eINSTANCE;
	private String fs1_name;
	private String fs2_name;

	public CloneModel(File base, File lib, File cvlmodel, int times){
		this.base = base;
		String basic_base = base.getName().replaceAll(".node", "");
		String basic_lib = lib.getName().replaceAll(".node", "");
		String basic_cvl = cvlmodel.getName().replaceAll(".node", "");
		this.base_new = new File(basic_base + "_" + times + ".node");
		this.lib_new = new File(basic_lib + "_" + times + ".node");
		this.cvlmodel_new = new File(basic_cvl + "_" + times + ".cvl");
		this.lib = lib;
		this.cvlmodel = cvlmodel;
		this.times = times;
		String path = this.base.getAbsolutePath();
		path = path.replaceAll(this.base.getName(), "");
		System.setProperty( "user.dir", path);
		this.resSet = new ResourceSetImpl();
	}
	
	public CloneModel(File base, File lib, File cvlmodel, int times, String[] baseEls, String[] libEls){
		this.base = base;
		this.base_new = new File("base_" + times + ".node");
		this.lib_new = new File("lib_" + times + ".node");
		this.cvlmodel_new = new File("node_new_" + times + ".cvl");
		this.lib = lib;
		this.cvlmodel = cvlmodel;
		this.times = times;
		String path = this.base.getAbsolutePath();
		path = path.replaceAll(this.base.getName(), "");
		System.setProperty( "user.dir", path);
		this.resSet = new ResourceSetImpl();
		this.baseEls = baseEls;
		this.libEls = libEls;
	}
	
	public CloneModel(File base, File lib, File cvlmodel, int times, String fs1_name, String fs2_name){
		this.base = base;
		this.base_new = new File("base_" + times + ".node");
		this.lib_new = new File("lib_" + times + ".node");
		this.cvlmodel_new = new File("node_new_" + times + ".cvl");
		this.lib = lib;
		this.cvlmodel = cvlmodel;
		this.times = times;
		String path = this.base.getAbsolutePath();
		path = path.replaceAll(this.base.getName(), "");
		System.setProperty( "user.dir", path);
		this.resSet = new ResourceSetImpl();
		this.fs1_name = fs1_name;
		this.fs2_name = fs2_name;
	}

	public void run() throws IOException {
		nodePackage.eINSTANCE.eClass();
		cvlPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		
		Resource resourceBase = resSet.getResource(URI.createFileURI(this.base.getName()), true);
		Resource resourceLib = resSet.getResource(URI.createFileURI(this.lib.getName()), true);
		Resource resourceCvl = resSet.getResource(URI.createFileURI(this.cvlmodel.getName()), true);
		Node rootNodeBase = (Node) resourceBase.getContents().get(0);
		Node rootNodeLib = (Node) resourceLib.getContents().get(0);
		ConfigurableUnit cu = (ConfigurableUnit) resourceCvl.getContents().get(0);
		
		for(int i=0; i<this.times; i++){
			EList<Node> contentsBase = rootNodeBase.getContains();
			Copier baseCopier = new EcoreUtil.Copier();
			Collection<Node> contentsBaseCopy = baseCopier.copyAll(contentsBase);
			baseCopier.copyReferences();
			rootNodeBase.getContains().addAll(contentsBaseCopy);
			
			EList<Node> contentsLib = rootNodeLib.getContains();
			Copier libCopier = new EcoreUtil.Copier();
			Collection<Node> contentsLibCopy = libCopier.copyAll(contentsLib);
			libCopier.copyReferences();
			rootNodeLib.getContains().addAll(contentsLibCopy);
			
			EList<VariationPoint> varPoints = cu.getOwnedVariationPoint();
			EList<Variabletype> varType = cu.getOwnedVariabletype();
			Copier cvlCopier = new EcoreUtil.Copier();
			Collection<VariationPoint> varPointsCopy = cvlCopier.copyAll(varPoints);
			Collection<Variabletype> varTypeCopy = cvlCopier.copyAll(varType);
			cvlCopier.copyReferences();
			cu.getOwnedVariationPoint().addAll(varPointsCopy);
			cu.getOwnedVariabletype().addAll(varTypeCopy);
			
			for(VariationPoint vp : varPointsCopy){
				if(vp instanceof FragmentSubstitution){
					FragmentSubstitution fs = (FragmentSubstitution) vp;
					EList<ObjectHandle> ohs = fs.getSourceObject();
					for(ObjectHandle oh : ohs){
						EObject eObject = oh.getMOFRef();
						if(!(rootNodeLib.equals(eObject) || rootNodeBase.equals(eObject))){
							EObject eNewObject = (baseCopier.get(eObject) == null) ? libCopier.get(eObject) : baseCopier.get(eObject);
							if(eNewObject == null){
								System.out.println("WARNIGN!!!");
							}
							oh.setMOFRef(eNewObject);						
						}
					}
				}
			}			
		}
		
	    resourceBase.setURI(URI.createFileURI(this.base_new.getName()));
	    resourceBase.save(Collections.EMPTY_MAP);
	    
	    resourceLib.setURI(URI.createFileURI(this.lib_new.getName()));
	    resourceLib.save(Collections.EMPTY_MAP);
	    
	    resourceCvl.setURI(URI.createFileURI(this.cvlmodel_new.getName()));
	    resourceCvl.save(Collections.EMPTY_MAP);
	}
	
	public void dubllicateToBinding() throws IOException {
		this.base_new = new File("base_binding_" + times + ".node");
		this.lib_new = new File("lib_binding_" + times + ".node");
		this.cvlmodel_new = new File("node_new_binding_" + times + ".cvl");
		
		nodePackage.eINSTANCE.eClass();
		cvlPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		
		Resource resourceBase = resSet.getResource(URI.createFileURI(this.base.getName()), true);
		Resource resourceLib = resSet.getResource(URI.createFileURI(this.lib.getName()), true);
		Resource resourceCvl = resSet.getResource(URI.createFileURI(this.cvlmodel.getName()), true);
		Node rootNodeBase = (Node) resourceBase.getContents().get(0);
		Node rootNodeLib = (Node) resourceLib.getContents().get(0);
		ConfigurableUnit cu = (ConfigurableUnit) resourceCvl.getContents().get(0);
		
		EList<Node> baseContents = rootNodeBase.getContains();
		Copier copierBase = new EcoreUtil.Copier();
		Collection<Node> baseContentsCopy = copierBase.copyAll(baseContents);
		copierBase.copyReferences();
		
		EList<Node> libContents = rootNodeLib.getContains();
		Copier copierLib = new EcoreUtil.Copier();
		Collection<Node> libContentsCopy = copierLib.copyAll(libContents);
		copierLib.copyReferences();
		
		EList<VariationPoint> varPoints = cu.getOwnedVariationPoint();
		EList<FragmentSubstitution> fsList = new BasicEList<FragmentSubstitution>();
		for(VariationPoint vp : varPoints){
			if(vp instanceof FragmentSubstitution){
				fsList.add((FragmentSubstitution) vp);
				
				EList<ObjectHandle> ohs = ((FragmentSubstitution) vp).getSourceObject();
				for(ObjectHandle oh : ohs){
					Node eObject = (Node) oh.getMOFRef();
					if(!(rootNodeLib.equals(eObject) || rootNodeBase.equals(eObject))){
						EObject eNewObject = (copierBase.get(eObject) == null) ? copierLib.get(eObject) : copierBase.get(eObject);
						if(eNewObject == null){
							System.out.println("WARNIGN!!!");
						}
						oh.setMOFRef(eNewObject);						
					}
				}
			}
		}
		
		rootNodeBase.getContains().clear();
		rootNodeBase.getContains().addAll(baseContentsCopy);
		
		rootNodeLib.getContains().clear();
		rootNodeLib.getContains().addAll(libContentsCopy);
		
		for(FragmentSubstitution fs : fsList){
			this.copyToBinding(fs, rootNodeBase, rootNodeLib, times);
		}
		
	    resourceBase.setURI(URI.createFileURI(this.base_new.getName()));
	    resourceBase.save(Collections.EMPTY_MAP);
	    
	    resourceLib.setURI(URI.createFileURI(this.lib_new.getName()));
	    resourceLib.save(Collections.EMPTY_MAP);
	    
	    resourceCvl.setURI(URI.createFileURI(this.cvlmodel_new.getName()));
	    resourceCvl.save(Collections.EMPTY_MAP);		
	}
	
	private void copyToBinding(FragmentSubstitution fs, Node rootNodeBase, Node rootNodeLib, int times){
		EList<BoundaryElementBinding> bindings = fs.getBoundaryElementBinding();
		EList<ToBinding> toBindings = new BasicEList<ToBinding>();
		for(BoundaryElementBinding binding : bindings){
			if(binding instanceof ToBinding){
				toBindings.add((ToBinding) binding);
			}
		}
		
		ToBinding toBindingCont = null;
		for(ToBinding toBinding : toBindings){
			String name = toBinding.getToPlacement().getPropertyName();
			if(name.equals("contains")){
				toBindingCont = toBinding;
				break;
			}
		}
		ToBinding toBindingLink = null;
		for(ToBinding toBinding : toBindings){
			String name = toBinding.getToPlacement().getPropertyName();
			if(!name.equals("contains")){
				toBindingLink = toBinding;
				break;
			}
		}
		if(toBindingLink == null || toBindingCont == null){
			System.out.println("!!!Bad bad...");
			return;
		}
		
		for(int i=0; i<times; i++){
			Copier bindingCopier = new EcoreUtil.Copier();
			ToBinding toBindingCopy = (ToBinding) bindingCopier.copy(toBindingLink);
			bindingCopier.copyReferences();
			fs.getBoundaryElementBinding().add(toBindingCopy);
			
			ToPlacement toPlacement = toBindingCopy.getToPlacement();
			Copier placementCopier = new EcoreUtil.Copier();
			ToPlacement toPlacementCopy = (ToPlacement) placementCopier.copy(toPlacement);
			placementCopier.copyReferences();
			fs.getPlacement().getPlacementBoundaryElement().add(toPlacementCopy);
			toBindingCopy.setToPlacement(toPlacementCopy);
			
			EList<EObject> insideBElmnts = Utility.resolveProxies(toPlacementCopy.getInsideBoundaryElement());
			Copier insideBElmntsCopier = new EcoreUtil.Copier();
			Collection<EObject> insideBElmntsCopy = insideBElmntsCopier.copyAll(insideBElmnts);
			insideBElmntsCopier.copyReferences();
			rootNodeBase.getContains().addAll((Collection<? extends Node>) insideBElmntsCopy);
			EList<ObjectHandle> objectHandlesCopy = this.createObjectHandles(insideBElmntsCopy);
			fs.getSourceObject().addAll(objectHandlesCopy);
			toPlacementCopy.getInsideBoundaryElement().clear();
			toPlacementCopy.getInsideBoundaryElement().addAll(objectHandlesCopy);
			toBindingCont.getToPlacement().getInsideBoundaryElement().addAll(objectHandlesCopy);
			
			EObject outsideBElemt = Utility.resolveProxies(toPlacementCopy.getOutsideBoundaryElement());
			Copier outsideBElmntsCopier = new EcoreUtil.Copier();
			EObject outsideBElemtCopy = outsideBElmntsCopier.copy(outsideBElemt);
			outsideBElmntsCopier.copyReferences();
			((Node) outsideBElemtCopy).getLinks().clear();
			((Node) outsideBElemtCopy).getLinks().addAll((Collection<? extends Node>) insideBElmntsCopy);
			rootNodeBase.getContains().add((Node) outsideBElemtCopy);
			ObjectHandle oh = factory.createObjectHandle();
			oh.setMOFRef(outsideBElemtCopy);
			fs.getSourceObject().add(oh);
			toPlacementCopy.setOutsideBoundaryElement(oh);
			
			
			ToReplacement toReplacement = toBindingCopy.getToReplacement();
			Copier replacementCopier = new EcoreUtil.Copier();
			ToReplacement toReplacementCopy = (ToReplacement) replacementCopier.copy(toReplacement);
			replacementCopier.copyReferences();
			fs.getReplacement().getReplacementBoundaryElement().add(toReplacementCopy);
			toBindingCopy.setToReplacement(toReplacementCopy);
			toReplacementCopy.setToPlacement(toPlacementCopy);
			toPlacementCopy.setToReplacement(toReplacementCopy);
			
			insideBElmnts = Utility.resolveProxies(toReplacementCopy.getInsideBoundaryElement());
			insideBElmntsCopier = new EcoreUtil.Copier();
			insideBElmntsCopy = insideBElmntsCopier.copyAll(insideBElmnts);
			insideBElmntsCopier.copyReferences();
			rootNodeLib.getContains().addAll((Collection<? extends Node>) insideBElmntsCopy);
			objectHandlesCopy = this.createObjectHandles(insideBElmntsCopy);
			fs.getSourceObject().addAll(objectHandlesCopy);
			toReplacementCopy.getInsideBoundaryElement().clear();
			toReplacementCopy.getInsideBoundaryElement().addAll(objectHandlesCopy);
			toBindingCont.getToReplacement().getInsideBoundaryElement().addAll(objectHandlesCopy);
			
			outsideBElemt = Utility.resolveProxies(toReplacementCopy.getOutsideBoundaryElement());
			outsideBElmntsCopier = new EcoreUtil.Copier();
			outsideBElemtCopy = outsideBElmntsCopier.copy(outsideBElemt);
			outsideBElmntsCopier.copyReferences();
			((Node) outsideBElemtCopy).getLinks().clear();
			((Node) outsideBElemtCopy).getLinks().addAll((Collection<? extends Node>) insideBElmntsCopy);
			rootNodeLib.getContains().add((Node) outsideBElemtCopy);
			oh = factory.createObjectHandle();
			oh.setMOFRef(outsideBElemtCopy);
			fs.getSourceObject().add(oh);
			toReplacementCopy.setOutsideBoundaryElement(oh);
		}
	}
	
	private EList<ObjectHandle> createObjectHandles(Collection<? extends EObject> eObjects){
		EList<ObjectHandle> ohs = new BasicEList<ObjectHandle>();
		for(EObject eObject : eObjects){
			ObjectHandle oh = factory.createObjectHandle();
			oh.setMOFRef(eObject);
			ohs.add(oh);
		}
		return ohs;
	}
	
	public void dublicate() throws IOException {
		this.base_new = new File("base_elem_" + times + ".node");
		this.lib_new = new File("lib_elem_" + times + ".node");
		this.cvlmodel_new = new File("node_new_elem_" + times + ".cvl");
		
		nodePackage.eINSTANCE.eClass();
		cvlPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		
		Resource resourceBase = resSet.getResource(URI.createFileURI(this.base.getName()), true);
		Resource resourceLib = resSet.getResource(URI.createFileURI(this.lib.getName()), true);
		Resource resourceCvl = resSet.getResource(URI.createFileURI(this.cvlmodel.getName()), true);
		Node rootNodeBase = (Node) resourceBase.getContents().get(0);
		Node rootNodeLib = (Node) resourceLib.getContents().get(0);
		ConfigurableUnit cu = (ConfigurableUnit) resourceCvl.getContents().get(0);
		
		EList<Node> baseContents = rootNodeBase.getContains();
		Copier copierBase = new EcoreUtil.Copier();
		Collection<Node> baseContentsCopy = copierBase.copyAll(baseContents);
		copierBase.copyReferences();
		
		EList<Node> libContents = rootNodeLib.getContains();
		Copier copierLib = new EcoreUtil.Copier();
		Collection<Node> libContentsCopy = copierLib.copyAll(libContents);
		copierLib.copyReferences();
		
		EList<VariationPoint> varPoints = cu.getOwnedVariationPoint();
		EList<FragmentSubstitution> fsList = new BasicEList<FragmentSubstitution>();
		for(VariationPoint vp : varPoints){
			if(vp instanceof FragmentSubstitution){
				fsList.add((FragmentSubstitution) vp);
				
				EList<ObjectHandle> ohs = ((FragmentSubstitution) vp).getSourceObject();
				for(ObjectHandle oh : ohs){
					Node eObject = (Node) oh.getMOFRef();
					if(!(rootNodeLib.equals(eObject) || rootNodeBase.equals(eObject))){
						EObject eNewObject = (copierBase.get(eObject) == null) ? copierLib.get(eObject) : copierBase.get(eObject);
						if(eNewObject == null){
							System.out.println("WARNIGN!!!");
						}
						oh.setMOFRef(eNewObject);						
					}
				}
			}
		}
		
		rootNodeBase.getContains().clear();
		rootNodeBase.getContains().addAll(baseContentsCopy);
		
		rootNodeLib.getContains().clear();
		rootNodeLib.getContains().addAll(libContentsCopy);
		
		for(FragmentSubstitution fs : fsList){
			this.dubElementsToPlacement(fs, fs.getPlacement(), baseEls, rootNodeBase, times);
			this.dubElementsToReplacement(fs, fs.getReplacement(), libEls, rootNodeLib, times);
		}
		
	    resourceBase.setURI(URI.createFileURI(this.base_new.getName()));
	    resourceBase.save(Collections.EMPTY_MAP);
	    
	    resourceLib.setURI(URI.createFileURI(this.lib_new.getName()));
	    resourceLib.save(Collections.EMPTY_MAP);
	    
	    resourceCvl.setURI(URI.createFileURI(this.cvlmodel_new.getName()));
	    resourceCvl.save(Collections.EMPTY_MAP);
	}
	
	private void dubElementsToPlacement(FragmentSubstitution fs, PlacementFragment pf, String[] elms, Node rootNodeBase, int times){
		EList<PlacementBoundaryElement> plBoundElments = pf.getPlacementBoundaryElement();
		EList<ToPlacement> toPlacements = new BasicEList<ToPlacement>();
		for(String name : elms){
			EObject node = null;
			for(PlacementBoundaryElement pbe : plBoundElments){
				if(pbe instanceof ToPlacement){
					EList<EObject> insideBElmts = Utility.resolveProxies(((ToPlacement) pbe).getInsideBoundaryElement());
					for(EObject eObject : insideBElmts){
						//we assume there is no element with the same name
						if(((Node) eObject).getName().equals(name)){
							toPlacements.add((ToPlacement) pbe);
							node = eObject;
							break;
						}
					}
				}
			}
			Copier copier = new EcoreUtil.Copier();
			EList<Node> copyList = new BasicEList<Node>();
			EList<ObjectHandle> ohList = new BasicEList<ObjectHandle>();
			if(node != null){
				for(int i=0; i<times; i++){
					Node copyEl = (Node) copier.copy(node);
					copier.copyReferences();
					copyList.add(copyEl);
					ObjectHandle oh = factory.createObjectHandle();
					oh.setMOFRef(copyEl);
					ohList.add(oh);
				}
				rootNodeBase.getContains().addAll(copyList);
				fs.getSourceObject().addAll(ohList);
				for(ToPlacement toPlacement : toPlacements){
					toPlacement.getInsideBoundaryElement().addAll(ohList);
				}
			}else{
				System.out.println("can not find element with name " + name);
			}
		}
	}
	
	private void dubElementsToReplacement(FragmentSubstitution fs, ReplacementFragmentType rf, String[] elms, Node rootNodeLib, int times){
		EList<ReplacementBoundaryElement> rplBoundElments = rf.getReplacementBoundaryElement();
		EList<ToReplacement> toReplacements = new BasicEList<ToReplacement>();
		for(String name : elms){
			EObject node = null;
			for(ReplacementBoundaryElement pbe : rplBoundElments){
				if(pbe instanceof ToReplacement){
					EList<EObject> insideBElmts = Utility.resolveProxies(((ToReplacement) pbe).getInsideBoundaryElement());
					for(EObject eObject : insideBElmts){
						//we assume there is no element with the same name
						if(((Node) eObject).getName().equals(name)){
							toReplacements.add((ToReplacement) pbe);
							node = eObject;
							break;
						}
					}
				}
			}
			Copier copier = new EcoreUtil.Copier();
			EList<Node> copyList = new BasicEList<Node>();
			EList<ObjectHandle> ohList = new BasicEList<ObjectHandle>();
			if(node != null){
				for(int i=0; i<times; i++){
					Node copyEl = (Node) copier.copy(node);
					copier.copyReferences();
					copyList.add(copyEl);
					ObjectHandle oh = factory.createObjectHandle();
					oh.setMOFRef(copyEl);
					ohList.add(oh);
				}
				rootNodeLib.getContains().addAll(copyList);
				fs.getSourceObject().addAll(ohList);
				for(ToReplacement toReplacement : toReplacements){
					toReplacement.getInsideBoundaryElement().addAll(ohList);
				}
			}else{
				System.out.println("replacement: can not find element with name " + name);
			}
		}
	}
	
	public void createAdjBindings() throws IOException{
		this.base_new = new File("base_adjbinding_" + times + ".node");
		this.lib_new = new File("lib_adjbinding_" + times + ".node");
		this.cvlmodel_new = new File("node_new_adjbinding_" + times + ".cvl");
		
		nodePackage.eINSTANCE.eClass();
		cvlPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		
		Resource resourceBase = resSet.getResource(URI.createFileURI(this.base.getName()), true);
		Resource resourceLib = resSet.getResource(URI.createFileURI(this.lib.getName()), true);
		Resource resourceCvl = resSet.getResource(URI.createFileURI(this.cvlmodel.getName()), true);
		Node rootNodeBase = (Node) resourceBase.getContents().get(0);
		Node rootNodeLib = (Node) resourceLib.getContents().get(0);
		ConfigurableUnit cu = (ConfigurableUnit) resourceCvl.getContents().get(0);
		
		FragmentSubstitution fs1 = null;
		FragmentSubstitution fs2 = null;
		EList<VariationPoint> varPoints = cu.getOwnedVariationPoint();
		for(VariationPoint varPoint : varPoints){
			if(varPoint instanceof FragmentSubstitution){
				if(((FragmentSubstitution) varPoint).getName().equals(fs1_name)){
					fs1 = (FragmentSubstitution) varPoint;
				}
				if(((FragmentSubstitution) varPoint).getName().equals(fs2_name)){
					fs2 = (FragmentSubstitution) varPoint;
				}
			}
		}
		
		if(fs1 == null || fs2 == null){
			System.out.println("WARNING: fs1 or fs2 is null");
			return;
		}
		
		EList<Node> baseContents = rootNodeBase.getContains();
		Copier copierBase = new EcoreUtil.Copier();
		Collection<Node> baseContentsCopy = copierBase.copyAll(baseContents);
		copierBase.copyReferences();
		
		EList<Node> libContents = rootNodeLib.getContains();
		Copier copierLib = new EcoreUtil.Copier();
		Collection<Node> libContentsCopy = copierLib.copyAll(libContents);
		copierLib.copyReferences();
		
		for(VariationPoint vp : varPoints){
			if(vp instanceof FragmentSubstitution){
				EList<ObjectHandle> ohs = ((FragmentSubstitution) vp).getSourceObject();
				for(ObjectHandle oh : ohs){
					Node eObject = (Node) oh.getMOFRef();
					if(!(rootNodeLib.equals(eObject) || rootNodeBase.equals(eObject))){
						EObject eNewObject = (copierBase.get(eObject) == null) ? copierLib.get(eObject) : copierBase.get(eObject);
						if(eNewObject == null){
							System.out.println("WARNIGN!!!");
						}
						oh.setMOFRef(eNewObject);						
					}
				}
			}
		}
		
		rootNodeBase.getContains().clear();
		rootNodeBase.getContains().addAll(baseContentsCopy);
		
		rootNodeLib.getContains().clear();
		rootNodeLib.getContains().addAll(libContentsCopy);
		
		
		this.dublicateAdjBinding(fs1, fs2, times, rootNodeBase, rootNodeLib);
		
	    resourceBase.setURI(URI.createFileURI(this.base_new.getName()));
	    resourceBase.save(Collections.EMPTY_MAP);
	    
	    resourceLib.setURI(URI.createFileURI(this.lib_new.getName()));
	    resourceLib.save(Collections.EMPTY_MAP);
	    
	    resourceCvl.setURI(URI.createFileURI(this.cvlmodel_new.getName()));
	    resourceCvl.save(Collections.EMPTY_MAP);
	}
	
	private void dublicateAdjBinding(FragmentSubstitution fs1, FragmentSubstitution fs2, int times, Node rootNodeBase, Node rootNodeLib){
		EList<BoundaryElementBinding> boundariesfs1 = fs1.getBoundaryElementBinding();
		ToBinding toBindingContfs1 = null;
		FromBinding fromBindingfs1 = null; 
		for(BoundaryElementBinding be : boundariesfs1){
			if(be instanceof ToBinding){
				ToBinding toBinding = (ToBinding) be;
				if(toBinding.getToPlacement().getPropertyName().equals("contains")){
					toBindingContfs1 = toBinding;
				}
			}
			if(be instanceof FromBinding){
				fromBindingfs1 = (FromBinding) be;
			}
		}
		
		if(fromBindingfs1 == null || toBindingContfs1 == null){
			System.out.println("WARNING! fromBindingfs1 or toBindingContfs1 is null");
			return;
		}
		
		EList<BoundaryElementBinding> boundariesfs2 = fs2.getBoundaryElementBinding();
		ToBinding toBindingContfs2 = null;
		ToBinding toBindingfs2 = null; 
		for(BoundaryElementBinding be : boundariesfs2){
			if(be instanceof ToBinding){
				ToBinding toBinding = (ToBinding) be;
				if(toBinding.getToPlacement().getPropertyName().equals("contains")){
					toBindingContfs2 = toBinding;
				} else {
					toBindingfs2 = toBinding;
				}
			}
		}
		
		if(toBindingfs2 == null || toBindingContfs2 == null){
			System.out.println("WARNING! toBindingfs2 or toBindingContfs2 is null");
			return;
		}
		
		for(int i=0; i<times; i++){
			Copier bindingCopier = new EcoreUtil.Copier();
			ToBinding toBindingCopy = (ToBinding) bindingCopier.copy(toBindingfs2);
			bindingCopier.copyReferences();
			fs2.getBoundaryElementBinding().add(toBindingCopy);
			
			ToPlacement toPlacement = toBindingCopy.getToPlacement();
			Copier placementCopier = new EcoreUtil.Copier();
			ToPlacement toPlacementCopy = (ToPlacement) placementCopier.copy(toPlacement);
			placementCopier.copyReferences();
			fs2.getPlacement().getPlacementBoundaryElement().add(toPlacementCopy);
			toBindingCopy.setToPlacement(toPlacementCopy);
			
			EList<EObject> insideBElmnts = Utility.resolveProxies(toPlacementCopy.getInsideBoundaryElement());
			Copier insideBElmntsCopier = new EcoreUtil.Copier();
			Collection<EObject> insideBElmntsCopy = insideBElmntsCopier.copyAll(insideBElmnts);
			insideBElmntsCopier.copyReferences();
			rootNodeBase.getContains().addAll((Collection<? extends Node>) insideBElmntsCopy);
			EList<ObjectHandle> objectHandlesCopyInside = this.createObjectHandles(insideBElmntsCopy);
			fs2.getSourceObject().addAll(objectHandlesCopyInside);
			toPlacementCopy.getInsideBoundaryElement().clear();
			toPlacementCopy.getInsideBoundaryElement().addAll(objectHandlesCopyInside);
			toBindingContfs2.getToPlacement().getInsideBoundaryElement().addAll(objectHandlesCopyInside);
			
			EObject outsideBElemt = Utility.resolveProxies(toPlacementCopy.getOutsideBoundaryElement());
			Copier outsideBElmntsCopier = new EcoreUtil.Copier();
			EObject outsideBElemtCopy = outsideBElmntsCopier.copy(outsideBElemt);
			outsideBElmntsCopier.copyReferences();
			((Node) outsideBElemtCopy).getLinks().clear();
			((Node) outsideBElemtCopy).getLinks().addAll((Collection<? extends Node>) insideBElmntsCopy);
			rootNodeBase.getContains().add((Node) outsideBElemtCopy);
			ObjectHandle ohOutside = factory.createObjectHandle();
			ohOutside.setMOFRef(outsideBElemtCopy);
			fs2.getSourceObject().add(ohOutside);
			toPlacementCopy.setOutsideBoundaryElement(ohOutside);
			
			ToReplacement toReplacement = toBindingCopy.getToReplacement();
			Copier replacementCopier = new EcoreUtil.Copier();
			ToReplacement toReplacementCopy = (ToReplacement) replacementCopier.copy(toReplacement);
			replacementCopier.copyReferences();
			fs2.getReplacement().getReplacementBoundaryElement().add(toReplacementCopy);
			toBindingCopy.setToReplacement(toReplacementCopy);
			toReplacementCopy.setToPlacement(toPlacementCopy);
			toPlacementCopy.setToReplacement(toReplacementCopy);
			
			insideBElmnts = Utility.resolveProxies(toReplacementCopy.getInsideBoundaryElement());
			insideBElmntsCopier = new EcoreUtil.Copier();
			insideBElmntsCopy = insideBElmntsCopier.copyAll(insideBElmnts);
			insideBElmntsCopier.copyReferences();
			rootNodeLib.getContains().addAll((Collection<? extends Node>) insideBElmntsCopy);
			EList<ObjectHandle> objectHandlesCopy = this.createObjectHandles(insideBElmntsCopy);
			fs2.getSourceObject().addAll(objectHandlesCopy);
			toReplacementCopy.getInsideBoundaryElement().clear();
			toReplacementCopy.getInsideBoundaryElement().addAll(objectHandlesCopy);
			toBindingContfs2.getToReplacement().getInsideBoundaryElement().addAll(objectHandlesCopy);
			
			outsideBElemt = Utility.resolveProxies(toReplacementCopy.getOutsideBoundaryElement());
			outsideBElmntsCopier = new EcoreUtil.Copier();
			outsideBElemtCopy = outsideBElmntsCopier.copy(outsideBElemt);
			outsideBElmntsCopier.copyReferences();
			((Node) outsideBElemtCopy).getLinks().clear();
			((Node) outsideBElemtCopy).getLinks().addAll((Collection<? extends Node>) insideBElmntsCopy);
			rootNodeLib.getContains().add((Node) outsideBElemtCopy);
			ObjectHandle oh = factory.createObjectHandle();
			oh.setMOFRef(outsideBElemtCopy);
			fs2.getSourceObject().add(oh);
			toReplacementCopy.setOutsideBoundaryElement(oh);
			
			
			bindingCopier = new EcoreUtil.Copier();
			FromBinding fromBindingCopy = (FromBinding) bindingCopier.copy(fromBindingfs1);
			bindingCopier.copyReferences();
			fs1.getBoundaryElementBinding().add(fromBindingCopy);
			
			FromPlacement fromPlacement = fromBindingCopy.getFromPlacement();
			placementCopier = new EcoreUtil.Copier();
			FromPlacement fromPlacementCopy = (FromPlacement) placementCopier.copy(fromPlacement);
			placementCopier.copyReferences();
			fs1.getPlacement().getPlacementBoundaryElement().add(fromPlacementCopy);
			fromBindingCopy.setFromPlacement(fromPlacementCopy);
			fromPlacementCopy.getOutsideBoundaryElement().clear();
			fromPlacementCopy.getOutsideBoundaryElement().addAll(objectHandlesCopyInside);
			fromPlacementCopy.setInsideBoundaryElement(ohOutside);
			toBindingContfs1.getToPlacement().getInsideBoundaryElement().add(ohOutside);
			toBindingContfs1.getToReplacement().getInsideBoundaryElement().add(oh);
			
			FromReplacement fromReplacement = fromBindingCopy.getFromReplacement();
			replacementCopier = new EcoreUtil.Copier();
			FromReplacement fromReplacementCopy = (FromReplacement) replacementCopier.copy(fromReplacement);
			replacementCopier.copyReferences();
			fs1.getReplacement().getReplacementBoundaryElement().add(fromReplacementCopy);
			fromBindingCopy.setFromReplacement(fromReplacementCopy);
			fromReplacementCopy.setFromPlacement(fromPlacementCopy);
			fromPlacementCopy.setFromReplacement(fromReplacementCopy);
			
			fromReplacementCopy.getOutsideBoundaryElement().clear();
			fromReplacementCopy.getOutsideBoundaryElement().addAll(objectHandlesCopy);
			fromReplacementCopy.setInsideBoundaryElement(oh);
		}
	}
	
	public void createAdjFragment() throws IOException{
		this.base_new = new File("base_adjfrag_" + times + ".node");
		this.lib_new = new File("lib_adjfrag_" + times + ".node");
		this.cvlmodel_new = new File("node_new_adjfrag_" + times + ".cvl");
		
		nodePackage.eINSTANCE.eClass();
		cvlPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		
		Resource resourceBase = resSet.getResource(URI.createFileURI(this.base.getName()), true);
		Resource resourceLib = resSet.getResource(URI.createFileURI(this.lib.getName()), true);
		Resource resourceCvl = resSet.getResource(URI.createFileURI(this.cvlmodel.getName()), true);
		Node rootNodeBase = (Node) resourceBase.getContents().get(0);
		Node rootNodeLib = (Node) resourceLib.getContents().get(0);
		ConfigurableUnit cu = (ConfigurableUnit) resourceCvl.getContents().get(0);
		
		FragmentSubstitution fs1 = null;
		FragmentSubstitution fs2 = null;
		EList<VariationPoint> varPoints = cu.getOwnedVariationPoint();
		for(VariationPoint varPoint : varPoints){
			if(varPoint instanceof FragmentSubstitution){
				if(((FragmentSubstitution) varPoint).getName().equals(fs1_name)){
					fs1 = (FragmentSubstitution) varPoint;
				}
				if(((FragmentSubstitution) varPoint).getName().equals(fs2_name)){
					fs2 = (FragmentSubstitution) varPoint;
				}
			}
		}
		
		if(fs1 == null || fs2 == null){
			System.out.println("WARNING: fs1 or fs2 is null");
			return;
		}
		
		EList<Node> baseContents = rootNodeBase.getContains();
		Copier copierBase = new EcoreUtil.Copier();
		Collection<Node> baseContentsCopy = copierBase.copyAll(baseContents);
		copierBase.copyReferences();
		
		EList<Node> libContents = rootNodeLib.getContains();
		Copier copierLib = new EcoreUtil.Copier();
		Collection<Node> libContentsCopy = copierLib.copyAll(libContents);
		copierLib.copyReferences();
		
		for(VariationPoint vp : varPoints){
			if(vp instanceof FragmentSubstitution){
				EList<ObjectHandle> ohs = ((FragmentSubstitution) vp).getSourceObject();
				for(ObjectHandle oh : ohs){
					Node eObject = (Node) oh.getMOFRef();
					if(!(rootNodeLib.equals(eObject) || rootNodeBase.equals(eObject))){
						EObject eNewObject = (copierBase.get(eObject) == null) ? copierLib.get(eObject) : copierBase.get(eObject);
						if(eNewObject == null){
							System.out.println("WARNIGN!!!");
						}
						oh.setMOFRef(eNewObject);						
					}
				}
			}
		}
		
		rootNodeBase.getContains().clear();
		rootNodeBase.getContains().addAll(baseContentsCopy);
		
		rootNodeLib.getContains().clear();
		rootNodeLib.getContains().addAll(libContentsCopy);
		
		
		this.dublicateAdjFragment(cu, fs1, fs2, times, rootNodeBase, rootNodeLib);
		
		
	    resourceBase.setURI(URI.createFileURI(this.base_new.getName()));
	    resourceBase.save(Collections.EMPTY_MAP);
	    
	    resourceLib.setURI(URI.createFileURI(this.lib_new.getName()));
	    resourceLib.save(Collections.EMPTY_MAP);
	    
	    resourceCvl.setURI(URI.createFileURI(this.cvlmodel_new.getName()));
	    resourceCvl.save(Collections.EMPTY_MAP);		
	}
	
	private void dublicateAdjFragment(ConfigurableUnit cu, FragmentSubstitution fs1, FragmentSubstitution fs2, int times, Node rootNodeBase, Node rootNodeLib){
		EList<BoundaryElementBinding> boundariesfs1 = fs1.getBoundaryElementBinding();
		EList<BoundaryElementBinding> boundariesfs2 = fs2.getBoundaryElementBinding();

		ToBinding toBindingContfs1 = null; 
		for(BoundaryElementBinding be : boundariesfs1){
			if(be instanceof ToBinding){
				ToBinding toBinding = (ToBinding) be;
				if(toBinding.getToPlacement().getPropertyName().equals("contains")){
					toBindingContfs1 = toBinding;
				}
			}
		}

		if(toBindingContfs1 == null){
			System.out.println("WARNING! toBindingContfs1 is null");
			return;
		}
		
		ToBinding toBindingContfs2 = null;
		for(BoundaryElementBinding be : boundariesfs2){
			if(be instanceof ToBinding){
				ToBinding toBinding = (ToBinding) be;
				if(toBinding.getToPlacement().getPropertyName().equals("contains")){
					toBindingContfs2 = toBinding;
				}
			}
		}
		
		if(toBindingContfs2 == null){
			System.out.println("WARNING! toBindingContfs2 is null");
			return;
		}
		
		for(int i=0; i<times; i++){
			Copier fragmentCopier = new EcoreUtil.Copier();
			PlacementFragment placement = fs2.getPlacement();
			ReplacementFragmentType replacement = fs2.getReplacement();
			EList<EObject> fragments = new BasicEList<EObject>();
			fragments.add(fs2);
			fragments.add(placement);
			fragments.add(replacement);
			Collection<EObject> fragmentsCopy = fragmentCopier.copyAll(fragments);
			fragmentCopier.copyReferences();
			FragmentSubstitution fsNew = null;
			PlacementFragment placementNew = null;
			ReplacementFragmentType replacementNew = null;
			for(EObject eObject : fragmentsCopy){
				if(eObject instanceof FragmentSubstitution){
					cu.getOwnedVariationPoint().add((FragmentSubstitution) eObject);
					fsNew = (FragmentSubstitution) eObject;
				}
				if(eObject instanceof PlacementFragment){
					cu.getOwnedVariationPoint().add((PlacementFragment) eObject);
					placementNew = (PlacementFragment) eObject;
				}
				if(eObject instanceof ReplacementFragmentType){
					cu.getOwnedVariabletype().add((ReplacementFragmentType) eObject);
					replacementNew = (ReplacementFragmentType) eObject;
				}
			}
			
			EList<EObject> placementElements = Utility.resolveProxies(toBindingContfs2.getToPlacement().getInsideBoundaryElement());
			Copier placementElmtsCopier = new EcoreUtil.Copier();
			Collection<EObject> placementElementsCopy = placementElmtsCopier.copyAll(placementElements);
			placementElmtsCopier.copyReferences();
			rootNodeBase.getContains().addAll((Collection<? extends Node>) placementElementsCopy);
			EList<EObject> replacementElements = Utility.resolveProxies(toBindingContfs2.getToReplacement().getInsideBoundaryElement());
			Copier replacementElmtsCopier = new EcoreUtil.Copier();
			Collection<EObject> replacementElementsCopy = replacementElmtsCopier.copyAll(replacementElements);
			replacementElmtsCopier.copyReferences();
			rootNodeLib.getContains().addAll((Collection<? extends Node>) replacementElementsCopy);
			EList<ObjectHandle> ohs = fsNew.getSourceObject();
			for(ObjectHandle oh : ohs){
				EObject node = oh.getMOFRef();
				if(placementElmtsCopier.get(node) != null){
					oh.setMOFRef(placementElmtsCopier.get(node));
				}
			}
			ohs = fsNew.getSourceObject();
			for(ObjectHandle oh : ohs){
				EObject node = oh.getMOFRef();
				if(replacementElmtsCopier.get(node) != null){
					oh.setMOFRef(replacementElmtsCopier.get(node));
				}
			}
			
			HashMap<FromBinding, ToBinding> fromToMap = new HashMap<FromBinding, ToBinding>();
			for(BoundaryElementBinding be : boundariesfs1){
				if(be instanceof FromBinding){
					FromBinding fromBinding = (FromBinding) be;
					boundariesfs2 = fsNew.getBoundaryElementBinding();
					for(BoundaryElementBinding be2 : boundariesfs2){
						if(be2 instanceof ToBinding){
							ToBinding toBinding = (ToBinding) be2;
							if(fromBinding.getFromPlacement().getInsideBoundaryElement().getMOFRef().equals(toBinding.getToPlacement().getOutsideBoundaryElement().getMOFRef())){
								fromToMap.put(fromBinding, toBinding);
							}
						}
					}
				}
			}
			if(fromToMap.isEmpty()){
				System.out.println("WTF");
				return;
			}
			
			for(Map.Entry<FromBinding, ToBinding> entry : fromToMap.entrySet()){
				FromBinding fromBinding = entry.getKey();
				ToBinding toBinding = entry.getValue();
				
				EObject elementp1 = fromBinding.getFromPlacement().getInsideBoundaryElement().getMOFRef();
				Copier elementp1Copier = new EcoreUtil.Copier();
				EObject elementp1Copy = elementp1Copier.copy(elementp1);
				elementp1Copier.copyReferences();
				rootNodeBase.getContains().add((Node) elementp1Copy);
				
				((Node) elementp1Copy).getLinks().clear();
				((Node) elementp1Copy).getLinks().addAll((Collection<? extends Node>) Utility.resolveProxies(toBinding.getToPlacement().getInsideBoundaryElement()));
				
				ObjectHandle oh = factory.createObjectHandle();
				oh.setMOFRef(elementp1Copy);
				fs1.getSourceObject().add(oh);
				toBindingContfs1.getToPlacement().getInsideBoundaryElement().add(oh);
				
				Copier fromBindingCopier = new EcoreUtil.Copier();
				FromBinding fromBindingCopy = (FromBinding) fromBindingCopier.copy(fromBinding);
				fromBindingCopier.copyReferences();
				fs1.getBoundaryElementBinding().add(fromBindingCopy);
				
				FromPlacement fromPlacement = fromBinding.getFromPlacement();
				Copier fromPlacementCopier = new EcoreUtil.Copier();
				FromPlacement fromPlacementCopy = (FromPlacement) fromPlacementCopier.copy(fromPlacement);
				fromPlacementCopier.copyReferences();
				fromPlacementCopy.setInsideBoundaryElement(oh);
				fromPlacementCopy.getOutsideBoundaryElement().clear();
				fromPlacementCopy.getOutsideBoundaryElement().addAll(toBinding.getToPlacement().getInsideBoundaryElement());
				fromBindingCopy.setFromPlacement(fromPlacementCopy);
				fs1.getPlacement().getPlacementBoundaryElement().add(fromPlacementCopy);
				
			
				EObject elementr1 = fromBinding.getFromReplacement().getInsideBoundaryElement().getMOFRef();
				Copier elementr1Copier = new EcoreUtil.Copier();
				EObject elementr1Copy = elementp1Copier.copy(elementr1);
				elementr1Copier.copyReferences();
				rootNodeLib.getContains().add((Node) elementr1Copy);
				
				((Node) elementr1Copy).getLinks().clear();
				((Node) elementr1Copy).getLinks().addAll((Collection<? extends Node>) Utility.resolveProxies(toBinding.getToReplacement().getInsideBoundaryElement()));
				
				ObjectHandle ohr = factory.createObjectHandle();
				ohr.setMOFRef(elementr1Copy);
				fs1.getSourceObject().add(ohr);
				toBindingContfs1.getToReplacement().getInsideBoundaryElement().add(ohr);
				
				FromReplacement fromReplacement = fromBinding.getFromReplacement();
				Copier fromReplacementCopier = new EcoreUtil.Copier();
				FromReplacement fromReplacementCopy = (FromReplacement) fromPlacementCopier.copy(fromReplacement);
				fromReplacementCopier.copyReferences();
				fromReplacementCopy.setInsideBoundaryElement(ohr);
				fromReplacementCopy.getOutsideBoundaryElement().clear();
				fromReplacementCopy.getOutsideBoundaryElement().addAll(toBinding.getToReplacement().getInsideBoundaryElement());
				fromBindingCopy.setFromReplacement(fromReplacementCopy);
				fs1.getReplacement().getReplacementBoundaryElement().add(fromReplacementCopy);
				
				fromPlacementCopy.setFromReplacement(fromReplacementCopy);
				fromReplacementCopy.setFromPlacement(fromPlacementCopy);

				toBinding.getToPlacement().getOutsideBoundaryElement().setMOFRef(elementp1Copy);
				toBinding.getToReplacement().getOutsideBoundaryElement().setMOFRef(elementr1Copy);
			}
			
		}
		
	}
}
