package modules.StudentParentDetails.Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    private By fatherAccordion = By.xpath("//button[.//span[contains(text(),'Parent Details - Primary contact (Father)')]]");
    
    
 // Street
    private By street = By.id("fatheR_STREET");

    // Other Area
    //private By otherArea = By.id("fatheR_AREA");

    // Change Location button
    private By changeLocation = By.xpath("//button[contains(@onclick,'openParentMapModal')]");

    // Building Name
    private By buildingName = By.id("fatheR_BLDG");

    // Apartment Number
    private By apartmentNumber = By.id("fatheR_APARTMENT");

    // P.O. Box Number
    private By poBoxNumber = By.id("fatheR_POBOX");

    // Fax
    private By fax = By.id("fatheR_FAX");

    // Father Mobile
    private By fatherMobile = By.id("fatheR_MOBILE");

    // Father Email
    private By fatherEmail = By.id("fatheR_EMAIL");

    // Home Phone
    private By homePhone = By.id("fatheR_RESIDENCE_PHONE");

    // Father's Office Number
    private By officePhone = By.id("fatheR_OFFICE_PHONE");

    // Father's Occupation
    private By occupation = By.id("fatheR_OCCUPATION");

    // Company Other textbox
    private By companyOther = By.id("fatheR_COMPANY");

    // How Long Have You Been Living In UAE dropdown
    private By livingInUAEButton =
            By.xpath("//button[@data-id='father']");

    private By livingInUAEOption(String value) {
        return By.xpath("//span[text()='" + value + "']");
    }

    //Locator For Mother Section
    
    private By motherAccordion = By.id("secondAccordion");

    private By motherStreet = By.id("motheR_STREET");
    private By motherBuildingName = By.id("motheR_BLDG");
    private By motherApartmentNumber = By.id("motheR_APARTMENT");
    private By motherPoBoxNumber = By.id("motheR_POBOX");
    private By motherFax = By.id("motheR_FAX");
    private By motherMobile = By.id("motheR_MOBILE");
    private By motherEmail = By.id("motheR_EMAIL");
    private By motherHomePhone = By.id("motheR_RESIDENCE_PHONE");
    private By motherOfficePhone = By.id("motheR_OFFICE_PHONE");
    private By motherOccupation = By.id("motheR_OCCUPATION");
    private By motherCompany = By.id("motheR_COMPANY");
    
    
    
    
    
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
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.id("stu_PREFCONTACT")));

        Select preferredContact = new Select(preferredContactElement);
        preferredContact.selectByVisibleText(contactType);
    }
    
    public void expandFatherSection() {

        wait.until(ExpectedConditions.elementToBeClickable(
                fatherAccordion)).click();
    }
    
    public void selectBootstrapDropdown(String fieldId, String value) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {

            WebElement dropdown = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[@data-id='" + fieldId + "']")));

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView({block:'center'});",
                            dropdown);
            ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();",
                    dropdown);
            Thread.sleep(2000);

            System.out.println("Open dropdown count = " +
                driver.findElements(
                    By.xpath("//div[contains(@class,'dropdown-menu') and contains(@class,'show')]")
                ).size());
            WebElement option = wait.until(
            	    ExpectedConditions.elementToBeClickable(
            	        By.xpath(
            	            "//span[@class='text' and normalize-space()='"
            	            + value + "']")));

            ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", option);

            option.click();

            System.out.println("Selected " + fieldId + " -> " + value);

        } 
        
        catch (Exception e) {

            throw new RuntimeException(
                    "Unable to select '" + value +
                    "' from dropdown '" + fieldId + "'", e);
        }
    }
    
    public void selectDropdownByText(String id, String value) {

        WebElement element =
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.id(id)));

        Select select = new Select(element);

        select.selectByVisibleText(value);

        System.out.println("Selected " + id + " -> " + value);
    }
    
    public void selectDropdown(By locator, String visibleText) {

        WebElement dropdownElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));

        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }
    
    public void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    
    public void waitForDropdown(String fieldId) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@data-id='" + fieldId + "']")));
    }
    
    public void enterText(By locator, String value) {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(locator));

        element.sendKeys(Keys.CONTROL + "a");

        element.sendKeys(Keys.DELETE);

        element.sendKeys(value);
    }
    
    
    public void enterStreet(String value) {
        enterText(street, value);
    }

  //  public void enterOtherArea(String value) {
    //    enterText(otherArea, value);
    //}

    public void clickChangeLocation() {
        clickElement(changeLocation);
    }

    public void enterBuildingName(String value) {
        enterText(buildingName, value);
    }

    public void enterApartmentNumber(String value) {
        enterText(apartmentNumber, value);
    }

    public void enterPoBoxNumber(String value) {
        enterText(poBoxNumber, value);
    }

    public void enterFax(String value) {
        enterText(fax, value);
    }

    public void enterFatherMobile(String value) {
        enterText(fatherMobile, value);
    }

    public void enterFatherEmail(String value) {
        enterText(fatherEmail, value);
    }

    public void enterHomePhone(String value) {
        enterText(homePhone, value);
    }

    public void enterOfficePhone(String value) {
        enterText(officePhone, value);
    }

    public void enterOccupation(String value) {
        enterText(occupation, value);
    }

    public void selectCompany(String companyName) throws InterruptedException {

        WebElement company = wait.until(
                ExpectedConditions.elementToBeClickable(companyOther));

        company.click();

        company.sendKeys(Keys.CONTROL + "a");
        company.sendKeys(Keys.DELETE);

        company.sendKeys(companyName);

        Thread.sleep(2000);

        company.sendKeys(Keys.ARROW_DOWN);
        company.sendKeys(Keys.ENTER);
        
        Thread.sleep(1000);

        new Actions(driver)
        .moveByOffset(10, 10)
        .click()
        .perform();

Thread.sleep(1000);
    }
    
    public void selectLivingInUAE(String value) {

        WebElement dropdown =
                driver.findElement(By.id("father"));

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].style.display='block';",
                dropdown);

        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
    }
    
    //Methods for mother section
    
    public void expandMotherSection() throws InterruptedException {

        WebElement motherSection =
            wait.until(ExpectedConditions.presenceOfElementLocated(
                motherAccordion));

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            motherSection);

        Thread.sleep(2000);

        ((JavascriptExecutor) driver).executeScript(
            "window.scrollBy(0,500);");

        Thread.sleep(2000);

        motherSection.click();
    }

    public void enterMotherStreet(String value) {
        enterText(motherStreet, value);
    }

    public void enterMotherBuildingName(String value) {
        enterText(motherBuildingName, value);
    }

    public void enterMotherApartmentNumber(String value) {
        enterText(motherApartmentNumber, value);
    }

    public void enterMotherPoBoxNumber(String value) {
        enterText(motherPoBoxNumber, value);
    }

    public void enterMotherFax(String value) {
        enterText(motherFax, value);
    }

    public void enterMotherMobile(String value) {
        enterText(motherMobile, value);
    }

    public void enterMotherEmail(String value) {
        enterText(motherEmail, value);
    }

    public void enterMotherHomePhone(String value) {
        enterText(motherHomePhone, value);
    }

    public void enterMotherOfficePhone(String value) {
        enterText(motherOfficePhone, value);
    }

    public void enterMotherOccupation(String value) {
        enterText(motherOccupation, value);
    }
    
    public void selectMotherCompany(String companyName)
            throws InterruptedException {

        WebElement company = wait.until(
                ExpectedConditions.elementToBeClickable(
                        motherCompany));

        company.click();

        company.sendKeys(Keys.CONTROL + "a");
        company.sendKeys(Keys.DELETE);

        company.sendKeys(companyName);

        Thread.sleep(2000);

        company.sendKeys(Keys.ARROW_DOWN);
        company.sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        new Actions(driver)
                .moveByOffset(10, 10)
                .click()
                .perform();
    }
    
}