package ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import FacadeMemento.FacadeMemento;
import Memento.Caretaker;
import Memento.Originator;

public class BackListener implements ActionListener {

	FacadeMemento facadeMemento;
	JTextArea textArea;

	public BackListener(JTextArea textArea, FacadeMemento facadeMemento) {
		// TODO Auto-generated constructor stub
		this.textArea = textArea;
		this.facadeMemento = facadeMemento;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		textArea.setText(facadeMemento.backMemento());
	}

}
