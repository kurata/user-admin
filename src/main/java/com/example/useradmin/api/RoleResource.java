package com.example.useradmin.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.useradmin.entities.Role;
import com.example.useradmin.entities.RoleRepository;

@Path("/v1/roles")
public class RoleResource {

	@Autowired
	private RoleRepository repository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveRole(@QueryParam("id") final String id) {
		List<Role> roles = this.repository.findById(id);
		if (null != roles) {
			return Response.status(Status.OK).entity(roles).build();
		}
		return null;

	}
}
