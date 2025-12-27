package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class priorityProgram {
 
	@Test(priority = 0)
    public void createcampaign() {
    	Reporter.log("Create campaign", true);
    }
	@Test(priority = 1)
    public void updatecampaign() {
    	Reporter.log("Update campaign", true);
    }
	@Test(priority = 2)
    public void deletecampaign() {
    	Reporter.log("Delete campaign", true);
    }
}
