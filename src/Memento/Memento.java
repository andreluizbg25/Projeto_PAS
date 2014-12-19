package Memento;

public class Memento {
	private String state = new String();

	public Memento(String stateToSave) {
		state = stateToSave;
	}

	public String getSavedState() {
		return state;
	}
}