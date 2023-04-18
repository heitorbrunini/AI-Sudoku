package entity;

import java.util.ArrayList;

public class Matrix {

	private ArrayList<ArrayList<Integer>> matrixlist = new ArrayList<>();

	public Matrix() {

	}

	public Matrix(ArrayList<Integer> Line1,ArrayList<Integer> Line2,ArrayList<Integer> Line3 ) {
		this.addline(Line1);
		this.addline(Line2);
		this.addline(Line3);
	}
	
	public Matrix(ArrayList<ArrayList<Integer>> matrixlist) {
		this.matrixlist = matrixlist;
	}
	
	public Matrix(Boolean True) {
		ArrayList<Integer> Line = new ArrayList<>();
		ArrayList<Integer> Line2 = new ArrayList<>();
		ArrayList<Integer> Line3 = new ArrayList<>();

		Line.add(0);
		Line.add(0);
		Line.add(0);
		
		Line2.add(0);
		Line2.add(0);
		Line2.add(0);
		
		Line3.add(0);
		Line3.add(0);
		Line3.add(0);
		
		this.addline(Line);
		this.addline(Line2);
		this.addline(Line3);
	}

	public void addline(ArrayList<Integer> values) {
		if (matrixlist.size() < 3) {
			matrixlist.add(values);
		}
	}

	public ArrayList<Integer> getLine(Integer Index) {
		return matrixlist.get(Index);
	}

	public ArrayList<Integer> getColumn(Integer Index) {

		ArrayList<Integer> column = new ArrayList<>();

		for (int i = 0; i < matrixlist.size(); i++) {
			column.add((Integer) matrixlist.get(i).get(Index));
		}
		return column;
	}

	public Boolean containsValue(Integer Value) {

		for (int i = 0; i < matrixlist.size(); i++) {
			if (matrixlist.get(i).contains(Value)) {
				return true;
			}
		}
		;
		return false;
	}
	
	public Boolean ValueInLine(Integer Value, Integer Line) {
		return this.matrixlist.get(Line).contains(Value);
	}
	
	public Boolean ValueInColumn(Integer value, Integer Column) {
		
		for (int i = 0; i < 3; i++) {
			
			if(this.matrixlist.get(i).get(Column) == value) {
				return true;
			}
			
		}		
		return false;	
	}
	
	

}
