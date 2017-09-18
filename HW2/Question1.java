import java.util.*;

/*
 * print out a "pyramid" consisting of numbers
 * ask user to input the level of the pyramid
 * numbers go from ascending order then descends
 *
*/

public class Question1{
	public static void main(String[] args){
		int levels;
		Scanner stdin = new Scanner(System.in);
		
		System.out.print("How many levels do you want the pyramid to be?  ");
		levels = stdin.nextInt();

		for(int i = levels; i >= 1; --i){
			//spaces that are before the first number(1) to centralize the line of numbers
			int spaces = i*2-1;

			for(int j = 0; j < spaces; ++j){
				System.out.print(" ");
			}
			
			//prints out numbers in ascending order from 1 to the largest one based on level
			for(int k = 1; k <= levels-i+1; ++k){
				System.out.print(k+" ");
			}

			//prints out numbers in descending order from the largest to 1
			for(int l = levels-i; l >= 1; --l){
				System.out.print(l+" ");
			}

			System.out.print("\n");
		}
	}
}