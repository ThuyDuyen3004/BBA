package pageObjects.Railway;

import common.Constant;
import org.openqa.selenium.By;

public class ResetPasswordPage {

    public void resetPassword(String email) {
        // Find the email input field and enter the email
        Constant.WEBDRIVER.findElement(By.id("email")).sendKeys(email);
    }

    public void clickSendInstructions() {
        // Find and click the 'Send Instructions' button

        Constant.WEBDRIVER.findElement(By.xpath("(//input[@value='Send Instructions'])[1]")).click();
    }

    public void enterNewPassword(String newPassword) {
        // Find the new password input field and enter the new password
        Constant.WEBDRIVER.findElement(By.id("newPassword")).sendKeys(newPassword);
    }

    public void enterConfirmPassword(String confirmPassword) {
        // Find the confirm password input field and enter the confirm password
        Constant.WEBDRIVER.findElement(By.id("confirmPassword")).sendKeys(confirmPassword);
    }

    public void clearToken() {
        // Clear the token input field to simulate a blank token
        Constant.WEBDRIVER.findElement(By.id("token")).clear();
    }

    public void clickResetPassword() {
        // Find and click the 'Reset Password' button
        Constant.WEBDRIVER.findElement(By.id("resetPasswordButton")).click();
    }

    public String getFormErrorMessage() {
        // Get the error message above the form
        return Constant.WEBDRIVER.findElement(By.id("formErrorMessage")).getText();
    }

    public String getTokenErrorMessage() {
        // Get the error message next to the token field
        return Constant.WEBDRIVER.findElement(By.id("tokenErrorMessage")).getText();
    }

    public String getConfirmPasswordErrorMessage() {
        // Get the error message next to the confirm password field
        return Constant.WEBDRIVER.findElement(By.id("confirmPasswordErrorMessage")).getText();
    }
}
