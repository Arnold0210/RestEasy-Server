package service.client;

import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.URL;

public class CarClient {
	public void search(String id, int amount) {
		HttpURLConnection connection = null;
		int result=0;
		try {
			URL url = new URL("http://localhost1:8080/rest/servicio/actualizar/" + id + "/" + amount);
			connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("PUT");
			connection.setUseCaches(false);
			result = connection.getResponseCode();
			if (connection.getResponseCode() == 200) {
				System.out.println("Sell did succesfully");
			} else {
				System.out.println("No existe ese auto \n"+connection.getResponseCode());
			}
		} catch (IOException e) {
			System.out.println("No se pudo hacer la peticion"+result);
			e.printStackTrace();
		}
	}
}
