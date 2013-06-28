package no.sintef.cvl.ui.command.event;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import cvl.FromBinding;
import cvl.FromPlacement;
import cvl.FromReplacement;
import cvl.NamedElement;
import cvl.ObjectHandle;
import cvl.ToBinding;
import cvl.ToPlacement;
import cvl.ToReplacement;
import cvl.VariationPoint;

import no.sintef.cvl.thirdparty.editor.ICVLEnabledEditor;
import no.sintef.cvl.ui.common.Constants;
import no.sintef.cvl.ui.common.ThirdpartyEditorSelector;
import no.sintef.cvl.ui.common.Utility;
import no.sintef.cvl.ui.editor.BindingJTable;
import no.sintef.cvl.ui.exception.IllegalOperationException;
import no.sintef.cvl.ui.logging.impl.Logging;
import no.sintef.cvl.ui.model.BindingTableModel;
import no.sintef.cvl.ui.primitive.impl.DataBindingItem;

public class BindingRowSelectionEvent implements ListSelectionListener {

	private BindingJTable table;

	public BindingRowSelectionEvent(BindingJTable jtable){
		table = jtable;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent event) {
		if(!event.getValueIsAdjusting()){
			int selectedIndex = ((ListSelectionModel) event.getSource()).getLeadSelectionIndex();
			BindingTableModel model = (BindingTableModel) table.getModel();
			ArrayList<ArrayList<Object>> data = model.getData();
			DataBindingItem bindingCell = (DataBindingItem) data.get(selectedIndex).get(Constants.BINDING_TYPE_CLMN);
			NamedElement binding = bindingCell.getNamedElement();
			
			HashMap<EObject, Integer> objectsToHighlight = new HashMap<EObject, Integer>();
			if(binding instanceof ToBinding){
				ToBinding toBinding = (ToBinding) binding;
				ToPlacement toPlacement = toBinding.getToPlacement();
				ToReplacement toReplacement = toBinding.getToReplacement();
				try {
					HashMap<EObject, Integer> toHighlight = this.getObjectsToHighlight(toPlacement);
					objectsToHighlight.putAll(toHighlight);
					toHighlight = this.getObjectsToHighlight(toReplacement);
					objectsToHighlight.putAll(toHighlight);
				} catch (IllegalOperationException e1) {
					e1.printStackTrace();
				}
			}else{
				FromBinding fromBinding = (FromBinding) binding;
				FromPlacement fromPlacement = fromBinding.getFromPlacement();
				FromReplacement fromReplacement = fromBinding.getFromReplacement();
				try {
					HashMap<EObject, Integer> toHighlight = this.getObjectsToHighlight(fromPlacement);
					objectsToHighlight.putAll(toHighlight);
					toHighlight = this.getObjectsToHighlight(fromReplacement);
					objectsToHighlight.putAll(toHighlight);
				} catch (IllegalOperationException e1) {
					e1.printStackTrace();
				}
			}
			
			try {
				ThirdpartyEditorSelector.getEditorSelector().highlightObjects(objectsToHighlight);
			} catch (IllegalOperationException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private HashMap<EObject, Integer> getObjectsToHighlight(VariationPoint boundary) throws IllegalOperationException{
		HashMap<EObject, Integer> map = new HashMap<EObject, Integer>();
		if(boundary instanceof ToPlacement || boundary instanceof ToReplacement){
			boolean isToPlacement = (boundary instanceof ToPlacement) ? true : false;
			if(!isToPlacement && Utility.isNullBoundary(boundary))
				return map;
			
			EObject eObject = (isToPlacement) ? ((ToPlacement) boundary).getOutsideBoundaryElement().getMOFRef() : ((ToReplacement) boundary).getOutsideBoundaryElement().getMOFRef();
			if(eObject != null){
				map.put(eObject, (isToPlacement) ? ICVLEnabledEditor.HL_PLACEMENT_IN : ICVLEnabledEditor.HL_REPLACEMENT_IN);
			}else{
				Logging.getLogger().error("outside boundary element reference is null for toBoundary" + boundary);
			}
			
			EList<ObjectHandle> objectHandles = (isToPlacement) ? ((ToPlacement) boundary).getInsideBoundaryElement() : ((ToReplacement) boundary).getInsideBoundaryElement();
			for(ObjectHandle oh : objectHandles){
				eObject = oh.getMOFRef();
				if(eObject != null){
					map.put(eObject, (isToPlacement) ? ICVLEnabledEditor.HL_PLACEMENT : ICVLEnabledEditor.HL_REPLACEMENT);
				}else{
					Logging.getLogger().error("inside boundary element reference is null for toBoundary" + boundary);
				}
			}
		}else if(boundary instanceof FromPlacement || boundary instanceof FromReplacement){
			boolean isFromPlacement = (boundary instanceof FromPlacement) ? true : false;
			if(isFromPlacement && Utility.isNullBoundary(boundary))
				return map;
			
			EObject eObject = (isFromPlacement) ? ((FromPlacement) boundary).getInsideBoundaryElement().getMOFRef() : ((FromReplacement) boundary).getInsideBoundaryElement().getMOFRef();
			if(eObject != null){
				map.put(eObject, (isFromPlacement) ? ICVLEnabledEditor.HL_PLACEMENT : ICVLEnabledEditor.HL_REPLACEMENT);
			}else{
				Logging.getLogger().error("inside boundary element reference is null for fromBoundary" + boundary);
			}
			
			EList<ObjectHandle> objectHandles = (isFromPlacement) ? ((FromPlacement) boundary).getOutsideBoundaryElement() : ((FromReplacement) boundary).getOutsideBoundaryElement();
			for(ObjectHandle oh : objectHandles){
				eObject = oh.getMOFRef();
				if(eObject != null){
					map.put(eObject, (isFromPlacement) ? ICVLEnabledEditor.HL_PLACEMENT_OUT : ICVLEnabledEditor.HL_REPLACEMENT_OUT);
				}else{
					Logging.getLogger().error("outside boundary element reference is null for fromBoundary" + boundary);
				}
			}
		}else{
			throw new IllegalOperationException("WTF!");
		}
		return map;
	}
}
