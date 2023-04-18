package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AgentResol {
	private Sudoku sudoku;
	private Integer tentativas=0;

	AgentResol() {

	}

	public AgentResol(Sudoku sudoku) {
		this.sudoku = sudoku;
	}

	public Matrix resolveMatrix(Matrix M,Integer IntervalColumn, Integer IntervaLine) {
		Map<String,ArrayList<Integer>> FirstLine = this.resolveLine(M,M.getLine(0), IntervalColumn, IntervaLine);
		System.out.println(FirstLine.toString());
		
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
		

	public Map<String,ArrayList<Integer>> resolveLine(Matrix m, ArrayList<Integer> Linha, Integer IntervalColumn, Integer IntervaLine) {
		ArrayList<Integer> aux2 = new ArrayList<>() ;
		
		// LineColumn and Value
		Map<String,ArrayList<Integer>> MapaSolutions = new HashMap<String, ArrayList<Integer>>();

		//for each number of the line:
		for (int column = 0; column < Linha.size() ; column++) {
			
			if(Linha.get(column) == 0) {
				//try numbers 0 to 9
				for (int i = 1; i < 10; i++) {
					if (!m.containsValue(i) && !sudoku.checkInColumn(column, i, IntervalColumn) && !sudoku.checkInLine(m.IndexOfLine(Linha), i, IntervaLine)) {
						System.out.println("i need to resolve Line " +m.IndexOfLine(Linha)+" Column " + column + " the answer could be:"+ i);
						
						String key = String.valueOf(m.IndexOfLine(Linha)) +  String.valueOf(column);
						
						if(MapaSolutions.containsKey(key)) {
							MapaSolutions.get(key).add(i);
						}else {
							ArrayList<Integer> aux3 = new ArrayList<>();
							aux3.add(i);
							MapaSolutions.put(key,aux3);
						}
						
					}					
				}
				
			}
			
			
			
		}		
		return MapaSolutions;
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
