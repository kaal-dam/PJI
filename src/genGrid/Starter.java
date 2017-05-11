package genGrid;

import java.util.ArrayList;

import grid.Grid;
import rules.*;

public class Starter {

	public static void main(String[] args) {
		ArrayList<Rule> rules = genRules();
		int ruleShape,ruleColor,ruleValue,rulePolice;//indice à passé pour chacune des règle voulut
		int majority,minority/*,ignore*/, position;//position d'indice de départ des déifférente règles dans le tableau rules
		//ignore= 0;// à donner sans rien de plus
		position = 1-1;// à donner + le numéro de colonne + 3*le numéro de la ligne voulut
		majority = position+9;// à donner + l'indice du patern souhaité (voir dans la fonction genRules)
		minority = majority+15;// à donner + l'indice du patern souhaité
		
		ruleShape = minority+1;
		ruleColor = position+2+(2*3);
		ruleValue = majority+10;
		rulePolice = position+4;
		
		Grid testGrid = new Grid(rules.get(ruleShape), rules.get(ruleColor), rules.get(ruleValue), rules.get(rulePolice));
		testGrid.displayRules();
		testGrid.displaySolution();
		testGrid.displayGrid();
		
		testGrid.regenerate();
		System.out.println();
		testGrid.displaySolution();
		testGrid.displayGrid();
		
		testGrid.regenerate();
		System.out.println();
		testGrid.displaySolution();
		testGrid.displayGrid();
		
	}
	
