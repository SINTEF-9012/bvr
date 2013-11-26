package org.bangbangbang.cvl.diagram.custom.ocl;

import org.bangbangbang.cvl.OpaqueConstraint;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.DefaultAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.graphics.RGB;

public class OCLConfiguration extends SourceViewerConfiguration {
	private ColorManager colorManager = null;
	private OpaqueConstraint constraint;

	public OCLConfiguration(OpaqueConstraint constraint) {
		super();
		this.constraint = constraint;
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
			OCLScanner scanner = new OCLScanner(colorManager);
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

	@Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
		ContentAssistant assistant = new ContentAssistant();

		OCLContentAssistProcessor processor = new OCLContentAssistProcessor(
				constraint);
		assistant.setContentAssistProcessor(processor,
				IDocument.DEFAULT_CONTENT_TYPE);
		assistant.setShowEmptyList(true);

		assistant.install(sourceViewer);

		return assistant;
	}

}