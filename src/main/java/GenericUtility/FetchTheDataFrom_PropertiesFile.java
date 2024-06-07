package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FetchTheDataFrom_PropertiesFile {
	
	
	public String fetchData(String url) throws IOException
	{
		FileInputStream fis = new FileInputStream(Ipathconstant.propertypath);
		Properties pro = new Properties();
		pro.load(fis);
		String urlFlipkart = pro.getProperty(url);
		return urlFlipkart;
	}

}
