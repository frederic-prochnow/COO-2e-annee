import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Auditeur extends Observer{
	
	RadioTchat r;
	JTextArea jTextArea;

	public Auditeur(RadioTchat radioTchat) {
		
		r = radioTchat;
		
		JFrame jFrame = new JFrame("Auditeur");
		jTextArea = new JTextArea();
		JTextField jTextField = new JTextField();
		
		jTextArea.setEditable(false);
		jFrame.add(jTextArea, BorderLayout.CENTER);
		jFrame.add(jTextField, BorderLayout.SOUTH);
		jTextField.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				jTextArea.setText(jTextArea.getText()+jTextField.getText()+"\n");
			}
		});
		jFrame.setSize(500,500);
		jFrame.setVisible(true);
	}

	@Override
	public void update() {
		jTextArea.setText(jTextArea.getText()+r.jTextField.getText()+"\n");
	}
	
}
