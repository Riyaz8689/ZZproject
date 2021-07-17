package selenium;

import org.testng.annotations.Test;

public class Assignment7 extends BaseTestUtilities {
	
	@Test
	
	public static  void EmployeeRegistration() throws Exception{
		
		LoginPage loginpage = new LoginPage();
		Dashboard dashboard = new Dashboard();
		AddEmployee addemployee = new AddEmployee();
		ViewPersonalDetails personaldetailspage = new ViewPersonalDetails();
		
		loginpage.EnterUserName();
		loginpage.EnterPassword();
		loginpage.ClickLogin();
		
		dashboard.ClickOnNavigationTabPIM();
		dashboard.ClickOnAddEmployee();
		
		addemployee.EnterFirstName();
		addemployee.EnterLastName();
		addemployee.EnterEmployeeId();
		addemployee.ClickOnLoginDetailsCheckBox();
		addemployee.EnterToCreateUserName();
		addemployee.EnterPassword();
		addemployee.ReTypePassword();
		addemployee.ClickToSave();
		Thread.sleep(2000);
		personaldetailspage.ClickOnWelcomeMenu();
		personaldetailspage.ClickOnLogOut();
		loginpage.EnterWithCreatedUserName();
		loginpage.EnterWithPassword();
		loginpage.ClickLogin();
		
		String AccountName = dashboard.GetAccountName();
		ShouldBeEqual(ConfigReader.accountname, AccountName);
		dashboard.ClickOnWelcomeMenu();
		dashboard.ClickOnLogOut();
	
		
		
	}

}
