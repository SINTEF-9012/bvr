/*******************************************************************************
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package no.sintef.bvr.papyrusdiagram.adapter;

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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.graphics.Color;
import org.eclipse.ui.IEditorPart;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;

import no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor;

// TODO: Auto-generated Javadoc
/**
 * The Class PapyrusBVREditorAdapter implements IBVREnabledEditor. The plugins
 * adopts standard PapyrusMultiDiagramEditor editor to interact with BVR Tool
 * Bundle.
 */
public class PapyrusBVREditorAdapter implements IBVREnabledEditor {

	private PapyrusMultiDiagramEditor editor;

	/** The foreground color. */
	private Map<IFigure, Color> foregroundColor = new HashMap<IFigure, Color>();

	/** The background color. */
	private Map<IFigure, Color> backgroundColor = new HashMap<IFigure, Color>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor#
	 * clearHighlighting()
	 */

	public PapyrusBVREditorAdapter(PapyrusMultiDiagramEditor _editor) {
		editor = _editor;
	}

	@Override
	public void clearHighlighting() {
		for (Iterator<IFigure> it = foregroundColor.keySet().iterator(); it
				.hasNext();) {
			IFigure figure = (IFigure) it.next();
			figure.setForegroundColor((Color) foregroundColor.get(figure));
			figure.repaint();

		}
		for (Iterator<IFigure> it = backgroundColor.keySet().iterator(); it
				.hasNext();) {
			IFigure figure = (IFigure) it.next();
			figure.setBackgroundColor((Color) backgroundColor.get(figure));
			figure.repaint();

		}
		foregroundColor.clear();
		backgroundColor.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor#
	 * getSelectedObjects()
	 */
	@Override
	public List<Object> getSelectedObjects() {
		ISelection selection = editor.getSite().getSelectionProvider()
				.getSelection();
		StructuredSelection structuredSelection = (StructuredSelection) selection;
		return structuredSelection.toList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor#highlightObject
	 * (java.lang.Object, int)
	 */
	@Override
	public void highlightObject(Object object, int type) {
		if (!(object instanceof EObject))
			return;

		EObject eObject = (EObject) object;
		Color c = ColorConstants.black;
		switch (type) {
		case IBVREnabledEditor.HL_PLACEMENT:
			c = IBVREnabledEditor.PLACEMENT;
			break;
		case IBVREnabledEditor.HL_PLACEMENT_OUT:
			c = IBVREnabledEditor.PLACEMENT_OUT;
			break;
		case IBVREnabledEditor.HL_PLACEMENT_IN:
			c = IBVREnabledEditor.PLACEMENT_IN;
			break;
		case IBVREnabledEditor.HL_PLACEMENT_IN_OUT:
			c = IBVREnabledEditor.PLACEMENT_IN_OUT;
			break;
		case IBVREnabledEditor.HL_REPLACEMENT:
			c = IBVREnabledEditor.REPLACEMENT;
			break;
		case IBVREnabledEditor.HL_REPLACEMENT_OUT:
			c = IBVREnabledEditor.REPLACEMENT_OUT;
			break;
		case IBVREnabledEditor.HL_REPLACEMENT_IN:
			c = IBVREnabledEditor.REPLACEMENT_IN;
			break;
		case IBVREnabledEditor.HL_REPLACEMENT_IN_OUT:
			c = IBVREnabledEditor.REPLACEMENT_IN_OUT;
			break;
		default:
			throw new UnsupportedOperationException(
					"coloring of this type is not supported " + type);
		}

		setColor(eObject, c, editor.getActiveEditor());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * no.sintef.bvr.thirdparty.interfaces.editor.IBVREnabledEditor#selectObjects
	 * (java.util.List)
	 */
	@Override
	public void selectObjects(List<Object> objects) {
		IStructuredSelection selection = new StructuredSelection(objects);
		editor.getSite().getSelectionProvider().setSelection(selection);
	}

	/**
	 * Sets the color.
	 *
	 * @param obj
	 *            the obj
	 * @param fg
	 *            the fg
	 * @param editor
	 *            the editor
	 */
	public void setColor(EObject obj, Color fg, IEditorPart editor) {
		IDiagramGraphicalViewer gv = ((IDiagramWorkbenchPart) editor)
				.getDiagramGraphicalViewer();

		List<?> editParts = gv.findEditPartsForElement(
				IDProvider.getXMIId(obj), EditPart.class);

		for (Object object : editParts) {
			if (object instanceof IPapyrusEditPart) {
				IPapyrusEditPart ep = (IPapyrusEditPart) object;

				if (!foregroundColor.containsKey(ep.getPrimaryShape())) {
					foregroundColor.put(ep.getPrimaryShape(), ep
							.getPrimaryShape().getForegroundColor());
				}

				ep.getPrimaryShape().setForegroundColor(fg);
				ep.getPrimaryShape().repaint();
			}
		}
	}
}
