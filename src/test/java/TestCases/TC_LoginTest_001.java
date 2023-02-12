package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();
		
		System.out.println("Title of the page::"+ driver.getTitle());
		
		if (driver.getTitle().equals(" Guru99 Bank Manager HomePage ")) 
		{
			Assert.assertTrue(true);
		}
		else 
		{
			captureScreenshot(driver, "loginTest");
			Assert.assertTrue(false);
		}
	}
}
