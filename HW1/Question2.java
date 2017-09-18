
/*
 * read radius from standard input and calculate area of circle
 * when EOF is read,terminate the program
 *
*/

import java.util.*;

public class Question2{
	public static void main(String[] args){

		double radius, area;
		Scanner stdin =  new Scanner(System.in);
		System.out.print("Enter a number:");
		
		//keep reading inputs from user until there's no more
		//radius should not be a negative number, check for each case
		//if radius is non-negative number, calculate the area of circle
		while(stdin.hasNext()){
			radius = stdin.nextDouble();
			if(radius < 0){
				System.out.println("Invalid radius");
				System.out.print("Enter a number:");
				continue;
			}
			area = Math.PI*Math.pow(radius, 2.0);
			System.out.println("The area of " + radius + " is " + area);
			System.out.print("Enter a number:");
		}

		stdin.close();

	}
}