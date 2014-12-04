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
package splar.plugins.reasoners.tests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static splar.plugins.tests.TestsGlobalContext.*;

import javax.naming.OperationNotSupportedException;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import splar.core.fm.FeatureModel;
import splar.core.fm.XMLFeatureModel;
import splar.core.fm.reasoning.FMReasoningInterface;

public abstract class FMReasoningInterfaceTest extends TestCase {

	public FMReasoningInterfaceTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	FMReasoningInterface reasoner1, reasoner2;
	FeatureModel featureModelConsistent, featureModelInconsistent;
	
	@Before
	public void setUp() throws Exception {
		// consistent feature model (with dead features)
		featureModelConsistent = new XMLFeatureModel(consistentFeatureModelXMLFile, XMLFeatureModel.USE_VARIABLE_NAME_AS_ID);
		featureModelConsistent.loadModel();
		reasoner1 = createReasoner(featureModelConsistent);
		reasoner1.init();
		
		// inconsistent feature model
		featureModelInconsistent = new XMLFeatureModel(inconsistentFeatureModelXMLFile, XMLFeatureModel.USE_VARIABLE_NAME_AS_ID);
		featureModelInconsistent.loadModel();
		reasoner2 = createReasoner(featureModelInconsistent);
		reasoner2.init();
	}
	
	// Create a concrete reasoner to test
	abstract protected FMReasoningInterface createReasoner(FeatureModel model);
	
	@Test
	public void testIsConsistent() {
		try {
			assertTrue(reasoner1.isConsistent());
			assertFalse(reasoner2.isConsistent());
			// If operation is not supported by reasoner we consider test is passed
		}catch (OperationNotSupportedException e1) {			
		}
		catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testCountSolutions() {
		try {
			assertEquals(36.0, reasoner1.countValidConfigurations());
			// If operation is not supported by reasoner we consider test is passed
		}catch (OperationNotSupportedException e1) {			
		}
		catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testIsDeadFeature() {
		try{
			// dead features
			for( String featureId : dead) {
				assertTrue(reasoner1.isDeadFeature(featureId));
			}
		// If operation is not supported by reasoner we consider test is passed
		}catch (OperationNotSupportedException e1) {			
		}
		catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testIsCoreFeature() {
		try {
			// core features
			for( String featureId : core) {
				assertTrue(reasoner1.isCoreFeature(featureId));
			}
			// If operation is not supported by reasoner we consider test is passed
		}catch (OperationNotSupportedException e1) {			
		}
		catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testIsFreeFeature() {
		try{
			// free features
			for( String featureId : free) {
				assertTrue(reasoner1.isFreeFeature(featureId));
			}
			// If operation is not supported by reasoner we consider test is passed
		}catch (OperationNotSupportedException e1) {			
		}
		catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	

	@Test
	public void testValidDomain() {
		try {
			// core features
			for( String featureId : core ) {
				Boolean d[] = reasoner1.validDomain(featureId);
				assertEquals(1, d.length);
				assertEquals(true, d[0].booleanValue());
			}
			// dead features
			for( String featureId : dead) {
				Boolean d[] = reasoner1.validDomain(featureId);
				assertEquals(1, d.length);
				assertEquals(false, d[0].booleanValue());
			}
			// free features
			for( String featureId : free) {
				Boolean d[] = reasoner1.validDomain(featureId);
				assertEquals(2, d.length);
			}
			// If operation is not supported by reasoner we consider test is passed
		}catch (OperationNotSupportedException e1) {			
		}
		catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testAllValidDomains() {
		try {
			Map<String, Boolean[]> domains = reasoner1.allValidDomains(new HashMap<String, String>());
			// core features
			for( String featureId : core ) {
				Boolean [] d = domains.get(featureId);
				assertEquals(1, d.length);
				assertEquals(true, d[0].booleanValue());
			}
			// dead features
			for( String featureId : dead) {
				Boolean [] d = domains.get(featureId);
				assertEquals(1, d.length);
				assertEquals(false, d[0].booleanValue());
			}
			// free features
			for( String featureId : free) {
				Boolean [] d = domains.get(featureId);
				assertEquals(2, d.length);
			}			
			// If operation is not supported by reasoner we consider test is passed
		}catch (OperationNotSupportedException e1) {			
		}
		catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testAllDeadFeatures() {
		try {
			List<String> features = reasoner1.allDeadFeatures(new HashMap<String, String>());
			assertEquals(dead.length, features.size());
			// dead features
			for( String knownDead : dead) {
				boolean found = false;
				for( String supposelyDead : features ) {
					if ( knownDead.equals(supposelyDead) ) {
						found = true;
						break;
					}
				}
				assertTrue(found);
			}
			// If operation is not supported by reasoner we consider test is passed
		}catch (OperationNotSupportedException e1) {			
		}
		catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testAllCoreFeatures() {
		try {
			List<String> features = reasoner1.allCoreFeatures(new HashMap<String, String>());
			assertEquals(core.length, features.size());
			// dead features
			for( String knownCore : core) {
				boolean found = false;
				for( String supposelyCore : features ) {
					if ( knownCore.equals(supposelyCore) ) {
						found = true;
						break;
					}
				}
				assertTrue(found);
			}
			// If operation is not supported by reasoner we consider test is passed
		}catch (OperationNotSupportedException e1) {			
		}
		catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}	
	
	@Test
	public void testAllFreeFeatures() {
		try {
			List<String> features = reasoner1.allFreeFeatures(new HashMap<String, String>());
			assertEquals(free.length, features.size());
			// dead features
			for( String knownFree : free) {
				boolean found = false;
				for( String supposelyFree: features ) {
					if ( knownFree.equals(supposelyFree) ) {
						found = true;
						break;
					}
				}
				assertTrue(found);
			}
		// If operation is not supported by reasoner we consider test is passed
		}catch (OperationNotSupportedException e1) {			
		}
		catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}		
}
