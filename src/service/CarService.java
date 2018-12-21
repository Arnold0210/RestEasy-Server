package service;

import model.DTO.Car;

public interface CarService {

	public String addCar(String c);

	public void sellCar(String idEAN, int ammount);

	public String getAllCar(String idEAN);

}
