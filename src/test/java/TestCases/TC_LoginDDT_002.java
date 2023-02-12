package TestCases;

import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import Utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider = "loginData")
	public void loginDDT(String uname, String pwd)
	{
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(uname);
		lp.setPassword(pwd);
		
		lp.clickLogin();
		
		if (isAlertPresent()==true) 
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			
		}
		else 
		{
			Assert.assertTrue(true);
			lp.clickLogOut();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent()
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) 
		{
			return false;
		}
		
	}
	
	
	@DataProvider(name="loginData")
	String[][] logindata() throws IOException
	{
		String path=System.getProperty("user.dir")+"./src/test/java/Utilities/XLUtils.java";
		
		int rowcount=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rowcount][colcount];
		
		for (int i=1;i<=rowcount; i++) 
		{
			for (int j=0;j<colcount; j++) 
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				
			}
			
		}
		return logindata;
		
		
		
	}
	
}
