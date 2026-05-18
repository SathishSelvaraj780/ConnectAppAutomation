package modules.schoolcalendar.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import base.SeleniumTest;

public class SchoolCalendar
{

	private WebDriver driver;
	private WebDriverWait wait;
	
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

public void searchEvent() throws InterruptedException
	
{

driver.findElement(By.xpath("//input[@placeholder='Search...']"))
    .sendKeys("2026" + Keys.ENTER);
Thread.sleep(5000);
}


public void verifyNoSearchResults()  {

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

    String expectedDate = "1st week of Apr 2026";

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


public void navigateToMonth(String expectedMonth) {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    By leftArrow = By.xpath("//span[@class='prevMonth']//a");
    By monthLabel = By.id("s_m");

    for (int i = 0; i < 12; i++) {

        String current = wait.until(
                ExpectedConditions.visibilityOfElementLocated(monthLabel)
        ).getText().trim();

        System.out.println("Current Month: " + current);

        if (current.equalsIgnoreCase(expectedMonth)) {
            System.out.println("✅ Reached: " + current);
            return;
        }

        // ✅ click
        WebElement arrow = wait.until(
                ExpectedConditions.elementToBeClickable(leftArrow)
        );
        arrow.click();

        // ✅ wait for month change
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBePresentInElementLocated(monthLabel, current)
        ));

        // ✅ small wait for data load (YOUR CASE)
        try { Thread.sleep(1500); } catch (Exception e) {}
    }

    throw new RuntimeException("Month not reached");
}

public void searchEventMonth() throws InterruptedException

{

driver.findElement(By.id("txtSearchMonth"))
      .sendKeys("2027" + Keys.ENTER);
Thread.sleep(5000);


}

}

		