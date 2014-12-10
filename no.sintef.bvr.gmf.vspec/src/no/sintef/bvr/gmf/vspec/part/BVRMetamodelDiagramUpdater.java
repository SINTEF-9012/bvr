package no.sintef.bvr.gmf.vspec.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import no.sintef.bvr.gmf.vspec.edit.parts.Choice2EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.ChoiceChoiceGroupMultiplicityCompartment2EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.ChoiceChoiceGroupMultiplicityCompartmentEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.ChoiceEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.ConfigurableUnitEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.ConstraintContextEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.MultiplicityInterval2EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.MultiplicityInterval3EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.MultiplicityInterval4EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.MultiplicityIntervalEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.OpaqueConstraintEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.VClassifierEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.VClassifierMultiplicityIntervalCompartment2EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.VClassifierMultiplicityIntervalCompartmentEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.VSpecChildEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.VariableEditPart;
import no.sintef.bvr.gmf.vspec.providers.BVRMetamodelElementTypes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import bvr.Choice;
import bvr.ConfigurableUnit;
import bvr.Constraint;
import bvr.BvrPackage;
import bvr.MultiplicityInterval;
import bvr.OpaqueConstraint;
import bvr.VClassifier;
import bvr.VSpec;
import bvr.Variable;

/**
 * @generated
 */
