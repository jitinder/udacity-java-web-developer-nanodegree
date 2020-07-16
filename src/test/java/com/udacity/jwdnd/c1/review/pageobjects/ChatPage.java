package com.udacity.jwdnd.c1.review.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
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

    public ChatPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void setMessageText(String message) {
        this.messageText.sendKeys(message);
    }

    public void setMessageType(String type){
        this.messageType.sendKeys(type);
    }

    public void submitMessage(){
        this.messageSubmit.click();
    }

    public List<String> getMessagesList(){
        List<String> messages = new ArrayList<>();
        for(WebElement element : chatMessages){
            List<WebElement> spans = element.findElements(By.tagName("span"));
            messages.add(spans.get(1).getText());
        }
        return messages;
    }
}
