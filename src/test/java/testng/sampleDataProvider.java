package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class sampleDataProvider {
	@DataProvider
	public Object[][] loginDetails(){
		Object[][] objarr = new Object[3][2];
		
		objarr[0][0] = "Mayuri";
		objarr[0][1] = "m@123";
		objarr[1][0] = "Soumya";
		objarr[1][1] = "s@123";
		objarr[2][0] = "Amruta";
		objarr[2][1] = "a@123";
		return objarr;
	}
	@Test(dataProvider = "loginDetails")
	public void loginProgram(String username, String password)
	{
		System.out.println(username + "=="+password);
	}

}
