package no.sintef.bvr.ui.editor.mvc.resolutionV2.UIElements;
import java.util.List;

import no.sintef.bvr.tool.subject.ConfigurableUnitSubject;
import no.sintef.bvr.tool.ui.editor.BVRUIKernel;
import no.sintef.bvr.tool.ui.loader.BVRModel;
import no.sintef.bvr.tool.ui.loader.BVRView;
import bvr.ConfigurableUnit;
import bvr.Constraint;

public interface BVRViewV2 extends BVRView {

		public boolean showGrouping();
		public void setGrouping(boolean group);
		public BVRUIKernel getKernel();
		public ConfigurableUnitSubject getConfigurableUnitSubject() ;
		public ConfigurableUnit getCU();
		public BVRModel getModel();
		
		public void setMaximized(Object v);
		public void setMinimized(Object v) ;
		
		public void refresh();
		
		public void setStripped(Object v);
		public void setUnstripped(Object v);
		
		public boolean isShowConstraints();
		public void setShowConstraints(boolean showConstraints);
		
		public List<Constraint> getInvalidConstraints();

}
