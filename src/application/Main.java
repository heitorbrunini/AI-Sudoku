package application;

import java.util.ArrayList;

import entity.Matrix;
import entity.Sudoku;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		
		ArrayList<Integer> Line = new ArrayList<>();
		ArrayList<Integer> Line2 = new ArrayList<>();
		ArrayList<Integer> Line3 = new ArrayList<>();		
		
		ArrayList<Integer> Line4 = new ArrayList<>();
		ArrayList<Integer> Line5 = new ArrayList<>();
		ArrayList<Integer> Line6 = new ArrayList<>();
		
		ArrayList<Integer> Line7 = new ArrayList<>();
		ArrayList<Integer> Line8 = new ArrayList<>();
		ArrayList<Integer> Line9 = new ArrayList<>();
		
		ArrayList<Integer> Line10 = new ArrayList<>();
		ArrayList<Integer> Line11 = new ArrayList<>();
		ArrayList<Integer> Line12 = new ArrayList<>();
		
		ArrayList<Integer> Line13 = new ArrayList<>();
		ArrayList<Integer> Line14 = new ArrayList<>();
		ArrayList<Integer> Line15 = new ArrayList<>();
		
		ArrayList<Integer> Line16 = new ArrayList<>();
		ArrayList<Integer> Line17 = new ArrayList<>();
		ArrayList<Integer> Line18 = new ArrayList<>();
		
		ArrayList<Integer> Line19 = new ArrayList<>();
		ArrayList<Integer> Line20 = new ArrayList<>();
		ArrayList<Integer> Line21 = new ArrayList<>();
		
		ArrayList<Integer> Line22 = new ArrayList<>();
		ArrayList<Integer> Line23 = new ArrayList<>();
		ArrayList<Integer> Line24 = new ArrayList<>();
		
		ArrayList<Integer> Line25 = new ArrayList<>();
		ArrayList<Integer> Line26 = new ArrayList<>();
		ArrayList<Integer> Line27 = new ArrayList<>();
		
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

		Line4.add( 1);
		Line4.add( 0);
		Line4.add( 2);

		Line5.add( 0);
		Line5.add( 5);
		Line5.add( 0);

		Line6.add(4);
		Line6.add( 0);
		Line6.add( 3);
		
		Matrix matrix2 = new Matrix(Line4, Line5, Line6);
		
		Line7.add( 0);
		Line7.add( 5);
		Line7.add( 8);

		Line8.add( 0);
		Line8.add(0);
		Line8.add(4);

		Line9.add(1);
		Line9.add( 0);
		Line9.add(0);
		
		Matrix matrix3 = new Matrix(Line7, Line8, Line9);
		
		Line10.add(0);
		Line10.add( 0);
		Line10.add( 0);

		Line11.add(0);
		Line11.add(0);
		Line11.add( 0);

		Line12.add(0);
		Line12.add( 0);
		Line12.add( 0);
		
		
		*/
		Sudoku sudoku = new Sudoku(true);
		System.out.println(sudoku.toString());
		sudoku.create();
		System.out.println("SUDOKU GENERATED:");
		System.out.println(sudoku.toString());
		}
}