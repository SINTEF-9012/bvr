package no.sintef.bvr.gmf.vspec.custom.ocl;

import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

public class OCLPartitionScanner extends RuleBasedPartitionScanner {
	public final static String OCL_COMMENT = "__ocl_comment";

	public OCLPartitionScanner() {
		IToken commentToken = new Token(OCL_COMMENT);
		IPredicateRule[] rules = { new EndOfLineRule("--", commentToken), };

		setPredicateRules(rules);
	}
}
