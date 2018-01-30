package com.example.useradmin.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Path("/v1")
public class APIStatus {
	
	private static final Logger LOGGER = LogManager.getLogger(APIStatus.class);
	
	@GET
	@Path("/status")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response status() {
		LOGGER.debug("GET /v1/status - Called.");
		return Response.status(Status.OK).build();
	}

}
