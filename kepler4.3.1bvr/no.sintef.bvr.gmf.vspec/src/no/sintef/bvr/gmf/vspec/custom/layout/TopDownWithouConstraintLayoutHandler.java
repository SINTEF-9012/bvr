package no.sintef.bvr.gmf.vspec.custom.layout;

import no.sintef.bvr.gmf.vspec.part.CVLMetamodelDiagramEditor;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.draw2d.Animation;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

public class TopDownWithouConstraintLayoutHandler extends AbstractHandler {

	public static final String LAYOUT_TYPE = "WithoutConstraint";

	EditingDomain editingDomain = null;
	IEditorPart editorPart = null;
	Viewer viewer = null;

	protected EditPart getParentEditPart(ExecutionEvent event) {
		editorPart = HandlerUtil.getActiveEditor(event);

		if (!(editorPart instanceof CVLMetamodelDiagramEditor)) {
			return null;
		}
		CVLMetamodelDiagramEditor bvrEditorPart = (CVLMetamodelDiagramEditor) editorPart;
		editingDomain = bvrEditorPart.getEditingDomain();
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
		return parent;
	}

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
		EditPart parent = getParentEditPart(event);

		ArrangeRequest request = new ArrangeRequest(
				ActionIds.ACTION_ARRANGE_ALL, LAYOUT_TYPE);

		Command command = parent.getCommand(request);

		Animation.markBegin();

		command.execute();

		Animation.run(500);
		return null;
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
