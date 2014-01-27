package no.sintef.bvr.gmf.vspec.navigator;

import no.sintef.bvr.gmf.vspec.edit.parts.Choice2EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.ChoiceEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.ChoiceName2EditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.ChoiceNameEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.ConfigurableUnitEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.ConstraintContextEditPart;
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
import no.sintef.bvr.gmf.vspec.edit.parts.VClassifierNameEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.VSpecChildEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.VariableEditPart;
import no.sintef.bvr.gmf.vspec.edit.parts.VariableNameEditPart;
import no.sintef.bvr.gmf.vspec.part.BVRMetamodelDiagramEditorPlugin;
import no.sintef.bvr.gmf.vspec.part.BVRMetamodelVisualIDRegistry;
import no.sintef.bvr.gmf.vspec.providers.BVRMetamodelElementTypes;
import no.sintef.bvr.gmf.vspec.providers.BVRMetamodelParserProvider;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import bvr.ConfigurableUnit;

/**
 * @generated
 */
public class BVRMetamodelNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		BVRMetamodelDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		BVRMetamodelDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof BVRMetamodelNavigatorItem
				&& !isOwnView(((BVRMetamodelNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof BVRMetamodelNavigatorGroup) {
			BVRMetamodelNavigatorGroup group = (BVRMetamodelNavigatorGroup) element;
			return BVRMetamodelDiagramEditorPlugin.getInstance()
					.getBundledImage(group.getIcon());
		}

		if (element instanceof BVRMetamodelNavigatorItem) {
			BVRMetamodelNavigatorItem navigatorItem = (BVRMetamodelNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (BVRMetamodelVisualIDRegistry.getVisualID(view)) {
		case ConfigurableUnitEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http:///bvr.ecore?ConfigurableUnit", BVRMetamodelElementTypes.ConfigurableUnit_1000); //$NON-NLS-1$
		case ChoiceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///bvr.ecore?Choice", BVRMetamodelElementTypes.Choice_2005); //$NON-NLS-1$
		case OpaqueConstraintEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///bvr.ecore?OpaqueConstraint", BVRMetamodelElementTypes.OpaqueConstraint_2014); //$NON-NLS-1$
		case Choice2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///bvr.ecore?Choice", BVRMetamodelElementTypes.Choice_2015); //$NON-NLS-1$
		case VariableEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///bvr.ecore?Variable", BVRMetamodelElementTypes.Variable_2016); //$NON-NLS-1$
		case VClassifierEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///bvr.ecore?VClassifier", BVRMetamodelElementTypes.VClassifier_2017); //$NON-NLS-1$
		case MultiplicityInterval2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///bvr.ecore?MultiplicityInterval", BVRMetamodelElementTypes.MultiplicityInterval_3001); //$NON-NLS-1$
		case MultiplicityIntervalEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///bvr.ecore?MultiplicityInterval", BVRMetamodelElementTypes.MultiplicityInterval_3002); //$NON-NLS-1$
		case MultiplicityInterval3EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///bvr.ecore?MultiplicityInterval", BVRMetamodelElementTypes.MultiplicityInterval_3003); //$NON-NLS-1$
		case MultiplicityInterval4EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///bvr.ecore?MultiplicityInterval", BVRMetamodelElementTypes.MultiplicityInterval_3004); //$NON-NLS-1$
		case VSpecChildEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///bvr.ecore?VSpec?child", BVRMetamodelElementTypes.VSpecChild_4001); //$NON-NLS-1$
		case ConstraintContextEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///bvr.ecore?Constraint?context", BVRMetamodelElementTypes.ConstraintContext_4003); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = BVRMetamodelDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& BVRMetamodelElementTypes.isKnownElementType(elementType)) {
			image = BVRMetamodelElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof BVRMetamodelNavigatorGroup) {
			BVRMetamodelNavigatorGroup group = (BVRMetamodelNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof BVRMetamodelNavigatorItem) {
			BVRMetamodelNavigatorItem navigatorItem = (BVRMetamodelNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (BVRMetamodelVisualIDRegistry.getVisualID(view)) {
		case ConfigurableUnitEditPart.VISUAL_ID:
			return getConfigurableUnit_1000Text(view);
		case ChoiceEditPart.VISUAL_ID:
			return getChoice_2005Text(view);
		case OpaqueConstraintEditPart.VISUAL_ID:
			return getOpaqueConstraint_2014Text(view);
		case Choice2EditPart.VISUAL_ID:
			return getChoice_2015Text(view);
		case VariableEditPart.VISUAL_ID:
			return getVariable_2016Text(view);
		case VClassifierEditPart.VISUAL_ID:
			return getVClassifier_2017Text(view);
		case MultiplicityInterval2EditPart.VISUAL_ID:
			return getMultiplicityInterval_3001Text(view);
		case MultiplicityIntervalEditPart.VISUAL_ID:
			return getMultiplicityInterval_3002Text(view);
		case MultiplicityInterval3EditPart.VISUAL_ID:
			return getMultiplicityInterval_3003Text(view);
		case MultiplicityInterval4EditPart.VISUAL_ID:
			return getMultiplicityInterval_3004Text(view);
		case VSpecChildEditPart.VISUAL_ID:
			return getVSpecChild_4001Text(view);
		case ConstraintContextEditPart.VISUAL_ID:
			return getConstraintContext_4003Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getConfigurableUnit_1000Text(View view) {
		ConfigurableUnit domainModelElement = (ConfigurableUnit) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			BVRMetamodelDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getChoice_2005Text(View view) {
		IParser parser = BVRMetamodelParserProvider.getParser(
				BVRMetamodelElementTypes.Choice_2005,
				view.getElement() != null ? view.getElement() : view,
				BVRMetamodelVisualIDRegistry
						.getType(ChoiceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			BVRMetamodelDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOpaqueConstraint_2014Text(View view) {
		IParser parser = BVRMetamodelParserProvider.getParser(
				BVRMetamodelElementTypes.OpaqueConstraint_2014, view
						.getElement() != null ? view.getElement() : view,
				BVRMetamodelVisualIDRegistry
						.getType(OpaqueConstraintConstraintEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			BVRMetamodelDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getChoice_2015Text(View view) {
		IParser parser = BVRMetamodelParserProvider.getParser(
				BVRMetamodelElementTypes.Choice_2015,
				view.getElement() != null ? view.getElement() : view,
				BVRMetamodelVisualIDRegistry
						.getType(ChoiceName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			BVRMetamodelDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5022); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getVariable_2016Text(View view) {
		IParser parser = BVRMetamodelParserProvider.getParser(
				BVRMetamodelElementTypes.Variable_2016,
				view.getElement() != null ? view.getElement() : view,
				BVRMetamodelVisualIDRegistry
						.getType(VariableNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			BVRMetamodelDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5023); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getVClassifier_2017Text(View view) {
		IParser parser = BVRMetamodelParserProvider.getParser(
				BVRMetamodelElementTypes.VClassifier_2017,
				view.getElement() != null ? view.getElement() : view,
				BVRMetamodelVisualIDRegistry
						.getType(VClassifierNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			BVRMetamodelDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5024); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMultiplicityInterval_3001Text(View view) {
		IParser parser = BVRMetamodelParserProvider
				.getParser(
						BVRMetamodelElementTypes.MultiplicityInterval_3001,
						view.getElement() != null ? view.getElement() : view,
						BVRMetamodelVisualIDRegistry
								.getType(MultiplicityIntervalLowerUpper2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			BVRMetamodelDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5018); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMultiplicityInterval_3002Text(View view) {
		IParser parser = BVRMetamodelParserProvider
				.getParser(
						BVRMetamodelElementTypes.MultiplicityInterval_3002,
						view.getElement() != null ? view.getElement() : view,
						BVRMetamodelVisualIDRegistry
								.getType(MultiplicityIntervalLowerUpperEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			BVRMetamodelDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5026); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMultiplicityInterval_3003Text(View view) {
		IParser parser = BVRMetamodelParserProvider
				.getParser(
						BVRMetamodelElementTypes.MultiplicityInterval_3003,
						view.getElement() != null ? view.getElement() : view,
						BVRMetamodelVisualIDRegistry
								.getType(MultiplicityIntervalLowerUpper3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			BVRMetamodelDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5027); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMultiplicityInterval_3004Text(View view) {
		IParser parser = BVRMetamodelParserProvider
				.getParser(
						BVRMetamodelElementTypes.MultiplicityInterval_3004,
						view.getElement() != null ? view.getElement() : view,
						BVRMetamodelVisualIDRegistry
								.getType(MultiplicityIntervalLowerUpper4EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			BVRMetamodelDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5028); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getVSpecChild_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getConstraintContext_4003Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return ConfigurableUnitEditPart.MODEL_ID
				.equals(BVRMetamodelVisualIDRegistry.getModelID(view));
	}

}
