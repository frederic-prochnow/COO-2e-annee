import java.util.Random;

public class MonGarage {
	private static final Voiture.Etat[] tabEtat = {Voiture.Etat.MARCHE, Voiture.Etat.PANNE_LEGERE, Voiture.Etat.PANNE_SEVERE};

	public Voiture generateur_de_voiture(){
		return new Voiture(randomNom(), randomEtat());
	}

	private String randomNom() {
		return "voiture"+ new Random().nextInt(100);
	}

	private Voiture.Etat randomEtat() {
		return tabEtat[new Random().nextInt(3)+1];
	}
	
	public MonGarage(){
		Garage garage = new Garage();
		Voiture v1 = generateur_de_voiture(); garage.add(v1);
		Voiture v2 = generateur_de_voiture(); garage.add(v2);
		Voiture v3 = generateur_de_voiture(); garage.add(v3);
		Voiture v4 = generateur_de_voiture(); garage.add(v4);
		Voiture v5 = generateur_de_voiture(); garage.add(v5);
		for(int i=0; i<5; i++){
			garage.setAtelier(i);
		}
		System.out.println(garage.toString());
	}

}
