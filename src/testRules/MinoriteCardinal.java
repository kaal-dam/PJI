package testRules;

import abstractTestRules.MinorityRule;
import grid.Cell;
import grid.Solution;

public class MinoriteCardinal extends MinorityRule {

	public MinoriteCardinal() {
		setLabel("MinoriteCardinal");
	}

	@Override
	public Cell[] validate() {
		Cell[] res = new Cell[4];
		res[0]=this.getGrille()[1][0];
		res[1]=this.getGrille()[1][2];
		res[2]=this.getGrille()[0][1];
		res[3]=this.getGrille()[2][1];
		return res;
	}

}
