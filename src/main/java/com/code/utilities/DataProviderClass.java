package com.code.utilities;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

  @DataProvider(name = "loginData")
    public Object[][] loginData() {
        // Read data from the Excel spreadsheet and return as a 2D array
        // Example: Read usernames and passwords from the Excel file
        Object[][] data = {
                {"tomsmith", "SuperSecretPassword!"},
                // Add more data as needed
        };
        return data;
    }
}
