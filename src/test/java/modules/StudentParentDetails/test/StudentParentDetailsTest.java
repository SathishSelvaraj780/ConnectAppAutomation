package modules.StudentParentDetails.test;

import base.SeleniumTest;
import modules.StudentParentDetails.Page.StudentParentDetailsPage;
import modules.login.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class StudentParentDetailsTest extends SeleniumTest {

	@Test
	public void parentDetailsUpdate() throws Exception {

		try {

			// Login
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

			// Navigation
			StudentParentDetailsPage parentDetails =
					new StudentParentDetailsPage(driver);

			parentDetails.openRequestsMenu();
			parentDetails.openUpdateStudentDetailsMenu();

			Thread.sleep(3000);

			parentDetails.openParentDetailsMenu();

			System.out.println("Iframe count after opening Parent Details : "
					+ driver.findElements(By.tagName("iframe")).size());

			// Fee Sponsor & Preferred Contact
			parentDetails.selectFeeSponsor();
			parentDetails.selectPreferredContact("Email");

			// ==========================
			// Father Details
			// ==========================

			parentDetails.expandFatherSection();

			parentDetails.selectDropdownByText(
					"fatheR_NATIONALITY_ID",
					"British (United Kingdom)");

			parentDetails.selectDropdownByText(
					"fatheR_NATIONALITY_ID2",
					"Canadian (Canada)");

			parentDetails.selectDropdownByText(
					"fatheR_COUNTRY_ID",
					"United Arab Emirates");

			parentDetails.waitForDropdown("fatherEmirate");

			parentDetails.selectDropdownByText(
					"fatherEmirate",
					"Dubai");

			parentDetails.waitForDropdown("fatheR_AREA_ID");

			parentDetails.selectDropdownByText(
					"fatheR_AREA_ID",
					"Dubai Marina");

			parentDetails.enterStreet("ABC Street");
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

			// ==========================
			// Mother Details
			// ==========================

			parentDetails.expandMotherSection();
			parentDetails.scrollToMotherNationality();

			parentDetails.selectBootstrapDropdown(
					"motheR_NATIONALITY_ID",
					"British (United Kingdom)");

			parentDetails.selectBootstrapDropdown(
					"motheR_NATIONALITY_ID2",
					"Canadian (Canada)");

			parentDetails.selectBootstrapDropdown(
					"motheR_COUNTRY_ID",
					"United Arab Emirates");

			parentDetails.selectBootstrapDropdown(
					"motherEmirate",
					"Dubai");

			parentDetails.selectBootstrapDropdown(
					"motheR_AREA_ID",
					"Dubai Marina");

			parentDetails.enterMotherBuildingName("Blue Building");
			parentDetails.enterMotherApartmentNumber("A-101");
			parentDetails.enterMotherPoBoxNumber("12345");
			parentDetails.enterMotherFax("110220");

			parentDetails.enterMotherMobile("9638527400");
			parentDetails.enterMotherEmail("mother@gmail.com");
			parentDetails.enterMotherHomePhone("8754114964");
			parentDetails.enterMotherOfficePhone("523456789");

			parentDetails.enterMotherOccupation("Doctor");

			//parentDetails.selectMotherCompany("Wipro");
			System.out.println("Mother Details updated successfully.");

			// ==========================
// Guardian Details
// ==========================

			System.out.println(
					"Guardian count = " +
							driver.findElements(
											By.xpath("//button[.//span[contains(text(),'Parent Details (Guardian)')]]"))
									.size());

			parentDetails.expandGuardianSection();

			parentDetails.enterGuardianFirstName("Jon");
			parentDetails.enterGuardianMiddleName("Doe");
			parentDetails.enterGuardianLastName("Will");

// Nationality Details
			parentDetails.selectBootstrapDropdown(
					"guardiaN_NATIONALITY_ID",
					"British (United Kingdom)");

			parentDetails.selectBootstrapDropdown(
					"guardiaN_NATIONALITY_ID2",
					"Canadian (Canada)");

			parentDetails.selectBootstrapDropdown(
					"guardiaN_COUNTRY_ID",
					"United Arab Emirates");

			parentDetails.selectBootstrapDropdown(
					"guardianEmirate",
					"Dubai");

			parentDetails.selectBootstrapDropdown(
					"guardiaN_AREA_ID",
					"Dubai Marina");

// Address Details
			parentDetails.enterGuardianStreet("ABC Street");
// parentDetails.enterGuardianOtherArea("Chennai");

			parentDetails.enterGuardianVillaName("Blue Building");
			parentDetails.enterGuardianApartment("A-101");
			parentDetails.enterGuardianPoBox("12345");
			parentDetails.enterGuardianFax("110220");

// Contact Details
			parentDetails.enterGuardianMobile("0501234567");
			parentDetails.enterGuardianEmail("guardian@gmail.com");
			parentDetails.enterGuardianHomePhone("0501234567");
			parentDetails.enterGuardianOfficePhone("045678123");

// Occupation
			parentDetails.enterGuardianOccupation("Doctor");
			parentDetails.selectGuardianCompany("Infosys");

			System.out.println("Guardian Details updated successfully.");

			parentDetails.clickUpdateButton();
			String actualPopupMessage = parentDetails.handlepopupMessage();
			Assert.assertEquals(
					actualPopupMessage,"Updated successfully","Popup message mismatch after updating student details"
			);

		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
	}
}