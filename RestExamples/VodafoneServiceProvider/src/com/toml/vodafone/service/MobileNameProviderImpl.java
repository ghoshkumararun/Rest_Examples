package com.toml.vodafone.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.toml.vodafone.model.MobileData;

@Path("/vodafonerest")
public class MobileNameProviderImpl implements MobileNameProvider{

	@Override
	@GET
	@Path("getcustomername/{operatorname}/{mobilenumber}")
	@Produces(MediaType.TEXT_HTML)
	public Response getCustomerName(@PathParam("operatorname") String operatorname,@PathParam("mobilenumber") String mobileNumber) {
		
		if(!"vodafone".equals(operatorname)){
			
			return Response.status(200).entity("not a valid operator name.").build();
		}
		else{
			if(mobileNumber.length()>10){
				return Response.status(200).entity("should be 10 digit valid mobile number.").build();
			}
			else{
				try{
					Long.parseLong(mobileNumber);
				}catch(Exception e){
					e.printStackTrace();
					return Response.status(200).entity("mobile number should contain only digits.").build();
				}
			}
		}
		return Response.status(200).entity("Arun").build();
	}
	
	@POST
	@Path("/getcustomername")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomerNameUsingJson(MobileData mobileData){
		
		if(!"vodafone".equals(mobileData.getOperatorName())){
					
					return Response.status(200).entity("not a valid operator name.").build();
				}
				else{
					if(mobileData.getMobileNumber().length()>10){
						return Response.status(200).entity("should be 10 digit valid mobile number.").build();
					}
					else{
						try{
							Long.parseLong(mobileData.getMobileNumber());
						}catch(Exception e){
							e.printStackTrace();
							return Response.status(200).entity("mobile number should contain only digits.").build();
						}
					}
				}

		mobileData.setCustomerName("Arun");
		
		return Response.status(200).entity(mobileData).build();
	}
	
}
