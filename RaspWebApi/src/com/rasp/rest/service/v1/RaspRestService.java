package com.rasp.rest.service.v1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 
 * @author sul
 *
 */

@Path("/")
public class RaspRestService {

	private static final Logger LOG = LogManager.getLogger(RaspRestService.class);

	@Path("/hello")
	public class HelloResource {
		@GET
		@Produces(MediaType.TEXT_PLAIN)
		public String sayHello() {
			return "Hello Jersey";
		}
	}
}
