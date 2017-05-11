package testRules;

import abstractTestRules.MinorityRule;
import grid.Cell;
import grid.Solution;

public class MinoriteDualLigneHautBas extends MinorityRule{

	

	public MinoriteDualLigneHautBas() {
		setLabel("MinoriteDualLigneHautBas");
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
