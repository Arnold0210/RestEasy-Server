package service;

import javax.ws.rs.core.Response;

import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;

public interface CarService {

	public void addCar(String c) throws ParseException;

	public void sellCar(String idEAN, int ammount);

	public Response getAllCar(String idEAN);

	Response deleteCar(String idEAN);
}
