package com.code.testCases;


import com.code.base.Page;
import com.code.pages.HomePage;
import com.code.testBase.BaseTest;
import org.testng.annotations.Test;



public class HomePageTest  extends BaseTest {


    @Test
    public void navigateToAuthPage()  {
        HomePage homePage = new HomePage(driver);
        homePage.goToSignInPage();

    }


}
