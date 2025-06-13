package NaveenAutomationLabs.NaveenAutomationSite;
import java.time.Duration;
import java.util.ArrayList;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class Sausedemo_practice {

	public static void main(String[] args) throws InterruptedException {		
		
		
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		 
		 		 
		 
		 LandingPage LandingPage = new LandingPage(driver);
		 LandingPage.goTo();
		 LandingPage.loginApplication("standard_user", "secret_sauce");
		 
		 String pageTitle = driver.getTitle();
		 
		 Assert.assertEquals(pageTitle, "Swag Labs" , "Page title is incorrect");
						
		/* String btnText = driver.findElement(By.id("login-button")).getDomAttribute("value");
		 
		 //if((btnText.substring(0,1).toUpperCase()+btnText.substring(1)).equals(btnText)) {
		 		 
		 if(btnText.equals(btnText.toUpperCase())) {
			 System.out.println("Button is capitalized!");
		 } else {		 
			 System.out.println("Button is not capitalized!");
		 }*/
				  
		// driver.findElement(By.id("user-name")).sendKeys("standard_user");
		// driver.findElement(By.id("password")).sendKeys("secret_sauce");
		 //driver.findElement(By.id("login-button")).click();
		
		 WebElement selFil = driver.findElement(By.className("product_sort_container"));
		 
		 Select selFilter = new Select(selFil);
		  
		 WebElement firstOption = selFilter.getFirstSelectedOption();	 
		 Assert.assertEquals(firstOption.getText(), "Name (A to Z)" , "The option A to Z is not selected");
		 		
		 ProductCatalogue ProductCatalogue = new ProductCatalogue(driver);
		 ProductCatalogue.addProductToCart(ProductCatalogue.backpack);	 
		 //System.out.println(ProductCatalogue.backpack);
	     String cartCount1 = ProductCatalogue.getCartItemCount();
	     Assert.assertEquals(cartCount1, "1" , "items in cart doesn't equals 1");
		 
		 
		 ProductCatalogue.addProductToCart(ProductCatalogue.redTshirt);
		 String cartCount2 = ProductCatalogue.getCartItemCount();
		 Assert.assertEquals(cartCount2, "2" , "items in cart is not increased");
		 
		 ProductCatalogue.addProductToCart(ProductCatalogue.removeItem);
		 String updCart = ProductCatalogue.getCartItemCount();		
	     //System.out.println(updCart);
		 Assert.assertEquals(updCart, "1" , "items in cart is not updated");
		 		
		 String selecteditemName = ProductCatalogue.getItemName();
		 
		 ProductCatalogue.clickCart(ProductCatalogue.shopping_cart_badge); 
		 String cartitemName = ProductCatalogue.getItemName();
	     Assert.assertEquals(selecteditemName, cartitemName , "items are in not in cart");
	       
	     driver.findElement(By.id("continue-shopping")).click();
	     	     
	     //driver.findElement(By.xpath("//select[@class='product_sort_container']//option[@value='lohi']"));
		 
	     ProductCatalogue.selectloHiFilter(ProductCatalogue.loHiFilter);
	     ArrayList<Double> priceList = new ArrayList();
	     
	     
	     List<WebElement> itemsPrice = driver.findElements(By.className("inventory_item_price"));
	     	    
	     for (int i = 0 ; i < ProductCatalogue.get_inventory_item_price_size() ; i ++ ) {
	    	 
	    	 double individualPrice = Double.parseDouble( ProductCatalogue.inventory_item_price.get(i).getText().substring(1));	    			
	    	 priceList.add(individualPrice);
	    	     	
	     }  
	     	     		 	    		 
	     boolean isSorted = true;
	     for(int j = 0 ; j < priceList.size()-1 ; j ++) {
	    	 if(priceList.get(j) > priceList.get(j + 1)) {
	    		 isSorted = false;
	    		 break;	 
	    	 }
	    	 
	     }
	      
	     if(isSorted) {
	    	 System.out.println("items are sorted");
	     }else {
	    	 System.out.println("items are not sorted");
	     }
	     driver.close();
	}

	
}
