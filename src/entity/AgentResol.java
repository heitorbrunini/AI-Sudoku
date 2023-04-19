package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import entity.backupClasses.CareTaker;
import entity.backupClasses.Memento;

public class AgentResol {
	private Sudoku sudoku;
	private Memento m;
	private CareTaker c = new CareTaker();
	private Integer tentativas = 0;

	AgentResol() {
	}

	public AgentResol(Sudoku sudoku) {
		
		this.sudoku = sudoku;
	}
	
	public void start() {
		resolversudoku();
		System.out.println(sudoku);	
		/*while(!this.sudoku.checkComplete()) {
			
			System.out.println("reset:---------\n");
			this.resolversudoku();
			tentativas++;
			System.out.println(sudoku);
		}*/
		
	}

	public Matrix resolveMatrix(Matrix M,Integer IntervalColumn, Integer IntervaLine) {
		Random random = new Random();
		Map<String,ArrayList<Integer>> FirstLineSolutions = this.resolveLine(M,M.getLine(0), IntervalColumn, IntervaLine);
		
		ArrayList<Integer> valuesToLine = new ArrayList<>();
		
		for (int line = 0; line < 3; line++) {
			
			Map<String,ArrayList<Integer>> LineSolutions = this.resolveLine(M,M.getLine(line), IntervalColumn, IntervaLine);
			
			for (int column = 0; column < 3; column++) {			
				//checks if the column exists in map
				
				if (LineSolutions.containsKey(String.valueOf(line) + String.valueOf(column))) {
					
					//Get the possible numbers to that camp
					valuesToLine = LineSolutions.get(String.valueOf(line)+ String.valueOf(column));
					//check if there possibles numbers to that camp
					if (valuesToLine.size()>1) {
						
						while(true) {
							
							try {
								int SortIndex = random.nextInt(0,valuesToLine.size()-1);
								if (!M.containsValue(valuesToLine.get(SortIndex))) {
									M.getLine(line).set(column, valuesToLine.get(SortIndex) );
									break;
								}
								
								valuesToLine.remove(SortIndex);
							} catch(IllegalArgumentException e) {
								
								if (!M.containsValue(valuesToLine.get(0))) {									
									M.getLine(line).set(column, valuesToLine.get(0));
								}
								
								break;
							}							
							
						}
						
					}else if (valuesToLine.size() ==1) {
						if (!M.containsValue(valuesToLine.get(0))) {
							
							M.getLine(line).set(column, valuesToLine.get(0));
						}
						
					} 
					
				}				
				else {
					
				}				
			}
						
		}
			
		return M;

	}
	
	public void resolversudoku() {
		
		sudoku.getSudoku().set(0, this.resolveMatrix(sudoku.getSudoku().get(0), 0, 2));
		sudoku.getSudoku().set(1, this.resolveMatrix(sudoku.getSudoku().get(1), 1, 2));
		sudoku.getSudoku().set(2,this.resolveMatrix(sudoku.getSudoku().get(2), 2, 2));
		
		sudoku.getSudoku().set(3,this.resolveMatrix(sudoku.getSudoku().get(3), 0, 5));
		sudoku.getSudoku().set(4,this.resolveMatrix(sudoku.getSudoku().get(4), 1, 5));
		sudoku.getSudoku().set(5,this.resolveMatrix(sudoku.getSudoku().get(5), 2, 5));
		
		sudoku.getSudoku().set(6,this.resolveMatrix(sudoku.getSudoku().get(6), 0, 8));
		sudoku.getSudoku().set(7,this.resolveMatrix(sudoku.getSudoku().get(7), 1, 8));
		sudoku.getSudoku().set(8,this.resolveMatrix(sudoku.getSudoku().get(8), 2, 8));
		
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