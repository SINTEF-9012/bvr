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
package splar.plugins.configuration.tests;


import static org.junit.Assert.*;
import static splar.plugins.tests.TestsGlobalContext.configurationFeatureModelXMLFile;
import static splar.plugins.tests.TestsGlobalContext.initial_feature_model_configuration_state;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.configuration.ConfigurationEngine;
import splar.core.fm.configuration.ConfigurationStep;

public abstract class ConfigurationEngineTest extends TestCase {

	public ConfigurationEngineTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	protected ConfigurationEngine confEngine = null;
	
	@Before
	public void setUp() throws Exception {
		// Creates the SAT configuration engine
		confEngine = createConfigurationEngine(configurationFeatureModelXMLFile);
		// Initializes the engine
		confEngine.reset();
	}

	protected abstract ConfigurationEngine createConfigurationEngine(String featureModelPath) throws Exception;
	
	@Test
	public void testResetConfiguration() {
		try {
			/*********************************************************************************
			 *  RESET
			 *********************************************************************************/
			confEngine.reset();
			
			// only one step is left in the configuration engine (root feature = true)
			assertEquals(1, confEngine.getSteps().size());
			
			// step has a single decision (root feature = true)
			assertEquals(1,confEngine.getLastStep().getDecisions().size()); 
			
			// decision refers to the root feature (root feature = true)
			FeatureModel model = confEngine.getModel();
			assertEquals(confEngine.getLastStep().getDecisions().toArray(new FeatureTreeNode[0])[0], model.getRoot()); 

			// check that only core features are selected when engine is reset
			assertSameFMState(initial_feature_model_configuration_state, model);
			
			dumpConfigurationSteps("Reset");
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testConfigure() {
		try {
			
			confEngine.reset();
			
			/***********************************************************************************************
			 *  CONFIGURE
			 ************************************************************************************************/
			// Selects feature "c1"
			ConfigurationStep step = confEngine.configure("c1", 1);
//			System.out.println("> Feature '" + confEngine.getModel().getNodeByID("c1").getName() + "' has been selected");
			
			// Check propagated features in current step {"c", "c12", "g_a1", "c2"}
			String propagated[] = {"c", "c12", "g_a1", "c2"};
			assertEquals(propagated.length, step.getPropagations().size());
			for( FeatureTreeNode propagatedNode: step.getPropagations() ) {
				boolean found = false;
				for( String expectedPropagated : propagated ) {
					if ( propagatedNode.getID().equals(expectedPropagated)) {
						found = true;
						break;
					}
				}
//				System.out.println("--> Propagated: " + propagatedNode.getName() + " = " + propagatedNode.getValue());
				assertTrue(found);
			}
			// step is the last step 
			assertEquals(step, confEngine.getLastStep());
			// #steps = 2
			assertEquals(2, confEngine.getSteps().size());

			dumpConfigurationSteps("Configure");

			// Deselects feature "b3"
			step = confEngine.configure("b3", 0);			
//			System.out.println("> Feature '" + confEngine.getModel().getNodeByID("b3").getName() + "' has been selected");
			
			// No propagations expected
			assertEquals(0, step.getPropagations().size());
			
			// step is the last step 
			assertEquals(step, confEngine.getLastStep());
			// #steps = 3
			assertEquals(3, confEngine.getSteps().size());
			
			dumpConfigurationSteps("Configure");
						
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}

	protected void sharedUndoTest(String testType) {
		try {
			
			FeatureModel model = confEngine.getModel();
			confEngine.reset();
			// Selects feature "c1"
			ConfigurationStep step1 = confEngine.configure("c1", 1);
			// Deselects feature "b3"
			ConfigurationStep step2 = confEngine.configure("b3", 0);			

			/*********************************************************************************
			 *  UNDO
			 *********************************************************************************/

			if ( testType.equals("testUndoByStepIndex") ) {
				confEngine.undo(confEngine.getSteps().size());
			}
			else if ( testType.equals("testUndoByStepObject") ) {
				confEngine.undo(step2);
			}
			else if ( testType.equals("testLastStepUndo") ) {
				confEngine.undoLastStep();
			}
			
			// #steps = 2
			assertEquals(2, confEngine.getSteps().size());
			String expectedState[] = {"+r","+a","+g_a1","?g_a2","+a3","?a4","?b","?b1","?b2","?b3","+c","+c1","?c11","+c12","+c2"};
			assertSameFMState(expectedState, model);
			
			
			dumpConfigurationSteps("Undo");
			
			if ( testType.equals("testUndoByStepIndex") ) {
				confEngine.undo(confEngine.getSteps().size());
			}
			else if ( testType.equals("testUndoByStepObject") ) {
				confEngine.undo(step1);
			}
			else if ( testType.equals("testLastStepUndo") ) {
				confEngine.undoLastStep();
			}
			
			// #steps = 1
			assertEquals(1, confEngine.getSteps().size());			
			// step has a single decision (root feature = true)
			assertEquals(1, confEngine.getLastStep().getDecisions().size()); 			
			// decision refers to the root feature (root feature = true)			
			assertEquals(model.getRoot(), confEngine.getLastStep().getDecisions().toArray(new FeatureTreeNode[0])[0]); 
			// check that only core features are selected 
			assertSameFMState(initial_feature_model_configuration_state, model);

			dumpConfigurationSteps("Undo");		
						
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}

	
	@Test
	public void testUndoByStepIndex() {
		sharedUndoTest("testUndoByStepIndex");
	}

	@Test
	public void testUndoByStepObject() {
		sharedUndoTest("testUndoByStepObject");
	}

	@Test
	public void testLastStepUndo() {
		sharedUndoTest("testLastStepUndo");
	}	

	@Test
	public void testConflictDetection() {
		try {

			confEngine.reset();
			confEngine.configure("c1", 1);
			confEngine.configure("b3", 0);			

			/***********************************************************************************************
			 *  CONFLICT DETECTION
			 ************************************************************************************************/						
			List<FeatureTreeNode> conflicts = confEngine.detectConflicts("g_a1");
			String expectedConflicts[] = {"c1", "b3"};
			// same number of conflicts
			assertEquals(expectedConflicts.length, conflicts.size());
			for( FeatureTreeNode feature : conflicts ) {
				boolean found = false;
				for( String expectedConflict : expectedConflicts) {
					if ( feature.getID().equals(expectedConflict)) {
						found = true;
						break;
					}
				}
				// same conflicts
				assertTrue(found);
			}		
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testToggle() {
		try {
			confEngine.reset();
			confEngine.configure("c1", 1);
			confEngine.configure("b3", 0);
			
			/***********************************************************************************************
			 *  TOGGLE
			 ************************************************************************************************/						
			confEngine.toggleDecision("g_a1");
			
			// #steps = 2
			assertEquals(2, confEngine.getSteps().size());

			// Check current state of the features in the feature model
			String expectedState[] = {"+r","+a","-g_a1","+g_a2","+a3","?a4","+b","?b1","?b2","+b3","?c","-c1","-c11","-c12","?c2"};
			assertSameFMState(expectedState, confEngine.getModel());

			dumpConfigurationSteps("Toggle");				
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testAutoCompletion() {
		try {
			FeatureModel model = confEngine.getModel();
			confEngine.reset();
			confEngine.configure("c1", 1);
			confEngine.configure("b3", 0);			
			confEngine.toggleDecision("g_a1");
			confEngine.undo(confEngine.getLastStep());

			/***********************************************************************************************
			 *  AUTO-COMPLETION: 
			 ************************************************************************************************/
			
			// Auto-completion (morefeatures)
			ConfigurationStep step = confEngine.autoComplete(true);

			String[] expectedState = new String[] {"+r","+a","+a3","+b","+c","+g_a1","+g_a2","+a4","+b1","-b2","+b3","+c1","+c2","+c11","+c12"};
			assertSameFMState(expectedState, model);
			
			// #steps = 2
			assertEquals(2, confEngine.getSteps().size());
			// step is the last step 
			assertEquals(step, confEngine.getLastStep());
			
			dumpConfigurationSteps("Auto-completion(true)");

			confEngine.undo(confEngine.getLastStep());
			
			// Auto-completion (less features)
			step = confEngine.autoComplete(false);

			expectedState = new String[] {"+r","+a","+a3","+b","-c","-g_a1","+g_a2","-a4","-b1","+b2","+b3","-c1","-c2","-c11","-c12"};
			assertSameFMState(expectedState, model);
			
			// #steps = 2
			assertEquals(2, confEngine.getSteps().size());
			// step is the last step 
			assertEquals(step, confEngine.getLastStep());
			
			dumpConfigurationSteps("Auto-completion(false)");			
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
//	@Test
//	public void testVariousConfigurationActions() {
//		try {
//			
//			FeatureModel model = confEngine.getModel();
//			confEngine.reset();
//			
//			/***********************************************************************************************
//			 *  CONFIGURE
//			 ************************************************************************************************/
//			// Selects feature "c1"
//			ConfigurationStep step = confEngine.configure("c1", 1);
////			System.out.println("> Feature '" + confEngine.getModel().getNodeByID("c1").getName() + "' has been selected");
//			
//			// Check propagated features in current step {"c", "c12", "g_a1", "c2"}
//			String propagated[] = {"c", "c12", "g_a1", "c2"};
//			assertEquals(propagated.length, step.getPropagations().size());
//			for( FeatureTreeNode propagatedNode: step.getPropagations() ) {
//				boolean found = false;
//				for( String expectedPropagated : propagated ) {
//					if ( propagatedNode.getID().equals(expectedPropagated)) {
//						found = true;
//						break;
//					}
//				}
////				System.out.println("--> Propagated: " + propagatedNode.getName() + " = " + propagatedNode.getValue());
//				assertTrue(found);
//			}
//			// step is the last step 
//			assertEquals(step, confEngine.getLastStep());
//			// #steps = 2
//			assertEquals(2, confEngine.getSteps().size());
//
//			dumpConfigurationSteps("Configure");
//
//			// Deselects feature "b3"
//			step = confEngine.configure("b3", 0);			
////			System.out.println("> Feature '" + confEngine.getModel().getNodeByID("b3").getName() + "' has been selected");
//			
//			// No propagations expected
//			assertEquals(0, step.getPropagations().size());
//			
//			// step is the last step 
//			assertEquals(step, confEngine.getLastStep());
//			// #steps = 3
//			assertEquals(3, confEngine.getSteps().size());
//			
//			dumpConfigurationSteps("Configure");
//
//			/***********************************************************************************************
//			 *  CONFLICT DETECTION
//			 ************************************************************************************************/						
//			List<FeatureTreeNode> conflicts = confEngine.detectConflicts("g_a1");
//			
////			System.out.println("> Conflicts if feature '" + confEngine.getModel().getNodeByID("g_a1").getName() + "' is toggled");
//			
//			String expectedConflicts[] = {"c1", "b3"};
//			// same number of conflicts
//			assertEquals(expectedConflicts.length, conflicts.size());
//			for( FeatureTreeNode feature : conflicts ) {
//				boolean found = false;
//				for( String expectedConflict : expectedConflicts) {
//					if ( feature.getID().equals(expectedConflict)) {
//						found = true;
//						break;
//					}
//				}
//				// same conflicts
//				assertTrue(found);
//			}
//			
//			/***********************************************************************************************
//			 *  TOGGLE
//			 ************************************************************************************************/						
////			System.out.println("> Toggling feature '" + confEngine.getModel().getNodeByID("g_a1").getName() + "'");
//			
//			confEngine.toggleDecision("g_a1");
//			
//			// #steps = 2
//			assertEquals(2, confEngine.getSteps().size());
//
//			// Check current state of the features in the feature model
//			String expectedState[] = {"+r","+a","-g_a1","+g_a2","+a3","?a4","+b","?b1","?b2","+b3","?c","-c1","-c11","-c12","?c2"};
//			assertSameFMState(expectedState, model);
//
//			dumpConfigurationSteps("Toggle");
//			
//			/***********************************************************************************************
//			 *  UNDO STEP: Retract decision made in the previous step (toggle)
//			 ************************************************************************************************/				
//			confEngine.undo(confEngine.getSteps().size());
//
//			// #steps = 1
//			assertEquals(1, confEngine.getSteps().size());
//			
//			// step has a single decision (root feature = true)
//			assertEquals(1, confEngine.getLastStep().getDecisions().size()); 
//			
//			// decision refers to the root feature (root feature = true)			
//			assertEquals(model.getRoot(), confEngine.getLastStep().getDecisions().toArray(new FeatureTreeNode[0])[0]); 
//
//			// check that only core features are selected when engine is reset
//			assertSameFMState(initial_feature_model_configuration_state, model);
//
//			dumpConfigurationSteps("Undo");
//			
//			/***********************************************************************************************
//			 *  AUTO-COMPLETION: 
//			 ************************************************************************************************/
//			
//			// Auto-completion (morefeatures)
//			step = confEngine.autoComplete(true);
//
//			expectedState = new String[] {"+r","+a","+a3","+b","+c","+g_a1","+g_a2","+a4","+b1","-b2","+b3","+c1","+c2","+c11","+c12"};
//			assertSameFMState(expectedState, model);
//			
//			// #steps = 2
//			assertEquals(2, confEngine.getSteps().size());
//			// step is the last step 
//			assertEquals(step, confEngine.getLastStep());
//			
//			dumpConfigurationSteps("Auto-completion(true)");
//
//			
////			confEngine.undo(confEngine.getSteps().size());
//			confEngine.undo(confEngine.getLastStep());
//			
//			
//			// Auto-completion (less features)
//			step = confEngine.autoComplete(false);
//
//			expectedState = new String[] {"+r","+a","+a3","+b","-c","-g_a1","+g_a2","-a4","-b1","+b2","+b3","-c1","-c2","-c11","-c12"};
//			assertSameFMState(expectedState, model);
//			
//			// #steps = 2
//			assertEquals(2, confEngine.getSteps().size());
//			// step is the last step 
//			assertEquals(step, confEngine.getLastStep());
//			
//			dumpConfigurationSteps("Auto-completion(false)");			
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//			fail(e.getMessage());
//		}
//	}

	protected void assertSameFMState(String expectedState[], FeatureModel model) {
		for( String state : expectedState ) {
			String signal = state.substring(0,1);
			String featureId = state.substring(1);
			int expectedValue =  signal.equals("+") ? 1 : (signal.equals("-") ? 0 : -1) ;
			assertEquals(expectedValue, model.getNodeByID(featureId).getValue());
		}
	}
	
	
	protected void dumpConfigurationSteps(String message) {
		System.out.println(message + ": " + confEngine);
	}

	protected void dumpFeatureModelState() {
		confEngine.getModel().dumpValues();
	}
}
