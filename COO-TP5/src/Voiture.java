public class Voiture {

	public enum Etat {
		MARCHE, PANNE_LEGERE, PANNE_SEVERE;
	}

	private String modele;

	private Etat etat;
	
	private Atelier atelier;

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Atelier getAtelier() {
		return atelier;
	}

	public void setAtelier(Atelier atelier) {
		this.atelier = atelier;
		this.atelier.reparer(this);
	}

	public Voiture(String modele, Etat etat){
		this.modele = modele;
		this.etat = etat;
	}

	@Override
	public String toString() {
		if(this == null) return "[voiture vide]";
		return "[modele=" + modele + ", etat=" + etat + "]";
	}

	public void setAtelier() {
		if (getEtat() == Etat.PANNE_LEGERE) setAtelier(AtelierLeger.getInstance());
		if (getEtat() == Etat.PANNE_SEVERE) setAtelier(AtelierSevere.getInstance());
	}
}
