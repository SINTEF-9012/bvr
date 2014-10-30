package no.sintef.bvr.tool.primitive.impl;

import java.util.HashMap;

import no.sintef.bvr.tool.exception.UnimplementedBVRException;
import no.sintef.bvr.tool.primitive.AbstractSymbol;
import no.sintef.bvr.tool.primitive.SymbolVSpec;

import org.eclipse.emf.common.util.BasicEList;

import bvr.ChoiceResolution;
import bvr.FragmentSubstitution;
import bvr.VSpecResolution;


public class VSpecResolutionSymbol extends AbstractSymbol {

	public VSpecResolutionSymbol(VSpecResolution vSpecRes){
		multi = false;
		vSpecResolution = vSpecRes;
		children = new BasicEList<SymbolVSpec>();
		vSpec = vSpecRes.getResolvedVSpec();
		fragSubs = new BasicEList<FragmentSubstitution>();
		fragSubsToExecute = new BasicEList<FragmentSubstitution>();
		fragmentSubCopyMap = new HashMap<FragmentSubstitution, FragmentSubstitution>();
		if(vSpecRes instanceof ChoiceResolution){
			if(((ChoiceResolution) vSpecRes).getResolvedChoice() != null){
				vSpec = ((ChoiceResolution) vSpecRes).getResolvedChoice();
			}else if(((ChoiceResolution) vSpecRes).getResolvedVClassifier() != null){
				vSpec = ((ChoiceResolution) vSpecRes).getResolvedVClassifier();
			}else {
				throw new UnimplementedBVRException("Can not find a resolved VSpec for " + vSpecRes);
			}
		}else {
			throw new UnimplementedBVRException("Can not create a symble from somthing other than ChoiceResolution " + vSpecRes);
		}
	}
}
