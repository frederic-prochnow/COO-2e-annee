public class Chocolat extends Garniture{

	public Chocolat(Dessert dessert) {
		this.dessert = dessert;
	}
	
	public double getPrix() {
		return dessert.getPrix() + 0.5;
	}
	
}