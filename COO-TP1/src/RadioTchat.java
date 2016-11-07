import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RadioTchat extends Subject{
	
	JFrame jFrame = new JFrame("Radio Tchat");
	JButton jButton = new JButton("nouvel auditeur");
	JTextArea jTextArea = new JTextArea();
	JTextField jTextField = new JTextField();

	RadioTchat radioTchat = this;
	
	public RadioTchat() {
		jTextArea.setEditable(false);
		jFrame.add(jButton, BorderLayout.NORTH);
		jFrame.add(jTextArea, BorderLayout.CENTER);
		jFrame.add(jTextField, BorderLayout.SOUTH);
		jTextField.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				jTextArea.setText(jTextArea.getText()+jTextField.getText()+"\n");
				notifyObserver();
			}
		});
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Auditeur(radioTchat);
				
			}
		});
		jFrame.setSize(500,500);
		jFrame.setVisible(true);
	}
	
}