public class BVRMetamodelDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<BVRMetamodelNodeDescriptor> getSemanticChildren(View view) {
		switch (BVRMetamodelVisualIDRegistry.getVisualID(view)) {
		case ConfigurableUnitEditPart.VISUAL_ID:
			return getConfigurableUnit_1000SemanticChildren(view);
		case ChoiceChoiceGroupMultiplicityCompartment2EditPart.VISUAL_ID:
			return getChoiceChoiceGroupMultiplicityCompartment_7005SemanticChildren(view);
		case ChoiceChoiceGroupMultiplicityCompartmentEditPart.VISUAL_ID:
			return getChoiceChoiceGroupMultiplicityCompartment_7004SemanticChildren(view);
		case VClassifierMultiplicityIntervalCompartmentEditPart.VISUAL_ID:
			return getVClassifierVClassifierGroupMultiplicityCompartment_7003SemanticChildren(view);
		case VClassifierMultiplicityIntervalCompartment2EditPart.VISUAL_ID:
			return getVClassifierVClassifierInstanceMultiplicityIntervalCompartment_7006SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelNodeDescriptor> getConfigurableUnit_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ConfigurableUnit modelElement = (ConfigurableUnit) view.getElement();
		LinkedList<BVRMetamodelNodeDescriptor> result = new LinkedList<BVRMetamodelNodeDescriptor>();
		for (Iterator<?> it = modelElement.getOwnedVSpec().iterator(); it
				.hasNext();) {
			VSpec childElement = (VSpec) it.next();
			int visualID = BVRMetamodelVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ChoiceEditPart.VISUAL_ID) {
				result.add(new BVRMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getOwnedConstraint().iterator(); it
				.hasNext();) {
			Constraint childElement = (Constraint) it.next();
			int visualID = BVRMetamodelVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == OpaqueConstraintEditPart.VISUAL_ID) {
				result.add(new BVRMetamodelNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		Resource resource = modelElement.eResource();
		for (Iterator<EObject> it = getPhantomNodesIterator(resource); it
				.hasNext();) {
			EObject childElement = it.next();
			if (childElement == modelElement) {
				continue;
			}
			if (BVRMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement) == Choice2EditPart.VISUAL_ID) {
				result.add(new BVRMetamodelNodeDescriptor(childElement,
						Choice2EditPart.VISUAL_ID));
				continue;
			}
			if (BVRMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement) == VariableEditPart.VISUAL_ID) {
				result.add(new BVRMetamodelNodeDescriptor(childElement,
						VariableEditPart.VISUAL_ID));
				continue;
			}
			if (BVRMetamodelVisualIDRegistry
					.getNodeVisualID(view, childElement) == VClassifierEditPart.VISUAL_ID) {
				result.add(new BVRMetamodelNodeDescriptor(childElement,
						VClassifierEditPart.VISUAL_ID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelNodeDescriptor> getChoiceChoiceGroupMultiplicityCompartment_7005SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Choice modelElement = (Choice) containerView.getElement();
		LinkedList<BVRMetamodelNodeDescriptor> result = new LinkedList<BVRMetamodelNodeDescriptor>();
		{
			MultiplicityInterval childElement = modelElement
					.getGroupMultiplicity();
			int visualID = BVRMetamodelVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == MultiplicityIntervalEditPart.VISUAL_ID) {
				result.add(new BVRMetamodelNodeDescriptor(childElement,
						visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelNodeDescriptor> getChoiceChoiceGroupMultiplicityCompartment_7004SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Choice modelElement = (Choice) containerView.getElement();
		LinkedList<BVRMetamodelNodeDescriptor> result = new LinkedList<BVRMetamodelNodeDescriptor>();
		{
			MultiplicityInterval childElement = modelElement
					.getGroupMultiplicity();
			int visualID = BVRMetamodelVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == MultiplicityInterval3EditPart.VISUAL_ID) {
				result.add(new BVRMetamodelNodeDescriptor(childElement,
						visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelNodeDescriptor> getVClassifierVClassifierGroupMultiplicityCompartment_7003SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		VClassifier modelElement = (VClassifier) containerView.getElement();
		LinkedList<BVRMetamodelNodeDescriptor> result = new LinkedList<BVRMetamodelNodeDescriptor>();
		{
			MultiplicityInterval childElement = modelElement
					.getGroupMultiplicity();
			int visualID = BVRMetamodelVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == MultiplicityInterval4EditPart.VISUAL_ID) {
				result.add(new BVRMetamodelNodeDescriptor(childElement,
						visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelNodeDescriptor> getVClassifierVClassifierInstanceMultiplicityIntervalCompartment_7006SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		VClassifier modelElement = (VClassifier) containerView.getElement();
		LinkedList<BVRMetamodelNodeDescriptor> result = new LinkedList<BVRMetamodelNodeDescriptor>();
		{
			MultiplicityInterval childElement = modelElement
					.getInstanceMultiplicity();
			int visualID = BVRMetamodelVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == MultiplicityInterval2EditPart.VISUAL_ID) {
				result.add(new BVRMetamodelNodeDescriptor(childElement,
						visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Iterator<EObject> getPhantomNodesIterator(Resource resource) {
		return resource.getAllContents();
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getContainedLinks(View view) {
		switch (BVRMetamodelVisualIDRegistry.getVisualID(view)) {
		case ConfigurableUnitEditPart.VISUAL_ID:
			return getConfigurableUnit_1000ContainedLinks(view);
		case ChoiceEditPart.VISUAL_ID:
			return getChoice_2005ContainedLinks(view);
		case Choice2EditPart.VISUAL_ID:
			return getChoice_2015ContainedLinks(view);
		case VariableEditPart.VISUAL_ID:
			return getVariable_2016ContainedLinks(view);
		case VClassifierEditPart.VISUAL_ID:
			return getVClassifier_2017ContainedLinks(view);
		case OpaqueConstraintEditPart.VISUAL_ID:
			return getOpaqueConstraint_2014ContainedLinks(view);
		case MultiplicityIntervalEditPart.VISUAL_ID:
			return getMultiplicityInterval_3002ContainedLinks(view);
		case MultiplicityInterval3EditPart.VISUAL_ID:
			return getMultiplicityInterval_3003ContainedLinks(view);
		case MultiplicityInterval2EditPart.VISUAL_ID:
			return getMultiplicityInterval_3001ContainedLinks(view);
		case MultiplicityInterval4EditPart.VISUAL_ID:
			return getMultiplicityInterval_3004ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getIncomingLinks(View view) {
		switch (BVRMetamodelVisualIDRegistry.getVisualID(view)) {
		case ChoiceEditPart.VISUAL_ID:
			return getChoice_2005IncomingLinks(view);
		case Choice2EditPart.VISUAL_ID:
			return getChoice_2015IncomingLinks(view);
		case VariableEditPart.VISUAL_ID:
			return getVariable_2016IncomingLinks(view);
		case VClassifierEditPart.VISUAL_ID:
			return getVClassifier_2017IncomingLinks(view);
		case OpaqueConstraintEditPart.VISUAL_ID:
			return getOpaqueConstraint_2014IncomingLinks(view);
		case MultiplicityIntervalEditPart.VISUAL_ID:
			return getMultiplicityInterval_3002IncomingLinks(view);
		case MultiplicityInterval3EditPart.VISUAL_ID:
			return getMultiplicityInterval_3003IncomingLinks(view);
		case MultiplicityInterval2EditPart.VISUAL_ID:
			return getMultiplicityInterval_3001IncomingLinks(view);
		case MultiplicityInterval4EditPart.VISUAL_ID:
			return getMultiplicityInterval_3004IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getOutgoingLinks(View view) {
		switch (BVRMetamodelVisualIDRegistry.getVisualID(view)) {
		case ChoiceEditPart.VISUAL_ID:
			return getChoice_2005OutgoingLinks(view);
		case Choice2EditPart.VISUAL_ID:
			return getChoice_2015OutgoingLinks(view);
		case VariableEditPart.VISUAL_ID:
			return getVariable_2016OutgoingLinks(view);
		case VClassifierEditPart.VISUAL_ID:
			return getVClassifier_2017OutgoingLinks(view);
		case OpaqueConstraintEditPart.VISUAL_ID:
			return getOpaqueConstraint_2014OutgoingLinks(view);
		case MultiplicityIntervalEditPart.VISUAL_ID:
			return getMultiplicityInterval_3002OutgoingLinks(view);
		case MultiplicityInterval3EditPart.VISUAL_ID:
			return getMultiplicityInterval_3003OutgoingLinks(view);
		case MultiplicityInterval2EditPart.VISUAL_ID:
			return getMultiplicityInterval_3001OutgoingLinks(view);
		case MultiplicityInterval4EditPart.VISUAL_ID:
			return getMultiplicityInterval_3004OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getConfigurableUnit_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getChoice_2005ContainedLinks(
			View view) {
		Choice modelElement = (Choice) view.getElement();
		LinkedList<BVRMetamodelLinkDescriptor> result = new LinkedList<BVRMetamodelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_VSpec_Child_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getChoice_2015ContainedLinks(
			View view) {
		Choice modelElement = (Choice) view.getElement();
		LinkedList<BVRMetamodelLinkDescriptor> result = new LinkedList<BVRMetamodelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_VSpec_Child_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getVariable_2016ContainedLinks(
			View view) {
		Variable modelElement = (Variable) view.getElement();
		LinkedList<BVRMetamodelLinkDescriptor> result = new LinkedList<BVRMetamodelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_VSpec_Child_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getVClassifier_2017ContainedLinks(
			View view) {
		VClassifier modelElement = (VClassifier) view.getElement();
		LinkedList<BVRMetamodelLinkDescriptor> result = new LinkedList<BVRMetamodelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_VSpec_Child_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getOpaqueConstraint_2014ContainedLinks(
			View view) {
		OpaqueConstraint modelElement = (OpaqueConstraint) view.getElement();
		LinkedList<BVRMetamodelLinkDescriptor> result = new LinkedList<BVRMetamodelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_Context_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getMultiplicityInterval_3002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getMultiplicityInterval_3003ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getMultiplicityInterval_3001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getMultiplicityInterval_3004ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getChoice_2005IncomingLinks(
			View view) {
		Choice modelElement = (Choice) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<BVRMetamodelLinkDescriptor> result = new LinkedList<BVRMetamodelLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_VSpec_Child_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_Context_4003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getChoice_2015IncomingLinks(
			View view) {
		Choice modelElement = (Choice) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<BVRMetamodelLinkDescriptor> result = new LinkedList<BVRMetamodelLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_VSpec_Child_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_Context_4003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getVariable_2016IncomingLinks(
			View view) {
		Variable modelElement = (Variable) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<BVRMetamodelLinkDescriptor> result = new LinkedList<BVRMetamodelLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_VSpec_Child_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_Context_4003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getVClassifier_2017IncomingLinks(
			View view) {
		VClassifier modelElement = (VClassifier) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<BVRMetamodelLinkDescriptor> result = new LinkedList<BVRMetamodelLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_VSpec_Child_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_Context_4003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getOpaqueConstraint_2014IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getMultiplicityInterval_3002IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getMultiplicityInterval_3003IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getMultiplicityInterval_3001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getMultiplicityInterval_3004IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getChoice_2005OutgoingLinks(
			View view) {
		Choice modelElement = (Choice) view.getElement();
		LinkedList<BVRMetamodelLinkDescriptor> result = new LinkedList<BVRMetamodelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_VSpec_Child_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getChoice_2015OutgoingLinks(
			View view) {
		Choice modelElement = (Choice) view.getElement();
		LinkedList<BVRMetamodelLinkDescriptor> result = new LinkedList<BVRMetamodelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_VSpec_Child_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getVariable_2016OutgoingLinks(
			View view) {
		Variable modelElement = (Variable) view.getElement();
		LinkedList<BVRMetamodelLinkDescriptor> result = new LinkedList<BVRMetamodelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_VSpec_Child_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getVClassifier_2017OutgoingLinks(
			View view) {
		VClassifier modelElement = (VClassifier) view.getElement();
		LinkedList<BVRMetamodelLinkDescriptor> result = new LinkedList<BVRMetamodelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_VSpec_Child_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getOpaqueConstraint_2014OutgoingLinks(
			View view) {
		OpaqueConstraint modelElement = (OpaqueConstraint) view.getElement();
		LinkedList<BVRMetamodelLinkDescriptor> result = new LinkedList<BVRMetamodelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_Context_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getMultiplicityInterval_3002OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getMultiplicityInterval_3003OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getMultiplicityInterval_3001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<BVRMetamodelLinkDescriptor> getMultiplicityInterval_3004OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<BVRMetamodelLinkDescriptor> getIncomingFeatureModelFacetLinks_VSpec_Child_4001(
			VSpec target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<BVRMetamodelLinkDescriptor> result = new LinkedList<BVRMetamodelLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == BvrPackage.eINSTANCE
					.getVSpec_Child()) {
				result.add(new BVRMetamodelLinkDescriptor(setting.getEObject(),
						target, BVRMetamodelElementTypes.VSpecChild_4001,
						VSpecChildEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<BVRMetamodelLinkDescriptor> getIncomingFeatureModelFacetLinks_Constraint_Context_4003(
			VSpec target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<BVRMetamodelLinkDescriptor> result = new LinkedList<BVRMetamodelLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == BvrPackage.eINSTANCE
					.getConstraint_Context()) {
				result.add(new BVRMetamodelLinkDescriptor(setting.getEObject(),
						target,
						BVRMetamodelElementTypes.ConstraintContext_4003,
						ConstraintContextEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<BVRMetamodelLinkDescriptor> getOutgoingFeatureModelFacetLinks_VSpec_Child_4001(
			VSpec source) {
		LinkedList<BVRMetamodelLinkDescriptor> result = new LinkedList<BVRMetamodelLinkDescriptor>();
		for (Iterator<?> destinations = source.getChild().iterator(); destinations
				.hasNext();) {
			VSpec destination = (VSpec) destinations.next();
			result.add(new BVRMetamodelLinkDescriptor(source, destination,
					BVRMetamodelElementTypes.VSpecChild_4001,
					VSpecChildEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<BVRMetamodelLinkDescriptor> getOutgoingFeatureModelFacetLinks_Constraint_Context_4003(
			Constraint source) {
		LinkedList<BVRMetamodelLinkDescriptor> result = new LinkedList<BVRMetamodelLinkDescriptor>();
		VSpec destination = source.getContext();
		if (destination == null) {
			return result;
		}
		result.add(new BVRMetamodelLinkDescriptor(source, destination,
				BVRMetamodelElementTypes.ConstraintContext_4003,
				ConstraintContextEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */
		@Override
		public List<BVRMetamodelNodeDescriptor> getSemanticChildren(View view) {
			return BVRMetamodelDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<BVRMetamodelLinkDescriptor> getContainedLinks(View view) {
			return BVRMetamodelDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<BVRMetamodelLinkDescriptor> getIncomingLinks(View view) {
			return BVRMetamodelDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<BVRMetamodelLinkDescriptor> getOutgoingLinks(View view) {
			return BVRMetamodelDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
