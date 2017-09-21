package com.toml.controller;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.toml.model.MobileData;

@Controller
public class MPISClientController {

	@RequestMapping(value={"/","/home"},method=RequestMethod.GET)
	public String helloWorld(){
		
		return "home";
	}
	
	@RequestMapping(value="/getServiceProviderName",method=RequestMethod.POST)
	public String getMobileOperatorName(@RequestParam("mobileNumber") String mobileNumber,ModelMap model){
		
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
		WebTarget webTarget = client.target("http://localhost:8080/MobileNumberProducer").path("mpsi").path("getmobileoperator").path(mobileNumber);
//		client.setProperty("Content-Type", "application/json;charset=UTF-8");
		
		//http://localhost:8080/MobileNumberProducer/mpsi/getmobileoperator/8898989898
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.TEXT_HTML);
		Response response = invocationBuilder.get();
		 
		String data = response.readEntity(String.class);
		
		if("others".equals(data)){
			model.addAttribute("message","your mobile number does not match with any service provider...");
			return "home";
		}
		
		System.out.println(data);
		model.addAttribute("operatorname", data);
		model.addAttribute("mobilenumber",mobileNumber);
		
//		Employees employees = response.readEntity(Employees.class);
//		List<Employee> listOfEmployees = employees.getEmployeeList();
//		     
//		System.out.println(response.getStatus());
//		System.out.println(Arrays.toString( listOfEmployees.toArray(new Employee[listOfEmployees.size()]) ));
		
		return "serviceprovider";
	}
	
	@RequestMapping(value="/getcustomername",method=RequestMethod.POST)
	public String getCustomerName(@RequestParam("mobileNumber") String mobileNumber, @RequestParam("mobileOperator") String operatorName,ModelMap model){
		
		
		// for airtel
		//http://localhost:8080/AirtelServiceProvider/airtelrest/getcustomername/airtel/9665656565
		
		
		//for vodafone
		//http://localhost:8080/VodafoneServiceProvider/vodafonerest/getcustomername/vodafone/8865656565
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
		WebTarget webTarget = null;
		
		if("airtel".equals(operatorName)){
			webTarget = client.target("http://localhost:8080/AirtelServiceProvider").path("airtelrest").path("getcustomername").path(operatorName).path(mobileNumber);
		}
		else if("vodafone".equals(operatorName)){
			webTarget = client.target("http://localhost:8080/VodafoneServiceProvider").path("vodafonerest").path("getcustomername").path(operatorName).path(mobileNumber);
		}
		else{
			model.addAttribute("message","some problem, please try again...");
			return "home";
		}
//		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
//		webTarget = client.target("http://localhost:8080/MobileNumberProducer").path("mpsi").path("getmobileoperator").path(mobileNumber);
//		client.setProperty("Content-Type", "application/json;charset=UTF-8");
		
		//http://localhost:8080/MobileNumberProducer/mpsi/getmobileoperator/8898989898
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.TEXT_HTML);
		Response response = invocationBuilder.get();
		 
		String data = response.readEntity(String.class);
		
		System.out.println(data);
		model.addAttribute("customername",data);
		model.addAttribute("operatorname", operatorName);
		model.addAttribute("mobilenumber",mobileNumber);
		
		return "customerinfo";
	}
	
	@RequestMapping(value="/postexample",method=RequestMethod.GET)
	public String postExamplePage(){
		return "postexample";
	}
	
