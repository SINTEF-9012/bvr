package no.sintef.cvl.ui.observer.impl;

import cvl.ConfigurableUnit;
import no.sintef.cvl.ui.primitive.impl.ObserverDataBulk;

public class ConfigurableUnitSubject extends AbstractViewSubject {

	private ConfigurableUnit configurableUnit;

	public ConfigurableUnitSubject(ConfigurableUnit cu){
		configurableUnit = cu;
	}
	
	@Override
	public void setState(ObserverDataBulk data) {
		Object field = data.getDataField("configurableUnit");
		if(field instanceof ConfigurableUnit){
			configurableUnit = (ConfigurableUnit) field;
		}
	}
	
	public ConfigurableUnit getConfigurableUnit(){
		return configurableUnit;
	}

	@Override
	public boolean isApplicable(ObserverDataBulk data) {
		Object field = data.getDataField("configurableUnit");
		if(field instanceof ConfigurableUnit){
			return true;
		}
		return false;
	}

}
