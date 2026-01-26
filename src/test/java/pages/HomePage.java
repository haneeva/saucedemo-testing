package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

        private By Title = By.xpath("//span[@class='title']");


        public HomePage(WebDriver driver){
            this.driver = driver;
        }

        public boolean isHomeDisplayed(){
            return driver.findElement(Title).isDisplayed();
        }

        public String getTitleText(){
            return driver.findElement(Title).getText();
        }

    
}
