package no.sintef.cvl.engine.common;

import java.util.Comparator;

import no.sintef.cvl.engine.rule.Rule;

public class RuleComparator implements Comparator<Rule> {

	@Override
	public int compare(Rule rule0, Rule rule1) {
		return rule0.getWeight() - rule1.getWeight();
	}

}
