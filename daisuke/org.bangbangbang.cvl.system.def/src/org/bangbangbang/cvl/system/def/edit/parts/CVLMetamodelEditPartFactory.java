package org.bangbangbang.cvl.system.def.edit.parts;

import org.bangbangbang.cvl.system.def.part.CVLMetamodelVisualIDRegistry;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class CVLMetamodelEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (CVLMetamodelVisualIDRegistry.getVisualID(view)) {

			case ConfigurableUnitEditPart.VISUAL_ID:
				return new ConfigurableUnitEditPart(view);

			case ChoiceEditPart.VISUAL_ID:
				return new ChoiceEditPart(view);

			case ChoiceNameEditPart.VISUAL_ID:
				return new ChoiceNameEditPart(view);

			case Choice2EditPart.VISUAL_ID:
				return new Choice2EditPart(view);

			case ChoiceName2EditPart.VISUAL_ID:
				return new ChoiceName2EditPart(view);

			case VariableEditPart.VISUAL_ID:
				return new VariableEditPart(view);

			case VariableNameEditPart.VISUAL_ID:
				return new VariableNameEditPart(view);

			case VClassifierEditPart.VISUAL_ID:
				return new VClassifierEditPart(view);

			case VClassifierNameEditPart.VISUAL_ID:
				return new VClassifierNameEditPart(view);

			case OpaqueConstraintEditPart.VISUAL_ID:
				return new OpaqueConstraintEditPart(view);

			case OpaqueConstraintNameEditPart.VISUAL_ID:
				return new OpaqueConstraintNameEditPart(view);

			case MultiplicityIntervalEditPart.VISUAL_ID:
				return new MultiplicityIntervalEditPart(view);

			case MultiplicityIntervalLowerUpperEditPart.VISUAL_ID:
				return new MultiplicityIntervalLowerUpperEditPart(view);

			case MultiplicityInterval2EditPart.VISUAL_ID:
				return new MultiplicityInterval2EditPart(view);

			case MultiplicityIntervalLowerUpper2EditPart.VISUAL_ID:
				return new MultiplicityIntervalLowerUpper2EditPart(view);

			case MultiplicityInterval3EditPart.VISUAL_ID:
				return new MultiplicityInterval3EditPart(view);

			case MultiplicityIntervalLowerUpper3EditPart.VISUAL_ID:
				return new MultiplicityIntervalLowerUpper3EditPart(view);

			case MultiplicityInterval4EditPart.VISUAL_ID:
				return new MultiplicityInterval4EditPart(view);

			case MultiplicityIntervalLowerUpper4EditPart.VISUAL_ID:
				return new MultiplicityIntervalLowerUpper4EditPart(view);

			case ChoiceChoiceGroupMultiplicityCompartmentEditPart.VISUAL_ID:
				return new ChoiceChoiceGroupMultiplicityCompartmentEditPart(
						view);

			case ChoiceChoiceGroupMultiplicityCompartment2EditPart.VISUAL_ID:
				return new ChoiceChoiceGroupMultiplicityCompartment2EditPart(
						view);

			case VClassifierVClassifierGroupMultiplicityCompartmentEditPart.VISUAL_ID:
				return new VClassifierVClassifierGroupMultiplicityCompartmentEditPart(
						view);

			case VClassifierVClassifierInstanceMultiplicityIntervalCompartmentEditPart.VISUAL_ID:
				return new VClassifierVClassifierInstanceMultiplicityIntervalCompartmentEditPart(
						view);

			case VSpecChildEditPart.VISUAL_ID:
				return new VSpecChildEditPart(view);

			case ConstraintContextEditPart.VISUAL_ID:
				return new ConstraintContextEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE
				.getTextCellEditorLocator(source);
	}

}
