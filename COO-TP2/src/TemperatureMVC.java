
public class TemperatureMVC {
	public TemperatureMVC() {
		TemperatureModel tempmod = new TemperatureModel();
		TemperatureController tempcontrolC = new TemperatureController(tempmod);
		TemperatureController tempcontrolF = new TemperatureController(tempmod);
		TemperatureVueCelsuis pvc = new TemperatureVueCelsuis(tempmod, tempcontrolC, 100, 200);
		TemperatureVueFahrenheit tvf = new TemperatureVueFahrenheit(tempmod, tempcontrolF, 100, 350);
		tempcontrolC.addView(pvc);
		tempcontrolF.addView(tvf);
	}
	
	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TemperatureMVC();
			}});
	}
}
