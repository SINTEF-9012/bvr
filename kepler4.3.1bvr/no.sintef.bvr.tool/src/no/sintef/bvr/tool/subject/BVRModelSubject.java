package no.sintef.bvr.tool.subject;


import bvr.BVRModel;
import no.sintef.bvr.tool.primitive.impl.ObserverDataBulk;

public class BVRModelSubject extends AbstractViewSubject {

	private BVRModel bvrModel;
	private String[] fields = {"bvrModel"};
	
	public BVRModelSubject(BVRModel bvrModel){
		this.bvrModel = bvrModel;
	}
	
	@Override
	public void setState(ObserverDataBulk data) {
		Object value = data.getDataField("bvrModel");
		bvrModel = (value != null) ? (BVRModel) value : null;
	}
	
	public BVRModel getBVRModel(){
		return bvrModel;
	}
	
	public void setBVRModel(BVRModel bvrModel){
		this.bvrModel = bvrModel;
	}
	
	@Override
	protected String[] getFileds(){
		return fields;
	}
}
