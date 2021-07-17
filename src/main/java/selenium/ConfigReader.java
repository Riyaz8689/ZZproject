package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	
	public static String url;
	
	public static String browser;
	
	public static String username;
	
	public static String password;
	
	public static String firstname;
	
	public static String lastname;
	
	public static String employeeid;
	
	public static String Username;
	
	public static String Newpassword;
	
	public static long elementwait;
	
	public static long pageloadwait;
	
	public static String accountname;
	
	
	
	
	public static void readConfigurations() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub

		File path = new File(System.getProperty("user.dir") + "//testConfigurations.properties");
		
		Properties configProperties = new Properties();
		configProperties.load(new FileInputStream(path));
		
		url = configProperties.getProperty("App.Url");
		browser= configProperties.getProperty("App.Browser");
		username = configProperties.getProperty("App.Username");
		password = configProperties.getProperty("App.Password");
		elementwait = Long.parseLong(configProperties.getProperty("App.ImplicitWait"));
		pageloadwait = Long.parseLong(configProperties.getProperty("App.PageLoadWait"));
		accountname = configProperties.getProperty("App.Accountname");
		firstname = configProperties.getProperty("App.FirstName");
		lastname = configProperties.getProperty("App.LastName");
		employeeid = configProperties.getProperty("App.EmployeeId");
		Username = configProperties.getProperty("App.UserName");
		Newpassword = configProperties.getProperty("App.UserPassword");
				
		
		
	}
	
	public static String GetLocator(String name) throws Exception{
		
		try {
		File path = new File(System.getProperty("user.dir") +"//Objectrepository.properties");
		Properties ap = new Properties();
		
		ap.load(new FileInputStream(path));
		
		String prop = ap.getProperty(name);
		System.out.println(prop);
		return prop;
		
	}catch (Exception e) {
		System.out.println("Not Found");
			throw e;
	}
	}
	
	public static void main(String[] args) throws Exception {
		
		//GetLocator("LoginPage.lnl_SignIn");
		readConfigurations();
		
	}
}
