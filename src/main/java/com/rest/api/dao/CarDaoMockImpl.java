package com.rest.api.dao;

import java.util.ArrayList;
import java.util.Collection;

import org.jvnet.hk2.annotations.Service;

import com.rest.api.model.Car;

@Service
public class CarDaoMockImpl implements CarDao {

	@Override
	public Car getCar(long id) {
		return new Car(1, "BMW", "320d", 1);
	}

	@Override
	public Car addCar(Car car) {
		return new Car(1, "BMW", "320d", 1);
	}

	@Override
	public Car updateCar(long id, Car car) {
		return new Car(1, "BMW", "320d", 1);
	}

	@Override
	public boolean deleteCar(long id) {
		return true;
	}

	@Override
	public Collection<Car> listCars() {
		ArrayList<Car> list = new ArrayList<Car>();
		
		list.add(new Car(1, "BMW", "320d", 1));
		list.add(new Car(2, "Audi", "A3 2.0TDI", 1));
		list.add(new Car(3, "Mercedes", "A 220d", 1));
		
		return list;
	}

}
