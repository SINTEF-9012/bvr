package org.bangbangbang.cvl.system.def.providers;

import org.bangbangbang.cvl.system.def.part.CVLSystemDefEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = CVLSystemDefEditorPlugin.getInstance()
				.getElementInitializers();
		if (cached == null) {
			CVLSystemDefEditorPlugin.getInstance().setElementInitializers(
					cached = new ElementInitializers());
		}
		return cached;
	}
}
