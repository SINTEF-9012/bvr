package no.sintef.cvl.ui.strategies.impl;

import cvl.FragmentSubstitution;
import no.sintef.cvl.ui.exceptions.AbstractError;
import no.sintef.cvl.ui.strategies.BindingCalculatorStrategy;

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
