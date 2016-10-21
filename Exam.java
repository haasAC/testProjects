import java.io.*;
import java.util.*;

/* Haseeb Chaudhry
*/

public class Exam{

    public static void main(String args[]){
        
        String s = "";
        populateFile(s);
        System.out.println(palidrome(s));
        
        
    }
    
    public static boolean palidrome(String s){
        
        if (s.length() == 0 || s.length() == 1){
            
        
            return true;
        }
        if(s.charAt(0) == s.charAt(s.length() -1)) {
                   }
        return palidrome(s.substring(s.length() - 1));
    }
    
    public static void populateFile(String fname){
        File f = new File("testwords.txt");
        
        try {
            Scanner input = new Scanner(f);
            while (input.hasNext()) {
                String s = input.next();
            }
            input.close();
        }
        catch (IOException e){
            System.out.println("File Not Reading");
        }
    }
    
}