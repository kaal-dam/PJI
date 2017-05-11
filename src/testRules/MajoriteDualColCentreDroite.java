package testRules;

import abstractTestRules.MajorityRule;
import grid.Cell;
import grid.Solution;

public class MajoriteDualColCentreDroite extends MajorityRule {

	public MajoriteDualColCentreDroite() {
		setLabel("MajoriteDualColCentreDroite");
	}

	@Override
	public Cell[] validate() {
		Cell[] res = new Cell[6];
		for(int i = 0;i<3;i++){
			res[i]=this.getGrille()[1][i];
			res[i+3]=this.getGrille()[2][i];
		}
		return res;
	}

}
