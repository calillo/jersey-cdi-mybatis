package com.rest.api.app;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.rest.api.dao.CarDao;
import com.rest.api.dao.CarDaoMockImpl;
import com.rest.api.db.mybatis.CarDaoBatisImpl;

public class RestAppBinder extends AbstractBinder {
    @Override
    protected void configure() {
        //bind(CarDaoMockImpl.class).to(CarDao.class).in(Singleton.class);
    	bind(CarDaoBatisImpl.class).to(CarDao.class).in(Singleton.class);
    }
}
