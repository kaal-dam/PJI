package testRules;

import abstractTestRules.MinorityRule;
import grid.Cell;
import grid.Solution;

public class MinoriteCorner extends MinorityRule {

	public MinoriteCorner() {
		setLabel("MinoriteCorner");
	}

	@Override
	public Cell[] validate() {
		Cell[] res = new Cell[4];
		res[0]=this.getGrille()[0][0];
		res[1]=this.getGrille()[0][2];
		res[2]=this.getGrille()[2][0];
		res[3]=this.getGrille()[2][2];
		return res;
	}
}
