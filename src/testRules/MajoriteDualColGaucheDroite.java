package testRules;

import abstractTestRules.MajorityRule;
import grid.Cell;
import grid.Solution;

public class MajoriteDualColGaucheDroite extends MajorityRule {

	public MajoriteDualColGaucheDroite() {
		setLabel("MajoriteDualColGaucheDroite");
	}

	@Override
	public Cell[] validate() {
		Cell[] res = new Cell[6];
		for(int i = 0;i<3;i++){
			res[i]=this.getGrille()[2][i];
			res[i+3]=this.getGrille()[0][i];
		}
		return res;
	}

}
