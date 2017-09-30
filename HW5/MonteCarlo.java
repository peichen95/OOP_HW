/*
 * Area of quandrant of circle: a1 = pi/4 * r^2
 * Area of square: a2 = r^2
 * a1 : a2 = pi/4
 * number of dot inside circle = n1
 * number of dot inside square = n2
 * pi/4 = n1/n2
 * pi = 4n1/n2
*/

/* 
 * to determine if a dot is inside of circle
 * we have to know if the distance from the dot to origin is smaller than the radius(1 in this case)
 * to calculate that, we have to know x-value and y-value of dot(x, y)
 * distance = sqrt(x*x+y*y)
*/

import java.util.*;

public class MonteCarlo{
	
	static boolean isInsideCircle(double x, double y){
		return (x*x + y*y) <= 1;
	}
	
	//asume that the radius of circle is 1
	public static void main(String[] args){
		final long BILLION = 1000000000L;
		long dotsInsideCircle = 0L;
		Random random = new Random();
		
		for(long i = 1L; i <= (4*BILLION); i++){
			double x = random.nextDouble();   //x-value of dot
			double y = random.nextDouble();   //y-value of do
			
			if(i % 100000000L == 0){
				System.out.printf("%.1f billion dots generated, and %d dots are inside circle%n", 
				                  (double)i/(double)BILLION, dotsInsideCircle);
			}
			
			if(isInsideCircle(x, y)){
				dotsInsideCircle++;
			}
		}
		
		double pi = 4.0 * (double)dotsInsideCircle / (4.0*BILLION);
		System.out.printf("pi using Monte Carlo Method is: %f", pi);
	}
}