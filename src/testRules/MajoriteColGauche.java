package testRules;

import abstractTestRules.MajorityRule;
import grid.Cell;
import grid.Solution;

public class MajoriteColGauche extends MajorityRule {

	public MajoriteColGauche() {
		setLabel("MajoriteColGauche");
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
