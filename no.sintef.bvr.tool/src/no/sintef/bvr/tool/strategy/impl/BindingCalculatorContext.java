/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.strategy.impl;

import bvr.FragmentSubstitution;
import no.sintef.bvr.tool.exception.AbstractError;
import no.sintef.bvr.tool.strategy.BindingCalculatorStrategy;

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
