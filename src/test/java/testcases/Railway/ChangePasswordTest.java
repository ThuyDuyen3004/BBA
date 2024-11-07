package testcases.Railway;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Railway.ChangePassWordPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;

public class ChangePasswordTest {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        System.setProperty("Webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC09() {
        System.out.println("TC9 - User can change password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login("qqhm5kb8wdcz@phyones.com", "123456789");

        ChangePassWordPage changePassWordPage = homePage.gotoChangePasswordPage();
        changePassWordPage.changePassword("123456789", "123456789", "123456789"); //TODO: Make new password not identical to the current one
        Assert.assertEquals(changePassWordPage.getLblMsg().getText(), "Your password has been updated!", "Message \"Your password has been updated\" appears.");
    }
}
