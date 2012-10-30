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
package no.sintef.cvl.ui.framework;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import no.sintef.cvl.ui.editor.CVLUIKernel;
import no.sintef.cvl.ui.editor.panel.CVLEditorPanel;
import no.sintef.cvl.ui.framework.OptionalElement.OPTION_STATE;
import no.sintef.cvl.ui.framework.elements.Binding;
import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.framework.elements.ConfigurableUnitPanel;
import no.sintef.cvl.ui.framework.elements.ConstraintPanel;
import no.sintef.cvl.ui.framework.elements.EditableModelPanel;
import no.sintef.cvl.ui.framework.elements.FragmentPanel;
import no.sintef.cvl.ui.framework.elements.FragmentPanel.PortType;
import no.sintef.cvl.ui.framework.elements.GroupPanel;
import no.sintef.cvl.ui.framework.elements.VClassifierPanel;

import com.explodingpixels.macwidgets.IAppWidgetFactory;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame jframe = new JFrame("CVL UI Tester");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setPreferredSize(new Dimension(800, 600));
        
        //ConfigurableUnitPanel model = new ConfigurableUnitPanel();
        CVLUIKernel model = new CVLUIKernel();
        CVLEditorPanel editorPanel = new CVLEditorPanel(model);
        model.setEditorPanel(editorPanel);
        
        VClassifierPanel c1 = new VClassifierPanel(model.getModelPanel());
        c1.setNameAndCardinality("PrinterPool", "[0..*]");
        
       /* ParallelogramTitledPanel par = new ParallelogramTitledPanel();
        par.setTitle("resolution = 300");
        model.add(par);*/
    
        FragmentPanel p11 = new FragmentPanel();
        p11.setType(PortType.PROVIDED);
        p11.setNature(FragmentPanel.PortNature.SERVICE);

        FragmentPanel p12 = new FragmentPanel();
        p12.setType(PortType.REQUIRED);
        p12.setNature(FragmentPanel.PortNature.SERVICE);
        
        p11.setTitle("Placement");
        p12.setTitle("Replacement");
        
        
        VClassifierPanel c2 = new VClassifierPanel(model.getModelPanel());
        c2.setNameAndCardinality("Printer", "[1..*]");
        c2.addAttribute("resolution", "int");
        c2.addAttribute("speed", "int");
        
        c2.addLeft(p11);
        c2.addRight(p12);
        
        Binding b0 = new Binding(OPTION_STATE.MANDATORY);
        b0.setSelected(false);
        b0.setFrom(c1);
        b0.setTo(c2);
        model.getModelPanel().addBinding(b0);
        
        
        
        VClassifierPanel c3 = new VClassifierPanel(model.getModelPanel());
        c3.setNameAndCardinality("Scanner", "[0..*]");
        c3.addAttribute("resolution", "int");
        c3.setOptionalState(OPTION_STATE.OPTIONAL);
        
        Binding b4 = new Binding(OPTION_STATE.OPTIONAL);
        b4.setSelected(false);
        b4.setFrom(c1);
        b4.setTo(c3);
        model.getModelPanel().addBinding(b4);
        
        
        GroupPanel group = new GroupPanel();
        group.setCardinality(1, 1);
        
        
        Binding b = new Binding(OPTION_STATE.MANDATORY);
        b.setSelected(false);
        b.setFrom(c2);
        b.setTo(group);
        model.getModelPanel().addBinding(b);
        
        
        
        ChoicePanel x300dpi_print = new ChoicePanel();
        x300dpi_print.setTitle("x300dpi");
        
        Binding b2 = new Binding(OPTION_STATE.OPTIONAL);
        b2.setSelected(false);
        b2.setFrom(group);
        b2.setTo(x300dpi_print);
        model.getModelPanel().addBinding(b2);
        
        
        ConstraintPanel constraint1 = new ConstraintPanel(model.getModelPanel());
        constraint1.setTitle("Resolution");
        constraint1.setConstraint("resolution = 300");
        
        Binding b5 = new Binding(OPTION_STATE.MANDATORY);
        b5.setSelected(false);
        b5.setFrom(x300dpi_print);
        b5.setTo(constraint1);
        model.getModelPanel().addBinding(b5);
        
        
        ChoicePanel x600dpi_print = new ChoicePanel();
        x600dpi_print.setTitle("x600dpi");
        
        Binding b3 = new Binding(OPTION_STATE.OPTIONAL);
        b3.setSelected(false);
        b3.setFrom(group);
        b3.setTo(x600dpi_print);
        model.getModelPanel().addBinding(b3);
        
                
        model.getModelPanel().addNode(c1);
        c1.setLocation(200, 0);
        model.getModelPanel().addNode(c2);
        c2.setLocation(100, 50);
        model.getModelPanel().addNode(c3);
        c2.setLocation(300, 50);
        model.getModelPanel().addNode(group);
        model.getModelPanel().addNode(x300dpi_print);
        model.getModelPanel().addNode(x600dpi_print);
        model.getModelPanel().addNode(constraint1);

        JScrollPane scrollPane = new JScrollPane(model.getModelPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        IAppWidgetFactory.makeIAppScrollPane(scrollPane);


        EditableModelPanel epanel = new EditableModelPanel(scrollPane);


        //jframe.add(epanel, BorderLayout.CENTER);


        jframe.add(epanel, BorderLayout.CENTER);


        /*JPanel prop = new JPanel();
        prop.add(new JButton("TOTO"));

        epanel.displayProperties(prop);*/


        jframe.pack();
        jframe.setVisible(true);


        /*HudWindow hud = new HudWindow("Window");
        hud.getJDialog().setSize(300, 350);
        hud.getJDialog().setLocationRelativeTo(jframe);
        hud.getJDialog().setResizable(true);
        hud.getJDialog().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        hud.getJDialog().setVisible(true);

        JTextField textField = HudWidgetFactory.createHudTextField("Text field");
         hud.getJDialog().add(textField);
*/



    }
}
