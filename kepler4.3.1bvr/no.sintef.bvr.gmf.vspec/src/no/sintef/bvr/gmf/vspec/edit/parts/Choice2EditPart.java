package no.sintef.bvr.gmf.vspec.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import no.sintef.bvr.gmf.vspec.edit.policies.Choice2CanonicalEditPolicy;
import no.sintef.bvr.gmf.vspec.edit.policies.Choice2ItemSemanticEditPolicy;
import no.sintef.bvr.gmf.vspec.part.BVRMetamodelVisualIDRegistry;
import no.sintef.bvr.gmf.vspec.providers.BVRMetamodelElementTypes;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;

import bvr.Choice;
import bvr.impl.ChoiceImpl;

/**
 * @generated
 */
public class Choice2EditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2015;

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
	public Choice2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicyWithCustomReparent(
						BVRMetamodelVisualIDRegistry.TYPED_INSTANCE));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new Choice2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new Choice2CanonicalEditPolicy());
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
		return primaryShape = new ChoiceFigure();
	}

	/**
	 * @generated
	 */
	public ChoiceFigure getPrimaryShape() {
		return (ChoiceFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ChoiceName2EditPart) {
			((ChoiceName2EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureChoiceNameFigure());
			return true;
		}
		if (childEditPart instanceof ChoiceChoiceGroupMultiplicityCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureChoiceGroupMultiplicityCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his
									// content pane in his own way
			pane.add(((ChoiceChoiceGroupMultiplicityCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ChoiceName2EditPart) {
			return true;
		}
		if (childEditPart instanceof ChoiceChoiceGroupMultiplicityCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureChoiceGroupMultiplicityCompartmentFigure();
			pane.remove(((ChoiceChoiceGroupMultiplicityCompartmentEditPart) childEditPart)
					.getFigure());
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
		if (editPart instanceof ChoiceChoiceGroupMultiplicityCompartmentEditPart) {
			return getPrimaryShape()
					.getFigureChoiceGroupMultiplicityCompartmentFigure();
		}
		return getContentPane();
	}

	/**
	 * @generated NOT
	 */
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(
			ConnectionEditPart connEditPart) {
		return new ModChopboxAnchor(getFigure());
	}

	/**
	 * @generated NOT
	 */
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return new ModChopboxAnchor(getFigure());
	}

	@Override
	/**
	 * @generated NOT
	 */
	public ConnectionAnchor getTargetConnectionAnchor(
			ConnectionEditPart connEditPart) {
		this.getPrimaryShape().updateFace();
		return super.getTargetConnectionAnchor(connEditPart);
	}

	@Override
	/**
	 * @generated NOT
	 */
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		this.getPrimaryShape().updateFace();
		return super.getTargetConnectionAnchor(request);
	}

	/**
	 * @generated NOT
	 */
	private class ModChopboxAnchor extends ChopboxAnchor {
		/**
		 * @generated NOT
		 */
		public ModChopboxAnchor(IFigure figure) {
			super(figure);
		}

		/**
		 * @generated NOT
		 */
		@Override
		public Point getLocation(Point reference) {
			Figure thisFigure = null, childFigure = null;
			Point p = super.getLocation(reference);
			if (this.getOwner().getChildren().size() > 0) {
				thisFigure = (Figure) this.getOwner().getChildren().get(0);
				if (thisFigure.getChildren().size() > 1) {
					childFigure = (RectangleFigure) thisFigure.getChildren()
							.get(1);
				}
			}
			if (((ChoiceImpl) ((ShapeImpl) Choice2EditPart.this.getModel())
					.getElement()).getGroupMultiplicity() != null) {
				p.x = thisFigure.getBounds().x + thisFigure.getBounds().width
						/ 2;
				p.y = childFigure.getBounds().y + 21;
			} else {
				p.x = thisFigure.getBounds().x + thisFigure.getBounds().width
						/ 2;
				p.y = childFigure.getBounds().y;

			}
			getOwner().translateToAbsolute(p);
			return p;
		}
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
				.getType(ChoiceName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(BVRMetamodelElementTypes.VSpecChild_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ChoiceEditPart) {
			types.add(BVRMetamodelElementTypes.VSpecChild_4001);
		}
		if (targetEditPart instanceof no.sintef.bvr.gmf.vspec.edit.parts.Choice2EditPart) {
			types.add(BVRMetamodelElementTypes.VSpecChild_4001);
		}
		if (targetEditPart instanceof VariableEditPart) {
			types.add(BVRMetamodelElementTypes.VSpecChild_4001);
		}
		if (targetEditPart instanceof VClassifierEditPart) {
			types.add(BVRMetamodelElementTypes.VSpecChild_4001);
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == BVRMetamodelElementTypes.VSpecChild_4001) {
			// types.add(BVRMetamodelElementTypes.Choice_2005);
			types.add(BVRMetamodelElementTypes.Choice_2015);
			types.add(BVRMetamodelElementTypes.Variable_2016);
			types.add(BVRMetamodelElementTypes.VClassifier_2017);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(BVRMetamodelElementTypes.VSpecChild_4001);
		types.add(BVRMetamodelElementTypes.ConstraintContext_4003);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == BVRMetamodelElementTypes.VSpecChild_4001) {
			types.add(BVRMetamodelElementTypes.Choice_2005);
			types.add(BVRMetamodelElementTypes.Choice_2015);
			types.add(BVRMetamodelElementTypes.Variable_2016);
			types.add(BVRMetamodelElementTypes.VClassifier_2017);
		} else if (relationshipType == BVRMetamodelElementTypes.ConstraintContext_4003) {
			types.add(BVRMetamodelElementTypes.OpaqueConstraint_2014);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request)
					.getViewAndElementDescriptor()
					.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter
					.getAdapter(IElementType.class);
			if (type == BVRMetamodelElementTypes.MultiplicityInterval_3003) {
				return getChildBySemanticHint(BVRMetamodelVisualIDRegistry
						.getType(ChoiceChoiceGroupMultiplicityCompartmentEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	@Override
	/**
	 * @generated NOT
	 * MOD
	 */
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getNotifier() instanceof Choice) {
			getPrimaryShape().updateFace();
		}
		super.handleNotificationEvent(notification);

	}

	/**
	 * @generated
	 */
	public class ChoiceFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureChoiceNameFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureChoiceGroupMultiplicityCompartmentFigure;

		/**
		 * @generated NOT MOD
		 */
		public void updateFace() {
			Choice node = (Choice) ((Node) Choice2EditPart.this.getModel())
					.getElement();

			VSpecChildEditPart connection = null;
			for (int i = 0; i < Choice2EditPart.this.getTargetConnections()
					.size(); i++) {
				if (Choice2EditPart.this.getTargetConnections().get(i) instanceof VSpecChildEditPart) {
					connection = (VSpecChildEditPart) Choice2EditPart.this
							.getTargetConnections().get(i);
				}

			}

			// set line style according to number of some children
			if (node.isIsImpliedByParent()) {
				if (connection != null) {
					((PolylineConnectionEx) connection.getFigure()) // .setVisible(true);
							.setLineStyle(Graphics.LINE_SOLID);
					((PolylineConnectionEx) connection.getFigure()).repaint();
				}
			} else {
				if (connection != null) {
					((PolylineConnectionEx) connection.getFigure()) // .setVisible(false);
							.setLineStyle(Graphics.LINE_DASH);
					((PolylineConnectionEx) connection.getFigure()).repaint();
				}
			}
		}

		/**
		 * @generated NOT
		 */
		public ChoiceFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setOutline(false);
			this.setFill(false);
			this.setOpaque(false);
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(100),
					getMapMode().DPtoLP(0)));
			createContents();
			updateFace();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RoundedRectangle choiceFigure0 = new RoundedRectangle();

			choiceFigure0.setCornerDimensions(new Dimension(getMapMode()
					.DPtoLP(8), getMapMode().DPtoLP(8)));
			choiceFigure0.setForegroundColor(ColorConstants.black);
			choiceFigure0.setBorder(new MarginBorder(getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(9), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(0)));

			this.add(choiceFigure0, BorderLayout.CENTER);

			FlowLayout layoutChoiceFigure0 = new FlowLayout();
			layoutChoiceFigure0.setStretchMinorAxis(false);
			layoutChoiceFigure0.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);

			layoutChoiceFigure0.setMajorAlignment(FlowLayout.ALIGN_LEFTTOP);
			layoutChoiceFigure0.setMajorSpacing(5);
			layoutChoiceFigure0.setMinorSpacing(5);
			layoutChoiceFigure0.setHorizontal(true);

			choiceFigure0.setLayoutManager(layoutChoiceFigure0);

			fFigureChoiceNameFigure = new WrappingLabel();

			fFigureChoiceNameFigure.setText("<...>");

			choiceFigure0.add(fFigureChoiceNameFigure);

			fFigureChoiceGroupMultiplicityCompartmentFigure = new RectangleFigure();

			fFigureChoiceGroupMultiplicityCompartmentFigure.setOutline(false);
			fFigureChoiceGroupMultiplicityCompartmentFigure.setFill(false);
			fFigureChoiceGroupMultiplicityCompartmentFigure.setOpaque(false);

			this.add(fFigureChoiceGroupMultiplicityCompartmentFigure,
					BorderLayout.BOTTOM);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureChoiceNameFigure() {
			return fFigureChoiceNameFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureChoiceGroupMultiplicityCompartmentFigure() {
			return fFigureChoiceGroupMultiplicityCompartmentFigure;
		}

	}

}
