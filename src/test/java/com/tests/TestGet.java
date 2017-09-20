package com.tests;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.exceptions.WebServicesException;
import com.pojos.GlobalData;
import com.utilities.BaseClass;
import com.utilities.CustomKeywords;
import com.utilities.GetTestData;

public class TestGet {
	GlobalData globalData;
	BaseClass base;
	CustomKeywords customKeywords;
	GetTestData getTestData;
	
	@DataProvider(name = "testData")
	public Object[][] data() throws IOException, WebServicesException {
		globalData = new GlobalData();
		getTestData = new GetTestData();
		base = new BaseClass(globalData,this.getClass().getSimpleName());
		return  getTestData.getExcelData(this.getClass().getSimpleName());
		
	}

	@Test(dataProvider = "testData")
	public void testGetServices(Hashtable<String, String> testData) throws IOException, WebServicesException {
		customKeywords = new CustomKeywords();
		customKeywords.getResponse(globalData, testData.get("Endpoint"));
		customKeywords.validateStatusCode(globalData, Integer.parseInt(testData.get("StatusCode")));
	}

	@AfterTest
	public void closeDriver() {
		base.close();
	}
	
}
