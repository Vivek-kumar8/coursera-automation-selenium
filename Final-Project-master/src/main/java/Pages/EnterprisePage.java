package Pages;

import Utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Handles Enterprise form
 */
public class EnterprisePage {

    WebDriver driver;
    WebDriverWait wait;
    String fName;
    String lName;
    String mail;


    public EnterprisePage(WebDriver driver, String fName , String lName,String mail) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.fName=fName;
        this.lName=lName;
        this.mail=mail;
    }

    By enterpriseLink = By.xpath("//li[contains(@class,'rc-SubFooterSection__content-column-link-item')]/a[text()='For Enterprise']");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By email = By.id("Email");
    By submitButton = By.xpath("//span[@class='mktoButtonWrap mktoSimple']//button\n");
    By emailError = By.xpath("//*[@id='ValidMsgEmail']");

    /**
     * Submit enterprise form with invalid email
     */
    
    public void submitForm() {

        WebElement enterpriseElement =
                wait.until(ExpectedConditions.presenceOfElementLocated(enterpriseLink));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                enterpriseElement
        );
        wait.until(ExpectedConditions.elementToBeClickable(enterpriseElement));
        js.executeScript("arguments[0].click();", enterpriseElement);
        WaitUtil.sendKeys(driver, firstName, fName, 20);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(email).sendKeys(mail);

        WaitUtil.click(driver, submitButton, 20);

        System.out.println(
                WaitUtil.waitForVisibility(driver, emailError, 20).getText()
        );
    }
}