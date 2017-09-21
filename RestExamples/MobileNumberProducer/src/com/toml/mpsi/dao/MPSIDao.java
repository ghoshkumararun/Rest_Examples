package com.toml.mpsi.dao;

import com.toml.mpsi.model.MobileData;

public interface MPSIDao {
	
	public String getMobileNumber(String mobileNumber);

	public MobileData getMobileNumberOperator(MobileData mobileData);
	
}
