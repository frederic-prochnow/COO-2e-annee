import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import java.net.URLConnection;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Itineraire {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("http.proxyHost", "cache.univ-lille1.fr");
		System.setProperty("http.proxyPort", "3128");
		
		String depart = "Lille";
		String arrivee = "Moscou";
		String[] tabNarrative = new String[100];
		int crochet1 = 1, crochet2 = 1;
		
		int cpt2 =1;
		int cpttotalfile = 0;
		
		URL u = new URL("http://open.mapquestapi.com/directions/v2/route?key=MzJPF68KYbwEXaqFr3rasHfabgXU5dcd&from="+depart+"&to="+arrivee+"&outFormat=xml&locale=fr_FR");
		URLConnection c = u.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
		String inputLine;
		
		while ((inputLine = in.readLine()) != null) {
			//System.out.println(inputLine);
			int distance = inputLine.indexOf("<distance>");
			int time = inputLine.indexOf("<formattedTime>");
			cpttotalfile = inputLine.length();
			if(distance!=-1){
				String longeur = inputLine.substring(distance+10,distance+17);
				Double totalmiles = Double.parseDouble(longeur);
				Double totalkm = totalmiles * 1.609 ;
				System.out.println("Départ de______________: " + depart);
			    System.out.println("Arrivee a______________: " + arrivee);
				System.out.println("Distace total en miles_: " + totalmiles + " miles.");
				System.out.println("Distace total en km____: " + totalkm + " kilométres.");
			}
			if(time!=-1){
				String duree = inputLine.substring(time+15,time+23);
				System.out.println("Duree du trajet________: " + duree);
				System.out.println("");
				System.out.println("Votre itinéraire :");
				System.out.println("");
			}
			crochet1 = 1; crochet2 = 1;
			for(int cpt =0; crochet1>0 && cpt2 < cpttotalfile; cpt ++){
				crochet1 = inputLine.indexOf("<narrative>",crochet2);
				crochet2 = inputLine.indexOf("</narrative>",crochet1);
				if(crochet1 != -1 && crochet2 != -1){
					tabNarrative[cpt] = inputLine.substring(crochet1+11,crochet2);
					System.out.println("Etape " + cpt + " : " + tabNarrative[cpt]);
				}
			}
		}
		in.close();
	}
}
