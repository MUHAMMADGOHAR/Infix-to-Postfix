/* array implementation of Stack
	 * 
	 */
public class ArrayStack extends StackADT {
	int maxSize;    	//default Capacity
	int top;
	Object[] Stack;	// array to hold stack elements
	
	//add default and parameterized constructor for size
	public ArrayStack(){
		this(10);
	}
	public ArrayStack(int size)	{
		maxSize = size;
		Stack = new Object[maxSize];
		top = -1;
	}
	
	// implement all methods from StackADT
	@Override
	public boolean push(Object E) {
		if(maxSize != size()) {	
			top = top + 1;
			Stack[top] = E;
			return true;
		}
		else
			return false;	
	}
	
	@Override
	public Object pop() {
		if(maxSize != size()){
			Object data = Stack[top];
			Stack[top] = 0;
			top = top-1;
			return data;
		}
		else
			return null;
	}
	
	@Override
	public Object top() {
		if(top!= -1)
			return Stack[top];
		else
			return false;
	}
	
	@Override
	public boolean isEmpty() {
		if(top == -1)
			return true;
		else
			return false;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return top+1;
	}
	
	// This is for array based stack
	public boolean isFull() {
		if(top == size()-1)
			return true;
		else
			return false;
	}
	

}
