package no.sintef.bvr.table.resolution.action;

import java.util.HashMap;

import no.sintef.bvr.table.resolution.editors.BvrResolutionEditor;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import bvr.BCLExpression;
import bvr.BooleanLiteralExp;
import bvr.BvrFactory;
import bvr.BvrPackage;
import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.ConfigurableUnit;
import bvr.IntegerLiteralExp;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitiveValueSpecification;
import bvr.PrimitveType;
import bvr.RealLiteralExp;
import bvr.StringLiteralExp;
import bvr.UnlimitedLiteralExp;
import bvr.VClassifier;
import bvr.VSpec;
import bvr.VSpecResolution;
import bvr.Variable;
import bvr.VariableValueAssignment;
import bvr.util.BvrSwitch;

public class CreateResolutionHandler implements IHandler {
	EditingDomain editingDomain = null;
	IEditorPart editorPart = null;
	Viewer viewer = null;

	CompoundCommand command = null;
	HashMap<VSpec, VSpecResolution> parentNodes = null;

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
		command = new CompoundCommand();
		parentNodes = new HashMap<VSpec, VSpecResolution>();

		if (!(editorPart instanceof BvrResolutionEditor)) {
			return null;
		}
		BvrResolutionEditor bvrEditorPart = (BvrResolutionEditor) editorPart;
		editingDomain = bvrEditorPart.getEditingDomain();
		
		XMIResource resource = (XMIResource) editingDomain.getResourceSet().getResource(
				EditUIUtil.getURI(editorPart.getEditorInput()), false);
		if (resource == null) {
			return null;
		}
		ConfigurableUnit cu = (ConfigurableUnit) resource.getContents().get(0);

		CreateResolutionVisitor visitor = new CreateResolutionVisitor();
		visitor.setConfigurableUnit(cu);

		for (TreeIterator<EObject> iterator = EcoreUtil
				.getAllContents(cu, true); iterator.hasNext();) {
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

	protected class CreateResolutionVisitor extends BvrSwitch<Object> {
		private ConfigurableUnit cu = null;
		private VSpecResolution root = null;

		public void setConfigurableUnit(ConfigurableUnit cu) {
			this.cu = cu;
		}

		protected VSpecResolution searchParentResolution(VSpec parent) {

			return parentNodes.get(parent);
		}

		@Override
		public Object caseChoice(Choice object) {
			ChoiceResolutuion cr = BvrFactory.eINSTANCE
					.createChoiceResolutuion();
			cr.setResolvedChoice(object);
			cr.setResolvedVSpec(object);

			if (object.eContainer() instanceof ConfigurableUnit) {
				root = (VSpecResolution) cr;
				Command addCommand = AddCommand
						.create(editingDomain, cu, BvrPackage.eINSTANCE
								.getConfigurableUnit_OwnedVSpecResolution(), cr);
				command.append(addCommand);
				parentNodes.put(object, cr);
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
						BvrPackage.eINSTANCE.getVSpecResolution_Child(), cr);
				command.append(addCommand);
				parentNodes.put(object, cr);
			}

			return true;
		}

		@Override
		public Object caseVClassifier(VClassifier object) {

			return false;
		}

		@Override
		public Object caseVariable(Variable object) {
			VariableValueAssignment vva = BvrFactory.eINSTANCE
					.createVariableValueAssignment();

			PrimitiveValueSpecification vs = BvrFactory.eINSTANCE
					.createPrimitiveValueSpecification();
			BCLExpression exp = null;
			if (((PrimitveType) object.getType()).getType() == PrimitiveTypeEnum.BOOLEAN) {
				exp = BvrFactory.eINSTANCE.createBooleanLiteralExp();
				((BooleanLiteralExp) exp).setBool(false);
			} else if (((PrimitveType) object.getType()).getType() == PrimitiveTypeEnum.INTEGER) {
				exp = BvrFactory.eINSTANCE.createIntegerLiteralExp();
				((IntegerLiteralExp) exp).setInteger(0);
			} else if (((PrimitveType) object.getType()).getType() == PrimitiveTypeEnum.REAL) {
				exp = BvrFactory.eINSTANCE.createRealLiteralExp();
				((RealLiteralExp) exp).setReal("0.0");
			} else if (((PrimitveType) object.getType()).getType() == PrimitiveTypeEnum.UNLIMITED_NATURAL) {
				exp = BvrFactory.eINSTANCE.createUnlimitedLiteralExp();
				((UnlimitedLiteralExp) exp).setUnlimited(0);
			} else if (((PrimitveType) object.getType()).getType() == PrimitiveTypeEnum.STRING) {
				exp = BvrFactory.eINSTANCE.createStringLiteralExp();
				((StringLiteralExp) exp).setString("");
			}

			vs.setExpression(exp);
			vs.setType(object.getType());
			vva.setValue(vs);
			vva.setResolvedVariable(object);
			vva.setResolvedVSpec(object);

			if (object.eContainer() instanceof ConfigurableUnit) {
				root = (VSpecResolution) vva;
				Command addCommand = AddCommand.create(editingDomain, cu,
						BvrPackage.eINSTANCE
								.getConfigurableUnit_OwnedVSpecResolution(),
						vva);
				command.append(addCommand);
				parentNodes.put(object, vva);
			} else {
				VSpecResolution parent = searchParentResolution((VSpec) object
						.eContainer());
				if (parent == null) {
					parent = root;
				}
				Command addCommand = AddCommand.create(editingDomain, parent,
						BvrPackage.eINSTANCE.getVSpecResolution_Child(), vva);
				command.append(addCommand);
				parentNodes.put(object, vva);
			}

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

}