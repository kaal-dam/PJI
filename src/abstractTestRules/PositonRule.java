package abstractTestRules;

import grid.Cell;
import grid.Solution;
import plugins.Plugin;

public abstract class PositonRule extends Plugin {

	Cell testCell;
	
	public PositonRule() {
		
	}
	
	public abstract Cell validate();
	
	@Override
	public void initPlugin(Cell[][] grille, Solution solution) {
		this.setGrille(grille);
		this.setSolution(solution);
		testCell=validate();		
	}
	
	@Override
	public boolean isPossibleColor() {
		if (testCell.get_color()==getSolution().color)
			return true;
		return false;
	}

	@Override
	public boolean isPossiblePolice() {
		if (testCell.get_police()==getSolution().police)
			return true;
		return false;
	}
	
	@Override
	public boolean isPossibleShape() {
		if (testCell.get_shape()==getSolution().shape)
			return true;
		return false;
	}
	
	@Override
	public boolean isPossibleValue() {
		if (testCell.get_value()==getSolution().value)
			return true;
		return false;
	}
}
