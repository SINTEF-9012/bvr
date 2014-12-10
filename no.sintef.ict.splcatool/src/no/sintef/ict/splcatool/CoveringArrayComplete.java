package no.sintef.ict.splcatool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.sat4j.core.VecInt;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IVecInt;
import org.sat4j.specs.TimeoutException;

import splar.core.constraints.BooleanVariableInterface;

public class CoveringArrayComplete extends CoveringArray {
	
	private List<List<Integer>> result;
	private CNF cnf;

	public CoveringArrayComplete(CNF cnf) {
		this.cnf = cnf;
		
		idnr = new HashMap<>();
		nrid = new HashMap<>();
	}

	@Override
	public void generate(){
		result = new ArrayList<List<Integer>>();
		
		Set<BooleanVariableInterface> vs = cnf.getVariables();
		
		SAT4JSolver satSolver = null;
		try {
			satSolver = cnf.getSAT4JSolver();
		} catch (ContradictionException e) {
		}
		
		int v = vs.size();
		
		int n = 0;
		for(BooleanVariableInterface av : vs){
			n++;
			idnr.put(av.getID(), n);
			nrid.put(n, av.getID());
		}
		
		int total = 1 << v;
		int c = 0;
		for(int i = 0; i < total; i++){
			int [] clause = new int [v];
			
			for(int j = 0; j < v; j++){
				clause[j] = j+1;
				if(((i >> j) & 1) == 0)
					clause[j] = -clause[j];
			}
			
			IVecInt assumps = new VecInt(clause);
			
			try {
				if(satSolver.solver.isSatisfiable(assumps)){
					//satSolver.solver.model();
					c++;
					System.out.println("Generating - Progress: " + (i*100/total) + "% - Solutions: " + c);
					
					List<Integer> solution = new ArrayList<Integer>();
					int[] s = satSolver.solver.model();
					for(int z : s)
						solution.add(z);
					
					result.add(solution);
					
					//System.out.println(solution);
				}
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void generate(int i, Integer sizelimit){
		throw new UnsupportedOperationException();
	}

	@Override
	public Integer[] getRow(int n) {
		
		List<Integer> nl = result.get(n);
		Integer[] res = new Integer[nl.size()];
		
/*		if(nl.size() != nrs.size()){
			System.out.println("Incompatible sizes: " + nl.size() + " and " + nrs.size());
			System.exit(-1);
		}
*/		
		for(int i = 0; i < cnf.getVariables().size(); i++){
			int x = i + 1;
			for(int j = 0; j < nl.size(); j++){
				if(Math.abs(nl.get(j)) == x)
					res[i] = nl.get(j)<0?1:0;
			}
		}

		return res;
	}

	@Override
	public int getRowCount() {
		return result.size();
	}

	@Override
	public void setTimeout(int timeout) {
		throw new UnsupportedOperationException();
	}

	@Override
	public double estimateGenerationTime() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getAlgorithmName() {
		return "All";
	}

	@Override
	public long getCoverage() {
		return 100;
	}

}
