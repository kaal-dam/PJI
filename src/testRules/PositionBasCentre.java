package testRules;

import abstractTestRules.PositonRule;
import grid.Cell;
import grid.Solution;

public class PositionBasCentre extends PositonRule{

	public PositionBasCentre() {
		setLabel("PositionBasCentre");
	}

	@Override
	public Cell validate() {
		return getGrille()[1][2];
	}

}
