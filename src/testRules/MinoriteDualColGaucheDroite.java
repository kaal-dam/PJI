package testRules;

import abstractTestRules.MinorityRule;
import grid.Cell;
import grid.Solution;

public class MinoriteDualColGaucheDroite extends MinorityRule {

	public MinoriteDualColGaucheDroite() {
		setLabel("MinoriteDualColGaucheDroite");
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
