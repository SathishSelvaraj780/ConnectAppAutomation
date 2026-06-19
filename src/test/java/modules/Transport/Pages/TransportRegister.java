package modules.Transport.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class TransportRegister {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private By TransportMenu = By.xpath("//li[@data-menu='Transport']");
    private By TransportInfo = By.xpath("//*[@data-menutext='Transport info']");
    private By RegisterButton = By.xpath("//a[contains(text(),'Register now')]");
    private By InfoNxtButton = By.xpath("//button[@class=\"button fill next\"]");
    private By SelectCityDropdown = By.xpath("//*[@id=\"citySelect\"]");
    private By EnterVillNo = By.id("House");
    private By StreetName = By.id("streetAddress");
    private By SelectTrasnportTypeDropdown = By.xpath("//*[@id=\"transportType\"]");
    private By PickupAreaDropdown = By.xpath("//*[@id=\"pickUpArea\"]");
    private By DropofAreaDropdown = By.xpath("//*[@id=\"dropOffArea\"]");
    private By selectPickuppointDropdown = By.xpath("//*[@id=\"pickUpPointSelect\"]");
    private By selectDropoffpointDropdown = By.xpath("//*[@id=\"DropOffPoint\"]");
    private By NextButton = By.xpath("//button[@class=\"button fill next\"]");
    private By TermsandConditionsCheckbox = By.xpath("//input[@id='agreeCheckbox']");
    private By AgreeTandCButton = By.id("agreeButton");
    private By ParentUndertaking = By.xpath("//input[@id='parentUndertakingHide1']");
    private By ParentAgreeButton = By.id("parentAgreeButton");
    private By TransportUpdatesCheckbox = By.xpath("//input[@id=\"chkagree\"]");
    private By Declarationcheckbox = By.xpath("//input[@id=\"chkdeclare\"]");
    private By SubmitButton = By.xpath("//button[@id='submitButton']");
    private By SaveRegisterProgress = By.xpath("//button[@id=\"btnYes\"]");
    private By SuccessfullRegistration = By.xpath("//div[@id=\"successMessageShow\"]");
    private By PrintreferenceNo = By.xpath("//div[contains(text(),'Reference No.')]");
    private By FinalProceedButton = By.xpath("//button[@id=\"proceedBtn\"]");
    private By FinalOKtoHomeredirection = By.xpath("//button[@id=\"homeRedirectBtn\"]");
    
    public TransportRegister(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Step("Open Transport Menu")
    public void clickTransportMenu(){
    wait.until(ExpectedConditions.elementToBeClickable(TransportMenu)).click();
    }

    @Step("Navigate to Transport Info")
    public void navigatetoTransportInfo(){
    wait.until(ExpectedConditions.elementToBeClickable(TransportInfo)).click();
    }

    @Step("Click on Register Now Button")
    public void clickRegisterNow(){
        wait.until(ExpectedConditions.elementToBeClickable(RegisterButton)).click();
    }
    @Step("")
    public void clickNextButton(){
        wait.until(ExpectedConditions.elementToBeClickable(InfoNxtButton)).click();
    }


}
