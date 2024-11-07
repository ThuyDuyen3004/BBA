package testcases.Railway;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;
import pageObjects.Railway.RegisterPage;

import java.util.List;

public class RegisterTest {
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
    public void TC7() {
        System.out.println("TC7 - User can create new account");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoRegisterPage();
        RegisterPage registerPage = new RegisterPage();
        var passwordConfirm = Constant.PASSWORDTC7;
        String actualMsg = registerPage.register(Constant.USERNAMETC7, Constant.PASSWORDTC7, passwordConfirm, Constant.IPTC7).getRegisterSuccessMessage();
        String expectedMsg = "Thank you for registering your account";
        //  System.out.println(actualMsg);
        // so sánh để tìm bug --> Cái này bug nè
        Assert.assertEquals(actualMsg, expectedMsg, "Success message is not display as expected");
    }

    @Test
    public void TC10() {
        System.out.println("TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoRegisterPage();
        RegisterPage registerPage = new RegisterPage();
        var passwordConfirm = Constant.PASSWORDTC10 + 'a';
        registerPage.register(Constant.USERNAMETC10, Constant.PASSWORDTC10, passwordConfirm,Constant.IPTC10);
        String actualMsg = registerPage.getErrorMsg();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        //  System.out.println(actualMsg);
        // so sánh để tìm bug --> Cái này bug nè
        Assert.assertEquals(actualMsg, expectedMsg, "Success message is not display as expected");
    }

    @Test
    public void TC11() {
        System.out.println("TC11 - User can't create account while password and PID fields are empty");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoRegisterPage();
        RegisterPage registerPage = new RegisterPage();
        registerPage.register(Constant.USERNAMETC11,Constant.PASSWORDTC11, Constant.PASSWORDTC11, Constant.IPTC11);
        List<WebElement> actualMsg = registerPage.getOtherErrorMsg();
        System.out.println(actualMsg);


        String actualMsg0 = registerPage.getErrorMsg();
        String expectedMsg0 = "There're errors in the form. Please correct the errors and try again.";

        String actualMsg1 = actualMsg.get(0).getText();
        String expectedMsg1 = "Invalid password length.";

        String actualMsg2 = actualMsg.get(1).getText();
        String expectedMsg2 = "Invalid ID length.";

        System.out.println(actualMsg0);
        System.out.println(actualMsg1);
        System.out.println(actualMsg2);

        //  System.out.println(actualMsg);
        // so sánh để tìm bug --> Cái này bug nè
        Assert.assertEquals(actualMsg0, expectedMsg0, "Success message is not display as expected");
        Assert.assertEquals(actualMsg1, expectedMsg1, "Success message is not display as expected");
        Assert.assertEquals(actualMsg2, expectedMsg2, "Success message is not display as expected");
    }
}
