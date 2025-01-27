//lily deller 
package binaryproject;
import java.util.Scanner;

public class binaryconverter {
	public static void main(String args[])
    {
		Scanner scanner = new Scanner(System.in);
			//defined how to get new scanner
        System.out.println("running program");
        System.out.println("please enter first nibble of binary (4 digits):");
        String firstBinary = scanner.nextLine();
        	//got first user input        
        System.out.println("please enter second nibble of binary (4 digits):");
        String secondBinary = scanner.nextLine();
        	//  second user input    
        int firstInt = 0;
        int secondInt = 0;
        
        for(int i=0;i<4;i++) {
        	if(firstBinary.charAt(i)== '1') {
        	firstInt+= Math.pow(2,3-i);
        	//converting first binary into an integer, looping through the string then adding 2^i
        	}
        }
        for(int i=0;i<4;i++) {
        	if(secondBinary.charAt(i)== '1') {
        	secondInt+= Math.pow(2,3-i);
        	}
        }
        int added = firstInt + secondInt;
        	//converting second binary into an integer, looping through the string then adding 2^i
        System.out.println("the total is "+ added);
        
    
    }
}
