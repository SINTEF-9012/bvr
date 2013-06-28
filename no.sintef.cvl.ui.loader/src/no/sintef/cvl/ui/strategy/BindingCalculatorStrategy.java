package no.sintef.cvl.ui.strategy;

import no.sintef.cvl.ui.exception.AbstractError;
import cvl.FragmentSubstitution;

public interface BindingCalculatorStrategy {

	public void generateBindings(FragmentSubstitution fragmentSubstitution) throws AbstractError;
}
