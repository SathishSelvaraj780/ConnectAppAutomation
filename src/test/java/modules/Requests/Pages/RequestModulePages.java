package modules.Requests.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestModulePages {


    private By RequestTopMenu = By.xpath("//*[@data-menutext='Requests']");
    private By UploadPhotoMenu = By.xpath("//a[@data-menutext=\"Upload photo\"]");

    private By getUploadButton(String memberType) {
        return By.xpath(String.format("//button[contains(@onclick,'%s')]", memberType.toUpperCase()));
    }

    private By FatherPhotoUploadButton = By.xpath("//button[contains(@onclick,'FATHER')]");
    private By StudentPhotoUploadButton = By.xpath("//button[contains(@onclick,'STUDENT')]");
    private By MotherPhotoUploadButton = By.xpath("//button[contains(@onclick,'MOTHER')]");
    private By GuardianPhotoUploadButton = By.xpath("//button[contains(@onclick,'GUARDIAN')]");
    private By ClickHereLink = By.cssSelector("span.click-here-link");
    private By UploadButton = By.xpath("//button[contains(@onclick,\"UploadPhotoToServer()\")]");
    private By ChooseFileButton = By.xpath("//input[@type='file']");
    private By SuccessPopupOkButton = By.xpath("//div[@id='success-dialog']//button");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public RequestModulePages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
    }

    public void openRequestMenu() {
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(RequestTopMenu)).click();
    }

    public void openUploadPhotoMenu() {
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(UploadPhotoMenu)).click();
    }

    public void clickUploadButton(String memberType) {

        wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions
                        .elementToBeClickable(getUploadButton(memberType))
        ).click();
    }

    public void uploadPhoto(String memberType, String filePath) {
        clickUploadButton(memberType);

        WebElement uploadInput = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        ChooseFileButton
                )
        );

        uploadInput.sendKeys(filePath);

        wait.until(driver ->
                !uploadInput.getAttribute("value").isEmpty()
        );

        WebElement uploadBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        UploadButton
                )
        );

        uploadBtn.click();

        System.out.println(memberType + " upload completed");

        try {

            WebElement okButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            SuccessPopupOkButton
                    )
            );

            okButton.click();

            wait.until(ExpectedConditions.invisibilityOf(okButton));

        } catch (Exception e) {

            System.out.println("Popup not displayed");
        }
    }
}