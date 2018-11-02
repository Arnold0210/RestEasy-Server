package service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import controller.controllerCar;
import model.GenericResponse;
import model.DTO.Car;

@Path("/car")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class CarServiceImpl implements CarService {

	private static Map<String, Car> cars = new HashMap<String, Car>();
	private controllerCar carc = new controllerCar();
	@Override
	@POST
	@Path("/newcar/")
	public Response addCar(Car c) {
		GenericResponse response = new GenericResponse();
		if (cars.get(c.getEancode()) != null) {
			response.setStatus(false);
			response.setMessage("Car Already Exists!");
			response.setErrorCode("CC-01");
			return Response.status(422).entity(response).build();
		}
		cars.put(c.getEancode(), c);
		response.setStatus(true);
		response.setMessage("Car created succesfully");
		return Response.ok(response).build();
	}

	@Override
	@GET
	@Path("/sell/{id}/{amount}")
	public String sellCar(@PathParam("id") String idEAN,@PathParam("amount")int amount) {
		carc.updateCar(idEAN, amount);
		return "hecho actualizado";
	}

	@Override
	@GET
	@Path("/query/{idEAN}")
	public Car getAllCar(@PathParam("idEAN")String idEAN) {
		Car c = carc.selectCar(idEAN);
		return c;
	}

	



}
