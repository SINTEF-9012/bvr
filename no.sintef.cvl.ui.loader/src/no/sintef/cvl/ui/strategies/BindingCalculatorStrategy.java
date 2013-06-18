package no.sintef.cvl.ui.strategies;

import no.sintef.cvl.ui.exceptions.AbstractError;
import cvl.FragmentSubstitution;

public interface BindingCalculatorStrategy {

	public void generateBindings(FragmentSubstitution fragmentSubstitution) throws AbstractError;
}
