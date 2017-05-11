package rules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import grid.Color;
import grid.Grid;
import grid.Police;
import grid.Shape;

public class Minority implements Rule {
	protected ArrayList<Integer[]> patern;

	
	protected String label;

	public Minority(ArrayList<Integer[]> patern){
		this.patern = patern;
		label = "Minority";
	}

	public Minority(ArrayList<Integer[]> patern, String label){
		this.patern = patern;
		this.label = "Minority(" + label + ")";
	}

	@Override
	public int[] legitValue(Grid grid) {
		/* les solution sont les occurence existente sur le paterne, égalité inclu
		 * */
		int[] possible = new int[]{0,1,2,3,4,5,6,7,8,9};
		int[] ret = possible;
		Map<Integer, Integer> count = new HashMap<Integer,Integer>();
		Integer local;
		int i;
		for (i = 0; i < possible.length; ++i) {
			count.put(possible[i], 0);
		}
		for (i = 0; i < patern.size(); ++i) {
			local = grid.getValue(patern.get(i)[0], patern.get(i)[1]);
			count.put(local, count.get(local)+1);
		}
		int occurence = possible.length*100;
		ArrayList<Integer> sols = new ArrayList<>();
		for (i = 0; i < possible.length; ++i) {
			if (count.get(possible[i]) != 0 && count.get(possible[i]) < occurence) {
				occurence = count.get(possible[i]);
				sols = new ArrayList<>();
				sols.add(possible[i]);
			} else if (count.get(possible[i]) == occurence){
				sols.add(possible[i]);
			}
		}
		ret = new int[sols.size()];
		for (i = 0; i < sols.size(); ++i) {
			ret[i] = sols.get(i);
		}/*/
		System.out.println("--------------------------");
		System.out.println("occurence = " + occurence);
		System.out.print("count = [");
		for (int j = 0; j < count.size(); j++) {
			System.out.print(possible[j]+":"+count.get(possible[j])+", ");	
		}System.out.println("]");
		System.out.println("retSize = " + ret.length);
		System.out.print("retVal = [");
		for (int j = 0; j < sols.size(); j++) {
			System.out.print(sols.get(j)+", ");	
		}System.out.println("]");
		System.out.println("--------------------------");//*/
		return ret;
	}

	@Override
	public Color[] legitColor(Grid grid) {
		Color[] possible = Color.values();
		Color[] ret = possible;
		Map<Color, Integer> count = new HashMap<Color,Integer>();
		Color local;
		int i;
		for (i = 0; i < possible.length; ++i) {
			count.put(possible[i], 0);
		}
		for (i = 0; i < patern.size(); ++i) {
			local = grid.getColor(patern.get(i)[0], patern.get(i)[1]);
			count.put(local, count.get(local)+1);
		}
		int occurence = possible.length*100;
		ArrayList<Color> sols = new ArrayList<>();
		for (i = 0; i < possible.length; ++i) {
			if (count.get(possible[i]) != 0 && count.get(possible[i]) < occurence) {
				occurence = count.get(possible[i]);
				sols = new ArrayList<>();
				sols.add(possible[i]);
			} else if (count.get(possible[i]) == occurence){
				sols.add(possible[i]);
			}
		}
		ret = new Color[sols.size()];
		for (i = 0; i < sols.size(); ++i) {
			ret[i] = sols.get(i);
		}/*/
		System.out.println("--------------------------");
		System.out.println("occurence = " + occurence);
		System.out.print("count = [");
		for (int j = 0; j < count.size(); j++) {
			System.out.print(possible[j]+":"+count.get(possible[j])+", ");	
		}System.out.println("]");
		System.out.println("retSize = " + ret.length);
		System.out.print("retVal = [");
		for (int j = 0; j < sols.size(); j++) {
			System.out.print(sols.get(j)+", ");	
		}System.out.println("]");
		System.out.println("--------------------------");//*/
		return ret;
	}

	@Override
	public Shape[] legitShape(Grid grid) {
		Shape[] possible = Shape.values();
		Shape[] ret = possible;
		Map<Shape, Integer> count = new HashMap<Shape,Integer>();
		Shape local;
		int i;
		for (i = 0; i < possible.length; ++i) {
			count.put(possible[i], 0);
		}
		for (i = 0; i < patern.size(); ++i) {
			local = grid.getShape(patern.get(i)[0], patern.get(i)[1]);
			count.put(local, count.get(local)+1);
		}
		int occurence = possible.length*100;
		ArrayList<Shape> sols = new ArrayList<>();
		for (i = 0; i < possible.length; ++i) {
			if (count.get(possible[i]) != 0 && count.get(possible[i]) < occurence) {
				occurence = count.get(possible[i]);
				sols = new ArrayList<>();
				sols.add(possible[i]);
			} else if (count.get(possible[i]) == occurence){
				sols.add(possible[i]);
			}
		}
		ret = new Shape[sols.size()];
		for (i = 0; i < sols.size(); ++i) {
			ret[i] = sols.get(i);
		}/*
		System.out.println("--------------------------");
		System.out.println("occurence = " + occurence);
		System.out.print("count = [");
		for (int j = 0; j < count.size(); j++) {
			System.out.print(possible[j]+":"+count.get(possible[j])+", ");	
		}System.out.println("]");
		System.out.println("retSize = " + ret.length);
		System.out.print("retVal = [");
		for (int j = 0; j < sols.size(); j++) {
			System.out.print(sols.get(j)+", ");	
		}System.out.println("]");
		System.out.println("--------------------------");//*/
		return ret;
	}

	@Override
	public Police[] legitPolice(Grid grid) {
		Police[] possible = Police.values();
		Police[] ret = possible;
		Map<Police, Integer> count = new HashMap<Police,Integer>();
		Police local;
		int i;
		for (i = 0; i < possible.length; ++i) {
			count.put(possible[i], 0);
		}
		for (i = 0; i < patern.size(); ++i) {
			local = grid.getPolice(patern.get(i)[0], patern.get(i)[1]);
			count.put(local, count.get(local)+1);
		}
		int occurence = possible.length*100;
		ArrayList<Police> sols = new ArrayList<>();
		for (i = 0; i < possible.length; ++i) {
			if (count.get(possible[i]) != 0 && count.get(possible[i]) < occurence) {
				occurence = count.get(possible[i]);
				sols = new ArrayList<>();
				sols.add(possible[i]);
			} else if (count.get(possible[i]) == occurence){
				sols.add(possible[i]);
			}
		}
		ret = new Police[sols.size()];
		for (i = 0; i < sols.size(); ++i) {
			ret[i] = sols.get(i);
		}/*/
		System.out.println("--------------------------");
		System.out.println("occurence = " + occurence);
		System.out.print("count = [");
		for (int j = 0; j < count.size(); j++) {
			System.out.print(possible[j]+":"+count.get(possible[j])+", ");	
		}System.out.println("]");
		System.out.println("retSize = " + ret.length);
		System.out.print("retVal = [");
		for (int j = 0; j < sols.size(); j++) {
			System.out.print(sols.get(j)+", ");	
		}System.out.println("]");
		System.out.println("--------------------------");//*/
		return ret;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return label;
	}

}
