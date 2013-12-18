package org.bangbangbang.cvl.diagram.custom.collapse;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.bangbangbang.cvl.VSpec;
import org.bangbangbang.cvl.diagram.edit.parts.VSpecChildEditPart;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

public class EditPartViewElementUtil {

	private EditPartViewElementUtil() {

	}

	/**
	 * @generated NOT
	 */
	public static List<View> getInvisibleViews(GraphicalEditPart part) {
		List<View> result = new LinkedList<View>();
		ResourceSet resSet = part.getEditingDomain().getResourceSet();
		for (Resource res : resSet.getResources()) {
			if (res instanceof GMFResource) {
				Iterator<EObject> it = res.getAllContents();
				while (it.hasNext()) {
					EObject obj = it.next();
					if (obj instanceof View) {
						View v = (View) obj;
						if (v.isVisible() == false) {
							result.add(v);
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	public static List<EObject> getSemanticChildren(GraphicalEditPart part) {
		assert (part.getModel() instanceof VSpec);
		List<EObject> children = new LinkedList<EObject>();
		for (TreeIterator<EObject> ti = ((VSpec) ((Node) part.getModel())
				.getElement()).eAllContents(); ti.hasNext();) {
			children.add(ti.next());
		}
		return children;
	}

	public static EditPart getEditPartFromView(View v) {

		IWorkbenchPage page = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		if (page != null) {
			IEditorPart editor = page.getActiveEditor();
			if (editor instanceof GraphicalEditor) {
				GraphicalEditor graphicalEditor = (GraphicalEditor) editor;
				GraphicalViewer gv = (GraphicalViewer) graphicalEditor
						.getAdapter(GraphicalViewer.class);
				for (@SuppressWarnings("rawtypes")
				Iterator ite = gv.getEditPartRegistry().values().iterator(); ite
						.hasNext();) {
					EditPart e = (EditPart) ite.next();
					if (e.getModel() == v) {
						return e;
					}
				}
			}
		}
		return null;
	}

	public static List<EditPart> getAllEditPart() {
		List<EditPart> result = new LinkedList<EditPart>();
		IWorkbenchPage page = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		if (page != null) {
			IEditorPart editor = page.getActiveEditor();
			if (editor instanceof GraphicalEditor) {
				GraphicalEditor graphicalEditor = (GraphicalEditor) editor;
				GraphicalViewer gv = (GraphicalViewer) graphicalEditor
						.getAdapter(GraphicalViewer.class);
				for (@SuppressWarnings("rawtypes")
				Iterator ite = gv.getEditPartRegistry().values().iterator(); ite
						.hasNext();) {
					EditPart e = (EditPart) ite.next();
					result.add(e);
				}
			}
		}
		return result;
	}

	public static boolean isCollapsed(EditPart e) {
		// Check collapsed or expanded
		boolean isCollapsed = false;
		if (e instanceof GraphicalEditPart) {
			@SuppressWarnings("unchecked")
			List<EditPart> childrenLink = ((GraphicalEditPart) e)
					.getSourceConnections();
			if (childrenLink.size() > 0
					&& childrenLink.get(0) instanceof VSpecChildEditPart
					&& ((VSpecChildEditPart) childrenLink.get(0)).getTarget() == null) {
				isCollapsed = true;
			}
			if (childrenLink.size() == 0
					&& EditPartViewElementUtil.getSemanticChildren(
							(GraphicalEditPart) e).size() > 0) {
				isCollapsed = true;
			}
		}
		return isCollapsed;
	}
}
