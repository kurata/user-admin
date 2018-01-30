package com.example.useradmin.api;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
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
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/v1/susers")
public class SecurityUserResource {

	@Autowired
	private UserRepository repository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveAllUsers(@HeaderParam("Token") final String token) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			User user = objectMapper.readValue(Base64.getDecoder().decode(token), User.class);
			List<User> users = this.repository.findAll();
			return Response.status(Status.OK).entity(users.stream()
					.filter(u -> u.getRole().getId() <= user.getRole().getId()).collect(Collectors.toSet())).build();
		} catch (IOException e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}

	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveUser(@HeaderParam("Token") final String token, @PathParam("id") final Long id) {
		User character = this.repository.findOne(id);
		if (null != character) {
			return Response.status(Status.OK).entity(character).build();
		}
		return null;

	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@HeaderParam("Token") final String token, @PathParam("id") final Long id) {
		this.repository.delete(id);
		return Response.status(Status.OK).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(@HeaderParam("Token") final String token, final User user) {
		User savedUser = this.repository.save(user);
		return Response.status(Status.CREATED).entity(savedUser).build();
	}

}
