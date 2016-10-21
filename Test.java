import java.io.*;
import java.util.*;

public class Test{
    
    public static void main(String args[]){
        
        String s = "";
        System.out.println(palidrome("Hello"));
        
        
    }
   
    
    
    public static boolean palidrome(String s){
        
        if (s.length() == 0 || s.length() == 1)
            return true;
        if(s.charAt(0) == s.charAt(s.length() -1))
             return palidrome(s.substring(s.length() - 1));
       }
     
}
