package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.exceptions.WebServicesException;
import com.pojos.GlobalData;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass {
	InputStream input = null;
	Properties prop = new Properties();
	GlobalData testData;
	ExtentReports extent;
	static ExtentTest test;
	
	public BaseClass(GlobalData globalData) throws IOException, WebServicesException {
		setupProps(globalData);
		
	}
	
	public BaseClass(GlobalData globalData,String TestName) throws IOException, WebServicesException {
		setupProps(globalData);
		setupExtent(globalData,TestName);
	}
	
	/**
	 * Description : Method to initialize config.properties and GlobalData
	 * this will be available throughout the execution
	 * @param globalData
	 * @throws IOException
	 * @throws WebServicesException
	 */
	private void setupProps(GlobalData globalData) throws IOException, WebServicesException{
		try{
		input = new FileInputStream("resources\\config.properties");
		prop.load(input);
		}catch(Exception e){
			throw new WebServicesException("Failed to read Property file");
		}
		globalData.setProp(prop);
		
	}
	
	public static void log(String logtype,String message) {
		
		switch(logtype.toLowerCase()) {
			case "stepinfo":
				test.log(LogStatus.INFO, message);
				System.out.println(message);
				break;
			case "steppass":
				test.log(LogStatus.PASS, message);
				System.out.println(message);
				break;
			case "stepfail":
				test.log(LogStatus.FAIL, message);
				System.out.println(message);
				break;
		}
		
	}
	
	public static void log(String logtype,String message, Throwable t) {
		switch(logtype.toLowerCase()) {
		case "stepfail":
			test.log(LogStatus.FAIL, message,t);
			System.out.println(message+t);
			break;
		
	}
	
	}
	
	private void setupExtent(GlobalData globalData,String TestName) throws IOException, WebServicesException{
		extent = new ExtentReports("reports\\"+TestName+".html",true);
		test = extent.startTest("Test Name", TestName);	
		
	}
	
	public void close() {
		extent.endTest(test);
		extent.flush();
	}

}
