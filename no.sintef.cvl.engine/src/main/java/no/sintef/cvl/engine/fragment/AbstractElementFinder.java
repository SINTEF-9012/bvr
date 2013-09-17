package no.sintef.cvl.engine.fragment;

import no.sintef.cvl.engine.common.SubstitutionContext;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public abstract class AbstractElementFinder {

	protected EList<EObject> calculateInnerElements(EList<EObject> outsideInside, EList<EObject> outsideOutside, EList<EObject> inside, EList<EObject> visited){
		for(EObject eObject : inside){
			EList<EObject> refobjects;
			try{
				refobjects = no.sintef.cvl.common.Utility.getReferencedEObjects(eObject);
			}catch(UnsupportedOperationException exception){
				SubstitutionContext.ME.getLogger().warn(exception.getMessage());
				continue;
			}
			refobjects.addAll(eObject.eContents());
			if(!outsideInside.contains(eObject) && !outsideOutside.contains(eObject) && !visited.contains(eObject)){
				visited.add(eObject);
				visited = calculateInnerElements(outsideInside, outsideOutside, refobjects, visited);
			}
		}
		return visited;
	}
	
}
