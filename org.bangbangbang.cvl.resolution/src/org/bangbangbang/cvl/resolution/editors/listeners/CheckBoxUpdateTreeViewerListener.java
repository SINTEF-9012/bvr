package org.bangbangbang.cvl.resolution.editors.listeners;
import java.util.Iterator;

import org.bangbangbang.cvl.ChoiceResolutuion;
import org.bangbangbang.cvl.ConfigurableUnit;
import org.bangbangbang.cvl.VSpecResolution;
import org.bangbangbang.cvl.resolution.custom.CustomAdapterFactoryContentProvider;
import org.bangbangbang.cvl.resolution.custom.VirtualVClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ITreeViewerListener;
import org.eclipse.jface.viewers.TreeExpansionEvent;

public class CheckBoxUpdateTreeViewerListener implements ITreeViewerListener {
	private CheckboxTreeViewer selectionViewer;

	public CheckBoxUpdateTreeViewerListener(CheckboxTreeViewer viewer) {
		selectionViewer = viewer;
	}

	@Override
	public void treeCollapsed(TreeExpansionEvent event) {

	}

	@Override
	public void treeExpanded(TreeExpansionEvent event) {
		if (event.getElement() instanceof VirtualVClassifier) {
			// VirtualVClassifier is expanded
			// Then children of the parent of
			// the VirtualVClassifier is
			// set Grayed.
			for (Iterator<VSpecResolution> iterator = ((VirtualVClassifier) event
					.getElement()).getParent().getChild().iterator(); iterator
					.hasNext();) {
				EObject element = iterator.next();
				if (element instanceof ChoiceResolutuion) {
					selectionViewer.setChecked(element,
							((ChoiceResolutuion) element).isDecision());
				} else if (element instanceof VSpecResolution
						|| element instanceof ConfigurableUnit) {
					selectionViewer.setGrayChecked(element, true);
				}
			}
		} else if (event.getElement() instanceof VSpecResolution) {

			CustomAdapterFactoryContentProvider contentProvider = (CustomAdapterFactoryContentProvider) ((CheckboxTreeViewer) event
					.getTreeViewer()).getContentProvider();
			Object[] targets = contentProvider.getChildren(event.getElement());

			for (int i = 0; i < targets.length; i++) {
				if (targets[i] instanceof VirtualVClassifier) {
					((CheckboxTreeViewer) event.getTreeViewer())
							.setGrayChecked(targets[i], true);
				}
			}
			for (Iterator<VSpecResolution> iterator = ((VSpecResolution) event
					.getElement()).getChild().iterator(); iterator.hasNext();) {
				EObject element = iterator.next();
				if (element instanceof ChoiceResolutuion) {
					selectionViewer.setChecked(element,
							((ChoiceResolutuion) element).isDecision());
				} else if (element instanceof VSpecResolution
						|| element instanceof ConfigurableUnit) {
					selectionViewer.setGrayChecked(element, true);
				}
			}
		}

	}
}