	public static ArrayList<Rule> genRules(){
		ArrayList<Rule> rules = new ArrayList<Rule>();
		//rules.add(new Ignore());//------------------------add Ignore Rule x1---------------------------
		ArrayList<Integer[]> paternGlobal = new ArrayList<Integer[]>();//0 // indice du patern pour sélection
		ArrayList<Integer[]> paternCorner = new ArrayList<Integer[]>();//1
		ArrayList<Integer[]> paternCardinal = new ArrayList<Integer[]>();//2
		ArrayList<Integer[]> paternLftColumn = new ArrayList<Integer[]>();//3
		ArrayList<Integer[]> paternMidColumn = new ArrayList<Integer[]>();//4
		ArrayList<Integer[]> paternRhtColumn = new ArrayList<Integer[]>();//5
		ArrayList<Integer[]> patern2LftColumns = new ArrayList<Integer[]>();//6
		ArrayList<Integer[]> patern2XtrColumns = new ArrayList<Integer[]>();//7
		ArrayList<Integer[]> patern2RhtColumns = new ArrayList<Integer[]>();//8
		ArrayList<Integer[]> paternTopLine = new ArrayList<Integer[]>();//9
		ArrayList<Integer[]> paternMidLine = new ArrayList<Integer[]>();//10
		ArrayList<Integer[]> paternBotLine = new ArrayList<Integer[]>();//11
		ArrayList<Integer[]> patern2TopLines = new ArrayList<Integer[]>();//12
		ArrayList<Integer[]> patern2XtrLines = new ArrayList<Integer[]>();//13
		ArrayList<Integer[]> patern2BotLines = new ArrayList<Integer[]>();//14
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				rules.add(new Position(x,y));
				paternGlobal.add(new Integer[]{x,y});//------------------------add all Position Rules x9---------------------------
				if (x == 0) {
					paternLftColumn.add(new Integer[]{x,y});
					patern2LftColumns.add(new Integer[]{x,y});
					patern2XtrColumns.add(new Integer[]{x,y});
					if(y == 0){
						patern2TopLines.add(new Integer[]{x,y});
						paternTopLine.add(new Integer[]{x,y});
						paternCorner.add(new Integer[]{x,y});
						patern2XtrLines.add(new Integer[]{x,y});
					}else if(y ==1){
						patern2BotLines.add(new Integer[]{x,y});
						patern2TopLines.add(new Integer[]{x,y});
						paternMidLine.add(new Integer[]{x,y});
						paternCardinal.add(new Integer[]{x,y});
					}else{
						patern2BotLines.add(new Integer[]{x,y});
						patern2XtrLines.add(new Integer[]{x,y});
						paternBotLine.add(new Integer[]{x,y});
						paternCorner.add(new Integer[]{x,y});
					}
				} else if(x == 1){
					paternMidColumn.add(new Integer[]{x,y});
					patern2LftColumns.add(new Integer[]{x,y});
					patern2RhtColumns.add(new Integer[]{x,y});
					if(y == 0){
						patern2XtrLines.add(new Integer[]{x,y});
						patern2TopLines.add(new Integer[]{x,y});
						paternTopLine.add(new Integer[]{x,y});
						paternCardinal.add(new Integer[]{x,y});
					}else if(y ==1){
						patern2BotLines.add(new Integer[]{x,y});
						patern2TopLines.add(new Integer[]{x,y});
						paternMidLine.add(new Integer[]{x,y});
					}else{
						patern2BotLines.add(new Integer[]{x,y});
						patern2XtrLines.add(new Integer[]{x,y});
						paternBotLine.add(new Integer[]{x,y});
						paternCardinal.add(new Integer[]{x,y});
					}
				} else {
					paternRhtColumn.add(new Integer[]{x,y});
					patern2XtrColumns.add(new Integer[]{x,y});
					patern2RhtColumns.add(new Integer[]{x,y});
					if(y == 0){
						patern2XtrLines.add(new Integer[]{x,y});
						patern2TopLines.add(new Integer[]{x,y});
						paternTopLine.add(new Integer[]{x,y});
						paternCorner.add(new Integer[]{x,y});
					}else if(y ==1){
						patern2BotLines.add(new Integer[]{x,y});
						patern2TopLines.add(new Integer[]{x,y});
						paternMidLine.add(new Integer[]{x,y});
						paternCardinal.add(new Integer[]{x,y});
					}else{
						patern2BotLines.add(new Integer[]{x,y});
						patern2XtrLines.add(new Integer[]{x,y});
						paternBotLine.add(new Integer[]{x,y});
						paternCorner.add(new Integer[]{x,y});
					}
				}
			}
		}
		rules.add(new Majority(paternGlobal,"Global"));//------------------------add all Majority Rules x15---------------------------
		rules.add(new Majority(paternCorner,"Corner"));
		rules.add(new Majority(paternCardinal,"Cardinal"));
		rules.add(new Majority(paternLftColumn,"LftColumn"));
		rules.add(new Majority(paternMidColumn,"MidColumn"));
		rules.add(new Majority(paternRhtColumn,"RhtColumn"));
		rules.add(new Majority(patern2LftColumns,"2LftColumns"));
		rules.add(new Majority(patern2XtrColumns,"2XtrColumns"));
		rules.add(new Majority(patern2RhtColumns,"2RhtColumns"));
		rules.add(new Majority(paternTopLine,"TopLine"));
		rules.add(new Majority(paternMidLine,"MidLine"));
		rules.add(new Majority(paternBotLine,"BotLine"));
		rules.add(new Majority(patern2TopLines,"2TopLines"));
		rules.add(new Majority(patern2XtrLines,"2XtrLines"));
		rules.add(new Majority(patern2BotLines,"2BotLines"));
		
		rules.add(new Minority(paternGlobal,"Global"));//------------------------add all Minority Rules x15---------------------------
		rules.add(new Minority(paternCorner,"Corner"));
		rules.add(new Minority(paternCardinal,"Cardinal"));
		rules.add(new Minority(paternLftColumn,"LftColumn"));
		rules.add(new Minority(paternMidColumn,"MidColumn"));
		rules.add(new Minority(paternRhtColumn,"RhtColumn"));
		rules.add(new Minority(patern2LftColumns,"2LftColumns"));
		rules.add(new Minority(patern2XtrColumns,"2XtrColumns"));
		rules.add(new Minority(patern2RhtColumns,"2RhtColumns"));
		rules.add(new Minority(paternTopLine,"TopLine"));
		rules.add(new Minority(paternMidLine,"MidLine"));
		rules.add(new Minority(paternBotLine,"BotLine"));
		rules.add(new Minority(patern2TopLines,"2TopLines"));
		rules.add(new Minority(patern2XtrLines,"2XtrLines"));
		rules.add(new Minority(patern2BotLines,"2BotLines"));
		return rules;
	}

}
