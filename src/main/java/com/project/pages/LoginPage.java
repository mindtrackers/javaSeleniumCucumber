package com.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.project.utils.BasePage;
import com.project.utils.DriverManager;

public class LoginPage extends BasePage {
    
    // Locators
    @FindBy(name = "username")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(css = "form[method=\"POST\"] div:nth-of-type(3)>button")
    WebElement loginButton;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void inputCredentials(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String verifyPageTitle(){
        return DriverManager.getDriver().getTitle();
    }

}
