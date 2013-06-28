package no.sintef.cvl.ui.strategy.impl;

import cvl.FragmentSubstitution;
import no.sintef.cvl.ui.exception.AbstractError;
import no.sintef.cvl.ui.strategy.BindingCalculatorStrategy;

public class BindingCalculatorContext {
	
	private BindingCalculatorStrategy defaultStrategy;

	public BindingCalculatorContext(){
		this.defaultStrategy = new DefaultBindingCalculatorStrategy();
	}
	
	public BindingCalculatorContext(BindingCalculatorStrategy bindingCalculator){
		this.defaultStrategy = bindingCalculator;
	}
	
	public void generateBindings(FragmentSubstitution fragmentSubstitution) throws AbstractError{
		this.defaultStrategy.generateBindings(fragmentSubstitution);
	}

}
