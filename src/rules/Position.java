package rules;

import grid.Color;
import grid.Grid;
import grid.Police;
import grid.Shape;

public class Position implements Rule {
	protected int x;
	protected int y;
	
	protected String label;

	public Position(int x, int y){
		this.x = x;
		this.y = y;
		label = "Position(" + x + "," + y + ")";
	}
	

	@Override
	public int[] legitValue(Grid grid) {
		/*	la solution est la valeur à la position donné
		 * */
		int[] ret;
		ret = new int[]{grid.getValue(x, y)};
		return ret;
	}

	@Override
	public Color[] legitColor(Grid grid) {
		Color[] ret;
		ret = new Color[]{grid.getColor(x, y)};
		return ret;
	}

	@Override
	public Shape[] legitShape(Grid grid) {
		Shape[] ret;
		ret = new Shape[]{grid.getShape(x, y)};
		return ret;
	}

	@Override
	public Police[] legitPolice(Grid grid) {
		Police[] ret;
		ret = new Police[]{grid.getPolice(x, y)};
		return ret;
	}


	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return label;
	}

}
