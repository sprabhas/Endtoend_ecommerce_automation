package NaveenAutomationLabs.NaveenAutomationSite;
import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Servicenow_login_positive {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		//WebDriverWait expWait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		driver.get("https://dev303280.service-now.com/");
		
		String loginpageTitle = driver.getTitle();	
		String expTitle = "Log in | ServiceNow";	
		
		System.out.println(loginpageTitle);
		//verifying if title is matched with the expected title
		Assert.assertEquals(loginpageTitle, expTitle, "Title is mismatched");
				
		//verifying if in the webpage if username and password field is displayed		
		WebElement usernameField = driver.findElement(By.cssSelector("label[for='user_name']"));
		WebElement pwdField = driver.findElement(By.cssSelector("label[for='user_password']"));
		
		Assert.assertTrue(usernameField.isDisplayed() , "The text field do not have User name");
		Assert.assertTrue(pwdField.isDisplayed() , "The text field do not have password");	
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("i/=Vk4hUhYI6");
				
		//verifying if in the webpage forgot password field is displayed
		WebElement forgotPwd = driver.findElement(By.cssSelector(".btn.btn-link"));
		Assert.assertTrue(forgotPwd.isDisplayed() , "forgot passowrd field is not displayed");
		
		//verifying if in the webpage login button is displayed
		WebElement loginBtn =  driver.findElement(By.id("sysverb_login"));
		Assert.assertTrue(loginBtn.isDisplayed() , "login button is not displayed");
		
		driver.findElement(By.id("sysverb_login")).click();
		
		//expWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("brandLogoLabel")));
		
		String homepageTitle = driver.getTitle();
		System.out.println(homepageTitle);
		//.assertEquals(homepageTitle, null)
		
       		
	}

}
