package com.FinalMock_ElementRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartPage {
	
	public FlipkartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//input[@title='Search for Products, Brands and More']")
	private WebElement SearchProduct;
	
	
	
	
	@FindBy(xpath = "//div[@class='tUxRFH']/descendant::div[@class='KzDlHZ']")
	private List<WebElement> product;




	public WebElement getSearchProduct() {
		return SearchProduct;
	}




	public List<WebElement> getProduct() {
		return product;
	}
	
	public void Busineeslibrary()
	{
		
	}
	
	//@FindBy(xpath = "")
	//private WebElement Productprice;
	
	
}
