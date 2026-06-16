package modules.StudentParentDetails.Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentParentDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By Topmenu = By.xpath("//*[@data-menutext='Requests']");
    private By UpdateStudentDetailsMenu = By.xpath("//*[@data-menutext='Update Student Details']");
    private By ParentDetailsTab = By.xpath("//a[normalize-space()='Parent Details']");
    private By FeeSponsor = By.id("feeSponsor");

    // Constructor
    public StudentParentDetailsPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void openRequestsMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(Topmenu)).click();
    }

    public void openUpdateStudentDetailsMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(UpdateStudentDetailsMenu)).click();
    }

    public void openParentDetailsMenu()
    {
        wait.until(ExpectedConditions.elementToBeClickable(ParentDetailsTab)).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("feeSponsor")));
    }

    public void selectFeeSponsor()
    {
        WebElement feeSponsorElement =
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        FeeSponsor));

        Select feeSponsor = new Select(feeSponsorElement);
        feeSponsor.selectByVisibleText("Mother");
    }

    public void selectPreferredContact(String contactType) {

        WebElement preferredContactElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("stu_PREFCONTACT")));

        Select preferredContact = new Select(preferredContactElement);
        preferredContact.selectByVisibleText(contactType);
    }
}