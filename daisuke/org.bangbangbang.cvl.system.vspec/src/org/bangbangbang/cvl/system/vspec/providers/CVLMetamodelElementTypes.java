package org.bangbangbang.cvl.system.vspec.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.bangbangbang.cvl.CvlPackage;
import org.bangbangbang.cvl.system.vspec.edit.parts.Choice2EditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.ChoiceEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.ConfigurableUnitEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.ConstraintContextEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.MultiplicityInterval2EditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.MultiplicityInterval3EditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.MultiplicityInterval4EditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.MultiplicityIntervalEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.OpaqueConstraintEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.VClassifierEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.VSpecChildEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.VariableEditPart;
import org.bangbangbang.cvl.system.vspec.part.CVLSystemVSpecEditorPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class CVLMetamodelElementTypes {

	/**
	 * @generated
	 */
	private CVLMetamodelElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			CVLSystemVSpecEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType VInterface_1000 = getElementType("org.bangbangbang.cvl.system.vspec.VInterface_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Choice_2002 = getElementType("org.bangbangbang.cvl.system.vspec.Choice_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Choice_2006 = getElementType("org.bangbangbang.cvl.system.vspec.Choice_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Variable_2003 = getElementType("org.bangbangbang.cvl.system.vspec.Variable_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType VClassifier_2004 = getElementType("org.bangbangbang.cvl.system.vspec.VClassifier_2004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType OpaqueConstraint_2007 = getElementType("org.bangbangbang.cvl.system.vspec.OpaqueConstraint_2007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType MultiplicityInterval_3001 = getElementType("org.bangbangbang.cvl.system.vspec.MultiplicityInterval_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MultiplicityInterval_3002 = getElementType("org.bangbangbang.cvl.system.vspec.MultiplicityInterval_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MultiplicityInterval_3003 = getElementType("org.bangbangbang.cvl.system.vspec.MultiplicityInterval_3003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MultiplicityInterval_3004 = getElementType("org.bangbangbang.cvl.system.vspec.MultiplicityInterval_3004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType VSpecChild_4001 = getElementType("org.bangbangbang.cvl.system.vspec.VSpecChild_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ConstraintContext_4002 = getElementType("org.bangbangbang.cvl.system.vspec.ConstraintContext_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(VInterface_1000, CvlPackage.eINSTANCE.getVInterface());

			elements.put(Choice_2002, CvlPackage.eINSTANCE.getChoice());

			elements.put(Choice_2006, CvlPackage.eINSTANCE.getChoice());

			elements.put(Variable_2003, CvlPackage.eINSTANCE.getVariable());

			elements.put(VClassifier_2004,
					CvlPackage.eINSTANCE.getVClassifier());

			elements.put(OpaqueConstraint_2007,
					CvlPackage.eINSTANCE.getOpaqueConstraint());

			elements.put(MultiplicityInterval_3001,
					CvlPackage.eINSTANCE.getMultiplicityInterval());

			elements.put(MultiplicityInterval_3002,
					CvlPackage.eINSTANCE.getMultiplicityInterval());

			elements.put(MultiplicityInterval_3003,
					CvlPackage.eINSTANCE.getMultiplicityInterval());

			elements.put(MultiplicityInterval_3004,
					CvlPackage.eINSTANCE.getMultiplicityInterval());

			elements.put(VSpecChild_4001, CvlPackage.eINSTANCE.getVSpec_Child());

			elements.put(ConstraintContext_4002,
					CvlPackage.eINSTANCE.getConstraint_Context());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(VInterface_1000);
			KNOWN_ELEMENT_TYPES.add(Choice_2002);
			KNOWN_ELEMENT_TYPES.add(Choice_2006);
			KNOWN_ELEMENT_TYPES.add(Variable_2003);
			KNOWN_ELEMENT_TYPES.add(VClassifier_2004);
			KNOWN_ELEMENT_TYPES.add(OpaqueConstraint_2007);
			KNOWN_ELEMENT_TYPES.add(MultiplicityInterval_3001);
			KNOWN_ELEMENT_TYPES.add(MultiplicityInterval_3002);
			KNOWN_ELEMENT_TYPES.add(MultiplicityInterval_3003);
			KNOWN_ELEMENT_TYPES.add(MultiplicityInterval_3004);
			KNOWN_ELEMENT_TYPES.add(VSpecChild_4001);
			KNOWN_ELEMENT_TYPES.add(ConstraintContext_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case ConfigurableUnitEditPart.VISUAL_ID:
			return VInterface_1000;
		case Choice2EditPart.VISUAL_ID:
			return Choice_2002;
		case ChoiceEditPart.VISUAL_ID:
			return Choice_2006;
		case VariableEditPart.VISUAL_ID:
			return Variable_2003;
		case VClassifierEditPart.VISUAL_ID:
			return VClassifier_2004;
		case OpaqueConstraintEditPart.VISUAL_ID:
			return OpaqueConstraint_2007;
		case MultiplicityIntervalEditPart.VISUAL_ID:
			return MultiplicityInterval_3001;
		case MultiplicityInterval2EditPart.VISUAL_ID:
			return MultiplicityInterval_3002;
		case MultiplicityInterval3EditPart.VISUAL_ID:
			return MultiplicityInterval_3003;
		case MultiplicityInterval4EditPart.VISUAL_ID:
			return MultiplicityInterval_3004;
		case VSpecChildEditPart.VISUAL_ID:
			return VSpecChild_4001;
		case ConstraintContextEditPart.VISUAL_ID:
			return ConstraintContext_4002;
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(
			elementTypeImages) {

		/**
		 * @generated
		 */
		@Override
		public boolean isKnownElementType(IElementType elementType) {
			return org.bangbangbang.cvl.system.vspec.providers.CVLMetamodelElementTypes
					.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return org.bangbangbang.cvl.system.vspec.providers.CVLMetamodelElementTypes
					.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(
				IAdaptable elementTypeAdapter) {
			return org.bangbangbang.cvl.system.vspec.providers.CVLMetamodelElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
