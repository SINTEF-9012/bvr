package no.sintef.bvr.tool.strategy;

import no.sintef.bvr.tool.exception.AbstractError;
import bvr.FragmentSubstitution;

public interface BindingCalculatorStrategy {

	public void generateBindings(FragmentSubstitution fragmentSubstitution) throws AbstractError;
}
