package testRules;

import abstractTestRules.MinorityRule;
import grid.Cell;
import grid.Solution;

public class MinoriteLigneBas extends MinorityRule{

	

	public MinoriteLigneBas() {
		setLabel("MinoriteLigneBas");
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
