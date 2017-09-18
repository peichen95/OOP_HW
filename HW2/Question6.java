import java.util.*;

/*
 * change delimiter of Scanner to "" to tokenize every individual characters
 *
*/

public class Question6{
	public static void main(String[] args){
		String character;
		Scanner in = new Scanner(System.in);
		in.useDelimiter("");

		while(in.hasNext()){
			//character = in.next();
			System.out.printf("%s ", in.next());
		}
	}
}
