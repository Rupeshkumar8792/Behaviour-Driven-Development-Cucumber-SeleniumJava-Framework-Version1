package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;

public class Screenshot extends BaseClass
{
	//takeScreenshot code
		public static byte[] takeScreenShot()
		{
			return ((TakesScreenshot) webDriver.get()).getScreenshotAs(OutputType.BYTES);
		}
}
