package com.example.useradmin.initialization;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.example.useradmin.api.APIStatus;
import com.example.useradmin.api.LoginResource;
import com.example.useradmin.api.RoleResource;
import com.example.useradmin.api.SecurityUserResource;
import com.example.useradmin.api.UserResource;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(APIStatus.class);
		register(UserResource.class);
		register(SecurityUserResource.class);
		register(LoginResource.class);
		register(RoleResource.class);
	}

}
