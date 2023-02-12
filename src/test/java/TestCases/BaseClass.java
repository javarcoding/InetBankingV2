package TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.utils.FileUtil;
import com.beust.jcommander.Parameter;

import Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	ReadConfig readConfig=new ReadConfig();
	public String baseURL=readConfig.getApplicationURL();
	public String username=readConfig.getUserName();
	public String password=readConfig.getPassword();
	
	public static WebDriver driver;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		if (br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if (br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+"./png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot is taken");
	}
	

	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(8);
	
		return(generatedString);
	}
	
	public String randomeNum()
	{
		String generatedString1=RandomStringUtils.randomNumeric(4);
		return(generatedString1);
		
	}
	
	
}
