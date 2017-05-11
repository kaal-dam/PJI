package abstractTestRules;

import java.util.ArrayList;
import java.util.List;

import grid.Cell;
import grid.Color;
import grid.Police;
import grid.Shape;
import grid.Solution;
import plugins.Plugin;

public abstract class MinorityRule extends Plugin {

	Cell[] testRange;
	
	public MinorityRule() {
		
	}

	public abstract Cell[] validate();
	
	@Override
	public void initPlugin(Cell[][] grille, Solution solution) {
		this.setGrille(grille);
		this.setSolution(solution);
		testRange=validate();		
	}

	@Override
	public boolean isPossibleColor() {
		List<Color> colorList = new ArrayList<>();
		int count = 9;
		for(Color col : Color.values()){
			int tmp=0;
			for (Cell cell : testRange) {
				if(cell.get_color()==col){
					tmp++;
				}
			}
			if(tmp==count){
				colorList.add(col);
			}
			else if(tmp<count && tmp > 0){
				colorList.clear();
				colorList.add(col);
				count = tmp;
			}
		}
		if(colorList.contains(getSolution().color)){
			return true;
		}
		return false;
	}

	@Override
	public boolean isPossiblePolice() {
		List<Police> policeList = new ArrayList<>();
		int count = 9;
		for(Police pol : Police.values()){
			int tmp=0;
			for (Cell cell : testRange) {
				if(cell.get_police()==pol){
					tmp++;
				}
			}
			if(tmp==count){
				policeList.add(pol);
			}
			else if(tmp<count && tmp > 0){
				policeList.clear();
				policeList.add(pol);
				count = tmp;
			}
		}
		if(policeList.contains(getSolution().police)){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isPossibleShape() {
		
		List<Shape> shapeList = new ArrayList<>();
		int count = 9;
		for(Shape sha : Shape.values()){
			int tmp=0;
			for (Cell cell : testRange) {
				if(cell.get_shape()==sha){
					tmp++;
				}
			}
			
			if(tmp==count){
				shapeList.add(sha);				
			}
			else if(tmp<count && tmp > 0){
				shapeList.clear();
				shapeList.add(sha);
				count = tmp;
			}
		}
		if(shapeList.contains(getSolution().shape)){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isPossibleValue() {
		List<Integer> valueList = new ArrayList<>();
		int count = 9;
		for(int val=0; val<10;val++){
			int tmp=0;
			for (Cell cell : testRange) {
				if(cell.get_value()==val){
					tmp++;
				}
			}
			if(tmp==count){
				valueList.add(val);
			}
			else if(tmp<count && tmp > 0){
				valueList.clear();
				valueList.add(val);
				count = tmp;
			}
		}
		return valueList.contains(getSolution().value);
	}
}
