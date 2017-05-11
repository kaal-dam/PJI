package testRules;

import abstractTestRules.PositonRule;
import grid.Cell;
import grid.Solution;

public class PositionCentreCentre extends PositonRule {

	public PositionCentreCentre() {
		setLabel("PositionCentreCentre");
	}

	@Override
	public Cell validate() {
		return getGrille()[1][1];
	}

}
