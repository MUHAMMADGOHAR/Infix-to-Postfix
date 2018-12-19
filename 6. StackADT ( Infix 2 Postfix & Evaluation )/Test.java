import java.util.Scanner;
public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\t ||============ Infix To Postfix-Converstion & Postfix-Evaluation ============|| "); 
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println(" Enter a valid expression or 0 to exit: ");
			System.out.print(" Infix :");
			String input=sc.nextLine();
			if(input.equals("0"))
				break;
			else
			{
				String postfix =infixToPostfix(input);
				System.out.println(" Postfix : "+postfix);
				int ans=postfixEvaluation(postfix);
				System.out.print(" Evaluation : ");
				System.out.println( input+" = "+ ans);
			}
		}
		sc.close();

	}
	//you first have to complete ArrayStack class in order to complete following methods
	//Pre: a valid mathematical expression in infix notation
	//post: postfix expression of input
	public static String infixToPostfix(String expression)
	{
		String infix = expression;
		String postfix = "";
		ArrayStack stack = new ArrayStack();
		stack.push('$');
		
		for(int i = 0; i < infix.length(); i++){
			char ch = infix.charAt(i);
			if(isOperator(ch)){
				while(checkPrecedence( ch , (char)stack.top()) )
					postfix = postfix + stack.pop();
					stack.push(ch);
				}
			else if(ch == '(')
				stack.push(ch);	
			else if(ch == ')'){
				while((char)stack.top() != '(') 
					postfix = postfix + stack.pop();
					stack.pop();
			}
			else
				postfix = postfix +  ch;
			}
		while((char)stack.top() != '$'){
			postfix = postfix + stack.pop();
		}
	return postfix;
	}
	//pre: a valid postfix expression
	//post:answer to expression
	public static int postfixEvaluation(String exp)
	{
		//evaluate expression and return answer
		ArrayStack stack = new ArrayStack();
		for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);
            if(Character.isDigit(c))
                stack.push(c);
            else{
                int R = Integer.parseInt(""+stack.pop());
                int L = Integer.parseInt(""+stack.pop());
                switch(c)
                {
                    case '+':
                    stack.push(L+R);
                    break;
                     
                    case '-':
                    stack.push(L-R);
                    break;
                     
                    case '/':
                    stack.push(L/R);
                    break;
                     
                    case '*':
                    stack.push(L*R);
                    break;
              }
            }
        }
	
		int result = Integer.parseInt("" + stack.pop());
        return result; 
	}
	
	//Important note
	/*carefully read ArrayStack and StackADT, data type is Object (super class of all java classes)
	Advantages: you can use one class to create stack for any data type like int, String, char, float etc
	Disadvantage. you can't compare an Object to int, char, float using == bc they are not reference data type.
	Solution. use equals() method or typecast, see the example
	Let say stack name is S and it is holding characters if you want to check if top element is equal to something
	Typecast==> (char)S.Top()=='+'		OR S.Top().equals('+')
	Preferably you should use equals()
	You can simply pass int and char to methods of AStack, no specific treatment is required.
	*/
	static boolean isOperator(char c){
		if(c == '+' || c == '-' || c == '*' || c =='/' || c == '^')
			return true;
		return false;
 }
	static boolean checkPrecedence(char c1, char c2){
		if((c2 == '+' || c2 == '-') && (c1 == '+' || c1 == '-'))
			return true;
		else if((c2 == '*' || c2 == '/') && (c1 == '+' || c1 == '-' || c1 == '*' || c1 == '/'))
			return true;
		else if((c2 == '^') && (c1 == '+' || c1 == '-' || c1 == '*' || c1 == '/'))
			return true;
		else
			return false;
 }
	
}