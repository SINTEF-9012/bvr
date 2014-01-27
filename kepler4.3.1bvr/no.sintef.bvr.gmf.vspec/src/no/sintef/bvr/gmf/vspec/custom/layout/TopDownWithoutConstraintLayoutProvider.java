package no.sintef.bvr.gmf.vspec.custom.layout;

import java.util.Iterator;
import java.util.List;

import no.sintef.bvr.gmf.vspec.edit.parts.OpaqueConstraintEditPart;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.graph.DirectedGraph;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.providers.TopDownProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.ILayoutNodeOperation;

public class TopDownWithoutConstraintLayoutProvider extends TopDownProvider {

	public static final String LAYOUT_TYPE = "WithoutConstraint";

	@SuppressWarnings({ "restriction", "rawtypes", "unchecked" })
	@Override
	protected void buildGraph(DirectedGraph g, List selectedObjects) {
		for (Iterator<EditPart> i = selectedObjects.iterator(); i.hasNext();) {
			if (i.next() instanceof OpaqueConstraintEditPart) {
				i.remove();
			}
		}
		super.buildGraph(g, selectedObjects);
	}

	@Override
	public boolean provides(IOperation operation) {

		IAdaptable layoutHint = ((ILayoutNodeOperation) operation)
				.getLayoutHint();
		String layoutType = (String) layoutHint.getAdapter(String.class);
		return LAYOUT_TYPE.equals(layoutType);
	}

}
