import java.util.*;

/*
 * check if a string a palindrome
 * (whether the string a the same forward and backward)
 *
*/

public class Question3{
	//isPalindrome() returns true if a string is a palindrom
	//returs false otherwise
	static boolean isPalindrome(String s){
		int start = 0;
		int end = s.length()-1;
		
		//check every character until start and end pass the midpoint
		while(end - start > 0){
			if(s.charAt(start) != s.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args){
		String str;
		Scanner stdin = new Scanner(System.in);
		System.out.print("Enter a string a check if it's a palindrome:   ");

		//read input from stdin until no more character is read
		//check each string to see if it's palindrome by calling isPalindrome()
		while(stdin.hasNext()){
			str = stdin.next();
			if(isPalindrome(str)){
				System.out.printf("\"%s\" is a palindrome.\n", str);
			}else{
				System.out.printf("\"%s\" is not a palindrome.\n", str);
			}
			System.out.print("Enter a string a check if it's a palindrome   ");
		}
	}
}