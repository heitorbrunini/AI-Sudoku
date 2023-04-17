package application;

import java.util.ArrayList;

import entity.Matrix;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Matrix> Sudoku = new ArrayList<>();
		
		ArrayList<Integer> Line = new ArrayList<>();
		ArrayList<Integer> Line2 = new ArrayList<>();
		ArrayList<Integer> Line3 = new ArrayList<>();
		
		Line.add(9);
		Line.add(4);
		Line.add(0);
		
		Line2.add(6);
		Line2.add(0);
		Line2.add(0);
		
		Line3.add(0);
		Line3.add(0);
		Line3.add(2);
		
		Matrix matrix1 = new Matrix(Line, Line2, Line3);

		Line.set(0, 1);
		Line.set(1, 0);
		Line.set(2, 2);

		Line2.set(0, 0);
		Line2.set(1, 5);
		Line2.set(2, 0);

		Line3.set(0, 4);
		Line3.set(1, 0);
		Line3.set(2, 3);
		
		Matrix matrix2 = new Matrix(Line, Line2, Line3);
		
		Line.set(0, 0);
		Line.set(1, 5);
		Line.set(2, 8);

		Line2.set(0, 0);
		Line2.set(1, 0);
		Line2.set(2, 4);

		Line3.set(0, 1);
		Line3.set(1, 0);
		Line3.set(2, 0);
		
		Matrix matrix3 = new Matrix(Line, Line2, Line3);
		
		Line.set(0, 0);
		Line.set(1, 0);
		Line.set(2, 0);

		Line2.set(0, 0);
		Line2.set(1, 0);
		Line2.set(2, 0);

		Line3.set(0, 0);
		Line3.set(1, 0);
		Line3.set(2, 0);
		
		Sudoku.add(matrix1);
		Sudoku.add(matrix2);
		Sudoku.add(matrix3);
		
		System.out.println(Sudoku.toString());		
		
	}

}
