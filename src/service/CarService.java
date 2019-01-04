package service;

import model.DTO.Car;

public interface CarService {

	public void addCar(Car c);

	public void sellCar(String idEAN, int ammount);

	public Car getAllCar(String idEAN);

	void deleteCar(String idEAN);

}
