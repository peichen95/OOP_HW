import java.util.*;

/*
 * print out formatted calendar based on the year and day of the first day of January
 * from January to December
 *
*/

public class Question2{

	//this function prints out formatted month canlendar
	//firstDayOfMonth is used to determine day of the first day of the month
	//and save the updated status of day of the first day of next month
	static void printMonth(int year, int month, int[] firstDayOfMonth){

		//totalDaysOfMonth is the counter for the number of days of that month
		//spaces tells how many spaces are printed before the first day of month is printed
		int totalDaysOfMonth, spaces;

		//determine total days of the month and prints out the head of calendar
		switch(month){
			case 1: totalDaysOfMonth = 31;
				System.out.println("    January " + year);
				break;
			case 2: totalDaysOfMonth = (year % 4 == 0 ? 29 : 28);
				System.out.println("    February " + year);
				break;
			case 3: totalDaysOfMonth = 31;
				System.out.println("     March " + year);
				break;
			case 4: totalDaysOfMonth = 30;
				System.out.println("     April " + year);
				break;
			case 5: totalDaysOfMonth = 31;
				System.out.println("      May " + year);
				break;
			case 6: totalDaysOfMonth = 30;
				System.out.println("      June " + year);
				break;
			case 7: totalDaysOfMonth = 31;
				System.out.println("      July " + year);
				break;
			case 8: totalDaysOfMonth = 31;
				System.out.println("     August " + year);
				break;
			case 9: totalDaysOfMonth = 30;
				System.out.println("   September " + year);
				break;
			case 10:totalDaysOfMonth = 31;
				System.out.println("    October " + year);
				break;
			case 11:totalDaysOfMonth = 30;
				System.out.println("    November " + year);
				break;
			default:totalDaysOfMonth = 31;
				System.out.println("    December " + year);
		}
		
		System.out.println("Su Mo Tu We Th Fr Sa");
		
		//prints spaces before the first day is printed
		spaces = firstDayOfMonth[0]*2+firstDayOfMonth[0];
		for(int i = 1; i <= spaces; i++){
			System.out.print(" ");
		}

		//prints formatted days of the month
		for(int i = 1; i <= totalDaysOfMonth; ++i){
			System.out.printf("%2d ", i);
			if(firstDayOfMonth[0] == 6){
				System.out.println();
				firstDayOfMonth[0] = 0;
				continue;
			}
			firstDayOfMonth[0]++;
		}
		System.out.println();
	}

	//ask user to input the year(int) and day of the first day of January(String)
	//and call printMonth() to print each month calendar
	public static void main(String[] args){

		int year;
		int[] firstDayOfMonth = {-1};  //when it's passed to printMonth(), changes to it would be kept
		String day;
		Scanner stdin = new Scanner(System.in);
		
		System.out.print("What is the year of Calendar?  ");
		year = stdin.nextInt();
		System.out.print("What day is the first day of January?  ");
		day = stdin.next().toLowerCase();

		//convert day of the first day from string to int so it can be used 
		//to calculate how many spaces are needed before actual numbers are printed
		if(day.equals("monday") || day.equals("mo")){
			firstDayOfMonth[0] = 1;
		}else if(day.equals("tuesday") || day.equals("tu")){
			firstDayOfMonth[0] = 2;
		}else if(day.equals("wendesday") || day.equals("we")){
			firstDayOfMonth[0] = 3;
		}else if(day.equals("thursday") || day.equals("th")){
			firstDayOfMonth[0] = 4;
		}else if(day.equals("friday") || day.equals("fr")){
			firstDayOfMonth[0] = 5;
		}else if(day.equals("saturday") || day.equals("sa")){
			firstDayOfMonth[0] = 6;
		}else if(day.equals("sunday") || day.equals("su")){
			firstDayOfMonth[0] = 0;
		}else{
			System.out.println("Invalid day of a week");
			System.exit(1);
		}

		for(int i = 1; i <= 12; ++i){
			printMonth(year, i, firstDayOfMonth);
		}
	}
}