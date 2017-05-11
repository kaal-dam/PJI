package plugins;

import grid.Cell;
import grid.Solution;

public abstract class Plugin {
	private Cell[][] grille;
	private Solution solution;
	private String label;
	
	public Plugin() {
		
	}
	
	public abstract void initPlugin(Cell[][] grille, Solution solution);
	
	public abstract boolean isPossibleColor();
	public abstract boolean isPossibleValue();
	public abstract boolean isPossibleShape();
	public abstract boolean isPossiblePolice();
	
	public String getLabel(){
		return label;
	}	
	public void setLabel(String label) {
		this.label = label;
	}
	public Cell[][] getGrille() {
		return grille;
	}
	public void setGrille(Cell[][] grille) {
		this.grille = grille;
	}
	public Solution getSolution() {
		return solution;
	}
	public void setSolution(Solution solution) {
		this.solution = solution;
	}
	
	@Override
	public String toString() {
		return label;
	}
}
