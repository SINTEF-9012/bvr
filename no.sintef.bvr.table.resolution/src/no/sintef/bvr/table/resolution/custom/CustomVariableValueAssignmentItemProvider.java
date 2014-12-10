/**
 */
package no.sintef.bvr.table.resolution.custom;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import bvr.BooleanLiteralExp;
import bvr.BvrFactory;
import bvr.BvrPackage;
import bvr.IntegerLiteralExp;
import bvr.PrimitiveTypeEnum;
import bvr.PrimitiveValueSpecification;
import bvr.PrimitveType;
import bvr.RealLiteralExp;
import bvr.StringLiteralExp;
import bvr.UnlimitedLiteralExp;
import bvr.Variable;
import bvr.VariableValueAssignment;
import bvr.provider.VSpecResolutionItemProvider;

/**
 * This is the item provider adapter for a
 * {@link no.sintef.bvr.model.VariableValueAssignment} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class CustomVariableValueAssignmentItemProvider extends
		VSpecResolutionItemProvider implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {

	private ItemPropertyDescriptor valuePropertyDescriptor = null;
	private PrimitiveTypeEnum previousType = null;

	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CustomVariableValueAssignmentItemProvider(
			AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addResolvedVariablePropertyDescriptor(object);
			addValuePropertyDescriptor(object);
		} else {
			PrimitiveTypeEnum type = ((PrimitveType) ((Variable) ((VariableValueAssignment) object)
					.getResolvedVariable()).getType()).getType();

			if (previousType != type) {
				itemPropertyDescriptors.remove(valuePropertyDescriptor);
				addValuePropertyDescriptor(object);
			}
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Resolved Variable feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addResolvedVariablePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_VariableValueAssignment_resolvedVariable_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_VariableValueAssignment_resolvedVariable_feature",
								"_UI_VariableValueAssignment_type"),
						BvrPackage.Literals.VARIABLE_VALUE_ASSIGNMENT__RESOLVED_VARIABLE,
						false, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the value this value is from
	 * VariableValueAssignment->ValueSpecification->BCLExpression <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected void addValuePropertyDescriptor(Object object) {
		PrimitiveTypeEnum type = ((PrimitveType) ((Variable) ((VariableValueAssignment) object)
				.getResolvedVariable()).getType()).getType();
		previousType = type;
		if (type == PrimitiveTypeEnum.INTEGER) {
			valuePropertyDescriptor = new ItemPropertyDescriptor(
					((ComposeableAdapterFactory) adapterFactory)
							.getRootAdapterFactory(),
					getResourceLocator(),
					"Value "
							+ getString("_UI_IntegerLiteralExp_integer_feature"),
					getString("_UI_PropertyDescriptor_description",
							"_UI_IntegerLiteralExp_integer_feature",
							"_UI_IntegerLiteralExp_type"),
					BvrPackage.Literals.INTEGER_LITERAL_EXP__INTEGER, true,
					false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
					null, null) {

				@Override
				public Object getPropertyValue(Object object) {
					try {
						return ((IntegerLiteralExp) ((PrimitiveValueSpecification) ((VariableValueAssignment) object)
								.getValue()).getExpression()).getInteger();
					} catch (ClassCastException cce) {
						return 0;
					}
				}

				@Override
				public void setPropertyValue(Object object, Object value) {
					EditingDomain editingDomain = getEditingDomain(object);
					EObject eObject = (IntegerLiteralExp) ((PrimitiveValueSpecification) ((VariableValueAssignment) object)
							.getValue()).getExpression();
					if (editingDomain == null) {
						eObject.eSet(feature, value);
					} else {
						editingDomain.getCommandStack().execute(
								SetCommand.create(editingDomain,
										getCommandOwner(eObject), feature,
										value));
					}
				}
			};
			itemPropertyDescriptors.add(valuePropertyDescriptor);
		} else if (type == PrimitiveTypeEnum.REAL) {
			valuePropertyDescriptor = new ItemPropertyDescriptor(
					((ComposeableAdapterFactory) adapterFactory)
							.getRootAdapterFactory(),
					getResourceLocator(), "Value "
							+ getString("_UI_RealLiteralExp_real_feature"),
					getString("_UI_PropertyDescriptor_description",
							"_UI_RealLiteralExp_real_feature",
							"_UI_RealLiteralExp_type"),
					BvrPackage.Literals.REAL_LITERAL_EXP__REAL, true, false,
					false, ItemPropertyDescriptor.TEXT_VALUE_IMAGE, null, null) {

				@Override
				public Object getPropertyValue(Object object) {
					try {
						return ((RealLiteralExp) ((PrimitiveValueSpecification) ((VariableValueAssignment) object)
								.getValue()).getExpression()).getReal();
					} catch (ClassCastException cce) {
						return 0;
					}
				}

				@Override
				public void setPropertyValue(Object object, Object value) {
					EditingDomain editingDomain = getEditingDomain(object);
					EObject eObject = (RealLiteralExp) ((PrimitiveValueSpecification) ((VariableValueAssignment) object)
							.getValue()).getExpression();
					if (editingDomain == null) {
						eObject.eSet(feature, value);
					} else {
						editingDomain.getCommandStack().execute(
								SetCommand.create(editingDomain,
										getCommandOwner(eObject), feature,
										value));
					}
				}
			};
			itemPropertyDescriptors.add(valuePropertyDescriptor);
		} else if (type == PrimitiveTypeEnum.UNLIMITED_NATURAL) {
			valuePropertyDescriptor = new ItemPropertyDescriptor(
					((ComposeableAdapterFactory) adapterFactory)
							.getRootAdapterFactory(),
					getResourceLocator(),
					"Value "
							+ getString("_UI_UnlimitedLiteralExp_unlimited_feature"),
					getString("_UI_PropertyDescriptor_description",
							"_UI_UnlimitedLiteralExp_unlimited_feature",
							"_UI_UnlimitedLiteralExp_type"),
					BvrPackage.Literals.UNLIMITED_LITERAL_EXP__UNLIMITED, true,
					false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
					null, null) {

				@Override
				public Object getPropertyValue(Object object) {
					try {
						return ((UnlimitedLiteralExp) ((PrimitiveValueSpecification) ((VariableValueAssignment) object)
								.getValue()).getExpression()).getUnlimited();
					} catch (ClassCastException cce) {
						return 0;
					}
				}

				@Override
				public void setPropertyValue(Object object, Object value) {
					EditingDomain editingDomain = getEditingDomain(object);
					EObject eObject = (UnlimitedLiteralExp) ((PrimitiveValueSpecification) ((VariableValueAssignment) object)
							.getValue()).getExpression();
					if (editingDomain == null) {
						eObject.eSet(feature, value);
					} else {
						editingDomain.getCommandStack().execute(
								SetCommand.create(editingDomain,
										getCommandOwner(eObject), feature,
										value));
					}
				}

			};
			itemPropertyDescriptors.add(valuePropertyDescriptor);
		} else if (type == PrimitiveTypeEnum.BOOLEAN) {
			valuePropertyDescriptor = new ItemPropertyDescriptor(
					((ComposeableAdapterFactory) adapterFactory)
							.getRootAdapterFactory(),
					getResourceLocator(), "Value "
							+ getString("_UI_BooleanLiteralExp_bool_feature"),
					getString("_UI_PropertyDescriptor_description",
							"_UI_BooleanLiteralExp_bool_feature",
							"_UI_BooleanLiteralExp_type"),
					BvrPackage.Literals.BOOLEAN_LITERAL_EXP__BOOL, true, false,
					false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null,
					null) {

				@Override
				public Object getPropertyValue(Object object) {
					try {
						return ((BooleanLiteralExp) ((PrimitiveValueSpecification) ((VariableValueAssignment) object)
								.getValue()).getExpression()).isBool();
					} catch (ClassCastException cce) {
						return false;
					}
				}

				@Override
				public void setPropertyValue(Object object, Object value) {
					EditingDomain editingDomain = getEditingDomain(object);
					EObject eObject = (BooleanLiteralExp) ((PrimitiveValueSpecification) ((VariableValueAssignment) object)
							.getValue()).getExpression();
					if (editingDomain == null) {
						eObject.eSet(feature, value);
					} else {
						editingDomain.getCommandStack().execute(
								SetCommand.create(editingDomain,
										getCommandOwner(eObject), feature,
										value));
					}
				}

			};
			itemPropertyDescriptors.add(valuePropertyDescriptor);
		} else if (type == PrimitiveTypeEnum.STRING) {
			valuePropertyDescriptor = new ItemPropertyDescriptor(
					((ComposeableAdapterFactory) adapterFactory)
							.getRootAdapterFactory(),
					getResourceLocator(), "Value "
							+ getString("_UI_StringLiteralExp_string_feature"),
					getString("_UI_PropertyDescriptor_description",
							"_UI_StringLiteralExp_string_feature",
							"_UI_StringLiteralExp_type"),
					BvrPackage.Literals.STRING_LITERAL_EXP__STRING, true,
					false, false, ItemPropertyDescriptor.TEXT_VALUE_IMAGE,
					null, null) {

				@Override
				public Object getPropertyValue(Object object) {
					try {
						return ((StringLiteralExp) ((PrimitiveValueSpecification) ((VariableValueAssignment) object)
								.getValue()).getExpression()).getString();
					} catch (ClassCastException cce) {
						return "";
					}
				}

				@Override
				public void setPropertyValue(Object object, Object value) {
					EditingDomain editingDomain = getEditingDomain(object);
					EObject eObject = (StringLiteralExp) ((PrimitiveValueSpecification) ((VariableValueAssignment) object)
							.getValue()).getExpression();
					if (editingDomain == null) {
						eObject.eSet(feature, value);
					} else {
						editingDomain.getCommandStack().execute(
								SetCommand.create(editingDomain,
										getCommandOwner(eObject), feature,
										value));
					}
				}

			};
			itemPropertyDescriptors.add(valuePropertyDescriptor);
		}

	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to
	 * deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in
	 * {@link #createCommand}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			// childrenFeatures
			// .add(BvrPackage.Literals.VARIABLE_VALUE_ASSIGNMENT__VALUE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper
		// feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns VariableValueAssignment.gif. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(
				object,
				getResourceLocator().getImage(
						"full/obj16/VariableValueAssignment"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = getString("_UI_VariableValueAssignment_type");

		if (((Variable) ((VariableValueAssignment) object)
				.getResolvedVariable()) == null
				|| ((Variable) ((VariableValueAssignment) object)
						.getResolvedVariable()).getType() == null) {
			return label;
		}
		label += " "
				+ ((PrimitveType) ((Variable) ((VariableValueAssignment) object)
						.getResolvedVariable()).getType()).getName();

		label += ": ";

		PrimitiveTypeEnum type = ((PrimitveType) ((Variable) ((VariableValueAssignment) object)
				.getResolvedVariable()).getType()).getType();
		try {
			if (type == PrimitiveTypeEnum.INTEGER) {
				label += String
						.valueOf(((IntegerLiteralExp) ((PrimitiveValueSpecification) ((VariableValueAssignment) object)
								.getValue()).getExpression()).getInteger());
			} else if (type == PrimitiveTypeEnum.REAL) {
				label += ((RealLiteralExp) ((PrimitiveValueSpecification) ((VariableValueAssignment) object)
						.getValue()).getExpression()).getReal();
			} else if (type == PrimitiveTypeEnum.UNLIMITED_NATURAL) {
				label += String
						.valueOf(((UnlimitedLiteralExp) ((PrimitiveValueSpecification) ((VariableValueAssignment) object)
								.getValue()).getExpression()).getUnlimited());
			} else if (type == PrimitiveTypeEnum.BOOLEAN) {
				label += String
						.valueOf(((BooleanLiteralExp) ((PrimitiveValueSpecification) ((VariableValueAssignment) object)
								.getValue()).getExpression()).isBool());
			} else if (type == PrimitiveTypeEnum.STRING) {
				label += ((StringLiteralExp) ((PrimitiveValueSpecification) ((VariableValueAssignment) object)
						.getValue()).getExpression()).getString();
			}
		} catch (ClassCastException cce) {
			// Nothing.
		}
		return label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached children and by creating a viewer notification, which
	 * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(VariableValueAssignment.class)) {
		case BvrPackage.VARIABLE_VALUE_ASSIGNMENT__VALUE:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(
				BvrPackage.Literals.VARIABLE_VALUE_ASSIGNMENT__VALUE,
				BvrFactory.eINSTANCE.createObjectSpecification()));

		newChildDescriptors.add(createChildParameter(
				BvrPackage.Literals.VARIABLE_VALUE_ASSIGNMENT__VALUE,
				BvrFactory.eINSTANCE.createReplacementFragmentSpecification()));

		newChildDescriptors.add(createChildParameter(
				BvrPackage.Literals.VARIABLE_VALUE_ASSIGNMENT__VALUE,
				BvrFactory.eINSTANCE.createPrimitiveValueSpecification()));
	}

}
