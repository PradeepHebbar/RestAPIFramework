package com.tests;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.exceptions.WebServicesException;
import com.pojos.GlobalData;
import com.utilities.BaseClass;
import com.utilities.CustomKeywords;
import com.utilities.GetTestData;

public class TestPut {
	GlobalData globalData;
	BaseClass base;
	CustomKeywords customKeywords;
	GetTestData getTestData;
	
	@DataProvider(name = "testData")
	public Object[][] data() throws Exception {
		globalData = new GlobalData();
		getTestData = new GetTestData();
		base = new BaseClass(globalData,this.getClass().getSimpleName());
		return  getTestData.getExcelData(this.getClass().getSimpleName());
		
	}
	
	@Test(dataProvider = "testData")
	public void testPutServices(Hashtable<String, String> testData) throws IOException, WebServicesException{
		customKeywords = new CustomKeywords();
		customKeywords.prepareBody(globalData,testData);		
		customKeywords.putResponse(globalData,testData.get("Endpoint"));
		customKeywords.validateStatusCode(globalData, Integer.parseInt(testData.get("StatusCode")));			
		customKeywords.validateResponseAttributes(globalData,testData);
		
	}
	@AfterTest
	public void closeDriver() {
		base.close();
	}
}
