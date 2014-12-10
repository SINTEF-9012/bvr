/**
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package no.sintef.bvr.ui.framework.listener;

import java.awt.Point;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.awt.Component;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import no.sintef.bvr.ui.framework.elements.BVRModelPanel;

public class InstanceDragSourceListener extends DragSourceAdapter implements DragSourceMotionListener, DragGestureListener {

    public JPanel flightComponent;
    private DragSource dragSource;
    private DragGestureEvent dragOriginEvent;
    private Transferable transferable;
    private Point origin2;
    public DragGestureRecognizer dgr = null;

    private DropTarget flightNodeDropTarget = null;


    public InstanceDragSourceListener(JPanel _panel) {
        flightComponent = _panel;
        this.dragSource = DragSource.getDefaultDragSource();

        for(MouseListener ml : this.flightComponent.getMouseListeners()){
            if(ml.getClass().getSimpleName().contains("DragGestureRecognizer")){
                this.flightComponent.removeMouseListener(ml);
            }
        }


       dgr= this.dragSource.createDefaultDragGestureRecognizer((Component) this.flightComponent, DnDConstants.ACTION_MOVE, this);
        dragSource.addDragSourceMotionListener(this);
        transferable = new Transferable() {

            public DataFlavor[] getTransferDataFlavors() {
                return new DataFlavor[0];
            }

            public boolean isDataFlavorSupported(DataFlavor arg0) {
                return true;
            }

            public Object getTransferData(DataFlavor arg0) {
                return flightComponent;
            }
        };

    }

    private DropTargetListener tempDropTarget = null;

    public void dragGestureRecognized(DragGestureEvent dge) {
        dragOriginEvent = dge;
        Point origin = dragOriginEvent.getDragOrigin();
        origin2 = (Point) origin.clone();
        //SwingUtilities.convertPointToScreen(origin2, p);
        //SwingUtilities.convertPointFromScreen(origin2,(Component) p);
        flightNodeDropTarget = ((Component) this.flightComponent).getDropTarget();
        ((Component) this.flightComponent).setDropTarget(null);
        try {
            dragSource.startDrag(dragOriginEvent, DragSource.DefaultLinkDrop, transferable, this);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(this.flightComponent.getMouseListeners().length);
            for(MouseListener ml : this.flightComponent.getMouseListeners()){
                System.out.println(ml);
            }
        }



    }

    @Override
    public void dragDropEnd(DragSourceDropEvent dragSourceDropEvent) {
        ((Component) this.flightComponent).setDropTarget(flightNodeDropTarget);
    }

    @Override
    public void dragMouseMoved(DragSourceDragEvent dsde) {
        super.dragMouseMoved(dsde);
        if (dsde.getDragSourceContext().getComponent().equals(this.flightComponent)) {
            Point p = dsde.getLocation();
            Point p2 = (Point) p.clone();
            SwingUtilities.convertPointFromScreen(p2, flightComponent.getParent());

            //tempPanel.setLocation(new Point(p2.x - origin2.x, p2.y - origin2.y));
            // kernel.getModelPanel().setFlightObject(flightComponent, new Point(p2.x - origin2.x, p2.y - origin2.y));

          //  System.out.println((p2.x - origin2.x) + "-" + (p2.y - origin2.y));

            int newX = (p2.x - origin2.x);
            if(newX < 0){newX = 0;}
            int newY = (p2.y - origin2.y);
            if(newY < 0){newY = 0;}

                flightComponent.setBounds(newX, newY, flightComponent.getWidth(), flightComponent.getHeight());
                ((BVRModelPanel) this.flightComponent.getParent().getParent()).update();



        }

    }
}
