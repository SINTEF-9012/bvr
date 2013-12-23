package org.bangbangbang.cvl.system.vspec.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import org.bangbangbang.cvl.system.vspec.edit.parts.Choice2EditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.ChoiceChoiceGroupMultiplicityCompartment2EditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.ChoiceChoiceGroupMultiplicityCompartmentEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.ChoiceEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.VInterfaceEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.ConstraintContextEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.MultiplicityInterval2EditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.MultiplicityInterval3EditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.MultiplicityInterval4EditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.MultiplicityIntervalEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.OpaqueConstraintEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.VClassifierEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.VClassifierVClassifierGroupMultiplicityCompartmentEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.VClassifierVClassifierInstanceMultiplicityIntervalCompartmentEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.VSpecChildEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.VariableEditPart;
import org.bangbangbang.cvl.system.vspec.part.CVLMetamodelVisualIDRegistry;
import org.bangbangbang.cvl.system.vspec.part.Messages;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

/**
 * @generated
 */
public class CVLMetamodelNavigatorContentProvider implements
		ICommonContentProvider {

	/**
	 * @generated
	 */
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	 * @generated
	 */
	private Viewer myViewer;

	/**
	 * @generated
	 */
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	 * @generated
	 */
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	 * @generated
	 */
	private Runnable myViewerRefreshRunnable;

	/**
	 * @generated
	 */
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public CVLMetamodelNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain,
				new WorkspaceSynchronizer.Delegate() {
					public void dispose() {
					}

					public boolean handleResourceChanged(final Resource resource) {
						unloadAllResources();
						asyncRefresh();
						return true;
					}

					public boolean handleResourceDeleted(Resource resource) {
						unloadAllResources();
						asyncRefresh();
						return true;
					}

					public boolean handleResourceMoved(Resource resource,
							final URI newURI) {
						unloadAllResources();
						asyncRefresh();
						return true;
					}
				});
	}

	/**
	 * @generated
	 */
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		myViewer = null;
		unloadAllResources();
		((TransactionalEditingDomain) myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	 * @generated
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	/**
	 * @generated
	 */
	void unloadAllResources() {
		for (Resource nextResource : myEditingDomain.getResourceSet()
				.getResources()) {
			nextResource.unload();
		}
	}

	/**
	 * @generated
	 */
	void asyncRefresh() {
		if (myViewer != null && !myViewer.getControl().isDisposed()) {
			myViewer.getControl().getDisplay()
					.asyncExec(myViewerRefreshRunnable);
		}
	}

	/**
	 * @generated
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath()
					.toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(
					fileURI, true);
			ArrayList<CVLMetamodelNavigatorItem> result = new ArrayList<CVLMetamodelNavigatorItem>();
			ArrayList<View> topViews = new ArrayList<View>(resource
					.getContents().size());
			for (EObject o : resource.getContents()) {
				if (o instanceof View) {
					topViews.add((View) o);
				}
			}
			result.addAll(createNavigatorItems(
					selectViewsByType(topViews,
							VInterfaceEditPart.MODEL_ID), file, false));
			return result.toArray();
		}

		if (parentElement instanceof CVLMetamodelNavigatorGroup) {
			CVLMetamodelNavigatorGroup group = (CVLMetamodelNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof CVLMetamodelNavigatorItem) {
			CVLMetamodelNavigatorItem navigatorItem = (CVLMetamodelNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (CVLMetamodelVisualIDRegistry.getVisualID(view)) {

		case VInterfaceEditPart.VISUAL_ID: {
			LinkedList<CVLMetamodelAbstractNavigatorItem> result = new LinkedList<CVLMetamodelAbstractNavigatorItem>();
			Diagram sv = (Diagram) view;
			CVLMetamodelNavigatorGroup links = new CVLMetamodelNavigatorGroup(
					Messages.NavigatorGroupName_VInterface_1000_links,
					"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(Choice2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(ChoiceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(VariableEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(VClassifierEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(OpaqueConstraintEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(VSpecChildEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(ConstraintContextEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case Choice2EditPart.VISUAL_ID: {
			LinkedList<CVLMetamodelAbstractNavigatorItem> result = new LinkedList<CVLMetamodelAbstractNavigatorItem>();
			Node sv = (Node) view;
			CVLMetamodelNavigatorGroup incominglinks = new CVLMetamodelNavigatorGroup(
					Messages.NavigatorGroupName_Choice_2002_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			CVLMetamodelNavigatorGroup outgoinglinks = new CVLMetamodelNavigatorGroup(
					Messages.NavigatorGroupName_Choice_2002_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(ChoiceChoiceGroupMultiplicityCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					CVLMetamodelVisualIDRegistry
							.getType(MultiplicityIntervalEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(VSpecChildEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(VSpecChildEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(ConstraintContextEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case VariableEditPart.VISUAL_ID: {
			LinkedList<CVLMetamodelAbstractNavigatorItem> result = new LinkedList<CVLMetamodelAbstractNavigatorItem>();
			Node sv = (Node) view;
			CVLMetamodelNavigatorGroup incominglinks = new CVLMetamodelNavigatorGroup(
					Messages.NavigatorGroupName_Variable_2003_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			CVLMetamodelNavigatorGroup outgoinglinks = new CVLMetamodelNavigatorGroup(
					Messages.NavigatorGroupName_Variable_2003_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(VSpecChildEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(VSpecChildEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(ConstraintContextEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case VClassifierEditPart.VISUAL_ID: {
			LinkedList<CVLMetamodelAbstractNavigatorItem> result = new LinkedList<CVLMetamodelAbstractNavigatorItem>();
			Node sv = (Node) view;
			CVLMetamodelNavigatorGroup incominglinks = new CVLMetamodelNavigatorGroup(
					Messages.NavigatorGroupName_VClassifier_2004_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			CVLMetamodelNavigatorGroup outgoinglinks = new CVLMetamodelNavigatorGroup(
					Messages.NavigatorGroupName_VClassifier_2004_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(VClassifierVClassifierInstanceMultiplicityIntervalCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					CVLMetamodelVisualIDRegistry
							.getType(MultiplicityInterval3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(VClassifierVClassifierGroupMultiplicityCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					CVLMetamodelVisualIDRegistry
							.getType(MultiplicityInterval4EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(VSpecChildEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(VSpecChildEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(ConstraintContextEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case ChoiceEditPart.VISUAL_ID: {
			LinkedList<CVLMetamodelAbstractNavigatorItem> result = new LinkedList<CVLMetamodelAbstractNavigatorItem>();
			Node sv = (Node) view;
			CVLMetamodelNavigatorGroup incominglinks = new CVLMetamodelNavigatorGroup(
					Messages.NavigatorGroupName_Choice_2006_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			CVLMetamodelNavigatorGroup outgoinglinks = new CVLMetamodelNavigatorGroup(
					Messages.NavigatorGroupName_Choice_2006_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(
					Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(ChoiceChoiceGroupMultiplicityCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					CVLMetamodelVisualIDRegistry
							.getType(MultiplicityInterval2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(VSpecChildEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(VSpecChildEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(ConstraintContextEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case OpaqueConstraintEditPart.VISUAL_ID: {
			LinkedList<CVLMetamodelAbstractNavigatorItem> result = new LinkedList<CVLMetamodelAbstractNavigatorItem>();
			Node sv = (Node) view;
			CVLMetamodelNavigatorGroup outgoinglinks = new CVLMetamodelNavigatorGroup(
					Messages.NavigatorGroupName_OpaqueConstraint_2007_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(ConstraintContextEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case VSpecChildEditPart.VISUAL_ID: {
			LinkedList<CVLMetamodelAbstractNavigatorItem> result = new LinkedList<CVLMetamodelAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			CVLMetamodelNavigatorGroup target = new CVLMetamodelNavigatorGroup(
					Messages.NavigatorGroupName_VSpecChild_4001_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			CVLMetamodelNavigatorGroup source = new CVLMetamodelNavigatorGroup(
					Messages.NavigatorGroupName_VSpecChild_4001_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(Choice2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(ChoiceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(VariableEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(VClassifierEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(Choice2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(ChoiceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(VariableEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(VClassifierEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ConstraintContextEditPart.VISUAL_ID: {
			LinkedList<CVLMetamodelAbstractNavigatorItem> result = new LinkedList<CVLMetamodelAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			CVLMetamodelNavigatorGroup target = new CVLMetamodelNavigatorGroup(
					Messages.NavigatorGroupName_ConstraintContext_4002_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			CVLMetamodelNavigatorGroup source = new CVLMetamodelNavigatorGroup(
					Messages.NavigatorGroupName_ConstraintContext_4002_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(Choice2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(ChoiceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(VariableEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(VClassifierEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					CVLMetamodelVisualIDRegistry
							.getType(OpaqueConstraintEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksSourceByType(Collection<Edge> edges,
			String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType())
					&& isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksTargetByType(Collection<Edge> edges,
			String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType())
					&& isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getOutgoingLinksByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getIncomingLinksByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getChildrenByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getDiagramLinksByType(
			Collection<Diagram> diagrams, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (Diagram nextDiagram : diagrams) {
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	// TODO refactor as static method
	/**
	 * @generated
	 */
	private Collection<View> selectViewsByType(Collection<View> views,
			String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (View nextView : views) {
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return VInterfaceEditPart.MODEL_ID
				.equals(CVLMetamodelVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection<CVLMetamodelNavigatorItem> createNavigatorItems(
			Collection<View> views, Object parent, boolean isLeafs) {
		ArrayList<CVLMetamodelNavigatorItem> result = new ArrayList<CVLMetamodelNavigatorItem>(
				views.size());
		for (View nextView : views) {
			result.add(new CVLMetamodelNavigatorItem(nextView, parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof CVLMetamodelAbstractNavigatorItem) {
			CVLMetamodelAbstractNavigatorItem abstractNavigatorItem = (CVLMetamodelAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}
