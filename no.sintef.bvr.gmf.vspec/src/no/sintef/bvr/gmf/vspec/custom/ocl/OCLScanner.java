package no.sintef.bvr.gmf.vspec.custom.ocl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;

public class OCLScanner extends RuleBasedScanner {
	private ColorManager colorManager = null;

	/**
	 * @param colorManager
	 */
	public OCLScanner(ColorManager color) {
		int style = 0;
		RGB c = null;
		IToken typeToken = null;
		List<IRule> rules = new ArrayList<IRule>();

		colorManager = color;

		// LOGICAL_OPERATOR : BLACK BOLD
		c = new RGB(0, 0, 0);
		style = SWT.BOLD;
		typeToken = new Token(new TextAttribute(colorManager.getColor(c), null,
				style));
		rules.add(new OCLWordRule(OCLCustomUtil.LOGICAL_OPERATOR, typeToken));

		// OCL_Type : GRAY BOLD
		c = new RGB(70, 70, 70);
		style = SWT.BOLD;
		typeToken = new Token(new TextAttribute(colorManager.getColor(c), null,
				style));
		rules.add(new OCLWordRule(OCLCustomUtil.OCL_TYPE, typeToken));

		// COLLECTION_OPERATOR : BLUE BOLD
		c = new RGB(0, 0, 180);
		style = SWT.BOLD;
		typeToken = new Token(new TextAttribute(colorManager.getColor(c), null,
				style));
		rules.add(new OCLWordRule(OCLCustomUtil.COLLECTION_OPERATOR, typeToken));
		rules.add(new OCLWordRule(OCLCustomUtil.OCL_OPERATOR, typeToken));
		
		
		// BVR_TYPE : ORANGE
		c = new RGB(180, 100, 0);
		style = 0;
		typeToken = new Token(new TextAttribute(colorManager.getColor(c), null,
				style));
		rules.add(new OCLWordRule(OCLCustomUtil.BVR_TYPE, typeToken));

		// keywords in model : Light BLUE ITALIC
		c = new RGB(140, 150, 255);
		style = SWT.ITALIC;
		typeToken = new Token(new TextAttribute(colorManager.getColor(c), null,
				style));
		rules.add(new OCLWordRule(OCLCustomUtil.getInstance().getKeywordInModel(), typeToken));

		setRules(rules.toArray(new IRule[rules.size()]));
	}

	private class OCLWordRule extends WordRule {
		public OCLWordRule(String[] words, IToken token) {
			super(new OCLWordDetector());
			for (String word : words) {
				addWord(word, token);
			}
		}
	}

	private class OCLWordDetector implements IWordDetector {
		@Override
		public boolean isWordStart(char c) {
			return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
		}

		@Override
		public boolean isWordPart(char c) {
			return Character.isJavaIdentifierPart(c);
		}
	}
}
