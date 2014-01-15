package no.sintef.cvl.tool.strategy.impl;

import cvl.FragmentSubstitution;
import no.sintef.cvl.tool.exception.AbstractError;
import no.sintef.cvl.tool.strategy.BindingCalculatorStrategy;

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
