package com.rest.api.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloRest {

	@GET
	public String message() {
		return "Hello, rest!";
	}
	
	@GET
	@Path("/new")
	public String newmethod() {
		return "New!";
	}
}
