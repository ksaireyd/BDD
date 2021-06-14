package manager;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(WebDriver driver) throws IOException {
        return new HomePage(driver);
    }
    public LoginPage getLoginPage(WebDriver driver) throws IOException {
        return new LoginPage(driver);
    }



}
