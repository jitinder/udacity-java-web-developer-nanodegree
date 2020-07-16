package com.udacity.jwdnd.c1.review;

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

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RegisterTests {

	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	private RegisterPage register;

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
		driver.get("http://localhost:"+port+"/register");
		register = new RegisterPage(driver);
	}

	@Test
	public void registerUser(){
		register.registerNewUser("Sidak", "Pasricha", "sid", "sid");
		assertTrue(register.isSuccessful());
	}

}
