package modules.Homepage.DashboardPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardRedirectionPages {

    private WebDriver driver;
    private WebDriverWait wait;

    private By QuicklinksActivities = By.xpath("(//button[contains(@onclick,'Activities/Home')])[1]");
    private By QuicklinksLeaveRequest = By.xpath("(//button[contains(@onclick,'Requests/LeaveRequest')])[1]");
    private  By ProfileCompletion = By.xpath("//a[contains(@class,'button') and contains(text(),'Complete Profile')]");
    private By SchoolFee = By.xpath("//button[contains(@class,'pay-now') and contains(@onclick,'/Fees/FeePayment?tab=schoolFee')]");
    private By Transportfee = By.xpath("//button[contains(@class,'pay-now') and contains(@onclick,'/Fees/FeePayment?tab=transportFee')]");
    private By NoticeBoard = By.xpath("//button[contains(@class,'owl-next')]");
    private By Attendance = By.xpath("//button[contains(@onclick, '/Child/Profile?tab=attendanceData')]");
    private By Reports = By.xpath("//*[@id=\"ddlReport\"]");
    private By ReportsDropdown = By.id("ddlReport");

    public DashboardRedirectionPages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    private void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    // Generic URL validation
    public boolean isOnExpectedPage(String expectedUrlPart) {
        wait.until(ExpectedConditions.urlContains(expectedUrlPart));
        return driver.getCurrentUrl().contains(expectedUrlPart);
    }

    // Actions + validations

    public boolean goToActivities() {
        click(QuicklinksActivities);
        return isOnExpectedPage("Activities/Home");
    }

    public boolean goToLeaveRequest() {
        click(QuicklinksLeaveRequest);
        return isOnExpectedPage("LeaveRequest");
    }

    public boolean goToProfileCompletion() {
        click(ProfileCompletion);
        return isOnExpectedPage("StudentDetails");
    }

    public boolean goToSchoolFee() {
        click(SchoolFee);
        return isOnExpectedPage("schoolFee");
    }

    public boolean goToTransportFee() {
        click(Transportfee);
        return isOnExpectedPage("transportFee");
    }

    public boolean goToAttendance() {
        click(Attendance);
        return isOnExpectedPage("attendanceData");
    }
}

