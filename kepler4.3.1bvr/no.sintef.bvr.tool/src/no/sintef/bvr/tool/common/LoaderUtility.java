/*******************************************************************************
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
 ******************************************************************************/
package no.sintef.bvr.tool.common;

import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import no.sintef.bvr.tool.context.Context;
import no.sintef.bvr.tool.primitive.SymbolVSpec;
import no.sintef.bvr.tool.primitive.SymbolVSpecResolutionTable;
import no.sintef.bvr.tool.ui.editor.BindingJTable;
import no.sintef.bvr.tool.ui.editor.FragmentSubstitutionJTable;
import no.sintef.bvr.tool.ui.editor.SubstitutionFragmentJTable;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import bvr.BvrFactory;
import bvr.FragmentSubstitution;
import bvr.FromPlacement;
import bvr.FromReplacement;
import bvr.NamedElement;
import bvr.ObjectHandle;
import bvr.PlacementBoundaryElement;
import bvr.PlacementFragment;
import bvr.ReplacementBoundaryElement;
import bvr.ReplacementFragmentType;
import bvr.ToPlacement;
import bvr.ToReplacement;
import bvr.VariationPoint;

public class LoaderUtility {

	public static String TOPLCMNT = "toPlacement";
	public static String FROMPLCMNT = "fromPlacement";
	public static String TOREPLCMNT = "toReplacement";
	public static String FROMREPLCMNT = "fromReplacement";
	
	public static boolean isNullBoundary(NamedElement boundary){
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
	
	public static ToReplacement getNullToReplacement(EList<? extends ReplacementBoundaryElement> boundaries){
		for(ReplacementBoundaryElement boundary : boundaries){
			if(isNullBoundary(boundary))
				return (ToReplacement) boundary;
		}
		return null;
	}
	
	public static FromPlacement getNullFromPlacement(EList<? extends PlacementBoundaryElement> boundaries){
		for(PlacementBoundaryElement boundary : boundaries){
			if(isNullBoundary(boundary))
				return (FromPlacement) boundary;
		}
		return null;
	}
	
	public static EList<EObject> resolveProxies(EList<ObjectHandle> proxyList){
		EList<EObject> resolvedList = new BasicEList<EObject>();
		for(ObjectHandle proxy : proxyList){
			EObject resolvedProxy = ((ObjectHandle) proxy).getMOFRef();
			resolvedList.add(resolvedProxy);
		}
		return resolvedList;
	}
	
	public static HashMap<String, ArrayList<NamedElement>> sortBoundariesByType(PlacementFragment placement, ReplacementFragmentType replacement){
		HashMap<String, ArrayList<NamedElement>> boundariesMap = new HashMap<String, ArrayList<NamedElement>>();
		ArrayList<NamedElement> toPlacements = new ArrayList<NamedElement>();
		ArrayList<NamedElement> fromPlacements = new ArrayList<NamedElement>();
		ArrayList<NamedElement> toReplacements = new ArrayList<NamedElement>();
		ArrayList<NamedElement> fromReplacements = new ArrayList<NamedElement>();
		
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
	
	public static boolean isBindingPanelInFocus(JTabbedPane modelPanel){
		if(modelPanel != null && modelPanel.getSelectedComponent() != null){
			if(modelPanel.getSelectedComponent() instanceof JTabbedPane && ((JTabbedPane) modelPanel.getSelectedComponent()).getSelectedComponent() != null){
				if(((JTabbedPane) modelPanel.getSelectedComponent()).getSelectedComponent().getName().equals(Constants.BINDING_EDITOR_NAME)){
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
	
	public static JTable getBindingTable(JScrollPane bindingPanel){
		Component table = ((JScrollPane) bindingPanel).getViewport().getView();
		if(table instanceof BindingJTable){
			return (BindingJTable) table;
		}
		return null;
	}
	
	public static String getExtension(File f){
	    String p = f.getAbsolutePath();
	    return p.substring(p.lastIndexOf(".")+1, p.length());
	}
	
	public static ToReplacement testNullToReplacement(ReplacementFragmentType replacement){
		ToReplacement nullToReplacement = getNullToReplacement(replacement.getReplacementBoundaryElement());
		if(nullToReplacement == null){
			nullToReplacement = BvrFactory.eINSTANCE.createToReplacement();
			ObjectHandle nullObjectHandle = testObjectHandle(replacement, null);
			nullToReplacement.setName(Constants.NULL_NAME);
			nullToReplacement.setOutsideBoundaryElement(nullObjectHandle);
			nullToReplacement.getInsideBoundaryElement().add(nullObjectHandle);
			replacement.getReplacementBoundaryElement().add(nullToReplacement);
		}
		return nullToReplacement;
	}
	
	public static FromPlacement testNullFromPlacement(PlacementFragment placement){
		FromPlacement nullFromPlacement;
		nullFromPlacement = LoaderUtility.getNullFromPlacement(placement.getPlacementBoundaryElement());
		if(nullFromPlacement == null){
			nullFromPlacement = BvrFactory.eINSTANCE.createFromPlacement();
			ObjectHandle nullObjectHandle = testObjectHandle(placement, null);
			nullFromPlacement.setInsideBoundaryElement(nullObjectHandle);
			nullFromPlacement.getOutsideBoundaryElement().add(nullObjectHandle);
			nullFromPlacement.setName(Constants.NULL_NAME);
			placement.getPlacementBoundaryElement().add(nullFromPlacement);
		}
		return nullFromPlacement;
	}
	
	public static ObjectHandle testObjectHandle(PlacementFragment placement, EObject eObject){
		EList<ObjectHandle> objectHandles = placement.getSourceObject();
		for(ObjectHandle oh : objectHandles){
			if(eObject != null && eObject.equals(oh.getMOFRef())){
				return oh;
			}else if(oh.getMOFRef() == null && eObject == null){
				return oh;
			}
		}
		ObjectHandle objectHandle = BvrFactory.eINSTANCE.createObjectHandle();
		objectHandle.setMOFRef(eObject);
		Context.eINSTANCE.getEditorCommands().addObjectHandlePlacement(placement, objectHandle);
		//placement.getSourceObject().add(objectHandle);
		return objectHandle;
	}
	
	public static ObjectHandle testObjectHandle(ReplacementFragmentType replacement, EObject eObject){
		EList<ObjectHandle> objectHandles = replacement.getSourceObject();
		for(ObjectHandle oh : objectHandles){
			if(eObject != null && eObject.equals(oh.getMOFRef())){
				return oh;
			}else if(oh.getMOFRef() == null && eObject == null){
				return oh;
			}
		}
		ObjectHandle objectHandle = BvrFactory.eINSTANCE.createObjectHandle();
		objectHandle.setMOFRef(eObject);
		Context.eINSTANCE.getEditorCommands().addObjectHandleReplacement(replacement, objectHandle);
		//replacement.getSourceObject().add(objectHandle);
		return objectHandle;
	}
	
	public static HashSet<FragmentSubstitution> collectFragmentSubstitutionsInTable(SymbolVSpecResolutionTable table){
		HashSet<FragmentSubstitution> fss = new HashSet<FragmentSubstitution>();
		ArrayList<SymbolVSpec> symbols = table.getSymbols();
		for(SymbolVSpec symbol : symbols){
			fss.addAll(symbol.getFragmentSubstitutions());
		}
		ArrayList<SymbolVSpecResolutionTable> tables = table.getChildren();
		for(SymbolVSpecResolutionTable symbolTable : tables){
			fss.addAll(collectFragmentSubstitutionsInTable(symbolTable));
		}
		return fss;
	}
}
