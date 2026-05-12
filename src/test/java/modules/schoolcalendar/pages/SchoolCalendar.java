package modules.schoolcalendar.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.SeleniumTest;

public class SchoolCalendar extends SeleniumTest
{

	private By Academics = By.xpath("//*[@data-menutext='Academics']");
	private By SchoolCalendar = By.xpath("//*[@data-menutext='School Calendar']");
	private By BackArrow = By.xpath("//*[name()='svg' and @alt='calendar arrow']");
	private By EventName = By.xpath("//span[contains(normalize-space(),'Academic Year End date')]");
	private By Week = By.xpath("//a[contains(text(),'WEEK')]");
	private By BackArrow2 = By.xpath("(//a[contains(@href,'getWeekCalender')])[1]");
    private By Month = By.xpath("//a[contains(text(), 'MONTH')]");
   
	
	public SchoolCalendar(WebDriver driver)

	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void openAcademicsMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(Academics)).click();
	}

	public void openSchoolCalendarMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(SchoolCalendar)).click();
	}
	
	//public void clickBackArrow() {
	//	wait.until(ExpectedConditions.elementToBeClickable(BackArrow)).click();
	//}


public void clickUntilDesiredDate() {

    String expectedDate = "Tue, 31 March 2026";

    while (true) {

        // ✅ Always get CURRENT visible date
        WebElement dateElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(@class,'cal-day')]")
            )
        );

        String currentDate = dateElement.getText().trim();
        System.out.println("Current Date: " + currentDate);

        // ✅ Break when matched
        if (currentDate.equals(expectedDate)) {
            System.out.println("Reached target date: " + currentDate);
            break;
        }

        // ✅ Click LEFT arrow (go backward)
        wait.until(ExpectedConditions.elementToBeClickable(BackArrow)).click();

        // ✅ Wait for date to update
        wait.until(ExpectedConditions.stalenessOf(dateElement));
    }
}

public void clickEventName() {
	wait.until(ExpectedConditions.elementToBeClickable(EventName)).click();
}

public void closeEventPopUp() {

    By modal = By.id("event_popup");
    wait.until(ExpectedConditions.visibilityOfElementLocated(modal));

    // Small pause for PDF load
    new WebDriverWait(driver, Duration.ofSeconds(2));


    // Step 3 — Now click the close button
    By closeBtn = By.xpath("//div[@id='event_popup']//div[@data-dismiss='modal']");
    WebElement close = wait.until(ExpectedConditions.elementToBeClickable(closeBtn));

    close.click();

    // Step 4 — Wait modal disappear
    wait.until(ExpectedConditions.invisibilityOfElementLocated(modal));
}

public void searchEvent()
	
{

driver.findElement(By.xpath("//input[@placeholder='Search...']"))
      .sendKeys("2026" + Keys.ENTER);


}


public void verifyNoSearchResults() {

    // Step 1: Enter invalid text
    WebElement searchBox = wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@placeholder='Search...']")
        )
    );

    searchBox.clear();
    searchBox.sendKeys("txtxt");
    searchBox.sendKeys(Keys.ENTER);

    // Step 2: Validate no results message
    WebElement message = wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//p[contains(text(),'No events for search')]")
        )
    );

    String actualText = message.getText().trim();
    String expectedText = "No events for search text for the day.";

    if (actualText.equals(expectedText)) {
        System.out.println("✅ No result message verified");
    } else {
        System.out.println("❌ Message mismatch");
    }
}

public void clickWeek()

{
	wait.until(ExpectedConditions.elementToBeClickable(Week)).click();
}

public void clickUntilDesiredDate2() {

    String expectedDate = "5th week of Mar 2026";

    while (true) {

        // ✅ Always get CURRENT visible date
        WebElement dateElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//strong[contains(text(),'week of')]")
            )
        );

        String currentDate = dateElement.getText().trim();
        System.out.println("Current Date: " + currentDate);

        // ✅ Break when matched
        if (currentDate.equals(expectedDate)) {
            System.out.println("Reached target date: " + currentDate);
            break;
        }

        // ✅ Click LEFT arrow (go backward)
        wait.until(ExpectedConditions.elementToBeClickable(BackArrow2)).click();

        // ✅ Wait for date to update
        wait.until(ExpectedConditions.stalenessOf(dateElement));
    }
}

public void clickMonth()

{
	wait.until(ExpectedConditions.elementToBeClickable(Month)).click();
}


public void clickUntilDesiredDate3() {

    String expectedMonth = "Mar 2026";

    while (true) {

        WebElement dateElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("s_m"))
        );

        String currentDate = dateElement.getText().trim();
        System.out.println("Current Month: " + currentDate);

        if (currentDate.equals(expectedMonth)) {
            System.out.println("Reached target month: " + currentDate);
            break;
        }

        By leftArrow = By.xpath(
            "//button[.//*[name()='svg' and contains(@src,'calendar-left-arrow-icon')]]"
        );

        WebElement arrow = wait.until(ExpectedConditions.visibilityOfElementLocated(leftArrow));

        // ✅ Scroll + JS click (fixes ALL click issues)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", arrow);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", arrow);

        // ✅ Wait for month change
        wait.until(ExpectedConditions.not(
            ExpectedConditions.textToBe(By.id("s_m"), currentDate)
        ));

    }
}


}
			