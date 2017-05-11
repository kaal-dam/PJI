package rules;

import grid.Color;
import grid.Grid;
import grid.Police;
import grid.Shape;

public class Ignore implements Rule {

	
	protected String label;

	public Ignore(){
		label = "Ignore";
	}
	@Override
	public int[] legitValue(Grid grid) {
		/*	tout est solution solution
		 * */
		int[] ret = {0,1,2,3,4,5,6,7,8,9};
		return ret;
	}

	@Override
	public Color[] legitColor(Grid grid) {
		return Color.values();
	}

	@Override
	public Shape[] legitShape(Grid grid) {
		return Shape.values();
	}

	@Override
	public Police[] legitPolice(Grid grid) {
		
		return Police.values();
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return label;
	}

}
