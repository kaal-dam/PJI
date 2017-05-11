package testRules;

import abstractTestRules.PositonRule;
import grid.Cell;
import grid.Solution;

public class PositionBasDroite extends PositonRule {

	public PositionBasDroite() {
		setLabel("PositionBasDroite");
	}

	@Override
	public Cell validate() {
		return getGrille()[2][2];
	}

}
