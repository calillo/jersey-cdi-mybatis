package com.rest.api.db.mybatis.mapper;

import java.util.Collection;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rest.api.model.Car;

public interface CarDaoMapper {

	@Select("SELECT * FROM MYDB.CAR WHERE id = #{id};")
	public Car getCar(long id);

	@Insert("INSERT INTO MYDB.CAR (BRAND, MODEL, VERSION) VALUES (#{brand}, #{model}, #{version});")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public Car addCar(Car car);
	
	@Update("UPDATE MYDB.CAR SET ID = #{car.id}, BRAND = #{car.brand} , MODEL = #{car.model}, VERSION = #{car.version} WHERE ID = #{id};")
	public Car updateCar(long id, Car car);

	@Delete("DELETE FROM MYDB.CAR WHERE id = #{id};")
	public boolean deleteCar(long id);

	@Select("SELECT * FROM MYDB.CAR")
	public Collection<Car> listCars();
}
