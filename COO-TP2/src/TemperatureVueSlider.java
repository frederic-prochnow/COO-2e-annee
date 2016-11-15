import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TemperatureVueSlider implements Observer{

	private String label;
	protected TemperatureModel model;
	protected TemperatureController controller;
	private JFrame temperatureJFrame;
	private JSlider thermometre = new JSlider(JSlider.VERTICAL);
	
	
	public TemperatureVueSlider(String label,TemperatureModel model,TemperatureController controller,int posX,int posY){
		this.label = label;
		this.model = model;
		this.controller = controller;
		
		temperatureJFrame = new JFrame(label);
		temperatureJFrame.add(new JLabel(label), BorderLayout.NORTH);
		
		JPanel panelslider = new JPanel();
		
		thermometre.setMaximum(100);
		thermometre.setMinimum(-20);
		thermometre.setMajorTickSpacing(10);
		thermometre.setMinorTickSpacing(1);
		thermometre.setPaintLabels(true);
		thermometre.setPaintTicks(true);
		
		panelslider.add(thermometre);
		
		temperatureJFrame.add(panelslider, BorderLayout.CENTER);
		temperatureJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		model.addObserver(this); // Connexion entre la vue et le modele
		//temperatureJFrame.setSize(100, 500);
		temperatureJFrame.setLocation(posX, posY);
		temperatureJFrame.setVisible(true);
		temperatureJFrame.pack();
		
		addThermoListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				double tempC = thermometre.getValue();
				controller.fixeDegresC(tempC);
			}});
		
	}
	
	/*public void setDisplay(String s){
		display.setText(s);
	}*/
	
	/**
	 * ACTIVER WARNING
	 */
	public void enableWarningColor(){
		thermometre.setBackground(Color.RED);
	}
	
	/**
	 * DESACTIVER WARNING
	 */
	public void disableWarningColor(){
		thermometre.setBackground(Color.white);
	}
	
	
	public void addThermoListener(ChangeListener a){
		thermometre.addChangeListener(a);
	}
	
	protected TemperatureModel model(){
		return model;
	}
	
	public void changement_couleur(){
		int temp = thermometre.getValue();
		if(temp <= 15.0)
			thermometre.setBackground(Color.cyan);
		else if(temp >= 40.0)
			thermometre.setBackground(Color.RED);
		else if (temp > 15.0 && temp < 40.0)
			thermometre.setBackground(Color.WHITE);
		else 
			thermometre.setBackground(Color.WHITE);
	}
	
	public void update(Observable o, Object arg) {
		thermometre.setValue((int) model().getC());
		changement_couleur();
	}


}
