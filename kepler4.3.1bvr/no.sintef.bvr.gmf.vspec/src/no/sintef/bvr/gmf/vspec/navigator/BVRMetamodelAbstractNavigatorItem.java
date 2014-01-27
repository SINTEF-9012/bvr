package no.sintef.bvr.gmf.vspec.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

/**
 * @generated
 */
public abstract class BVRMetamodelAbstractNavigatorItem extends PlatformObject {

	/**
	 * @generated
	 */
	static {
		final Class[] supportedTypes = new Class[] { ITabbedPropertySheetPageContributor.class };
		final ITabbedPropertySheetPageContributor propertySheetPageContributor = new ITabbedPropertySheetPageContributor() {
			public String getContributorId() {
				return "no.sintef.bvr.gmf.vspec"; //$NON-NLS-1$
			}
		};
		Platform.getAdapterManager().registerAdapters(
				new IAdapterFactory() {

					public Object getAdapter(Object adaptableObject,
							Class adapterType) {
						if (adaptableObject instanceof no.sintef.bvr.gmf.vspec.navigator.BVRMetamodelAbstractNavigatorItem
								&& adapterType == ITabbedPropertySheetPageContributor.class) {
							return propertySheetPageContributor;
						}
						return null;
					}

					public Class[] getAdapterList() {
						return supportedTypes;
					}
				},
				no.sintef.bvr.gmf.vspec.navigator.BVRMetamodelAbstractNavigatorItem.class);
	}

	/**
	 * @generated
	 */
	private Object myParent;

	/**
	 * @generated
	 */
	protected BVRMetamodelAbstractNavigatorItem(Object parent) {
		myParent = parent;
	}

	/**
	 * @generated
	 */
	public Object getParent() {
		return myParent;
	}

}
