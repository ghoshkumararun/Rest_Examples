package com.toml.mpsi.service;

import javax.ws.rs.core.Response;

public interface MPISService {
	
	public Response getMobileNumberOperatorName(String mobileNumber);
	
}
