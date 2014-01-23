package no.sintef.bvr.tool.ui.command.event;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import bvr.FromBinding;
import bvr.FromPlacement;
import bvr.FromReplacement;
import bvr.NamedElement;
import bvr.ObjectHandle;
import bvr.ToBinding;
import bvr.ToPlacement;
import bvr.ToReplacement;
import bvr.VariationPoint;

import no.sintef.bvr.common.logging.Logger;
import no.sintef.bvr.thirdparty.editor.ICVLEnabledEditor;
import no.sintef.bvr.tool.common.Constants;
import no.sintef.bvr.tool.common.LoaderUtility;
import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.exception.IllegalOperationException;
import no.sintef.bvr.tool.primitive.impl.DataBindingItem;
import no.sintef.bvr.tool.ui.editor.BindingJTable;
import no.sintef.bvr.tool.ui.model.BindingTableModel;

public class BindingRowSelectionEvent implements ListSelectionListener {

	private BindingJTable table;
	private Logger logger = Context.eINSTANCE.logger;

	public BindingRowSelectionEvent(BindingJTable jtable){
		table = jtable;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent event) {
		if(!Context.eINSTANCE.getConfig().isHighlightingMode())
			return;
		
		int selectedIndex = ((ListSelectionModel) event.getSource()).getLeadSelectionIndex();
		if(!event.getValueIsAdjusting() && selectedIndex >= 0){
			BindingTableModel model = (BindingTableModel) table.getModel();
			ArrayList<ArrayList<Object>> data = model.getData();
			DataBindingItem bindingCell = (DataBindingItem) data.get(selectedIndex).get(Constants.BINDING_TYPE_CLMN);
			NamedElement binding = bindingCell.getNamedElement();
			
			EList<HashMap<EObject, Integer>> objectsToHighlightList = new BasicEList<HashMap<EObject,Integer>>();
			if(binding instanceof ToBinding){
				ToBinding toBinding = (ToBinding) binding;
				ToPlacement toPlacement = toBinding.getToPlacement();
				ToReplacement toReplacement = toBinding.getToReplacement();
				try {
					objectsToHighlightList.addAll(getObjectsToHighlight(toPlacement));
					objectsToHighlightList.addAll(getObjectsToHighlight(toReplacement));
				} catch (IllegalOperationException e1) {
					e1.printStackTrace();
				}
			}else{
				FromBinding fromBinding = (FromBinding) binding;
				FromPlacement fromPlacement = fromBinding.getFromPlacement();
				FromReplacement fromReplacement = fromBinding.getFromReplacement();
				try {
					objectsToHighlightList.addAll(getObjectsToHighlight(fromPlacement));
					objectsToHighlightList.addAll(getObjectsToHighlight(fromReplacement));
				} catch (IllegalOperationException e1) {
					e1.printStackTrace();
				}
			}
			
			Context.eINSTANCE.highlightObjects(objectsToHighlightList);
		}
	}
	
	private EList<HashMap<EObject, Integer>> getObjectsToHighlight(NamedElement boundary) throws IllegalOperationException{
		EList<HashMap<EObject, Integer>> list = new BasicEList<HashMap<EObject, Integer>>();
		if(boundary instanceof ToPlacement || boundary instanceof ToReplacement){
			boolean isToPlacement = (boundary instanceof ToPlacement) ? true : false;
			if(!isToPlacement && LoaderUtility.isNullBoundary(boundary))
				return list;
			
			EObject eObject = (isToPlacement) ? ((ToPlacement) boundary).getOutsideBoundaryElement().getMOFRef() : ((ToReplacement) boundary).getOutsideBoundaryElement().getMOFRef();
			if(eObject != null){
				HashMap<EObject, Integer> map = new HashMap<EObject, Integer>();
				map.put(eObject, (isToPlacement) ? ICVLEnabledEditor.HL_PLACEMENT_IN : ICVLEnabledEditor.HL_REPLACEMENT_IN);
				list.add(map);
			}else{
				logger.error("outside boundary element reference is null for toBoundary" + boundary);
			}
			
			EList<ObjectHandle> objectHandles = (isToPlacement) ? ((ToPlacement) boundary).getInsideBoundaryElement() : ((ToReplacement) boundary).getInsideBoundaryElement();
			for(ObjectHandle oh : objectHandles){
				eObject = oh.getMOFRef();
				if(eObject != null){
					HashMap<EObject, Integer> map = new HashMap<EObject, Integer>();
					map.put(eObject, (isToPlacement) ? ICVLEnabledEditor.HL_PLACEMENT : ICVLEnabledEditor.HL_REPLACEMENT);
					list.add(map);
				}else{
					logger.error("inside boundary element reference is null for toBoundary" + boundary);
				}
			}
		}else if(boundary instanceof FromPlacement || boundary instanceof FromReplacement){
			boolean isFromPlacement = (boundary instanceof FromPlacement) ? true : false;
			if(isFromPlacement && LoaderUtility.isNullBoundary(boundary))
				return list;
			
			EObject eObject = (isFromPlacement) ? ((FromPlacement) boundary).getInsideBoundaryElement().getMOFRef() : ((FromReplacement) boundary).getInsideBoundaryElement().getMOFRef();
			if(eObject != null){
				HashMap<EObject, Integer> map = new HashMap<EObject, Integer>();
				map.put(eObject, (isFromPlacement) ? ICVLEnabledEditor.HL_PLACEMENT : ICVLEnabledEditor.HL_REPLACEMENT);
				list.add(map);
			}else{
				logger.error("inside boundary element reference is null for fromBoundary" + boundary);
			}
			
			EList<ObjectHandle> objectHandles = (isFromPlacement) ? ((FromPlacement) boundary).getOutsideBoundaryElement() : ((FromReplacement) boundary).getOutsideBoundaryElement();
			for(ObjectHandle oh : objectHandles){
				eObject = oh.getMOFRef();
				if(eObject != null){
					HashMap<EObject, Integer> map = new HashMap<EObject, Integer>();
					map.put(eObject, (isFromPlacement) ? ICVLEnabledEditor.HL_PLACEMENT_OUT : ICVLEnabledEditor.HL_REPLACEMENT_OUT);
					list.add(map);
				}else{
					logger.error("outside boundary element reference is null for fromBoundary" + boundary);
				}
			}
		}else{
			throw new IllegalOperationException("WTF!");
		}
		return list;
	}
}
