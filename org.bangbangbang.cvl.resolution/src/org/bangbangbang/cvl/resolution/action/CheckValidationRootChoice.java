package org.bangbangbang.cvl.resolution.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.bangbangbang.cvl.ChoiceResolutuion;
import org.bangbangbang.cvl.ConfigurableUnit;
import org.bangbangbang.cvl.MultiplicityInterval;
import org.bangbangbang.cvl.VClassifier;
import org.bangbangbang.cvl.VInstance;
import org.bangbangbang.cvl.VSpecResolution;
import org.bangbangbang.cvl.resolution.editors.CvlResolutionEditor;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.handlers.HandlerUtil;

public class CheckValidationRootChoice implements IHandler {
	EditingDomain editingDomain = null;
	IEditorPart editorPart = null;
	TreeViewer viewer = null;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		editorPart = HandlerUtil.getActiveEditorChecked(event);
		viewer = (TreeViewer) ((IViewerProvider) editorPart).getViewer();
		Map<String, VSpecResolution> result = new TreeMap<String, VSpecResolution>();

		if (!(editorPart instanceof CvlResolutionEditor)) {
			return null;
		}
		CvlResolutionEditor cvlEditorPart = (CvlResolutionEditor) editorPart;
		editingDomain = cvlEditorPart.getEditingDomain();

		// get Root choice.
		ChoiceResolutuion targetRootChoice;
		if (((TreeSelection) viewer.getSelection()).getFirstElement() instanceof VSpecResolution) {
			VSpecResolution res = (VSpecResolution) ((TreeSelection) viewer
					.getSelection()).getFirstElement();
			while (!(res.eContainer() instanceof ConfigurableUnit)) {
				if (!(res.eContainer() instanceof VSpecResolution)) {
					return null;
				}
				res = (VSpecResolution) res.eContainer();
			}
			targetRootChoice = (ChoiceResolutuion) res;
		} else {
			return null;
		}

		result = traverseResolutionTree(editingDomain, editorPart, viewer,
				targetRootChoice, result);

		if (result.size() == 0) {
			Dialog dialog = new MessageDialog(PlatformUI.getWorkbench()
					.getModalDialogShellProvider().getShell(), "No Violation",
					null, null, 0, null, 0);
			dialog.open();
			return null;
		}

		ListDialog dialog = new ListDialog(PlatformUI.getWorkbench()
				.getModalDialogShellProvider().getShell());
		dialog.setContentProvider(new ArrayContentProvider());
		dialog.setInput(result.entrySet().toArray());
		dialog.setLabelProvider(new LabelProvider() {

			@SuppressWarnings("unchecked")
			@Override
			public String getText(Object element) {
				Entry<String, VSpecResolution> entry;
				if (element instanceof Entry<?, ?>) {
					entry = (Entry<String, VSpecResolution>) element;
					return entry.getKey();
				}
				return "";
			}

		});

		if (dialog.open() == Window.OK) {
			Object[] selection = dialog.getResult();
			if (selection.length > 0) {
				viewer.setSelection(new StructuredSelection(
						((Entry<String, VSpecResolution>) selection[0])
								.getValue()));
			}
		}

		return null;
	}

	public static Map<String, VSpecResolution> traverseResolutionTree(
			EditingDomain editDomain, IEditorPart editPart, TreeViewer viewer,
			ChoiceResolutuion root, Map<String, VSpecResolution> result) {
		// for Root Choice resolution, check group multiplicity
		// and check constraints
		checkGroupMultiplicity(root, result, root);

		// traverse tree of resolution
		for (TreeIterator<EObject> iterator = root.eAllContents(); iterator
				.hasNext();) {
			EObject obj = iterator.next();
			if (!(obj instanceof VSpecResolution)) {
				continue;
			}
			VSpecResolution target = (VSpecResolution) obj;

			// Check : Is target have VInstance child? for checking Instance
			// multiplicity
			Map<VClassifier, Integer> vclassifiers = new HashMap<VClassifier, Integer>();

			EList<VSpecResolution> children = target.getChild();
			for (Iterator<VSpecResolution> childrenIterator = children
					.iterator(); childrenIterator.hasNext();) {
				VSpecResolution res = childrenIterator.next();
				if (res instanceof VInstance
						&& !vclassifiers.containsKey(res.getResolvedVSpec())) {
					vclassifiers.put((VClassifier) res.getResolvedVSpec(), 1);
				} else if (res instanceof VInstance
						&& vclassifiers.containsKey(res.getResolvedVSpec())) {
					vclassifiers.put((VClassifier) res.getResolvedVSpec(),
							vclassifiers.get(res.getResolvedVSpec()) + 1);
				}
			}

			// For each VClassifier, check instance multiplicity
			for (Iterator<Entry<VClassifier, Integer>> vclassifierIterator = vclassifiers
					.entrySet().iterator(); vclassifierIterator.hasNext();) {
				Entry<VClassifier, Integer> entry = vclassifierIterator.next();
				if (entry.getKey().getInstanceMultiplicity() != null
						&& entry.getKey().getInstanceMultiplicity() instanceof MultiplicityInterval) {
					MultiplicityInterval interval = entry.getKey()
							.getInstanceMultiplicity();
					if (interval.getLower() > entry.getValue()
							|| interval.getUpper() < entry.getValue()) {
						// Violation of InstanceMultiplicity with target and
						// entry.getKey()
						result.put(
								String.valueOf(result.size() + 1)
										+ " InstanceMultiplicity Violation ["
										+ String.valueOf(interval.getLower())
										+ ".."
										+ String.valueOf(interval.getUpper())
										+ "] at Product:" + root.getName()
										+ " VClassifier:"
										+ entry.getKey().getName(), target);
					}
				}

			}

			// if target has group multiplicity, check choice decision count of
			// target children
			checkGroupMultiplicity(root, result, target);

		}

		return result;
	}

	private static void checkGroupMultiplicity(ChoiceResolutuion root,
			Map<String, VSpecResolution> result, VSpecResolution target) {
		if ((target instanceof ChoiceResolutuion && ((ChoiceResolutuion) target)
				.getResolvedChoice().getGroupMultiplicity() != null)
				|| (target instanceof VInstance && ((VInstance) target)
						.getType().getGroupMultiplicity() != null)) {
			MultiplicityInterval interval = null;
			if (target instanceof ChoiceResolutuion) {
				interval = ((ChoiceResolutuion) target).getResolvedChoice()
						.getGroupMultiplicity();
			} else if (target instanceof VInstance) {
				interval = ((VInstance) target).getType()
						.getGroupMultiplicity();
			} else {
				assert (false);
			}
			int count = 0;
			for (Iterator<VSpecResolution> childrenIterator = target.getChild()
					.iterator(); childrenIterator.hasNext();) {
				VSpecResolution child = childrenIterator.next();
				if (child instanceof ChoiceResolutuion
						&& ((ChoiceResolutuion) child).isDecision()) {
					count++;
				}
			}
			if (interval.getLower() > count || interval.getUpper() < count) {
				// Violation
				result.put(
						String.valueOf(result.size() + 1)
								+ " GroupMultiplicity Violation ["
								+ String.valueOf(interval.getLower()) + ".."
								+ String.valueOf(interval.getUpper())
								+ "] at Product:" + root.getName()
								+ " Element:"
								+ target.getResolvedVSpec().getName(), target);
			}
		}
	}

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
