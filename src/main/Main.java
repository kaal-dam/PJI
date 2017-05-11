package main;

import java.util.ArrayList;
import java.util.Random;

import genGrid.Starter;
import genHacker.Hacker;
import grid.Grid;
import rules.Rule;

public class Main {

	public Main() {
		
	}
	
	public Grid genGrille(){
		ArrayList<Rule> rules = Starter.genRules();
		int ruleShape,ruleColor,ruleValue,rulePolice;//indice à passé pour chacune des règle voulut
		Random r = new Random();
		ruleShape =r.nextInt(rules.size());
		ruleColor =r.nextInt(rules.size());
		ruleValue =r.nextInt(rules.size());
		rulePolice =r.nextInt(rules.size());
		System.out.println(rules.get(ruleShape)+""+ rules.get(ruleColor)+""+ rules.get(ruleValue)+""+ rules.get(rulePolice));
		return new Grid(rules.get(ruleShape), rules.get(ruleColor), rules.get(ruleValue), rules.get(rulePolice));
	}
	
	public void run(){
		Grid g = genGrille();
		Hacker a = new Hacker();
		a.initialize(g);
		a.hack();
		int turn = 0;
		boolean resIn3 = false;
		boolean resIn2 = false;
		while(turn < 200){
			if(a.countRules()==0){
				System.err.println("error : no rule find for one part");
				g.displaySolution();
				g.displayRules();
				g.displayGrid();
				a.getSolution();
				break;
			}
			else if(a.countRules()==3 && !resIn3){
				resIn3=true;
				System.err.println("seulement 3 solutions restantes apres "+turn+" ensembles grille/solution");
				g.displaySolution();
				g.displayRules();
				g.displayGrid();
				a.getSolution();
			}
			else if(a.countRules()==2 && !resIn2){
				resIn2=true;
				System.err.println("seulement 2 solutions restantes apres "+turn+" ensembles grille/solution");
				g.displaySolution();
				g.displayRules();
				g.displayGrid();
				a.getSolution();
			}
			else if(a.countRules()==1){
				System.err.println("seulement 1 solution restante apres "+turn+" ensembles grille/solution");
				g.displaySolution();
				g.displayRules();
				g.displayGrid();
				a.getSolution();
				break;
			}
			g.regenerate();
			a.initialize(g);
			a.hack();
			turn ++;
		}				
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

}
