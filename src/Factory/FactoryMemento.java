package Factory;

import Memento.Memento;

public class FactoryMemento {

	
		public Memento getMemento(String stateToSave){
			return new Memento(stateToSave);
		}
}
