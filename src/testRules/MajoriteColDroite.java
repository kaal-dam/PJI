package testRules;

import abstractTestRules.MajorityRule;
import grid.Cell;
import grid.Solution;

public class MajoriteColDroite extends MajorityRule {

	public MajoriteColDroite() {
		setLabel("MajoriteColDroite");
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
