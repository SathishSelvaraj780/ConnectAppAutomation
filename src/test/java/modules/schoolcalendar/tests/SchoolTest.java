package modules.schoolcalendar.tests;

import java.time.Duration;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.SeleniumTest;
import modules.login.pages.LoginPage;
import modules.schoolcalendar.pages.SchoolCalendar;

@Epic("School Calendar")
@Feature("View Calender")
public class SchoolTest extends SeleniumTest {
	@Severity(SeverityLevel.CRITICAL)
	@Description("Validate user can able to view the school calendar and search for events")
	@Test(groups = {"regression"})
	public void schoolCalendarModule() throws InterruptedException 
	
	{
	
	try
	
	{

		driver.get(config.getProperty("app.url"));

		LoginPage Login = new LoginPage(driver);
		Login.enterUsername(config.getProperty("test.username", "Faizal.a9"));
		Login.enterPassword(config.getProperty("test.password", "Welcome1234@"));
		Login.clickLogin();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("Home"));
		SchoolCalendar event = new SchoolCalendar(driver);		
		
		event.openAcademicsMenu();
		event.openSchoolCalendarMenu();
		event.clickUntilDesiredDate();
		event.clickEventName();
		event.closeEventPopUp();
		event.searchEvent();
		event.verifyNoSearchResults();
		Thread.sleep(3000);
		event.clickWeek();
		event.clickUntilDesiredDate2();
		event.clickMonth();
		event.navigateToMonth("Mar 2026");

wait.until(ExpectedConditions.visibilityOfElementLocated(
		By.id("txtSearchMonth")));
By EventName = By.xpath("//span[text()='Fee Payment Due Date for Mar-2026']");
//By EventName = By.xpath("//div[contains(@class,'event-wrap')]//span[contains(text(),'Fee Payment Due Date')]");
Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(EventName)).isDisplayed(),
    "Event Name not Displayed"
);
System.out.println("Event Name displayed Successfully");
	event.searchEventMonth();
		Thread.sleep(3000);
		
	}
		catch (Exception e) {

	        e.printStackTrace();

	        throw e;            
	}
	}
}
	