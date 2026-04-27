package modules.Homepage.DashboardPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardRedirectionPages {

    private WebDriver driver;
    private WebDriverWait wait;

    private By QuicklinksActivities = By.xpath("//*[@id=\"mCSB_1_container\"]/main/div[11]/div[3]/div[2]/div/button[1]");
    private By QuicklinksLeaveRequest = By.xpath("//*[@id=\"mCSB_1_container\"]/main/div[11]/div[3]/div[2]/div/button[2]");
    private  By ProfileCompletion = By.xpath("//*[@id=\"mCSB_1_container\"]/main/div[10]/div[2]/div/div[5]/a");
    private By SchoolFee = By.xpath("//*[@id=\"mCSB_1_container\"]/main/div[11]/div[2]/div[2]/div[1]/div[1]/div/button");
    private By Transportfee = By.xpath("//*[@id=\"mCSB_1_container\"]/main/div[11]/div[2]/div[2]/div[1]/div[2]/div/button");
    private By NoticeBoard = By.xpath("//*[@id=\"divNoticeBoard\"]/div[2]/button[2]/span");
    private By Attendance = By.xpath("//*[@id=\"mCSB_1_container\"]/main/div[12]/div[2]/div[1]/button");

}
