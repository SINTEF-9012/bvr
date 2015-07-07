/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package no.sintef.bvr.tool.visitor;

import java.util.Arrays;
import java.util.HashSet;

import no.sintef.bvr.tool.primitive.SymbolEObject;
import no.sintef.bvr.tool.rule.SymbolRule;
import no.sintef.bvr.tool.rule.SymbolVSpecTargetNotNullRule;
import no.sintef.bvr.tool.rule.SymbolVSpecTargetScopeRule;

public class PropertyCheckNodeVisitor extends AbstractNodeVisitor {

	private HashSet<SymbolRule> rulesSymbolNamedElement = new HashSet<SymbolRule>(Arrays.asList(
			new SymbolVSpecTargetNotNullRule(),
			new SymbolVSpecTargetScopeRule()));
	
	@Override
	public void visitNamedElement(SymbolEObject element) {
		super.visitNamedElement(element);
		for(SymbolRule rule : rulesSymbolNamedElement)
			rule.execute(element);	
	}
}
