public class Fraise extends Garniture{

	public Fraise(Dessert dessert) {
		this.dessert = dessert;
	}
	
	public double getPrix() {
		return dessert.getPrix() + 1;
	}
}