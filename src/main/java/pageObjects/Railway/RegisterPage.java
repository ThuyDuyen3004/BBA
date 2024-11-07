//package pageObjects.Railway;
//import common.Constant;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//import java.util.List;
//
//public class RegisterPage extends GeneralPage {
//    private final By emailRegister = By.xpath("/html/body/div[1]/div[2]/form/fieldset/ol/li[1]/input");
//    private final By passWordRegister = By.xpath("/html/body/div[1]/div[2]/form/fieldset/ol/li[2]/input");
//    private final By comfirmPassWordRegister = By.xpath("/html/body/div[1]/div[2]/form/fieldset/ol/li[3]/input");
//    private final By btnRegister = By.xpath("/html/body/div[1]/div[2]/form/fieldset/p/input");
//    private final By IpRegister = By.xpath("/html/body/div[1]/div[2]/form/fieldset/ol/li[4]/input");
//    private final By errMsg = By.xpath("/html/body/div[1]/div[2]/p[2]");
//    private final By otherErrMsg = By.xpath("//label[@class='validation-error']");
//    // lấy element
//    public WebElement getEmailRegister() {
//        return Constant.WEBDRIVER.findElement(emailRegister);
//    }
//    public WebElement getPassWordRegister() {
//        return Constant.WEBDRIVER.findElement(passWordRegister);
//    }
//    public WebElement getErrMsg() {
//        return Constant.WEBDRIVER.findElement(errMsg);
//    }
//    public WebElement getComfirmPassWordRegister() {
//        return Constant.WEBDRIVER.findElement(comfirmPassWordRegister);
//    }
//    public WebElement getBtnRegister() {
//        return Constant.WEBDRIVER.findElement(btnRegister);
//    }
//    public WebElement getIpRegister() {
//        return Constant.WEBDRIVER.findElement(IpRegister);
//    }
//    public List<WebElement> getOtherErrMsg() {
//        return Constant.WEBDRIVER.findElements(otherErrMsg);
//    }
//    // method lấy đăng ký
//    public HomePage register(String username,String password, String ip, String passwordconfirm)
//    {
//        this.getEmailRegister().sendKeys(username);
//        this.getPassWordRegister().sendKeys(password);
//        this.getComfirmPassWordRegister().sendKeys(passwordconfirm);
//        this.getIpRegister().sendKeys(ip);
//        this.getBtnRegister().click();
//        return new HomePage();
//    }
//    public String getErrorMsg() {
//        return this.getErrMsg().getText();
//    }
//    public List<WebElement> getOtherErrorMsg() {
//        return this.getOtherErrMsg();
//    }
//
//}

package pageObjects.Railway;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends GeneralPage {
    private final By emailRegister = By.xpath("/html/body/div[1]/div[2]/form/fieldset/ol/li[1]/input");
    private final By passWordRegister = By.xpath("/html/body/div[1]/div[2]/form/fieldset/ol/li[2]/input");
    private final By comfirmPassWordRegister = By.xpath("/html/body/div[1]/div[2]/form/fieldset/ol/li[3]/input");
    private final By btnRegister = By.xpath("/html/body/div[1]/div[2]/form/fieldset/p/input");
    private final By IpRegister = By.xpath("/html/body/div[1]/div[2]/form/fieldset/ol/li[4]/input");
    private final By errMsg = By.xpath("/html/body/div[1]/div[2]/p[2]");
    private final By otherErrMsg = By.xpath("//label[@class='validation-error']");

    // Get elements
    public WebElement getEmailRegister() {
        return Constant.WEBDRIVER.findElement(emailRegister);
    }

    public WebElement getPassWordRegister() {
        return Constant.WEBDRIVER.findElement(passWordRegister);
    }

    public WebElement getErrMsg() {
        return Constant.WEBDRIVER.findElement(errMsg);
    }

    public WebElement getComfirmPassWordRegister() {
        return Constant.WEBDRIVER.findElement(comfirmPassWordRegister);
    }

    public WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }

    public WebElement getIpRegister() {
        return Constant.WEBDRIVER.findElement(IpRegister);
    }

    public List<WebElement> getOtherErrMsg() {
        return Constant.WEBDRIVER.findElements(otherErrMsg);
    }

    // Method to perform registration
    public HomePage register(String username, String password, String ip, String passwordconfirm) {
        this.getEmailRegister().sendKeys(username);
        this.getPassWordRegister().sendKeys(password);
        this.getComfirmPassWordRegister().sendKeys(passwordconfirm);
        this.getIpRegister().sendKeys(ip);
        this.getBtnRegister().click();
        return new HomePage();
    }

    // Get error message
    public String getErrorMsg() {
        return this.getErrMsg().getText();
    }

    // Get other error messages
    public List<WebElement> getOtherErrorMsg() {
        return this.getOtherErrMsg();
    }
}
