import java.util.Observable;

public class TemperatureVueSlider extends TemperatureVue{

	public TemperatureVueSlider(TemperatureModel modele,TemperatureController controleur, int posX,int posY) {
		super("Temperature Celsuis", modele, controleur, posX, posY);
		setDisplay(""+model.getC());
	}

	public void update(Observable o, Object arg) {
		
	}

}
