package org.bangbangbang.cvl.resolution.action;

import org.bangbangbang.cvl.BCLExpression;
import org.bangbangbang.cvl.BooleanLiteralExp;
import org.bangbangbang.cvl.Choice;
import org.bangbangbang.cvl.ChoiceResolutuion;
import org.bangbangbang.cvl.CvlFactory;
import org.bangbangbang.cvl.CvlPackage;
import org.bangbangbang.cvl.IntegerLiteralExp;
import org.bangbangbang.cvl.PrimitiveTypeEnum;
import org.bangbangbang.cvl.PrimitiveValueSpecification;
import org.bangbangbang.cvl.PrimitveType;
import org.bangbangbang.cvl.RealLiteralExp;
import org.bangbangbang.cvl.StringLiteralExp;
import org.bangbangbang.cvl.UnlimitedLiteralExp;
import org.bangbangbang.cvl.VClassifier;
import org.bangbangbang.cvl.VInstance;
import org.bangbangbang.cvl.VSpec;
import org.bangbangbang.cvl.VSpecResolution;
import org.bangbangbang.cvl.Variable;
import org.bangbangbang.cvl.VariableValueAssignment;
import org.bangbangbang.cvl.resolution.custom.VirtualVClassifier;
import org.bangbangbang.cvl.resolution.editors.CvlResolutionEditor;
import org.bangbangbang.cvl.util.CvlSwitch;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

public class CreateVInstanceHandler implements IHandler {
	EditingDomain editingDomain = null;
	IEditorPart editorPart = null;
	Viewer viewer = null;

	CompoundCommand command = null;

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		editorPart = HandlerUtil.getActiveEditorChecked(event);
		viewer = ((IViewerProvider) editorPart).getViewer();

		command = new CompoundCommand();

		if (!(editorPart instanceof CvlResolutionEditor)) {
			return null;
		}
		CvlResolutionEditor cvlEditorPart = (CvlResolutionEditor) editorPart;
		editingDomain = cvlEditorPart.getEditingDomain();

		VirtualVClassifier virtualVClassifier;
		if (((TreeSelection) viewer.getSelection()).getFirstElement() instanceof VirtualVClassifier) {
			virtualVClassifier = (VirtualVClassifier) ((TreeSelection) viewer
					.getSelection()).getFirstElement();
		} else {
			return null;
		}

		VInstance vi = CvlFactory.eINSTANCE.createVInstance();
		vi.setResolvedVSpec(virtualVClassifier.getResolvedVSpec());
		vi.setType((VClassifier) virtualVClassifier.getResolvedVSpec());

		Command addCommand = AddCommand.create(editingDomain,
				virtualVClassifier.getParent(),
				CvlPackage.eINSTANCE.getVSpecResolution_Child(), vi);
		command.append(addCommand);

		CreateVInstanceVisitor visitor = new CreateVInstanceVisitor();
		visitor.setRoot(vi);

		for (TreeIterator<EObject> iterator = EcoreUtil.getAllContents(
				virtualVClassifier.getResolvedVSpec(), true); iterator
				.hasNext();) {
			EObject modelElement = iterator.next();

			Object isContinue = visitor.doSwitch(modelElement);
			if (isContinue != null && !(boolean) isContinue) {
				iterator.prune();
			}
		}

		editingDomain.getCommandStack().execute(command);

		// Refresh editor as edited
		if (viewer != null) {
			viewer.refresh();
		}
		return null;
	}

	protected class CreateVInstanceVisitor extends CvlSwitch<Object> {
		private VSpecResolution root = null;

		public void setRoot(VSpecResolution root) {
			this.root = root;
		}

		protected VSpecResolution searchParentResolution(VSpec parent) {
			if (root.getResolvedVSpec() == parent) {
				return root;
			}
			for (TreeIterator<EObject> iterator = EcoreUtil.getAllContents(
					root, true); iterator.hasNext();) {
				EObject element = iterator.next();
				if (element instanceof VSpecResolution
						&& ((VSpecResolution) element).getResolvedVSpec() == parent) {
					return ((VSpecResolution) element);
				}
			}

			return null;
		}

		@Override
		public Object caseChoice(Choice object) {
			ChoiceResolutuion cr = CvlFactory.eINSTANCE
					.createChoiceResolutuion();
			cr.setResolvedChoice(object);
			cr.setResolvedVSpec(object);

			VSpecResolution parent = searchParentResolution((VSpec) object
					.eContainer());
			if (parent == null) {
				return false;
			}
			if (object.isIsImpliedByParent()
					&& parent instanceof ChoiceResolutuion) {
				cr.setDecision(((ChoiceResolutuion) parent).isDecision());
			}
			Command addCommand = AddCommand.create(editingDomain, parent,
					CvlPackage.eINSTANCE.getVSpecResolution_Child(), cr);
			command.append(addCommand);
			return true;
		}

		@Override
		public Object caseVClassifier(VClassifier object) {
			// Stop iteration under VClassifier

			return false;
		}

		@Override
		public Object caseVariable(Variable object) {
			VariableValueAssignment vva = CvlFactory.eINSTANCE
					.createVariableValueAssignment();

			PrimitiveValueSpecification vs = CvlFactory.eINSTANCE
					.createPrimitiveValueSpecification();
			BCLExpression exp = null;
			if (((PrimitveType) object.getType()).getType() == PrimitiveTypeEnum.BOOLEAN) {
				exp = CvlFactory.eINSTANCE.createBooleanLiteralExp();
				// TODO default value
				((BooleanLiteralExp) exp).setBool(false);
			} else if (((PrimitveType) object.getType()).getType() == PrimitiveTypeEnum.INTEGER) {
				exp = CvlFactory.eINSTANCE.createIntegerLiteralExp();
				// TODO default value
				((IntegerLiteralExp) exp).setInteger(0);
			} else if (((PrimitveType) object.getType()).getType() == PrimitiveTypeEnum.REAL) {
				exp = CvlFactory.eINSTANCE.createRealLiteralExp();
				// TODO default value
				((RealLiteralExp) exp).setReal("0.0");
			} else if (((PrimitveType) object.getType()).getType() == PrimitiveTypeEnum.UNLIMITED_NATURAL) {
				exp = CvlFactory.eINSTANCE.createUnlimitedLiteralExp();
				// TODO default value
				((UnlimitedLiteralExp) exp).setUnlimited(0);
			} else if (((PrimitveType) object.getType()).getType() == PrimitiveTypeEnum.STRING) {
				exp = CvlFactory.eINSTANCE.createStringLiteralExp();
				// TODO default value
				((StringLiteralExp) exp).setString("");
			}

			vs.setExpression(exp);
			vs.setType(object.getType());
			vva.setValue(vs);
			vva.setResolvedVariable(object);
			vva.setResolvedVSpec(object);

			VSpecResolution parent = searchParentResolution((VSpec) object
					.eContainer());
			if (parent == null) {
				return false;
			}
			Command addCommand = AddCommand.create(editingDomain, parent,
					CvlPackage.eINSTANCE.getVSpecResolution_Child(), vva);
			command.append(addCommand);

			return true;
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

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {

	}

}
