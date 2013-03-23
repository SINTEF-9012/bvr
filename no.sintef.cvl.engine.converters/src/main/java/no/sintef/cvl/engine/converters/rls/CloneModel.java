package no.sintef.cvl.engine.converters.rls;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

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
import cvl.FromPlacement;
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

	public CloneModel(File base, File lib, File cvlmodel, int times){
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
}
