package no.sintef.cvl.tool.strategy;

import no.sintef.cvl.tool.exception.AbstractError;
import cvl.FragmentSubstitution;

public interface BindingCalculatorStrategy {

	public void generateBindings(FragmentSubstitution fragmentSubstitution) throws AbstractError;
}
