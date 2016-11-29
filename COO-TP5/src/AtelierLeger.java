import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AtelierLeger extends Atelier {
	
	private static final AtelierLeger Instance = new AtelierLeger();
	
	private List<Voiture> fileAttenteAL = new ArrayList<>();
	
	private AtelierLeger(){
		disponibilite = true;
	}
	
	public static AtelierLeger getInstance() {
		return Instance;
	}

	public void reparer(Voiture voiture) {
		if(disponibilite == true) {
			voiture.setAtelier( getInstance());
			Random random = new Random();
			duree = random.nextInt(3)+1;
			disponibilite = false;
		} else {
			fileAttenteAL.add(voiture);
		}
	}

	@Override
	public String toString() {
		return "AtelierLeger [fileAttenteAL=" + fileAttenteAL + "]";
	}
}
