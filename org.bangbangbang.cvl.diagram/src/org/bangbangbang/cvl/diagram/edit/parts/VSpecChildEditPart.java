package org.bangbangbang.cvl.diagram.edit.parts;

import org.bangbangbang.cvl.Choice;
import org.bangbangbang.cvl.diagram.edit.policies.VSpecChildItemSemanticEditPolicy;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class VSpecChildEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4001;

	/**
	 * @generated
	 */
	public VSpecChildEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new VSpecChildItemSemanticEditPolicy());
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
		return new VSpecChildFigure();
	}

	/**
	 * @generated
	 */
	public VSpecChildFigure getPrimaryShape() {
		return (VSpecChildFigure) getFigure();
	}

	@Override
	/**
	 * @generated NOT
	 * MOD
	 */
	public void setTarget(EditPart editPart) {
		super.setTarget(editPart);
		this.getPrimaryShape().updateFace();
	}

	/**
	 * @generated
	 */
	public class VSpecChildFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public VSpecChildFigure() {
			this.setForegroundColor(ColorConstants.black);

		}

		/**
		 * @generated NOT MOD
		 */
		public void updateFace() {
			if (VSpecChildEditPart.this.getTarget() != null
					&& VSpecChildEditPart.this.getTarget() instanceof Choice) {
				Choice node = (Choice) ((Node) VSpecChildEditPart.this
						.getTarget().getModel()).getElement();

				// set line style
				if (node.isIsImpliedByParent()) {
					this.setLineStyle(Graphics.LINE_SOLID);

				} else {
					this.setLineStyle(Graphics.LINE_DASH);

				}
			}
		}

	}

}
