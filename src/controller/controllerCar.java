package controller;

import model.DAO.CarroDAO;
import model.DTO.Car;
import service.client.CarClient;

public class controllerCar {
	CarroDAO DAOCar;
	Car car;

	public void createCar(String idEAN, String description, int cantidad) {
		DAOCar = new CarroDAO();
		car = new Car();
		try {
			car.setEancode(idEAN);
			car.setDescription(description.toLowerCase());
			car.setAmount(cantidad);
			DAOCar.createcar(car);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Car selectCar(String idEAN) {
		DAOCar = new CarroDAO();
		car = new Car();
		car = DAOCar.selectCar(idEAN);
		return car;
	}

	public void updateCar(String idEAN, int amount) {
		DAOCar = new CarroDAO();
		boolean status = true;
		status = DAOCar.updateamount(idEAN, amount);
		if (status == false) {
			CarClient cc = new CarClient();
			cc.search(idEAN, amount);
		} else {
			System.out.println("sell do it!");
		}
	}

	public Boolean deleteCar(String idEAN) {
		DAOCar = new CarroDAO();
		boolean car;
		car = DAOCar.deleteCar(idEAN);
		if (car == false) {
			System.err.println("Can't delete this car");
			return false;
		} else {
			return true;
		}
	}
}
