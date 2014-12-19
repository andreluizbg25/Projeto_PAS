package ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import FacadeMemento.FacadeMemento;
import Factory.FactoryMemento;
import Memento.Caretaker;

public class SaveListener implements ActionListener {

	JTextArea textArea;
	FacadeMemento facadeMemento;

	public SaveListener(JTextArea textArea, FacadeMemento facadeMemento) {
		// TODO Auto-generated constructor stub
		this.textArea = textArea;
		this.facadeMemento = facadeMemento;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		facadeMemento.saveMemento(textArea.getText());
	}

}
