package com.toml.mpsi.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.toml.mpsi.dao.MPSIDao;
import com.toml.mpsi.dao.MPSIDaoImpl;
import com.toml.mpsi.model.MobileData;

@Path("/mpsi")
public class MPISServiceImpl implements MPISService{

	// for sending data in path param
	@GET
	@Path("/getmobileoperator/{mobilenumber}")
	@Produces(MediaType.TEXT_HTML)
	public Response getMobileNumberOperatorName(@PathParam("mobilenumber") String mobileNumber) {
		if(mobileNumber.length()>10)
		{
			return Response.status(200).entity("enter 10 digit valid mobile number").build();
		}
		else{
		
			try{
				Long.parseLong(mobileNumber);
			}catch(Exception e){
				e.printStackTrace();
				return Response.status(200).entity("enter only digits").build();
			}
		}
		MPSIDao dao = new MPSIDaoImpl();
		String result = dao.getMobileNumber(mobileNumber);
		
		return Response.status(200).entity(result).build();
	}

	//for sending data in json
	
    @POST
    @Path("/getmobileoperator")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrSaveBookInfo(MobileData mobileData) {
    	
    	if(mobileData.getMobileNumber().length()>10)
		{
			return Response.status(200).entity("enter 10 digit valid mobile number").build();
		}
		else{
		
			try{
				Long.parseLong(mobileData.getMobileNumber());
			}catch(Exception e){
				e.printStackTrace();
				return Response.status(200).entity("enter only digits").build();
			}
		}
    	
    	MPSIDao dao = new MPSIDaoImpl();
    	MobileData result = dao.getMobileNumberOperator(mobileData);
		
		return Response.status(200).entity(result).build();
    	
    }
	
}
