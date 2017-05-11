package testRules;

import abstractTestRules.MinorityRule;
import grid.Cell;
import grid.Solution;

public class MinoriteColCentre extends MinorityRule {

	public MinoriteColCentre() {
		setLabel("MinoriteColCentre");
	}

	@Override
	public Cell[] validate() {
		Cell[] res = new Cell[3];
		for(int i = 0;i<3;i++){
			res[i]=this.getGrille()[1][i];
		}
		return res;
	}

}
