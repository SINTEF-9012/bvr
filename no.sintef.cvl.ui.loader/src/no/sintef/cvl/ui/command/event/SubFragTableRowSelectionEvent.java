package no.sintef.cvl.ui.command.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EObjectEList;

import cvl.FromPlacement;
import cvl.FromReplacement;
import cvl.NamedElement;
import cvl.ObjectHandle;
import cvl.PlacementBoundaryElement;
import cvl.PlacementFragment;
import cvl.ReplacementBoundaryElement;
import cvl.ReplacementFragmentType;
import cvl.ToPlacement;
import cvl.ToReplacement;

import no.sintef.cvl.thirdparty.editor.ICVLEnabledEditor;
import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.common.ThirdpartyEditorSelector;
import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.context.Context;
import no.sintef.cvl.ui.editor.SubstitutionFragmentJTable;
import no.sintef.cvl.ui.exception.NoEclipseDetectedException;
import no.sintef.cvl.ui.logging.impl.Logging;
import no.sintef.cvl.ui.model.SubFragTableModel;
import no.sintef.cvl.ui.primitive.impl.DataNamedElementItem;

public class SubFragTableRowSelectionEvent implements ListSelectionListener {

	private SubstitutionFragmentJTable jtable;
	
	public SubFragTableRowSelectionEvent(SubstitutionFragmentJTable table){
		jtable = table;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent event) {
		if(!event.getValueIsAdjusting()){
			EList<HashMap<EObject, Integer>> objectsToHighlightList = new BasicEList<HashMap<EObject, Integer>>();
			SubFragTableModel model =  (SubFragTableModel) jtable.getModel();
			ArrayList<ArrayList<Object>> data = model.getData();
            ArrayList<Integer> selectedIndexes = new ArrayList<Integer>();
			ListSelectionModel listSelectionModel = (ListSelectionModel) event.getSource();
            int minIndex = listSelectionModel.getMinSelectionIndex();
            int maxIndex = listSelectionModel.getMaxSelectionIndex();
            for (int i = minIndex; i <= maxIndex; i++) {
                if (listSelectionModel.isSelectedIndex(i)) selectedIndexes.add(i);
            }
            for(Integer index : selectedIndexes){
            	DataNamedElementItem subFragDataElement = (DataNamedElementItem) data.get(index).get(Constants.SUB_FRAG_FRAG_CLMN);
            	NamedElement fragment = subFragDataElement.getNamedElement();
            	if(fragment instanceof PlacementFragment){
            		PlacementFragment placement = (PlacementFragment) fragment;
            		EList<PlacementBoundaryElement> boundaries = placement.getPlacementBoundaryElement();
            		EList<EObject> outsideInsideElements = new BasicEList<EObject>();
            		EList<EObject> outsideOutsideElements = new BasicEList<EObject>();
            		EList<EObject> insideElements = new BasicEList<EObject>();
            		for(PlacementBoundaryElement boundary : boundaries){
            			if(boundary instanceof ToPlacement){
            				ToPlacement toPlacement = (ToPlacement) boundary;
            				if(!Utility.isNullBoundary(toPlacement)){
            					EObject eObject = toPlacement.getOutsideBoundaryElement().getMOFRef();
            					if(eObject == null){
            						Logging.getLogger().error("outside boundary element refrence is null for toPlacement" + toPlacement);
            					}else{
            						outsideInsideElements.add(eObject);
            					}
            					EList<ObjectHandle> objectHandles = toPlacement.getInsideBoundaryElement();
            					for(ObjectHandle objectHandle : objectHandles){
            						eObject = objectHandle.getMOFRef();
            						if(eObject == null){
            							Logging.getLogger().error("inside boundary element refrence is null for toPlacement" + toPlacement);
            						}else{
            							insideElements.add(eObject);
            						}
            					}
            				}else{
            					Logging.getLogger().error("toPlacement can not be null boundary, placement " + placement);
            				}
            			}
            			if(boundary instanceof FromPlacement){
            				FromPlacement fromPlacement = (FromPlacement) boundary;
            				if(!Utility.isNullBoundary(fromPlacement)){
            					EObject eObject = fromPlacement.getInsideBoundaryElement().getMOFRef();
            					if(eObject == null){
            						Logging.getLogger().error("inside boundary element refrence is null for fromPlacement" + fromPlacement);
            					}else{
            						insideElements.add(eObject);
            					}
            					EList<ObjectHandle> objectHandles = fromPlacement.getOutsideBoundaryElement();
            					for(ObjectHandle objectHandle : objectHandles){
            						eObject = objectHandle.getMOFRef();
            						if(eObject == null){
            							Logging.getLogger().error("outside boundary element refrence is null for fromPlacement" + fromPlacement);
            						}else{
            							outsideOutsideElements.add(eObject);
            						}
            					}
            				}
            			}
            		}
            		insideElements = calculateInnerPlacementElements(outsideInsideElements, outsideOutsideElements, insideElements, new BasicEList<EObject>());
            		EList<HashMap<EObject, Integer>> elements = markObjects(outsideInsideElements, outsideOutsideElements, insideElements, true);
            		objectsToHighlightList.addAll(markObjects(outsideInsideElements, outsideOutsideElements, insideElements, true));
            	}
            	if(fragment instanceof ReplacementFragmentType){
            		ReplacementFragmentType replacement = (ReplacementFragmentType) fragment;
            		EList<ReplacementBoundaryElement> boundaries = replacement.getReplacementBoundaryElement();
            		EList<EObject> outsideInsideElements = new BasicEList<EObject>();
            		EList<EObject> outsideOutsideElements = new BasicEList<EObject>();
            		EList<EObject> insideElements = new BasicEList<EObject>();
            		for(ReplacementBoundaryElement boundary : boundaries){
            			if(boundary instanceof ToReplacement){
            				ToReplacement toReplacement = (ToReplacement) boundary;
            				if(!Utility.isNullBoundary(toReplacement)){
            					EObject eObject = toReplacement.getOutsideBoundaryElement().getMOFRef();
            					if(eObject == null){
            						Logging.getLogger().error("outside boundary element refrence is null for toReplacement" + toReplacement);
            					}else{
            						outsideInsideElements.add(eObject);
            					}
            					EList<ObjectHandle> objectHandles = toReplacement.getInsideBoundaryElement();
            					for(ObjectHandle objectHandle : objectHandles){
            						eObject = objectHandle.getMOFRef();
            						if(eObject == null){
            							Logging.getLogger().error("inside boundary element refrence is null for toReplacement" + toReplacement);
            						}else{
            							insideElements.add(eObject);
            						}
            					}
            				}
            			}
            			if(boundary instanceof FromReplacement){
            				FromReplacement fromReplacement = (FromReplacement) boundary;
            				if(!Utility.isNullBoundary(fromReplacement)){
            					EObject eObject = fromReplacement.getInsideBoundaryElement().getMOFRef();
            					if(eObject == null){
            						Logging.getLogger().error("inside boundary element refrence is null for fromReplacement" + fromReplacement);
            					}else{
            						insideElements.add(eObject);
            					}
            					EList<ObjectHandle> objectHandles = fromReplacement.getOutsideBoundaryElement();
            					for(ObjectHandle objectHandle : objectHandles){
            						eObject = objectHandle.getMOFRef();
            						if(eObject == null){
            							Logging.getLogger().error("outside boundary element refrence is null for fromReplacement" + fromReplacement);
            						}else{
            							outsideOutsideElements.add(eObject);
            						}
            					}
            				}else{
            					Logging.getLogger().error("fromPlacement can not be null boundary, replacement " + replacement);
            				}
            			}
            		}
            		insideElements = calculateInnerPlacementElements(outsideInsideElements, outsideOutsideElements, insideElements, new BasicEList<EObject>());
            		objectsToHighlightList.addAll(this.markObjects(outsideInsideElements, outsideOutsideElements, insideElements, false));
            	}
            }
            
            Context.eINSTANCE.highlightObjects(objectsToHighlightList);
		}
	}

