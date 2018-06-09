package com.rest.api.db.mybatis;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.rest.api.dao.CarDao;
import com.rest.api.db.mybatis.mapper.CarDaoMapper;
import com.rest.api.model.Car;

@Named
//@Default
@Alternative
@ApplicationScoped
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

	public void updateCar(long id, Car car) {
		SqlSession session = sqlSessionFactory.openSession();
		try {			
			CarDaoMapper mapper = session.getMapper(CarDaoMapper.class);
			mapper.updateCar(id, car);
			session.commit();
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
