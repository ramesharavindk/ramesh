package com.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
 public static WebDriver driver;
 
 public static Workbook w;
 
 public static WebDriver getDriver() {
	 
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramesh Aravind\\eclipse-TestNG\\Excel\\driver\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 return driver;
	 
 }
 
 public static void loadurl(String url) {
	 driver.get(url);
	
}

 public void type(WebElement element, String name) {
	 element.sendKeys(name);
	}

 public static String getdata(String sheetname, int rowNo, int cellNo) throws IOException {
	 File loc = new File("C:\\Users\\Ramesh Aravind\\eclipse-TestNG\\ExcelMaven\\TestData-Excel\\TestData.xlsx");
	 FileInputStream fs =  new FileInputStream(loc);
	 Workbook w = new XSSFWorkbook(fs);
	 
	 Sheet s = w.getSheet(sheetname);
	 Row r = s.getRow(rowNo);
	 Cell c = r.getCell(cellNo);
	 //c.setCellValue(sheetname);
	 int type = c.getCellType();
	 String name = null;
	 if(type==1) {
		 name = c.getStringCellValue();
	 }
	 if(type==0) {
	if(DateUtil.isCellDateFormatted(c)) {
	name = new SimpleDateFormat("dd-MM-yyyy").format(c.getDateCellValue());
	 } else {
		 name = String.valueOf((long)c.getNumericCellValue());
	 }
	 }
	 return name;
		 }	
 
 public static String createnewexcelanddata(String loc, String name, int rowNo, int cellNo, String sheetname) throws Throwable {
	 //File loc = new File("C:\\Users\\Ramesh Aravind\\eclipse-TestNG\\ExcelMaven\\TestData-Excel\\NewTestData.xlsx");
	 //FileInputStream fs =  new FileInputStream(loc);
	 Workbook w = new XSSFWorkbook();
	 FileOutputStream fo = new FileOutputStream(loc);
	 
	 
	 Sheet s = w.createSheet(sheetname);
	 Row r = s.createRow(rowNo);
	 Cell c = r.createCell(cellNo);
	 c.setCellValue(name);
	 w.write(fo);
	 fo.close();
	 
	// FileOutputStream fo = new FileOutputStream(loc);
	 //w.write(fo);
	 
	 System.out.println("Create data in Excel Done !!!");
	 return null;
	 	 
 }
 
 public static String updatedata(String previousname, String updatename, int rowNo, int cellNo, String sheetname) throws Throwable {
	 File loc = new File("C:\\Users\\Ramesh Aravind\\eclipse-TestNG\\ExcelMaven\\TestData-Excel\\TestData.xlsx");
	 FileInputStream fs =  new FileInputStream(loc);
	 Workbook w = new XSSFWorkbook(fs);
	 
	 Sheet s = w.getSheet(sheetname);
	 Row r = s.getRow(rowNo);
	 Cell c = r.getCell(cellNo);
	 String name = c.getStringCellValue();
	 if(name.equals(previousname)) {
		 c.setCellValue(updatename);
	 }
	 
	 FileOutputStream fo = new FileOutputStream(loc);
	 w.write(fo);
	 
	 System.out.println("update data in Excel Done !!!");
	 return null;
	 	 
 }
 
 public static String deletecell(String previousname, String updatename, int rowNo, int cellNo, String sheetname) throws Throwable {
	 File loc = new File("C:\\Users\\Ramesh Aravind\\eclipse-TestNG\\ExcelMaven\\TestData-Excel\\TestData.xlsx");
	 FileInputStream fs =  new FileInputStream(loc);
	 Workbook w = new XSSFWorkbook(fs);
	 
	 Sheet s = w.getSheet(sheetname);
	 Row r = s.getRow(rowNo);
	 //Cell c = r.getCell(cellNo);
	 r.removeCell(r.getCell(cellNo));
	 FileOutputStream fo = new FileOutputStream(loc);
	 w.write(fo);
	 
	 System.out.println("Cell data is removed !!!");
	 return null;
	 	 
 }
	 
 }
