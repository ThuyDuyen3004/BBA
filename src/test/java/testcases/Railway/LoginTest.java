package testcases.Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import common.Constant;
import common.Utilities;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;


public class LoginTest {
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
    public void TC1() {
        System.out.println("TC1 - User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        // o homepage moi co thong bao welcomeMessage
        String actualMsg = loginPage.login(Constant.USERNAMETC1, Constant.PASSWORDTC1).getWelcomeMessage();
        String expectedMsg = "Welcome to Railway" + Constant.USERNAMETC1;
//        System.out.println(actualMsg);
        // so sánh để tìm bug --> Cái này bug nè
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not display as expected");
    }

    @Test
    public void TC2() {
        // In ra cho người dùng dễ đọc code
        System.out.println("TC2 - User can't login with blank \"Username\" textbox");
        // Tạo mô đối tượng homepage  kế thừa các thuộc tính của General Page (những thu chung chung nhat)
        // General chi la thu dung de ke thua, ke thua lai cac phan tu ma site nao cung co
        HomePage homePage = new HomePage();
        // Thuc hien phuong thuc opoen de tra ve chinh no, chinh la web mà ta them url vao
        homePage.open();
        // Phuong thuc nay khoi tao mot loginpage chua cac phuong thuc cua LoginPage
        LoginPage loginPage = homePage.gotoLoginPage();
        // Thuc hien cac phuong thuc cua loginPage
        // login
        loginPage.login(Constant.USERNAMETC2, Constant.PASSWORDTC2);
        // lay loi
        String actualMsg = loginPage.getErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        // so sanh
        Assert.assertEquals(actualMsg, expectedMsg, "There was a problem with your login and/or errors exist in your form.");
    }

    @Test
    public void TC3() {
        // In ra cho người dùng dễ đọc code
        System.out.println("TC3 - User cannot log into Railway with invalid password ");
        // Tạo mô đối tượng homepage  kế thừa các thuộc tính của General Page (những thu chung chung nhat)
        // General chi la thu dung de ke thua, ke thua lai cac phan tu ma site nao cung co
        HomePage homePage = new HomePage();
        // Thuc hien phuong thuc open de tra ve chinh no, chinh la web mà ta them url vao
        homePage.open();
        // Phuong thuc nay khoi tao mot loginpage chua cac phuong thuc cua LoginPage
        LoginPage loginPage = homePage.gotoLoginPage();
        // Thuc hien cac phuong thuc cua loginPage
        // login
        loginPage.login(Constant.USERNAMETC3, Constant.PASSWORDTC3);
        // lay loi
        String actualMsg = loginPage.getErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        // so sanh
        Assert.assertEquals(actualMsg, expectedMsg, "There was a problem with your login and/or errors exist in your form.");
    }

    @Test
    public void TC4() {
        System.out.println("TC4 - Login page displays when un-logged User clicks on \"Book ticket\" tab");
        HomePage homePage = new HomePage();
        // Thuc hien phuong thuc open de tra ve chinh no, chinh la web mà ta them url vao
        homePage.open();
        homePage.gotoMyTicketPage();
        String currentUrl = Constant.WEBDRIVER.getCurrentUrl();
        String expectedUrl = "http://railwayb1.somee.com/Account/Login.cshtml?ReturnUrl=/Page/BookTicketPage.cshtml";
        Assert.assertEquals(currentUrl, expectedUrl, "There was not display correct screen");
    }

    @Test
    public void TC5() {
        // In ra cho người dùng dễ đọc code
        System.out.println("TC5 - User cannot log into Railway with invalid password ");
        // Tạo mô đối tượng homepage  kế thừa các thuộc tính của General Page (những thu chung chung nhat)
        // General chi la thu dung de ke thua, ke thua lai cac phan tu ma site nao cung co
        HomePage homePage = new HomePage();
        // Thuc hien phuong thuc open de tra ve chinh no, chinh la web mà ta them url vao
        homePage.open();
        // Phuong thuc nay khoi tao mot loginpage chua cac phuong thuc cua LoginPage
        LoginPage loginPage = homePage.gotoLoginPage();
        // Thuc hien cac phuong thuc cua loginPage
        // login
        for (int i = 0; i < 5; i++) {
            loginPage.login(Constant.USERNAMETC3, Constant.PASSWORDTC3);
        }
        // lay loi
        String actualMsg = loginPage.getErrorMsg();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        // so sanh
        Assert.assertEquals(actualMsg, expectedMsg, "There was a problem with your login and/or errors exist in your form.");
    }

    @Test
    public void TC6() {
        // In ra cho người dùng dễ đọc code
        System.out.println("TC6 - Additional pages display once user logged in");
        // Tạo mô đối tượng homepage  kế thừa các thuộc tính của General Page (những thu chung chung nhat)
        // General chi la thu dung de ke thua, ke thua lai cac phan tu ma site nao cung co
        HomePage homePage = new HomePage();
        // Thuc hien phuong thuc open de tra ve chinh no, chinh la web mà ta them url vao
        homePage.open();
        // Phuong thuc nay khoi tao mot loginpage chua cac phuong thuc cua LoginPage
        LoginPage loginPage = homePage.gotoLoginPage();
        // Thuc hien cac phuong thuc cua loginPage
        // login
        loginPage.login(Constant.USERNAMETC1, Constant.PASSWORDTC1);
        loginPage.gotoBookTicketPage();
        // lay loi
        String currentUrl1 = Constant.WEBDRIVER.getCurrentUrl();
        String expectedUrl1 = "http://railwayb1.somee.com/Page/ManageTicket.cshtml";
        Assert.assertEquals(currentUrl1, expectedUrl1, "There was not display correct screen");
        loginPage.gotoChangePasswordPage();
        String currentUrl2 = Constant.WEBDRIVER.getCurrentUrl();
        String expectedUrl2 = "http://railwayb1.somee.com/Account/ChangePassword.cshtml";
        Assert.assertEquals(currentUrl2, expectedUrl2, "There was not display correct screen");
    }
}
