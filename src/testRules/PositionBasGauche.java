package testRules;

import abstractTestRules.PositonRule;
import grid.Cell;
import grid.Solution;

public class PositionBasGauche extends PositonRule {

	public PositionBasGauche() {
		setLabel("PositionBasGauche");
	}

	@Override
	public Cell validate() {
		return getGrille()[0][2];
	}

}
