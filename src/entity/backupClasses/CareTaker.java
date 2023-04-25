package entity.backupClasses;

import java.util.ArrayList;

public class CareTaker {
	
	private ArrayList<Memento> states = new ArrayList<>();
	
	public Memento getState(int i) {
		return states.get(i);
	}
	
	public void addState(Memento m) {
		states.add(m);
		
	}
	
}
