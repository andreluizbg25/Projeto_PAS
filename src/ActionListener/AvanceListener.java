package ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import FacadeMemento.FacadeMemento;
import Memento.Caretaker;
import Memento.Originator;

public class AvanceListener implements ActionListener {

	Originator originator;
	Caretaker caretaker;
	JTextArea textArea;
	 FacadeMemento facadeMemento;
	public AvanceListener(JTextArea textArea, FacadeMemento facadeMemento) {
		this.textArea = textArea;
		this.facadeMemento = facadeMemento;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		textArea.setText(facadeMemento.avanceMemento());
	}

}
