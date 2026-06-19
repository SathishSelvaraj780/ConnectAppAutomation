package utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData()
            throws Exception {

        return ExcelUtils.getTestData(
                "src/test/resources/testdata/LoginData.xlsx",
                "Login");
    }
}
