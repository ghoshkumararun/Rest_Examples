package com.toml.mpsi.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.toml.mpsi.dao.MPSIDao;
import com.toml.mpsi.dao.MPSIDaoImpl;

@Path("/rest")
public class SampleRest {

	@GET
	@Path("/helloworld")
	@Produces("text/html")
	public Response helloWorld(){
		
		String responseString = "Hello world";
		return Response.status(200).entity(responseString).build();
	}
	
	@GET
	@Path("/getmobileoperator/{mobilenumber}")
	@Produces(MediaType.TEXT_HTML)
	public Response getMobileNumberOperatorName(@PathParam("mobilenumber") String mobileNumber) {
		MPSIDao dao = new MPSIDaoImpl();
		String result = dao.getMobileNumber(mobileNumber);
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/getmobileoperator1")
	@Produces(MediaType.TEXT_HTML)
	public Response getMobileNumberOperatorName1() {
		
		return Response.status(200).entity("success").build();
	}

}
