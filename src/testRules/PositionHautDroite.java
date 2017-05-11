package testRules;

import abstractTestRules.PositonRule;
import grid.Cell;
import grid.Solution;

public class PositionHautDroite extends PositonRule {

	public PositionHautDroite() {
		setLabel("PositionHautDroite");
	}

	@Override
	public Cell validate() {
		return getGrille()[2][0];
	}

}
