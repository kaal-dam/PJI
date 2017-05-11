package testRules;

import abstractTestRules.PositonRule;
import grid.Cell;
import grid.Solution;

public class PositionHautCentre extends PositonRule {

	public PositionHautCentre() {
		setLabel("PositionHautCentre");
	}

	@Override
	public Cell validate() {		
		return getGrille()[1][0];
	}

}
