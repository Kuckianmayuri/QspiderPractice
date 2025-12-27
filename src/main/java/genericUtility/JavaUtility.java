package genericUtility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
     public String getTodaysDate() {
    	 Date d = new Date();
    	 SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
    	 String date = sim.format(d);
    	 return date;
     }
	
     public String getExpectedDate(int expDate) {
    	 // Get today
    	    Calendar cal = Calendar.getInstance();
    	    
    	    // Add the required number of days
    	    cal.add(Calendar.DAY_OF_MONTH, expDate);
    	    
    	    // Format the new date
    	    SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
    	    String date = sim.format(cal.getTime());
    	    
    	    return date;
     }
     
     public int getRandomNumber() {
    	 Random rm = new Random();
    	 int ranNum = rm.nextInt(1000);
    	 //System.out.println(ranNum);
    	 return ranNum;
     }
}
