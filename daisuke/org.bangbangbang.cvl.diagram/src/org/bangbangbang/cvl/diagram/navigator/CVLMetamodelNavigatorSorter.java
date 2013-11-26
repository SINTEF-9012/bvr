package org.bangbangbang.cvl.diagram.navigator;

import org.bangbangbang.cvl.diagram.part.CVLMetamodelVisualIDRegistry;
import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class CVLMetamodelNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7008;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof CVLMetamodelNavigatorItem) {
			CVLMetamodelNavigatorItem item = (CVLMetamodelNavigatorItem) element;
			return CVLMetamodelVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
