package entity;

import java.util.ArrayList;
import java.util.Random;

public class Sudoku {
	private ArrayList<Matrix> sudoku = new ArrayList<>();

	public Sudoku() {

	}

	public Sudoku(Boolean True) {
		for (int i = 0; i < 9; i++) {
			sudoku.add(new Matrix(true));
		}
	}

	public void create() {
		
		this.randomMatrix(this.sudoku.get(0), 2, 0);
		this.randomMatrix(this.sudoku.get(1), 2, 1);
		this.randomMatrix(this.sudoku.get(2), 2, 2);
		
		this.randomMatrix(this.sudoku.get(3), 5, 0);
		this.randomMatrix(this.sudoku.get(4), 5, 1);
		this.randomMatrix(this.sudoku.get(5), 5, 2);
		
		this.randomMatrix(this.sudoku.get(6), 8, 0);
		this.randomMatrix(this.sudoku.get(7), 8, 1);
		this.randomMatrix(this.sudoku.get(8), 8, 2);

	}

	public Sudoku(Matrix m, Matrix m2, Matrix m3, Matrix m4, Matrix m5, Matrix m6, Matrix m7, Matrix m8, Matrix m9) {
		sudoku.add(m);
		sudoku.add(m2);
		sudoku.add(m3);
		sudoku.add(m4);
		sudoku.add(m5);
		sudoku.add(m6);
		sudoku.add(m7);
		sudoku.add(m8);
		sudoku.add(m9);
	}

	public void randomMatrix(Matrix auxM, Integer intervalLine, Integer intervalColumn) {
		Random random = new Random();

		// three values random to be insert in the matrix
		int value1 = 0;
		int value2 = 0;
		int value3 = 0;

		int column1 = random.nextInt(0, 3);
		int column2 = random.nextInt(0, 3);
		int column3 = random.nextInt(0, 3);
		
		
		do {
			value1 = random.nextInt(1, 9);

		} while (auxM.containsValue(value1) || this.checkInColumn(column1, value1, intervalColumn) || this.checkInLine(0, value1, intervalLine) );
		
		
		auxM.getLine(0).set(column1, value1);

		do {
			value2 = random.nextInt(1, 9);

		} while (auxM.containsValue(value2) || this.checkInColumn(column2, value2, intervalColumn) || this.checkInLine(1, value2, intervalLine));

		auxM.getLine(1).set(column2, value2);

		do {
			value3 = random.nextInt(1, 9);
		} while (auxM.containsValue(value3) || this.checkInColumn(column3, value3, intervalColumn) || this.checkInLine(2, value3, intervalLine));
		auxM.getLine(2).set(column3, value3);
		

	}

	public boolean checkInLine(Integer Line, Integer Value, Integer intervalLine) {
		ArrayList<Matrix> intervals = new ArrayList<>();
	
		intervals.add(sudoku.get(intervalLine-2));
		intervals.add(sudoku.get(intervalLine-1));
		intervals.add(sudoku.get(intervalLine));
		
		for (int i = 0; i < intervals.size(); i++) {
			Matrix matrizatual =  intervals.get(i);
			if(matrizatual.getLine(Line).contains(Value)) {
				return true;
			}			
		}		
		
		return false;
	}

	public boolean checkInColumn(Integer Column, Integer Value, Integer Interval) {
		ArrayList<Matrix> intervals = new ArrayList<>();

		intervals.add(this.sudoku.get(Interval));
		intervals.add(this.sudoku.get(Interval + 3));
		intervals.add(this.sudoku.get(Interval + 6));

		for (int i = 0; i < intervals.size(); i++) {

			if (intervals.get(i).ValueInColumn(Value, Column)) {
				return true;
			}

		}
		return false;
	}
	
	public boolean checkComplete() {
		
		for (int matriz = 0; matriz < sudoku.size(); matriz++) {
			if(sudoku.get(matriz).containsValue(0)) {
				return false;
			}
		}
		
		return true;
	}

	public String toString() {

		StringBuffer sb = new StringBuffer();
		String str;

		sb.append(sudoku.get(0).getLine(0) + "|" + sudoku.get(1).getLine(0) + "|" + sudoku.get(2).getLine(0) + "\n"
				+ sudoku.get(0).getLine(1) + "|" + sudoku.get(1).getLine(1) + "|" + sudoku.get(2).getLine(1) + "\n"
				+ sudoku.get(0).getLine(2) + "|" + sudoku.get(1).getLine(2) + "|" + sudoku.get(2).getLine(2) + "\n"
				+ "---------+---------+---------\n" + sudoku.get(3).getLine(0) + "|" + sudoku.get(4).getLine(0) + "|"
				+ sudoku.get(5).getLine(0) + "\n" + sudoku.get(3).getLine(1) + "|" + sudoku.get(4).getLine(1) + "|"
				+ sudoku.get(5).getLine(1) + "\n" + sudoku.get(3).getLine(2) + "|" + sudoku.get(4).getLine(2) + "|"
				+ sudoku.get(5).getLine(2) + "\n" + "---------+---------+---------\n" + sudoku.get(6).getLine(0) + "|"
				+ sudoku.get(7).getLine(0) + "|" + sudoku.get(8).getLine(0) + "\n" + sudoku.get(6).getLine(1) + "|"
				+ sudoku.get(7).getLine(1) + "|" + sudoku.get(8).getLine(1) + "\n" + sudoku.get(6).getLine(2) + "|"
				+ sudoku.get(7).getLine(2) + "|" + sudoku.get(8).getLine(2) + "\n"

		);

		str = sb.toString();
		return str;

	}

	public ArrayList<Matrix> getSudoku() {
		return sudoku;
	}

	public void setSudoku(ArrayList<Matrix> sudoku) {
		this.sudoku = sudoku;
	}
	

}
