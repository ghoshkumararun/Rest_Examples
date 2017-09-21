package com.toml.mpsi.dao;

import com.toml.mpsi.model.MobileData;

public class MPSIDaoImpl implements MPSIDao {

	@Override
	public String getMobileNumber(String mobileNumber) {

		String mobileStr = String.valueOf(mobileNumber);

		if(mobileStr.startsWith("88"))
		{
			return "airtel";
		}
		else if(mobileStr.startsWith("96"))
		{
			return "vodafone";
		}
			
		return "others";
	}

	@Override
	public MobileData getMobileNumberOperator(MobileData mobileData) {
		
		String mobileStr = String.valueOf(mobileData.getMobileNumber());

		if(mobileStr.startsWith("88"))
		{
			mobileData.setOperatorName("airtel");
		}
		else if(mobileStr.startsWith("96"))
		{
			mobileData.setOperatorName("vodafone");
		}
		
		return mobileData;
	}

}
