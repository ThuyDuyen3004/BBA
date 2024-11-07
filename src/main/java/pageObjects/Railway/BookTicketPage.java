package pageObjects.Railway;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {
    private final By selectDepart = By.name("DepartStation");
    private final By selectArrive = By.name("ArriveStation");
    private final By selectSeatType = By.name("SeatType");
    private final By selectAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By bookSuccess = By.xpath("/html/body/div/div[2]/h1");

    // Elements
    // Các phương thức dưa trên trình duyệt để tìm element thông qua Xpath
    public WebElement getSelectDepart() {
        return Constant.WEBDRIVER.findElement(selectDepart);
    }
    public WebElement getSelectArrive() {
        return Constant.WEBDRIVER.findElement(selectArrive);
    }
    protected WebElement getSelectSeatType() {
        return Constant.WEBDRIVER.findElement(selectSeatType);
    }
    protected WebElement getBookSuccess() {
        return Constant.WEBDRIVER.findElement(bookSuccess);
    }
    protected  WebElement getTicketAmount() {
        return Constant.WEBDRIVER.findElement(selectAmount);
    }
    protected  WebElement getBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    public String getBookMsg() {
        return getBookSuccess().getText();
    }

    public void changeDepart(String depart) {
        Select select = new Select(getSelectDepart());
        select.selectByValue(depart);
    }

    public void changeArrive(String arrive) {
        Select select = new Select(getSelectArrive());
        select.selectByValue(arrive);
    }

    public void changeSeatType(String seatType) {
        Select select = new Select(getSelectSeatType());
        select.selectByValue(seatType);
    }

    public void changeTicketAmount(String amount) {
        Select select = new Select(getTicketAmount());
        select.selectByValue(amount);
    }

    public void bookTicket(){
        getBookTicket().click();
    }
}
