package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {
	
	public static Iterator<User> readExcelData(String excelFile)  {
		
		File file=new File(System.getProperty("user.dir")+"//testData//"+excelFile);
//		XLSX File
		List<User> userList=null;
		
		XSSFWorkbook workbook = null;
		XSSFSheet sheet;
		Iterator<Row> iterator;
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		User user;
		try {
			userList=new ArrayList<User>();
			workbook = new XSSFWorkbook(file);
			sheet=workbook.getSheet("LoginTestData");
			iterator=sheet.iterator();
			iterator.next();
			while(iterator.hasNext()) {
				row= iterator.next();
				emailAddressCell=row.getCell(0);
				passwordCell=row.getCell(1);
				user=new User(emailAddressCell.toString(),passwordCell.toString());
				userList.add(user);
				workbook.close();
			}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();
		
	}

}
