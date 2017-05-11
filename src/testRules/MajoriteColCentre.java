package testRules;

import abstractTestRules.MajorityRule;
import grid.Cell;
import grid.Solution;

public class MajoriteColCentre extends MajorityRule {

	public MajoriteColCentre() {
		setLabel("MajoriteColCentre");
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
