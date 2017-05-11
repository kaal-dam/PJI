package testRules;

import abstractTestRules.MajorityRule;
import grid.Cell;
import grid.Solution;

public class MajoriteDualLigneHautCentre extends MajorityRule {

	public MajoriteDualLigneHautCentre() {
		setLabel("MajoriteDualLigneHautCentre");
	}

	@Override
	public Cell[] validate() {
		Cell[] res = new Cell[6];
		for(int i = 0;i<3;i++){
			res[i]=this.getGrille()[i][0];
			res[i+3]=this.getGrille()[i][1];
		}
		return res;
	}

}
