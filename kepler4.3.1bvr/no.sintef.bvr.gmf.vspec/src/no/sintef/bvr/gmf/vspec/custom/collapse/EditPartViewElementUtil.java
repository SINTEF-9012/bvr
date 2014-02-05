package no.sintef.bvr.gmf.vspec.custom.collapse;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import no.sintef.bvr.gmf.vspec.edit.parts.ConstraintContextEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.VSpecChildEditPart;
import no.sintef.bvr.gmf.vspec.part.BVRMetamodelVisualIDRegistry;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import bvr.VSpec;

public class EditPartViewElementUtil {

	private EditPartViewElementUtil() {

	}

	/**
	 * @generated NOT
	 */
	public static List<View> getInvisibleViews(GraphicalEditPart part) {
		List<View> result = new LinkedList<View>();
		
		// TODO avoid other file's gmf resource
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

	/**
	 * @generated NOT
	 */
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

	/**
	 * @generated NOT
	 */
	public static void getSemanticChildrenEditpart(GraphicalEditPart part,
			List<EditPart> list) {
		assert (part.getModel() instanceof VSpec);
		List<EditPart> vspecChilds = part.getSourceConnections();
		for (EditPart ep : vspecChilds) {
			if (ep instanceof VSpecChildEditPart
					&& ((VSpecChildEditPart) ep).getTarget() != null
					&& ((VSpecChildEditPart) ep).getTarget() instanceof EditPart) {
				list.add(((VSpecChildEditPart) ep).getTarget());
				getSemanticChildrenEditpart(
						(GraphicalEditPart) ((VSpecChildEditPart) ep)
								.getTarget(),
						list);
			}
		}
	}

	/**
	 * @generated NOT
	 */
	public static Command getDeleteCommandAsChild(
			TransactionalEditingDomain editDomain, View view) {
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				editDomain, null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (BVRMetamodelVisualIDRegistry.getVisualID(incomingLink) == VSpecChildEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r) {
					protected CommandResult doExecuteWithResult(
							IProgressMonitor progressMonitor, IAdaptable info)
							throws ExecutionException {
						EObject referencedObject = getReferencedObject();
						Resource resource = referencedObject.eResource();
						CommandResult result = super.doExecuteWithResult(
								progressMonitor, info);
						if (resource != null) {
							resource.getContents().add(referencedObject);
						}
						return result;
					}
				});
				cmd.add(new DeleteCommand(editDomain, incomingLink));
				continue;
			}
			if (BVRMetamodelVisualIDRegistry.getVisualID(incomingLink) == ConstraintContextEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(editDomain, incomingLink));
				continue;
			}
		}
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (BVRMetamodelVisualIDRegistry.getVisualID(outgoingLink) == VSpecChildEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r) {
					protected CommandResult doExecuteWithResult(
							IProgressMonitor progressMonitor, IAdaptable info)
							throws ExecutionException {
						EObject referencedObject = getReferencedObject();
						Resource resource = referencedObject.eResource();
						CommandResult result = super.doExecuteWithResult(
								progressMonitor, info);
						if (resource != null) {
							resource.getContents().add(referencedObject);
						}
						return result;
					}
				});
				cmd.add(new DeleteCommand(editDomain, outgoingLink));
				continue;
			}
		}
		cmd.add(new DestroyElementCommand(new DestroyElementRequest(editDomain,
				view.getElement(), false)));
		cmd.add(new DeleteCommand(editDomain, view));

		return new ICommandProxy(cmd.reduce());
	}

}
