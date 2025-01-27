//Lily Deller
package temperateaverage;
import java.util.Scanner;
public class tempproject {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //array stuff
        final int TotalTemps = 10;
        double[] numbers = new double[TotalTemps];
        double sum = 0;
        double average = 0;
        double max = 0;
        int day = 1;
        //ask for user input of temp for 10 days 
        for (int n = 0; n < numbers.length; n++) {
            System.out.print("Enter a temperature for day " + day + ":");
            numbers[n] = input.nextDouble();
            day++;

        }
        
        //calculating to find average over the 10 days 
            sum = numbers[0]+ numbers[1]+ numbers[2] + numbers [3] + numbers [4] + numbers [5] + numbers [6] + numbers [7] + numbers [8] + numbers [9];
           
        average = sum / 10;    
        
        System.out.println("Average temp = " + average);

        
        
      //below average
        
      System.out.println("The days that were below average were:");
      day = 1;  
      for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < average) {
              
               System.out.println("day " + day + " with " +numbers[i]);
               day++;
      //output for what days were below average and with what temp         
            }
        }
        
        
        
    }
}
