package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.parser.ParseException;

import com.google.gson.*;

import controller.controllerCar;
import model.DAO.CarroDAO;
import model.DTO.Car;

@Path("/car")

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarServiceImpl implements CarService {
	private Gson gson = new Gson();
	//private Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
	private controllerCar carc = new controllerCar();
	@Override
	@POST
	@Path("/newcar")
	public void addCar(String car) throws ParseException {
		Car c = gson.fromJson(car, Car.class);
		CarroDAO carro = new CarroDAO();
		carro.createcar(c);
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
	public Response getAllCar(@PathParam("idEAN") String idEAN) {
		Car c = carc.selectCar(idEAN);
		String jsonstring = gson.toJson(c);
		JsonParser parser = new JsonParser();
		parser.parse(jsonstring).getAsJsonObject();
		//String jsonString = gsonPretty.toJson(c);
		return Response.status(200).entity(jsonstring).build();
	}

	@Override
	@DELETE
	@Path("/deletecar/{idEAN}")
	public Response deleteCar(@PathParam("idEAN") String idEAN) {
		Boolean c = carc.deleteCar(idEAN);
		if (c == true) {
			String message = "{'infocode':200,'infomessage':'Car deleted succesfully!'}";
			JsonParser parser = new JsonParser();
			
			return Response.status(200).entity(parser.parse(message).getAsJsonObject()).build();
		} else {
			String message = "{'errorcode':402,'errordescription':'Car can't deleted !'}";
			JsonParser parser = new JsonParser();
			parser.parse(message).getAsJsonObject();
			return Response.status(402).entity(parser.parse(message).getAsJsonObject()).build();
		}
	}

}
