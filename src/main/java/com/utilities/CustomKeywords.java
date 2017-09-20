package com.utilities;

import java.io.IOException;
import java.util.Hashtable;

import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import com.exceptions.WebServicesException;
import com.pojos.GlobalData;
import com.pojos.JsonBody;
import com.relevantcodes.extentreports.LogStatus;

public class CustomKeywords {
	WebservicesWrapper keywords;
	JsonBody jsonBody;

	public CustomKeywords() throws IOException {
		keywords = new WebservicesWrapper();
		jsonBody = new JsonBody();

	}

	/**
	 * @description : Method to get the response
	 * @param globalData
	 * @param endPointName
	 * @throws WebServicesException
	 */
	public void getResponse(GlobalData globalData, String endPointName) throws WebServicesException {
		try {
			String rootURI = globalData.getProp().get("rootURI").toString();
			keywords.Get(globalData, rootURI + endPointName);
			BaseClass.log("stepPass","Response is:\n" + globalData.getResponse().getBody().asString());
		} catch (ParseException | WebServicesException e) {
			throw new WebServicesException("Failed to perform Get on: " + endPointName);
		}

	}

	/**
	 * @description : Method to post the response
	 * @param globalData
	 * @param endPointName
	 * @throws WebServicesException
	 */
	public void postResponse(GlobalData globalData, String endPointName) throws WebServicesException {
		try {
			String rootURI = globalData.getProp().get("rootURI").toString();
			keywords.Post(globalData, rootURI + endPointName, globalData.getInputBody());
			BaseClass.log("stepPass","Response is:\n" + globalData.getResponse().getBody().asString());
		} catch (ParseException | WebServicesException e) {
			throw new WebServicesException("Failed to perform Post on: " + endPointName);
		}

	}

	/**
	 * @description : Method to put the response
	 * @param globalData
	 * @param endPointName
	 * @throws WebServicesException
	 */
	public void putResponse(GlobalData globalData, String endPointName) throws WebServicesException {
		try {
			String rootURI = globalData.getProp().get("rootURI").toString();
			keywords.Put(globalData, rootURI + endPointName, globalData.getInputBody());
			BaseClass.log("stepPass","Response is:\n" + globalData.getResponse().getBody().asString());
		} catch (ParseException | WebServicesException e) {
			throw new WebServicesException("Failed to perform put on: " + endPointName);
		}

	}

	/**
	 * @description : Method to patch the response
	 * @param globalData
	 * @param endPointName
	 * @throws WebServicesException
	 */
	public void patchResponse(GlobalData globalData, String endPointName) throws WebServicesException {
		try {
			String rootURI = globalData.getProp().get("rootURI").toString();
			keywords.Put(globalData, rootURI + endPointName, globalData.getInputBody());
			BaseClass.log("stepPass","Response is:\n" + globalData.getResponse().getBody().asString());
		} catch (ParseException | WebServicesException e) {
			throw new WebServicesException("Failed to perform Patch on: " + endPointName);
		}

	}

	/**
	 * @description : Method to delete the response
	 * @param globalData
	 * @param endPointName
	 * @throws WebServicesException
	 */
	public void deleteResponse(GlobalData globalData, String endPointName) throws WebServicesException {
		try {
			String rootURI = globalData.getProp().get("rootURI").toString();
			keywords.Get(globalData, rootURI + endPointName);
			BaseClass.log("stepPass","Response is:\n" + globalData.getResponse().getBody().asString());
		} catch (ParseException | WebServicesException e) {
			throw new WebServicesException("Failed to perform Delete on: " + endPointName);
		}

	}

	/**
	 * @description : method to validate the attributes in the response
	 * @param globalData
	 * @param testData
	 * @throws WebServicesException
	 */
	public void validateResponseAttributes(GlobalData globalData, Hashtable<String, String> testData)
			throws WebServicesException {
		for (int i = 0; i < testData.get("ExpectedBodyAttributes").split(",").length; i++) {
			switch (testData.get("ExpectedBodyAttributes").split(",")[i]) {
			case "ExpectedUserID":
				Assert.assertEquals(globalData.getResponse().getBody().jsonPath().get("userId").toString(),
						String.valueOf(testData.get("ExpectedUserID")));
				BaseClass.log("stepinfo",
						"UserID " + testData.get("ExpectedUserID") + " has been validated sucessfully agains response");
				break;
			case "ExpectedID":
				Assert.assertEquals(globalData.getResponse().getBody().jsonPath().get("id").toString(),
						String.valueOf(testData.get("ExpectedID")));
				BaseClass.log("stepinfo",
						"ID " + testData.get("ExpectedID") + " has been validated sucessfully agains response");
				break;
			case "ExpectedTitle":
				Assert.assertEquals(globalData.getResponse().getBody().jsonPath().get("title"),
						testData.get("ExpectedTitle"));
				BaseClass.log("stepinfo",
						"Title " + testData.get("ExpectedTitle") + " has been validated sucessfully agains response");
			case "ExpectedBody":
				Assert.assertEquals(globalData.getResponse().getBody().jsonPath().get("body"),
						testData.get("ExpectedBody"));
				BaseClass.log("stepinfo",
						"Body " + testData.get("ExpectedBody") + " has been validated sucessfully agains response");
				break;
			default:
				BaseClass.log("stepFail","Invalid Attribute: " + testData.get("BodyAttributes").split(",")[i]);
				throw new WebServicesException(
						new Throwable("Invalid Attribute: " + testData.get("BodyAttributes").split(",")[i]));
			}

		}

	}

	/**
	 * @description : Method to validate status code of the response
	 * @param globalData
	 * @param statusCode
	 * @throws WebServicesException
	 */
	public void validateStatusCode(GlobalData globalData, int statusCode) throws WebServicesException {
		if (globalData.getResponse().getStatusCode() == statusCode) {
			BaseClass.log("stepinfo","Expected status code is: " + statusCode);
			BaseClass.log("stepinfo","Actual status code is: " + globalData.getResponse().getStatusCode());
			BaseClass.log("stepPass", "Status code of the response validated sucessfully");
		} else {
			BaseClass.log("stepinfo","Expected status code is: " + statusCode);
			BaseClass.log("stepinfo","Actual status code is: " + globalData.getResponse().getStatusCode());
			BaseClass.log("stepFail", "Status code of the response validation is unsucessfully",new WebServicesException("Failed to validate status code of the response"));
			throw new WebServicesException(new Throwable("Failed to validate status code of the response"));
		}
	}

	/**
	 * @description: Method to prerare body 
	 * @param globalData
	 * @param testData
	 * @throws WebServicesException
	 */
	public void prepareBody(GlobalData globalData, Hashtable<String, String> testData) throws WebServicesException {
		for (int i = 0; i < testData.get("BodyAttributes").split(",").length; i++) {
			switch (testData.get("BodyAttributes").split(",")[i]) {
			case "UserID":
				jsonBody.setUserId(Integer.parseInt(testData.get("UserID")));
				break;
			case "ID":
				jsonBody.setId(Integer.parseInt(testData.get("ID")));
				break;
			case "Title":
				jsonBody.setTitle(testData.get("Title"));
				break;
			case "Body":
				jsonBody.setBody(testData.get("Body"));
				break;
			default:
				BaseClass.log("stepFail", "Invalid Attribute: " + testData.get("BodyAttributes").split(",")[i],new WebServicesException("Failed to validate status code of the response"));
				throw new WebServicesException(
						new Throwable("Invalid Attribute: " + testData.get("BodyAttributes").split(",")[i]));
			}

		}

		globalData.setInputBody(new JSONObject(jsonBody).toString());
	}

}
