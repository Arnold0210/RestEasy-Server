package controller;

import model.DAO.CarroDAO;
import model.DTO.Car;

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
			// Hacer web service
		}else {
			System.out.println("actualicé");
		}
	}
}
