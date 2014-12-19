package Test;

import FacadeMemento.FacadeMemento;
import Factory.FactoryFacadeMemento;

public class TestMemento {

	public static void main(String args[]) {
		
		FacadeMemento facadeMemento = new FactoryFacadeMemento().getFacadeMemento();
		facadeMemento.executaMemento();
	}

}
