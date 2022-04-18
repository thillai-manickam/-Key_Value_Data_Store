package fileCache;

import java.io.IOException;
import java.util.Scanner;

import org.json.JSONException;
import java.util.*;
public class StandAlone {
	
	//Input function is used to get input from the user 
	
     public static String input(){
    	 Scanner s=new Scanner(System.in);
    	 String n=s.next();
    	 return n;
     }
	public static void main(String[] args) throws IOException, JSONException {
		while(true){
			
			System.out.println("Enter operation 1.Add  2.Read  3.Delete ");
			int n=Integer.parseInt(input());
			FileCache cache=new FileCache();
			switch(n){
			case 1:
				System.out.println("Enter the data to be created");
				String name = input();
				cache.add(name);
			    break;
			case 2:
				System.out.println("Enter Key to read the data");
				String key=input();
				cache.read(key);
				break;
			case 3:
				System.out.println("Enter Key to delete the data");
				String del=input();
				cache.delete(del);
				break;
			
		}
		
		}
		
}
}
