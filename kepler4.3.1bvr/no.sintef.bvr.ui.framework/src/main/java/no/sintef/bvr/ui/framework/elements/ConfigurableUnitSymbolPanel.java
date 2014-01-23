package no.sintef.bvr.ui.framework.elements;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingConstants;

import no.sintef.bvr.ui.framework.ErrorHighlightableElement;
import no.sintef.bvr.ui.framework.SelectElement;
import no.sintef.bvr.ui.framework.ThreePartRectanglePanel;
import no.sintef.bvr.ui.framework.TitledElement;

import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXTitledSeparator;

public class ConfigurableUnitSymbolPanel extends ThreePartRectanglePanel implements VSpecPanel, SelectElement, TitledElement, ErrorHighlightableElement {
	private static final long serialVersionUID = -3463243889276205974L;
	
	JXLabel display_name = new JXLabel();
    JXTitledSeparator separatorbar = new JXTitledSeparator();
    Map<String, JXLabel> attributesbar = new HashMap<String, JXLabel>();
    
    ConfigurableUnitPanel model;

	public String getName() {
		return display_name.getName();
	}
	

	public void setName(String name) {
		setTitle(name);
	}
    
    public ConfigurableUnitSymbolPanel(ConfigurableUnitPanel model) {
    	this.model = model;
    	
        display_name.setForeground(Color.BLACK);
        display_name.setHorizontalAlignment(SwingConstants.CENTER);
        
        addCenter(display_name);
        
        setOptionalState(OPTION_STATE.MANDATORY);
        
        setBackground(Color.WHITE);
    }
    
    /*public void addVSpec(VSpecPanel vspec) {
        Binding b = new Binding(OPTION_STATE.MANDATORY);
        b.setSelected(false);
        b.setFrom(this);
        b.setTo((JComponent)vspec);
        model.addBinding(b);
        
        System.out.println(((JComponent)vspec).getX() + ", " + ((JComponent)vspec).getX()); 
        
        ((JComponent)vspec).move(getX(), getY()+getHeight()+50);
        
        System.out.println(((JComponent)vspec).getX() + ", " + ((JComponent)vspec).getX());
    }*/

    public void addAttribute(String name, String type) {
    	JXLabel att = new JXLabel();
    	
    	att.setForeground(Color.BLACK);
        att.setText(name + " : " + type);
        att.setHorizontalAlignment(SwingConstants.LEFT);
        att.setVisible(true);
        att.setFont(new Font(null, Font.PLAIN, 11));

        attributesbar.put(name, att);
        addCenter(att);
    }
    
    public void removeAttribute(String name) {
    	
    }
    
    public void setNameAndCardinality(String name, int lower, int upper) {
    	setTitle(name + " : [" + lower + ", " + ((upper==-1)?"*":upper) + "]");
    }
    
    @Override
    public void setTitle(String title) {
    	this.display_name.setText(title + " : Configurable Unit");
        this.setToolTipText("ConfigurableUnit"+title + " : Configurable Unit");
    }

    private Boolean selected = false;

    public void setSelected(Boolean _selected) {
        selected = _selected;
        active = _selected;
    }

    public Boolean isSelected() {
        return selected;
    }

    private STATE _state = STATE.NO_ERROR;

    public void setState(STATE state) {
        _state = state;
        if (_state.equals(STATE.IN_ERROR)) {
            this.setBackground(new Color(239, 50, 50, 180));
        } else {
            setOptionalState(optionalState);
        }
    }

    public STATE getCurrentState() {
        return _state;
    }
    
    private OPTION_STATE optionalState = OPTION_STATE.MANDATORY;
    
	public void setOptionalState(OPTION_STATE state) {
		this.optionalState = state;
		
        if (optionalState.equals(OPTION_STATE.MANDATORY)) {
            this.setBackground(new Color(0, 0, 0, 25));
        } else {
        	this.setBackground(new Color(0, 0, 0, 5));
        }
	}

	public OPTION_STATE getOptionalState() {
		return optionalState;
	}

}