	private EList<EObject> calculateInnerPlacementElements(EList<EObject> outsideInside, EList<EObject> outsideOutside, EList<EObject> inside, EList<EObject> visited){
		for(EObject eObject : inside){
			EList<EReference> links = new BasicEList<EReference>(eObject.eClass().getEAllReferences());
			EList<EObject> refobjects = getReferencedEObjects(eObject, links);
			refobjects.addAll(eObject.eContents());
			if(!outsideInside.contains(eObject) && !outsideOutside.contains(eObject) && !visited.contains(eObject)){
				visited.add(eObject);
				visited = calculateInnerPlacementElements(outsideInside, outsideOutside, refobjects, visited);
			}
		}
		return visited;
	}
	
	private EList<EObject> getReferencedEObjects(EObject source, EList<EReference> links){
		EList<EObject> eObjects = new BasicEList<EObject>();
		for(EReference link : links){
			if(Utility.isDerived(link) == 0){
				Object value = source.eGet(link);
				if(value instanceof EObject){
					eObjects.add((EObject) value);
				}else if (value instanceof EObjectEList){
					eObjects.addAll((EList<? extends EObject>) value);
				}else if(value != null){
					Logging.getLogger().warn("reference " + link + " does not point to EObject nor EObjectList :" + value);
				}
			}
		}
		return eObjects;
	}
	
	private EList<HashMap<EObject, Integer>> markObjects(EList<EObject> outsideInsideElements, EList<EObject> outsideOutsideElements, EList<EObject> insideElements, boolean isPlacement){
		EList<HashMap<EObject, Integer>> objectsToHL = new BasicEList<HashMap<EObject,Integer>>();
		int fragment = (isPlacement) ? ICVLEnabledEditor.HL_PLACEMENT : ICVLEnabledEditor.HL_REPLACEMENT;
		int fragment_in = (isPlacement) ? ICVLEnabledEditor.HL_PLACEMENT_IN : ICVLEnabledEditor.HL_REPLACEMENT_IN;
		int fragment_out = (isPlacement) ? ICVLEnabledEditor.HL_PLACEMENT_OUT : ICVLEnabledEditor.HL_REPLACEMENT_OUT;
		for(EObject eObject : outsideInsideElements){
			HashMap<EObject, Integer> objectsToH = new HashMap<EObject, Integer>();
			objectsToH.put(eObject, fragment_in);
			objectsToHL.add(objectsToH);
		}
		for(EObject eObject : insideElements){
			HashMap<EObject, Integer> objectsToH = new HashMap<EObject, Integer>();
			objectsToH.put(eObject, fragment);
			objectsToHL.add(objectsToH);
		}
		for(EObject eObject : outsideOutsideElements){
			HashMap<EObject, Integer> objectsToH = new HashMap<EObject, Integer>();
			objectsToH.put(eObject, fragment_out);
			objectsToHL.add(objectsToH);
		}
		return objectsToHL;
	}

}
