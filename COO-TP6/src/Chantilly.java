public class Chantilly extends Garniture{

	public Chantilly(Dessert dessert) {
		this.dessert = dessert;
	}
	
	public double getPrix() {
		return dessert.getPrix() +1;
	}
}