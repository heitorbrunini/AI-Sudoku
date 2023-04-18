package entity;

import java.util.ArrayList;

public class AgentResol {
	private Sudoku sudoku;
	private Integer tentativas=0;

	AgentResol() {

	}

	public AgentResol(Sudoku sudoku) {
		this.sudoku = sudoku;
	}

	public Matrix resolveMatrix(Matrix M,Integer IntervalColumn, Integer IntervaLine) {
		
		M.SetLine(0, this.resolveLine(M, M.getLine(0), IntervalColumn, IntervaLine));
		M.SetLine(1, this.resolveLine(M, M.getLine(1), IntervalColumn, IntervaLine));
		M.SetLine(2, this.resolveLine(M, M.getLine(2), IntervalColumn, IntervaLine));
		return M;

	}
	
	public void resolversudoku() {
		
		sudoku.getSudoku().set(0, this.resolveMatrix(sudoku.getSudoku().get(0), 0, 2));
		/*sudoku.getSudoku().set(1, this.resolveMatrix(sudoku.getSudoku().get(1), 1, 2));
		this.resolveMatrix(sudoku.getSudoku().get(2), 2, 2);
		
		this.resolveMatrix(sudoku.getSudoku().get(3), 0, 5);
		this.resolveMatrix(sudoku.getSudoku().get(4), 1, 5);
		this.resolveMatrix(sudoku.getSudoku().get(5), 2, 5);
		
		this.resolveMatrix(sudoku.getSudoku().get(6), 0, 8);
		this.resolveMatrix(sudoku.getSudoku().get(7), 1, 8);
		this.resolveMatrix(sudoku.getSudoku().get(8), 2, 8);
		*/
		
	}
		

	public ArrayList<Integer> resolveLine(Matrix m, ArrayList<Integer> Linha, Integer IntervalColumn, Integer IntervaLine) {
		ArrayList<Integer> aux = new ArrayList<>();

		//for each number of the line:
		for (int column = 0; column < Linha.size() ; column++) {
			
			if(Linha.get(column) == 0) {
				//try numbers 0 to 9
				for (int i = 1; i < 10; i++) {
					if (!m.containsValue(i) && !sudoku.checkInColumn(IntervalColumn, i, IntervaLine) && !sudoku.checkInLine(m.IndexOfLine(Linha), i, IntervaLine)) {
						System.out.println("i need to resolve Line " +m.IndexOfLine(Linha)+" Column " + column + " the answer could be:"+ i);
						
					}
					
				}
				
			}					
			
		}
		
		return Linha;
	}

	public Sudoku getSudoku() {
		return sudoku;
	}

	public void setSudoku(Sudoku sudoku) {
		this.sudoku = sudoku;
	}

	public Integer getTentativas() {
		return tentativas;
	}

	public void setTentativas(Integer tentativas) {
		this.tentativas = tentativas;
	}
	
	

}
