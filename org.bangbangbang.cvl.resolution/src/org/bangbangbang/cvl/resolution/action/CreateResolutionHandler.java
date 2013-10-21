package org.bangbangbang.cvl.resolution.action;

import org.bangbangbang.cvl.Choice;
import org.bangbangbang.cvl.ChoiceResolutuion;
import org.bangbangbang.cvl.ConfigurableUnit;
import org.bangbangbang.cvl.CvlFactory;
import org.bangbangbang.cvl.CvlPackage;
import org.bangbangbang.cvl.IntegerLiteralExp;
import org.bangbangbang.cvl.PrimitiveValueSpecification;
import org.bangbangbang.cvl.VClassifier;
import org.bangbangbang.cvl.VInstance;
import org.bangbangbang.cvl.VSpec;
import org.bangbangbang.cvl.VSpecResolution;
import org.bangbangbang.cvl.Variable;
import org.bangbangbang.cvl.VariableValueAssignment;
import org.bangbangbang.cvl.resolution.editors.CvlResolutionEditor;
import org.bangbangbang.cvl.util.CvlSwitch;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

public class CreateResolutionHandler implements IHandler {
	EditingDomain editingDomain = null;
	IEditorPart editorPart = null;
	Viewer viewer = null;

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
		editorPart = HandlerUtil.getActiveEditorChecked(event);
		viewer = ((IViewerProvider) editorPart).getViewer();

		if (!(editorPart instanceof CvlResolutionEditor)) {
			return null;
		}
		CvlResolutionEditor cvlEditorPart = (CvlResolutionEditor) editorPart;
		editingDomain = cvlEditorPart.getEditingDomain();

		// TODO If ConfigurationUnit has composite ConfigurationUnit
		// it needs selection form of configurationUnit
		ConfigurableUnit cu = (ConfigurableUnit) editingDomain.getResourceSet()
				.getResources().get(0).getContents().get(0);

		CreateResolutionVisitor visitor = new CreateResolutionVisitor();
		visitor.setConfigurableUnit(cu);

		for (TreeIterator<EObject> iterator = EcoreUtil
				.getAllContents(cu, true); iterator.hasNext();) {
			EObject modelElement = iterator.next();

			visitor.doSwitch(modelElement);
		}

		// Refresh editor as edited
		if (viewer != null) {
			viewer.refresh();
		}
		return null;
	}

	protected class CreateResolutionVisitor extends CvlSwitch<Object> {
		private ConfigurableUnit cu = null;
		private VSpecResolution root = null;

		public void setConfigurableUnit(ConfigurableUnit cu) {
			this.cu = cu;
		}

		protected VSpecResolution searchParentResolution(VSpec parent) {

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

			if (object.eContainer() instanceof ConfigurableUnit) {
				root = (VSpecResolution) cr;
				Command addCommand = AddCommand
						.create(editingDomain, cu, CvlPackage.eINSTANCE
								.getConfigurableUnit_OwnedVSpecResolution(), cr);
				editingDomain.getCommandStack().execute(addCommand);
				if (object.isIsImpliedByParent()) {
					cr.setDecision(true);
				}
			} else {
				VSpecResolution parent = searchParentResolution((VSpec) object
						.eContainer());
				if (parent == null) {
					parent = root;
				}
				if (object.isIsImpliedByParent()
						&& parent instanceof ChoiceResolutuion) {
					cr.setDecision(((ChoiceResolutuion) parent).isDecision());
				}
				Command addCommand = AddCommand.create(editingDomain, parent,
						CvlPackage.eINSTANCE.getVSpecResolution_Child(), cr);
				editingDomain.getCommandStack().execute(addCommand);

			}
			// Refresh editor as edited
			if (viewer != null) {
				viewer.refresh();
			}
			return super.caseChoice(object);
		}

		@Override
		public Object caseVClassifier(VClassifier object) {
			VInstance vi = CvlFactory.eINSTANCE.createVInstance();
			vi.setResolvedVSpec(object);
			vi.setType(object);

			if (object.eContainer() instanceof ConfigurableUnit) {
				root = (VSpecResolution) vi;
				Command addCommand = AddCommand
						.create(editingDomain, cu, CvlPackage.eINSTANCE
								.getConfigurableUnit_OwnedVSpecResolution(), vi);
				editingDomain.getCommandStack().execute(addCommand);
			} else {
				VSpecResolution parent = searchParentResolution((VSpec) object
						.eContainer());
				if (parent == null) {
					parent = root;
				}
				Command addCommand = AddCommand.create(editingDomain, parent,
						CvlPackage.eINSTANCE.getVSpecResolution_Child(), vi);
				editingDomain.getCommandStack().execute(addCommand);

			}
			// Refresh editor as edited
			if (viewer != null) {
				viewer.refresh();
			}
			return super.caseVClassifier(object);
		}

		@Override
		public Object caseVariable(Variable object) {
			VariableValueAssignment vva = CvlFactory.eINSTANCE
					.createVariableValueAssignment();

			// TODO type variable
			PrimitiveValueSpecification vs = CvlFactory.eINSTANCE
					.createPrimitiveValueSpecification();
			IntegerLiteralExp integer = CvlFactory.eINSTANCE
					.createIntegerLiteralExp();
			integer.setInteger(0);
			vs.setExpression(integer);
			vs.setType(object.getType());
			vva.setValue(vs);

			if (object.eContainer() instanceof ConfigurableUnit) {
				root = (VSpecResolution) vva;
				Command addCommand = AddCommand.create(editingDomain, cu,
						CvlPackage.eINSTANCE
								.getConfigurableUnit_OwnedVSpecResolution(),
						vva);
				editingDomain.getCommandStack().execute(addCommand);
			} else {
				VSpecResolution parent = searchParentResolution((VSpec) object
						.eContainer());
				if (parent == null) {
					parent = root;
				}
				Command addCommand = AddCommand.create(editingDomain, parent,
						CvlPackage.eINSTANCE.getVSpecResolution_Child(), vva);
				editingDomain.getCommandStack().execute(addCommand);

			}
			// Refresh editor as edited
			if (viewer != null) {
				viewer.refresh();
			}
			return super.caseVariable(object);
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