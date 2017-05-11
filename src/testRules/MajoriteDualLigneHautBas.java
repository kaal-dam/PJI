package testRules;

import abstractTestRules.MajorityRule;
import grid.Cell;
import grid.Solution;

public class MajoriteDualLigneHautBas extends MajorityRule{

	

	public MajoriteDualLigneHautBas() {
		setLabel("MajoriteDualLigneHautBas");
	}

	@Override
	public Cell[] validate() {
		Cell[] res = new Cell[6];
		for(int i = 0;i<3;i++){
			res[i]=this.getGrille()[i][2];
			res[i+3]=this.getGrille()[i][0];
		}
		return res;
	}

}
