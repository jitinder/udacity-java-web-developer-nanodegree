package com.udacity.jwdnd.c1.review.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    @FindBy(id = "inputFirstName")
    private WebElement firstNameEdit;

    @FindBy(id = "inputLastName")
    private WebElement lastNameEdit;

    @FindBy(id = "inputUsername")
    private WebElement usernameEdit;

    @FindBy(id = "inputPassword")
    private WebElement passwordEdit;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    @FindBy(id = "success-msg")
    private WebElement successMessage;

    @FindBy(id = "error-msg")
    private WebElement errorMessage;

    public RegisterPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void registerNewUser(String firstName, String lastName, String username, String password){
        firstNameEdit.sendKeys(firstName);
        lastNameEdit.sendKeys(lastName);
        usernameEdit.sendKeys(username);
        passwordEdit.sendKeys(password);
        submitButton.click();
    }

    public boolean isSuccessful(){
        return successMessage.isDisplayed();
    }

}
