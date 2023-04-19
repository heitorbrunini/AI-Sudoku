package application;

import entity.AgentResol;
import entity.Sudoku;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Sudoku sudoku = new Sudoku(true);
		sudoku.create();
		System.out.println("(●'◡'●) - Sudoku kun: SUDOKU GENERATED");
		System.out.println(sudoku.toString());
		
		System.out.println("(⌐■_■) - Skynet: SUDOKU SOLUTION:");	
		AgentResol AgentII = new AgentResol(sudoku);
		AgentII.start();
	}
}