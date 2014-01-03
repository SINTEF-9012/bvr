package org.bangbangbang.cvl.system.vspec.navigator;

import org.bangbangbang.cvl.VInterface;
import org.bangbangbang.cvl.system.vspec.edit.parts.Choice2EditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.ChoiceEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.ChoiceName2EditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.ChoiceNameEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.ConstraintContextEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.MultiplicityInterval2EditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.MultiplicityInterval3EditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.MultiplicityInterval4EditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.MultiplicityIntervalEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.MultiplicityIntervalLowerUpper2EditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.MultiplicityIntervalLowerUpper3EditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.MultiplicityIntervalLowerUpper4EditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.MultiplicityIntervalLowerUpperEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.OpaqueConstraintEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.OpaqueConstraintNameEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.VClassifierEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.VClassifierNameEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.VInterfaceEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.VSpecChildEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.VariableEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.VariableNameEditPart;
import org.bangbangbang.cvl.system.vspec.part.CVLMetamodelVisualIDRegistry;
import org.bangbangbang.cvl.system.vspec.part.CVLSystemVSpecEditorPlugin;
import org.bangbangbang.cvl.system.vspec.providers.CVLMetamodelElementTypes;
import org.bangbangbang.cvl.system.vspec.providers.CVLMetamodelParserProvider;
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

/**
 * @generated
 */
