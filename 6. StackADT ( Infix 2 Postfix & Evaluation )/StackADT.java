
public abstract class StackADT {
	
	//precondition: stack must not be full
	//postcondition: object must be added on top of existing objects
	public abstract boolean push(Object E);
	
	//precondition: stack must not be empty
	//postcondition: most recently added element will be removed and returned
	public abstract Object pop();
	
	//precondition: stack must not be empty
	//postcondition: return most recently added element, without removing it
	public abstract Object top();
	
	//---------Some helper methods
	public abstract boolean isEmpty();	
	public abstract int size();



}
