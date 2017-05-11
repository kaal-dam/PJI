package testRules;

import abstractTestRules.MinorityRule;
import grid.Cell;
import grid.Solution;

public class MinoriteGlobal extends MinorityRule {

	public MinoriteGlobal() {
		setLabel("MinoriteGlobal");
	}

	@Override
	public Cell[] validate() {
		Cell[] res = new Cell[9];
		res[0]=this.getGrille()[0][0];
		res[1]=this.getGrille()[0][1];
		res[2]=this.getGrille()[0][2];
		res[3]=this.getGrille()[1][0];
		res[4]=this.getGrille()[1][1];
		res[5]=this.getGrille()[1][2];
		res[6]=this.getGrille()[2][0];
		res[7]=this.getGrille()[2][1];
		res[8]=this.getGrille()[2][2];
		return res;
	}

}
