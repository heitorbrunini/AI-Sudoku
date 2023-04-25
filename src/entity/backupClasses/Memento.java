package entity.backupClasses;

import entity.Sudoku;

public class Memento {
	private final Sudoku sudoku;
	
	public Memento(Sudoku sudoku){
		this.sudoku= sudoku;
	}
	
	public Sudoku getSudoku() {
		return this.sudoku;
		
	}
}
