package RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		SimpleDateFormat formatter = new SimpleDateFormat("HH.mm.ss aa");
		String curTime = formatter.format(new Date());
		Driver sendRequest = new Driver();
		
		/*  
		This was to test the sliding window ->
		Made sure that bursts of requests would come near the boundary
		Something like this ->  |R......RRR|.RRRR.......|
		*/
		sendRequest.checkRequestAllowed("user1",curTime);
		Thread.sleep(995);
		System.out.println("Sleep");
		
		for(int i=0;i<9;i++) {
			curTime = formatter.format(new Date());			
			sendRequest.checkRequestAllowed("user1",curTime);
		}
		
		
			
		Thread.sleep(700);
		System.out.println("Sleep");
		
		for(int i=0;i<15;i++) {
			curTime = formatter.format(new Date());			
			sendRequest.checkRequestAllowed("user1",curTime);
		}
	}
}