package modules.StudentParentDetails.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.SeleniumTest;
import modules.StudentParentDetails.Page.StudentParentDetailsPage;
import modules.login.pages.LoginPage;

public class StudentParentDetailsTest extends SeleniumTest {

    @Test
    public void ParentDetailsUpdate() throws Exception {

        try {

            driver.get(config.getProperty("app.url"));

            LoginPage login = new LoginPage(driver);

            login.enterUsername(
                    config.getProperty("test.username", "Faizal.a9"));

            login.enterPassword(
                    config.getProperty("test.password", "Welcome1234@"));

            login.clickLogin();

            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(30));

            wait.until(ExpectedConditions.urlContains("Home/Home"));

            StudentParentDetailsPage parentDetails =
                    new StudentParentDetailsPage(driver);

            parentDetails.openRequestsMenu();

            parentDetails.openUpdateStudentDetailsMenu();

            Thread.sleep(5000);

            parentDetails.openParentDetailsMenu();

            System.out.println("Iframe count after opening Parent Details : "
                    + driver.findElements(By.tagName("iframe")).size());

          parentDetails.selectFeeSponsor();

          parentDetails.selectPreferredContact("Email");
          Thread.sleep(5000);

          parentDetails.expandFatherSection();
          Thread.sleep(5000);
          parentDetails.selectDropdownByText(
        	        "fatheR_NATIONALITY_ID",
        	        "British (United Kingdom)");

        	parentDetails.selectDropdownByText(
        	        "fatheR_NATIONALITY_ID2",
        	        "Canadian (Canada)");

        	parentDetails.selectDropdownByText(
        	        "fatheR_COUNTRY_ID",
        	        "United Arab Emirates");

        	// Wait for city dropdown to refresh
        	parentDetails.waitForDropdown("fatherEmirate");

        	parentDetails.selectDropdownByText(
        	        "fatherEmirate",
        	        "Dubai");
        	// Wait for area dropdown to refresh
        	parentDetails.waitForDropdown("fatheR_AREA_ID");

        	parentDetails.selectDropdownByText(
        	        "fatheR_AREA_ID",
        	        "Dubai Marina");
        	
        	Thread.sleep(5000);
        	
        	parentDetails.enterStreet("ABC Street");

        //	parentDetails.enterOtherArea("Chennai");

        	parentDetails.enterBuildingName("Blue Building");

        	parentDetails.enterApartmentNumber("A-101");

        	parentDetails.enterPoBoxNumber("12345");

        	parentDetails.enterFax("110220");

        	parentDetails.enterFatherMobile("9638527400");

        	parentDetails.enterFatherEmail("test@gmail.com");

        	parentDetails.enterHomePhone("8754114964");

        	parentDetails.enterOfficePhone("523456789");

        	parentDetails.enterOccupation("Doctor");

        	parentDetails.selectCompany("Wipro");

        	parentDetails.selectLivingInUAE("3 - 5 Years");
        	
          	Thread.sleep(5000);
          	
          	//Method calling for Mother section
          	
          	parentDetails.expandMotherSection();

          	Thread.sleep(3000);
          	

System.out.println(
    "Mother nationality dropdown count = " +
    driver.findElements(
        By.xpath("//button[@data-id='motheR_NATIONALITY_ID']")
    ).size());

WebElement motherNationalityButton =
driver.findElement(
    By.xpath("//button[@data-id='motheR_NATIONALITY_ID']")
);

((JavascriptExecutor) driver).executeScript(
"arguments[0].scrollIntoView({block:'center'});",
motherNationalityButton);

Thread.sleep(3000);


parentDetails.selectBootstrapDropdown(
        "motheR_NATIONALITY_ID",
        "British (United Kingdom)");

parentDetails.selectBootstrapDropdown(
        "motheR_NATIONALITY_ID2",
        "Canadian (Canada)");

parentDetails.selectBootstrapDropdown(
        "motheR_COUNTRY_ID",
        "United Arab Emirates");
          	parentDetails.waitForDropdown("motherEmirate");

          	parentDetails.selectDropdownByText(
          	        "motherEmirate",
          	        "Dubai");

          	parentDetails.waitForDropdown("motheR_AREA_ID");

          	parentDetails.selectDropdownByText(
          	        "motheR_AREA_ID",
          	        "Dubai Marina");
          	
          	parentDetails.enterMotherStreet("ABC Street");

          	parentDetails.enterMotherBuildingName("Blue Building");

          	parentDetails.enterMotherApartmentNumber("A-101");

          	parentDetails.enterMotherPoBoxNumber("12345");

          	parentDetails.enterMotherFax("110220");

          	parentDetails.enterMotherMobile("9638527400");

          	parentDetails.enterMotherEmail("mother@gmail.com");

          	parentDetails.enterMotherHomePhone("8754114964");

          	parentDetails.enterMotherOfficePhone("523456789");

          	parentDetails.enterMotherOccupation("Doctor");

          	parentDetails.selectMotherCompany("Wipro");
        } 
        
        catch (Exception e) {

            e.printStackTrace();
            throw e;
        }
    }
}