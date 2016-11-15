import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class TemperatureVueFahrenheit extends TemperatureVue{
	public TemperatureVueFahrenheit(TemperatureModel modele,TemperatureController controleur, int posX,int posY) {
		super("Temperature Fahrenheit", modele, controleur, posX, posY);
		setDisplay(""+model.getF());
		addUpListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.augmenteDegresF();
			}});
		addDownListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.diminueDegresF();	
			}});
		addDisplayListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double tempF = getDisplay();
				controller.fixeDegresF(tempF);
			}});
		
	}
	
	public void update(Observable s, Object o) {
		setDisplay(""+model().getF());
		changement_couleur(getDisplay());
	}
}
