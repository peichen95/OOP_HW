import java.util.*;

/*
 * read two points from standard input and use them as the center of two circles
 * read two radius form standard input as well
 * calculate the distance of two centers
 * use that to determine whether the circles are:
 * - separated from each other
 * - toucing each other
 * - overlapping each other
 * - or completely whithin each other
 *
*/

public class Question6{

	//it returns the distance between two points
	//use it to calculate the distance between two centers of circles
	 static double distanceBetweenCircles(double x1, double y1, double x2, double y2){
		return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
	}

	//it returns a string that indicates the situation of two circles
	//if the distance is greater than the sum of two circles, they are separated from each other
	//if the distance equals the sum, they are toucing each other
	//if the distance is less than the sum, there would be two case of it:
	// - if the distance is greater than the difference of the radiuses, they are overlapping each other
	// - otherwise they are completely whithin one another
	static String typeOfTwoCircle(double radius1, double radius2, double distance){
		if(distance > (radius1+radius2)) return "separated from eache other";
		else if(distance == (radius1+radius2)) return "touching each other";
		else{
			if(distance > Math.abs(radius1-radius2))
				return "overlapping each other";
			else
				return "completely whithin one another";
		}
		
	}

	public static void main(String[] args){
		double x1, y1, x2, y2;
		double radius1, radius2, distance;
		String type;

		Scanner stdin = new Scanner(System.in);
		System.out.println("Enter two points as the centers of two circles.");

		System.out.print("x-and-y-coordinate for circle1: ");
		x1 = stdin.nextDouble();   y1 = stdin.nextDouble();
		System.out.print("the radius of circle1 is: ");
		radius1 = stdin.nextDouble();
		System.out.printf("circle1 centered at (%.2f, %.2f), radius: %.2f\n", x1, y1, radius1);
		
		System.out.print("x-and-y-coordinate for circle2: ");
		x2 = stdin.nextDouble();   y2 = stdin.nextDouble();
		System.out.print("the radius of corcle1 is: ");
		radius2 = stdin.nextDouble();
		System.out.printf("circle2 centered at (%.2f, %.2f), radius: %.2f\n", x2, y2, radius2);
		
		distance = distanceBetweenCircles(x1, y1, x2, y2);
		System.out.printf("the distance between two circles is: %.2f\n", distance);
		
		type = typeOfTwoCircle(radius1, radius2, distance);
		System.out.printf("The two circles are %s\n", type);
	}
}