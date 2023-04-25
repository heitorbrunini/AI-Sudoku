package application;

import entity.AgentResol;
import entity.Sudoku;
import entity.backupClasses.Memento;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//marcelo@ifpb.edu.br
		Sudoku sudoku = new Sudoku(true);
		sudoku.create();
		System.out.println("(●'◡'●) - Sudoku kun: SUDOKU GENERATED");
		System.out.println(sudoku.toString());
		
		System.out.println("(⌐■_■) - Skynet: SUDOKU SOLUTION:");	
		AgentResol AgentII = new AgentResol(sudoku);
		
		final Memento backup = AgentII.backup();
		
		//loop, restart not working
		do {
			AgentII.start();
			System.out.println(	AgentII.getSudoku());
			AgentII.setSudoku(backup.getSudoku());
		}while(!AgentII.getSudoku().checkComplete());
		
		System.out.println(AgentII.getSudoku());
		
		}
}