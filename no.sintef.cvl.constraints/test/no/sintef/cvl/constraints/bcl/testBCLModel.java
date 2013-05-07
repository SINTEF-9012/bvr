package no.sintef.cvl.constraints.bcl;

public class testBCLModel {
	
/*	@Test
	public void testJaCoP(){
		Store store = new Store();  // define FD store 
        int size = 4; 
        
        // define finite domain variables 
        JaCoP.core.IntVar[] v = new JaCoP.core.IntVar[size]; 
        for(int i=0; i<size; i++){
            v[i] = new JaCoP.core.IntVar(store, "v"+i, 1, size);
        }
        
        // define constraints 
        store.impose( new XneqY(v[0], v[1]) ); 
        store.impose( new XneqY(v[0], v[2]) ); 
        store.impose( new XneqY(v[1], v[2]) ); 
        store.impose( new XneqY(v[1], v[3]) ); 
        store.impose( new XneqY(v[2], v[3]) ); 
 
        // search for a solution and print results 
        Search<JaCoP.core.IntVar> search = new DepthFirstSearch<JaCoP.core.IntVar>(); 
        SelectChoicePoint<JaCoP.core.IntVar> select = new InputOrderSelect<JaCoP.core.IntVar>(store, v, new IndomainMin<JaCoP.core.IntVar>()); 
        boolean result = search.labeling(store, select); 
 
        // Check result
        assertTrue(result);
        assertTrue(v[0] != v[1]);
        assertTrue(v[0] != v[2]);
        assertTrue(v[1] != v[2]);
        assertTrue(v[1] != v[3]);
        assertTrue(v[2] != v[3]);
	}
	*/
	
/*	@Test
	public void testChoco3(){
		// 1. Create a Solver 
		Solver solver = new Solver("my first problem");
		// 2. Create variables through the variable factory 
		solver.variables.IntVar x = VariableFactory.bounded("X", 0, 5, solver);
		solver.variables.IntVar y = VariableFactory.bounded("Y", 0, 5, solver);
		// 3. Create and post constraints by using constraint factories
		solver.post(IntConstraintFactory.arithm(x, "+", y, "<", 5)); 
		// 4. Define the search strategy
		solver.set(IntStrategyFactory.inputOrder_InDomainMin(new solver.variables.IntVar[10])); 
		// 5. Launch the resolution process
		boolean result = solver.findSolution();
		
		assertTrue(result);
	}*/
	
/*	@Test
	public void testEclipseOCL(){
		boolean valid;
		OCLExpression<EClassifier> query = null;

		try {
		    // create an OCL instance for Ecore
			OCL<?, EClassifier, ?, ?, ?, ?, ?, ?, ?, Constraint, EClass, EObject> ocl;
			ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		    
			// create an OCL helper object
			OCLHelper<EClassifier, ?, ?, Constraint> helper = ocl.createOCLHelper();

			// set the OCL context classifier
			helper.setContext(EXTLibraryPackage.Literals.LIBRARY);

			Constraint invariant = helper.createInvariant("books->forAll(b1, b2 | b1 <> b2 implies b1.title <> b2.title)");
			   
			OCLExpression<EClassifier> query = helper.createQuery(
			    "books->collect(b : Book | b.category)->asSet()");
		    
		    // record success
		    valid = true;
		} catch (ParserException e) {
		    // record failure to parse
		    valid = false;
		    System.err.println(e.getLocalizedMessage());
		}
	}*/

	/*
	@Test
	public void test1() throws Exception {
		// ConstraintChecking/test1.xmi
		CVLModel cm = new CVLModel("TestData/ConstraintChecking/test1.xmi");
		BCLChecker bc = new JaCoPBCLChecker(cm);
		
		// isValid() -> true
		assertTrue(bc.isValid());
		// X1 -> getChildren() -> []
		// X2 -> getChildren() -> []
		
		// X1 -> isValid() -> true
		bc = new JaCoPBCLChecker(cm);
		assertTrue(bc.isValid(cm.getCU().getOwnedVSpecResolution().get(0)));
		
		// X2 -> isValid() -> true
		bc = new JaCoPBCLChecker(cm);
		assertTrue(bc.isValid(cm.getCU().getOwnedVSpecResolution().get(1)));
		
		// X3 -> isValid() -> false
		bc = new JaCoPBCLChecker(cm);
		assertFalse(bc.isValid(cm.getCU().getOwnedVSpecResolution().get(2)));
		
	}
	
	@Test
	public void test2() throws Exception {
		// ConstraintChecking/test2.xmi
		CVLModel cm = new CVLModel("TestData/ConstraintChecking/test2.xmi");
		BCLChecker bc = new JaCoPBCLChecker(cm);
		
		// isValid() -> true
		assertTrue(bc.isValid());
		
		// X1 -> isValid() -> true
		bc = new JaCoPBCLChecker(cm);
		assertTrue(bc.isValid(cm.getCU().getOwnedVSpecResolution().get(0)));
		
		// X2 -> isValid() -> false
		bc = new JaCoPBCLChecker(cm);
		assertFalse(bc.isValid(cm.getCU().getOwnedVSpecResolution().get(1)));
		
		// X3 -> isValid() -> true
		bc = new JaCoPBCLChecker(cm);
		assertTrue(bc.isValid(cm.getCU().getOwnedVSpecResolution().get(2)));
		
		// X4 -> isValid() -> true
		bc = new JaCoPBCLChecker(cm);
		assertTrue(bc.isValid(cm.getCU().getOwnedVSpecResolution().get(3)));
	}
	
	@Test
	public void test3() throws Exception {
		// ConstraintChecking/test3.xmi
		CVLModel cm = new CVLModel("TestData/ConstraintChecking/test3.xmi");
		BCLChecker bc = new JaCoPBCLChecker(cm);
		
		// isValid() -> true
		assertTrue(bc.isValid());
	}
	
	@Test
	public void test4() throws Exception {
		// ConstraintChecking/test4.xmi
		// isValid() -> true
		// All A with B -> B implies C
		// All A with one D and E must have C
	}

	@Test
	public void test5() throws Exception {
		// ConstraintChecking/test5.xmi
		// A.a, B.b, C.c + "A.a > B.b and B.b > C.c and C.c > A.a"
		CVLModel cm = new CVLModel("TestData/ConstraintChecking/test5.xmi");
		BCLChecker bc = new JaCoPBCLChecker(cm);
		
		// isValid() -> false
		assertFalse(bc.isValid());
	}

	@Test
	public void test6() throws Exception {
		// ConstraintChecking/test6.xmi
		// isValid() -> false
		// A.a, B.b, C.c + "A.a > B.b and B.b > C.c and C.c < A.a"
	}

*/
}
