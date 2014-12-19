package Factory;

import Memento.Caretaker;

public class FactoryCaretaker {

	public Caretaker getCaretaker() {
		return new Caretaker();
	}
}
