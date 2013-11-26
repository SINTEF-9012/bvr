package org.bangbangbang.cvl.diagram.custom.property;

import java.util.Iterator;

import org.bangbangbang.cvl.OpaqueConstraint;
import org.bangbangbang.cvl.diagram.custom.ocl.OCLCustomUtil;
import org.bangbangbang.cvl.diagram.custom.ocl.OCLPartitionScanner;
import org.bangbangbang.cvl.diagram.custom.ocl.OCLSourceViewer;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.ITextViewerExtension2;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.source.DefaultCharacterPairMatcher;
import org.eclipse.jface.text.source.MatchingCharacterPainter;
import org.eclipse.jface.text.source.VerticalRuler;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.ocl.ParserException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.PlatformUI;

public class ConstraintDialog extends Dialog {
	public static final int VERIFY_ID = 10000;
	private OCLSourceViewer sourceViewer = null;
	private Document document = null;
	private OpaqueConstraint constraint = null;

	protected ConstraintDialog(IShellProvider parentShell,
			OpaqueConstraint opaqueConstraint) {

		super(parentShell);
		constraint = opaqueConstraint;
		document = new Document();

	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == VERIFY_ID) {
			setReturnCode(VERIFY_ID);
			try {
				boolean result;
				result = OCLCustomUtil.checkSyntax(document.get(), constraint);
				if (result) {
					MessageDialog.openInformation(PlatformUI.getWorkbench()
							.getModalDialogShellProvider().getShell(),
							"Check Syntax", "OCL Syntax Valid");
				} else {
					MessageDialog.openInformation(PlatformUI.getWorkbench()
							.getModalDialogShellProvider().getShell(),
							"Check Syntax", "OCL Constraint don't have target");
				}
			} catch (ParserException e) {
				MessageBox box = new MessageBox(getShell(), SWT.OK
						| SWT.ICON_ERROR);
				box.setText("Syntax Error");
				String message = e.getMessage();
				for (Iterator<Diagnostic> iterator = e.getDiagnostic()
						.getChildren().iterator(); iterator.hasNext();) {
					message += "\n" + iterator.next().getMessage();
				}
				box.setMessage(message);
				box.open();

			}
		} else {
			super.buttonPressed(buttonId);
		}
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, VERIFY_ID, "Verify Syntax", false);
		super.createButtonsForButtonBar(parent);
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	public String getText() {
		return document.get();

	}

	public void setText(String text) {
		document = new Document(text);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite comp = new Composite(parent, 0);
		comp.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout(1, true);
		comp.setLayout(layout);

		// Add partitioner for comment
		IDocumentPartitioner partitioner = new FastPartitioner(
				new OCLPartitionScanner(),
				new String[] { OCLPartitionScanner.OCL_COMMENT });
		partitioner.connect(document);
		document.setDocumentPartitioner(partitioner);

		// create sourceviewer
		sourceViewer = new OCLSourceViewer(comp, new VerticalRuler(0),
				SWT.V_SCROLL | SWT.H_SCROLL, constraint);
		sourceViewer.setDocument(document);
		sourceViewer.getTextWidget().addKeyListener(new ShortcutKeyListener());

		// Add painter for parenthesis highlight
		MatchingCharacterPainter painter = new MatchingCharacterPainter(
				sourceViewer, new DefaultCharacterPairMatcher(new char[] { '(',
						')' }));
		painter.setColor(Display.getDefault().getSystemColor(SWT.COLOR_GRAY));
		ITextViewerExtension2 extension = (ITextViewerExtension2) sourceViewer;
		extension.addPainter(painter);

		// Something for layout...
		GridData gridData = new GridData();
		gridData.horizontalSpan = 1;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = SWT.FILL;
		gridData.grabExcessVerticalSpace = true;
		gridData.minimumHeight = 300;
		gridData.minimumWidth = 300;

		sourceViewer.getControl().setLayoutData(gridData);

		return comp;

	}

	private class ShortcutKeyListener implements KeyListener {

		public void keyPressed(KeyEvent e) {
			switch (e.keyCode) {
			case ' ':
				if ((e.stateMask & SWT.CTRL) == SWT.CTRL) {
					sourceViewer.getContentAssistant()
							.showPossibleCompletions();
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {

		}

	}

}
