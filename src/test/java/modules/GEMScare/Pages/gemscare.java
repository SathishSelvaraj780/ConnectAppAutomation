package modules.GEMScare.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class gemscare {

    private WebDriver driver;
    private WebDriverWait wait;

    private By Topmenu = By.xpath("//*[@data-menutext='Requests']");
    private By GemsCareMenu = By.xpath("//*[@data-menutext='GEMS Care']");
    private By SelectEmploymentType = By.xpath("//button[@data-id=\"FEmploymentType\"]");
    private By Resasonfordifficulty = By.xpath("//button[@data-id=\"FReason\"]");
    private By NationalID = By.xpath("//input[@id=\"FNationalId\"]");
    private By CompanyName = By.xpath("//input[@id=\"FCompanyName\"]");
    private By Position = By.xpath("//input[@id=\"FPosition\"]");
    private By EmployedSinceDate = By.xpath("//input[@id=\"FEmployedSince\"]");
    private By ManagerName = By.xpath("//input[@id=\"FManagersName\"]");
    private By OfficeTelephone = By.xpath("//input[@id=\"FOfficalTelephone\"]");
    private By PrimaryBankName = By.xpath("//input[@id=\"FPrimaryBankName\"]");
    private By SelectMotherEmploymentType = By.xpath("//button[@data-id=\"MEmploymentType\"]");
    private By MResasonfordifficulty = By.xpath("//button[@data-id=\"MReason\"]");
    private By MNationalID = By.xpath("//input[@id=\"MNationalId\"]");
    private By MCompanyName = By.xpath("//input[@id=\"MCompanyName\"]");
    private By MPosition = By.xpath("//input[@id=\"MPosition\"]");
    private By MEmployedSince = By.xpath("//input[@id=\"MEmployedSince\"]");
    private By MMangername = By.xpath("//input[@id=\"MManagersName\"]");
    private By MOfficeTelephone = By.xpath("//input[@id=\"MOfficeTelephone\"]");
    private By MPrimaryBankName = By.xpath("//input[@id=\"MPrimaryBankName\"]");



    public void fillLoanDetails(int rowIndex,
                                String loanType,
                                String balanceRemaining,
                                String monthlyPayment,
                                String bankName) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        // =========================
        // Select Loan Type
        // =========================

        WebElement loanDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//select[contains(@name,'LoanType')]/following-sibling::button)[" + rowIndex + "]")
                )
        );

        loanDropdown.click();

        WebElement loanOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='" + loanType + "']")
                )
        );

        loanOption.click();

        // =========================
        // Balance Remaining
        // =========================

        WebElement balanceField = driver.findElement(
                By.xpath("(//input[contains(@name,'BalanceRemaining')])[" + rowIndex + "]")
        );

        balanceField.clear();
        balanceField.sendKeys(balanceRemaining);

        // =========================
        // Monthly Payment
        // =========================

        WebElement monthlyPaymentField = driver.findElement(
                By.xpath("(//input[contains(@name,'MonthlyPayment')])[" + rowIndex + "]")
        );

        monthlyPaymentField.clear();
        monthlyPaymentField.sendKeys(monthlyPayment);

        // =========================
        // Bank Name
        // =========================

        WebElement bankNameField = driver.findElement(
                By.xpath("(//input[contains(@name,'BankName')])[" + rowIndex + "]")
        );

        bankNameField.clear();
        bankNameField.sendKeys(bankName);
    }
    }
