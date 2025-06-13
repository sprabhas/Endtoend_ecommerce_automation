package NaveenAutomationLabs.NaveenAutomationSite;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogue {
	
	WebDriver driver; 
	
	public ProductCatalogue(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement backpack;
	
	@FindBy(className = "shopping_cart_badge")
	WebElement shopping_cart_badge;
	
	@FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)")
	WebElement redTshirt;
	
	@FindBy(id="remove-sauce-labs-backpack")
	WebElement removeItem;
	
	@FindBy(css="a[id='item_3_title_link']>div")
	WebElement itemName;
	
	@FindBy(xpath ="//select[@class='product_sort_container']//option[@value='lohi']")
	WebElement loHiFilter;
	
	@FindBy(className="inventory_item_price")
	List<WebElement> inventory_item_price;
	 
	
	public void addProductToCart(WebElement product) {
		
		product.click();
	
	}
	
	public int get_inventory_item_price_size() {
		
		return inventory_item_price.size();
	}
	
   public String getCartItemCount() {
	
		String cart = shopping_cart_badge.getText();
		//System.out.println(cart);
		return cart;
	}
   
   public void clickCart(WebElement cart) {
		
		cart.click();
	}
   
   public void selectloHiFilter(WebElement loHiFilter) {
	   
	   loHiFilter.click();
	   
   }
   
   public String getItemName() {
		
		String item = itemName.getText();
		//System.out.println(cart);
		return item;
	}

}
