package pageObjects.Railway;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage extends GeneralPage {
    public WebElement getWebElement(String xpath) {
        return Constant.WEBDRIVER.findElement(By.xpath(xpath));
    }
}
