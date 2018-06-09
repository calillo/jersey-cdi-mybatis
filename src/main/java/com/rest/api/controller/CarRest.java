package com.rest.api.controller;

import java.util.Collection;

import javax.inject.Inject;
import javax.validation.constraints.Min;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.rest.api.dao.CarDao;
import com.rest.api.model.Car;

@Path("/cars")
public class CarRest {

	@Inject
	private CarDao carDao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Car> listCars() {
		return carDao.listCars();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Car getCar(@PathParam("id") @Min(0) long id) {
		Car car = carDao.getCar(id);
		if (car != null)
			return car;
		else
			throw new NotFoundException();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCar(Car car, @Context UriInfo uriInfo) {
		carDao.addCar(car);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(car.getId()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCar(@PathParam("id") long id, Car car) {
		carDao.updateCar(id, car);
		return Response.noContent().build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteCar(@PathParam("id") long id) {
		carDao.deleteCar(id);
		return Response.noContent().build();
	}

}
