package com.rest.api.db.mybatis;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.jvnet.hk2.annotations.Service;

import com.rest.api.dao.CarDao;
import com.rest.api.db.mybatis.mapper.CarDaoMapper;
import com.rest.api.model.Car;

@Service
public class CarDaoBatisImpl implements CarDao {

	private SqlSessionFactory sqlSessionFactory;

	public CarDaoBatisImpl() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public Car getCar(long id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {			
			CarDaoMapper mapper = session.getMapper(CarDaoMapper.class);
			return mapper.getCar(id);
		} finally {
			session.close();
		}
	}

	public Car addCar(Car car) {
		SqlSession session = sqlSessionFactory.openSession();
		try {			
			CarDaoMapper mapper = session.getMapper(CarDaoMapper.class);
			mapper.addCar(car);
			session.commit();
			return car;
		} finally {
			session.close();
		}
	}

	public Car updateCar(long id, Car car) {
		SqlSession session = sqlSessionFactory.openSession();
		try {			
			CarDaoMapper mapper = session.getMapper(CarDaoMapper.class);
			mapper.updateCar(id, car);
			session.commit();
			return car;
		} finally {
			session.close();
		}
	}

	public boolean deleteCar(long id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {			
			CarDaoMapper mapper = session.getMapper(CarDaoMapper.class);
			mapper.deleteCar(id);
			session.commit();
			return true;
		} finally {
			session.close();
		}
	}

	public Collection<Car> listCars() {
		SqlSession session = sqlSessionFactory.openSession();
		try {			
			CarDaoMapper mapper = session.getMapper(CarDaoMapper.class);
			return mapper.listCars();
		} finally {
			session.close();
		}
	}

}
