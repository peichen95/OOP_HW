
/*
 * generate a random number between one and twelve
 * print out the name of month accordinly
 *
*/

import java.util.Random;

public class Question3{
	public static void main(String[] args){

		int month;
		Random rand = new Random();
		month = rand.nextInt(12)+1;

		switch(month){
			case 1:
				System.out.println(month+": January");
				break;
			case 2:
				System.out.println(month+": February");
				break;
			case 3:
				System.out.println(month+": March");
				break;
			case 4:
				System.out.println(month+": April");
				break;
			case 5:
				System.out.println(month+": May");
				break;
			case 6:
				System.out.println(month+": June");
				break;
			case 7:
				System.out.println(month+": July");
				break;
			case 8:
				System.out.println(month+": August");
				break;
			case 9:
				System.out.println(month+": September");
				break;
			case 10:
				System.out.println(month+": Octocber");
				break;
			case 11:
				System.out.println(month+": November");
				break;
			default:
				System.out.println(month+": December");
		}


	}

}