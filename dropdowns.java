package NaveenAutomationLabs.NaveenAutomationSite;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdowns {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://letcode.in/dropdowns");
		
		
		Select fruits = new Select(driver.findElement(By.id("fruits")));
		
		List<WebElement> individualFruits = fruits.getOptions();
		
		
		for(WebElement fruitOptions : individualFruits) {
			System.out.println(fruitOptions.getText());
			
		}
		

	}

}
