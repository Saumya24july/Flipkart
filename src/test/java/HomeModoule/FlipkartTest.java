package HomeModoule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.FinalMock_ElementRepo.FlipkartPage;

import GenericUtility.BaseclassForFlipkart;


@Listeners(GenericUtility.ListenerImplementationclass.class)

public class FlipkartTest extends BaseclassForFlipkart{

	 @Test(retryAnalyzer = GenericUtility.RetryAnalyser.class)

	 //hello world
	 
	 public void Test1() throws EncryptedDocumentException, IOException
		{
			List<String> list = new ArrayList<String>();
		 FlipkartPage flip=new FlipkartPage(driver);
		 
		String productTosearch = excel.fetchTheData("Sheet1", 0, 0);
		
		flip.getSearchProduct().sendKeys(productTosearch+Keys.ENTER);
		
		
		List<WebElement> P_name = flip.getProduct();
	
		
		for(WebElement A:P_name) {
			list.add(A.getText());
		}
		
		Collections.sort(list,Collections.reverseOrder());
		
		for(String prodct:list) {
			WebElement ele = driver.findElement(By.xpath("//div[.='"+prodct+"']/ancestor::div[@class='tUxRFH']/descendant::div[@class='Nx9bqj _4b5DiR']"));
			
			Reporter.log(prodct+"===>"+ele.getText(),true);
		}

}
}