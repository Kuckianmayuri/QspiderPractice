package hardcoding;

import java.util.Random;

public class getRandomNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Random rm = new Random();
        int ranNum = rm.nextInt(1000);
        System.out.println(ranNum);
	}

}
