package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseclassForFlipkart {

	public WebDriver driver;
	public ExelfileUtilityForFlipkart excel = new ExelfileUtilityForFlipkart();
	public WebDriverUtility genfile = new WebDriverUtility();
	public JavaUtility java = new JavaUtility();
	public static WebDriver sdriver;
	public FetchTheDataFrom_PropertiesFile pro = new FetchTheDataFrom_PropertiesFile();

	@BeforeSuite(alwaysRun = true)
	public void DBconnect() throws Throwable {

		Reporter.log("---Connected To DataBase--", true);
	}

	//@Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	public void openBrowser(/*String browser */) throws Throwable {
//if(browser.equalsIgnoreCase("chrome"))
//{

	driver = new ChromeDriver();
//}
/*else if(browser.equalsIgnoreCase("edge"))
{
	driver=new EdgeDriver();
}*/
		genfile.Window_Maximum(driver);
		genfile.Impliwait(driver, 25);
		String Flipkart_Url = pro.fetchData("url");
		//String Flipkart_Url = System.getProperty("Flipkart_Url");
		genfile.lunchTheApplicattion(driver, Flipkart_Url);
		
		
		sdriver=driver;

	}

	@AfterClass(alwaysRun = true)
	public void CloseBrowser() throws Throwable {

		driver.quit();

	}

	@AfterSuite(alwaysRun = true)
	public void DBconnectionCl() throws Throwable {

		Reporter.log("---Close The DataBase Connection---", true);
	}

}
