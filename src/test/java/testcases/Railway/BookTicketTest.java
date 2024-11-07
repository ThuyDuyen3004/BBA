package testcases.Railway;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;
import pageObjects.Railway.BookTicketPage;
import pageObjects.Railway.TimeTablePage;

public class BookTicketTest {
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
    public void TC14() {
        System.out.println("TC14 - User can book 1 ticket at a time");

        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login("qqhm5kb8wdcz@phyones.com", "123456789");

        BookTicketPage bookTicketPage = loginPage.gotoBookTicketPage();

        bookTicketPage.changeDepart("5"); //5 is Hue, No Sai Gon here :)
        bookTicketPage.changeArrive("3");
        bookTicketPage.changeSeatType("6");
        bookTicketPage.changeTicketAmount("1");
        bookTicketPage.bookTicket();
        Assert.assertEquals(bookTicketPage.getBookMsg(), "Ticket booked successfully!", "Message \"Ticket booked successfully!\" displays.");
    }

    @Test
    public void TC15() {
        System.out.println("TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login("qqhm5kb8wdcz@phyones.com", "123456789");

        TimeTablePage timeTablePage = loginPage.gotoTimeTablePage();
        timeTablePage
                .getWebElement("/html/body/div/div[2]/div/div/table/tbody/tr[4]/td[7]/a") //Sai Gon to Hue
                .click(); //Bug: <a> element not clickable for unknown reasons

        BookTicketPage bookTicketPage = new BookTicketPage();
        Select depart = new Select(bookTicketPage.getSelectDepart());
        Assert.assertTrue(depart.getOptions().stream().anyMatch((e) -> {
            String selected = e.getAttribute("selected");
            if (selected == null) return false;
            return e.getAttribute("value").equals("5"); //BUGGED - 5 is Hue NOT Sai Gon
        }));

        Select arrive = new Select(bookTicketPage.getSelectArrive());
        Assert.assertTrue(arrive.getOptions().stream().anyMatch((e) -> {
            String selected = e.getAttribute("selected");
            if (selected == null) return false;
            return e.getAttribute("value").equals("5");
        }));
    }

    @Test
    public void TC16() {
        System.out.println("TC16 - User can cancel a ticket");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login("qqhm5kb8wdcz@phyones.com", "123456789");

        BookTicketPage bookTicketPage = loginPage.gotoBookTicketPage();

        bookTicketPage.changeDepart("5"); //5 is Hue, No Sai Gon here :)
        bookTicketPage.changeArrive("3");
        bookTicketPage.changeSeatType("6");
        bookTicketPage.changeTicketAmount("1");
        bookTicketPage.bookTicket();
        //TODO: Test failed, finish the test:
    }
}
