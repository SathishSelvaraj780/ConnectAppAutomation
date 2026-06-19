package modules.GEMScare.Pages;

import org.openqa.selenium.*;
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


    public gemscare(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterText(By locator, String value) {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(locator));

        element.sendKeys(Keys.CONTROL + "a");

        element.sendKeys(Keys.DELETE);

        element.sendKeys(value);
    }

    public void clickRequestsmenu(){
        wait.until(ExpectedConditions.elementToBeClickable(Topmenu)).click();
    }

    public void clickGemsCareMenu(){
        wait.until(ExpectedConditions.elementToBeClickable(GemsCareMenu)).click();
    }

    public void enterPosition(String position){
        enterText(Position, position);
    }

    public void enterEmployedsince(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('FEmployedSince').value='01/Jan/2020';");
    }

    public void enterManagerName(String name){
        enterText(ManagerName, name);
    }

    public void enterOfficeTelephone(String telephone){
        enterText(OfficeTelephone, telephone);
    }

    public void enterPrimaryBankName(String name){
        enterText(PrimaryBankName, name);
    }

    public void selectMotherEmploymentType(){
        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(SelectMotherEmploymentType));

        dropdown.click();

        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='Salaried']")
                )
        );

        option.click();

    }

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

    public void fillmonthlyexpenses(String expenseName, String amount, String employerAmount ){
        By amountTxt = By.xpath(
                "//td[contains(normalize-space(),'" + expenseName + "')]" +
                        "/following-sibling::td[1]//input");

        By employerAmountTxt = By.xpath(
                "//td[contains(normalize-space(),'" + expenseName + "')]" +
                        "/following-sibling::td[2]//input");

        driver.findElement(amountTxt).clear();
        driver.findElement(amountTxt).sendKeys(amount);

        driver.findElement(employerAmountTxt).clear();
        driver.findElement(employerAmountTxt).sendKeys(employerAmount);
    }
    public void enterReferenceDetails(int rowNo,
                                      String name,
                                      String mobileNo,
                                      String email,
                                      String relation) {

        // Name
        driver.findElement(By.xpath(
                        "(//input[contains(@name,'ReferencesName')])[" + rowNo + "]"))
                .sendKeys(name);

        // Mobile Number
        driver.findElement(By.xpath(
                        "(//input[contains(@name,'ReferencesMobileNumber')])[" + rowNo + "]"))
                .sendKeys(mobileNo);

        // Email Address
        driver.findElement(By.xpath(
                        "(//input[contains(@name,'ReferencesEmailAddress')])[" + rowNo + "]"))
                .sendKeys(email);

        // Relation
        driver.findElement(By.xpath(
                        "(//input[contains(@name,'ReferencesRelation')])[" + rowNo + "]"))
                .sendKeys(relation);
    }

    public void openAccordion(String accordionName) {
        By accordion = org.openqa.selenium.By.xpath(
                "//button[contains(@class,'custom-accordion') and contains(.,'"
                        + accordionName + "')]");

        WebElement accordionElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(accordion));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        accordionElement);

        wait.until(ExpectedConditions.elementToBeClickable(accordionElement))
                .click();
    }

    }
