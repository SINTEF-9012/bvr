package no.sintef.bvr.tool.visitor;

public interface Node {

	public void accept(NodeVisitor visitor);
}
