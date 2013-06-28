package no.sintef.cvl.ui.command.event;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

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
import no.sintef.cvl.ui.editor.SubstitutionFragmentJTable;
import no.sintef.cvl.ui.exception.IllegalOperationException;
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
			HashMap<EObject, Integer> objectsToHighlight = new HashMap<EObject, Integer>();
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
            		insideElements = this.calculateInnerPlacementElements(outsideInsideElements, outsideOutsideElements, insideElements, new BasicEList<EObject>());
            		objectsToHighlight.putAll(this.markObjects(outsideInsideElements, outsideOutsideElements, insideElements, true));
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
            		insideElements = this.calculateInnerPlacementElements(outsideInsideElements, outsideOutsideElements, insideElements, new BasicEList<EObject>());
            		objectsToHighlight.putAll(this.markObjects(outsideInsideElements, outsideOutsideElements, insideElements, false));
            	}
            }
            try {
				ThirdpartyEditorSelector.getEditorSelector().highlightObjects(objectsToHighlight);
			} catch (IllegalOperationException e) {
				e.printStackTrace();
			}
		}
	}
	
	private EList<EObject> calculateInnerPlacementElements(EList<EObject> outsideInside, EList<EObject> outsideOutside, EList<EObject> inside, EList<EObject> visited){
		for(EObject eObject : inside){
			EList<EObject> refobjects = new BasicEList<EObject>(eObject.eCrossReferences());
			refobjects.addAll(eObject.eContents());
			if(!outsideInside.contains(eObject) && !outsideOutside.contains(eObject) && !visited.contains(eObject)){
				visited.add(eObject);
				visited = this.calculateInnerPlacementElements(outsideInside, outsideOutside, refobjects, visited);
			}
		}
		return visited;
	}
	
	private HashMap<EObject, Integer> markObjects(EList<EObject> outsideInsideElements, EList<EObject> outsideOutsideElements, EList<EObject> insideElements, boolean isPlacement){
		HashMap<EObject, Integer> objectsToH = new HashMap<EObject, Integer>();
		int fragment = (isPlacement) ? ICVLEnabledEditor.HL_PLACEMENT : ICVLEnabledEditor.HL_REPLACEMENT;
		int fragment_in = (isPlacement) ? ICVLEnabledEditor.HL_PLACEMENT_IN : ICVLEnabledEditor.HL_REPLACEMENT_IN;
		int fragment_out = (isPlacement) ? ICVLEnabledEditor.HL_PLACEMENT_OUT : ICVLEnabledEditor.HL_REPLACEMENT_OUT;
		for(EObject eObject : outsideInsideElements){
			objectsToH.put(eObject, fragment_in);
		}
		for(EObject eObject : insideElements){
			objectsToH.put(eObject, fragment);
		}
		for(EObject eObject : outsideOutsideElements){
			objectsToH.put(eObject, fragment_out);
		}
		return objectsToH;
	}

}
