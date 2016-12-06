public class DessertConcret extends Composition{

	public static Dessert crepeNature(){ return new Crepe(); }
	
	public static Dessert crepeChocolat(){ return  new Chocolat(new Crepe()); }
	
	public static Dessert crepeChocolatChantilly(){ return  new Chantilly(new Chocolat(new Crepe())); }
	
	public static Dessert crepeChantilly() { return new Chantilly(new Crepe()); }
	
	public static Dessert crepeChantillyFraise() { return new Fraise(new Chantilly(new Crepe())); }
	
	public static Dessert gauffreNature() { return new Gauffre(); }
	
	public static Dessert gauffreChantilly() { return new Chantilly(new Gauffre()); }
	
	public static Dessert gauffreChantillyFraise() { return new Fraise(new Chantilly(new Gauffre())); }
	
	public static Dessert gauffreChocolat(){ return  new Chocolat(new Gauffre()); }
	
	public static Dessert gauffreChocolatChantilly(){ return  new Chantilly(new Chocolat(new Gauffre())); }
	
	public static  void main (String [] args ){
		Dessert d1 = crepeChocolatChantilly();
		Dessert d2 = gauffreChantillyFraise();
		Dessert d3 = crepeChocolat();
		Dessert d4 = gauffreChantilly();
		Dessert d5 = crepeNature();
		Dessert d6 = gauffreNature();
		
		System.out.println("crepe chocolat chantilly a 3 € facturé : " + d1.getPrix() + " €");
		System.out.println("gauffre chantily fraise a 4 € facturé : " + d2.getPrix() + " €");
		System.out.println("crepe chocolat a 2 € facturé : " + d3.getPrix() + " €");
		System.out.println("gauffre chantily a 3 € facturé : " + d4.getPrix() + " €");
		System.out.println("crepe  a 1.5 € facturé : " + d5.getPrix() + " €");
		System.out.println("gauffre  a 2 € facturé : " + d6.getPrix() + " €");
	}
	
}
