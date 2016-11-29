public class Garage implements Iterable<Voiture>{

	private Voiture[] listeVoiture = new Voiture[5];
	private Integer nbVoiture = 0;

	private class IterateurVoiture implements Iterateur<Voiture> {

		private Integer compteur = 0;
		public boolean hasNext() {
			return compteur<listeVoiture.length;
		}

		public Voiture next() {
			if(this.hasNext()) return listeVoiture[compteur++];
			return null;
		}

		public void remove() {
			listeVoiture[compteur] = null;
		}
		
	}

	public Voiture.Etat getEtat(int i) {
		return listeVoiture[i].getEtat();
	}

	public Iterateur<Voiture> creerIterateur() {
		return new IterateurVoiture();
	}
	
	public void add(Voiture voiture){
		listeVoiture[nbVoiture] = voiture;
		nbVoiture++;
	}
	
	public Voiture get(int indice){
		return listeVoiture[indice];
	}

	public void setAtelier(int i) {
		listeVoiture[i].setAtelier();
	}
}
