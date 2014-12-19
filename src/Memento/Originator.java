package Memento;

import Factory.FactoryMemento;

public class Originator {
	private String state;

	public void set(String state) {
		System.out.println("Originator: Setando o estado: " + state);
		this.state = state;
	}

	public Memento saveToMemento() {
		System.out.println("Originator: Salvando no Memento.");
		return new FactoryMemento().getMemento(state);
	}

	public void restoreFromMemento(Memento m) {
		state = m.getSavedState();
		System.out.println("Originator: Estado após restauração: "
				+ state);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}