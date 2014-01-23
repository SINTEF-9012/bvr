package no.sintef.bvr.table.resolution.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import no.sintef.bvr.table.resolution.editors.BvrResolutionEditor;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.ConfigurableUnit;
import bvr.Constraint;
import bvr.BvrPackage;
import bvr.MultiplicityInterval;
import bvr.OpaqueConstraint;
import bvr.VClassifier;
import bvr.VInstance;
import bvr.VSpecResolution;
import bvr.Variable;

public class CheckValidationRootChoice implements IHandler {
	EditingDomain editingDomain = null;
	IEditorPart editorPart = null;
	TreeViewer viewer = null;

	public static class ViolationEntry {
		public String message;
		public VSpecResolution target;

		public ViolationEntry(String message, VSpecResolution target) {
			this.message = message;
			this.target = target;
		}
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		editorPart = HandlerUtil.getActiveEditorChecked(event);
		viewer = (TreeViewer) ((IViewerProvider) editorPart).getViewer();
		List<ViolationEntry> result = new ArrayList<ViolationEntry>();

		if (!(editorPart instanceof BvrResolutionEditor)) {
			return null;
		}
		BvrResolutionEditor bvrEditorPart = (BvrResolutionEditor) editorPart;
		editingDomain = bvrEditorPart.getEditingDomain();

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
			MessageDialog.openInformation(PlatformUI.getWorkbench()
					.getModalDialogShellProvider().getShell(),
					"Check Violation", "No Violation");

			return null;
		}

		ListDialog dialog = new ListDialog(PlatformUI.getWorkbench()
				.getModalDialogShellProvider().getShell());
		dialog.setContentProvider(new ArrayContentProvider());
		dialog.setInput(result.toArray());
		dialog.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(Object element) {
				ViolationEntry entry;
				if (element instanceof ViolationEntry) {
					entry = (ViolationEntry) element;
					return entry.message;
				}
				return "";
			}

		});

		if (dialog.open() == Window.OK) {
			Object[] selection = dialog.getResult();
			if (selection.length > 0) {
				viewer.setSelection(new StructuredSelection(
						((ViolationEntry) selection[0]).target));
			}
		}

		return null;
	}

	public static List<ViolationEntry> traverseResolutionTree(
			EditingDomain editDomain, IEditorPart editPart, TreeViewer viewer,
			ChoiceResolutuion root, List<ViolationEntry> result) {
		// for Root Choice resolution, check group and instance multiplicity
		// and check constraints
		checkInstanceMultiplicity(root, result, root);
		checkGroupMultiplicity(root, result, root);
		checkOCLConstraint(root, result, root);

		// traverse tree of resolution
		for (TreeIterator<EObject> iterator = root.eAllContents(); iterator
				.hasNext();) {
			EObject obj = iterator.next();
			if (!(obj instanceof VSpecResolution)) {
				continue;
			}
			VSpecResolution target = (VSpecResolution) obj;

			// check instance multiplicity
			checkInstanceMultiplicity(root, result, target);
			// check group multiplicity
			checkGroupMultiplicity(root, result, target);

			checkOCLConstraint(root, result, target);
		}

		return result;
	}

	private static void checkInstanceMultiplicity(ChoiceResolutuion root,
			List<ViolationEntry> result, VSpecResolution target) {
		// Check : Is target have VInstance child? for checking Instance
		// multiplicity
		Map<VClassifier, Integer> vclassifiers = new HashMap<VClassifier, Integer>();
		EList<VSpecResolution> children = target.getChild();
		for (Iterator<VSpecResolution> childrenIterator = children.iterator(); childrenIterator
				.hasNext();) {
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
					result.add(new ViolationEntry(
							" InstanceMultiplicity Violation ["
									+ String.valueOf(interval.getLower())
									+ ".."
									+ String.valueOf(interval.getUpper())
									+ "] at Product:" + root.getName()
									+ " VClassifier:"
									+ entry.getKey().getName(), target));

				}
			}

		}
	}

	private static void checkGroupMultiplicity(ChoiceResolutuion root,
			List<ViolationEntry> result, VSpecResolution target) {
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
				result.add(new ViolationEntry(" GroupMultiplicity Violation ["
						+ String.valueOf(interval.getLower()) + ".."
						+ String.valueOf(interval.getUpper()) + "] at Product:"
						+ root.getName() + " Element:"
						+ target.getResolvedVSpec().getName(), target));
			}
		}
	}

	private static void checkOCLConstraint(ChoiceResolutuion root,
			List<ViolationEntry> result, VSpecResolution target) {
		ConfigurableUnit cu = null;
		if (root.eContainer() instanceof ConfigurableUnit) {
			cu = (ConfigurableUnit) root.eContainer();
		} else {
			assert (false);
		}

		// get constraints that context is target's vspec
		EList<Constraint> constraints = new BasicEList<Constraint>();
		constraints.addAll(cu.getOwnedConstraint());
		for (Iterator<Constraint> iterator = constraints.iterator(); iterator
				.hasNext();) {
			Constraint c = iterator.next();
			if (c.getContext() != target.getResolvedVSpec()
					|| !(c instanceof OpaqueConstraint)) {
				iterator.remove();
			}
		}

		for (Constraint constraint : constraints) {
			OCLExpression<EClassifier> invariant = null;
			try {
				// create an OCL instance for Ecore
				OCL<?, EClassifier, ?, ?, ?, ?, ?, ?, ?, org.eclipse.ocl.ecore.Constraint, EClass, EObject> ocl;
				ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);

				// create an OCL helper object
				OCLHelper<EClassifier, ?, ?, org.eclipse.ocl.ecore.Constraint> helper = ocl
						.createOCLHelper();

				// set the OCL context classifier
				if (constraint.getContext() instanceof Choice) {
					helper.setContext(BvrPackage.Literals.CHOICE_RESOLUTUION);
				} else if (constraint.getContext() instanceof VClassifier) {
					helper.setContext(BvrPackage.Literals.VINSTANCE);
				} else if (constraint.getContext() instanceof Variable) {
					helper.setContext(BvrPackage.Literals.VARIABLE_VALUE_ASSIGNMENT);
				} else {
					helper.setContext(BvrPackage.Literals.VSPEC_RESOLUTION);
				}
				
				invariant = helper.createQuery(((OpaqueConstraint) constraint)
						.getConstraint());
				if (!ocl.check(target, invariant)) {
					// Violation
					result.add(new ViolationEntry(" OCL Violation ["
							+ ((OpaqueConstraint) constraint).getConstraint()
							+ "] at Product:" + root.getName() + " Element:"
							+ target.getResolvedVSpec().getName(), target));
				}

			} catch (ParserException e) {
				MessageDialog.openInformation(PlatformUI.getWorkbench()
						.getModalDialogShellProvider().getShell(),
						"Check Violation", "OCL Syntax error");
				return;
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
