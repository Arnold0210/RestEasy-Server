package service;



import javax.ws.rs.core.Response;

import model.DTO.Car;

public interface CarService {

	public Response addCar(Car c);

	public String sellCar(String idEAN,int ammount);

	public Car getAllCar(String idEAN);

}
