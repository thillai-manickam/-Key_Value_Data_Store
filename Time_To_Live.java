package fileCache;
import java.io.IOException;
import java.util.*;
public class Time_To_Live {
	  Timer timer;
	  String key;
	  
	  //time scheduling is done with key and time 
	  
	    public Time_To_Live(String key,int seconds) {
	    	this.key=key;
	        timer = new Timer();
	        timer.schedule(new RemindTask(), seconds*1000);
		}
	    
        //After the time ends the key will be passed to the delete function
	    
	    class RemindTask extends TimerTask {
	        public void run() {
	           
	            FileCache d=new FileCache();
	            try {
					d.delete(key);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
	            timer.cancel(); 
	        }
	    }
}
