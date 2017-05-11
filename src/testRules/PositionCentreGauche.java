package testRules;

import abstractTestRules.PositonRule;
import grid.Cell;
import grid.Solution;

public class PositionCentreGauche extends PositonRule {

	public PositionCentreGauche() {
		setLabel("PositionCentreGauche");
	}

	@Override
	public Cell validate() {
		return getGrille()[0][1];
	}

}
