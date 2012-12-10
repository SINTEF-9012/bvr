package no.sintef.cvl.engine.converters.rls;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import no.sintef.cvl.engine.converters.common.CVLModelNew;
import no.sintef.cvl.engine.converters.common.CVLModelOld;
import no.sintef.cvl.engine.converters.common.PlacementElementHolder;
import no.sintef.cvl.engine.converters.common.ReplacementElementHolder;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.ExternalCrossReferencer;
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;

import org.variabilitymodeling.cvl.BoundaryElementBinding;
import org.variabilitymodeling.cvl.CVLModel;
import org.variabilitymodeling.cvl.CompositeVariability;
import org.variabilitymodeling.cvl.PlacementBoundaryElement;
import org.variabilitymodeling.cvl.ReplacementBoundaryElement;

import cvl.Choice;
import cvl.ConfigurableUnit;
import cvl.FromPlacement;
import cvl.ObjectHandle;
import cvl.OpaqueVariationPoint;
import cvl.PlacementFragment;
import cvl.ReplacementFragmentType;
import cvl.ToReplacement;
import cvl.VClassifier;
import cvl.VSpec;
import cvl.cvlFactory;
import cvl.ToPlacement;
import cvl.FromReplacement;
import cvl.FragmentSubstitution;
import cvl.ToBinding;
import cvl.FromBinding;

public class OldCvlToNewCvl {

	private File oldcvlfile;
	private File newcvlfile;
	private cvlFactory factory = cvlFactory.eINSTANCE;
	private ConfigurableUnit cu;
	private HashMap<org.variabilitymodeling.cvl.PlacementFragment, cvl.PlacementFragment> plMap = new HashMap<org.variabilitymodeling.cvl.PlacementFragment, cvl.PlacementFragment>();
	private HashMap<org.variabilitymodeling.cvl.ReplacementFragment, cvl.ReplacementFragmentType> rplMap = new HashMap<org.variabilitymodeling.cvl.ReplacementFragment, cvl.ReplacementFragmentType>();
	private HashMap<CompositeVariability, VSpec> compositeVSpecMap = new HashMap<CompositeVariability, VSpec>();
	private HashMap<org.variabilitymodeling.cvl.PlacementBoundaryElement, cvl.PlacementBoundaryElement> placBoundMap = new HashMap<org.variabilitymodeling.cvl.PlacementBoundaryElement, cvl.PlacementBoundaryElement>();
	private HashMap<org.variabilitymodeling.cvl.ReplacementBoundaryElement, cvl.ReplacementBoundaryElement> replBoundMap = new HashMap<org.variabilitymodeling.cvl.ReplacementBoundaryElement, cvl.ReplacementBoundaryElement>();
	private ResourceSet resSet;
	
