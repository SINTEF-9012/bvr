package org.bangbangbang.cvl.diagram.custom.ocl;

import org.bangbangbang.cvl.OpaqueConstraint;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.widgets.Composite;

public class OCLSourceViewer extends SourceViewer {

	public OCLSourceViewer(Composite parent, IVerticalRuler ruler, int styles,
			OpaqueConstraint constraint) {
		super(parent, ruler, styles);
		configure(new OCLConfiguration(constraint));

	}

	public IContentAssistant getContentAssistant() {
		return fContentAssistant;
	}

}
