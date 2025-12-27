package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;


public class enabled {
	
	@Test(enabled = true)
	public void hello() {
		Reporter.log("Hello students", true);
		
	}
	@Test(enabled = false)
	public void goodMorning() {
		Reporter.log("Goodmorning students", true);
	}
   @Test
	public void goodNight() {
		Reporter.log("Goodnight students", true);
		
	}
}
