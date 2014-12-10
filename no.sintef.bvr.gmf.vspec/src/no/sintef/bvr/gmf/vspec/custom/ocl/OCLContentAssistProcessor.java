package no.sintef.bvr.gmf.vspec.custom.ocl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

import bvr.OpaqueConstraint;

public class OCLContentAssistProcessor implements IContentAssistProcessor {
	OpaqueConstraint constraint;

	public OCLContentAssistProcessor(OpaqueConstraint constraint) {
		super();
		this.constraint = constraint;
	}

	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {

		String prefix = getPrefix(viewer.getDocument(), offset);

		List<ICompletionProposal> list = new ArrayList<ICompletionProposal>(
				OCLCustomUtil.getKeyword(prefix, constraint).size());
		for (String s : OCLCustomUtil.getKeyword(prefix, constraint)) {
			list.add(new CompletionProposal(s, offset - prefix.length(), prefix
					.length(), s.length()));
		}
		return list.toArray(new ICompletionProposal[list.size()]);
	}

	private String getPrefix(IDocument doc, int offset) {
		int n = offset - 1;
		for (; n >= 0; n--) {
			char c;
			try {
				c = doc.getChar(n);
			} catch (org.eclipse.jface.text.BadLocationException e) {
				break;
			}
			if (Character.isJavaIdentifierPart(c)) {
				continue;
			} else {
				break;
			}
		}

		n++;
		try {
			return doc.get(n, offset - n);
		} catch (BadLocationException e) {
			return "";
		}
	}

	@Override
	public IContextInformation[] computeContextInformation(ITextViewer viewer,
			int offset) {
		return null;
	}

	@Override
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}

	@Override
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	@Override
	public String getErrorMessage() {
		return null;
	}

	@Override
	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}

}
