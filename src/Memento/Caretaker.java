package Memento;

import java.util.ArrayList;
import FacadeMemento.FacadeMemento;
import Factory.FactoryArrayListMemento;
import Factory.FactoryMemento;

public class Caretaker {
	private ArrayList<Memento> savedStates = new FactoryArrayListMemento()
			.getArrayListMemento();

	public void addMemento(Memento m) {
		savedStates.add(m);
	}

	public Memento getMemento(int index) {
		return savedStates.get(index);

	}


}