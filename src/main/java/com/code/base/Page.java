package com.code.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.code.utilities.ExcelReader;
import com.code.utilities.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

	public static WebDriver driver;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static Logger log = Logger.getLogger("devpinoyLogger");


	public Page(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}


	public static void waitForElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElementToBePresent(WebElement element) {
		 wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public static void click(WebElement element) {

		element.click();
//		log.debug("Clicking on an Element : "+element);
//		test.log(LogStatus.INFO, "Clicking on : " + element);
	}

	
	public static void type(WebElement element, String value) {

		element.sendKeys(value);

//		log.debug("Typing in an Element : "+element+" entered value as : "+value);
//
//		test.log(LogStatus.INFO, "Typing in : " + element + " entered value as " + value);

	}

	

}
