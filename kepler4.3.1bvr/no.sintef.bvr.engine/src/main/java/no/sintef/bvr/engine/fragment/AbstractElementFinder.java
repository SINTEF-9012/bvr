package no.sintef.bvr.engine.fragment;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public abstract class AbstractElementFinder {

	protected EList<EObject> calculateInnerElements(EList<EObject> outsideInside, EList<EObject> outsideOutside, EList<EObject> inside, EList<EObject> visited){
		for(EObject eObject : inside){
			EList<EObject> refobjects = no.sintef.bvr.common.CommonUtility.getReferencedEObjects(eObject);
			refobjects.addAll(eObject.eContents());
			if(!outsideInside.contains(eObject) && !outsideOutside.contains(eObject) && !visited.contains(eObject)){
				visited.add(eObject);
				visited = calculateInnerElements(outsideInside, outsideOutside, refobjects, visited);
			}
		}
		return visited;
	}
	
}
