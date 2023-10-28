package com.code.pages;

import com.code.base.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {


	public HomePage(WebDriver driver){
		super(driver);
	}
	@FindBy (xpath="//a[contains(@href,'/login')]")
	public WebElement basicAuth;

   public SignInPage goToSignInPage(){
	   basicAuth.click();
	   return new SignInPage(driver);
   }


}
