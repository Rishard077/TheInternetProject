package com.code.testCases;

import com.code.pages.HomePage;
import com.code.pages.SignInPage;
import com.code.testBase.BaseTest;
import com.code.utilities.DataProviderClass;
import com.code.utilities.Utilities;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class LoginTest extends BaseTest {

//    @Test (dataProvider = "dp", dataProviderClass = Utilities.class)
//    public void doLogin(Hashtable<String,String> data){
//        HomePage homePage = new HomePage(driver);
//        homePage.goToSignInPage();
//        SignInPage signInPage = new SignInPage(driver);
//        signInPage.doLogin(data.get("username"), data.get("password"));
//    }

//    @Test(dataProvider = "csvData", dataProviderClass = Utilities.class)
//    public void loginTest(String[] data){
//        HomePage homePage = new HomePage(driver);
//        homePage.goToSignInPage();
//        SignInPage signInPage = new SignInPage(driver);
//        signInPage.doLogin(data[0], data[1]);
//    }

        @Test(dataProvider = "loginData", dataProviderClass = DataProviderClass.class)
        public void loginTest(String username,String password){
        HomePage homePage = new HomePage(driver);
        homePage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.doLogin(username,password);
    }


}
