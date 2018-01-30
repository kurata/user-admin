package com.example.useradmin.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.useradmin.entities.User;
import com.example.useradmin.entities.UserRepository;

@Path("/v1/users")
public class UserResource {

	@Autowired
	private UserRepository respository;

	@OPTIONS
	public Response options() {
		return Response.status(Status.OK).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveAllUsers() {
		List<User> users = this.respository.findAll();
		return Response.status(Status.OK).entity(users).header("Access-Control-Allow-Origin", "*").build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveUser(@HeaderParam("Token") final String token, @PathParam("id") final Long id) {
		User character = this.respository.findOne(id);
		if (null != character) {
			return Response.status(Status.OK).entity(character).build();
		}
		return null;

	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@HeaderParam("Token") final String token, @PathParam("id") final Long id) {
		this.respository.delete(id);
		return Response.status(Status.OK).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(@HeaderParam("Token") final String token, final User user) {
		User savedUser = this.respository.save(user);
		return Response.status(Status.CREATED).entity(savedUser).build();
	}

}
