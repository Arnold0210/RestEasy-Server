package service;

import org.json.simple.parser.ParseException;

public interface CarService {

	public String addCar(String c) throws ParseException;

	public void sellCar(String idEAN, int ammount);

	public String getAllCar(String idEAN);

	void deleteCar(String idEAN);
}
