/*
 * Lily Deller
 */
import java.util.Scanner;
public class SelectionSorter {

	public static final int DEF_SIZE = 10;
	public static void main(String[] args) {
		
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Enter "+DEF_SIZE+" numbers and I can sort them!");
			int[] a = new int[DEF_SIZE];
			for(int i = a.length-1;i>=0;i--);
			{
				a[i] = keyboard.nextInt();
			}
			System.out.println("Test");
	}

}
