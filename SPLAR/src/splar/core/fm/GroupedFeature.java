package splar.core.fm;

public class GroupedFeature extends FeatureTreeNode {

	private boolean isOptional = false;
	
	public GroupedFeature(  String id, String name) {		
		super(id,name);
	}
	
	public FeatureGroup getGroup() {
		return (FeatureGroup)getParent();
	}
	
	public String toString() {
		return ": " + super.toString();
	}
	
}