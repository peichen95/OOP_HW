
/*
 * read three 2D point from standard input
 * calculate three lengths for each two popint
 * determinte whether these three lengths can form a triangel
 *
*/

import java.util.*;

public class Question5{
	//this method calculates the distance between two points
	static double distanceBetweenPoints(double x1, double y1, double x2, double y2){
		return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
	}
	
	//determine if the three sides can form a real triangle
	//if the sum of any two of them smaller than the third, return false
	// otherwise return true 
	static boolean isARealTriangle(double length1, double length2, double length3){
		if     (length1+length2 <= length3) return false;
		else if(length1+length3 <= length2) return false;
		else if(length2+length3 <= length1) return false;
		else return true;
	}

	public static void main(String[] args){

		double x1, y1, x2, y2, x3, y3;
		double length1, length2, length3;

		Scanner stdin = new Scanner(System.in);
		
		//ask user to input x-and-y-coordinates for three points		
		System.out.println("Enter three pointsto form a triangle: ");
		System.out.print("x-coordinate for pointa: ");
		x1 = stdin.nextDouble();
		System.out.print("y-coordinate for pointa: ");
		y1 = stdin.nextDouble();
		System.out.print("x-coordinate for pointb: ");
		x2 = stdin.nextDouble();
		System.out.print("y-coordinate for pointb: ");
		y2 = stdin.nextDouble();
		System.out.print("x-coordinate for pointc: ");
		x3 = stdin.nextDouble();
		System.out.print("y-coordinate for pointc: ");
		y3 = stdin.nextDouble();

		System.out.printf("a(%.2f, %.2f), b(%.2f, %.2f), c(%.2f, %.2f)\n",
				   x1, y1, x2, y2, x3, y3);
		
		//calcute length of each side(of a triangle) formed by three points
		length1 = distanceBetweenPoints(x1, y1, x2, y2);
		length2 = distanceBetweenPoints(x1, y1, x3, y3);
		length3 = distanceBetweenPoints(x2, y2, x3, y3);

		System.out.printf("The three lengths for the triangle are : %.2f %.2f %.2f\n",
				   length1, length2, length3);

		//determine if it's a real triangle
		if(isARealTriangle(length1, length2, length3)){
			System.out.println("This is a real triangle");
		}else{
			System.out.println("This is not a real triangle");
		}

		stdin.close();
	
	}
}
