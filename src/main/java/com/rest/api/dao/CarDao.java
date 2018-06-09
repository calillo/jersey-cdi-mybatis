package com.rest.api.dao;

import java.util.Collection;

import com.rest.api.model.Car;

public interface CarDao {
	Car getCar(long id);
    Car addCar(Car car);
    void updateCar(long id, Car car);
    boolean deleteCar(long id);
    Collection<Car> listCars();
}
