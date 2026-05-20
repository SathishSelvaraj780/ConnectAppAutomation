package modules.Activities.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activities {
	
	
	private WebDriver driver;
	private WebDriverWait wait;


	private By Activities = By.xpath("//*[@data-menutext='Activities']");
	
	
	public Activities(WebDriver driver)

	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	

	public void openActivitiesMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(Activities)).click();
	}
	
}
