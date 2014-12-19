package Interface;

import java.util.prefs.BackingStoreException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import ActionListener.AvanceListener;
import ActionListener.BackListener;
import ActionListener.SaveListener;
import FacadeMemento.FacadeMemento;
import Factory.FactoryCaretaker;
import Factory.FactoryFacadeMemento;
import Factory.FactoryOriginator;
import Memento.Caretaker;
import Memento.Originator;

public class Screen {

	private JFrame jFrame;
	private JTextArea textArea;
	private JButton avance;
	private JButton back;
	private JButton save;

	private FacadeMemento facadeMemento;
	private SaveListener saveListener;
	private BackListener backListener;
	private AvanceListener avanceListener;

	public Screen() {
		this.load();
		this.set();
		this.addJFrame();
		this.addListener();
		jFrame.setVisible(true);
			}

	private void load(){
		jFrame = new JFrame();
		textArea = new JTextArea();
		avance = new JButton();
		back = new JButton();
		save = new JButton();
		facadeMemento = new FactoryFacadeMemento().getFacadeMemento();
		backListener = new BackListener(textArea,facadeMemento);
		saveListener = new SaveListener(textArea,facadeMemento);
		avanceListener = new AvanceListener(textArea,facadeMemento);
	}
	
	private void set(){
		jFrame.setTitle("My Editor Screen");
		jFrame.setLayout(null);
		jFrame.setSize(600,500);
		avance.setText(">");
		back.setText("<");
		save.setText("Salvar");
		jFrame.setBounds(250,150,350,440);
		textArea.setBounds(20, 20, 300, 300);
		save.setBounds(20,330, 70,50);
		back.setBounds(100,330, 70,50);
		avance.setBounds(160,330, 70,50);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void addJFrame(){
		jFrame.add(textArea);
		jFrame.add(avance);
		jFrame.add(back);
		jFrame.add(save);
		
	}
	private void addListener(){
		save.addActionListener(saveListener);
		back.addActionListener(backListener);
		avance.addActionListener(avanceListener);
	}
	

	
	
	
}