public class CVLMetamodelNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		CVLSystemVSpecEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		CVLSystemVSpecEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof CVLMetamodelNavigatorItem
				&& !isOwnView(((CVLMetamodelNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof CVLMetamodelNavigatorGroup) {
			CVLMetamodelNavigatorGroup group = (CVLMetamodelNavigatorGroup) element;
			return CVLSystemVSpecEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof CVLMetamodelNavigatorItem) {
			CVLMetamodelNavigatorItem navigatorItem = (CVLMetamodelNavigatorItem) element;
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
		switch (CVLMetamodelVisualIDRegistry.getVisualID(view)) {
		case VInterfaceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http:///cvl.ecore?VInterface", CVLMetamodelElementTypes.VInterface_1000); //$NON-NLS-1$
		case Choice2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///cvl.ecore?Choice", CVLMetamodelElementTypes.Choice_2002); //$NON-NLS-1$
		case VariableEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///cvl.ecore?Variable", CVLMetamodelElementTypes.Variable_2003); //$NON-NLS-1$
		case VClassifierEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///cvl.ecore?VClassifier", CVLMetamodelElementTypes.VClassifier_2004); //$NON-NLS-1$
		case ChoiceEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///cvl.ecore?Choice", CVLMetamodelElementTypes.Choice_2006); //$NON-NLS-1$
		case OpaqueConstraintEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http:///cvl.ecore?OpaqueConstraint", CVLMetamodelElementTypes.OpaqueConstraint_2007); //$NON-NLS-1$
		case MultiplicityIntervalEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///cvl.ecore?MultiplicityInterval", CVLMetamodelElementTypes.MultiplicityInterval_3001); //$NON-NLS-1$
		case MultiplicityInterval2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///cvl.ecore?MultiplicityInterval", CVLMetamodelElementTypes.MultiplicityInterval_3002); //$NON-NLS-1$
		case MultiplicityInterval3EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///cvl.ecore?MultiplicityInterval", CVLMetamodelElementTypes.MultiplicityInterval_3003); //$NON-NLS-1$
		case MultiplicityInterval4EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http:///cvl.ecore?MultiplicityInterval", CVLMetamodelElementTypes.MultiplicityInterval_3004); //$NON-NLS-1$
		case VSpecChildEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///cvl.ecore?VSpec?child", CVLMetamodelElementTypes.VSpecChild_4001); //$NON-NLS-1$
		case ConstraintContextEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http:///cvl.ecore?Constraint?context", CVLMetamodelElementTypes.ConstraintContext_4002); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = CVLSystemVSpecEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& CVLMetamodelElementTypes.isKnownElementType(elementType)) {
			image = CVLMetamodelElementTypes.getImage(elementType);
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
		if (element instanceof CVLMetamodelNavigatorGroup) {
			CVLMetamodelNavigatorGroup group = (CVLMetamodelNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof CVLMetamodelNavigatorItem) {
			CVLMetamodelNavigatorItem navigatorItem = (CVLMetamodelNavigatorItem) element;
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
		switch (CVLMetamodelVisualIDRegistry.getVisualID(view)) {
		case VInterfaceEditPart.VISUAL_ID:
			return getVInterface_1000Text(view);
		case Choice2EditPart.VISUAL_ID:
			return getChoice_2002Text(view);
		case VariableEditPart.VISUAL_ID:
			return getVariable_2003Text(view);
		case VClassifierEditPart.VISUAL_ID:
			return getVClassifier_2004Text(view);
		case ChoiceEditPart.VISUAL_ID:
			return getChoice_2006Text(view);
		case OpaqueConstraintEditPart.VISUAL_ID:
			return getOpaqueConstraint_2007Text(view);
		case MultiplicityIntervalEditPart.VISUAL_ID:
			return getMultiplicityInterval_3001Text(view);
		case MultiplicityInterval2EditPart.VISUAL_ID:
			return getMultiplicityInterval_3002Text(view);
		case MultiplicityInterval3EditPart.VISUAL_ID:
			return getMultiplicityInterval_3003Text(view);
		case MultiplicityInterval4EditPart.VISUAL_ID:
			return getMultiplicityInterval_3004Text(view);
		case VSpecChildEditPart.VISUAL_ID:
			return getVSpecChild_4001Text(view);
		case ConstraintContextEditPart.VISUAL_ID:
			return getConstraintContext_4002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getVInterface_1000Text(View view) {
		VInterface domainModelElement = (VInterface) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			CVLSystemVSpecEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getChoice_2002Text(View view) {
		IParser parser = CVLMetamodelParserProvider.getParser(
				CVLMetamodelElementTypes.Choice_2002,
				view.getElement() != null ? view.getElement() : view,
				CVLMetamodelVisualIDRegistry
						.getType(ChoiceName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CVLSystemVSpecEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getVariable_2003Text(View view) {
		IParser parser = CVLMetamodelParserProvider.getParser(
				CVLMetamodelElementTypes.Variable_2003,
				view.getElement() != null ? view.getElement() : view,
				CVLMetamodelVisualIDRegistry
						.getType(VariableNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CVLSystemVSpecEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getVClassifier_2004Text(View view) {
		IParser parser = CVLMetamodelParserProvider.getParser(
				CVLMetamodelElementTypes.VClassifier_2004,
				view.getElement() != null ? view.getElement() : view,
				CVLMetamodelVisualIDRegistry
						.getType(VClassifierNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CVLSystemVSpecEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getChoice_2006Text(View view) {
		IParser parser = CVLMetamodelParserProvider.getParser(
				CVLMetamodelElementTypes.Choice_2006,
				view.getElement() != null ? view.getElement() : view,
				CVLMetamodelVisualIDRegistry
						.getType(ChoiceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CVLSystemVSpecEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOpaqueConstraint_2007Text(View view) {
		IParser parser = CVLMetamodelParserProvider.getParser(
				CVLMetamodelElementTypes.OpaqueConstraint_2007, view
						.getElement() != null ? view.getElement() : view,
				CVLMetamodelVisualIDRegistry
						.getType(OpaqueConstraintNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CVLSystemVSpecEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMultiplicityInterval_3001Text(View view) {
		IParser parser = CVLMetamodelParserProvider
				.getParser(
						CVLMetamodelElementTypes.MultiplicityInterval_3001,
						view.getElement() != null ? view.getElement() : view,
						CVLMetamodelVisualIDRegistry
								.getType(MultiplicityIntervalLowerUpperEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CVLSystemVSpecEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMultiplicityInterval_3002Text(View view) {
		IParser parser = CVLMetamodelParserProvider
				.getParser(
						CVLMetamodelElementTypes.MultiplicityInterval_3002,
						view.getElement() != null ? view.getElement() : view,
						CVLMetamodelVisualIDRegistry
								.getType(MultiplicityIntervalLowerUpper2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CVLSystemVSpecEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMultiplicityInterval_3003Text(View view) {
		IParser parser = CVLMetamodelParserProvider
				.getParser(
						CVLMetamodelElementTypes.MultiplicityInterval_3003,
						view.getElement() != null ? view.getElement() : view,
						CVLMetamodelVisualIDRegistry
								.getType(MultiplicityIntervalLowerUpper3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CVLSystemVSpecEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMultiplicityInterval_3004Text(View view) {
		IParser parser = CVLMetamodelParserProvider
				.getParser(
						CVLMetamodelElementTypes.MultiplicityInterval_3004,
						view.getElement() != null ? view.getElement() : view,
						CVLMetamodelVisualIDRegistry
								.getType(MultiplicityIntervalLowerUpper4EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			CVLSystemVSpecEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5007); //$NON-NLS-1$
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
	private String getConstraintContext_4002Text(View view) {
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
		return VInterfaceEditPart.MODEL_ID.equals(CVLMetamodelVisualIDRegistry
				.getModelID(view));
	}

}
