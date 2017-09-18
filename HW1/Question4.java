import java.util.*;
import java.io.*;

/*
 * read from a file specified in command line
 * print it to standard input
 *
*/

public class Question4{
	public static void main(String[] args){
		
		//check if there are too many or too less commands
		if(args.length != 1){
			System.out.println("Usage: java PrintFile FileName");
			return;
		}

		//try to redirect standard input to the file and print it
		//if the file doesn't exist, terminate the program
		try{
			Scanner stdin = new Scanner(new File(args[0]));

			while(stdin.hasNext()){
				String str = stdin.nextLine();
				System.out.println(str);
			}
	
			stdin.close();
		}catch(FileNotFoundException ex){
			System.out.printf("%s: fail to find the file", args[0]);
		}
	}
}