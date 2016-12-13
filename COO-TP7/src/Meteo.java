import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import java.net.URLConnection;

public class Meteo {

	public static void main(String[] args) throws Exception {
		System.setProperty("http.proxyHost", "cache.univ-lille1.fr");
		System.setProperty("http.proxyPort", "3128");
		URL u = new URL("http://api.openweathermap.org/data/2.5/forecast/city?q=Villeneuve+d%27ascq&APPID=a627747b324b5c59cc68ae303a056581");
		URLConnection c = u.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
			in.close();
		}
}
