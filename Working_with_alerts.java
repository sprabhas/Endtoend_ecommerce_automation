package NaveenAutomationLabs.NaveenAutomationSite;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Working_with_alerts {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,100)");
		
		driver.get("https://letcode.in/test");
		driver.findElement(By.linkText("Dialog")).click();
		driver.findElement(By.id("accept")).click();
		
		//accepting an alert
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("confirm")).click();
		// ok and cancel button in alert
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.id("prompt")).click();
		Alert promtAlert = driver.switchTo().alert();
		
		System.out.println(promtAlert.getText());
		promtAlert.sendKeys("hii");
		driver.switchTo().alert().accept();
		
		
	

	}

}
