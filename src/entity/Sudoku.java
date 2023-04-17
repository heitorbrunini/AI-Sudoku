package entity;

import java.util.ArrayList;

public class Sudoku {
	private ArrayList<Matrix> sudoku = new ArrayList<>();

	public Sudoku() {

	}

	public Sudoku(Matrix m,Matrix m2, Matrix m3, Matrix m4,Matrix m5,Matrix m6,Matrix m7,Matrix m8, Matrix m9) {
		
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
	
public Sudoku(Matrix m,Matrix m2, Matrix m3) {
		
		sudoku.add(m);
		sudoku.add(m2);
		sudoku.add(m3);
		
	}
	
	
	
	public String toString() {
		
		String s ="";
		s = s + sudoku.get(0).toString();
		s = s + sudoku.get(1).toString();
		s = s + sudoku.get(2).toString() + "\n";
		/*
		s = s + sudoku.get(3).toString();
		s = s + sudoku.get(4).toString();
		s = s + sudoku.get(5).toString() + "\n";
		
		s = s + sudoku.get(6).toString();
		s = s + sudoku.get(7).toString();
		s = s + sudoku.get(8).toString() + "\n";
		*/
		return s;
		
	}

}
