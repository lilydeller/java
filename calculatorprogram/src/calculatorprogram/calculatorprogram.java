package calculatorprogram;
//lily deller
import java.util.Scanner;
//import java.math.*;

public class calculatorprogram
{
	private static final Scanner askScanner = new Scanner(System.in);
	public static double answer;
	public static double firstNumber;
	public static double secondNumber; //makes variables for the whole class

	public static void main(String[] args) {
	    calculator();
	}

    public static void calculator() {

	    System.out.println("hi lets do math!");
	    System.out.println("Pick one:");
	    System.out.println("1. Addition");
	    System.out.println("2. Subtraction");
	    System.out.println("3. Multiplication");
	    System.out.println("4. Division");
	    int pick = askScanner.nextInt();
	
	    if(pick == 1) {
	        addition();
	    }
	    else if(pick == 2) {
	        subtraction();
	    }
	    else if(pick == 3) {
	        multiplication();
	    }
	    else if(pick == 4) {
	        division();
	    }
	    else {
	        System.out.println("invalid input - please pick 1-4");
	        calculator();	       
	    }
	    goagain();
    }
    
    public static void goagain() {
    	System.out.println ("another question? \"Yes\" or \"No\"");
        try (Scanner YN = new Scanner(System.in)) {
    		String YN_String = YN.next();
    		if(YN_String.equals("Yes") || YN_String.equals("yes")) { 
    			calculator();
    		}
    		if(YN_String.equals("No") || YN_String.equals("no")) {
    		    System.out.println ("Ok! do math another time!");
    		    //System.exit();
    		}
        }
    	//calculator();
    }

    private static void getNumbers() {
        System.out.println("First number?");
        firstNumber = askScanner.nextDouble();
        System.out.println("Second Number?");
        secondNumber = askScanner.nextDouble();        
    }

    public static void subtraction() {
        System.out.println("Subtraction");
        getNumbers();
        answer = firstNumber - secondNumber;
        System.out.println("This is the difference of the two numbers:  " + answer);       
    }

    public static void addition() {
       System.out.println("Addition");
       getNumbers();
       answer = firstNumber + secondNumber;
       System.out.println("This is the sum of the two numbers:  " + answer);       
    }

    public static void multiplication() {
        System.out.println("Multiplication");
        getNumbers();
        answer = firstNumber * secondNumber;
        System.out.println("This is the product of the two numbers  " + answer); 
    }

    public static void division() {
        System.out.println("Division");
        getNumbers();
        answer = firstNumber / secondNumber;
        System.out.println("This is the quotient of the two numbers:    " + answer);
    }
}