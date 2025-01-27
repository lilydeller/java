import java.util.Scanner;
public class Helper {



	    public static void forLoop (int s) {
	        int[] arr = new int[s];
	        Scanner sc = new Scanner(System.in);
	        for (int i = 0; i < s; i++) {
	            System.out.print("Enter a number: ");
	            arr[i] = sc.nextInt();
	        }
	        int sum = 0;
	        for (int i : arr) {
	            sum += i;
	        }
	        System.out.println("Sum of values in the array: " + sum);
	    }

	    public static void whileLoop() {
	        Scanner sc = new Scanner(System.in);
	        int num = 4;
	        int sum = 0;
	        while (num != 0) {
	            System.out.print("Enter a number (type 0 to stop): ");
	            num = sc.nextInt();
	            sum += num;
	        }
	        System.out.println("Sum of values typed in: " + sum);
	    }

	    public static void ifStatements(int x, int y){
	        if (x > y) {
	            System.out.println("X is greater than Y");
	        } else if (x == y) {
	            System.out.println("X is equal to Y");
	        } else {
	            System.out.println("X is less than Y");
	        }
	        }
	    

	    public static void main(String[] args) {
	        forLoop(5);
	        whileLoop();
	        ifStatements(10, 5);
	    }
	}

