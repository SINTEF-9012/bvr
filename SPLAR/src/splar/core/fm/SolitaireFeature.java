package splar.core.fm;

public class SolitaireFeature extends FeatureTreeNode {

	private boolean isOptional = false;
	
	public SolitaireFeature( boolean isOptional,  String id, String name) {		
		super(id,name);
		this.isOptional = isOptional;
	}
	
	public boolean isOptional() {
		return isOptional;
	}

	public String toString() {
		String str = "";
		str = isOptional ? ":o " : ":m ";
		return str + super.toString();
	}
	
}
