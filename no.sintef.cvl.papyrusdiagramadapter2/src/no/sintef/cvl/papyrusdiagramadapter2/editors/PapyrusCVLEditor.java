package no.sintef.cvl.papyrusdiagramadapter2.editors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;

import org.eclipse.swt.graphics.Color;
import org.eclipse.ui.IEditorPart;


import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;

import no.sintef.cvl.thirdparty.editor.ICVLEnabledEditor;


public class PapyrusCVLEditor extends PapyrusMultiDiagramEditor implements ICVLEnabledEditor {
	
	private Map<IFigure,Color> foregroundColor = new HashMap<IFigure,Color>();
	private Map<IFigure,Color> backgroundColor = new HashMap<IFigure,Color>();
	
	@Override
	public void clearHighlighting() {
		for (Iterator<IFigure> it = foregroundColor.keySet().iterator(); it.hasNext();) {
			IFigure figure = (IFigure) it.next();
			figure.setForegroundColor((Color)foregroundColor.get(figure));
			figure.repaint();
			
		}
		for (Iterator<IFigure> it = backgroundColor.keySet().iterator(); it.hasNext();) {
			IFigure figure = (IFigure) it.next();
			figure.setBackgroundColor((Color)backgroundColor.get(figure));
			figure.repaint();
			
		}
		foregroundColor.clear();
		backgroundColor.clear();
	}

	@Override
	public ArrayList<Object> getSelectedObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void highlightObject(Object object, int type) {
		if(!(object instanceof EObject))
			return;
		
		EObject eObject = (EObject) object;
		Color c = ColorConstants.black;
		switch (type) {
			case ICVLEnabledEditor.HL_PLACEMENT : 
				c = ICVLEnabledEditor.PLACEMENT; break;
			case ICVLEnabledEditor.HL_PLACEMENT_OUT : 
				c = ICVLEnabledEditor.PLACEMENT_OUT; break;
			case ICVLEnabledEditor.HL_PLACEMENT_IN : 
				c = ICVLEnabledEditor.PLACEMENT_IN; break;
			case ICVLEnabledEditor.HL_PLACEMENT_IN_OUT : 
				c = ICVLEnabledEditor.PLACEMENT_IN_OUT; break;
			case ICVLEnabledEditor.HL_REPLACEMENT : 
				c = ICVLEnabledEditor.REPLACEMENT; break;
			case ICVLEnabledEditor.HL_REPLACEMENT_OUT : 
				c = ICVLEnabledEditor.REPLACEMENT_OUT; break;
			case ICVLEnabledEditor.HL_REPLACEMENT_IN : 
				c = ICVLEnabledEditor.REPLACEMENT_IN; break;
			case ICVLEnabledEditor.HL_REPLACEMENT_IN_OUT : 
				c = ICVLEnabledEditor.REPLACEMENT_IN_OUT; break;
			default : 
				throw new UnsupportedOperationException("coloring of this type is not supported " + type);
		}
		
		setColor(eObject, c, getActiveEditor());
	}

	@Override
	public void selectObjects(ArrayList<Object> objects) {
		// TODO Auto-generated method stub
	}
		
	public void setColor(EObject obj, Color fg, IEditorPart editor) {
		IDiagramGraphicalViewer gv = ((IDiagramWorkbenchPart)editor).getDiagramGraphicalViewer();
		
		List<?> editParts = gv.findEditPartsForElement(EMFCoreUtil.getProxyID(obj), EditPart.class);
		
		for (Object object : editParts) {
			if(object instanceof IPapyrusEditPart){
				IPapyrusEditPart ep = (IPapyrusEditPart) object;
				
				if (!foregroundColor.containsKey(ep.getPrimaryShape())){
					foregroundColor.put(ep.getPrimaryShape(), ep.getPrimaryShape().getForegroundColor());
				}
				
				ep.getPrimaryShape().setForegroundColor(fg);
				ep.getPrimaryShape().repaint();
			}
		}
	}
}

