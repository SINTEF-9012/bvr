package no.sintef.bvr.gmf.vspec.providers;

import no.sintef.bvr.gmf.vspec.edit.parts.ChoiceName2EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.ChoiceNameEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.MultiplicityIntervalLowerUpper2EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.MultiplicityIntervalLowerUpper3EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.MultiplicityIntervalLowerUpper4EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.MultiplicityIntervalLowerUpperEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.OpaqueConstraintConstraintEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.VClassifierNameEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.VariableNameEditPart;
import no.sintef.bvr.gmf.vspec.parsers.MessageFormatParser;
import no.sintef.bvr.gmf.vspec.part.BVRMetamodelVisualIDRegistry;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import bvr.BvrPackage;

/**
 * @generated
 */
public class BVRMetamodelParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser choiceName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getChoiceName_5005Parser() {
		if (choiceName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { BvrPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			choiceName_5005Parser = parser;
		}
		return choiceName_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser choiceName_5022Parser;

	/**
	 * @generated
	 */
	private IParser getChoiceName_5022Parser() {
		if (choiceName_5022Parser == null) {
			EAttribute[] features = new EAttribute[] { BvrPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			choiceName_5022Parser = parser;
		}
		return choiceName_5022Parser;
	}

	/**
	 * @generated
	 */
	private IParser variableName_5023Parser;

	/**
	 * @generated
	 */
	private IParser getVariableName_5023Parser() {
		if (variableName_5023Parser == null) {
			EAttribute[] features = new EAttribute[] { BvrPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			variableName_5023Parser = parser;
		}
		return variableName_5023Parser;
	}

	/**
	 * @generated
	 */
	private IParser vClassifierName_5024Parser;

	/**
	 * @generated
	 */
	private IParser getVClassifierName_5024Parser() {
		if (vClassifierName_5024Parser == null) {
			EAttribute[] features = new EAttribute[] { BvrPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			vClassifierName_5024Parser = parser;
		}
		return vClassifierName_5024Parser;
	}

	/**
	 * @generated
	 */
	private IParser opaqueConstraintName_5014Parser;

	/**
	 * @generated
	 */
	private IParser getOpaqueConstraintName_5014Parser() {
		if (opaqueConstraintName_5014Parser == null) {
			EAttribute[] features = new EAttribute[] { BvrPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			opaqueConstraintName_5014Parser = parser;
		}
		return opaqueConstraintName_5014Parser;
	}

	/**
	 * @generated
	 */
	private IParser multiplicityIntervalLowerUpper_5026Parser;

	/**
	 * @generated
	 */
	private IParser getMultiplicityIntervalLowerUpper_5026Parser() {
		if (multiplicityIntervalLowerUpper_5026Parser == null) {
			EAttribute[] features = new EAttribute[] {
					BvrPackage.eINSTANCE.getMultiplicityInterval_Lower(),
					BvrPackage.eINSTANCE.getMultiplicityInterval_Upper() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("[{0}..{1}]"); //$NON-NLS-1$
			parser.setEditorPattern("[{0}..{1}]"); //$NON-NLS-1$
			parser.setEditPattern("[{0}..{1}]"); //$NON-NLS-1$
			multiplicityIntervalLowerUpper_5026Parser = parser;
		}
		return multiplicityIntervalLowerUpper_5026Parser;
	}

	/**
	 * @generated
	 */
	private IParser multiplicityIntervalLowerUpper_5027Parser;

	/**
	 * @generated
	 */
	private IParser getMultiplicityIntervalLowerUpper_5027Parser() {
		if (multiplicityIntervalLowerUpper_5027Parser == null) {
			EAttribute[] features = new EAttribute[] {
					BvrPackage.eINSTANCE.getMultiplicityInterval_Lower(),
					BvrPackage.eINSTANCE.getMultiplicityInterval_Upper() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("[{0}..{1}]"); //$NON-NLS-1$
			parser.setEditorPattern("[{0}..{1}]"); //$NON-NLS-1$
			parser.setEditPattern("[{0}..{1}]"); //$NON-NLS-1$
			multiplicityIntervalLowerUpper_5027Parser = parser;
		}
		return multiplicityIntervalLowerUpper_5027Parser;
	}

	/**
	 * @generated
	 */
	private IParser multiplicityIntervalLowerUpper_5018Parser;

	/**
	 * @generated
	 */
	private IParser getMultiplicityIntervalLowerUpper_5018Parser() {
		if (multiplicityIntervalLowerUpper_5018Parser == null) {
			EAttribute[] features = new EAttribute[] {
					BvrPackage.eINSTANCE.getMultiplicityInterval_Lower(),
					BvrPackage.eINSTANCE.getMultiplicityInterval_Upper() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}..{1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}..{1}"); //$NON-NLS-1$
			parser.setEditPattern("{0}..{1}"); //$NON-NLS-1$
			multiplicityIntervalLowerUpper_5018Parser = parser;
		}
		return multiplicityIntervalLowerUpper_5018Parser;
	}

	/**
	 * @generated
	 */
	private IParser multiplicityIntervalLowerUpper_5028Parser;

	/**
	 * @generated
	 */
	private IParser getMultiplicityIntervalLowerUpper_5028Parser() {
		if (multiplicityIntervalLowerUpper_5028Parser == null) {
			EAttribute[] features = new EAttribute[] {
					BvrPackage.eINSTANCE.getMultiplicityInterval_Lower(),
					BvrPackage.eINSTANCE.getMultiplicityInterval_Upper() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("[{0}..{1}]"); //$NON-NLS-1$
			parser.setEditorPattern("[{0}..{1}]"); //$NON-NLS-1$
			parser.setEditPattern("[{0}..{1}]"); //$NON-NLS-1$
			multiplicityIntervalLowerUpper_5028Parser = parser;
		}
		return multiplicityIntervalLowerUpper_5028Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ChoiceNameEditPart.VISUAL_ID:
			return getChoiceName_5005Parser();
		case ChoiceName2EditPart.VISUAL_ID:
			return getChoiceName_5022Parser();
		case VariableNameEditPart.VISUAL_ID:
			return getVariableName_5023Parser();
		case VClassifierNameEditPart.VISUAL_ID:
			return getVClassifierName_5024Parser();
		case OpaqueConstraintConstraintEditPart.VISUAL_ID:
			return getOpaqueConstraintName_5014Parser();
		case MultiplicityIntervalLowerUpperEditPart.VISUAL_ID:
			return getMultiplicityIntervalLowerUpper_5026Parser();
		case MultiplicityIntervalLowerUpper3EditPart.VISUAL_ID:
			return getMultiplicityIntervalLowerUpper_5027Parser();
		case MultiplicityIntervalLowerUpper2EditPart.VISUAL_ID:
			return getMultiplicityIntervalLowerUpper_5018Parser();
		case MultiplicityIntervalLowerUpper4EditPart.VISUAL_ID:
			return getMultiplicityIntervalLowerUpper_5028Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(BVRMetamodelVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(BVRMetamodelVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (BVRMetamodelElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
