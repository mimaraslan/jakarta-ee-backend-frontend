package com.mimaraslan;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 */
@Path("/")
public class AppMain implements Serializable {

	private static final long serialVersionUID = 1L;

	private final static Logger LOGGER = Logger.getLogger(AppMain.class.toString());

	/*
	 * Endpoint for Backend
	 * 
	 * curl -X GET
	 * http://localhost:8080/my-001-jakartaee-backend/webapi/person/Amelia Eiras
	 */
	@GET
	@Produces("text/plain")
	@Path("person/{personName : .*}")
	public String person(@PathParam("personName") String personName) {

		LOGGER.entering(this.getClass().toString(), "person", new Object[] { personName });

		String greetings = "Hello " + personName;

		LOGGER.exiting(this.getClass().toString(), "person", greetings);

		return "" + greetings;
	}
}
