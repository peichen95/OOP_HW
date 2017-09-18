class MyString{
	private char[] chars;

	//create a new array and use it to construct MyString
	public MyString(char[] chars){
		this.chars = new char[chars.length];
		for(int i = 0; i < chars.length; i++){
			this.chars[i] = chars[i];
		}
	}

	public char charAt(int index){
		return this.chars[index];
	}

	public int length(){
		return this.chars.length;
	}

	//create an array which contains substring from begin to end
	//use it to construct a MyString and return it
	public MyString substring(int begin, int end){
		MyString substr;
		char[] temp = new char[end-begin];
		for(int i = 0; i < end-begin; i++){
			temp[i] = this.chars[i+begin];
		}
		substr = new MyString(temp);
		return substr;
	}

	//create a MyString variable and copy whatever in this.chars to it
	//if any letter is uppercase, convert it to lower case
	public MyString toLowerCase(){
		MyString lowerCase;
		char[] temp = new char[this.length()];
		for(int i = 0; i < this.length(); i++){
			temp[i] = this.chars[i];
			if(temp[i] >= 65 && temp[i] <= 90){    //uppercase letters are from 65 to 90 in decimal
				temp[i] += 32;                 //lowercase letters are from 97 to 122 in decimal
			}
		}
		lowerCase = new MyString(temp);
		return lowerCase;
	}

	//similar to toLowerCase(), convert lowercase letters to uppercase
	public MyString toUpperCase(){
		MyString upperCase;
		char[] temp = new char[this.length()];
		for(int i = 0; i < this.length(); i++){
			temp[i] = this.chars[i];
			if(temp[i] >= 97 && temp[i] <= 122){
				temp[i] -= 32;
			}
		}
		upperCase = new MyString(temp);
		return upperCase;
	}

	//check the two MyString's lengths first\
	//then compare every single character to see it they are identical
	public boolean equals(MyString s){
		if(this.length() != s.length()){
			return false;
		}
		for(int i = 0; i < this.length(); i++){
			if(this.charAt(i) != s.charAt(i)){
				return false;
			}
		}
		return true;
	}

	//create a new MyString and return it
	public MyString getMyString(){
		MyString ms;
		char[] temp = new char[this.length()];
		for(int i = 0; i < this.length(); i++){
			temp[i] = this.chars[i];
		}
		ms = new MyString(temp);
		return ms;
	}

	public String toString(){
		String s = new String(this.chars);
		return s;
	}

	//convert int to MyString by isolating every digit and store them in a char array
	public static MyString valueOf(int i){
		int length = 0;   //it would be the length of the char array which would be used to construct MyString
		int number = i;   //the number would be changed every time divided by 10, so a new int is created to so that we don't lose the original one
		if(number <= 0){              //if the number is 0, the length would just be 1
			length = 1;           //if the number is negative, an extra space would be needed for the sign '-'
			number = -number;     //first make the number positive so it can be separated into single digits
		}

		//this while loop is used to determined how many digits the number have
		int j = number;
		while(j != 0){
			j /= 10;
			length++;
		}

		//use for loop to separate digits, and store them in the array
		char[] array = new char[length];
		for(int k = length-1; k >= 0; k--){       //%10 results in digits from 0-9, which are not 0-9 characters
			array[k] = (char)(number%10+48);  //the actual decimal that represent 0-9 characters are from 48 to 57
			number /= 10;          //divided by 10 so we can get to next digit
		}
		if(i < 0){
			array[0] = '-';   //set the first character of the array to '-' if the number is negative
		}
		MyString numberStr = new MyString(array);
		return numberStr;

	}

}

public class TestDriver{
	public static void main(String[] args){
		System.out.print("Constructing a new MyString: ");
		char[] array1 = {'A', 'b', 'c', 'd', 'e', 'f', 'G', 'H', 'I', 'j', '1', '2', '3'};
		MyString ms1 = new MyString(array1);
		System.out.println(ms1);
		
		for(int i = 0; i < 5; i++){
			System.out.printf("charAt[%d]: %c%n", i, ms1.charAt(i));
		}
		System.out.printf("length of MyString: %d%n", ms1.length());
		System.out.printf("substirng(2,8): %s%n", ms1.substring(2,8).toString());
		System.out.printf("lowercase: %s%n", ms1.toLowerCase().toString());
		System.out.printf("upperCase: %s%n%n", ms1.toUpperCase().toString());
		
		char[] array2 = {'A', 'b', 'c', 'd', 'e', 'f', 'G', 'H', 'I', 'j', '1', '2', '9'};
		MyString ms2 = new MyString(array2);
		System.out.printf("second MyStirng: %s%n", ms2.toString());
		System.out.printf("compare it with the first one using euqals(): %b%n%n", ms1.equals(ms2));

		char[] array3 = {'A', 'b', 'c', 'd', 'e', 'f', 'G', 'H', 'I', 'j', '1', '2', '3'};
		MyString ms3 = new MyString(array3);
		System.out.printf("third MyStirng: %s%n", ms3.toString());
		System.out.printf("compare it with the first one using euqals(): %b%n%n", ms1.equals(ms3));
	
		MyString ms4 = ms1.getMyString();
		System.out.printf("get MyString using getMyString(): %s%n%n", ms4.toString());

		int i = 414986;
		int j = -23412;
		int k = 0;
		System.out.printf("%d to MyString: %s%n%d to MyString: %s%n%d to MyString: %s%n",
				  i, MyString.valueOf(i).toString(), j, MyString.valueOf(j).toString(),
				  k, MyString.valueOf(k).toString());
	}
}