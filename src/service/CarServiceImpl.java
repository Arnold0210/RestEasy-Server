package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.simple.parser.ParseException;

import com.google.gson.*;

import controller.controllerCar;
import model.DAO.CarroDAO;
import model.DTO.Car;

@Path("/car")
@Consumes("application/json")
@Produces("application/json")
public class CarServiceImpl implements CarService {
	private Gson gson = new Gson();
	private Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
	private controllerCar carc = new controllerCar();

	@Override
	@POST
	@Path("/newcar")
	public String addCar(String car) throws ParseException {
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
		String jsonString = gsonPretty.toJson(c);
		return jsonString;
	}

	@Override
	@DELETE
	@Path("/deletecar/{idEAN}")
	public void deleteCar(@PathParam("idEAN") String idEAN) {
		Boolean c = carc.deleteCar(idEAN);
		if (c == true) {
			System.out.println("Car deleted succesfully!");
		} else {
			System.err.println("Car can't deleted ");
		}

	}

}
