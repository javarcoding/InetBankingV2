package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;
	public ReadConfig()
	{
		File src=new File(System.getProperty("user.dir")+"./Configuration//config.properties");
		
		try 
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) 
		{
			System.out.println("Exception is :"+ e.getMessage());
		}
		
	}
	
	public String getApplicationURL()
	{
		String baseurl=pro.getProperty("baseURL");
		return baseurl;
	}
	
	public String getUserName()
	{
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getEdgePath()
	{
		String edgepath=pro.getProperty("edgepath");
		return edgepath;
	}
	
}
