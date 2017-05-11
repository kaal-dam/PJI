package rules;

import grid.Color;
import grid.Grid;
import grid.Police;
import grid.Shape;

public interface Rule {

	int[] legitValue(Grid grid);
	Color[] legitColor(Grid grid);
	Shape[] legitShape(Grid grid);
	Police[] legitPolice(Grid grid);
	
	String getLabel();
	
}
