package com.rest.api.dao.mock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Named;

import com.rest.api.dao.CarDao;
import com.rest.api.model.Car;

@Named
//@Default
@Alternative
@ApplicationScoped
public class CarDaoMockImpl implements CarDao, Serializable {

	@Override
	public Car getCar(long id) {
		return new Car(1, "BMW", "320d", 1);
	}

	@Override
	public Car addCar(Car car) {
		return new Car(1, "BMW", "320d", 1);
	}

	@Override
	public void updateCar(long id, Car car) {
		;
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
