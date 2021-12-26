package com.test;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilities.ExcelFileUtil;
import com.utilities.GetFilePathUtil;
import com.utilities.ReadJSONFileUtil;
import com.utilities.ReadPropFileUtil;

public class readDifferentFiles {
	
	ReadPropFileUtil readProp;
	Properties prop;
	ReadJSONFileUtil readJSON;
	ExcelFileUtil excelUtil;
	GetFilePathUtil getFilePath;
	
	@BeforeMethod
	public void setUp() {
		
	}
	
	@Test
	public void readOne() {
		
		readProp = new ReadPropFileUtil();
		getFilePath = new GetFilePathUtil();
//		Properties prop = readPropertiesFile.readProperties(System.getProperty("user.dir") + "\\src\\test\\resources\\com\\propertyFile.properties");
		Properties prop = readProp.readProperties(getFilePath.getFilePath("src/test/resources/com/", "propertyFile.properties"));
		System.out.println(prop.getProperty("company"));
		
	}
	
	@Test
	public void readTwo() throws IOException {
		
		readJSON = new ReadJSONFileUtil();
		getFilePath = new GetFilePathUtil();
//		Object value = readJSON.getKey(readJSON.filetoJSONObject(System.getProperty("user.dir") + "\\src\\test\\resources\\com\\simpleJSONFile.json"), "job");
		Object value = readJSON.getKey(readJSON.JSONFile(getFilePath.getFilePath("src/test/resources/com/", "simpleJSONFile.json")), "job");
		System.out.println(value);
	}
	
	@Test
	public void readThree() throws IOException {
		
//		excelHelper = new ExcelHelper(System.getProperty("user.dir") + "\\src\\test\\resources\\com\\excelread.xlsx");
		getFilePath = new GetFilePathUtil();
		excelUtil = new ExcelFileUtil(getFilePath.getFilePath("src/test/resources/com/", "excelread.xlsx"));
		
		int columnCount = excelUtil.getColumnCount("Sheet1");
		System.out.println("Column count of Sheet1: "+columnCount);
		int rowCount = excelUtil.getRowCount("Sheet1");
		System.out.println("Row count of Sheet1: "+rowCount);
		
		System.out.println("Get Sheet1 Data (A1) :"+ excelUtil.getCellData("Sheet1", 0, 1));
		System.out.println("Get Sheet1 Data (B1) :"+ excelUtil.getCellData("Sheet1", 1, 1));
		
		System.out.println("Get Sheet1 Data (B2) :"+ excelUtil.getCellData("Sheet1", 1, 2));
		System.out.println("Get Sheet1 Data (C2) :"+ excelUtil.getCellData("Sheet1", 2, 2));
		
		String value = excelUtil.getCellData("Sheet2", 1, 1);
		System.out.println(value);
		
		System.out.println(excelUtil.getCellData("Sheet2", "Tool Name", 2));
		boolean result = excelUtil.setCellData("Sheet2", "Test", 2, "With Column name1");
		System.out.println(result);
		
		boolean result1 = excelUtil.setCellData("Sheet2", 2, 3, "With Column index1");
		System.out.println(result1);
		
	}

}
