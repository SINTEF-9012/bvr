package no.sintef.bvr.gmf.vspec.edit.parts;

import no.sintef.bvr.gmf.vspec.edit.policies.MultiplicityInterval3CanonicalEditPolicy;
import no.sintef.bvr.gmf.vspec.edit.policies.MultiplicityInterval3ItemSemanticEditPolicy;
import no.sintef.bvr.gmf.vspec.part.BVRMetamodelVisualIDRegistry;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonShape;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class MultiplicityInterval3EditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3003;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public MultiplicityInterval3EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new MultiplicityInterval3ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new MultiplicityInterval3CanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that
		// would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new GroupMultiplicityFigure();
	}

	/**
	 * @generated
	 */
	public GroupMultiplicityFigure getPrimaryShape() {
		return (GroupMultiplicityFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof MultiplicityIntervalLowerUpper3EditPart) {
			((MultiplicityIntervalLowerUpper3EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureGroupMultiplicityIntervalFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof MultiplicityIntervalLowerUpper3EditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so
	 * you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane. Respects
	 * layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *            instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(BVRMetamodelVisualIDRegistry
				.getType(MultiplicityIntervalLowerUpper3EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class GroupMultiplicityFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureGroupMultiplicityIntervalFigure;

		/**
		 * @generated NOT
		 */
		private RectangleFigure paddingRectangleFigure0;

		/**
		 * @generated
		 */
		public GroupMultiplicityFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setOutline(false);
			this.setFill(false);
			this.setOpaque(false);
			createContents();
		}

		/**
		 * @generated NOT
		 */
		@Override
		public void repaint() {
			if (paddingRectangleFigure0 != null) {
				paddingRectangleFigure0.setSize(
						getMapMode().DPtoLP(this.getSize().width() / 2 - 10),
						getMapMode().DPtoLP(1));
			}

			super.repaint();
		}

		/**
		 * @generated NOT
		 */
		private void createContents() {

			paddingRectangleFigure0 = new RectangleFigure();

			paddingRectangleFigure0.setFill(false);
			paddingRectangleFigure0.setForegroundColor(ColorConstants.white);
			paddingRectangleFigure0.setSize(getMapMode().DPtoLP(10),
					getMapMode().DPtoLP(1));
			paddingRectangleFigure0.setOutline(false);
			
			this.add(paddingRectangleFigure0, BorderLayout.LEFT);

			PolygonShape groupMultiplicityFigurePolygon0 = new PolygonShape();

			groupMultiplicityFigurePolygon0.addPoint(new Point(getMapMode()
					.DPtoLP(10), getMapMode().DPtoLP(0)));
			groupMultiplicityFigurePolygon0.addPoint(new Point(getMapMode()
					.DPtoLP(20), getMapMode().DPtoLP(20)));
			groupMultiplicityFigurePolygon0.addPoint(new Point(getMapMode()
					.DPtoLP(0), getMapMode().DPtoLP(20)));
			groupMultiplicityFigurePolygon0.setFill(true);
			groupMultiplicityFigurePolygon0
					.setForegroundColor(ColorConstants.black);
			groupMultiplicityFigurePolygon0
					.setBackgroundColor(ColorConstants.white);

			this.add(groupMultiplicityFigurePolygon0, BorderLayout.CENTER);

			fFigureGroupMultiplicityIntervalFigure = new WrappingLabel();

			fFigureGroupMultiplicityIntervalFigure.setText("<...>");

			this.add(fFigureGroupMultiplicityIntervalFigure, BorderLayout.RIGHT);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureGroupMultiplicityIntervalFigure() {
			return fFigureGroupMultiplicityIntervalFigure;
		}

	}

}
