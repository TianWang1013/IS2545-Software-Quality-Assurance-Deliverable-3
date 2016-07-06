package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebTesting {

	static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for herokuapp for each test
	@Before
	public void setUp() throws Exception {
		driver.get("http://lit-bayou-7912.herokuapp.com/");
	}
	
	// ------------------------------------------------------------------------------------------------------
	// 1.As a user 
	//   I want to click the button
	//   So that I can go to the certain page
	// ------------------------------------------------------------------------------------------------------
	
	// Given that I’m on the main page
	// When I click on the “Tokenize” button
	// Then I should be redirected to the “Tokenize Operation” page
	@Test
	public void testButtonTokenize() {
        try {
        	WebElement submitButtonToken = driver.findElement(By.cssSelector("[value='Tokenize']"));
    		submitButtonToken.click();
    		WebElement newPageH = driver.findElement(By.cssSelector("h1"));
    		assertEquals(newPageH.getText(), "Hood Popped - Tokenize Operation");
        } catch (NoSuchElementException newPage) {
        	fail();
        }	
	}
	
	// Given that I’m on the main page
	// When I click on the “Parse” button
	// Then I should be redirected to “Parse Operation” page
	@Test
	public void testButtonParse() {
        try {
    		WebElement submitButtonParse = driver.findElement(By.cssSelector("[value='Parse']"));
    		submitButtonParse.click();
    		WebElement newPageH = driver.findElement(By.cssSelector("h1"));
    		assertEquals(newPageH.getText(), "Hood Popped - Parse Operation");
        } catch (NoSuchElementException newPage) {
        	fail();
        }	
	}
	
	// Given that I’m on the main page
	// When I click on the “Compile” button
	// Then I should be redirected to “Parse Operation” page
	@Test
	public void testButtonCompile() {
        try {
    		WebElement submitButtonCompile = driver.findElement(By.cssSelector("[value='Compile']"));
    		submitButtonCompile.click();
    		WebElement newPageH = driver.findElement(By.cssSelector("h1"));
    		assertEquals(newPageH.getText(), "Hood Popped - Compile Operation");
        } catch (NoSuchElementException newPage) {
        	fail();
        }
	}
	
	
	// ------------------------------------------------------------------------------------------------------
	// 2.As a user 
	//	 I want to type codes in the textbox
	//	 So that I can compile the program
	// ------------------------------------------------------------------------------------------------------
	
	// Given a string of codes
	// When I try to type with this credential and click on “Tokenize” button
	// Then I should see the “Tokenize Operation” kind string in “Tokenize Operation” page
	@Test
	public void testTextboxTokenize() {
        try {
        	WebElement textboxCodeT = driver.findElement(By.id("code_code"));
        	textboxCodeT.sendKeys("Noogie Cat");
    		WebElement submitButtonToken = driver.findElement(By.cssSelector("[value='Tokenize']"));
    		submitButtonToken.click();
    		WebElement newPageCode = driver.findElement(By.cssSelector("code"));
    		String newPageCodeTest = newPageCode.getText();
    		assertTrue(newPageCodeTest.contains("[1, 0]"));
        } catch (NoSuchElementException newPage) {
        	fail();
        }	
	}
	
	// Given a string of codes
	// When I try to type with this credential and click on “Parse” button
	// Then I should see at least one line of “Parse Operation” kind string in “Parse Operation” page
	@Test
	public void testTextboxParse() {
        try {
        	WebElement textboxCodeP = driver.findElement(By.id("code_code"));
        	textboxCodeP.sendKeys("Noogie Cat");
    		WebElement submitButtonParse = driver.findElement(By.cssSelector("[value='Parse']"));
    		submitButtonParse.click();
    		WebElement newPageCode = driver.findElement(By.cssSelector("code"));
    		String newPageCodeTest = newPageCode.getText();
    		assertTrue(newPageCodeTest.contains("[1, 0]"));
        } catch (NoSuchElementException newPage) {
        	fail();
        }	
	}
	
	//Given a string of codes
	//When I try to type with this credential and click on “Parse” button
	//Then I should see at least one line of “Compile Operation” kind string in “Compile Operation” page
	@Test
	public void testTextboxCompile() {
        try {
        	WebElement textboxCodeC = driver.findElement(By.id("code_code"));
        	textboxCodeC.sendKeys("Noogie Cat");
    		WebElement submitButtonCompile = driver.findElement(By.cssSelector("[value='Compile']"));
    		submitButtonCompile.click();
    		WebElement newPageCode = driver.findElement(By.cssSelector("code"));
    		String newPageCodeTest = newPageCode.getText();
    		assertTrue(newPageCodeTest.contains("trace"));
        } catch (NoSuchElementException newPage) {
        	fail();
        }	
	}
	
	// ------------------------------------------------------------------------------------------------------
	// 3.As a user
	// I want to run the operation
	// So that I can check the compilation process
	// ------------------------------------------------------------------------------------------------------
	
	// Given a letter in the first line of the textbox
	// When I try to type with this credential and click on “Tokenize” button
	// Then I should see ‘:on_ident’
	@Test
	public void testRunTokenize() {
        try {
        	WebElement textboxCodeC = driver.findElement(By.id("code_code"));
        	textboxCodeC.sendKeys("a");
    		WebElement submitButtonCompile = driver.findElement(By.cssSelector("[value='Tokenize']"));
    		submitButtonCompile.click();
    		WebElement newPageCode = driver.findElement(By.cssSelector("code"));
    		String newPageCodeTest = newPageCode.getText();
    		assertTrue(newPageCodeTest.contains(":on_ident"));
        } catch (NoSuchElementException newPage) {
        	fail();
        }	
	}
	
	// Given an operator in the first line of the textbox
	// When I try to type with this credential and click on “Parse” button
	// Then I should see a warning about something went wrong.
	@Test
	public void testRunParse() {
        try {
        	WebElement textboxCodeC = driver.findElement(By.id("code_code"));
        	textboxCodeC.sendKeys("+");
    		WebElement submitButtonCompile = driver.findElement(By.cssSelector("[value='Parse']"));
    		submitButtonCompile.click();
    		WebElement newPageCode = driver.findElement(By.cssSelector("h1"));
    		String newPageCodeTest = newPageCode.getText();
    		assertTrue(newPageCodeTest.contains("We're sorry, but something went wrong."));
        } catch (NoSuchElementException newPage) {
        	fail();
        }	
	}
	
	// Given an arithmetic fault access without space
	// When I try to type with this credential and click on “Compile” button
	//Then I should see the put object and certain operator
	@Test
	public void testRunCompile() {
        try {
        	WebElement textboxCodeC = driver.findElement(By.id("code_code"));
        	textboxCodeC.sendKeys("4-3");
    		WebElement submitButtonCompile = driver.findElement(By.cssSelector("[value='Compile']"));
    		submitButtonCompile.click();
    		WebElement newPageCode = driver.findElement(By.cssSelector("code"));
    		String newPageCodeTest = newPageCode.getText();
    		assertTrue(newPageCodeTest.contains("putobject 4"));
    		assertTrue(newPageCodeTest.contains("putobject 3"));
    		assertTrue(newPageCodeTest.contains("opt_minus"));
        } catch (NoSuchElementException newPage) {
        	fail();
        }			
		}
	}
