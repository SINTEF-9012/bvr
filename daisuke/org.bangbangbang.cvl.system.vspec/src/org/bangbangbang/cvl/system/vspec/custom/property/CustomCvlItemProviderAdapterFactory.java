package org.bangbangbang.cvl.system.vspec.custom.property;

import org.bangbangbang.cvl.provider.CvlItemProviderAdapterFactory;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;

public class CustomCvlItemProviderAdapterFactory extends
		CvlItemProviderAdapterFactory implements AdapterFactory {
	/**
	 * This keeps track of the one adapter used for all
	 * {@link cvl.ChoiceResolutuion} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected CustomChoiceItemProvider choiceItemProvider;

	/**
	 * This creates an adapter for a {@link cvl.ChoiceResolutuion}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public Adapter createChoiceAdapter() {
		if (choiceItemProvider == null) {
			choiceItemProvider = new CustomChoiceItemProvider(this);
		}

		return choiceItemProvider;
	}
}
