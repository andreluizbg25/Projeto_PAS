package ExercicioMemento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class TestMemento extends JFrame {
    
    private JButton saveBut, undoBut, redoBut;
    private JTextArea theArticle = new JTextArea(40, 60);

    Caretaker caretaker = new Caretaker();
    Originator originator = new Originator();
    int saveFiles = 0, currentArticle = 0;

    public TestMemento() {

		this.setSize(750, 780);
		this.setTitle("Memento - Design Pattern");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("Article"));
		panel1.add(theArticle);
	
		ButtonListener saveListener = new ButtonListener();
		ButtonListener undoListener = new ButtonListener();
		ButtonListener redoListener = new ButtonListener();
	
		saveBut = new JButton("Save");
		saveBut.addActionListener(saveListener);
	
		undoBut = new JButton("Undo");
		undoBut.addActionListener(undoListener);
	
		redoBut = new JButton("Redo");
		redoBut.addActionListener(redoListener);
		
		//Inicializa os botões "DESFAZER" e "REFAZER" como falso
		undoBut.setEnabled(false);
		redoBut.setEnabled(false);
		
		panel1.add(saveBut);
		panel1.add(undoBut);
		panel1.add(redoBut);
	
		this.add(panel1);
		this.setVisible(true);
    }
    
		
	public static void main (String[] args){
		new TestMemento();
	}
	
    class ButtonListener implements ActionListener {
	
		public void actionPerformed(ActionEvent e) {
			// Botão "SALVAR"
		    if (e.getSource() == saveBut) {
				String textInTextArea = theArticle.getText();
				originator.set(textInTextArea);
				caretaker.addMemento(originator.storeInMemento());
				saveFiles++;
				
				if(saveFiles == 1){}
				else currentArticle++;
		
				System.out.println("Arquivos Salvos: " + saveFiles + "\n---------------------------------------" +"\n\n");
		
				undoBut.setEnabled(true);
		    
		    } else
		    	// Botão "DESFAZER"
			    if (e.getSource() == undoBut) {
					if (currentArticle >= 1) {
					    currentArticle--;
					    originator.restoreFromMemento(caretaker.getMemento(currentArticle));
					    theArticle.setText(originator.getArticle());
					    redoBut.setEnabled(true);
					} else {
					    undoBut.setEnabled(false);
					}
			    } else
			    	// Botão "REFAZER"
				    if (e.getSource() == redoBut) {
						if ((saveFiles - 1) > currentArticle) {
							currentArticle++;
						    originator.restoreFromMemento(caretaker.getMemento(currentArticle));
						    theArticle.setText(originator.getArticle());
						    undoBut.setEnabled(true);
						} else {
						    redoBut.setEnabled(false);
						}
				    }
		}
    }
}