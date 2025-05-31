package NaveenAutomationLabs.NaveenAutomationSite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Forgot_password_flow {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		driver.get("https://dev303280.service-now.com/");
		
		String loginpageTitle = driver.getTitle();	
		String expTitle = "Log in | ServiceNow";	
		
		//verifying if title is matched with the expected title
		Assert.assertEquals(loginpageTitle, expTitle, "Title is mismatched");
		
		//verifying if forgot password is visible
		WebElement forgotPwd = driver.findElement(By.className("btn-link"));
		Assert.assertTrue(forgotPwd.isDisplayed(), "forgot password is not displayed");
		
		driver.findElement(By.className("btn-link")).click();
		
		String pwdResetpageTitle = driver.getTitle();
		Assert.assertEquals(pwdResetpageTitle, "Password Reset - Identify" ,"Title is mismatched");
		
		//System.out.println(pwdResetpageTitle);
		
		WebElement identifyElement = driver.findElement(By.xpath("//ol[@class='login-forgot-password-steps']//li[text()='Identify']"));
		WebElement verifyElement = driver.findElement(By.xpath("//ol[@class='login-forgot-password-steps']//li[text()='Verify']"));
		WebElement resetElement = driver.findElement(By.xpath("//ol[@class='login-forgot-password-steps']//li[text()='Reset']"));
		
		Assert.assertTrue(identifyElement.isDisplayed() && verifyElement.isDisplayed() && resetElement.isDisplayed() , "elements are not displayed");
		
		
		WebElement usernameElement = driver.findElement(By.cssSelector("div[id='user_id_form_group_0']>label[for='sysparm_user_id_0']"));
		WebElement textFieldElement = driver.findElement(By.id("sysparm_user_id_0"));
		WebElement nextBtnField = driver.findElement(By.id("sysverb_pwd_reset"));
		
		Assert.assertTrue(usernameElement.isDisplayed() && textFieldElement.isDisplayed() && nextBtnField.isDisplayed() , "elements are not displayed");
		
		
		driver.findElement(By.id("sysparm_user_id_0")).sendKeys("admin");
		
		//capcha
		driver.findElement(By.id("sysverb_pwd_reset")).click();

		
	}

}
