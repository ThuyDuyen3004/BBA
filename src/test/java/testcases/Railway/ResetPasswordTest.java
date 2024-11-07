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
import pageObjects.Railway.RegisterPage;
import pageObjects.Railway.ResetPasswordPage;

public class ResetPasswordTest {
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
        //Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC12() throws InterruptedException {
        System.out.println("TC12 - Errors display when password reset token is blank");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

        // Create account with random email
        String email = Utilities.getRandomEmail();
        String password = Utilities.getRandomPassword();

        // Register new account
        homePage.open();
        homePage.gotoRegister();
        RegisterPage registerPage = new RegisterPage();
        registerPage.register(email, password, "123456789", password);

        // Activate account through confirmation link
        String confirmationLink = Utilities.getConfirmationLink(email);
        Constant.WEBDRIVER.get(confirmationLink);

        System.out.println("A random account has been created and activated successfully");
        Thread.sleep(2000);

        // Navigate to QA Railway Login page
        homePage.open();
        homePage.gotoLoginPage();

        // Click on Forgot Password link
        loginPage.gotoForgotPasswordPage();

        // Enter email address to reset password
        resetPasswordPage.resetPassword(email);
        Thread.sleep(2000);
        // Click Send Instructions button
        resetPasswordPage.clickSendInstructions();

        // Get reset password link from email
        String resetPasswordLink = Utilities.getResetPasswordLink(email);

        // Navigate to reset password link
        Constant.WEBDRIVER.get(resetPasswordLink);

        // Enter new passwords but leave token blank
        String newPassword = Utilities.getRandomPassword();
        resetPasswordPage.enterNewPassword(newPassword);
        resetPasswordPage.enterConfirmPassword(newPassword);
        resetPasswordPage.clearToken();
        resetPasswordPage.clickResetPassword();

        // Verify error message above form
        String actualFormMsg = resetPasswordPage.getFormErrorMessage();
        String expectedFormMsg = "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one.";
        Assert.assertEquals(actualFormMsg, expectedFormMsg, "Form error message is not displayed as expected");

        // Verify error message next to token field
        String actualTokenMsg = resetPasswordPage.getTokenErrorMessage();
        String expectedTokenMsg = "The password reset token is invalid.";
        Assert.assertEquals(actualTokenMsg, expectedTokenMsg, "Token error message is not displayed as expected");
    }

    @Test
    public void TC13() {
        System.out.println("TC13 - Errors display if password and confirm password don't match when resetting password");

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        RegisterPage registerPage = new RegisterPage();
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

        // Generate random email
        String email = Utilities.getRandomEmail();
        String password = Utilities.getRandomPassword();

        // Register new account
        homePage.open();
        homePage.gotoRegister();
        registerPage.register(email, password, "123456789", password);

        // Activate account through confirmation link
        String confirmationLink = Utilities.getConfirmationLink(email);
        Constant.WEBDRIVER.get(confirmationLink);

        System.out.println("A random account has been created and activated successfully");

        // Navigate to QA Railway Login page
        homePage.open();
        homePage.gotoLoginPage();

        // Click on Forgot Password link
        loginPage.gotoForgotPasswordPage();

        // Enter email address to reset password
        resetPasswordPage.resetPassword(email);

        // Click Send Instructions button
        resetPasswordPage.clickSendInstructions();

        // Get reset password link from email
        String resetPasswordLink = Utilities.getResetPasswordLink(email);

        // Navigate to reset password link
        Constant.WEBDRIVER.get(resetPasswordLink);

        // Enter different values for new password and confirm password fields
        String newPassword = Utilities.getRandomPassword();
        String confirmPassword = Utilities.getRandomPassword(); // Different password
        resetPasswordPage.enterNewPassword(newPassword);
        resetPasswordPage.enterConfirmPassword(confirmPassword);

        // Click on Reset Password button
        resetPasswordPage.clickResetPassword();

        // Verify error message above form
        String actualFormMsg = resetPasswordPage.getFormErrorMessage();
        String expectedFormMsg = "Could not reset password. Please correct the errors and try again.";
        Assert.assertEquals(actualFormMsg, expectedFormMsg, "Form error message is not displayed as expected");

        // Verify error message next to confirm password field
        String actualConfirmMsg = resetPasswordPage.getConfirmPasswordErrorMessage();
        String expectedConfirmMsg = "The password confirmation did not match the new password.";
        Assert.assertEquals(actualConfirmMsg, expectedConfirmMsg, "Confirm password error message is not displayed as expected");
    }


}