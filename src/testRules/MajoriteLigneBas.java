package testRules;

import abstractTestRules.MajorityRule;
import grid.Cell;
import grid.Solution;

public class MajoriteLigneBas extends MajorityRule{

	

	public MajoriteLigneBas() {
		setLabel("MajoriteLigneBas");
	}

	@Override
	public Cell[] validate() {
		Cell[] res = new Cell[3];
		for(int i = 0;i<3;i++){
			res[i]=this.getGrille()[i][2];
		}
		return res;
	}

}
