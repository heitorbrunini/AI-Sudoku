package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AgentResol {
	private Sudoku sudoku;
	private Integer tentativas=0;

	AgentResol() {

	}

	public AgentResol(Sudoku sudoku) {
		this.sudoku = sudoku;
	}

	public Matrix resolveMatrix(Matrix M,Integer IntervalColumn, Integer IntervaLine) {
		Random random = new Random();
		Map<String,ArrayList<Integer>> FirstLineSolutions = this.resolveLine(M,M.getLine(0), IntervalColumn, IntervaLine);
		
		ArrayList<Integer> valuesToLine = new ArrayList<>();
		
		for (int column = 0; column < 3; column++) {			
			//checks if the column exists in map
			if (FirstLineSolutions.containsKey("0"+ String.valueOf(column))) {
				
				//Get the possible numbers to that camp
				valuesToLine = FirstLineSolutions.get("0"+ String.valueOf(column));

				System.out.println(valuesToLine.size());
				//check if there possibles numbers to that camp
				if (valuesToLine.size()>1) {
					
					while(true) {
						int SortIndex = random.nextInt(0,valuesToLine.size()-1);
						
						if (!M.containsValue(valuesToLine.get(SortIndex))) {
							M.getLine(0).set(column, valuesToLine.get(SortIndex) );
							break;
						}
					}
					
				}else if (valuesToLine.size() ==1) {
					M.getLine(0).set(column, valuesToLine.get(0));
				} 
				
			}						
		}
		System.out.println(FirstLineSolutions.toString());
				
		Map<String,ArrayList<Integer>> SecondLineSolutions = this.resolveLine(M,M.getLine(1), IntervalColumn, IntervaLine);
		
		for (int column = 0; column < 3; column++) {			
			//checks if the column exists in map
			if (SecondLineSolutions.containsKey("1"+ String.valueOf(column))) {
				
				//Get the possible numbers to that camp
				valuesToLine = SecondLineSolutions.get("1"+ String.valueOf(column));

				System.out.println(valuesToLine.size());
				//check if there possibles numbers to that camp
				if (valuesToLine.size()>1) {
					
					while(true) {
						int SortIndex = random.nextInt(0,valuesToLine.size()-1);
						
						if (!M.containsValue(valuesToLine.get(SortIndex))) {
							M.getLine(1).set(column, valuesToLine.get(SortIndex) );
							break;
						}
					}
					
				}else if (valuesToLine.size() ==1) {
					M.getLine(1).set(column, valuesToLine.get(0));
				} 
				
			}						
		}
		Map<String,ArrayList<Integer>> ThirdineSolutions = this.resolveLine(M,M.getLine(2), IntervalColumn, IntervaLine);
	
		
		System.out.println(SecondLineSolutions);
		
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
