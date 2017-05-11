package testRules;

import abstractTestRules.MajorityRule;
import grid.Cell;
import grid.Solution;

public class MajoriteLigneCentre extends MajorityRule {

	public MajoriteLigneCentre() {
		setLabel("MajoriteLigneCentre");
	}

	@Override
	public Cell[] validate() {
		Cell[] res = new Cell[3];
		for(int i = 0;i<3;i++){
			res[i]=this.getGrille()[i][1];
		}
		return res;
	}

}
