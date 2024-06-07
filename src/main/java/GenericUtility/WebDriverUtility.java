package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class WebDriverUtility {
	
	
	public void lunchTheApplicattion(WebDriver driver,String Website)
	{
		driver.get(Website);
	}
	
	public void Impliwait(WebDriver driver,int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	public void Window_Maximum(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	
	public static String getScreenshot(WebDriver driver,String Screenshotname) throws IOException
	{
		JavaUtility jutil=new JavaUtility();
		TakesScreenshot ts=(TakesScreenshot)driver;
		String path="./SCREENSHOT"+Screenshotname+jutil.systemdate()+".png";
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
	
		FileHandler.copy(src, dest);
	return	dest.getAbsolutePath();
	}

}
