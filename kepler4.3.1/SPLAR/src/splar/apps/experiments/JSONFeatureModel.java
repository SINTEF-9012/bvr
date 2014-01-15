package splar.apps.experiments;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import splar.core.constraints.BooleanVariable;
import splar.core.constraints.CNFClause;
import splar.core.constraints.CNFLiteral;
import splar.core.constraints.PropositionalFormula;
import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureModelException;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.GroupedFeature;
import splar.core.fm.RootNode;
import splar.core.fm.SolitaireFeature;

public class JSONFeatureModel extends FeatureModel {

	private String featureModelJSONString;
	Map<String,FeatureTreeNode> featuresMap;
	
	public JSONFeatureModel(String featureModelJSONString) {
		super();
		this.featureModelJSONString = featureModelJSONString;
		this.featuresMap = new HashMap<String,FeatureTreeNode>();
	}
	
	
	@Override
	protected FeatureTreeNode createNodes() throws FeatureModelException {
		
		try {
			
			/*
			JSON structure for the feature model
	 		{	"feature_model_name" : "",
				"feature_diagram" : [[feature_id, feature_name, "feature_type", "parent_id"], ...],
				"crosstree_constraints" : {"constraint_1" : ['a','~b','c'], ... },
				"additional_information" : ... 				
			}
			*/
			JSONObject featureModelJSON = new JSONObject(featureModelJSONString);
	
	
			/*********************************************************
			 * Feature Diagram
			 *********************************************************/
			FeatureTreeNode rootNode = null;
			JSONArray featureDiagramFeatures = featureModelJSON.getJSONArray("feature_diagram");
			int numberOfFeatures = featureDiagramFeatures.length();
			for( int i = 0 ; i < numberOfFeatures ; i++ ) {
				JSONArray featureAttributes = featureDiagramFeatures.getJSONArray(i);
				if ( featureAttributes.length() > 0 ) {
					String featureId = featureAttributes.getString(0);
					String featureName = featureAttributes.getString(1);
					String featureType = featureAttributes.getString(2);
					String parentId = featureAttributes.getString(3);				
					FeatureTreeNode node = createNode(featureId, featureName, featureType);
					featuresMap.put(featureId, node);
					if ( i == 0 ) {
						rootNode = node;
					}
					else {
						FeatureTreeNode parentNode = featuresMap.get(parentId);
						parentNode.add(node);
					}
				}
			}

			// Feature Model Name
			String fmName = featureModelJSON.getString("feature_model_name").trim();
			setName( fmName.length() == 0 ? rootNode.getName() : fmName);
				
			/*********************************************************
			 * Cross-tree Constraints
			 *********************************************************/
			for( Iterator it = featureModelJSON.getJSONObject("crosstree_constraints").keys() ; it.hasNext() ; ) {
				String constraintId = (String)it.next();
				JSONArray literals = featureModelJSON.getJSONObject("crosstree_constraints").getJSONArray(constraintId);
				if ( literals.length() > 0 ) {
					CNFClause clause = new CNFClause();
					for ( int i = 0 ; i < literals.length() ; i++ ) {
						String literal = literals.getString(i);
						clause.addLiteral(new CNFLiteral(new BooleanVariable(literal.substring(literal.startsWith("~")?1:0)), !literal.startsWith("~") ));
					}
					addConstraint(new PropositionalFormula(constraintId, clause.toString2()));					
				}
			}			
			
			
			/*********************************************************
			 * Additional Information
			 *********************************************************/
			
			String metaData[] = {
					"fm_description:description", "fm_author:creator", "fm_author_address:address", 
					"fm_author_email:email", "fm_author_phone:phone", "fm_author_website:website",
					"fm_author_organization:organization", "fm_author_department:department", 
					"fm_creation_date:date", "fm_publication:reference" 
			};			
			for( String metaDataString : metaData ) {				
				addMetaData(metaDataString.split(":")[1], featureModelJSON.getJSONObject("additional_information").getString(metaDataString.split(":")[0]));        		
			}			
			return rootNode;
		} 
		catch (Exception e) {
			throw new FeatureModelException(e.toString());
		}

	}
	
	protected FeatureTreeNode createNode(String featureId, String featureName, String featureType) {
		FeatureTreeNode node = null;
		// It's the ROOT feature (concept)
		if ( featureType.compareToIgnoreCase("root") == 0 ) {
	        node = new RootNode( featureId, featureName );	            	
		}	
		// It's a MANDATORY feature
		else if ( featureType.compareToIgnoreCase("mandatory") == 0 ) {
	        node = new SolitaireFeature( false, featureId, featureName );
		}
		// It's a OPTIONAL feature
		else if ( featureType.compareToIgnoreCase("optional") == 0 ) {
	        node = new SolitaireFeature( true, featureId, featureName );	            	
		}
		// It's a FEATURE GROUP
		else if ( featureType.compareToIgnoreCase("xor") == 0 ) {
			node = new FeatureGroup( featureId, "", 1,1);
		}
		// It's a FEATURE GROUP
		else if ( featureType.compareToIgnoreCase("or") == 0 ) {
			node = new FeatureGroup( featureId, "", 1,-1);
		}
		// It's assumed a GROUPED feature
		else {
	        node = new GroupedFeature( featureId, featureName);
		}
		return node;
	}
	
	protected void saveNodes() {		
	}  
}
