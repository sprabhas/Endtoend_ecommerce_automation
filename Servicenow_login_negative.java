package NaveenAutomationLabs.NaveenAutomationSite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Servicenow_login_negative {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		driver.get("https://dev303280.service-now.com/");
		
		String loginpageTitle = driver.getTitle();	
		String expTitle = "Log in | ServiceNow";	
		
		System.out.println(loginpageTitle);
		
		//verifying if title is matched with the expected title
		Assert.assertEquals(loginpageTitle, expTitle, "Title is mismatched");
		
		driver.findElement(By.id("sysverb_login")).click();
		
		WebElement errorText = driver.findElement(By.className("outputmsg_text"));
		Assert.assertTrue(errorText.isDisplayed(), "Error message is not displayed");
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("sysverb_login")).click();
		
		String pwderrorText = driver.findElement(By.cssSelector("span[class='dp-invalid-login-msg']")).getText();
		Assert.assertTrue(pwderrorText.contains("User name or password invalid") , "does not contain the error message");
	
	}

}
