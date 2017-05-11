package testRules;

import abstractTestRules.PositonRule;
import grid.Cell;
import grid.Solution;

public class PositionHautGauche extends PositonRule {

	public PositionHautGauche() {
		setLabel("PositionHautGauche");
	}

	@Override
	public Cell validate() {		
		return getGrille()[0][0];
	}

}
