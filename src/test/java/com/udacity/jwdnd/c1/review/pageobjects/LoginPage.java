package com.udacity.jwdnd.c1.review.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "inputUsername")
    private WebElement usernameEdit;

    @FindBy(id = "inputPassword")
    private WebElement passwordEdit;

    @FindBy(id = "submit-button")
    private WebElement loginSubmit;

    @FindBy(id = "signup-link")
    private WebElement signupLink;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password){
        usernameEdit.sendKeys(username);
        passwordEdit.sendKeys(password);
        loginSubmit.click();
    }

    public void goToSignup(){
        signupLink.click();
    }

}
