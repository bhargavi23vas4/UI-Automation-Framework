package com.ui.dataproviders;

import static com.utility.CSVReaderUtility.readCSVFile;
import static com.utility.ExcelReaderUtility.readExcelData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;

public class LoginDataProvider {
	
	
	@DataProvider(name="LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
		
		Gson gson=new Gson();
		File testDataFile=new File(System.getProperty("user.dir")+"//testData//logindata.json");
		FileReader fileReader=new FileReader(testDataFile);
		TestData testData=gson.fromJson(fileReader, TestData.class);
		
		List<Object[]> dataToReturn=new ArrayList<Object[]>();
		
		
		
		for(User user:testData.getData()) {
			dataToReturn.add(new Object[] {user});	
		}
		
		return dataToReturn.iterator();
	}
	
	@DataProvider(name="LoginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvider() throws FileNotFoundException {
		return readCSVFile("loginData.csv");

}
	
	@DataProvider(name="LoginTestExcelDataProvider")
	public Iterator<User> loginExcelDataProvider() throws InvalidFormatException, IOException {
		return readExcelData("LoginData.xlsx");

}
	
}