//	@RequestMapping(value="/callpostexample",method=RequestMethod.POST)
//	public String callPostExample(@RequestParam("textVal") String textVal,ModelMap model){
//		
//		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
//		WebTarget webTarget = client.target("http://localhost:8080/simplerest").path("bookservice").path("postexample");
//		
//		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.TEXT_PLAIN);
//		Response response = invocationBuilder.post(Entity.entity(textVal, MediaType.TEXT_PLAIN));
//		
//		String data = response.readEntity(String.class);
//		
//		model.addAttribute("postresult", data);
//		return "postexample";
//	}
	
	@RequestMapping(value="/callpostexample",method=RequestMethod.POST)
	public String callPostExample1(@RequestParam("operatorname") String operatorName,@RequestParam("mobilenumber") String mobileNumber,ModelMap model){
		
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
		WebTarget webTarget = client.target("http://localhost:8080/simplerest").path("bookservice").path("postexample1").path(operatorName).path(mobileNumber);
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.TEXT_PLAIN);
		Response response = invocationBuilder.post(Entity.entity("", MediaType.TEXT_PLAIN));
		
		String data = response.readEntity(String.class);
		
		model.addAttribute("postresult", data);
		return "postexample";
	}
	

	// get home page for sending data
	@RequestMapping(value={"/home_json"},method=RequestMethod.GET)
	public String homePageJson(){
		return "home_json";
	}
	
	// call getmobileoperator using Json get getting operator name
	@RequestMapping(value="/getServiceProviderNameJson",method=RequestMethod.POST)
	public String getMobileOperatorNameUsingJson(@RequestParam("mobileNumber") String mobileNumber,ModelMap model){
		
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
		
		WebTarget webTarget = client.target("http://localhost:8080/MobileNumberProducer").path("mpsi").path("getmobileoperator");
//		client.setProperty("Content-Type", "application/json;charset=UTF-8");
		
		//http://localhost:8080/MobileNumberProducer/mpsi/getmobileoperator/8898989898
		
		
		MobileData mobileData = new MobileData();
		mobileData.setMobileNumber(mobileNumber);
		 
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(mobileData, MediaType.APPLICATION_JSON));
		
		MobileData data = response.readEntity(MobileData.class);
		
		if("others".equals(data.getOperatorName())){
			model.addAttribute("message","your mobile number does not match with any service provider...");
			return "home";
		}
		
		System.out.println(data);
		model.addAttribute("operatorname", data.getOperatorName());
		model.addAttribute("mobilenumber",data.getMobileNumber());
		
//		Employees employees = response.readEntity(Employees.class);
//		List<Employee> listOfEmployees = employees.getEmployeeList();
//		     
//		System.out.println(response.getStatus());
//		System.out.println(Arrays.toString( listOfEmployees.toArray(new Employee[listOfEmployees.size()]) ));
		
		return "serviceprovider_json";
	}
	
	@RequestMapping(value="/getcustomernamejson",method=RequestMethod.POST)
	public String getCustomerNameUsingJson(@RequestParam("mobileNumber") String mobileNumber, @RequestParam("mobileOperator") String operatorName,ModelMap model){
		
		
		// for airtel
		//http://localhost:8080/AirtelServiceProvider/airtelrest/getcustomername/airtel/9665656565
		
		
		//for vodafone
		//http://localhost:8080/VodafoneServiceProvider/vodafonerest/getcustomername/vodafone/8865656565
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
		WebTarget webTarget = null;
		
		if("airtel".equals(operatorName)){
			webTarget = client.target("http://localhost:8080/AirtelServiceProvider").path("airtelrest").path("getcustomername");
		}
		else if("vodafone".equals(operatorName)){
			webTarget = client.target("http://localhost:8080/VodafoneServiceProvider").path("vodafonerest").path("getcustomername");
		}
		else{
			model.addAttribute("message","some problem, please try again...");
			return "home";
		}
		
		//http://localhost:8080/MobileNumberProducer/mpsi/getmobileoperator/8898989898
		
		MobileData mobileData = new MobileData();
		mobileData.setMobileNumber(mobileNumber);
		mobileData.setOperatorName(operatorName);
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(mobileData, MediaType.APPLICATION_JSON));
		
		MobileData data = response.readEntity(MobileData.class);
		
		System.out.println(data);
		model.addAttribute("customername",data.getCustomerName());
		model.addAttribute("operatorname", data.getOperatorName());
		model.addAttribute("mobilenumber",data.getMobileNumber());
		
		return "customerinfo_json";
	}
	
	
}
