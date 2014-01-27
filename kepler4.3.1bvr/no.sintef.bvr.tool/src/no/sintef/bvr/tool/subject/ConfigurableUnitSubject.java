package no.sintef.bvr.tool.subject;

import bvr.ConfigurableUnit;
import no.sintef.bvr.tool.primitive.impl.ObserverDataBulk;

public class ConfigurableUnitSubject extends AbstractViewSubject {

	private ConfigurableUnit configurableUnit;
	private String[] fields = {"configurableUnit"};
	
	public ConfigurableUnitSubject(ConfigurableUnit cu){
		configurableUnit = cu;
	}
	
	@Override
	public void setState(ObserverDataBulk data) {
		Object value = data.getDataField("configurableUnit");
		configurableUnit = (value != null) ? (ConfigurableUnit) value : null;
	}
	
	public ConfigurableUnit getConfigurableUnit(){
		return configurableUnit;
	}
	
	public void setConfigurableUnit(ConfigurableUnit cu){
		configurableUnit = cu;
	}
	
	@Override
	protected String[] getFileds(){
		return fields;
	}
}
