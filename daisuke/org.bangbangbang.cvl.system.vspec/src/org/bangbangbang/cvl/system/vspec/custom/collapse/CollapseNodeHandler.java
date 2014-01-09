package org.bangbangbang.cvl.system.vspec.custom.collapse;

import java.util.List;

import org.bangbangbang.cvl.system.vspec.edit.parts.VSpecChildEditPart;
import org.bangbangbang.cvl.system.vspec.part.CVLSystemVSpecEditor;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.NotationPackageImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

public class CollapseNodeHandler extends AbstractHandler {

	public static final String LAYOUT_TYPE = "WithoutConstraint";

	protected EditingDomain editingDomain = null;
	protected IEditorPart editorPart = null;
	protected Viewer viewer = null;

	protected CompoundCommand cmds;

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		editorPart = HandlerUtil.getActiveEditor(event);

		if (!(editorPart instanceof CVLSystemVSpecEditor)) {
			return null;
		}
		CVLSystemVSpecEditor cvlEditorPart = (CVLSystemVSpecEditor) editorPart;
		editingDomain = cvlEditorPart.getEditingDomain();
		ISelection selection = null;
		try {
			selection = HandlerUtil.getCurrentSelectionChecked(event);
		} catch (ExecutionException e) {

		}
		assert selection instanceof IStructuredSelection;
		assert ((IStructuredSelection) selection).size() == 1;
		assert ((IStructuredSelection) selection).getFirstElement() instanceof EditPart;
		EditPart parent = (EditPart) ((IStructuredSelection) selection)
				.getFirstElement();

		while (parent != null && !(parent instanceof DiagramEditPart)
				&& !(parent instanceof ShapeCompartmentEditPart)) {
			parent = parent.getParent();
		}

		cmds = new CompoundCommand();

		// Check collapsed or expanded
		boolean isCollapsed = EditPartViewElementUtil
				.isCollapsed((GraphicalEditPart) ((IStructuredSelection) selection)
						.getFirstElement());

		// Collapse or Expand
		if (isCollapsed) {
			// Expand
			expandChildren(editingDomain, cmds,
					((IStructuredSelection) selection).getFirstElement());
			FillStyle style = (FillStyle) ((GraphicalEditPart) ((IStructuredSelection) selection)
					.getFirstElement()).getNotationView().getStyle(
					NotationPackageImpl.eINSTANCE.getFillStyle());
			SetCommand cmd = new SetCommand(editingDomain, style,
					NotationPackageImpl.eINSTANCE.getFillStyle_FillColor(),
					0xffffff);
			cmds.append(cmd);
		} else {
			Object element = ((IStructuredSelection) selection)
					.getFirstElement();
			if (((GraphicalEditPart) element).getSourceConnections().size() != 0) {

				// Collapse
				collapseChildren(editingDomain, cmds,
						((IStructuredSelection) selection).getFirstElement());
				FillStyle style = (FillStyle) ((GraphicalEditPart) ((IStructuredSelection) selection)
						.getFirstElement()).getNotationView().getStyle(
						NotationPackageImpl.eINSTANCE.getFillStyle());
				SetCommand cmd = new SetCommand(editingDomain, style,
						NotationPackageImpl.eINSTANCE.getFillStyle_FillColor(),
						0xdddddd);
				cmds.append(cmd);
			}
		}

		editingDomain.getCommandStack().execute(cmds);

		// Refresh all editpart
		for (EditPart e : EditPartViewElementUtil.getAllEditPart()) {
			e.refresh();
		}

		return null;
	}

	public static void collapseChildren(EditingDomain editingDomain,
			CompoundCommand cmds, Object firstElement) {

		assert (firstElement instanceof GraphicalEditPart);

		@SuppressWarnings("unchecked")
		List<EditPart> childrenLink = ((GraphicalEditPart) firstElement)
				.getSourceConnections();

		// Set white
		FillStyle style = (FillStyle) ((GraphicalEditPart) firstElement)
				.getNotationView().getStyle(
						NotationPackageImpl.eINSTANCE.getFillStyle());
		SetCommand colorcmd = new SetCommand(editingDomain, style,
				NotationPackageImpl.eINSTANCE.getFillStyle_FillColor(),
				0xffffff);
		cmds.append(colorcmd);

		for (EditPart childLink : childrenLink) {
			if (childLink instanceof VSpecChildEditPart) {

				// Target node invisible
				if (((VSpecChildEditPart) childLink).getTarget() instanceof GraphicalEditPart) {
					GraphicalEditPart child = (GraphicalEditPart) ((VSpecChildEditPart) childLink)
							.getTarget();

					// set invisible
					if (child.getNotationView() instanceof View) {
						// set invisible
						SetCommand cmd = new SetCommand(
								editingDomain,
								child.getNotationView(),
								NotationPackageImpl.eINSTANCE.getView_Visible(),
								Boolean.FALSE);
						cmds.append(cmd);

						// traverse
						collapseChildren(editingDomain, cmds, child);
					}
				}
			}
		}
		((GraphicalEditPart) firstElement).refresh();
	}

	public static void expandChildren(EditingDomain editingDomain,
			CompoundCommand cmds, Object firstElement) {
		assert (firstElement instanceof GraphicalEditPart);

		List<EObject> children = EditPartViewElementUtil
				.getSemanticChildren((GraphicalEditPart) firstElement);

		for (View view : EditPartViewElementUtil
				.getInvisibleViews((GraphicalEditPart) firstElement)) {
			if (children.contains(view.getElement())) {
				SetCommand cmd = new SetCommand(editingDomain, view,
						NotationPackage.Literals.VIEW__VISIBLE, Boolean.TRUE);
				cmds.append(cmd);
			}
		}

	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

}
