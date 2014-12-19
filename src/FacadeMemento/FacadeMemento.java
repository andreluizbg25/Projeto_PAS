package FacadeMemento;

import Factory.FactoryCaretaker;
import Factory.FactoryOriginator;
import Memento.Caretaker;
import Memento.Memento;
import Memento.Originator;

public class FacadeMemento {
	private Caretaker caretaker = null;
	private Originator originator = null;
	private int currentState = 0 ;
	private int lastState = 0;
	
	
	public FacadeMemento(){
		caretaker = new FactoryCaretaker().getCaretaker();
		 originator = new FactoryOriginator().getOriginator();
	}
	
	
	public void executaMemento() {
		 caretaker = new FactoryCaretaker().getCaretaker();
		 originator = new FactoryOriginator().getOriginator();
		saveMemento("Estado0");
		saveMemento("Estado1");
		saveMemento("Estado2");
		saveMemento("Estado3");
		
		System.out.println(backMemento());
		System.out.println(backMemento());
		System.out.println(backMemento());
		System.out.println(backMemento());
		System.out.println(backMemento());
		System.out.println(backMemento());
		System.out.println(avanceMemento());
		System.out.println(avanceMemento());
		System.out.println(backMemento());
		System.out.println(avanceMemento());
		System.out.println(backMemento());
		System.out.println(avanceMemento());
		System.out.println(avanceMemento());
		System.out.println(avanceMemento());
		System.out.println(backMemento());
		System.out.println(avanceMemento());
		System.out.println(avanceMemento());
		System.out.println(backMemento());
		System.out.println(backMemento());
		System.out.println(avanceMemento());
	}
	
	public String backMemento(){
		if(currentState>0){
		currentState--;
		originator.restoreFromMemento(caretaker.getMemento(currentState));
		return originator.getState();
		}
		return "";
	}
	
	
	public String avanceMemento(){
		if((currentState < lastState-1)&& ( currentState != lastState)) {
			originator.restoreFromMemento(caretaker.getMemento(currentState));
			currentState++;
			return originator.getState();
		}	
		originator.restoreFromMemento(caretaker.getMemento(lastState-1));
		return originator.getState(); 
	}
	
	public void saveMemento(String string){
		if(string == null) string = new String("");
		originator.set(string);
		caretaker.addMemento(originator.saveToMemento());
		lastState++;
		currentState = lastState;
		}

}
