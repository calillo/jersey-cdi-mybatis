package com.rest.api.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.rest.api.dao.CarDao;

//@ApplicationPath("/v1")
public class RestAppConfig extends ResourceConfig {
    public RestAppConfig() {
        //packages("com.rest.api");
    	//register(CarDao.class);
        register(new RestAppBinder());  
     }
 }
