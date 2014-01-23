package no.sintef.bvr.gmf.vspec.part;

import no.sintef.bvr.gmf.vspec.edit.parts.Choice2EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.ChoiceChoiceGroupMultiplicityCompartment2EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.ChoiceChoiceGroupMultiplicityCompartmentEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.ChoiceEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.ChoiceName2EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.ChoiceNameEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.ConfigurableUnitEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.MultiplicityInterval2EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.MultiplicityInterval3EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.MultiplicityInterval4EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.MultiplicityIntervalEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.MultiplicityIntervalLowerUpper2EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.MultiplicityIntervalLowerUpper3EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.MultiplicityIntervalLowerUpper4EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.MultiplicityIntervalLowerUpperEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.OpaqueConstraintConstraintEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.OpaqueConstraintEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.VClassifierEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.VClassifierMultiplicityIntervalCompartment2EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.VClassifierMultiplicityIntervalCompartmentEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.VClassifierNameEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.VariableEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.VariableNameEditPart;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

import bvr.Choice;
import bvr.ConfigurableUnit;
import bvr.BvrPackage;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented by
 * a domain model object.
 * 
 * @generated
 */
public class BVRMetamodelVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "no.sintef.bvr.gmf.vspec/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (ConfigurableUnitEditPart.MODEL_ID.equals(view.getType())) {
				return ConfigurableUnitEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return no.sintef.bvr.gmf.vspec.part.BVRMetamodelVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				BVRMetamodelDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (BvrPackage.eINSTANCE.getConfigurableUnit().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((ConfigurableUnit) domainElement)) {
			return ConfigurableUnitEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = no.sintef.bvr.gmf.vspec.part.BVRMetamodelVisualIDRegistry
				.getModelID(containerView);
		if (!ConfigurableUnitEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (ConfigurableUnitEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = no.sintef.bvr.gmf.vspec.part.BVRMetamodelVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ConfigurableUnitEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case ConfigurableUnitEditPart.VISUAL_ID:
			if (BvrPackage.eINSTANCE.getChoice().isSuperTypeOf(
					domainElement.eClass())
					&& isChoice_2005((Choice) domainElement)) {
				return ChoiceEditPart.VISUAL_ID;
			}
			if (BvrPackage.eINSTANCE.getChoice().isSuperTypeOf(
					domainElement.eClass())) {
				return Choice2EditPart.VISUAL_ID;
			}
			if (BvrPackage.eINSTANCE.getVariable().isSuperTypeOf(
					domainElement.eClass())) {
				return VariableEditPart.VISUAL_ID;
			}
			if (BvrPackage.eINSTANCE.getVClassifier().isSuperTypeOf(
					domainElement.eClass())) {
				return VClassifierEditPart.VISUAL_ID;
			}
			if (BvrPackage.eINSTANCE.getOpaqueConstraint().isSuperTypeOf(
					domainElement.eClass())) {
				return OpaqueConstraintEditPart.VISUAL_ID;
			}
			break;
		case ChoiceChoiceGroupMultiplicityCompartment2EditPart.VISUAL_ID:
			if (BvrPackage.eINSTANCE.getMultiplicityInterval().isSuperTypeOf(
					domainElement.eClass())) {
				return MultiplicityIntervalEditPart.VISUAL_ID;
			}
			break;
		case ChoiceChoiceGroupMultiplicityCompartmentEditPart.VISUAL_ID:
			if (BvrPackage.eINSTANCE.getMultiplicityInterval().isSuperTypeOf(
					domainElement.eClass())) {
				return MultiplicityInterval3EditPart.VISUAL_ID;
			}
			break;
		case VClassifierMultiplicityIntervalCompartmentEditPart.VISUAL_ID:
			if (BvrPackage.eINSTANCE.getMultiplicityInterval().isSuperTypeOf(
					domainElement.eClass())) {
				return MultiplicityInterval4EditPart.VISUAL_ID;
			}
			break;
		case VClassifierMultiplicityIntervalCompartment2EditPart.VISUAL_ID:
			if (BvrPackage.eINSTANCE.getMultiplicityInterval().isSuperTypeOf(
					domainElement.eClass())) {
				return MultiplicityInterval2EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = no.sintef.bvr.gmf.vspec.part.BVRMetamodelVisualIDRegistry
				.getModelID(containerView);
		if (!ConfigurableUnitEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (ConfigurableUnitEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = no.sintef.bvr.gmf.vspec.part.BVRMetamodelVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ConfigurableUnitEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case ConfigurableUnitEditPart.VISUAL_ID:
			if (ChoiceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Choice2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (VariableEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (VClassifierEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OpaqueConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ChoiceEditPart.VISUAL_ID:
			if (ChoiceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ChoiceChoiceGroupMultiplicityCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Choice2EditPart.VISUAL_ID:
			if (ChoiceName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ChoiceChoiceGroupMultiplicityCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case VariableEditPart.VISUAL_ID:
			if (VariableNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case VClassifierEditPart.VISUAL_ID:
			if (VClassifierNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (VClassifierMultiplicityIntervalCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (VClassifierMultiplicityIntervalCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OpaqueConstraintEditPart.VISUAL_ID:
			if (OpaqueConstraintConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MultiplicityIntervalEditPart.VISUAL_ID:
			if (MultiplicityIntervalLowerUpperEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MultiplicityInterval3EditPart.VISUAL_ID:
			if (MultiplicityIntervalLowerUpper3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MultiplicityInterval2EditPart.VISUAL_ID:
			if (MultiplicityIntervalLowerUpper2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MultiplicityInterval4EditPart.VISUAL_ID:
			if (MultiplicityIntervalLowerUpper4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ChoiceChoiceGroupMultiplicityCompartment2EditPart.VISUAL_ID:
			if (MultiplicityIntervalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ChoiceChoiceGroupMultiplicityCompartmentEditPart.VISUAL_ID:
			if (MultiplicityInterval3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case VClassifierMultiplicityIntervalCompartmentEditPart.VISUAL_ID:
			if (MultiplicityInterval4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case VClassifierMultiplicityIntervalCompartment2EditPart.VISUAL_ID:
			if (MultiplicityInterval2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(ConfigurableUnit element) {
		return true;
	}

	/**
	 * @generated NOT
	 * 
	 */
	private static boolean isChoice_2005(Choice domainElement) {
		// FIXED: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		if (domainElement.eContainer() != null
				&& domainElement.eContainer().eClass().getName()
						.indexOf("ConfigurableUnit") >= 0) {
			return true;
		} else {
			return false;
		}

		// throw new UnsupportedOperationException(
		//				"No java implementation provided in 'isChoice_2005' operation"); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView,
			EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		switch (visualID) {
		case ChoiceChoiceGroupMultiplicityCompartment2EditPart.VISUAL_ID:
		case ChoiceChoiceGroupMultiplicityCompartmentEditPart.VISUAL_ID:
		case VClassifierMultiplicityIntervalCompartmentEditPart.VISUAL_ID:
		case VClassifierMultiplicityIntervalCompartment2EditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case ConfigurableUnitEditPart.VISUAL_ID:
			return false;
		case OpaqueConstraintEditPart.VISUAL_ID:
		case VariableEditPart.VISUAL_ID:
		case MultiplicityInterval2EditPart.VISUAL_ID:
		case MultiplicityIntervalEditPart.VISUAL_ID:
		case MultiplicityInterval3EditPart.VISUAL_ID:
		case MultiplicityInterval4EditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		 * @generated
		 */
		@Override
		public int getVisualID(View view) {
			return no.sintef.bvr.gmf.vspec.part.BVRMetamodelVisualIDRegistry
					.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return no.sintef.bvr.gmf.vspec.part.BVRMetamodelVisualIDRegistry
					.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return no.sintef.bvr.gmf.vspec.part.BVRMetamodelVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView,
				EObject domainElement, int candidate) {
			return no.sintef.bvr.gmf.vspec.part.BVRMetamodelVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return no.sintef.bvr.gmf.vspec.part.BVRMetamodelVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return no.sintef.bvr.gmf.vspec.part.BVRMetamodelVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
