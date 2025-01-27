//lily FEBRUARY 27TH LECTURE NOTES
public class ArrayStack <T> implements StackI<T>{
	private T[] stack;
	private int headIndex; //first null element of the stack. top of the stack is -1
	public static final int DEF_SIZE = 100;
	public ArrayStack()
	{
		init(DEF_SIZE);
	}
	public ArrayStack(int size)
	{
		init(size);
	}
	private void init(int size)
	{
		this.headIndex = 0;
		if(size >= 1)
			stack = (T[])(new Object[size]);
		else
			stack = (T[])(new Object[DEF_SIZE]);
	}
	public void push (T aData)
	{
		if(headIndex >= stack.length)
			return; 
		stack[headIndex] = aData;
		headIndex++;
	}
	public T pop()
	{
		if(headIndex == 0)
			return null;
		T ret = stack[headIndex-1];
		headIndex--;
		return ret;
	}
	public T peek()
	{
		if(headIndex ==0)
			return null;
		return stack[headIndex];
	}
	public void print()
	{
		for(int i=headIndex-1;i>=0;i--)
		{
			System.out.println(stack[i]);
		}
	}
}




