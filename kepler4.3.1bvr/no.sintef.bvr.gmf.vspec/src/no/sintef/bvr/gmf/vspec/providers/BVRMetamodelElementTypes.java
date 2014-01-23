package no.sintef.bvr.gmf.vspec.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import no.sintef.bvr.gmf.vspec.edit.parts.Choice2EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.ChoiceEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.ConfigurableUnitEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.ConstraintContextEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.MultiplicityInterval2EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.MultiplicityInterval3EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.MultiplicityInterval4EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.MultiplicityIntervalEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.OpaqueConstraintEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.VClassifierEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.VSpecChildEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.VariableEditPart;
import no.sintef.bvr.gmf.vspec.part.CVLMetamodelDiagramEditorPlugin;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import bvr.BvrPackage;

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
	public static final IElementType ConfigurableUnit_1000 = getElementType("no.sintef.bvr.gmf.vspec.ConfigurableUnit_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Choice_2005 = getElementType("no.sintef.bvr.gmf.vspec.Choice_2005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Choice_2015 = getElementType("no.sintef.bvr.gmf.vspec.Choice_2015"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Variable_2016 = getElementType("no.sintef.bvr.gmf.vspec.Variable_2016"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType VClassifier_2017 = getElementType("no.sintef.bvr.gmf.vspec.VClassifier_2017"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType OpaqueConstraint_2014 = getElementType("no.sintef.bvr.gmf.vspec.OpaqueConstraint_2014"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MultiplicityInterval_3002 = getElementType("no.sintef.bvr.gmf.vspec.MultiplicityInterval_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MultiplicityInterval_3003 = getElementType("no.sintef.bvr.gmf.vspec.MultiplicityInterval_3003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MultiplicityInterval_3001 = getElementType("no.sintef.bvr.gmf.vspec.MultiplicityInterval_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MultiplicityInterval_3004 = getElementType("no.sintef.bvr.gmf.vspec.MultiplicityInterval_3004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType VSpecChild_4001 = getElementType("no.sintef.bvr.gmf.vspec.VSpecChild_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ConstraintContext_4003 = getElementType("no.sintef.bvr.gmf.vspec.ConstraintContext_4003"); //$NON-NLS-1$

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
					BvrPackage.eINSTANCE.getConfigurableUnit());

			elements.put(Choice_2005, BvrPackage.eINSTANCE.getChoice());

			elements.put(Choice_2015, BvrPackage.eINSTANCE.getChoice());

			elements.put(Variable_2016, BvrPackage.eINSTANCE.getVariable());

			elements.put(VClassifier_2017,
					BvrPackage.eINSTANCE.getVClassifier());

			elements.put(OpaqueConstraint_2014,
					BvrPackage.eINSTANCE.getOpaqueConstraint());

			elements.put(MultiplicityInterval_3002,
					BvrPackage.eINSTANCE.getMultiplicityInterval());

			elements.put(MultiplicityInterval_3003,
					BvrPackage.eINSTANCE.getMultiplicityInterval());

			elements.put(MultiplicityInterval_3001,
					BvrPackage.eINSTANCE.getMultiplicityInterval());

			elements.put(MultiplicityInterval_3004,
					BvrPackage.eINSTANCE.getMultiplicityInterval());

			elements.put(VSpecChild_4001, BvrPackage.eINSTANCE.getVSpec_Child());

			elements.put(ConstraintContext_4003,
					BvrPackage.eINSTANCE.getConstraint_Context());
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
			return no.sintef.bvr.gmf.vspec.providers.CVLMetamodelElementTypes
					.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return no.sintef.bvr.gmf.vspec.providers.CVLMetamodelElementTypes
					.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(
				IAdaptable elementTypeAdapter) {
			return no.sintef.bvr.gmf.vspec.providers.CVLMetamodelElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
