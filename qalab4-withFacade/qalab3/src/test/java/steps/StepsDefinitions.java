package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.io.IOException;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;

public class StepsDefinitions {


    WebDriver driver;
    HomePage homePage;
    BasePage basePage;
    LoginPage loginPage;
    PageFactoryManager pageFactoryManager;
    @Before
    public void testsSetUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
        homePage = pageFactoryManager.getHomePage(driver);
        loginPage = pageFactoryManager.getLoginPage(driver);
        homePage.implicityWaiter();
    }
    

    @Given("User opens signing page")
    public void userOpensSigningPage() throws IOException {
        driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com");
    }


    @And("User enter his {string}")
    public void userEnterHisEmail(String mail) {
        loginPage.enterMail(mail);
    }

    @And("User enter his {string} key")
    public void userEnterHisPasswordKey(String pass) {
        loginPage.enterPass(pass);
    }

    @Then("User gets to the home page")
    public void userGetsToTheHomePage() throws IOException {
        Assert.assertTrue(homePage.checkSigning());

    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("User clicks compose")
    public void userClicksCompose() {
        homePage.clickCompose();
    }

    @And("User enters {string} field")
    public void userEnterSendtoField(String sendto) {
        homePage.enterAddr(sendto);
    }

    @And("User enters {string} of message")
    public void userEnterTextOfMessage(String text) {
        homePage.enterText(text);
    }


    @And("User sends message")
    public void userClicksSendButton() {
        homePage.sendMessage();
    }

    @When("User opens sent folder")
    public void userOpensSentFolder() {
        homePage.openSentFolder();
    }

    @Then("User confirms sending")
    public void userConfirmsSending() {
        Assert.assertTrue(homePage.checkSending());
    }

    @And("User deletes the letter from folder")
    public void userDeletesTheLetterFromFolder() {
        homePage.removeMessage();
    }
}
