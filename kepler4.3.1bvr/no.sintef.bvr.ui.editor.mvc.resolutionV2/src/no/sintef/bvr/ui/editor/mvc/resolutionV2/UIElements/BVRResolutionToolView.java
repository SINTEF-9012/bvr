package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements;
import java.util.List;


//import no.sintef.bvr.tool.subject.ConfigurableUnitSubject;

import no.sintef.bvr.tool.ui.loader.BVRToolView;
//import no.sintef.bvr.tool.ui.loader.BVRModel;
//import bvr.ConfigurableUnit;
import bvr.Constraint;
import bvr.VSpecResolution;

public interface BVRResolutionToolView extends BVRToolView{

		public void setStripped(Object v);
		public void setUnstripped(Object v);
		public List<VSpecResolution> getStripped();
		
		public boolean showGrouping();
		public void setGrouping(boolean group);

		public boolean isShowConstraints();
		public void setShowConstraints(boolean showConstraints);
		
		public int getIncrementedNameCounter();
		public List<Constraint> getInvalidConstraints();

}
