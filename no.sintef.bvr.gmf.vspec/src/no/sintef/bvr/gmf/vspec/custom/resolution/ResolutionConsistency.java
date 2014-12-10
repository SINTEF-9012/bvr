package no.sintef.bvr.gmf.vspec.custom.resolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import bvr.BCLExpression;
import bvr.BooleanLiteralExp;
import bvr.Choice;
import bvr.ChoiceResolutuion;
import bvr.ConfigurableUnit;
import bvr.BvrFactory;
import bvr.BvrPackage;
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

public class ResolutionConsistency {
	private EditingDomain editingDomain;
	private ConfigurableUnit cu;
	private CompoundCommand command;
	private HashMap<VSpec, VSpecResolution> parentNodes = null;

	public ResolutionConsistency() {
		command = new CompoundCommand();

	}

	public void setEditingDomain(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	public void setCu(ConfigurableUnit cu) {
		this.cu = cu;
	}

	public void reformResolutions() {
		assert (cu != null && editingDomain != null);

		if (cu.getOwnedVSpec().size() != 1) {
			return;
		}

		for (Iterator<VSpecResolution> ite = cu.getOwnedVSpecResolution()
				.iterator(); ite.hasNext();) {
			VSpecResolution vsr = ite.next();
			if (vsr.getResolvedVSpec() == cu.getOwnedVSpec().get(0)) {
				reformTraverse(cu.getOwnedVSpec().get(0), vsr);
			}
		}

		editingDomain.getCommandStack().execute(command);
	}

	private void reformTraverse(VSpec vspec, VSpecResolution resolution) {
		assert (resolution.getResolvedVSpec() == vspec);

		// Check variable type...
		if (vspec instanceof Variable
				&& ((Variable) vspec).getType() instanceof PrimitveType
				&& resolution instanceof VariableValueAssignment
				&& ((VariableValueAssignment) resolution).getValue() instanceof PrimitiveValueSpecification) {

			checkVariableType(vspec, resolution);
		}

		// get childrens
		List<VSpec> vsChildren = new ArrayList<VSpec>();
		List<VSpecResolution> resolutionChildren = new ArrayList<VSpecResolution>();
		for (Iterator<VSpec> ite = vspec.getChild().iterator(); ite.hasNext();) {
			vsChildren.add(ite.next());
		}
		for (Iterator<VSpecResolution> ite = resolution.getChild().iterator(); ite
				.hasNext();) {
			resolutionChildren.add(ite.next());
		}
		// traverse matched vspec and vspec resolution
		for (VSpecResolution vsr : resolutionChildren) {
			if (vsChildren.contains(vsr.getResolvedVSpec())) {
				reformTraverse(vsr.getResolvedVSpec(), vsr);
			} else {
				// Delete resolution when resolvedVspec is not contained
				command.append(RemoveCommand.create(editingDomain, vsr));
			}
		}

		// Add resolution when resolution is not exist for choice and variable
		for (VSpec vs : vsChildren) {
			boolean isContain = false;

			for (VSpecResolution vsr : resolutionChildren) {
				if (vsr.getResolvedVSpec() == vs) {
					isContain = true;

				}
			}
			if (!isContain) {

				CreateVInstanceVisitor visitor = new CreateVInstanceVisitor();
				parentNodes = new HashMap<VSpec, VSpecResolution>();
				parentNodes.put(vspec, resolution);
				visitor.doSwitch(vs);

				for (TreeIterator<EObject> iterator = EcoreUtil.getAllContents(
						vs, true); iterator.hasNext();) {
					EObject modelElement = iterator.next();

					Object isContinue = visitor.doSwitch(modelElement);
					if (isContinue != null && !(boolean) isContinue) {
						iterator.prune();
					}
				}
			}
		}

	}

	private void checkVariableType(VSpec vspec, VSpecResolution resolution) {
		BCLExpression exp = null;
		boolean isReplaceNeeded = false;
		if (((PrimitveType) ((Variable) vspec).getType()).getType() == PrimitiveTypeEnum.BOOLEAN
				&& !(((PrimitiveValueSpecification) ((VariableValueAssignment) resolution)
						.getValue()).getExpression() instanceof BooleanLiteralExp)) {
			exp = BvrFactory.eINSTANCE.createBooleanLiteralExp();
			((BooleanLiteralExp) exp).setBool(false);
			isReplaceNeeded = true;
		} else if (((PrimitveType) ((Variable) vspec).getType()).getType() == PrimitiveTypeEnum.INTEGER
				&& !(((PrimitiveValueSpecification) ((VariableValueAssignment) resolution)
						.getValue()).getExpression() instanceof IntegerLiteralExp)) {
			exp = BvrFactory.eINSTANCE.createIntegerLiteralExp();
			((IntegerLiteralExp) exp).setInteger(0);
			isReplaceNeeded = true;
		} else if (((PrimitveType) ((Variable) vspec).getType()).getType() == PrimitiveTypeEnum.REAL
				&& !(((PrimitiveValueSpecification) ((VariableValueAssignment) resolution)
						.getValue()).getExpression() instanceof RealLiteralExp)) {
			exp = BvrFactory.eINSTANCE.createRealLiteralExp();
			((RealLiteralExp) exp).setReal("0.0");
			isReplaceNeeded = true;
		} else if (((PrimitveType) ((Variable) vspec).getType()).getType() == PrimitiveTypeEnum.UNLIMITED_NATURAL
				&& !(((PrimitiveValueSpecification) ((VariableValueAssignment) resolution)
						.getValue()).getExpression() instanceof UnlimitedLiteralExp)) {
			exp = BvrFactory.eINSTANCE.createUnlimitedLiteralExp();
			((UnlimitedLiteralExp) exp).setUnlimited(0);
			isReplaceNeeded = true;
		} else if (((PrimitveType) ((Variable) vspec).getType()).getType() == PrimitiveTypeEnum.STRING
				&& !(((PrimitiveValueSpecification) ((VariableValueAssignment) resolution)
						.getValue()).getExpression() instanceof StringLiteralExp)) {
			exp = BvrFactory.eINSTANCE.createStringLiteralExp();
			((StringLiteralExp) exp).setString("");
			isReplaceNeeded = true;
		}
		if (isReplaceNeeded) {

			command.append(SetCommand
					.create(editingDomain,
							((PrimitiveValueSpecification) ((VariableValueAssignment) resolution)
									.getValue()),
							BvrPackage.eINSTANCE
									.getPrimitiveValueSpecification_Expression(),
							exp));

		}
	}

	protected class CreateVInstanceVisitor extends BvrSwitch<Object> {

		protected VSpecResolution searchParentResolution(VSpec parent) {

			return parentNodes.get(parent);
		}

		@Override
		public Object caseChoice(Choice object) {
			ChoiceResolutuion cr = BvrFactory.eINSTANCE
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
					BvrPackage.eINSTANCE.getVSpecResolution_Child(), cr);
			command.append(addCommand);
			parentNodes.put(object, cr);
			return true;
		}

		@Override
		public Object caseVClassifier(VClassifier object) {
			// Stop iteration under VClassifier

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

			VSpecResolution parent = searchParentResolution((VSpec) object
					.eContainer());
			if (parent == null) {
				return false;
			}
			Command addCommand = AddCommand.create(editingDomain, parent,
					BvrPackage.eINSTANCE.getVSpecResolution_Child(), vva);
			command.append(addCommand);
			parentNodes.put(object, vva);
			return true;
		}
	}

}
