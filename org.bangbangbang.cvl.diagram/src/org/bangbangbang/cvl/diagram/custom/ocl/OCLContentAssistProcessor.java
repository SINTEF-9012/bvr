package org.bangbangbang.cvl.diagram.custom.ocl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class OCLContentAssistProcessor implements IContentAssistProcessor {
	final String[] LOGICAL_OPERATOR = { "and", "or", "xor", "implies" };
	final String[] OCL_TYPE = { "Integer", "Real", "String", "Boolean",
			"OclExpression", "OclType", "OclAny" };
	final String[] COLLECTION_OPERATOR = { "asSequence", "sortBy", "size",
			"isEmpty", "count", "sum", "select", "reject", "collect",
			"forAll", "exists", "includes", "excludes", "union",
			"intersection", "including", "excluding", "oclIsKindOf",
			"oclIsTypeOf", "oclAsType", "oclInState" };

	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {
		List<ICompletionProposal> list = new ArrayList<ICompletionProposal>(COLLECTION_OPERATOR.length);
		for (String s : COLLECTION_OPERATOR) {
			list.add(new CompletionProposal(s, offset, 0, s.length()));
		}
		return list.toArray(new ICompletionProposal[list.size()]);
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
