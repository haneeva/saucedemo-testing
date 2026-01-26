package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

   WebDriver driver;
   
    private By UsernameField = By.id("user-name");
    private By PasswordField = By.id("password");
    private By LoginButton = By.id("login-button");
    private By HomeTitle = By.xpath("//span[@class='title']");
    private By ErrorMessage = By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]");
    private By BlankErrorMessage = By.xpath("//h3[normalize-space()='Epic sadface: Username is required']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(UsernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(PasswordField).sendKeys(password);
    }

    public HomePage clickLogin() {
        driver.findElement(LoginButton).click();
        return new HomePage(driver);
    }

    public boolean isErrorDisplayed(){
        return driver.findElement(ErrorMessage).isDisplayed();
    }

    public String getErrorMessage(){
        return driver.findElement(ErrorMessage).getText();
    }

    public boolean isBlankErrorDisplayed(){
        return driver.findElement(BlankErrorMessage).isDisplayed();
    }

    public String getBlankErrorMessage(){
        return driver.findElement(BlankErrorMessage).getText();
    } 
    
}
