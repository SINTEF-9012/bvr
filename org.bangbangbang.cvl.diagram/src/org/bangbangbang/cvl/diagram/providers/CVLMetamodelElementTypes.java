package org.bangbangbang.cvl.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.bangbangbang.cvl.CvlPackage;
import org.bangbangbang.cvl.diagram.edit.parts.Choice2EditPart;
import org.bangbangbang.cvl.diagram.edit.parts.ChoiceEditPart;
import org.bangbangbang.cvl.diagram.edit.parts.ConfigurableUnitEditPart;
import org.bangbangbang.cvl.diagram.edit.parts.ConstraintContextEditPart;
import org.bangbangbang.cvl.diagram.edit.parts.MultiplicityInterval2EditPart;
import org.bangbangbang.cvl.diagram.edit.parts.MultiplicityInterval3EditPart;
import org.bangbangbang.cvl.diagram.edit.parts.MultiplicityInterval4EditPart;
import org.bangbangbang.cvl.diagram.edit.parts.MultiplicityIntervalEditPart;
import org.bangbangbang.cvl.diagram.edit.parts.OpaqueConstraintEditPart;
import org.bangbangbang.cvl.diagram.edit.parts.VClassifierEditPart;
import org.bangbangbang.cvl.diagram.edit.parts.VSpecChildEditPart;
import org.bangbangbang.cvl.diagram.edit.parts.VariableEditPart;
import org.bangbangbang.cvl.diagram.part.CVLMetamodelDiagramEditorPlugin;
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
			CVLMetamodelDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType ConfigurableUnit_1000 = getElementType("org.bangbangbang.cvl.diagram.ConfigurableUnit_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Choice_2005 = getElementType("org.bangbangbang.cvl.diagram.Choice_2005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Choice_2015 = getElementType("org.bangbangbang.cvl.diagram.Choice_2015"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Variable_2016 = getElementType("org.bangbangbang.cvl.diagram.Variable_2016"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType VClassifier_2017 = getElementType("org.bangbangbang.cvl.diagram.VClassifier_2017"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType OpaqueConstraint_2014 = getElementType("org.bangbangbang.cvl.diagram.OpaqueConstraint_2014"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MultiplicityInterval_3002 = getElementType("org.bangbangbang.cvl.diagram.MultiplicityInterval_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MultiplicityInterval_3003 = getElementType("org.bangbangbang.cvl.diagram.MultiplicityInterval_3003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MultiplicityInterval_3001 = getElementType("org.bangbangbang.cvl.diagram.MultiplicityInterval_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MultiplicityInterval_3004 = getElementType("org.bangbangbang.cvl.diagram.MultiplicityInterval_3004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType VSpecChild_4001 = getElementType("org.bangbangbang.cvl.diagram.VSpecChild_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ConstraintContext_4003 = getElementType("org.bangbangbang.cvl.diagram.ConstraintContext_4003"); //$NON-NLS-1$

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

			elements.put(ConfigurableUnit_1000,
					CvlPackage.eINSTANCE.getConfigurableUnit());

			elements.put(Choice_2005, CvlPackage.eINSTANCE.getChoice());

			elements.put(Choice_2015, CvlPackage.eINSTANCE.getChoice());

			elements.put(Variable_2016, CvlPackage.eINSTANCE.getVariable());

			elements.put(VClassifier_2017,
					CvlPackage.eINSTANCE.getVClassifier());

			elements.put(OpaqueConstraint_2014,
					CvlPackage.eINSTANCE.getOpaqueConstraint());

			elements.put(MultiplicityInterval_3002,
					CvlPackage.eINSTANCE.getMultiplicityInterval());

			elements.put(MultiplicityInterval_3003,
					CvlPackage.eINSTANCE.getMultiplicityInterval());

			elements.put(MultiplicityInterval_3001,
					CvlPackage.eINSTANCE.getMultiplicityInterval());

			elements.put(MultiplicityInterval_3004,
					CvlPackage.eINSTANCE.getMultiplicityInterval());

			elements.put(VSpecChild_4001, CvlPackage.eINSTANCE.getVSpec_Child());

			elements.put(ConstraintContext_4003,
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
			KNOWN_ELEMENT_TYPES.add(ConfigurableUnit_1000);
			KNOWN_ELEMENT_TYPES.add(Choice_2005);
			KNOWN_ELEMENT_TYPES.add(Choice_2015);
			KNOWN_ELEMENT_TYPES.add(Variable_2016);
			KNOWN_ELEMENT_TYPES.add(VClassifier_2017);
			KNOWN_ELEMENT_TYPES.add(OpaqueConstraint_2014);
			KNOWN_ELEMENT_TYPES.add(MultiplicityInterval_3002);
			KNOWN_ELEMENT_TYPES.add(MultiplicityInterval_3003);
			KNOWN_ELEMENT_TYPES.add(MultiplicityInterval_3001);
			KNOWN_ELEMENT_TYPES.add(MultiplicityInterval_3004);
			KNOWN_ELEMENT_TYPES.add(VSpecChild_4001);
			KNOWN_ELEMENT_TYPES.add(ConstraintContext_4003);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case ConfigurableUnitEditPart.VISUAL_ID:
			return ConfigurableUnit_1000;
		case ChoiceEditPart.VISUAL_ID:
			return Choice_2005;
		case Choice2EditPart.VISUAL_ID:
			return Choice_2015;
		case VariableEditPart.VISUAL_ID:
			return Variable_2016;
		case VClassifierEditPart.VISUAL_ID:
			return VClassifier_2017;
		case OpaqueConstraintEditPart.VISUAL_ID:
			return OpaqueConstraint_2014;
		case MultiplicityIntervalEditPart.VISUAL_ID:
			return MultiplicityInterval_3002;
		case MultiplicityInterval3EditPart.VISUAL_ID:
			return MultiplicityInterval_3003;
		case MultiplicityInterval2EditPart.VISUAL_ID:
			return MultiplicityInterval_3001;
		case MultiplicityInterval4EditPart.VISUAL_ID:
			return MultiplicityInterval_3004;
		case VSpecChildEditPart.VISUAL_ID:
			return VSpecChild_4001;
		case ConstraintContextEditPart.VISUAL_ID:
			return ConstraintContext_4003;
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
			return org.bangbangbang.cvl.diagram.providers.CVLMetamodelElementTypes
					.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return org.bangbangbang.cvl.diagram.providers.CVLMetamodelElementTypes
					.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(
				IAdaptable elementTypeAdapter) {
			return org.bangbangbang.cvl.diagram.providers.CVLMetamodelElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
