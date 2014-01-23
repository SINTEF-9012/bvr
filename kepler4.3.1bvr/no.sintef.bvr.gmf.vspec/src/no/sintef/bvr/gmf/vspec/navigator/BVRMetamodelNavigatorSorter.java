package no.sintef.bvr.gmf.vspec.navigator;

import no.sintef.bvr.gmf.vspec.part.BVRMetamodelVisualIDRegistry;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class BVRMetamodelNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7008;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof BVRMetamodelNavigatorItem) {
			BVRMetamodelNavigatorItem item = (BVRMetamodelNavigatorItem) element;
			return BVRMetamodelVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
