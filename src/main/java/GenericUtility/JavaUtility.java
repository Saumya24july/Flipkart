package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility {
	
	
	public String systemdate()
	{
		Date d=new Date();
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
	String dateGenerator = format.format(d);
	return dateGenerator;
	}

}
