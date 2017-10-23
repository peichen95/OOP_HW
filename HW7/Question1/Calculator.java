import java.util.*;

public class Calculator{
	
	public static boolean isNumeric(String str){
		try{
			double d = Double.parseDouble(str);
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}
	
	
	
	public static String[] infixToPostfix(String[] infixstr)
	              throws UserIsADumbassException, LookAtMrAlgebraOverHereException, IllegalOperationException
	{
		int j = 0;
		String[] temp = new String[infixstr.length];
		Stack<String> opstack = new Stack<String>();
		String ops = "+-#/()%!";
	
		for(int i = 0; i < infixstr.length; i++)
		{
			int pos = ops.indexOf(infixstr[i]);
			if(pos == -1){
				if(!isNumeric(infixstr[i])){
					throw (new LookAtMrAlgebraOverHereException(infixstr[i] + ": not a number"));
				}
				temp[j++] = infixstr[i];
			}else if(pos < 6){
				while(!opstack.empty() && ops.indexOf(opstack.peek())/2 >= pos/2){
					if(opstack.peek().equals("(")){
						break;
					}
					
					if(opstack.peek().equals(")")){
						opstack.pop();
						while(!opstack.peek().equals("(")){
							temp[j++] = opstack.peek();
							opstack.pop();
						}
						opstack.pop();
						continue;
					}
				
					temp[j++] = opstack.peek();
					opstack.pop();
				
				}
				opstack.push(infixstr[i]);
			}else{
				throw (new IllegalOperationException(infixstr[i] + ": operation unsupported"));
			}
			
		}	
		
		while(!opstack.empty()){
			if(opstack.peek().equals(")") || opstack.peek().equals("(")){
				opstack.pop();
				continue;
			}
			temp[j++] = opstack.peek();
			opstack.pop();
		}
		
		boolean hasANumber = false;
		String[] postfixstr = new String[j];
		for(int i = 0; i < j; i++){
			if(isNumeric(temp[i])){
				hasANumber = true;
			}
			postfixstr[i] = temp[i];
		}
		if(!hasANumber){
			throw (new UserIsADumbassException("enter some numbers to be operated you dumbass"));
		}
		
		return postfixstr;
	}
	
	
	
	public static void main(String[] args){
		try{
			String[] postfix = infixToPostfix(args);
		
			Stack<String> stack = new Stack<String>();
			String ops = "+-#/";
			double total;
		
			for(int i = 0; i < postfix.length; i++){
				stack.push(postfix[i]);
					
				if(ops.indexOf(stack.peek()) >= 0){
					String op = stack.peek();
					stack.pop();
					double right = Double.parseDouble(stack.peek());
					stack.pop();
					double left = Double.parseDouble(stack.peek());
					stack.pop();
				
					switch(op){
						case "+":
							total = left+right;
							break;
						case "-":
							total = left-right;
							break;
						case "#":
							total = left*right;
							break;
						default:
							if(right - 0.0 < 0.000000000000000001){
								throw (new ArithmeticException("divided by zero"));
							}
							total = left/right;
					}
			
					stack.push(String.valueOf(total));
				}
			}	
		
			System.out.println(stack.peek());
		}catch(LookAtMrAlgebraOverHereException e){
			e.printStackTrace();
		}catch(IllegalOperationException e){
			e.printStackTrace();
		}catch(UserIsADumbassException e){
			e.printStackTrace();
		}catch(ArithmeticException e){
			e.printStackTrace();
		}
	}
}



class LookAtMrAlgebraOverHereException extends IllegalArgumentException{
	public LookAtMrAlgebraOverHereException(String message){
		super(message);
	}
}

class IllegalOperationException extends IllegalArgumentException{
	public IllegalOperationException(String message){
		super(message);
	}
}

class UserIsADumbassException extends IllegalArgumentException{
	public UserIsADumbassException(String message){
		super(message);
	}
}