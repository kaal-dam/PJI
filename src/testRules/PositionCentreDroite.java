package testRules;

import abstractTestRules.PositonRule;
import grid.Cell;
import grid.Solution;

public class PositionCentreDroite extends PositonRule {

	public PositionCentreDroite() {
		setLabel("PositionCentreDroite");
	}

	@Override
	public Cell validate() {
		return getGrille()[2][1];
	}

}
