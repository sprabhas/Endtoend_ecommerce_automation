package NaveenAutomationLabs.NaveenAutomationSite;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class React_shopping {

	public static void main(String[] args) throws InterruptedException {
		
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		 // WebDriverWait expWait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 	 
		 driver.get("https://react-shopping-cart-67954.firebaseapp.com/");		    
		 //driver.findElement(By.className("github-button")).click();	
		 // expWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='js-confirm-csrf-token']/following-sibling::button")));
		
		 //driver.findElement(By.xpath("//input[@class='js-confirm-csrf-token']/following-sibling::button")).click();
	 
		 /* driver.findElement(By.id("repo-stars-counter-star")).click();
		 driver.findElement(By.id("login_field")).sendKeys("sprabhashankar2429@gmail.com");
		 driver.findElement(By.id("password")).sendKeys("Muthuprabha@29");
		 
		 driver.findElement(By.cssSelector("input[value='Sign in']")).click();*/	 
		 List<WebElement> itemsList = driver.findElements(By.className("eeXMBo"));
		 //System.out.println(itemsList);
		 int itemsCount = 0;
		 for (WebElement indItems  : itemsList) {
			 itemsCount += 1;
			
		 }
		   int text = Integer.parseInt(driver.findElement(By.xpath("//main[@class='sc-ebmerl-4 iliWeY']//p")).getText().split(" ")[0]);
				  	   
		   Assert.assertEquals(itemsCount, text , "items count does not match");
		   
		   driver.findElement(By.xpath(" //span[text()='S']")).click();
		   
		     int UptitemsCount = 0;
			 for (WebElement indItems  : itemsList) {
				 UptitemsCount += 1;
				
			 }
				 
			 // System.out.println("e  "+itemsCount);
		  	 
			   int updtext = Integer.parseInt(driver.findElement(By.xpath("//main[@class='sc-ebmerl-4 iliWeY']//p")).getText().split(" ")[0]);
					  	   
			   Assert.assertEquals(UptitemsCount, updtext , "items count does not match");
			   
			   Actions ac = new Actions(driver);

			   WebElement btn= driver.findElement(By.xpath("(//button[@class='sc-124al1g-0 jCsgpZ'])[1]")); 
			   String beforeHover = btn.getCssValue("background-color");
			   btn.getCssValue("background-color");
			   System.out.println("before hover  " + beforeHover );
			   ac.moveToElement(btn).perform();
			  
			   String afterHover = btn.getCssValue("background-color");
			   System.out.println("before hover  " +afterHover);
			   
			   driver.findElement(By.xpath("(//button[@class='sc-124al1g-0 jCsgpZ'])[1]")).click();
			   driver.findElement(By.cssSelector(".sc-1h98xa9-11.gnXVNU")).click();
			   driver.switchTo().alert().accept();
			   driver.close();
		
		
	}

}
