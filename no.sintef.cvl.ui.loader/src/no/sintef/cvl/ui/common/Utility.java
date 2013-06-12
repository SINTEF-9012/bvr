package no.sintef.cvl.ui.common;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import no.sintef.cvl.ui.editors.FragmentSubstitutionJTable;
import no.sintef.cvl.ui.editors.SubstitutionFragmentJTable;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import cvl.FromPlacement;
import cvl.FromReplacement;
import cvl.ObjectHandle;
import cvl.PlacementBoundaryElement;
import cvl.PlacementFragment;
import cvl.ReplacementBoundaryElement;
import cvl.ReplacementFragmentType;
import cvl.ToPlacement;
import cvl.ToReplacement;
import cvl.VariationPoint;

public class Utility {

	public static String TOPLCMNT = "toPlacement";
	public static String FROMPLCMNT = "fromPlacement";
	public static String TOREPLCMNT = "toReplacement";
	public static String FROMREPLCMNT = "fromReplacement";
	
	public static boolean isNullBoundary(VariationPoint boundary){
		if(boundary instanceof ToReplacement){
			ToReplacement toReplacement = (ToReplacement) boundary;
			if(toReplacement.getInsideBoundaryElement().size() == 1 && toReplacement.getInsideBoundaryElement().get(0).equals(toReplacement.getOutsideBoundaryElement()) && toReplacement.getOutsideBoundaryElement().getMOFRef() == null){
				return true;
			}
		}else if(boundary instanceof FromPlacement){
			FromPlacement fromPlacement = (FromPlacement) boundary;
			if(fromPlacement.getOutsideBoundaryElement().size() == 1 && fromPlacement.getOutsideBoundaryElement().get(0).equals(fromPlacement.getInsideBoundaryElement()) && fromPlacement.getInsideBoundaryElement().getMOFRef() == null){
				return true;
			}
		}else if(boundary instanceof FromReplacement){
			FromReplacement fromReplacement = (FromReplacement) boundary;
			if(fromReplacement.getOutsideBoundaryElement().size() == 1 && fromReplacement.getOutsideBoundaryElement().get(0).equals(fromReplacement.getInsideBoundaryElement()) && fromReplacement.getInsideBoundaryElement().getMOFRef() == null){
				return true;
			}			
		} else if(boundary instanceof ToPlacement){
			ToPlacement toPlacement = (ToPlacement) boundary;
			if(toPlacement.getInsideBoundaryElement().size() == 1 && toPlacement.getInsideBoundaryElement().get(0).equals(toPlacement.getOutsideBoundaryElement()) && toPlacement.getOutsideBoundaryElement().getMOFRef() == null){
				return true;
			}
		}
		return false;
	}
	
	public static EList<EObject> resolveProxies(EList<ObjectHandle> proxyList){
		EList<EObject> resolvedList = new BasicEList<EObject>();
		for(ObjectHandle proxy : proxyList){
			EObject resolvedProxy = ((ObjectHandle) proxy).getMOFRef();
			resolvedList.add(resolvedProxy);
		}
		return resolvedList;
	}
	
	public static HashMap<String, ArrayList<VariationPoint>> filterOutBoundariesByType(PlacementFragment placement, ReplacementFragmentType replacement){
		HashMap<String, ArrayList<VariationPoint>> boundariesMap = new HashMap<String, ArrayList<VariationPoint>>();
		ArrayList<VariationPoint> toPlacements = new ArrayList<VariationPoint>();
		ArrayList<VariationPoint> fromPlacements = new ArrayList<VariationPoint>();
		ArrayList<VariationPoint> toReplacements = new ArrayList<VariationPoint>();
		ArrayList<VariationPoint> fromReplacements = new ArrayList<VariationPoint>();
		
		EList<PlacementBoundaryElement> placementBoundaries = placement.getPlacementBoundaryElement();
		EList<ReplacementBoundaryElement> replacementBoundaries = replacement.getReplacementBoundaryElement();
		for(PlacementBoundaryElement boundary : placementBoundaries){
			if(boundary instanceof ToPlacement){
				toPlacements.add((ToPlacement) boundary);
			}
			if(boundary instanceof FromPlacement){
				fromPlacements.add((FromPlacement) boundary);
			}
		}
		for(ReplacementBoundaryElement boundary : replacementBoundaries){
			if(boundary instanceof ToReplacement){
				toReplacements.add((ToReplacement) boundary);
			}
			if(boundary instanceof FromReplacement){
				fromReplacements.add((FromReplacement) boundary);
			}			
		}
		boundariesMap.put(TOPLCMNT, toPlacements);
		boundariesMap.put(FROMPLCMNT, fromPlacements);
		boundariesMap.put(TOREPLCMNT, toReplacements);
		boundariesMap.put(FROMREPLCMNT, fromReplacements);
		return boundariesMap;
	}
	
	public static boolean isVariationPointsPanelInFocus(JTabbedPane modelPanel){
		if(modelPanel != null && modelPanel.getSelectedComponent() != null){
			if(modelPanel.getSelectedComponent() instanceof JTabbedPane && ((JTabbedPane) modelPanel.getSelectedComponent()).getSelectedComponent() != null){
				if(((JTabbedPane) modelPanel.getSelectedComponent()).getSelectedComponent().getName().equals(Constants.REALIZATION_VP_SUBTAB_NAME)){
					return true;
				}
			}
		}
		return false;
	}
	
	public static JTable getSibstitutionFragmentTable(JPanel variationPanel){
		Component[] components = variationPanel.getComponents();
		for(Component comp : components){
			if(comp instanceof JScrollPane){
				Component table = ((JScrollPane) comp).getViewport().getView();
				if(table instanceof SubstitutionFragmentJTable){
					return (SubstitutionFragmentJTable) table;
				}
			}
		}
		return null;
	}
	
	public static JTable getFragmentSibstitutionTable(JPanel variationPanel){
		Component[] components = variationPanel.getComponents();
		for(Component comp : components){
			if(comp instanceof JScrollPane){
				Component table = ((JScrollPane) comp).getViewport().getView();
				if(table instanceof FragmentSubstitutionJTable){
					return (FragmentSubstitutionJTable) table;
				}
			}
		}
		return null;
	}
}
