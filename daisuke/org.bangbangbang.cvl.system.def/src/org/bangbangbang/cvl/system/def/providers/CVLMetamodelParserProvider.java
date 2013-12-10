package org.bangbangbang.cvl.system.def.providers;

import org.bangbangbang.cvl.CvlPackage;
import org.bangbangbang.cvl.system.def.edit.parts.ChoiceName2EditPart;
import org.bangbangbang.cvl.system.def.edit.parts.ChoiceNameEditPart;
import org.bangbangbang.cvl.system.def.edit.parts.MultiplicityIntervalLowerUpper2EditPart;
import org.bangbangbang.cvl.system.def.edit.parts.MultiplicityIntervalLowerUpper3EditPart;
import org.bangbangbang.cvl.system.def.edit.parts.MultiplicityIntervalLowerUpper4EditPart;
import org.bangbangbang.cvl.system.def.edit.parts.MultiplicityIntervalLowerUpperEditPart;
import org.bangbangbang.cvl.system.def.edit.parts.OpaqueConstraintNameEditPart;
import org.bangbangbang.cvl.system.def.edit.parts.VClassifierNameEditPart;
import org.bangbangbang.cvl.system.def.edit.parts.VariableNameEditPart;
import org.bangbangbang.cvl.system.def.parsers.MessageFormatParser;
import org.bangbangbang.cvl.system.def.part.CVLMetamodelVisualIDRegistry;
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

/**
 * @generated
 */
public class CVLMetamodelParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser choiceName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getChoiceName_5002Parser() {
		if (choiceName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { CvlPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			choiceName_5002Parser = parser;
		}
		return choiceName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser choiceName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getChoiceName_5004Parser() {
		if (choiceName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { CvlPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			choiceName_5004Parser = parser;
		}
		return choiceName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser variableName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getVariableName_5005Parser() {
		if (variableName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { CvlPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			variableName_5005Parser = parser;
		}
		return variableName_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser vClassifierName_5008Parser;

	/**
	 * @generated
	 */
	private IParser getVClassifierName_5008Parser() {
		if (vClassifierName_5008Parser == null) {
			EAttribute[] features = new EAttribute[] { CvlPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			vClassifierName_5008Parser = parser;
		}
		return vClassifierName_5008Parser;
	}

	/**
	 * @generated
	 */
	private IParser opaqueConstraintName_5009Parser;

	/**
	 * @generated
	 */
	private IParser getOpaqueConstraintName_5009Parser() {
		if (opaqueConstraintName_5009Parser == null) {
			EAttribute[] features = new EAttribute[] { CvlPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			opaqueConstraintName_5009Parser = parser;
		}
		return opaqueConstraintName_5009Parser;
	}

	/**
	 * @generated
	 */
	private IParser multiplicityIntervalLowerUpper_5001Parser;

	/**
	 * @generated
	 */
	private IParser getMultiplicityIntervalLowerUpper_5001Parser() {
		if (multiplicityIntervalLowerUpper_5001Parser == null) {
			EAttribute[] features = new EAttribute[] {
					CvlPackage.eINSTANCE.getMultiplicityInterval_Lower(),
					CvlPackage.eINSTANCE.getMultiplicityInterval_Upper() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("[{0}..{1}]"); //$NON-NLS-1$
			parser.setEditorPattern("[{0}..{1}]"); //$NON-NLS-1$
			parser.setEditPattern("[{0}..{1}]"); //$NON-NLS-1$
			multiplicityIntervalLowerUpper_5001Parser = parser;
		}
		return multiplicityIntervalLowerUpper_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser multiplicityIntervalLowerUpper_5003Parser;

	/**
	 * @generated
	 */
	private IParser getMultiplicityIntervalLowerUpper_5003Parser() {
		if (multiplicityIntervalLowerUpper_5003Parser == null) {
			EAttribute[] features = new EAttribute[] {
					CvlPackage.eINSTANCE.getMultiplicityInterval_Lower(),
					CvlPackage.eINSTANCE.getMultiplicityInterval_Upper() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("[{0}..{1}]"); //$NON-NLS-1$
			parser.setEditorPattern("[{0}..{1}]"); //$NON-NLS-1$
			parser.setEditPattern("[{0}..{1}]"); //$NON-NLS-1$
			multiplicityIntervalLowerUpper_5003Parser = parser;
		}
		return multiplicityIntervalLowerUpper_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser multiplicityIntervalLowerUpper_5006Parser;

	/**
	 * @generated
	 */
	private IParser getMultiplicityIntervalLowerUpper_5006Parser() {
		if (multiplicityIntervalLowerUpper_5006Parser == null) {
			EAttribute[] features = new EAttribute[] {
					CvlPackage.eINSTANCE.getMultiplicityInterval_Lower(),
					CvlPackage.eINSTANCE.getMultiplicityInterval_Upper() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0}..{1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}..{1}"); //$NON-NLS-1$
			parser.setEditPattern("{0}..{1}"); //$NON-NLS-1$
			multiplicityIntervalLowerUpper_5006Parser = parser;
		}
		return multiplicityIntervalLowerUpper_5006Parser;
	}

	/**
	 * @generated
	 */
	private IParser multiplicityIntervalLowerUpper_5007Parser;

	/**
	 * @generated
	 */
	private IParser getMultiplicityIntervalLowerUpper_5007Parser() {
		if (multiplicityIntervalLowerUpper_5007Parser == null) {
			EAttribute[] features = new EAttribute[] {
					CvlPackage.eINSTANCE.getMultiplicityInterval_Lower(),
					CvlPackage.eINSTANCE.getMultiplicityInterval_Upper() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("[{0}..{1}]"); //$NON-NLS-1$
			parser.setEditorPattern("[{0}..{1}]"); //$NON-NLS-1$
			parser.setEditPattern("[{0}..{1}]"); //$NON-NLS-1$
			multiplicityIntervalLowerUpper_5007Parser = parser;
		}
		return multiplicityIntervalLowerUpper_5007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ChoiceNameEditPart.VISUAL_ID:
			return getChoiceName_5002Parser();
		case ChoiceName2EditPart.VISUAL_ID:
			return getChoiceName_5004Parser();
		case VariableNameEditPart.VISUAL_ID:
			return getVariableName_5005Parser();
		case VClassifierNameEditPart.VISUAL_ID:
			return getVClassifierName_5008Parser();
		case OpaqueConstraintNameEditPart.VISUAL_ID:
			return getOpaqueConstraintName_5009Parser();
		case MultiplicityIntervalLowerUpperEditPart.VISUAL_ID:
			return getMultiplicityIntervalLowerUpper_5001Parser();
		case MultiplicityIntervalLowerUpper2EditPart.VISUAL_ID:
			return getMultiplicityIntervalLowerUpper_5003Parser();
		case MultiplicityIntervalLowerUpper3EditPart.VISUAL_ID:
			return getMultiplicityIntervalLowerUpper_5006Parser();
		case MultiplicityIntervalLowerUpper4EditPart.VISUAL_ID:
			return getMultiplicityIntervalLowerUpper_5007Parser();
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
			return getParser(CVLMetamodelVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(CVLMetamodelVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (CVLMetamodelElementTypes.getElement(hint) == null) {
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
