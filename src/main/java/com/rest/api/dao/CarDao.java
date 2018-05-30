package com.rest.api.dao;

import java.util.Collection;

import org.jvnet.hk2.annotations.Contract;

import com.rest.api.model.Car;

@Contract
public interface CarDao {
	Car getCar(long id);
    Car addCar(Car car);
    Car updateCar(long id, Car car);
    boolean deleteCar(long id);
    Collection<Car> listCars();
}
