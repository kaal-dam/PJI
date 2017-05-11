package testRules;

import abstractTestRules.MinorityRule;
import grid.Cell;
import grid.Solution;

public class MinoriteColDroite extends MinorityRule {

	public MinoriteColDroite() {
		setLabel("MinoriteColDroite");
	}

	@Override
	public Cell[] validate() {
		Cell[] res = new Cell[3];
		for(int i = 0;i<3;i++){
			res[i]=this.getGrille()[2][i];
		}
		return res;
	}

}
