package NaveenAutomationLabs.NaveenAutomationSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;	
	public LandingPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	//PageFactory
	@FindBy(id="user-name")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement passWord;
	
	@FindBy(id="login-button")
	WebElement loginBtn;
	
	public void loginApplication(String user_name,String passwordEle) {
		
		userName.sendKeys(user_name);
		passWord.sendKeys(passwordEle);
		loginBtn.click();		
	}
	
	public void goTo() {
		
		driver.get("https://www.saucedemo.com/");
	}
	
}
