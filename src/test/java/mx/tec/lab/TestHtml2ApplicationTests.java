package mx.tec.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestHtml2ApplicationTests {

	private static WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/karenhernandez/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    

    @Test
    public void givenAClient_whenEnteringAutomationPractice_thenPageTitleIsCorrect() throws Exception {
        // When
        driver.get("http://automationpractice.com/index.php");
        String title = driver.getTitle();

        // Then
        assertEquals("My Store", title);
    }
    
    @Test
    public void givenAClient_whenEnteringLoginCredentials_thenAccountPageIsDisplayed() throws Exception {
        // When
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("karenaliciahernandez@hotmail.com");
        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("nidGu2-mugtah-nofzen");
        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        submitButton.click();       
        String title = driver.getTitle();
        
        // Then
        assertEquals("My account - My Store", title);
    }
    
    @Test
    public void givenAClient_whenEnteringWrongLoginCredentials_thenAuthenticationPageIsDisplayed()
      throws Exception {
    	// When
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("karenaliciahernandez@hotmail.com");
        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("nidGu2-mugtah-nofzen");
        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        submitButton.click();       
        String title = driver.getTitle();
        
        // Then
        assertEquals("My account - My Store", title);
    	
    }
    
    @Test
    public void givenAClient_whenEnteringWrongLoginCredentials_thenErrorMessageIsDisplayed()
      throws Exception {
    	// When
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("karenaliciahernandez@hotmail.com");
        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("nidGu2-mugtah-nofzen-incorrect");
        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        submitButton.click();       
        String errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getText();
        
        // Then
        assertEquals("Authentication failed.", errorMessage);
    	
    }
    
    
    @Test
    public void givenAClient_whenSearchingNotExistingProduct_thenNoResultsDisplayed()
      throws Exception {
    	// When
        driver.get("http://automationpractice.com/index.php");
        WebElement searchField = driver.findElement(By.id("search_query_top"));
        searchField.sendKeys("boots");
        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-default button-search']"));
        submitButton.click();    
        String errorMessage = driver.findElement(By.xpath("//p[@class='alert alert-warning']")).getText();

        // Then
        assertEquals("No results were found for your search \"boots\"", errorMessage);
    	
    }
    
    
    @Test
    public void givenAClient_whenSearchingEmptyString_thenPleaseEnterDisplayed()
      throws Exception {
    	// When
        driver.get("http://automationpractice.com/index.php");
        WebElement searchField = driver.findElement(By.id("search_query_top"));
        searchField.sendKeys("");
        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-default button-search']"));
        submitButton.click();    
        String errorMessage = driver.findElement(By.xpath("//p[@class='alert alert-warning']")).getText();

        // Then
        assertEquals("Please enter a search keyword", errorMessage);
    	
    }
    
    @Test
    public void givenAClient_whenSigningOut_thenAuthenticationPageIsDisplayed()
      throws Exception {
    	// When
    	driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("karenaliciahernandez@hotmail.com");
        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("nidGu2-mugtah-nofzen");
        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        submitButton.click();  
        WebElement signOut = driver.findElement(By.xpath("//a[@class='logout']"));
        signOut.click(); 
        String title = driver.getTitle();
        
        // Then
        assertEquals("Login - My Store", title);
    	
    }
    
    /*
     * 2.	What is the advantage of Selenium vs HtmlUnit and viceversa?
		
		Selenium-WebDriver was developed to support dynamic web pages where elements of a page may change 
		without the page itself being reloaded. Selenium WebDriver’s goal is to supply a well-designed object-oriented 
		API that provides improved support for modern advanced web-app testing problems.
		
		Selenium-WebDriver makes direct calls to the browser using each browser’s native support for automation. 
		How the calls are made, and the features they support depend on the browser you are using. 
		
		
		HtmlUnit Driver is currently the fastest and most lightweight implementation of WebDriver. 
		HtmlUnit is a java based implementation of a WebBrowser without a GUI. 
		For any language binding (other than java) the Selenium Server is required to use this driver.
		Some pros of HtmlUnit Driver is that is it the fastest implementation of WebDriver, is a pure Java solution and so it 
		is platform independent and it supports JavaScript.
		A cons is that it emulates other browsers’ JavaScript behavior. If you test JavaScript using HtmlUnit the results may 
		differ significantly from browser to browser. 

		
		
		HtmlUnit is a java based implementation of a WebBrowser without a GUI and a way to simulate a browser for testing purposes, 
		and Selenium-WebDriver makes direct calls to the browser using each browser’s native support for automation. 
		
		HtmlUnit provides API without GUI possibility for automation whereas Selenium-WebDriver provides internal browsers' possibilities for automation.

     * 
     */
    


}


