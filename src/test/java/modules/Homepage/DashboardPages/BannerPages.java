package modules.Homepage.DashboardPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BannerPages {


    private WebDriver driver;
    private WebDriverWait wait;

    private By Banner = By.cssSelector("#reward-carousel .owl-item.active img");

    public BannerPages(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isBannerDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // wait for carousel
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reward-carousel")));

            System.out.println("Banner count: " + driver.findElements(Banner).size());

            WebElement bannerElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(Banner)
            );

            return bannerElement.isDisplayed();

        } catch (Exception e) {
            System.out.println("Banner NOT found: " + e.getMessage());
            return false;
        }
    }
}