package declaration;
import java.util.Scanner;
public class triangleproject {
//lily deller	
    public static void main(String args[])
    {
    	Scanner input = new Scanner(System.in);
       //user input
        System.out.println("hi please enter what size you want your triangle!");

        int how_many = input.nextInt();
        // need number of rows and how many per row
        for(int i = 1; i <= how_many; i++){
            for(int j = 1; j <= i; j++){
               System.out.print("*");
            }
            System.out.println();
        }
        // minus one so that it doesn't mirror
        // "--" instead of "++" so that it goes down not up 
        for(int i = how_many - 1; i>= 0; i--) {
    	   for(int j = 1; j<= i; j++) {
        //same for statement bc its the name number per row 
    		   System.out.print("*");
    	   }
    	   System.out.println();
       }
    }
}