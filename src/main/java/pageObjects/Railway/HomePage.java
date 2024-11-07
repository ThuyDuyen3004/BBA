//package pageObjects.Railway;
//import common.Constant;
//import org.openqa.selenium.By;
//
//// Vì general là trang chung, nên các trang khác sẽ kế thừa
//public class HomePage extends GeneralPage{
//    public HomePage open()
//    {
//        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
//        return this;
//    }
//    public void gotoRegister() {
//        // Find the 'Register' link and click it
//        Constant.WEBDRIVER.findElement(By.linkText("Register")).click();
//    }
//
//    public void gotoLoginPage() {
//        // Find the 'Login' link and click it
//        Constant.WEBDRIVER.findElement(By.linkText("Login")).click();
//    }
//}
package pageObjects.Railway;

import common.Constant;
import org.openqa.selenium.By;

// HomePage represents the main page of the Railway application.
public class HomePage extends GeneralPage {

    // Opens the Railway application and returns the HomePage instance.
    public HomePage open() {
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
        return this;
    }

    // Navigates to the Register page by clicking the 'Register' link.
    public void gotoRegister() {
        Constant.WEBDRIVER.findElement(By.linkText("Register")).click();
    }

//    // Navigates to the Login page by clicking the 'Login' link.
//    public void gotoLoginPage() {
//        Constant.WEBDRIVER.findElement(By.linkText("Login")).click();
//    }
}





