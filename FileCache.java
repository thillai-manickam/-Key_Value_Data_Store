package fileCache;
import java.io.*;
import java.util.*;
import org.json.*;

public class FileCache{

         //This is add function used for adding keys and values to the files 
	
		 static void add(String key) throws IOException, JSONException {
				FileReader reader=new FileReader("database.properties");  
				
			  //Property file is used to save data in the form of Key and Value  
				
			    Properties p=new Properties();  
				p.load(reader); 
				
				StandAlone stand=new StandAlone();
				
				//if condition is used to check whether key is already present inside the property file
				//if present data will not be added inside the property file
			    if(!p.containsKey(key)){
			    	System.out.println("enter");
			    
			    	//String is converted into Json object 
			    
			    	JSONObject jsonObject = new JSONObject(stand.input());
			    	
		      
			    	//condition for checking whether key is string or not 
			    	//condition  to check if key is capped at 32chars and value is capped at 16kb 
				
			    	if(Character.isLetter(key.charAt(0))){
			    		if(key.length()<(32) && jsonObject.toString().length()<=(16*1024*1024)){
			    			try{
			    				Properties Propertyone = new Properties();
		    		   
			    				//data is pushed into the property file
		    		   
			    				Propertyone.setProperty(key.toString(), jsonObject.toString());
			    				File file = new File("database.properties");
			    				FileOutputStream fileOut = new FileOutputStream(file,true);
			    				Propertyone.store(fileOut, "Database");
			    				fileOut.close();
			    				}catch(Exception e){
			    					e.printStackTrace();
			    					}
			    		}
			    	}
		       
			    	//Here time is given to make the data expire 
		       
			    	System.out.println("type yes for giving time");
			    	String n=stand.input();
			    	if(n.equals("yes")){
			    	System.out.println("Enter time in seconds to kill the data in file");
			    	int time=Integer.parseInt(stand.input());
			    	Time_To_Live t=new Time_To_Live(key,time);}
		   
			    	}else{
			    		System.out.println("Data already exist");}
		 			}
	 
		//Read function is used to read data from the property file
		 
		static void read(String key) throws IOException{
		
			
			    try{
			    	FileReader reader=new FileReader("database.properties");  
			    	Properties p=new Properties();  
			    	p.load(reader);  
			    	String name=p.getProperty(key);
			    	System.out.println(name);
			    	}catch(Exception e){
			    		e.printStackTrace();
			    	}
			
			  
		}
		
		//Delete function is used to delete key from the table 
		
		static void delete(String key) throws IOException{
				try{
					FileReader reader=new FileReader("database.properties");  
					Properties p=new Properties();  
					p.load(reader); 
					FileOutputStream fout = new FileOutputStream("database.properties");
					p.remove(key);
					p.store(fout, "key and value are removed");
				}catch(Exception e){
		    	  e.printStackTrace();
					}
			
		}
		
			
		
}
