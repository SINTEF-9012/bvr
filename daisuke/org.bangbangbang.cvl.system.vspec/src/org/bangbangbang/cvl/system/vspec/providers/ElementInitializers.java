package org.bangbangbang.cvl.system.vspec.providers;

import org.bangbangbang.cvl.system.vspec.part.CVLSystemVSpecEditorPlugin;

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
		ElementInitializers cached = CVLSystemVSpecEditorPlugin.getInstance()
				.getElementInitializers();
		if (cached == null) {
			CVLSystemVSpecEditorPlugin.getInstance().setElementInitializers(
					cached = new ElementInitializers());
		}
		return cached;
	}
}
