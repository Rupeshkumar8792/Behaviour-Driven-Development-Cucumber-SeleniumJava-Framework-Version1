package base;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class BaseClass 
{
	/*
	 * thread-local variable named webDriver, which will hold instances of
	 * WebDriver. Each thread accessing this variable will have its own independent
	 * instance of WebDriver, which is useful for scenarios like parallel testing
	 * where you need separate browser instances for each thread.
	 */
	public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	public static WebDriver driver = null;

	public final static int TIMEOUT = 4;

	public static Logger log = Logger.getLogger(BaseClass.class);

	public static String browserName = ConfigReader.intializeProperties().getProperty("browser");

	public static void launchBrowser() {
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		log.info("maximizing browser");
		driver.manage().window().maximize();

		log.info("::::Maximizing Window::::");
		driver.manage().window().maximize();

		// page is fully loaded then wait for before throwing the exception wait until
		// time

		log.info(":::::Applying Waits::::");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TIMEOUT));

		webDriver.set(driver);

	}

	public static void launchApplication(String url) 
	{
		webDriver.get().get(url);
	}

	public static void teardown() 
	{
		log.info("::::Active Browser is close::::");

		webDriver.get().close();

		log.info("::::All Browser is quit::::");

		webDriver.get().quit();
	}
}
