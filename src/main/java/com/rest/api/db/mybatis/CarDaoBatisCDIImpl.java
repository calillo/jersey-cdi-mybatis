package com.rest.api.db.mybatis;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;

import com.rest.api.dao.CarDao;
import com.rest.api.db.mybatis.mapper.CarDaoMapper;
import com.rest.api.model.Car;

@Named
@Default
//@Alternative
@ApplicationScoped
public class CarDaoBatisCDIImpl implements CarDao, Serializable {

	@Inject
	private CarDaoMapper carMapper;

	public Car getCar(long id) {
		return carMapper.getCar(id);
	}

	public Car addCar(Car car) {
		carMapper.addCar(car);
		return car;
	}

	public void updateCar(long id, Car car) {
		carMapper.updateCar(id, car);
	}

	public boolean deleteCar(long id) {
		return carMapper.deleteCar(id);
	}

	public Collection<Car> listCars() {
		return carMapper.listCars();
	}

}
