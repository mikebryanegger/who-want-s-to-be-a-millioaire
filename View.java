package projekt;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View {

	JFrame frame;
	JPanel panel;
	JLabel question;
	JLabel result;
	JPanel answers;
	JButton[] buttons = new JButton[4];
	
	
	public View(Control control) {
		frame = new JFrame("Wer wird Millionär?");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(800,600));
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.LIGHT_GRAY);
		frame.add(panel);
		
		question = new JLabel("Frage kommt hier");
		
		
		panel.add(question, BorderLayout.CENTER);
		
		result = new JLabel();
		result.setLayout(new GridLayout(2,2));
		panel.add(result, BorderLayout.NORTH);
		
		answers = new JPanel();
		answers.setLayout(new GridLayout(2,2));
		answers.setBackground(Color.gray);
		panel.add(answers, BorderLayout.SOUTH);
		
		for(int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton("Knöpfe");
			
			answers.add(buttons[i]);
			buttons[i].addActionListener(control);
		}
		
		frame.pack();
		frame.setVisible(true);
		question.setBounds((panel.getWidth()-question.getPreferredSize().width)/2, (int)(panel.getHeight()*0.25), question.getPreferredSize().width, question.getPreferredSize().height);
	}
	
}
