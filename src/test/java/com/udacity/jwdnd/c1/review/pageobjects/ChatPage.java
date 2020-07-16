package com.udacity.jwdnd.c1.review.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ChatPage {

    @FindBy(id = "messageText")
    private WebElement messageText;

    @FindBy(id = "messageType")
    private WebElement messageType;

    @FindBy(id = "messageSubmit")
    private WebElement messageSubmit;

    @FindBy(className = "messageContainer")
    private List<WebElement> chatMessages;



}
