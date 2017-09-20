package com.utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.exceptions.WebServicesException;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.pojos.GlobalData;

/**
 * @description : Rest Keywords
 * @author pradeep.jp
 *
 */
public class WebservicesWrapper {
	JSONParser parser = new JSONParser();

	public void Get(GlobalData testData, String URI) throws ParseException, WebServicesException {
		BaseClass.log("stepinfo","Get Keyword method invoked...");
		Response response = null;
		try {
			BaseClass.log("stepinfo","Performing GET for the URI: "+URI);
			response = RestAssured.given().contentType(testData.getProp().get("headerTypec").toString()).when()
					.get(URI);
			BaseClass.log("stepinfo","Response is sucessfully fetched from URI " + URI);
		} catch (Exception e) {
			BaseClass.log("stepinfo","Failed to fetched response from URI " + URI);
			e.printStackTrace();
			throw e;
		}
		if (response != null) {
			testData.setResponse(response);
		} else {
			throw new WebServicesException("Failed to perform GET on URI: " + URI);
		}
		BaseClass.log("stepinfo","Get Keyword method Executed sucessfully...");

	}

	public void Post(GlobalData testData, String URI, String body) throws ParseException, WebServicesException {
		BaseClass.log("stepinfo","POST Keyword method invoked");
		Response response = null;
		try {
			BaseClass.log("stepinfo","Performing POST for the URI: "+URI+ "\n With Json body as :\n"+ (JSONObject) parser.parse(body));
			response = RestAssured.given().contentType(testData.getProp().get("headerTypec").toString()).body(body)
					.when().post(URI);
			BaseClass.log("stepinfo","Response is sucessfully fetched from URI " + URI);
		} catch (Exception e) {
			BaseClass.log("stepinfo","Failed to fetched response from URI " + URI);
			e.printStackTrace();
			throw e;
		}
		if (response != null) {
			testData.setResponse(response);
		} else {
			throw new WebServicesException("Failed to perform POST on URI: " + URI);
		}
		BaseClass.log("stepinfo","POST Keyword method Executed sucessfully...");
	}
	
	public void Put(GlobalData testData, String URI, String body) throws ParseException, WebServicesException {
		BaseClass.log("stepinfo","PUT Keyword method invoked");
		Response response = null;
		try {
			BaseClass.log("stepinfo","Performing PUT for the URI: "+URI+ "\n With Json body as :\n"+body);
			response = RestAssured.given().contentType(testData.getProp().get("headerTypec").toString()).body(body)
					.when().put(URI);
			BaseClass.log("stepinfo","Response is sucessfully fetched from URI " + URI);
		} catch (Exception e) {
			BaseClass.log("stepinfo","Failed to fetched response from URI " + URI);
			e.printStackTrace();
			throw e;
		}
		if (response != null) {
			testData.setResponse(response);
		} else {
			throw new WebServicesException("Failed to perform PUT on URI: " + URI);
		}
		BaseClass.log("stepinfo","PUT Keyword method Executed sucessfully...");
	}
	
	
	public void Patch(GlobalData testData, String URI, String body) throws ParseException, WebServicesException {
		BaseClass.log("stepinfo","PATCH Keyword method invoked");
		Response response = null;
		try {
			BaseClass.log("stepinfo","Performing PATCH for the URI: "+URI+ "\n With Json body as :\n"+body);
			response = RestAssured.given().contentType(testData.getProp().get("headerTypec").toString()).body(body)
					.when().patch(URI);
			BaseClass.log("stepinfo","Response is sucessfully fetched from URI " + URI);
		} catch (Exception e) {
			BaseClass.log("stepinfo","Failed to fetched response from URI " + URI);
			e.printStackTrace();
			throw e;
		}
		if (response != null) {
			testData.setResponse(response);
		} else {
			throw new WebServicesException("Failed to perform PATCH on URI: " + URI);
		}
		BaseClass.log("stepinfo","PATCH Keyword method Executed sucessfully...");
	}

	public void Delete(GlobalData testData, String URI) throws ParseException, WebServicesException {
		BaseClass.log("stepinfo","DELETE Keyword method invoked...");
		Response response = null;
		try {
			BaseClass.log("stepinfo","Performing DELETE for the URI: "+URI);
			response = RestAssured.given().contentType(testData.getProp().get("headerTypec").toString()).when()
					.delete(URI);
			BaseClass.log("stepinfo","Response is sucessfully fetched from URI " + URI);
		} catch (Exception e) {
			BaseClass.log("stepinfo","Failed to fetched response from URI " + URI);
			e.printStackTrace();
			throw e;
		}
		if (response != null) {
			testData.setResponse(response);
		} else {
			throw new WebServicesException("Failed to perform DELETE on URI: " + URI);
		}
		BaseClass.log("stepinfo","DELETE Keyword method Executed sucessfully...");

	}


}
