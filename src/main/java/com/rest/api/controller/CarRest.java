package com.rest.api.controller;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.rest.api.dao.CarDao;
import com.rest.api.model.Car;

@Path("/cars")
public class CarRest {

	@Inject
	CarDao carDao;
	
	@GET
	@Produces("application/json")
	public Collection<Car> getCars() {
		return carDao.listCars();
	}
}
