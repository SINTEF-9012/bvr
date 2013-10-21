package org.bangbangbang.cvl.diagram.custom.ocl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.jface.text.source.DefaultAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;

public class OCLConfiguration extends SourceViewerConfiguration {
	private ColorManager colorManager = null;

	public OCLConfiguration() {
		super();

		colorManager = new ColorManager();
	}

	@Override
	public IAnnotationHover getAnnotationHover(ISourceViewer sourceViewer) {
		return new DefaultAnnotationHover();
	}

	@Override
	public IPresentationReconciler getPresentationReconciler(
			ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		{ // for default color and keyword highlight
			RGB defaultColor = new RGB(0, 0, 0);
			OclScanner scanner = new OclScanner();
			scanner.setDefaultReturnToken(new Token(new TextAttribute(
					colorManager.getColor(defaultColor))));

			DefaultDamagerRepairer dr = new DefaultDamagerRepairer(scanner);
			reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
			reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);
		}
		{ // for Comment color
			RGB c = new RGB(0, 160, 0);
			NonRuleBasedDamagerRepairer dr = new NonRuleBasedDamagerRepairer(
					new TextAttribute(colorManager.getColor(c)));
			reconciler.setDamager(dr, OCLPartitionScanner.OCL_COMMENT);
			reconciler.setRepairer(dr, OCLPartitionScanner.OCL_COMMENT);
		}

		return reconciler;
	}

	private class OclScanner extends RuleBasedScanner {
		final String[] LOGICAL_OPERATOR = { "and", "or", "xor", "implies" };
		final String[] OCL_TYPE = { "Integer", "Real", "String", "Boolean",
				"OclExpression", "OclType", "OclAny" };
		final String[] COLLECTION_OPERATOR = { "asSequence", "sortBy", "size",
				"isEmpty", "count", "sum", "select", "reject", "collect",
				"forAll", "exists", "includes", "excludes", "union",
				"intersection", "including", "excluding", "oclIsKindOf",
				"oclIsTypeOf", "oclAsType", "oclInState" };

		/**
		 * @param colorManager
		 */
		public OclScanner() {
			int style = 0;
			RGB c = null;
			IToken typeToken = null;
			List<IRule> rules = new ArrayList<IRule>();

			// LOGICAL_OPERATOR
			c = new RGB(0, 0, 0);
			style = SWT.BOLD;
			typeToken = new Token(new TextAttribute(colorManager.getColor(c),
					null, style));
			rules.add(new OCLWordRule(LOGICAL_OPERATOR, typeToken));

			// OCL_Type
			c = new RGB(70, 70, 70);
			style = SWT.BOLD;
			typeToken = new Token(new TextAttribute(colorManager.getColor(c),
					null, style));
			rules.add(new OCLWordRule(OCL_TYPE, typeToken));

			// COLLECTION_OPERATOR
			c = new RGB(0, 0, 180);
			style = SWT.BOLD;
			typeToken = new Token(new TextAttribute(colorManager.getColor(c),
					null, style));
			rules.add(new OCLWordRule(COLLECTION_OPERATOR, typeToken));

			setRules(rules.toArray(new IRule[rules.size()]));
		}
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
