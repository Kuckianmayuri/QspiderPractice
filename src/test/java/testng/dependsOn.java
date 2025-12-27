package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class dependsOn {
     
	@Test
	public void createAccount() {
		Reporter.log("Account in insta is created", true);
	}
	@Test(dependsOnMethods = "createAccount")
	public void updateAccount() {
		Reporter.log("Account in insta is updated", true);
	}
	@Test(dependsOnMethods = {"createAccount", "updateAccount"})
	public void deleteAccount() {
		Reporter.log("Account in insta is deleted", true);
	}
}
