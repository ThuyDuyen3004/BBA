package pageObjects.Railway;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePassWordPage {
    private final By _txtCurrentPassword = By.xpath("//*[@id=\"currentPassword\"]");
    private final By _txtNewPassword = By.xpath("//input[@id='newPassword']");
    private final By _btnConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By _btnCp = By.xpath("//input[@value='Change Password']");
    private final By _lblMsg = By.xpath("//p[@class='message success']");

    public WebElement getTxtCurrentPassword() {
        return Constant.WEBDRIVER.findElement(_txtCurrentPassword);
    }
    public WebElement getTxtNewPassword() {
        return Constant.WEBDRIVER.findElement(_txtNewPassword);
    }
    public WebElement getBtnConfirmPassword() {
        return Constant.WEBDRIVER.findElement(_btnConfirmPassword);
    }
    public WebElement getLblMsg() {
        return Constant.WEBDRIVER.findElement(_lblMsg);
    }
    public WebElement getBtnCp() {
        return Constant.WEBDRIVER.findElement(_btnCp);
    }

    public void changePassword(String currPassword, String newPassword, String confirmPassword) {
        getTxtCurrentPassword().sendKeys(currPassword);
        getTxtNewPassword().sendKeys(newPassword);
        getBtnConfirmPassword().sendKeys(confirmPassword);
        this.getBtnCp().click();
    }
}
