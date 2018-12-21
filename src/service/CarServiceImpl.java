package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.*;

import controller.controllerCar;
import model.DAO.CarroDAO;
import model.DTO.Car;

@Path("/car")
@Consumes("application/json")
@Produces("application/json")
public class CarServiceImpl implements CarService {

	private controllerCar carc = new controllerCar();

	@Override
	@POST
	@Path("/newcar")
	public String addCar(String car) {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		Car c = gson.fromJson(car, Car.class);
		CarroDAO carro = new CarroDAO();
		carro.createcar(c);
		return car;
	}

	@Override
	@PUT
	@Path("/sell/{id}/{amount}")
	public void sellCar(@PathParam("id") String idEAN, @PathParam("amount") int amount) {
		carc.updateCar(idEAN, amount);
	}

	@Override
	@GET
	@Path("/query/{idEAN}")
	public String getAllCar(@PathParam("idEAN") String idEAN) {
		Car c = carc.selectCar(idEAN);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String jsonString = gson.toJson(c);
		return jsonString;
	}

}
