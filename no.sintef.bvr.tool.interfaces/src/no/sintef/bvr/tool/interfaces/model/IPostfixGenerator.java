package no.sintef.bvr.tool.interfaces.model;

public interface IPostfixGenerator {

	public String getPostfix();

	public String getPostfixDelimiter();

	public String removePostfix(String str);
}
