package CalculatorTester;
//lily deller
import java.util.Scanner;

public class CalculatorTester{

	private static final Scanner askScanner = new Scanner(System.in);
	public static double answer;
	public static double firstNumber;
	public static double secondNumber; //makes variables for the whole class

	public static void main(String[] args) {
	    calculator();
	    //Calling calculator in main thread but not calling 'go again' 
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
	        //if user enters a number greater than 4 , the program doesn't know what to do because we only have four operations - export error to user
	        calculator();	
	        //repeating calculator after error so that user has opportunity to try again
	    }
	    goagain();
	    //calling go again in calculator method so it continues looping more than once if user says 'yes'
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
    	//creating a go again statement if the user would like to do another question they would say yes and we would go back to calculator, if they don't want to then program will end!	    
    		}
        }
    }

    private static void getNumbers() {
        System.out.println("First number?");
        firstNumber = askScanner.nextDouble();
        System.out.println("Second Number?");
        secondNumber = askScanner.nextDouble();        
    }
    //we take two numbers from user = double 
    public static void subtraction() {
        System.out.println("Subtraction");
        getNumbers();
        answer = firstNumber - secondNumber;
        System.out.println("This is the difference of the two numbers:  " + answer);       
    }
    //subtraction
    public static void addition() {
       System.out.println("Addition");
       getNumbers();
       answer = firstNumber + secondNumber;
       System.out.println("This is the sum of the two numbers:  " + answer);       
    }
    //addition
    public static void multiplication() {
        System.out.println("Multiplication");
        getNumbers();
        answer = firstNumber * secondNumber;
        System.out.println("This is the product of the two numbers  " + answer); 
    }
    //multiplication
    public static void division() {
        System.out.println("Division");
        getNumbers();
        answer = firstNumber / secondNumber;
        System.out.println("This is the quotient of the two numbers:    " + answer);
    }
}