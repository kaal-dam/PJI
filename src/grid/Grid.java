package grid;

import java.util.Random;

import rules.*;

public class Grid {
	protected Cell[][] grid;
	protected Rule colorRule;
	protected Rule shapeRule;
	protected Rule policeRule;
	protected Rule valueRule;
	
	public Solution solution;
	
	
	public Grid(Rule shape, Rule color, Rule value, Rule police){
		/*
		 * pour un set de règles donné,
		 * on choisi au hasard une solution qui devra être vérifier dans la grille
		 * 
		 * */
		grid = new Cell[3][3];
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				grid[x][y] = new Cell();
			}
		}
		colorRule = color;
		shapeRule = shape;
		policeRule = police;
		valueRule = value;
		solution = new Solution();
		followRules();
	}
	
	public void displayRules(){
		System.out.println("rules = " + shapeRule.getLabel() + "," + colorRule.getLabel() + "," + valueRule.getLabel() + "," + policeRule.getLabel());
	}
	
	public void displaySolution(){
		System.out.println("sol = " + solution.shape + ", " +solution.color + ", " + solution.value + ", " + solution.police);
	}
	
	public void regenerate(){
        grid = new Cell[3][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                grid[x][y] = new Cell();
            }
        }
        followRules();
    }
	
	public void displayGrid(){
		String ligne = "";
		for (int j = 0; j < 3; j++) {
			ligne = "";
			for (int i = 0; i < 3; i++) {
				ligne += "[";
				ligne += grid[i][j].get_shape() + ", ";
				ligne += grid[i][j].get_color() + ", ";
				ligne += grid[i][j].get_value() + ", ";
				ligne += grid[i][j].get_police();
				ligne += "] ";
			}
			System.out.println(ligne);
		}
	}
	
	protected void followRules(){
		int random;
		int[] legitValues;
		Shape shape;
		Shape[] legitShapes;
		Police police;
		Police[] legitPolices;
		Color color;
		Color[] legitColors;
		for (int y = 0; y < 3; ++y) {
			for (int x = 0; x < 3; ++x) {
				//check valueRule
				random = (int)(Math.random()*(9));
				grid[x][y].set_value(random);
				//check shapeRule
				random = (int)(Math.random()*(Shape.values().length-1));
				shape = Shape.values()[random];
				grid[x][y].set_shape(shape);
				//check policeRule
				random = (int)(Math.random()*(Police.values().length-1));
				police = Police.values()[random];
				grid[x][y].set_police(police);
				//check colorRule
				random = (int)(Math.random()*(Color.values().length-1));
				color = Color.values()[random];
				grid[x][y].set_color(color);
				grid[x][y].isSet = true;
			}
		}
		//set de la solution
		legitValues = valueRule.legitValue(this);
		random = (int)(legitValues.length-1);
		this.solution.value = legitValues[random];
		legitShapes = shapeRule.legitShape(this);
		random = (int)(legitShapes.length-1);
		this.solution.shape = legitShapes[random];
		legitPolices = policeRule.legitPolice(this);
		random = (int)(legitPolices.length-1);
		this.solution.police = legitPolices[random];
		legitColors = colorRule.legitColor(this);
		random = (int)(legitColors.length-1);
		this.solution.color = legitColors[random];
		
	}
	
	public int getValue(int x,int y){
		return grid[x][y].get_value();
	}
	public Police getPolice(int x, int y){
		return grid[x][y].get_police();
	}
	public Color getColor(int x, int y){
		return grid[x][y].get_color();
	}
	public Shape getShape(int x, int y){
		return grid[x][y].get_shape();
	}
	public boolean getSet(int x, int y){
		return grid[x][y].get_isSet();
	}
	public Cell[][] getGrid() {
		return grid;
	}
}
