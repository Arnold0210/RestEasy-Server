package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import controller.controllerCar;
import model.DAO.CarroDAO;
import model.DTO.Car;

@Path("/car")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class CarServiceImpl implements CarService {

	private controllerCar carc = new controllerCar();

	@Override
	@POST
	@Path("/newcar")
	public String addCar(Car c) {
		CarroDAO carro = new CarroDAO();
		carro.createcar(c);
		return "hola";
	}

	@Override
	@GET
	@Path("/sell/{id}/{amount}")
	public void sellCar(@PathParam("id") String idEAN, @PathParam("amount") int amount) {
		carc.updateCar(idEAN, amount);
	}

	@Override
	@GET
	@Path("/query/{idEAN}")
	public Car getAllCar(@PathParam("idEAN") String idEAN) {
		Car c = carc.selectCar(idEAN);
		return c;
	}

}
