package cvl.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

import cvl.Choice;
import cvl.ConfigurableUnit;
import cvl.CvlPackage;
import cvl.diagram.edit.parts.Choice2EditPart;
import cvl.diagram.edit.parts.ChoiceChoiceGroupMultiplicityCompartment2EditPart;
import cvl.diagram.edit.parts.ChoiceChoiceGroupMultiplicityCompartmentEditPart;
import cvl.diagram.edit.parts.ChoiceEditPart;
import cvl.diagram.edit.parts.ChoiceName2EditPart;
import cvl.diagram.edit.parts.ChoiceNameEditPart;
import cvl.diagram.edit.parts.ConfigurableUnitEditPart;
import cvl.diagram.edit.parts.MultiplicityInterval2EditPart;
import cvl.diagram.edit.parts.MultiplicityInterval3EditPart;
import cvl.diagram.edit.parts.MultiplicityInterval4EditPart;
import cvl.diagram.edit.parts.MultiplicityIntervalEditPart;
import cvl.diagram.edit.parts.MultiplicityIntervalLowerUpper2EditPart;
import cvl.diagram.edit.parts.MultiplicityIntervalLowerUpper3EditPart;
import cvl.diagram.edit.parts.MultiplicityIntervalLowerUpper4EditPart;
import cvl.diagram.edit.parts.MultiplicityIntervalLowerUpperEditPart;
import cvl.diagram.edit.parts.OpaqueConstraintConstraintEditPart;
import cvl.diagram.edit.parts.OpaqueConstraintEditPart;
import cvl.diagram.edit.parts.VClassifierEditPart;
import cvl.diagram.edit.parts.VClassifierMultiplicityIntervalCompartment2EditPart;
import cvl.diagram.edit.parts.VClassifierMultiplicityIntervalCompartmentEditPart;
import cvl.diagram.edit.parts.VClassifierNameEditPart;
import cvl.diagram.edit.parts.VariableEditPart;
import cvl.diagram.edit.parts.VariableNameEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class CVLMetamodelVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.bangbangbang.cvl.diagram/debug/visualID"; //$NON-NLS-1$

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
		return cvl.diagram.part.CVLMetamodelVisualIDRegistry.getVisualID(view
				.getType());
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
				CVLMetamodelDiagramEditorPlugin.getInstance().logError(
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
		if (CvlPackage.eINSTANCE.getConfigurableUnit().isSuperTypeOf(
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
		String containerModelID = cvl.diagram.part.CVLMetamodelVisualIDRegistry
				.getModelID(containerView);
		if (!ConfigurableUnitEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (ConfigurableUnitEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = cvl.diagram.part.CVLMetamodelVisualIDRegistry
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
			if (CvlPackage.eINSTANCE.getChoice().isSuperTypeOf(
					domainElement.eClass())
					&& isChoice_2005((Choice) domainElement)) {
				return ChoiceEditPart.VISUAL_ID;
			}
			if (CvlPackage.eINSTANCE.getChoice().isSuperTypeOf(
					domainElement.eClass())) {
				return Choice2EditPart.VISUAL_ID;
			}
			if (CvlPackage.eINSTANCE.getVariable().isSuperTypeOf(
					domainElement.eClass())) {
				return VariableEditPart.VISUAL_ID;
			}
			if (CvlPackage.eINSTANCE.getVClassifier().isSuperTypeOf(
					domainElement.eClass())) {
				return VClassifierEditPart.VISUAL_ID;
			}
			if (CvlPackage.eINSTANCE.getOpaqueConstraint().isSuperTypeOf(
					domainElement.eClass())) {
				return OpaqueConstraintEditPart.VISUAL_ID;
			}
			break;
		case ChoiceChoiceGroupMultiplicityCompartment2EditPart.VISUAL_ID:
			if (CvlPackage.eINSTANCE.getMultiplicityInterval().isSuperTypeOf(
					domainElement.eClass())) {
				return MultiplicityIntervalEditPart.VISUAL_ID;
			}
			break;
		case ChoiceChoiceGroupMultiplicityCompartmentEditPart.VISUAL_ID:
			if (CvlPackage.eINSTANCE.getMultiplicityInterval().isSuperTypeOf(
					domainElement.eClass())) {
				return MultiplicityInterval3EditPart.VISUAL_ID;
			}
			break;
		case VClassifierMultiplicityIntervalCompartmentEditPart.VISUAL_ID:
			if (CvlPackage.eINSTANCE.getMultiplicityInterval().isSuperTypeOf(
					domainElement.eClass())) {
				return MultiplicityInterval4EditPart.VISUAL_ID;
			}
			break;
		case VClassifierMultiplicityIntervalCompartment2EditPart.VISUAL_ID:
			if (CvlPackage.eINSTANCE.getMultiplicityInterval().isSuperTypeOf(
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
		String containerModelID = cvl.diagram.part.CVLMetamodelVisualIDRegistry
				.getModelID(containerView);
		if (!ConfigurableUnitEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (ConfigurableUnitEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = cvl.diagram.part.CVLMetamodelVisualIDRegistry
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
	 * @generated
	 */
	private static boolean isChoice_2005(Choice domainElement) {
		// FIXME: implement this method 
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException(
				"No java implementation provided in 'isChoice_2005' operation"); //$NON-NLS-1$
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
			return cvl.diagram.part.CVLMetamodelVisualIDRegistry
					.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return cvl.diagram.part.CVLMetamodelVisualIDRegistry
					.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return cvl.diagram.part.CVLMetamodelVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView,
				EObject domainElement, int candidate) {
			return cvl.diagram.part.CVLMetamodelVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return cvl.diagram.part.CVLMetamodelVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return cvl.diagram.part.CVLMetamodelVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
