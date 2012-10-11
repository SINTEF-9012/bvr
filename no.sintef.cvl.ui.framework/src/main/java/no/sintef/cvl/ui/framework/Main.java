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
/**
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package no.sintef.cvl.ui.framework;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import no.sintef.cvl.ui.framework.elements.Binding;
import no.sintef.cvl.ui.framework.elements.ChoicePanel;
import no.sintef.cvl.ui.framework.elements.ConfigurableUnitPanel;
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


        ConfigurableUnitPanel model = new ConfigurableUnitPanel();
        
        VClassifierPanel c1 = new VClassifierPanel(model);
        c1.setNameAndCardinality("PrinterPool", "[0..*]");
        
        

        
        
        
    
        FragmentPanel p11 = new FragmentPanel();
        p11.setType(PortType.PROVIDED);
        p11.setNature(FragmentPanel.PortNature.SERVICE);

        FragmentPanel p12 = new FragmentPanel();
        p12.setType(PortType.REQUIRED);
        p12.setNature(FragmentPanel.PortNature.SERVICE);
        
        p11.setTitle("Placement");
        p12.setTitle("Replacement");
        
        
        VClassifierPanel c2 = new VClassifierPanel(model);
        c2.setNameAndCardinality("Printer", "[1..*]");
        c2.addAttribute("resolution", "int");
        
        c2.addLeft(p11);
        c2.addRight(p12);
        
        c1.addVSpec(c2);
        
        
        
        GroupPanel group = new GroupPanel();
        group.setCardinality(1, 1);
        
        
        Binding b = new Binding(Binding.Type.input);
        b.setSelected(false);
        b.setFrom(c2);
        b.setTo(group);
        model.addBinding(b);
        
        
        
        ChoicePanel x300dpi_print = new ChoicePanel();
        x300dpi_print.setTitle("x300dpi");
        
        Binding b2 = new Binding(Binding.Type.input);
        b2.setSelected(false);
        b2.setFrom(group);
        b2.setTo(x300dpi_print);
        model.addBinding(b2);
        
        ChoicePanel x600dpi_print = new ChoicePanel();
        x600dpi_print.setTitle("x600dpi");
        
        Binding b3 = new Binding(Binding.Type.input);
        b3.setSelected(false);
        b3.setFrom(group);
        b3.setTo(x600dpi_print);
        model.addBinding(b3);
        
                
        model.addNode(c1);
        model.addNode(c2);
        model.addNode(group);
        model.addNode(x300dpi_print);
        model.addNode(x600dpi_print);


        JScrollPane scrollPane = new JScrollPane(model, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
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
