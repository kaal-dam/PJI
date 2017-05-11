package testRules;

import abstractTestRules.MinorityRule;
import grid.Cell;
import grid.Solution;

public class MinoriteColGauche extends MinorityRule {

	public MinoriteColGauche() {
		setLabel("MinoriteColGauche");
	}

	@Override
	public Cell[] validate() {
		Cell[] res = new Cell[3];
		for(int i = 0;i<3;i++){
			res[i]=this.getGrille()[0][i];
		}
		return res;
	}
}
