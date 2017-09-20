package com.pojos;

/**
 *@description : POJO to store data and it will be available throughout the execution
 * @author pradeep.jp
 */
import java.util.Properties;

import com.jayway.restassured.response.Response;

public class GlobalData {

	Properties prop;
	Response response;
	String rootURI;
	String inputBody;

	public String getInputBody() {
		return inputBody;
	}

	public void setInputBody(String inputBody) {
		this.inputBody = inputBody;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	
	
}
