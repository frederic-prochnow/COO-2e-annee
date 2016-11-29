import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AtelierSevere extends Atelier{

	private static final AtelierSevere Instance = new AtelierSevere();
	private List<Voiture> fileAttenteAS = new ArrayList<>();
	
	private AtelierSevere(){
		disponibilite = false;
	}
	
	public static AtelierSevere getInstance(){
		return Instance;
	}

	public void reparer(Voiture voiture) {
		if(disponibilite == true) {
			voiture.setAtelier( getInstance());
			Random random = new Random();
			duree = random.nextInt(3)+3;
			disponibilite = false;
		} else {
			fileAttenteAS.add(voiture);
		}
	}

	@Override
	public String toString() {
		return "AtelierSevere [fileAttenteAS=" + fileAttenteAS + "]";
	}
}