	public OldCvlToNewCvl(File oldcvl, File newcvl){
		this.oldcvlfile = oldcvl;
		this.newcvlfile = newcvl;
		try {
			this.newcvlfile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String path = this.oldcvlfile.getAbsolutePath();
		path = path.replaceAll(oldcvl.getName(), "");
		System.setProperty( "user.dir", path);
	}

	public void run() throws Exception{
		this.resSet = new ResourceSetImpl();
		
		CVLModelNew cvn = new CVLModelNew(this.resSet);
		this.cu = cvn.creat();
		
		CVLModelOld cvo = new CVLModelOld(this.resSet);
		CVLModel cv = cvo.load(this.oldcvlfile);
		
		this.parseOldTree(cv, cu);
				
		cvn.writeToFile(this.newcvlfile, cu);
	}
	
	private void parseOldTree(EObject node, EObject newnode) throws Exception{
		if(node instanceof CVLModel){
			((ConfigurableUnit) newnode).setName(((CVLModel) node).getName());
		}
		for(EObject child : node.eContents()){
			if(child instanceof CompositeVariability){
				VSpec vspec = factory.createChoice();
				vspec.setName(((CompositeVariability) child).getName());
				this.compositeVSpecMap.put((CompositeVariability) child, vspec);
				if(newnode instanceof ConfigurableUnit){
					((ConfigurableUnit) newnode).getOwnedVSpec().add(vspec);
				}
				if(newnode instanceof VSpec){
					((VSpec) newnode).getChild().add(vspec);
				}
				this.parseOldTree(child, vspec);
			}
			if(child instanceof org.variabilitymodeling.cvl.PlacementFragment){
				org.variabilitymodeling.cvl.PlacementFragment opf = (org.variabilitymodeling.cvl.PlacementFragment) child;
				PlacementFragment pf = factory.createPlacementFragment();
				pf.setName(opf.getName());
				this.plMap.put(opf, pf);
				PlacementElementHolder pef = new PlacementElementHolder(opf);
				HashMap<org.variabilitymodeling.cvl.FromPlacement, EObject> mapFromPlacementInside = pef.getInsideBoundaryMapForPlacement();
				
				EList<PlacementBoundaryElement> opbes = opf.getBoundaryElement();
				for(PlacementBoundaryElement element : opbes){
					if(element instanceof org.variabilitymodeling.cvl.ToPlacement){
						org.variabilitymodeling.cvl.ToPlacement tpbe = (org.variabilitymodeling.cvl.ToPlacement) element;
						ToPlacement tpbeNew = factory.createToPlacement();
						this.placBoundMap.put(tpbe, tpbeNew);
						
						tpbeNew.setPropertyName(tpbe.getPropertyName());
						pf.getPlacementBoundaryElement().add(tpbeNew);
						
						EList<EObject> ibeos = tpbe.getInsideBoundaryElement();
						for(EObject ibeo : ibeos){	
							ObjectHandle obh = factory.createObjectHandle();
							obh.setMOFRef(this.getProxyURI(ibeo));
							OpaqueVariationPoint ovp = factory.createOpaqueVariationPoint();
							ovp.getSourceObject().add(obh);
							this.cu.getOwnedVariationPoint().add(ovp);
							tpbeNew.getInsideBoundaryElement().add(obh);
						}
						
						EObject obeo = tpbe.getOutsideBoundaryElement();
						ObjectHandle obh = factory.createObjectHandle();
						obh.setMOFRef(this.getProxyURI(obeo));
						OpaqueVariationPoint ovp = factory.createOpaqueVariationPoint();
						ovp.getSourceObject().add(obh);
						this.cu.getOwnedVariationPoint().add(ovp);
						tpbeNew.setOutsideBoundaryElement(obh);
					}
					
					if(element instanceof org.variabilitymodeling.cvl.FromPlacement){
						org.variabilitymodeling.cvl.FromPlacement fpbe = (org.variabilitymodeling.cvl.FromPlacement) element;
						FromPlacement fpbeNew = factory.createFromPlacement();
						this.placBoundMap.put(fpbe, fpbeNew);
						
						pf.getPlacementBoundaryElement().add(fpbeNew);
						
						EList<EObject> obeos = fpbe.getOutsideBoundaryElement();
						for(EObject obeo : obeos){
							ObjectHandle obh = factory.createObjectHandle();
							obh.setMOFRef(this.getProxyURI(obeo));
							OpaqueVariationPoint ovp = factory.createOpaqueVariationPoint();
							ovp.getSourceObject().add(obh);
							this.cu.getOwnedVariationPoint().add(ovp);
							fpbeNew.getOutsideBoundaryElement().add(obh);
							
						}
						
						EObject insideBoundaryElementOld = mapFromPlacementInside.get(fpbe);
						ObjectHandle obh = factory.createObjectHandle();
						obh.setMOFRef(this.getProxyURI(insideBoundaryElementOld));
						OpaqueVariationPoint ovp = factory.createOpaqueVariationPoint();
						ovp.getSourceObject().add(obh);
						this.cu.getOwnedVariationPoint().add(ovp);
						fpbeNew.setInsideBoundaryElement(obh);
					}
				}
				this.cu.getOwnedVariationPoint().add(pf);
			}
			
			if(child instanceof org.variabilitymodeling.cvl.ReplacementFragment){
				org.variabilitymodeling.cvl.ReplacementFragment orf = (org.variabilitymodeling.cvl.ReplacementFragment) child;
				ReplacementFragmentType rft = factory.createReplacementFragmentType();
				rft.setName(orf.getName());
				this.rplMap.put(orf, rft);
				
				ReplacementElementHolder reh = new ReplacementElementHolder(orf);
				HashMap<org.variabilitymodeling.cvl.ToReplacement, EObject> mapToReplacementOutside = reh.getOutsideBoundaryElementMap();
				
				EList<ReplacementBoundaryElement> orbes = orf.getBoundaryElement();
				for(ReplacementBoundaryElement element : orbes){
					if(element instanceof org.variabilitymodeling.cvl.FromReplacement){
						org.variabilitymodeling.cvl.FromReplacement frbe = (org.variabilitymodeling.cvl.FromReplacement) element;
						FromReplacement frbeNew = factory.createFromReplacement();
						this.replBoundMap.put(frbe, frbeNew);
						
						frbeNew.setPropertyName(frbe.getPropertyName());
						rft.getReplacementBoundaryElement().add(frbeNew);
						
						EList<EObject> obeos = frbe.getOutsideBoundaryElement();
						for(EObject obeo : obeos){
							ObjectHandle obh = factory.createObjectHandle();
							obh.setMOFRef(this.getProxyURI(obeo));
							OpaqueVariationPoint ovp = factory.createOpaqueVariationPoint();
							ovp.getSourceObject().add(obh);
							this.cu.getOwnedVariationPoint().add(ovp);
							frbeNew.getOutsideBoundaryElement().add(obh);
						}
						
						EObject ibeo = frbe.getInsideBoundaryElement();
						ObjectHandle obh = factory.createObjectHandle();
						obh.setMOFRef(this.getProxyURI(ibeo));
						OpaqueVariationPoint ovp = factory.createOpaqueVariationPoint();
						ovp.getSourceObject().add(obh);
						this.cu.getOwnedVariationPoint().add(ovp);
						frbeNew.setInsideBoundaryElement(obh);
					}
					if(element instanceof org.variabilitymodeling.cvl.ToReplacement){
						org.variabilitymodeling.cvl.ToReplacement trbe = (org.variabilitymodeling.cvl.ToReplacement) element;
						ToReplacement trbeNew = factory.createToReplacement();
						this.replBoundMap.put(trbe, trbeNew);
						
						rft.getReplacementBoundaryElement().add(trbeNew);
						
						EList<EObject> ibeos = trbe.getInsideBoundaryElement();
						for(EObject ibeo : ibeos){
							ObjectHandle obh = factory.createObjectHandle();
							obh.setMOFRef(this.getProxyURI(ibeo));
							OpaqueVariationPoint ovp = factory.createOpaqueVariationPoint();
							ovp.getSourceObject().add(obh);
							this.cu.getOwnedVariationPoint().add(ovp);
							trbeNew.getInsideBoundaryElement().add(obh);
						}
						
						EObject outsideBoundaryElement = mapToReplacementOutside.get(trbe);
						ObjectHandle obh = factory.createObjectHandle();
						obh.setMOFRef(this.getProxyURI(outsideBoundaryElement));
						OpaqueVariationPoint ovp = factory.createOpaqueVariationPoint();
						ovp.getSourceObject().add(obh);
						this.cu.getOwnedVariationPoint().add(ovp);
						trbeNew.setOutsideBoundaryElement(obh);
					}
				}
				this.cu.getOwnedVariabletype().add(rft);
			}
			if(child instanceof org.variabilitymodeling.cvl.FragmentSubstitution){
				org.variabilitymodeling.cvl.FragmentSubstitution fso = (org.variabilitymodeling.cvl.FragmentSubstitution) child;
				FragmentSubstitution fsn = factory.createFragmentSubstitution();
				fsn.setName(fso.getName());
				PlacementFragment pf = this.getPlacement(fso.getPlacement());
				ReplacementFragmentType rft = this.getReplacement(fso.getReplacement());
				fsn.setPlacement(pf);
				fsn.setReplacement(rft);				
				this.bindFragmentSubstitution(fsn, newnode);
				
				EList<BoundaryElementBinding> obs = fso.getBoundaryElementBinding();
				for (BoundaryElementBinding ob: obs){
					if(ob instanceof org.variabilitymodeling.cvl.ToBinding){
						org.variabilitymodeling.cvl.ToBinding tob = (org.variabilitymodeling.cvl.ToBinding) ob;
						ToBinding tnb = factory.createToBinding();
						HashMap<ToPlacement, ToReplacement> pr = this.getToPlacementReplacement(tob);
						tnb.setToPlacement(pr.keySet().iterator().next());
						tnb.setToReplacement(pr.values().iterator().next());
						fsn.getBoundaryElementBinding().add(tnb);	
					}
					if(ob instanceof org.variabilitymodeling.cvl.FromBinding){
						org.variabilitymodeling.cvl.FromBinding fob = (org.variabilitymodeling.cvl.FromBinding) ob;
						FromBinding fnb = factory.createFromBinding();
						HashMap<FromPlacement, FromReplacement> pr = this.getFromPlacementReplacement(fob);
						fnb.setFromPlacement(pr.keySet().iterator().next());
						fnb.setFromReplacement(pr.values().iterator().next());
						fsn.getBoundaryElementBinding().add(fnb);	
					}
				}
				
				this.cu.getOwnedVariationPoint().add(fsn);
			}
		}
	}
	
	private String getProxyURI(EObject object) throws Exception{
		if(object.eIsProxy()){
			object = EcoreUtil.resolve(object, resSet);
		}
		if(object.eIsProxy()){
			throw new Exception("Can not reslve proxy" + object);
		}
		return EcoreUtil.getURI(object).toString();
	}
	
	private HashMap<FromPlacement, FromReplacement> getFromPlacementReplacement(org.variabilitymodeling.cvl.FromBinding fob) throws Exception {
		cvl.PlacementBoundaryElement nfp = this.placBoundMap.get(fob.getFromPlacement());
		cvl.ReplacementBoundaryElement nfr = this.replBoundMap.get(fob.getFromReplacement());
		if(nfp == null){
			throw new Exception("can not find FromPlacement matching " + fob.getFromPlacement() + " in " + fob);
		}
		if(nfr == null){
			throw new Exception("can not find FromReplacement matching " + fob.getFromReplacement() + " in " + fob);
		}
		HashMap<FromPlacement, FromReplacement> val = new HashMap<FromPlacement, FromReplacement>();
		val.put((FromPlacement) nfp, (FromReplacement) nfr);
		return val;
	}

	private HashMap<ToPlacement, ToReplacement> getToPlacementReplacement(org.variabilitymodeling.cvl.ToBinding tb) throws Exception{
		cvl.PlacementBoundaryElement ntp = this.placBoundMap.get(tb.getToPlacement());
		cvl.ReplacementBoundaryElement ntr = this.replBoundMap.get(tb.getToReplacement());
		if(ntp == null){
			throw new Exception("can not find ToPlacement matching " + tb.getToPlacement() + " in " + tb);
		}
		if(ntr == null){
			throw new Exception("can not find ToReplacement matching " + tb.getToReplacement() + " in " + tb);
		}
		HashMap<ToPlacement, ToReplacement> val = new HashMap<ToPlacement, ToReplacement>();
		val.put((ToPlacement) ntp, (ToReplacement) ntr);
		return val;
	}
	
	private void bindFragmentSubstitution(FragmentSubstitution fs, EObject vspec) throws Exception{
		if(vspec instanceof VClassifier){
			fs.setBindingClassifier((VClassifier)vspec);
		}else if(vspec instanceof Choice){
			fs.setBindingChoice((Choice) vspec);
		}else if(vspec instanceof VSpec){
			fs.setBindingVSpec((VSpec) vspec);
		}else{
			throw new Exception("vspec is of the wrong type" + vspec);
		}
	}
	
	private PlacementFragment getPlacement(org.variabilitymodeling.cvl.PlacementFragment pl) throws Exception{
		PlacementFragment pf = this.plMap.get(pl);
		if(pl == null){
			throw new Exception("there is no PlacementFragment in the new model matching " + pl);
		}
		return pf;
	}
	
	private ReplacementFragmentType getReplacement(org.variabilitymodeling.cvl.ReplacementFragmentAbstract rl) throws Exception{
		ReplacementFragmentType rlt = this.rplMap.get((org.variabilitymodeling.cvl.ReplacementFragment) rl);
		if(rlt == null){
			throw new Exception("there is no ReplacementFragment in the new model matching " + rl);
		}
		return rlt;
	}
	
	private VSpec getVSpec(org.variabilitymodeling.cvl.CompositeVariability cv) throws Exception{
		VSpec vs = this.compositeVSpecMap.get(cv);
		if(vs == null){
			throw new Exception("there is no VSpec in the new model matching " + cv);
		}
		return vs;
	}
	
	private void parseOldTree1(EObject node){
		System.out.println(node);
		for(EObject child : node.eContents()){
			this.parseOldTree1(child);
		}
	}
}
