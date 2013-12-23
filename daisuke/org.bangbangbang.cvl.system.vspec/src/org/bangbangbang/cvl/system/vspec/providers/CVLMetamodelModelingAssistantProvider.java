package org.bangbangbang.cvl.system.vspec.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.bangbangbang.cvl.system.vspec.edit.parts.Choice2EditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.ChoiceEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.ConfigurableUnitEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.OpaqueConstraintEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.VClassifierEditPart;
import org.bangbangbang.cvl.system.vspec.edit.parts.VariableEditPart;
import org.bangbangbang.cvl.system.vspec.part.CVLSystemVSpecEditorPlugin;
import org.bangbangbang.cvl.system.vspec.part.Messages;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * @generated
 */
public class CVLMetamodelModelingAssistantProvider extends
		ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof ConfigurableUnitEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(5);
			types.add(CVLMetamodelElementTypes.Choice_2001);
			types.add(CVLMetamodelElementTypes.Choice_2002);
			types.add(CVLMetamodelElementTypes.Variable_2003);
			types.add(CVLMetamodelElementTypes.VClassifier_2004);
			types.add(CVLMetamodelElementTypes.OpaqueConstraint_2005);
			return types;
		}
		if (editPart instanceof ChoiceEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(CVLMetamodelElementTypes.MultiplicityInterval_3001);
			return types;
		}
		if (editPart instanceof Choice2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(1);
			types.add(CVLMetamodelElementTypes.MultiplicityInterval_3002);
			return types;
		}
		if (editPart instanceof VClassifierEditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(2);
			types.add(CVLMetamodelElementTypes.MultiplicityInterval_3004);
			types.add(CVLMetamodelElementTypes.MultiplicityInterval_3003);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ChoiceEditPart) {
			return ((ChoiceEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Choice2EditPart) {
			return ((Choice2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof VariableEditPart) {
			return ((VariableEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof VClassifierEditPart) {
			return ((VClassifierEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof OpaqueConstraintEditPart) {
			return ((OpaqueConstraintEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof ChoiceEditPart) {
			return ((ChoiceEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Choice2EditPart) {
			return ((Choice2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof VariableEditPart) {
			return ((VariableEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof VClassifierEditPart) {
			return ((VClassifierEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ChoiceEditPart) {
			return ((ChoiceEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Choice2EditPart) {
			return ((Choice2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof VariableEditPart) {
			return ((VariableEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof VClassifierEditPart) {
			return ((VClassifierEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof OpaqueConstraintEditPart) {
			return ((OpaqueConstraintEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof ChoiceEditPart) {
			return ((ChoiceEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Choice2EditPart) {
			return ((Choice2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof VariableEditPart) {
			return ((VariableEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof VClassifierEditPart) {
			return ((VClassifierEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ChoiceEditPart) {
			return ((ChoiceEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Choice2EditPart) {
			return ((Choice2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof VariableEditPart) {
			return ((VariableEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof VClassifierEditPart) {
			return ((VClassifierEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof OpaqueConstraintEditPart) {
			return ((OpaqueConstraintEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return selectExistingElement(target,
				getTypesForSource(target, relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return selectExistingElement(source,
				getTypesForTarget(source, relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		HashSet<EObject> elements = new HashSet<EObject>();
		for (Iterator<EObject> it = diagram.getElement().eAllContents(); it
				.hasNext();) {
			EObject element = it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements
				.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(
				element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				CVLSystemVSpecEditorPlugin.getInstance()
						.getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog.setMessage(Messages.CVLMetamodelModelingAssistantProviderMessage);
		dialog.setTitle(Messages.CVLMetamodelModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
