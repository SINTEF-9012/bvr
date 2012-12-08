package no.sintef.cvl.engine.rule.impl;

import java.util.ArrayList;
import java.util.Collections;

import no.sintef.cvl.engine.common.RuleComparator;
import no.sintef.cvl.engine.rule.Rule;
import no.sintef.cvl.engine.rule.RuleContainer;

public abstract class BasicRuleContainer implements RuleContainer {

	protected ArrayList<Rule> rules;
	
	public BasicRuleContainer() {
		Collections.sort(this.rules, new RuleComparator());
	}
	
	public void setRules(ArrayList<Rule> rules){
		this.rules = rules;
	}
	
}
