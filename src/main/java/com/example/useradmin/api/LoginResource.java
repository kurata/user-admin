package com.example.useradmin.api;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.useradmin.entities.User;
import com.example.useradmin.entities.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/v1/login")
public class LoginResource {

	@Autowired
	private UserRepository repository;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(final Login login) {
		User user = this.repository.findByName(login.getName());
		if (login.getPassword().equals(user.getName())) {
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				String userInfoString = objectMapper.writeValueAsString(user);
				return Response.status(Status.OK).entity(
						"{\"token\": \"" + Base64.getEncoder().encodeToString(userInfoString.getBytes("UTF-8")) + "\"}")
						.build();
			} catch (JsonProcessingException | UnsupportedEncodingException e) {
				return Response.status(Status.INTERNAL_SERVER_ERROR).build();
			}
		}
		return Response.status(Status.UNAUTHORIZED).build();
	}
}
