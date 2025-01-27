//lily
public class Tester {
	
	public static void main(String[]args) {
		//TODO AUTO GENERATED METHOD STUB
		StackI<String> strStack = new LLStack<String>();
		
		for(int i=0;i<5;i++)
			strStack.push("String" +i);
		System.out.println(strStack.peek()+"\n");
		strStack.print();
		System.out.println();
		for(int i=0;i<5;i++)
			System.out.println(strStack.pop());
		System.out.println("\n"+strStack.peek());
	}

}
