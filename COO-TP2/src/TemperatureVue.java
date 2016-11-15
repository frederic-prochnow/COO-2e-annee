import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class TemperatureVue implements Observer{
	@SuppressWarnings("unused")
	private String label;
	protected TemperatureModel model;
	protected TemperatureController controller;
	private JFrame temperatureJFrame;
	private JTextField display = new JTextField();
	private JButton upJButton = new JButton("+");
	private JButton downJButton = new JButton("-");
	
	public TemperatureVue(String label,TemperatureModel model,TemperatureController controller,int posX,int posY){
		this.label = label;
		this.model = model;
		this.controller = controller;
		
		temperatureJFrame = new JFrame(label);
		temperatureJFrame.add(new JLabel(label), BorderLayout.NORTH);
		temperatureJFrame.add(display, BorderLayout.CENTER);
		
		JPanel panelbuttons = new JPanel();
		
		panelbuttons.add(downJButton);
		panelbuttons.add(upJButton);
		temperatureJFrame.add(panelbuttons, BorderLayout.SOUTH);
		temperatureJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		model.addObserver(this); // Connexion entre la vue et le modele
		temperatureJFrame.setSize(200, 100);
		temperatureJFrame.setLocation(posX, posY);
		temperatureJFrame.setVisible(true);
	}
	
	public void setDisplay(String s){
		display.setText(s);
	}
	
	/**
	 * ACTIVER WARNING
	 */
	public void enableWarningColor(){
		display.setBackground(Color.RED);
	}
	
	/**
	 * DESACTIVER WARNING
	 */
	public void disableWarningColor(){
		display.setBackground(Color.white);
	}
	
	public double getDisplay() {
		double result = 0.0;
		try {
			result = Double.valueOf(display.getText()).doubleValue();
		} catch (NumberFormatException e) {
			result = 0.0;
		}
		return result;
	}
	
	public void addDisplayListener(ActionListener a) {
		display.addActionListener(a);
	}
	
	public void addUpListener(ActionListener a) {
		upJButton.addActionListener(a);
	}
	
	public void addDownListener(ActionListener a) {
		downJButton.addActionListener(a);
	}
	
	protected TemperatureModel model(){
		return model;
	}
}
