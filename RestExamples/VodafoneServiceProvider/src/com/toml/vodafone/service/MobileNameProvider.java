package com.toml.vodafone.service;

import javax.ws.rs.core.Response;

public interface MobileNameProvider {
	public Response getCustomerName(String operatorname,String mobileNumber);
}
