package org.bangbangbang.cvl.system.def.edit.parts;

import org.bangbangbang.cvl.system.def.edit.policies.ConstraintContextItemSemanticEditPolicy;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ConstraintContextEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4002;

	/**
	 * @generated
	 */
	public ConstraintContextEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ConstraintContextItemSemanticEditPolicy());
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	protected Connection createConnectionFigure() {
		return new OpaqueConstraintContextFigure();
	}

	/**
	 * @generated
	 */
	public OpaqueConstraintContextFigure getPrimaryShape() {
		return (OpaqueConstraintContextFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class OpaqueConstraintContextFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public OpaqueConstraintContextFigure() {
			this.setForegroundColor(ColorConstants.black);

		}

	}

}
