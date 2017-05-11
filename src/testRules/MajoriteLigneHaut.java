package testRules;

import abstractTestRules.MajorityRule;
import grid.Cell;
import grid.Solution;

public class MajoriteLigneHaut extends MajorityRule {

	public MajoriteLigneHaut() {
		setLabel("MajoriteLigneHaut");
	}

	@Override
	public Cell[] validate() {
		Cell[] res = new Cell[3];
		for(int i = 0;i<3;i++){
			res[i]=this.getGrille()[i][0];
		}
		return res;
	}

}
