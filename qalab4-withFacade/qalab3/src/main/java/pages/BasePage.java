package pages;

import manager.PropertiesManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
    InputStream inputStream;
    WebDriver driver;
    Properties prop ;

    BasePage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PropertiesManager propertiesManager = new PropertiesManager();
        prop = propertiesManager.getPropValues();
    }



    public void implicityWaiter() {
        driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("impl_time")), TimeUnit.SECONDS);
    }

    public void waitVisibility(WebElement el) {
        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(prop.getProperty("visibility_time")));
        wait.until(ExpectedConditions.visibilityOf(el));
    }

    public void waitClick(WebElement el) {
        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(prop.getProperty("click_time")));
        wait.until(ExpectedConditions.elementToBeClickable(el));
    }

}
