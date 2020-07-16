package com.udacity.jwdnd.c1.review;

import com.udacity.jwdnd.c1.review.pageobjects.ChatPage;
import com.udacity.jwdnd.c1.review.pageobjects.LoginPage;
import com.udacity.jwdnd.c1.review.pageobjects.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegratedTests {

    @LocalServerPort
    private Integer port;
    private String baseUrl;

    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void afterAll(){
        driver.close();
    }

    @BeforeEach
    public void beforeEach(){
        baseUrl = "http://localhost:"+port;
    }

    @Test
    public void testUserSignupLoginAndSubmitMessage() {
        String username = "user";
        String password = "pass";
        String messageText = "Test Message";

        driver.get(baseUrl + "/register");

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerNewUser("Sid", "Pas", username, password);

        driver.get(baseUrl + "/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        ChatPage chatPage = new ChatPage(driver);
        chatPage.setMessageText(messageText);
        chatPage.submitMessage();

        List<String> messages = chatPage.getMessagesList();

        assertEquals(messageText, messages.get(0));
    }

}
