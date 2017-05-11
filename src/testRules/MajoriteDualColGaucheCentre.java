package testRules;

import abstractTestRules.MajorityRule;
import grid.Cell;
import grid.Solution;

public class MajoriteDualColGaucheCentre extends MajorityRule {

	public MajoriteDualColGaucheCentre() {
		setLabel("MajoriteDualColGaucheCentre");
	}

	@Override
	public Cell[] validate() {
		Cell[] res = new Cell[6];
		for(int i = 0;i<3;i++){
			res[i]=this.getGrille()[1][i];
			res[i+3]=this.getGrille()[0][i];
		}
		return res;
	}

}
