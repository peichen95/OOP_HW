import java.util.*;

/*
 * change Scanner's delimiter to ","
 * ask user to input strings and print them out
 *
*/

public class Question5{
	public static void main(String[] args){
		String str = "";
		Scanner stdin = new Scanner(System.in);
		stdin.useDelimiter(",");
		System.out.println("Enter some strings separated by ','");

		while(stdin.hasNext()){
			str = stdin.next();
			System.out.printf("%s ", str);
		}
	}
}