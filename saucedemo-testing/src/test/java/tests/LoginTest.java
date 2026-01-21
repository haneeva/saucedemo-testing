package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import resources.TestData;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void validLogin() {

        //Call LoginPage
        LoginPage login = new LoginPage(driver);

        //Enter username and password
        login.enterUsername(TestData.USERNAME);
        login.enterPassword(TestData.PASSWORD);

        HomePage home = login.clickLogin(); //After clicking login button, it will direct to Home page

        //Assert login successful
        Assert.assertTrue(home.isHomeDisplayed(),
                "Login failed");
        String homeTitle = home.getTitleText();
        System.out.println("Homepage title: " + homeTitle);
    }

    @Test(priority = 2)
    public void invalidUsernameLogin(){
        //Call LoginPage
        LoginPage login = new LoginPage(driver);

        //Enter Invalid Username and valid Password
        login.enterUsername(TestData.INVALID_USERNAME);
        login.enterPassword(TestData.PASSWORD);
        login.clickLogin();

        //Assert Error
        Assert.assertTrue(login.isErrorDisplayed(),
                "An error message is not displayed");
        System.out.println("Error message: " + login.getErrorMessage());
    }

    @Test(priority = 3)
    public void invalidPasswordLogin(){
        //Call LoginPage
        LoginPage login = new LoginPage(driver);

        //Enter valid Username and invalid Password
        login.enterUsername(TestData.USERNAME);
        login.enterPassword(TestData.INVALID_PASSWORD);
        login.clickLogin();

        //Assert Error
        Assert.assertTrue(login.isErrorDisplayed(),
                "An error message is not displayed");
        System.out.println("Error message: " + login.getErrorMessage());
    }

    @Test(priority = 4)
    public void invalidLogin(){
        //Call LoginPage
        LoginPage login = new LoginPage(driver);

        //Enter invalid Username and invalid Password
        login.enterUsername(TestData.INVALID_PASSWORD);
        login.enterPassword(TestData.INVALID_PASSWORD);
        login.clickLogin();

        //Assert Error
        Assert.assertTrue(login.isErrorDisplayed(),
                "An error message is not displayed");
        System.out.println("Error message: " + login.getErrorMessage());
    }

    @Test(priority = 5)
    public void blankLogin(){
        //Call LoginPage
        LoginPage login = new LoginPage(driver);

        //Blank both username and password
        login.clickLogin();

        //Assert Error
        Assert.assertTrue(login.isBlankErrorDisplayed(),
                "An error message is not displayed");
        System.out.println("Error message: " + login.getBlankErrorMessage());
    }
    
}
