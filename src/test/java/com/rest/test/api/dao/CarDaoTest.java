package com.rest.test.api.dao;

import java.util.Collection;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.rest.api.dao.CarDao;
import com.rest.api.model.Car;
import com.rest.test.api.weld.WeldJUnit4Runner;

@RunWith(WeldJUnit4Runner.class)
public class CarDaoTest {

    @Inject
	CarDao carDao;
	
    @Test
	public void addCar() {
    	Car car = new Car();
    	car.setBrand("Brand_1");
    	car.setModel("Model_1");
    	car.setVersion(1);    	
    	carDao.addCar(car);
    	
    	Assert.assertNotNull(car.getId());
    	
    	Car ins = carDao.getCar(car.getId());
    	Assert.assertEquals(car.getBrand(), ins.getBrand());
    	Assert.assertEquals(car.getModel(), ins.getModel());
    	Assert.assertEquals(car.getVersion(), ins.getVersion());
    	
    	carDao.deleteCar(car.getId());

	}
    
    @Test
    public void updateCar() {
    	Car car = new Car();
    	car.setBrand("Brand_1");
    	car.setModel("Model_1");
    	car.setVersion(1);    	
    	carDao.addCar(car);
    	
    	car.setBrand("Brand_2");
    	car.setModel("Model_2");
    	car.setVersion(2);
    	carDao.updateCar(car.getId(), car);
    	
    	Car upd = carDao.getCar(car.getId());
    	Assert.assertEquals(car.getBrand(), upd.getBrand());
    	Assert.assertEquals(car.getModel(), upd.getModel());
    	Assert.assertEquals(car.getVersion(), upd.getVersion());
    	
    	carDao.deleteCar(car.getId());
    	
    }
    
    @Test
    public void deleteCar() {
    	Car car = new Car();
    	car.setBrand("Brand_1");
    	car.setModel("Model_1");
    	car.setVersion(1);
    	carDao.addCar(car);
    	
    	boolean isDel;
    	isDel = carDao.deleteCar(car.getId());
    	Assert.assertTrue(isDel);
    	
    	Car del = carDao.getCar(car.getId());
    	Assert.assertNull(del);
    	
    	isDel = carDao.deleteCar(99999);
    	Assert.assertFalse(isDel);
    	
    }
    
    @Test
    public void listCars() {
    	Car car = new Car();
    	for(int i = 0; i < 3; i++) {
    		car.setBrand("Brand_" + i);
        	car.setModel("Model_" + i);
        	car.setVersion(i);
        	carDao.addCar(car);
    	}
    		
    	Collection<Car> carList = carDao.listCars();
    	int i = 0;
    	for (Car c : carList) {
    		if (c.getBrand() != null && c.getBrand().startsWith("Brand_")) {
    			carDao.deleteCar(c.getId());
    			i++;
    		}
		}
    	Assert.assertEquals(3, i);
    	
    }
	
}
