package no.sintef.cvl.thirdparty.editor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import no.sintef.cvl.thirdparty.exception.NotSupportedThirdPartyEditor;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class ProxyPapyrusDiagramEditor extends PapyrusMultiDiagramEditor implements ICVLEnabledEditor{
	
	private PapyrusMultiDiagramEditor papyrusMultiDiagram;
	private Map<IFigure,Color> foregroundColor = new HashMap<IFigure,Color>();
	private Map<IFigure,Color> backgroundColor = new HashMap<IFigure,Color>();

	public ProxyPapyrusDiagramEditor(Object multiDiagram) throws NotSupportedThirdPartyEditor{
		if(Display.getDefault() == null)
			throw new UnsupportedOperationException("Display is null, can not do any operation which reflects UI, wrapp this call in the Display thread");
		if(!(multiDiagram instanceof PapyrusMultiDiagramEditor))
			throw new NotSupportedThirdPartyEditor("active editor should extend PapyrusMultiDiagramEditor, can not highlight anything");
		papyrusMultiDiagram = (PapyrusMultiDiagramEditor) multiDiagram;
		
	}
	
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
			case ICVLEnabledEditor.HL_REPLACEMENT : 
				c = ICVLEnabledEditor.REPLACEMENT; break;
			case ICVLEnabledEditor.HL_REPLACEMENT_OUT : 
				c = ICVLEnabledEditor.REPLACEMENT_OUT; break;
			case ICVLEnabledEditor.HL_REPLACEMENT_IN : 
				c = ICVLEnabledEditor.REPLACEMENT_IN; break;
			default : 
				throw new UnsupportedOperationException("coloring of this type is not supported " + type);
		}
		
		System.out.println("--------------------------------------------");
		System.out.println(eObject + " " + "type" + type + " color " + c);
		System.out.println("********************************************");
		setColor(eObject, c);
	}

	@Override
	public void selectObjects(ArrayList<Object> objects) {
		// TODO Auto-generated method stub
	}
		
	public void setColor(EObject obj, Color fg) {
		IDiagramGraphicalViewer gv = papyrusMultiDiagram.getDiagramGraphicalViewer();
		
		List<?> editParts = gv.findEditPartsForElement(EMFCoreUtil.getProxyID(obj), EditPart.class);
		
		for (Object object : editParts) {
			System.out.println("EDITPART: " + object);
			System.out.println("EDITPART CLASS: " + object.getClass());
			System.out.println(object instanceof NodeEditPart);
			
			if(object instanceof NodeEditPart){
				NodeEditPart ep = (NodeEditPart) object;
				
				if (!foregroundColor.containsKey(ep.getFigure())){
					foregroundColor.put(ep.getFigure(), ep.getFigure().getForegroundColor());
				}
				
				ep.getFigure().setForegroundColor(fg);
				ep.getFigure().repaint();
			}
			if(object instanceof ClassEditPart){
				ClassEditPart ep = (ClassEditPart) object;
				
				if (!foregroundColor.containsKey(ep.getPrimaryShape())){
					foregroundColor.put(ep.getPrimaryShape(), ep.getPrimaryShape().getForegroundColor());
				}
				
				ep.getPrimaryShape().setForegroundColor(fg);
				ep.getPrimaryShape().repaint();
			}
		}
	}
}
