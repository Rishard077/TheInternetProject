package com.code.utilities;

import com.code.base.Page;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import static com.code.base.Page.driver;
import static com.code.base.Page.excel;


public class Utilities  {

	public static String screenshotPath;
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

	}

//	@DataProvider(name="dp")
//	public Object[][] getData(Method m) {
//
//		String sheetName = m.getName();
//		int rows = excel.getRowCount(sheetName);
//		int cols = excel.getColumnCount(sheetName);
//
//		Object[][] data = new Object[rows - 1][1];
//
//		Hashtable<String,String> table = null;
//
//		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2
//
//			table = new Hashtable<String,String>();
//
//			for (int colNum = 0; colNum < cols; colNum++) {
//
//				// data[0][0]
//				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
//				data[rowNum - 2][0] = table;
//			}
//
//		}
//
//		return data;
//
//	}

	@DataProvider(name = "dp") // to read excel data
	public Object[][] getData(Method m) {
		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		// Check for empty or invalid Excel sheets
		if (rows <= 1 || cols <= 0) {
			return new Object[0][0]; // Return an empty 2D array
		}

		Object[][] data = new Object[rows - 1][1];
		Hashtable<String, String> table;

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			table = new Hashtable<String, String>();

			for (int colNum = 0; colNum < cols; colNum++) {
				// Verify the column number is within the range
				if (colNum < cols) {
					table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				}
			}

			data[rowNum - 2][0] = table;
		}

		return data;
	}

	@DataProvider(name = "loginData")
	public Object[][] loginData() {
		// Read data from the Excel spreadsheet and return as a 2D array
		// Example: Read usernames and passwords from the Excel file
		Object[][] data = {
				{"user1", "password1"},
				{"user2", "password2"},
				// Add more data as needed
		};
		return data;
	}
	@DataProvider(name = "csvData")
	public Object[][] readCSVData() {
		String csvFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\csv\\testdata.xlsx";

		List<String[]> data = new ArrayList<>();

		try (CSVReader reader = new CSVReaderBuilder(new FileReader(csvFilePath))
				.withSkipLines(1) // Skip the header row
				.build()) {
			String[] line;
			while ((line = reader.readNext()) != null) {
				data.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvValidationException e) {
			throw new RuntimeException(e);
		}

		Object[][] testData = new Object[data.size()][1];

		for (int i = 0; i < data.size(); i++) {
			testData[i][0] = data.get(i);
		}

		return testData;
	}



	public static boolean isTestRunnable(String testName, ExcelReader excel){

		String sheetName="test_suite";
		int rows = excel.getRowCount(sheetName);


		for(int rNum=2; rNum<=rows; rNum++){

			String testCase = excel.getCellData(sheetName, "TCID", rNum);

			if(testCase.equalsIgnoreCase(testName)){

				String runmode = excel.getCellData(sheetName, "Runmode", rNum);

				if(runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}


		}
		return false;
	}

}
