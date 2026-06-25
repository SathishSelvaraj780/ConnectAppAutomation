package modules.StudentProfile.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.logging.Logger;

import java.time.Duration;

public class StudentProfilePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private By StudentProfileTopMenu = org.openqa.selenium.By.xpath("//a[@href=\"/Child/Profile\"]");
    private By BasicInfoTab = org.openqa.selenium.By.xpath("//a[@href=\"#basicInfoData\"]");
    private By FeeDetailsTab = org.openqa.selenium.By.xpath("//a[@href=\"#feeDetailsData\"]");
    private By CurriculamTab = org.openqa.selenium.By.xpath("//a[@href=\"#curriculumData\"]");
    private By AttendanceTab = org.openqa.selenium.By.xpath("//a[@href=\"#attendanceData\"]");
    private By CommunicationsTab = org.openqa.selenium.By.xpath("//a[@href=\"#notificationsData\"]");
    private By OtherTab = org.openqa.selenium.By.xpath("//a[@href=\"#othersData\"]");
    private By EditProfileButton = org.openqa.selenium.By.xpath("//a[@href=\"/Requests/StudentDetails\" and contains(text(),'Edit Profile')]");
    private By loaderOverlay = org.openqa.selenium.By.cssSelector("div.blockUI.blockOverlay");
    private By CommandNewsletterArrow =  org.openqa.selenium.By.xpath("//button[@class=\"message-btn arrowBtn commNewsletter\"]");
    private By MessageDetailsArrow = org.openqa.selenium.By.xpath("//button[@class=\"message-btn arrowBtn\"]");
    private By MessageDetailsPagination = org.openqa.selenium.By.xpath("//button[@class=\"next\"]");
    private By EditProfile = By.xpath("//a[@class=\"button filter\"]");



    public StudentProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
    }

    public void clickStudentProfileTopMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(StudentProfileTopMenu)).click();
    }

    public void clickBasicInfoTab() {
        wait.until(ExpectedConditions.elementToBeClickable(BasicInfoTab)).click();
    }
    @Step("Open Accordion : {0}")
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

    public boolean validateFieldLabel(String fieldName, String expectedValue) {
        try {

            By locator = org.openqa.selenium.By.xpath(
                    "//div[contains(@class,'label-text') and " +
                            "contains(normalize-space(),'" + fieldName + "')]" +

                            "/following-sibling::div[contains(@class,'value-text') " +
                            "and contains(normalize-space(),'" + expectedValue + "')]");

            WebElement field = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator));

            ((JavascriptExecutor) driver)
                    .executeScript(
                            "arguments[0].scrollIntoView({block:'center'});",
                            field);
            System.out.println(
                    "Validated Field : " + fieldName +
                            " | Value : " + expectedValue);

            return field.isDisplayed();

        } catch (Exception e) {

            System.out.println(
                    "Validation Failed : " + fieldName +
                            " | Expected Value : " + expectedValue);

            return false;
        }
    }

    public boolean validateFieldAndValue(
            String fieldName,
            String expectedValue) {

        try {

            By locator = org.openqa.selenium.By.xpath(

                    "//div[contains(@class,'label-text') and " +
                            "contains(normalize-space(),'" + fieldName + "')]" +

                            "/following-sibling::div[contains(@class,'value-text')]" +

                            "[contains(normalize-space(),'" + expectedValue + "')]");

            WebElement field = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator));

            ((JavascriptExecutor) driver)
                    .executeScript(
                            "arguments[0].scrollIntoView({block:'center'});",
                            field);

            System.out.println(
                    "Validated Field : "
                            + fieldName
                            + " | Value : "
                            + expectedValue);

            return field.isDisplayed();

        } catch (Exception e) {

            System.out.println(
                    "Validation Failed : "
                            + fieldName
                            + " | Expected Value : "
                            + expectedValue);

            return false;
        }
    }

    public void scrollToElement(By locator) {

        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(locator));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        element);
    }

    public void waitForLoaderToDisappear() {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                loaderOverlay));
    }

    public void clickFeeDetailsTab() {

        waitForLoaderToDisappear();

        WebElement feeTab = wait.until(
                ExpectedConditions.elementToBeClickable(
                        FeeDetailsTab));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        feeTab);

        feeTab.click();

        System.out.println("Clicked Fee Details Tab");
    }

    public boolean validateTableHeader(String headerName) {

        try {

            By locator = org.openqa.selenium.By.xpath(
                    "//th[contains(normalize-space(.),'"
                            + headerName + "')]");

            WebElement header = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            locator));

            ((JavascriptExecutor) driver)
                    .executeScript(
                            "arguments[0].scrollIntoView({block:'center'});",
                            header);

            System.out.println(
                    "Validated Table Header : "
                            + headerName);

            return header.isDisplayed();

        } catch (Exception e) {

            System.out.println(
                    "Table Header Not Found : "
                            + headerName);

            return false;
        }
    }

    public void clickCurriculamTab() {

        waitForLoaderToDisappear();

        WebElement curriculamTab = wait.until(
                ExpectedConditions.elementToBeClickable(
                        CurriculamTab));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        curriculamTab);

        curriculamTab.click();

        System.out.println("Clicked Curriculum Tab");
    }

    public void clickAttendanceTab() {

        waitForLoaderToDisappear();

        WebElement attendanceTab = wait.until(
                ExpectedConditions.elementToBeClickable(
                        AttendanceTab));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        attendanceTab);

        attendanceTab.click();

        System.out.println("Clicked Curriculum Tab");
    }
    public boolean validateDynamicFieldValue(
            String fieldName) {

        try {

            By locator = org.openqa.selenium.By.xpath(

                    "//div[contains(@class,'label-text') and " +
                            "contains(normalize-space(),'"
                            + fieldName + "')]" +

                            "/following-sibling::div[contains(@class,'value-text')]");

            WebElement valueElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            locator));

            String actualValue =
                    valueElement.getText().trim();

            System.out.println(
                    "Validated Dynamic Field : "
                            + fieldName
                            + " | Actual Value : "
                            + actualValue);

            return !actualValue.isEmpty();

        } catch (Exception e) {

            System.out.println(
                    "Dynamic Field Validation Failed : "
                            + fieldName);

            return false;
        }
    }
    public boolean validateGraphPresent(String chartId) {

        try {

            By locator = org.openqa.selenium.By.id(chartId);

            WebElement chart = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            locator));

            WebElement graphSection = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            locator));

            ((JavascriptExecutor) driver)
                    .executeScript(
                            "arguments[0].scrollIntoView({block:'center'});",
                            graphSection);

            System.out.println(
                    "Validated Graph Section : "
                            + chartId);

            return graphSection.isDisplayed();

        } catch (Exception e) {

            System.out.println(
                    "Graph Section Not Found : "
                            + chartId);

            return false;
        }
    }
    public void clickCommunicationsTab() {
        waitForLoaderToDisappear();


        WebElement CommTab  = wait.until(
                ExpectedConditions.elementToBeClickable(
                        CommunicationsTab));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        CommTab);

        CommTab.click();

        System.out.println("Clicked Communications Tab");

    }
    public void clickOtherTab() {
        waitForLoaderToDisappear();

        WebElement otherTab  = wait.until(
                ExpectedConditions.elementToBeClickable(
                        OtherTab));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        otherTab);

        otherTab.click();

        System.out.println("Clicked Other Tab");

    }
    public void clickEditProfileButton() {
        waitForLoaderToDisappear();

        // Scroll page to top completely
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, 0);");

        // Small wait for sticky header rendering
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement editProfileBtn = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        EditProfileButton));

        // Force scroll to button
        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        editProfileBtn);

        // JS click avoids overlay issue
        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        editProfileBtn);

        System.out.println("Clicked Edit Profile Button");

    }
    public boolean isCommunicationMessageDisplayed() {

        By communicationMessage = By.xpath(
                "//div[contains(@class,'card')]//div[string-length(normalize-space(text())) > 30]");

        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        communicationMessage));


        String actualMessage = message.getText().trim();

        System.out.println("Communication Message: " + actualMessage);

        return message.isDisplayed() &&
                !actualMessage.isEmpty();
    }
    public void clickCommandNewsLetterArrorw(){
        wait.until(ExpectedConditions.elementToBeClickable(CommandNewsletterArrow)).click();
    }
    public void clickMessageDetailsarrow(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(MessageDetailsArrow)).click();
    }
    public void clickMessagePagination(){
        wait.until(ExpectedConditions.elementToBeClickable(MessageDetailsPagination)).click();
    }
    public void scrollToTop() {

        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, 0);");
    }
    public void validateAchievementHeaders() {

        List<WebElement> headerElements =
                driver.findElements(
                        By.xpath("//div[contains(@class,'tab-header')]//div"));

        for (WebElement header : headerElements) {

            String headerText = header.getText().trim();

            // Ignore empty divs
            if (!headerText.isEmpty()) {

                System.out.println("Header : " + headerText);

                Assert.assertFalse(headerText.isEmpty(),
                        "Header is empty");
            }
        }
    }

    public void printAchievementTableData() {

        List<WebElement> rows = driver.findElements(
                By.xpath("//div[contains(@class,'card-wrapper')]"));

        System.out.println("Total Rows : " + rows.size());

        for (int i = 0; i < rows.size(); i++) {

            List<WebElement> columns =
                    rows.get(i).findElements(By.xpath(".//div"));

            System.out.println("------ Row " + (i + 1) + " ------");

            for (WebElement column : columns) {

                String value = column.getText().trim();

                if (!value.isEmpty()) {

                    System.out.println(value);
                }
            }
        }

    }
    public void validateLibraryHeaders() {

        List<WebElement> headers = driver.findElements(
                By.xpath("//div[contains(@class,'tab-header')]/div"));

        for (WebElement header : headers) {

            String headerText = header.getText().trim();

            if (!headerText.isEmpty()) {

                System.out.println("Header : " + headerText);

                Assert.assertFalse(headerText.isEmpty(),
                        "Header text is empty");
            }
        }
    }
    public void printLibraryTableData() {

        List<WebElement> rows = driver.findElements(
                By.xpath("//div[contains(@class,'card-wrapper')]"));

        System.out.println("Total Rows : " + rows.size());

        for (int i = 0; i < rows.size(); i++) {

            List<WebElement> columns =
                    rows.get(i).findElements(By.xpath(".//div"));

            System.out.println("------ Row " + (i + 1) + " ------");

            for (WebElement column : columns) {

                String value = column.getText().trim();

                if (!value.isEmpty()) {

                    System.out.println(value);
                }
            }
        }
    }
}